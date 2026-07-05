/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_p;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public final class C_m
extends C_p {
    private int aD;
    private int aE;
    private Random aF = new Random();
    private int[] aG = new int[]{0, 1, 2, 3};
    private int numAdjacentSources = 0;
    private boolean[] isOptimalFlowDirection = new boolean[4];
    private int[] flowCost = new int[4];

    protected C_m(int n, Material c_c) {
        super(n, c_c);
        this.as = 14;
        if (c_c == Material.g) {
            this.as = 46;
        }
        Block.g[n] = true;
        this.aE = n;
        this.aD = n + 1;
        this.a(0.01f, -0.09f, 0.01f, 1.01f, 0.90999997f, 1.01f);
        this.a(true);
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        c_g.e(n, n2, n3, this.aE);
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        this.e(c_g, n, n2, n3, 0);
    }

    @Override
    public final boolean e(World c_g, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        boolean bl = false;
        boolean bl2 = this.e(c_g, n - 1, n2, n3) || this.e(c_g, n + 1, n2, n3) || this.e(c_g, n, n2, n3 - 1) || this.e(c_g, n, n2, n3 + 1);
        if (bl2 && c_g.f(n, n2 - 1, n3) == this.aC && !c_g.floodFill(n, n2 - 1, n3, this.aE, this.aD)) {
            int n8 = c_g.a(n, n2, n3, this.aE, this.aD);
            if (n8 != -9999) {
                if (n8 < 0) {
                    return false;
                }
                int n9 = n8 % 1024;
                int n10 = (n8 >>= 10) % 1024;
                n = (n8 >>= 10) % 1024;
                c_g.b(n9, n, n10, 0);
                return false;
            }
            return false;
        }
        bl = this.a(c_g, n, n2, n3, n, n2 - 1, n3);
        for (n7 = 0; n7 < 4; ++n7) {
            n6 = this.aF.nextInt(4 - n7) + n7;
            n5 = this.aG[n7];
            this.aG[n7] = this.aG[n6];
            this.aG[n6] = n5;
            if (this.aG[n7] == 0 && !bl) {
                bl = this.a(c_g, n, n2, n3, n - 1, n2, n3);
            }
            if (this.aG[n7] == 1 && !bl) {
                bl = this.a(c_g, n, n2, n3, n + 1, n2, n3);
            }
            if (this.aG[n7] == 2 && !bl) {
                bl = this.a(c_g, n, n2, n3, n, n2, n3 - 1);
            }
            if (this.aG[n7] != 3 || bl) continue;
            bl = this.a(c_g, n, n2, n3, n, n2, n3 + 1);
        }
        if (!bl && bl2) {
            if (this.aF.nextInt(3) == 0) {
                bl = false;
                for (n7 = 0; n7 < 4; ++n7) {
                    n6 = this.aF.nextInt(4 - n7) + n7;
                    n5 = this.aG[n7];
                    this.aG[n7] = this.aG[n6];
                    this.aG[n6] = n5;
                    if (this.aG[n7] == 0 && !bl) {
                        bl = this.a(c_g, n, n2, n3, n - 1, n2, n3);
                    }
                    if (this.aG[n7] == 1 && !bl) {
                        bl = this.a(c_g, n, n2, n3, n + 1, n2, n3);
                    }
                    if (this.aG[n7] == 2 && !bl) {
                        bl = this.a(c_g, n, n2, n3, n, n2, n3 - 1);
                    }
                    if (this.aG[n7] != 3 || bl) continue;
                    bl = this.a(c_g, n, n2, n3, n, n2, n3 + 1);
                }
            } else {
                this.flowOutwards(c_g, n, n2, n3, this.aF);
            }
            return false;
        }
        if (this.aC == Material.f) {
            bl = bl | C_m.h(c_g, n - 1, n2, n3) | C_m.h(c_g, n + 1, n2, n3) | C_m.h(c_g, n, n2, n3 - 1) | C_m.h(c_g, n, n2, n3 + 1);
        }
        if (this.aC == Material.g) {
            bl = bl | C_m.i(c_g, n - 1, n2, n3) | C_m.i(c_g, n + 1, n2, n3) | C_m.i(c_g, n, n2, n3 - 1) | C_m.i(c_g, n, n2, n3 + 1);
        }
        if (!bl) {
            c_g.d(n, n2, n3, this.aD);
        } else {
            c_g.e(n, n2, n3, this.aE);
        }
        return bl;
    }

    private void updateFlow(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        c_g.setBlockAndMetadata(n, n2, n3, this.at + 1, by);
        c_g.markBlocksDirty(n, n2, n3, n, n2, n3);
    }

    public final void flowOutwards(World c_g, int n, int n2, int n3, Random random) {
        int n4;
        int n5;
        int n6 = this.getFlowDecay(c_g, n, n2, n3);
        boolean bl = true;
        if (n6 > 0) {
            this.numAdjacentSources = 0;
            n5 = this.getSmallestFlowDecay(c_g, n - 1, n2, n3, -100);
            n5 = this.getSmallestFlowDecay(c_g, n + 1, n2, n3, n5);
            n5 = this.getSmallestFlowDecay(c_g, n, n2, n3 - 1, n5);
            n4 = (n5 = this.getSmallestFlowDecay(c_g, n, n2, n3 + 1, n5)) + this.liquidType;
            if (n4 >= 8 || n5 < 0) {
                n4 = -1;
            }
            if (this.getFlowDecay(c_g, n, n2 + 1, n3) >= 0) {
                n5 = this.getFlowDecay(c_g, n, n2 + 1, n3);
                n4 = n5 >= 8 ? n5 : n5 + 8;
            }
            if (this.numAdjacentSources >= 2 && this.aC == Material.f) {
                n4 = 0;
            }
            if (this.aC == Material.g && n6 < 8 && n4 < 8 && n4 > n6 && random.nextInt(4) != 0) {
                n4 = n6;
                bl = false;
            }
            if (n4 != n6) {
                n6 = n4;
                if (n4 < 0) {
                    c_g.b(n, n2, n3, 0);
                } else {
                    c_g.setBlockMetadata(n, n2, n3, n4);
                    c_g.e(n, n2, n3, this.at);
                    c_g.c(n, n2, n3, this.at);
                }
            } else if (bl) {
                this.updateFlow(c_g, n, n2, n3);
            }
        } else {
            this.updateFlow(c_g, n, n2, n3);
        }
        if (this.liquidCanDisplaceBlock(c_g, n, n2 - 1, n3)) {
            if (n6 >= 8) {
                c_g.setBlockAndMetadataWithNotify(n, n2 - 1, n3, this.at, n6);
            } else {
                c_g.setBlockAndMetadataWithNotify(n, n2 - 1, n3, this.at, n6 + 8);
            }
        } else if (n6 >= 0 && (n6 == 0 || C_m.blockBlocksFlow(c_g, n, n2 - 1, n3))) {
            int n7;
            int n8;
            int n9 = n3;
            n4 = n2;
            n5 = n;
            World c_g2 = c_g;
            C_m c_m = this;
            for (n8 = 0; n8 < 4; ++n8) {
                c_m.flowCost[n8] = 1000;
                n7 = n5;
                int n10 = n9;
                if (n8 == 0) {
                    n7 = n5 - 1;
                }
                if (n8 == 1) {
                    ++n7;
                }
                if (n8 == 2) {
                    n10 = n9 - 1;
                }
                if (n8 == 3) {
                    ++n10;
                }
                if (C_m.blockBlocksFlow(c_g2, n7, n4, n10) || c_g2.f(n7, n4, n10) == c_m.aC && c_g2.e(n7, n4, n10) == 0) continue;
                c_m.flowCost[n8] = !C_m.blockBlocksFlow(c_g2, n7, n4 - 1, n10) ? 0 : c_m.calculateFlowCost(c_g2, n7, n4, n10, 1, n8);
            }
            n8 = c_m.flowCost[0];
            for (n7 = 1; n7 < 4; ++n7) {
                if (c_m.flowCost[n7] >= n8) continue;
                n8 = c_m.flowCost[n7];
            }
            for (n7 = 0; n7 < 4; ++n7) {
                c_m.isOptimalFlowDirection[n7] = c_m.flowCost[n7] == n8;
            }
            boolean[] blArray = c_m.isOptimalFlowDirection;
            n4 = n6 + this.liquidType;
            if (n6 >= 8) {
                n4 = 1;
            }
            if (n4 >= 8) {
                return;
            }
            if (blArray[0]) {
                this.flowIntoBlock(c_g, n - 1, n2, n3, n4);
            }
            if (blArray[1]) {
                this.flowIntoBlock(c_g, n + 1, n2, n3, n4);
            }
            if (blArray[2]) {
                this.flowIntoBlock(c_g, n, n2, n3 - 1, n4);
            }
            if (blArray[3]) {
                this.flowIntoBlock(c_g, n, n2, n3 + 1, n4);
            }
        }
    }

    private int calculateFlowCost(World c_g, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1000;
        for (int i = 0; i < 4; ++i) {
            if (i == 0 && n5 == 1 || i == 1 && n5 == 0 || i == 2 && n5 == 3 || i == 3 && n5 == 2) continue;
            int n7 = n;
            int n8 = n3;
            if (i == 0) {
                n7 = n - 1;
            }
            if (i == 1) {
                ++n7;
            }
            if (i == 2) {
                n8 = n3 - 1;
            }
            if (i == 3) {
                ++n8;
            }
            if (C_m.blockBlocksFlow(c_g, n7, n2, n8) || c_g.f(n7, n2, n8) == this.aC && c_g.e(n7, n2, n8) == 0) continue;
            if (!C_m.blockBlocksFlow(c_g, n7, n2 - 1, n8)) {
                return n4;
            }
            if (n4 >= 4 || (n7 = this.calculateFlowCost(c_g, n7, n2, n8, n4 + 1, i)) >= n6) continue;
            n6 = n7;
        }
        return n6;
    }

    private void flowIntoBlock(World c_g, int n, int n2, int n3, int n4) {
        if (this.liquidCanDisplaceBlock(c_g, n, n2, n3)) {
            int n5 = c_g.a(n, n2, n3);
            if (n5 > 0) {
                Block.c[n5].f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            }
            c_g.setBlockAndMetadataWithNotify(n, n2, n3, this.at, n4);
        }
    }

    private boolean liquidCanDisplaceBlock(World c_g, int n, int n2, int n3) {
        Material c_c = c_g.f(n, n2, n3);
        return c_c == this.aC ? false : (c_c == Material.g ? false : !C_m.blockBlocksFlow(c_g, n, n2, n3));
    }

    private static boolean blockBlocksFlow(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        return n4 != Block.doorOak.at && n4 != Block.signStanding.at && n4 != Block.ladder.at ? (n4 == 0 ? false : Block.c[n4].aC.a()) : true;
    }

    private int getSmallestFlowDecay(World c_g, int n, int n2, int n3, int n4) {
        int n5 = this.getFlowDecay(c_g, n, n2, n3);
        if (n5 < 0) {
            return n4;
        }
        if (n5 == 0) {
            ++this.numAdjacentSources;
        }
        if (n5 >= 8) {
            n5 = 0;
        }
        return n4 >= 0 && n5 >= n4 ? n4 : n5;
    }

    private boolean a(World c_g, int n, int n2, int n3, int n4, int n5, int n6) {
        if (!this.e(c_g, n4, n5, n6)) {
            return false;
        }
        if ((n = c_g.a(n, n2, n3, this.aE, this.aD)) != -9999) {
            if (n < 0) {
                return false;
            }
            n2 = n % 1024;
            n3 = (n >>= 10) % 1024;
            n >>= 10;
            if (!((n %= 1024) <= n5 && this.e(c_g, n4, n5 - 1, n6) || n > n5 || n2 == 0 || n2 == c_g.a - 1 || n3 == 0 || n3 == c_g.b - 1)) {
                return false;
            }
            c_g.b(n2, n, n3, 0);
        }
        c_g.b(n4, n5, n6, this.at);
        c_g.e(n4, n5, n6, this.at);
        return true;
    }

    @Override
    public final boolean d(World c_g, int n, int n2, int n3, int n4) {
        int n5;
        return n >= 0 && n2 >= 0 && n3 >= 0 && n < c_g.a && n3 < c_g.b ? ((n5 = c_g.a(n, n2, n3)) != this.aE && n5 != this.aD && n5 != Block.coralFan.at ? (n4 == 1 && (c_g.a(n - 1, n2, n3) == 0 || c_g.a(n + 1, n2, n3) == 0 || c_g.a(n, n2, n3 - 1) == 0 || c_g.a(n, n2, n3 + 1) == 0) ? true : super.d(c_g, n, n2, n3, n4)) : false) : false;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    public final boolean isOpaqueCube() {
        return false;
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
    }

    @Override
    public final int e() {
        return this.aC == Material.g ? 25 : 5;
    }

    @Override
    public final int a(Random random) {
        return 0;
    }

    @Override
    public final int f() {
        return this.aC == Material.f ? 1 : 0;
    }

    private static boolean h(World c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2, n3) == Block.ag.at || c_g.a(n, n2, n3) == Block.hellfire.at) {
            c_g.b(n, n2, n3, 0);
            return true;
        }
        if (c_g.a(n, n2, n3) != Block.r.at && c_g.a(n, n2, n3) != Block.s.at) {
            return false;
        }
        c_g.b(n, n2, n3, Block.ae.at);
        return true;
    }

    private static boolean i(World c_g, int n, int n2, int n3) {
        if (Block.ag.b(c_g.a(n, n2, n3))) {
            Block.ag.h(c_g, n, n2, n3);
            return true;
        }
        return false;
    }
}

