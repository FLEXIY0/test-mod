/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_s
extends Item {
    protected C_s(int n) {
        super(n);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            n4 = c_g.a(n, n2, n3);
            C_x c_x = C_x.c[n4];
            byte by = c_g.e(n, n2, n3);
            C_x c_x2 = C_x.y;
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = c_x2.getStepSound(by).b();
            float f4 = (c_x2.getStepSound((int)by).a + 1.0f) / 2.0f;
            if (c_x == C_x.log) {
                c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x2.getStepSound((int)by).b * 0.8f);
                c_g.setBlockAndMetadataWithNotify(n, n2, n3, c_x2.at, by);
                if (c_g.z) {
                    --itemStack.a;
                }
                entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

