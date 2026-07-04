/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiScreen;

public final class C_c
extends GuiScreen {
    private String a;
    private String i;

    public C_c(String string, String string2) {
        this.a = string;
        this.i = string2;
    }

    @Override
    public final void b() {
    }

    @Override
    public final void a(int n, int n2, float f) {
        C_c.a(0, 0, this.c, this.d, -12574688, -11530224);
        C_c.a(this.g, this.a, this.c / 2, 90, 0xFFFFFF);
        C_c.a(this.g, this.i, this.c / 2, 110, 0xFFFFFF);
        super.a(n, n2, f);
    }

    @Override
    protected final void a(char c, int n) {
    }
}

