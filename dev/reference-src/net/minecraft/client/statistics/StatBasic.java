/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.IStatType;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;

public class StatBasic
extends StatBase {
    public StatBasic(int n, String string, IStatType iStatType) {
        super(n, string, iStatType);
    }

    public StatBasic(int n, String string) {
        super(n, string);
    }

    @Override
    public StatBase registerStat() {
        super.registerStat();
        StatList.generalStats.add(this);
        return this;
    }
}

