/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.c.C_c;
import net.minecraft.a.a.c.C_d;
import net.minecraft.a.a.c.C_e;
import net.minecraft.game.level.block.plants.BlockFlower;

public final class BlockSapling
extends BlockFlower {
    private static String[] NAME_LIST = new String[]{"Oak", "Apple Tree", "Birch", "Palm", "Pine"};

    public BlockSapling(int n, int n2) {
        super(n, n2);
        this.a(0.099999994f, 0.0f, 0.099999994f, 0.9f, 0.8f, 0.9f);
        this.hasStates = true;
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && random.nextInt(125) == 0) {
            byte by = c_g.e(n, n2, n3);
            C_c c_c = new C_c(false);
            C_d c_d = new C_d();
            C_e c_e = new C_e();
            c_g.d(n, n2, n3, 0);
            if (by == 3) {
                if (!c_g.growPalmTrees(n, n2, n3)) {
                    c_g.d(n, n2, n3, this.at);
                }
            } else if (by == 4) {
                if (random.nextBoolean()) {
                    if (!c_d.generate(c_g, random, n, n2, n3)) {
                        c_g.d(n, n2, n3, this.at);
                    }
                } else if (!c_e.generate(c_g, random, n, n2, n3)) {
                    c_g.d(n, n2, n3, this.at);
                }
            } else if (by == 1) {
                c_c.setScale(0.3, 1.0, 0.3);
                c_c.metadata = 1;
                c_c.leafDistanceLimit = 5;
                if (!c_c.generate(c_g, c_g.q, n, n2, n3)) {
                    c_g.d(n, n2, n3, this.at);
                }
            } else if (!c_g.growTrees(n, n2, n3, by)) {
                c_g.d(n, n2, n3, this.at);
            }
        }
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 1: {
                this.as = Block.ladder.as + n2;
                break;
            }
            case 2: {
                this.as = 329;
                break;
            }
            case 3: {
                this.as = 361;
                break;
            }
            case 4: {
                this.as = 393;
                break;
            }
            default: {
                this.as = 15;
            }
        }
        return this.as;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 4;
    }

    public static int getSaplingName(int n) {
        return n;
    }

    @Override
    public String getBlockName(int n) {
        if (n < 5) {
            return NAME_LIST[BlockSapling.getSaplingName(n)] + " Sapling";
        }
        return "Oak Sapling";
    }
}

