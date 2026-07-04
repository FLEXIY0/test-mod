/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_d {
    private Object[][] a = new Object[][]{{C_x.W, Item.l}, {C_x.X, Item.k}, {C_x.am, Item.j}, {C_x.blockCoal, Item.i}, {C_x.blockEmerald, Item.emerald}, {C_x.blockAdminium, Item.ingotAdminium}, {C_x.slimeBlock, Item.slimeBall}, {C_x.hayBlock, Item.P}, {C_x.bone, Item.bone}};

    public final void a(C_f c_f) {
        for (int i = 0; i < this.a.length; ++i) {
            C_x c_x = (C_x)this.a[i][0];
            Item item = (Item)this.a[i][1];
            c_f.a(new ItemStack(c_x), "###", "###", "###", Character.valueOf('#'), item);
            c_f.a(new ItemStack(item, 9), "#", Character.valueOf('#'), c_x);
        }
    }
}

