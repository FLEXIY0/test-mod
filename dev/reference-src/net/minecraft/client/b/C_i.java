/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_j;

public final class C_i {
    public C_j[] a;

    private C_i(C_j[] c_jArray) {
        this.a = c_jArray;
    }

    public C_i(C_j[] c_jArray, int n, int n2, int n3, int n4, float f, float f2) {
        this(c_jArray);
        float f3 = 0.0f / f;
        float f4 = 0.0f / f2;
        c_jArray[0] = c_jArray[0].a((float)n3 / f - f3, (float)n2 / f2 + f4);
        c_jArray[1] = c_jArray[1].a((float)n / f + f3, (float)n2 / f2 + f4);
        c_jArray[2] = c_jArray[2].a((float)n / f + f3, (float)n4 / f2 - f4);
        c_jArray[3] = c_jArray[3].a((float)n3 / f - f3, (float)n4 / f2 - f4);
    }
}

