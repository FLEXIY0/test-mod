/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.d;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_c;
import net.minecraft.a.d.C_d;
import net.minecraft.a.d.C_e;

public final class C_b {
    private static List<C_b> boundingBoxes = new ArrayList<C_b>();
    private static int numBoundingBoxesInUse = 0;
    private static final ThreadLocal<?> theAABBLocalPool = new C_d();
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;

    public C_b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
    }

    public final C_b a(float f, float f2, float f3) {
        float f4 = this.a;
        float f5 = this.b;
        float f6 = this.c;
        float f7 = this.d;
        float f8 = this.e;
        float f9 = this.f;
        if (f < 0.0f) {
            f4 += f;
        }
        if (f > 0.0f) {
            f7 += f;
        }
        if (f2 < 0.0f) {
            f5 += f2;
        }
        if (f2 > 0.0f) {
            f8 += f2;
        }
        if (f3 < 0.0f) {
            f6 += f3;
        }
        if (f3 > 0.0f) {
            f9 += f3;
        }
        return new C_b(f4, f5, f6, f7, f8, f9);
    }

    public final C_b b(float f, float f2, float f3) {
        if (this.b > this.e) {
            throw new IllegalArgumentException("NOOOOOO!");
        }
        float f4 = this.a - f;
        float f5 = this.b - f2;
        float f6 = this.c - f3;
        return new C_b(f4, f5, f6, f += this.d, f2 += this.e, f3 += this.f);
    }

    public final float a(C_b c_b, float f) {
        if (c_b.e > this.b && c_b.b < this.e) {
            if (c_b.f > this.c && c_b.c < this.f) {
                float f2;
                if (f > 0.0f && c_b.d <= this.a) {
                    float f3;
                    f2 = this.a - c_b.d;
                    if (f3 < f) {
                        f = f2;
                    }
                }
                if (f < 0.0f && c_b.a >= this.d) {
                    float f4;
                    f2 = this.d - c_b.a;
                    if (f4 > f) {
                        f = f2;
                    }
                }
                return f;
            }
            return f;
        }
        return f;
    }

    public final float b(C_b c_b, float f) {
        if (c_b.d > this.a && c_b.a < this.d) {
            if (c_b.f > this.c && c_b.c < this.f) {
                float f2;
                if (f > 0.0f && c_b.e <= this.b) {
                    float f3;
                    f2 = this.b - c_b.e;
                    if (f3 < f) {
                        f = f2;
                    }
                }
                if (f < 0.0f && c_b.b >= this.e) {
                    float f4;
                    f2 = this.e - c_b.b;
                    if (f4 > f) {
                        f = f2;
                    }
                }
                return f;
            }
            return f;
        }
        return f;
    }

    public final float c(C_b c_b, float f) {
        if (c_b.d > this.a && c_b.a < this.d) {
            if (c_b.e > this.b && c_b.b < this.e) {
                float f2;
                if (f > 0.0f && c_b.f <= this.c) {
                    float f3;
                    f2 = this.c - c_b.f;
                    if (f3 < f) {
                        f = f2;
                    }
                }
                if (f < 0.0f && c_b.c >= this.f) {
                    float f4;
                    f2 = this.f - c_b.c;
                    if (f4 > f) {
                        f = f2;
                    }
                }
                return f;
            }
            return f;
        }
        return f;
    }

    public final boolean a(C_b c_b) {
        return c_b.d >= this.a && c_b.a <= this.d ? (c_b.e >= this.b && c_b.b <= this.e ? c_b.f >= this.c && c_b.c <= this.f : false) : false;
    }

    public final void c(float f, float f2, float f3) {
        this.a += f;
        this.b += f2;
        this.c += f3;
        this.d += f;
        this.e += f2;
        this.f += f3;
    }

    public double getAverageEdgeLength() {
        double d2 = this.d - this.a;
        double d3 = this.e - this.b;
        double d4 = this.f - this.c;
        return (d2 + d3 + d4) / 3.0;
    }

    public C_b getInsetBoundingBox(float f, float f2, float f3) {
        float f4 = this.a + f;
        float f5 = this.b + f2;
        float f6 = this.c + f3;
        float f7 = this.d - f;
        float f8 = this.e - f2;
        float f9 = this.f - f3;
        return new C_b(f4, f5, f6, f7, f8, f9);
    }

    public final C_b a() {
        return new C_b(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public C_b cloneMove(float f, float f2, float f3) {
        return new C_b(this.a + f, this.b + f2, this.c + f3, this.d + f, this.e + f2, this.f + f3);
    }

    public final C_c a(C_a c_a, C_a c_a2) {
        C_a c_a3 = c_a.a(c_a2, this.a);
        C_a c_a4 = c_a.a(c_a2, this.d);
        C_a c_a5 = c_a.b(c_a2, this.b);
        C_a c_a6 = c_a.b(c_a2, this.e);
        C_a c_a7 = c_a.c(c_a2, this.c);
        c_a2 = c_a.c(c_a2, this.f);
        if (!this.a(c_a3)) {
            c_a3 = null;
        }
        if (!this.a(c_a4)) {
            c_a4 = null;
        }
        if (!this.b(c_a5)) {
            c_a5 = null;
        }
        if (!this.b(c_a6)) {
            c_a6 = null;
        }
        if (!this.c(c_a7)) {
            c_a7 = null;
        }
        if (!this.c(c_a2)) {
            c_a2 = null;
        }
        C_a c_a8 = null;
        if (c_a3 != null) {
            c_a8 = c_a3;
        }
        if (c_a4 != null && (c_a8 == null || c_a.c(c_a4) < c_a.c(c_a8))) {
            c_a8 = c_a4;
        }
        if (c_a5 != null && (c_a8 == null || c_a.c(c_a5) < c_a.c(c_a8))) {
            c_a8 = c_a5;
        }
        if (c_a6 != null && (c_a8 == null || c_a.c(c_a6) < c_a.c(c_a8))) {
            c_a8 = c_a6;
        }
        if (c_a7 != null && (c_a8 == null || c_a.c(c_a7) < c_a.c(c_a8))) {
            c_a8 = c_a7;
        }
        if (c_a2 != null && (c_a8 == null || c_a.c(c_a2) < c_a.c(c_a8))) {
            c_a8 = c_a2;
        }
        if (c_a8 == null) {
            return null;
        }
        int n = -1;
        if (c_a8 == c_a3) {
            n = 4;
        }
        if (c_a8 == c_a4) {
            n = 5;
        }
        if (c_a8 == c_a5) {
            n = 0;
        }
        if (c_a8 == c_a6) {
            n = 1;
        }
        if (c_a8 == c_a7) {
            n = 2;
        }
        if (c_a8 == c_a2) {
            n = 3;
        }
        return new C_c(0, 0, 0, n, c_a8);
    }

    private boolean a(C_a c_a) {
        return c_a == null ? false : c_a.b >= this.b && c_a.b <= this.e && c_a.c >= this.c && c_a.c <= this.f;
    }

    private boolean b(C_a c_a) {
        return c_a == null ? false : c_a.a >= this.a && c_a.a <= this.d && c_a.c >= this.c && c_a.c <= this.f;
    }

    private boolean c(C_a c_a) {
        return c_a == null ? false : c_a.a >= this.a && c_a.a <= this.d && c_a.b >= this.b && c_a.b <= this.e;
    }

    public boolean isVecInside(C_a c_a) {
        return c_a.a > this.a && c_a.a < this.d ? (c_a.b > this.b && c_a.b < this.e ? c_a.c > this.c && c_a.c < this.f : false) : false;
    }

    public static C_e getAABBPool() {
        return (C_e)theAABBLocalPool.get();
    }

    public C_b setBounds(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        return this;
    }

    public static C_b getBoundingBox(float f, float f2, float f3, float f4, float f5, float f6) {
        return new C_b(f, f2, f3, f4, f5, f6);
    }

    public static C_b getBoundingBoxFromPool(float f, float f2, float f3, float f4, float f5, float f6) {
        if (numBoundingBoxesInUse >= boundingBoxes.size()) {
            boundingBoxes.add(C_b.getBoundingBox(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        return boundingBoxes.get(numBoundingBoxesInUse++).setBounds(f, f2, f3, f4, f5, f6);
    }
}

