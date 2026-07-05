/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;

public final class C_d {
    private Object[][] a = new Object[][]{{Block.W, Item.l}, {Block.X, Item.k}, {Block.am, Item.j}, {Block.blockCoal, Item.i}, {Block.blockEmerald, Item.emerald}, {Block.blockAdminium, Item.ingotAdminium}, {Block.slimeBlock, Item.slimeBall}, {Block.hayBlock, Item.P}, {Block.bone, Item.bone}};

    public final void a(CraftingManager c_f) {
        for (int i = 0; i < this.a.length; ++i) {
            Block c_x = (Block)this.a[i][0];
            Item item = (Item)this.a[i][1];
            c_f.a(new ItemStack(c_x), "###", "###", "###", Character.valueOf('#'), item);
            c_f.a(new ItemStack(item, 9), "#", Character.valueOf('#'), c_x);
        }
    }
}

