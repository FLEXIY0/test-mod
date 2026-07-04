/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public interface C_b {
    public int a();

    public ItemStack a(int var1);

    public ItemStack a(int var1, int var2);

    public void a(int var1, ItemStack var2);

    public String b();

    public int c();

    public void onInventoryChanged();

    public boolean canInteractWith(EntityPlayer var1);

    public void openInventory();

    public void closeInventory();
}

