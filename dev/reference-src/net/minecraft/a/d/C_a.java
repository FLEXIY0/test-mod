/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.d;

import util.MathHelper;

public final class C_a {
    public float a;
    public float b;
    public float c;

    public C_a(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public final C_a a(C_a c_a) {
        return new C_a(this.a - c_a.a, this.b - c_a.b, this.c - c_a.c);
    }

    public final C_a a() {
        float f = MathHelper.c(this.a * this.a + this.b * this.b + this.c * this.c);
        return new C_a(this.a / f, this.b / f, this.c / f);
    }

    public final C_a a(float f, float f2, float f3) {
        return new C_a(this.a + f, this.b + f2, this.c + f3);
    }

    public double getIntermediateVector(C_a c_a) {
        return this.a * c_a.a + this.b * c_a.b + this.c * c_a.c;
    }

    public final float b(C_a c_a) {
        float f = c_a.a - this.a;
        float f2 = c_a.b - this.b;
        float f3 = c_a.c - this.c;
        return MathHelper.c(f * f + f2 * f2 + f3 * f3);
    }

    public final float c(C_a c_a) {
        float f = c_a.a - this.a;
        float f2 = c_a.b - this.b;
        float f3 = c_a.c - this.c;
        return f * f + f2 * f2 + f3 * f3;
    }

    public final C_a a(C_a c_a, float f) {
        C_a c_a2;
        float f2 = c_a.a - this.a;
        float f3 = c_a.b - this.b;
        float f4 = c_a.c - this.c;
        if (f2 * f2 < 1.0E-7f) {
            c_a2 = null;
        } else {
            float f5;
            f = (f - this.a) / f2;
            c_a2 = f5 >= 0.0f && f <= 1.0f ? new C_a(this.a + f2 * f, this.b + f3 * f, this.c + f4 * f) : null;
        }
        return c_a2;
    }

    public final C_a b(C_a c_a, float f) {
        C_a c_a2;
        float f2 = c_a.a - this.a;
        float f3 = c_a.b - this.b;
        float f4 = c_a.c - this.c;
        if (f3 * f3 < 1.0E-7f) {
            c_a2 = null;
        } else {
            float f5;
            f = (f - this.b) / f3;
            c_a2 = f5 >= 0.0f && f <= 1.0f ? new C_a(this.a + f2 * f, this.b + f3 * f, this.c + f4 * f) : null;
        }
        return c_a2;
    }

    public final C_a c(C_a c_a, float f) {
        C_a c_a2;
        float f2;
        float f3 = c_a.a - this.a;
        float f4 = c_a.b - this.b;
        float f5 = c_a.c - this.c;
        if (f2 * f5 < 1.0E-7f) {
            c_a2 = null;
        } else {
            float f6;
            f = (f - this.c) / f5;
            c_a2 = f6 >= 0.0f && f <= 1.0f ? new C_a(this.a + f3 * f, this.b + f4 * f, this.c + f5 * f) : null;
        }
        return c_a2;
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }

    public void rotateAroundX(float f) {
        float f2 = MathHelper.b(f);
        float f3 = MathHelper.a(f);
        double d2 = this.a;
        double d3 = (double)this.b * (double)f2 + (double)this.c * (double)f3;
        double d4 = (double)this.c * (double)f2 - (double)this.b * (double)f3;
        this.a = (float)d2;
        this.b = (float)d3;
        this.c = (float)d4;
    }

    public void rotateAroundY(float f) {
        float f2 = MathHelper.b(f);
        float f3 = MathHelper.a(f);
        double d2 = (double)this.a * (double)f2 + (double)this.c * (double)f3;
        double d3 = this.b;
        double d4 = (double)this.c * (double)f2 - (double)this.a * (double)f3;
        this.a = (float)d2;
        this.b = (float)d3;
        this.c = (float)d4;
    }

    public void rotateAroundZ(float f) {
        float f2 = MathHelper.b(f);
        float f3 = MathHelper.a(f);
        double d2 = (double)this.a * (double)f2 + (double)this.b * (double)f3;
        double d3 = (double)this.b * (double)f2 - (double)this.a * (double)f3;
        double d4 = this.c;
        this.a = (float)d2;
        this.b = (float)d3;
        this.c = (float)d4;
    }

    public double lengthVector() {
        return MathHelper.c(this.a * this.a + this.b * this.b + this.c * this.c);
    }
}

