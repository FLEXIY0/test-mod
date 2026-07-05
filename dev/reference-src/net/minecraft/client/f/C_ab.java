/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.client.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.d;
import net.minecraft.client.f.C_k;
import org.lwjgl.opengl.GL11;

public class C_ab
extends C_k {
    public C_ab(World c_g, float f, float f2, float f3, float f4) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.T = 4;
        this.X = this.Y = this.G.nextFloat() * 0.6f + 0.4f;
        this.W = this.Y;
        this.U = 1.0f - f4 * 0.5f;
    }

    @Override
    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        int n = (int)(((float)this.S + f) * 3.0f / (float)this.T);
        if (n <= 7) {
            RenderEngine.a(net.minecraft.client.d.getMinecraft().m.a("/misc/sweep.png"));
            float f7 = (float)(n % 4) / 4.0f;
            float f8 = f7 + 0.24975f;
            float f9 = (float)(n / 2) / 2.0f;
            float f10 = f9 + 0.4995f;
            float f11 = 1.0f * this.U;
            float f12 = this.e + (this.h - this.e) * f;
            float f13 = this.f + (this.i - this.f) * f;
            float f14 = this.g + (this.j - this.g) * f;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)2896);
            C_c.a();
            c_d.b();
            c_d.a(this.W, this.X, this.Y, 1.0f);
            C_d.c(0.0f, 1.0f, 0.0f);
            c_d.a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11 * 0.5f, f14 - f4 * f11 - f6 * f11, f8, f10);
            c_d.a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11 * 0.5f, f14 - f4 * f11 + f6 * f11, f8, f9);
            c_d.a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11 * 0.5f, f14 + f4 * f11 + f6 * f11, f7, f9);
            c_d.a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11 * 0.5f, f14 + f4 * f11 - f6 * f11, f7, f10);
            c_d.a();
            GL11.glEnable((int)2896);
        }
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        ++this.S;
        if (this.S == this.T) {
            this.k();
        }
    }

    @Override
    public int c() {
        return 3;
    }
}

