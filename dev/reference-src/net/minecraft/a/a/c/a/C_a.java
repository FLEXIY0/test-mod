/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c.a;

import java.util.Random;
import net.minecraft.a.a.c.a.C_b;
import util.MathHelper;

public final class C_a
extends C_b {
    private int[] a = new int[512];

    public C_a() {
        this(new Random());
    }

    public C_a(Random random) {
        int n = 0;
        while (n < 256) {
            this.a[n] = n++;
        }
        for (n = 0; n < 256; ++n) {
            int n2 = random.nextInt(256 - n) + n;
            int n3 = this.a[n];
            this.a[n] = this.a[n2];
            this.a[n2] = n3;
            this.a[n + 256] = this.a[n];
        }
    }

    private static double a(double d2) {
        return d2 * d2 * d2 * (d2 * (d2 * 6.0 - 15.0) + 10.0);
    }

    private static double a(double d2, double d3, double d4) {
        return d3 + d2 * (d4 - d3);
    }

    private static double a(int n, double d2, double d3, double d4) {
        double d5;
        double d6 = d5 = (n &= 0xF) < 8 ? d2 : d3;
        double d7 = n < 4 ? d3 : (n != 12 && n != 14 ? d4 : d2);
        return ((n & 1) == 0 ? d5 : -d5) + ((n & 2) == 0 ? d7 : -d7);
    }

    @Override
    public final double a(double d2, double d3) {
        double d4 = 0.0;
        double d5 = d3;
        int n = MathHelper.a(d2) & 0xFF;
        int n2 = MathHelper.a(d3) & 0xFF;
        int n3 = MathHelper.a(0.0) & 0xFF;
        double d6 = d2 - (double)MathHelper.a(d2);
        d5 -= (double)MathHelper.a(d5);
        d4 = 0.0 - (double)MathHelper.a(0.0);
        double d7 = C_a.a(d6);
        double d8 = C_a.a(d5);
        double d9 = C_a.a(d4);
        int n4 = this.a[n] + n2;
        int n5 = this.a[n4] + n3;
        n4 = this.a[n4 + 1] + n3;
        n = this.a[n + 1] + n2;
        n2 = this.a[n] + n3;
        n = this.a[n + 1] + n3;
        return C_a.a(d9, C_a.a(d8, C_a.a(d7, C_a.a(this.a[n5], d6, d5, d4), C_a.a(this.a[n2], d6 - 1.0, d5, d4)), C_a.a(d7, C_a.a(this.a[n4], d6, d5 - 1.0, d4), C_a.a(this.a[n], d6 - 1.0, d5 - 1.0, d4))), C_a.a(d8, C_a.a(d7, C_a.a(this.a[n5 + 1], d6, d5, d4 - 1.0), C_a.a(this.a[n2 + 1], d6 - 1.0, d5, d4 - 1.0)), C_a.a(d7, C_a.a(this.a[n4 + 1], d6, d5 - 1.0, d4 - 1.0), C_a.a(this.a[n + 1], d6 - 1.0, d5 - 1.0, d4 - 1.0))));
    }
}

