/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_d;
import net.minecraft.a.a.b.a.C_j;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockPistonMoving
extends BlockContainer {
    public BlockPistonMoving(int n) {
        super(n, Material.pulley);
        this.b(-1.0f);
    }

    @Override
    public TileEntity getBlockEntity() {
        return null;
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        TileEntity c_a = c_g.j(n, n2, n3);
        if (c_a != null && c_a instanceof C_j) {
            ((C_j)c_a).clearPistonTileEntity();
        } else {
            super.b(c_g, n, n2, n3);
        }
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return false;
    }

    @Override
    public int a() {
        return -1;
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
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (!c_g.multiplayerWorld && c_g.j(n, n2, n3) == null) {
            c_g.b(n, n2, n3, 0);
            return true;
        }
        return false;
    }

    @Override
    public int a(int n, Random random) {
        return 0;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        C_j c_j;
        if (!c_g.multiplayerWorld && (c_j = this.getTileEntityAtLocation(c_g, n, n2, n3)) != null) {
            Block.c[c_j.getStoredBlockID()].f(c_g, n, n2, n3, c_j.getBlockMetadata());
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld && c_g.j(n, n2, n3) == null) {
            c_g.b(n, n2, n3, 0);
        }
    }

    public static TileEntity getTileEntity(int n, int n2, int n3, boolean bl, boolean bl2) {
        return new C_j(n, n2, n3, bl, bl2);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        C_j c_j = this.getTileEntityAtLocation(c_g, n, n2, n3);
        if (c_j == null) {
            return null;
        }
        float f = c_j.getProgress(0.0f);
        if (c_j.isExtending()) {
            f = 1.0f - f;
        }
        return this.getAxisAlignedBB(c_g, n, n2, n3, c_j.getStoredBlockID(), f, c_j.getPistonOrientation());
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        C_j c_j = this.getTileEntityAtLocation(c_g, n, n2, n3);
        if (c_j != null) {
            Block c_x = Block.c[c_j.getStoredBlockID()];
            if (c_x == null || c_x == this) {
                return;
            }
            c_x.setBlockBoundsBasedOnState(c_g, n, n2, n3);
            float f = c_j.getProgress(0.0f);
            if (c_j.isExtending()) {
                f = 1.0f - f;
            }
            int n4 = c_j.getPistonOrientation();
            this.au = c_x.au - (float)C_d.offsetsXForSide[n4] * f;
            this.av = c_x.av - (float)C_d.offsetsYForSide[n4] * f;
            this.aw = c_x.aw - (float)C_d.offsetsZForSide[n4] * f;
            this.ax = c_x.ax - (float)C_d.offsetsXForSide[n4] * f;
            this.ay = c_x.ay - (float)C_d.offsetsYForSide[n4] * f;
            this.az = c_x.az - (float)C_d.offsetsZForSide[n4] * f;
        }
    }

    public C_b getAxisAlignedBB(World c_g, int n, int n2, int n3, int n4, float f, int n5) {
        if (n4 != 0 && n4 != this.at) {
            C_b c_b = Block.c[n4].getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
            if (c_b == null) {
                return null;
            }
            if (C_d.offsetsXForSide[n5] < 0) {
                c_b.a = (float)((double)c_b.a - (double)((float)C_d.offsetsXForSide[n5] * f));
            } else {
                c_b.d = (float)((double)c_b.d - (double)((float)C_d.offsetsXForSide[n5] * f));
            }
            if (C_d.offsetsYForSide[n5] < 0) {
                c_b.b = (float)((double)c_b.b - (double)((float)C_d.offsetsYForSide[n5] * f));
            } else {
                c_b.e = (float)((double)c_b.e - (double)((float)C_d.offsetsYForSide[n5] * f));
            }
            if (C_d.offsetsZForSide[n5] < 0) {
                c_b.c = (float)((double)c_b.c - (double)((float)C_d.offsetsZForSide[n5] * f));
            } else {
                c_b.f = (float)((double)c_b.f - (double)((float)C_d.offsetsZForSide[n5] * f));
            }
            return c_b;
        }
        return null;
    }

    private C_j getTileEntityAtLocation(World c_g, int n, int n2, int n3) {
        TileEntity c_a = c_g.j(n, n2, n3);
        return c_a != null && c_a instanceof C_j ? (C_j)c_a : null;
    }
}

