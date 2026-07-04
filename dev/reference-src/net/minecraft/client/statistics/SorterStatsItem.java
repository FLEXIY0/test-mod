/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.util.Comparator;
import net.minecraft.client.c.C_bq;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatCrafting;
import net.minecraft.client.statistics.StatList;

public class SorterStatsItem
implements Comparator<Object> {
    final C_bs statsGUI;
    final C_bq slotStatsItemGUI;

    public SorterStatsItem(C_bq c_bq, C_bs c_bs) {
        this.slotStatsItemGUI = c_bq;
        this.statsGUI = c_bs;
    }

    public int readStatList(StatCrafting statCrafting, StatCrafting statCrafting2) {
        int n = statCrafting.getItemID();
        int n2 = statCrafting2.getItemID();
        StatBase statBase = null;
        StatBase statBase2 = null;
        if (this.slotStatsItemGUI.selectedBlockStat == 0) {
            statBase = StatList.objectBreakStats[n];
            statBase2 = StatList.objectBreakStats[n2];
        } else if (this.slotStatsItemGUI.selectedBlockStat == 1) {
            statBase = StatList.objectCraftStats[n];
            statBase2 = StatList.objectCraftStats[n2];
        } else if (this.slotStatsItemGUI.selectedBlockStat == 2) {
            statBase = StatList.objectUseStats[n];
            statBase2 = StatList.objectUseStats[n2];
        } else if (this.slotStatsItemGUI.selectedBlockStat == 3) {
            statBase = StatList.objectObtainStats[n];
            statBase2 = StatList.objectObtainStats[n2];
        } else if (this.slotStatsItemGUI.selectedBlockStat == 4) {
            statBase = StatList.objectDisposeStats[n];
            statBase2 = StatList.objectDisposeStats[n2];
        }
        if (statBase != null || statBase2 != null) {
            int n3;
            if (statBase == null) {
                return 1;
            }
            if (statBase2 == null) {
                return -1;
            }
            int n4 = C_bs.getStatsFileWriter(this.slotStatsItemGUI.slotGuiStats).getStatCount(statBase);
            if (n4 != (n3 = C_bs.getStatsFileWriter(this.slotStatsItemGUI.slotGuiStats).getStatCount(statBase2))) {
                return (n4 - n3) * this.slotStatsItemGUI.selectedStat;
            }
        }
        return n - n2;
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.readStatList((StatCrafting)object, (StatCrafting)object2);
    }
}

