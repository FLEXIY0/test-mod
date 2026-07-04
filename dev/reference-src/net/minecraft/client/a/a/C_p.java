/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.d.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_p
extends C_f {
    @Override
    public final void a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4, float f5) {
        float f6;
        C_b c_b2 = (C_b)c_b;
        this.a("/item/darts.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)f3);
        GL11.glRotatef((float)(c_b2.p + (c_b2.n - c_b2.p) * f5 - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(c_b2.q + (c_b2.o - c_b2.q) * f5), (float)0.0f, (float)0.0f, (float)1.0f);
        C_d c_d = C_d.a;
        GL11.glEnable((int)2977);
        f = (float)c_b2.arrowShake - f5;
        if (f6 > 0.0f) {
            GL11.glRotatef((float)(-MathHelper.a(f * 3.0f) * f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        float f7 = (float)(0 + c_b2.arrowType * 10) / 32.0f;
        float f8 = (float)(5 + c_b2.arrowType * 10) / 32.0f;
        float f9 = 0.15625f;
        float f10 = (float)(5 + c_b2.arrowType * 10) / 32.0f;
        float f11 = (float)(10 + c_b2.arrowType * 10) / 32.0f;
        GL11.glRotatef((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)0.05625f, (float)0.05625f, (float)0.05625f);
        GL11.glTranslatef((float)-4.0f, (float)0.0f, (float)0.0f);
        GL11.glNormal3f((float)0.05625f, (float)0.0f, (float)0.0f);
        c_d.b();
        c_d.a(-7.0f, -2.0f, -2.0f, 0.0f, f10);
        c_d.a(-7.0f, -2.0f, 2.0f, f9, f10);
        c_d.a(-7.0f, 2.0f, 2.0f, f9, f11);
        c_d.a(-7.0f, 2.0f, -2.0f, 0.0f, f11);
        c_d.a();
        GL11.glNormal3f((float)-0.05625f, (float)0.0f, (float)0.0f);
        c_d.b();
        c_d.a(-7.0f, 2.0f, -2.0f, 0.0f, f10);
        c_d.a(-7.0f, 2.0f, 2.0f, f9, f10);
        c_d.a(-7.0f, -2.0f, 2.0f, f9, f11);
        c_d.a(-7.0f, -2.0f, -2.0f, 0.0f, f11);
        c_d.a();
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glNormal3f((float)0.0f, (float)0.0f, (float)0.05625f);
            c_d.b();
            c_d.a(-8.0f, -2.0f, 0.0f, 0.0f, f7);
            c_d.a(8.0f, -2.0f, 0.0f, 0.5f, f7);
            c_d.a(8.0f, 2.0f, 0.0f, 0.5f, f8);
            c_d.a(-8.0f, 2.0f, 0.0f, 0.0f, f8);
            c_d.a();
        }
        GL11.glDisable((int)2977);
        GL11.glPopMatrix();
    }
}

