/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.d;
import org.lwjgl.opengl.GL11;

class GuiButtonNextPage
extends GuiButton {
    private final boolean nextPage;

    public GuiButtonNextPage(int n, int n2, int n3, boolean bl) {
        super(n, n2, n3, 23, 13, "");
        this.nextPage = bl;
    }

    @Override
    public void a(d d2, int n, int n2) {
        if (this.d) {
            boolean bl = n >= this.g && n2 >= this.i && n < this.g + this.e && n2 < this.i + this.f;
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            RenderEngine.a(d2.m.a("/gui/book.png"));
            int n3 = 0;
            int n4 = 192;
            if (bl) {
                n3 += 23;
            }
            if (!this.nextPage) {
                n4 += 13;
            }
            this.b(this.g, this.i, n3, n4, 23, 13);
        }
    }
}

