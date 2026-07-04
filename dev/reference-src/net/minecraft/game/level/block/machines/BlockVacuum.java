/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_m;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockVacuum
extends BlockContainer {
    private Random random = new Random();

    public BlockVacuum(int n, int n2) {
        super(n, C_c.vacuum);
        this.as = n2;
        this.isBlockContainer = true;
    }

    @Override
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            return this.as + 1;
        }
        if (n4 == 1) {
            return this.as + 2;
        }
        return this.as;
    }

    @Override
    public final int a(int n) {
        if (n == 0) {
            return this.as + 1;
        }
        if (n == 1) {
            return this.as + 2;
        }
        return this.as;
    }

    @Override
    public final C_a getBlockEntity() {
        return new C_m();
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        C_m c_m = (C_m)c_g.j(n, n2, n3);
        if (c_g.multiplayerWorld) {
            return true;
        }
        entityPlayer.displayGUIBarrel(c_m, true);
        entityPlayer.addStat(StatList.vacuumUse, 1);
        return true;
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3) {
        C_m c_m = (C_m)c_g.j(n, n2, n3);
        for (int i = 0; i < c_m.a(); ++i) {
            ItemStack itemStack = c_m.a(i);
            if (itemStack == null) continue;
            float f = this.random.nextFloat() * 0.8f + 0.1f;
            float f2 = this.random.nextFloat() * 0.8f + 0.1f;
            float f3 = this.random.nextFloat() * 0.8f + 0.1f;
            while (itemStack.a > 0) {
                int n4 = this.random.nextInt(21) + 10;
                if (n4 > itemStack.a) {
                    n4 = itemStack.a;
                }
                itemStack.a -= n4;
                C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.d));
                new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.d)).k = (float)this.random.nextGaussian() * 0.05f;
                c_b.l = (float)this.random.nextGaussian() * 0.05f + 0.2f;
                c_b.m = (float)this.random.nextGaussian() * 0.05f;
                c_g.spawnEntityInWorld(c_b);
            }
        }
        super.b(c_g, n, n2, n3);
    }
}

