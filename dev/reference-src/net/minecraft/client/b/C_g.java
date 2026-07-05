/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_h;
import util.MathHelper;

public class C_g
extends C_h {
    public C_g() {
        this(0.0f);
    }

    public C_g(float f) {
        this(f, 0.0f);
    }

    private C_g(float f, float f2) {
        this.a = new C_c(0, 0);
        this.a.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.a.a(0.0f, 0.0f, 0.0f);
        this.b = new C_c(32, 0);
        this.b.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.b.a(0.0f, 0.0f, 0.0f);
        this.c = new C_c(16, 16);
        this.c.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.c.a(0.0f, 0.0f, 0.0f);
        this.d = new C_c(40, 16);
        this.d.a(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.d.a(-5.0f, 2.0f, 0.0f);
        this.e = new C_c(40, 16);
        this.e.d = true;
        this.e.a(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.e.a(5.0f, 2.0f, 0.0f);
        this.f = new C_c(0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.f.a(-2.0f, 12.0f, 0.0f);
        this.g = new C_c(0, 16);
        this.g.d = true;
        this.g.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.g.a(2.0f, 12.0f, 0.0f);
    }

    @Override
    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        super.b(f, f2, f3, f4, f5, f6);
        f = MathHelper.a(0.0f);
        f2 = MathHelper.a(0.0f);
        this.d.c = 0.0f;
        this.e.c = 0.0f;
        this.d.b = -(0.1f - f * 0.6f);
        this.e.b = 0.1f - f * 0.6f;
        this.d.a = -1.5707964f;
        this.e.a = -1.5707964f;
        this.d.a -= f * 1.2f - f2 * 0.4f;
        this.e.a -= f * 1.2f - f2 * 0.4f;
        this.d.c += MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.e.c -= MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.d.a += MathHelper.a(f3 * 0.067f) * 0.05f;
        this.e.a -= MathHelper.a(f3 * 0.067f) * 0.05f;
    }
}

