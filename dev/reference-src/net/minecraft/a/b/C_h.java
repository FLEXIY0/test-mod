/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockChair;

public class C_h
extends C_g {
    private static Block[] as = new Block[]{Block.m, Block.ac, Block.y, Block.aj, Block.an, Block.doorOak, Block.z, Block.melon, Block.pumpkin, Block.mushroomStem, Block.mushroomCap, Block.log, Block.ladder, Block.leafPile, Block.flowerPetal, Block.flowerStem, Block.bone, Block.tallGrass, Block.plantern};

    public C_h(int n, int n2) {
        super(n, 3, n2, as);
        this.materialEffectiveAgainst = Material.c;
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1 && !c_g.multiplayerWorld) {
            n4 = c_g.a(n, n2, n3);
            Block c_x = Block.c[n4];
            byte by = c_g.e(n, n2, n3);
            Block c_x2 = Block.log;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x2.getStepSound(by).b();
            float f4 = (c_x2.getStepSound((int)by).a + 1.0f) / 2.0f;
            if (c_x == Block.y) {
                c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x2.getStepSound((int)by).b * 0.8f);
                c_g.setBlockAndMetadataWithNotify(n, n2, n3, c_x2.at, by);
                float f5 = 0.7f;
                float f6 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                float f7 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                float f8 = c_g.I.nextFloat() * f5 + (1.0f - f5) * 0.5f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f6, (float)n2 + f7, (float)n3 + f8, new ItemStack(Item.bark.ap));
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

