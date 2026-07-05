/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public final class C_e
extends C_l {
    private C_c a = new C_c(32, 4);
    private C_c b;
    private C_c c;
    private C_c d;
    private C_c e;
    private C_c f;
    private C_c g;
    private C_c h;
    private C_c i;
    private C_c j;
    private C_c k;

    public C_e() {
        this.a.a(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.a.a(0.0f, 15.0f, -3.0f);
        this.b = new C_c(0, 0);
        this.b.a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.b.a(0.0f, 15.0f, 0.0f);
        this.c = new C_c(0, 12);
        this.c.a(-5.0f, -4.0f, -6.0f, 10, 8, 12, 0.0f);
        this.c.a(0.0f, 15.0f, 9.0f);
        this.d = new C_c(18, 0);
        this.d.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.d.a(-4.0f, 15.0f, 2.0f);
        this.e = new C_c(18, 0);
        this.e.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.e.a(4.0f, 15.0f, 2.0f);
        this.f = new C_c(18, 0);
        this.f.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.f.a(-4.0f, 15.0f, 1.0f);
        this.g = new C_c(18, 0);
        this.g.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.g.a(4.0f, 15.0f, 1.0f);
        this.h = new C_c(18, 0);
        this.h.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.h.a(-4.0f, 15.0f, 0.0f);
        this.i = new C_c(18, 0);
        this.i.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.i.a(4.0f, 15.0f, 0.0f);
        this.j = new C_c(18, 0);
        this.j.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.j.a(-4.0f, 15.0f, -1.0f);
        this.k = new C_c(18, 0);
        this.k.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.k.a(4.0f, 15.0f, -1.0f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.a.a(1.0f);
        this.b.a(1.0f);
        this.c.a(1.0f);
        this.d.a(1.0f);
        this.e.a(1.0f);
        this.f.a(1.0f);
        this.g.a(1.0f);
        this.h.a(1.0f);
        this.i.a(1.0f);
        this.j.a(1.0f);
        this.k.a(1.0f);
    }

    @Override
    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.b = f4 / 57.295776f;
        this.a.a = f5 / 57.295776f;
        this.d.c = -0.7853982f;
        this.e.c = 0.7853982f;
        this.f.c = -0.58119464f;
        this.g.c = 0.58119464f;
        this.h.c = -0.58119464f;
        this.i.c = 0.58119464f;
        this.j.c = -0.7853982f;
        this.k.c = 0.7853982f;
        this.d.b = 0.7853982f;
        this.e.b = -0.7853982f;
        this.f.b = 0.3926991f;
        this.g.b = -0.3926991f;
        this.h.b = -0.3926991f;
        this.i.b = 0.3926991f;
        this.j.b = -0.7853982f;
        this.k.b = 0.7853982f;
        f3 = -(MathHelper.b(f * 0.6662f * 2.0f) * 0.4f) * f2;
        f4 = -(MathHelper.b(f * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * f2;
        f5 = -(MathHelper.b(f * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * f2;
        f6 = -(MathHelper.b(f * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f2;
        float f7 = Math.abs(MathHelper.a(f * 0.6662f) * 0.4f) * f2;
        float f8 = Math.abs(MathHelper.a(f * 0.6662f + (float)Math.PI) * 0.4f) * f2;
        float f9 = Math.abs(MathHelper.a(f * 0.6662f + 1.5707964f) * 0.4f) * f2;
        f = Math.abs(MathHelper.a(f * 0.6662f + 4.712389f) * 0.4f) * f2;
        this.d.b += f3;
        this.e.b -= f3;
        this.f.b += f4;
        this.g.b -= f4;
        this.h.b += f5;
        this.i.b -= f5;
        this.j.b += f6;
        this.k.b -= f6;
        this.d.c += f7;
        this.e.c -= f7;
        this.f.c += f8;
        this.g.c -= f8;
        this.h.c += f9;
        this.i.c -= f9;
        this.j.c += f;
        this.k.c -= f;
    }
}

