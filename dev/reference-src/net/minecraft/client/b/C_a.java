/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_b;
import net.minecraft.client.b.C_c;

public final class C_a
extends C_b {
    private float graze = 1.0f;
    private float grazeO;
    public boolean grazing = false;

    public C_a() {
        super(12, 0.0f);
        this.a = new C_c(0, 0);
        this.a.a(-3.0f, -4.0f, -6.0f, 6, 6, 8, 0.0f);
        this.a.a(0.0f, 6.0f, -8.0f);
        this.b = new C_c(28, 8);
        this.b.a(-4.0f, -10.0f, -7.0f, 8, 16, 6, 0.0f);
        this.b.a(0.0f, 5.0f, 2.0f);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        super.b(f, f2, f3, f4, f5, f6);
        this.grazeO = this.graze;
        this.graze = this.grazing ? (this.graze += 0.2f) : (this.graze -= 0.2f);
        if (this.graze < 0.5f) {
            this.graze = 0.5f;
        }
        if (this.graze > 1.5f) {
            this.graze = 1.5f;
        }
        this.a.k = this.grazing ? (this.a.k += (this.grazeO + (this.graze - this.grazeO) * f2) * 8.0f) : (this.a.k -= (this.grazeO + (this.graze - this.grazeO) * f2) * 8.0f);
        if (this.a.k > 12.0f) {
            this.a.k = 12.0f;
        }
        if (this.a.k < 6.0f) {
            this.a.k = 6.0f;
        }
    }
}

