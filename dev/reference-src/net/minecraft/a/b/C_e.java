/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.d.C_a;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_e
extends Item {
    public C_e(int n) {
        super(n);
        this.ar = 256;
        this.aq = 1;
        this.isToolItem = true;
        this.desc[0] = this.ar + " durability";
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer, int n) {
        boolean bl = false;
        int n2 = 0;
        int n3 = this.getMaxItemUseDuration(itemStack) - n;
        float f = (float)n3 / 20.0f;
        if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].a() instanceof C_ba) {
            entityPlayer.damageItem(1, entityPlayer.b.charmSlot[0], c_g);
            if (entityPlayer.b.charmSlot[0].d >= entityPlayer.b.charmSlot[0].getMaxDamage()) {
                entityPlayer.b.charmSlot[0] = null;
            }
        }
        if (entityPlayer.gamemode == 1 || entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].a() == Item.quiverAdminium) {
            this.useBow(itemStack, c_g, entityPlayer, 2, f * 2.0f);
        } else if (entityPlayer.b.c(Item.h.ap) || entityPlayer.b.consumeQuiverItem(Item.h.ap)) {
            bl = true;
        }
        if (bl) {
            this.useBow(itemStack, c_g, entityPlayer, n2, f * 2.0f);
        }
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
    public ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        if (entityPlayer.b.containsItem(Item.h) || c_g.gamemode == 1) {
            if (!c_g.multiplayerWorld) {
                entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
            } else {
                c_g.a(entityPlayer, "random.bow", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 0.8f));
            }
        }
        return itemStack;
    }

    private void useBow(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer, int n, float f) {
        c_g.a(entityPlayer, "random.bow", 1.0f, 1.0f / (a.nextFloat() * 0.4f + 0.8f));
        if (!c_g.multiplayerWorld) {
            c_g.spawnEntityInWorld(new C_a(c_g, entityPlayer, n, f));
            entityPlayer.damageItem(1, itemStack, c_g);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

