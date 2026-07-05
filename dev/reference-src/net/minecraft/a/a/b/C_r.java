/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public final class C_r
extends Block {
    public C_r(int n, int n2) {
        super(n, n2, Material.d);
    }

    @Override
    public final int a(int n, Random random) {
        return Block.l.at;
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

