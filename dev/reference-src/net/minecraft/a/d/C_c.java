/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.d;

import net.minecraft.a.c.Entity;
import net.minecraft.a.d.C_a;

public final class C_c {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public C_a f;
    public Entity g;

    public C_c(int n, int n2, int n3, int n4, C_a c_a) {
        this.a = 0;
        this.b = n;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = new C_a(c_a.a, c_a.b, c_a.c);
    }

    public C_c(Entity c_b) {
        this.a = 1;
        this.g = c_b;
        this.f = new C_a(c_b.h, c_b.i, c_b.j);
    }
}

