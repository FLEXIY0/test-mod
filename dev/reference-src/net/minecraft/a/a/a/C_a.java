/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.a;

import util.MathHelper;

public final class C_a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    int e = -1;
    float f;
    float g;
    float h;
    C_a i;
    public boolean j = false;

    public C_a(int n, int n2, int n3) {
        this.a = n;
        this.b = n2;
        this.c = n3;
        this.d = n | n2 << 10 | n3 << 20;
    }

    public final float a(C_a c_a) {
        float f = c_a.a - this.a;
        float f2 = c_a.b - this.b;
        float f3 = c_a.c - this.c;
        return MathHelper.c(f * f + f2 * f2 + f3 * f3);
    }

    public final boolean equals(Object object) {
        return ((C_a)object).d == this.d;
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean a() {
        return this.e >= 0;
    }

    public final String toString() {
        return this.a + ", " + this.b + ", " + this.c;
    }
}

