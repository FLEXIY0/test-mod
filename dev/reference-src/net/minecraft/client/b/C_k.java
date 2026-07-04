/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public final class C_k
extends C_l {
    private C_c a = new C_c(0, 0);
    private C_c b;
    private C_c c;
    private C_c d;
    private C_c e;
    private C_c f;
    private C_c g;

    public C_k() {
        this.a.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.a.a(0.0f, 4.0f, 0.0f);
        this.b = new C_c(32, 0);
        this.b.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.5f);
        this.b.a(0.0f, 4.0f, 0.0f);
        this.c = new C_c(16, 16);
        this.c.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.c.a(0.0f, 4.0f, 0.0f);
        this.d = new C_c(0, 16);
        this.d.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.d.a(-2.0f, 16.0f, 4.0f);
        this.e = new C_c(0, 16);
        this.e.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.e.a(2.0f, 16.0f, 4.0f);
        this.f = new C_c(0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.f.a(-2.0f, 16.0f, -4.0f);
        this.g = new C_c(0, 16);
        this.g.a(-2.0f, 0.0f, -2.0f, 4, 6, 4, 0.0f);
        this.g.a(2.0f, 16.0f, -4.0f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.a.a(1.0f);
        this.c.a(1.0f);
        this.d.a(1.0f);
        this.e.a(1.0f);
        this.f.a(1.0f);
        this.g.a(1.0f);
    }

    @Override
    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.b = f4 / 57.295776f;
        this.a.a = f5 / 57.295776f;
        this.d.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.e.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.f.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.g.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
    }
}

