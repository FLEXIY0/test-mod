/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.GameSettings;

public class ScaledResolution {
    private int a;
    private int b;
    public int scaleFactor;

    public ScaledResolution(GameSettings gameSettings, int n, int n2) {
        this.a = n;
        this.b = n2;
        int n3 = gameSettings.guiScale;
        if (n3 == 0) {
            n3 = 1000;
        }
        this.scaleFactor = 1;
        while (this.scaleFactor < n3 && this.a / (this.scaleFactor + 1) >= 320 && this.b / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }
        this.a /= this.scaleFactor;
        this.b /= this.scaleFactor;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }
}

