/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.c.C_e;
import net.minecraft.client.a.a.C_f;
import net.minecraft.game.level.block.furniture.BlockChair;
import net.minecraft.game.level.block.furniture.BlockFence;
import net.minecraft.game.level.block.furniture.BlockFenceGate;
import net.minecraft.game.level.block.furniture.BlockTable;
import org.lwjgl.opengl.GL11;

public class C_w
extends C_f {
    private final net.minecraft.client.a.C_f renderBlocksInstance = new net.minecraft.client.a.C_f();
    private final int[] offsetX = new int[]{0, -1, 0, 1, 0, 0};
    private final int[] offsetZ = new int[]{-1, 0, 1, 0, 0, 0};

    public void mainRender(C_e c_e, double d2, double d3, double d4, float f, float f2) {
        GL11.glPushMatrix();
        float f3 = (float)((double)c_e.h - d2) - 0.5f;
        float f4 = (float)((double)c_e.i - d3) - 0.5f;
        float f5 = (float)((double)c_e.j - d4) - 0.5f;
        int n = c_e.P + this.offsetX[c_e.a];
        int n2 = c_e.Q;
        int n3 = c_e.R + this.offsetZ[c_e.a];
        GL11.glTranslatef((float)((float)n - f3), (float)((float)n2 - f4), (float)((float)n3 - f5));
        this.renderFrameBase(c_e);
        this.renderFrameItem(c_e);
        GL11.glPopMatrix();
    }

    private void renderFrameBase(C_e c_e) {
        GL11.glPushMatrix();
        GL11.glBindTexture((int)3553, (int)this.a.b.a("/terrain.png"));
        GL11.glRotatef((float)(c_e.n + 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        if (c_e.a == 4) {
            GL11.glRotatef((float)(c_e.n + 90.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)1.0f, (float)0.0f, (float)0.0f);
        } else if (c_e.a == 5) {
            GL11.glRotatef((float)(c_e.n + 180.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)1.0f, (float)0.0f, (float)0.0f);
        }
        C_x c_x = C_x.m;
        float f = 0.0625f;
        float f2 = 0.75f;
        float f3 = f2 / 2.0f;
        GL11.glPushMatrix();
        c_x.a(0.0f, 0.5f - f3 + 0.0625f, 0.5f - f3 + 0.0625f, f * 0.5f, 0.5f + f3 - 0.0625f, 0.5f + f3 - 0.0625f);
        this.renderBlocksInstance.setOverrideBlockTexture(261);
        this.renderBlocksInstance.renderBlockOnInventory(c_x, 0);
        this.renderBlocksInstance.clearOverrideBlockTexture();
        GL11.glPopMatrix();
        this.renderBlocksInstance.setOverrideBlockTexture(4);
        GL11.glPushMatrix();
        c_x.a(0.0f, 0.5f - f3, 0.5f - f3, f + 1.0E-4f, f + 0.5f - f3, 0.5f + f3);
        this.renderBlocksInstance.renderBlockOnInventory(c_x, 0);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        c_x.a(0.0f, 0.5f + f3 - f, 0.5f - f3, f + 1.0E-4f, 0.5f + f3, 0.5f + f3);
        this.renderBlocksInstance.renderBlockOnInventory(c_x, 0);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        c_x.a(0.0f, 0.5f - f3, 0.5f - f3, f, 0.5f + f3, f + 0.5f - f3);
        this.renderBlocksInstance.renderBlockOnInventory(c_x, 0);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        c_x.a(0.0f, 0.5f - f3, 0.5f + f3 - f, f, 0.5f + f3, 0.5f + f3);
        this.renderBlocksInstance.renderBlockOnInventory(c_x, 0);
        GL11.glPopMatrix();
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    private void renderFrameItem(C_e c_e) {
        ItemStack itemStack = c_e.getDisplayedItem();
        if (itemStack != null && itemStack.a() != null) {
            C_b c_b = new C_b(c_e.d, 0.0f, 0.0f, 0.0f, itemStack);
            c_b.a.a = 1;
            c_b.P = 0.0f;
            GL11.glPushMatrix();
            if (c_e.a == 4) {
                GL11.glRotatef((float)(c_e.n + 90.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            } else if (c_e.a == 5) {
                GL11.glRotatef((float)(c_e.n + 180.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            }
            if (itemStack.a().ap >= 256 || !net.minecraft.client.a.C_f.renderItemIn3d(C_x.c[itemStack.getItemID()].a())) {
                if (c_e.n == 180.0f || c_e.n == 0.0f) {
                    GL11.glTranslatef((float)(0.223125f * (float)this.offsetZ[c_e.a]), (float)-0.18f, (float)(-0.453125f * (float)this.offsetZ[c_e.a]));
                } else {
                    GL11.glTranslatef((float)(-0.453125f * (float)this.offsetX[c_e.a]), (float)-0.18f, (float)(-0.223125f * (float)this.offsetX[c_e.a]));
                }
                if (c_e.a == 4) {
                    GL11.glTranslatef((float)-0.225f, (float)-0.025f, (float)-0.525f);
                } else if (c_e.a == 5) {
                    GL11.glTranslatef((float)-0.225f, (float)-0.025f, (float)-0.525f);
                    GL11.glRotatef((float)(c_e.n + 180.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                GL11.glRotatef((float)c_e.n, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glTranslatef((float)0.22f, (float)0.22f, (float)0.0f);
                GL11.glRotatef((float)(45 * c_e.getRotation()), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslatef((float)-0.22f, (float)-0.22f, (float)0.0f);
            } else {
                C_x c_x = C_x.c[itemStack.getItemID()];
                boolean bl = c_x instanceof BlockFence || c_x instanceof BlockTable || c_x instanceof BlockFenceGate || c_x instanceof BlockChair || c_x instanceof C_bq;
                GL11.glTranslatef((float)(-0.453125f * (float)this.offsetX[c_e.a]), (float)0.0f, (float)(-0.453125f * (float)this.offsetZ[c_e.a]));
                if (c_e.a == 4) {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.525f);
                } else if (c_e.a == 5) {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.525f);
                    GL11.glRotatef((float)(c_e.n + 180.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (c_e.n == 0.0f) {
                    if (bl) {
                        GL11.glRotatef((float)(90.0f + c_e.n), (float)0.0f, (float)1.0f, (float)0.0f);
                    } else {
                        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                } else if (c_e.n == 180.0f) {
                    if (bl) {
                        GL11.glRotatef((float)(90.0f + c_e.n), (float)0.0f, (float)1.0f, (float)0.0f);
                    } else {
                        GL11.glRotatef((float)0.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                } else if (c_e.n == 90.0f) {
                    if (bl) {
                        GL11.glRotatef((float)(90.0f + c_e.n), (float)0.0f, (float)1.0f, (float)0.0f);
                    } else {
                        GL11.glRotatef((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    }
                } else if (bl) {
                    GL11.glRotatef((float)(90.0f + c_e.n), (float)0.0f, (float)1.0f, (float)0.0f);
                } else {
                    GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (bl || c_e.a == 4) {
                    GL11.glRotatef((float)(45 * c_e.getRotation()), (float)1.0f, (float)0.0f, (float)0.0f);
                } else {
                    GL11.glRotatef((float)(45 * c_e.getRotation()), (float)0.0f, (float)0.0f, (float)1.0f);
                }
            }
            GL11.glScalef((float)0.3f, (float)0.3f, (float)0.3f);
            this.a.itemRenderer.renderItemIntoFrame(itemStack);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.mainRender((C_e)c_b, f, f2, f3, f4, f5);
    }
}

