/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public final class C_bb
extends C_x {
    public C_bb(int n, int n2) {
        super(n, C_c.e);
        if (n == 21) {
            this.aC = C_c.d;
        }
        this.as = n2;
    }

    @Override
    public final int a(int n) {
        if (this.at == 21) {
            return this.as;
        }
        return n == 1 ? this.as - 32 : (n == 0 ? this.as + 32 : this.as);
    }
}

