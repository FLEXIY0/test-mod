/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.d.C_a;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public final class C_af
extends Item {
    public C_af(int n) {
        super(n);
        this.ar = 256;
        this.aq = 1;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World c_g, EntityPlayer entityPlayer, int n) {
        if ((entityPlayer.b.hasItem(Item.arrowAdminium.ap) || c_g.gamemode == 1) && itemStack.getMaxItemUseDuration() - entityPlayer.itemInUseCount >= 24) {
            int n2 = this.getMaxItemUseDuration(itemStack) - n;
            float f = (float)n2 / 20.0f;
            if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            if ((entityPlayer.b.c(Item.arrowAdminium.ap) || c_g.gamemode == 1) && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().c == Item.crossbow.ap) {
                entityPlayer.b.a(entityPlayer.b.c, new ItemStack(Item.crossbowLoaded, 1, itemStack.d));
                c_g.a(entityPlayer, "random.click", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 0.8f));
                entityPlayer.swingItem();
                entityPlayer.triggerAchievement(AchievementList.crossbow);
            }
        }
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
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (this.ap == Item.crossbowLoaded.ap) {
            C_a c_a = new C_a(c_g, entityPlayer, 1, 2.0f);
            c_g.a(entityPlayer, "random.crossbow", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 0.8f));
            if (!c_g.multiplayerWorld) {
                c_g.spawnEntityInWorld(c_a);
                entityPlayer.damageItem(1, itemStack, c_g);
                entityPlayer.addStat(StatList.objectUseStats[this.ap], 1);
                return new ItemStack(Item.crossbow, itemStack.a, itemStack.d);
            }
        } else if ((entityPlayer.b.hasItem(Item.arrowAdminium.ap) || c_g.gamemode == 1) && !c_g.multiplayerWorld) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

