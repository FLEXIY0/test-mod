/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;

public class C_bk
extends GuiButton {
    public C_bk(int n, int n2, int n3) {
        super(n, n2, n3, 20, 20, "");
    }

    @Override
    protected void drawBg(byte by) {
        by = (byte)(by - 1);
        this.b(this.g, this.i, by * 20, 206, this.e / 2, this.f);
        this.b(this.g + this.e / 2, this.i, 20 + by * 20 - this.e / 2, 206, this.e / 2, this.f);
    }
}

