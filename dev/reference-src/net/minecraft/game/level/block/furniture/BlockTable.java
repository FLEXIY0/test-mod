/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class BlockTable
extends C_x {
    private static String[] NAME_LIST = new String[]{"Oak", "Birch", "Palm", "Pine"};

    public BlockTable(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.hasStates = true;
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2 - 1, n3) == C_x.quickSand.at || !c_g.b(n, n2 - 1, n3)) {
            return false;
        }
        return super.a(c_g, n, n2, n3);
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2 - 1, n3).a()) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean d(C_g c_g, int n, int n2, int n3, int n4) {
        return !c_g.b(n, n2, n3) && c_g.a(n, n2, n3) != this.at;
    }

    @Override
    public int a() {
        return 15;
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
    public int getMaxDamage() {
        return 3;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
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
        return NAME_LIST[n] + " Table";
    }
}

