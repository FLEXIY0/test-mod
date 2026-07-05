/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.d.C_c;

public abstract class BlockContainer
extends C_x {
    public BlockContainer(int n, C_c c_c) {
        super(n, c_c);
        this.isBlockContainer = true;
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        c_g.a(n, n2, n3, this.getBlockEntity());
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3) {
        super.b(c_g, n, n2, n3);
        c_g.i(n, n2, n3);
    }

    public abstract C_a getBlockEntity();
}

