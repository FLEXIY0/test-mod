/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_w;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_e
extends C_w {
    public C_e(int n, int n2) {
        super(n, n2, C_c.m);
    }

    @Override
    public final int a(int n, Random random) {
        return random.nextInt(n) == 0 ? Item.al.ap : this.at;
    }

    @Override
    public void a(C_g c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            EntityPlayer entityPlayer = (EntityPlayer)c_g.y;
            ItemStack itemStack = entityPlayer.b.charmSlot[0];
            int n6 = 10;
            if (itemStack != null && itemStack.c == Item.coin.ap) {
                n6 = 1;
                itemStack.damageItem2(1, c_g);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            }
            for (int i = 0; i < n5; ++i) {
                int n7;
                if (!(c_g.q.nextFloat() <= f) || (n7 = this.a(n6, c_g.q)) <= 0) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                C_b c_b = new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n7, 1, this.damageDropped(n4)));
                new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n7, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

