/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.C_f;
import net.minecraft.a.c.C_e;
import net.minecraft.a.d.C_b;

public final class C_i {
    public int a;
    public int b;
    public int c;
    private C_f f = new C_f(this);
    private C_f g = new C_f(this);
    public List<net.minecraft.a.c.C_b>[] d;
    public List<net.minecraft.a.c.C_b> e = new ArrayList<net.minecraft.a.c.C_b>();
    private List<net.minecraft.a.c.C_b> h = new ArrayList<net.minecraft.a.c.C_b>();

    public C_i(int n, int n2, int n3) {
        this.a = n / 8;
        this.b = n2 / 8;
        this.c = n3 / 8;
        if (this.a == 0) {
            this.a = 1;
        }
        if (this.b == 0) {
            this.b = 1;
        }
        if (this.c == 0) {
            this.c = 1;
        }
        this.d = new ArrayList[this.a * this.b * this.c];
        for (n = 0; n < this.a; ++n) {
            for (n2 = 0; n2 < this.b; ++n2) {
                for (n3 = 0; n3 < this.c; ++n3) {
                    this.d[(n3 * this.b + n2) * this.a + n] = new ArrayList<net.minecraft.a.c.C_b>();
                }
            }
        }
    }

    public final void a(net.minecraft.a.c.C_b c_b) {
        this.e.add(c_b);
        this.f.a(c_b.h, c_b.i, c_b.j).a(c_b);
        c_b.B = c_b.h;
        c_b.C = c_b.i;
        c_b.D = c_b.j;
    }

    public final void b(net.minecraft.a.c.C_b c_b) {
        this.f.a(c_b.B, c_b.C, c_b.D).b(c_b);
        this.f.a(c_b.h, c_b.i, c_b.j).b(c_b);
        this.e.remove(c_b);
    }

    public final List<net.minecraft.a.c.C_b> a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4, float f5, float f6) {
        this.h.clear();
        return this.a(c_b, f, f2, f3, f4, f5, f6, this.h);
    }

    private List<net.minecraft.a.c.C_b> a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4, float f5, float f6, List<net.minecraft.a.c.C_b> list) {
        C_f c_f = this.f.a(f, f2, f3);
        C_f c_f2 = this.g.a(f4, f5, f6);
        for (int i = C_f.xPosition(c_f) - 1; i <= C_f.xPosition(c_f2) + 1; ++i) {
            for (int j = C_f.yPosition(c_f) - 1; j <= C_f.yPosition(c_f2) + 1; ++j) {
                for (int k = C_f.zPosition(c_f) - 1; k <= C_f.zPosition(c_f2) + 1; ++k) {
                    if (i < 0 || j < 0 || k < 0 || i >= this.a || j >= this.b || k >= this.c) continue;
                    List<net.minecraft.a.c.C_b> list2 = this.d[(k * this.b + j) * this.a + i];
                    for (int i2 = 0; i2 < list2.size(); ++i2) {
                        net.minecraft.a.c.C_b c_b2 = list2.get(i2);
                        if (c_b2 == c_b) continue;
                        C_b c_b3 = c_b2.r;
                        if (!(f4 > c_b3.a) || !(f < c_b3.d) || !(f5 > c_b3.b) || !(f2 < c_b3.e) || !(f6 > c_b3.c) || !(f3 < c_b3.f)) continue;
                        list.add(c_b2);
                    }
                }
            }
        }
        return list;
    }

    public final List<net.minecraft.a.c.C_b> a(net.minecraft.a.c.C_b c_b, C_b c_b2) {
        this.h.clear();
        return c_b2 == null ? this.h : this.a(c_b, c_b2.a, c_b2.b, c_b2.c, c_b2.d, c_b2.e, c_b2.f, this.h);
    }

    public final void a() {
        for (int i = 0; i < this.e.size(); ++i) {
            C_f c_f;
            C_f c_f2;
            net.minecraft.a.c.C_b c_b = this.e.get(i);
            c_b.B = c_b.h;
            c_b.C = c_b.i;
            c_b.D = c_b.j;
            if (c_b.ridingEntity != null) {
                c_b.updateRidden();
            } else {
                c_b.b_();
            }
            if (c_b.u) {
                this.e.remove(i--);
                this.f.a(c_b.B, c_b.C, c_b.D).b(c_b);
                continue;
            }
            int n = (int)(c_b.B / 8.0f);
            int n2 = (int)(c_b.C / 8.0f);
            int n3 = (int)(c_b.D / 8.0f);
            int n4 = (int)(c_b.h / 8.0f);
            int n5 = (int)(c_b.i / 8.0f);
            int n6 = (int)(c_b.j / 8.0f);
            if (n == n4 && n2 == n5 && n3 == n6 || (c_f2 = this.f.a(c_b.B, c_b.C, c_b.D)).equals(c_f = this.g.a(c_b.h, c_b.i, c_b.j))) continue;
            c_f2.b(c_b);
            c_f.a(c_b);
        }
    }

    public void removeAll() {
        for (int i = 0; i < this.e.size(); ++i) {
            net.minecraft.a.c.C_b c_b = this.e.get(i);
            if (!(c_b instanceof C_e)) continue;
            c_b.attackEntityFrom(null, 1000, 0.0f);
        }
    }
}

