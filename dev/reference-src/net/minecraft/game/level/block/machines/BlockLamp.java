/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.machines.BlockPistonMoving;

public class BlockLamp
extends C_x {
    public BlockLamp(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        for (int i = -1; i < 2; ++i) {
            C_x c_x = C_x.c[c_g.a(n + i, n2, n3)];
            if (c_x != null && c_x instanceof BlockPistonMoving) {
                return;
            }
            c_x = C_x.c[c_g.a(n, n2 + i, n3)];
            if (c_x != null && c_x instanceof BlockPistonMoving) {
                return;
            }
            c_x = C_x.c[c_g.a(n, n2, n3 + i)];
            if (c_x == null || !(c_x instanceof BlockPistonMoving)) continue;
            return;
        }
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.a(n, n2, n3, C_x.adminiumLampLit.at);
        } else {
            c_g.a(n, n2, n3, C_x.adminiumLamp.at);
        }
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.a(n, n2, n3, C_x.adminiumLampLit.at);
        } else {
            c_g.a(n, n2, n3, C_x.adminiumLamp.at);
        }
    }

    @Override
    public int a(int n, Random random) {
        return C_x.adminiumLamp.at;
    }

    @Override
    public void dropBlockAsItemWithChance(C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = 1;
        for (int i = 0; i < n5; ++i) {
            int n6;
            if (!(c_g.q.nextFloat() <= 1.0f) || (n6 = C_x.adminiumLamp.at) <= 0) continue;
            float f = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4)));
            new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
    }
}

