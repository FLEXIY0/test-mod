/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public final class C_ai
extends C_x {
    private int a;

    protected C_ai(int n, int n2) {
        super(n, C_x.c[n2].as, C_c.f);
        this.a = n2;
        this.a(true);
    }

    @Override
    public final void d(C_g c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        if (c_g.a(n - 1, n2, n3) == 0) {
            c_g.b(n - 1, n2, n3, this.a);
        }
        if (c_g.a(n + 1, n2, n3) == 0) {
            c_g.b(n + 1, n2, n3, this.a);
        }
        if (c_g.a(n, n2, n3 - 1) == 0) {
            c_g.b(n, n2, n3 - 1, this.a);
        }
        if (c_g.a(n, n2, n3 + 1) == 0) {
            c_g.b(n, n2, n3 + 1, this.a);
        }
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.a(n - 1, n2, n3) == 0) {
            c_g.b(n - 1, n2, n3, this.a);
        }
        if (c_g.a(n + 1, n2, n3) == 0) {
            c_g.b(n + 1, n2, n3, this.a);
        }
        if (c_g.a(n, n2, n3 - 1) == 0) {
            c_g.b(n, n2, n3 - 1, this.a);
        }
        if (c_g.a(n, n2, n3 + 1) == 0) {
            c_g.b(n, n2, n3 + 1, this.a);
        }
    }
}

