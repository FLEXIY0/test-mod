/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

class Mdct {
    int n;
    int log2n;
    float[] trig;
    int[] bitrev;
    float scale;
    float[] _x = new float[1024];
    float[] _w = new float[1024];

    Mdct() {
    }

    void init(int n) {
        int n2;
        this.bitrev = new int[n / 4];
        this.trig = new float[n + n / 4];
        this.log2n = (int)Math.rint(Math.log(n) / Math.log(2.0));
        this.n = n;
        int n3 = 0 + n / 2;
        int n4 = n3 + 1;
        int n5 = n3 + n / 2;
        int n6 = n5 + 1;
        for (n2 = 0; n2 < n / 4; ++n2) {
            this.trig[0 + (n2 << 1)] = (float)Math.cos(Math.PI / (double)n * (double)(n2 * 4));
            this.trig[1 + (n2 << 1)] = (float)(-Math.sin(Math.PI / (double)n * (double)(n2 * 4)));
            this.trig[n3 + (n2 << 1)] = (float)Math.cos(Math.PI / (double)(n * 2) * (double)(n2 * 2 + 1));
            this.trig[n4 + (n2 << 1)] = (float)Math.sin(Math.PI / (double)(n * 2) * (double)(n2 * 2 + 1));
        }
        for (n2 = 0; n2 < n / 8; ++n2) {
            this.trig[n5 + (n2 << 1)] = (float)Math.cos(Math.PI / (double)n * (double)(n2 * 4 + 2));
            this.trig[n6 + (n2 << 1)] = (float)(-Math.sin(Math.PI / (double)n * (double)(n2 * 4 + 2)));
        }
        n2 = (1 << this.log2n - 1) - 1;
        n3 = 1 << this.log2n - 2;
        for (n4 = 0; n4 < n / 8; ++n4) {
            n5 = 0;
            n6 = 0;
            while (n3 >>> n6 != 0) {
                if ((n3 >>> n6 & n4) != 0) {
                    n5 |= 1 << n6;
                }
                ++n6;
            }
            this.bitrev[n4 << 1] = ~n5 & n2;
            this.bitrev[(n4 << 1) + 1] = n5;
        }
        this.scale = 4.0f / (float)n;
    }

    void clear() {
    }

    void forward(float[] fArray, float[] fArray2) {
    }

    synchronized void backward(float[] fArray, float[] fArray2) {
        int n;
        if (this._x.length < this.n / 2) {
            this._x = new float[this.n / 2];
        }
        if (this._w.length < this.n / 2) {
            this._w = new float[this.n / 2];
        }
        float[] fArray3 = this._x;
        float[] fArray4 = this._w;
        int n2 = this.n >>> 1;
        int n3 = this.n >>> 2;
        int n4 = this.n >>> 3;
        int n5 = 1;
        int n6 = 0;
        int n7 = n2;
        for (n = 0; n < n4; ++n) {
            fArray3[n6++] = -fArray[n5 + 2] * this.trig[(n7 -= 2) + 1] - fArray[n5] * this.trig[n7];
            fArray3[n6++] = fArray[n5] * this.trig[n7 + 1] - fArray[n5 + 2] * this.trig[n7];
            n5 += 4;
        }
        n5 = n2 - 4;
        for (n = 0; n < n4; ++n) {
            fArray3[n6++] = fArray[n5] * this.trig[(n7 -= 2) + 1] + fArray[n5 + 2] * this.trig[n7];
            fArray3[n6++] = fArray[n5] * this.trig[n7] - fArray[n5 + 2] * this.trig[n7 + 1];
            n5 -= 4;
        }
        float[] fArray5 = this.mdct_kernel(fArray3, fArray4, this.n, n2, n3, n4);
        n6 = 0;
        n7 = n2;
        n = n3;
        int n8 = n3 - 1;
        int n9 = n3 + n2;
        int n10 = n9 - 1;
        for (n2 = 0; n2 < n3; ++n2) {
            float f = fArray5[n6] * this.trig[n7 + 1] - fArray5[n6 + 1] * this.trig[n7];
            float f2 = -(fArray5[n6] * this.trig[n7] + fArray5[n6 + 1] * this.trig[n7 + 1]);
            fArray2[n] = -f;
            fArray2[n8] = f;
            fArray2[n9] = f2;
            fArray2[n10] = f2;
            ++n;
            --n8;
            ++n9;
            --n10;
            n6 += 2;
            n7 += 2;
        }
    }

    private float[] mdct_kernel(float[] fArray, float[] fArray2, int n, int n2, int n3, int n4) {
        float f;
        float f2;
        float f3;
        float f4;
        int n5;
        int n6;
        int n7 = n3;
        int n8 = 0;
        int n9 = n2;
        for (n6 = 0; n6 < n3; ++n6) {
            float f5 = fArray[n7] - fArray[n8];
            fArray2[n3 + n6] = fArray[n7++] + fArray[n8++];
            float f6 = fArray[n7] - fArray[n8];
            fArray2[n6++] = f5 * this.trig[n9 -= 4] + f6 * this.trig[n9 + 1];
            fArray2[n6] = f6 * this.trig[n9] - f5 * this.trig[n9 + 1];
            fArray2[n3 + n6] = fArray[n7++] + fArray[n8++];
        }
        for (n6 = 0; n6 < this.log2n - 3; ++n6) {
            int n10 = n >>> n6 + 2;
            int n11 = 1 << n6 + 3;
            n7 = n2 - 2;
            n9 = 0;
            for (n8 = 0; n8 < n10 >>> 2; ++n8) {
                n5 = n7;
                n3 = n5 - (n10 >> 1);
                f4 = this.trig[n9];
                f3 = this.trig[n9 + 1];
                n7 -= 2;
                ++n10;
                for (int i = 0; i < 2 << n6; ++i) {
                    f2 = fArray2[n5] - fArray2[n3];
                    fArray[n5] = fArray2[n5] + fArray2[n3];
                    f = fArray2[++n5] - fArray2[++n3];
                    fArray[n5] = fArray2[n5] + fArray2[n3];
                    fArray[n3] = f * f4 - f2 * f3;
                    fArray[n3 - 1] = f2 * f4 + f * f3;
                    n5 -= n10;
                    n3 -= n10;
                }
                --n10;
                n9 += n11;
            }
            float[] fArray3 = fArray2;
            fArray2 = fArray;
            fArray = fArray3;
        }
        n6 = n;
        int n12 = 0;
        int n13 = 0;
        n7 = n2 - 1;
        for (n3 = 0; n3 < n4; ++n3) {
            n8 = this.bitrev[n12++];
            n5 = this.bitrev[n12++];
            f4 = fArray2[n8] - fArray2[n5 + 1];
            f = fArray2[n8 - 1] + fArray2[n5];
            f3 = fArray2[n8] + fArray2[n5 + 1];
            f2 = fArray2[n8 - 1] - fArray2[n5];
            float f7 = f4 * this.trig[n6];
            float f8 = f * this.trig[n6++];
            float f9 = f4 * this.trig[n6];
            float f10 = f * this.trig[n6++];
            fArray[n13++] = (f3 + f9 + f8) * 0.5f;
            fArray[n7--] = (-f2 + f10 - f7) * 0.5f;
            fArray[n13++] = (f2 + f10 - f7) * 0.5f;
            fArray[n7--] = (f3 - f9 - f8) * 0.5f;
        }
        return fArray;
    }
}

