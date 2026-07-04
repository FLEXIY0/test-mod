/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_g;
import net.minecraft.client.a.a.C_j;
import org.lwjgl.opengl.GL11;

public final class C_n
extends C_j {
    private net.minecraft.client.b.C_n modelAntlion;

    public C_n() {
        super(new net.minecraft.client.b.C_n(), 1.0f);
        this.modelAntlion = (net.minecraft.client.b.C_n)this.d;
        this.a(new net.minecraft.client.b.C_n());
        this.b = 0.75f;
    }

    private void renderAntlion(C_g c_g, float f, float f2, float f3, float f4, float f5) {
        this.modelAntlion.isBuried = c_g.isLaying;
        super.renderEntity(c_g, f, f2, f3, f4, f5);
    }

    @Override
    protected final float a(C_e c_e) {
        return 180.0f;
    }

    protected void scaleModel(C_g c_g, float f) {
        float f2 = 0.7f;
        GL11.glScalef((float)f2, (float)f2, (float)f2);
    }

    @Override
    protected void a(C_e c_e, float f) {
        this.scaleModel((C_g)c_e, f);
    }

    @Override
    public final void renderEntity(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        this.renderAntlion((C_g)c_e, f, f2, f3, f4, f5);
    }

    @Override
    public final void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderAntlion((C_g)c_b, f, f2, f3, f4, f5);
    }
}

