/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public final class BlockLantern
extends Block {
    public BlockLantern(int n, int n2) {
        super(n, n2, Material.solid);
        this.a(true);
    }

    @Override
    public int a(int n) {
        if (n < 2) {
            return 266;
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
        return 20;
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2 - 1, n3);
        Block c_x = Block.c[c_g.a(n, n2 + 1, n3)];
        if (n4 == Block.table.at || n4 == Block.wall.at || n4 == Block.fence.at || n4 == Block.stairUpsideDown.at || c_x == Block.fence || c_x == Block.rope || c_x == Block.wall || c_x instanceof C_bq && c_g.e(n, n2 + 1, n3) <= 3 || c_x == Block.Z) {
            return true;
        }
        return c_g.b(n, n2 - 1, n3) || c_g.b(n, n2 + 1, n3);
    }

    @Override
    public final void g(World c_g, int n, int n2, int n3, int n4) {
        Block c_x = Block.c[c_g.a(n, n2 + 1, n3)];
        if (c_g.b(n, n2 + 1, n3) || c_x == Block.fence || c_x == Block.wall || c_x == Block.rope || c_x == Block.Z || c_x instanceof C_bq && c_g.e(n, n2 + 1, n3) <= 3) {
            c_g.setBlockMetadata(n, n2, n3, 1);
        }
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.e(n, n2, n3) == 0) {
            this.d(c_g, n, n2, n3);
        }
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        if (c_g.b(n, n2 + 1, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 1);
        }
        this.dropLanternIfCantStay(c_g, n, n2, n3);
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2 - 1, n3);
        Block c_x = Block.c[c_g.a(n, n2 + 1, n3)];
        if (this.dropLanternIfCantStay(c_g, n, n2, n3)) {
            boolean bl = false;
            if (!(c_g.b(n, n2 - 1, n3) || n5 == Block.table.at || n5 == Block.fence.at || n5 == Block.wall.at || c_x == Block.wall || c_x == Block.fence || c_x == Block.rope || c_x == Block.Z || c_x instanceof C_bq || c_g.b(n, n2 + 1, n3))) {
                bl = true;
            }
            if (!c_g.b(n, n2 - 1, n3) && c_g.b(n, n2 + 1, n3)) {
                c_g.setBlockMetadata(n, n2, n3, 1);
            }
            if (c_g.b(n, n2 - 1, n3) && !c_g.b(n, n2 + 1, n3)) {
                c_g.setBlockMetadata(n, n2, n3, 0);
            }
            if (bl) {
                this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
                c_g.b(n, n2, n3, 0);
            }
        }
    }

    private boolean dropLanternIfCantStay(World c_g, int n, int n2, int n3) {
        if (!this.a(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        if (by == 1) {
            this.a(0.2f, 0.375f, 0.2f, 0.8f, 1.0f, 0.8f);
        } else {
            this.a(0.2f, 0.0f, 0.2f, 0.8f, 0.625f, 0.8f);
        }
    }
}

