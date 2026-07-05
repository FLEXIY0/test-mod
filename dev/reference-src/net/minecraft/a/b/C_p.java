/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.C_b;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public class C_p
extends Item {
    private int as;

    public C_p(int n, int n2) {
        super(n);
        this.as = n2;
        this.aq = 1;
        this.desc[0] = "+" + this.as + " HP";
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (entityPlayer.gamemode != 1 && entityPlayer.W < 20) {
            if (!(this instanceof C_b)) {
                --itemStack.a;
            }
            for (int i = 0; i < 16; ++i) {
                C_a c_a = new C_a((a.nextFloat() - 0.5f) * 0.1f, (float)(Math.random() * (double)0.1f + (double)0.1f), 0.0f);
                c_a.rotateAroundX(-entityPlayer.o * (float)Math.PI / 180.0f);
                c_a.rotateAroundY(-entityPlayer.n * (float)Math.PI / 180.0f);
                C_a c_a2 = new C_a((a.nextFloat() - 1.5f) * 0.3f, -a.nextFloat() * 0.6f - 0.3f, 0.6f);
                c_a2.rotateAroundX(-entityPlayer.o * (float)Math.PI / 180.0f);
                c_a2.rotateAroundY(-entityPlayer.n * (float)Math.PI / 180.0f);
                c_a2 = c_a2.a(entityPlayer.h, entityPlayer.i + entityPlayer.n(), entityPlayer.j);
                c_g.a("iconcrack_" + itemStack.a().ap, c_a2.a, c_a2.b, c_a2.c, c_a.a, c_a.b + 0.05f, c_a.c);
            }
            c_g.a(entityPlayer, "random.eat", 1.0f, 1.0f);
            entityPlayer.b(this.as);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            this.checkForFoodAchievement(entityPlayer);
        }
        return itemStack;
    }

    @Override
    public boolean throwInFire(World c_g, float f, float f2, float f3) {
        if (this.ap == Item.am.ap || this.ap == Item.fishRaw.ap) {
            int n = 0;
            if (this.ap == Item.am.ap) {
                n = Item.an.ap;
            }
            if (this.ap == Item.fishRaw.ap) {
                n = Item.fishCooked.ap;
            }
            for (int i = 0; i <= 0; ++i) {
                if (!(c_g.q.nextFloat() <= 1.0f)) continue;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
                net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
                new net.minecraft.a.c.c.EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
            return true;
        }
        return false;
    }

    protected void checkForFoodAchievement(EntityPlayer entityPlayer) {
        int n = 0;
        for (int i = 256; i < 1024; ++i) {
            if (!(Item.b[i] instanceof C_p) || net.minecraft.client.d.getMinecraft().statFileWriter.getStatCount(StatList.objectUseStats[i]) < 1) continue;
            ++n;
        }
        if (n >= 13) {
            entityPlayer.triggerAchievement(AchievementList.diet);
        }
    }
}

