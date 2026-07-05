/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.b.C_d;
import net.minecraft.client.a.a.C_j;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public class C_o
extends C_j {
    private int renderedBatSize;

    public C_o() {
        super(new net.minecraft.client.b.C_o(), 0.25f);
        this.renderedBatSize = ((net.minecraft.client.b.C_o)this.d).getBatSize();
    }

    public void renderBat(C_d c_d, float f, float f2, float f3, float f4, float f5) {
        int n = ((net.minecraft.client.b.C_o)this.d).getBatSize();
        ((net.minecraft.client.b.C_o)this.d).isHanging = c_d.isLaying;
        if (n != this.renderedBatSize) {
            this.renderedBatSize = n;
            this.d = new net.minecraft.client.b.C_o();
        }
        super.a(c_d, f, f2, f3, f4, f5);
    }

    protected void setBatSize(C_d c_d, float f) {
        GL11.glScalef((float)0.35f, (float)0.35f, (float)0.35f);
    }

    protected void rotateCorpse(C_d c_d, float f, float f2, float f3) {
        if (!c_d.getIsBatHanging()) {
            GL11.glTranslatef((float)0.0f, (float)(MathHelper.b(f * 0.3f) * 0.1f), (float)0.0f);
        } else {
            GL11.glTranslatef((float)0.0f, (float)-0.1f, (float)0.0f);
        }
        super.rotateCorpse(c_d, f, f2, f3);
    }

    @Override
    protected void a(C_e c_e, float f) {
        this.setBatSize((C_d)c_e, f);
    }

    @Override
    protected void rotateCorpse(C_e c_e, float f, float f2, float f3) {
        this.rotateCorpse((C_d)c_e, f, f2, f3);
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderBat((C_d)c_b, f, f2, f3, f4, f5);
    }
}

