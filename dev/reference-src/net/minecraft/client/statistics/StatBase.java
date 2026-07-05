/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.client.statistics.AchievementMap;
import net.minecraft.client.statistics.IStatType;
import net.minecraft.client.statistics.StatList;
import net.minecraft.client.statistics.StatTypeDistance;
import net.minecraft.client.statistics.StatTypeSimple;
import net.minecraft.client.statistics.StatTypeTime;

public class StatBase {
    public final int statId;
    private final String statName;
    public boolean isIndependent = false;
    public String statGuid;
    private final IStatType type;
    private static NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.US);
    public static IStatType simpleStatType = new StatTypeSimple();
    private static DecimalFormat decimalFormat = new DecimalFormat("########0.00");
    public static IStatType timeStatType = new StatTypeTime();
    public static IStatType distanceStatType = new StatTypeDistance();

    public StatBase(int n, String string, IStatType iStatType) {
        this.statId = n;
        this.statName = string;
        this.type = iStatType;
    }

    public StatBase(int n, String string) {
        this(n, string, simpleStatType);
    }

    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }

    public StatBase registerStat() {
        if (StatList.oneShotStats.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + StatList.oneShotStats.get((Object)Integer.valueOf((int)this.statId)).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
        }
        StatList.allStats.add(this);
        StatList.oneShotStats.put(this.statId, this);
        this.statGuid = AchievementMap.getGuid(this.statId);
        return this;
    }

    public boolean isAchievement() {
        return false;
    }

    public String getTypeName(int n) {
        return this.type.format(n);
    }

    public String getName() {
        return this.statName;
    }

    static NumberFormat getNumberFormat() {
        return numberFormat;
    }

    static DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }
}

