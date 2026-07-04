/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_n
extends C_l {
    private C_c head = new C_c(32, 4).setTextureSize(64, 48);
    private final C_c pincerLeft2;
    private final C_c pincerLeft1;
    private final C_c pincerRight2;
    private final C_c pincerRight1;
    private final C_c bodyRing1;
    private final C_c bodyRing2;
    private final C_c bodyRing3;
    private final C_c tail;
    private final C_c tailBase;
    private C_c neck;
    private C_c body;
    private C_c leg1;
    private C_c leg2;
    private C_c leg3;
    private C_c leg4;
    private C_c leg5;
    private C_c leg6;
    public boolean isBuried = false;

    public C_n() {
        this.head.a(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.head.a(0.0f, 15.0f, -3.0f);
        this.pincerLeft2 = new C_c(49, 32).setTextureSize(64, 48);
        this.pincerLeft2.a(-2.0f, 1.0f, 1.0f, 3, 1, 1, 0.0f);
        this.pincerLeft2.a(1.17f, 1.0f, -12.0f);
        this.head.addChild(this.pincerLeft2);
        this.pincerLeft1 = new C_c(49, 32).setTextureSize(64, 48);
        this.pincerLeft1.a(2.0f, 1.0f, -12.0f, 2, 2, 4, 0.0f);
        this.head.addChild(this.pincerLeft1);
        this.pincerRight2 = new C_c(49, 32).setTextureSize(64, 48);
        this.pincerRight2.a(0.0f, 1.0f, 0.0f, 3, 1, 1, 0.0f);
        this.pincerRight2.a(-4.0f, 1.0f, -12.0f);
        this.head.addChild(this.pincerRight2);
        this.pincerRight1 = new C_c(49, 32).setTextureSize(64, 48);
        this.pincerRight1.a(-4.0f, 1.0f, -12.0f, 2, 2, 4, 0.0f);
        this.head.addChild(this.pincerRight1);
        this.neck = new C_c(0, 0).setTextureSize(64, 48);
        this.neck.a(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.neck.a(0.0f, 15.0f, 0.0f);
        this.body = new C_c(0, 12).setTextureSize(64, 48);
        this.body.a(-5.0f, -4.0f, -6.0f, 10, 8, 12, 0.0f);
        this.body.a(0.0f, 15.0f, 9.0f);
        this.bodyRing1 = new C_c(0, 32).setTextureSize(64, 48);
        this.bodyRing1.a(-6.0f, -5.0f, -4.0f, 12, 10, 1, 0.0f);
        this.body.addChild(this.bodyRing1);
        this.bodyRing2 = new C_c(0, 32).setTextureSize(64, 48);
        this.bodyRing2.a(-6.0f, -5.0f, -1.0f, 12, 10, 1, 0.0f);
        this.body.addChild(this.bodyRing2);
        this.bodyRing3 = new C_c(0, 32).setTextureSize(64, 48);
        this.bodyRing3.a(-6.0f, -5.0f, 2.0f, 12, 10, 1, 0.0f);
        this.body.addChild(this.bodyRing3);
        this.tail = new C_c(0, 32).setTextureSize(64, 48);
        this.tail.a(-1.0f, -1.0f, 7.0f, 2, 2, 2, 0.0f);
        this.body.addChild(this.tail);
        this.tailBase = new C_c(0, 32).setTextureSize(64, 48);
        this.tailBase.a(-2.0f, -2.0f, 6.0f, 4, 4, 1, 0.0f);
        this.body.addChild(this.tailBase);
        this.leg1 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg1.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg1.a(-4.0f, 15.0f, 2.0f);
        this.leg2 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg2.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg2.a(4.0f, 15.0f, 2.0f);
        this.leg3 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg3.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg3.a(-4.0f, 15.0f, 0.0f);
        this.leg4 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg4.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg4.a(4.0f, 15.0f, 0.0f);
        this.leg5 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg5.a(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg5.a(-4.0f, 15.0f, -2.0f);
        this.leg6 = new C_c(18, 0).setTextureSize(64, 48);
        this.leg6.a(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.leg6.a(4.0f, 15.0f, -2.0f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, 1.0f);
        this.head.a(1.0f);
        this.neck.a(1.0f);
        if (!this.isBuried) {
            this.body.a(1.0f);
            this.leg1.a(1.0f);
            this.leg2.a(1.0f);
            this.leg3.a(1.0f);
            this.leg4.a(1.0f);
            this.leg5.a(1.0f);
            this.leg6.a(1.0f);
        }
    }

    @Override
    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.head.b = f4 / 57.295776f;
        this.head.a = f5 / 57.295776f;
        this.neck.a = 0.0f;
        this.leg1.c = -0.7853982f;
        this.leg2.c = 0.7853982f;
        this.leg3.c = -0.58119464f;
        this.leg4.c = 0.58119464f;
        this.leg5.c = -0.58119464f;
        this.leg6.c = 0.58119464f;
        this.leg1.b = 0.3926991f;
        this.leg2.b = -0.3926991f;
        this.leg3.b = -0.08119464f;
        this.leg4.b = 0.08119464f;
        this.leg5.b = -0.3926991f;
        this.leg6.b = 0.3926991f;
        this.pincerLeft2.b = 2.3561945f;
        this.pincerRight2.b = 0.7853982f;
        this.neck.k = 15.0f;
        this.neck.l = 0.0f;
        if (this.isBuried) {
            GL11.glTranslatef((float)0.0f, (float)8.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)6.0f);
            this.head.a = -0.3926991f;
            this.neck.a = -0.6926991f;
            this.neck.k = 17.0f;
            this.neck.l = -1.5f;
        }
        f3 = -(MathHelper.b(f * 0.6662f * 2.0f) * 0.4f) * f2;
        f4 = -(MathHelper.b(f * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * f2;
        f5 = -(MathHelper.b(f * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * f2;
        f6 = -(MathHelper.b(f * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f2;
        float f7 = Math.abs(MathHelper.a(f * 0.6662f) * 0.4f) * f2;
        float f8 = Math.abs(MathHelper.a(f * 0.6662f + (float)Math.PI) * 0.4f) * f2;
        float f9 = Math.abs(MathHelper.a(f * 0.6662f + 1.5707964f) * 0.4f) * f2;
        f = Math.abs(MathHelper.a(f * 0.6662f + 4.712389f) * 0.4f) * f2;
        this.leg1.b += f3;
        this.leg2.b -= f3;
        this.leg3.b += f4;
        this.leg4.b -= f4;
        this.leg5.b += f5;
        this.leg6.b -= f5;
        this.leg1.c += f7;
        this.leg2.c -= f7;
        this.leg3.c += f8;
        this.leg4.c -= f8;
        this.leg5.c += f9;
        this.leg6.c -= f9;
    }
}

