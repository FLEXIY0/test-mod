/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_ao;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_d;

public class C_ab
extends C_d {
    public C_ab(int n) {
        super(n);
        this.ar = 0;
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 15;
    }

    @Override
    public String getItemName(int n) {
        return Block.cloth.getBlockName(n);
    }

    @Override
    public int getIconFromDamage(int n) {
        return Block.cloth.a(2, C_ao.getClothColor(n));
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }
}

