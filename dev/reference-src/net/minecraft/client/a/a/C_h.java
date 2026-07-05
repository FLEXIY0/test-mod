/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import java.util.Random;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.Entity;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public class C_h
extends C_f {
    private Random d = new Random();

    @Override
    public void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        C_a c_a = (C_a)c_b;
        this.d.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)f3);
        GL11.glRotatef((float)f4, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glEnable((int)2977);
        this.a("/art/kz.png");
        net.minecraft.a.c.C_d c_d = c_a.b;
        GL11.glScalef((float)0.0625f, (float)0.0625f, (float)0.0625f);
        int n = c_d.f;
        int n2 = c_d.e;
        int n3 = c_d.d;
        int n4 = c_d.c;
        C_h c_h = this;
        float f6 = (float)(-n4) / 2.0f;
        float f7 = (float)(-n3) / 2.0f;
        for (int i = 0; i < n4 / 16; ++i) {
            for (int j = 0; j < n3 / 16; ++j) {
                float f8 = f6 + (float)(i + 1 << 4);
                float f9 = f6 + (float)(i << 4);
                float f10 = f7 + (float)(j + 1 << 4);
                float f11 = f7 + (float)(j << 4);
                float f12 = (f8 + f9) / 2.0f;
                float f13 = (f10 + f11) / 2.0f;
                float f14 = f12;
                int n5 = (int)c_a.h;
                int n6 = (int)(c_a.i + f13 / 16.0f);
                int n7 = (int)c_a.j;
                if (c_a.a == 0) {
                    n5 = (int)(c_a.h + f14 / 16.0f);
                }
                if (c_a.a == 1) {
                    n7 = (int)(c_a.j - f14 / 16.0f);
                }
                if (c_a.a == 2) {
                    n5 = (int)(c_a.h - f14 / 16.0f);
                }
                if (c_a.a == 3) {
                    n7 = (int)(c_a.j + f14 / 16.0f);
                }
                float f15 = c_h.a.c.c(n5, n6, n7);
                if (c_h.a.c.mc.f.nightVision && (f15 += 0.7f) > 1.0f) {
                    f15 = 1.0f;
                }
                GL11.glColor3f((float)f15, (float)f15, (float)f15);
                f15 = (float)(n2 + n4 - (i << 4)) / 256.0f;
                float f16 = (float)(n2 + n4 - (i + 1 << 4)) / 256.0f;
                f14 = (float)(n + n3 - (j << 4)) / 256.0f;
                f13 = (float)(n + n3 - (j + 1 << 4)) / 256.0f;
                C_d c_d2 = C_d.a;
                C_d.a.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                c_d2.a(f8, f11, -0.5f, f16, f14);
                c_d2.a(f9, f11, -0.5f, f15, f14);
                c_d2.a(f9, f10, -0.5f, f15, f13);
                c_d2.a(f8, f10, -0.5f, f16, f13);
                C_d.c(0.0f, 0.0f, 1.0f);
                c_d2.a(f8, f10, 0.5f, 0.75f, 0.0f);
                c_d2.a(f9, f10, 0.5f, 0.8125f, 0.0f);
                c_d2.a(f9, f11, 0.5f, 0.8125f, 0.0625f);
                c_d2.a(f8, f11, 0.5f, 0.75f, 0.0625f);
                C_d.c(0.0f, -1.0f, 0.0f);
                c_d2.a(f8, f10, -0.5f, 0.75f, 0.001953125f);
                c_d2.a(f9, f10, -0.5f, 0.8125f, 0.001953125f);
                c_d2.a(f9, f10, 0.5f, 0.8125f, 0.001953125f);
                c_d2.a(f8, f10, 0.5f, 0.75f, 0.001953125f);
                C_d.c(0.0f, 1.0f, 0.0f);
                c_d2.a(f8, f11, 0.5f, 0.75f, 0.001953125f);
                c_d2.a(f9, f11, 0.5f, 0.8125f, 0.001953125f);
                c_d2.a(f9, f11, -0.5f, 0.8125f, 0.001953125f);
                c_d2.a(f8, f11, -0.5f, 0.75f, 0.001953125f);
                C_d.c(-1.0f, 0.0f, 0.0f);
                c_d2.a(f8, f10, 0.5f, 0.7519531f, 0.0f);
                c_d2.a(f8, f11, 0.5f, 0.7519531f, 0.0625f);
                c_d2.a(f8, f11, -0.5f, 0.7519531f, 0.0625f);
                c_d2.a(f8, f10, -0.5f, 0.7519531f, 0.0f);
                C_d.c(1.0f, 0.0f, 0.0f);
                c_d2.a(f9, f10, -0.5f, 0.7519531f, 0.0f);
                c_d2.a(f9, f11, -0.5f, 0.7519531f, 0.0625f);
                c_d2.a(f9, f11, 0.5f, 0.7519531f, 0.0625f);
                c_d2.a(f9, f10, 0.5f, 0.7519531f, 0.0f);
                c_d2.a();
            }
        }
        GL11.glDisable((int)2977);
        GL11.glPopMatrix();
    }
}

