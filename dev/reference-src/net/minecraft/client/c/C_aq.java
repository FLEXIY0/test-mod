/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;

public class C_aq
extends GuiScreen {
    private Exception e;

    public C_aq(Exception exception) {
        this.e = exception;
    }

    @Override
    public void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Back to title screen"));
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            this.b.a(new GuiMainMenu());
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_aq.a(this.g, "An exception has occurred!", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
        C_aq.a(this.g, "Minecraft ran into an unexpected problem:", this.c / 2 - 140, this.d / 4 - 60 + 60 + 0, 0xA0A0A0);
        C_aq.a(this.g, "", this.c / 2 - 140, this.d / 4 - 60 + 60 + 18, 0xA0A0A0);
        C_aq.a(this.g, this.e.toString(), this.c / 2, this.d / 4 - 60 + 60 + 27, -256);
        C_aq.a(this.g, "   at " + this.e.getStackTrace()[0].toString(), this.c / 2, this.d / 4 - 60 + 60 + 35, -256);
        C_aq.a(this.g, "To prevent more problems, the current game has quit.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 60, 0xA0A0A0);
        super.a(n, n2, f);
    }
}

