/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockCrops
extends BlockFlower {
    public BlockCrops(int n, int n2) {
        super(n, n2);
        this.a(true);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
        this.hasStates = true;
    }

    @Override
    protected final boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == C_x.ap.at;
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        byte by;
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && (by = c_g.e(n, n2, n3)) < 7) {
            int n4 = n3;
            int n5 = n2;
            int n6 = n;
            C_g c_g2 = c_g;
            float f = 1.0f;
            int n7 = c_g.a(n, n2, n3 - 1);
            int n8 = c_g.a(n, n2, n3 + 1);
            int n9 = c_g.a(n - 1, n2, n3);
            int n10 = c_g.a(n + 1, n2, n3);
            int n11 = c_g.a(n - 1, n2, n3 - 1);
            int n12 = c_g.a(n + 1, n2, n3 - 1);
            int n13 = c_g.a(n + 1, n2, n3 + 1);
            int n14 = c_g.a(n - 1, n2, n3 + 1);
            boolean bl = n9 == this.at || n10 == this.at;
            boolean bl2 = n7 == this.at || n8 == this.at;
            boolean bl3 = n11 == this.at || n12 == this.at || n13 == this.at || n14 == this.at;
            for (n8 = n - 1; n8 <= n6 + 1; ++n8) {
                for (n10 = n4 - 1; n10 <= n4 + 1; ++n10) {
                    n11 = c_g2.a(n8, n5 - 1, n10);
                    float f2 = 0.0f;
                    if (n11 == C_x.ap.at) {
                        f2 = 1.0f;
                        if (c_g2.e(n8, n5 - 1, n10) > 0 && c_g2.season.currentSeason != 3) {
                            switch (c_g2.season.currentSeason) {
                                case 2: {
                                    f2 = 2.0f;
                                    break;
                                }
                                case 1: {
                                    f2 = 3.0f;
                                    break;
                                }
                                case 0: {
                                    f2 = 4.0f;
                                }
                            }
                        }
                    }
                    if (n8 != n6 || n10 != n4) {
                        f2 /= 4.0f;
                    }
                    f += f2;
                }
            }
            if (bl3 || bl && bl2) {
                f /= 2.0f;
            }
            if (random.nextInt((int)(100.0f / f)) == 0) {
                int n15 = by + 1;
                c_g.setBlockMetadata(n, n2, n3, n15);
            }
        }
    }

    @Override
    public final int a(int n, int n2) {
        if (n2 < 0) {
            n2 = 7;
        }
        return this.as + n2;
    }

    @Override
    public int a() {
        return 6;
    }

    @Override
    public int getMaxDamage() {
        return 7;
    }

    @Override
    public final void c(C_g c_g, int n, int n2, int n3, int n4) {
        super.c(c_g, n, n2, n3, n4);
        if (!c_g.multiplayerWorld) {
            for (int i = 0; i < 3; ++i) {
                if (c_g.q.nextInt(15) > n4) continue;
                float f = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.O));
                new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.O)).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        int n4 = c_g.e(n, n2, n3) & 7;
        float f = (float)(2 * (1 + n4)) / 16.0f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public final int a(int n, Random random) {
        return n == 7 ? Item.P.ap : -1;
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    public void fertilize(C_g c_g, int n, int n2, int n3) {
        c_g.setBlockMetadataWithNotify(n, n2, n3, 7);
    }
}

