/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.C_ax;
import net.minecraft.client.c.C_ay;
import net.minecraft.client.c.C_ba;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.Gui;
import org.lwjgl.opengl.GL11;

class C_az
extends C_bm {
    final /* synthetic */ C_ba this$0;

    public C_az(C_ba c_ba) {
        this.this$0 = c_ba;
        super(c_ba.b, c_ba.c, c_ba.d, 32, c_ba.d - 64, 48);
    }

    @Override
    protected int getSize() {
        return C_ba.access$000(this.this$0).size();
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
        boolean bl2;
        C_ba.access$102(this.this$0, n);
        C_ba.access$200((C_ba)this.this$0).c = bl2 = C_ba.access$100(this.this$0) >= 0 && C_ba.access$100(this.this$0) < this.getSize();
        C_ba.access$300((C_ba)this.this$0).c = bl2;
        C_ba.access$400((C_ba)this.this$0).c = bl2;
        if (bl && bl2) {
            C_ba.access$500(this.this$0, n);
        }
    }

    @Override
    protected boolean isSelected(int n) {
        return n == C_ba.access$100(this.this$0);
    }

    @Override
    protected int getContentHeight() {
        return C_ba.access$000(this.this$0).size() * 48;
    }

    @Override
    protected void drawBackground() {
        this.this$0.h();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        int n5;
        int n6;
        C_ax c_ax = (C_ax)C_ba.access$000(this.this$0).get(n);
        Object object = C_ba.access$600();
        synchronized (object) {
            if (C_ba.access$700() < 5 && !c_ax.pinged) {
                c_ax.pinged = true;
                c_ax.ping = -2L;
                c_ax.motd = "";
                c_ax.serversideName = "";
                c_ax.playerCount = "";
                C_ba.access$708();
                new C_ay(this, c_ax).start();
            }
        }
        Gui.b(this.this$0.g, c_ax.name, n2 + 2, n3 + 1, 0xFFFFFF);
        Gui.b(this.this$0.g, c_ax.serversideName, n2 + 2, n3 + 12, 0xBFBFBF);
        Gui.b(this.this$0.g, c_ax.motd, n2 + 2, n3 + 12 + 11, 0xBFBFBF);
        Gui.b(this.this$0.g, c_ax.playerCount, n2 + 215 - this.this$0.g.a(c_ax.playerCount), n3 + 12, 0x808080);
        object = C_ba.access$900(this.this$0, c_ax.gamemode);
        Gui.b(this.this$0.g, (String)object, n2 + 215 - this.this$0.g.a((String)object), n3 + 12 + 22, 0x808080);
        Gui.b(this.this$0.g, c_ax.ip, n2 + 2, n3 + 12 + 22, 0x303030);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(this.this$0.b.m.a("/gui/icons.png"));
        String string = "";
        if (c_ax.pinged && c_ax.ping != -2L) {
            n6 = 0;
            n5 = c_ax.ping < 0L ? 5 : (c_ax.ping < 150L ? 0 : (c_ax.ping < 300L ? 1 : (c_ax.ping < 600L ? 2 : (c_ax.ping < 1000L ? 3 : 4))));
            string = c_ax.ping < 0L ? "(no connection)" : c_ax.ping + "ms";
        } else {
            n6 = 1;
            n5 = (int)(System.currentTimeMillis() / 100L + (long)(n * 2) & 7L);
            if (n5 > 4) {
                n5 = 8 - n5;
            }
            string = "Pinging..";
        }
        this.this$0.b(n2 + 205, n3, 0 + n6 * 10, 31 + n5 * 8, 10, 8);
        int n7 = 4;
        if (this.screenWidth >= n2 + 205 - n7 && this.screenHeight >= n3 - n7 && this.screenWidth <= n2 + 205 + 10 + n7 && this.screenHeight <= n3 + 8 + n7) {
            C_ba.access$1002(this.this$0, string);
        }
    }
}

