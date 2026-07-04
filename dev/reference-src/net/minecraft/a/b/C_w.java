/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.C_at;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_d;

public class C_w
extends C_d {
    public C_w(int n) {
        super(n);
        this.ar = 0;
        this.setHasSubtypes(true);
    }

    @Override
    public int getSubtypes() {
        return 1;
    }

    @Override
    public String getItemName(int n) {
        return C_x.stoneBricks.getBlockName(n);
    }

    @Override
    public int getIconFromDamage(int n) {
        return C_x.stoneBricks.a(2, C_at.getCoralColor(n));
    }

    @Override
    public int getPlacedBlockMetadata(int n) {
        return n;
    }
}

