/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class BlockTrapdoor
extends C_x {
    public BlockTrapdoor(int n, int n2, C_c c_c) {
        super(n, c_c);
        this.as = n2;
        float f = 0.5f;
        float f2 = 1.0f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
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
        return 17;
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsForBlockRender(c_g.e(n, n2, n3));
    }

    @Override
    public void setBlockBoundsForItemRender(int n) {
        float f = 0.1875f;
        this.a(0.0f, 0.5f - f / 2.0f, 0.0f, 1.0f, 0.5f + f / 2.0f, 1.0f);
    }

    public void setBlockBoundsForBlockRender(int n) {
        float f = 0.1875f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
        if (BlockTrapdoor.isTrapdoorOpen(n)) {
            if ((n & 3) == 0) {
                this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 1) {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
            }
            if ((n & 3) == 2) {
                this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            if ((n & 3) == 3) {
                this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (this.aC == C_c.c) {
            byte by = c_g.e(n, n2, n3);
            c_g.setBlockMetadataWithNotify(n, n2, n3, by ^ 4);
            if (by < 4) {
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_open", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
            } else {
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_close", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
            }
            entityPlayer.addStat(StatList.doorUse, 1);
        }
        return true;
    }

    public void onPoweredBlockChange(C_g c_g, int n, int n2, int n3, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = (c_g.e(n, n2, n3) & 4) > 0;
        if (bl2 != bl) {
            byte by = c_g.e(n, n2, n3);
            c_g.setBlockMetadataWithNotify(n, n2, n3, by ^ 4);
            if (by < 4) {
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_open", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
            } else {
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_close", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
            }
        }
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld && n4 > 0 && C_x.c[n4].canProvidePower()) {
            boolean bl = c_g.isBlockIndirectlyGettingPowered(n, n2, n3);
            this.onPoweredBlockChange(c_g, n, n2, n3, bl);
        }
    }

    @Override
    public net.minecraft.a.d.C_c a(C_g c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.a(c_g, n, n2, n3, c_a, c_a2);
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        return true;
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        int n5 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
        }
        if (n5 == 1) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
        }
        if (n5 == 2) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 1);
        }
        if (n5 == 3) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
        }
    }

    public static boolean isTrapdoorOpen(int n) {
        return (n & 4) != 0;
    }
}

