/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.b;

import net.minecraft.client.a.b.C_a;
import net.minecraft.client.a.b.C_b;
import net.minecraft.client.a.b.C_e;

public final class C_c
implements C_e {
    private C_b a = C_a.a();

    @Override
    public final boolean a(net.minecraft.a.d.C_b c_b) {
        float f = c_b.f;
        float f2 = c_b.e;
        float f3 = c_b.d;
        float f4 = c_b.c;
        float f5 = c_b.b;
        float f6 = c_b.a;
        C_b c_b2 = this.a;
        for (int i = 0; i < 6; ++i) {
            if (!(c_b2.a[i][0] * f6 + c_b2.a[i][1] * f5 + c_b2.a[i][2] * f4 + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f3 + c_b2.a[i][1] * f5 + c_b2.a[i][2] * f4 + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f6 + c_b2.a[i][1] * f2 + c_b2.a[i][2] * f4 + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f3 + c_b2.a[i][1] * f2 + c_b2.a[i][2] * f4 + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f6 + c_b2.a[i][1] * f5 + c_b2.a[i][2] * f + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f3 + c_b2.a[i][1] * f5 + c_b2.a[i][2] * f + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f6 + c_b2.a[i][1] * f2 + c_b2.a[i][2] * f + c_b2.a[i][3] <= 0.0f) || !(c_b2.a[i][0] * f3 + c_b2.a[i][1] * f2 + c_b2.a[i][2] * f + c_b2.a[i][3] <= 0.0f)) continue;
            return false;
        }
        return true;
    }
}

