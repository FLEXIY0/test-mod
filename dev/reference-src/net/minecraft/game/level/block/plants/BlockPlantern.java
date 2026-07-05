/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import util.MathHelper;

public class BlockPlantern
extends Block {
    public BlockPlantern(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            int n5 = MathHelper.a((double)(c_g.y.n * 4.0f / 360.0f) + 0.5) & 3;
            if (n5 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
            }
            if (n5 == 1) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 5);
            }
            if (n5 == 2) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
            }
            if (n5 == 3) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 4);
            }
        }
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1 || n4 == 0) {
            return this.as + 1;
        }
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.g(c_g, n, n2, n3, n4);
            by = c_g.e(n, n2, n3);
        }
        return n4 != by ? this.as : 719;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as + 1 : (n == 0 ? this.as + 1 : (n == 3 ? 719 : this.as));
    }
}

