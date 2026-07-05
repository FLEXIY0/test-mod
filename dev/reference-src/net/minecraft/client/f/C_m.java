/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;
import net.minecraft.game.level.block.furniture.BlockDoor;

public final class C_m
extends C_k {
    public C_m(World c_g, float f, float f2, float f3, float f4, float f5, float f6, Block c_x, int n) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.P = c_x instanceof BlockDoor ? c_x.as : c_x.a(2, n);
        this.V = c_x.aB;
        this.Y = 0.6f;
        this.X = 0.6f;
        this.W = 0.6f;
        this.U /= 2.0f;
    }

    @Override
    public final int c() {
        return 1;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)(this.P % 32) + this.Q / 4.0f) / 32.0f;
        float f8 = f7 + 0.0078046876f;
        float f9 = ((float)(this.P / 32) + this.R / 4.0f) / 32.0f;
        float f10 = f9 + 0.0078046876f;
        float f11 = 0.1f * this.U;
        float f12 = this.e + (this.h - this.e) * f;
        float f13 = this.f + (this.i - this.f) * f;
        float f14 = this.g + (this.j - this.g) * f;
        f = this.a(f);
        if (this.d.mc.f.nightVision && (f += 0.7f) > 1.0f) {
            f = 1.0f;
        }
        c_d.a(f * this.W, f * this.X, f * this.Y);
        c_d.a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        c_d.a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f7, f9);
        c_d.a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        c_d.a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f8, f10);
    }
}

