/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_s
extends C_l {
    public C_c head;
    public C_c body;
    public C_c rightLeg;
    public C_c leftLeg;
    public C_c rightWing;
    public C_c leftWing;
    public C_c bill;
    public C_c chin;

    public C_s() {
        int n = 16;
        this.head = new C_c(0, 0);
        this.head.a(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.head.a(0.0f, -1 + n, -4.0f);
        this.bill = new C_c(14, 0);
        this.bill.a(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.bill.a(0.0f, -1 + n, -4.0f);
        this.chin = new C_c(14, 4);
        this.chin.a(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.chin.a(0.0f, -1 + n, -4.0f);
        this.body = new C_c(0, 9);
        this.body.a(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.body.a(0.0f, 0 + n, 0.0f);
        this.rightLeg = new C_c(26, 0);
        this.rightLeg.a(-1.0f, 0.0f, -3.0f, 3, 5, 3, 0.0f);
        this.rightLeg.a(-2.0f, 3 + n, 1.0f);
        this.leftLeg = new C_c(26, 0);
        this.leftLeg.a(-1.0f, 0.0f, -3.0f, 3, 5, 3, 0.0f);
        this.leftLeg.a(1.0f, 3 + n, 1.0f);
        this.rightWing = new C_c(24, 13);
        this.rightWing.a(0.0f, 0.0f, -3.0f, 1, 4, 6, 0.0f);
        this.rightWing.a(-4.0f, -3 + n, 0.0f);
        this.leftWing = new C_c(24, 13);
        this.leftWing.a(-1.0f, 0.0f, -3.0f, 1, 4, 6, 0.0f);
        this.leftWing.a(4.0f, -3 + n, 0.0f);
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.head.a(f6);
        this.bill.a(f6);
        this.chin.a(f6);
        this.body.a(f6);
        this.rightLeg.a(f6);
        this.leftLeg.a(f6);
        this.rightWing.a(f6);
        this.leftWing.a(f6);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        this.head.a = -(f5 / 57.295776f);
        this.head.b = f4 / 57.295776f;
        this.bill.a = this.head.a;
        this.bill.b = this.head.b;
        this.chin.a = this.head.a;
        this.chin.b = this.head.b;
        this.body.a = 1.5707964f;
        this.rightLeg.a = MathHelper.b(f * 0.6662f) * 1.4f * f2;
        this.leftLeg.a = MathHelper.b(f * 0.6662f + (float)Math.PI) * 1.4f * f2;
        this.rightWing.c = f3;
        this.leftWing.c = -f3;
    }
}

