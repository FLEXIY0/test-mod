/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.C_aa;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.c.a.C_g;

public final class C_v
extends C_g {
    public C_v(C_b c_b, int n, int n2, int n3) {
        super(c_b, n, n2, n3);
    }

    @Override
    public final boolean a(ItemStack itemStack) {
        return itemStack.a() instanceof C_aa && itemStack.a() != Item.bootsHermes || itemStack.a() instanceof C_ba;
    }

    @Override
    public final int b() {
        return 79;
    }
}

