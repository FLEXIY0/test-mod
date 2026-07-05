/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.IStatType;
import net.minecraft.client.statistics.StatBase;

final class StatTypeTime
implements IStatType {
    StatTypeTime() {
    }

    @Override
    public String format(int n) {
        double d2 = (double)n / 20.0;
        double d3 = d2 / 60.0;
        double d4 = d3 / 60.0;
        double d5 = d4 / 24.0;
        double d6 = d5 / 365.0;
        return d6 > 0.5 ? StatBase.getDecimalFormat().format(d6) + " y" : (d5 > 0.5 ? StatBase.getDecimalFormat().format(d5) + " d" : (d4 > 0.5 ? StatBase.getDecimalFormat().format(d4) + " h" : (d3 > 0.5 ? StatBase.getDecimalFormat().format(d3) + " m" : d2 + " s")));
    }
}

