/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_ao;
import net.minecraft.a.a.b.C_bo;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public class C_n {
    public void addRecipes(C_f c_f) {
        for (int i = 0; i < 16; ++i) {
            c_f.addShapelessRecipe(new ItemStack(C_x.cloth, 1, C_ao.getClothColor(i)), new ItemStack(Item.dyePowder, 1, i), new ItemStack(Item.b[C_x.cloth.at], 1, 0));
            c_f.addShapelessRecipe(new ItemStack(C_x.carpet, 1, C_am.getClothColor(i)), new ItemStack(Item.dyePowder, 1, i), new ItemStack(Item.b[C_x.carpet.at], 1, 0));
            c_f.addShapelessRecipe(new ItemStack(C_x.glassStained, 1, C_bo.getGlassColor(i)), new ItemStack(Item.dyePowder, 1, i), new ItemStack(Item.b[C_x.B.at], 1, 0));
            c_f.addShapelessRecipe(new ItemStack(C_x.cloth, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.b[C_x.cloth.at], 1, i));
            c_f.addShapelessRecipe(new ItemStack(C_x.carpet, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.b[C_x.carpet.at], 1, i));
            c_f.addShapelessRecipe(new ItemStack(C_x.glassStained, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Item.b[C_x.glassStained.at], 1, i));
        }
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 0), C_x.plantRed);
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 1), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Item.dyePowder, 1, 2));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 2), C_x.plantYellow);
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 3), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 2));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 4), Item.reed);
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 5), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 6));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 6), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.dyePowder, 1, 7));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 7), C_x.plantBlue);
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 8), new ItemStack(Item.dyePowder, 1, 9), new ItemStack(Item.dyePowder, 1, 7));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 9), C_x.plantPurple);
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 10), new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Item.dyePowder, 1, 0));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 11), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Item.dyePowder, 1, 15));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 12), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.dyePowder, 1, 0));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 13), new ItemStack(Item.i), new ItemStack(Item.dyePowder, 1, 15));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 14), new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Item.dyePowder, 1, 15));
        c_f.addShapelessRecipe(new ItemStack(Item.dyePowder, 3, 15), Item.bone);
        c_f.addShapelessRecipe(new ItemStack(Item.fertilizer), Item.ash, new ItemStack(Item.dyePowder, 3, 15));
    }
}

