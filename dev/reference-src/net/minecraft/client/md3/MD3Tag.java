/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.md3;

import net.minecraft.a.d.C_a;

public final class MD3Tag {
    public String name;
    public C_a[] coords;
    public C_a[] polygons;
    public C_a[] colors;
    public C_a[] surfaces;

    public MD3Tag(int n) {
        this.coords = new C_a[n];
        this.polygons = new C_a[n];
        this.colors = new C_a[n];
        this.surfaces = new C_a[n];
    }
}

