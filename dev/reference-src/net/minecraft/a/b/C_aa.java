/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_aa
extends Item {
    protected C_aa(int n) {
        super(n);
        this.isToolItem = true;
        this.aq = 1;
        this.ar = 256;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public final ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        if (this != Item.bootsHermes) {
            if (this == Item.mirror) {
                if (!(c_g.isBloodMoon() || entityPlayer.isSitting || entityPlayer.isLaying)) {
                    entityPlayer.respawnPlayer();
                    if (entityPlayer.gamemode != 1) {
                        entityPlayer.getCurrentEquippedItem().damageItem2(25, c_g);
                    }
                    entityPlayer.addStat(StatList.objectUseStats[entityPlayer.getCurrentEquippedItem().c], 1);
                    c_g.a(entityPlayer, "random.breath", 0.5f, 1.0f / (c_g.q.nextFloat() * 0.4f + 0.8f));
                    for (int i = 0; i < 20; ++i) {
                        float f = c_g.q.nextFloat() * 0.02f;
                        float f2 = c_g.q.nextFloat() * 0.02f;
                        float f3 = c_g.q.nextFloat() * 0.02f;
                        c_g.a("puff", entityPlayer.h + entityPlayer.G.nextFloat() * entityPlayer.w * 2.0f - entityPlayer.w, entityPlayer.i + entityPlayer.G.nextFloat() * entityPlayer.x, entityPlayer.j + entityPlayer.G.nextFloat() * entityPlayer.w * 2.0f - entityPlayer.w, f, f2, f3);
                    }
                }
            } else {
                ItemStack itemStack2 = itemStack.copy();
                entityPlayer.b.a[entityPlayer.b.c] = entityPlayer.b.charmSlot[0];
                entityPlayer.b.charmSlot[0] = itemStack2;
                c_g.a(entityPlayer, "random.bundle", 1.0f, a.nextFloat() * 0.4f + 0.8f);
            }
        } else if (this == Item.bootsHermes) {
            ItemStack itemStack3 = itemStack.copy();
            entityPlayer.b.a[entityPlayer.b.c] = entityPlayer.b.b[0];
            entityPlayer.b.b[0] = itemStack3;
            c_g.a(entityPlayer, "random.bundle", 1.0f, a.nextFloat() * 0.4f + 0.8f);
        }
        return itemStack;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }

    @Override
    public int a() {
        if (this == Item.gloves) {
            return 4;
        }
        return 1;
    }
}

