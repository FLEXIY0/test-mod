/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;

public class C_am
extends GuiButton {
    public C_am(int n, int n2, int n3) {
        super(n, n2, n3, 20, 20, "");
    }

    @Override
    protected void drawBg(byte by) {
        this.b(this.g, this.i, 0, 86 + by * 20, this.e / 2, this.f);
        this.b(this.g + this.e / 2, this.i, 200 - this.e / 2, 86 + by * 20, this.e / 2, this.f);
    }
}

