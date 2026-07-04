/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.a;

import net.minecraft.a.a.a.C_a;

public final class C_d {
    private C_a[] a = new C_a[1024];
    private int b = 0;

    public final C_a a(C_a c_a) {
        if (c_a.e >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.b == this.a.length) {
            C_a[] c_aArray = new C_a[this.b << 1];
            System.arraycopy(this.a, 0, c_aArray, 0, this.b);
            this.a = c_aArray;
        }
        this.a[this.b] = c_a;
        c_a.e = this.b;
        this.a(this.b++);
        return c_a;
    }

    public final void a() {
        this.b = 0;
    }

    public final C_a b() {
        C_a c_a = this.a[0];
        this.a[0] = this.a[--this.b];
        this.a[this.b] = null;
        if (this.b > 0) {
            this.b(0);
        }
        c_a.e = -1;
        return c_a;
    }

    public final void a(C_a c_a, float f) {
        float f2 = c_a.h;
        c_a.h = f;
        if (f < f2) {
            this.a(c_a.e);
        } else {
            this.b(c_a.e);
        }
    }

    private void a(int n) {
        C_a c_a = this.a[n];
        float f = c_a.h;
        while (n > 0) {
            int n2 = n - 1 >> 1;
            C_a c_a2 = this.a[n2];
            if (f >= c_a2.h) break;
            this.a[n] = c_a2;
            c_a2.e = n;
            n = n2;
        }
        this.a[n] = c_a;
        c_a.e = n;
    }

    private void b(int n) {
        C_a c_a = this.a[n];
        float f = c_a.h;
        while (true) {
            float f2;
            C_a c_a2;
            int n2 = 1 + (n << 1);
            int n3 = n2 + 1;
            if (n2 >= this.b) break;
            C_a c_a3 = this.a[n2];
            float f3 = c_a3.h;
            if (n3 >= this.b) {
                c_a2 = null;
                f2 = Float.POSITIVE_INFINITY;
            } else {
                c_a2 = this.a[n3];
                f2 = c_a2.h;
            }
            if (f3 < f2) {
                if (f3 >= f) break;
                this.a[n] = c_a3;
                c_a3.e = n;
                n = n2;
                continue;
            }
            if (f2 >= f) break;
            this.a[n] = c_a2;
            c_a2.e = n;
            n = n3;
        }
        this.a[n] = c_a;
        c_a.e = n;
    }

    public final boolean c() {
        return this.b == 0;
    }
}

