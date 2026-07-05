/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.c.C_c;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public final class C_r
extends C_f {
    private net.minecraft.client.a.C_f blockRenderer = new net.minecraft.client.a.C_f();

    public C_r() {
        this.b = 0.5f;
    }

    @Override
    public final void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        C_c c_c = (C_c)c_b;
        f4 = f3;
        f3 = f2;
        f2 = f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f2, (float)f3, (float)f4);
        this.a("/terrain.png");
        this.blockRenderer.renderBlockOnInventory(Block.c[c_c.id], 0);
        GL11.glPopMatrix();
    }
}

