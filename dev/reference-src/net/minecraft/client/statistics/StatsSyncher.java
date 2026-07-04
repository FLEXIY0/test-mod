/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import net.minecraft.client.C_l;
import net.minecraft.client.CharacterLoader;
import net.minecraft.client.d;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatFileWriter;
import net.minecraft.client.statistics.ThreadStatSyncherReceive;
import net.minecraft.client.statistics.ThreadStatSyncherSend;

public class StatsSyncher {
    private volatile boolean synchronizingFiles = false;
    private volatile Map<?, ?> statisticsMap = null;
    private volatile Map<?, ?> achievementsMap = null;
    private StatFileWriter fileWriter;
    private File unsentData;
    private File data;
    private File temporaryUnsent;
    private File temporary;
    private File unsentOld;
    private File oldData;
    private int syncTime = 0;
    private int waitTime = 0;
    private String name = "";
    private int id = 0;

    public StatsSyncher(CharacterLoader characterLoader, StatFileWriter statFileWriter, File file, C_l c_l) {
        this.id = d.getMinecraft().w.character;
        this.unsentData = new File(file, "stats_char" + this.id + "_unsent.dat");
        this.data = new File(file, "stats_char" + this.id + ".dat");
        this.unsentOld = new File(file, "stats_char" + this.id + "_unsent.old");
        this.oldData = new File(file, "stats_char" + this.id + ".old");
        this.temporaryUnsent = new File(file, "stats_char" + this.id + "_unsent.tmp");
        this.temporary = new File(file, "stats_char" + this.id + ".tmp");
        this.writeStatsFile(file, "stats_char" + this.id + "_unsent.dat", this.unsentData);
        this.writeStatsFile(file, "stats_char" + this.id + ".dat", this.data);
        this.writeStatsFile(file, "stats_char" + this.id + "_unsent.old", this.unsentOld);
        this.writeStatsFile(file, "stats_char" + this.id + ".old", this.oldData);
        this.writeStatsFile(file, "stats_char" + this.id + "_unsent.tmp", this.temporaryUnsent);
        this.writeStatsFile(file, "stats_char" + this.id + ".tmp", this.temporary);
        this.fileWriter = statFileWriter;
        if (this.unsentData.exists()) {
            statFileWriter.writeStatisticsAndAchievements(this.fileComparator(this.unsentData, this.temporaryUnsent, this.unsentOld));
        }
        this.tryFetchStats();
    }

    private void writeStatsFile(File file, String string, File file2) {
        File file3 = new File(file, string);
        if (file3.exists() && !file3.isDirectory() && !file2.exists()) {
            file3.renameTo(file2);
        }
    }

    private Map<?, ?> fileComparator(File file, File file2, File file3) {
        return file.exists() ? this.getLocalStatsFile(file) : (file3.exists() ? this.getLocalStatsFile(file3) : (file2.exists() ? this.getLocalStatsFile(file2) : null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map<?, ?> getLocalStatsFile(File file) {
        BufferedReader bufferedReader = null;
        try {
            Map<StatBase, Integer> map;
            bufferedReader = new BufferedReader(new FileReader(file));
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string);
            }
            Map<StatBase, Integer> map2 = map = StatFileWriter.saveStatisticsToLocalFile(stringBuilder.toString());
            return map2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checksumFileAndMD5(Map<?, ?> map, File file, File file2, File file3) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file2, false));){
            printWriter.print(StatFileWriter.generateMD5(this.name, "local", map));
        }
        if (file3.exists()) {
            file3.delete();
        }
        if (file.exists()) {
            file.renameTo(file3);
        }
        file2.renameTo(file);
    }

    public void tryFetchStats() {
        if (this.synchronizingFiles) {
            throw new IllegalStateException("Can't get stats from server while StatsSyncher is busy!");
        }
        this.syncTime = 100;
        this.synchronizingFiles = true;
        new ThreadStatSyncherReceive(this).start();
    }

    public void trySaveStats(Map map) {
        if (this.synchronizingFiles) {
            throw new IllegalStateException("Can't save stats while StatsSyncher is busy!");
        }
        this.syncTime = 100;
        this.synchronizingFiles = true;
        new ThreadStatSyncherSend(this, map).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void syncStatsFileWithMap(Map<?, ?> map) {
        int n = 30;
        while (this.synchronizingFiles && --n > 0) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        this.synchronizingFiles = true;
        try {
            this.checksumFileAndMD5(map, this.unsentData, this.temporaryUnsent, this.unsentOld);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            this.synchronizingFiles = false;
        }
    }

    public boolean isSynchronizing() {
        return this.syncTime <= 0 && !this.synchronizingFiles && this.achievementsMap == null;
    }

    public void saveStatsAndAchievementsBasedOnTimer() {
        if (this.syncTime > 0) {
            --this.syncTime;
        }
        if (this.waitTime > 0) {
            --this.waitTime;
        }
        if (this.achievementsMap != null) {
            this.fileWriter.writeAchievements(this.achievementsMap);
            this.achievementsMap = null;
        }
        if (this.statisticsMap != null) {
            this.fileWriter.writeStatistics(this.statisticsMap);
            this.statisticsMap = null;
        }
    }

    static Map<?, ?> getStatisticsMap(StatsSyncher statsSyncher) {
        return statsSyncher.statisticsMap;
    }

    static File getFileData(StatsSyncher statsSyncher) {
        return statsSyncher.data;
    }

    static File getTempData(StatsSyncher statsSyncher) {
        return statsSyncher.temporary;
    }

    static File getOldData(StatsSyncher statsSyncher) {
        return statsSyncher.oldData;
    }

    static void checkFiles(StatsSyncher statsSyncher, Map<?, ?> map, File file, File file2, File file3) throws IOException {
        statsSyncher.checksumFileAndMD5(map, file, file2, file3);
    }

    static Map<?, ?> getStatisticsMap(StatsSyncher statsSyncher, Map<?, ?> map) {
        statsSyncher.statisticsMap = map;
        return statsSyncher.statisticsMap;
    }

    static Map<?, ?> compareFiles(StatsSyncher statsSyncher, File file, File file2, File file3) {
        return statsSyncher.fileComparator(file, file2, file3);
    }

    static boolean isCurrentlySynchronizing(StatsSyncher statsSyncher, boolean bl) {
        statsSyncher.synchronizingFiles = bl;
        return statsSyncher.synchronizingFiles;
    }

    static File getUnsentData(StatsSyncher statsSyncher) {
        return statsSyncher.unsentData;
    }

    static File getTemporarilyUnsentData(StatsSyncher statsSyncher) {
        return statsSyncher.temporaryUnsent;
    }

    static File getOldUnsentData(StatsSyncher statsSyncher) {
        return statsSyncher.unsentOld;
    }
}

