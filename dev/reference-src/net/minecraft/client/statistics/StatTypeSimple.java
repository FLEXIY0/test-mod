/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.IStatType;
import net.minecraft.client.statistics.StatBase;

final class StatTypeSimple
implements IStatType {
    StatTypeSimple() {
    }

    @Override
    public String format(int n) {
        return StatBase.getNumberFormat().format(n);
    }
}

