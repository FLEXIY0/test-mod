/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_c;
import net.minecraft.a.b.C_aa;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.a.c.e.InventoryPlayer;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_a;
import net.minecraft.client.c.a.C_d;
import net.minecraft.client.c.a.C_e;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.c.a.C_h;
import net.minecraft.client.c.a.C_v;
import net.minecraft.client.c.a.C_x;
import net.minecraft.client.c.a.C_y;

public class C_j
extends C_c {
    public C_a craftMatrix = new C_a(this, 2, 2);
    public net.minecraft.a.C_b craftResult = new C_h();
    public boolean isSinglePlayer = false;
    private net.minecraft.a.C_b deleteSlot = new C_h();

    public C_j(InventoryPlayer c_b) {
        this(c_b, true);
        this.isMainInventory = true;
    }

    public C_j(InventoryPlayer c_b, boolean bl) {
        int n;
        int n2;
        this.isSinglePlayer = bl;
        this.addSlot(new C_d(c_b.d, this.craftMatrix, this.craftResult, 0, 144, 31));
        this.addSlot(new C_v(c_b, 43, 80, 62));
        for (n2 = 0; n2 < 2; ++n2) {
            for (n = 0; n < 2; ++n) {
                this.addSlot(new C_g(this.craftMatrix, n + n2 * 2, 88 + n * 18, 21 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            this.addSlot(new C_e(this, c_b, c_b.a() - 5 - n2, 8, 8 + n2 * 18, n2));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            this.addSlot(new C_x(c_b, c_b.a() - 2 - n2, -15, 16 + n2 * 18));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlot(new C_g(c_b, n + (n2 + 1) * 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlot(new C_g(c_b, n2, 8 + n2 * 18, 142));
        }
        this.addSlot(new C_y(this.deleteSlot, 0, 106, 62));
        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
    public void onCraftMatrixChanged(net.minecraft.a.C_b c_b) {
        this.craftResult.a(0, CraftingManager.a().findMatchingRecipe(this.craftMatrix));
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer entityPlayer) {
        super.onCraftGuiClosed(entityPlayer);
        for (int i = 0; i < 4; ++i) {
            ItemStack itemStack = this.craftMatrix.a(i);
            if (itemStack != null && !entityPlayer.b.a(itemStack)) {
                entityPlayer.a(itemStack);
            }
            this.craftMatrix.a(i, null);
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = null;
        C_g c_g = (C_g)this.slots.get(n);
        if (c_g != null && c_g.getHasStack()) {
            int n2;
            ItemStack itemStack2 = c_g.getStack();
            itemStack = itemStack2.copy();
            if (n == 0 ? !this.isSlotFree(itemStack2, 13, 49, false) : (itemStack.a() instanceof net.minecraft.a.b.C_j && !((C_g)this.slots.get(6 + ((net.minecraft.a.b.C_j)itemStack.a()).as)).getHasStack() ? !this.isSlotFree(itemStack2, n2 = 6 + ((net.minecraft.a.b.C_j)itemStack.a()).as, n2 + 1, false) : (itemStack.a() == Item.bootsHermes && !((C_g)this.slots.get(9)).getHasStack() ? !this.isSlotFree(itemStack2, 9, 10, false) : ((itemStack.a() instanceof C_ba || itemStack.a() instanceof C_aa && itemStack.a() != Item.bootsHermes) && !((C_g)this.slots.get(1)).getHasStack() ? !this.isSlotFree(itemStack2, 1, 2, false) : (n >= 13 && n < 40 ? !this.isSlotFree(itemStack2, 40, 49, false) : (n >= 39 && n < 49 ? !this.isSlotFree(itemStack2, 13, 40, false) : !this.isSlotFree(itemStack2, 13, 49, false))))))) {
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
}

