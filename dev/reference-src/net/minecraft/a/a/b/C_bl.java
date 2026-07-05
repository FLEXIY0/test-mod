/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public class C_bl
extends Block {
    protected C_bl(int n, int n2) {
        super(n, n2, Material.d);
        this.as = n2;
        this.hasStates = true;
    }

    @Override
    public final int a(int n, int n2) {
        if (n2 <= 1) {
            if (n == 1) {
                return this.as + 1;
            }
            if (n == 0) {
                if (n2 == 1) {
                    return this.as + 1;
                }
                return this.as + 2;
            }
            if (n2 == 1) {
                return 492;
            }
            return this.as;
        }
        if (n == 1) {
            return 452;
        }
        if (n == 0) {
            if (n2 == 3) {
                return 452;
            }
            return 453;
        }
        if (n2 == 3) {
            return 0;
        }
        return 451;
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (by <= 1) {
            if (n4 == 1) {
                return this.as + 1;
            }
            if (n4 == 0) {
                if (by == 1) {
                    return this.as + 1;
                }
                return this.as + 2;
            }
            if (by == 1) {
                return 492;
            }
            return this.as;
        }
        if (n4 == 1) {
            return 452;
        }
        if (n4 == 0) {
            if (by == 3) {
                return 452;
            }
            return 453;
        }
        if (by == 3) {
            return 0;
        }
        return 451;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as + 1 : (n == 0 ? this.as + 2 : this.as);
    }

    @Override
    public String getBlockName(int n) {
        return n == 1 ? "Smooth Sandstone" : (n == 2 ? "Red Sandstone" : (n == 3 ? "Smooth Red Sandstone" : "Sandstone"));
    }
}

