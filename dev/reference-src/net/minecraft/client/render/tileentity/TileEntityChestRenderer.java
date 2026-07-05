/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.render.tileentity;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.client.b.C_q;
import net.minecraft.client.b.C_y;
import net.minecraft.client.render.tileentity.TileEntitySpecialRenderer;
import net.minecraft.game.level.block.container.BlockChest;
import org.lwjgl.opengl.GL11;

public class TileEntityChestRenderer
extends TileEntitySpecialRenderer {
    private C_q chestModel = new C_q();
    private C_q largeChestModel = new C_y();

    public void renderTileEntityChestAt(C_c c_c, double d2, double d3, double d4, float f) {
        Object object;
        int n;
        if (c_c.a == null) {
            n = 0;
        } else {
            object = c_c.getBlockType();
            n = c_c.getBlockMetadata();
            if (object != null && object == C_x.aj && n == 0) {
                ((BlockChest)object).unifyAdjacentChests(c_c.a, c_c.b, c_c.c, c_c.d);
                n = c_c.getBlockMetadata();
            }
            c_c.checkForAdjacentChests();
        }
        if (c_c.adjacentChestZNeg == null && c_c.adjacentChestXNeg == null) {
            if (c_c.adjacentChestXPos == null && c_c.adjacentChestZPos == null) {
                object = this.chestModel;
                this.bindTextureByName("/item/chest.png");
            } else {
                object = this.largeChestModel;
                this.bindTextureByName("/item/largechest.png");
            }
            GL11.glPushMatrix();
            GL11.glEnable((int)32826);
            GL11.glTranslatef((float)((float)d2), (float)((float)d3 + 1.0f), (float)((float)d4 + 1.0f));
            GL11.glScalef((float)1.0f, (float)-1.0f, (float)-1.0f);
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            int n2 = 0;
            if (n == 2) {
                n2 = 180;
            }
            if (n == 3) {
                n2 = 0;
            }
            if (n == 4) {
                n2 = 90;
            }
            if (n == 5) {
                n2 = -90;
            }
            if (c_c.getBlockType() == C_x.aj) {
                if (n == 2 && c_c.adjacentChestXPos != null) {
                    GL11.glTranslatef((float)1.0f, (float)0.0f, (float)0.0f);
                }
                if (n == 5 && c_c.adjacentChestZPos != null) {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-1.0f);
                }
            }
            GL11.glRotatef((float)n2, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            float f2 = c_c.lidAngle;
            f2 = 1.0f - f2;
            f2 = 1.0f - f2 * f2 * f2;
            ((C_q)object).chestLid.a = -(f2 * (float)Math.PI / 2.0f);
            ((C_q)object).renderAll();
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    @Override
    public void renderTileEntityAt(C_a c_a, float f, float f2, float f3, float f4) {
        this.renderTileEntityChestAt((C_c)c_a, f, f2, f3, f4);
    }
}

