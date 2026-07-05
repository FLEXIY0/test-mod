/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_l;
import net.minecraft.client.c.a.C_a;

public class C_r
implements C_l {
    private int recipeWidth;
    private int recipeHeight;
    private ItemStack[] recipeItems;
    private ItemStack recipeOutput;
    public final int recipeOutputItemID;
    private boolean doesItemContainNBT = false;

    public C_r(int n, int n2, ItemStack[] itemStackArray, ItemStack itemStack) {
        this.recipeOutputItemID = itemStack.c;
        this.recipeWidth = n;
        this.recipeHeight = n2;
        this.recipeItems = itemStackArray;
        this.recipeOutput = itemStack;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    @Override
    public boolean matches(C_a c_a) {
        for (int i = 0; i <= 3 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 3 - this.recipeHeight; ++j) {
                if (this.doesItemMatch(c_a, i, j, true)) {
                    return true;
                }
                if (!this.doesItemMatch(c_a, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean doesItemMatch(C_a c_a, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack;
                int n3 = i - n;
                int n4 = j - n2;
                ItemStack itemStack2 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.recipeWidth && n4 < this.recipeHeight) {
                    itemStack2 = bl ? this.recipeItems[this.recipeWidth - n3 - 1 + n4 * this.recipeWidth] : this.recipeItems[n3 + n4 * this.recipeWidth];
                }
                if ((itemStack = c_a.getStackInRowAndColumn(i, j)) == null && itemStack2 == null) continue;
                if (itemStack == null && itemStack2 != null || itemStack != null && itemStack2 == null) {
                    return false;
                }
                if (itemStack2.c != itemStack.c) {
                    return false;
                }
                if (itemStack2.getItemDamage() == -1 || itemStack2.getItemDamage() == itemStack.getItemDamage()) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(C_a c_a) {
        ItemStack itemStack = new ItemStack(this.recipeOutput.c, this.recipeOutput.a, this.recipeOutput.getItemDamage());
        if (this.doesItemContainNBT) {
            for (int i = 0; i < c_a.a(); ++i) {
                ItemStack itemStack2 = c_a.a(i);
                if (itemStack2 == null || !itemStack2.hasTagCompound()) continue;
                itemStack.setTagCompound((NBTTagCompound)itemStack2.stackTagCompound.copy());
            }
        }
        return itemStack;
    }

    @Override
    public int getRecipeSize() {
        return this.recipeWidth * this.recipeHeight;
    }

    public int getRecipeWidth() {
        return this.recipeWidth;
    }

    public int getRecipeHeight() {
        return this.recipeHeight;
    }

    @Override
    public ItemStack[] getRecipeItems() {
        return this.recipeItems;
    }
}

