/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public final class C_ag
extends GuiScreen {
    public String message = "";
    private int counter = 0;

    @Override
    public final void b() {
        this.b.f.resetPlayerKeyState();
        Keyboard.enableRepeatEvents((boolean)true);
    }

    @Override
    public final void a() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public final void f_() {
        ++this.counter;
    }

    @Override
    protected final void a(char c, int n) {
        if (Keyboard.getEventKey() == 1) {
            this.b.a((GuiScreen)null);
        }
        if (n == 28) {
            if (!this.message.trim().isEmpty()) {
                this.b.f.sendMessage(this.message.trim());
                this.b.lastChatMessage = this.message;
            }
            this.b.a((GuiScreen)null);
        } else if (n == 200) {
            if (this.b.lastChatMessage != null) {
                this.message = this.b.lastChatMessage;
            }
        } else {
            if (n == 14 && this.message.length() > 0) {
                this.message = this.message.substring(0, this.message.length() - 1);
            }
            if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.message.length() <= 64) {
                this.message = this.message + c;
            }
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        C_ag.a(2, this.d - 14, this.c - 2, this.d - 2, Integer.MIN_VALUE);
        C_ag.b(this.g, this.message + (this.counter / 6 % 2 == 0 ? "_" : ""), 4, this.d - 12, 0xE0E0E0);
    }
}

