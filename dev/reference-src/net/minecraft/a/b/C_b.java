/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.C_p;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_b
extends C_p {
    public C_b(int n, int n2) {
        super(n, n2);
    }

    @Override
    public final ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        super.a(itemStack, c_g, entityPlayer);
        if (this.ap == Item.bowlGlowSoup.ap) {
            entityPlayer.nightVision = true;
            entityPlayer.nightVisionTimer = 1200;
            c_g.mc.e.a();
        }
        entityPlayer.b.d().c = Item.A.ap;
        return new ItemStack(Item.A);
    }
}

