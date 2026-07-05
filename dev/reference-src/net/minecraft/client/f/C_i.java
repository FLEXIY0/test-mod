/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.d.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public class C_i
extends C_k {
    public C_i(C_g c_g, float f, float f2, float f3) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.a *= 0.3f;
        this.b = (float)Math.random() * 0.2f + 0.1f;
        this.O *= 0.3f;
        this.W = 1.0f;
        this.X = 1.0f;
        this.Y = 1.0f;
        this.P = c_g.theme == 1 ? 18 : (c_g.theme == 4 ? 19 : 16);
        this.a(0.01f, 0.01f);
        this.V = 0.06f;
        this.T = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        super.a(c_d, f, f2, f3, f4, f5, f6);
    }

    @Override
    public final void b_() {
        C_c c_c;
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.b -= this.V;
        this.d(this.a, this.b, this.O);
        this.a *= 0.98f;
        this.b *= 0.98f;
        this.O *= 0.98f;
        if (this.T-- <= 0) {
            this.k();
        }
        if (this.s) {
            if (Math.random() < 0.5) {
                this.k();
            }
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
        if ((c_c = this.d.f((int)this.h, (int)this.i, (int)this.j)).d() || c_c.a()) {
            this.k();
        }
    }
}

