/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import net.minecraft.game.level.block.plants.BlockFlower;
import org.lwjgl.opengl.GL11;

public class C_ab
extends C_j {
    protected C_f renderBlocks = new C_f();

    public C_ab(C_l c_l, float f) {
        super(c_l, f);
    }

    public void renderLivingMooshroom(net.minecraft.a.c.b.C_j c_j, float f, float f2, float f3, float f4, float f5) {
        super.a(c_j, f, f2, f3, f4, f5);
    }

    protected void renderMooshroomEquippedItems(net.minecraft.a.c.b.C_j c_j, float f) {
        super.renderEquippedItems(c_j, f);
        BlockFlower blockFlower = C_x.plantYellow;
        this.a("/terrain.png");
        GL11.glEnable((int)2884);
        GL11.glPushMatrix();
        GL11.glScalef((float)12.0f, (float)-12.0f, (float)12.0f);
        GL11.glTranslatef((float)0.2f, (float)0.3f, (float)0.5f);
        GL11.glRotatef((float)42.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.renderBlocks.renderBlockOnInventory(blockFlower, 0);
        GL11.glTranslatef((float)0.1f, (float)0.0f, (float)-0.6f);
        GL11.glRotatef((float)42.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.renderBlocks.renderBlockOnInventory(blockFlower, 0);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef((float)12.0f, (float)-12.0f, (float)12.0f);
        GL11.glTranslatef((float)0.0f, (float)0.5f, (float)-0.9f);
        GL11.glRotatef((float)12.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        this.renderBlocks.renderBlockOnInventory(blockFlower, 0);
        GL11.glPopMatrix();
        GL11.glDisable((int)2884);
    }

    @Override
    protected void renderEquippedItems(C_e c_e, float f) {
        this.renderMooshroomEquippedItems((net.minecraft.a.c.b.C_j)c_e, f);
    }

    public void doRenderLiving(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        this.renderLivingMooshroom((net.minecraft.a.c.b.C_j)c_e, f, f2, f3, f4, f5);
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderLivingMooshroom((net.minecraft.a.c.b.C_j)c_b, f, f2, f3, f4, f5);
    }
}

