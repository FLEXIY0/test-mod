/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public class C_o
extends C_k {
    private boolean isAlive = true;
    float scaleFactor;

    public C_o(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        this(c_g, f, f2, f3, f4, f5, f6, 1.0f);
    }

    public C_o(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.k = (float)((double)this.k * (double)0.1f);
        this.l = (float)((double)this.l * (double)0.1f);
        this.m = (float)((double)this.m * (double)0.1f);
        this.k = (float)((double)this.k + (double)f4 * 0.4);
        this.l = (float)((double)this.l + (double)f5 * 0.4);
        this.m = (float)((double)this.m + (double)f6 * 0.4);
        this.X = this.Y = (float)(Math.random() * (double)0.3f + (double)0.6f);
        this.W = this.Y;
        this.U *= 0.75f;
        this.U *= f7;
        this.scaleFactor = this.U;
        this.T = (int)(6.0 / (Math.random() * 0.8 + 0.6));
        this.T = (int)((float)this.T * f7);
        this.F = false;
        this.P = 130;
        this.b_();
    }

    @Override
    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isAlive) {
            float f7 = ((float)this.S + f) / (float)this.T * 32.0f;
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            this.U = this.scaleFactor * f7;
            super.a(c_d, f, f2, f3, f4, f5, f6);
        }
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.d(this.k, this.l, this.m);
        this.X = (float)((double)this.X * 0.96);
        this.Y = (float)((double)this.Y * 0.9);
        this.k = (float)((double)this.k * (double)0.7f);
        this.l = (float)((double)this.l * (double)0.7f);
        this.m = (float)((double)this.m * (double)0.7f);
        this.l = (float)((double)this.l - (double)0.02f);
        if (this.s) {
            this.k = (float)((double)this.k * (double)0.7f);
            this.m = (float)((double)this.m * (double)0.7f);
        }
    }
}

