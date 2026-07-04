/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.f.C_k;

public class C_q
extends C_k {
    public C_q(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.W = f4;
        this.X = f5;
        this.Y = f6;
        this.V = 0.001f;
        this.U *= 0.67499995f;
        this.T = (int)(16.0 / ((double)this.G.nextFloat() * 0.8 + 0.2)) + 2;
        this.m = 0.0f;
        this.l = 0.0f;
        this.k = 0.0f;
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.P = 7 - this.S * 8 / this.T;
        this.l = (float)((double)this.l - 0.004);
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * 0.9);
        this.l = (float)((double)this.l * 0.9);
        this.m = (float)((double)this.m * 0.9);
        if (this.s) {
            this.k = (float)((double)this.k * 0.7);
            this.m = (float)((double)this.m * 0.7);
        }
    }
}

