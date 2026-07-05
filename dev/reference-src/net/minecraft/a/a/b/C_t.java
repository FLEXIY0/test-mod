/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_t
extends C_x {
    protected C_t(int n) {
        super(58, C_c.c);
        this.as = 59;
    }

    public final int a(int n) {
        if (n == 1) {
            return this.as - 16;
        }
        if (n == 0) {
            return C_x.m.a(0);
        }
        if (n == 2 || n == 4) {
            return this.as + 1;
        }
        return this.as;
    }

    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        entityPlayer.g_();
        return true;
    }
}

