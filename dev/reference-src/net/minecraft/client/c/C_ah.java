/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;

public final class C_ah
extends GuiScreen {
    private GuiScreen parent;
    private String warn;
    private String warn2;
    private String message1;
    private String message2;
    private int id;

    public C_ah(GuiScreen guiScreen, String string, String string2, String string3, String string4, int n) {
        this.parent = guiScreen;
        this.warn = string;
        this.warn2 = string2;
        this.message1 = string3;
        this.message2 = string4;
        this.id = n;
    }

    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 60, 100, 20, this.message1));
        this.e.add(new GuiButton(1, this.c / 2 + 5, this.d / 4 + 60, 97, 20, this.message2));
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0) {
                this.parent.buttonAction(true, this.id);
            }
            if (guiButton.b == 1) {
                this.b.a(this.parent);
            }
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_ah.a(this.g, this.warn, this.c / 2, 75, 0xFFFFFF);
        C_ah.a(this.g, this.warn2, this.c / 2, 90, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

