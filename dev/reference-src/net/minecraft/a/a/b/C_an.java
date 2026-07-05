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

public class C_an
extends Block {
    protected C_an(int n, int n2) {
        super(n, n2, Material.b);
    }

    @Override
    public int a(int n, Random random) {
        return Item.clay.ap;
    }

    @Override
    public int a(Random random) {
        return 4;
    }

    @Override
    public final boolean directSmelt(World c_g, float f, float f2, float f3) {
        int n = Block.aa.at;
        if (c_g.q.nextFloat() <= 1.0f) {
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
            new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

