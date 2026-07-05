/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_p {
    private Object[][] recipeItems = new Object[][]{{Block.l, Block.stairStone}, {Block.aa, Block.stairBrick}, {Block.ad, Block.stairMoss}, {Block.brimStoneBrick, Block.stairBlackBricks}, {Block.moonRockBrick, Block.stairMoonBricks}};
    private Object[][] recipeItemsWithMetadata = new Object[][]{{new ItemStack(Block.m, 1, 0), Block.stairWood}, {new ItemStack(Block.m, 1, 1), Block.stairWoodWhite}, {new ItemStack(Block.m, 1, 2), Block.stairWoodCherry}, {new ItemStack(Block.m, 1, 3), Block.stairWoodBlack}, {new ItemStack(Block.stoneBricks, 1, 0), Block.stairStoneBricks}, {new ItemStack(Block.stoneBricks, 1, 1), Block.stairStoneBricksMossy}, {new ItemStack(Block.sandStone, 1, 0), Block.stairSandstone}, {new ItemStack(Block.sandStone, 1, 2), Block.stairRedSandstone}};

    public final void addRecipes(C_f c_f) {
        Block c_x;
        Object object;
        int n;
        for (n = 0; n < this.recipeItems.length; ++n) {
            object = (Block)this.recipeItems[n][0];
            c_x = (Block)this.recipeItems[n][1];
            c_f.a(new ItemStack(c_x, 8), "#  ", "## ", "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < this.recipeItemsWithMetadata.length; ++n) {
            object = (ItemStack)this.recipeItemsWithMetadata[n][0];
            c_x = (Block)this.recipeItemsWithMetadata[n][1];
            c_f.a(new ItemStack(c_x, 8), "#  ", "## ", "###", Character.valueOf('#'), object);
        }
    }
}

