/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public class C_ax
extends Item {
    protected C_ax(int n) {
        super(n);
        this.aq = 1;
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (c_g.a(c_g.mc.G.c) > 0.0f) {
            c_g.setBloodMoon(true);
            c_g.mc.t.addChatMessage("\u00a7cThe blood moon is rising...");
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.triggerAchievement(AchievementList.bloodMoon);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        return itemStack;
    }
}

