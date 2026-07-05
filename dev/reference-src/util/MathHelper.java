/*
 * Decompiled with CFR 0.152.
 */
package util;

public final class MathHelper {
    private static float[] a = new float[65536];

    public static final float a(float f) {
        return a[(int)(f * 10430.378f) & 0xFFFF];
    }

    public static final float b(float f) {
        return a[(int)(f * 10430.378f + 16384.0f) & 0xFFFF];
    }

    public static final float c(float f) {
        return (float)Math.sqrt(f);
    }

    public static final float sqrt_double(double d2) {
        return (float)Math.sqrt(d2);
    }

    public static int d(float f) {
        int n = (int)f;
        return f < (float)n ? n - 1 : n;
    }

    public static int a(double d2) {
        int n = (int)d2;
        return d2 < (double)n ? n - 1 : n;
    }

    public static int ceil_float(float f) {
        int n = (int)f;
        return f > (float)n ? n + 1 : n;
    }

    public static int ceil_double(double d2) {
        int n = (int)d2;
        return d2 > (double)n ? n + 1 : n;
    }

    public static float e(float f) {
        return f >= 0.0f ? f : -f;
    }

    public static float abs_max(float f, float f2) {
        if (f < 0.0f) {
            f = -f;
        }
        if (f2 < 0.0f) {
            f2 = -f2;
        }
        return f > f2 ? f : f2;
    }

    public static float clamp(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    static {
        for (int i = 0; i < 65536; ++i) {
            MathHelper.a[i] = (float)Math.sin((double)i * Math.PI * 2.0 / 65536.0);
        }
    }
}

