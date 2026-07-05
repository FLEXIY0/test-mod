/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_d;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_am
extends Item {
    public C_am(int n) {
        super(n);
        this.setMaxDamage(64);
        this.setStackSize(1);
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public boolean isDamagable() {
        return true;
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (entityPlayer.fishEntity != null) {
            int n = entityPlayer.fishEntity.catchFish();
            entityPlayer.damageItem(n, itemStack, c_g);
            entityPlayer.swingItem();
        } else {
            c_g.a(entityPlayer, "random.bow", 0.5f, 0.4f / (a.nextFloat() * 0.4f + 0.8f));
            if (!c_g.multiplayerWorld) {
                c_g.spawnEntityInWorld(new C_d(c_g, entityPlayer));
            }
            entityPlayer.damageItem(1, itemStack, c_g);
            entityPlayer.swingItem();
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        return itemStack;
    }
}

