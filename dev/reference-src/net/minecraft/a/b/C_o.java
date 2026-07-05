/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.C_be;

public final class C_o
extends Item {
    public C_o(int n) {
        super(n);
        this.setMaxDamage(0);
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 0 || n4 == 1 || c_g.multiplayerWorld) {
            return false;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            byte by = 0;
            if (n4 == 4) {
                by = 1;
            }
            if (n4 == 3) {
                by = 2;
            }
            if (n4 == 5) {
                by = 3;
            }
            if (new C_a(c_g, n, n2, n3, by, itemStack.getItemDamage()).c()) {
                c_g.mc.a(new C_be(n, n2, n3, by));
            }
            return true;
        }
        return false;
    }
}

