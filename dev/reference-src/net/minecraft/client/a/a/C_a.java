/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.Entity;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public final class C_a
extends C_f {
    @Override
    public final void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(f - c_b.B), (float)(f2 - c_b.C), (float)(f3 - c_b.D));
        C_a.a(c_b.r);
        GL11.glPopMatrix();
    }
}

