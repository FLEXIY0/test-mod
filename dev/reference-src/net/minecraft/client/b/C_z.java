/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;

public class C_z
extends C_l {
    public C_c[] sideModels = new C_c[7];

    public C_z() {
        this.sideModels[0] = new C_c(0, 10);
        this.sideModels[1] = new C_c(0, 0);
        this.sideModels[2] = new C_c(0, 0);
        this.sideModels[3] = new C_c(0, 0);
        this.sideModels[4] = new C_c(0, 0);
        this.sideModels[5] = new C_c(44, 10);
        int n = 20;
        int n2 = 8;
        int n3 = 16;
        int n4 = 4;
        this.sideModels[0].a(-n / 2, -n3 / 2, -1.0f, n, n3, 2, 0.0f);
        this.sideModels[0].a(0.0f, 0 + n4, 0.0f);
        this.sideModels[5].a(-n / 2 + 1, -n3 / 2 + 1, -1.0f, n - 2, n3 - 2, 1, 0.0f);
        this.sideModels[5].a(0.0f, 0 + n4, 0.0f);
        this.sideModels[1].a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.sideModels[1].a(-n / 2 + 1, 0 + n4, 0.0f);
        this.sideModels[2].a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.sideModels[2].a(n / 2 - 1, 0 + n4, 0.0f);
        this.sideModels[3].a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.sideModels[3].a(0.0f, 0 + n4, -n3 / 2 + 1);
        this.sideModels[4].a(-n / 2 + 2, -n2 - 1, -1.0f, n - 4, n2, 2, 0.0f);
        this.sideModels[4].a(0.0f, 0 + n4, n3 / 2 - 1);
        this.sideModels[0].a = 1.5707964f;
        this.sideModels[1].b = 4.712389f;
        this.sideModels[2].b = 1.5707964f;
        this.sideModels[3].b = (float)Math.PI;
        this.sideModels[5].a = -1.5707964f;
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.sideModels[5].k = 4.0f - f3;
        for (int i = 0; i < 6; ++i) {
            this.sideModels[i].a(f6);
        }
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
    }
}

