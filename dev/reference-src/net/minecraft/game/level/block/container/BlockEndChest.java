/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public final class BlockEndChest
extends C_x {
    public BlockEndChest(int n) {
        super(n, C_c.d);
        this.as = 456;
    }

    @Override
    public void g(C_g c_g, int n, int n2, int n3, int n4) {
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
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this.as - 1;
        }
        if (n4 == 0) {
            return this.as - 1;
        }
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.g(c_g, n, n2, n3, n4);
            by = c_g.e(n, n2, n3);
        }
        return n4 != by ? this.as : this.as + 1;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as - 1 : (n == 0 ? this.as - 1 : (n == 3 ? this.as + 1 : this.as));
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        if (c_g.a((float)n, (float)(n2 + 1), (float)n3)) {
            return true;
        }
        entityPlayer.displayGUIEnderChest(entityPlayer.inventoryChest);
        return true;
    }
}

