/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.ItemStack;

public class C_g {
    public final int a;
    public int slotNumber;
    public final int b;
    public final int c;
    public final C_b d;

    public C_g(C_b c_b, int n, int n2, int n3) {
        this.d = c_b;
        this.a = n;
        this.b = n2;
        this.c = n3;
    }

    public void onPickupFromSlot(ItemStack itemStack) {
        this.onSlotChanged();
    }

    public boolean a(ItemStack itemStack) {
        return true;
    }

    public final void b(ItemStack itemStack) {
        this.d.a(this.a, itemStack);
        this.onSlotChanged();
    }

    public int b() {
        return -1;
    }

    public ItemStack decrStackSize(int n) {
        return this.d.a(this.a, n);
    }

    public ItemStack getStack() {
        return this.d.a(this.a);
    }

    public boolean getHasStack() {
        return this.getStack() != null;
    }

    public int getSlotStackLimit() {
        return this.d.c();
    }

    public void onSlotChanged() {
        this.d.onInventoryChanged();
    }

    public boolean isHere(C_b c_b, int n) {
        return c_b == this.d && n == this.a;
    }
}

