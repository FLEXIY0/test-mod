/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class BlockChair
extends Block {
    public boolean isOccupied = false;

    public BlockChair(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
        this.hasStates = true;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2 - 1, n3) == Block.quickSand.at ? false : (!c_g.b(n, n2 - 1, n3) ? false : super.a(c_g, n, n2, n3));
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2 - 1, n3).a()) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return !c_g.f(n, n2 - 1, n3).a();
    }

    @Override
    public final void g(World c_g, int n, int n2, int n3, int n4) {
        int n5 = MathHelper.a((double)(c_g.y.n * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
        }
        if (n5 == 1) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
        }
        if (n5 == 2) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 1);
        }
        if (n5 == 3) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, 4);
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        if (c_g.y.isSitting) {
            c_g.y.isSitting = false;
        }
    }

    @Override
    public int a() {
        return 14;
    }

    @Override
    public int getMaxMetadata() {
        return 4;
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
    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (!(c_g.multiplayerWorld || entityPlayer.isInWater() || entityPlayer.isSneaking != 0 || c_g.a(n, n2 + 1, n3) != 0 || entityPlayer.isLaying || entityPlayer.isFlying)) {
            entityPlayer.m = 0.0f;
            entityPlayer.l = 0.0f;
            entityPlayer.k = 0.0f;
            entityPlayer.resetPlayerKeyState();
            entityPlayer.b((float)n + 0.5f, (float)n2 + 1.7f, (float)n3 + 0.5f);
            boolean bl = entityPlayer.isSitting = !entityPlayer.isSitting;
            if (entityPlayer.isSitting) {
                entityPlayer.addStat(StatList.chairUse, 1);
            }
            return true;
        }
        return false;
    }
}

