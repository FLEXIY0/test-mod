/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.machines.BlockPistonMoving;

public class BlockLamp
extends Block {
    public BlockLamp(int n, int n2, Material c_c) {
        super(n, n2, c_c);
    }

    @Override
    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        for (int i = -1; i < 2; ++i) {
            Block c_x = Block.c[c_g.a(n + i, n2, n3)];
            if (c_x != null && c_x instanceof BlockPistonMoving) {
                return;
            }
            c_x = Block.c[c_g.a(n, n2 + i, n3)];
            if (c_x != null && c_x instanceof BlockPistonMoving) {
                return;
            }
            c_x = Block.c[c_g.a(n, n2, n3 + i)];
            if (c_x == null || !(c_x instanceof BlockPistonMoving)) continue;
            return;
        }
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.a(n, n2, n3, Block.adminiumLampLit.at);
        } else {
            c_g.a(n, n2, n3, Block.adminiumLamp.at);
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            c_g.a(n, n2, n3, Block.adminiumLampLit.at);
        } else {
            c_g.a(n, n2, n3, Block.adminiumLamp.at);
        }
    }

    @Override
    public int a(int n, Random random) {
        return Block.adminiumLamp.at;
    }

    @Override
    public void dropBlockAsItemWithChance(World c_g, int n, int n2, int n3, int n4) {
        int n5 = 1;
        for (int i = 0; i < n5; ++i) {
            int n6;
            if (!(c_g.q.nextFloat() <= 1.0f) || (n6 = Block.adminiumLamp.at) <= 0) continue;
            float f = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4)));
            new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
    }
}

