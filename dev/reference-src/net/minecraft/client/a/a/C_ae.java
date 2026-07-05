/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_m;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;

public class C_ae
extends C_j {
    private C_l scaleAmount;

    public C_ae(C_l c_l, C_l c_l2, float f) {
        super(c_l, f);
        this.scaleAmount = c_l2;
    }

    protected boolean renderSlimePassModel(C_m c_m, int n) {
        if (n == 0) {
            this.a(this.scaleAmount);
            GL11.glEnable((int)2977);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            return true;
        }
        if (n == 1) {
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        return false;
    }

    protected void scaleSlime(C_m c_m, float f) {
        int n = c_m.getSlimeSize();
        float f2 = (c_m.offsetX + (c_m.offsetY - c_m.offsetX) * f) / ((float)n * 0.5f + 1.0f);
        float f3 = 1.0f / (f2 + 1.0f);
        float f4 = n;
        GL11.glScalef((float)(f3 * f4), (float)(1.0f / f3 * f4), (float)(f3 * f4));
        this.b = 0.35f * (float)c_m.getSlimeSize();
    }

    @Override
    protected void a(EntityLiving c_e, float f) {
        this.scaleSlime((C_m)c_e, f);
    }

    @Override
    protected boolean a(EntityLiving c_e, int n) {
        return this.renderSlimePassModel((C_m)c_e, n);
    }
}

