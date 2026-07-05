/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.d.Material;

public abstract class C_q
extends Block {
    protected C_q(int n, Material c_c) {
        super(n, c_c);
    }

    public void d(World c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        c_g.a(n, n2, n3, this.a_());
    }

    public void b(World c_g, int n, int n2, int n3) {
        super.b(c_g, n, n2, n3);
        c_g.i(n, n2, n3);
    }

    protected abstract TileEntity a_();
}

