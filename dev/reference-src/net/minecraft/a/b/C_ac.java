/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.b.C_bd;
import net.minecraft.a.b.ItemStack;

public class C_ac
extends C_bd {
    public C_ac(int n) {
        super(n);
        this.ar = 0;
        this.setHasSubtypes(true);
    }

    @Override
    public int getIconFromDamage(int n) {
        return n == 1 ? 38 : 7;
    }

    @Override
    public String getItemName(ItemStack itemStack) {
        return itemStack.getItemDamage() == 1 ? "Charcoal" : "Coal";
    }

    @Override
    public String getItemName(int n) {
        return n == 1 ? "Charcoal" : "Coal";
    }

    @Override
    public int getSubtypes() {
        return 1;
    }
}

