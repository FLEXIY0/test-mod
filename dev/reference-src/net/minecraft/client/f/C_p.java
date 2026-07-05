/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.a.a.d.C_c;
import net.minecraft.client.f.C_i;
import net.minecraft.client.f.C_k;
import util.MathHelper;

public class C_p
extends C_k {
    private C_c materialType;
    private int bobTimer;

    public C_p(World c_g, float f, float f2, float f3, C_c c_c) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.m = 0.0f;
        this.l = 0.0f;
        this.k = 0.0f;
        if (c_c == C_c.f) {
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 1.0f;
        } else {
            this.W = 1.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
        }
        this.P = 113;
        this.a(0.01f, 0.01f);
        this.V = 0.06f;
        this.materialType = c_c;
        this.bobTimer = 40;
        this.T = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        this.m = 0.0f;
        this.l = 0.0f;
        this.k = 0.0f;
    }

    @Override
    public float a(float f) {
        return this.materialType == C_c.f ? super.a(f) : 1.0f;
    }

    @Override
    public void b_() {
        double d2;
        C_c c_c;
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.materialType == C_c.f) {
            this.W = 0.2f;
            this.X = 0.3f;
            this.Y = 1.0f;
        } else {
            this.W = 1.0f;
            this.X = 16.0f / (float)(40 - this.bobTimer + 16);
            this.Y = 4.0f / (float)(40 - this.bobTimer + 8);
        }
        this.l = (float)((double)this.l - (double)this.V);
        if (this.bobTimer-- > 0) {
            this.k = (float)((double)this.k * 0.02);
            this.l = (float)((double)this.l * 0.02);
            this.m = (float)((double)this.m * 0.02);
            this.P = 113;
        } else {
            this.P = 112;
        }
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * (double)0.98f);
        this.l = (float)((double)this.l * (double)0.98f);
        this.m = (float)((double)this.m * (double)0.98f);
        if (this.T-- <= 0) {
            this.k();
        }
        if (this.s) {
            if (this.materialType == C_c.f) {
                this.k();
                this.d.mc.g.a(new C_i(this.d, this.h, this.i, this.j));
            } else {
                this.P = 114;
            }
            this.k = (float)((double)this.k * (double)0.7f);
            this.m = (float)((double)this.m * (double)0.7f);
        }
        if (((c_c = this.d.f(MathHelper.a((double)this.h), MathHelper.a((double)this.i), MathHelper.a((double)this.j))).d() || c_c.a()) && (double)this.i < (d2 = (double)((float)(MathHelper.a((double)this.i) + 1) - net.minecraft.a.a.b.C_p.getFluidHeightPercent(this.d.e(MathHelper.a((double)this.h), MathHelper.a((double)this.i), MathHelper.a((double)this.j)))))) {
            this.k();
        }
    }
}

