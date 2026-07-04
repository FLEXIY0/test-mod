/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_h;
import org.lwjgl.opengl.GL11;

public class C_aa
extends C_h {
    public C_aa(float f) {
        super(f);
    }

    @Override
    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        GL11.glEnable((int)2884);
        GL11.glCullFace((int)1029);
        super.a(f, f2, f3, f4, f5, f6);
        GL11.glDisable((int)2884);
    }
}

