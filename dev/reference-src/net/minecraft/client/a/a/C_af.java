/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public class C_af
extends C_f {
    private int itemIconIndex;

    public C_af(int n) {
        this.itemIconIndex = n;
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)f2, (float)f3);
        GL11.glEnable((int)32826);
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.a("/gui/items.png");
        C_d c_d = C_d.a;
        float f6 = (float)(this.itemIconIndex % 32 * 16 + 0) / 512.0f;
        float f7 = (float)(this.itemIconIndex % 32 * 16 + 16) / 512.0f;
        float f8 = (float)(this.itemIconIndex / 32 * 16 + 0) / 512.0f;
        float f9 = (float)(this.itemIconIndex / 32 * 16 + 16) / 512.0f;
        float f10 = 1.0f;
        float f11 = 0.5f;
        float f12 = 0.25f;
        GL11.glRotatef((float)(180.0f - this.a.d), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-this.a.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
        c_d.b();
        C_d.c(0.0f, 1.0f, 0.0f);
        c_d.a(0.0f - f11, 0.0f - f12, 0.0f, f6, f9);
        c_d.a(f10 - f11, 0.0f - f12, 0.0f, f7, f9);
        c_d.a(f10 - f11, 1.0f - f12, 0.0f, f7, f8);
        c_d.a(0.0f - f11, 1.0f - f12, 0.0f, f6, f8);
        c_d.a();
        GL11.glDisable((int)32826);
        GL11.glPopMatrix();
    }
}

