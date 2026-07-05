/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.d.C_c;

public abstract class BlockContainer
extends Block {
    public BlockContainer(int n, C_c c_c) {
        super(n, c_c);
        this.isBlockContainer = true;
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        c_g.a(n, n2, n3, this.getBlockEntity());
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        super.b(c_g, n, n2, n3);
        c_g.i(n, n2, n3);
    }

    public abstract TileEntity getBlockEntity();
}

