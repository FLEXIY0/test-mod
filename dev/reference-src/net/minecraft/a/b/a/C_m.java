/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public class C_m {
    private Object[][] recipeWalls = new Object[][]{{C_x.l, new ItemStack(C_x.wall, 6, 0)}, {C_x.ad, new ItemStack(C_x.wall, 6, 1)}, {C_x.aa, new ItemStack(C_x.wall, 6, 2)}, {C_x.brimStoneBrick, new ItemStack(C_x.wall, 6, 6)}, {C_x.moonRock, new ItemStack(C_x.wall, 6, 8)}, {C_x.brimStone, new ItemStack(C_x.wall, 6, 9)}};
    private Object[][] recipeWallsMetadata = new Object[][]{{new ItemStack(C_x.stoneBricks, 1, 0), new ItemStack(C_x.wall, 6, 4)}, {new ItemStack(C_x.stoneBricks, 1, 1), new ItemStack(C_x.wall, 6, 5)}, {new ItemStack(C_x.sandStone, 1, 0), new ItemStack(C_x.wall, 6, 3)}, {new ItemStack(C_x.sandStone, 1, 2), new ItemStack(C_x.wall, 6, 7)}};
    private Object[][] recipeFences = new Object[][]{{new ItemStack(C_x.m, 1, 0), new ItemStack(C_x.fence, 4, 0)}, {new ItemStack(C_x.m, 1, 1), new ItemStack(C_x.fence, 4, 1)}, {new ItemStack(C_x.m, 1, 2), new ItemStack(C_x.fence, 4, 2)}, {new ItemStack(C_x.m, 1, 3), new ItemStack(C_x.fence, 4, 3)}};
    private Object[][] recipeFenceGates = new Object[][]{{new ItemStack(C_x.m, 1, 0), new ItemStack(C_x.fenceGateOak)}, {new ItemStack(C_x.m, 1, 1), new ItemStack(C_x.fenceGateBirch)}, {new ItemStack(C_x.m, 1, 2), new ItemStack(C_x.fenceGatePalm)}, {new ItemStack(C_x.m, 1, 3), new ItemStack(C_x.fenceGateSpruce)}};

    public final void addRecipes(C_f c_f) {
        ItemStack itemStack;
        Object object;
        int n;
        for (n = 0; n < this.recipeWalls.length; ++n) {
            object = (C_x)this.recipeWalls[n][0];
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

