/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.GameSettings;
import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_h
extends C_l {
    public C_c a = new C_c(0, 0);
    public C_c b;
    public C_c c;
    public C_c d;
    public C_c e;
    public C_c f;
    public C_c g;
    public int sneaking = 0;
    public boolean inWater = false;
    public boolean heldItemLeft = false;
    public boolean heldItemRight = false;
    public boolean isRiding;
    public boolean blocking;
    public boolean aimedBow;

    public C_h() {
        this(0.0f);
    }

    public C_h(float f) {
        this(f, 0.0f);
    }

    private C_h(float f, float f2) {
        this.a.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.a.a(0.0f, 0.0f, 0.0f);
        this.b = new C_c(32, 0);
        this.b.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f + 0.5f);
        this.b.a(0.0f, 0.0f, 0.0f);
        this.c = new C_c(16, 16);
        this.c.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, f);
        this.c.a(0.0f, 0.0f, 0.0f);
        this.d = new C_c(40, 16);
        this.d.a(-3.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.d.a(-5.0f, 2.0f, 0.0f);
        this.e = new C_c(40, 16);
        this.e.d = true;
        this.e.a(-1.0f, -2.0f, -2.0f, 4, 12, 4, f);
        this.e.a(5.0f, 2.0f, 0.0f);
        this.f = new C_c(0, 16);
        this.f.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.f.a(-2.0f, 12.0f, 0.0f);
        this.g = new C_c(0, 16);
        this.g.d = true;
        this.g.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, f);
        this.g.a(2.0f, 12.0f, 0.0f);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.a.a(1.0f);
        this.c.a(1.0f);
        this.d.a(1.0f);
        this.e.a(1.0f);
        this.f.a(1.0f);
        this.g.a(1.0f);
        this.b.a(1.0f);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a.b = f4 / 57.295776f;
        this.a.a = f5 / 57.295776f;
        if (GameSettings.armFlailing) {
            this.d.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 2.0f * f2;
            this.d.c = (MathHelper.b(f * 0.2312f) + 1.0f) * f2;
            this.e.a = MathHelper.b(f * 0.6662f) * 2.0f * f2;
            this.e.c = (MathHelper.b(f * 0.2812f) - 1.0f) * f2;
        } else {
            this.d.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
            this.e.a = MathHelper.b(f * 0.6662f) * 2.0f * f2 * 0.5f;
            this.d.c = 0.0f;
            this.e.c = 0.0f;
        }
        this.f.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.g.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.d.c += MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.e.c -= MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.d.a += MathHelper.a(f3 * 0.067f) * 0.05f;
        this.e.a -= MathHelper.a(f3 * 0.067f) * 0.05f;
        this.d.b = 0.0f;
        this.e.b = 0.0f;
        if (this.isRiding) {
            this.d.a += -0.62831855f;
            this.e.a += -0.62831855f;
            this.f.a = -1.2566371f;
            this.g.a = -1.2566371f;
            this.f.b = 0.31415927f;
            this.g.b = -0.31415927f;
        } else {
            this.f.b = 0.0f;
            this.g.b = 0.0f;
        }
        if (this.heldItemLeft) {
            this.e.a = this.e.a * 0.5f - 0.31415927f;
        }
        if (this.heldItemRight) {
            this.d.a = this.d.a * 0.5f - 0.31415927f;
        }
        if (this.blocking) {
            this.d.a = this.d.a * 0.5f - 0.9424778f;
        }
        if (this.aimedBow) {
            this.d.c = 0.0f;
            this.e.c = 0.0f;
            this.d.b = -0.1f + this.a.b;
            this.e.b = 0.1f + this.a.b + 0.4f;
            this.d.a = -1.5707964f + this.a.a;
            this.e.a = -1.5707964f + this.a.a;
            this.d.c += MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
            this.e.c -= MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
            this.d.a += MathHelper.a(f3 * 0.067f) * 0.05f;
            this.e.a -= MathHelper.a(f3 * 0.067f) * 0.05f;
        }
        if (this.swingProgress > -9990.0f) {
            float f7 = this.swingProgress;
            this.c.b = MathHelper.a(MathHelper.c(f7) * (float)Math.PI * 2.0f) * 0.2f;
            this.d.l = MathHelper.a(this.c.b) * 5.0f;
            this.d.j = -MathHelper.b(this.c.b) * 5.0f;
            this.e.l = -MathHelper.a(this.c.b) * 5.0f;
            this.e.j = MathHelper.b(this.c.b) * 5.0f;
            this.d.b += this.c.b;
            this.e.b += this.c.b;
            this.e.a += this.c.b;
            f7 = 1.0f - this.swingProgress;
            f7 *= f7;
            f7 *= f7;
            f7 = 1.0f - f7;
            float f8 = MathHelper.a(f7 * (float)Math.PI);
            float f9 = MathHelper.a(this.swingProgress * (float)Math.PI) * -(this.a.a - 0.7f) * 0.75f;
            this.d.a = (float)((double)this.d.a - ((double)f8 * 1.2 + (double)f9));
            this.d.b += this.c.b * 2.0f;
            this.d.c += MathHelper.a(this.swingProgress * (float)Math.PI) * -0.4f;
        }
        if (this.sneaking == 1 && !this.inWater) {
            this.c.a = 0.5f;
            this.f.a -= 0.0f;
            this.g.a -= 0.0f;
            this.d.a += 0.4f;
            this.e.a += 0.4f;
            this.f.l = 4.0f;
            this.g.l = 4.0f;
            this.f.k = 12.0f;
            this.g.k = 12.0f;
            this.a.k = 3.0f;
            this.c.k = 3.0f;
            this.e.k = 4.5f;
            this.d.k = 4.5f;
        } else if (this.sneaking == 2) {
            this.c.a = 1.5f;
            this.f.a -= -20.5f;
            this.g.a -= -20.5f;
            this.d.a -= 7.5f;
            this.e.a -= 7.5f;
            this.f.l = 0.0f;
            this.g.l = 0.0f;
            this.c.k = 21.0f;
            this.a.k = 21.0f;
            this.g.k = 22.0f;
            this.f.k = 22.0f;
            this.e.k = 21.0f;
            this.d.k = 21.0f;
            this.f.l = 9.0f;
            this.g.l = 9.0f;
        } else {
            this.c.a = 0.0f;
            this.f.l = 0.0f;
            this.g.l = 0.0f;
            this.f.k = 12.0f;
            this.g.k = 12.0f;
            this.a.k = 0.0f;
            this.b.k = 0.0f;
            this.c.k = 0.0f;
            this.e.k = 2.0f;
            this.d.k = 2.0f;
            this.f.l = 0.0f;
            this.g.l = 0.0f;
        }
        this.b.k = this.a.k;
        this.b.b = this.a.b;
        this.b.a = this.a.a;
    }
}

