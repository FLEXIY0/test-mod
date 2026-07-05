/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_b;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public final class BlockFurnace
extends BlockContainer {
    private Random furnaceRand = new Random();
    private final boolean isActive;
    private static boolean keepFurnaceInventory = false;

    public BlockFurnace(int n, boolean bl) {
        super(n, C_c.d);
        this.isActive = bl;
        this.as = 77;
    }

    @Override
    public void g(C_g c_g, int n, int n2, int n3, int n4) {
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
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return 259;
        }
        if (n4 == 0) {
            return 259;
        }
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.g(c_g, n, n2, n3, n4);
            by = c_g.e(n, n2, n3);
        }
        return n4 != by ? this.as : (this.isActive ? 713 : this.as - 1);
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, Random random) {
        if (this.isActive) {
            if (random.nextInt(24) == 0) {
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.furnace", 0.3f, random.nextFloat() * 0.7f + 0.3f);
            }
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
        return n == 1 ? 259 : (n == 0 ? 259 : (n == 3 ? (this.isActive ? this.as + 32 : this.as - 1) : this.as));
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        C_b c_b = (C_b)c_g.j(n, n2, n3);
        entityPlayer.a(c_b);
        return true;
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        c_g.a(n, n2, n3, this.getBlockEntity());
    }

    @Override
    public final C_a getBlockEntity() {
        return new C_b();
    }

    @Override
    public int a(int n, Random random) {
        return C_x.aq.at;
    }

    @Override
    public final void dropBlockAsItemWithChance(C_g c_g, int n, int n2, int n3, int n4) {
        this.a(c_g, n, n2, n3, n4, 1.0f);
    }

    public static void updateFurnaceBlockState(boolean bl, C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        C_a c_a = c_g.j(n, n2, n3);
        keepFurnaceInventory = true;
        if (bl) {
            c_g.b(n, n2, n3, C_x.ar.at);
        } else {
            c_g.b(n, n2, n3, C_x.aq.at);
        }
        keepFurnaceInventory = false;
        c_g.setBlockMetadata(n, n2, n3, by);
        c_a.unmarkForRemoval();
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3) {
        if (!keepFurnaceInventory) {
            C_b c_b = (C_b)c_g.j(n, n2, n3);
            for (int i = 0; i < c_b.a(); ++i) {
                ItemStack itemStack = c_b.a(i);
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
                    net.minecraft.a.c.c.C_b c_b2 = new net.minecraft.a.c.c.C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.getItemDamage()));
                    float f4 = 0.05f;
                    c_b2.k = (float)this.furnaceRand.nextGaussian() * f4;
                    c_b2.l = (float)this.furnaceRand.nextGaussian() * f4 + 0.2f;
                    c_b2.m = (float)this.furnaceRand.nextGaussian() * f4;
                    c_g.spawnEntityInWorld(c_b2);
                }
            }
        }
        super.b(c_g, n, n2, n3);
    }
}

