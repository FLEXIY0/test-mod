/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.IAchieveDisplay;

public class CategoryDisplay
implements IAchieveDisplay {
    private Achievement.Category category;

    public CategoryDisplay(Achievement.Category category) {
        this.category = category;
    }

    @Override
    public Achievement getAchievement() {
        return null;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return this.category.getName();
    }

    @Override
    public int getColor() {
        return this.category.getColor();
    }
}

