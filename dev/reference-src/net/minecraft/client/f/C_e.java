/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.f.C_k;
import org.lwjgl.opengl.GL11;

public final class C_e
extends C_k {
    private C_b Z;
    private net.minecraft.a.c.C_e aa;
    private int ab = 0;
    private int ac = 0;
    private float ad;

    public C_e(C_g c_g, C_b c_b, net.minecraft.a.c.C_e c_e, float f) {
        super(c_g, c_b.h, c_b.i, c_b.j, c_b.k, c_b.l, c_b.m);
        this.Z = c_b;
        this.aa = c_e;
        this.ac = 3;
        this.ad = -0.5f;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float)this.ab + f) / (float)this.ac;
        f7 *= f7;
        f2 = this.Z.h;
        f3 = this.Z.i;
        f4 = this.Z.j;
        f5 = this.aa.B + (this.aa.h - this.aa.B) * f;
        f6 = this.aa.C + (this.aa.i - this.aa.C) * f + this.ad;
        float f8 = this.aa.D + (this.aa.j - this.aa.D) * f;
        f2 += (f5 - f2) * f7;
        f3 += (f6 - f3) * f7;
        f7 = f4 + (f8 - f4) * f7;
        f4 = this.d.c((int)f2, (int)f3, (int)f7);
        GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
        C_i.a.a(this.Z, f2, f3, f7, this.Z.n, f);
    }

    @Override
    public final void b_() {
        ++this.ab;
        if (this.ab == this.ac) {
            this.k();
        }
    }

    @Override
    public final int c() {
        return 3;
    }
}

