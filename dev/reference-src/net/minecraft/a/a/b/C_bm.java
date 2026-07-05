/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.C_l;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;

public class C_bm
extends Block {
    protected C_bm(int n, int n2, Material c_c) {
        super(n, n2, c_c);
    }

    @Override
    public int a(int n, Random random) {
        return Item.snowball.ap;
    }

    @Override
    public int a(Random random) {
        return 4;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            EntityPlayer entityPlayer = (EntityPlayer)c_g.y;
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= f) || (n6 = this.a(n4, c_g.q)) <= 0 || entityPlayer == null || entityPlayer.b.a[entityPlayer.b.c] == null || !(entityPlayer.b.a[entityPlayer.b.c].a() instanceof C_l)) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4)));
                new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }
}

