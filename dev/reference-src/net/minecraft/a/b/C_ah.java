/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_ah
extends Item {
    Block door;

    protected C_ah(int n, Block c_x) {
        super(n);
        this.door = c_x;
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (n4 != 1) {
            return false;
        }
        Block c_x = this.door;
        if (!c_x.a(c_g, n, ++n2, n3)) {
            return false;
        }
        int n5 = MathHelper.a((double)((entityPlayer.n + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
        int n6 = 0;
        int n7 = 0;
        if (n5 == 0) {
            n7 = 1;
        }
        if (n5 == 1) {
            n6 = -1;
        }
        if (n5 == 2) {
            n7 = -1;
        }
        if (n5 == 3) {
            n6 = 1;
        }
        int n8 = (c_g.b(n - n6, n2, n3 - n7) ? 1 : 0) + (c_g.b(n - n6, n2 + 1, n3 - n7) ? 1 : 0);
        int n9 = (c_g.b(n + n6, n2, n3 + n7) ? 1 : 0) + (c_g.b(n + n6, n2 + 1, n3 + n7) ? 1 : 0);
        boolean bl = c_g.a(n - n6, n2, n3 - n7) == c_x.at || c_g.a(n - n6, n2 + 1, n3 - n7) == c_x.at;
        boolean bl2 = c_g.a(n + n6, n2, n3 + n7) == c_x.at || c_g.a(n + n6, n2 + 1, n3 + n7) == c_x.at;
        boolean bl3 = false;
        if (bl && !bl2) {
            bl3 = true;
        } else if (n9 > n8) {
            bl3 = true;
        }
        if (bl3) {
            n5 = n5 - 1 & 3;
            n5 += 4;
        }
        c_g.setBlockAndMetadataWithNotify(n, n2, n3, c_x.at, n5);
        c_g.setBlockAndMetadataWithNotify(n, n2 + 1, n3, c_x.at, n5 + 8);
        c_g.c(n, n2, n3, c_x.at);
        c_g.c(n, n2 + 1, n3, c_x.at);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + 0.5f;
        float f3 = (float)n3 + 0.5f;
        String string = this.door.getStepSound(this.getPlacedBlockMetadata(itemStack.getItemDamage())).b();
        float f4 = (this.door.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).a + 1.0f) / 2.0f;
        c_g.playSoundAtBlock(f, f2, f3, string, f4, this.door.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).b * 0.8f);
        if (entityPlayer.gamemode != 1) {
            --itemStack.a;
        }
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        return true;
    }
}

