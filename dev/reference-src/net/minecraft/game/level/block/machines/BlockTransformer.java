/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;

public class BlockTransformer
extends Block {
    public BlockTransformer(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (n4 == 1) {
            return this.as + 4;
        }
        if (n4 == 0) {
            return this.as + 5;
        }
        if (by < 4) {
            return this.as + by;
        }
        if (by >= 4 && by < 8) {
            return this.as + by - 4;
        }
        return this.as;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as + 4 : (n == 0 ? this.as + 5 : this.as);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            return false;
        }
        c_g.setBlockMetadata(n, n2, n3, c_g.e(n, n2, n3) + 1);
        if (c_g.e(n, n2, n3) > 3) {
            c_g.setBlockMetadata(n, n2, n3, 0);
        }
        return true;
    }

    @Override
    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    private void updateStateWhenPowered(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3) && by < 4) {
            c_g.setBlockMetadata(n, n2, n3, by + 4);
        } else if (!c_g.isBlockIndirectlyGettingPowered(n, n2, n3) && by >= 4) {
            c_g.setBlockMetadata(n, n2, n3, by - 4);
            for (int i = 0; i < 20; ++i) {
                float f = (float)n + c_g.q.nextFloat();
                float f2 = (float)n2 + this.ay;
                float f3 = (float)n3 + c_g.q.nextFloat();
                c_g.a("explode", f, f2, f3, 0.0f, 0.0f, 0.0f);
            }
        }
    }
}

