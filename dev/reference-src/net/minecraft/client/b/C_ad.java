/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_ad
extends C_l {
    public C_c stickRight;
    public C_c stickLeft;
    public C_c head1;
    public C_c bodyUpper;
    public C_c bodyLower;

    public C_ad() {
        float f = 4.0f;
        float f2 = 0.0f;
        this.head1 = new C_c(0, 0).setTextureSize(64, 64);
        this.head1.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 - 0.5f);
        this.head1.a(0.0f, 0.0f + f, 0.0f);
        this.bodyUpper = new C_c(32, 0).setTextureSize(64, 64);
        this.bodyUpper.a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f2 - 0.5f);
        this.bodyUpper.a(0.0f, 0.0f + f + 9.0f - 7.0f, 0.0f);
        this.bodyLower = new C_c(32, 0).setTextureSize(64, 64);
        this.bodyLower.a(-1.0f, 0.0f, -1.0f, 12, 2, 2, f2 - 0.5f);
        this.bodyLower.a(0.0f, 0.0f + f + 9.0f - 7.0f, 0.0f);
        this.stickRight = new C_c(0, 16).setTextureSize(64, 64);
        this.stickRight.a(-5.0f, -10.0f, -5.0f, 10, 10, 10, f2 - 0.5f);
        this.stickRight.a(0.0f, 0.0f + f + 9.0f, 0.0f);
        this.stickLeft = new C_c(0, 36).setTextureSize(64, 64);
        this.stickLeft.a(-6.0f, -12.0f, -6.0f, 12, 12, 12, f2 - 0.5f);
        this.stickLeft.a(0.0f, 0.0f + f + 20.0f, 0.0f);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        super.b(f, f2, f3, f4, f5, f6);
        this.head1.b = f4 / 57.295776f;
        this.head1.a = f5 / 57.295776f;
        this.stickRight.b = f4 / 57.295776f * 0.25f;
        float f7 = MathHelper.a(this.stickRight.b);
        float f8 = MathHelper.b(this.stickRight.b);
        this.bodyUpper.c = 1.0f;
        this.bodyLower.c = -1.0f;
        this.bodyUpper.b = 0.0f + this.stickRight.b;
        this.bodyLower.b = (float)Math.PI + this.stickRight.b;
        this.bodyUpper.j = f8 * 5.0f;
        this.bodyUpper.l = -f7 * 5.0f;
        this.bodyLower.j = -f8 * 5.0f;
        this.bodyLower.l = f7 * 5.0f;
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.stickRight.a(f6);
        this.stickLeft.a(f6);
        this.head1.a(f6);
        this.bodyUpper.a(f6);
        this.bodyLower.a(f6);
    }
}

