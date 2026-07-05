/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import java.util.Random;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_f;
import net.minecraft.client.c.FontRenderer;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_e
extends C_f {
    public net.minecraft.client.a.C_f d = new net.minecraft.client.a.C_f();
    private Random e = new Random();

    public C_e() {
        this.b = 0.15f;
        this.c = 0.75f;
    }

    public final void renderItemIntoGUI(RenderEngine renderEngine, int n, int n2, int n3, int n4, int n5) {
        if (n >= 0) {
            if (n < 256 && net.minecraft.client.a.C_f.renderItemIn3d(Block.c[n].a())) {
                int n6 = n;
                RenderEngine.a(renderEngine.a("/terrain.png"));
                Block c_x = Block.c[n6];
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(n4 - 2), (float)(n5 + 3), (float)100.0f);
                GL11.glScalef((float)1.0f, (float)1.0f, (float)-1.0f);
                GL11.glScalef((float)10.0f, (float)10.0f, (float)10.0f);
                GL11.glTranslatef((float)1.0f, (float)0.5f, (float)8.0f);
                GL11.glRotatef((float)210.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                this.d.renderBlockOnInventory(c_x, n2);
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
            } else if (n3 >= 0) {
                int n7;
                GL11.glDisable((int)2896);
                float f = 0.001953125f;
                if (n < 256) {
                    RenderEngine.a(renderEngine.a("/terrain.png"));
                } else {
                    RenderEngine.a(renderEngine.a("/gui/items.png"));
                }
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                int n8 = n4;
                int n9 = n5;
                int n10 = n3 % 32 << 4;
                n5 = n7 = n3 / 32 << 4;
                n4 = n10;
                int n11 = n9;
                int n12 = n8;
                C_d c_d = C_d.a;
                C_d.a.b();
                c_d.a(n12, n11 + 16, 0.0f, (float)n4 * f, (float)(n5 + 16) * f);
                c_d.a(n12 + 16, n11 + 16, 0.0f, (float)(n4 + 16) * f, (float)(n5 + 16) * f);
                c_d.a(n12 + 16, n11, 0.0f, (float)(n4 + 16) * f, (float)n5 * f);
                c_d.a(n12, n11, 0.0f, (float)n4 * f, (float)n5 * f);
                c_d.a();
                GL11.glEnable((int)2896);
                GL11.glDisable((int)3042);
            }
        }
    }

    public final void renderItemOverlayIntoGUI(FontRenderer fontRenderer, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n >= 0) {
            if (n4 > 1) {
                String string = "" + n4;
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                fontRenderer.a(string, n6 + 19 - 2 - fontRenderer.a(string), n7 + 6 + 3, 0xFFFFFF);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
            }
            if (n2 > 0 && n5 > 0) {
                int n8 = 13 - n2 * 13 / n5;
                int n9 = 255 - n2 * 255 / n5;
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                GL11.glDisable((int)3553);
                C_d c_d = C_d.a;
                int n10 = 255 - n9 << 16 | n9 << 8;
                n9 = (255 - n9) / 4 << 16 | 0x3F00;
                C_e.a(c_d, n6 + 2, n7 + 13, 13, 2, 0);
                C_e.a(c_d, n6 + 2, n7 + 13, 12, 1, n9);
                C_e.a(c_d, n6 + 2, n7 + 13, n8, 1, n10);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            }
        }
    }

    public final void a(RenderEngine renderEngine, ItemStack itemStack, int n, int n2) {
        if (itemStack != null) {
            this.renderItemIntoGUI(renderEngine, itemStack.c, itemStack.d, itemStack.getIconIndex(), n, n2);
        }
    }

    public final void a(FontRenderer fontRenderer, ItemStack itemStack, int n, int n2) {
        if (itemStack != null) {
            this.renderItemOverlayIntoGUI(fontRenderer, itemStack.c, itemStack.d, itemStack.getIconIndex(), itemStack.a, itemStack.getMaxDamage(), n, n2);
        }
    }

    private static void a(C_d c_d, int n, int n2, int n3, int n4, int n5) {
        c_d.b();
        c_d.b(n5);
        c_d.b(n, n2, 0.0f);
        c_d.b(n, n2 + n4, 0.0f);
        c_d.b(n + n3, n2 + n4, 0.0f);
        c_d.b(n + n3, n2, 0.0f);
        c_d.a();
    }

    @Override
    public final void a(net.minecraft.a.c.C_b c_b, float f, float f2, float f3, float f4, float f5) {
        C_b c_b2 = (C_b)c_b;
        C_e c_e = this;
        this.e.setSeed(187L);
        ItemStack itemStack = c_b2.a;
        GL11.glPushMatrix();
        float f6 = MathHelper.a(((float)c_b2.b + f5) / 10.0f + c_b2.P) * 0.1f + 0.1f;
        f5 = (((float)c_b2.b + f5) / 20.0f + c_b2.P) * 57.295776f;
        int n = 1;
        if (c_b2.a.a > 1) {
            n = 2;
        }
        if (c_b2.a.a > 5) {
            n = 3;
        }
        if (c_b2.a.a > 20) {
            n = 4;
        }
        if (!GameSettings.fancyItems) {
            f6 = 0.0f;
        }
        GL11.glTranslatef((float)f, (float)(f2 + f6), (float)f3);
        GL11.glEnable((int)2977);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        if (itemStack.c < 256 && net.minecraft.client.a.C_f.renderItemIn3d(Block.c[itemStack.c].a())) {
            if (GameSettings.fancyItems) {
                GL11.glRotatef((float)f5, (float)0.0f, (float)1.0f, (float)0.0f);
            }
            this.a("/terrain.png");
            f = 0.25f;
            if (!Block.c[itemStack.c].c() && itemStack.c != Block.Z.at) {
                f = 0.5f;
            }
            GL11.glScalef((float)f, (float)f, (float)f);
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                if (i > 0) {
                    f3 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.2f / f;
                    f4 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.2f / f;
                    f5 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.2f / f;
                    GL11.glTranslatef((float)f3, (float)f4, (float)f5);
                }
                if (!Block.c[itemStack.c].c() && itemStack.c != Block.Z.at) {
                    GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
                }
                c_e.d.renderBlockOnInventory(Block.c[itemStack.c], itemStack.d);
                GL11.glPopMatrix();
            }
        } else if (GameSettings.fancyItems) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)f5, (float)0.0f, (float)1.0f, (float)0.0f);
            float f7 = 512.0f;
            float f8 = 9.765625E-4f;
            if (itemStack.c < 256) {
                this.a("/terrain.png");
            } else {
                this.a("/gui/items.png");
            }
            C_d c_d = C_d.a;
            float f9 = (float)(itemStack.getIconIndex() % 32 * 16 + 0) / f7;
            float f10 = (float)(itemStack.getIconIndex() % 32 * 16 + 16) / f7;
            float f11 = (float)(itemStack.getIconIndex() / 32 * 16 + 0) / f7;
            float f12 = (float)(itemStack.getIconIndex() / 32 * 16 + 16) / f7;
            float f13 = 1.0f;
            float f14 = 0.0f;
            float f15 = 0.0f;
            GL11.glEnable((int)32826);
            GL11.glTranslatef((float)(-f14), (float)f15, (float)0.0f);
            float f16 = 0.5f;
            GL11.glScalef((float)f16, (float)f16, (float)f16);
            float f17 = 0.0625f;
            float f18 = 0.021875f;
            f6 = 0.25f;
            GL11.glTranslatef((float)-0.5f, (float)(-f6), (float)(-((f17 + f18) * (float)n / 2.0f)));
            float f19 = 0.0625f;
            for (int i = 0; i < n; ++i) {
                float f20;
                float f21;
                float f22;
                int n2;
                GL11.glPushMatrix();
                if (i > 0) {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)((float)i * (f17 + f18)));
                } else {
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(f17 + f18));
                }
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                c_d.a(0.0f, 0.0f, 0.0f, f10, f12);
                c_d.a(f13, 0.0f, 0.0f, f9, f12);
                c_d.a(f13, 1.0f, 0.0f, f9, f11);
                c_d.a(0.0f, 1.0f, 0.0f, f10, f11);
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                c_d.a(0.0f, 1.0f, 0.0f - f19, f10, f11);
                c_d.a(f13, 1.0f, 0.0f - f19, f9, f11);
                c_d.a(f13, 0.0f, 0.0f - f19, f9, f12);
                c_d.a(0.0f, 0.0f, 0.0f - f19, f10, f12);
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                for (n2 = 0; n2 < 16; ++n2) {
                    f22 = (float)n2 / 16.0f;
                    f21 = f10 + (f9 - f10) * f22 - f8;
                    f20 = f13 * f22;
                    c_d.a(f20, 0.0f, 0.0f - f19, f21, f12);
                    c_d.a(f20, 0.0f, 0.0f, f21, f12);
                    c_d.a(f20, 1.0f, 0.0f, f21, f11);
                    c_d.a(f20, 1.0f, 0.0f - f19, f21, f11);
                }
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                for (n2 = 0; n2 < 16; ++n2) {
                    f22 = (float)n2 / 16.0f;
                    f21 = f10 + (f9 - f10) * f22 - f8;
                    f20 = f13 * f22 + 0.0625f;
                    c_d.a(f20, 1.0f, 0.0f - f19, f21, f11);
                    c_d.a(f20, 1.0f, 0.0f, f21, f11);
                    c_d.a(f20, 0.0f, 0.0f, f21, f12);
                    c_d.a(f20, 0.0f, 0.0f - f19, f21, f12);
                }
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                for (n2 = 0; n2 < 16; ++n2) {
                    f22 = (float)n2 / 16.0f;
                    f21 = f12 + (f11 - f12) * f22 - f8;
                    f20 = f13 * f22 + 0.0625f;
                    c_d.a(0.0f, f20, 0.0f, f10, f21);
                    c_d.a(f13, f20, 0.0f, f9, f21);
                    c_d.a(f13, f20, 0.0f - f19, f9, f21);
                    c_d.a(0.0f, f20, 0.0f - f19, f10, f21);
                }
                c_d.a();
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                for (n2 = 0; n2 < 16; ++n2) {
                    f22 = (float)n2 / 16.0f;
                    f21 = f12 + (f11 - f12) * f22 - f8;
                    f20 = f13 * f22;
                    c_d.a(f13, f20, 0.0f, f9, f21);
                    c_d.a(0.0f, f20, 0.0f, f10, f21);
                    c_d.a(0.0f, f20, 0.0f - f19, f10, f21);
                    c_d.a(f13, f20, 0.0f - f19, f9, f21);
                }
                c_d.a();
                GL11.glPopMatrix();
            }
            GL11.glDisable((int)32826);
            GL11.glPopMatrix();
        } else {
            GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
            int n3 = itemStack.getIconIndex();
            if (itemStack.c < 256) {
                this.a("/terrain.png");
            } else {
                this.a("/gui/items.png");
            }
            C_d c_d = C_d.a;
            float f23 = 512.0f;
            f3 = (float)(n3 % 32 << 4) / f23;
            f4 = (float)((n3 % 32 << 4) + 16) / f23;
            f5 = (float)(n3 / 32 << 4) / f23;
            f = (float)((n3 / 32 << 4) + 16) / f23;
            for (int i = 0; i < n; ++i) {
                GL11.glPushMatrix();
                GL11.glDisable((int)2896);
                if (i > 0) {
                    f6 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f24 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f25 = (c_e.e.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    GL11.glTranslatef((float)f6, (float)f24, (float)f25);
                }
                GL11.glRotatef((float)(180.0f - c_e.a.d), (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glRotatef((float)(-c_e.a.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                c_d.a(-0.5f, -0.25f, 0.0f, f3, f);
                c_d.a(0.5f, -0.25f, 0.0f, f4, f);
                c_d.a(0.5f, 0.75f, 0.0f, f4, f5);
                c_d.a(-0.5f, 0.75f, 0.0f, f3, f5);
                c_d.a();
                GL11.glEnable((int)2896);
                GL11.glPopMatrix();
            }
        }
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2977);
        GL11.glPopMatrix();
    }
}

