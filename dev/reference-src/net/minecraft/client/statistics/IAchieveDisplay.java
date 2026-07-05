/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.Achievement;

public interface IAchieveDisplay {
    public String getName();

    public Achievement getAchievement();

    public int getType();

    public int getColor();
}

