/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import java.util.Comparator;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.a.b.a.C_l;
import net.minecraft.a.b.a.C_r;
import net.minecraft.a.b.a.C_s;

class C_i
implements Comparator<Object> {
    final CraftingManager craftingManager;

    C_i(CraftingManager c_f) {
        this.craftingManager = c_f;
    }

    public int compareRecipes(C_l c_l, C_l c_l2) {
        return c_l instanceof C_s && c_l2 instanceof C_r ? 1 : (c_l2 instanceof C_s && c_l instanceof C_r ? -1 : (c_l2.getRecipeSize() < c_l.getRecipeSize() ? -1 : (c_l2.getRecipeSize() > c_l.getRecipeSize() ? 1 : 0)));
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.compareRecipes((C_l)object, (C_l)object2);
    }
}

