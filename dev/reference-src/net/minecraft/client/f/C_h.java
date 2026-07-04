/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public final class C_h
extends C_k {
    public C_h(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.a = f4 + (float)(Math.random() * 2.0 - 1.0) * 0.05f;
        this.b = f5 + (float)(Math.random() * 2.0 - 1.0) * 0.05f;
        this.O = f6 + (float)(Math.random() * 2.0 - 1.0) * 0.05f;
        this.X = this.Y = this.G.nextFloat() * 0.3f + 0.7f;
        this.W = this.Y;
        this.U = this.G.nextFloat() * this.G.nextFloat() * 6.0f + 1.0f;
        this.T = (int)(16.0 / ((double)this.G.nextFloat() * 0.8 + 0.2)) + 2;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
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
        this.P = 7 - (this.S << 3) / this.T;
        this.b = (float)((double)this.b + 0.004);
        if (this.d.l((int)this.h, (int)this.i, (int)this.j)) {
            if (this.d.getWindDirection() == 1) {
                this.a = (float)(((double)this.a + (double)((float)this.d.getWindDirection() * this.d.getWindForce())) * 0.1);
            } else if (this.d.getWindDirection() == -1) {
                this.O = (float)(((double)this.O + (double)((float)this.d.getWindDirection() * this.d.getWindForce())) * 0.1);
            }
        }
        this.d(this.a, this.b, this.O);
        this.a *= 0.9f;
        this.b *= 0.9f;
        this.O *= 0.9f;
        if (this.s) {
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
    }
}

