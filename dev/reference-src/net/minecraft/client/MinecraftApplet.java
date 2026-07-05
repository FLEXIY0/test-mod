/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import net.minecraft.client.C_b;
import net.minecraft.client.C_l;
import net.minecraft.client.d;

public class MinecraftApplet
extends Applet {
    private static final long serialVersionUID = 1L;
    private Canvas a;
    private d b;
    private Thread c = null;

    @Override
    public void init() {
        this.a = new C_b(this);
        boolean bl = false;
        if (this.getParameter("fullscreen") != null) {
            bl = this.getParameter("fullscreen").equalsIgnoreCase("true");
        }
        this.b = new d(this.a, this, this.getWidth(), this.getHeight(), bl);
        this.b.i = this.getDocumentBase().getHost();
        if (this.getDocumentBase().getPort() > 0) {
            this.b.i = this.b.i + ":" + this.getDocumentBase().getPort();
        }
        if (this.getParameter("username") != null && this.getParameter("sessionid") != null) {
            this.b.h = new C_l(this.getParameter("username"), this.getParameter("sessionid"));
            if (this.getParameter("mppass") != null) {
                this.getParameter("mppass");
            }
        }
        if (this.getParameter("loadmap_user") != null && this.getParameter("loadmap_id") != null) {
            this.b.r = this.getParameter("loadmap_user");
            this.b.s = Integer.parseInt(this.getParameter("loadmap_id"));
        } else if (this.getParameter("server") != null && this.getParameter("port") != null) {
            this.b.a(this.getParameter("server"), Integer.parseInt(this.getParameter("port")));
        }
        this.b.k = true;
        this.setLayout(new BorderLayout());
        this.add((Component)this.a, "Center");
        this.a.setFocusable(true);
        this.validate();
    }

    public final void a() {
        if (this.c == null) {
            this.c = new Thread((Runnable)this.b, "Minecraft main thread");
            this.c.start();
        }
    }

    @Override
    public void start() {
        this.b.l = false;
    }

    @Override
    public void stop() {
        this.b.l = true;
    }

    @Override
    public void destroy() {
        this.b();
    }

    public final void b() {
        if (this.c != null) {
            this.b.A = false;
            try {
                this.c.join(1000L);
            }
            catch (InterruptedException interruptedException) {
                try {
                    this.b.a();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            this.c = null;
        }
    }
}

