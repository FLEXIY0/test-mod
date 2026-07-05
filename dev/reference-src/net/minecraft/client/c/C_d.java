/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.a.a.World;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.opengl.GL11;

public final class C_d
extends GuiScreen {
    private int counter = 0;

    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 58, "Respawn"));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 82, "Quit to title.."));
        ((GuiButton)this.e.get((int)0)).c = false;
        ((GuiButton)this.e.get((int)1)).c = false;
        if (this.b.f.isHardcoreEnabled) {
            ((GuiButton)this.e.get((int)0)).a = "Spectate level";
        }
    }

    @Override
    protected final void a(char c, int n) {
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.b == 0 && this.b.f != null) {
            this.b.f.doRespawn();
        }
        if (guiButton.b == 1) {
            this.b.a((World)null);
            this.b.f = null;
            this.b.a(new GuiMainMenu());
        }
    }

    @Override
    public void f_() {
        if (this.counter < 20) {
            ++this.counter;
        }
        if (this.counter >= 20) {
            ((GuiButton)this.e.get((int)0)).c = true;
            ((GuiButton)this.e.get((int)1)).c = true;
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        C_d.a(0, 0, this.c, this.d, 0x60500000, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        C_d.a(this.g, "Game over!", this.c / 2 / 2, 30, 0xFFFFFF);
        GL11.glPopMatrix();
        FontRenderer fontRenderer = this.g;
        StringBuilder stringBuilder = new StringBuilder().append("Score: \u00a7e");
        C_d.a(fontRenderer, stringBuilder.append(this.b.f.P).toString(), this.c / 2, 95, 0xFFFFFF);
        super.a(n, n2, f);
    }

    @Override
    public final boolean c() {
        return false;
    }
}

