/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_d;

public class C_z
extends C_d {
    public C_z(int n) {
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
        return C_x.carpet.getBlockName(n);
    }

    @Override
    public int getIconFromDamage(int n) {
        return C_x.carpet.a(2, C_am.getClothColor(n));
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }
}

