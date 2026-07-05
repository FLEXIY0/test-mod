/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_a;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public final class C_m
extends Item {
    private int type;

    public C_m(int n, int n2) {
        super(n);
        this.aq = 1;
        this.ar = n == 95 ? 32 : 64;
        this.type = n2;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            if (c_g.a(n, n2, n3) == C_x.unlitTorch.at) {
                byte by = c_g.e(n, n2, n3);
                c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.ignite", 1.0f, a.nextFloat() * 0.4f + 0.8f);
                c_g.setBlockAndMetadataWithNotify(n, n2, n3, this == Item.f ? C_x.torchHell.at : C_x.af.at, by);
                entityPlayer.damageItem(1, itemStack, c_g);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                entityPlayer.addStat(StatList.torchesRelight, 1);
                entityPlayer.triggerAchievement(AchievementList.lightTorch);
                return true;
            }
            if (c_g.a(n, n2, n3) == C_x.ab.at) {
                C_a c_a = new C_a(c_g, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f);
                c_g.spawnEntityInWorld(c_a);
                c_g.a(c_a, "random.fuse", 1.0f, 1.0f);
                c_g.b(n, n2, n3, 0);
                entityPlayer.getCurrentEquippedItem().damageItem(1, c_g);
                entityPlayer.addStat(StatList.tntIgnited, 1);
                return true;
            }
        }
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            if (c_g.a(n, n2, n3) == 0) {
                c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.ignite", 1.0f, a.nextFloat() * 0.4f + 0.8f);
                if (this.type == 1) {
                    c_g.b(n, n2, n3, C_x.hellfire.at);
                } else {
                    c_g.b(n, n2, n3, C_x.ag.at);
                }
                entityPlayer.damageItem(1, itemStack, c_g);
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

