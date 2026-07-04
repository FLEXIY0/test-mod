/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_b;
import net.minecraft.client.b.C_c;

public class C_r
extends C_b {
    C_c udders;
    C_c horn1;
    C_c horn2;

    public C_r() {
        super(12, 0.0f);
        this.a = new C_c(0, 0);
        this.a.a(-4.0f, -4.0f, -6.0f, 8, 8, 6, 0.0f);
        this.a.a(0.0f, 4.0f, -8.0f);
        this.horn1 = new C_c(22, 0);
        this.horn1.a(-4.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.horn1.a(0.0f, 3.0f, -7.0f);
        this.horn2 = new C_c(22, 0);
        this.horn2.a(3.0f, -5.0f, -4.0f, 1, 3, 1, 0.0f);
        this.horn2.a(0.0f, 3.0f, -7.0f);
        this.udders = new C_c(52, 0);
        this.udders.a(-2.0f, -3.0f, 0.0f, 4, 6, 2, 0.0f);
        this.udders.a(0.0f, 14.0f, 6.0f);
        this.udders.a = 1.5707964f;
        this.b = new C_c(18, 4);
        this.b.a(-6.0f, -10.0f, -7.0f, 12, 18, 10, 0.0f);
        this.b.a(0.0f, 5.0f, 2.0f);
        this.c.j -= 1.0f;
        this.d.j += 1.0f;
        this.c.l += 0.0f;
        this.d.l += 0.0f;
        this.e.j -= 1.0f;
        this.f.j += 1.0f;
        this.e.l -= 1.0f;
        this.f.l -= 1.0f;
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        super.a(f, f2, f3, f4, f5, f6);
        this.horn1.a(f6);
        this.horn2.a(f6);
        this.udders.a(f6);
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        super.b(f, f2, f3, f4, f5, f6);
        this.horn1.b = this.a.b;
        this.horn1.a = this.a.a;
        this.horn2.b = this.a.b;
        this.horn2.a = this.a.a;
    }
}

