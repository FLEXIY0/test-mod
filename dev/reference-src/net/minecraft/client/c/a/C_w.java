/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public class C_w
extends C_g {
    private EntityPlayer thePlayer;

    public C_w(C_b c_b, int n, int n2, int n3, EntityPlayer entityPlayer) {
        super(c_b, n, n2, n3);
        this.thePlayer = entityPlayer;
    }

    @Override
    public boolean a(ItemStack itemStack) {
        return false;
    }

    @Override
    public void onPickupFromSlot(ItemStack itemStack) {
        super.onPickupFromSlot(itemStack);
        this.thePlayer.addStat(StatList.objectCraftStats[itemStack.c], 1);
        if (itemStack.c == Item.k.ap) {
            this.thePlayer.triggerAchievement(AchievementList.acquireIron);
        }
        if (itemStack.c == Item.fishCooked.ap) {
            this.thePlayer.triggerAchievement(AchievementList.cookFish);
        }
        if (itemStack.c == Item.j.ap) {
            this.thePlayer.triggerAchievement(AchievementList.diamonds);
        }
        if (itemStack.c == Item.emerald.ap) {
            this.thePlayer.triggerAchievement(AchievementList.emeralds);
        }
        if (itemStack.c == Item.i.ap && itemStack.d == 1) {
            this.thePlayer.triggerAchievement(AchievementList.charcoal);
        }
        if (itemStack.c == C_x.A.at) {
            this.thePlayer.triggerAchievement(AchievementList.spong);
        }
    }
}

