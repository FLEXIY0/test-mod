/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.a.C_a;
import net.minecraft.a.C_b;
import net.minecraft.a.C_f;
import net.minecraft.a.C_m;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.opengl.GL11;

public class C_i
extends C_j {
    private C_b k;
    private C_b l;
    private int m = 0;
    boolean alt = false;

    public C_i(C_b c_b, C_b c_b2, boolean bl) {
        super(new C_f(c_b, c_b2));
        this.k = c_b;
        this.l = c_b2;
        this.f = false;
        this.m = c_b2.a() / 9;
        this.i = 114 + this.m * 18;
        this.alt = bl;
    }

    @Override
    public void b() {
        super.b();
        int n = (this.d - this.i) / 2 + this.i - 80;
        this.e.add(new C_s(1, this.c / 2 + 62, n, 10, 10, "z", "Sort items"));
        this.e.add(new C_s(2, this.c / 2 + 52, n, 10, 10, "v", "Take all"));
        this.e.add(new C_s(3, this.c / 2 + 42, n + 2, 10, 10, "^", "Deposit all"));
    }

    @Override
    protected void a(GuiButton guiButton) {
        super.a(guiButton);
        if (guiButton.b == 1 && !this.b.d.multiplayerWorld) {
            List<ItemStack> list = null;
            if (this.l instanceof C_c) {
                list = Arrays.asList(((C_c)this.l).e);
            } else if (this.l instanceof C_m) {
                list = Arrays.asList(((C_m)this.l).mainInventory);
            } else if (this.l instanceof C_a) {
                int n;
                int n2;
                C_a c_a = (C_a)this.l;
                C_b c_b = c_a.b;
                C_b c_b2 = c_a.c;
                ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
                for (n2 = 0; n2 < c_b.a(); ++n2) {
                    arrayList.add(c_b.a(n2));
                }
                for (n2 = 0; n2 < c_b2.a(); ++n2) {
                    arrayList.add(c_b2.a(n2));
                }
                arrayList.sort(Comparator.comparingInt(itemStack -> {
                    if (itemStack == null || itemStack.a() == null) {
                        return Integer.MAX_VALUE;
                    }
                    return itemStack.a().ap;
                }));
                n2 = 0;
                for (n = 0; n < c_b.a(); ++n) {
                    c_b.a(n, (ItemStack)arrayList.get(n2++));
                }
                for (n = 0; n < c_b2.a(); ++n) {
                    c_b2.a(n, (ItemStack)arrayList.get(n2++));
                }
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
        C_i.b(this.g, this.l.b(), 8, 6, 0xFFFFFF);
        this.g.b(this.k.b(), 8, this.i - 79, n);
    }

    @Override
    public void a() {
        super.a();
        this.l.closeInventory();
    }

    @Override
    protected final void d() {
        int n = this.b.m.a("/gui/container/container.png");
        if (this.alt) {
            n = this.b.m.a("/gui/container/obsidianChest.png");
        }
        int n2 = (this.c - this.a) / 2;
        int n3 = (this.d - this.i) / 2;
        RenderEngine.a(n);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b(n2, n3, 0, 0, this.a, this.m * 18 + 17);
        this.b(n2, n3 + this.m * 18 + 17, 0, 126, 256, 126);
        this.b(n2, n3 + this.m * 18 + 27, 0, 136, 256, 116);
    }
}

