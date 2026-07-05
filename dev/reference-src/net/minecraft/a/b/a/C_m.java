/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;

public class C_m {
    private Object[][] recipeWalls = new Object[][]{{Block.l, new ItemStack(Block.wall, 6, 0)}, {Block.ad, new ItemStack(Block.wall, 6, 1)}, {Block.aa, new ItemStack(Block.wall, 6, 2)}, {Block.brimStoneBrick, new ItemStack(Block.wall, 6, 6)}, {Block.moonRock, new ItemStack(Block.wall, 6, 8)}, {Block.brimStone, new ItemStack(Block.wall, 6, 9)}};
    private Object[][] recipeWallsMetadata = new Object[][]{{new ItemStack(Block.stoneBricks, 1, 0), new ItemStack(Block.wall, 6, 4)}, {new ItemStack(Block.stoneBricks, 1, 1), new ItemStack(Block.wall, 6, 5)}, {new ItemStack(Block.sandStone, 1, 0), new ItemStack(Block.wall, 6, 3)}, {new ItemStack(Block.sandStone, 1, 2), new ItemStack(Block.wall, 6, 7)}};
    private Object[][] recipeFences = new Object[][]{{new ItemStack(Block.m, 1, 0), new ItemStack(Block.fence, 4, 0)}, {new ItemStack(Block.m, 1, 1), new ItemStack(Block.fence, 4, 1)}, {new ItemStack(Block.m, 1, 2), new ItemStack(Block.fence, 4, 2)}, {new ItemStack(Block.m, 1, 3), new ItemStack(Block.fence, 4, 3)}};
    private Object[][] recipeFenceGates = new Object[][]{{new ItemStack(Block.m, 1, 0), new ItemStack(Block.fenceGateOak)}, {new ItemStack(Block.m, 1, 1), new ItemStack(Block.fenceGateBirch)}, {new ItemStack(Block.m, 1, 2), new ItemStack(Block.fenceGatePalm)}, {new ItemStack(Block.m, 1, 3), new ItemStack(Block.fenceGateSpruce)}};

    public final void addRecipes(CraftingManager c_f) {
        ItemStack itemStack;
        Object object;
        int n;
        for (n = 0; n < this.recipeWalls.length; ++n) {
            object = (Block)this.recipeWalls[n][0];
            itemStack = (ItemStack)this.recipeWalls[n][1];
            c_f.a(itemStack, "###", "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < this.recipeWallsMetadata.length; ++n) {
            object = (ItemStack)this.recipeWallsMetadata[n][0];
            itemStack = (ItemStack)this.recipeWallsMetadata[n][1];
            c_f.a(itemStack, "###", "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < this.recipeFences.length; ++n) {
            object = (ItemStack)this.recipeFences[n][0];
            itemStack = (ItemStack)this.recipeFences[n][1];
            c_f.a(itemStack, "#X#", "#X#", Character.valueOf('#'), object, Character.valueOf('X'), Item.z);
        }
        for (n = 0; n < this.recipeFenceGates.length; ++n) {
            object = (ItemStack)this.recipeFenceGates[n][0];
            itemStack = (ItemStack)this.recipeFenceGates[n][1];
            c_f.a(itemStack, "X#X", "X#X", Character.valueOf('#'), object, Character.valueOf('X'), Item.z);
        }
    }
}

