/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import net.minecraft.a.a.LevelOptions;
import net.minecraft.client.c.C_as;
import net.minecraft.client.c.C_n;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public class C_bw
extends GuiScreen {
    private C_as locker;
    private C_n parent;
    private String title = "Level seed:";
    private String warn = "Leave blank for random seed";
    public String seed = "";
    public int house = 1;
    public int theme = 0;
    public int type = 0;
    public int season = 0;
    public boolean locked = false;
    private int counter = 0;
    private static final String[] HOUSES = new String[]{"None", "Original", "Debug"};
    private static final String[] THEMES = new String[]{"Normal", "Hell", "Paradise", "Woods", "Shroomland"};
    private static final String[] SEASONS = new String[]{"Spring", "Summer", "Autumn", "Winter"};
    private static final String[] TYPES = new String[]{"Inland", "Island", "Floating", "Flat", "Desert", "Caves", "Mountains", "Ocean", "Moon", "Marshland"};

    public C_bw(C_n c_n) {
        this.parent = c_n;
        LevelOptions levelOptions = c_n.worldOptions;
        this.seed = levelOptions.seed;
        this.house = levelOptions.house;
        this.theme = levelOptions.theme;
        this.type = levelOptions.type;
        this.season = levelOptions.seasons;
        this.locked = levelOptions.seasonLock;
        this.seed = levelOptions.seed;
    }

    @Override
    public final void b() {
        this.e.clear();
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.add(new GuiButton(1, this.c / 2 + 5, this.d / 4 + 72 + 12, 150, 20, this.getSetting(1)));
        this.e.add(new GuiButton(2, this.c / 2 - 150, this.d / 4 + 72 + 12, 150, 20, this.getSetting(2)));
        this.e.add(new GuiButton(3, this.c / 2 - 150, this.d / 4 + 96 + 12, 150, 20, this.getSetting(3)));
        this.e.add(new GuiButton(4, this.c / 2 + 5, this.d / 4 + 96 + 12, 129, 20, this.getSetting(4)));
        this.locker = new C_as(5, this.c / 2 + 135, this.d / 4 + 96 + 12);
        this.e.add(this.locker);
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 144, "Done"));
        this.locker.isLocked = this.locked;
    }

    @Override
    public final void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public final void f_() {
        ++this.counter;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0) {
                this.saveAndExit();
            }
            if (guiButton.b == 1) {
                if (Keyboard.isKeyDown((int)42)) {
                    --this.house;
                    if (this.house < 0) {
                        this.house = HOUSES.length - 1;
                    }
                } else {
                    this.house = (this.house + 1) % HOUSES.length;
                }
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 2) {
                if (Keyboard.isKeyDown((int)42)) {
                    --this.theme;
                    if (this.theme < 0) {
                        this.theme = THEMES.length - 1;
                    }
                } else {
                    this.theme = (this.theme + 1) % THEMES.length;
                }
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 3) {
                if (Keyboard.isKeyDown((int)42)) {
                    --this.type;
                    if (this.type < 0) {
                        this.type = TYPES.length - 1;
                    }
                } else {
                    this.type = (this.type + 1) % TYPES.length;
                }
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 4) {
                if (Keyboard.isKeyDown((int)42)) {
                    --this.season;
                    if (this.season < 0) {
                        this.season = SEASONS.length - 1;
                    }
                } else {
                    this.season = (this.season + 1) % SEASONS.length;
                }
                guiButton.a = this.getSetting(guiButton.b);
            }
            if (guiButton.b == 5) {
                this.locker.isLocked = this.locked = !this.locked;
            }
        }
    }

    public final String getSetting(int n) {
        return n == 1 ? "House: " + HOUSES[this.house] : (n == 2 ? "Theme: " + THEMES[this.theme] : (n == 3 ? "Type: " + TYPES[this.type] : (n == 4 ? "Season: " + SEASONS[this.season] : "")));
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.seed.length() > 0) {
            this.seed = this.seed.substring(0, this.seed.length() - 1);
        }
        if (n == 1) {
            this.saveAndExit();
        }
        if (n == 28) {
            this.saveAndExit();
        }
        if (c == '\u0016') {
            int n2;
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            if ((n2 = 32 - this.seed.length()) > string.length()) {
                n2 = string.length();
            }
            if (n2 > 0) {
                this.seed = this.seed + string.substring(0, n2);
            }
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.seed.length() < 64 && this.g.a(this.seed) < 192) {
            this.seed = this.seed + c;
        }
    }

    private void saveAndExit() {
        LevelOptions levelOptions = this.parent.worldOptions;
        levelOptions.seed = this.seed;
        levelOptions.house = this.house;
        levelOptions.theme = this.theme;
        levelOptions.seasons = this.season;
        levelOptions.type = this.type;
        levelOptions.seasonLock = this.locked;
        levelOptions.seed = this.seed;
        this.b.a(this.parent);
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_bw.a(this.g, "More world options", this.c / 2, this.d / 4 - 20, 0xFFFFFF);
        C_bw.a(this.g, this.title, this.c / 2, this.d / 4, 0xFFFFFF);
        C_bw.a(this.g, this.warn, this.c / 2, this.d / 4 + 52, 0xFFFFFF);
        int n3 = this.c / 2 - 100;
        int n4 = this.d / 4 + 20;
        C_bw.a(n3 - 1, n4 - 1, n3 + 200 + 1, n4 + 20 + 1, -6250336);
        C_bw.a(n3, n4, n3 + 200, n4 + 20, -16777216);
        C_bw.b(this.g, this.seed + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 6, 0xE0E0E0);
        super.a(n, n2, f);
    }
}

