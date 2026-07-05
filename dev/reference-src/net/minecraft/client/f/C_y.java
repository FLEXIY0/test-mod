/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public class C_y
extends C_k {
    public C_y(C_g c_g, float f, float f2, float f3, Item item) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.P = item.getIconFromDamage(0);
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.V = C_x.snowBlock.aB;
        this.U /= 2.0f;
    }

    public C_y(C_g c_g, float f, float f2, float f3, int n) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.P = n;
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.V = C_x.snowBlock.aB;
        this.U /= 2.0f;
    }

    @Override
    public int c() {
        return 2;
    }

    @Override
    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)(this.P % 32) + this.Q / 8.0f) / 32.0f;
        float f8 = f7 + 0.015609375f;
        float f9 = ((float)(this.P / 32) + this.R / 8.0f) / 32.0f;
        float f10 = f9 + 0.015609375f;
        float f11 = 0.1f * this.U;
        float f12 = this.e + (this.h - this.e) * f;
        float f13 = this.f + (this.i - this.f) * f;
        float f14 = this.g + (this.j - this.g) * f;
        float f15 = this.a(f);
        if (this.d.mc.f.nightVision && (f15 += 0.7f) > 1.0f) {
            f15 = 1.0f;
        }
        c_d.a(f15 * this.W, f15 * this.X, f15 * this.Y);
        c_d.a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        c_d.a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f7, f9);
        c_d.a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        c_d.a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f8, f10);
    }
}

