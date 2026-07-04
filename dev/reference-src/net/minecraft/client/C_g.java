/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

public final class C_g {
    float a = 20.0f;
    private double d;
    public int b;
    public float c;
    private float e = 1.0f;
    private float f = 0.0f;
    private long g = System.currentTimeMillis();
    private long h = System.nanoTime() / 1000000L;
    private double i = 1.0;

    public C_g(float f) {
    }

    public final void a() {
        double d2;
        long l = System.currentTimeMillis();
        long l2 = l - this.g;
        long l3 = System.nanoTime() / 1000000L;
        if (l2 > 1000L) {
            long l4 = l3 - this.h;
            d2 = (double)l2 / (double)l4;
            this.i += (d2 - this.i) * (double)0.2f;
            this.g = l;
            this.h = l3;
        }
        if (l2 < 0L) {
            this.g = l;
            this.h = l3;
        }
        double d3 = (double)l3 / 1000.0;
        d2 = (d3 - this.d) * this.i;
        this.d = d3;
        if (d2 < 0.0) {
            d2 = 0.0;
        }
        if (d2 > 1.0) {
            d2 = 1.0;
        }
        this.f = (float)((double)this.f + d2 * (double)this.e * (double)this.a);
        this.b = (int)this.f;
        this.f -= (float)this.b;
        if (this.b > 10) {
            this.b = 10;
        }
        this.c = this.f;
    }
}

