/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class C_ba
extends C_x {
    protected C_ba(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, Random random) {
        byte by = (byte)c_g.a(n, n2 + 1, n3);
        float f = (float)n + random.nextFloat();
        float f2 = (float)n2 + this.ay;
        float f3 = (float)n3 + random.nextFloat();
        if (by == 0 || by == C_x.q.at || by == C_x.p.at) {
            c_g.a("smoke", f, f2, f3, 0.0f, 0.0f, 0.0f);
        }
        if (by == C_x.q.at || by == C_x.p.at) {
            c_g.a("bigbubble", f, f2, f3, 0.0f, 0.0f, 0.0f);
        }
    }
}

