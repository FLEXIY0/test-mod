/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_g;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_l
extends C_g {
    private static Block[] as = new Block[]{Block.j, Block.k, Block.t, Block.u, Block.ap, Block.ash, Block.snowBlock, Block.snowLayer, Block.quickSand, Block.sandLayer, Block.moss, Block.mycelium, Block.redSand, Block.clay};

    public C_l(int n, int n2) {
        super(n, 1, n2, as);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            n4 = c_g.a(n, n2, n3);
            byte by = c_g.e(n, n2, n3);
            if (c_g.f(n, n2 + 1, n3).a() || n4 != Block.j.at || by == 1) {
                return false;
            }
            Block c_x = Block.k;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x.getStepSound(by).b();
            float f4 = (c_x.getStepSound((int)by).a + 1.0f) / 2.0f;
            c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x.getStepSound((int)by).b * 0.8f);
            c_g.setBlockMetadataWithNotify(n, n2, n3, 1);
            entityPlayer.damageItem(1, itemStack, c_g);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            entityPlayer.addStat(StatList.pathsMade, 1);
            return true;
        }
        return false;
    }
}

