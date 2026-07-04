/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public class C_z
extends C_k {
    private int textureOffset = 140;

    public C_z(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.l = (float)((double)this.l * (double)0.2f);
        if ((double)f4 == 0.0 && (double)f6 == 0.0) {
            this.k = (float)((double)this.k * (double)0.1f);
            this.m = (float)((double)this.m * (double)0.1f);
        }
        this.U *= 0.75f;
        this.T = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.F = false;
    }

    @Override
    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.S + f) / (float)this.T * 32.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        super.a(c_d, f, f2, f3, f4, f5, f6);
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.P = this.textureOffset + (7 - this.S * 8 / this.T);
        this.l = (float)((double)this.l + 0.004);
        this.d(this.k, this.l, this.m);
        if (this.i == this.f) {
            this.k = (float)((double)this.k * 1.1);
            this.m = (float)((double)this.m * 1.1);
        }
        this.k = (float)((double)this.k * (double)0.96f);
        this.l = (float)((double)this.l * (double)0.96f);
        this.m = (float)((double)this.m * (double)0.96f);
        if (this.s) {
            this.k = (float)((double)this.k * (double)0.7f);
            this.m = (float)((double)this.m * (double)0.7f);
        }
    }

    public void setTextureOffset(int n) {
        this.textureOffset = n;
    }
}

