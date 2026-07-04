/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c.a;

import net.minecraft.a.a.c.a.C_b;

public final class C_d
extends C_b {
    private C_b a;
    private C_b b;

    public C_d(C_b c_b, C_b c_b2) {
        this.a = c_b;
        this.b = c_b2;
    }

    @Override
    public final double a(double d2, double d3) {
        return this.a.a(d2 + this.b.a(d2, d3), d3);
    }
}

