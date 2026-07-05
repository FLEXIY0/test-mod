/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_t
extends Block {
    protected C_t(int n) {
        super(58, Material.c);
        this.as = 59;
    }

    public final int a(int n) {
        if (n == 1) {
            return this.as - 16;
        }
        if (n == 0) {
            return Block.m.a(0);
        }
        if (n == 2 || n == 4) {
            return this.as + 1;
        }
        return this.as;
    }

    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        entityPlayer.g_();
        return true;
    }
}

