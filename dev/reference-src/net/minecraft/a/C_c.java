/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_k;
import net.minecraft.a.c.e.InventoryPlayer;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_y;

public abstract class C_c {
    public List<ItemStack> inventoryItemStacks = new ArrayList<ItemStack>();
    public List<C_g> slots = new ArrayList<C_g>();
    public int windowId = 0;
    private short transactionID = 0;
    protected List<C_k> crafters = new ArrayList<C_k>();
    protected boolean isMainInventory = false;
    public C_g lastClickedSlot;
    public C_g clickedSlot;
    public ItemStack movingStack;
    public long currentTime;

    protected void addSlot(C_g c_g) {
        c_g.slotNumber = this.slots.size();
        this.slots.add(c_g);
        this.inventoryItemStacks.add(null);
    }

    public void updateCraftingResults() {
        for (int i = 0; i < this.slots.size(); ++i) {
            ItemStack itemStack = this.slots.get(i).getStack();
            ItemStack itemStack2 = this.inventoryItemStacks.get(i);
            if (ItemStack.areItemStacksEqual(itemStack2, itemStack)) continue;
            itemStack2 = itemStack == null ? null : itemStack.copy();
            this.inventoryItemStacks.set(i, itemStack2);
            for (int j = 0; j < this.crafters.size(); ++j) {
                this.crafters.get(j).updateCraftingInventorySlot(this, i, itemStack2);
            }
        }
    }

    public void onCraftGuiOpened(C_k c_k) {
        if (this.crafters.contains(c_k)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.crafters.add(c_k);
        c_k.updateCraftingInventory(this, this.addItemStackToSlotList());
        this.updateCraftingResults();
    }

    public C_g getSlot(int n) {
        return this.slots.get(n);
    }

    public ItemStack getStackInSlot(int n) {
        C_g c_g = this.slots.get(n);
        return c_g != null ? c_g.getStack() : null;
    }

    public ItemStack clickSlot(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        ItemStack itemStack = null;
        if (n2 == 0 || n2 == 1) {
            InventoryPlayer c_b = entityPlayer.b;
            if ((c_b.charmSlot[0] == null || c_b.charmSlot[0].a() != Item.quiver) && n >= 10 && n < 13 && this.isMainInventory) {
                if (n2 == 0) {
                    entityPlayer.a(c_b.getItemStack());
                    c_b.setItemStack(null);
                }
                if (n2 == 1) {
                    entityPlayer.a(c_b.getItemStack().a(1));
                    if (c_b.getItemStack().a <= 0) {
                        c_b.setItemStack(null);
                    }
                }
            }
            if (n == -999) {
                if (c_b.getItemStack() != null && n == -999) {
                    if (n2 == 0) {
                        entityPlayer.a(c_b.getItemStack());
                        c_b.setItemStack(null);
                    }
                    if (n2 == 1) {
                        entityPlayer.a(c_b.getItemStack().a(1));
                        if (c_b.getItemStack().a <= 0) {
                            c_b.setItemStack(null);
                        }
                    }
                }
            } else if (bl) {
                ItemStack itemStack2 = this.getStackInSlot(n);
                if (itemStack2 != null) {
                    int n3 = itemStack2.c;
                    itemStack = itemStack2.copy();
                    C_g c_g = this.slots.get(n);
                    this.movingStack = itemStack;
                    this.clickedSlot = c_g;
                    this.currentTime = System.currentTimeMillis();
                    if (c_g != null && c_g.getStack() != null && c_g.getStack().c == n3) {
                        this.retryClickSlot(n, n2, bl, entityPlayer);
                    }
                }
            } else {
                C_g c_g = this.slots.get(n);
                if (c_g != null) {
                    int n4;
                    c_g.onSlotChanged();
                    ItemStack itemStack3 = c_g.getStack();
                    ItemStack itemStack4 = c_b.getItemStack();
                    if (itemStack3 != null) {
                        itemStack = itemStack3.copy();
                    }
                    if (itemStack3 == null) {
                        if (itemStack4 != null && c_g.a(itemStack4)) {
                            int n5;
                            int n6 = n5 = n2 == 0 ? itemStack4.a : 1;
                            if (n5 > c_g.getSlotStackLimit()) {
                                n5 = c_g.getSlotStackLimit();
                            }
                            c_g.b(itemStack4.a(n5));
                            if (itemStack4.a <= 0) {
                                c_b.setItemStack(null);
                            }
                        }
                    } else if (itemStack4 == null) {
                        int n7 = n2 == 0 ? itemStack3.a : (itemStack3.a + 1) / 2;
                        ItemStack itemStack5 = c_g.decrStackSize(n7);
                        c_b.setItemStack(itemStack5);
                        if (itemStack3.a <= 0) {
                            c_g.b(null);
                        }
                        c_g.onPickupFromSlot(c_b.getItemStack());
                    } else if (c_g.a(itemStack4)) {
                        if (!(itemStack3.c != itemStack4.c || itemStack3.getHasSubtypes() && itemStack3.getItemDamage() != itemStack4.getItemDamage() || !ItemStack.areItemStackTagsEqual(itemStack3, itemStack4) || itemStack3.hasTagCompound())) {
                            int n8;
                            int n9 = n8 = n2 == 0 ? itemStack4.a : 1;
                            if (n8 > c_g.getSlotStackLimit() - itemStack3.a) {
                                n8 = c_g.getSlotStackLimit() - itemStack3.a;
                            }
                            if (n8 > itemStack4.getMaxStackSize() - itemStack3.a) {
                                n8 = itemStack4.getMaxStackSize() - itemStack3.a;
                            }
                            itemStack4.a(n8);
                            if (itemStack4.a <= 0) {
                                c_b.setItemStack(null);
                            }
                            itemStack3.a += n8;
                        } else if (itemStack4.a <= c_g.getSlotStackLimit()) {
                            c_g.b(itemStack4);
                            if (c_g instanceof C_y && c_b.getItemStack() != null) {
                                c_b.setItemStack(null);
                            } else {
                                c_b.setItemStack(itemStack3);
                            }
                        }
                    } else if (!(itemStack3.c != itemStack4.c || itemStack4.getMaxStackSize() <= 1 || itemStack3.getHasSubtypes() && itemStack3.getItemDamage() != itemStack4.getItemDamage() || !ItemStack.areItemStackTagsEqual(itemStack3, itemStack4) || itemStack3.hasTagCompound() || (n4 = itemStack3.a) <= 0 || n4 + itemStack4.a > itemStack4.getMaxStackSize())) {
                        itemStack4.a += n4;
                        itemStack3.a(n4);
                        if (itemStack3.a <= 0) {
                            c_g.b(null);
                        }
                        c_g.onPickupFromSlot(c_b.getItemStack());
                    }
                }
            }
        }
        return itemStack;
    }

    protected void retryClickSlot(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        this.clickSlot(n, n2, bl, entityPlayer);
    }

    public void onCraftGuiClosed(EntityPlayer entityPlayer) {
        InventoryPlayer c_b = entityPlayer.b;
        if (c_b.getItemStack() != null) {
            entityPlayer.a(c_b.getItemStack());
            c_b.setItemStack(null);
        }
    }

    public void onCraftMatrixChanged(net.minecraft.a.C_b c_b) {
        this.updateCraftingResults();
    }

    public void putStackInSlot(int n, ItemStack itemStack) {
        this.getSlot(n).b(itemStack);
    }

    public void putStacksInSlots(ItemStack[] itemStackArray) {
        for (int i = 0; i < itemStackArray.length; ++i) {
            this.getSlot(i).b(itemStackArray[i]);
        }
    }

    public void determineSmeltTime(int n, int n2) {
    }

    public short updateTransaction(InventoryPlayer c_b) {
        this.transactionID = (short)(this.transactionID + 1);
        return this.transactionID;
    }

    public void cancelTransaction(short s) {
    }

    public void sendTransaction(short s) {
    }

    public abstract boolean isUsableByPlayer(EntityPlayer var1);

    protected boolean isSlotFree(ItemStack itemStack, int n, int n2, boolean bl) {
        ItemStack itemStack2;
        C_g c_g;
        boolean bl2 = false;
        int n3 = n;
        if (bl) {
            n3 = n2 - 1;
        }
        if (itemStack.isStackable()) {
            while (itemStack.a > 0 && (!bl && n3 < n2 || bl && n3 >= n)) {
                c_g = this.slots.get(n3);
                itemStack2 = c_g.getStack();
                if (!(itemStack2 == null || itemStack2.c != itemStack.c || itemStack.getHasSubtypes() && itemStack.getItemDamage() != itemStack2.getItemDamage() || !ItemStack.areItemStackTagsEqual(itemStack, itemStack2) || itemStack.hasTagCompound())) {
                    int n4 = itemStack2.a + itemStack.a;
                    if (n4 <= itemStack.getMaxStackSize()) {
                        itemStack.a = 0;
                        itemStack2.a = n4;
                        c_g.onSlotChanged();
                        this.lastClickedSlot = c_g;
                        bl2 = true;
                    } else if (itemStack2.a < itemStack.getMaxStackSize()) {
                        itemStack.a -= itemStack.getMaxStackSize() - itemStack2.a;
                        itemStack2.a = itemStack.getMaxStackSize();
                        c_g.onSlotChanged();
                        this.lastClickedSlot = c_g;
                        bl2 = true;
                    }
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        if (itemStack.a > 0) {
            n3 = bl ? n2 - 1 : n;
            while (!bl && n3 < n2 || bl && n3 >= n) {
                c_g = this.slots.get(n3);
                itemStack2 = c_g.getStack();
                if (itemStack2 == null) {
                    c_g.b(itemStack.copy());
                    c_g.onSlotChanged();
                    this.lastClickedSlot = c_g;
                    itemStack.a = 0;
                    bl2 = true;
                    break;
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        return bl2;
    }

    public ItemStack updateWindow(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        ItemStack itemStack = null;
        if (n2 == 0 || n2 == 1) {
            InventoryPlayer c_b = entityPlayer.b;
            if (n == -999) {
                if (c_b.getItemStack() != null && n == -999) {
                    if (n2 == 0) {
                        entityPlayer.a(c_b.getItemStack());
                        c_b.setItemStack(null);
                    }
                    if (n2 == 1) {
                        entityPlayer.a(c_b.getItemStack().a(1));
                        if (c_b.getItemStack().a == 0) {
                            c_b.setItemStack(null);
                        }
                    }
                }
            } else if (bl) {
                ItemStack itemStack2 = this.getStackInSlot(n);
                if (itemStack2 != null) {
                    int n3;
                    int n4 = itemStack2.a;
                    itemStack = itemStack2.copy();
                    C_g c_g = this.slots.get(n);
                    if (c_g != null && c_g.getStack() != null && (n3 = c_g.getStack().a) < n4) {
                        this.updateWindow(n, n2, bl, entityPlayer);
                    }
                }
            } else {
                C_g c_g = this.slots.get(n);
                if (c_g != null) {
                    int n5;
                    c_g.onSlotChanged();
                    ItemStack itemStack3 = c_g.getStack();
                    ItemStack itemStack4 = c_b.getItemStack();
                    if (itemStack3 != null) {
                        itemStack = itemStack3.copy();
                    }
                    if (itemStack3 == null) {
                        if (itemStack4 != null && c_g.a(itemStack4)) {
                            int n6;
                            int n7 = n6 = n2 != 0 ? 1 : itemStack4.a;
                            if (n6 > c_g.getSlotStackLimit()) {
                                n6 = c_g.getSlotStackLimit();
                            }
                            c_g.b(itemStack4.a(n6));
                            if (itemStack4.a == 0) {
                                c_b.setItemStack(null);
                            }
                        }
                    } else if (itemStack4 == null) {
                        int n8 = n2 != 0 ? (itemStack3.a + 1) / 2 : itemStack3.a;
                        ItemStack itemStack5 = c_g.decrStackSize(n8);
                        c_b.setItemStack(itemStack5);
                        if (itemStack3.a == 0) {
                            c_g.b(null);
                        }
                        c_g.onPickupFromSlot(c_b.getItemStack());
                    } else if (c_g.a(itemStack4)) {
                        if (!(itemStack3.c != itemStack4.c || itemStack3.getHasSubtypes() && itemStack3.getItemDamage() != itemStack4.getItemDamage())) {
                            int n9;
                            int n10 = n9 = n2 != 0 ? 1 : itemStack4.a;
                            if (n9 > c_g.getSlotStackLimit() - itemStack3.a) {
                                n9 = c_g.getSlotStackLimit() - itemStack3.a;
                            }
                            if (n9 > itemStack4.getMaxStackSize() - itemStack3.a) {
                                n9 = itemStack4.getMaxStackSize() - itemStack3.a;
                            }
                            itemStack4.a(n9);
                            if (itemStack4.a == 0) {
                                c_b.setItemStack(null);
                            }
                            itemStack3.a += n9;
                        } else if (itemStack4.a <= c_g.getSlotStackLimit()) {
                            c_g.b(itemStack4);
                            c_b.setItemStack(itemStack3);
                        }
                    } else if (!(itemStack3.c != itemStack4.c || itemStack4.getMaxStackSize() <= 1 || itemStack3.getHasSubtypes() && itemStack3.getItemDamage() != itemStack4.getItemDamage() || (n5 = itemStack3.a) <= 0 || n5 + itemStack4.a > itemStack4.getMaxStackSize())) {
                        itemStack4.a += n5;
                        itemStack3.a(n5);
                        if (itemStack3.a == 0) {
                            c_g.b(null);
                        }
                        c_g.onPickupFromSlot(c_b.getItemStack());
                    }
                }
            }
        }
        return itemStack;
    }

    public void getProgressBar(int n, int n2) {
    }

    public ItemStack getSlotIdentifier(int n) {
        C_g c_g = this.slots.get(n);
        return c_g != null ? c_g.getStack() : null;
    }

    public List<ItemStack> addItemStackToSlotList() {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (int i = 0; i < this.slots.size(); ++i) {
            arrayList.add(this.slots.get(i).getStack());
        }
        return arrayList;
    }

    public C_g fetchSlotFromInventory(net.minecraft.a.C_b c_b, int n) {
        for (int i = 0; i < this.slots.size(); ++i) {
            C_g c_g = this.slots.get(i);
            if (!c_g.isHere(c_b, n)) continue;
            return c_g;
        }
        return null;
    }
}

