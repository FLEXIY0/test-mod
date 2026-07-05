/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockJukeBox;

public class C_bb
extends Item {
    public final String recordName;

    protected C_bb(int n, String string) {
        super(n);
        this.recordName = string;
        this.aq = 1;
        this.desc[1] = string;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        if (c_g.a(n, n2, n3) == Block.jukeBox.at && c_g.e(n, n2, n3) == 0) {
            if (c_g.multiplayerWorld) {
                return true;
            }
            ((BlockJukeBox)Block.jukeBox).ejectRecord(c_g, n, n2, n3, this.ap);
            c_g.playRecord(this.recordName, n, n2, n3);
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.triggerAchievement(AchievementList.buildJukebox);
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            entityPlayer.addStat(StatList.jukeboxUse, 1);
            return true;
        }
        return false;
    }
}

