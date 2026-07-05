/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_l;
import net.minecraft.client.c.a.C_a;

public class C_s
implements C_l {
    private final ItemStack recipeOutput;
    private final List<ItemStack> recipeItems;
    private final ItemStack[] recipeReusedArray;

    public C_s(ItemStack itemStack, List<ItemStack> list) {
        this.recipeOutput = itemStack;
        this.recipeItems = list;
        this.recipeReusedArray = new ItemStack[list.size()];
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    @Override
    public boolean matches(C_a c_a) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>(this.recipeItems);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = c_a.getStackInRowAndColumn(j, i);
                if (itemStack == null) continue;
                boolean bl = false;
                for (ItemStack itemStack2 : arrayList) {
                    if (itemStack.c != itemStack2.c || itemStack2.getItemDamage() != -1 && itemStack.getItemDamage() != itemStack2.getItemDamage()) continue;
                    bl = true;
                    arrayList.remove(itemStack2);
                    break;
                }
                if (bl) continue;
                return false;
            }
        }
        return arrayList.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(C_a c_a) {
        return this.recipeOutput.copy();
    }

    @Override
    public int getRecipeSize() {
        return this.recipeItems.size();
    }

    @Override
    public ItemStack[] getRecipeItems() {
        return this.recipeItems.toArray(this.recipeReusedArray);
    }
}

