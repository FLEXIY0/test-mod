/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_i;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.c.e.InventoryPlayer;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_s;
import net.minecraft.client.g.C_d;
import net.minecraft.network.packet.Packet91ActivateGenerator;
import org.lwjgl.opengl.GL11;

public final class C_o
extends C_j {
    private C_h containerInventory;

    public C_o(InventoryPlayer c_b, C_h c_h) {
        super(new C_i(c_b, c_h));
        this.containerInventory = c_h;
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        this.g.b("Generator", 64, 6, n);
        this.g.b("Inventory", 8, this.i - 96 + 2, n);
    }

    @Override
    public void b() {
        super.b();
        this.e.clear();
        this.e.add(new C_s(1, this.c / 2 + 13, this.d / 2 - 48, 20, 20, "", "Activate"));
        this.closeButton = new C_s(0, this.c / 2 + 72, this.d / 2 - 12, 10, 10, "x", "Close");
        this.e.add(this.closeButton);
    }

    @Override
    protected void a(GuiButton guiButton) {
        super.a(guiButton);
        if (guiButton.b == 1) {
            boolean bl = this.containerInventory.active = !this.containerInventory.active;
            if (this.b.isMultiplayerWorld() && this.b.f instanceof C_d) {
                ((C_d)this.b.f).sendQueue.addToSendQueue(new Packet91ActivateGenerator(this.containerInventory.b, this.containerInventory.c, this.containerInventory.d, this.containerInventory.active));
            }
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    protected final void d() {
        int n = this.b.m.a("/gui/container/generator.png");
        RenderEngine.a(n);
        n = (this.c - this.a) / 2;
        int n2 = (this.d - this.i) / 2;
        this.b(n, n2, 0, 0, this.a, this.i);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.containerInventory.isBurning()) {
            int n3 = this.containerInventory.getBurnTimeRemainingScaled(12);
            this.b(n + 80, n2 + 30 - n3, 176, 12 - n3, 14, n3 + 2);
        }
        if (this.containerInventory.active) {
            this.b(this.c / 2 + 13, this.d / 2 - 48, 192, 0, 16, 16);
        } else {
            this.b(this.c / 2 + 13, this.d / 2 - 48, 208, 0, 16, 16);
        }
    }
}

