/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_m
implements C_b {
    public ItemStack[] mainInventory = new ItemStack[27];
    public EntityPlayer player;
    public boolean inventoryChanged = false;

    public C_m(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    @Override
    public final ItemStack a(int n, int n2) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= this.mainInventory.length) {
            n -= this.mainInventory.length;
        }
        if (itemStackArray[n] != null) {
            if (itemStackArray[n].a <= n2) {
                ItemStack itemStack = itemStackArray[n];
                itemStackArray[n] = null;
                return itemStack;
            }
            ItemStack itemStack = itemStackArray[n].a(n2);
            if (itemStackArray[n].a == 0) {
                itemStackArray[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= this.mainInventory.length) {
            n -= this.mainInventory.length;
        }
        itemStackArray[n] = itemStack;
    }

    @Override
    public final int a() {
        return this.mainInventory.length;
    }

    @Override
    public final ItemStack a(int n) {
        ItemStack[] itemStackArray = this.mainInventory;
        if (n >= this.mainInventory.length) {
            n -= this.mainInventory.length;
        }
        return itemStackArray[n];
    }

    @Override
    public final String b() {
        return "Adminium Chest";
    }

    @Override
    public final int c() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
        this.inventoryChanged = true;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return (double)entityPlayer.b(this.player) <= 64.0;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

