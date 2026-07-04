/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_d;

public class C_y
extends C_d {
    public C_y(int n) {
        super(n);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 1;
    }

    @Override
    public String getItemName(int n) {
        return C_x.berryBush.getBlockName(n);
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }

    @Override
    public int getIconFromDamage(int n) {
        return C_x.berryBush.a(0, n);
    }
}

