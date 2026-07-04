/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public final class C_d
extends C_x {
    public C_d(int n, int n2) {
        super(n, C_c.e);
        this.as = n2;
    }

    public final int a(int n) {
        if (n == 1) {
            return this.as - 16;
        }
        if (n == 0) {
            return this.as + 16;
        }
        return this.as;
    }
}

