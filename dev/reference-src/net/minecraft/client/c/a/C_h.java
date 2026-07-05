/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_h
implements C_b {
    private ItemStack[] a = new ItemStack[1];

    @Override
    public final int a() {
        return 1;
    }

    @Override
    public final ItemStack a(int n) {
        return this.a[n];
    }

    @Override
    public final String b() {
        return "Result";
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.a[n] != null) {
            ItemStack itemStack = this.a[n];
            this.a[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.a[n] = itemStack;
    }

    @Override
    public final int c() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

