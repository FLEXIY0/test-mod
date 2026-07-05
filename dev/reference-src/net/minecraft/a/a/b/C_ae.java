/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;

public class C_ae
extends Block {
    private boolean a;

    protected C_ae(int n, int n2, C_c c_c, boolean bl) {
        super(n, n2, c_c);
        this.a = bl;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        return !this.a && n5 == this.at ? false : super.d(c_g, n, n2, n3, n4);
    }
}

