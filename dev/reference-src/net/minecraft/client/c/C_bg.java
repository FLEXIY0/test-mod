/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.IOException;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.client.c.C_ah;
import net.minecraft.client.c.C_ap;
import net.minecraft.client.c.C_bd;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.g.EntityPlayerSP;
import net.minecraft.client.statistics.StatFileWriter;

public class C_bg
extends GuiScreen {
    private GuiScreen parent;
    protected String title = "Select character";
    private boolean deleteMode = false;
    private boolean renameMode = false;
    private GuiButton deleteButton;
    private GuiButton editButton;

    public C_bg(GuiScreen guiScreen) {
        this.parent = guiScreen;
    }

    @Override
    public void b() {
        this.e.clear();
        for (int i = 0; i < 5; ++i) {
            this.e.add(new GuiButton(i, this.c / 2 - 100, this.d / 6 + i * 24, "- empty -"));
            GuiButton guiButton = (GuiButton)this.e.get(i);
            try {
                NBTTagCompound nBTTagCompound = this.b.characters.readCharacter(i);
                if (nBTTagCompound != null) {
                    guiButton.a = nBTTagCompound.g("Name");
                    ((GuiButton)this.e.get((int)i)).c = true;
                    continue;
                }
                guiButton.a = "- empty -";
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.deleteMode = false;
        this.renameMode = false;
        this.deleteButton = new GuiButton(5, this.c / 2 + 4, this.d / 6 + 120 + 12, 97, 20, "Delete..");
        this.e.add(this.deleteButton);
        this.editButton = new GuiButton(7, this.c / 2 - 100, this.d / 6 + 120 + 12, 100, 20, "Edit..");
        this.e.add(this.editButton);
        this.e.add(new GuiButton(6, this.c / 2 - 100, this.d / 6 + 168, "Cancel"));
    }

    @Override
    public final void f_() {
        for (int i = 0; i < 5; ++i) {
            try {
                NBTTagCompound nBTTagCompound = this.b.characters.readCharacter(i);
                if (nBTTagCompound == null) continue;
                ((GuiButton)this.e.get((int)i)).c = true;
                continue;
            }
            catch (IOException iOException) {
                ((GuiButton)this.e.get((int)i)).c = !this.deleteMode && !this.renameMode;
            }
        }
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b < 5) {
                if (this.deleteMode) {
                    String string = "Are you sure you want to delete this character?";
                    String string2 = "Once deleted, there is no recovering it!";
                    String string3 = "Delete";
                    String string4 = "Cancel";
                    this.title = "Select character";
                    this.b.a(new C_ah(this, string, string2, string3, string4, guiButton.b));
                } else if (this.renameMode) {
                    this.renameMode = false;
                    this.title = "Select character";
                    this.b.a(new C_ap(this, this.b.characters, guiButton.b));
                } else {
                    try {
                        this.b.characters.currentCharacter = this.b.characters.readCharacter(guiButton.b);
                        this.b.w.character = guiButton.b;
                        this.b.w.a();
                        this.b.statFileWriter = new StatFileWriter(this.b.characters, this.b.z, this.b.h);
                        this.b.a(this.parent);
                        CraftingManager.clearRecipes();
                        CraftingManager.addUnlockedRecipes();
                    }
                    catch (IOException iOException) {
                        this.newCharacter(guiButton.b);
                    }
                }
            }
            if (guiButton.b == 6) {
                if (this.deleteMode || this.renameMode) {
                    this.deleteMode = false;
                    this.renameMode = false;
                    this.deleteButton.d = true;
                    this.editButton.d = true;
                    this.title = "Select character";
                } else {
                    this.b.a(this.parent);
                }
            }
            if (guiButton.b == 5) {
                this.deleteMode = true;
                this.deleteButton.d = false;
                this.editButton.d = false;
                this.title = "Select character to delete";
            }
            if (guiButton.b == 7) {
                this.renameMode = true;
                this.deleteButton.d = false;
                this.editButton.d = false;
                this.title = "Select character to edit";
            }
        }
    }

    @Override
    public void buttonAction(boolean bl, int n) {
        this.deleteMode = false;
        if (bl) {
            File file = new File(this.b.z, "characters/char" + n + ".dat");
            File file2 = new File(this.b.z, "characters/char" + n + ".png");
            File file3 = new File(this.b.z, "characters/stats_char" + n + "_unsent.dat");
            File file4 = new File(this.b.z, "characters/stats_char" + n + "_unsent.old");
            if (file.exists()) {
                file.delete();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (file3.exists()) {
                file3.delete();
            }
            if (file4.exists()) {
                file4.delete();
            }
            CraftingManager.clearRecipes();
            this.newCharacter(n);
        }
        this.b.a(this);
    }

    private void newCharacter(int n) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        EntityPlayerSP c_a = new EntityPlayerSP(this.b, null, this.b.h);
        c_a.c(nBTTagCompound);
        this.b.characters.currentCharacter = nBTTagCompound;
        this.b.w.character = n;
        this.b.statFileWriter = new StatFileWriter(this.b.characters, this.b.z, this.b.h);
        this.b.a(new C_bd(this.b.characters, n));
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_bg.a(this.g, this.title, this.c / 2, 20, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

