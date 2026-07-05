/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.C_l;
import net.minecraft.a.a.b.C_x;

final class C_c {
    public final C_l skyBlock;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public C_c(C_l c_l, int n, int n2, int n3, int n4, int n5, int n6) {
        this.skyBlock = c_l;
        this.a = n;
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = n5;
        this.f = n6;
    }

    public void updateLight(C_g c_g) {
        for (int i = this.a; i <= this.d; ++i) {
            for (int j = this.c; j <= this.f; ++j) {
                for (int k = this.b; k <= this.e; ++k) {
                    int n;
                    int n2;
                    if (i < 0 || i >= c_g.a || j < 0 || j >= c_g.b || k < 0 || k >= c_g.c) continue;
                    int n3 = c_g.getSavedLightValue(this.skyBlock, i, k, j);
                    int n4 = c_g.a(i, k, j);
                    int n5 = C_x.f[n4];
                    if (n5 == 0) {
                        n5 = 1;
                    }
                    int n6 = 0;
                    if (this.skyBlock == C_l.Sky) {
                        if (c_g.l(i, k, j)) {
                            n6 = 15;
                        }
                    } else if (this.skyBlock == C_l.Block) {
                        n6 = C_x.h[n4];
                    }
                    if (n5 >= 15 && n6 == 0) {
                        n2 = 0;
                    } else {
                        n = c_g.getSavedLightValue(this.skyBlock, i - 1, k, j);
                        int n7 = c_g.getSavedLightValue(this.skyBlock, i + 1, k, j);
                        int n8 = c_g.getSavedLightValue(this.skyBlock, i, k - 1, j);
                        int n9 = c_g.getSavedLightValue(this.skyBlock, i, k + 1, j);
                        int n10 = c_g.getSavedLightValue(this.skyBlock, i, k, j - 1);
                        int n11 = c_g.getSavedLightValue(this.skyBlock, i, k, j + 1);
                        n2 = n;
                        if (n7 > n) {
                            n2 = n7;
                        }
                        if (n8 > n2) {
                            n2 = n8;
                        }
                        if (n9 > n2) {
                            n2 = n9;
                        }
                        if (n10 > n2) {
                            n2 = n10;
                        }
                        if (n11 > n2) {
                            n2 = n11;
                        }
                        if ((n2 -= n5) < 0) {
                            n2 = 0;
                        }
                        if (n6 > n2) {
                            n2 = n6;
                        }
                    }
                    if (n3 == n2) continue;
                    c_g.setSavedLightValue(this.skyBlock, i, k, j, n2);
                    n = n2 - 1;
                    if (n < 0) {
                        n = 0;
                    }
                    c_g.neighborLightPropagationChanged(this.skyBlock, i - 1, k, j, n);
                    c_g.neighborLightPropagationChanged(this.skyBlock, i, k - 1, j, n);
                    c_g.neighborLightPropagationChanged(this.skyBlock, i, k, j - 1, n);
                    if (i + 1 >= this.d) {
                        c_g.neighborLightPropagationChanged(this.skyBlock, i + 1, k, j, n);
                    }
                    if (k + 1 >= this.e) {
                        c_g.neighborLightPropagationChanged(this.skyBlock, i, k + 1, j, n);
                    }
                    if (j + 1 < this.f) continue;
                    c_g.neighborLightPropagationChanged(this.skyBlock, i, k, j + 1, n);
                }
            }
        }
    }

    public boolean getLightUpdated(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= this.a && n2 >= this.b && n3 >= this.c && n4 <= this.d && n5 <= this.e && n6 <= this.f) {
            return true;
        }
        int n7 = 1;
        if (n >= this.a - n7 && n2 >= this.b - n7 && n3 >= this.c - n7 && n4 <= this.d + n7 && n5 <= this.e + n7 && n6 <= this.f + n7) {
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13 = this.d - this.a;
            int n14 = this.e - this.b;
            int n15 = this.f - this.c;
            if (n > this.a) {
                n = this.a;
            }
            if (n2 > this.b) {
                n2 = this.b;
            }
            if (n3 > this.c) {
                n3 = this.c;
            }
            if (n4 < this.d) {
                n4 = this.d;
            }
            if (n5 < this.e) {
                n5 = this.e;
            }
            if (n6 < this.f) {
                n6 = this.f;
            }
            if ((n12 = (n11 = n4 - n) * (n10 = n5 - n2) * (n9 = n6 - n3)) - (n8 = n13 * n14 * n15) <= 2) {
                this.a = n;
                this.b = n2;
                this.c = n3;
                this.d = n4;
                this.e = n5;
                this.f = n6;
                return true;
            }
        }
        return false;
    }
}

