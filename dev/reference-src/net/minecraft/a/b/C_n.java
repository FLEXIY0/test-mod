/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_n
extends Item {
    public C_n(int n, int n2) {
        super(n);
        this.aq = 1;
        this.ar = 64 << n2;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            n4 = c_g.a(n, n2, n3);
            byte by = c_g.e(n, n2, n3);
            if (c_g.f(n, n2 + 1, n3).a() || n4 != Block.j.at && n4 != Block.k.at) {
                return false;
            }
            Block c_x = Block.ap;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x.getStepSound(by).b();
            float f4 = (c_x.getStepSound((int)by).a + 1.0f) / 2.0f;
            c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x.getStepSound((int)by).b * 0.8f);
            if (c_g.multiplayerWorld) {
                return true;
            }
            c_g.b(n, n2, n3, c_x.at);
            entityPlayer.damageItem(1, itemStack, c_g);
            if (c_g.q.nextInt(8) == 0 && n4 == Block.j.at || this.ap == 294) {
                int n5 = 0;
                if (this.ap == Item.J.ap) {
                    n5 = 1;
                }
                for (int i = 0; i <= n5; ++i) {
                    float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
                    float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
                    ItemStack itemStack2 = new ItemStack(Item.O);
                    if (c_g.q.nextInt(8) == 0) {
                        switch (c_g.season.currentSeason) {
                            case 1: {
                                itemStack2 = new ItemStack(Item.seedsMelon);
                                break;
                            }
                            case 2: {
                                itemStack2 = new ItemStack(Item.seedsPumpkin);
                                break;
                            }
                            default: {
                                itemStack2 = new ItemStack(Item.O);
                            }
                        }
                    }
                    EntityItem c_b = new EntityItem(c_g, (float)n + f5, (float)n2 + 1.2f, (float)n3 + f6, itemStack2);
                    new EntityItem(c_g, (float)n + f5, (float)n2 + 1.2f, (float)n3 + f6, itemStack2).O = 10;
                    c_g.spawnEntityInWorld(c_b);
                }
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            entityPlayer.addStat(StatList.farmlandMade, 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

