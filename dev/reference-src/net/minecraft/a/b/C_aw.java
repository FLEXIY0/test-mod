/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_d;

public class C_aw
extends C_d {
    public C_aw(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 2;
    }

    @Override
    public String getItemName(int n) {
        return C_x.mushroomCap.getBlockName(n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }

    @Override
    public int getIconFromDamage(int n) {
        return C_x.mushroomCap.a(0, n);
    }
}

