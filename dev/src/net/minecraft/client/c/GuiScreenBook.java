/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import com.a.a.NBTTagString;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiButtonNextPage;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.statistics.StatList;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiScreenBook
extends GuiScreen {
    private final EntityPlayer editingPlayer;
    private final ItemStack itemstackBook;
    private final boolean bookIsUnsigned;
    private boolean bookModified;
    private boolean editingTitle;
    private int updateCount;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private int bookTotalPages = 1;
    private int currPage;
    private NBTTagList bookPages;
    private String bookTitle = "";
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;
    private GuiButton buttonDone;
    private GuiButton buttonSign;
    private GuiButton buttonFinalize;
    private GuiButton buttonCancel;

    public GuiScreenBook(EntityPlayer entityPlayer, ItemStack itemStack, boolean bl) {
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
        if (this.bookPages == null && bl) {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
        if (bl) {
            this.currPage = this.bookTotalPages - 1;
        }
    }

    @Override
    public void f_() {
        super.f_();
        ++this.updateCount;
    }

    @Override
    public void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        if (this.bookIsUnsigned) {
            this.buttonFinalize = new GuiButton(5, this.c / 2 - 100, 4 + this.bookImageHeight, 98, 20, "Sign and Close");
            this.e.add(this.buttonFinalize);
            this.buttonSign = new GuiButton(3, this.c / 2 - 100, 4 + this.bookImageHeight, 98, 20, "Sign");
            this.e.add(this.buttonSign);
            this.buttonDone = new GuiButton(0, this.c / 2 + 2, 4 + this.bookImageHeight, 98, 20, "Done");
            this.e.add(this.buttonDone);
            this.buttonCancel = new GuiButton(4, this.c / 2 + 2, 4 + this.bookImageHeight, 98, 20, "Cancel");
            this.e.add(this.buttonCancel);
        } else {
            this.buttonDone = new GuiButton(0, this.c / 2 - 100, 4 + this.bookImageHeight, 200, 20, "Done");
            this.e.add(this.buttonDone);
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
        this.buttonNextPage.d = !this.editingTitle && (this.currPage < this.bookTotalPages - 1 || this.bookIsUnsigned);
        this.buttonPreviousPage.d = !this.editingTitle && this.currPage > 0;
        boolean bl = this.buttonDone.d = !this.bookIsUnsigned || !this.editingTitle;
        if (this.bookIsUnsigned) {
            this.buttonSign.d = !this.editingTitle;
            this.buttonCancel.d = this.editingTitle;
            this.buttonFinalize.d = this.editingTitle;
            this.buttonFinalize.c = this.bookTitle.trim().length() > 0;
        }
    }

    private void sendBookToServer(boolean bl) {
        if (this.bookIsUnsigned && this.bookModified && this.bookPages != null) {
            Object object;
            while (this.bookPages.b() > 1) {
                object = (NBTTagString)this.bookPages.a(this.bookPages.b() - 1);
                if (((NBTTagString)object).a != null && ((NBTTagString)object).a.length() != 0) break;
                this.bookPages.removeTag(this.bookPages.b() - 1);
            }
            if (this.itemstackBook.hasTagCompound()) {
                object = this.itemstackBook.getTagCompound();
                ((NBTTagCompound)object).a("pages", this.bookPages);
            } else {
                this.itemstackBook.setTagInfo("pages", this.bookPages);
            }
            object = "MC|BEdit";
            if (bl) {
                object = "MC|BSign";
                this.itemstackBook.setTagInfo("author", new NBTTagString(this.editingPlayer.name));
                this.itemstackBook.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
                this.itemstackBook.c = Item.writtenBook.ap;
            }
            if (this.b.isMultiplayerWorld()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    Packet.writeItemStack(this.itemstackBook, dataOutputStream);
                    this.b.getSendQueue().addToSendQueue(new Packet250CustomPayload((String)object, byteArrayOutputStream.toByteArray()));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0) {
                this.b.a((GuiScreen)null);
                this.sendBookToServer(false);
            } else if (guiButton.b == 3 && this.bookIsUnsigned) {
                this.editingTitle = true;
            } else if (guiButton.b == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                } else if (this.bookIsUnsigned) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            } else if (guiButton.b == 2) {
                if (this.currPage > 0) {
                    --this.currPage;
                }
            } else if (guiButton.b == 5 && this.editingTitle) {
                this.sendBookToServer(true);
                this.b.a((GuiScreen)null);
                this.b.f.addStat(StatList.objectUseStats[Item.bookAndQuill.ap], 1);
            } else if (guiButton.b == 4 && this.editingTitle) {
                this.editingTitle = false;
            }
            this.updateButtons();
        }
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
        if (this.bookIsUnsigned) {
            if (this.editingTitle) {
                this.editTitle(c, n);
            } else {
                this.keyTypedInBook(c, n);
            }
        }
    }

    private void keyTypedInBook(char c, int n) {
        switch (c) {
            case '\u0016': {
                this.typeCharacter(GuiScreen.getClipboardString());
                return;
            }
        }
        switch (n) {
            case 14: {
                String string = this.writePages();
                if (string.length() > 0) {
                    this.signBook(string.substring(0, string.length() - 1));
                }
                return;
            }
            case 28: {
                this.typeCharacter("\n");
                return;
            }
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0) {
            this.typeCharacter(Character.toString(c));
        }
    }

    private void editTitle(char c, int n) {
        switch (n) {
            case 14: {
                if (this.bookTitle.length() > 0) {
                    this.bookTitle = this.bookTitle.substring(0, this.bookTitle.length() - 1);
                    this.updateButtons();
                }
                return;
            }
            case 28: {
                if (this.bookTitle.length() > 0) {
                    this.sendBookToServer(true);
                    this.b.a((GuiScreen)null);
                }
                return;
            }
        }
        if (this.bookTitle.length() < 16 && ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0) {
            this.bookTitle = this.bookTitle + Character.toString(c);
            this.updateButtons();
            this.bookModified = true;
        }
    }

    private String writePages() {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.b()) {
            NBTTagString nBTTagString = (NBTTagString)this.bookPages.a(this.currPage);
            return nBTTagString.toString();
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
        String string2 = this.writePages();
        String string3 = string2 + string;
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
        if (this.editingTitle) {
            String string = this.bookTitle;
            if (this.bookIsUnsigned) {
                string = this.updateCount / 6 % 2 == 0 ? string + '\u00a7' + "0_" : string + '\u00a7' + "7_";
            }
            String string2 = "Enter Book Title:";
            int n6 = this.g.a(string2);
            this.g.b(string2, n4 + 36 + (116 - n6) / 2, n5 + 16 + 16, 0);
            int n7 = this.g.a(string);
            this.g.b(string, n4 + 36 + (116 - n7) / 2, n5 + 48, 0);
            String string3 = net.minecraft.client.Lang.tr("by %1").replace("%1", this.editingPlayer.name);
            int n8 = this.g.a(string3);
            this.g.b("\u00a78" + string3, n4 + 36 + (116 - n8) / 2, n5 + 48 + 10, 0);
            String string4 = "Note! When you sign the book, it will no longer be editable.";
            this.g.drawSplitString(string4, n4 + 36, n5 + 80, 116, 0);
        } else {
            String string = net.minecraft.client.Lang.tr("Page %1 of %2").replace("%1", Integer.toString(this.currPage + 1)).replace("%2", Integer.toString(this.bookTotalPages));
            String string5 = "";
            if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.b()) {
                NBTTagString nBTTagString = (NBTTagString)this.bookPages.a(this.currPage);
                string5 = nBTTagString.toString();
            }
            if (this.bookIsUnsigned) {
                string5 = this.updateCount / 6 % 2 == 0 ? string5 + '\u00a7' + "0_" : string5 + '\u00a7' + "7_";
            }
            int n9 = this.g.a(string);
            this.g.b(string, n4 - n9 + this.bookImageWidth - 44, n5 + 16, 0);
            this.g.drawSplitString(string5, n4 + 36, n5 + 16 + 16, 116, 0);
        }
        super.a(n, n2, f);
    }
}

