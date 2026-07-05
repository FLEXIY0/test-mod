/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.Entity;
import net.minecraft.a.c.d.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_ag
extends C_f {
    @Override
    public final void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        float f6;
        C_g c_g = (C_g)c_b;
        this.a("/item/spears.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)f3);
        GL11.glRotatef((float)(c_g.p + (c_g.n - c_g.p) * f5 - 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(c_g.q + (c_g.o - c_g.q) * f5), (float)0.0f, (float)0.0f, (float)1.0f);
        C_d c_d = C_d.a;
        GL11.glEnable((int)2977);
        f = (float)c_g.arrowShake - f5;
        if (f6 > 0.0f) {
            GL11.glRotatef((float)(-MathHelper.a(f) * f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        float f7 = (float)(0 + (c_g.id - 400) * 5) / 64.0f;
        float f8 = (float)(5 + (c_g.id - 400) * 5) / 64.0f;
        GL11.glRotatef((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)0.05625f, (float)0.05625f, (float)0.05625f);
        GL11.glTranslatef((float)-4.0f, (float)0.0f, (float)0.0f);
        GL11.glNormal3f((float)0.05625f, (float)0.0f, (float)0.0f);
        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glNormal3f((float)0.0f, (float)0.0f, (float)0.05625f);
            c_d.b();
            c_d.a(-16.0f, -2.0f, 0.0f, 0.0f, f7);
            c_d.a(16.0f, -2.0f, 0.0f, 0.5f, f7);
            c_d.a(16.0f, 2.0f, 0.0f, 0.5f, f8);
            c_d.a(-16.0f, 2.0f, 0.0f, 0.0f, f8);
            c_d.a();
        }
        GL11.glDisable((int)2977);
        GL11.glPopMatrix();
    }
}

