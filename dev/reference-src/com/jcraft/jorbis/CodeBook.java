/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jorbis.CodeBook$DecodeAux;
import com.jcraft.jorbis.StaticCodeBook;
import com.jcraft.jorbis.Util;

class CodeBook {
    int dim;
    int entries;
    StaticCodeBook c = new StaticCodeBook();
    float[] valuelist;
    int[] codelist;
    CodeBook$DecodeAux decode_tree;
    private int[] t = new int[15];

    CodeBook() {
    }

    int encode(int n, Buffer buffer) {
        buffer.write(this.codelist[n], this.c.lengthlist[n]);
        return this.c.lengthlist[n];
    }

    int errorv(float[] fArray) {
        int n = this.best(fArray, 1);
        for (int i = 0; i < this.dim; ++i) {
            fArray[i] = this.valuelist[n * this.dim + i];
        }
        return n;
    }

    int encodev(int n, float[] fArray, Buffer buffer) {
        for (int i = 0; i < this.dim; ++i) {
            fArray[i] = this.valuelist[n * this.dim + i];
        }
        return this.encode(n, buffer);
    }

    int encodevs(float[] fArray, Buffer buffer, int n, int n2) {
        int n3 = this.besterror(fArray, n, n2);
        return this.encode(n3, buffer);
    }

    synchronized int decodevs_add(float[] fArray, int n, Buffer buffer, int n2) {
        int n3;
        int n4;
        if (this.t.length < (n2 /= this.dim)) {
            this.t = new int[n2];
        }
        for (n4 = 0; n4 < n2; ++n4) {
            n3 = this.decode(buffer);
            if (n3 == -1) {
                return -1;
            }
            this.t[n4] = n3 * this.dim;
        }
        n4 = 0;
        n3 = 0;
        while (n4 < this.dim) {
            for (int i = 0; i < n2; ++i) {
                int n5 = n + n3 + i;
                fArray[n5] = fArray[n5] + this.valuelist[this.t[i] + n4];
            }
            ++n4;
            n3 += n2;
        }
        return 0;
    }

    int decodev_add(float[] fArray, int n, Buffer buffer, int n2) {
        if (this.dim > 8) {
            int n3 = 0;
            while (n3 < n2) {
                int n4 = this.decode(buffer);
                if (n4 == -1) {
                    return -1;
                }
                int n5 = n4 * this.dim;
                n4 = 0;
                while (n4 < this.dim) {
                    int n6 = n + n3++;
                    fArray[n6] = fArray[n6] + this.valuelist[n5 + n4++];
                }
            }
        } else {
            int n7 = 0;
            while (n7 < n2) {
                int n8 = this.decode(buffer);
                if (n8 == -1) {
                    return -1;
                }
                int n9 = n8 * this.dim;
                n8 = 0;
                switch (this.dim) {
                    case 8: {
                        int n10 = n + n7++;
                        fArray[n10] = fArray[n10] + this.valuelist[n9 + 0];
                    }
                    case 7: {
                        int n11 = n + n7++;
                        int n12 = ++n8;
                        fArray[n11] = fArray[n11] + this.valuelist[n9 + n12];
                    }
                    case 6: {
                        int n13 = n + n7++;
                        int n14 = ++n8;
                        fArray[n13] = fArray[n13] + this.valuelist[n9 + n14];
                    }
                    case 5: {
                        int n15 = n + n7++;
                        int n16 = ++n8;
                        fArray[n15] = fArray[n15] + this.valuelist[n9 + n16];
                    }
                    case 4: {
                        int n17 = n + n7++;
                        int n18 = ++n8;
                        fArray[n17] = fArray[n17] + this.valuelist[n9 + n18];
                    }
                    case 3: {
                        int n19 = n + n7++;
                        int n20 = ++n8;
                        fArray[n19] = fArray[n19] + this.valuelist[n9 + n20];
                    }
                    case 2: {
                        int n21 = n + n7++;
                        int n22 = ++n8;
                        ++n8;
                        fArray[n21] = fArray[n21] + this.valuelist[n9 + n22];
                    }
                    case 1: {
                        int n23 = n + n7++;
                        fArray[n23] = fArray[n23] + this.valuelist[n9 + n8];
                    }
                }
            }
        }
        return 0;
    }

    int decodev_set(float[] fArray, int n, Buffer buffer, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            int n4 = this.decode(buffer);
            if (n4 == -1) {
                return -1;
            }
            int n5 = n4 * this.dim;
            n4 = 0;
            while (n4 < this.dim) {
                fArray[n + n3++] = this.valuelist[n5 + n4++];
            }
        }
        return 0;
    }

    int decodevv_add(float[][] fArray, int n, int n2, Buffer buffer, int n3) {
        int n4 = 0;
        int n5 = n / n2;
        while (n5 < (n + n3) / n2) {
            int n6 = this.decode(buffer);
            if (n6 == -1) {
                return -1;
            }
            int n7 = n6 * this.dim;
            for (n6 = 0; n6 < this.dim; ++n6) {
                float[] fArray2 = fArray[n4++];
                int n8 = n5++;
                fArray2[n8] = fArray2[n8] + this.valuelist[n7 + n6];
                if (n4 != n2) continue;
                n4 = 0;
            }
        }
        return 0;
    }

    int decode(Buffer buffer) {
        int n = 0;
        CodeBook$DecodeAux codeBook$DecodeAux = this.decode_tree;
        int n2 = buffer.look(codeBook$DecodeAux.tabn);
        if (n2 >= 0) {
            n = codeBook$DecodeAux.tab[n2];
            buffer.adv(codeBook$DecodeAux.tabl[n2]);
            if (n <= 0) {
                return -n;
            }
        }
        do {
            switch (buffer.read1()) {
                case 0: {
                    n = codeBook$DecodeAux.ptr0[n];
                    break;
                }
                case 1: {
                    n = codeBook$DecodeAux.ptr1[n];
                    break;
                }
                default: {
                    return -1;
                }
            }
        } while (n > 0);
        return -n;
    }

    int decodevs(float[] fArray, int n, Buffer buffer, int n2, int n3) {
        int n4 = this.decode(buffer);
        if (n4 == -1) {
            return -1;
        }
        switch (n3) {
            case -1: {
                n3 = 0;
                int n5 = 0;
                while (n3 < this.dim) {
                    fArray[n + n5] = this.valuelist[n4 * this.dim + n3];
                    ++n3;
                    n5 += n2;
                }
                break;
            }
            case 0: {
                n3 = 0;
                int n6 = 0;
                while (n3 < this.dim) {
                    int n7 = n + n6;
                    fArray[n7] = fArray[n7] + this.valuelist[n4 * this.dim + n3];
                    ++n3;
                    n6 += n2;
                }
                break;
            }
            case 1: {
                n3 = 0;
                int n8 = 0;
                while (n3 < this.dim) {
                    int n9 = n + n8;
                    fArray[n9] = fArray[n9] * this.valuelist[n4 * this.dim + n3];
                    ++n3;
                    n8 += n2;
                }
                break;
            }
        }
        return n4;
    }

    int best(float[] fArray, int n) {
        int n2 = -1;
        float f = 0.0f;
        int n3 = 0;
        for (int i = 0; i < this.entries; ++i) {
            if (this.c.lengthlist[i] > 0) {
                float f2 = CodeBook.dist(this.dim, this.valuelist, n3, fArray, n);
                if (n2 == -1 || f2 < f) {
                    f = f2;
                    n2 = i;
                }
            }
            n3 += this.dim;
        }
        return n2;
    }

    int besterror(float[] fArray, int n, int n2) {
        int n3 = this.best(fArray, n);
        switch (n2) {
            case 0: {
                n2 = 0;
                int n4 = 0;
                while (n2 < this.dim) {
                    int n5 = n4;
                    fArray[n5] = fArray[n5] - this.valuelist[n3 * this.dim + n2];
                    ++n2;
                    n4 += n;
                }
                break;
            }
            case 1: {
                n2 = 0;
                int n6 = 0;
                while (n2 < this.dim) {
                    float f = this.valuelist[n3 * this.dim + n2];
                    if (f == 0.0f) {
                        fArray[n6] = 0.0f;
                    } else {
                        int n7 = n6;
                        fArray[n7] = fArray[n7] / f;
                    }
                    ++n2;
                    n6 += n;
                }
                break;
            }
        }
        return n3;
    }

    void clear() {
    }

    private static float dist(int n, float[] fArray, int n2, float[] fArray2, int n3) {
        float f = 0.0f;
        for (int i = 0; i < n; ++i) {
            float f2 = fArray[n2 + i] - fArray2[i * n3];
            f += f2 * f2;
        }
        return f;
    }

    int init_decode(StaticCodeBook staticCodeBook) {
        this.c = staticCodeBook;
        this.entries = staticCodeBook.entries;
        this.dim = staticCodeBook.dim;
        this.valuelist = staticCodeBook.unquantize();
        this.decode_tree = this.make_decode_tree();
        if (this.decode_tree == null) {
            this.clear();
            return -1;
        }
        return 0;
    }

    static int[] make_words(int[] nArray, int n) {
        int n2;
        int n3;
        int n4;
        int[] nArray2 = new int[33];
        int[] nArray3 = new int[n];
        for (n4 = 0; n4 < n; ++n4) {
            n3 = nArray[n4];
            if (n3 <= 0) continue;
            n2 = nArray2[n3];
            if (n3 < 32 && n2 >>> n3 != 0) {
                return null;
            }
            nArray3[n4] = n2;
            int n5 = n3;
            while (n5 > 0) {
                if ((nArray2[n5] & 1) != 0) {
                    if (n5 == 1) {
                        nArray2[1] = nArray2[1] + 1;
                        break;
                    }
                    nArray2[n5] = nArray2[n5 - 1] << 1;
                    break;
                }
                int n6 = n5--;
                nArray2[n6] = nArray2[n6] + 1;
            }
            for (n5 = n3 + 1; n5 < 33 && nArray2[n5] >>> 1 == n2; ++n5) {
                n2 = nArray2[n5];
                nArray2[n5] = nArray2[n5 - 1] << 1;
            }
        }
        for (n4 = 0; n4 < n; ++n4) {
            n3 = 0;
            for (n2 = 0; n2 < nArray[n4]; ++n2) {
                n3 <<= 1;
                n3 |= nArray3[n4] >>> n2 & 1;
            }
            nArray3[n4] = n3;
        }
        return nArray3;
    }

    CodeBook$DecodeAux make_decode_tree() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5 = 0;
        CodeBook$DecodeAux codeBook$DecodeAux = new CodeBook$DecodeAux(this);
        new CodeBook$DecodeAux(this).ptr0 = new int[this.entries << 1];
        int[] nArray = new CodeBook$DecodeAux(this).ptr0;
        codeBook$DecodeAux.ptr1 = new int[this.entries << 1];
        int[] nArray2 = codeBook$DecodeAux.ptr1;
        int[] nArray3 = CodeBook.make_words(this.c.lengthlist, this.c.entries);
        if (nArray3 == null) {
            return null;
        }
        codeBook$DecodeAux.aux = this.entries << 1;
        for (n4 = 0; n4 < this.entries; ++n4) {
            if (this.c.lengthlist[n4] <= 0) continue;
            n3 = 0;
            for (n2 = 0; n2 < this.c.lengthlist[n4] - 1; ++n2) {
                n = nArray3[n4] >>> n2 & 1;
                if (n == 0) {
                    if (nArray[n3] == 0) {
                        nArray[n3] = ++n5;
                    }
                    n3 = nArray[n3];
                    continue;
                }
                if (nArray2[n3] == 0) {
                    nArray2[n3] = ++n5;
                }
                n3 = nArray2[n3];
            }
            if ((nArray3[n4] >>> n2 & 1) == 0) {
                nArray[n3] = -n4;
                continue;
            }
            nArray2[n3] = -n4;
        }
        codeBook$DecodeAux.tabn = Util.ilog(this.entries) - 4;
        if (codeBook$DecodeAux.tabn < 5) {
            codeBook$DecodeAux.tabn = 5;
        }
        n4 = 1 << codeBook$DecodeAux.tabn;
        codeBook$DecodeAux.tab = new int[n4];
        codeBook$DecodeAux.tabl = new int[n4];
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = 0;
            for (n = 0; n < codeBook$DecodeAux.tabn && (n2 > 0 || n == 0); ++n) {
                n2 = (n3 & 1 << n) != 0 ? nArray2[n2] : nArray[n2];
            }
            codeBook$DecodeAux.tab[n3] = n2;
            codeBook$DecodeAux.tabl[n3] = n;
        }
        return codeBook$DecodeAux;
    }
}

