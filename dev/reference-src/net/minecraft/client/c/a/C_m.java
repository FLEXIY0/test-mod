/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.C_c;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.C_bt;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.a.C_f;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_j;
import net.minecraft.client.c.a.C_r;
import net.minecraft.client.c.a.C_s;
import net.minecraft.client.d;
import net.minecraft.network.packet.Packet202CreativeInventory;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class C_m
extends C_j {
    private static C_r creativeInventory = new C_r("tmp", 72);
    private float scrollValue = 0.0f;
    private boolean canScroll = false;
    private boolean mouseHeld;
    public static int page = 6;
    private String[] pageName = new String[]{"Unused category", "Blocks", "Decoration", "Items", "Tools", "Survival Inventory", "All items"};
    private boolean keepItemOnClick;
    public C_bt field;
    public static String search;

    public C_m(EntityPlayer entityPlayer) {
        super(new net.minecraft.a.C_g(entityPlayer));
        if (net.minecraft.client.d.getMinecraft().isMultiplayerWorld()) {
            entityPlayer.craftingInventory = new net.minecraft.a.C_j(entityPlayer.b);
            entityPlayer.inventorySlots = new net.minecraft.a.C_j(entityPlayer.b);
        } else {
            entityPlayer.craftingInventory = this.container;
            entityPlayer.inventorySlots = this.container;
        }
        this.i = 208;
        this.keepItem = false;
        this.keepItemOnClick = false;
    }

    @Override
    protected void windowClick(C_g c_g, int n, int n2, boolean bl) {
        Object object;
        if (c_g != null) {
            if (c_g.d == creativeInventory) {
                C_b c_b = this.b.f.b;
                ItemStack itemStack = c_b.getItemStack();
                object = c_g.getStack();
                if (itemStack != null && object != null && itemStack.c == ((ItemStack)object).c && itemStack.d == ((ItemStack)object).d) {
                    if (n2 == 0) {
                        if (bl) {
                            itemStack.a = itemStack.getMaxStackSize();
                        } else if (itemStack.a < itemStack.getMaxStackSize()) {
                            ++itemStack.a;
                        }
                    } else if (itemStack.a <= 1) {
                        c_b.setItemStack(null);
                    } else {
                        --itemStack.a;
                    }
                } else if (itemStack != null) {
                    c_b.setItemStack(null);
                } else if (object == null) {
                    c_b.setItemStack(null);
                } else if (itemStack == null || itemStack.c != ((ItemStack)object).c || itemStack.d != ((ItemStack)object).d) {
                    c_b.setItemStack(ItemStack.copyItemStack((ItemStack)object));
                    itemStack = c_b.getItemStack();
                    if (bl) {
                        itemStack.a = itemStack.getMaxStackSize();
                    }
                }
            } else {
                if (this.b.isMultiplayerWorld() && this.b.getSendQueue() != null && this.b.f.b.a(c_g.a) != null && c_g.a <= 8) {
                    this.b.getSendQueue().addToSendQueue(new Packet202CreativeInventory(c_g.a, null));
                }
                if (bl) {
                    this.b.f.b.a[c_g.a] = null;
                } else {
                    this.container.clickSlot(c_g.slotNumber, n2, bl, this.b.f);
                    object = this.container.getSlot(c_g.slotNumber).getStack();
                    this.b.a.copyStack((ItemStack)object, c_g.slotNumber - this.container.slots.size() + 9 + 36);
                }
            }
        } else {
            C_b c_b = this.b.f.b;
            if (c_b.getItemStack() != null && !this.keepItem) {
                if (n2 == 0) {
                    this.b.f.a(c_b.getItemStack());
                    this.b.a.dupeStack(c_b.getItemStack());
                    c_b.setItemStack(null);
                }
                if (n2 == 1) {
                    ItemStack itemStack = c_b.getItemStack().a(1);
                    this.b.f.a(itemStack);
                    this.b.a.dupeStack(itemStack);
                    if (c_b.getItemStack().a == 0) {
                        c_b.setItemStack(null);
                    }
                }
            }
        }
        if (this.b.isMultiplayerWorld()) {
            object = this.b.f.b;
            if (this.b.getSendQueue() != null && c_g != null && c_g.a <= 8) {
                if (((C_b)object).a(c_g.a) != null) {
                    this.b.getSendQueue().addToSendQueue(new Packet202CreativeInventory(c_g.a, ((C_b)object).a(c_g.a)));
                } else if (((C_b)object).getItemStack() != null) {
                    this.b.getSendQueue().addToSendQueue(new Packet202CreativeInventory(c_g.a, ((C_b)object).getItemStack()));
                    this.b.getSendQueue().addToSendQueue(new Packet202CreativeInventory(c_g.a, null));
                }
            }
        }
    }

    @Override
    public void b() {
        this.e.clear();
        int n = (this.c - this.a) / 2;
        int n2 = (this.d - this.i) / 2;
        for (int i = 1; i < 7; ++i) {
            this.e.add(new C_s(i, n - 20, n2 + 28 * i - 11, 20, 22, "", ""));
        }
        this.field = new C_bt(this, this.g, this.c / 2 - 9, this.d / 2 - 100, 90, 12, "", "Search..");
    }

    @Override
    protected void e_() {
        int n = 0x404040;
        this.g.b(this.pageName[page], 8, 6, n);
    }

    @Override
    public void f_() {
        this.field.updateCursorCounter();
    }

    @Override
    public final void f() {
        super.f();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = ((net.minecraft.a.C_g)this.container).getInventory().size() / 8 - 8 + 1;
            switch (page) {
                case 1: {
                    n2 = ((net.minecraft.a.C_g)this.container).getBlocks().size() / 8 - 8 + 1;
                    break;
                }
                case 2: {
                    n2 = ((net.minecraft.a.C_g)this.container).getDecor().size() / 8 - 8 + 1;
                    break;
                }
                case 3: {
                    n2 = ((net.minecraft.a.C_g)this.container).getItems().size() / 8 - 8 + 1;
                    break;
                }
                case 4: {
                    n2 = ((net.minecraft.a.C_g)this.container).getTools().size() / 8 - 8 + 1;
                    break;
                }
                default: {
                    n2 = ((net.minecraft.a.C_g)this.container).getInventory().size() / 8 - 8 + 1;
                }
            }
            if (n > 0) {
                n = 1;
            }
            if (n < 0) {
                n = -1;
            }
            this.scrollValue = (float)((double)this.scrollValue - 1.0 * (double)n / (double)n2);
            if (this.scrollValue < 0.0f) {
                this.scrollValue = 0.0f;
            }
            if (this.scrollValue > 1.0f) {
                this.scrollValue = 1.0f;
            }
            this.refreshScreen();
        }
    }

    @Override
    public void refreshScreen() {
        ((net.minecraft.a.C_g)this.container).addSlotContents(this.scrollValue);
    }

    @Override
    protected final void mouseClick(int n, int n2, int n3) {
        super.mouseClick(n, n2, n3);
        this.field.mouseClicked(n, n2, n3);
    }

    @Override
    protected void a(char c, int n) {
        if (this.field.isFocused && n != 1) {
            Keyboard.enableRepeatEvents((boolean)true);
            this.field.textboxKeyTyped(c, n);
            ((net.minecraft.a.C_g)this.container).updateSlots(this.field.getText());
            this.refreshScreen();
        } else {
            Keyboard.enableRepeatEvents((boolean)false);
            super.a(c, n);
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        boolean bl = Mouse.isButtonDown((int)0);
        int n3 = (this.c - this.a) / 2;
        int n4 = (this.d - this.i) / 2;
        int n5 = n3 + 155;
        int n6 = n4 + 17;
        int n7 = n5 + 14;
        int n8 = n6 + 160 + 2;
        if (!this.mouseHeld && bl && n >= n5 && n2 >= n6 && n < n7 && n2 < n8) {
            this.canScroll = true;
        }
        if (!bl) {
            this.canScroll = false;
        }
        this.mouseHeld = bl;
        if (this.canScroll) {
            this.scrollValue = (float)(n2 - (n6 + 8)) / ((float)(n8 - n6) - 16.0f);
            if (this.scrollValue < 0.0f) {
                this.scrollValue = 0.0f;
            }
            if (this.scrollValue > 1.0f) {
                this.scrollValue = 1.0f;
            }
            this.refreshScreen();
        }
        super.a(n, n2, f);
        GL11.glDisable((int)2896);
        int n9 = this.b.m.a("/gui/container/allitems.png");
        RenderEngine.a(n9);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-32.0f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b(n3 + 154, n4 + 17 + (int)((float)(n8 - n6 - 17) * this.scrollValue), this.a + 4, 45, 16, 16);
        this.field.drawText(2);
        this.keepItem = false;
        for (int i = 0; i < 6; ++i) {
            boolean bl2;
            GuiButton guiButton = (GuiButton)this.e.get(i);
            boolean bl3 = bl2 = n >= guiButton.g && n2 >= guiButton.i && n < guiButton.g + guiButton.e && n2 < guiButton.i + guiButton.f;
            if (!bl2) continue;
            this.keepItem = true;
            GL11.glTranslatef((float)0.0f, (float)0.0f, (float)64.0f);
            String string = this.pageName[i + 1];
            int n10 = this.b.n.a(string);
            C_m.drawGradientRect(n + 4 + n10, n2 - 1, n, n2 - 13, 0x60050500, -1607454624, 1.5f);
            C_m.b(this.b.n, string, n + 2, n2 - 11, 0xE0E0E0);
        }
    }

    @Override
    protected void d() {
        int n = this.b.m.a("/gui/container/allitems.png");
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(n);
        int n2 = (this.c - this.a) / 2;
        int n3 = (this.d - this.i) / 2;
        this.b(n2, n3, 0, 0, this.a, this.i);
        for (int i = 1; i < 7; ++i) {
            if (i == page) {
                this.b(n2 - 21, n3 + 28 * i - 11, this.a + 5, 0, 25, 22);
                continue;
            }
            this.b(n2 - 21, n3 + 28 * i - 11, this.a + 5, 23, 24, 22);
        }
        GL11.glPushMatrix();
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        C_c.b();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glEnable((int)2977);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        k.a(this.b.m, new ItemStack(C_x.j), n2 - 17, n3 + 20);
        k.a(this.b.m, new ItemStack(C_x.aj), n2 - 17, n3 + 133 - 1);
        k.a(this.b.m, new ItemStack(C_x.i), n2 - 17, n3 + 133 + 27);
        C_c.a();
        k.a(this.b.m, new ItemStack(C_x.n), n2 - 17, n3 + 32 + 15);
        k.a(this.b.m, new ItemStack(Item.i), n2 - 17, n3 + 48 + 36 - 8);
        k.a(this.b.m, new ItemStack(Item.d), n2 - 17, n3 + 64 + 54 - 15);
        GL11.glDisable((int)2977);
        GL11.glPopMatrix();
    }

    @Override
    protected void a(GuiButton guiButton) {
        for (int i = 1; i < 7; ++i) {
            if (guiButton.b != i || i == 5) continue;
            page = i;
            net.minecraft.a.C_g c_g = new net.minecraft.a.C_g(this.b.f);
            c_g.updateSlots(this.field.getText());
            c_g.addSlotContents(this.scrollValue);
            this.container = c_g;
        }
        if (guiButton.b == 5) {
            C_b c_b;
            this.keepItemOnClick = true;
            if (this.b.getSendQueue() != null && this.b.isMultiplayerWorld() && (c_b = this.b.f.b).getItemStack() != null) {
                this.b.getSendQueue().addToSendQueue(new Packet202CreativeInventory(-3, c_b.getItemStack()));
            }
            this.b.a(new C_f(this.b.f));
        }
    }

    @Override
    public void a() {
        GL11.glDeleteTextures((int)this.viewportTexture);
        if (this.b.f != null && !this.keepItemOnClick) {
            this.b.a.closeInventory(this.container.windowId, this.b.f);
        }
    }

    public static C_r creativeContainer() {
        return creativeInventory;
    }
}

