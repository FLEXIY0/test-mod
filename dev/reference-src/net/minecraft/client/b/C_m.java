/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_g;

public final class C_m
extends C_g {
    public C_m(float f) {
        this(f, 0.0f);
    }

    private C_m(float f, float f2) {
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

    public C_m() {
        this(0.0f);
        this.d = new C_c(40, 16);
        this.d.a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.d.a(-5.0f, 2.0f, 0.0f);
        this.e = new C_c(40, 16);
        this.e.d = true;
        this.e.a(-1.0f, -2.0f, -1.0f, 2, 12, 2, 0.0f);
        this.e.a(5.0f, 2.0f, 0.0f);
        this.f = new C_c(0, 16);
        this.f.a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.f.a(-2.0f, 12.0f, 0.0f);
        this.g = new C_c(0, 16);
        this.g.d = true;
        this.g.a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
        this.g.a(2.0f, 12.0f, 0.0f);
    }
}

