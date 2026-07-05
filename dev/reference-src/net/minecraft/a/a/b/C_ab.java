/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public final class C_ab
extends C_x {
    protected C_ab(int n) {
        super(n, C_c.b);
        this.as = 101;
        this.a(true);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.hasStates = true;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return new C_b(n, n2, n3, n + 1, n2 + 1, n3 + 1);
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public int getMaxMetadata() {
        return 1;
    }

    @Override
    public final void dropBlockAsItemWithChance(C_g c_g, int n, int n2, int n3, int n4) {
        this.a(c_g, n, n2, n3, n4, 1.0f);
    }

    @Override
    public final int a(int n, int n2) {
        return n == 1 && n2 > 0 ? this.as - 1 : (n == 1 ? this.as : 2);
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (random.nextInt(5) == 0 && !c_g.multiplayerWorld) {
            int n4;
            int n5;
            boolean bl;
            int n6 = n3;
            int n7 = n2;
            int n8 = n;
            C_g c_g2 = c_g;
            int n9 = n - 4;
            block0: while (true) {
                if (n9 > n8 + 4) {
                    bl = false;
                    break;
                }
                for (n5 = n7; n5 <= n7 + 1; ++n5) {
                    for (n4 = n6 - 4; n4 <= n6 + 4; ++n4) {
                        if (c_g2.f(n9, n5, n4) != C_c.f) continue;
                        bl = true;
                        break block0;
                    }
                }
                ++n9;
            }
            if (bl) {
                c_g.setBlockMetadata(n, n2, n3, 7);
                return;
            }
            byte by = c_g.e(n, n2, n3);
            if (by > 0) {
                c_g.setBlockMetadata(n, n2, n3, by - 1);
                return;
            }
            n6 = n3;
            n7 = n2;
            n8 = n;
            c_g2 = c_g;
            n5 = n;
            block3: while (true) {
                if (n5 > n8) {
                    bl = false;
                    break;
                }
                for (n4 = n6; n4 <= n6; ++n4) {
                    if (c_g2.a(n5, n7 + 1, n4) != C_x.ao.at) continue;
                    bl = true;
                    break block3;
                }
                ++n5;
            }
            if (!bl) {
                c_g.b(n, n2, n3, C_x.k.at);
            }
        }
    }

    @Override
    public final void g(C_g c_g, int n, int n2, int n3) {
        if (c_g.q.nextInt(4) == 0) {
            c_g.b(n, n2, n3, C_x.k.at);
        }
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        super.b(c_g, n, n2, n3, n4);
        if (c_g.f(n, n2 + 1, n3).a()) {
            c_g.b(n, n2, n3, C_x.k.at);
        }
    }

    @Override
    public final int a(int n, Random random) {
        return C_x.k.a(0, random);
    }
}

