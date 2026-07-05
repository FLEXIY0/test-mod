/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;

public class C_at
extends Block {
    private static String[] NAME_LIST = new String[]{"Purple", "Blue", "Red", "Yellow"};

    protected C_at(int n, int n2, Material c_c) {
        super(n, n2, c_c);
        this.hasStates = true;
    }

    @Override
    public int a(int n, int n2) {
        return this.as + n2;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    public static int getCoralColor(int n) {
        return ~n & 3;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[C_at.getCoralColor(n)] + " Coral";
    }

    @Override
    public final boolean directSmelt(World c_g, float f, float f2, float f3) {
        int n = Block.A.at;
        if (c_g.q.nextFloat() <= 1.0f) {
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 0));
            new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 0)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

