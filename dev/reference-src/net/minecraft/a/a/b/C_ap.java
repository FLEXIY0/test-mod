/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_ae;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public class C_ap
extends C_ae {
    protected C_ap(int n, int n2, Material c_c) {
        super(n, n2, c_c, false);
    }

    @Override
    public int f() {
        return 1;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return new C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + 0.1f, (float)n3 + this.az);
    }
}

