/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import com.a.a.C_m;
import com.a.a.NBTTagCompound;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class C_bf
extends GuiScreen {
    private GuiScreen parent;
    private String title = "Enter level name:";
    private String name = "";
    private String fileName = "";
    private int counter = 0;

    public C_bf(GuiScreen guiScreen, String string, String string2) {
        this.parent = guiScreen;
        if (string != null) {
            this.name = string;
        }
        if (string2 != null) {
            this.fileName = string2;
        }
    }

    @Override
    public final void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120, "Rename"));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 144, "Cancel"));
        ((GuiButton)this.e.get((int)0)).c = this.name.trim().length() > 1;
    }

    @Override
    public final void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public final void f_() {
        ++this.counter;
        ((GuiButton)this.e.get((int)0)).c = this.name.length() >= 2;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0 && this.name.trim().length() > 1) {
                File file = new File(this.b.z, "saves/" + this.fileName);
                try {
                    NBTTagCompound nBTTagCompound = C_m.readTags(new FileInputStream(file));
                    NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("About");
                    nBTTagCompound2.a("Name", this.name);
                    C_m.writeTags(nBTTagCompound, new FileOutputStream(file));
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.b.a(this.parent);
            }
            if (guiButton.b == 1) {
                this.b.a(this.parent);
            }
        }
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.name.length() < 64 && this.g.a(this.name) < 132) {
            this.name = this.name + c;
        }
        ((GuiButton)this.e.get((int)0)).c = this.name.trim().length() > 1;
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_bf.a(this.g, this.title, this.c / 2, 80, 0xFFFFFF);
        int n3 = this.c / 2 - 100;
        int n4 = this.d / 4 + 55;
        C_bf.a(n3 - 1, n4 - 1, n3 + 200 + 1, n4 + 20 + 1, -6250336);
        C_bf.a(n3, n4, n3 + 200, n4 + 20, -16777216);
        C_bf.b(this.g, this.name + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 6, 0xE0E0E0);
        super.a(n, n2, f);
    }
}

