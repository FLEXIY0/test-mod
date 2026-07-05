/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import com.mojang.json.J_InvalidSyntaxException;
import com.mojang.json.J_JdomParser;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonRootNode;
import com.mojang.json.J_JsonStringNode;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.C_l;
import net.minecraft.client.CharacterLoader;
import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.MD5String;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;
import net.minecraft.client.statistics.StatsSyncher;

public class StatFileWriter {
    private Map<StatBase, Object> statsMap = new HashMap<StatBase, Object>();
    private Map<StatBase, Object> achievementMap = new HashMap<StatBase, Object>();
    private boolean isSynchronizing = false;
    private StatsSyncher statsSyncher;

    public StatFileWriter(CharacterLoader characterLoader, File file, C_l c_l) {
        File file2 = new File(file, "characters");
        if (!file2.exists()) {
            file2.mkdir();
        }
        for (File file3 : file.listFiles()) {
            File file4;
            if (!file3.getName().startsWith("stats_") || !file3.getName().endsWith(".dat") || (file4 = new File(file2, file3.getName())).exists()) continue;
            System.out.println("Relocating " + file3.getName());
            file3.renameTo(file4);
        }
        this.statsSyncher = new StatsSyncher(characterLoader, this, file2, c_l);
    }

    public void writeStat(StatBase statBase, int n) {
        this.writeStatToMap(this.achievementMap, statBase, n);
        this.writeStatToMap(this.statsMap, statBase, n);
        this.isSynchronizing = true;
    }

    private void writeStatToMap(Map<StatBase, Object> map, StatBase statBase, int n) {
        Integer n2 = (Integer)map.get(statBase);
        int n3 = n2 == null ? 0 : n2;
        map.put(statBase, n3 + n);
    }

    public Map<StatBase, Object> getAchievementMap() {
        return new HashMap<StatBase, Object>(this.achievementMap);
    }

    public void writeStatisticsAndAchievements(Map<?, ?> map) {
        if (map != null) {
            this.isSynchronizing = true;
            for (StatBase statBase : map.keySet()) {
                this.writeStatToMap(this.achievementMap, statBase, (Integer)map.get(statBase));
                this.writeStatToMap(this.statsMap, statBase, (Integer)map.get(statBase));
            }
        }
    }

    public void writeStatistics(Map<?, ?> map) {
        if (map != null) {
            for (StatBase statBase : map.keySet()) {
                Integer n = (Integer)this.achievementMap.get(statBase);
                int n2 = n == null ? 0 : n;
                this.statsMap.put(statBase, (Integer)map.get(statBase) + n2);
            }
        }
    }

    public void writeAchievements(Map<?, ?> map) {
        if (map != null) {
            this.isSynchronizing = true;
            for (StatBase statBase : map.keySet()) {
                this.writeStatToMap(this.achievementMap, statBase, (Integer)map.get(statBase));
            }
        }
    }

    public static Map<StatBase, Integer> saveStatisticsToLocalFile(String string) {
        HashMap<StatBase, Integer> hashMap = new HashMap<StatBase, Integer>();
        try {
            Object object;
            Object object22;
            String string2 = "local";
            StringBuilder stringBuilder = new StringBuilder();
            J_JsonRootNode j_JsonRootNode = new J_JdomParser().func_27367_a(string);
            List<?> list = j_JsonRootNode.func_27217_b("stats-change");
            for (Object object22 : list) {
                object = ((J_JsonNode)object22).func_27214_c();
                Map.Entry<?, ?> entry = object.entrySet().iterator().next();
                int n = Integer.parseInt(((J_JsonStringNode)entry.getKey()).func_27216_b());
                int n2 = Integer.parseInt(((J_JsonNode)entry.getValue()).func_27216_b());
                StatBase statBase = StatList.getOneShotStat(n);
                if (statBase == null) {
                    System.out.println(n + " is not a valid stat");
                    continue;
                }
                stringBuilder.append(StatList.getOneShotStat((int)n).statGuid).append(",");
                stringBuilder.append(n2).append(",");
                hashMap.put(statBase, n2);
            }
            object22 = new MD5String(string2);
            object = ((MD5String)object22).func_27369_a(stringBuilder.toString());
            if (!((String)object).equals(j_JsonRootNode.func_27213_a("checksum"))) {
                System.out.println("CHECKSUM MISMATCH");
            }
        }
        catch (J_InvalidSyntaxException j_InvalidSyntaxException) {
            j_InvalidSyntaxException.printStackTrace();
        }
        return hashMap;
    }

    public static String generateMD5(String string, String string2, Map<?, ?> map) {
        Object object2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean bl = true;
        stringBuilder.append("{\r\n");
        if (string != null && string2 != null) {
            stringBuilder.append("  \"user\":{\r\n");
            stringBuilder.append("    \"name\":\"").append(string).append("\",\r\n");
            stringBuilder.append("    \"sessionid\":\"").append(string2).append("\"\r\n");
            stringBuilder.append("  },\r\n");
        }
        stringBuilder.append("  \"stats-change\":[");
        for (Object object2 : map.keySet()) {
            if (!bl) {
                stringBuilder.append("},");
            } else {
                bl = false;
            }
            stringBuilder.append("\r\n    {\"").append(((StatBase)object2).statId).append("\":").append(map.get(object2));
            stringBuilder2.append(((StatBase)object2).statGuid).append(",");
            stringBuilder2.append(map.get(object2)).append(",");
        }
        if (!bl) {
            stringBuilder.append("}");
        }
        object2 = new MD5String(string2);
        stringBuilder.append("\r\n  ],\r\n");
        stringBuilder.append("  \"checksum\":\"").append(((MD5String)object2).func_27369_a(stringBuilder2.toString())).append("\"\r\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean hasAchievementUnlocked(Achievement achievement) {
        return this.statsMap.containsKey(achievement);
    }

    public boolean hasAchievementParent(Achievement achievement) {
        return achievement.parentAchievement == null || this.hasAchievementUnlocked(achievement.parentAchievement);
    }

    public int getStatCount(StatBase statBase) {
        Integer n = (Integer)this.statsMap.get(statBase);
        return n == null ? 0 : n;
    }

    public void unusedFunction() {
    }

    public void syncStats() {
        this.statsSyncher.syncStatsFileWithMap(this.getAchievementMap());
    }

    public void synchronizeStats() {
        if (this.isSynchronizing && this.statsSyncher.isSynchronizing()) {
            this.statsSyncher.trySaveStats(this.getAchievementMap());
        }
        this.statsSyncher.saveStatsAndAchievementsBasedOnTimer();
    }
}

