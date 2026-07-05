/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.b.C_h;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_t
extends C_h {
    public C_t(int n, int n2) {
        super(n, n2);
        this.at = n2 + 1 << 0;
        this.desc[0] = this.au + " damage";
        this.desc[1] = this.ar + " durability";
        this.desc[2] = "Knockback";
    }

    @Override
    public C_q getItemUseAction(ItemStack itemStack) {
        return C_q.bow;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World c_g, EntityPlayer entityPlayer, int n) {
        if (itemStack.getMaxItemUseDuration() - entityPlayer.itemInUseCount >= 18) {
            int n2 = this.getMaxItemUseDuration(itemStack) - n;
            float f = (float)n2 / 20.0f;
            if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            entityPlayer.swingItem();
            float f2 = (float)(c_g.I.nextGaussian() * (double)0.02f);
            float f3 = (float)(c_g.I.nextGaussian() * (double)0.02f);
            float f4 = (float)(c_g.I.nextGaussian() * (double)0.02f);
            float f5 = -MathHelper.a(entityPlayer.n * ((float)Math.PI / 180));
            float f6 = MathHelper.b(entityPlayer.n * ((float)Math.PI / 180));
            c_g.a("swipe", entityPlayer.h + f5, entityPlayer.i - 0.3f, entityPlayer.j + f6, f2, f3, f4);
            c_g.a(entityPlayer, "random.throw", 1.0f, 0.0f);
            float f7 = 3.0f;
            List<C_b> list = c_g.a(entityPlayer, net.minecraft.a.d.C_b.getBoundingBoxFromPool(entityPlayer.h - f7, entityPlayer.i - f7, entityPlayer.j - f7, entityPlayer.h + f7, entityPlayer.i + f7, entityPlayer.j + f7));
            for (int i = 0; i < list.size(); ++i) {
                C_b c_b = list.get(i);
                if (!(c_b instanceof C_e) || !c_b.isVisible) continue;
                c_b.attackEntityFrom(entityPlayer, this.au, 0.4f);
                itemStack.damageItem(2, c_g);
                if (list.size() < 3) continue;
                entityPlayer.triggerAchievement(AchievementList.buildBattleAxe);
            }
            entityPlayer.addStat(StatList.objectUseStats[this.ap], 1);
        }
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (!c_g.multiplayerWorld) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
            entityPlayer.addStat(StatList.objectUseStats[this.ap], 1);
        }
        return itemStack;
    }
}

