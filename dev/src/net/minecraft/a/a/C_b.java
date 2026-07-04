/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_a;
import net.minecraft.a.c.a.C_d;
import net.minecraft.a.c.a.C_f;
import net.minecraft.a.c.a.C_h;
import net.minecraft.a.c.a.C_i;
import net.minecraft.a.c.a.C_j;
import net.minecraft.a.c.a.C_k;
import net.minecraft.a.c.a.C_l;
import net.minecraft.a.c.a.C_m;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;

public class C_b {
    private C_g a;

    public C_b(C_g c_g) {
        this.a = c_g;
    }

    public final void a() {
        net.minecraft.a.c.C_c c_c;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        C_b c_b;
        net.minecraft.a.c.C_c c_c2;
        float f7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12 = this.a.a * this.a.b * this.a.c * 20 / 64 / 64 / 64 / 2;
        if (this.a.bloodMoon && this.a.E != 0) {
            n12 = n12 * 8 / 4;
        } else {
            if (this.a.E == 0) {
                n12 = 0;
            }
            if (this.a.E == 1) {
                n12 = n12 * 3 / 4;
            }
            if (this.a.E == 2) {
                n12 = (n12 << 2) / 4;
            }
            if (this.a.E == 3) {
                n12 = n12 * 6 / 4;
            }
        }
        if (this.a.bloodMoon && this.a.type != 8) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(25);
            if (n8 == 0 && !this.a.b(n11, n10, n9) && this.a.b(n11, n10 - 1, n9) && this.a.d(n11, n10, n9) <= this.a.q.nextInt(8)) {
                f7 = this.a.q.nextFloat() * 360.0f;
                c_c2 = new C_a(this.a);
                ((C_e)c_c2).b(n11, n10, n9, f7, 0.0f);
                this.a.spawnEntityInWorld(c_c2);
            }
        }
        if (this.a.type == 4 && this.a.E > 0) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            net.minecraft.a.c.a.C_g c_g = new net.minecraft.a.c.a.C_g(this.a);
            if (!(this.a.b(n11, n10, n9) || this.a.a(n11, n10 - 1, n9) != C_x.t.at && this.a.a(n11, n10 - 1, n9) != C_x.redSand.at)) {
                f7 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_g).b(n11, n10 + 1, n9, f7, 0.0f);
                this.a.spawnEntityInWorld(c_g);
            }
        }
        if (this.a.type == 5 && this.a.E > 0) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(5);
            net.minecraft.a.c.b.C_d c_d = new net.minecraft.a.c.b.C_d(this.a);
            if (n8 == 0 && !this.a.b(n11, n10, n9) && this.a.b(n11, n10 + 1, n9) && this.a.a((float)n11, (float)(n10 + 1), (float)n9)) {
                float f8 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_d).b((float)n11 + 0.5f, (float)n10 + 0.65f, (float)n9 + 0.5f, f8, 0.0f);
                this.a.spawnEntityInWorld(c_d);
            }
        }
        if (this.a.type == 7) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(5);
            int n13 = this.a.q.nextInt(2);
            c_c2 = null;
            switch (n13) {
                case 0: {
                    c_c2 = new net.minecraft.a.c.b.C_g(this.a, this.a.q.nextInt(2));
                    break;
                }
                case 1: {
                    c_c2 = new net.minecraft.a.c.b.C_i(this.a);
                }
            }
            if (n8 == 0 && this.a.f(n11, n10, n9) == C_c.f) {
                float f9 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_c2).b((float)n11 + 0.5f, (float)n10 + 0.65f, (float)n9 + 0.5f, f9, 0.0f);
                this.a.spawnEntityInWorld(c_c2);
            }
        }
        if (this.a.type == 1) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(5);
            net.minecraft.a.c.b.C_g c_g = new net.minecraft.a.c.b.C_g(this.a, this.a.q.nextInt(2));
            if (n8 == 0 && this.a.f(n11, n10, n9) == C_c.f) {
                float f10 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_g).b((float)n11 + 0.5f, (float)n10 + 0.65f, (float)n9 + 0.5f, f10, 0.0f);
                this.a.spawnEntityInWorld(c_g);
            }
        }
        if (this.a.theme == 1 && this.a.type != 8 && this.a.type != 5 && this.a.E > 0) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(5);
            C_j c_j = new C_j(this.a);
            if (n8 == 0 && !this.a.b(n11, n10, n9) && this.a.a((float)n11, (float)(n10 - 1), (float)n9)) {
                float f11 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_j).b(n11, n10 + 1, n9, f11, 0.0f);
                this.a.spawnEntityInWorld(c_j);
            }
        }
        if (this.a.type == 2 && this.a.E > 0) {
            n11 = this.a.q.nextInt(this.a.a);
            n10 = (int)(Math.min(this.a.q.nextFloat(), this.a.q.nextFloat()) * (float)this.a.c);
            n9 = this.a.q.nextInt(this.a.b);
            n8 = this.a.q.nextInt(250);
            C_h c_h = new C_h(this.a);
            if (n8 == 0 && !this.a.b(n11, n10, n9)) {
                float f12 = this.a.q.nextFloat() * 360.0f;
                ((C_e)c_h).b(n11, n10 + 1, n9, f12, 0.0f);
                this.a.spawnEntityInWorld(c_h);
            }
        }
        n11 = this.a.a * this.a.b / 4000;
        n10 = this.a.a(net.minecraft.a.c.a.C_e.class);
        for (n9 = 0; n9 < 4; ++n9) {
            if (n10 >= n12) continue;
            C_e c_e = this.a.y;
            c_b = this;
            int n14 = 0;
            int n15 = this.a.q.nextInt(4);
            if (this.a.type == 5) {
                n15 = this.a.q.nextInt(5);
            }
            int n16 = this.a.q.nextInt(this.a.a);
            n7 = this.a.q.nextInt(this.a.c); // raised spawn ceiling: uniform height so hostiles can spawn at the surface (y~62), not biased to the bottom
            n6 = this.a.q.nextInt(this.a.b);
            for (n5 = 0; n5 < 2; ++n5) {
                n4 = n16;
                n3 = n7;
                n2 = n6;
                for (n = 0; n < 3; ++n) {
                    if ((n4 += c_b.a.q.nextInt(6) - c_b.a.q.nextInt(6)) < 0 || (n2 += c_b.a.q.nextInt(6) - c_b.a.q.nextInt(6)) <= 0 || (n3 += c_b.a.q.nextInt(1) - c_b.a.q.nextInt(1)) < 0 || n3 >= c_b.a.c - 2 || n4 >= c_b.a.a || n2 >= c_b.a.b) continue;
                    f6 = (float)n4 + 0.5f;
                    f5 = (float)n3 + 0.5f;
                    f4 = (float)n2 + 0.5f;
                    if (c_e != null ? (f3 = f6 - c_e.h) * f3 + (f2 = f5 - c_e.i) * f2 + (f = f4 - c_e.j) * f < 1024.0f : (f3 = f6 - (float)c_b.a.i) * f3 + (f2 = f5 - (float)c_b.a.j) * f2 + (f = f4 - (float)c_b.a.k) * f < 1024.0f) continue;
                    c_c = null;
                    if (n15 == 0) {
                        c_c = this.a.type == 8 ? new EntityRana(c_b.a) : new net.minecraft.a.c.a.C_c(c_b.a);
                    }
                    if (n15 == 1) {
                        c_c = this.a.type == 8 ? new EntityBeastBoy(c_b.a) : new C_d(c_b.a);
                    }
                    if (n15 == 2) {
                        c_c = this.a.type == 8 ? new EntityBlackSteve(c_b.a) : new net.minecraft.a.c.a.C_b(c_b.a);
                    }
                    if (n15 == 3) {
                        c_c = this.a.type == 8 ? new EntitySteve(c_b.a) : (this.a.theme == 4 ? new C_i(c_b.a) : (this.a.type == 4 ? new C_k(c_b.a) : new C_f(c_b.a)));
                    }
                    if (n15 == 4 && this.a.type == 5) {
                        c_c = new C_m(c_b.a);
                    }
                    if (c_c instanceof net.minecraft.a.c.a.C_e && c_b.a.E == 0) {
                        c_c = null;
                    }
                    if (c_c == null || c_b.a.b(n4, n3, n2) || !c_b.a.b(n4, n3 - 1, n2) && !(C_x.c[c_b.a.a(n4, n3 - 1, n2)] instanceof C_bs) || !((C_e)c_c).a(f6, f5, f4)) continue;
                    f = c_b.a.q.nextFloat() * 360.0f;
                    ((C_e)c_c).b(f6, f5, f4, f, 0.0f);
                    ++n14;
                    c_b.a.spawnEntityInWorld(c_c);
                }
            }
            n10 += n14;
        }
        n9 = this.a.a(net.minecraft.a.c.b.C_a.class);
        if (this.a.season.currentSeason == 3) {
            n11 = n11 * 3 / 4;
        }
        if (this.a.season.currentSeason == 2 || this.a.season.currentSeason == 0) {
            n11 = (n11 << 2) / 4;
        }
        if (this.a.season.currentSeason == 1) {
            n11 = n11 * 6 / 4;
        }
        for (n12 = 0; n12 < 4; ++n12) {
            if (n9 >= n11) continue;
            C_e c_e = this.a.y;
            c_b = this;
            int n17 = 0;
            int n18 = this.a.q.nextInt(4);
            if (this.a.season.currentSeason == 3 || this.a.theme == 4) {
                n18 = this.a.q.nextInt(5);
            }
            int n19 = this.a.q.nextInt(this.a.a);
            n7 = this.a.q.nextInt(this.a.c);
            n6 = this.a.q.nextInt(this.a.b);
            for (n5 = 0; n5 < 2; ++n5) {
                n4 = n19;
                n3 = n7;
                n2 = n6;
                for (n = 0; n < 3; ++n) {
                    if ((n4 += c_b.a.q.nextInt(6) - c_b.a.q.nextInt(6)) < 0 || (n2 += c_b.a.q.nextInt(6) - c_b.a.q.nextInt(6)) <= 0 || (n3 += c_b.a.q.nextInt(1) - c_b.a.q.nextInt(1)) < 0 || n3 >= c_b.a.c - 2 || n4 >= c_b.a.a || n2 >= c_b.a.b) continue;
                    f6 = (float)n4 + 0.5f;
                    f5 = (float)n3 + 0.5f;
                    f4 = (float)n2 + 0.5f;
                    if (c_e != null ? (f3 = f6 - c_e.h) * f3 + (f2 = f5 - c_e.i) * f2 + (f = f4 - c_e.j) * f < 1024.0f : (f3 = f6 - (float)c_b.a.i) * f3 + (f2 = f5 - (float)c_b.a.j) * f2 + (f = f4 - (float)c_b.a.k) * f < 1024.0f) continue;
                    c_c = null;
                    if (n18 == 0) {
                        c_c = new net.minecraft.a.c.b.C_c(c_b.a);
                    }
                    if (n18 == 1) {
                        c_c = new net.minecraft.a.c.b.C_b(c_b.a);
                    }
                    if (n18 == 2) {
                        c_c = this.a.theme == 2 && this.a.q.nextInt(25) == 0 ? new net.minecraft.a.c.b.C_j(c_b.a) : (this.a.theme == 4 ? new net.minecraft.a.c.b.C_k(c_b.a, c_b.a.q.nextInt(2)) : new net.minecraft.a.c.b.C_e(c_b.a, c_b.a.q.nextInt(4)));
                    }
                    if (n18 == 3) {
                        c_c = new net.minecraft.a.c.b.C_f(c_b.a);
                    }
                    if (n18 == 4) {
                        if (this.a.theme == 4 && this.a.E > 0) {
                            c_c = new C_l(c_b.a);
                        } else if (this.a.season.currentSeason == 3) {
                            c_c = new net.minecraft.a.c.b.C_h(c_b.a);
                        }
                    }
                    if (c_c == null || c_b.a.b(n4, n3, n2) || !c_b.a.b(n4, n3 - 1, n2) && !(C_x.c[c_b.a.a(n4, n3 - 1, n2)] instanceof C_bs) || !((C_e)c_c).a(f6, f5, f4)) continue;
                    f = c_b.a.q.nextFloat() * 360.0f;
                    ((C_e)c_c).b(f6, f5, f4, f, 0.0f);
                    ++n17;
                    c_b.a.spawnEntityInWorld(c_c);
                }
            }
            n9 += n17;
        }
    }
}

