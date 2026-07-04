/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_c;
import net.minecraft.a.a.b.a.C_b;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_j;
import net.minecraft.a.b.a.C_k;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_w;

public class C_h
extends C_c {
    private C_b furnace;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public C_h(net.minecraft.a.c.e.C_b c_b, C_b c_b2) {
        int n;
        this.furnace = c_b2;
        this.addSlot(new C_g(c_b2, 0, 48, 22));
        this.addSlot(new C_g(c_b2, 1, 48, 58));
        this.addSlot(new C_w(c_b2, 2, 108, 40, c_b.d));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlot(new C_g(c_b, i + n * 9 + 9, 8 + i * 18, 100 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlot(new C_g(c_b, n, 8 + n * 18, 158));
        }
    }

    @Override
    public void updateCraftingResults() {
        super.updateCraftingResults();
        for (int i = 0; i < this.crafters.size(); ++i) {
            C_k c_k = (C_k)this.crafters.get(i);
            if (this.cookTime != this.furnace.h) {
                c_k.updateCraftingInventoryInfo(this, 0, this.furnace.h);
            }
            if (this.burnTime != this.furnace.f) {
                c_k.updateCraftingInventoryInfo(this, 1, this.furnace.f);
            }
            if (this.itemBurnTime == this.furnace.g) continue;
            c_k.updateCraftingInventoryInfo(this, 2, this.furnace.g);
        }
        this.cookTime = this.furnace.h;
        this.burnTime = this.furnace.f;
        this.itemBurnTime = this.furnace.g;
    }

    @Override
    public void determineSmeltTime(int n, int n2) {
        if (n == 0) {
            this.furnace.h = n2;
        }
        if (n == 1) {
            this.furnace.f = n2;
        }
        if (n == 2) {
            this.furnace.g = n2;
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return this.furnace.canInteractWith(entityPlayer);
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = null;
        C_g c_g = (C_g)this.slots.get(n);
        if (c_g != null && c_g.getHasStack()) {
            ItemStack itemStack2 = c_g.getStack();
            itemStack = itemStack2.copy();
            if (n == 2 ? !this.isSlotFree(itemStack2, 3, 39, false) : (n != 1 && n != 0 ? (C_j.smelting().getSmeltingResult(itemStack2.a().ap) != null ? !this.isSlotFree(itemStack2, 0, 1, false) : (C_b.isFuel(itemStack2) ? !this.isSlotFree(itemStack2, 1, 2, false) : (n >= 3 && n < 30 ? !this.isSlotFree(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.isSlotFree(itemStack2, 3, 30, false)))) : !this.isSlotFree(itemStack2, 3, 39, false))) {
                return null;
            }
            if (itemStack2.a == 0) {
                c_g.b(null);
            } else {
                c_g.onSlotChanged();
            }
            if (itemStack2.a == itemStack.a) {
                return null;
            }
            c_g.onPickupFromSlot(itemStack2);
        }
        return itemStack;
    }

    @Override
    public void getProgressBar(int n, int n2) {
        if (n == 0) {
            this.furnace.h = n2;
        }
        if (n == 1) {
            this.furnace.f = n2;
        }
        if (n == 2) {
            this.furnace.g = n2;
        }
    }
}

