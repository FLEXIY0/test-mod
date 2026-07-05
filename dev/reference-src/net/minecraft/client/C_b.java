/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

final class C_b
extends Canvas {
    private static final long serialVersionUID = 1L;
    private MinecraftApplet a;

    C_b(MinecraftApplet minecraftApplet) {
        this.a = minecraftApplet;
    }

    @Override
    public final synchronized void addNotify() {
        super.addNotify();
        this.a.a();
    }

    @Override
    public final synchronized void removeNotify() {
        this.a.b();
        super.removeNotify();
    }
}

