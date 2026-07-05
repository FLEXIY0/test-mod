/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public class C_a
implements C_b {
    private String a;
    public C_b b;
    public C_b c;

    public C_a(String string, C_b c_b, C_b c_b2) {
        this.a = string;
        this.b = c_b;
        this.c = c_b2;
    }

    @Override
    public int a() {
        return this.b.a() + this.c.a();
    }

    @Override
    public String b() {
        return this.a;
    }

    @Override
    public ItemStack a(int n) {
        return n >= this.b.a() ? this.c.a(n - this.b.a()) : this.b.a(n);
    }

    @Override
    public ItemStack a(int n, int n2) {
        return n >= this.b.a() ? this.c.a(n - this.b.a(), n2) : this.b.a(n, n2);
    }

    @Override
    public void a(int n, ItemStack itemStack) {
        if (n >= this.b.a()) {
            this.c.a(n - this.b.a(), itemStack);
        } else {
            this.b.a(n, itemStack);
        }
    }

    @Override
    public int c() {
        return this.b.c();
    }

    @Override
    public void onInventoryChanged() {
        this.b.onInventoryChanged();
        this.c.onInventoryChanged();
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.b.canInteractWith(entityPlayer) && this.c.canInteractWith(entityPlayer);
    }

    @Override
    public void openInventory() {
        this.b.openInventory();
        this.c.openInventory();
    }

    @Override
    public void closeInventory() {
        this.b.closeInventory();
        this.c.closeInventory();
    }
}

