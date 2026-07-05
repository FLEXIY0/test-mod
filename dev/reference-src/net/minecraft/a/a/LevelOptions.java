/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import net.minecraft.a.a.World;
import net.minecraft.a.a.c.C_a;

public class LevelOptions {
    public String name = "A Nice World";
    public String seed = "";
    public int house = 1;
    public int gamemode = 0;
    public int seasons = 0;
    public boolean cheats = false;
    public boolean seasonLock = false;
    public int width = 256;
    public int height = 128;
    public int length = 256;
    public int type = 1;
    public int theme = 0;
    public String file;

    public World generate(net.minecraft.client.C_a c_a, String string) {
        C_a c_a2 = new C_a(c_a);
        c_a2.worldGen = this;
        c_a2.a = this.type == 1;
        c_a2.b = this.type == 2;
        c_a2.c = this.type == 3;
        c_a2.desertGen = this.type == 4;
        c_a2.cavesGen = this.type == 5;
        c_a2.mountainGen = this.type == 6;
        c_a2.oceanGen = this.type == 7;
        c_a2.moonGen = this.type == 8;
        c_a2.marshGen = this.type == 9;
        c_a2.theme = this.theme;
        c_a2.cheats = this.cheats;
        if (this.seed != null && !this.seed.isEmpty()) {
            try {
                c_a2.seed = Long.parseLong(this.seed);
            }
            catch (NumberFormatException numberFormatException) {
                c_a2.seed = this.seed.hashCode();
            }
        }
        return c_a2.a(string, this.width, this.length, this.height);
    }
}

