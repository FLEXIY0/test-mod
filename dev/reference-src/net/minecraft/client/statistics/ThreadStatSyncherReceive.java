/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.StatsSyncher;

class ThreadStatSyncherReceive
extends Thread {
    final StatsSyncher statSynchronizer;

    ThreadStatSyncherReceive(StatsSyncher statsSyncher) {
        this.statSynchronizer = statsSyncher;
    }

    @Override
    public void run() {
        try {
            if (StatsSyncher.getStatisticsMap(this.statSynchronizer) != null) {
                StatsSyncher.checkFiles(this.statSynchronizer, StatsSyncher.getStatisticsMap(this.statSynchronizer), StatsSyncher.getFileData(this.statSynchronizer), StatsSyncher.getTempData(this.statSynchronizer), StatsSyncher.getOldData(this.statSynchronizer));
            } else if (StatsSyncher.getFileData(this.statSynchronizer).exists()) {
                StatsSyncher.getStatisticsMap(this.statSynchronizer, StatsSyncher.compareFiles(this.statSynchronizer, StatsSyncher.getFileData(this.statSynchronizer), StatsSyncher.getTempData(this.statSynchronizer), StatsSyncher.getOldData(this.statSynchronizer)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            StatsSyncher.isCurrentlySynchronizing(this.statSynchronizer, false);
        }
    }
}

