/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

public enum C_d {
    a("Kebab", 16, 16, 0, 0),
    g("Aztec", 16, 16, 16, 0),
    h("Alban", 16, 16, 32, 0),
    i("Aztec2", 16, 16, 48, 0),
    j("Bomb", 16, 16, 64, 0),
    k("Plant", 16, 16, 80, 0),
    l("Wasteland", 16, 16, 96, 0),
    Crow("Crow", 16, 16, 112, 0),
    Girl("Girl", 16, 16, 128, 0),
    Head("Head", 16, 16, 144, 0),
    Forest("Woods", 16, 16, 160, 0),
    Indev("Sands", 16, 16, 176, 0),
    Infdev("Eternity", 16, 16, 0, 16),
    Spring("Spring", 16, 16, 16, 16),
    Summer("Summer", 16, 16, 32, 16),
    Autumn("Autumn", 16, 16, 48, 16),
    Winter("Winter", 16, 16, 64, 16),
    Light("Light", 16, 16, 80, 16),
    m("Pool", 32, 16, 0, 32),
    n("Courbet", 32, 16, 32, 32),
    o("Sea", 32, 16, 64, 32),
    p("Sunset", 32, 16, 96, 32),
    Tram("Tram", 32, 16, 128, 32),
    Stars("Stars", 32, 16, 160, 32),
    Train("Train", 32, 16, 0, 48),
    Leader("Nature", 32, 16, 32, 48),
    Harmony("Harmony", 32, 16, 64, 48),
    Dawn("Dawn", 32, 16, 96, 48),
    Swan("Unity", 32, 16, 128, 48),
    Resurgence("Resurgence", 32, 16, 160, 48),
    q("Wanderer", 16, 32, 0, 64),
    Wake("Wake", 16, 32, 16, 64),
    Graham("Graham", 16, 32, 32, 64),
    Lady("Emilia", 16, 32, 48, 64),
    r("Match", 32, 32, 0, 128),
    s("Bust", 32, 32, 32, 128),
    t("Stage", 32, 32, 64, 128),
    u("Void", 32, 32, 96, 128),
    v("SkullAndRoses", 32, 32, 128, 128),
    KoRn("KoRn", 32, 32, 160, 128),
    Rake("Baldrs", 32, 32, 192, 128),
    Adieu("Adieu", 32, 32, 224, 128),
    Isolation("Nostalgia", 32, 32, 0, 160),
    Lexicon("Wisdom", 32, 32, 32, 160),
    Sertaline("Peace", 32, 32, 64, 160),
    w("Fighters", 64, 32, 0, 96),
    Noel("Saucer", 64, 32, 64, 96),
    Sabbath("Sabbath", 64, 32, 128, 96),
    x("Pointer", 64, 64, 0, 192),
    Filosofem("Filosofem", 64, 64, 64, 192);

    public static final int maxArtTitleLength;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    private C_d(String string2, int n2, int n3, int n4, int n5) {
        this.b = string2;
        this.c = n2;
        this.d = n3;
        this.e = n4;
        this.f = n5;
    }

    static {
        maxArtTitleLength = "SkullAndRoses".length();
    }
}

