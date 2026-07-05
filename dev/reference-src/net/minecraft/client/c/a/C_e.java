/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.c.a.C_g;

public final class C_e
extends C_g {
    private int e;

    public C_e(net.minecraft.a.C_j c_j, C_b c_b, int n, int n2, int n3, int n4) {
        super(c_b, n, 8, n3);
        this.e = n4;
    }

    @Override
    public final boolean a(ItemStack itemStack) {
        if (itemStack.a() == Item.bootsHermes) {
            return true;
        }
        return itemStack.a() instanceof C_j ? ((C_j)itemStack.a()).as == this.e : false;
    }

    @Override
    public final int b() {
        return 15 + (this.e << 4);
    }
}

