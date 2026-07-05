/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;

public class C_x
extends C_l {
    C_c body;
    C_c[] tentacles = new C_c[4];

    public C_x() {
        int n = -16;
        this.body = new C_c(0, 0);
        this.body.a(-6.0f, -8.0f, -6.0f, 12, 6, 12, 0.0f);
        this.body.k += (float)(24 + n);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = new C_c(48, 0);
            double d2 = 0.7853981633974483 + (double)i * Math.PI * 2.0 / (double)this.tentacles.length;
            float f = (float)Math.cos(d2) * 3.0f;
            float f2 = (float)Math.sin(d2) * 3.0f;
            this.tentacles[i].a(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
            this.tentacles[i].j = f;
            this.tentacles[i].l = f2;
            this.tentacles[i].k = 22 + n;
            d2 = (double)i * Math.PI * -2.0 / (double)this.tentacles.length + 0.7853981633974483;
            this.tentacles[i].b = (float)d2;
        }
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].a = f3;
        }
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.b(f, f2, f3, f4, f5, f6);
        this.body.a(f6);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].a(f6);
        }
    }
}

