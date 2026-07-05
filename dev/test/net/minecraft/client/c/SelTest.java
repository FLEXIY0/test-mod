package net.minecraft.client.c;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import sun.misc.Unsafe;

/**
 * Headless tests for the Obsidian Book text selection + clipboard state machine
 * (GuiScreenObsidianBook.moveCaret/deleteSelection/selectedText/hasSel) and for
 * BookLayout's selection-highlight rendering. The GUI object is allocated
 * WITHOUT its constructor (Unsafe) so we avoid EntityPlayer/ItemStack/OpenGL.
 */
public class SelTest {
    static int pass = 0, fail = 0;

    static void ok(boolean c, String msg) {
        if (c) { pass++; } else { fail++; System.out.println("FAIL: " + msg); }
    }

    // reflection helpers on the GUI instance
    static Field fContent, fCursor, fAnchor;
    static Method mMove, mDel, mSelText, mHasSel, mSelMin, mSelMax;

    static void setState(Object g, String content, int cursor, int anchor) throws Exception {
        fContent.set(g, content);
        fCursor.setInt(g, cursor);
        fAnchor.setInt(g, anchor);
    }
    static String content(Object g) throws Exception { return (String) fContent.get(g); }
    static int cursor(Object g) throws Exception { return fCursor.getInt(g); }
    static int anchor(Object g) throws Exception { return fAnchor.getInt(g); }

    public static void main(String[] args) throws Exception {
        Unsafe unsafe;
        Field uf = Unsafe.class.getDeclaredField("theUnsafe");
        uf.setAccessible(true);
        unsafe = (Unsafe) uf.get(null);

        Class<?> k = GuiScreenObsidianBook.class;
        Object g = unsafe.allocateInstance(k);

        fContent = k.getDeclaredField("content"); fContent.setAccessible(true);
        fCursor = k.getDeclaredField("cursorPos"); fCursor.setAccessible(true);
        fAnchor = k.getDeclaredField("selAnchor"); fAnchor.setAccessible(true);
        mMove = k.getDeclaredMethod("moveCaret", int.class, boolean.class); mMove.setAccessible(true);
        mDel = k.getDeclaredMethod("deleteSelection"); mDel.setAccessible(true);
        mSelText = k.getDeclaredMethod("selectedText"); mSelText.setAccessible(true);
        mHasSel = k.getDeclaredMethod("hasSel"); mHasSel.setAccessible(true);
        mSelMin = k.getDeclaredMethod("selMin"); mSelMin.setAccessible(true);
        mSelMax = k.getDeclaredMethod("selMax"); mSelMax.setAccessible(true);

        // --- moveCaret without shift: no selection, caret moves, anchor stays -1 ---
        setState(g, "hello world", 0, -1);
        mMove.invoke(g, 5, false);
        ok(cursor(g) == 5, "move no-shift moves caret");
        ok(anchor(g) == -1, "move no-shift keeps anchor -1");
        ok(!(Boolean) mHasSel.invoke(g), "no selection after plain move");

        // --- shift move starts a selection anchored at the old caret ---
        setState(g, "hello world", 2, -1);
        mMove.invoke(g, 5, true);
        ok(anchor(g) == 2, "shift move sets anchor to old caret");
        ok(cursor(g) == 5, "shift move moves caret");
        ok((Boolean) mHasSel.invoke(g), "selection active after shift move");
        ok(((String) mSelText.invoke(g)).equals("llo"), "selectedText = 'llo' got '" + mSelText.invoke(g) + "'");

        // --- extending selection with more shift moves keeps the same anchor ---
        mMove.invoke(g, 8, true);
        ok(anchor(g) == 2, "anchor stable across shift moves");
        ok(((String) mSelText.invoke(g)).equals("llo wo"), "extended selectedText");

        // --- selection backwards (caret before anchor): min/max normalize ---
        setState(g, "hello world", 8, 8);
        mMove.invoke(g, 2, true);
        ok((Integer) mSelMin.invoke(g) == 2, "selMin normalizes backwards sel");
        ok((Integer) mSelMax.invoke(g) == 8, "selMax normalizes backwards sel");
        ok(((String) mSelText.invoke(g)).equals("llo wo"), "backwards selectedText same span");

        // --- a plain (no-shift) move collapses the selection ---
        mMove.invoke(g, 0, false);
        ok(anchor(g) == -1, "plain move drops the selection");
        ok(!(Boolean) mHasSel.invoke(g), "no selection after collapse");

        // --- deleteSelection removes the span and collapses caret to its start ---
        setState(g, "hello world", 5, -1);
        mMove.invoke(g, 2, true);              // select "llo" backwards: anchor 5, caret 2
        mDel.invoke(g);
        ok(content(g).equals("he world"), "deleteSelection removed 'llo' -> '" + content(g) + "'");
        ok(cursor(g) == 2, "caret collapses to selection start");
        ok(anchor(g) == -1, "anchor cleared after delete");

        // --- deleteSelection with no selection is a no-op (just clears anchor) ---
        setState(g, "abc", 1, -1);
        mDel.invoke(g);
        ok(content(g).equals("abc"), "delete with no sel is no-op");
        ok(cursor(g) == 1, "delete no-sel keeps caret");

        // --- select-all style: anchor 0, caret len ---
        setState(g, "abcdef", 6, 0);
        ok(((String) mSelText.invoke(g)).equals("abcdef"), "select-all selectedText");
        mDel.invoke(g);
        ok(content(g).equals(""), "delete select-all empties content");
        ok(cursor(g) == 0, "caret 0 after emptying");

        // --- hasSel is false when anchor == cursor (empty selection) ---
        setState(g, "abc", 2, 2);
        ok(!(Boolean) mHasSel.invoke(g), "empty selection (anchor==cursor) is not a selection");
        ok(((String) mSelText.invoke(g)).equals(""), "selectedText empty when no span");

        // --- moveCaret clamps out-of-range positions ---
        setState(g, "abc", 1, -1);
        mMove.invoke(g, 99, false);
        ok(cursor(g) == 3, "moveCaret clamps to length");
        mMove.invoke(g, -5, false);
        ok(cursor(g) == 0, "moveCaret clamps to 0");

        // ===== BookLayout selection-highlight rendering (pure) =====
        BookLayout.Metrics met = new BookLayout.Metrics() {
            public int width(String s) { return s.length() * 6; }
        };
        // select chars [2,5) on a single line; expect a SEL_BG rect at x=12 width=18
        BookLayout bl = BookLayout.build("hello world", 0, 2, 5, 200, met, false);
        int selSpans = 0; boolean rightRect = false;
        for (BookLayout.Span s : bl.spans) {
            if (s.text == null && s.color == BookLayout.SEL_BG) {
                selSpans++;
                if (s.x == 12 && s.w == 18) rightRect = true;
            }
        }
        ok(selSpans >= 1, "selection produces a SEL_BG rect");
        ok(rightRect, "SEL_BG rect at expected x=12 w=18");

        // no selection -> no SEL_BG rects
        BookLayout bl2 = BookLayout.build("hello world", 0, -1, -1, 200, met, false);
        boolean anySel = false;
        for (BookLayout.Span s : bl2.spans) if (s.text == null && s.color == BookLayout.SEL_BG) anySel = true;
        ok(!anySel, "no SEL_BG rects without a selection");

        // multi-line selection spanning a newline highlights both lines
        BookLayout bl3 = BookLayout.build("abc\ndef", 0, 1, 6, 200, met, false);
        int selRects = 0;
        for (BookLayout.Span s : bl3.spans) if (s.text == null && s.color == BookLayout.SEL_BG) selRects++;
        ok(selRects >= 2, "multi-line selection highlights each row (got " + selRects + ")");

        System.out.println("SelTest: " + pass + " passed, " + fail + " failed");
        if (fail > 0) System.exit(1);
    }
}
