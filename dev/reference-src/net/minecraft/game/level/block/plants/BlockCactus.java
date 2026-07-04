/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class BlockCactus
extends C_x {
    public BlockCactus(int n, int n2) {
        super(n, n2, C_c.cactus);
        this.a(true);
    }

    @Override
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this.as + 1;
        }
        if (n4 == 0) {
            return this.as + 2;
        }
        return this.as;
    }

    @Override
    public final int a(int n, int n2) {
        return n == 1 ? this.as + 1 : (n == 0 ? this.as + 2 : this.as);
    }

    @Override
    public void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (c_g.f(n, n2 + 1, n3) == C_c.a) {
            int n4 = 1;
            while (c_g.a(n, n2 - n4, n3) == this.at) {
                ++n4;
            }
            if (n4 < 3) {
                byte by = c_g.e(n, n2, n3);
                if (by == 15) {
                    c_g.b(n, n2 + 1, n3, this.at);
                    c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
                } else {
                    c_g.setBlockMetadataWithNotify(n, n2, n3, by + 1);
                }
            }
        }
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public int a() {
        return 31;
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        return !super.a(c_g, n, n2, n3) ? false : this.canBlockStay(c_g, n, n2, n3);
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
        if (c_g.f(n - 1, n2, n3).a()) {
            return false;
        }
        if (c_g.f(n + 1, n2, n3).a()) {
            return false;
        }
        if (c_g.f(n, n2, n3 - 1).a()) {
            return false;
        }
        if (c_g.f(n, n2, n3 + 1).a()) {
            return false;
        }
        int n4 = c_g.a(n, n2 - 1, n3);
        return n4 == C_x.cactus.at || n4 == C_x.t.at || n4 == C_x.redSand.at;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

