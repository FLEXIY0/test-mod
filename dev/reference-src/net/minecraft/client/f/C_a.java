/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.f.C_k;

public final class C_a
extends C_k {
    int type = 0;
    private double raiseSpd = 0.002;

    public C_a(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.W = 1.0f;
        this.X = 1.0f;
        this.Y = 1.0f;
        this.P = 32;
        this.a(0.02f, 0.02f);
        this.U *= this.G.nextFloat() * 0.6f + 0.2f;
        this.a = f4 * 0.2f + (float)(Math.random() * 2.0 - 1.0) * 0.02f;
        this.b = f5 * 0.2f + (float)(Math.random() * 2.0 - 1.0) * 0.02f;
        this.O = f6 * 0.2f + (float)(Math.random() * 2.0 - 1.0) * 0.02f;
        this.type = n;
        double d2 = 8.0;
        this.T = (int)(d2 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.l = (float)((double)this.l + this.raiseSpd);
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * 0.85);
        this.l = (float)((double)this.l * 0.85);
        this.m = (float)((double)this.m * 0.85);
        if (this.T <= 2) {
            this.P = 35;
        }
        if (this.T-- <= 0) {
            this.k();
        }
    }
}

