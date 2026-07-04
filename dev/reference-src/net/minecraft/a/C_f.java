/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_b;
import net.minecraft.a.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;

public class C_f
extends C_c {
    private C_b inventory;
    private int size;

    public C_f(C_b c_b, C_b c_b2) {
        int n;
        int n2;
        this.inventory = c_b2;
        this.size = c_b2.a() / 9;
        int n3 = (this.size - 4) * 18;
        for (n2 = 0; n2 < this.size; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlot(new C_g(c_b2, n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlot(new C_g(c_b, n + n2 * 9 + 9, 8 + n * 18, 118 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlot(new C_g(c_b, n2, 8 + n2 * 18, 176 + n3));
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return this.inventory.canInteractWith(entityPlayer);
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = null;
        C_g c_g = (C_g)this.slots.get(n);
        if (c_g != null && c_g.getHasStack()) {
            ItemStack itemStack2 = c_g.getStack();
            itemStack = itemStack2.copy();
            if (n < this.size * 9 ? !this.isSlotFree(itemStack2, this.size * 9, this.slots.size(), false) : !this.isSlotFree(itemStack2, 0, this.size * 9, false)) {
                return null;
            }
            if (itemStack2.a == 0) {
                c_g.b(null);
            } else {
                c_g.onSlotChanged();
            }
        }
        return itemStack;
    }
}

