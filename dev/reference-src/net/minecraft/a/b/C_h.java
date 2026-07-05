/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockChair;

public class C_h
extends C_g {
    private static C_x[] as = new C_x[]{C_x.m, C_x.ac, C_x.y, C_x.aj, C_x.an, C_x.doorOak, C_x.z, C_x.melon, C_x.pumpkin, C_x.mushroomStem, C_x.mushroomCap, C_x.log, C_x.ladder, C_x.leafPile, C_x.flowerPetal, C_x.flowerStem, C_x.bone, C_x.tallGrass, C_x.plantern};

    public C_h(int n, int n2) {
        super(n, 3, n2, as);
        this.materialEffectiveAgainst = C_c.c;
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.C_g c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1 && !c_g.multiplayerWorld) {
            n4 = c_g.a(n, n2, n3);
            C_x c_x = C_x.c[n4];
            byte by = c_g.e(n, n2, n3);
            C_x c_x2 = C_x.log;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x2.getStepSound(by).b();
            float f4 = (c_x2.getStepSound((int)by).a + 1.0f) / 2.0f;
            if (c_x == C_x.y) {
                c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x2.getStepSound((int)by).b * 0.8f);
                c_g.setBlockAndMetadataWithNotify(n, n2, n3, c_x2.at, by);
                float f5 = 0.7f;
                float f6 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                float f7 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                float f8 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                C_b c_b = new C_b(c_g, (float)n + f6, (float)n2 + f7, (float)n3 + f8, new ItemStack(Item.bark.ap));
                c_g.spawnEntityInWorld(c_b);
                entityPlayer.damageItem(1, itemStack, c_g);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                entityPlayer.addStat(StatList.treesChopped, 1);
                return true;
            }
            if (c_x instanceof BlockChair) {
                c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x2.getStepSound((int)by).b * 0.8f);
                c_g.setBlockMetadataWithNotify(n, n2, n3, 5);
                entityPlayer.damageItem(1, itemStack, c_g);
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                return true;
            }
            return false;
        }
        return false;
    }
}

