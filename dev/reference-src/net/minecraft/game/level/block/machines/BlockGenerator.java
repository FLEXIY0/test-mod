/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public final class BlockGenerator
extends BlockContainer {
    private Random furnaceRand = new Random();
    private final boolean isActive;
    private static boolean keepFurnaceInventory = false;

    public BlockGenerator(int n, boolean bl) {
        super(n, Material.e);
        this.isActive = bl;
        this.as = 556;
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            int n5 = MathHelper.a((double)(c_g.y.n * 4.0f / 360.0f) + 0.5) & 3;
            if (n5 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
            }
            if (n5 == 1) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 5);
            }
            if (n5 == 2) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
            }
            if (n5 == 3) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 4);
            }
        }
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return 38;
        }
        if (n4 == 0) {
            return 102;
        }
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.g(c_g, n, n2, n3, n4);
            by = c_g.e(n, n2, n3);
        }
        return n4 != by ? this.as + 3 : (this.isActive ? this.as + 1 : this.as);
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, Random random) {
        if (this.isActive) {
            byte by = c_g.e(n, n2, n3);
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + random.nextFloat() * 6.0f / 16.0f;
            float f3 = (float)n3 + 0.5f;
            float f4 = random.nextFloat() * 0.6f - 0.3f;
            if (by == 4) {
                c_g.a("smoke", f - 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
                c_g.a("flame", f - 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            } else if (by == 5) {
                c_g.a("smoke", f + 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
                c_g.a("flame", f + 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            } else if (by == 2) {
                c_g.a("smoke", f + f4, f2, f3 - 0.52f, 0.0f, 0.0f, 0.0f);
                c_g.a("flame", f + f4, f2, f3 - 0.52f, 0.0f, 0.0f, 0.0f);
            } else if (by == 3) {
                c_g.a("smoke", f + f4, f2, f3 + 0.52f, 0.0f, 0.0f, 0.0f);
                c_g.a("flame", f + f4, f2, f3 + 0.52f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    @Override
    public final int a(int n) {
        return n == 1 ? 38 : (n == 0 ? 102 : (n == 3 ? (this.isActive ? this.as + 1 : this.as) : this.as + 3));
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        C_h c_h = (C_h)c_g.j(n, n2, n3);
        entityPlayer.displayGUIGenerator(c_h);
        return true;
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
    }

    @Override
    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        c_g.a(n, n2, n3, this.getBlockEntity());
    }

    @Override
    public final TileEntity getBlockEntity() {
        return new C_h();
    }

    @Override
    public int a(int n, Random random) {
        return Block.generator.at;
    }

    @Override
    public final void dropBlockAsItemWithChance(World c_g, int n, int n2, int n3, int n4) {
        this.a(c_g, n, n2, n3, n4, 1.0f);
    }

    @Override
    public boolean isProvidingStrongPower(World c_g, int n, int n2, int n3, int n4) {
        return this.isActive;
    }

    @Override
    public boolean isProvidingWeakPower(World c_g, int n, int n2, int n3, int n4) {
        return this.isActive;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void breakBlock(World c_g, int n, int n2, int n3, int n4, int n5) {
        c_g.c(n, n2, n3, this.at);
        super.breakBlock(c_g, n, n2, n3, n4, n5);
    }

    public static void updateBlockState(boolean bl, World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        TileEntity c_a = c_g.j(n, n2, n3);
        keepFurnaceInventory = true;
        if (bl) {
            c_g.a(n, n2, n3, Block.generatorActive.at);
            net.minecraft.client.d.getMinecraft().f.triggerAchievement(AchievementList.buildGenerator);
        } else {
            c_g.a(n, n2, n3, Block.generator.at);
        }
        c_g.c(n, n2, n3 - 1, Block.generatorActive.at);
        c_g.c(n, n2, n3 + 1, Block.generatorActive.at);
        c_g.c(n + 1, n2, n3, Block.generatorActive.at);
        c_g.c(n - 1, n2, n3, Block.generatorActive.at);
        c_g.c(n, n2 + 1, n3, Block.generatorActive.at);
        c_g.c(n, n2 - 1, n3, Block.generatorActive.at);
        keepFurnaceInventory = false;
        c_g.setBlockMetadata(n, n2, n3, by);
        c_a.unmarkForRemoval();
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        if (!keepFurnaceInventory) {
            C_h c_h = (C_h)c_g.j(n, n2, n3);
            for (int i = 0; i < c_h.a(); ++i) {
                ItemStack itemStack = c_h.a(i);
                if (itemStack == null) continue;
                float f = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                float f2 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                float f3 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                while (itemStack.a > 0) {
                    int n4 = this.furnaceRand.nextInt(21) + 10;
                    if (n4 > itemStack.a) {
                        n4 = itemStack.a;
                    }
                    itemStack.a -= n4;
                    EntityItem c_b = new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.getItemDamage()));
                    float f4 = 0.05f;
                    c_b.k = (float)this.furnaceRand.nextGaussian() * f4;
                    c_b.l = (float)this.furnaceRand.nextGaussian() * f4 + 0.2f;
                    c_b.m = (float)this.furnaceRand.nextGaussian() * f4;
                    c_g.spawnEntityInWorld(c_b);
                }
            }
        }
        c_g.c(n, n2, n3 - 1, Block.generatorActive.at);
        c_g.c(n, n2, n3 + 1, Block.generatorActive.at);
        c_g.c(n + 1, n2, n3, Block.generatorActive.at);
        c_g.c(n - 1, n2, n3, Block.generatorActive.at);
        c_g.c(n, n2 + 1, n3, Block.generatorActive.at);
        c_g.c(n, n2 - 1, n3, Block.generatorActive.at);
        super.b(c_g, n, n2, n3);
    }
}

