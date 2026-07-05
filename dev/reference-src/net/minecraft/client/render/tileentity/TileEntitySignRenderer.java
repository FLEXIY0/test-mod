/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.render.tileentity;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.client.b.C_ae;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.render.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer
extends TileEntitySpecialRenderer {
    private C_ae modelSign = new C_ae();

    public void renderTileEntitySignAt(C_l c_l, float f, float f2, float f3, float f4) {
        float f5;
        int n;
        C_x c_x = c_l.getBlockType();
        GL11.glPushMatrix();
        float f6 = 0.6666667f;
        if (c_x == C_x.signStanding || c_x == C_x.signBirchStanding || c_x == C_x.signPalmStanding || c_x == C_x.signDarkStanding) {
            GL11.glTranslatef((float)(f + 0.5f), (float)(f2 + 0.75f * f6), (float)(f3 + 0.5f));
            float f7 = (float)(c_l.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef((float)(-f7), (float)0.0f, (float)1.0f, (float)0.0f);
            this.modelSign.signStick.e = true;
            this.modelSign.signLeg1.e = false;
            this.modelSign.signLeg2.e = false;
            this.modelSign.signPole.e = false;
        } else if (c_x == C_x.signHanging || c_x == C_x.signBirchHanging || c_x == C_x.signPalmHanging || c_x == C_x.signDarkHanging) {
            GL11.glTranslatef((float)(f + 0.5f), (float)(f2 + 0.75f * f6), (float)(f3 + 0.5f));
            float f8 = (float)(c_l.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef((float)(-f8), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
            this.modelSign.signStick.e = false;
            n = c_l.a.a(c_l.b, c_l.c + 1, c_l.d);
            if (n == C_x.fence.at || n == C_x.glassPane.at || n == C_x.wall.at) {
                this.modelSign.signLeg1.e = false;
                this.modelSign.signLeg2.e = false;
                this.modelSign.signPole.e = true;
            } else {
                this.modelSign.signLeg1.e = true;
                this.modelSign.signLeg2.e = true;
                this.modelSign.signPole.e = false;
            }
        } else {
            int n2 = c_l.getBlockMetadata();
            f5 = 0.0f;
            if (n2 == 2) {
                f5 = 180.0f;
            }
            if (n2 == 4) {
                f5 = 90.0f;
            }
            if (n2 == 5) {
                f5 = -90.0f;
            }
            GL11.glTranslatef((float)(f + 0.5f), (float)(f2 + 0.75f * f6), (float)(f3 + 0.5f));
            GL11.glRotatef((float)(-f5), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)-0.3125f, (float)-0.4375f);
            this.modelSign.signStick.e = false;
            this.modelSign.signLeg1.e = false;
            this.modelSign.signLeg2.e = false;
            this.modelSign.signPole.e = false;
        }
        if (c_x == C_x.signBirchStanding || c_x == C_x.signBirchHanging || c_x == C_x.signBirchWall) {
            this.bindTextureByName("/item/sign_birch.png");
        } else if (c_x == C_x.signPalmStanding || c_x == C_x.signPalmHanging || c_x == C_x.signPalmWall) {
            this.bindTextureByName("/item/sign_palm.png");
        } else if (c_x == C_x.signDarkStanding || c_x == C_x.signDarkHanging || c_x == C_x.signDarkWall) {
            this.bindTextureByName("/item/sign_dark_oak.png");
        } else {
            this.bindTextureByName("/item/sign.png");
        }
        GL11.glPushMatrix();
        GL11.glScalef((float)f6, (float)(-f6), (float)(-f6));
        this.modelSign.renderSign();
        GL11.glPopMatrix();
        FontRenderer fontRenderer = this.getFontRenderer();
        f5 = 0.016666668f * f6;
        GL11.glTranslatef((float)0.0f, (float)(0.5f * f6), (float)(0.07f * f6));
        GL11.glScalef((float)f5, (float)(-f5), (float)f5);
        GL11.glNormal3f((float)0.0f, (float)0.0f, (float)(-1.0f * f5));
        GL11.glDepthMask((boolean)false);
        n = 0;
        for (int i = 0; i < c_l.signText.length; ++i) {
            String string = c_l.signText[i];
            if (i == c_l.lineBeingEdited) {
                string = "> " + string + " <";
                fontRenderer.b(string, -fontRenderer.a(string) / 2, i * 10 - c_l.signText.length * 5, n);
                continue;
            }
            fontRenderer.b(string, -fontRenderer.a(string) / 2, i * 10 - c_l.signText.length * 5, c_l.textColor);
        }
        GL11.glDepthMask((boolean)true);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(C_a c_a, float f, float f2, float f3, float f4) {
        this.renderTileEntitySignAt((C_l)c_a, f, f2, f3, f4);
    }
}

