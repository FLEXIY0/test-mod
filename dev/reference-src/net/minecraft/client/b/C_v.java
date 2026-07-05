/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_v
extends C_l {
    private C_c head = new C_c(0, 0).setTextureSize(64, 64);
    private C_c body;
    private C_c legRight;
    private C_c legLeft;
    private C_c rightWing;
    private C_c leftWing;
    private C_c outerRightWing;
    private C_c outerLeftWing;

    public C_v() {
        this.head.a(-4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f);
        this.body = new C_c(0, 48).setTextureSize(64, 64);
        this.body.a(-4.0f, 0.0f, -2.0f, 8, 12, 4, 0.0f);
        this.legRight = new C_c(24, 48).setTextureSize(64, 64);
        this.legRight.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legRight.a(-2.0f, 12.0f, 0.0f);
        this.legLeft = new C_c(24, 48).setTextureSize(64, 64);
        this.legLeft.a(-2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f);
        this.legLeft.a(2.0f, 12.0f, 0.0f);
        this.legLeft.d = true;
        this.rightWing = new C_c(42, 0).setTextureSize(64, 64);
        this.rightWing.a(-12.0f, 0.0f, 1.5f, 10, 16, 1, 0.0f);
        this.outerRightWing = new C_c(24, 16).setTextureSize(64, 64);
        this.outerRightWing.a(-12.0f, 3.0f, 1.5f);
        this.outerRightWing.a(-8.0f, -2.0f, 0.0f, 8, 12, 1, 0.0f);
        this.leftWing = new C_c(42, 0).setTextureSize(64, 64);
        this.leftWing.d = true;
        this.leftWing.a(2.0f, 0.0f, 1.5f, 10, 16, 1, 0.0f);
        this.outerLeftWing = new C_c(24, 16).setTextureSize(64, 64);
        this.outerLeftWing.d = true;
        this.outerLeftWing.a(12.0f, 3.0f, 1.5f);
        this.outerLeftWing.a(0.0f, -2.0f, 0.0f, 8, 12, 1, 0.0f);
        this.body.addChild(this.rightWing);
        this.body.addChild(this.leftWing);
        this.rightWing.addChild(this.outerRightWing);
        this.leftWing.addChild(this.outerLeftWing);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.head.a(f6);
        this.body.a(f6);
        this.legRight.a(f6);
        this.legLeft.a(f6);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.head.a = f5 / 57.295776f;
        this.head.b = f4 / 57.295776f;
        this.head.c = 0.0f;
        this.head.a(0.0f, 0.0f, 0.0f);
        this.rightWing.a(0.0f, 0.0f, 0.0f);
        this.leftWing.a(0.0f, 0.0f, 0.0f);
        this.legRight.a = this.legLeft.a = 0.7853982f + MathHelper.b(f3 * 0.1f) * 0.15f;
        this.legLeft.b = 0.0f;
        this.legRight.b = 0.0f;
        this.rightWing.b = MathHelper.b(f3) * (float)Math.PI * 0.25f;
        this.leftWing.b = -this.rightWing.b;
        this.outerRightWing.b = this.rightWing.b * 0.5f;
        this.outerLeftWing.b = -this.rightWing.b * 0.5f;
    }
}

