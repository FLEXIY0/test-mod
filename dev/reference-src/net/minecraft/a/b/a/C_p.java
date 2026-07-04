/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_p {
    private Object[][] recipeItems = new Object[][]{{C_x.l, C_x.stairStone}, {C_x.aa, C_x.stairBrick}, {C_x.ad, C_x.stairMoss}, {C_x.brimStoneBrick, C_x.stairBlackBricks}, {C_x.moonRockBrick, C_x.stairMoonBricks}};
    private Object[][] recipeItemsWithMetadata = new Object[][]{{new ItemStack(C_x.m, 1, 0), C_x.stairWood}, {new ItemStack(C_x.m, 1, 1), C_x.stairWoodWhite}, {new ItemStack(C_x.m, 1, 2), C_x.stairWoodCherry}, {new ItemStack(C_x.m, 1, 3), C_x.stairWoodBlack}, {new ItemStack(C_x.stoneBricks, 1, 0), C_x.stairStoneBricks}, {new ItemStack(C_x.stoneBricks, 1, 1), C_x.stairStoneBricksMossy}, {new ItemStack(C_x.sandStone, 1, 0), C_x.stairSandstone}, {new ItemStack(C_x.sandStone, 1, 2), C_x.stairRedSandstone}};

    public final void addRecipes(C_f c_f) {
        C_x c_x;
        Object object;
        int n;
        for (n = 0; n < this.recipeItems.length; ++n) {
            object = (C_x)this.recipeItems[n][0];
            c_x = (C_x)this.recipeItems[n][1];
            c_f.a(new ItemStack(c_x, 8), "#  ", "## ", "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < this.recipeItemsWithMetadata.length; ++n) {
            object = (ItemStack)this.recipeItemsWithMetadata[n][0];
            c_x = (C_x)this.recipeItemsWithMetadata[n][1];
            c_f.a(new ItemStack(c_x, 8), "#  ", "## ", "###", Character.valueOf('#'), object);
        }
    }
}

