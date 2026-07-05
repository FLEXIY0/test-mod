/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_g
extends Item {
    float at = 4.0f;
    protected int au;
    protected Material materialEffectiveAgainst;

    public C_g(int n, int n2, int n3, Block[] c_xArray) {
        super(n);
        this.blocksEffectiveAgainst = c_xArray;
        this.aq = 1;
        this.ar = 64 << n3;
        this.at = n3 + 1 << 1;
        this.au = n2 + n3;
        this.isToolItem = true;
        this.desc[0] = (int)this.at + " efficiency";
        this.desc[1] = this.au + " damage";
        this.desc[2] = this.ar + " durability";
    }

    @Override
    public final float getStrVsBlock(Block c_x, int n) {
        for (int i = 0; i < this.blocksEffectiveAgainst.length; ++i) {
            if (this.blocksEffectiveAgainst[i] != c_x && c_x.getMaterial(n) != this.materialEffectiveAgainst) continue;
            return this.at;
        }
        return 1.0f;
    }

    @Override
    public final void hitEntity(EntityPlayer entityPlayer, ItemStack itemStack, net.minecraft.a.a.World c_g) {
        entityPlayer.damageItem(2, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final void onBlockDestroyed(EntityPlayer entityPlayer, ItemStack itemStack, net.minecraft.a.a.World c_g) {
        entityPlayer.damageItem(1, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final int a() {
        return this.au;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

