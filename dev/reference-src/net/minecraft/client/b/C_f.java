/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_b;
import net.minecraft.client.b.C_c;

public final class C_f
extends C_b {
    public C_c nose = new C_c(16, 16);

    public C_f() {
        super(6, 0.0f);
        this.nose.a(-2.0f, 0.0f, -9.0f, 4, 3, 1, 0.0f);
        this.nose.a(0.0f, 12.0f, -6.0f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        super.a(f, f2, f3, f4, f5, f6);
        this.nose.a(f6);
    }

    @Override
    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        super.b(f, f2, f3, f4, f5, f6);
        this.nose.b = f4 / 57.295776f;
        this.nose.a = f5 / 57.295776f;
    }
}

