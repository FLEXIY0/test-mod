/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_e;
import net.minecraft.a.c.b.C_i;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;

public class C_x
extends C_j {
    public C_x(C_l c_l, float f) {
        super(c_l, f);
    }

    protected void moveTentacles(C_i c_i, float f, float f2, float f3) {
        float f4 = c_i.tentacle1PrevMotion + (c_i.tentacle1Motion - c_i.tentacle1PrevMotion) * f3;
        float f5 = c_i.tentacle2PrevMotion + (c_i.tentacle2Motion - c_i.tentacle2PrevMotion) * f3;
        GL11.glTranslatef((float)0.0f, (float)0.5f, (float)0.0f);
        GL11.glRotatef((float)(180.0f - f2), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)f4, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)f5, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glTranslatef((float)0.0f, (float)-1.2f, (float)0.0f);
    }

    protected float rotateTentacles(C_i c_i, float f) {
        float f2 = c_i.tentacle4PrevMotion + (c_i.tentacle4Motion - c_i.tentacle4PrevMotion) * f;
        return f2;
    }

    @Override
    protected float getDefaultAngle(C_e c_e, float f) {
        return this.rotateTentacles((C_i)c_e, f);
    }

    @Override
    protected void rotateCorpse(C_e c_e, float f, float f2, float f3) {
        this.moveTentacles((C_i)c_e, f, f2, f3);
    }
}

