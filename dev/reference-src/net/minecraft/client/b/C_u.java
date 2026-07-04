/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_u
extends C_l {
    private final C_c head = new C_c(1, 5);
    private final C_c earL;
    private final C_c earR;
    private final C_c nose;
    private final C_c body;
    private final C_c leg0;
    private final C_c leg1;
    private final C_c leg2;
    private final C_c leg3;
    private final C_c tail;
    public boolean isSleeping;

    public C_u() {
        this.head.a(-3.0f, -2.0f, -5.0f, 8, 6, 6, 0.0f);
        this.head.a(-1.0f, 16.5f, -3.0f);
        this.earL = new C_c(8, 1);
        this.earL.a(-3.0f, -4.0f, -4.0f, 2, 2, 1, 0.0f);
        this.earL.a(-1.0f, 14.5f, 0.0f);
        this.earR = new C_c(15, 1);
        this.earR.a(3.0f, -4.0f, -4.0f, 2, 2, 1, 0.0f);
        this.earR.a(-1.0f, 14.5f, 0.0f);
        this.nose = new C_c(6, 18);
        this.nose.a(-1.0f, 2.01f, -8.0f, 4, 2, 3, 0.0f);
        this.nose.a(-1.0f, 14.5f, -3.0f);
        this.body = new C_c(24, 15);
        this.body.a(-3.0f, 3.999f, -3.5f, 6, 11, 6, 0.0f);
        this.body.a(0.0f, 16.0f, -6.0f);
        this.leg0 = new C_c(13, 24);
        this.leg0.a(2.0f, 0.5f, -1.0f, 2, 6, 2, 0.001f);
        this.leg0.a(-5.0f, 17.5f, 7.0f);
        this.leg1 = new C_c(4, 24);
        this.leg1.a(2.0f, 0.5f, -1.0f, 2, 6, 2, 0.001f);
        this.leg1.a(-1.0f, 17.5f, 7.0f);
        this.leg2 = new C_c(13, 24);
        this.leg2.a(2.0f, 0.5f, -1.0f, 2, 6, 2, 0.001f);
        this.leg2.a(-5.0f, 17.5f, 0.0f);
        this.leg3 = new C_c(4, 24);
        this.leg3.a(2.0f, 0.5f, -1.0f, 2, 6, 2, 0.001f);
        this.leg3.a(-1.0f, 17.5f, 0.0f);
        this.tail = new C_c(30, 0);
        this.tail.a(2.0f, 0.0f, -1.0f, 4, 9, 5, 0.0f);
        this.tail.a(-4.0f, 18.0f, 7.0f);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.head.a(f6);
        this.earL.a(f6);
        this.earR.a(f6);
        this.nose.a(f6);
        this.body.a(f6);
        if (!this.isSleeping) {
            this.leg0.a(f6);
            this.leg1.a(f6);
            this.leg2.a(f6);
            this.leg3.a(f6);
        }
        this.tail.a(f6);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.body.a = 1.5707964f;
        this.tail.a(-4.0f, 18.0f, 7.0f);
        this.tail.a = 1.5707964f;
        this.tail.c = 0.0f;
        this.leg0.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.leg1.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg2.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.leg3.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.head.a(-1.0f, 14.5f, -3.0f);
        this.head.b = 0.0f;
        this.nose.a(-1.0f, 14.5f, -3.0f);
        this.nose.b = 0.0f;
        this.earL.a(-1.0f, 14.5f, 0.0f);
        this.earL.b = 0.0f;
        this.earR.a(-1.0f, 14.5f, 0.0f);
        this.earR.b = 0.0f;
        this.body.a(0.0f, 16.0f, -6.0f);
        this.body.c = 0.0f;
        this.leg0.a(-5.0f, 17.5f, 7.0f);
        this.leg1.a(-1.0f, 17.5f, 7.0f);
        if (this.isSleeping) {
            this.body.c = -1.5707964f;
            this.body.a(0.0f, 21.0f, -6.0f);
            this.tail.a = -2.6179938f;
            this.tail.c = 1.6179938f;
            this.tail.a(2.0f, 17.5f, 9.0f);
            this.head.a(1.0f, 19.49f, -3.0f);
            this.head.b = -2.0943952f;
            this.nose.b = -2.0943952f;
            this.nose.a(1.0f, 19.49f, -3.0f);
            this.earR.b = -2.0943952f;
            this.earR.a(1.0f, 19.49f, -3.0f);
            this.earL.b = -2.0943952f;
            this.earL.a(1.0f, 19.49f, -3.0f);
        }
    }
}

