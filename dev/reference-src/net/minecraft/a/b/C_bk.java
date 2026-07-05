/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;

public class C_bk
extends Item {
    protected C_bk(int n) {
        super(n);
    }

    @Override
    public boolean throwInFire(C_g c_g, float f, float f2, float f3) {
        int n = 0;
        if (this.ap == Item.rawIron.ap) {
            n = Item.k.ap;
        }
        if (this.ap == Item.rawGold.ap) {
            n = Item.l.ap;
        }
        if (this.ap == Item.rawAdminium.ap) {
            n = Item.ingotAdminium.ap;
        }
        if (this.ap == Item.antlionTusk.ap) {
            n = Item.antlionExtract.ap;
        }
        if (this.ap == Item.clay.ap) {
            n = Item.bricks.ap;
        }
        for (int i = 0; i <= 0; ++i) {
            if (!(c_g.q.nextFloat() <= 1.0f)) continue;
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
            new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        net.minecraft.client.d.getMinecraft().f.triggerAchievement(AchievementList.hellfireLighter);
        return true;
    }
}

