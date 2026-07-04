/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_ar;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_c
extends Item {
    private int as;

    public C_c(int n, int n2) {
        super(n);
        this.aq = 1;
        this.ar = 64 << n2;
        this.as = 4 + (n2 << 1);
        this.isToolItem = true;
        this.blocksEffectiveAgainst = new C_x[]{C_x.cobweb, C_x.deadBush};
        this.desc[0] = this.as + " damage";
        this.desc[1] = this.ar + " durability";
    }

    @Override
    public float getStrVsBlock(C_x c_x, int n) {
        if (c_x instanceof C_ar) {
            return 9.5f;
        }
        return 1.5f;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }

    @Override
    public final void hitEntity(EntityPlayer entityPlayer, ItemStack itemStack, C_g c_g) {
        entityPlayer.damageItem(1, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final void onBlockDestroyed(EntityPlayer entityPlayer, ItemStack itemStack, C_g c_g) {
        entityPlayer.damageItem(2, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final int a() {
        return this.as;
    }

    @Override
    public final Item setDamageVsEntity(int n) {
        this.as = n;
        return this;
    }

    @Override
    public C_q getItemUseAction(ItemStack itemStack) {
        return C_q.block;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
}

