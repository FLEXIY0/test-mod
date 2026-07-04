/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import net.minecraft.a.a.LevelOptions;
import net.minecraft.client.c.C_bl;
import net.minecraft.client.c.C_bw;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class C_n
extends GuiScreen {
    private GuiScreen a;
    public String name = "A Nice World";
    public LevelOptions worldOptions;
    private int counter = 0;

    public C_n(GuiScreen guiScreen) {
        this.a = guiScreen;
    }

    @Override
    public final void b() {
        this.worldOptions = this.b.worldOptions;
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.clear();
        this.e.add(new C_bl(1, this.c / 2 - 100, this.d / 5 + 44, "Width", 4, 200, 20));
        this.e.add(new C_bl(2, this.c / 2 - 100, this.d / 5 + 68, "Height", 5, 200, 20));
        this.e.add(new C_bl(3, this.c / 2 - 100, this.d / 5 + 92, "Length", 6, 200, 20));
        this.e.add(new GuiButton(4, this.c / 2 - 100, this.d / 5 + 154, 100, 20, "Create"));
        this.e.add(new GuiButton(5, this.c / 2 - 100, this.d / 5 + 130, "More world options.."));
        this.e.add(new GuiButton(6, this.c / 2 + 4, this.d / 5 + 154, 96, 20, "Cancel"));
    }

    @Override
    public final void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public final void f_() {
        ++this.counter;
        ((GuiButton)this.e.get((int)3)).c = this.name.length() >= 2 && this.b.worldOptions.width * this.b.worldOptions.height * this.b.worldOptions.length < 0x8000000;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.b == 6) {
            this.b.a(this.a);
        } else if (guiButton.b == 5) {
            this.b.a(new C_bw(this));
        } else if (guiButton.b == 4) {
            this.b.generateLevel(this.worldOptions, this.name);
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        if (c == '\u0016') {
            int n2;
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            if ((n2 = 32 - this.name.length()) > string.length()) {
                n2 = string.length();
            }
            if (n2 > 0) {
                this.name = this.name + string.substring(0, n2);
            }
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.name.length() < 48 && this.g.a(this.name) < 132) {
            this.name = this.name + c;
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_n.a(this.g, "Generate new level", this.c / 2, 20, 0xFFFFFF);
        C_n.a(this.g, "Level name:", this.c / 2, 50, 0xFFFFFF);
        int n3 = this.c / 2 - 100;
        int n4 = this.d / 5;
        C_n.a(n3 - 1, n4 + 15 - 1, n3 + 200 + 1, n4 + 35 + 1, -6250336);
        C_n.a(n3, n4 + 15, n3 + 200, n4 + 35, -16777216);
        C_n.b(this.g, this.name + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 15 + 6, 0xE0E0E0);
        if (this.b.worldOptions.width * this.b.worldOptions.height * this.b.worldOptions.length >= 0x8000000) {
            C_n.a(this.g, "\u00a7cWorld too large!", this.c / 2, this.d / 5 + 117, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }
}

