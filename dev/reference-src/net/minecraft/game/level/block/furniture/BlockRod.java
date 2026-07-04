/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class BlockRod
extends C_x {
    public BlockRod(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.a(0.41666666f, 0.0f, 0.41666666f, 0.5833333f, 1.0f, 0.5833333f);
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        return c_g.a(n, n2 - 1, n3) == C_x.B.at ? true : (c_g.a(n, n2 - 1, n3) == C_x.table.at ? true : (c_g.a(n, n2 - 1, n3) == C_x.wall.at ? true : (c_g.a(n, n2 - 1, n3) == C_x.fence.at ? true : (c_g.f(n, n2, n3) == C_c.f ? false : (!c_g.b(n, n2 - 1, n3) ? false : (c_g.a(n, n2 - 1, n3) == this.at ? false : super.a(c_g, n, n2, n3)))))));
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
    public boolean canBlockStay(C_g c_g, int n, int n2, int n3) {
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

