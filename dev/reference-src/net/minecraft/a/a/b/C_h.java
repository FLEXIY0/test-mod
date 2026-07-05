/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.c.C_a;

public final class C_h
extends Block {
    public C_h(int n, int n2) {
        super(46, 8, C_c.p);
    }

    @Override
    public final int a(int n) {
        return n == 0 ? this.as + 2 : (n == 1 ? this.as + 1 : this.as);
    }

    @Override
    public final void c(World c_g, int n, int n2, int n3) {
        if (!c_g.multiplayerWorld) {
            C_a c_a = new C_a(c_g, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f);
            new C_a(c_g, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f).a = c_g.q.nextInt(c_a.a / 4) + c_a.a / 8;
            c_g.spawnEntityInWorld(c_a);
        }
    }
}

