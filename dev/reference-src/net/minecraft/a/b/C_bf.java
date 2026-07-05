/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_d;

public class C_bf
extends C_d {
    public C_bf(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 3;
    }

    @Override
    public String getItemName(int n) {
        return Block.sandStone.getBlockName(n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }

    @Override
    public int getIconFromDamage(int n) {
        return Block.sandStone.a(0, n);
    }
}

