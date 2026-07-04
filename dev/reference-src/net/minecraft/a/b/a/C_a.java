/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;

public final class C_a {
    private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] b = new Object[][]{{C_x.cloth, Item.k, Item.j, Item.l, Item.emerald, Item.leather, Item.chainmail}, {Item.R, Item.Z, Item.ad, Item.ah, Item.helmetEmerald, Item.helmetStudded, Item.V}, {Item.S, Item.aa, Item.ae, Item.ai, Item.plateEmerald, Item.plateStudded, Item.W}, {Item.T, Item.ab, Item.af, Item.aj, Item.legsEmerald, Item.legsStudded, Item.X}, {Item.U, Item.ac, Item.ag, Item.ak, Item.bootsEmerald, Item.bootsStudded, Item.Y}};

    public final void a(C_f c_f) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];
            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item)this.b[j + 1][i];
                c_f.a(new ItemStack(item), this.a[j], Character.valueOf('X'), object);
            }
        }
    }
}

