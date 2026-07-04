/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

public class C_s
extends GuiButton {
    public C_s(int n, int n2, int n3, int n4, int n5, String string, String string2) {
        super(n, n2, n3, n4, n5, string);
        this.description = string2;
    }

    @Override
    public void a(d d2, int n, int n2) {
        if (this.d) {
            int n3 = 0x404040;
            boolean bl = n >= this.g && n2 >= this.i && n < this.g + this.e && n2 < this.i + this.f;
            C_s.drawCenteredStringNoShadow(d2.n, this.a, this.g + this.e / 2, this.i + (this.f - 8) / 2, n3);
            if (bl && !this.description.isEmpty()) {
                this.drawTooltip(n, n2, d2.n);
            }
        }
    }

    @Override
    protected void drawTooltip(int n, int n2, FontRenderer fontRenderer) {
        GL11.glPushMatrix();
        int n3 = n + 12;
        int n4 = n2 - 12;
        int n5 = fontRenderer.a(this.description);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)50.0f);
        C_s.drawGradientRect(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 11, 0x60050500, -1607454624, 1.5f);
        C_s.b(fontRenderer, this.description, n3, n4, -1);
        GL11.glPopMatrix();
    }
}

