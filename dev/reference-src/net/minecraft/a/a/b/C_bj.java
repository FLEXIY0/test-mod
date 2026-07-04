/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class C_bj
extends C_x {
    private static String[] NAME_LIST = new String[]{"Oak", "Birch", "Palm", "Pine"};

    protected C_bj(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.hasStates = true;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 1: {
                return 328;
            }
            case 2: {
                return 360;
            }
            case 3: {
                return 392;
            }
        }
        return 4;
    }

    @Override
    public String getBlockName(int n) {
        if (n < 0) {
            return "Oak Planks";
        }
        return NAME_LIST[n] + " Planks";
    }
}

