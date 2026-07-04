/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_b
extends C_l {
    public C_c a = new C_c(0, 0);
    public C_c b;
    public C_c c;
    public C_c d;
    public C_c e;
    public C_c f;

    public C_b(int n, float f) {
        this.a.a(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.a.a(0.0f, 18 - n, -6.0f);
        this.b = new C_c(28, 8);
        this.b.a(-5.0f, -10.0f, -7.0f, 10, 16, 8, 0.0f);
        this.b.a(0.0f, 17 - n, 2.0f);
        this.c = new C_c(0, 16);
        this.c.a(-2.0f, 0.0f, -2.0f, 4, n, 4, 0.0f);
        this.c.a(-3.0f, 24 - n, 7.0f);
        this.d = new C_c(0, 16);
        this.d.a(-2.0f, 0.0f, -2.0f, 4, n, 4, 0.0f);
        this.d.a(3.0f, 24 - n, 7.0f);
        this.e = new C_c(0, 16);
        this.e.a(-2.0f, 0.0f, -2.0f, 4, n, 4, 0.0f);
        this.e.a(-3.0f, 24 - n, -5.0f);
        this.f = new C_c(0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, n, 4, 0.0f);
        this.f.a(3.0f, 24 - n, -5.0f);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.a.a(1.0f);
        this.b.a(1.0f);
        this.c.a(1.0f);
        this.d.a(1.0f);
        this.e.a(1.0f);
        this.f.a(1.0f);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.b = f4 / 57.295776f;
        this.a.a = f5 / 57.295776f;
        this.b.a = 1.5707964f;
        this.c.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.d.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.e.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.f.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
    }
}

