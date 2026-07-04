/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.d.C_c;

public abstract class C_q
extends C_x {
    protected C_q(int n, C_c c_c) {
        super(n, c_c);
    }

    public void d(C_g c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        c_g.a(n, n2, n3, this.a_());
    }

    public void b(C_g c_g, int n, int n2, int n3) {
        super.b(c_g, n, n2, n3);
        c_g.i(n, n2, n3);
    }

    protected abstract C_a a_();
}

