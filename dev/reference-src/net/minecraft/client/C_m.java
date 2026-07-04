/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 */
package net.minecraft.client;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public final class C_m {
    public int a;
    public int b;

    public final void a() {
        Mouse.setGrabbed((boolean)true);
        this.a = 0;
        this.b = 0;
    }

    public final void b() {
        this.a = Mouse.getDX();
        this.b = -Mouse.getDY();
    }

    public void resetMouseCursor() {
        Mouse.setCursorPosition((int)(Display.getWidth() / 2), (int)(Display.getHeight() / 2));
        Mouse.setGrabbed((boolean)false);
    }
}

