/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jorbis.Lookup;

class Lsp {
    static final float M_PI = (float)Math.PI;

    Lsp() {
    }

    static void lsp_to_curve(float[] fArray, int[] nArray, int n, int n2, float[] fArray2, int n3, float f, float f2) {
        float f3 = (float)Math.PI / (float)n2;
        for (n2 = 0; n2 < n3; ++n2) {
            fArray2[n2] = Lookup.coslook(fArray2[n2]);
        }
        int n4 = n3 / 2 << 1;
        n2 = 0;
        while (n2 < n) {
            int n5;
            int n6 = nArray[n2];
            float f4 = 0.70710677f;
            float f5 = 0.70710677f;
            float f6 = Lookup.coslook(f3 * (float)n6);
            for (n5 = 0; n5 < n4; n5 += 2) {
                f5 *= fArray2[n5] - f6;
                f4 *= fArray2[n5 + 1] - f6;
            }
            if ((n3 & 1) != 0) {
                f5 *= fArray2[n3 - 1] - f6;
                f5 *= f5;
                f4 *= f4 * (1.0f - f6 * f6);
            } else {
                f5 *= f5 * (f6 + 1.0f);
                f4 *= f4 * (1.0f - f6);
            }
            f5 = f4 + f5;
            n5 = Float.floatToIntBits(f5);
            int n7 = Integer.MAX_VALUE & n5;
            int n8 = 0;
            if (n7 < 2139095040 && n7 != 0) {
                if (n7 < 0x800000) {
                    f5 = (float)((double)f5 * 3.3554432E7);
                    n5 = Float.floatToIntBits(f5);
                    n7 = Integer.MAX_VALUE & n5;
                    n8 = -25;
                }
                n8 += (n7 >>> 23) - 126;
                n5 = n5 & 0x807FFFFF | 0x3F000000;
                f5 = Float.intBitsToFloat(n5);
            }
            f5 = Lookup.fromdBlook(f * Lookup.invsqlook(f5) * Lookup.invsq2explook(n8 + n3) - f2);
            do {
                int n9 = n2++;
                fArray[n9] = fArray[n9] * f5;
            } while (n2 < n && nArray[n2] == n6);
        }
    }
}

