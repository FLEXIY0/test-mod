/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import com.a.a.NBTTagCompound;
import java.util.Random;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_g;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.d.C_a;
import net.minecraft.a.c.d.C_d;
import net.minecraft.a.c.d.C_e;
import net.minecraft.a.c.d.C_f;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public class BlockDispenser
extends BlockContainer {
    private Random random = new Random();

    public BlockDispenser(int n) {
        super(n, Material.d);
        this.as = 331;
    }

    @Override
    public void d(net.minecraft.a.a.World c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        this.setDispenserDefaultDirection(c_g, n, n2, n3);
    }

    private void setDispenserDefaultDirection(net.minecraft.a.a.World c_g, int n, int n2, int n3) {
        if (!c_g.multiplayerWorld) {
            int n4 = c_g.a(n, n2, n3 - 1);
            int n5 = c_g.a(n, n2, n3 + 1);
            int n6 = c_g.a(n - 1, n2, n3);
            int n7 = c_g.a(n + 1, n2, n3);
            int n8 = 3;
            if (Block.e[n4] && !Block.e[n5]) {
                n8 = 3;
            }
            if (Block.e[n5] && !Block.e[n4]) {
                n8 = 2;
            }
            if (Block.e[n6] && !Block.e[n7]) {
                n8 = 5;
            }
            if (Block.e[n7] && !Block.e[n6]) {
                n8 = 4;
            }
            c_g.setBlockMetadataWithNotify(n, n2, n3, n8);
        }
    }

    @Override
    public int a(net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return 588;
        }
        if (n4 == 0) {
            return 611;
        }
        byte by = c_g.e(n, n2, n3);
        return n4 != by ? this.as : 646;
    }

    @Override
    public int a(int n) {
        return n == 1 ? 588 : (n == 0 ? 611 : (n == 3 ? 646 : this.as));
    }

    @Override
    public boolean a(net.minecraft.a.a.World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        C_g c_g2 = (C_g)c_g.j(n, n2, n3);
        if (c_g2 != null) {
            entityPlayer.displayGUIBarrel(c_g2, true);
        }
        return true;
    }

    private void dispenseItem(net.minecraft.a.a.World c_g, int n, int n2, int n3, Random random) {
        byte by = c_g.e(n, n2, n3);
        int n4 = 0;
        int n5 = 0;
        if (by == 3) {
            n5 = 1;
        } else if (by == 2) {
            n5 = -1;
        } else {
            n4 = by == 5 ? 1 : -1;
        }
        C_g c_g2 = (C_g)c_g.j(n, n2, n3);
        if (c_g2 != null) {
            ItemStack itemStack = c_g2.getRandomStackFromInventory();
            float f = (float)n + (float)n4 * 0.6f + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + (float)n5 * 0.6f + 0.5f;
            if (itemStack != null) {
                if (itemStack.c == Item.h.ap) {
                    C_a c_a = new C_a(c_g, f, f2, f3);
                    c_a.a(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_g.spawnEntityInWorld(c_a);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.arrowAdminium.ap) {
                    C_a c_a = new C_a(c_g, f, f2, f3);
                    c_a.a(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_a.arrowType = 1;
                    c_g.spawnEntityInWorld(c_a);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.dart.ap) {
                    net.minecraft.a.c.d.C_b c_b = new net.minecraft.a.c.d.C_b(c_g, f, f2, f3);
                    c_b.setArrowHeading(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_g.spawnEntityInWorld(c_b);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.dartPoison.ap) {
                    net.minecraft.a.c.d.C_b c_b = new net.minecraft.a.c.d.C_b(c_g, f, f2, f3);
                    c_b.setArrowHeading(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_b.arrowType = 1;
                    c_g.spawnEntityInWorld(c_b);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.snowball.ap) {
                    C_f c_f = new C_f(c_g, f, f2, f3);
                    c_f.setSnowballHeading(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_g.spawnEntityInWorld(c_f);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.sandball.ap) {
                    C_e c_e = new C_e(c_g, f, f2, f3);
                    c_e.setSnowballHeading(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_g.spawnEntityInWorld(c_e);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.c == Item.fireBall.ap) {
                    C_d c_d = new C_d(c_g, f, f2, f3);
                    c_d.setSnowballHeading(n4, 0.1f, n5, 1.1f, 6.0f);
                    c_g.spawnEntityInWorld(c_d);
                    c_g.playSoundAtBlock(f, f2 - 0.3f, f3, "random.bow", 1.0f, 1.0f / (c_g.I.nextFloat() * 0.4f + 0.8f));
                } else {
                    EntityItem c_b = new EntityItem(c_g, f, f2 - 0.3f, f3, itemStack);
                    float f4 = random.nextFloat() * 0.1f + 0.2f;
                    c_b.k = (float)n4 * f4;
                    c_b.l = 0.2f;
                    c_b.m = (float)n5 * f4;
                    c_b.k = (float)((double)c_b.k + random.nextGaussian() * (double)0.0075f * 6.0);
                    c_b.l = (float)((double)c_b.l + random.nextGaussian() * (double)0.0075f * 6.0);
                    c_b.m = (float)((double)c_b.m + random.nextGaussian() * (double)0.0075f * 6.0);
                    c_g.spawnEntityInWorld(c_b);
                }
                c_g.a("smoke", f, f2 - 0.3f, f3, n, n2, n3);
            }
        }
    }

    @Override
    public void b(net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        boolean bl;
        if (n4 > 0 && Block.c[n4].canProvidePower() && (bl = c_g.isBlockIndirectlyGettingPowered(n, n2, n3))) {
            this.dispenseItem(c_g, n, n2, n3, c_g.I);
        }
    }

    @Override
    public net.minecraft.a.a.b.a.TileEntity getBlockEntity() {
        return new C_g();
    }

    @Override
    public void onBlockPlacedByPlayer(net.minecraft.a.a.World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        int n5 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3;
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
        super.onBlockPlacedByPlayer(c_g, entityPlayer, n, n2, n3, n4);
    }

    @Override
    public void b(net.minecraft.a.a.World c_g, int n, int n2, int n3) {
        C_g c_g2 = (C_g)c_g.j(n, n2, n3);
        if (c_g2 != null) {
            for (int i = 0; i < c_g2.a(); ++i) {
                ItemStack itemStack = c_g2.a(i);
                if (itemStack == null) continue;
                float f = this.random.nextFloat() * 0.8f + 0.1f;
                float f2 = this.random.nextFloat() * 0.8f + 0.1f;
                float f3 = this.random.nextFloat() * 0.8f + 0.1f;
                while (itemStack.a > 0) {
                    int n4 = this.random.nextInt(21) + 10;
                    if (n4 > itemStack.a) {
                        n4 = itemStack.a;
                    }
                    itemStack.a -= n4;
                    EntityItem c_b = new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.getItemDamage()));
                    if (itemStack.hasTagCompound()) {
                        c_b.a.setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                    }
                    float f4 = 0.05f;
                    c_b.k = (float)this.random.nextGaussian() * f4;
                    c_b.l = (float)this.random.nextGaussian() * f4 + 0.2f;
                    c_b.m = (float)this.random.nextGaussian() * f4;
                    c_g.spawnEntityInWorld(c_b);
                }
            }
        }
        super.b(c_g, n, n2, n3);
    }
}

