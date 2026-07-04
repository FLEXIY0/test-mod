/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.C_aj;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.d;
import net.minecraft.network.NetClientHandler;

public class C_ak
extends GuiScreen {
    private NetClientHandler clientHandler;
    private boolean cancelled = false;

    public C_ak(d d2, String string, int n) {
        System.out.println("Connecting to " + string + ", " + n);
        new C_aj(this, d2, string, n).start();
    }

    @Override
    public void f_() {
        if (this.clientHandler != null) {
            this.clientHandler.processReadPackets();
        }
    }

    @Override
    protected void a(char c, int n) {
    }

    @Override
    public void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Cancel"));
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.b == 0) {
            this.cancelled = true;
            if (this.clientHandler != null) {
                this.clientHandler.disconnect();
            }
            this.b.a(new GuiMainMenu());
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        if (this.clientHandler == null) {
            C_ak.a(this.g, "Connecting...", this.c / 2, this.d / 2 - 50, 0xFFFFFF);
            C_ak.a(this.g, "", this.c / 2, this.d / 2 - 10, 0xFFFFFF);
        } else {
            C_ak.a(this.g, "Logging in", this.c / 2, this.d / 2 - 50, 0xFFFFFF);
            C_ak.a(this.g, this.clientHandler.customGreeting, this.c / 2, this.d / 2 - 10, 0xFFFFFF);
        }
        super.a(n, n2, f);
    }

    static /* synthetic */ NetClientHandler access$002(C_ak c_ak, NetClientHandler netClientHandler) {
        c_ak.clientHandler = netClientHandler;
        return c_ak.clientHandler;
    }

    static /* synthetic */ boolean access$100(C_ak c_ak) {
        return c_ak.cancelled;
    }

    static /* synthetic */ NetClientHandler access$000(C_ak c_ak) {
        return c_ak.clientHandler;
    }
}

