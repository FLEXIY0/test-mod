/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.b.ItemStack;
import net.minecraft.client.c.a.C_a;

public interface C_l {
    public boolean matches(C_a var1);

    public ItemStack getCraftingResult(C_a var1);

    public int getRecipeSize();

    public ItemStack getRecipeOutput();

    public ItemStack[] getRecipeItems();
}

