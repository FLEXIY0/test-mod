/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

public class C_n {
    public int currentSeason = 0;
    public int nextSeason = 1;
    public int lastSeason = 3;
    public float seasonProgress;
    public int seasonTime = 0;
    public boolean seasonsDisabled = false;
    public static final int SEASON_LENGTH_TICKS = 600000;
    private static final int NUM_SEASONS = 4;

    public void tick() {
        if (!this.seasonsDisabled) {
            ++this.seasonTime;
            if (this.seasonTime >= 2400000) {
                this.seasonTime = 0;
            }
            this.currentSeason = this.seasonTime % 2400000 / 600000;
            this.lastSeason = this.currentSeason - 1 + (this.currentSeason - 1 < 0 ? 4 : 0);
            this.nextSeason = this.currentSeason + 1 - (this.currentSeason + 1 >= 4 ? 4 : 0);
            this.seasonProgress = (float)(this.seasonTime % 600000) / 600000.0f;
        }
    }
}

