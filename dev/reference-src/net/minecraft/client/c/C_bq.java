/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.C_bn;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.statistics.SorterStatsItem;
import net.minecraft.client.statistics.StatCrafting;
import net.minecraft.client.statistics.StatList;

public class C_bq
extends C_bn {
    public final C_bs slotGuiStats;

    public C_bq(C_bs c_bs) {
        super(c_bs);
        this.slotGuiStats = c_bs;
        this.fullStatsList = new ArrayList();
        for (StatCrafting statCrafting : StatList.itemStats) {
            boolean bl = false;
            int n = statCrafting.getItemID();
            if (C_bs.getStatsFileWriter(c_bs).getStatCount(statCrafting) > 0) {
                bl = true;
            } else if (StatList.objectBreakStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectBreakStats[n]) > 0) {
                bl = true;
            } else if (StatList.objectCraftStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectCraftStats[n]) > 0) {
                bl = true;
            } else if (StatList.objectObtainStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectObtainStats[n]) > 0) {
                bl = true;
            } else if (StatList.objectDisposeStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectDisposeStats[n]) > 0) {
                bl = true;
            }
            if (!bl) continue;
            this.fullStatsList.add(statCrafting);
        }
        this.statsComparator = new SorterStatsItem(this, c_bs);
    }

    @Override
    protected void onInteraction(int n, int n2, C_d c_d) {
        super.onInteraction(n, n2, c_d);
        if (this.selectedItemStat == 0) {
            C_bs.drawSprite(this.slotGuiStats, n + 55 - 18 + 1, n2 + 1 + 1, 72, 18);
        } else {
            C_bs.drawSprite(this.slotGuiStats, n + 55 - 18, n2 + 1, 72, 18);
        }
        if (this.selectedItemStat == 1) {
            C_bs.drawSprite(this.slotGuiStats, n + 95 - 18 + 1, n2 + 1 + 1, 18, 18);
        } else {
            C_bs.drawSprite(this.slotGuiStats, n + 95 - 18, n2 + 1, 18, 18);
        }
        if (this.selectedItemStat == 2) {
            C_bs.drawSprite(this.slotGuiStats, n + 135 - 18 + 1, n2 + 1 + 1, 36, 18);
        } else {
            C_bs.drawSprite(this.slotGuiStats, n + 135 - 18, n2 + 1, 36, 18);
        }
        if (this.selectedItemStat == 3) {
            C_bs.drawSprite(this.slotGuiStats, n + 175 - 18 + 1, n2 + 1 + 1, 0, 36);
        } else {
            C_bs.drawSprite(this.slotGuiStats, n + 175 - 18, n2 + 1, 0, 36);
        }
        if (this.selectedItemStat == 4) {
            C_bs.drawSprite(this.slotGuiStats, n + 215 - 18 + 1, n2 + 1 + 1, 18, 36);
        } else {
            C_bs.drawSprite(this.slotGuiStats, n + 215 - 18, n2 + 1, 18, 36);
        }
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        StatCrafting statCrafting = this.getStat(n);
        int n5 = statCrafting.getItemID();
        C_bs.drawItemSprite(this.slotGuiStats, n2, n3, n5);
        this.displayStatString((StatCrafting)StatList.objectBreakStats[n5], n2 + 55, n3, n % 2 == 0);
        this.displayStatString((StatCrafting)StatList.objectCraftStats[n5], n2 + 95, n3, n % 2 == 0);
        this.displayStatString(statCrafting, n2 + 135, n3, n % 2 == 0);
        this.displayStatString((StatCrafting)StatList.objectObtainStats[n5], n2 + 175, n3, n % 2 == 0);
        this.displayStatString((StatCrafting)StatList.objectDisposeStats[n5], n2 + 215, n3, n % 2 == 0);
    }

    @Override
    protected String getStatName(int n) {
        return n == 1 ? "Times Crafted" : (n == 2 ? "Times Used" : (n == 3 ? "Times Collected" : (n == 4 ? "Times Dropped" : "Times Broken")));
    }
}

