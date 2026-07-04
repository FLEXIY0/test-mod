/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a;

import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_af;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.C_c;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.d;
import net.minecraft.client.g.C_a;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_g {
    private d a;
    private ItemStack b = null;
    private float c = 0.0f;
    private float d = 0.0f;
    private C_f g = new C_f();

    public C_g(d d2) {
        this.a = d2;
    }

    public void renderItem(ItemStack itemStack) {
        GL11.glPushMatrix();
        if (itemStack.c < 256 && C_f.renderItemIn3d(C_x.c[itemStack.c].a())) {
            GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            this.g.renderBlockOnInventory(C_x.c[itemStack.c], itemStack.d);
            GL11.glDisable((int)3042);
        } else {
            float f;
            float f2;
            float f3;
            int n;
            float f4 = 512.0f;
            float f5 = 9.765625E-4f;
            if (itemStack.c < 256) {
                GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
            } else {
                GL11.glBindTexture((int)3553, (int)this.a.m.a("/gui/items.png"));
            }
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            C_d c_d = C_d.a;
            int n2 = this.a.f == null ? itemStack.getIconIndex() : this.a.f.getItemIcon(itemStack);
            float f6 = (float)(n2 % 32 * 16 + 0) / f4;
            float f7 = (float)(n2 % 32 * 16 + 16) / f4;
            float f8 = (float)(n2 / 32 * 16 + 0) / f4;
            float f9 = (float)(n2 / 32 * 16 + 16) / f4;
            float f10 = 1.0f;
            float f11 = 0.0f;
            float f12 = 0.3f;
            GL11.glEnable((int)32826);
            GL11.glTranslatef((float)(-f11), (float)(-f12), (float)0.0f);
            float f13 = 1.5f;
            GL11.glScalef((float)f13, (float)f13, (float)f13);
            GL11.glRotatef((float)50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)-0.9375f, (float)-0.0625f, (float)0.0f);
            float f14 = 0.0625f;
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.a(0.0f, 0.0f, 0.0f, f7, f9);
            c_d.a(f10, 0.0f, 0.0f, f6, f9);
            c_d.a(f10, 1.0f, 0.0f, f6, f8);
            c_d.a(0.0f, 1.0f, 0.0f, f7, f8);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.a(0.0f, 1.0f, 0.0f - f14, f7, f8);
            c_d.a(f10, 1.0f, 0.0f - f14, f6, f8);
            c_d.a(f10, 0.0f, 0.0f - f14, f6, f9);
            c_d.a(0.0f, 0.0f, 0.0f - f14, f7, f9);
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f7 + (f6 - f7) * f3 - f5;
                f = f10 * f3;
                c_d.a(f, 0.0f, 0.0f - f14, f2, f9);
                c_d.a(f, 0.0f, 0.0f, f2, f9);
                c_d.a(f, 1.0f, 0.0f, f2, f8);
                c_d.a(f, 1.0f, 0.0f - f14, f2, f8);
            }
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f7 + (f6 - f7) * f3 - f5;
                f = f10 * f3 + 0.0625f;
                c_d.a(f, 1.0f, 0.0f - f14, f2, f8);
                c_d.a(f, 1.0f, 0.0f, f2, f8);
                c_d.a(f, 0.0f, 0.0f, f2, f9);
                c_d.a(f, 0.0f, 0.0f - f14, f2, f9);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f9 + (f8 - f9) * f3 - f5;
                f = f10 * f3 + 0.0625f;
                c_d.a(0.0f, f, 0.0f, f7, f2);
                c_d.a(f10, f, 0.0f, f6, f2);
                c_d.a(f10, f, 0.0f - f14, f6, f2);
                c_d.a(0.0f, f, 0.0f - f14, f7, f2);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f9 + (f8 - f9) * f3 - f5;
                f = f10 * f3;
                c_d.a(f10, f, 0.0f, f6, f2);
                c_d.a(0.0f, f, 0.0f, f7, f2);
                c_d.a(0.0f, f, 0.0f - f14, f7, f2);
                c_d.a(f10, f, 0.0f - f14, f6, f2);
            }
            c_d.a();
            GL11.glDisable((int)32826);
            GL11.glDisable((int)3042);
        }
        GL11.glPopMatrix();
    }

    public void renderItemIntoFrame(ItemStack itemStack) {
        GL11.glPushMatrix();
        if (itemStack.c < 256 && C_f.renderItemIn3d(C_x.c[itemStack.c].a())) {
            GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            this.g.renderBlockOnInventory(C_x.c[itemStack.c], itemStack.d);
            GL11.glDisable((int)3042);
        } else {
            float f;
            float f2;
            float f3;
            int n;
            float f4 = 512.0f;
            float f5 = 9.765625E-4f;
            if (itemStack.c < 256) {
                GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
            } else {
                GL11.glBindTexture((int)3553, (int)this.a.m.a("/gui/items.png"));
            }
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            C_d c_d = C_d.a;
            float f6 = (float)(itemStack.getIconIndex() % 32 * 16 + 0) / f4;
            float f7 = (float)(itemStack.getIconIndex() % 32 * 16 + 16) / f4;
            float f8 = (float)(itemStack.getIconIndex() / 32 * 16 + 0) / f4;
            float f9 = (float)(itemStack.getIconIndex() / 32 * 16 + 16) / f4;
            float f10 = 1.0f;
            GL11.glEnable((int)32826);
            float f11 = 1.5f;
            GL11.glScalef((float)f11, (float)f11, (float)f11);
            float f12 = 0.0625f;
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.a(0.0f, 0.0f, 0.0f, f7, f9);
            c_d.a(f10, 0.0f, 0.0f, f6, f9);
            c_d.a(f10, 1.0f, 0.0f, f6, f8);
            c_d.a(0.0f, 1.0f, 0.0f, f7, f8);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.a(0.0f, 1.0f, 0.0f - f12, f7, f8);
            c_d.a(f10, 1.0f, 0.0f - f12, f6, f8);
            c_d.a(f10, 0.0f, 0.0f - f12, f6, f9);
            c_d.a(0.0f, 0.0f, 0.0f - f12, f7, f9);
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f7 + (f6 - f7) * f3 - f5;
                f = f10 * f3;
                c_d.a(f, 0.0f, 0.0f - f12, f2, f9);
                c_d.a(f, 0.0f, 0.0f, f2, f9);
                c_d.a(f, 1.0f, 0.0f, f2, f8);
                c_d.a(f, 1.0f, 0.0f - f12, f2, f8);
            }
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f7 + (f6 - f7) * f3 - f5;
                f = f10 * f3 + 0.0625f;
                c_d.a(f, 1.0f, 0.0f - f12, f2, f8);
                c_d.a(f, 1.0f, 0.0f, f2, f8);
                c_d.a(f, 0.0f, 0.0f, f2, f9);
                c_d.a(f, 0.0f, 0.0f - f12, f2, f9);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f9 + (f8 - f9) * f3 - f5;
                f = f10 * f3 + 0.0625f;
                c_d.a(0.0f, f, 0.0f, f7, f2);
                c_d.a(f10, f, 0.0f, f6, f2);
                c_d.a(f10, f, 0.0f - f12, f6, f2);
                c_d.a(0.0f, f, 0.0f - f12, f7, f2);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            for (n = 0; n < 16; ++n) {
                f3 = (float)n / 16.0f;
                f2 = f9 + (f8 - f9) * f3 - f5;
                f = f10 * f3;
                c_d.a(f10, f, 0.0f, f6, f2);
                c_d.a(0.0f, f, 0.0f, f7, f2);
                c_d.a(0.0f, f, 0.0f - f12, f7, f2);
                c_d.a(f10, f, 0.0f - f12, f6, f2);
            }
            c_d.a();
            GL11.glDisable((int)32826);
            GL11.glDisable((int)3042);
        }
        GL11.glPopMatrix();
    }

    public final void a(float f) {
        if (this.a.w.showHUD && this.a.w.showArm) {
            float f2;
            float f3;
            float f4;
            float f5 = this.d + (this.c - this.d) * f;
            C_a c_a = this.a.f;
            GL11.glPushMatrix();
            GL11.glRotatef((float)(c_a.q + (c_a.o - c_a.q) * f), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)(c_a.p + (c_a.n - c_a.p) * f), (float)0.0f, (float)1.0f, (float)0.0f);
            C_c.b();
            GL11.glPopMatrix();
            if (c_a instanceof C_a && this.a.w.viewBobbing) {
                f4 = c_a.prevRenderArmPitch + (c_a.renderArmPitch - c_a.prevRenderArmPitch) * f;
                f3 = c_a.prevRenderArmYaw + (c_a.renderArmYaw - c_a.prevRenderArmYaw) * f;
                GL11.glRotatef((float)((c_a.o - f4) * 0.1f), (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)((c_a.n - f3) * 0.1f), (float)0.0f, (float)1.0f, (float)0.0f);
                f2 = 18.0f + ((float)c_a.H + f + 1.0f);
                float f6 = f2 / 20.0f;
                f6 = (f6 * f6 + f6 * 4.0f) / 3.0f;
                if (f6 > 1.0f) {
                    f6 = 1.0f;
                }
                if (f6 > 0.1f) {
                    GL11.glTranslatef((float)0.0f, (float)(MathHelper.a((f2 - 0.1f) * 0.1f) * 0.01f * (f6 - 0.1f)), (float)0.0f);
                }
            }
            f4 = this.a.d.c((int)c_a.h, (int)c_a.i, (int)c_a.j);
            if (this.a.f.nightVision && (f4 += 0.7f) > 1.0f) {
                f4 = 1.0f;
            }
            GL11.glColor4f((float)f4, (float)f4, (float)f4, (float)1.0f);
            if (this.b != null) {
                float f7;
                GL11.glPushMatrix();
                if (c_a.isSwinging) {
                    f4 = ((float)c_a.swingProgressInt + f) / 8.0f;
                    f3 = MathHelper.a(f4 * (float)Math.PI);
                    GL11.glTranslatef((float)(-MathHelper.a(MathHelper.c(f4) * (float)Math.PI) * 0.4f), (float)(MathHelper.a(MathHelper.c(f4) * (float)Math.PI * 2.0f) * 0.2f), (float)(-f3 * 0.2f));
                }
                GL11.glTranslatef((float)0.56f, (float)(-0.52f - (1.0f - f5) * 0.6f), (float)-0.71999997f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glEnable((int)2977);
                if (c_a.isSwinging) {
                    f4 = ((float)c_a.swingProgressInt + f) / 8.0f;
                    f3 = MathHelper.a(f4 * f4 * (float)Math.PI);
                    f2 = MathHelper.a(MathHelper.c(f4) * (float)Math.PI);
                    GL11.glRotatef((float)(-f3 * 20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(-f2 * 20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glRotatef((float)(-f2 * 80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
                GL11.glScalef((float)0.4f, (float)0.4f, (float)0.4f);
                if (c_a.getItemInUseCount() > 0) {
                    C_q c_q = this.b.getItemUseAction();
                    if (c_q == C_q.block) {
                        GL11.glTranslatef((float)-0.5f, (float)0.2f, (float)0.0f);
                        GL11.glRotatef((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                        GL11.glRotatef((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    } else if (c_q == C_q.bow) {
                        if (this.b.a() == Item.g) {
                            GL11.glRotatef((float)-18.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                            GL11.glRotatef((float)-12.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                            GL11.glRotatef((float)-8.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                            GL11.glTranslatef((float)-0.9f, (float)0.2f, (float)0.0f);
                        }
                        f7 = (float)this.b.getMaxItemUseDuration() - ((float)c_a.getItemInUseCount() - f + 1.0f);
                        float f8 = f7 / 20.0f;
                        if ((f8 = (f8 * f8 + f8 * 2.0f) / 3.0f) > 1.0f) {
                            f8 = 1.0f;
                        }
                        if (f8 > 0.1f) {
                            GL11.glTranslatef((float)0.0f, (float)(MathHelper.a((f7 - 0.1f) * 1.3f) * 0.01f * (f8 - 0.1f)), (float)0.0f);
                        }
                        if (this.b.a() instanceof C_bm) {
                            GL11.glTranslatef((float)0.0f, (float)1.0f, (float)0.0f);
                            GL11.glRotatef((float)-20.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                            GL11.glRotatef((float)-10.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                        }
                        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(f8 * 0.1f));
                        GL11.glRotatef((float)-335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                        GL11.glRotatef((float)-50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glTranslatef((float)0.0f, (float)0.5f, (float)0.0f);
                        float f9 = 1.0f + f8 * 0.2f;
                        GL11.glScalef((float)1.0f, (float)1.0f, (float)f9);
                        GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
                        GL11.glRotatef((float)50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    }
                }
                if (this.b.c < 256 && C_f.renderItemIn3d(C_x.c[this.b.c].a())) {
                    GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    GL11.glPushMatrix();
                    C_x c_x = C_x.c[this.b.c];
                    if (c_x instanceof C_am || c_x instanceof C_bs) {
                        GL11.glTranslatef((float)0.0f, (float)0.5f, (float)0.0f);
                    }
                    this.g.renderBlockOnInventory(C_x.c[this.b.c], this.b.d);
                    GL11.glTranslatef((float)0.0f, (float)0.0f, (float)0.0f);
                    GL11.glPopMatrix();
                    GL11.glDisable((int)3042);
                } else {
                    float f10;
                    float f11;
                    int n;
                    float f12 = 512.0f;
                    f7 = 9.765625E-4f;
                    if (this.b.c < 256) {
                        GL11.glBindTexture((int)3553, (int)this.a.m.a("/terrain.png"));
                    } else {
                        GL11.glBindTexture((int)3553, (int)this.a.m.a("/gui/items.png"));
                    }
                    GL11.glEnable((int)3042);
                    GL11.glBlendFunc((int)770, (int)771);
                    if (this.b.a() instanceof net.minecraft.a.b.C_am) {
                        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    } else if (this.b.a() instanceof C_af) {
                        GL11.glRotatef((float)-83.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                        GL11.glRotatef((float)50.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                        GL11.glRotatef((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.3f);
                        GL11.glTranslatef((float)0.0f, (float)-0.5f, (float)0.0f);
                    }
                    C_d c_d = C_d.a;
                    int n2 = this.a.f.getItemIcon(this.b);
                    f2 = (float)(n2 % 32 << 4) / f12;
                    f = (float)((n2 % 32 << 4) + 16) / f12;
                    f5 = (float)(n2 / 32 << 4) / f12;
                    f4 = (float)((n2 / 32 << 4) + 16) / f12;
                    GL11.glEnable((int)2977);
                    GL11.glTranslatef((float)0.0f, (float)-0.3f, (float)0.0f);
                    GL11.glScalef((float)1.5f, (float)1.5f, (float)1.5f);
                    GL11.glRotatef((float)50.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)335.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glTranslatef((float)-0.9375f, (float)-0.0625f, (float)0.0f);
                    C_d.c(0.0f, 0.0f, 1.0f);
                    c_d.b();
                    c_d.a(0.0f, 0.0f, 0.0f, f, f4);
                    c_d.a(1.0f, 0.0f, 0.0f, f2, f4);
                    c_d.a(1.0f, 1.0f, 0.0f, f2, f5);
                    c_d.a(0.0f, 1.0f, 0.0f, f, f5);
                    c_d.a();
                    C_d.c(0.0f, 0.0f, -1.0f);
                    c_d.b();
                    c_d.a(0.0f, 1.0f, -0.0625f, f, f5);
                    c_d.a(1.0f, 1.0f, -0.0625f, f2, f5);
                    c_d.a(1.0f, 0.0f, -0.0625f, f2, f4);
                    c_d.a(0.0f, 0.0f, -0.0625f, f, f4);
                    c_d.a();
                    C_d.c(-1.0f, 0.0f, 0.0f);
                    c_d.b();
                    for (n = 0; n < 16; ++n) {
                        f11 = (float)n / 16.0f;
                        f10 = f + (f2 - f) * f11 - f7;
                        c_d.a(f11 *= 1.0f, 0.0f, -0.0625f, f10, f4);
                        c_d.a(f11, 0.0f, 0.0f, f10, f4);
                        c_d.a(f11, 1.0f, 0.0f, f10, f5);
                        c_d.a(f11, 1.0f, -0.0625f, f10, f5);
                    }
                    c_d.a();
                    C_d.c(1.0f, 0.0f, 0.0f);
                    c_d.b();
                    for (n = 0; n < 16; ++n) {
                        f11 = (float)n / 16.0f;
                        f10 = f + (f2 - f) * f11 - f7;
                        f11 = f11 * 1.0f + 0.0625f;
                        c_d.a(f11, 1.0f, -0.0625f, f10, f5);
                        c_d.a(f11, 1.0f, 0.0f, f10, f5);
                        c_d.a(f11, 0.0f, 0.0f, f10, f4);
                        c_d.a(f11, 0.0f, -0.0625f, f10, f4);
                    }
                    c_d.a();
                    C_d.c(0.0f, 1.0f, 0.0f);
                    c_d.b();
                    for (n = 0; n < 16; ++n) {
                        f11 = (float)n / 16.0f;
                        f10 = f4 + (f5 - f4) * f11 - f7;
                        f11 = f11 * 1.0f + 0.0625f;
                        c_d.a(0.0f, f11, 0.0f, f, f10);
                        c_d.a(1.0f, f11, 0.0f, f2, f10);
                        c_d.a(1.0f, f11, -0.0625f, f2, f10);
                        c_d.a(0.0f, f11, -0.0625f, f, f10);
                    }
                    c_d.a();
                    C_d.c(0.0f, -1.0f, 0.0f);
                    c_d.b();
                    for (n = 0; n < 16; ++n) {
                        f11 = (float)n / 16.0f;
                        f10 = f4 + (f5 - f4) * f11 - f7;
                        c_d.a(1.0f, f11 *= 1.0f, 0.0f, f2, f10);
                        c_d.a(0.0f, f11, 0.0f, f, f10);
                        c_d.a(0.0f, f11, -0.0625f, f, f10);
                        c_d.a(1.0f, f11, -0.0625f, f2, f10);
                    }
                    c_d.a();
                    GL11.glDisable((int)2977);
                    GL11.glDisable((int)3042);
                }
                GL11.glPopMatrix();
            } else {
                GL11.glPushMatrix();
                if (c_a.isSwinging) {
                    f4 = ((float)c_a.swingProgressInt + f) / 8.0f;
                    f3 = MathHelper.a(f4 * (float)Math.PI);
                    GL11.glTranslatef((float)(-MathHelper.a(MathHelper.c(f4) * (float)Math.PI) * 0.3f), (float)(MathHelper.a(MathHelper.c(f4) * (float)Math.PI * 2.0f) * 0.4f), (float)(-f3 * 0.4f));
                }
                GL11.glTranslatef((float)0.64000005f, (float)(-0.6f - (1.0f - f5) * 0.6f), (float)-0.71999997f);
                GL11.glRotatef((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glEnable((int)2977);
                if (c_a.isSwinging) {
                    f4 = ((float)c_a.swingProgressInt + f) / 8.0f;
                    f3 = MathHelper.a(f4 * f4 * (float)Math.PI);
                    GL11.glRotatef((float)(MathHelper.a(MathHelper.c(f4) * (float)Math.PI) * 70.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)(-f3 * 20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.a.f.N != null && this.a.f.skinId.isEmpty()) {
                    GL11.glBindTexture((int)3553, (int)this.a.m.a(this.a.f.N, this.a.f.q()));
                } else {
                    GL11.glBindTexture((int)3553, (int)this.a.m.getExternalTexture(this.a.f.skinId));
                }
                GL11.glTranslatef((float)-0.2f, (float)-0.3f, (float)0.1f);
                GL11.glRotatef((float)120.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glRotatef((float)200.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                GL11.glRotatef((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                GL11.glScalef((float)0.0625f, (float)0.0625f, (float)0.0625f);
                GL11.glTranslatef((float)6.0f, (float)0.0f, (float)0.0f);
                ((net.minecraft.client.a.a.C_g)C_i.a.a(this.a.f)).a();
                GL11.glPopMatrix();
            }
            GL11.glDisable((int)2977);
            C_c.a();
        }
    }

    public final void b(float f) {
        float f2;
        float f3;
        C_d c_d;
        int n;
        GL11.glDisable((int)3008);
        if (this.a.f.J > 0) {
            n = this.a.m.a("/terrain.png");
            GL11.glBindTexture((int)3553, (int)n);
            c_d = C_d.a;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            for (n = 0; n < 2; ++n) {
                GL11.glPushMatrix();
                int n2 = C_x.ag.as;
                int n3 = (n2 & 0x1F) << 4;
                n2 = n2 >> 1 & 0x1F0;
                float f4 = (float)n3 / 512.0f;
                float f5 = ((float)n3 + 15.99f) / 512.0f;
                f3 = (float)n2 / 512.0f;
                f2 = ((float)n2 + 15.99f) / 512.0f;
                GL11.glTranslatef((float)((float)(-((n << 1) - 1)) * 0.24f), (float)-0.3f, (float)0.0f);
                GL11.glRotatef((float)((float)((n << 1) - 1) * 10.0f), (float)0.0f, (float)1.0f, (float)0.0f);
                c_d.b();
                c_d.a(-0.5f, -0.5f, -0.5f, f5, f2);
                c_d.a(0.5f, -0.5f, -0.5f, f4, f2);
                c_d.a(0.5f, 0.5f, -0.5f, f4, f3);
                c_d.a(-0.5f, 0.5f, -0.5f, f5, f3);
                c_d.a();
                GL11.glPopMatrix();
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
        }
        if (this.a.f.m() && GameSettings.f) {
            n = this.a.m.a("/water.png");
            GL11.glBindTexture((int)3553, (int)n);
            c_d = C_d.a;
            float f6 = this.a.f.a(f);
            GL11.glColor4f((float)f6, (float)f6, (float)f6, (float)0.5f);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glPushMatrix();
            f3 = -this.a.f.n / 64.0f;
            f2 = this.a.f.o / 64.0f;
            c_d.b();
            c_d.a(-1.0f, -1.0f, -0.5f, f3 + 4.0f, f2 + 4.0f);
            c_d.a(1.0f, -1.0f, -0.5f, f3 + 0.0f, f2 + 4.0f);
            c_d.a(1.0f, 1.0f, -0.5f, f3 + 0.0f, f2 + 0.0f);
            c_d.a(-1.0f, 1.0f, -0.5f, f3 + 4.0f, f2 + 0.0f);
            c_d.a();
            GL11.glPopMatrix();
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3042);
        }
        GL11.glEnable((int)3008);
    }

    public final void a() {
        float f;
        this.d = this.c;
        C_a c_a = this.a.f;
        ItemStack itemStack = c_a.b.d();
        float f2 = (itemStack == this.b ? 1.0f : 0.0f) - this.c;
        if (f < -0.4f) {
            f2 = -0.4f;
        }
        if (f2 > 0.4f) {
            f2 = 0.4f;
        }
        this.c += f2;
        if (this.c < 0.1f) {
            this.b = itemStack;
        }
    }

    public final void d() {
        this.c = 0.0f;
    }
}

