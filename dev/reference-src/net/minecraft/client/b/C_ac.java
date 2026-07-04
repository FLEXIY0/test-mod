/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;

public class C_ac
extends C_l {
    C_c slimeBodies;
    C_c slimeRightEye;
    C_c slimeLeftEye;
    C_c slimeMouth;

    public C_ac(int n) {
        this.slimeBodies = new C_c(0, n);
        this.slimeBodies.a(-4.0f, 16.0f, -4.0f, 8, 8, 8, 0.0f);
        if (n > 0) {
            this.slimeBodies = new C_c(0, n);
            this.slimeBodies.a(-3.0f, 17.0f, -3.0f, 6, 6, 6, 0.0f);
            this.slimeRightEye = new C_c(32, 0);
            this.slimeRightEye.a(-3.25f, 18.0f, -3.5f, 2, 2, 2, 0.0f);
            this.slimeLeftEye = new C_c(32, 4);
            this.slimeLeftEye.a(1.25f, 18.0f, -3.5f, 2, 2, 2, 0.0f);
            this.slimeMouth = new C_c(32, 8);
            this.slimeMouth.a(0.0f, 21.0f, -3.5f, 1, 1, 1, 0.0f);
        }
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.slimeBodies.a(f6);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.a(f6);
            this.slimeLeftEye.a(f6);
            this.slimeMouth.a(f6);
        }
    }
}

