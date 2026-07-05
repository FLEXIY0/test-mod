/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.C_p;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.statistics.StatList;

public class C_be
extends C_p {
    int healAmount;

    public C_be(int n, int n2) {
        super(n, n2);
        this.healAmount = n2;
    }

    @Override
    public ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        if (entityPlayer.gamemode != 1 && entityPlayer.W < 20) {
            --itemStack.a;
            for (int i = 0; i < 16; ++i) {
                C_a c_a = new C_a((a.nextFloat() - 0.5f) * 0.1f, (float)(Math.random() * (double)0.1f + (double)0.1f), 0.0f);
                c_a.rotateAroundX(-entityPlayer.o * (float)Math.PI / 180.0f);
                c_a.rotateAroundY(-entityPlayer.n * (float)Math.PI / 180.0f);
                C_a c_a2 = new C_a((a.nextFloat() - 1.5f) * 0.3f, -a.nextFloat() * 0.6f - 0.3f, 0.6f);
                c_a2.rotateAroundX(-entityPlayer.o * (float)Math.PI / 180.0f);
                c_a2.rotateAroundY(-entityPlayer.n * (float)Math.PI / 180.0f);
                c_a2 = c_a2.a(entityPlayer.h, entityPlayer.i + entityPlayer.n(), entityPlayer.j);
                c_g.a("iconcrack_" + itemStack.a().ap, c_a2.a, c_a2.b, c_a2.c, c_a.a, c_a.b + 0.05f, c_a.c);
            }
            c_g.a(entityPlayer, "random.eat", 1.0f, 1.0f);
            if (a.nextInt(3) == 0) {
                entityPlayer.b(this.healAmount);
            } else {
                entityPlayer.poison = 100;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        return itemStack;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

