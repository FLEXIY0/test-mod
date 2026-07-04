/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public final class C_ah
extends C_x {
    private int[] a = new int[256];
    private int[] b = new int[256];

    protected C_ah(int n, int n2) {
        super(n, n2, C_c.l);
        this.c(C_x.m.at, 5, 20);
        this.c(C_x.y.at, 5, 5);
        this.c(C_x.log.at, 5, 5);
        this.c(C_x.z.at, 30, 60);
        this.c(C_x.tallGrass.at, 30, 60);
        this.c(C_x.plantBlue.at, 30, 60);
        this.c(C_x.plantPurple.at, 30, 60);
        this.c(C_x.plantRed.at, 30, 60);
        this.c(C_x.plantYellow.at, 30, 60);
        this.c(C_x.n.at, 30, 60);
        this.c(C_x.ab.at, 15, 100);
        this.c(C_x.cloth.at, 30, 60);
        this.c(C_x.stairWood.at, 5, 20);
        this.c(C_x.chair.at, 10, 30);
        this.c(C_x.chairBlack.at, 10, 30);
        this.c(C_x.chairWhite.at, 10, 30);
        this.c(C_x.chairRed.at, 10, 30);
        this.c(C_x.table.at, 10, 30);
        this.c(C_x.stairWood.at, 10, 30);
        this.c(C_x.stairWoodBlack.at, 10, 30);
        this.c(C_x.stairWoodWhite.at, 10, 30);
        this.c(C_x.stairWoodCherry.at, 10, 30);
        this.c(C_x.carpet.at, 30, 60);
        this.c(C_x.fence.at, 10, 30);
        this.c(C_x.fenceGateOak.at, 10, 30);
        this.c(C_x.fenceGateBirch.at, 10, 30);
        this.c(C_x.fenceGateSpruce.at, 10, 30);
        this.c(C_x.fenceGatePalm.at, 10, 30);
        this.a(true);
    }

    private void c(int n, int n2, int n3) {
        this.a[n] = n2;
        this.b[n] = n3;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return null;
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
    public final int a() {
        return 3;
    }

    @Override
    public final int a(Random random) {
        return 0;
    }

    @Override
    public final int e() {
        return 20;
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (!c_g.multiplayerWorld) {
            byte by = c_g.e(n, n2, n3);
            if (by < 15) {
                c_g.setBlockMetadata(n, n2, n3, by + 1);
                c_g.e(n, n2, n3, this.at);
            }
            byte by2 = 3;
            if (c_g.getRaining()) {
                by2 = 0;
            }
            if (!this.i(c_g, n, n2, n3)) {
                C_x c_x;
                if ((!c_g.b(n, n2 - 1, n3) || by > by2) && ((c_x = C_x.c[c_g.a(n, n2 - 1, n3)]) != C_x.blockCoal && c_x != C_x.magma || c_g.isBloodMoon())) {
                    c_g.b(n, n2, n3, C_x.ash.at);
                }
            } else if (!this.e(c_g, n, n2 - 1, n3) && by == 15 && random.nextInt(4) == 0) {
                c_g.b(n, n2, n3, 0);
            } else if (by % 5 == 0 && by > 5) {
                this.a(c_g, n + 1, n2, n3, 300, random);
                this.a(c_g, n - 1, n2, n3, 300, random);
                this.a(c_g, n, n2 - 1, n3, 100, random);
                this.a(c_g, n, n2 + 1, n3, 200, random);
                this.a(c_g, n, n2, n3 - 1, 300, random);
                this.a(c_g, n, n2, n3 + 1, 300, random);
                for (int i = n - 1; i <= n + 1; ++i) {
                    for (int j = n3 - 1; j <= n3 + 1; ++j) {
                        for (int k = n2 - 1; k <= n2 + 4; ++k) {
                            int n4;
                            int n5;
                            if (i == n && k == n2 && j == n3) continue;
                            int n6 = 100;
                            if (k > n2 + 1) {
                                n6 = 100 + (k - (n2 + 1)) * 100;
                            }
                            if (c_g.a(i, k, j) != 0) {
                                n5 = 0;
                            } else {
                                n4 = this.e(c_g, i + 1, k, j, 0);
                                n4 = this.e(c_g, i - 1, k, j, n4);
                                n4 = this.e(c_g, i, k - 1, j, n4);
                                n4 = this.e(c_g, i, k + 1, j, n4);
                                n4 = this.e(c_g, i, k, j - 1, n4);
                                n5 = this.e(c_g, i, k, j + 1, n4);
                            }
                            n4 = n5;
                            if (n5 <= 0 || random.nextInt(n6) > n4) continue;
                            c_g.b(i, k, j, this.at);
                        }
                    }
                }
            }
        }
    }

    private void a(C_g c_g, int n, int n2, int n3, int n4, Random random) {
        int n5 = this.b[c_g.a(n, n2, n3)];
        if (random.nextInt(n4) < n5 && !c_g.multiplayerWorld) {
            boolean bl;
            boolean bl2 = bl = c_g.a(n, n2, n3) == C_x.ab.at;
            if (random.nextInt(2) == 0) {
                c_g.b(n, n2, n3, this.at);
            } else {
                c_g.b(n, n2, n3, 0);
            }
            if (bl) {
                C_x.ab.c(c_g, n, n2, n3, 0);
            }
        }
    }

    private boolean i(C_g c_g, int n, int n2, int n3) {
        return this.e(c_g, n + 1, n2, n3) ? true : (this.e(c_g, n - 1, n2, n3) ? true : (this.e(c_g, n, n2 - 1, n3) ? true : (this.e(c_g, n, n2 + 1, n3) ? true : (this.e(c_g, n, n2, n3 - 1) ? true : this.e(c_g, n, n2, n3 + 1)))));
    }

    @Override
    public final boolean d() {
        return false;
    }

    public final boolean e(C_g c_g, int n, int n2, int n3) {
        return this.a[c_g.a(n, n2, n3)] > 0;
    }

    private int e(C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = this.a[c_g.a(n, n2, n3)];
        return n5 > n4 ? n5 : n4;
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3) {
        return c_g.b(n, n2 - 1, n3) || this.i(c_g, n, n2, n3);
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!c_g.b(n, n2 - 1, n3) && !this.i(c_g, n, n2, n3)) {
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
        if (!c_g.b(n, n2 - 1, n3) && !this.i(c_g, n, n2, n3)) {
            c_g.b(n, n2, n3, 0);
        } else {
            c_g.e(n, n2, n3, this.at);
        }
    }

    public final boolean b(int n) {
        return this.a[n] > 0;
    }

    public final void h(C_g c_g, int n, int n2, int n3) {
        boolean bl = false;
        bl = C_ah.j(c_g, n, n2 + 1, n3);
        if (!bl) {
            bl = C_ah.j(c_g, n - 1, n2, n3);
        }
        if (!bl) {
            bl = C_ah.j(c_g, n + 1, n2, n3);
        }
        if (!bl) {
            bl = C_ah.j(c_g, n, n2, n3 - 1);
        }
        if (!bl) {
            bl = C_ah.j(c_g, n, n2, n3 + 1);
        }
        if (!bl) {
            bl = C_ah.j(c_g, n, n2 - 1, n3);
        }
        if (!bl) {
            c_g.b(n, n2, n3, C_x.ag.at);
        }
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, Random random) {
        block12: {
            block11: {
                float f;
                float f2;
                float f3;
                int n4;
                if (random.nextInt(24) == 0) {
                    c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                }
                if (c_g.b(n, n2 - 1, n3) || C_x.ag.e(c_g, n, n2 - 1, n3)) break block11;
                if (C_x.ag.e(c_g, n - 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n + 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)(n + 1) - random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n, n2, n3 - 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n, n2, n3 + 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)(n3 + 1) - random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (!C_x.ag.e(c_g, n, n2 + 1, n3)) break block12;
                for (n4 = 0; n4 < 2; ++n4) {
                    f3 = (float)n + random.nextFloat();
                    f2 = (float)(n2 + 1) - random.nextFloat() * 0.1f;
                    f = (float)n3 + random.nextFloat();
                    c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                }
                break block12;
            }
            for (int i = 0; i < 3; ++i) {
                float f = (float)n + random.nextFloat();
                float f4 = (float)n2 + random.nextFloat() * 0.5f + 0.5f;
                float f5 = (float)n3 + random.nextFloat();
                c_g.a("largesmoke", f, f4, f5, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private static boolean j(C_g c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        if (n4 == C_x.ag.at) {
            return true;
        }
        if (n4 == 0) {
            c_g.b(n, n2, n3, C_x.ag.at);
            return true;
        }
        return false;
    }
}

