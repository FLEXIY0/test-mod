/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_bh
extends Item {
    private int signType = 0;

    public C_bh(int n, int n2) {
        super(n);
        this.ar = 64;
        this.aq = 64;
        this.signType = n2;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2, n3).a()) {
            return false;
        }
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
        Block c_x = Block.signStanding;
        Block c_x2 = Block.signHanging;
        Block c_x3 = Block.signWall;
        switch (this.signType) {
            case 1: {
                c_x = Block.signBirchStanding;
                c_x2 = Block.signBirchHanging;
                c_x3 = Block.signBirchWall;
                break;
            }
            case 2: {
                c_x = Block.signPalmStanding;
                c_x2 = Block.signPalmHanging;
                c_x3 = Block.signPalmWall;
                break;
            }
            case 3: {
                c_x = Block.signDarkStanding;
                c_x2 = Block.signDarkHanging;
                c_x3 = Block.signDarkWall;
                break;
            }
            default: {
                c_x = Block.signStanding;
                c_x2 = Block.signHanging;
                c_x3 = Block.signWall;
            }
        }
        if (!c_x.a(c_g, n, n2, n3) || !c_x2.a(c_g, n, n2, n3)) {
            return false;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a && n2 < c_g.c && n3 < c_g.b) {
            boolean bl = false;
            bl = n4 == 1 ? (bl |= c_g.setBlockAndMetadata(n, n2, n3, c_x.at, MathHelper.d((entityPlayer.n + 180.0f) * 16.0f / 360.0f + 0.5f) & 0xF)) : (n4 == 0 ? (bl |= c_g.setBlockAndMetadata(n, n2, n3, c_x2.at, MathHelper.d((entityPlayer.n + 180.0f) * 16.0f / 360.0f + 0.5f) & 0xF)) : (bl |= c_g.setBlockAndMetadata(n, n2, n3, c_x3.at, n4)));
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            if (bl) {
                C_l c_l;
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
                if ((c_l = (C_l)c_g.j(n, n2, n3)) != null) {
                    entityPlayer.displayGUIEditSign(c_l);
                }
                return true;
            }
        }
        return false;
    }
}

