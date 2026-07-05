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

public final class C_aa
extends Block {
    private static String[] NAME_LIST = new String[]{"Oak", "Birch", "Palm", "Pine"};

    protected C_aa(int n) {
        super(n, Material.c);
        this.as = 36;
        this.hasStates = true;
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    @Override
    public final int a(int n, Random random) {
        return Block.y.at;
    }

    @Override
    protected int damageDropped(int n) {
        return n & 3;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    public int getMaxMetadata() {
        return 11;
    }

    @Override
    public int a() {
        return 24;
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        int n5 = ((EntityPlayer)c_g.y).b.d().d & 3;
        byte by = 0;
        switch (n4) {
            case 0: 
            case 1: {
                by = (byte)n5;
                break;
            }
            case 2: 
            case 3: {
                by = (byte)(n5 + 8);
                break;
            }
            case 4: 
            case 5: {
                by = (byte)(n5 + 4);
            }
        }
        c_g.setBlockMetadataWithNotify(n, n2, n3, by);
    }

    @Override
    public int a(int n, int n2) {
        int n3 = n2 & 0xC;
        int n4 = n2 & 3;
        switch (n4) {
            case 1: {
                return n3 == 0 && (n == 1 || n == 0) ? 325 : (n3 == 4 && (n == 5 || n == 4) ? 325 : (n3 == 8 && (n == 2 || n == 3) ? 325 : 324));
            }
            case 2: {
                return n3 == 0 && (n == 1 || n == 0) ? 357 : (n3 == 4 && (n == 5 || n == 4) ? 357 : (n3 == 8 && (n == 2 || n == 3) ? 357 : 356));
            }
            case 3: {
                return n3 == 0 && (n == 1 || n == 0) ? 389 : (n3 == 4 && (n == 5 || n == 4) ? 389 : (n3 == 8 && (n == 2 || n == 3) ? 389 : 388));
            }
        }
        return n3 == 0 && (n == 1 || n == 0) ? 37 : (n3 == 4 && (n == 5 || n == 4) ? 37 : (n3 == 8 && (n == 2 || n == 3) ? 37 : 36));
    }

    @Override
    public final boolean directSmelt(World c_g, float f, float f2, float f3) {
        int n = Item.i.ap;
        if (c_g.q.nextFloat() <= 1.0f) {
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 1));
            new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 1)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n & 3] + " Log";
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

