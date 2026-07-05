/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.d.C_a;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public class C_s
extends C_f {
    public void renderFish(net.minecraft.a.c.c.C_d c_d, float f, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)f3);
        GL11.glEnable((int)32826);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        int n = 1;
        int n2 = 2;
        this.a("/particles.png");
        C_d c_d2 = C_d.a;
        float f6 = (float)(n * 8 + 0) / 128.0f;
        float f7 = (float)(n * 8 + 8) / 128.0f;
        float f8 = (float)(n2 * 8 + 0) / 128.0f;
        float f9 = (float)(n2 * 8 + 8) / 128.0f;
        float f10 = 1.0f;
        float f11 = 0.5f;
        float f12 = 0.5f;
        GL11.glRotatef((float)(180.0f - this.a.d), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.a.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
        c_d2.b();
        C_d.c(0.0f, 1.0f, 0.0f);
        c_d2.a(0.0f - f11, 0.0f - f12, 0.0f, f6, f9);
        c_d2.a(f10 - f11, 0.0f - f12, 0.0f, f7, f9);
        c_d2.a(f10 - f11, 1.0f - f12, 0.0f, f7, f8);
        c_d2.a(0.0f - f11, 1.0f - f12, 0.0f, f6, f8);
        c_d2.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
        if (c_d.angler != null) {
            float f13 = c_d.angler.getSwingProgress(f5);
            float f14 = MathHelper.a(MathHelper.c(f13) * (float)Math.PI);
            C_a c_a = new C_a(-0.5f, 0.03f, 0.8f);
            c_a.rotateAroundX(-(c_d.angler.q + (c_d.angler.o - c_d.angler.q) * f5) * (float)Math.PI / 180.0f);
            c_a.rotateAroundY(-(c_d.angler.p + (c_d.angler.n - c_d.angler.p) * f5) * (float)Math.PI / 180.0f);
            c_a.rotateAroundY(f14 * 0.5f);
            c_a.rotateAroundX(-f14 * 0.7f);
            float f15 = c_d.angler.e + (c_d.angler.h - c_d.angler.e) * f5 + c_a.a;
            float f16 = c_d.angler.f + (c_d.angler.i - c_d.angler.f) * f5 + c_a.b;
            float f17 = c_d.angler.g + (c_d.angler.j - c_d.angler.g) * f5 + c_a.c;
            float f18 = c_d.e + (c_d.h - c_d.e) * f5;
            float f19 = c_d.f + (c_d.i - c_d.f) * f5 + 0.25f;
            float f20 = c_d.g + (c_d.j - c_d.g) * f5;
            float f21 = f15 - f18;
            float f22 = f16 - f19;
            float f23 = f17 - f20;
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            c_d2.a(3);
            c_d2.b(0);
            int n3 = 16;
            for (int i = 0; i <= n3; ++i) {
                float f24 = (float)i / (float)n3;
                c_d2.b(f + f21 * f24, f2 + f22 * (f24 * f24 + f24) * 0.5f + 0.25f, f3 + f23 * f24);
            }
            c_d2.a();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
        }
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderFish((net.minecraft.a.c.c.C_d)c_b, f, f2, f3, f4, f5);
    }
}

