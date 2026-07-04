/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.util.Map;
import net.minecraft.client.statistics.StatsSyncher;

class ThreadStatSyncherSend
extends Thread {
    final Map<StatsSyncher, ?> synchronizers;
    final StatsSyncher statSynchronizer;

    ThreadStatSyncherSend(StatsSyncher statsSyncher, Map<StatsSyncher, ?> map) {
        this.statSynchronizer = statsSyncher;
        this.synchronizers = map;
    }

    @Override
    public void run() {
        try {
            StatsSyncher.checkFiles(this.statSynchronizer, this.synchronizers, StatsSyncher.getUnsentData(this.statSynchronizer), StatsSyncher.getTemporarilyUnsentData(this.statSynchronizer), StatsSyncher.getOldUnsentData(this.statSynchronizer));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            StatsSyncher.isCurrentlySynchronizing(this.statSynchronizer, false);
        }
    }
}

