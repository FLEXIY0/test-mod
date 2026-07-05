/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_a
implements C_b {
    private ItemStack[] a;
    private int b;
    private C_c eventHandler;

    public C_a(C_c c_c, int n, int n2) {
        int n3 = n * n2;
        this.a = new ItemStack[n3];
        this.eventHandler = c_c;
        this.b = n;
    }

    @Override
    public final int a() {
        return this.a.length;
    }

    @Override
    public ItemStack a(int n) {
        return n >= this.a() ? null : this.a[n];
    }

    @Override
    public final String b() {
        return "Crafting";
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.a[n] != null) {
            if (this.a[n].a <= n2) {
                ItemStack itemStack = this.a[n];
                this.a[n] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return itemStack;
            }
            ItemStack itemStack = this.a[n].a(n2);
            if (this.a[n].a == 0) {
                this.a[n] = null;
            }
            this.eventHandler.onCraftMatrixChanged(this);
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.a[n] = itemStack;
        this.eventHandler.onCraftMatrixChanged(this);
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

    public ItemStack getStackInRowAndColumn(int n, int n2) {
        if (n >= 0 && n < this.b) {
            int n3 = n + n2 * this.b;
            return this.a(n3);
        }
        return null;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

