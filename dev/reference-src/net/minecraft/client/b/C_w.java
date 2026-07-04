/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_w
extends C_l {
    public C_c bipedHead = new C_c(0, 0);
    public C_c bipedBody;
    public C_c bipedRightArm;
    public C_c bipedLeftArm;
    public C_c bipedRightLeg;
    public C_c bipedLeftLeg;
    public C_c bipedRightHorn;
    public C_c bipedLeftHorn;

    public C_w() {
        this(0.0f);
    }

    public C_w(float f) {
        this(f, 0.0f);
    }

    private C_w(float f, float f2) {
        this.bipedHead.a(-4.0f, 0.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.a(0.0f, 0.0f, 0.0f);
        this.bipedRightHorn = new C_c(32, 0);
        this.bipedRightHorn.a(-3.5f, -2.0f, -0.5f, 1, 2, 1, f);
        this.bipedRightHorn.a(0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(this.bipedRightHorn);
        this.bipedLeftHorn = new C_c(32, 0);
        this.bipedLeftHorn.a(2.5f, -2.0f, -0.5f, 1, 2, 1, f);
        this.bipedLeftHorn.a(0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(this.bipedLeftHorn);
        this.bipedBody = new C_c(16, 16);
        this.bipedBody.a(-4.0f, 8.0f, -2.0f, 8, 8, 4, f);
        this.bipedBody.a(0.0f, 0.0f, 0.0f);
        this.bipedRightArm = new C_c(40, 16);
        this.bipedRightArm.a(-3.0f, -2.0f, -2.0f, 4, 8, 4, f);
        this.bipedRightArm.a(-5.0f, 10.0f, 0.0f);
        this.bipedLeftArm = new C_c(40, 16);
        this.bipedLeftArm.d = true;
        this.bipedLeftArm.a(-1.0f, -2.0f, -2.0f, 4, 8, 4, f);
        this.bipedLeftArm.a(5.0f, 10.0f, 0.0f);
        this.bipedRightLeg = new C_c(0, 16);
        this.bipedRightLeg.a(-2.0f, 0.0f, -2.0f, 4, 8, 4, f);
        this.bipedRightLeg.a(-2.0f, 16.0f, 0.0f);
        this.bipedLeftLeg = new C_c(0, 16);
        this.bipedLeftLeg.d = true;
        this.bipedLeftLeg.a(-2.0f, 0.0f, -2.0f, 4, 8, 4, f);
        this.bipedLeftLeg.a(2.0f, 16.0f, 0.0f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.bipedHead.a(1.0f);
        this.bipedBody.a(1.0f);
        this.bipedRightArm.a(1.0f);
        this.bipedLeftArm.a(1.0f);
        this.bipedRightLeg.a(1.0f);
        this.bipedLeftLeg.a(1.0f);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.bipedHead.b = f4 / 57.295776f;
        this.bipedHead.a = f5 / 57.295776f;
        this.bipedRightArm.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 2.0f * f2 * 0.5f;
        this.bipedLeftArm.a = MathHelper.b(f * 0.6662f) * 2.0f * f2 * 0.5f;
        this.bipedRightArm.c = 0.0f;
        this.bipedLeftArm.c = 0.0f;
        this.bipedRightLeg.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.bipedLeftLeg.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.bipedRightArm.c += MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.c -= MathHelper.b(f3 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.a += MathHelper.a(f3 * 0.067f) * 0.05f;
        this.bipedLeftArm.a -= MathHelper.a(f3 * 0.067f) * 0.05f;
        this.bipedRightArm.b = 0.0f;
        this.bipedLeftArm.b = 0.0f;
        this.bipedRightLeg.b = 0.0f;
        this.bipedLeftLeg.b = 0.0f;
    }
}

