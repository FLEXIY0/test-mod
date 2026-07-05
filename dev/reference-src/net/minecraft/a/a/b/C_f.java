/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_ad;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;

public final class C_f
extends C_ad {
    protected C_f(int n, int n2) {
        super(59, 88);
        this.as = 88;
        this.a(true);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
    }

    protected final boolean b(int n) {
        return n == Block.ap.at;
    }

    public final void a(World c_g, int n, int n2, int n3, Random random) {
        int n4;
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && (n4 = c_g.e(n, n2, n3)) < 7) {
            float f;
            int n5 = n3;
            int n6 = n2;
            int n7 = n;
            World c_g2 = c_g;
            C_f c_f = this;
            float f2 = 1.0f;
            int n8 = c_g2.a(n7, n6, n5 - 1);
            int n9 = c_g2.a(n7, n6, n5 + 1);
            int n10 = c_g2.a(n7 - 1, n6, n5);
            int n11 = c_g2.a(n7 + 1, n6, n5);
            int n12 = c_g2.a(n7 - 1, n6, n5 - 1);
            int n13 = c_g2.a(n7 + 1, n6, n5 - 1);
            int n14 = c_g2.a(n7 + 1, n6, n5 + 1);
            int n15 = c_g2.a(n7 - 1, n6, n5 + 1);
            n10 = n10 == c_f.at || n11 == c_f.at ? 1 : 0;
            n8 = n8 == c_f.at || n9 == c_f.at ? 1 : 0;
            boolean bl = n12 == c_f.at || n13 == c_f.at || n14 == c_f.at || n15 == c_f.at;
            for (n9 = n7 - 1; n9 <= n7 + 1; ++n9) {
                for (n11 = n5 - 1; n11 <= n5 + 1; ++n11) {
                    n12 = c_g2.a(n9, n6 - 1, n11);
                    float f3 = 0.0f;
                    if (n12 == Block.ap.at) {
                        f3 = 1.0f;
                        if (c_g2.e(n9, n6 - 1, n11) > 0) {
                            f3 = 3.0f;
                        }
                    }
                    if (n9 != n7 || n11 != n5) {
                        f3 /= 4.0f;
                    }
                    f2 += f3;
                }
            }
            if (bl || n10 != 0 && n8 != 0) {
                f2 /= 2.0f;
            }
            if (random.nextInt((int)(100.0f / (f = f2))) == 0) {
                c_g.f(n, n2, n3, ++n4);
            }
        }
    }

    public final int a(int n, int n2) {
        if (n2 < 0) {
            n2 = 7;
        }
        return this.as + n2;
    }

    public final int a() {
        return 6;
    }

    public final void c(World c_g, int n, int n2, int n3, int n4) {
        super.c(c_g, n, n2, n3, n4);
        for (int i = 0; i < 3; ++i) {
            if (c_g.q.nextInt(15) > n4) continue;
            float f = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.O));
            new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.O)).O = 10;
            c_g.a(c_b);
        }
    }

    public final int a(int n, Random random) {
        System.out.println("Get resource: " + n);
        if (n == 7) {
            return Item.P.ap;
        }
        return -1;
    }

    public final int a(Random random) {
        return 1;
    }
}

