/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.C_c;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_f;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_s;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class C_j
extends GuiScreen {
    protected static C_e k = new C_e();
    protected int a = 176;
    protected int i = 166;
    protected net.minecraft.a.C_c container;
    public boolean keepItem;
    protected GuiButton closeButton;
    protected int leftBound;
    protected int topBound;

    public C_j(net.minecraft.a.C_c c_c) {
        this.container = c_c;
    }

    @Override
    public void b() {
        super.b();
        this.b.f.craftingInventory = this.container;
        this.leftBound = (this.c - this.a) / 2;
        this.topBound = (this.d - this.i) / 2;
        int n = this.topBound + this.i - 80;
        this.e.clear();
        this.closeButton = new C_s(0, this.c / 2 + 72, n, 10, 10, "x", "Close");
        this.e.add(this.closeButton);
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c && guiButton == this.closeButton) {
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        this.h();
        int n8 = (this.c - this.a) / 2;
        int n9 = (this.d - this.i) / 2;
        this.d();
        GL11.glPushMatrix();
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        C_c.b();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n8, (float)n9, (float)0.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2977);
        for (n7 = 0; n7 < this.container.slots.size(); ++n7) {
            C_g c_g = this.container.slots.get(n7);
            C_b c_b = c_g.d;
            n6 = c_g.a;
            int n10 = c_g.b;
            int n11 = c_g.c;
            ItemStack itemStack = c_b.a(n6);
            if (itemStack == null && (n5 = c_g.b()) >= 0) {
                if (this.b.f.b.charmSlot[0] != null && this.b.f.b.charmSlot[0].c == Item.quiver.ap || c_g.a <= 39 || c_g.a >= 43 || !(this.b.o instanceof C_f)) {
                    GL11.glDisable((int)2896);
                    RenderEngine.a(this.b.m.a("/gui/items.png"));
                    this.drawSlotTexture(n10, n11, n5 % 16 << 4, n5 / 16 << 4, 16, 16);
                    GL11.glEnable((int)2896);
                }
            } else {
                k.a(this.b.m, itemStack, n10, n11);
                k.a(this.g, itemStack, n10, n11);
            }
            if (!this.isAtCursorPos(c_g, n, n2) || (this.b.f.b.charmSlot[0] == null || this.b.f.b.charmSlot[0].c != Item.quiver.ap) && c_g.a > 39 && c_g.a < 43 && this.b.o instanceof C_f) continue;
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            n4 = c_g.b;
            n3 = c_g.c;
            C_j.drawGradientRect(n4, n3, n4 + 16, n3 + 16, -2130706433, -2130706433, 1.0f);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
        }
        if (this.b.f.b.getItemStack() != null) {
            GL11.glPushMatrix();
            float f2 = 1.2f;
            int n12 = n - n8 - 8;
            int n13 = n2 - n9 - 8;
            GL11.glTranslatef((float)n12, (float)n13, (float)50.0f);
            GL11.glScalef((float)f2, (float)f2, (float)1.0f);
            k.a(this.b.m, this.b.f.b.getItemStack(), 0, 0);
            k.a(this.g, this.b.f.b.getItemStack(), 0, 0);
            GL11.glPopMatrix();
        }
        this.animateShiftClick();
        GL11.glDisable((int)2977);
        C_c.a();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        this.e_();
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glPopMatrix();
        C_c.a();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)64.0f);
        for (n7 = 0; n7 < this.container.slots.size(); ++n7) {
            int n14;
            C_g c_g = this.container.slots.get(n7);
            C_b c_b = c_g.d;
            n6 = c_g.a;
            ItemStack itemStack = c_b.a(n6);
            if (!this.isAtCursorPos(c_g, n, n2) || itemStack == null || this.b.f.b.getItemStack() != null) continue;
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)64.0f);
            String string = this.b.w.d ? itemStack.getItemName() + " " + itemStack.getItemID() + ":" + itemStack.getItemDamage() : itemStack.getItemName();
            n5 = this.b.n.a(string);
            int n15 = -11;
            n4 = 0;
            for (n3 = 0; n3 < itemStack.getItemDescriptionLength(); ++n3) {
                n14 = this.b.n.a(itemStack.getItemDescription(n3));
                if (itemStack.getItemDescription(n3).isEmpty()) continue;
                n4 += 10;
                if (n5 >= n14) continue;
                n5 = n14;
            }
            if (itemStack.c == C_x.barrel.at && itemStack.hasTagCompound() && itemStack.getTagCompound().i("BlockEntityTag").j("Items").b() > 0) {
                Object object;
                int n16;
                C_j.drawGradientRect(n + 10 + (n5 > 52 ? n5 : 52), n2 - 1 + n4 - 56, n + 6, n2 - 13 - 56, 0x60050500, -1607454624, 1.5f);
                C_j.drawGradientRect(n + 10 + (n5 > 52 ? n5 : 52), n2 - 1 + n4, n + 6, n2 - 1 - 56 + n4, -1878719232, -802148256, 1.5f);
                n3 = 2 + (n5 > 52 ? n5 / 2 - 26 : 0);
                n14 = -54 + n4;
                for (int i = 0; i < 9; ++i) {
                    C_j.drawGradientRect(n + 22 + n3 + i % 3 * 18, n2 + 15 + n14 + i / 3 * 18, n + 6 + n3 + i % 3 * 18, n2 - 1 + n14 + i / 3 * 18, -1871021415, -1599888436, 1.5f);
                }
                NBTTagCompound nBTTagCompound = itemStack.getTagCompound();
                NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("BlockEntityTag");
                NBTTagList nBTTagList = nBTTagCompound2.j("Items");
                GL11.glPushMatrix();
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                C_c.b();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glEnable((int)2977);
                for (n16 = 0; n16 < nBTTagList.b(); ++n16) {
                    object = (NBTTagCompound)nBTTagList.a(n16);
                    short s = ((NBTTagCompound)object).c("id");
                    int n17 = ((NBTTagCompound)object).b("Slot") & 0xFF;
                    byte by = ((NBTTagCompound)object).b("Count");
                    short s2 = ((NBTTagCompound)object).c("Damage");
                    k.renderItemIntoGUI(this.b.m, s, s2, Item.b[s].getIconFromDamage(s2), n + 6 + n3 + n17 % 3 * 18, n2 - 1 + n14 + n17 / 3 * 18);
                    k.renderItemOverlayIntoGUI(this.g, s, s2, Item.b[s].getIconFromDamage(s2), by, Item.b[s].d(), n + 6 + n3 + n17 % 3 * 18, n2 - 1 + n14 + n17 / 3 * 18);
                }
                GL11.glDisable((int)2977);
                GL11.glPopMatrix();
                C_c.a();
                C_j.b(this.b.n, string, n + 8, n2 - 11 - 56, 0xE0E0E0);
                for (n16 = 0; n16 < itemStack.getItemDescriptionLength(); ++n16) {
                    object = itemStack.getItemDescription(n16);
                    n15 += 10;
                    if (((String)object).isEmpty()) continue;
                    C_j.b(this.b.n, (String)object, n + 8, n2 + n15 - 56, 0x55FF55);
                }
                continue;
            }
            C_j.drawGradientRect(n + 10 + n5, n2 - 1 + n4, n + 6, n2 - 13, 0x60050500, -1607454624, 1.5f);
            C_j.b(this.b.n, string, n + 8, n2 - 11, 0xE0E0E0);
            for (n3 = 0; n3 < itemStack.getItemDescriptionLength(); ++n3) {
                String string2 = itemStack.getItemDescription(n3);
                n15 += 10;
                if (string2.isEmpty()) continue;
                C_j.b(this.b.n, string2, n + 8, n2 + n15, 0x55FF55);
            }
        }
        super.a(n, n2, f);
    }

    protected void animateShiftClick() {
        if (this.container.movingStack != null) {
            float f = Math.min(1.0f, (float)(System.currentTimeMillis() - this.container.currentTime) / 150.0f);
            int n = this.leftBound + this.container.clickedSlot.b;
            int n2 = this.topBound + this.container.clickedSlot.c;
            int n3 = this.leftBound + this.container.lastClickedSlot.b;
            int n4 = this.topBound + this.container.lastClickedSlot.c;
            int n5 = (int)((float)n + (float)(n3 - n) * f) - this.leftBound;
            int n6 = (int)((float)n2 + (float)(n4 - n2) * f) - this.topBound;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)n5, (float)n6, (float)200.0f);
            k.a(this.b.m, this.container.movingStack, 0, 0);
            k.a(this.b.n, this.container.movingStack, 0, 0);
            GL11.glPopMatrix();
            if (f >= 1.0f) {
                this.container.movingStack = null;
                this.container.clickedSlot = null;
                this.container.lastClickedSlot = null;
            }
        }
    }

    protected boolean isAtCursorPos(C_g c_g, int n, int n2) {
        int n3 = (this.c - this.a) / 2;
        int n4 = (this.d - this.i) / 2;
        return (n -= n3) >= c_g.b - 1 && n < c_g.b + 16 + 1 && (n2 -= n4) >= c_g.c - 1 && n2 < c_g.c + 16 + 1;
    }

    protected void transferItems(int n) {
        C_g c_g = this.container.slots.get(n);
        ItemStack itemStack = this.b.f.b.getItemStack();
        ItemStack itemStack2 = c_g.getStack();
        if (itemStack != null) {
            if (itemStack2 != null && itemStack2.a() == itemStack.a() && itemStack2.getItemDamage() == itemStack.getItemDamage()) {
                this.b.a.updateWindow(this.container.windowId, c_g.slotNumber, 0, true, this.b.f);
            }
        } else {
            this.b.a.updateWindow(this.container.windowId, c_g.slotNumber, 0, true, this.b.f);
        }
    }

    protected void e_() {
    }

    protected abstract void d();

    protected C_g getSlotAtPosition(int n, int n2) {
        for (int i = 0; i < this.container.slots.size(); ++i) {
            C_g c_g = this.container.slots.get(i);
            if (!this.isAtCursorPos(c_g, n, n2)) continue;
            return c_g;
        }
        return null;
    }

    @Override
    protected void mouseClick(int n, int n2, int n3) {
        super.mouseClick(n, n2, n3);
        if (n3 == 0 || n3 == 1) {
            C_g c_g = this.getSlotAtPosition(n, n2);
            int n4 = (this.c - this.a) / 2;
            int n5 = (this.d - this.i) / 2;
            boolean bl = n < n4 || n2 < n5 || n >= n4 + this.a || n2 >= n5 + this.i;
            int n6 = -1;
            if (c_g != null) {
                n6 = c_g.slotNumber;
            }
            if (bl) {
                n6 = -999;
            }
            if (n6 != -1) {
                boolean bl2 = n6 != -999 && (Keyboard.isKeyDown((int)42) || Keyboard.isKeyDown((int)54));
                this.windowClick(c_g, n6, n3, bl2);
            }
        }
    }

    protected void windowClick(C_g c_g, int n, int n2, boolean bl) {
        if (c_g != null) {
            n = c_g.slotNumber;
        }
        if (!this.keepItem) {
            this.b.a.clickSlot(this.container.windowId, n, n2, bl, this.b.f);
        }
    }

    @Override
    protected void a(char c, int n) {
        if (n == 1 || n == this.b.w.n.b) {
            this.b.a((GuiScreen)null);
        }
    }

    @Override
    public void a() {
        super.a();
        if (this.b.f != null) {
            this.b.a.closeInventory(this.container.windowId, this.b.f);
        }
    }

    @Override
    public final boolean c() {
        return false;
    }
}

