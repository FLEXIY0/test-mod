/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_e;
import net.minecraft.client.a.a.C_j;
import org.lwjgl.opengl.GL11;

public final class C_l
extends C_j {
    private float e = 6.0f;

    public C_l(net.minecraft.client.b.C_l c_l, float f, float f2) {
        super(c_l, 3.0f);
    }

    @Override
    protected final void a(C_e c_e, float f) {
        GL11.glScalef((float)this.e, (float)this.e, (float)this.e);
    }
}

