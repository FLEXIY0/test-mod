/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.Gui;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public class GuiButton
extends Gui {
    public int e;
    public int f;
    public int g;
    public int i;
    public String a;
    public int b;
    public boolean c = true;
    public boolean d = true;
    public boolean slider = false;
    public String description;

    public GuiButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiButton(int n, int n2, int n3, int n4, int n5, String string, String string2) {
        this(n, n2, n3, n4, n5, string);
        this.description = string2;
    }

    public GuiButton(int n, int n2, int n3, int n4, int n5, String string) {
        this.b = n;
        this.g = n2;
        this.i = n3;
        this.e = n4;
        this.f = n5;
        this.a = string;
    }

    public void a(d d2, int n, int n2) {
        if (this.d) {
            boolean bl;
            FontRenderer fontRenderer = d2.n;
            GL11.glBindTexture((int)3553, (int)d2.m.a("/gui/gui.png"));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            byte by = 1;
            boolean bl2 = bl = n >= this.g && n2 >= this.i && n < this.g + this.e && n2 < this.i + this.f;
            if (!this.c) {
                by = 0;
            } else if (bl) {
                by = 2;
            }
            this.drawBg(by);
            if (!this.c) {
                GuiButton.a(fontRenderer, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, -6250336);
            } else if (bl) {
                GuiButton.a(fontRenderer, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, 0xFFFFA0);
            } else {
                GuiButton.a(fontRenderer, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, 0xE0E0E0);
            }
        }
    }

    protected void drawBg(byte by) {
        this.b(this.g, this.i, 0, 46 + by * 20, this.e / 2, this.f);
        this.b(this.g + this.e / 2, this.i, 200 - this.e / 2, 46 + by * 20, this.e / 2, this.f);
    }

    protected void mouseDragged(d d2, int n, int n2) {
    }

    public void mouseReleased(int n, int n2) {
    }

    public boolean mousePressed(d d2, int n, int n2) {
        return this.c && this.d && n >= this.g && n2 >= this.i && n < this.g + this.e && n2 < this.i + this.f;
    }

    protected void drawTooltip(int n, int n2, FontRenderer fontRenderer) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)250.0f);
        int n3 = fontRenderer.a(this.description);
        GuiButton.drawGradientRect(n + 5 - n3 / 2, n2 + 12, n + 10 + n3 + 3 - n3 / 2, n2 + 26, 0x60050500, -1607454624, 1.5f);
        GuiButton.a(fontRenderer, this.description, n + 10, n2 + 15, 0xE0E0E0);
        GL11.glPopMatrix();
    }
}

