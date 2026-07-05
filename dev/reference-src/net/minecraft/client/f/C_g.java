/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public final class C_g
extends C_k {
    private float Z;

    public C_g(net.minecraft.a.a.C_g c_g, float f, float f2, float f3) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.a *= 0.8f;
        this.b *= 0.8f;
        this.O *= 0.8f;
        this.b = this.G.nextFloat() * 0.4f + 0.05f;
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.U *= this.G.nextFloat() * 2.0f + 0.2f;
        this.Z = this.U;
        this.T = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.F = false;
        this.P = 49;
    }

    @Override
    public final float a(float f) {
        return 1.0f;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.S + f) / (float)this.T;
        this.U = this.Z * (1.0f - f7 * f7);
        super.a(c_d, f, f2, f3, f4, f5, f6);
    }

    @Override
    public final void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        float f = (float)this.S / (float)this.T;
        if (this.G.nextFloat() > f) {
            this.d.a("smoke", this.h, this.i, this.j, this.a, this.b, this.O);
        }
        this.b = (float)((double)this.b - 0.03);
        this.d(this.a, this.b, this.O);
        this.a *= 0.999f;
        this.b *= 0.999f;
        this.O *= 0.999f;
        if (this.s) {
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
    }
}

