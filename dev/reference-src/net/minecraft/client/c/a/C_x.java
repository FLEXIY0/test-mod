/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.C_b;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.c.a.C_g;

public final class C_x
extends C_g {
    public C_x(C_b c_b, int n, int n2, int n3) {
        super(c_b, n, n2, n3);
    }

    @Override
    public final boolean a(ItemStack itemStack) {
        if (this.d.a(43) != null && this.d.a(43).a() == Item.quiver) {
            return itemStack.a().ap == Item.h.ap || itemStack.a().ap == Item.arrowAdminium.ap || itemStack.a().ap == Item.dart.ap || itemStack.a().ap == Item.dartPoison.ap;
        }
        return false;
    }

    @Override
    public final int b() {
        return 95;
    }
}

