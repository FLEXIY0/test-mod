/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.C_g;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_a
extends C_g {
    private static Block[] as = new Block[]{Block.l, Block.i, Block.ad, Block.w, Block.X, Block.x, Block.W, Block.v, Block.al, Block.am, Block.oreEmerald, Block.blockEmerald, Block.blockCoal, Block.ae, Block.ar, Block.aq, Block.B, Block.ice, Block.glassPane, Block.oreAdminium, Block.blockAdminium, Block.stalactite, Block.magma, Block.brimStone, Block.brimStoneBrick, Block.moonRockBrick, Block.rail, Block.railBooster, Block.generator, Block.generatorActive, Block.fan, Block.vacuum, Block.pump, Block.pulleyBase, Block.pulleyStickyBase, Block.pulleyBaseActive, Block.pulleyStickyBaseActive, Block.ak, Block.lantern, Block.transformer, Block.doorSteel, Block.rod, Block.trapdoorSteel, Block.regulator, Block.adminiumLamp, Block.detector, Block.ironBars, Block.adminiumLampLit, Block.glassStained};
    private int at;

    public C_a(int n, int n2) {
        super(n, 2, n2, as);
        this.at = n2;
        this.materialEffectiveAgainst = Material.d;
    }

    @Override
    public final boolean canHarvestBlock(Block c_x, int n) {
        if (this.ap == 285) {
            return c_x == Block.ae && c_x == Block.blockAdminium && c_x == Block.oreAdminium ? this.at > 3 : true;
        }
        return c_x == Block.ae ? this.at > 3 : (c_x != Block.blockAdminium && c_x != Block.oreAdminium ? (c_x != Block.am && c_x != Block.al ? (c_x != Block.W && c_x != Block.v && c_x != Block.blockEmerald && c_x != Block.oreEmerald ? (c_x != Block.X && c_x != Block.w ? (c_x.getMaterial(n) == Material.d || c_x.getMaterial(n) == Material.magma || c_x.getMaterial(n) == Material.pulley || c_x.getMaterial(n) == Material.vacuum ? true : c_x.getMaterial(n) == Material.e) : this.at > 0) : this.at >= 2) : this.at >= 3) : this.at > 3);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1 && !c_g.multiplayerWorld) {
            n4 = c_g.a(n, n2, n3);
            byte by = c_g.e(n, n2, n3);
            if (n4 != Block.Y.at) {
                return false;
            }
            Block c_x = Block.Z;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x.getStepSound(by).b();
            float f4 = (c_x.getStepSound((int)by).a + 1.0f) / 2.0f;
            c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x.getStepSound((int)by).b * 0.8f);
            c_g.setBlockAndMetadataWithNotify(n, n2, n3, c_x.at, by);
            c_x.f(c_g, n, n2, n3, by);
            entityPlayer.damageItem(1, itemStack, c_g);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            entityPlayer.addStat(StatList.slabSplits, 1);
            return true;
        }
        return false;
    }
}

