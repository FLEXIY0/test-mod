/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.c.C_g;
import net.minecraft.a.d.C_a;
import net.minecraft.client.a.a.C_f;
import net.minecraft.client.b.C_l;
import net.minecraft.client.b.C_z;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public class C_aa
extends C_f {
    protected C_l modelMinecart;

    public C_aa() {
        this.b = 0.5f;
        this.modelMinecart = new C_z();
    }

    public void renderMinecart(C_g c_g, double d2, double d3, double d4, float f, float f2) {
        GL11.glPushMatrix();
        double d5 = (double)c_g.B + (double)(c_g.h - c_g.B) * (double)f2;
        double d6 = (double)c_g.C + (double)(c_g.i - c_g.C) * (double)f2;
        double d7 = (double)c_g.D + (double)(c_g.j - c_g.D) * (double)f2;
        double d8 = 0.3f;
        C_a c_a = c_g.getPos(d5, d6, d7);
        float f3 = c_g.q + (c_g.o - c_g.q) * f2;
        if (c_a != null) {
            C_a c_a2 = c_g.getPosOffset(d5, d6, d7, d8);
            C_a c_a3 = c_g.getPosOffset(d5, d6, d7, -d8);
            if (c_a2 == null) {
                c_a2 = c_a;
            }
            if (c_a3 == null) {
                c_a3 = c_a;
            }
            d2 += (double)c_a.a - d5;
            d3 += (double)(c_a2.b + c_a3.b) / 2.0 - d6;
            d4 += (double)c_a.c - d7;
            C_a c_a4 = c_a3.a(-c_a2.a, -c_a2.b, -c_a2.c);
            if (c_a4.lengthVector() != 0.0) {
                c_a4 = c_a4.a();
                f = (float)(Math.atan2(c_a4.c, c_a4.a) * 180.0 / Math.PI);
                f3 = (float)(Math.atan(c_a4.b) * 73.0);
            }
        }
        GL11.glTranslatef((float)((float)d2), (float)((float)d3), (float)((float)d4));
        GL11.glRotatef((float)(180.0f - f), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-f3), (float)0.0f, (float)0.0f, (float)1.0f);
        float f4 = (float)c_g.timeSinceHit - f2;
        float f5 = (float)c_g.damageTaken - f2;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f4 > 0.0f) {
            GL11.glRotatef((float)(MathHelper.a(f4) * f4 * f5 / 10.0f * (float)c_g.forwardDirection), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        this.a("/terrain.png");
        float f6 = 0.75f;
        GL11.glScalef((float)f6, (float)f6, (float)f6);
        GL11.glTranslatef((float)0.0f, (float)0.3f, (float)0.0f);
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        switch (c_g.minecartType) {
            case 1: {
                new net.minecraft.client.a.C_f().renderBlockOnInventory(C_x.aj, 0);
                break;
            }
            case 2: {
                new net.minecraft.client.a.C_f().renderBlockOnInventory(C_x.aq, 0);
                break;
            }
            case 3: {
                new net.minecraft.client.a.C_f().renderBlockOnInventory(C_x.ab, 0);
            }
        }
        GL11.glScalef((float)(1.0f / f6), (float)(1.0f / f6), (float)(1.0f / f6));
        GL11.glTranslatef((float)0.0f, (float)-0.3f, (float)0.0f);
        GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.a("/item/cart.png");
        GL11.glScalef((float)-1.0f, (float)-1.0f, (float)1.0f);
        this.modelMinecart.a(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderMinecart((C_g)c_b, f, f2, f3, f4, f5);
    }
}

