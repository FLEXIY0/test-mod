/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;

public class C_o {
    private Object[][] recipeRecords = new Object[][]{{Item.l, new ItemStack(Item.recordGold)}, {Item.k, new ItemStack(Item.recordWhite)}, {Item.i, new ItemStack(Item.recordBlack)}, {Item.emerald, new ItemStack(Item.recordGreen)}, {Item.j, new ItemStack(Item.recordBlue)}, {Item.antlionExtract, new ItemStack(Item.recordOrange)}, {Item.fireBall, new ItemStack(Item.recordRed)}, {Item.fishFin, new ItemStack(Item.recordAqua)}, {Item.harpyFeather, new ItemStack(Item.recordPurple)}, {Item.eye, new ItemStack(Item.recordSpecial)}};

    public final void addRecipes(CraftingManager c_f) {
        for (int i = 0; i < this.recipeRecords.length; ++i) {
            Item item = (Item)this.recipeRecords[i][0];
            ItemStack itemStack = (ItemStack)this.recipeRecords[i][1];
            c_f.a(itemStack, " X ", "XYX", " X ", Character.valueOf('Y'), item, Character.valueOf('X'), Item.ingotAdminium);
        }
    }
}

