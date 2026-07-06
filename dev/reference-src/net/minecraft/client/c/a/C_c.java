/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_h;
import net.minecraft.a.a.b.a.C_b;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.opengl.GL11;

public final class C_c
extends C_j {
    private C_b k;

    public C_c(net.minecraft.a.c.e.InventoryPlayer c_b, C_b c_b2) {
        super(new C_h(c_b, c_b2));
        this.k = c_b2;
    }

    @Override
    public void b() {
        super.b();
        int n = this.topBound + this.i - 78;
        this.e.clear();
        this.closeButton = new C_s(0, this.c / 2 + 72, n, 10, 10, "x", "Close");
        this.e.add(this.closeButton);
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        C_c.a(this.g, "Furnace", this.a / 2, 6, 0xFFFFFF);
        this.g.b("Inventory", 8, this.i - 77, n);
    }

    @Override
    protected final void d() {
        int n;
        int n2 = this.b.m.a("/gui/container/furnace.png");
        float f = 1.0f;
        RenderEngine.a(n2);
        int n3 = (this.c - this.a) / 2;
        int n4 = (this.d - this.i) / 2;
        GL11.glColor4f((float)f, (float)f, (float)f, (float)1.0f);
        this.b(n3, n4, 0, 0, this.a, 206);
        if (this.k.e()) {
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            n = this.k.c(12);
            this.b(n3 + 49, n4 + 54 - n, 176, 12 - n, 14, n + 2);
        }
        GL11.glColor4f((float)(f + 0.4f), (float)(f + 0.4f), (float)(f + 0.4f), (float)1.0f);
        n = this.k.b(24);
        this.b(n3 + 71, n4 + 40, 176, 14, n + 1, 16);
    }
}

