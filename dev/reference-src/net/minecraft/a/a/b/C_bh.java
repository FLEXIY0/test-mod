/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_aj;
import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class C_bh
extends C_x {
    protected C_bh(int n) {
        super(n, C_c.b);
        this.as = 425;
        this.a(true);
        this.hasStates = true;
    }

    @Override
    public final int a(int n, int n2) {
        return n == 1 ? 426 : (n == 0 ? 2 : 425);
    }

    private boolean canSpread(C_g c_g, int n, int n2, int n3) {
        C_x c_x = C_x.c[c_g.a(n, n2 + 1, n3)];
        return !(c_x instanceof C_am) && !(c_x instanceof C_aj) && !(c_x instanceof C_bq);
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (c_g.a((float)n, (float)(n2 + 1), (float)n3) || !this.canSpread(c_g, n, n2, n3)) {
            if (random.nextInt(4) == 0) {
                c_g.b(n, n2, n3, C_x.k.at);
            }
        } else if (c_g.d(n, n2 + 1, n3) >= 9 && (c_g.a(n = n + random.nextInt(3) - 1, n2 = n2 + random.nextInt(5) - 3, n3 = n3 + random.nextInt(3) - 1) == C_x.k.at || c_g.a(n, n2, n3) == C_x.j.at) && !c_g.a((float)n, (float)(n2 + 1), (float)n3) && this.canSpread(c_g, n, n2, n3)) {
            c_g.b(n, n2, n3, C_x.mycelium.at);
        }
    }

    @Override
    public final int a(int n, Random random) {
        return C_x.k.a(0, random);
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, Random random) {
        super.b(c_g, n, n2, n3, random);
        if (random.nextInt(10) == 0) {
            c_g.a("townaura", (float)n + random.nextFloat(), (float)n2 + 1.1f, (float)n3 + random.nextFloat(), 0.0f, 0.0f, 0.0f);
        }
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

