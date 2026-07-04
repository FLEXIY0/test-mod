/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.packet.Packet0KeepAlive;

public class C_ar
extends GuiScreen {
    private NetClientHandler netHandler;
    private int updateCounter = 0;

    public C_ar(NetClientHandler netClientHandler) {
        this.netHandler = netClientHandler;
    }

    @Override
    protected void a(char c, int n) {
    }

    @Override
    public void b() {
        this.e.clear();
    }

    @Override
    public void f_() {
        ++this.updateCounter;
        if (this.updateCounter % 20 == 0) {
            this.netHandler.addToSendQueue(new Packet0KeepAlive());
        }
        if (this.netHandler != null) {
            this.netHandler.processReadPackets();
        }
    }

    @Override
    protected void a(GuiButton guiButton) {
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_ar.a(this.g, this.netHandler.motd, this.c / 2, this.d / 2 - 4 - 16, 0xFFFFFF);
        C_ar.a(this.g, this.netHandler.serverName, this.c / 2, this.d / 2 - 4 + 8, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

