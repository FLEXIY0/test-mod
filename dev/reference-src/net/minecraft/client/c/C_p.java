/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class C_p
extends GuiScreen {
    private GuiScreen a;
    private String i = "Enter level name:";
    private int j;
    private String k;
    private int l = 0;

    public C_p(GuiScreen guiScreen, String string, int n) {
        this.a = guiScreen;
        this.j = n;
        this.k = string;
        if (this.k.equals("-")) {
            this.k = "";
        }
    }

    public final void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120, "Save"));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 144, "Cancel"));
        ((GuiButton)this.e.get((int)0)).c = this.k.trim().length() > 1;
    }

    public final void a() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public final void f_() {
        ++this.l;
    }

    protected final void a(GuiButton guiButton) {
        if (!guiButton.c) {
            return;
        }
        if (guiButton.b == 0 && this.k.trim().length() > 1) {
            this.k.trim();
            this.b.a((GuiScreen)null);
            this.b.b();
        }
        if (guiButton.b == 1) {
            this.b.a(this.a);
        }
    }

    protected final void a(char c, int n) {
        if (n == 14 && this.k.length() > 0) {
            this.k = this.k.substring(0, this.k.length() - 1);
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:-_'*!\"#%/()=+?[]{}<>".indexOf(c) >= 0 && this.k.length() < 64) {
            this.k = this.k + c;
        }
        ((GuiButton)this.e.get((int)0)).c = this.k.trim().length() > 1;
    }

    public final void a(int n, int n2, float f) {
        this.h();
        C_p.a(this.g, this.i, this.c / 2, 40, 0xFFFFFF);
        int n3 = this.c / 2 - 100;
        int n4 = this.d / 2 - 10;
        C_p.a(n3 - 1, n4 - 1, n3 + 200 + 1, n4 + 20 + 1, -6250336);
        C_p.a(n3, n4, n3 + 200, n4 + 20, -16777216);
        C_p.b(this.g, this.k + (this.l / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 6, 0xE0E0E0);
        super.a(n, n2, f);
    }
}

