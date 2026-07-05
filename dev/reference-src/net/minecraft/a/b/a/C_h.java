/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_h {
    private String[][] a = new String[][]{{"X", "X", "#"}, {"X  ", " # ", "  #"}};
    private Object[][] b = new Object[][]{{C_x.m, C_x.l, Item.k, Item.j, Item.l, Item.emerald}, {Item.n, Item.r, Item.m, Item.v, Item.C, Item.swordEmerald}, {Item.spearWood, Item.spearStone, Item.spearSteel, Item.spearDiamond, Item.spearGold, Item.spearEmerald}};

    public final void a(C_f c_f) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];
            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item)this.b[j + 1][i];
                c_f.a(new ItemStack(item), this.a[j], Character.valueOf('#'), Item.z, Character.valueOf('X'), object);
            }
        }
        c_f.a(new ItemStack(Item.g, 1), " #X", "# X", " #X", Character.valueOf('X'), Item.G, Character.valueOf('#'), Item.z);
        c_f.a(new ItemStack(Item.h, 4), "X", "#", "Y", Character.valueOf('Y'), Item.H, Character.valueOf('X'), Item.k, Character.valueOf('#'), Item.z);
        c_f.a(new ItemStack(Item.arrowAdminium, 8), "X", "#", "Y", Character.valueOf('Y'), Item.H, Character.valueOf('X'), Item.ingotAdminium, Character.valueOf('#'), Item.z);
        c_f.a(new ItemStack(Item.dart, 4), "X", "#", "Y", Character.valueOf('Y'), Item.H, Character.valueOf('X'), Item.l, Character.valueOf('#'), Item.z);
        c_f.a(new ItemStack(Item.dartPoison, 8), "X", "#", "Y", Character.valueOf('Y'), Item.H, Character.valueOf('X'), Item.eye, Character.valueOf('#'), Item.z);
        c_f.a(new ItemStack(Item.dartShooter, 1), "#", "#", "X", Character.valueOf('X'), Item.emerald, Character.valueOf('#'), C_x.m);
        c_f.a(new ItemStack(Item.crossbow, 1), "#Y#", "XXX", " # ", Character.valueOf('X'), Item.G, Character.valueOf('#'), Item.z, Character.valueOf('Y'), Item.k);
    }
}

