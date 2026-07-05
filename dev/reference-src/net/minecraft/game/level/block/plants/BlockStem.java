/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockStem
extends BlockFlower {
    private Block fruitType;

    public BlockStem(int n, int n2, Block c_x) {
        super(n, n2);
        this.fruitType = c_x;
        this.a(true);
        float f = 0.125f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.hasStates = true;
    }

    @Override
    protected final boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == Block.ap.at;
    }

    @Override
    public int a() {
        return 40;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        float f;
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && random.nextInt((int)(100.0f / (f = this.tickBlock(c_g, n, n2, n3)))) == 0) {
            int n4 = c_g.e(n, n2, n3);
            if (n4 < 7) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, ++n4);
            } else {
                if (c_g.a(n - 1, n2, n3) == this.fruitType.at) {
                    return;
                }
                if (c_g.a(n + 1, n2, n3) == this.fruitType.at) {
                    return;
                }
                if (c_g.a(n, n2, n3 - 1) == this.fruitType.at) {
                    return;
                }
                if (c_g.a(n, n2, n3 + 1) == this.fruitType.at) {
                    return;
                }
                int n5 = random.nextInt(4);
                int n6 = n;
                int n7 = n3;
                if (n5 == 0) {
                    n6 = n - 1;
                }
                if (n5 == 1) {
                    ++n6;
                }
                if (n5 == 2) {
                    n7 = n3 - 1;
                }
                if (n5 == 3) {
                    ++n7;
                }
                if (c_g.a(n6, n2, n7) == 0 && c_g.f(n6, n2 - 1, n7) == C_c.b) {
                    c_g.b(n6, n2, n7, this.fruitType.at);
                }
            }
        }
    }

    public void fertilize(World c_g, int n, int n2, int n3) {
        c_g.setBlockMetadataWithNotify(n, n2, n3, 7);
    }

    private float tickBlock(World c_g, int n, int n2, int n3) {
        float f = 1.0f;
        int n4 = c_g.a(n, n2, n3 - 1);
        int n5 = c_g.a(n, n2, n3 + 1);
        int n6 = c_g.a(n - 1, n2, n3);
        int n7 = c_g.a(n + 1, n2, n3);
        int n8 = c_g.a(n - 1, n2, n3 - 1);
        int n9 = c_g.a(n + 1, n2, n3 - 1);
        int n10 = c_g.a(n + 1, n2, n3 + 1);
        int n11 = c_g.a(n - 1, n2, n3 + 1);
        boolean bl = n6 == this.at || n7 == this.at;
        boolean bl2 = n4 == this.at || n5 == this.at;
        boolean bl3 = n8 == this.at || n9 == this.at || n10 == this.at || n11 == this.at;
        for (int i = n - 1; i <= n + 1; ++i) {
            for (int j = n3 - 1; j <= n3 + 1; ++j) {
                int n12 = c_g.a(i, n2 - 1, j);
                float f2 = 0.0f;
                if (n12 == Block.ap.at) {
                    f2 = 1.0f;
                    if (c_g.e(i, n2 - 1, j) > 0 && c_g.season.currentSeason != 3) {
                        switch (c_g.season.currentSeason) {
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
                if (i != n || j != n3) {
                    f2 /= 4.0f;
                }
                f += f2;
            }
        }
        if (bl3 || bl && bl2) {
            f /= 2.0f;
        }
        return f;
    }

    @Override
    public int a(int n, int n2) {
        return this.as;
    }

    @Override
    public int getMaxDamage() {
        return 7;
    }

    public void setBlockBoundsForItemRender() {
        float f = 0.125f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        this.ay = (float)(c_g.e(n, n2, n3) * 2 + 2) / 16.0f;
        float f = 0.125f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, this.ay, 0.5f + f);
    }

    public int getState(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        return by < 7 ? -1 : (c_g.a(n - 1, n2, n3) == this.fruitType.at ? 0 : (c_g.a(n + 1, n2, n3) == this.fruitType.at ? 1 : (c_g.a(n, n2, n3 - 1) == this.fruitType.at ? 2 : (c_g.a(n, n2, n3 + 1) == this.fruitType.at ? 3 : -1))));
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        super.a(c_g, n, n2, n3, n4, f);
        if (!c_g.multiplayerWorld) {
            Item item = null;
            if (this.fruitType == Block.pumpkin) {
                item = Item.seedsPumpkin;
            }
            if (this.fruitType == Block.melon) {
                item = Item.seedsMelon;
            }
            if (c_g.q.nextInt(15) <= n4) {
                float f2 = 0.7f;
                float f3 = c_g.q.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                float f4 = c_g.q.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                float f5 = c_g.q.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                C_b c_b = new C_b(c_g, (float)n + f3, (float)n2 + f4, (float)n3 + f5, new ItemStack(item));
                c_b.O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public int a(int n, Random random) {
        if (n == 7) {
            // empty if block
        }
        return -1;
    }

    @Override
    public int a(Random random) {
        return 1;
    }
}

