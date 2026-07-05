/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_e;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_g;
import net.minecraft.client.b.C_l;
import org.lwjgl.opengl.GL11;

public class C_v
extends C_j {
    private C_g modelBipedMain;

    public C_v(C_l c_l, float f) {
        super(c_l, f);
        this.modelBipedMain = (C_g)this.d;
    }

    @Override
    protected final void renderEquippedItems(C_e c_e, float f) {
        this.renderSpecials(c_e, f);
    }

    protected void renderSpecials(C_e c_e, float f) {
        GL11.glPushMatrix();
        this.modelBipedMain.d.renderWithRotation(1.0f);
        this.modelBipedMain.heldItemRight = true;
        GL11.glTranslatef((float)-0.0625f, (float)0.0f, (float)0.0625f);
        float f2 = 7.5f;
        GL11.glTranslatef((float)0.0f, (float)9.0f, (float)2.0f);
        GL11.glScalef((float)f2, (float)(-f2), (float)f2);
        GL11.glRotatef((float)-110.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.a.itemRenderer.renderItem(new ItemStack(Item.dartShooter));
        GL11.glPopMatrix();
    }
}

