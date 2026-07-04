/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.a.C_d;
import net.minecraft.client.c.FontRenderer;
import org.lwjgl.opengl.GL11;

public class Gui {
    protected float h = 0.0f;

    protected static void a(int n, int n2, int n3, int n4, int n5) {
        float f = (float)(n5 >>> 24) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        C_d c_d = C_d.a;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)f2, (float)f3, (float)f4, (float)f);
        c_d.b();
        c_d.b(n, n4, 0.0f);
        c_d.b(n3, n4, 0.0f);
        c_d.b(n3, n2, 0.0f);
        c_d.b(n, n2, 0.0f);
        c_d.a();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    protected static void a(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = (float)(n5 >>> 24) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        float f5 = (float)(n6 >>> 24) / 255.0f;
        float f6 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)770, (int)771);
        C_d c_d = C_d.a;
        C_d.a.b();
        c_d.a(f2, f3, f4, f);
        c_d.b(n3, n2, 0.0f);
        c_d.b(n, n2, 0.0f);
        c_d.a(f6, f7, f8, f5);
        c_d.b(n, n4, 0.0f);
        c_d.b(n3, n4, 0.0f);
        c_d.a();
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
    }

    protected static void drawGradientRect(int n, int n2, int n3, int n4, int n5, int n6, float f) {
        float f2 = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n5 & 0xFF) / 255.0f;
        float f6 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n6 & 0xFF) / 255.0f;
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        C_d c_d = C_d.a;
        c_d.b();
        c_d.a(f3, f4, f5, f2 * f);
        c_d.b(n3, n2, 0.0f);
        c_d.b(n, n2, 0.0f);
        c_d.a(f7, f8, f9, f6 * f);
        c_d.b(n, n4, 0.0f);
        c_d.b(n3, n4, 0.0f);
        c_d.a();
        GL11.glShadeModel((int)7424);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
    }

    public static void a(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.a(string, n - fontRenderer.a(string) / 2, n2, n3);
    }

    public static void drawCenteredStringNoShadow(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.b(string, n - fontRenderer.a(string) / 2, n2, n3);
    }

    public static void b(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.a(string, n, n2, n3);
    }

    public static void drawStringAlt(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer.a(string, n - fontRenderer.a(string), n2, n3);
    }

    public final void b(int n, int n2, int n3, int n4, int n5, int n6) {
        C_d c_d = C_d.a;
        c_d.b();
        c_d.a(n, n2 + n6, this.h, (float)n3 * 0.00390625f, (float)(n4 + n6) * 0.00390625f);
        c_d.a(n + n5, n2 + n6, this.h, (float)(n3 + n5) * 0.00390625f, (float)(n4 + n6) * 0.00390625f);
        c_d.a(n + n5, n2, this.h, (float)(n3 + n5) * 0.00390625f, (float)n4 * 0.00390625f);
        c_d.a(n, n2, this.h, (float)n3 * 0.00390625f, (float)n4 * 0.00390625f);
        c_d.a();
    }

    public final void drawSlotTexture(int n, int n2, int n3, int n4, int n5, int n6) {
        C_d c_d = C_d.a;
        c_d.b();
        c_d.a(n, n2 + n6, this.h, (float)n3 * 0.001953125f, (float)(n4 + n6) * 0.001953125f);
        c_d.a(n + n5, n2 + n6, this.h, (float)(n3 + n5) * 0.001953125f, (float)(n4 + n6) * 0.001953125f);
        c_d.a(n + n5, n2, this.h, (float)(n3 + n5) * 0.001953125f, (float)n4 * 0.001953125f);
        c_d.a(n, n2, this.h, (float)n3 * 0.001953125f, (float)n4 * 0.001953125f);
        c_d.a();
    }

    public void drawPaintingTexture(float f, float f2, int n, int n2, int n3, int n4, int n5, int n6) {
        C_d c_d = C_d.a;
        c_d.b();
        c_d.a(1.0f, 1.0f, 1.0f);
        c_d.a(f, f2 + (float)n4, this.h, (float)n * 0.00390625f, (float)(n2 + n6) * 0.00390625f);
        c_d.a(f + (float)n3, f2 + (float)n4, this.h, (float)(n + n5) * 0.00390625f, (float)(n2 + n6) * 0.00390625f);
        c_d.a(f + (float)n3, f2, this.h, (float)(n + n5) * 0.00390625f, (float)n2 * 0.00390625f);
        c_d.a(f, f2, this.h, (float)n * 0.00390625f, (float)n2 * 0.00390625f);
        c_d.a();
    }
}

