/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.c.C_a;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public final class C_d
extends C_f {
    private net.minecraft.client.a.C_f d = new net.minecraft.client.a.C_f();

    public C_d() {
        this.b = 0.5f;
    }

    @Override
    public final void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        C_a c_a = (C_a)c_b;
        f4 = f3;
        f3 = f2;
        f2 = f;
        C_a c_a2 = c_a;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f2, (float)f3, (float)f4);
        if ((float)c_a2.a - f5 + 1.0f < 10.0f) {
            float f6;
            f2 = 1.0f - ((float)c_a2.a - f5 + 1.0f) / 10.0f;
            if (f6 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f2 *= f2;
            f2 *= f2;
            f2 = 1.0f + f2 * 0.3f;
            GL11.glScalef((float)f2, (float)f2, (float)f2);
        }
        f2 = (1.0f - ((float)c_a2.a - f5 + 1.0f) / 100.0f) * 0.8f;
        this.a("/terrain.png");
        this.d.renderBlockOnInventory(C_x.ab, 0);
        if (c_a2.a / 5 % 2 == 0) {
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)772);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f2);
            this.d.renderBlockOnInventory(C_x.ab, 0);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
        }
        GL11.glPopMatrix();
    }
}

