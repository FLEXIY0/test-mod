/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public class BlockRod
extends Block {
    public BlockRod(int n, int n2, Material c_c) {
        super(n, n2, c_c);
        this.a(0.41666666f, 0.0f, 0.41666666f, 0.5833333f, 1.0f, 0.5833333f);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2 - 1, n3) == Block.B.at ? true : (c_g.a(n, n2 - 1, n3) == Block.table.at ? true : (c_g.a(n, n2 - 1, n3) == Block.wall.at ? true : (c_g.a(n, n2 - 1, n3) == Block.fence.at ? true : (c_g.f(n, n2, n3) == Material.f ? false : (!c_g.b(n, n2 - 1, n3) ? false : (c_g.a(n, n2 - 1, n3) == this.at ? false : super.a(c_g, n, n2, n3)))))));
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2 - 1, n3).a()) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return !c_g.f(n, n2 - 1, n3).a();
    }

    @Override
    public int a(int n) {
        if (n == 1) {
            return 39;
        }
        return this.as;
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
    public final int a() {
        return 29;
    }
}

