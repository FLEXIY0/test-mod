/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;

public class C_ai
extends GuiScreen {
    private String errorMessage;
    private String[] lines;

    public C_ai(String string, String string2) {
        this.errorMessage = string;
        this.lines = string2.split("\n");
    }

    @Override
    public void f_() {
    }

    @Override
    protected void a(char c, int n) {
    }

    @Override
    public void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Back to menu..."));
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.b == 0) {
            this.b.a(new GuiMainMenu());
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_ai.a(0, 0, this.c, this.d, -12574688, -11530224);
        C_ai.a(this.g, this.errorMessage, this.c / 2, this.d / 2 - 60, 0xFFFFFF);
        for (int i = 0; i < this.lines.length; ++i) {
            C_ai.a(this.g, this.lines[i], this.c / 2, this.d / 2 - 40 + i * 10, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }
}

