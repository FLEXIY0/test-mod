/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public class BlockCake
extends C_x {
    public BlockCake(int n, int n2) {
        super(n, n2, C_c.cake);
        this.a(true);
        this.hasStates = true;
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + by * 2) / 16.0f;
        float f3 = 0.5f;
        this.a(f2, 0.0f, f, 1.0f - f, f3, 1.0f - f);
    }

    @Override
    public int a() {
        return 10;
    }

    @Override
    public int getMaxMetadata() {
        return 6;
    }

    @Override
    public boolean getEnableStats() {
        return false;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + by * 2) / 16.0f;
        float f3 = 0.5f;
        return new C_b((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3 - f, (float)(n3 + 1) - f);
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        float f = 0.0625f;
        float f2 = (float)(1 + by * 2) / 16.0f;
        float f3 = 0.5f;
        return new C_b((float)n + f2, n2, (float)n3 + f, (float)(n + 1) - f, (float)n2 + f3, (float)(n3 + 1) - f);
    }

    @Override
    public int a(int n, int n2) {
        return n == 1 ? this.as : (n == 0 ? this.as + 3 : (n2 > 0 && n == 4 ? this.as + 2 : this.as + 1));
    }

    @Override
    public int a(int n) {
        return n == 1 ? this.as : (n == 0 ? this.as + 3 : this.as + 1);
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
    public boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (!c_g.multiplayerWorld) {
            this.eatCakeSlice(c_g, n, n2, n3, entityPlayer);
        }
        return true;
    }

    private void eatCakeSlice(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (entityPlayer.W < 20) {
            entityPlayer.b(3);
            int n4 = c_g.e(n, n2, n3) + 1;
            if (n4 >= 6) {
                c_g.b(n, n2, n3, 0);
            } else {
                c_g.setBlockMetadataWithNotify(n, n2, n3, n4);
                c_g.markBlockNeedsUpdate(n, n2, n3);
            }
            entityPlayer.triggerAchievement(AchievementList.bakePie);
            entityPlayer.addStat(StatList.pieUse, 1);
        }
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3) {
        return c_g.a(n, n2, n3) == 0 && (c_g.a((float)n, (float)(n2 - 1), (float)n3) || c_g.a(n, n2 - 1, n3) == C_x.table.at);
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
        return c_g.b(n, n2 - 1, n3) || c_g.a(n, n2 - 1, n3) == C_x.table.at;
    }

    @Override
    public int a(Random random) {
        return 0;
    }

    @Override
    public int a(int n, Random random) {
        return 0;
    }
}

