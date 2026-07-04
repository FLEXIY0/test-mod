/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_bc
extends Item {
    private int ID;

    public C_bc(int n, C_x c_x) {
        super(n);
        this.ID = c_x.at;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (itemStack.a == 0) {
            return false;
        }
        C_x c_x = C_x.c[this.ID];
        if (c_x.a(c_g, n, n2, n3) && c_g.b(n, n2, n3, this.ID)) {
            c_x.g(c_g, n, n2, n3, n4);
            String string = c_x.getStepSound(this.getPlacedBlockMetadata(itemStack.getItemDamage())).b();
            c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, string, (c_x.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).a + 1.0f) / 2.0f, c_x.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).b * 0.8f);
            if (entityPlayer.gamemode == 0) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        return true;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

