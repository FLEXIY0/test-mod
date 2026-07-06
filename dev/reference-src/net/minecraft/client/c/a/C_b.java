/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_k;
import net.minecraft.a.a.World;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.C_ac;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public final class C_b
extends C_j {
    public C_b(net.minecraft.a.c.e.InventoryPlayer c_b, World c_g, int n, int n2, int n3) {
        super(new C_k(c_b, c_g, n, n2, n3));
    }

    @Override
    public void b() {
        super.b();
        this.e.clear();
        int n = (this.c - this.a) / 2;
        int n2 = (this.d - this.i) / 2;
        int n3 = this.topBound + this.i - 78;
        this.e.add(new C_s(1, n + 148, n2 + 34, 20, 20, "", "Recipes"));
        this.closeButton = new C_s(0, this.c / 2 + 72, n3, 10, 10, "x", "Close");
        this.e.add(this.closeButton);
    }

    @Override
    protected void a(GuiButton guiButton) {
        super.a(guiButton);
        if (guiButton.b == 1) {
            this.b.a(new C_ac(this.b.statFileWriter, 2));
        }
    }

    @Override
    public final void a() {
        super.a();
        this.container.onCraftGuiClosed(this.b.f);
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        C_b.b(this.g, "Crafting", 32, 6, 0xFFFFFF);
        this.g.b("Inventory", 8, this.i - 77, n);
    }

    @Override
    protected final void d() {
        int n = this.b.m.a("/gui/container/crafting.png");
        float f = 1.0f;
        RenderEngine.a(n);
        int n2 = (this.c - this.a) / 2;
        int n3 = (this.d - this.i) / 2;
        GL11.glColor4f((float)f, (float)f, (float)f, (float)1.0f);
        this.b(n2, n3, 0, 0, this.a, 203);
        GuiButton guiButton = (GuiButton)this.e.get(0);
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        int n4 = scaledResolution.a();
        int n5 = scaledResolution.b();
        int n6 = Mouse.getX() * n4 / this.b.b;
        int n7 = n5 - Mouse.getY() * n5 / this.b.c - 1;
        boolean bl = n6 >= guiButton.g && n7 >= guiButton.i && n6 < guiButton.g + guiButton.e && n7 < guiButton.i + guiButton.f;
        RenderEngine.a(this.b.m.a("/gui/container/inventory.png"));
        if (bl) {
            this.b(n2 + 148, n3 + 34, 25, 185, 34, 19);
        } else {
            this.b(n2 + 148, n3 + 34, 25, 204, 34, 19);
        }
    }
}

