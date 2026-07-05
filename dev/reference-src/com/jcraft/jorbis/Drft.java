/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

class Drft {
    int n;
    float[] trigcache;
    int[] splitcache;
    static int[] ntryh = new int[]{4, 2, 3, 5};
    static float tpi = (float)Math.PI * 2;
    static float hsqt2 = 0.70710677f;
    static float taui = 0.8660254f;
    static float taur = -0.5f;
    static float sqrt2 = 1.4142135f;

    Drft() {
    }

    void backward(float[] fArray) {
        if (this.n == 1) {
            return;
        }
        Drft.drftb1(this.n, fArray, this.trigcache, this.trigcache, this.n, this.splitcache);
    }

    void init(int n) {
        this.n = n;
        this.trigcache = new float[n * 3];
        this.splitcache = new int[32];
        Drft.fdrffti(n, this.trigcache, this.splitcache);
    }

    void clear() {
        if (this.trigcache != null) {
            this.trigcache = null;
        }
        if (this.splitcache != null) {
            this.splitcache = null;
        }
    }

    static void drfti1(int n, float[] fArray, int n2, int[] nArray) {
        int n3 = 0;
        int n4 = -1;
        int n5 = n;
        int n6 = 0;
        int n7 = 101;
        block5: while (true) {
            switch (n7) {
                case 101: {
                    n3 = ++n4 < 4 ? ntryh[n4] : (n3 += 2);
                }
                case 104: {
                    int n8;
                    n7 = n5 / n3;
                    int n9 = n5 - n3 * n7;
                    if (n9 != 0) {
                        n7 = 101;
                        continue block5;
                    }
                    nArray[++n6 + 1] = n3;
                    n5 = n7;
                    if (n3 != 2) {
                        n7 = 107;
                        continue block5;
                    }
                    if (n6 == 1) {
                        n7 = 107;
                        continue block5;
                    }
                    for (n8 = 1; n8 < n6; ++n8) {
                        n7 = n6 - n8 + 1;
                        nArray[n7 + 1] = nArray[n7];
                    }
                    nArray[2] = 2;
                }
                case 107: {
                    int n8;
                    if (n5 != 1) {
                        n7 = 104;
                        continue block5;
                    }
                    nArray[0] = n;
                    nArray[1] = n6;
                    float f = tpi / (float)n;
                    int n10 = 0;
                    int n11 = n6 - 1;
                    int n12 = 1;
                    if (n11 == 0) {
                        return;
                    }
                    for (n6 = 0; n6 < n11; ++n6) {
                        n3 = nArray[n6 + 2];
                        int n13 = 0;
                        int n14 = n12 * n3;
                        int n15 = n / n14;
                        int n16 = n3 - 1;
                        for (n4 = 0; n4 < n16; ++n4) {
                            n8 = n10;
                            float f2 = (float)(n13 += n12) * f;
                            float f3 = 0.0f;
                            for (int i = 2; i < n15; i += 2) {
                                float f4 = (f3 += 1.0f) * f2;
                                fArray[n2 + n8++] = (float)Math.cos(f4);
                                fArray[n2 + n8++] = (float)Math.sin(f4);
                            }
                            n10 += n15;
                        }
                        n12 = n14;
                    }
                    break block5;
                }
                default: {
                    continue block5;
                }
            }
            break;
        }
    }

    static void fdrffti(int n, float[] fArray, int[] nArray) {
        if (n == 1) {
            return;
        }
        Drft.drfti1(n, fArray, n, nArray);
    }

    static void dradf2(int n, int n2, float[] fArray, float[] fArray2, float[] fArray3, int n3) {
        int n4;
        int n5;
        int n6 = 0;
        int n7 = n5 = n2 * n;
        int n8 = n << 1;
        for (n4 = 0; n4 < n2; ++n4) {
            fArray2[n6 << 1] = fArray[n6] + fArray[n5];
            fArray2[(n6 << 1) + n8 - 1] = fArray[n6] - fArray[n5];
            n6 += n;
            n5 += n;
        }
        if (n < 2) {
            return;
        }
        if (n != 2) {
            n6 = 0;
            n5 = n7;
            for (n4 = 0; n4 < n2; ++n4) {
                n8 = n5;
                int n9 = (n6 << 1) + (n << 1);
                int n10 = n6;
                int n11 = n6 + n6;
                for (int i = 2; i < n; i += 2) {
                    float f = fArray3[n3 + i - 2] * fArray[(n8 += 2) - 1] + fArray3[n3 + i - 1] * fArray[n8];
                    float f2 = fArray3[n3 + i - 2] * fArray[n8] - fArray3[n3 + i - 1] * fArray[n8 - 1];
                    fArray2[n11 += 2] = fArray[n10 += 2] + f2;
                    fArray2[n9 -= 2] = f2 - fArray[n10];
                    fArray2[n11 - 1] = fArray[n10 - 1] + f;
                    fArray2[n9 - 1] = fArray[n10 - 1] - f;
                }
                n6 += n;
                n5 += n;
            }
            if (n % 2 == 1) {
                return;
            }
        }
        n6 = n;
        n8 = n5 = n6 - 1;
        n5 += n7;
        for (n4 = 0; n4 < n2; ++n4) {
            fArray2[n6] = -fArray[n5];
            fArray2[n6 - 1] = fArray[n8];
            n6 += n << 1;
            n5 += n;
            n8 += n;
        }
    }

    static void dradf4(int n, int n2, float[] fArray, float[] fArray2, float[] fArray3, int n3, float[] fArray4, int n4, float[] fArray5, int n5) {
        float f;
        int n6;
        int n7;
        float f2;
        float f3;
        int n8;
        int n9;
        int n10 = n9 = n2 * n;
        int n11 = n9 << 1;
        int n12 = n9 + n11;
        int n13 = 0;
        for (n8 = 0; n8 < n2; ++n8) {
            f3 = fArray[n10] + fArray[n12];
            f2 = fArray[n13] + fArray[n11];
            n7 = n13 << 2;
            fArray2[n7] = f3 + f2;
            fArray2[(n << 2) + n7 - 1] = f2 - f3;
            fArray2[(n7 += n << 1) - 1] = fArray[n13] - fArray[n11];
            fArray2[n7] = fArray[n12] - fArray[n10];
            n10 += n;
            n12 += n;
            n13 += n;
            n11 += n;
        }
        if (n < 2) {
            return;
        }
        if (n != 2) {
            n10 = 0;
            for (n8 = 0; n8 < n2; ++n8) {
                n12 = n10;
                n11 = n10 << 2;
                n6 = n << 1;
                n7 = n6 + n11;
                for (int i = 2; i < n; i += 2) {
                    n13 = n12 += 2;
                    n11 += 2;
                    n7 -= 2;
                    f = fArray3[n3 + i - 2] * fArray[(n13 += n9) - 1] + fArray3[n3 + i - 1] * fArray[n13];
                    float f4 = fArray3[n3 + i - 2] * fArray[n13] - fArray3[n3 + i - 1] * fArray[n13 - 1];
                    float f5 = fArray4[n4 + i - 2] * fArray[(n13 += n9) - 1] + fArray4[n4 + i - 1] * fArray[n13];
                    f2 = fArray4[n4 + i - 2] * fArray[n13] - fArray4[n4 + i - 1] * fArray[n13 - 1];
                    float f6 = fArray5[n5 + i - 2] * fArray[(n13 += n9) - 1] + fArray5[n5 + i - 1] * fArray[n13];
                    float f7 = fArray5[n5 + i - 2] * fArray[n13] - fArray5[n5 + i - 1] * fArray[n13 - 1];
                    f3 = f + f6;
                    float f8 = f6 - f;
                    f = f4 + f7;
                    f6 = f4 - f7;
                    f7 = fArray[n12] + f2;
                    f4 = fArray[n12] - f2;
                    f2 = fArray[n12 - 1] + f5;
                    f5 = fArray[n12 - 1] - f5;
                    fArray2[n11 - 1] = f3 + f2;
                    fArray2[n11] = f + f7;
                    fArray2[n7 - 1] = f5 - f6;
                    fArray2[n7] = f8 - f4;
                    fArray2[n11 + n6 - 1] = f6 + f5;
                    fArray2[n11 + n6] = f8 + f4;
                    fArray2[n7 + n6 - 1] = f2 - f3;
                    fArray2[n7 + n6] = f - f7;
                }
                n10 += n;
            }
            if ((n & 1) != 0) {
                return;
            }
        }
        n10 = n9 + n - 1;
        n12 = n10 + (n9 << 1);
        n13 = n << 2;
        n11 = n;
        n7 = n << 1;
        n6 = n;
        for (n8 = 0; n8 < n2; ++n8) {
            f = -hsqt2 * (fArray[n10] + fArray[n12]);
            f3 = hsqt2 * (fArray[n10] - fArray[n12]);
            fArray2[n11 - 1] = f3 + fArray[n6 - 1];
            fArray2[n11 + n7 - 1] = fArray[n6 - 1] - f3;
            fArray2[n11] = f - fArray[n10 + n9];
            fArray2[n11 + n7] = f + fArray[n10 + n9];
            n10 += n;
            n12 += n;
            n11 += n13;
            n6 += n;
        }
    }

    static void dradfg(int n, int n2, int n3, int n4, float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float[] fArray5, float[] fArray6, int n5) {
        float f = tpi / (float)n2;
        Math.cos(f);
        Math.sin(f);
        while (true) {
            // Infinite loop
        }
    }

    static void drftf1(int n, float[] fArray, float[] fArray2, float[] fArray3, int[] nArray) {
        int n2 = nArray[1];
        int n3 = 1;
        int n4 = n;
        int n5 = n;
        block8: for (int i = 0; i < n2; ++i) {
            int n6 = n2 - i;
            int n7 = nArray[n6 + 1];
            n6 = n4 / n7;
            n4 = n / n4;
            int n8 = n4 * n6;
            n5 -= (n7 - 1) * n4;
            n3 = 1 - n3;
            int n9 = 100;
            block9: while (true) {
                switch (n9) {
                    case 100: {
                        if (n7 != 4) {
                            n9 = 102;
                            continue block9;
                        }
                        n9 = n5 + n4;
                        int n10 = n9 + n4;
                        if (n3 != 0) {
                            Drft.dradf4(n4, n6, fArray2, fArray, fArray3, n5 - 1, fArray3, n9 - 1, fArray3, n10 - 1);
                        } else {
                            Drft.dradf4(n4, n6, fArray, fArray2, fArray3, n5 - 1, fArray3, n9 - 1, fArray3, n10 - 1);
                        }
                        n9 = 110;
                        continue block9;
                    }
                    case 102: {
                        if (n7 != 2) {
                            n9 = 104;
                            continue block9;
                        }
                        if (n3 != 0) {
                            n9 = 103;
                            continue block9;
                        }
                        Drft.dradf2(n4, n6, fArray, fArray2, fArray3, n5 - 1);
                        n9 = 110;
                        continue block9;
                    }
                    case 103: {
                        Drft.dradf2(n4, n6, fArray2, fArray, fArray3, n5 - 1);
                    }
                    case 104: {
                        if (n4 == 1) {
                            n3 = 1 - n3;
                        }
                        if (n3 != 0) {
                            n9 = 109;
                            continue block9;
                        }
                        Drft.dradfg(n4, n7, n6, n8, fArray, fArray, fArray, fArray2, fArray2, fArray3, n5 - 1);
                        n3 = 1;
                        n9 = 110;
                        continue block9;
                    }
                    case 109: {
                        Drft.dradfg(n4, n7, n6, n8, fArray2, fArray2, fArray2, fArray, fArray, fArray3, n5 - 1);
                        n3 = 0;
                    }
                    case 110: {
                        n4 = n6;
                        continue block8;
                    }
                    default: {
                        continue block9;
                    }
                }
                break;
            }
        }
        if (n3 == 1) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            fArray[i] = fArray2[i];
        }
    }

    static void dradb2(int n, int n2, float[] fArray, float[] fArray2, float[] fArray3, int n3) {
        int n4;
        int n5 = n2 * n;
        int n6 = 0;
        int n7 = 0;
        int n8 = (n << 1) - 1;
        for (n4 = 0; n4 < n2; ++n4) {
            fArray2[n6] = fArray[n7] + fArray[n8 + n7];
            fArray2[n6 + n5] = fArray[n7] - fArray[n8 + n7];
            n7 = (n6 += n) << 1;
        }
        if (n < 2) {
            return;
        }
        if (n != 2) {
            n6 = 0;
            n7 = 0;
            for (n4 = 0; n4 < n2; ++n4) {
                n8 = n6;
                int n9 = n7;
                int n10 = n9 + (n << 1);
                int n11 = n5 + n6;
                for (n7 = 2; n7 < n; n7 += 2) {
                    fArray2[(n8 += 2) - 1] = fArray[(n9 += 2) - 1] + fArray[(n10 -= 2) - 1];
                    float f = fArray[n9 - 1] - fArray[n10 - 1];
                    fArray2[n8] = fArray[n9] - fArray[n10];
                    float f2 = fArray[n9] + fArray[n10];
                    fArray2[(n11 += 2) - 1] = fArray3[n3 + n7 - 2] * f - fArray3[n3 + n7 - 1] * f2;
                    fArray2[n11] = fArray3[n3 + n7 - 2] * f2 + fArray3[n3 + n7 - 1] * f;
                }
                n7 = (n6 += n) << 1;
            }
            if (n % 2 == 1) {
                return;
            }
        }
        n7 = n6 = n - 1;
        for (n4 = 0; n4 < n2; ++n4) {
            fArray2[n6] = fArray[n7] + fArray[n7];
            fArray2[n6 + n5] = -(fArray[n7 + 1] + fArray[n7 + 1]);
            n6 += n;
            n7 += n << 1;
        }
    }

    static void dradb3(int n, int n2, float[] fArray, float[] fArray2, float[] fArray3, int n3, float[] fArray4, int n4) {
        float f;
        float f2;
        float f3;
        int n5;
        int n6 = n2 * n;
        int n7 = 0;
        int n8 = n6 << 1;
        int n9 = n << 1;
        int n10 = n + n9;
        int n11 = 0;
        for (n5 = 0; n5 < n2; ++n5) {
            f3 = fArray[n9 - 1] + fArray[n9 - 1];
            f2 = fArray[n11] + taur * f3;
            fArray2[n7] = fArray[n11] + f3;
            f = taui * (fArray[n9] + fArray[n9]);
            fArray2[n7 + n6] = f2 - f;
            fArray2[n7 + n8] = f2 + f;
            n7 += n;
            n9 += n10;
            n11 += n10;
        }
        if (n == 1) {
            return;
        }
        n7 = 0;
        n9 = n << 1;
        for (n5 = 0; n5 < n2; ++n5) {
            int n12 = n7 + (n7 << 1);
            n10 = n11 = n12 + n9;
            int n13 = n7;
            int n14 = n7 + n6;
            int n15 = n14 + n6;
            for (n8 = 2; n8 < n; n8 += 2) {
                n14 += 2;
                n15 += 2;
                f3 = fArray[(n11 += 2) - 1] + fArray[(n10 -= 2) - 1];
                f2 = fArray[(n12 += 2) - 1] + taur * f3;
                fArray2[(n13 += 2) - 1] = fArray[n12 - 1] + f3;
                f = fArray[n11] - fArray[n10];
                f3 = fArray[n12] + taur * f;
                fArray2[n13] = fArray[n12] + f;
                float f4 = taui * (fArray[n11 - 1] - fArray[n10 - 1]);
                f = taui * (fArray[n11] + fArray[n10]);
                float f5 = f2 - f;
                f2 += f;
                f = f3 + f4;
                fArray2[n14 - 1] = fArray3[n3 + n8 - 2] * f5 - fArray3[n3 + n8 - 1] * f;
                fArray2[n14] = fArray3[n3 + n8 - 2] * f + fArray3[n3 + n8 - 1] * f5;
                fArray2[n15 - 1] = fArray4[n4 + n8 - 2] * f2 - fArray4[n4 + n8 - 1] * (f3 -= f4);
                fArray2[n15] = fArray4[n4 + n8 - 2] * f3 + fArray4[n4 + n8 - 1] * f2;
            }
            n7 += n;
        }
    }

    static void dradb4(int n, int n2, float[] fArray, float[] fArray2, float[] fArray3, int n3, float[] fArray4, int n4, float[] fArray5, int n5) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int n6;
        int n7;
        int n8;
        int n9 = n2 * n;
        int n10 = 0;
        int n11 = n << 2;
        int n12 = 0;
        int n13 = n << 1;
        for (n8 = 0; n8 < n2; ++n8) {
            n7 = n12 + n13;
            n6 = n10;
            f5 = fArray[n7 - 1] + fArray[n7 - 1];
            f4 = fArray[n7] + fArray[n7];
            f3 = fArray[n12] - fArray[(n7 += n13) - 1];
            f2 = fArray[n12] + fArray[n7 - 1];
            fArray2[n6] = f2 + f5;
            fArray2[n6 += n9] = f3 - f4;
            fArray2[n6 += n9] = f2 - f5;
            fArray2[n6 + n9] = f3 + f4;
            n10 += n;
            n12 += n11;
        }
        if (n < 2) {
            return;
        }
        if (n != 2) {
            n10 = 0;
            for (n8 = 0; n8 < n2; ++n8) {
                n11 = n10 << 2;
                n7 = n12 = n11 + n13;
                n6 = n12 + n13;
                int n14 = n10;
                for (int i = 2; i < n; i += 2) {
                    n14 += 2;
                    float f6 = fArray[n11 += 2] + fArray[n6 -= 2];
                    f = fArray[n11] - fArray[n6];
                    float f7 = fArray[n12 += 2] - fArray[n7 -= 2];
                    f4 = fArray[n12] + fArray[n7];
                    f3 = fArray[n11 - 1] - fArray[n6 - 1];
                    f2 = fArray[n11 - 1] + fArray[n6 - 1];
                    float f8 = fArray[n12 - 1] - fArray[n7 - 1];
                    f5 = fArray[n12 - 1] + fArray[n7 - 1];
                    fArray2[n14 - 1] = f2 + f5;
                    f5 = f2 - f5;
                    fArray2[n14] = f + f7;
                    f7 = f - f7;
                    f2 = f3 - f4;
                    f3 += f4;
                    f = f6 + f8;
                    f8 = f6 - f8;
                    int n15 = n14 + n9;
                    fArray2[n15 - 1] = fArray3[n3 + i - 2] * f2 - fArray3[n3 + i - 1] * f;
                    fArray2[n15] = fArray3[n3 + i - 2] * f + fArray3[n3 + i - 1] * f2;
                    fArray2[(n15 += n9) - 1] = fArray4[n4 + i - 2] * f5 - fArray4[n4 + i - 1] * f7;
                    fArray2[n15] = fArray4[n4 + i - 2] * f7 + fArray4[n4 + i - 1] * f5;
                    fArray2[(n15 += n9) - 1] = fArray5[n5 + i - 2] * f3 - fArray5[n5 + i - 1] * f8;
                    fArray2[n15] = fArray5[n5 + i - 2] * f8 + fArray5[n5 + i - 1] * f3;
                }
                n10 += n;
            }
            if (n % 2 == 1) {
                return;
            }
        }
        n10 = n;
        n11 = n << 2;
        n12 = n - 1;
        n7 = n + n13;
        for (n8 = 0; n8 < n2; ++n8) {
            n6 = n12;
            float f9 = fArray[n10] + fArray[n7];
            f = fArray[n7] - fArray[n10];
            f3 = fArray[n10 - 1] - fArray[n7 - 1];
            f2 = fArray[n10 - 1] + fArray[n7 - 1];
            fArray2[n6] = f2 + f2;
            fArray2[n6 += n9] = sqrt2 * (f3 - f9);
            fArray2[n6 += n9] = f + f;
            fArray2[n6 + n9] = -sqrt2 * (f3 + f9);
            n12 += n;
            n10 += n11;
            n7 += n11;
        }
    }

    static void dradbg(int n, int n2, int n3, int n4, float[] fArray, float[] fArray2, float[] fArray3, float[] fArray4, float[] fArray5, float[] fArray6, int n5) {
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        int n10 = 0;
        int n11 = 100;
        block10: while (true) {
            switch (n11) {
                case 100: {
                    int n12;
                    int n13;
                    int n14;
                    n8 = n2 * n;
                    n7 = n3 * n;
                    float f3 = tpi / (float)n2;
                    f = (float)Math.cos(f3);
                    f2 = (float)Math.sin(f3);
                    n9 = n - 1 >>> 1;
                    n10 = n2;
                    n6 = n2 + 1 >>> 1;
                    if (n < n3) {
                        n11 = 103;
                        continue block10;
                    }
                    int n15 = 0;
                    int n16 = 0;
                    for (n14 = 0; n14 < n3; ++n14) {
                        n13 = n15;
                        n12 = n16;
                        for (n11 = 0; n11 < n; ++n11) {
                            fArray4[n13] = fArray[n12];
                            ++n13;
                            ++n12;
                        }
                        n15 += n;
                        n16 += n8;
                    }
                    n11 = 106;
                    continue block10;
                }
                case 103: {
                    int n13;
                    int n14;
                    int n16;
                    int n15 = 0;
                    for (n11 = 0; n11 < n; ++n11) {
                        n16 = n15;
                        n13 = n15;
                        for (n14 = 0; n14 < n3; ++n14) {
                            fArray4[n16] = fArray[n13];
                            n16 += n;
                            n13 += n8;
                        }
                        ++n15;
                    }
                }
                case 106: {
                    int n17;
                    int n18;
                    int n19;
                    int n20;
                    int n21;
                    int n22;
                    int n12;
                    int n13;
                    int n14;
                    int n15 = 0;
                    int n16 = n10 * n7;
                    int n23 = n22 = n << 1;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        n20 = n22;
                        for (n14 = 0; n14 < n3; ++n14) {
                            fArray4[n13] = fArray[n20 - 1] + fArray[n20 - 1];
                            fArray4[n12] = fArray[n20] + fArray[n20];
                            n13 += n;
                            n12 += n;
                            n20 += n8;
                        }
                        n22 += n23;
                    }
                    if (n == 1) {
                        n11 = 116;
                        continue block10;
                    }
                    if (n9 < n3) {
                        n11 = 112;
                        continue block10;
                    }
                    n15 = 0;
                    n16 = n10 * n7;
                    n23 = 0;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        n19 = n23 += n << 1;
                        for (n14 = 0; n14 < n3; ++n14) {
                            n22 = n13;
                            n20 = n12;
                            n18 = n19;
                            n17 = n19;
                            for (n11 = 2; n11 < n; n11 += 2) {
                                fArray4[(n22 += 2) - 1] = fArray[(n18 += 2) - 1] + fArray[(n17 -= 2) - 1];
                                fArray4[(n20 += 2) - 1] = fArray[n18 - 1] - fArray[n17 - 1];
                                fArray4[n22] = fArray[n18] - fArray[n17];
                                fArray4[n20] = fArray[n18] + fArray[n17];
                            }
                            n13 += n;
                            n12 += n;
                            n19 += n8;
                        }
                    }
                    n11 = 116;
                    continue block10;
                }
                case 112: {
                    int n24;
                    int n17;
                    int n18;
                    int n19;
                    int n20;
                    int n21;
                    int n22;
                    int n12;
                    int n13;
                    int n14;
                    int n15 = 0;
                    int n16 = n10 * n7;
                    int n23 = 0;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        n19 = n23 += n << 1;
                        n18 = n23;
                        for (n11 = 2; n11 < n; n11 += 2) {
                            n22 = n13 += 2;
                            n20 = n12 += 2;
                            n17 = n19 += 2;
                            n24 = n18 -= 2;
                            for (n14 = 0; n14 < n3; ++n14) {
                                fArray4[n22 - 1] = fArray[n17 - 1] + fArray[n24 - 1];
                                fArray4[n20 - 1] = fArray[n17 - 1] - fArray[n24 - 1];
                                fArray4[n22] = fArray[n17] - fArray[n24];
                                fArray4[n20] = fArray[n17] + fArray[n24];
                                n22 += n;
                                n20 += n;
                                n17 += n8;
                                n24 += n8;
                            }
                        }
                    }
                }
                case 116: {
                    int n24;
                    int n17;
                    int n20;
                    int n21;
                    int n23;
                    int n22;
                    int n12;
                    int n14;
                    int n16;
                    float f4 = 1.0f;
                    float f5 = 0.0f;
                    int n15 = 0;
                    int n18 = n16 = n10 * n4;
                    int n13 = (n2 - 1) * n4;
                    for (n11 = 1; n11 < n6; ++n11) {
                        float f6 = f * f4 - f2 * f5;
                        f5 = f * f5 + f2 * f4;
                        f4 = f6;
                        n12 = n15 += n4;
                        n22 = n16 -= n4;
                        n20 = 0;
                        n23 = n4;
                        int n25 = n13;
                        for (n14 = 0; n14 < n4; ++n14) {
                            fArray3[n12++] = fArray5[n20++] + f4 * fArray5[n23++];
                            fArray3[n22++] = f5 * fArray5[n25++];
                        }
                        float f7 = f4;
                        float f8 = f5;
                        float f9 = f4;
                        float f10 = f5;
                        n20 = n4;
                        n23 = n18 - n4;
                        for (n21 = 2; n21 < n6; ++n21) {
                            n20 += n4;
                            n23 -= n4;
                            float f11 = f7 * f9 - f8 * f10;
                            f10 = f7 * f10 + f8 * f9;
                            f9 = f11;
                            n12 = n15;
                            n22 = n16;
                            n17 = n20;
                            n24 = n23;
                            for (n14 = 0; n14 < n4; ++n14) {
                                int n26 = n12++;
                                fArray3[n26] = fArray3[n26] + f9 * fArray5[n17++];
                                int n27 = n22++;
                                fArray3[n27] = fArray3[n27] + f10 * fArray5[n24++];
                            }
                        }
                    }
                    n15 = 0;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n16 = n15 += n4;
                        n14 = 0;
                        while (n14 < n4) {
                            int n28 = n14++;
                            fArray5[n28] = fArray5[n28] + fArray5[n16++];
                        }
                    }
                    n15 = 0;
                    n16 = n10 * n7;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        for (n14 = 0; n14 < n3; ++n14) {
                            fArray4[n13] = fArray2[n13] - fArray2[n12];
                            fArray4[n12] = fArray2[n13] + fArray2[n12];
                            n13 += n;
                            n12 += n;
                        }
                    }
                    if (n == 1) {
                        n11 = 132;
                        continue block10;
                    }
                    if (n9 < n3) {
                        n11 = 128;
                        continue block10;
                    }
                    n15 = 0;
                    n16 = n10 * n7;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        for (n14 = 0; n14 < n3; ++n14) {
                            n22 = n13;
                            n20 = n12;
                            for (n11 = 2; n11 < n; n11 += 2) {
                                fArray4[(n22 += 2) - 1] = fArray2[n22 - 1] - fArray2[n20 += 2];
                                fArray4[n20 - 1] = fArray2[n22 - 1] + fArray2[n20];
                                fArray4[n22] = fArray2[n22] + fArray2[n20 - 1];
                                fArray4[n20] = fArray2[n22] - fArray2[n20 - 1];
                            }
                            n13 += n;
                            n12 += n;
                        }
                    }
                    n11 = 132;
                    continue block10;
                }
                case 128: {
                    int n20;
                    int n21;
                    int n22;
                    int n12;
                    int n13;
                    int n14;
                    int n15 = 0;
                    int n16 = n10 * n7;
                    for (n21 = 1; n21 < n6; ++n21) {
                        n13 = n15 += n7;
                        n12 = n16 -= n7;
                        for (n11 = 2; n11 < n; n11 += 2) {
                            n22 = n13 += 2;
                            n20 = n12 += 2;
                            for (n14 = 0; n14 < n3; ++n14) {
                                fArray4[n22 - 1] = fArray2[n22 - 1] - fArray2[n20];
                                fArray4[n20 - 1] = fArray2[n22 - 1] + fArray2[n20];
                                fArray4[n22] = fArray2[n22] + fArray2[n20 - 1];
                                fArray4[n20] = fArray2[n22] - fArray2[n20 - 1];
                                n22 += n;
                                n20 += n;
                            }
                        }
                    }
                }
                case 132: {
                    int n21;
                    int n13;
                    int n14;
                    int n16;
                    if (n == 1) {
                        return;
                    }
                    for (n14 = 0; n14 < n4; ++n14) {
                        fArray3[n14] = fArray5[n14];
                    }
                    int n15 = 0;
                    for (n21 = 1; n21 < n2; ++n21) {
                        n16 = n15 += n7;
                        for (n14 = 0; n14 < n3; ++n14) {
                            fArray2[n16] = fArray4[n16];
                            n16 += n;
                        }
                    }
                    if (n9 > n3) {
                        n11 = 139;
                        continue block10;
                    }
                    int n29 = -n - 1;
                    n15 = 0;
                    for (n21 = 1; n21 < n2; ++n21) {
                        n4 = n29 += n;
                        n16 = n15 += n7;
                        for (n11 = 2; n11 < n; n11 += 2) {
                            n4 += 2;
                            n13 = n16 += 2;
                            for (n14 = 0; n14 < n3; ++n14) {
                                fArray2[n13 - 1] = fArray6[n5 + n4 - 1] * fArray4[n13 - 1] - fArray6[n5 + n4] * fArray4[n13];
                                fArray2[n13] = fArray6[n5 + n4 - 1] * fArray4[n13] + fArray6[n5 + n4] * fArray4[n13 - 1];
                                n13 += n;
                            }
                        }
                    }
                    return;
                }
                case 139: {
                    int n21;
                    int n13;
                    int n14;
                    int n16;
                    int n30 = -n - 1;
                    int n15 = 0;
                    for (n21 = 1; n21 < n2; ++n21) {
                        n30 += n;
                        n16 = n15 += n7;
                        for (n14 = 0; n14 < n3; ++n14) {
                            n4 = n30;
                            n13 = n16;
                            for (n11 = 2; n11 < n; n11 += 2) {
                                fArray2[(n13 += 2) - 1] = fArray6[n5 + (n4 += 2) - 1] * fArray4[n13 - 1] - fArray6[n5 + n4] * fArray4[n13];
                                fArray2[n13] = fArray6[n5 + n4 - 1] * fArray4[n13] + fArray6[n5 + n4] * fArray4[n13 - 1];
                            }
                            n16 += n;
                        }
                    }
                    break block10;
                }
                default: {
                    continue block10;
                }
            }
            break;
        }
    }

    static void drftb1(int n, float[] fArray, float[] fArray2, float[] fArray3, int n2, int[] nArray) {
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = nArray[1];
        int n8 = 0;
        int n9 = 1;
        int n10 = 1;
        block7: for (int i = 0; i < n7; ++i) {
            int n11 = 100;
            block8: while (true) {
                switch (n11) {
                    case 100: {
                        n4 = nArray[i + 2];
                        n3 = n4 * n9;
                        n5 = n / n3;
                        n6 = n5 * n9;
                        if (n4 != 4) {
                            n11 = 103;
                            continue block8;
                        }
                        n11 = n10 + n5;
                        int n12 = n11 + n5;
                        if (n8 != 0) {
                            Drft.dradb4(n5, n9, fArray2, fArray, fArray3, n2 + n10 - 1, fArray3, n2 + n11 - 1, fArray3, n2 + n12 - 1);
                        } else {
                            Drft.dradb4(n5, n9, fArray, fArray2, fArray3, n2 + n10 - 1, fArray3, n2 + n11 - 1, fArray3, n2 + n12 - 1);
                        }
                        n8 = 1 - n8;
                        n11 = 115;
                        continue block8;
                    }
                    case 103: {
                        if (n4 != 2) {
                            n11 = 106;
                            continue block8;
                        }
                        if (n8 != 0) {
                            Drft.dradb2(n5, n9, fArray2, fArray, fArray3, n2 + n10 - 1);
                        } else {
                            Drft.dradb2(n5, n9, fArray, fArray2, fArray3, n2 + n10 - 1);
                        }
                        n8 = 1 - n8;
                        n11 = 115;
                        continue block8;
                    }
                    case 106: {
                        if (n4 != 3) {
                            n11 = 109;
                            continue block8;
                        }
                        n11 = n10 + n5;
                        if (n8 != 0) {
                            Drft.dradb3(n5, n9, fArray2, fArray, fArray3, n2 + n10 - 1, fArray3, n2 + n11 - 1);
                        } else {
                            Drft.dradb3(n5, n9, fArray, fArray2, fArray3, n2 + n10 - 1, fArray3, n2 + n11 - 1);
                        }
                        n8 = 1 - n8;
                        n11 = 115;
                        continue block8;
                    }
                    case 109: {
                        if (n8 != 0) {
                            Drft.dradbg(n5, n4, n9, n6, fArray2, fArray2, fArray2, fArray, fArray, fArray3, n2 + n10 - 1);
                        } else {
                            Drft.dradbg(n5, n4, n9, n6, fArray, fArray, fArray, fArray2, fArray2, fArray3, n2 + n10 - 1);
                        }
                        if (n5 == 1) {
                            n8 = 1 - n8;
                        }
                    }
                    case 115: {
                        n9 = n3;
                        n10 += (n4 - 1) * n5;
                        continue block7;
                    }
                    default: {
                        continue block8;
                    }
                }
                break;
            }
        }
        if (n8 == 0) {
            return;
        }
        for (int i = 0; i < n; ++i) {
            fArray[i] = fArray2[i];
        }
    }
}

