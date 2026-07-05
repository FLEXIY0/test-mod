/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_d;

public class C_bo
extends C_d {
    public C_bo(int n) {
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
        return Block.log.getBlockName(n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }

    @Override
    public int getIconFromDamage(int n) {
        return Block.log.a(0, n);
    }
}

