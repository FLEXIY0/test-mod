/*
 * Obsidian Book editor. Like the normal book editor, but the "Sign" button is
 * replaced with "Улучшить" (Upgrade), which opens three tools:
 *   - "Сохранить как"  : export the whole book as one Markdown file (pages
 *                        separated by "---"), via a native Save-As dialog.
 *   - "Загрузить"      : import a Markdown file back into the book.
 *   - "Скрыть синтаксис": reading view that hides Markdown syntax (commonmark).
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import com.a.a.NBTTagString;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.RenderEngine;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiScreenObsidianBook
extends GuiScreen {
    private static final String SEPARATOR = "\n\n---\n\n";
    private final EntityPlayer editingPlayer;
    private final ItemStack itemstackBook;
    private final boolean bookIsUnsigned;
    private boolean bookModified;
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 1;
    private int currPage;
    private NBTTagList bookPages;
    private boolean showTools;
    private boolean reading;
    private String status = "";
    private int statusTimer;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;

    public GuiScreenObsidianBook(EntityPlayer entityPlayer, ItemStack itemStack, boolean bl) {
        this.editingPlayer = entityPlayer;
        this.itemstackBook = itemStack;
        this.bookIsUnsigned = bl;
        if (itemStack.hasTagCompound()) {
            NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
            this.bookPages = nBTTagCompound.j("pages");
            if (this.bookPages != null) {
                this.bookPages = (NBTTagList)this.bookPages.copy();
                this.bookTotalPages = this.bookPages.b();
                if (this.bookTotalPages < 1) {
                    this.bookTotalPages = 1;
                }
            }
        }
        if (this.bookPages == null) {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
        this.currPage = this.bookTotalPages - 1;
    }

    @Override
    public void f_() {
        super.f_();
        ++this.updateCount;
        if (this.statusTimer > 0 && --this.statusTimer == 0) {
            this.status = "";
        }
    }

    @Override
    public void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        int bottom = 4 + this.bookImageHeight;
        // Row 1: Улучшить / Назад  +  Done
        this.e.add(new GuiButton(10, this.c / 2 - 100, bottom, 98, 20,
                this.showTools ? net.minecraft.client.Lang.tr("Back") : "\u00a7d" + net.minecraft.client.Lang.tr("Upgrade")));
        this.e.add(new GuiButton(0, this.c / 2 + 2, bottom, 98, 20, net.minecraft.client.Lang.tr("Done")));
        // Row 2 (tools submenu)
        if (this.showTools) {
            this.e.add(new GuiButton(11, this.c / 2 - 100, bottom + 24, 98, 20, net.minecraft.client.Lang.tr("Save as")));
            this.e.add(new GuiButton(12, this.c / 2 + 2, bottom + 24, 98, 20, net.minecraft.client.Lang.tr("Load")));
            this.e.add(new GuiButton(13, this.c / 2 - 100, bottom + 48, 200, 20,
                    this.reading ? net.minecraft.client.Lang.tr("Show syntax") : net.minecraft.client.Lang.tr("Hide syntax (reading)")));
        }
        int n = (this.c - this.bookImageWidth) / 2;
        int n2 = 2;
        this.buttonNextPage = new GuiButtonNextPage(1, n + 120, n2 + 154, true);
        this.e.add(this.buttonNextPage);
        this.buttonPreviousPage = new GuiButtonNextPage(2, n + 38, n2 + 154, false);
        this.e.add(this.buttonPreviousPage);
        this.updateButtons();
    }

    @Override
    public void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    private void updateButtons() {
        this.buttonNextPage.d = this.currPage < this.bookTotalPages - 1 || !this.reading;
        this.buttonPreviousPage.d = this.currPage > 0;
    }

    private void setStatus(String s) {
        this.status = s;
        this.statusTimer = 80;
    }

    /** Persist the (possibly edited) pages back into the held item stack. */
    private void savePages() {
        if (this.bookPages == null) {
            return;
        }
        while (this.bookPages.b() > 1) {
            NBTTagString last = (NBTTagString)this.bookPages.a(this.bookPages.b() - 1);
            if (last.a != null && last.a.length() != 0) break;
            this.bookPages.removeTag(this.bookPages.b() - 1);
        }
        if (this.itemstackBook.hasTagCompound()) {
            this.itemstackBook.getTagCompound().a("pages", this.bookPages);
        } else {
            this.itemstackBook.setTagInfo("pages", this.bookPages);
        }
    }

    private String buildMarkdown() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.bookPages.b(); ++i) {
            NBTTagString page = (NBTTagString)this.bookPages.a(i);
            String text = page.a == null ? "" : page.a;
            if (i > 0) {
                sb.append(SEPARATOR);
            }
            sb.append(text);
        }
        return sb.toString();
    }

    private void loadFromMarkdown(String markdown) {
        String normalized = markdown.replace("\r\n", "\n").replace("\r", "\n");
        String[] rawPages = normalized.split("\n[ \t]*---[ \t]*\n");
        NBTTagList list = new NBTTagList();
        int count = 0;
        for (String raw : rawPages) {
            if (count >= 250) break;
            String page = raw;
            while (page.startsWith("\n")) page = page.substring(1);
            while (page.endsWith("\n")) page = page.substring(0, page.length() - 1);
            if (page.length() > 1024) {
                page = page.substring(0, 1024);
            }
            list.appendTag(new NBTTagString(page));
            ++count;
        }
        if (list.b() == 0) {
            list.appendTag(new NBTTagString(""));
        }
        this.bookPages = list;
        this.bookTotalPages = list.b();
        this.currPage = 0;
        this.bookModified = true;
    }

    private void doExport() {
        String md = this.buildMarkdown();
        String suggested = "book_" + System.currentTimeMillis() + ".md";
        java.io.File saved = BookIO.saveAs(md, suggested);
        if (saved != null) {
            this.setStatus("\u00a7a" + net.minecraft.client.Lang.tr("Saved") + ": " + saved.getName());
        } else {
            this.setStatus("\u00a7e" + net.minecraft.client.Lang.tr("Save cancelled"));
        }
    }

    private void doImport() {
        String content = BookIO.load();
        if (content == null) {
            this.setStatus("\u00a7e" + net.minecraft.client.Lang.tr("Load cancelled"));
            return;
        }
        this.loadFromMarkdown(content);
        this.savePages();
        this.setStatus("\u00a7a" + net.minecraft.client.Lang.tr("Loaded") + " (" + this.bookTotalPages + ")");
        this.b();
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (!guiButton.c) {
            return;
        }
        switch (guiButton.b) {
            case 0: { // Done
                this.savePages();
                this.b.a((GuiScreen)null);
                break;
            }
            case 1: { // next page
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                } else if (!this.reading) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
                break;
            }
            case 2: { // previous page
                if (this.currPage > 0) {
                    --this.currPage;
                }
                break;
            }
            case 10: { // Улучшить / Назад
                this.showTools = !this.showTools;
                this.b();
                break;
            }
            case 11: { // Сохранить как
                this.doExport();
                break;
            }
            case 12: { // Загрузить
                this.doImport();
                break;
            }
            case 13: { // Скрыть синтаксис (чтение)
                this.reading = !this.reading;
                this.b();
                break;
            }
        }
        this.updateButtons();
    }

    private void addNewPage() {
        if (this.bookPages != null && this.bookPages.b() < 250) {
            this.bookPages.appendTag(new NBTTagString(""));
            ++this.bookTotalPages;
            this.bookModified = true;
        }
    }

    @Override
    protected void a(char c, int n) {
        super.a(c, n);
        if (this.reading) {
            return; // reading view is read-only
        }
        this.keyTypedInBook(c, n);
    }

    private void keyTypedInBook(char c, int n) {
        if (c == '\u0016') { // Ctrl+V
            this.typeCharacter(GuiScreen.getClipboardString());
            return;
        }
        if (n == 14) { // backspace
            String string = this.writePages();
            if (string.length() > 0) {
                this.signBook(string.substring(0, string.length() - 1));
            }
            return;
        }
        if (n == 28) { // enter
            this.typeCharacter("\n");
            return;
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0) {
            this.typeCharacter(Character.toString(c));
        }
    }

    private String writePages() {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.b()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages.a(this.currPage);
            return nBTTagString.a == null ? "" : nBTTagString.a;
        }
        return "";
    }

    private void signBook(String string) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.b()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages.a(this.currPage);
            nBTTagString.a = string;
            this.bookModified = true;
        }
    }

    private void typeCharacter(String string) {
        String string3 = this.writePages() + string;
        int n = this.g.splitStringWidth(string3 + '\u00a7' + "0_", 118);
        if (n <= 118 && string3.length() < 1024) {
            this.signBook(string3);
        }
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
        String pageLabel = net.minecraft.client.Lang.tr("Page %1 of %2")
                .replace("%1", Integer.toString(this.currPage + 1))
                .replace("%2", Integer.toString(this.bookTotalPages));
        String raw = "";
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.b()) {
            NBTTagString page = (NBTTagString)this.bookPages.a(this.currPage);
            raw = page.a == null ? "" : page.a;
        }
        String body;
        if (this.reading) {
            body = MarkdownReader.render(raw);
        } else {
            body = this.updateCount / 6 % 2 == 0 ? raw + '\u00a7' + "0_" : raw + '\u00a7' + "7_";
        }
        int n9 = this.g.a(pageLabel);
        this.g.b(pageLabel, n4 - n9 + this.bookImageWidth - 44, n5 + 16, 0);
        this.g.drawSplitString(body, n4 + 36, n5 + 16 + 16, 116, 0);
        if (this.status.length() > 0) {
            int sw = this.g.a(this.status);
            this.g.b(this.status, this.c / 2 - sw / 2, 4 + this.bookImageHeight - 12, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }
}
