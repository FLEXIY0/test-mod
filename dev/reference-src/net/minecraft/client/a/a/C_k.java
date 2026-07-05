/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_a;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;

public final class C_k
extends C_j {
    private C_a modelSheepMain;

    public C_k(C_l c_l, C_l c_l2, float f) {
        super(c_l, 0.7f);
        this.modelSheepMain = (C_a)this.d;
        this.a(c_l2);
    }

    private void renderSheep(net.minecraft.a.c.b.C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.modelSheepMain.grazing = c_b.grazing;
        super.renderEntity(c_b, f, f2, f3, f4, f5);
    }

    @Override
    protected final boolean a(EntityLiving c_e, int n) {
        net.minecraft.a.c.b.C_b c_b = (net.minecraft.a.c.b.C_b)c_e;
        int n2 = n;
        net.minecraft.a.c.b.C_b c_b2 = c_b;
        this.a("/mob/sheep_fur.png");
        float f = c_b.a(1.0f);
        if (this.a.c.mc.f.nightVision && (f += 0.7f) > 1.0f) {
            f = 1.0f;
        }
        GL11.glColor3f((float)(f * net.minecraft.a.c.b.C_b.fleeceColorTable[c_b2.getFleeceColor()][0]), (float)(f * net.minecraft.a.c.b.C_b.fleeceColorTable[c_b2.getFleeceColor()][1]), (float)(f * net.minecraft.a.c.b.C_b.fleeceColorTable[c_b2.getFleeceColor()][2]));
        return n2 == 0 && !c_b2.getSheared();
    }

    @Override
    public final void renderEntity(EntityLiving c_e, float f, float f2, float f3, float f4, float f5) {
        this.renderSheep((net.minecraft.a.c.b.C_b)c_e, f, f2, f3, f4, f5);
    }

    @Override
    public final void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderSheep((net.minecraft.a.c.b.C_b)c_b, f, f2, f3, f4, f5);
    }
}

