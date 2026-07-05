/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.a.a.d.Material;
import net.minecraft.client.f.C_k;
import util.MathHelper;

public class C_aa
extends C_k {
    public C_aa(World c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2 - 0.125f, f3, f4, f5, f6);
        this.W = 0.4f;
        this.X = 0.4f;
        this.Y = 0.7f;
        this.P = 0;
        this.a(0.01f, 0.01f);
        this.U *= this.G.nextFloat() * 0.6f + 0.2f;
        this.k = f4 * 0.0f;
        this.l = f5 * 0.0f;
        this.m = f6 * 0.0f;
        this.T = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.d(this.k, this.l, this.m);
        if (this.d.f(MathHelper.a((double)this.h), MathHelper.a((double)this.i), MathHelper.a((double)this.j)) != Material.f) {
            this.k();
        }
        if (this.T-- <= 0) {
            this.k();
        }
    }
}

