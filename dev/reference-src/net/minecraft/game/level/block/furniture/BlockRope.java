/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.furniture.BlockFence;
import net.minecraft.game.level.block.furniture.BlockWall;

public class BlockRope
extends C_x {
    public BlockRope(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.a(0.375f, 0.0f, 0.375f, 0.625f, 1.0f, 0.625f);
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        return !super.a(c_g, n, n2, n3) ? false : (c_g.a((float)n, (float)(n2 + 1), (float)n3) ? true : this.canBlockStay(c_g, n, n2, n3));
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public boolean canBlockStay(C_g c_g, int n, int n2, int n3) {
        C_x c_x = C_x.c[c_g.a(n, n2 + 1, n3)];
        return c_g.a(n, n2 + 1, n3) == C_x.rope.at || c_g.a((float)n, (float)(n2 + 1), (float)n3) || c_x instanceof C_bq || c_x instanceof BlockWall || c_x instanceof BlockFence || c_x == C_x.Z;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return null;
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
        return 19;
    }
}

