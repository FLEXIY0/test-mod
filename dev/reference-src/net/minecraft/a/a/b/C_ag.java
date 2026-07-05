/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public final class C_ag
extends C_x {
    protected C_ag(int n) {
        super(19, C_c.j);
        this.as = 96;
    }

    @Override
    public final void d(C_g c_g, int n, int n2, int n3) {
        for (int i = n - 2; i <= n + 2; ++i) {
            for (int j = n2 - 2; j <= n2 + 2; ++j) {
                for (int k = n3 - 2; k <= n3 + 2; ++k) {
                    if (!c_g.g(i, j, k)) continue;
                    c_g.a(i, j, k, 0);
                }
            }
        }
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3) {
        for (int i = n - 2; i <= n + 2; ++i) {
            for (int j = n2 - 2; j <= n2 + 2; ++j) {
                for (int k = n3 - 2; k <= n3 + 2; ++k) {
                    c_g.c(i, j, k, c_g.a(i, j, k));
                }
            }
        }
    }

    @Override
    public int getMobilityFlag() {
        return 2;
    }
}

