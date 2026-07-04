/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;

public class BlockPump
extends C_x {
    public BlockPump(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.a(true);
    }

    @Override
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (c_g.e(n, n2, n3) == 0) {
            return n4 == 1 ? 579 : (n4 == 0 ? 102 : this.as + 2);
        }
        return n4 == 1 ? 579 : (n4 == 0 ? 102 : this.as);
    }

    @Override
    public final int a(int n) {
        return n == 1 ? 579 : (n == 0 ? 102 : this.as + 2);
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (!c_g.multiplayerWorld && c_g.e(n, n2, n3) == 1) {
            for (int i = n - 5; i <= n + 5; ++i) {
                for (int j = n2 - 5; j <= n2 + 5; ++j) {
                    for (int k = n3 - 5; k <= n3 + 5; ++k) {
                        if (!c_g.g(i, j, k) && !c_g.isLava(i, j, k)) continue;
                        c_g.b(i, j, k, 0);
                    }
                }
            }
        }
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    private void updateStateWhenPowered(C_g c_g, int n, int n2, int n3, int n4) {
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 1);
        } else if (!c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 0);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 2;
    }
}

