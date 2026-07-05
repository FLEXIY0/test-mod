/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.util.Comparator;
import net.minecraft.client.c.C_br;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;
import net.minecraft.client.statistics.StatMob;

public class SorterStatsMob
implements Comparator<Object> {
    final C_bs statsGUI;
    final C_br slotStatsMobGUI;

    public SorterStatsMob(C_br c_br, C_bs c_bs) {
        this.slotStatsMobGUI = c_br;
        this.statsGUI = c_bs;
    }

    public int readStatList(StatMob statMob, StatMob statMob2) {
        int n = statMob.getEntity();
        int n2 = statMob2.getEntity();
        StatBase statBase = null;
        StatBase statBase2 = null;
        if (this.slotStatsMobGUI.selectedBlockStat == 0) {
            statBase = StatList.objectKillStats[n];
            statBase2 = StatList.objectKillStats[n2];
        } else if (this.slotStatsMobGUI.selectedBlockStat == 1) {
            statBase = StatList.objectDeathStats[n];
            statBase2 = StatList.objectDeathStats[n2];
        }
        if (statBase != null || statBase2 != null) {
            int n3;
            if (statBase == null) {
                return 1;
            }
            if (statBase2 == null) {
                return -1;
            }
            int n4 = C_bs.getStatsFileWriter(this.slotStatsMobGUI.theStats).getStatCount(statBase);
            if (n4 != (n3 = C_bs.getStatsFileWriter(this.slotStatsMobGUI.theStats).getStatCount(statBase2))) {
                return (n4 - n3) * this.slotStatsMobGUI.selectedStat;
            }
        }
        return n - n2;
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.readStatList((StatMob)object, (StatMob)object2);
    }
}

