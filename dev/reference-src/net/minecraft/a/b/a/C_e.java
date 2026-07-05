/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;

public final class C_e {
    private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}, {"XXX", "X#X", " # "}};
    private Object[][] b = new Object[][]{{Block.m, Block.l, Item.k, Item.j, Item.l, Item.emerald}, {Item.p, Item.t, Item.d, Item.x, Item.E, Item.pickaxeEmerald}, {Item.o, Item.s, Item.c, Item.w, Item.D, Item.shovelEmerald}, {Item.q, Item.u, Item.e, Item.y, Item.F, Item.axeEmerald}, {Item.J, Item.K, Item.L, Item.M, Item.N, Item.hoeEmerald}, {Item.battleAxeWood, Item.battleAxeStone, Item.battleAxeIron, Item.battleAxeDiamond, Item.battleAxeGold, Item.battleAxeEmerald}};

    public final void a(CraftingManager c_f) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];
            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item)this.b[j + 1][i];
                c_f.a(new ItemStack(item), this.a[j], Character.valueOf('#'), Item.z, Character.valueOf('X'), object);
            }
        }
    }
}

