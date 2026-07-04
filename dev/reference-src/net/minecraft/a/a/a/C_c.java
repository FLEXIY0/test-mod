/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.a;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.a.C_a;
import net.minecraft.a.a.a.C_b;
import net.minecraft.a.a.a.C_d;
import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.C_x;

public final class C_c {
    private C_g a;
    private C_d b = new C_d();
    private Map<Integer, C_a> c = new HashMap<Integer, C_a>();
    private C_a[] d = new C_a[32];

    public C_c(C_g c_g) {
        this.a = c_g;
    }

    public final C_b a(net.minecraft.a.c.C_b c_b, net.minecraft.a.c.C_b c_b2, float f) {
        return this.a(c_b, c_b2.h, c_b2.r.b, c_b2.j, f);
    }

    public final C_b a(net.minecraft.a.c.C_b c_b, int n, int n2, int n3, float f) {
        return this.a(c_b, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, f);
    }

    private C_b a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4) {
        C_b c_b2;
        this.b.a();
        this.c.clear();
        C_a c_a = this.a((int)c_b.r.a, (int)c_b.r.b, (int)c_b.r.c);
        C_a c_a2 = this.a((int)(f - c_b.w / 2.0f), (int)f2, (int)(f3 - c_b.w / 2.0f));
        C_a c_a3 = new C_a((int)(c_b.w + 1.0f), (int)(c_b.x + 1.0f), (int)(c_b.w + 1.0f));
        float f5 = f4;
        C_a c_a4 = c_a3;
        C_a c_a5 = c_a2;
        net.minecraft.a.c.C_b c_b3 = c_b;
        C_c c_c = this;
        c_a.f = 0.0f;
        c_a.h = c_a.g = c_a.a(c_a2);
        this.b.a();
        this.b.a(c_a);
        C_a c_a6 = c_a;
        block0: while (true) {
            if (c_c.b.c()) {
                c_b2 = c_a6 == c_a ? null : C_c.a(c_a6);
                break;
            }
            C_a c_a7 = c_c.b.b();
            if (c_a7.d == c_a5.d) {
                c_b2 = C_c.a(c_a5);
                break;
            }
            if (c_a7.a(c_a5) < c_a6.a(c_a5)) {
                c_a6 = c_a7;
            }
            c_a7.j = true;
            int n = 0;
            int n2 = 0;
            if (c_c.a(c_a7.a, c_a7.b + 1, c_a7.c, c_a4) > 0) {
                n2 = 1;
            }
            C_a c_a8 = c_c.a(c_b3, c_a7.a, c_a7.b, c_a7.c + 1, c_a4, n2);
            C_a c_a9 = c_c.a(c_b3, c_a7.a - 1, c_a7.b, c_a7.c, c_a4, n2);
            C_a c_a10 = c_c.a(c_b3, c_a7.a + 1, c_a7.b, c_a7.c, c_a4, n2);
            C_a c_a11 = c_c.a(c_b3, c_a7.a, c_a7.b, c_a7.c - 1, c_a4, n2);
            if (c_a8 != null && !c_a8.j && c_a8.a(c_a5) < f5) {
                ++n;
                c_c.d[0] = c_a8;
            }
            if (c_a9 != null && !c_a9.j && c_a9.a(c_a5) < f5) {
                c_c.d[n++] = c_a9;
            }
            if (c_a10 != null && !c_a10.j && c_a10.a(c_a5) < f5) {
                c_c.d[n++] = c_a10;
            }
            if (c_a11 != null && !c_a11.j && c_a11.a(c_a5) < f5) {
                c_c.d[n++] = c_a11;
            }
            int n3 = n;
            int n4 = 0;
            while (true) {
                if (n4 >= n3) continue block0;
                C_a c_a12 = c_c.d[n4];
                float f6 = c_a7.f + c_a7.a(c_a12);
                if (!c_a12.a() || f6 < c_a12.f) {
                    c_a12.i = c_a7;
                    c_a12.f = f6;
                    c_a12.g = c_a12.a(c_a5);
                    if (c_a12.a()) {
                        c_c.b.a(c_a12, c_a12.f + c_a12.g);
                    } else {
                        c_a12.h = c_a12.f + c_a12.g;
                        c_c.b.a(c_a12);
                    }
                }
                ++n4;
            }
            break;
        }
        return c_b2;
    }

    private C_a a(net.minecraft.a.c.C_b c_b, int n, int n2, int n3, C_a c_a, int n4) {
        C_a c_a2 = null;
        if (this.a(n, n2, n3, c_a) > 0) {
            c_a2 = this.a(n, n2, n3);
        }
        if (c_a2 == null && this.a(n, n2 + n4, n3, c_a) > 0) {
            c_a2 = this.a(n, n2 + n4, n3);
        }
        if (c_a2 != null) {
            n4 = 0;
            while (true) {
                int n5;
                if (n2 <= 0 || (n5 = this.a(n, n2 - 1, n3, c_a)) <= 0) {
                    net.minecraft.a.a.d.C_c c_c = this.a.f(n, n2 - 1, n3);
                    if (c_c != net.minecraft.a.a.d.C_c.f && c_c != net.minecraft.a.a.d.C_c.g && c_c != net.minecraft.a.a.d.C_c.magma && c_c != net.minecraft.a.a.d.C_c.cactus && c_c != net.minecraft.a.a.d.C_c.quicksand) break;
                    return null;
                }
                if (n5 < 0) {
                    return null;
                }
                if (++n4 >= 4) {
                    return null;
                }
                c_a2 = this.a(n, --n2, n3);
            }
        }
        return c_a2;
    }

    private final C_a a(int n, int n2, int n3) {
        int n4 = n | n2 << 10 | n3 << 20;
        C_a c_a = this.c.get(n4);
        if (c_a == null) {
            c_a = new C_a(n, n2, n3);
            this.c.put(n4, c_a);
        }
        return c_a;
    }

    private int a(int n, int n2, int n3, C_a c_a) {
        for (int i = n; i < n + c_a.a; ++i) {
            if (i < 0 || i >= this.a.a) {
                return 0;
            }
            for (int j = n2; j < n2 + c_a.b; ++j) {
                if (j < 0 || j >= this.a.c) {
                    return 0;
                }
                for (int k = n3; k < n3 + c_a.c; ++k) {
                    if (k >= 0 && k < this.a.b) {
                        net.minecraft.a.a.d.C_c c_c = this.a.f(n, n2, n3);
                        C_x c_x = C_x.c[this.a.a(n, n2, n3)];
                        if (c_c.c() && !(c_x instanceof C_bs) && !(c_x instanceof C_am) && !(c_x instanceof C_bq)) {
                            return 0;
                        }
                        if (c_c != net.minecraft.a.a.d.C_c.f && c_c != net.minecraft.a.a.d.C_c.g) {
                            continue;
                        }
                        return -1;
                    }
                    return 0;
                }
            }
        }
        return 1;
    }

    private static C_b a(C_a c_a) {
        int n = 1;
        C_a c_a2 = c_a;
        while (c_a2.i != null) {
            ++n;
            c_a2 = c_a2.i;
        }
        C_a[] c_aArray = new C_a[n];
        c_a2 = c_a;
        c_aArray[--n] = c_a;
        while (c_a2.i != null) {
            c_a2 = c_a2.i;
            c_aArray[--n] = c_a2;
        }
        return new C_b(c_aArray);
    }
}

