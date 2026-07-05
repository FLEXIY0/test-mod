/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_o
extends C_l {
    private C_c batHead = new C_c(0, 0).setTextureSize(64, 64);
    private C_c batBody;
    private C_c batRightWing;
    private C_c batLeftWing;
    private C_c batOuterRightWing;
    private C_c batOuterLeftWing;
    public boolean isHanging = false;

    public C_o() {
        this.batHead.a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        C_c c_c = new C_c(24, 0).setTextureSize(64, 64);
        c_c.a(-4.0f, -6.0f, -2.0f, 3, 4, 1, 0.0f);
        this.batHead.addChild(c_c);
        C_c c_c2 = new C_c(24, 0).setTextureSize(64, 64);
        c_c2.d = true;
        c_c2.a(1.0f, -6.0f, -2.0f, 3, 4, 1, 0.0f);
        this.batHead.addChild(c_c2);
        this.batBody = new C_c(0, 16).setTextureSize(64, 64);
        this.batBody.a(-3.0f, 4.0f, -3.0f, 6, 12, 6, 0.0f);
        this.batRightWing = new C_c(42, 0).setTextureSize(64, 64);
        this.batRightWing.a(-12.0f, 1.0f, 1.5f, 10, 16, 1, 0.0f);
        this.batOuterRightWing = new C_c(24, 16).setTextureSize(64, 64);
        this.batOuterRightWing.a(-12.0f, 1.0f, 1.5f);
        this.batOuterRightWing.a(-8.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f);
        this.batLeftWing = new C_c(42, 0).setTextureSize(64, 64);
        this.batLeftWing.d = true;
        this.batLeftWing.a(2.0f, 1.0f, 1.5f, 10, 16, 1, 0.0f);
        this.batOuterLeftWing = new C_c(24, 16).setTextureSize(64, 64);
        this.batOuterLeftWing.d = true;
        this.batOuterLeftWing.a(12.0f, 1.0f, 1.5f);
        this.batOuterLeftWing.a(0.0f, 1.0f, 0.0f, 8, 12, 1, 0.0f);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }

    public int getBatSize() {
        return 36;
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.batHead.a(f6);
        this.batBody.a(f6);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.isHanging) {
            this.batHead.a = f5 / 57.295776f;
            this.batHead.b = (float)Math.PI - f4 / 57.295776f;
            this.batHead.c = (float)Math.PI;
            this.batHead.a(0.0f, -2.0f, 0.0f);
            this.batRightWing.a(-3.0f, 0.0f, 3.0f);
            this.batLeftWing.a(3.0f, 0.0f, 3.0f);
            this.batBody.a = (float)Math.PI;
            this.batRightWing.a = -0.15707964f;
            this.batRightWing.b = -1.2566371f;
            this.batOuterRightWing.b = -1.7278761f;
            this.batLeftWing.a = this.batRightWing.a;
            this.batLeftWing.b = -this.batRightWing.b;
            this.batOuterLeftWing.b = -this.batOuterRightWing.b;
        } else {
            this.batHead.a = f5 / 57.295776f;
            this.batHead.b = f4 / 57.295776f;
            this.batHead.c = 0.0f;
            this.batHead.a(0.0f, 0.0f, 0.0f);
            this.batRightWing.a(0.0f, 0.0f, 0.0f);
            this.batLeftWing.a(0.0f, 0.0f, 0.0f);
            this.batBody.a = 0.7853982f + MathHelper.b(f3 * 0.1f) * 0.15f;
            this.batBody.b = 0.0f;
            this.batRightWing.b = MathHelper.b(f3 * 1.3f) * (float)Math.PI * 0.25f;
            this.batLeftWing.b = -this.batRightWing.b;
            this.batOuterRightWing.b = this.batRightWing.b * 0.5f;
            this.batOuterLeftWing.b = -this.batRightWing.b * 0.5f;
        }
    }
}

