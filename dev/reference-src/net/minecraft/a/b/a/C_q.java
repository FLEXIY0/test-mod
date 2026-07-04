/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_q {
    private Object[][] recipeItems = new Object[][]{{C_x.i, new ItemStack(C_x.Z, 6, 0)}, {C_x.aa, new ItemStack(C_x.Z, 6, 1)}, {C_x.l, new ItemStack(C_x.Z, 6, 2)}, {C_x.ad, new ItemStack(C_x.Z, 6, 3)}, {C_x.brimStoneBrick, new ItemStack(C_x.Z, 6, 8)}, {C_x.moonRockBrick, new ItemStack(C_x.Z, 6, 11)}};

    public final void addRecipes(C_f c_f) {
        ItemStack itemStack;
        Object object;
        int n;
        for (n = 0; n < this.recipeItems.length; ++n) {
            object = (C_x)this.recipeItems[n][0];
            itemStack = (ItemStack)this.recipeItems[n][1];
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        for (n = 0; n < 16; ++n) {
            object = new ItemStack(C_x.cloth, 1, n);
            itemStack = new ItemStack(C_x.carpet, 6, n);
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        for (n = 0; n <= C_x.stairSingleWood.getMaxDamage(); ++n) {
            object = new ItemStack(C_x.m, 1, n);
            itemStack = new ItemStack(C_x.stairSingleWood, 6, n);
            c_f.a(itemStack, "###", Character.valueOf('#'), object);
        }
        c_f.a(new ItemStack(C_x.Z, 6, 5), "###", Character.valueOf('#'), new ItemStack(C_x.stoneBricks, 1, 0));
        c_f.a(new ItemStack(C_x.Z, 6, 6), "###", Character.valueOf('#'), new ItemStack(C_x.stoneBricks, 1, 1));
        c_f.a(new ItemStack(C_x.Z, 6, 4), "###", Character.valueOf('#'), new ItemStack(C_x.sandStone, 1, 0));
        c_f.a(new ItemStack(C_x.Z, 6, 7), "###", Character.valueOf('#'), new ItemStack(C_x.sandStone, 1, 1));
        c_f.a(new ItemStack(C_x.Z, 6, 9), "###", Character.valueOf('#'), new ItemStack(C_x.sandStone, 1, 2));
        c_f.a(new ItemStack(C_x.Z, 6, 10), "###", Character.valueOf('#'), new ItemStack(C_x.sandStone, 1, 3));
        c_f.a(new ItemStack(C_x.snowLayer, 3), "###", Character.valueOf('#'), new ItemStack(Item.snowball, 1));
        c_f.a(new ItemStack(C_x.sandLayer, 3), "###", Character.valueOf('#'), new ItemStack(Item.sandball, 1));
        c_f.a(new ItemStack(C_x.ash, 3), "###", Character.valueOf('#'), new ItemStack(Item.ash, 1));
        c_f.a(new ItemStack(C_x.leafPile, 6), "###", Character.valueOf('#'), new ItemStack(C_x.z, 1, 0));
    }
}

