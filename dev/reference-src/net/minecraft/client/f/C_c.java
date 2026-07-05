/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public final class C_c
extends C_k {
    private float Z;

    public C_c(World c_g, float f, float f2, float f3) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.a *= 0.01f;
        this.b *= 0.01f;
        this.O *= 0.01f;
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.Z = this.U;
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.T = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.F = true;
        this.P = 48;
    }

    public C_c(World c_g, float f, float f2, float f3, int n) {
        this(c_g, f, f2, f3);
        this.a *= 0.01f;
        this.b *= 0.01f;
        this.O *= 0.01f;
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.G.nextFloat();
        this.Z = this.U;
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.T = n;
        this.F = true;
        this.P = 48;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.S + f) / (float)this.T;
        this.U = this.Z * (1.0f - f7 * f7 * 0.5f);
        super.a(c_d, f, f2, f3, f4, f5, f6);
    }

    @Override
    public final float a(float f) {
        float f2;
        float f3 = ((float)this.S + f) / (float)this.T;
        if (f2 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return super.a(f) * f3 + (1.0f - f3);
    }

    @Override
    public final void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.d(this.a, this.b, this.O);
        this.a *= 0.96f;
        this.b *= 0.96f;
        this.O *= 0.96f;
        if (this.s) {
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
    }
}

