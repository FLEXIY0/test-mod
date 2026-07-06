/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_c;
import net.minecraft.a.a.b.a.C_h;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.InventoryPlayer;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;

public class C_i
extends C_c {
    private C_h generatorBlock;

    public C_i(InventoryPlayer c_b, C_h c_h) {
        int n;
        this.generatorBlock = c_h;
        this.addSlot(new C_g(c_h, 0, 80, 35));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlot(new C_g(c_b, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlot(new C_g(c_b, n, 8 + n * 18, 142));
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return this.generatorBlock.canInteractWith(entityPlayer);
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = null;
        C_g c_g = (C_g)this.slots.get(n);
        if (c_g != null && c_g.getHasStack()) {
            ItemStack itemStack2 = c_g.getStack();
            itemStack = itemStack2.copy();
            if (n != 0 ? (C_h.isFuel(itemStack2) ? !this.isSlotFree(itemStack2, 0, 1, false) : (n >= 1 && n < 30 ? !this.isSlotFree(itemStack2, 30, 37, false) : n >= 30 && n < 37 && !this.isSlotFree(itemStack2, 1, 30, false))) : !this.isSlotFree(itemStack2, 1, 37, false)) {
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
            this.generatorBlock.activeTime = n2;
        }
    }
}

