/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.a.d.C_a;

public final class C_j {
    public C_a a;
    public float b;
    public float c;

    public C_j(float f, float f2, float f3, float f4, float f5) {
        this(new C_a(f, f2, f3), f4, f5);
    }

    public final C_j a(float f, float f2) {
        return new C_j(this, f, f2);
    }

    private C_j(C_j c_j, float f, float f2) {
        this.a = c_j.a;
        this.b = f;
        this.c = f2;
    }

    private C_j(C_a c_a, float f, float f2) {
        this.a = c_a;
        this.b = f;
        this.c = f2;
    }
}

