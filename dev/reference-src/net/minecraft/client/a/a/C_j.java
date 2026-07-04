/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.client.a.a.C_f;
import net.minecraft.client.b.C_l;
import net.minecraft.client.g.C_a;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public class C_j
extends C_f {
    protected C_l d;
    private C_l e;
    private C_l secondaryModel;

    public C_j(C_l c_l, float f) {
        this.d = c_l;
        this.b = f;
    }

    public final void a(C_l c_l) {
        this.e = c_l;
    }

    public final void setSecondModelLayer(C_l c_l) {
        this.secondaryModel = c_l;
    }

    public void renderEntity(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        this.d.swingProgress = this.getSwingProgess(c_e, f5);
        if (this.e != null) {
            this.e.swingProgress = this.d.swingProgress;
        }
        if (this.secondaryModel != null) {
            this.secondaryModel.swingProgress = this.d.swingProgress;
        }
        try {
            f4 = c_e.U + (c_e.T - c_e.U) * f5;
            float f6 = c_e.p + (c_e.n - c_e.p) * f5;
            float f7 = c_e.q + (c_e.o - c_e.q) * f5;
            GL11.glTranslatef((float)f, (float)f2, (float)f3);
            float f8 = this.getDefaultAngle(c_e, f5);
            this.rotateCorpse(c_e, f8, f4, f5);
            GL11.glScalef((float)-0.0625f, (float)-0.0625f, (float)0.0625f);
            this.a(c_e, f5);
            GL11.glTranslatef((float)0.0f, (float)-24.0f, (float)0.0f);
            GL11.glEnable((int)2977);
            float f9 = c_e.af + (c_e.ag - c_e.af) * f5;
            float f10 = c_e.ah - c_e.ag * (1.0f - f5);
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            if (c_e instanceof C_a) {
                if (c_e.N != null && c_e.skinId.isEmpty()) {
                    this.a(c_e.N, c_e.q());
                } else {
                    this.loadLocalImageTexture(c_e.skinId);
                }
            } else {
                this.a(c_e.N, c_e.q());
            }
            GL11.glEnable((int)3008);
            this.d.a(f10, f9, f8, f6 - f4, f7, 1.0f);
            for (int i = 0; i < 4; ++i) {
                if (this.a(c_e, i)) {
                    this.e.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    GL11.glDisable((int)3042);
                    GL11.glEnable((int)3008);
                }
                if (!this.renderAccessories(c_e, i)) continue;
                this.secondaryModel.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)3008);
            }
            this.renderEquippedItems(c_e, f5);
            float f11 = c_e.a(f5);
            int n = this.a(c_e, f11, f5);
            if (n >>> 24 > 0 || c_e.Y > 0 || c_e.ab > 0 || c_e.poison > 0) {
                int n2;
                GL11.glDisable((int)3553);
                GL11.glDisable((int)3008);
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glDepthFunc((int)514);
                if (c_e.Y > 0 || c_e.ab > 0) {
                    GL11.glColor4f((float)f11, (float)0.0f, (float)0.0f, (float)0.4f);
                    this.d.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    for (n2 = 0; n2 < 4; ++n2) {
                        if (this.a(c_e, n2)) {
                            GL11.glColor4f((float)f11, (float)0.0f, (float)0.0f, (float)0.4f);
                            this.e.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                        }
                        if (!this.renderAccessories(c_e, n2)) continue;
                        GL11.glColor4f((float)f11, (float)0.0f, (float)0.0f, (float)0.4f);
                        this.secondaryModel.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    }
                }
                if (c_e.poison > 0) {
                    GL11.glColor4f((float)0.0f, (float)f11, (float)0.0f, (float)0.4f);
                    this.d.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    for (n2 = 0; n2 < 4; ++n2) {
                        if (this.a(c_e, n2)) {
                            GL11.glColor4f((float)0.0f, (float)f11, (float)0.0f, (float)0.4f);
                            this.e.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                        }
                        if (!this.renderAccessories(c_e, n2)) continue;
                        GL11.glColor4f((float)0.0f, (float)f11, (float)0.0f, (float)0.4f);
                        this.secondaryModel.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    }
                }
                if (n >>> 24 > 0) {
                    float f12 = (float)(n >> 16 & 0xFF) / 255.0f;
                    f11 = (float)(n >> 8 & 0xFF) / 255.0f;
                    float f13 = (float)(n & 0xFF) / 255.0f;
                    f5 = (float)(n >>> 24) / 255.0f;
                    if (c_e instanceof C_a) {
                        C_a c_a = (C_a)c_e;
                        if (c_a.nightVision) {
                            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f5);
                        } else {
                            GL11.glColor4f((float)f12, (float)f11, (float)f13, (float)f5);
                        }
                    }
                    this.d.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    for (int i = 0; i < 4; ++i) {
                        if (this.a(c_e, i)) {
                            GL11.glColor4f((float)f12, (float)f11, (float)f13, (float)f5);
                            this.e.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                        }
                        if (!this.renderAccessories(c_e, i)) continue;
                        GL11.glColor4f((float)f12, (float)f11, (float)f13, (float)f5);
                        this.secondaryModel.a(f10, f9, f8, f6 - f4, f7, 1.0f);
                    }
                }
                GL11.glDepthFunc((int)515);
                GL11.glDisable((int)3042);
                GL11.glEnable((int)3008);
                GL11.glEnable((int)3553);
            }
            GL11.glDisable((int)2977);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
        this.passSpecialRender(c_e, f, f2, f3);
    }

    protected void passSpecialRender(C_e c_e, float f, float f2, float f3) {
    }

    protected float getSwingProgess(C_e c_e, float f) {
        return c_e.getSwingProgress(f);
    }

    protected void renderEquippedItems(C_e c_e, float f) {
    }

    protected boolean a(C_e c_e, int n) {
        return false;
    }

    protected boolean renderAccessories(C_e c_e, int n) {
        return false;
    }

    protected float a(C_e c_e) {
        return 90.0f;
    }

    protected float getDefaultAngle(C_e c_e, float f) {
        return (float)c_e.H + f;
    }

    protected void rotateCorpse(C_e c_e, float f, float f2, float f3) {
        GL11.glRotatef((float)(180.0f - f2), (float)0.0f, (float)1.0f, (float)0.0f);
        if (c_e.ab > 0) {
            float f4 = ((float)c_e.ab + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f4 = MathHelper.c(f4)) > 1.0f) {
                f4 = 1.0f;
            }
            GL11.glRotatef((float)(f4 * this.a(c_e)), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected int a(C_e c_e, float f, float f2) {
        return 0;
    }

    protected void a(C_e c_e, float f) {
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderEntity((C_e)c_b, f, f2, f3, f4, f5);
    }
}

