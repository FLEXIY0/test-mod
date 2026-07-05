/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_ab;

public class C_ah
extends C_j {
    private int tint;

    public C_ah() {
        super(new C_ab(), 0.3f);
    }

    @Override
    protected float a(C_e c_e) {
        return 180.0f;
    }

    @Override
    protected boolean a(C_e c_e, int n) {
        return false;
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        int n = ((C_ab)this.d).cunkf();
        if (n != this.tint) {
            this.tint = n;
            this.d = new C_ab();
        }
        super.a(c_b, f, f2, f3, f4, f5);
    }
}

