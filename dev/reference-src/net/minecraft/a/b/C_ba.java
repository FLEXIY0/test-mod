/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public class C_ba
extends Item {
    protected C_ba(int n) {
        super(n);
        this.aq = 1;
        this.ar = n == 175 ? 256 : 128;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public final ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        ItemStack itemStack2 = itemStack.copy();
        entityPlayer.b.a[entityPlayer.b.c] = entityPlayer.b.charmSlot[0];
        entityPlayer.b.charmSlot[0] = itemStack2;
        c_g.a(entityPlayer, "random.bundle", 1.0f, a.nextFloat() * 0.4f + 0.8f);
        return itemStack;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

