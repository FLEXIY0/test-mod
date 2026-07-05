/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.IStatStringFormat;
import net.minecraft.client.statistics.StatBase;

public class Achievement
extends StatBase {
    public final Achievement parentAchievement;
    private final String achievementDescription;
    private IStatStringFormat statStringFormatter;
    public final ItemStack theItemStack;
    private boolean isSpecial;
    private Category category;

    public Achievement(int n, String string, String string2, Item item, Achievement achievement) {
        this(n, string, string2, new ItemStack(item), achievement);
    }

    public Achievement(int n, String string, String string2, C_x c_x, Achievement achievement) {
        this(n, string, string2, new ItemStack(c_x), achievement);
    }

    public Achievement(int n, String string, String string2, ItemStack itemStack, Achievement achievement) {
        super(0x500000 + n, string);
        this.theItemStack = itemStack;
        this.achievementDescription = string2;
        this.parentAchievement = achievement;
    }

    public Achievement setIndependent() {
        this.isIndependent = true;
        return this;
    }

    public Achievement setSpecial() {
        this.isSpecial = true;
        return this;
    }

    public Achievement registerAchievement() {
        super.registerStat();
        if (this.isSpecial) {
            AchievementList.challengeList.add(this);
        } else {
            AchievementList.achievementList.add(this);
        }
        return this;
    }

    @Override
    public boolean isAchievement() {
        return true;
    }

    public String getDescription() {
        return this.statStringFormatter != null ? this.statStringFormatter.formatString(this.achievementDescription) : this.achievementDescription;
    }

    public Achievement setStatStringFormatter(IStatStringFormat iStatStringFormat) {
        this.statStringFormatter = iStatStringFormat;
        return this;
    }

    public boolean getSpecial() {
        return this.isSpecial;
    }

    @Override
    public StatBase registerStat() {
        return this.registerAchievement();
    }

    @Override
    public StatBase initIndependentStat() {
        return this.setIndependent();
    }

    public Category getCategory() {
        return this.category;
    }

    public Achievement setCategory(Category category) {
        this.category = category;
        return this;
    }

    public static enum Category {
        GENERAL("General", 0xFFFFFF),
        MINING("Mining", 0xAAAAAA),
        FARMING("Farming", 0x55FF55),
        FISHING("Fishing", 0x5555FF),
        COMBAT("Combat", 0xFF5555),
        ADVENTURE("Adventure", 0xFFAA55),
        ENDGAME("Endgame", 0xFFFF55);

        private String name;
        private int color;

        private Category(String string2, int n2) {
            this.name = string2;
            this.color = n2;
        }

        public String getName() {
            return this.name;
        }

        public int getColor() {
            return this.color;
        }
    }
}

