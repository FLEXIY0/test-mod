/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class C_al
extends C_x {
    protected C_al(int n, int n2, C_c c_c) {
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
        return 1;
    }

    @Override
    public String getBlockName(int n) {
        if (n == 1) {
            return "Mossy Bricks";
        }
        return this.name;
    }
}

