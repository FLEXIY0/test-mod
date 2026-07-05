/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_m;
import net.minecraft.a.a.b.C_p;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.c.C_c;

public class C_w
extends C_x {
    public C_w(int n, int n2, net.minecraft.a.a.d.C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public net.minecraft.a.d.C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        if (this.at == C_x.quickSand.at) {
            return null;
        }
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public final void d(C_g c_g, int n, int n2, int n3) {
        this.e(c_g, n, n2, n3);
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        this.e(c_g, n, n2, n3);
        if (this.at == C_x.quickSand.at && c_g.f(n, n2 + 1, n3) == net.minecraft.a.a.d.C_c.f) {
            c_g.a(n, n2, n3, C_x.t.at);
        }
    }

    private void e(C_g c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2 - 1, n3);
        C_x c_x = C_x.c[n4];
        if ((n4 == 0 || c_x instanceof C_p || c_x instanceof C_m) && !c_g.physicsDisabled && !c_g.multiplayerWorld) {
            c_g.spawnEntityInWorld(new C_c(c_g, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.at));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public final boolean directSmelt(C_g c_g, float f, float f2, float f3) {
        int n = 0;
        if (this.at == C_x.t.at || this.at == C_x.redSand.at) {
            n = C_x.B.at;
        }
        if (this.at == C_x.u.at || this.at == C_x.quickSand.at) {
            return false;
        }
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

    @Override
    public boolean canBeDuped() {
        return true;
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, Random random) {
        if (random.nextInt(10) == 0 && !c_g.a((float)n, (float)(n2 - 1), (float)n3)) {
            float f = (float)n + random.nextFloat();
            float f2 = (float)n2 - 0.05f;
            float f3 = (float)n3 + random.nextFloat();
            float f4 = 0.7f;
            float f5 = 0.7f;
            float f6 = 0.5f;
            if (this.at == C_x.redSand.at) {
                f4 = 0.7f;
                f5 = 0.4f;
                f6 = 0.1f;
            } else if (this.at == C_x.u.at) {
                f4 = 0.5f;
                f5 = 0.45f;
                f6 = 0.5f;
            }
            c_g.a("dust", f, f2, f3, f4, f5, f6);
        }
    }
}

