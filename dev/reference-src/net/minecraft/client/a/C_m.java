/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a;

import java.util.Random;
import net.minecraft.client.c.GuiMainMenu;

public class C_m {
    public double height;
    public double prevHeight;
    public double dropSpeed;
    final GuiMainMenu mainMenu;
    private Random random = new Random();

    public C_m(GuiMainMenu guiMainMenu, int n, int n2) {
        this.mainMenu = guiMainMenu;
        this.height = this.prevHeight = (double)(10 + n2) + this.random.nextDouble() * 32.0 + (double)n;
    }

    public void updateLogoEffects() {
        this.prevHeight = this.height;
        if (this.height > 0.0) {
            this.dropSpeed -= 0.6;
        }
        this.height += this.dropSpeed;
        this.dropSpeed *= 0.9;
        if (this.height < 0.0) {
            this.height = 0.0;
            this.dropSpeed = 0.0;
        }
    }
}

