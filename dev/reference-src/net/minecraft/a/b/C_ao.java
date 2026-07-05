/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_ao
extends Item {
    public C_ao(int n) {
        super(n);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (c_g.multiplayerWorld) {
            return false;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            byte by = 0;
            if (n4 == 4) {
                by = 1;
            }
            if (n4 == 3) {
                by = 2;
            }
            if (n4 == 5) {
                by = 3;
            }
            if (n4 == 1) {
                by = 4;
            }
            if (n4 == 0) {
                by = 5;
            }
            this.placeItemFrame(itemStack, entityPlayer, c_g, n, n2, n3, n4, by);
            return true;
        }
        return false;
    }

    private void placeItemFrame(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4, byte by) {
        C_e c_e = new C_e(c_g, n, n2, n3, by);
        if (c_e.c()) {
            c_g.spawnEntityInWorld(c_e);
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
    }
}

