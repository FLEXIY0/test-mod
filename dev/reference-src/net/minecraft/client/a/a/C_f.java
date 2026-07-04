/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_aj;
import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.b.C_h;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.game.level.block.furniture.BlockBed;
import net.minecraft.game.level.block.furniture.BlockCake;
import org.lwjgl.opengl.GL11;

public abstract class C_f {
    protected C_i a;
    protected float b;
    protected float c;

    public C_f() {
        new C_h();
        new net.minecraft.client.a.C_f();
        this.b = 0.0f;
        this.c = 1.0f;
    }

    public abstract void a(C_b var1, float var2, float var3, float var4, float var5, float var6);

    protected final void a(String string) {
        RenderEngine.a(this.a.b.a(string));
    }

    protected final void a(String string, String string2) {
        RenderEngine.a(this.a.b.a(string, string2));
    }

    protected final void loadLocalImageTexture(String string) {
        RenderEngine.a(this.a.b.getExternalTexture(string));
    }

    public static void a(net.minecraft.a.d.C_b c_b) {
        GL11.glDisable((int)3553);
        C_d c_d = C_d.a;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        c_d.b();
        C_d.c(0.0f, 0.0f, -1.0f);
        c_d.b(c_b.a, c_b.e, c_b.c);
        c_d.b(c_b.d, c_b.e, c_b.c);
        c_d.b(c_b.d, c_b.b, c_b.c);
        c_d.b(c_b.a, c_b.b, c_b.c);
        C_d.c(0.0f, 0.0f, 1.0f);
        c_d.b(c_b.a, c_b.b, c_b.f);
        c_d.b(c_b.d, c_b.b, c_b.f);
        c_d.b(c_b.d, c_b.e, c_b.f);
        c_d.b(c_b.a, c_b.e, c_b.f);
        C_d.c(0.0f, -1.0f, 0.0f);
        c_d.b(c_b.a, c_b.b, c_b.c);
        c_d.b(c_b.d, c_b.b, c_b.c);
        c_d.b(c_b.d, c_b.b, c_b.f);
        c_d.b(c_b.a, c_b.b, c_b.f);
        C_d.c(0.0f, 1.0f, 0.0f);
        c_d.b(c_b.a, c_b.e, c_b.f);
        c_d.b(c_b.d, c_b.e, c_b.f);
        c_d.b(c_b.d, c_b.e, c_b.c);
        c_d.b(c_b.a, c_b.e, c_b.c);
        C_d.c(-1.0f, 0.0f, 0.0f);
        c_d.b(c_b.a, c_b.b, c_b.f);
        c_d.b(c_b.a, c_b.e, c_b.f);
        c_d.b(c_b.a, c_b.e, c_b.c);
        c_d.b(c_b.a, c_b.b, c_b.c);
        C_d.c(1.0f, 0.0f, 0.0f);
        c_d.b(c_b.d, c_b.b, c_b.c);
        c_d.b(c_b.d, c_b.e, c_b.c);
        c_d.b(c_b.d, c_b.e, c_b.f);
        c_d.b(c_b.d, c_b.b, c_b.f);
        c_d.a();
        GL11.glEnable((int)3553);
    }

    public final void a(C_i c_i) {
        this.a = c_i;
    }

    public final void a(C_b c_b, float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        int n;
        float f9;
        Object object;
        float f10;
        float f11;
        if (c_b.d == null) {
            return;
        }
        if (!(!(this.b > 0.0f) || c_b.m() || c_b.l() || c_b.o() || c_b.isSitting || c_b.isLaying || c_b.isInRope() || c_b.isInCobweb())) {
            float f12;
            f4 = this.a.a(f, f2, f3);
            f4 = (1.0f - f4 / 256.0f) * this.c;
            if (f12 > 0.0f) {
                float f13 = f4;
                float f14 = f3;
                f11 = f2;
                f10 = f;
                C_f c_f = this;
                GL11.glEnable((int)3042);
                RenderEngine.a(this.a.b.a("%%/shadow.png"));
                object = this.a.c;
                GL11.glDepthMask((boolean)false);
                f9 = this.b;
                for (n = (int)(f - f9); n <= (int)(f10 + f9); ++n) {
                    for (int i = (int)(f11 - 2.0f); i <= (int)f11; ++i) {
                        for (int j = (int)(f14 - f9); j <= (int)(f14 + f9); ++j) {
                            float f15;
                            int n2 = ((C_g)object).a(n, i - 1, j);
                            if (n2 <= 0 || ((C_g)object).d(n, i, j) <= 3) continue;
                            C_x c_x = C_x.c[n2];
                            C_d c_d = C_d.a;
                            f8 = (f13 - (f11 - (float)i) / 2.0f) * 0.5f * c_f.a.c.c(n, i, j);
                            if (!(f15 >= 0.0f)) continue;
                            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f8);
                            c_d.b();
                            f8 = (float)n + c_x.au;
                            f7 = (float)n + c_x.ax;
                            float f16 = c_x instanceof C_aj && !((C_aj)c_x).a ? (float)i + c_x.av - 0.5f : (c_x instanceof BlockCake || c_x instanceof BlockBed || c_x instanceof C_bq ? (float)i + c_x.av - 0.5f : (c_x instanceof C_am || c_x instanceof C_bs ? (float)i + c_x.av - 0.875f : (float)i + c_x.av));
                            float f17 = (float)j + c_x.aw;
                            f6 = (float)j + c_x.az;
                            float f18 = (f10 - f8) / 2.0f / f9 + 0.5f;
                            float f19 = (f10 - f7) / 2.0f / f9 + 0.5f;
                            float f20 = (f14 - f17) / 2.0f / f9 + 0.5f;
                            f5 = (f14 - f6) / 2.0f / f9 + 0.5f;
                            c_d.a(f8, f16, f17, f18, f20);
                            c_d.a(f8, f16, f6, f18, f5);
                            c_d.a(f7, f16, f6, f19, f5);
                            c_d.a(f7, f16, f17, f19, f20);
                            c_d.a();
                        }
                    }
                }
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3042);
                GL11.glDepthMask((boolean)true);
            }
        }
        if (c_b.J > 0) {
            GL11.glDisable((int)2896);
            int n3 = C_x.ag.as;
            n = (C_x.ag.as & 0x1F) << 4;
            int n4 = n3 >> 1 & 0x1F0;
            f9 = (float)n / 512.0f;
            f11 = ((float)n + 15.99f) / 512.0f;
            f10 = (float)n4 / 512.0f;
            float f21 = ((float)n4 + 15.99f) / 512.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)f, (float)f2, (float)f3);
            f8 = c_b.w * 1.4f;
            GL11.glScalef((float)f8, (float)f8, (float)f8);
            this.a("/terrain.png");
            object = C_d.a;
            f6 = 1.0f;
            f7 = 0.0f;
            f5 = c_b.x / c_b.w;
            GL11.glRotatef((float)(-this.a.d), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)(0.4f + (float)((int)f5) * 0.02f));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            ((C_d)object).b();
            while (f5 > 0.0f) {
                ((C_d)object).a(f6 - 0.5f, 0.0f - f7, 0.0f, f11, f21);
                ((C_d)object).a(-0.5f, 0.0f - f7, 0.0f, f9, f21);
                ((C_d)object).a(-0.5f, 1.4f - f7, 0.0f, f9, f10);
                ((C_d)object).a(f6 - 0.5f, 1.4f - f7, 0.0f, f11, f10);
                f5 -= 1.0f;
                f7 -= 1.0f;
                f6 *= 0.9f;
                GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.04f);
            }
            ((C_d)object).a();
            GL11.glPopMatrix();
            GL11.glEnable((int)2896);
        }
    }

    public FontRenderer getFontRendererFromRenderManager() {
        return this.a.getFontRenderer();
    }
}

