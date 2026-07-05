/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_g;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_av
extends Item {
    private int minecartType;

    public C_av(int n, int n2) {
        super(n);
        this.aq = 1;
        this.minecartType = n2;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (n5 == C_x.rail.at || n5 == C_x.railBooster.at) {
            if (!c_g.multiplayerWorld) {
                c_g.spawnEntityInWorld(new C_g(c_g, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.minecartType));
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            }
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            return true;
        }
        return false;
    }
}

