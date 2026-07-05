/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.b.C_g;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public final class C_x
extends Item {
    private int isFull;
    private static boolean CATCH;

    public C_x(int n, int n2) {
        super(n);
        this.ar = 64;
        this.isFull = n2;
        this.aq = this.isFull == 0 ? 16 : 1;
    }

    @Override
    public final ItemStack a(ItemStack itemStack, net.minecraft.a.a.World c_g, EntityPlayer entityPlayer) {
        float f = entityPlayer.q + (entityPlayer.o - entityPlayer.q);
        float f2 = entityPlayer.p + (entityPlayer.n - entityPlayer.p);
        float f3 = entityPlayer.e + (entityPlayer.h - entityPlayer.e);
        float f4 = entityPlayer.f + (entityPlayer.i - entityPlayer.f);
        float f5 = entityPlayer.g + (entityPlayer.j - entityPlayer.g);
        C_a c_a = new C_a(f3, f4, f5);
        float f6 = MathHelper.b(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        f2 = MathHelper.a(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f7 = -MathHelper.b(-f * ((float)Math.PI / 180));
        C_a c_a2 = c_a.a((f2 *= f7) * 5.0f, (f = MathHelper.a(-f * ((float)Math.PI / 180))) * 5.0f, (f6 *= f7) * 5.0f);
        net.minecraft.a.d.C_c c_c = c_g.rayTraceBlocks_do(c_a, c_a2, this.isFull == 0, false);
        if (c_c == null) {
            return itemStack;
        }
        if (c_c.a == 0 && !CATCH) {
            int n = c_c.b;
            int n2 = c_c.c;
            int n3 = c_c.d;
            if (this.isFull == 0) {
                if (c_g.f(n, n2, n3) == Material.f && c_g.e(n, n2, n3) == 0) {
                    c_g.b(n, n2, n3, 0);
                    c_g.playSoundAtBlock(n, n2, n3, "random.waterBucket", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 1.2f));
                    entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                    if (entityPlayer.gamemode == 1) {
                        return itemStack;
                    }
                    if (itemStack.a == 1) {
                        return new ItemStack(Item.bucketWater);
                    }
                    if (!entityPlayer.b.a(new ItemStack(Item.bucketWater, 1))) {
                        EntityItem c_b = new EntityItem(c_g, n, n2, n3, new ItemStack(Item.bucketWater, 1));
                        c_g.spawnEntityInWorld(c_b);
                    }
                    return new ItemStack(itemStack.a(), itemStack.a - 1);
                }
                if (c_g.f(n, n2, n3) == Material.g && c_g.e(n, n2, n3) == 0) {
                    c_g.b(n, n2, n3, 0);
                    c_g.playSoundAtBlock(n, n2, n3, "random.lavaBucket", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 1.2f));
                    entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                    if (entityPlayer.gamemode == 1) {
                        return itemStack;
                    }
                    if (itemStack.a == 1) {
                        return new ItemStack(Item.bucketLava);
                    }
                    if (!entityPlayer.b.a(new ItemStack(Item.bucketLava, 1))) {
                        EntityItem c_b = new EntityItem(c_g, n, n2, n3, new ItemStack(Item.bucketLava, 1));
                        c_g.spawnEntityInWorld(c_b);
                    }
                    return new ItemStack(itemStack.a(), itemStack.a - 1);
                }
            } else {
                if (c_c.e == 0) {
                    --n2;
                }
                if (c_c.e == 1) {
                    ++n2;
                }
                if (c_c.e == 2) {
                    --n3;
                }
                if (c_c.e == 3) {
                    ++n3;
                }
                if (c_c.e == 4) {
                    --n;
                }
                if (c_c.e == 5) {
                    ++n;
                }
                if (c_g.a(n, n2, n3) == 0 || !c_g.f(n, n2, n3).a()) {
                    if (this.isFull == net.minecraft.a.a.b.Block.p.at && c_g.theme == 1) {
                        for (int i = 0; i < 20; ++i) {
                            float f8 = (float)n + c_g.q.nextFloat();
                            float f9 = (float)n2 + net.minecraft.a.a.b.Block.p.av;
                            float f10 = (float)n3 + c_g.q.nextFloat();
                            c_g.a("smoke", f8, f9, f10, 0.0f, 0.0f, 0.0f);
                        }
                        c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (c_g.q.nextFloat() - c_g.q.nextFloat()) * 0.8f);
                    } else {
                        c_g.setBlockAndMetadataWithNotify(n, n2, n3, this.isFull, 0);
                        c_g.playSoundAtBlock(n, n2, n3, "random.emptyBucket", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 1.2f));
                    }
                    if (this.ap == Item.bucketFish.ap && !c_g.multiplayerWorld) {
                        C_g c_g2 = new C_g(c_g);
                        c_g2.tamed = true;
                        c_g2.b(n, n2, n3);
                        c_g.spawnEntityInWorld(c_g2);
                        c_g.playSoundAtBlock(n, n2, n3, "random.emptyBucket", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 1.2f));
                    }
                    if (entityPlayer.gamemode != 1) {
                        return new ItemStack(Item.bucketEmpty);
                    }
                    entityPlayer.swingItem();
                    entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                }
            }
        }
        CATCH = false;
        return itemStack;
    }

    @Override
    public void saddleEntity(ItemStack itemStack, EntityLiving c_e, EntityPlayer entityPlayer) {
        if (c_e instanceof C_g && !c_e.d.multiplayerWorld) {
            Item item = Item.bucketFish;
            if (itemStack != null) {
                if (itemStack.a > 1) {
                    if (!entityPlayer.b.a(new ItemStack(item, 1))) {
                        EntityItem c_b = new EntityItem(c_e.d, c_e.h, c_e.i, c_e.j, new ItemStack(Item.bucketFish, 1));
                        entityPlayer.d.spawnEntityInWorld(c_b);
                    }
                    --itemStack.a;
                } else {
                    entityPlayer.b.a(entityPlayer.b.c, new ItemStack(item, 1));
                }
                entityPlayer.swingItem();
                entityPlayer.triggerAchievement(AchievementList.fishBucket);
                c_e.k();
                CATCH = true;
            }
        }
    }
}

