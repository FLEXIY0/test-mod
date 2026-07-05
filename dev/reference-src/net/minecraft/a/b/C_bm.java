/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.d.C_g;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_bm
extends Item {
    private int weaponDamage;

    public C_bm(int n, int n2) {
        super(n);
        this.aq = 1;
        this.ar = 64 << n2;
        this.weaponDamage = 3 + n2;
        this.isToolItem = true;
        this.desc[0] = this.weaponDamage + " damage";
        this.desc[1] = this.ar + " durability";
        this.desc[2] = "Extended reach";
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, net.minecraft.a.a.C_g c_g, EntityPlayer entityPlayer, int n) {
        int n2 = this.getMaxItemUseDuration(itemStack) - n;
        float f = (float)n2 / 20.0f;
        if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        C_g c_g2 = new C_g(c_g, entityPlayer, itemStack.d, 8, this.ap, this.ar, f * 2.0f);
        c_g.a(entityPlayer, "random.bow", 0.5f, 0.4f / (a.nextFloat() * 0.4f + 0.8f));
        if (!c_g.multiplayerWorld) {
            entityPlayer.swingItem();
            c_g.spawnEntityInWorld(c_g2);
            entityPlayer.b.a(entityPlayer.b.c, null);
        }
        entityPlayer.addStat(StatList.objectUseStats[this.ap], 1);
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
    public ItemStack a(ItemStack itemStack, net.minecraft.a.a.C_g c_g, EntityPlayer entityPlayer) {
        if (!c_g.multiplayerWorld) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

    @Override
    public final void hitEntity(EntityPlayer entityPlayer, ItemStack itemStack, net.minecraft.a.a.C_g c_g) {
        entityPlayer.damageItem(1, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final void onBlockDestroyed(EntityPlayer entityPlayer, ItemStack itemStack, net.minecraft.a.a.C_g c_g) {
        entityPlayer.damageItem(2, itemStack, c_g);
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
    }

    @Override
    public final int a() {
        return this.weaponDamage;
    }

    @Override
    public final Item setDamageVsEntity(int n) {
        this.weaponDamage = n;
        return this;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

