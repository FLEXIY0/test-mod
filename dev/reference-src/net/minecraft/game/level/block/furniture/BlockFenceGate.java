/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class BlockFenceGate
extends Block {
    public BlockFenceGate(int n, int n2) {
        super(n, n2, C_c.c);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return !c_g.f(n, n2 - 1, n3).a() ? false : super.a(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        return BlockFenceGate.isFenceGateOpen(by) ? null : (by != 2 && by != 0 ? C_b.getAABBPool().addOrModifyAABBInPool((float)n + 0.375f, n2, n3, (float)n + 0.625f, (float)n2 + 1.5f, n3 + 1) : C_b.getAABBPool().addOrModifyAABBInPool(n, n2, (float)n3 + 0.375f, n + 1, (float)n2 + 1.5f, (float)n3 + 0.625f));
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        int n4 = BlockFenceGate.getDirection(c_g.e(n, n2, n3));
        if (n4 != 2 && n4 != 0) {
            this.a(0.375f, 0.0f, 0.0f, 0.625f, 1.0f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.375f, 1.0f, 1.0f, 0.625f);
        }
    }

    public static boolean isFenceGateOpen(int n) {
        return (n & 4) != 0;
    }

    public static int getDirection(int n) {
        return n & 3;
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
        return 16;
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        int n5 = (MathHelper.a((double)(c_g.y.n * 4.0f / 360.0f) + 0.5) & 3) % 4;
        c_g.setBlockMetadataWithNotify(n, n2, n3, n5);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4 = c_g.e(n, n2, n3);
        if (!c_g.multiplayerWorld) {
            if (BlockFenceGate.isOpen(n4)) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, n4 & 0xFFFFFFFB);
            } else {
                int n5 = (MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3) % 4;
                int n6 = BlockFenceGate.getOpenState(n4);
                if (n6 == (n5 + 2) % 4) {
                    n4 = n5;
                }
                c_g.setBlockMetadataWithNotify(n, n2, n3, n4 | 4);
            }
        }
        if (n4 < 4) {
            c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_open", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
        } else {
            c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_close", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
        }
        entityPlayer.addStat(StatList.doorUse, 1);
        return true;
    }

    public static boolean isOpen(int n) {
        return (n & 4) != 0;
    }

    public static int getOpenState(int n) {
        return n & 3;
    }
}

