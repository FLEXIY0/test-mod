/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_c
extends C_x {
    public C_c(int n, int n2) {
        super(n, n2, net.minecraft.a.a.d.C_c.d);
    }

    @Override
    public final int a(int n, Random random) {
        return this.at == C_x.x.at ? Item.i.ap : (this.at == C_x.al.at ? Item.j.ap : (this.at == C_x.oreEmerald.at ? Item.emerald.ap : (this.at == C_x.w.at ? Item.rawIron.ap : (this.at == C_x.v.at ? Item.rawGold.ap : (this.at == C_x.oreAdminium.at ? Item.rawAdminium.ap : this.at)))));
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    @Override
    public void a(C_g c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            EntityPlayer entityPlayer = (EntityPlayer)c_g.y;
            ItemStack itemStack = entityPlayer.b.charmSlot[0];
            if (itemStack != null && itemStack.c == Item.coin.ap) {
                n5 = c_g.q.nextInt(3) + 1;
                itemStack.damageItem2(1, c_g);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            }
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= f) || (n6 = this.a(n4, c_g.q)) <= 0) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                C_b c_b = new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4)));
                new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public final boolean directSmelt(C_g c_g, float f, float f2, float f3) {
        int n = 0;
        if (this.at == C_x.x.at) {
            n = Item.i.ap;
        }
        if (this.at == C_x.al.at) {
            n = Item.j.ap;
        }
        if (this.at == C_x.w.at) {
            n = Item.k.ap;
        }
        if (this.at == C_x.v.at) {
            n = Item.l.ap;
        }
        if (this.at == C_x.oreEmerald.at) {
            n = Item.emerald.ap;
        }
        if (this.at == C_x.oreAdminium.at) {
            n = Item.ingotAdminium.ap;
        }
        if (c_g.q.nextFloat() <= 1.0f) {
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
            new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

