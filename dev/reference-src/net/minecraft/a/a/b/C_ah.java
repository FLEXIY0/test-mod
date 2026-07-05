/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public final class C_ah
extends Block {
    private int[] a = new int[256];
    private int[] b = new int[256];

    protected C_ah(int n, int n2) {
        super(n, n2, Material.l);
        this.c(Block.m.at, 5, 20);
        this.c(Block.y.at, 5, 5);
        this.c(Block.log.at, 5, 5);
        this.c(Block.z.at, 30, 60);
        this.c(Block.tallGrass.at, 30, 60);
        this.c(Block.plantBlue.at, 30, 60);
        this.c(Block.plantPurple.at, 30, 60);
        this.c(Block.plantRed.at, 30, 60);
        this.c(Block.plantYellow.at, 30, 60);
        this.c(Block.n.at, 30, 60);
        this.c(Block.ab.at, 15, 100);
        this.c(Block.cloth.at, 30, 60);
        this.c(Block.stairWood.at, 5, 20);
        this.c(Block.chair.at, 10, 30);
        this.c(Block.chairBlack.at, 10, 30);
        this.c(Block.chairWhite.at, 10, 30);
        this.c(Block.chairRed.at, 10, 30);
        this.c(Block.table.at, 10, 30);
        this.c(Block.stairWood.at, 10, 30);
        this.c(Block.stairWoodBlack.at, 10, 30);
        this.c(Block.stairWoodWhite.at, 10, 30);
        this.c(Block.stairWoodCherry.at, 10, 30);
        this.c(Block.carpet.at, 30, 60);
        this.c(Block.fence.at, 10, 30);
        this.c(Block.fenceGateOak.at, 10, 30);
        this.c(Block.fenceGateBirch.at, 10, 30);
        this.c(Block.fenceGateSpruce.at, 10, 30);
        this.c(Block.fenceGatePalm.at, 10, 30);
        this.a(true);
    }

    private void c(int n, int n2, int n3) {
        this.a[n] = n2;
        this.b[n] = n3;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
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
    public final void a(World c_g, int n, int n2, int n3, Random random) {
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
                Block c_x;
                if ((!c_g.b(n, n2 - 1, n3) || by > by2) && ((c_x = Block.c[c_g.a(n, n2 - 1, n3)]) != Block.blockCoal && c_x != Block.magma || c_g.isBloodMoon())) {
                    c_g.b(n, n2, n3, Block.ash.at);
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

    private void a(World c_g, int n, int n2, int n3, int n4, Random random) {
        int n5 = this.b[c_g.a(n, n2, n3)];
        if (random.nextInt(n4) < n5 && !c_g.multiplayerWorld) {
            boolean bl;
            boolean bl2 = bl = c_g.a(n, n2, n3) == Block.ab.at;
            if (random.nextInt(2) == 0) {
                c_g.b(n, n2, n3, this.at);
            } else {
                c_g.b(n, n2, n3, 0);
            }
            if (bl) {
                Block.ab.c(c_g, n, n2, n3, 0);
            }
        }
    }

    private boolean i(World c_g, int n, int n2, int n3) {
        return this.e(c_g, n + 1, n2, n3) ? true : (this.e(c_g, n - 1, n2, n3) ? true : (this.e(c_g, n, n2 - 1, n3) ? true : (this.e(c_g, n, n2 + 1, n3) ? true : (this.e(c_g, n, n2, n3 - 1) ? true : this.e(c_g, n, n2, n3 + 1)))));
    }

    @Override
    public final boolean d() {
        return false;
    }

    public final boolean e(World c_g, int n, int n2, int n3) {
        return this.a[c_g.a(n, n2, n3)] > 0;
    }

    private int e(World c_g, int n, int n2, int n3, int n4) {
        int n5 = this.a[c_g.a(n, n2, n3)];
        return n5 > n4 ? n5 : n4;
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3) {
        return c_g.b(n, n2 - 1, n3) || this.i(c_g, n, n2, n3);
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.b(n, n2 - 1, n3) && !this.i(c_g, n, n2, n3)) {
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
        if (!c_g.b(n, n2 - 1, n3) && !this.i(c_g, n, n2, n3)) {
            c_g.b(n, n2, n3, 0);
        } else {
            c_g.e(n, n2, n3, this.at);
        }
    }

    public final boolean b(int n) {
        return this.a[n] > 0;
    }

    public final void h(World c_g, int n, int n2, int n3) {
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
            c_g.b(n, n2, n3, Block.ag.at);
        }
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, Random random) {
        block12: {
            block11: {
                float f;
                float f2;
                float f3;
                int n4;
                if (random.nextInt(24) == 0) {
                    c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                }
                if (c_g.b(n, n2 - 1, n3) || Block.ag.e(c_g, n, n2 - 1, n3)) break block11;
                if (Block.ag.e(c_g, n - 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (Block.ag.e(c_g, n + 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)(n + 1) - random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (Block.ag.e(c_g, n, n2, n3 - 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (Block.ag.e(c_g, n, n2, n3 + 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)(n3 + 1) - random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (!Block.ag.e(c_g, n, n2 + 1, n3)) break block12;
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

    private static boolean j(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        if (n4 == Block.ag.at) {
            return true;
        }
        if (n4 == 0) {
            c_g.b(n, n2, n3, Block.ag.at);
            return true;
        }
        return false;
    }
}

