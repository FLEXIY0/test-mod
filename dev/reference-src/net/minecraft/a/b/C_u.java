/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.furniture.BlockBed;
import util.MathHelper;

public class C_u
extends Item {
    public C_u(int n) {
        super(n);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 != 1) {
            return false;
        }
        ++n2;
        BlockBed blockBed = (BlockBed)C_x.bed;
        int n5 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3;
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
        if (c_g.f(n, n2, n3) == C_c.a && c_g.f(n + n6, n2, n3 + n7) == C_c.a && c_g.b(n, n2 - 1, n3) && c_g.b(n + n6, n2 - 1, n3 + n7) && c_g.a(n, n2 - 1, n3) != C_x.quickSand.at && n + n6 > 0 && n3 + n7 > 0 && n + n6 <= c_g.a - 2 && n3 + n7 <= c_g.b - 2 && n > 0 && n3 > 0 && n <= c_g.a - 2 && n3 <= c_g.b - 2) {
            c_g.setBlockAndMetadataWithNotify(n, n2, n3, blockBed.at, n5);
            c_g.setBlockAndMetadataWithNotify(n + n6, n2, n3 + n7, blockBed.at, n5 + 8);
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            String string = C_x.bed.getStepSound(this.getPlacedBlockMetadata(itemStack.getItemDamage())).b();
            float f4 = (C_x.bed.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).a + 1.0f) / 2.0f;
            c_g.playSoundAtBlock(f, f2, f3, string, f4, C_x.bed.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).b * 0.8f);
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            return true;
        }
        return false;
    }
}

