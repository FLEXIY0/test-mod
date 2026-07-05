/*
 * Obsidian Book editor with an Obsidian-style "Live Preview".
 *
 * The book is one continuous document (field `content`); pages are purely a
 * display pagination computed from the rendered height, so text that doesn't
 * fit flows onto the next page automatically and the caret (a single index into
 * `content`) crosses pages seamlessly with the arrow keys. Every line renders
 * formatted except the caret's line, which reveals its raw markdown for editing.
 *
 * "Улучшить" (Upgrade) → Save as / Load / Reading (full preview). Mouse: click
 * places the caret, clicks links (opens the browser) and toggles checkboxes.
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import com.a.a.NBTTagString;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.RenderEngine;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiScreenObsidianBook
extends GuiScreen {
    private static final int PAGE_WIDTH = 116;
    private final EntityPlayer editingPlayer;
    private final ItemStack itemstackBook;
    private boolean bookModified;
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private String content = "";
    private int cursorPos;
    private boolean showTools;
    private boolean reading;
    private String status = "";
    private int statusTimer;
    private BookIO.Result saveTask;
    private BookIO.Result loadTask;
    private BookLayout layout;
    private int layoutX, layoutY, pageStart;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;

    public GuiScreenObsidianBook(EntityPlayer entityPlayer, ItemStack itemStack, boolean bl) {
        this.editingPlayer = entityPlayer;
        this.itemstackBook = itemStack;
        this.content = readContent(itemStack);
        this.cursorPos = this.content.length();
    }

    /** Join the stored pages into one continuous document. */
    private static String readContent(ItemStack itemStack) {
        if (!itemStack.hasTagCompound()) {
            return "";
        }
        NBTTagList pages = itemStack.getTagCompound().j("pages");
        if (pages == null || pages.b() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pages.b(); ++i) {
            NBTTagString p = (NBTTagString) pages.a(i);
            if (i > 0) sb.append("\n\n");
            sb.append(p.a == null ? "" : p.a);
        }
        return sb.toString();
    }

    private BookLayout.Metrics metrics() {
        final FontRenderer fr = this.g;
        return new BookLayout.Metrics() {
            @Override
            public int width(String s) { return fr.a(s); }
        };
    }

    private int pageAreaHeight() {
        return this.bookImageHeight - 40;
    }

    /** Split the document into display pages by rendered height. Returns page
     *  start indices with a trailing sentinel = content length (pages = n-1). */
    private int[] paginate() {
        BookLayout full = BookLayout.build(this.content, -1, PAGE_WIDTH, this.metrics(), true);
        return computePageStarts(full.lines, this.content.length(), this.pageAreaHeight());
    }

    /** Group laid-out lines into display pages by cumulative height. Pure/testable. */
    static int[] computePageStarts(List<BookLayout.LineBox> lines, int contentLen, int pageH) {
        List<Integer> starts = new ArrayList<Integer>();
        starts.add(0);
        int pageTop = 0;
        for (BookLayout.LineBox lb : lines) {
            if (lb.start == starts.get(starts.size() - 1)) {
                pageTop = lb.top; // first line of the current page
                continue;
            }
            if (lb.bottom - pageTop > pageH) {
                starts.add(lb.start);
                pageTop = lb.top;
            }
        }
        starts.add(contentLen);
        int[] out = new int[starts.size()];
        for (int i = 0; i < out.length; i++) out[i] = starts.get(i);
        return out;
    }

    static int pageIndexOf(int[] starts, int pos) {
        for (int k = 0; k < starts.length - 1; k++) {
            if (pos >= starts[k] && pos < starts[k + 1]) return k;
        }
        return Math.max(0, starts.length - 2);
    }

    @Override
    public void f_() {
        super.f_();
        ++this.updateCount;
        this.pollTasks();
        if (this.statusTimer > 0 && --this.statusTimer == 0) {
            this.status = "";
        }
    }

    private void pollTasks() {
        if (this.saveTask != null && this.saveTask.done) {
            if (this.saveTask.file != null) {
                this.setStatus("\u00a7a" + net.minecraft.client.Lang.tr("Saved") + ": " + this.saveTask.file.getName());
            } else {
                this.setStatus("\u00a7e" + net.minecraft.client.Lang.tr("Save cancelled"));
            }
            this.saveTask = null;
        }
        if (this.loadTask != null && this.loadTask.done) {
            if (this.loadTask.content != null) {
                this.loadFromMarkdown(this.loadTask.content);
                this.savePages();
                this.setStatus("\u00a7a" + net.minecraft.client.Lang.tr("Loaded"));
                this.b();
            } else {
                this.setStatus("\u00a7e" + net.minecraft.client.Lang.tr("Load cancelled"));
            }
            this.loadTask = null;
        }
    }

    @Override
    public void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        int bottom = 4 + this.bookImageHeight;
        this.e.add(new GuiButton(10, this.c / 2 - 100, bottom, 98, 20,
                this.showTools ? net.minecraft.client.Lang.tr("Back") : "\u00a7d" + net.minecraft.client.Lang.tr("Upgrade")));
        this.e.add(new GuiButton(0, this.c / 2 + 2, bottom, 98, 20, net.minecraft.client.Lang.tr("Done")));
        if (this.showTools) {
            this.e.add(new GuiButton(11, this.c / 2 - 100, bottom + 24, 98, 20, net.minecraft.client.Lang.tr("Save as")));
            this.e.add(new GuiButton(12, this.c / 2 + 2, bottom + 24, 98, 20, net.minecraft.client.Lang.tr("Load")));
            this.e.add(new GuiButton(13, this.c / 2 - 100, bottom + 48, 200, 20,
                    this.reading ? net.minecraft.client.Lang.tr("Show syntax") : net.minecraft.client.Lang.tr("Hide syntax (reading)")));
        }
        int n = (this.c - this.bookImageWidth) / 2;
        this.buttonNextPage = new GuiButtonNextPage(1, n + 120, 156, true);
        this.e.add(this.buttonNextPage);
        this.buttonPreviousPage = new GuiButtonNextPage(2, n + 38, 156, false);
        this.e.add(this.buttonPreviousPage);
    }

    @Override
    public void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    private void setStatus(String s) {
        this.status = s;
        this.statusTimer = 80;
    }

    /** Store the whole document as a single page (display pagination is runtime). */
    private void savePages() {
        NBTTagList list = new NBTTagList();
        list.appendTag(new NBTTagString(this.content));
        if (this.itemstackBook.hasTagCompound()) {
            this.itemstackBook.getTagCompound().a("pages", list);
        } else {
            this.itemstackBook.setTagInfo("pages", list);
        }
    }

    private void loadFromMarkdown(String markdown) {
        this.content = markdown.replace("\r\n", "\n").replace("\r", "\n");
        this.cursorPos = 0;
        this.bookModified = true;
    }

    private void doExport() {
        if (this.saveTask != null || this.loadTask != null) return;
        this.setStatus("\u00a77" + net.minecraft.client.Lang.tr("Choose a file..."));
        this.saveTask = BookIO.saveAsAsync(this.content, "book_" + System.currentTimeMillis() + ".md");
    }

    private void doImport() {
        if (this.saveTask != null || this.loadTask != null) return;
        this.setStatus("\u00a77" + net.minecraft.client.Lang.tr("Choose a file..."));
        this.loadTask = BookIO.loadAsync();
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (!guiButton.c) return;
        switch (guiButton.b) {
            case 0: // Done
                this.savePages();
                this.b.a((GuiScreen)null);
                break;
            case 1: { // next page: move caret to the next page (or the end)
                int[] s = this.paginate();
                int p = this.pageIndexOf(s, this.cursorPos);
                if (p < s.length - 2) this.cursorPos = s[p + 1];
                else this.cursorPos = this.content.length();
                break;
            }
            case 2: { // previous page
                int[] s = this.paginate();
                int p = this.pageIndexOf(s, this.cursorPos);
                if (p > 0) this.cursorPos = s[p - 1];
                break;
            }
            case 10:
                this.showTools = !this.showTools;
                this.b();
                break;
            case 11:
                this.doExport();
                break;
            case 12:
                this.doImport();
                break;
            case 13:
                this.reading = !this.reading;
                this.b();
                break;
        }
    }

    @Override
    protected void a(char c, int n) {
        super.a(c, n);
        if (this.reading) return;
        this.keyTypedInBook(c, n);
    }

    private void keyTypedInBook(char c, int keyCode) {
        String text = this.content;
        int len = text.length();
        if (this.cursorPos > len) this.cursorPos = len;
        switch (keyCode) {
            case 203: if (this.cursorPos > 0) --this.cursorPos; return;                  // Left
            case 205: if (this.cursorPos < len) ++this.cursorPos; return;                // Right
            case 199: this.cursorPos = lineStart(text, this.cursorPos); return;          // Home
            case 207: this.cursorPos = lineEnd(text, this.cursorPos); return;            // End
            case 200: this.cursorPos = moveVertical(text, this.cursorPos, -1); return;   // Up
            case 208: this.cursorPos = moveVertical(text, this.cursorPos, 1); return;    // Down
            case 14: // Backspace
                if (this.cursorPos > 0) {
                    this.content = text.substring(0, this.cursorPos - 1) + text.substring(this.cursorPos);
                    --this.cursorPos;
                    this.bookModified = true;
                }
                return;
            case 211: // Delete
                if (this.cursorPos < len) {
                    this.content = text.substring(0, this.cursorPos) + text.substring(this.cursorPos + 1);
                    this.bookModified = true;
                }
                return;
        }
        if (c == '\u0016') { this.insert(GuiScreen.getClipboardString()); return; } // Ctrl+V
        if (keyCode == 28) { this.insert("\n"); return; }                            // Enter
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0) {
            this.insert(Character.toString(c));
        }
    }

    /** Insert at the caret. No page-capacity check — overflow flows to a new page. */
    private void insert(String string) {
        if (string == null || string.length() == 0) return;
        if (this.cursorPos > this.content.length()) this.cursorPos = this.content.length();
        if (this.content.length() + string.length() > 100000) return; // sanity cap
        this.content = this.content.substring(0, this.cursorPos) + string + this.content.substring(this.cursorPos);
        this.cursorPos += string.length();
        this.bookModified = true;
    }

    // ---- line navigation over the whole document (crosses pages) ----

    private static int lineStart(String t, int pos) {
        int i = t.lastIndexOf('\n', pos - 1);
        return i < 0 ? 0 : i + 1;
    }
    private static int lineEnd(String t, int pos) {
        int i = t.indexOf('\n', pos);
        return i < 0 ? t.length() : i;
    }
    private static int moveVertical(String t, int pos, int dir) {
        int ls = lineStart(t, pos);
        int col = pos - ls;
        if (dir < 0) {
            if (ls == 0) return pos;
            int prevStart = lineStart(t, ls - 1);
            return Math.min(prevStart + col, ls - 1);
        }
        int le = lineEnd(t, pos);
        if (le >= t.length()) return pos;
        int nextStart = le + 1;
        return Math.min(nextStart + col, lineEnd(t, nextStart));
    }

    // ---- mouse ----

    @Override
    protected void mouseClick(int mx, int my, int button) {
        super.mouseClick(mx, my, button);
        if (button != 0 || this.layout == null) return;
        int lx = mx - this.layoutX;
        int ly = my - this.layoutY;
        for (BookLayout.Link l : this.layout.links) {
            if (lx >= l.x && lx <= l.x + l.w && ly >= l.y - 1 && ly <= l.y + l.h) {
                BookIO.openUrlAsync(l.url);
                this.setStatus("\u00a77" + net.minecraft.client.Lang.tr("Opening link..."));
                return;
            }
        }
        if (this.reading) return;
        for (BookLayout.Check ch : this.layout.checks) {
            if (lx >= ch.x - 1 && lx <= ch.x + ch.size + 1 && ly >= ch.y - 1 && ly <= ch.y + ch.size + 1) {
                this.content = toggleState(this.content, this.pageStart + ch.markIndex);
                this.bookModified = true;
                return;
            }
        }
        for (BookLayout.LineBox lb : this.layout.lines) {
            if (ly >= lb.top && ly < lb.bottom) {
                String pageText = this.content.substring(
                        Math.min(this.pageStart + lb.start, this.content.length()),
                        Math.min(this.pageStart + lb.end, this.content.length()));
                this.cursorPos = this.pageStart + lb.start + columnFromX(pageText, lx, this.metrics());
                if (this.cursorPos > this.content.length()) this.cursorPos = this.content.length();
                return;
            }
        }
    }

    /** Flip the checkbox state char (after '[') between ' ' and 'x'. Pure. */
    static String toggleState(String text, int bracketIdx) {
        int s = bracketIdx + 1;
        if (s < 0 || s >= text.length()) return text;
        char nw = Character.toLowerCase(text.charAt(s)) == 'x' ? ' ' : 'x';
        return text.substring(0, s) + nw + text.substring(s + 1);
    }

    /** Approximate character column for a click x within a single line's text. */
    static int columnFromX(String line, int lx, BookLayout.Metrics m) {
        if (lx <= 0) return 0;
        int acc = 0;
        for (int i = 0; i < line.length(); i++) {
            int w = m.width(line.substring(i, i + 1));
            if (acc + w / 2 >= lx) return i;
            acc += w;
        }
        return line.length();
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        int n3 = this.b.m.a("/gui/book.png");
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(n3);
        int n4 = (this.c - this.bookImageWidth) / 2;
        int n5 = 2;
        this.b(n4, n5, 0, 0, this.bookImageWidth, this.bookImageHeight);

        int[] starts = this.paginate();
        int pageCount = starts.length - 1;
        int page = this.pageIndexOf(starts, this.cursorPos);
        this.pageStart = starts[page];
        int pageEnd = starts[page + 1];
        String pageText = this.content.substring(this.pageStart, pageEnd);
        int pageCursor = this.reading ? -1 : (this.cursorPos - this.pageStart);

        String pageLabel = net.minecraft.client.Lang.tr("Page %1 of %2")
                .replace("%1", Integer.toString(page + 1)).replace("%2", Integer.toString(pageCount));
        int lw = this.g.a(pageLabel);
        this.g.b(pageLabel, n4 - lw + this.bookImageWidth - 44, n5 + 16, 0);

        int textX = n4 + 36;
        int textY = n5 + 16 + 16;
        this.layout = MarkdownRenderer.render(this.g, pageText, pageCursor, textX, textY, PAGE_WIDTH, this.pageAreaHeight(), this.reading);
        this.layoutX = textX;
        this.layoutY = textY;

        if (this.buttonNextPage != null) this.buttonNextPage.d = true;
        if (this.buttonPreviousPage != null) this.buttonPreviousPage.d = page > 0;

        if (this.status.length() > 0) {
            int sw = this.g.a(this.status);
            this.g.b(this.status, this.c / 2 - sw / 2, 4 + this.bookImageHeight - 12, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }
}
