/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public final class C_d
extends Block {
    public C_d(int n, int n2) {
        super(n, Material.e);
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

