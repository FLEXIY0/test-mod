/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public class C_bt
extends Block {
    protected C_bt(int n, int n2, Material c_c) {
        super(n, n2, c_c);
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public int f() {
        return 2;
    }

    @Override
    public final boolean d(World c_g, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int a() {
        return 22;
    }
}

