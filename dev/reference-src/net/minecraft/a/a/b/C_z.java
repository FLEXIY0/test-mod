/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_ad;

public final class C_z
extends C_ad {
    protected C_z(int n, int n2) {
        super(6, 15);
        this.a(0.099999994f, 0.0f, 0.099999994f, 0.9f, 0.8f, 0.9f);
    }

    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && random.nextInt(5) == 0) {
            byte by = c_g.e(n, n2, n3);
            if (by < 15) {
                c_g.f(n, n2, n3, by + 1);
                return;
            }
            c_g.d(n, n2, n3, 0);
            if (!c_g.h(n, n2, n3)) {
                c_g.d(n, n2, n3, this.at);
            }
        }
    }
}

