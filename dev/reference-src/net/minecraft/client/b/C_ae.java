/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;

public class C_ae {
    public C_c signBoard = new C_c(0, 0);
    public C_c signStick;
    public C_c signLeg1;
    public C_c signLeg2;
    public C_c signPole;

    public C_ae() {
        this.signBoard.a(-12.0f, -14.0f, -1.0f, 24, 12, 2, 0.0f);
        this.signStick = new C_c(0, 14);
        this.signStick.a(-1.0f, -2.0f, -1.0f, 2, 14, 2, 0.0f);
        this.signLeg1 = new C_c(0, 14);
        this.signLeg1.a(-8.0f, -24.0f, -1.0f, 2, 10, 2, 0.0f);
        this.signLeg2 = new C_c(0, 14);
        this.signLeg2.a(6.0f, -24.0f, -1.0f, 2, 10, 2, 0.0f);
        this.signPole = new C_c(0, 14);
        this.signPole.a(-1.0f, -24.0f, -1.0f, 2, 10, 2, 0.0f);
    }

    public void renderSign() {
        this.signBoard.a(0.0625f);
        this.signStick.a(0.0625f);
        this.signLeg1.a(0.0625f);
        this.signLeg2.a(0.0625f);
        this.signPole.a(0.0625f);
    }
}

