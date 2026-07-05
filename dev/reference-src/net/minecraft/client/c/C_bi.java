/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.C_bj;

class C_bi
implements Comparable<C_bi> {
    private String name;
    private String fileName;
    private String type;
    private String theme;
    private String season;
    private String gamemode;
    private String cheats;
    private String[] types = new String[]{"Inland", "Island", "Floating", "Flat", "Desert", "Caves", "Mountains", "Ocean", "Moon", "Marshland"};
    private String[] themes = new String[]{"Normal", "Hell", "Paradise", "Woods", "Shroomland"};
    private String[] seasons = new String[]{"Spring", "Summer", "Autumn", "Winter"};
    private String[] gamemodes = new String[]{"\u00a7cSurvival", "\u00a79Creative", "\u00a7eSpectator", "\u00a74Hardcore", "\u00a7aAdventure"};
    private String size;
    private long accessTime;
    private short gamemodeValue;
    private boolean cheatsValue;
    private boolean hardcoreValue;
    final /* synthetic */ C_bj this$0;

    public C_bi(C_bj c_bj, String string, String string2, short s, short s2, short s3, short s4, boolean bl, boolean bl2, String string3, long l) {
        this.this$0 = c_bj;
        if (bl2) {
            s4 = (short)3;
        }
        this.name = string;
        this.fileName = string2;
        this.type = this.types[s];
        this.theme = this.themes[s2];
        this.season = this.seasons[s3];
        this.gamemode = this.gamemodes[s4];
        this.cheats = bl ? "\u00a7eCheats" : "";
        this.size = string3;
        this.accessTime = l;
        this.gamemodeValue = s4;
        this.cheatsValue = bl;
        this.hardcoreValue = bl2;
    }

    @Override
    public int compareTo(C_bi c_bi) {
        return this.name.compareToIgnoreCase(c_bi.name);
    }

    static /* synthetic */ String access$000(C_bi c_bi) {
        return c_bi.fileName;
    }

    static /* synthetic */ String access$100(C_bi c_bi) {
        return c_bi.name;
    }

    static /* synthetic */ String access$200(C_bi c_bi) {
        return c_bi.type;
    }

    static /* synthetic */ String access$300(C_bi c_bi) {
        return c_bi.theme;
    }

    static /* synthetic */ String access$400(C_bi c_bi) {
        return c_bi.size;
    }

    static /* synthetic */ String access$1100(C_bi c_bi) {
        return c_bi.season;
    }

    static /* synthetic */ String access$1200(C_bi c_bi) {
        return c_bi.gamemode;
    }

    static /* synthetic */ String access$1300(C_bi c_bi) {
        return c_bi.cheats;
    }

    static /* synthetic */ boolean access$1400(C_bi c_bi) {
        return c_bi.cheatsValue;
    }

    static /* synthetic */ short access$1500(C_bi c_bi) {
        return c_bi.gamemodeValue;
    }

    static /* synthetic */ boolean access$1600(C_bi c_bi) {
        return c_bi.hardcoreValue;
    }

    static /* synthetic */ long access$1700(C_bi c_bi) {
        return c_bi.accessTime;
    }
}

