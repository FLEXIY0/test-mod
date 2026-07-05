/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;

public final class C_q {
    private Object[][] recipeItems = new Object[][]{{Block.i, new ItemStack(Block.Z, 6, 0)}, {Block.aa, new ItemStack(Block.Z, 6, 1)}, {Block.l, new ItemStack(Block.Z, 6, 2)}, {Block.ad, new ItemStack(Block.Z, 6, 3)}, {Block.brimStoneBrick, new ItemStack(Block.Z, 6, 8)}, {Block.moonRockBrick, new ItemStack(Block.Z, 6, 11)}};

    public final void addRecipes(CraftingManager c_f) {
        ItemStack itemStack;
        Object object;
        int n;
        for (n = 0; n < this.recipeItems.length; ++n) {
            object = (Block)this.recipeItems[n][0];
            itemStack = (ItemStack)this.recipeItems[n][1];
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < 16; ++n) {
            object = new ItemStack(Block.cloth, 1, n);
            itemStack = new ItemStack(Block.carpet, 6, n);
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        for (n = 0; n <= Block.stairSingleWood.getMaxDamage(); ++n) {
            object = new ItemStack(Block.m, 1, n);
            itemStack = new ItemStack(Block.stairSingleWood, 6, n);
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        c_f.a(new ItemStack(Block.Z, 6, 5), "###", Character.valueOf('#'), new ItemStack(Block.stoneBricks, 1, 0));
        c_f.a(new ItemStack(Block.Z, 6, 6), "###", Character.valueOf('#'), new ItemStack(Block.stoneBricks, 1, 1));
        c_f.a(new ItemStack(Block.Z, 6, 4), "###", Character.valueOf('#'), new ItemStack(Block.sandStone, 1, 0));
        c_f.a(new ItemStack(Block.Z, 6, 7), "###", Character.valueOf('#'), new ItemStack(Block.sandStone, 1, 1));
        c_f.a(new ItemStack(Block.Z, 6, 9), "###", Character.valueOf('#'), new ItemStack(Block.sandStone, 1, 2));
        c_f.a(new ItemStack(Block.Z, 6, 10), "###", Character.valueOf('#'), new ItemStack(Block.sandStone, 1, 3));
        c_f.a(new ItemStack(Block.snowLayer, 3), "###", Character.valueOf('#'), new ItemStack(Item.snowball, 1));
        c_f.a(new ItemStack(Block.sandLayer, 3), "###", Character.valueOf('#'), new ItemStack(Item.sandball, 1));
        c_f.a(new ItemStack(Block.ash, 3), "###", Character.valueOf('#'), new ItemStack(Item.ash, 1));
        c_f.a(new ItemStack(Block.leafPile, 6), "###", Character.valueOf('#'), new ItemStack(Block.z, 1, 0));
    }
}

