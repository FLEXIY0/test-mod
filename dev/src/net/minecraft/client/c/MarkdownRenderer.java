/*
 * Draws a BookLayout onto the Obsidian Book page. The 8px font has no real
 * bold/italic/size, so bold = double-draw, italic = shear matrix, headings =
 * scale matrix. Rectangles (rules, underlines, strike, highlight, code bg,
 * quote bar) use Gui.a(); checkboxes and the caret are drawn explicitly.
 *
 * Returns the BookLayout so the GUI can hit-test links / checkboxes / cursor.
 */
package net.minecraft.client.c;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class MarkdownRenderer {

    private static final FloatBuffer SHEAR = makeShear();

    private static FloatBuffer makeShear() {
        FloatBuffer b = BufferUtils.createFloatBuffer(16);
        b.put(new float[]{1f, 0f, 0f, 0f, -0.21f, 1f, 0f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1f});
        b.flip();
        return b;
    }

    public static BookLayout render(final FontRenderer fr, String text, int cursorPos,
                                    final int x, final int y, int width, int maxHeight, boolean reading) {
        BookLayout bl = BookLayout.build(text, cursorPos, width, new BookLayout.Metrics() {
            @Override
            public int width(String s) { return fr.a(s); }
        }, reading);

        // 1. background rects
        for (BookLayout.Span s : bl.spans) {
            if (s.text != null || s.layer != 0 || s.y > maxHeight) continue;
            fill(x + s.x, y + s.y, s.w, s.h, s.color);
        }
        // 2. text
        for (BookLayout.Span s : bl.spans) {
            if (s.text == null || s.text.length() == 0 || s.y > maxHeight) continue;
            drawText(fr, s, x, y);
        }
        // 3. foreground rects (strike-through)
        for (BookLayout.Span s : bl.spans) {
            if (s.text != null || s.layer != 1 || s.y > maxHeight) continue;
            fill(x + s.x, y + s.y, s.w, s.h, s.color);
        }
        // 4. checkboxes (box + drawn checkmark)
        for (BookLayout.Check c : bl.checks) {
            if (c.y > maxHeight) continue;
            drawCheckbox(x + c.x, y + c.y, c.size, c.checked);
        }
        // 5. caret (only present in hybrid edit mode)
        if (bl.caretX >= 0 && bl.caretY <= maxHeight && (System.currentTimeMillis() / 500) % 2 == 0) {
            fill(x + bl.caretX, y + bl.caretY - 1, 1, bl.caretH + 1, 0xFF000000);
        }
        return bl;
    }

    private static void drawText(FontRenderer fr, BookLayout.Span s, int x, int y) {
        GL11.glPushMatrix();
        GL11.glTranslatef(x + s.x, y + s.y, 0f);
        if (s.scale != 1f) GL11.glScalef(s.scale, s.scale, 1f);
        if (s.italic) {
            SHEAR.rewind();
            GL11.glMultMatrix(SHEAR);
            GL11.glTranslatef(1.5f, 0f, 0f);
        }
        fr.b(s.text, 0, 0, s.color);
        if (s.bold) fr.b(s.text, 1, 0, s.color);
        GL11.glPopMatrix();
    }

    private static void drawCheckbox(int x, int y, int size, boolean checked) {
        // outline box
        fill(x, y, size, 1, 0xFF444444);
        fill(x, y + size - 1, size, 1, 0xFF444444);
        fill(x, y, 1, size, 0xFF444444);
        fill(x + size - 1, y, 1, size, 0xFF444444);
        if (checked) {
            // a checkmark: descending short stroke to a low vertex, then a longer up stroke
            int c = 0xFF117711;
            fill(x + 1, y + 3, 1, 2, c);
            fill(x + 2, y + 4, 1, 2, c);
            fill(x + 3, y + 3, 1, 2, c);
            fill(x + 4, y + 2, 1, 2, c);
            fill(x + 5, y + 1, 1, 2, c);
        }
    }

    /** Filled rect via Gui.a (ARGB); adds opaque alpha when none is set. */
    private static void fill(int x, int y, int w, int h, int color) {
        if (w <= 0 || h <= 0) return;
        if ((color & 0xFF000000) == 0) color |= 0xFF000000;
        Gui.a(x, y, x + w, y + h, color);
    }
}
