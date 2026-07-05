/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.d.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_ag
extends Item {
    public C_ag(int n) {
        super(n);
        this.ar = 256;
        this.aq = 1;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public final ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        Item[] itemArray = new Item[]{Item.dart, Item.dartPoison};
        boolean bl = false;
        int n = 0;
        if (entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].a() instanceof C_ba) {
            entityPlayer.damageItem(1, entityPlayer.b.charmSlot[0], c_g);
            if (entityPlayer.b.charmSlot[0].d >= entityPlayer.b.charmSlot[0].getMaxDamage()) {
                entityPlayer.b.charmSlot[0] = null;
            }
        }
        if (entityPlayer.gamemode == 1) {
            this.useBow(itemStack, c_g, entityPlayer, 2);
        } else {
            for (n = 0; n < itemArray.length; ++n) {
                if (!entityPlayer.b.consumeQuiverItem(itemArray[n].ap)) continue;
                bl = true;
                break;
            }
            if (!bl) {
                for (n = 0; n < itemArray.length; ++n) {
                    if (!entityPlayer.b.c(itemArray[n].ap)) continue;
                    bl = true;
                    break;
                }
            }
        }
        if (bl) {
            this.useBow(itemStack, c_g, entityPlayer, n);
        }
        return itemStack;
    }

    private void useBow(ItemStack itemStack, World c_g, EntityPlayer entityPlayer, int n) {
        c_g.a(entityPlayer, "random.throw", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 0.8f));
        if (!c_g.multiplayerWorld) {
            c_g.spawnEntityInWorld(new C_b(c_g, entityPlayer, n));
            entityPlayer.damageItem(1, itemStack, c_g);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

