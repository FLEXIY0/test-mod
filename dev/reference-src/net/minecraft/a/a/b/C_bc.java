/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_bu;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_b;

public class C_bc
extends Block {
    protected C_bc(int n, int n2) {
        super(n, n2, Material.n);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public net.minecraft.a.d.C_c a(World c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.a(c_g, n, n2, n3, c_a, c_a2);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        if (by >= 2 && by <= 5) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    @Override
    public int a(int n, int n2) {
        if (this.at == Block.railBooster.at) {
            return n2 >= 6 ? 544 : this.as;
        }
        return n2 >= 6 ? this.as - 32 : this.as;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int a() {
        return 25;
    }

    @Override
    public int a(Random random) {
        return 1;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.b(n, n2 - 1, n3) && c_g.a(n, n2, n3) == 0;
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
        if (!c_g.multiplayerWorld) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 15);
            this.refreshTrackShape(c_g, n, n2, n3, true);
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            byte by = c_g.e(n, n2, n3);
            boolean bl = false;
            if (!c_g.b(n, n2 - 1, n3)) {
                bl = true;
            }
            if (by == 2 && !c_g.b(n + 1, n2, n3)) {
                bl = true;
            }
            if (by == 3 && !c_g.b(n - 1, n2, n3)) {
                bl = true;
            }
            if (by == 4 && !c_g.b(n, n2, n3 - 1)) {
                bl = true;
            }
            if (by == 5 && !c_g.b(n, n2, n3 + 1)) {
                bl = true;
            }
            if (bl) {
                this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
                c_g.b(n, n2, n3, 0);
            } else if (n4 > 0 && C_bu.getNAdjacentTracks(new C_bu(this, c_g, n, n2, n3)) == 3) {
                this.refreshTrackShape(c_g, n, n2, n3, false);
            }
        }
    }

    private void refreshTrackShape(World c_g, int n, int n2, int n3, boolean bl) {
        if (!c_g.multiplayerWorld) {
            new C_bu(this, c_g, n, n2, n3).place(true, bl);
        }
    }
}

