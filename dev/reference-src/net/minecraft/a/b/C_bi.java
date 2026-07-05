/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_d;

public class C_bi
extends C_d {
    public C_bi(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return C_x.Z.getMaxDamage();
    }

    @Override
    public String getItemName(int n) {
        return C_x.Z.getBlockName(n);
    }

    @Override
    public int getIconFromDamage(int n) {
        return C_x.Z.a(2, n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }
}

