/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_t
extends C_l {
    private final C_c body = new C_c(0, 0);
    private final C_c head;
    private final C_c leftFin;
    private final C_c rightFin;
    private final C_c topFin;
    private final C_c tailFin;

    public C_t() {
        this.body.a(0.0f, 24.0f, 0.0f);
        this.body.a(-1.0f, -4.0f, 1.0f, 2, 4, 7, 0.0f);
        this.head = new C_c(11, 0);
        this.head.a(0.0f, 0.0f, 0.0f);
        this.head.a(-1.0f, -4.0f, -2.0f, 2, 4, 3, 0.0f);
        this.body.addChild(this.head);
        this.topFin = new C_c(0, 11);
        this.topFin.a(0.0f, 0.0f, 0.0f);
        this.topFin.a(0.0f, -5.0f, 0.0f, 0, 1, 6, 0.0f);
        this.body.addChild(this.topFin);
        this.leftFin = new C_c(12, 14);
        this.leftFin.a(-1.0f, 23.0f, 0.0f);
        this.setRotationAngle(this.leftFin, 0.0f, 0.0f, -0.6109f);
        this.leftFin.a(-2.0f, 0.0f, 0.0f, 2, 1, 2, 0.0f);
        this.rightFin = new C_c(12, 18);
        this.rightFin.a(1.0f, 23.0f, 0.0f);
        this.setRotationAngle(this.rightFin, 0.0f, 0.0f, 0.6109f);
        this.rightFin.a(0.0f, 0.0f, 0.0f, 2, 1, 2, 0.0f);
        this.tailFin = new C_c(26, 0);
        this.tailFin.a(0.0f, 0.0f, 8.0f);
        this.tailFin.a(0.0f, -4.0f, -2.0f, 0, 4, 6, 0.0f);
        this.body.addChild(this.tailFin);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.body.a(f6);
        this.rightFin.a(f6);
        this.leftFin.a(f6);
    }

    public void setRotationAngle(C_c c_c, float f, float f2, float f3) {
        c_c.a = f;
        c_c.b = f2;
        c_c.c = f3;
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.rightFin.b = this.leftFin.b = MathHelper.b(f3 * 0.9f + 0.47123894f) * (float)Math.PI * 0.05f;
        this.body.b = this.leftFin.b;
        this.tailFin.b = -(MathHelper.b(f3 * 0.9f + 0.47123894f) * (float)Math.PI * 0.1f * (float)Math.abs(2));
    }
}

