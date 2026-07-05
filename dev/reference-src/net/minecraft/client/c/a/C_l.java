/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.C_e;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.a.C_j;
import org.lwjgl.opengl.GL11;

public class C_l
extends C_j {
    private C_b upperChestInventory;
    private C_b lowerChestInventory;
    private int inventoryRows = 0;

    public C_l(C_b c_b, C_b c_b2) {
        super(new C_e(c_b, c_b2));
        this.upperChestInventory = c_b;
        this.lowerChestInventory = c_b2;
        this.f = false;
        this.inventoryRows = c_b2.a() / 9;
        this.i = 114 + this.inventoryRows * 18;
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        C_l.b(this.g, this.lowerChestInventory.b(), 8, 6, 0xFFFFFF);
        this.g.b(this.upperChestInventory.b(), 8, this.i - 79, n);
    }

    @Override
    protected final void d() {
        int n = this.b.m.a("/gui/container/bookshelf.png");
        int n2 = (this.c - this.a) / 2;
        int n3 = (this.d - this.i) / 2;
        RenderEngine.a(n);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b(n2, n3, 0, 0, this.a, this.inventoryRows * 18 + 17);
        this.b(n2, n3 + this.inventoryRows * 18 + 17, 0, 126, 256, 126);
        this.b(n2, n3 + this.inventoryRows * 18 + 27, 0, 136, 256, 116);
    }
}

