/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a;

import net.minecraft.a.C_c;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.a.c.e.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_a;
import net.minecraft.client.c.a.C_d;
import net.minecraft.client.c.a.C_h;

public class C_k
extends C_c {
    public C_a craftMatrix = new C_a(this, 3, 3);
    public net.minecraft.a.C_b craftResult = new C_h();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public C_k(C_b c_b, World c_g, int n, int n2, int n3) {
        int n4;
        int n5;
        this.worldObj = c_g;
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.addSlot(new C_d(c_b.d, this.craftMatrix, this.craftResult, 0, 120, 36));
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                this.addSlot(new net.minecraft.client.c.a.C_g(this.craftMatrix, n4 + n5 * 3, 26 + n4 * 18, 18 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                this.addSlot(new net.minecraft.client.c.a.C_g(c_b, n4 + n5 * 9 + 9, 8 + n4 * 18, 101 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 9; ++n5) {
            this.addSlot(new net.minecraft.client.c.a.C_g(c_b, n5, 8 + n5 * 18, 159));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
    public void onCraftMatrixChanged(net.minecraft.a.C_b c_b) {
        this.craftResult.a(0, CraftingManager.a().findMatchingRecipe(this.craftMatrix));
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer entityPlayer) {
        super.onCraftGuiClosed(entityPlayer);
        if (!this.worldObj.multiplayerWorld) {
            for (int i = 0; i < 9; ++i) {
                ItemStack itemStack = this.craftMatrix.a(i);
                if (itemStack != null && !entityPlayer.b.a(itemStack)) {
                    entityPlayer.a(itemStack);
                }
                this.craftMatrix.a(i, null);
            }
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.a(this.posX, this.posY, this.posZ) != Block.an.at ? false : entityPlayer.getDistanceSq((float)this.posX + 0.5f, (float)this.posY + 0.5f, (float)this.posZ + 0.5f) <= 64.0f;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack itemStack = null;
        net.minecraft.client.c.a.C_g c_g = (net.minecraft.client.c.a.C_g)this.slots.get(n);
        if (c_g != null && c_g.getHasStack()) {
            ItemStack itemStack2 = c_g.getStack();
            itemStack = itemStack2.copy();
            if (n == 0 ? !this.isSlotFree(itemStack2, 10, 46, false) : (n >= 10 && n < 37 ? !this.isSlotFree(itemStack2, 37, 46, false) : (n >= 37 && n < 46 ? !this.isSlotFree(itemStack2, 10, 37, false) : !this.isSlotFree(itemStack2, 10, 46, false)))) {
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

