/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;

public class C_as
extends GuiButton {
    public boolean isLocked;

    public C_as(int n, int n2, int n3) {
        super(n, n2, n3, 20, 20, "");
    }

    @Override
    protected void drawBg(byte by) {
        if (this.isLocked) {
            this.b(this.g, this.i, 0, 146 + by * 20, this.e / 2, this.f);
            this.b(this.g + this.e / 2, this.i, 20 - this.e / 2, 146 + by * 20, this.e / 2, this.f);
        } else {
            this.b(this.g, this.i, 20, 146 + by * 20, this.e / 2, this.f);
            this.b(this.g + this.e / 2, this.i, 40 - this.e / 2, 146 + by * 20, this.e / 2, this.f);
        }
    }
}

