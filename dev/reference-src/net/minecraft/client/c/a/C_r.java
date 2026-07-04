/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import java.util.List;
import net.minecraft.a.C_b;
import net.minecraft.a.C_l;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public class C_r
implements C_b {
    private String inventoryTitle;
    private int slotsCount;
    public ItemStack[] inventoryContents;
    private List<C_l> items;

    public C_r(String string, int n) {
        this.inventoryTitle = string;
        this.slotsCount = n;
        this.inventoryContents = new ItemStack[n];
    }

    @Override
    public ItemStack a(int n) {
        return this.inventoryContents[n];
    }

    @Override
    public ItemStack a(int n, int n2) {
        if (this.inventoryContents[n] != null) {
            if (this.inventoryContents[n].a <= n2) {
                ItemStack itemStack = this.inventoryContents[n];
                this.onInventoryChanged();
                return itemStack;
            }
            return null;
        }
        return null;
    }

    @Override
    public void a(int n, ItemStack itemStack) {
        this.inventoryContents[n] = itemStack;
        if (itemStack != null && itemStack.a > this.c()) {
            itemStack.a = this.c();
        }
        this.onInventoryChanged();
    }

    @Override
    public int a() {
        return this.slotsCount;
    }

    @Override
    public String b() {
        return this.inventoryTitle;
    }

    @Override
    public int c() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
        if (this.items != null) {
            for (int i = 0; i < this.items.size(); ++i) {
                this.items.get(i).addContents(this);
            }
        }
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

