/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public class BlockLadder
extends Block {
    public BlockLadder(int n, int n2) {
        super(n, n2, C_c.n);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        float f = 0.125f;
        if (by == 2) {
            this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (by == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (by == 4) {
            this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (by == 5) {
            this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        float f = 0.125f;
        if (by == 2) {
            this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (by == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (by == 4) {
            this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (by == 5) {
            this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
        return super.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int a() {
        return 8;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.b(n - 1, n2, n3) ? true : (c_g.b(n + 1, n2, n3) ? true : (c_g.b(n, n2, n3 - 1) ? true : c_g.b(n, n2, n3 + 1)));
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.e(n, n2, n3);
        if ((n5 == 0 || n4 == 2) && c_g.b(n, n2, n3 + 1)) {
            n5 = 2;
        }
        if ((n5 == 0 || n4 == 3) && c_g.b(n, n2, n3 - 1)) {
            n5 = 3;
        }
        if ((n5 == 0 || n4 == 4) && c_g.b(n + 1, n2, n3)) {
            n5 = 4;
        }
        if ((n5 == 0 || n4 == 5) && c_g.b(n - 1, n2, n3)) {
            n5 = 5;
        }
        c_g.setBlockMetadataWithNotify(n, n2, n3, n5);
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        boolean bl = false;
        if (by == 2 && c_g.b(n, n2, n3 + 1)) {
            bl = true;
        }
        if (by == 3 && c_g.b(n, n2, n3 - 1)) {
            bl = true;
        }
        if (by == 4 && c_g.b(n + 1, n2, n3)) {
            bl = true;
        }
        if (by == 5 && c_g.b(n - 1, n2, n3)) {
            bl = true;
        }
        if (!bl) {
            this.f(c_g, n, n2, n3, by);
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public int a(Random random) {
        return 1;
    }
}

