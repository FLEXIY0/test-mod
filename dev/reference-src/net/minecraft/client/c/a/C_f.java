/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.C_c;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.c.C_ac;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_m;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public final class C_f
extends C_j {
    private float m;
    private float n;
    private boolean keepItemOnClick;

    public C_f(EntityPlayer entityPlayer) {
        super(new net.minecraft.a.C_j(entityPlayer.b));
        entityPlayer.craftingInventory = this.container;
        entityPlayer.inventorySlots = this.container;
        this.keepItem = false;
        this.keepItemOnClick = false;
        this.f = true;
    }

    @Override
    public void b() {
        this.e.clear();
        int n = (this.c - this.a) / 2;
        int n2 = (this.d - this.i) / 2;
        if (this.b.f.gamemode == 1) {
            this.e.add(new C_s(1, n - 20, n2 + 140 - 32, 20, 22, "", "Creative Inventory"));
        }
        this.e.add(new C_s(3, n + 142, n2 + 140 - 80, 20, 20, "", "Recipes"));
    }

    @Override
    protected final void e_() {
        int n = 0x404040;
        this.g.b("Crafting", 86, 8, n);
        C_f.a(this.g, "Score: \u00a7e" + this.b.f.P, 90, -10, 0xFFFFFF);
    }

    @Override
    public final void a(int n, int n2, float f) {
        super.a(n, n2, f);
        this.m = n;
        this.n = n2;
    }

    @Override
    protected void a(GuiButton guiButton) {
        super.a(guiButton);
        if (guiButton.b == 1) {
            this.keepItemOnClick = true;
            this.b.a(new C_m(this.b.f));
        }
        if (guiButton.b == 3) {
            this.b.a(new C_ac(this.b.statFileWriter, 2));
        }
    }

    @Override
    public final void f_() {
        super.f_();
        if (this.b.f.b.charmSlot[0] == null || this.b.f.b.charmSlot[0].a() != Item.quiver) {
            for (int i = 0; i < this.b.f.b.quiverInventory.length; ++i) {
                if (this.b.f.b.quiverInventory[i] != null && !this.b.f.b.a(this.b.f.b.quiverInventory[i])) {
                    this.b.f.a(this.b.f.b.quiverInventory[i]);
                }
                this.b.f.b.quiverInventory[i] = null;
            }
        }
    }

    @Override
    protected void altClick(GuiButton guiButton) {
        if (guiButton.b == 1 && this.b.f.b.getItemStack() != null) {
            this.b.f.b.decrItemStack(1);
            this.b.x.a("random.click", 1.0f, 1.0f);
        }
    }

    @Override
    public void a() {
        super.a();
        if (this.b.f != null && !this.keepItemOnClick) {
            this.b.a.closeInventory(this.container.windowId, this.b.f);
        }
    }

    @Override
    protected final void d() {
        int n = this.b.m.a("/gui/container/inventory.png");
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(n);
        n = (this.c - this.a) / 2;
        int n2 = (this.d - this.i) / 2;
        this.b(n, n2, 0, 0, this.a, this.i);
        if (this.b.f.b.charmSlot[0] != null && this.b.f.b.charmSlot[0].a() == Item.quiver) {
            this.b(n - 20, n2 + 11, 0, 166, 25, 62);
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2977);
        GL11.glEnable((int)2903);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(n + 51), (float)(n2 + 75), (float)50.0f);
        GL11.glScalef((float)-30.0f, (float)30.0f, (float)30.0f);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f = this.b.f.T;
        float f2 = this.b.f.n;
        float f3 = this.b.f.o;
        float f4 = (float)(n + 51) - this.m;
        float f5 = (float)(n2 + 75 - 50) - this.n;
        GL11.glRotatef((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        C_c.b();
        GL11.glRotatef((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-((float)Math.atan(f5 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        this.b.f.T = (float)Math.atan(f4 / 40.0f) * 20.0f;
        this.b.f.n = (float)Math.atan(f4 / 40.0f) * 40.0f;
        this.b.f.o = -((float)Math.atan(f5 / 40.0f)) * 20.0f;
        GL11.glTranslatef((float)0.0f, (float)this.b.f.v, (float)0.0f);
        C_i.a.a(this.b.f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
        this.b.f.T = f;
        this.b.f.n = f2;
        this.b.f.o = f3;
        GL11.glPopMatrix();
        C_c.a();
        GL11.glDisable((int)2977);
        int n3 = (this.c - this.a) / 2;
        int n4 = (this.d - this.i) / 2;
        if (this.b.f.gamemode == 1) {
            int n5 = this.b.m.a("/gui/container/allitems.png");
            RenderEngine.a(n5);
            this.b(n3 - 21, n4 + 140 - 32, this.a + 5, 0, 24, 22);
            GL11.glPushMatrix();
            GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            C_c.b();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glEnable((int)2977);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            k.a(this.b.m, new ItemStack(Block.i), n3 - 17, n4 + 114 - 3);
            GL11.glDisable((int)2977);
            C_c.a();
            GL11.glPopMatrix();
        }
        GuiButton guiButton = (GuiButton)this.e.get(0);
        if (this.b.f.gamemode == 1) {
            guiButton = (GuiButton)this.e.get(1);
        }
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        int n6 = scaledResolution.a();
        int n7 = scaledResolution.b();
        int n8 = Mouse.getX() * n6 / this.b.b;
        int n9 = n7 - Mouse.getY() * n7 / this.b.c - 1;
        boolean bl = n8 >= guiButton.g && n9 >= guiButton.i && n8 < guiButton.g + guiButton.e && n9 < guiButton.i + guiButton.f;
        RenderEngine.a(this.b.m.a("/gui/container/inventory.png"));
        if (bl) {
            this.b(n3 + 142, n4 + 140 - 80, 25, 185, 34, 19);
        } else {
            this.b(n3 + 142, n4 + 140 - 80, 25, 166, 34, 19);
        }
    }
}

