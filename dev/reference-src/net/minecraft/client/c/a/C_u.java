/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.c.a.C_g;

public class C_u
extends C_g {
    public C_u(C_b c_b, int n, int n2, int n3) {
        super(c_b, n, n2, n3);
    }

    @Override
    public boolean a(ItemStack itemStack) {
        Item item = itemStack.a();
        return item == Item.book || item == Item.bookAndQuill || item == Item.writtenBook;
    }
}

