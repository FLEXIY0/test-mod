/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_br
extends C_x {
    private Random rand = new Random();
    private static String[] NAME_LIST = new String[]{"Oak", "Birch", "Palm", "Pine"};

    protected C_br(int n) {
        super(n, C_c.c);
        this.as = 36;
        this.hasStates = true;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean d(C_g c_g, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int a() {
        return 32;
    }

    @Override
    public void g(C_g c_g, int n, int n2, int n3, int n4) {
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
                return n3 == 0 && (n == 1 || n == 0) ? 325 : (n3 == 4 && (n == 5 || n == 4) ? 325 : (n3 == 8 && (n == 2 || n == 3) ? 325 : 420));
            }
            case 2: {
                return n3 == 0 && (n == 1 || n == 0) ? 357 : (n3 == 4 && (n == 5 || n == 4) ? 357 : (n3 == 8 && (n == 2 || n == 3) ? 357 : 421));
            }
            case 3: {
                return n3 == 0 && (n == 1 || n == 0) ? 389 : (n3 == 4 && (n == 5 || n == 4) ? 389 : (n3 == 8 && (n == 2 || n == 3) ? 389 : 422));
            }
        }
        return n3 == 0 && (n == 1 || n == 0) ? 37 : (n3 == 4 && (n == 5 || n == 4) ? 37 : (n3 == 8 && (n == 2 || n == 3) ? 37 : 419));
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    @Override
    public final int a(int n, Random random) {
        return C_x.log.at;
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
    public final boolean directSmelt(C_g c_g, float f, float f2, float f3) {
        int n = Item.i.ap;
        int n2 = this.rand.nextInt(3) + 1;
        for (int i = 0; i < n2; ++i) {
            if (!(c_g.q.nextFloat() <= 1.0f)) continue;
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 1));
            new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n, 1, 1)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n] + " Lumber";
    }
}

