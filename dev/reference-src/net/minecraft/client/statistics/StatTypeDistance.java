/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.IStatType;
import net.minecraft.client.statistics.StatBase;

final class StatTypeDistance
implements IStatType {
    StatTypeDistance() {
    }

    @Override
    public String format(int n) {
        double d2 = (double)n / 100.0;
        double d3 = d2 / 1000.0;
        return d3 > 0.5 ? StatBase.getDecimalFormat().format(d3) + " km" : (d2 > 0.5 ? StatBase.getDecimalFormat().format(d2) + " m" : n + " cm");
    }
}

