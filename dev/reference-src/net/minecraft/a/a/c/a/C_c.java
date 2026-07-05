/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c.a;

import java.util.Random;
import net.minecraft.a.a.c.a.C_a;
import net.minecraft.a.a.c.a.C_b;

public final class C_c
extends C_b {
    private C_a[] a;
    private int b;

    public C_c(Random random, int n) {
        this.b = n;
        this.a = new C_a[n];
        for (int i = 0; i < n; ++i) {
            this.a[i] = new C_a(random);
        }
    }

    @Override
    public final double a(double d2, double d3) {
        double d4 = 0.0;
        double d5 = 1.0;
        for (int i = 0; i < this.b; ++i) {
            d4 += this.a[i].a(d2 / d5, d3 / d5) * d5;
            d5 *= 2.0;
        }
        return d4;
    }
}

