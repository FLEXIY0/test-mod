/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_b;
import net.minecraft.a.C_c;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_t;

public class C_d
extends C_c {
    private C_b inventory;

    public C_d(C_b c_b, C_b c_b2) {
        int n;
        int n2;
        this.inventory = c_b2;
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 3; ++n) {
                this.addSlot(new C_t(c_b2, n + n2 * 3, 62 + n * 18, 17 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlot(new C_g(c_b, n + n2 * 9 + 9, 8 + n * 18, 100 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlot(new C_g(c_b, n2, 8 + n2 * 18, 158));
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
            if (n < 9) {
                if (!this.isSlotFree(itemStack2, 9, this.slots.size(), false)) {
                    return null;
                }
            } else if (itemStack.a().ap != Block.barrel.at) {
                if (!this.isSlotFree(itemStack2, 0, 9, false)) {
                    return null;
                }
            } else {
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

