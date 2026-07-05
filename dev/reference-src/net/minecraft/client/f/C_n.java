/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public class C_n
extends C_k {
    private C_b parent;
    private int isAliveTime = 0;
    private int maxAliveTime = 0;

    public C_n(World c_g, C_b c_b) {
        super(c_g, c_b.h, c_b.r.b + c_b.x / 2.0f, c_b.j, c_b.k, c_b.l, c_b.m);
        this.parent = c_b;
        this.maxAliveTime = 3;
        this.b_();
    }

    @Override
    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void b_() {
        for (int i = 0; i < 16; ++i) {
            float f;
            float f2;
            float f3 = this.G.nextFloat() * 2.0f - 1.0f;
            if (!((double)(f3 * f3 + (f2 = this.G.nextFloat() * 2.0f - 1.0f) * f2 + (f = this.G.nextFloat() * 2.0f - 1.0f) * f) <= 1.0)) continue;
            float f4 = this.parent.h + f3 * this.parent.w / 4.0f;
            float f5 = this.parent.r.b + this.parent.x / 2.0f + f2 * this.parent.x / 4.0f;
            float f6 = this.parent.j + f * this.parent.w / 4.0f;
            this.d.a("crit", f4, f5, f6, f3, f2 + 0.2f, f);
        }
        ++this.isAliveTime;
        if (this.isAliveTime >= this.maxAliveTime) {
            this.k();
        }
    }

    @Override
    public int c() {
        return 3;
    }
}

