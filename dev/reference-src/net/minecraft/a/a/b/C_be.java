/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_be
extends Block {
    protected C_be(int n, int n2, Material c_c) {
        super(n, n2, c_c);
    }

    @Override
    public final int a(int n, Random random) {
        Item item = Item.O;
        int n2 = random.nextInt(3);
        switch (n2) {
            case 1: {
                item = Item.seedsMelon;
                break;
            }
            case 2: {
                item = Item.seedsPumpkin;
                break;
            }
            default: {
                item = Item.O;
            }
        }
        return random.nextInt(n) == 0 ? item.ap : this.at;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
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
                EntityItem c_b = new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n7, 1, this.damageDropped(n4)));
                new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n7, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

