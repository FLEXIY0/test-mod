/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.a.C_b;
import net.minecraft.a.C_d;
import net.minecraft.a.a.b.a.C_e;
import net.minecraft.a.a.b.a.C_m;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.opengl.GL11;

public final class C_k
extends C_j {
    private C_b upperChestInventory;
    private C_b lowerChestInventory;
    private boolean alt;

    public C_k(C_b c_b, C_b c_b2, boolean bl) {
        super(new C_d(c_b, c_b2));
        this.upperChestInventory = c_b;
        this.lowerChestInventory = c_b2;
        this.f = false;
        this.alt = bl;
    }

    @Override
    public void b() {
        super.b();
        int n = this.topBound + this.i - 78;
        this.e.clear();
        this.closeButton = new C_s(0, this.c / 2 + 72, n, 10, 10, "x", "Close");
        this.e.add(this.closeButton);
        this.e.add(new C_s(1, this.c / 2 + 62, n, 10, 10, "z", "Sort items"));
        this.e.add(new C_s(2, this.c / 2 + 52, n, 10, 10, "v", "Take all"));
        this.e.add(new C_s(3, this.c / 2 + 42, n + 2, 10, 10, "^", "Deposit all"));
    }

    @Override
    protected void a(GuiButton guiButton) {
        super.a(guiButton);
        if (guiButton.b == 1 && !this.b.d.multiplayerWorld) {
            List<ItemStack> list = null;
            if (this.lowerChestInventory instanceof C_e) {
                list = Arrays.asList(((C_e)this.lowerChestInventory).barrelContents);
            } else if (this.lowerChestInventory instanceof C_m) {
                list = Arrays.asList(((C_m)this.lowerChestInventory).vacuumContents);
            }
            if (list != null) {
                Collections.sort(list, Comparator.comparingInt(itemStack -> {
                    if (itemStack == null || itemStack.a() == null) {
                        return Integer.MAX_VALUE;
                    }
                    return itemStack.a().ap;
                }));
            }
        }
        if (guiButton.b == 2) {
            for (int i = 0; i < this.container.slots.size() - 36; ++i) {
                this.transferItems(i);
            }
        }
        if (guiButton.b == 3) {
            for (int i = this.container.slots.size() - 36; i < this.container.slots.size(); ++i) {
                this.transferItems(i);
            }
        }
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        if (this.alt) {
            C_k.drawCenteredStringNoShadow(this.g, this.lowerChestInventory.b(), this.a / 2, 6, n);
        } else {
            C_k.a(this.g, this.lowerChestInventory.b(), this.a / 2, 6, 0xFFFFFF);
        }
        this.g.b(this.upperChestInventory.b(), 8, this.i - 77, n);
    }

    @Override
    public void a() {
        super.a();
        this.lowerChestInventory.closeInventory();
    }

    @Override
    protected void d() {
        int n = this.b.m.a("/gui/container/barrel.png");
        if (this.alt) {
            n = this.b.m.a("/gui/container/trap.png");
        }
        RenderEngine.a(n);
        int n2 = (this.c - this.a) / 2;
        int n3 = (this.d - this.i) / 2;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b(n2, n3, 0, 0, this.a, 205);
    }
}

