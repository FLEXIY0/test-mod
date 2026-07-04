/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;
import util.MathHelper;

public class C_v
extends C_k {
    float size;

    public C_v(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        this(c_g, f, f2, f3, f4, f5, f6, 2.0f);
    }

    public C_v(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.k = (float)((double)this.k * (double)0.01f);
        this.l = (float)((double)this.l * (double)0.01f);
        this.m = (float)((double)this.m * (double)0.01f);
        this.l = (float)((double)this.l + 0.2);
        this.W = MathHelper.a((f4 + 0.0f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.X = MathHelper.a((f4 + 0.33333334f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.Y = MathHelper.a((f4 + 0.6666667f) * (float)Math.PI * 2.0f) * 0.65f + 0.35f;
        this.U *= 0.75f;
        this.U *= f7;
        this.size = this.U;
        this.T = 6;
        this.F = false;
        this.P = 128;
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
        this.U = this.size * f7;
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
        this.d(this.k, this.l, this.m);
        if (this.i == this.f) {
            this.k = (float)((double)this.k * 1.1);
            this.m = (float)((double)this.m * 1.1);
        }
        this.k = (float)((double)this.k * (double)0.66f);
        this.l = (float)((double)this.l * (double)0.66f);
        this.m = (float)((double)this.m * (double)0.66f);
        if (this.s) {
            this.k = (float)((double)this.k * (double)0.7f);
            this.m = (float)((double)this.m * (double)0.7f);
        }
    }
}

