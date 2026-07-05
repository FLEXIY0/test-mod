/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_h;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_v;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public class C_u
extends C_j {
    public C_u() {
        super(new C_v(), 0.25f);
        this.b = 0.75f;
    }

    public void renderHarpy(C_h c_h, float f, float f2, float f3, float f4, float f5) {
        super.a(c_h, f, f2, f3, f4, f5);
    }

    protected void setSize(C_h c_h, float f) {
        GL11.glScalef((float)1.25f, (float)1.25f, (float)1.25f);
    }

    protected void rotateCorpse(C_h c_h, float f, float f2, float f3) {
        GL11.glTranslatef((float)0.0f, (float)(MathHelper.b(f * 0.3f) * 0.1f), (float)0.0f);
        super.rotateCorpse(c_h, f, f2, f3);
    }

    @Override
    protected void a(EntityLiving c_e, float f) {
        this.setSize((C_h)c_e, f);
    }

    @Override
    protected void rotateCorpse(EntityLiving c_e, float f, float f2, float f3) {
        this.rotateCorpse((C_h)c_e, f, f2, f3);
    }

    @Override
    public void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderHarpy((C_h)c_b, f, f2, f3, f4, f5);
    }
}

