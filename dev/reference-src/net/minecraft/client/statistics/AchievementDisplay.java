/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.IAchieveDisplay;

public class AchievementDisplay
implements IAchieveDisplay {
    private Achievement achievement;

    public AchievementDisplay(Achievement achievement) {
        this.achievement = achievement;
    }

    @Override
    public Achievement getAchievement() {
        return this.achievement;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return this.achievement.getName();
    }

    @Override
    public int getColor() {
        return -1;
    }
}

