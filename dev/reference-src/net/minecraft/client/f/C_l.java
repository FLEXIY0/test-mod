/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.f.C_k;

public class C_l
extends C_k {
    public C_l(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        float f7;
        this.W = f7 = this.G.nextFloat() * 0.1f + 0.2f;
        this.X = f7;
        this.Y = f7;
        this.P = 0;
        this.a(0.02f, 0.02f);
        this.U *= this.G.nextFloat() * 0.6f + 0.5f;
        this.k = (float)((double)this.k * (double)0.02f);
        this.l = (float)((double)this.l * (double)0.02f);
        this.m = (float)((double)this.m * (double)0.02f);
        this.T = (int)(20.0 / (Math.random() * 0.8 + 0.2));
        this.F = true;
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * 0.99);
        this.l = (float)((double)this.l * 0.99);
        this.m = (float)((double)this.m * 0.99);
        this.l = (float)((double)this.l + 1.0E-4);
        if (this.T-- <= 0) {
            this.k();
        }
    }
}

