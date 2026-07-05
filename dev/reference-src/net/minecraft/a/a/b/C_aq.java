/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;

public class C_aq
extends Block {
    protected C_aq(int n, int n2) {
        super(n, n2, C_c.d);
        this.a(true);
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        if (random.nextInt(20) == 0 && (c_g.f(n + 1, n2, n3) == C_c.f || c_g.f(n - 1, n2, n3) == C_c.f || c_g.f(n, n2, n3 + 1) == C_c.f || c_g.f(n, n2, n3 - 1) == C_c.f)) {
            c_g.b(n, n2, n3, Block.ad.at);
        }
    }

    @Override
    public final boolean directSmelt(World c_g, float f, float f2, float f3) {
        int n = Block.i.at;
        if (c_g.q.nextFloat() <= 1.0f) {
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
            new C_b(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
        return true;
    }
}

