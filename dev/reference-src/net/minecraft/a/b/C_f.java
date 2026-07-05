/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_f
extends Item {
    private int as;

    public C_f(int n, int n2) {
        super(n);
        this.as = n2;
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 != 1) {
            return false;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            if (c_g.a(n, n2, n3) == C_x.ap.at && c_g.a(n, n2 + 1, n3) == 0) {
                c_g.b(n, n2 + 1, n3, this.as);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

