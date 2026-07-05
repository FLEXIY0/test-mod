/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.C_g;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public final class C_a
extends C_g {
    private static C_x[] as = new C_x[]{C_x.l, C_x.i, C_x.ad, C_x.w, C_x.X, C_x.x, C_x.W, C_x.v, C_x.al, C_x.am, C_x.oreEmerald, C_x.blockEmerald, C_x.blockCoal, C_x.ae, C_x.ar, C_x.aq, C_x.B, C_x.ice, C_x.glassPane, C_x.oreAdminium, C_x.blockAdminium, C_x.stalactite, C_x.magma, C_x.brimStone, C_x.brimStoneBrick, C_x.moonRockBrick, C_x.rail, C_x.railBooster, C_x.generator, C_x.generatorActive, C_x.fan, C_x.vacuum, C_x.pump, C_x.pulleyBase, C_x.pulleyStickyBase, C_x.pulleyBaseActive, C_x.pulleyStickyBaseActive, C_x.ak, C_x.lantern, C_x.transformer, C_x.doorSteel, C_x.rod, C_x.trapdoorSteel, C_x.regulator, C_x.adminiumLamp, C_x.detector, C_x.ironBars, C_x.adminiumLampLit, C_x.glassStained};
    private int at;

    public C_a(int n, int n2) {
        super(n, 2, n2, as);
        this.at = n2;
        this.materialEffectiveAgainst = C_c.d;
    }

    @Override
    public final boolean canHarvestBlock(C_x c_x, int n) {
        if (this.ap == 285) {
            return c_x == C_x.ae && c_x == C_x.blockAdminium && c_x == C_x.oreAdminium ? this.at > 3 : true;
        }
        return c_x == C_x.ae ? this.at > 3 : (c_x != C_x.blockAdminium && c_x != C_x.oreAdminium ? (c_x != C_x.am && c_x != C_x.al ? (c_x != C_x.W && c_x != C_x.v && c_x != C_x.blockEmerald && c_x != C_x.oreEmerald ? (c_x != C_x.X && c_x != C_x.w ? (c_x.getMaterial(n) == C_c.d || c_x.getMaterial(n) == C_c.magma || c_x.getMaterial(n) == C_c.pulley || c_x.getMaterial(n) == C_c.vacuum ? true : c_x.getMaterial(n) == C_c.e) : this.at > 0) : this.at >= 2) : this.at >= 3) : this.at > 3);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.C_g c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1 && !c_g.multiplayerWorld) {
            n4 = c_g.a(n, n2, n3);
            byte by = c_g.e(n, n2, n3);
            if (n4 != C_x.Y.at) {
                return false;
            }
            C_x c_x = C_x.Z;
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

