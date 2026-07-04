/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.a.a.C_g;
import net.minecraft.client.c.C_ac;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiOptions;
import net.minecraft.client.c.GuiScreen;

public final class C_b
extends GuiScreen {
    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 5 + 96, "Options..."));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 5 + 24, "Back to game"));
        this.e.add(new GuiButton(3, this.c / 2 - 100, this.d / 5 + 48, 98, 20, "Achievements"));
        this.e.add(new GuiButton(4, this.c / 2 + 2, this.d / 5 + 48, 98, 20, "Statistics"));
        this.e.add(new GuiButton(2, this.c / 2 - 100, this.d / 5 + 120, "Save and quit"));
        if (this.b.isMultiplayerWorld()) {
            ((GuiButton)this.e.get((int)4)).a = "Disconnect";
            ((GuiButton)this.e.get((int)3)).c = false;
            ((GuiButton)this.e.get((int)2)).c = false;
        }
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.b == 0) {
            this.b.a(new GuiOptions(this.b.w));
        }
        if (guiButton.b == 1) {
            this.b.a((GuiScreen)null);
            this.b.b();
        }
        if (guiButton.b == 2) {
            if (this.b.isMultiplayerWorld()) {
                this.b.d.sendQuittingDisconnectingPacket();
            }
            if (this.b.d != null) {
                this.b.d.active = true;
            }
            this.b.a((C_g)null);
            this.b.f = null;
            this.b.a(new GuiMainMenu());
        }
        if (guiButton.b == 3) {
            this.b.a(new C_ac(this.b.statFileWriter));
        }
        if (guiButton.b == 4) {
            this.b.a(new C_bs(this, this.b.statFileWriter));
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_b.a(this.g, "Game menu", this.c / 2, 48, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

