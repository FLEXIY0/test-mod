/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

public class GuiPlayerInfo {
    public final String name;
    private final String nameinLowerCase;
    public int responseTime;
    public int score;

    public GuiPlayerInfo(String string, int n) {
        this.name = string;
        this.nameinLowerCase = string.toLowerCase();
        this.score = n;
    }

    public boolean nameStartsWith(String string) {
        return this.nameinLowerCase.startsWith(string);
    }
}

