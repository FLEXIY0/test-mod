/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_d;

public class C_ae
extends C_d {
    public C_ae(int n) {
        super(n);
        this.ar = 0;
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 4;
    }

    @Override
    public String getItemName(int n) {
        return Block.coralFan.getBlockName(n);
    }

    @Override
    public int getIconFromDamage(int n) {
        return Block.coralFan.a(2, n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }
}

