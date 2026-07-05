/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.d.C_d;
import net.minecraft.a.c.d.C_e;
import net.minecraft.a.c.d.C_f;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_bl
extends Item {
    int type;

    public C_bl(int n, int n2) {
        super(n);
        this.aq = 16;
        this.type = n2;
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        Entity c_b;
        if (entityPlayer.gamemode != 1) {
            --itemStack.a;
        } else {
            c_g.mc.q.a.d();
        }
        c_g.a(entityPlayer, "random.bow", 0.5f, 0.4f / (a.nextFloat() * 0.4f + 0.8f));
        switch (this.type) {
            case 1: {
                c_b = new C_d(c_g, entityPlayer);
                break;
            }
            case 2: {
                c_b = new C_e(c_g, entityPlayer);
                break;
            }
            default: {
                c_b = new C_f(c_g, entityPlayer);
            }
        }
        if (!c_g.multiplayerWorld) {
            c_g.spawnEntityInWorld(c_b);
        }
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        return itemStack;
    }
}

