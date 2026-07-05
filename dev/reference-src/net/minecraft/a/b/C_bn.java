/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_bn
extends Item {
    protected C_bn(int n) {
        super(n);
        this.isToolItem = true;
        this.aq = 1;
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            Block c_x = Block.c[c_g.a(n, n2, n3)];
            if (c_x != null) {
                int n5 = c_g.e(n, n2, n3);
                if (++n5 > c_x.getMaxMetadata()) {
                    n5 = 0;
                }
                if (c_g.a(n, n2, n3) != 0 && c_x.hasStates) {
                    c_g.setBlockMetadata(n, n2, n3, n5);
                }
                c_g.mc.f.addStat(StatList.objectUseStats[itemStack.c], 1);
                return true;
            }
            return false;
        }
        return false;
    }
}

