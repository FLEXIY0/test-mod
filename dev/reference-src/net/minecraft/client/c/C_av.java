/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package net.minecraft.client.c;

import net.minecraft.client.c.C_ax;
import net.minecraft.client.c.C_ba;
import net.minecraft.client.c.C_bt;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.input.Keyboard;

public class C_av
extends GuiScreen {
    private final GuiScreen guiScreen;
    private final C_ax serverListStorage;
    private C_bt serverTextField;
    final /* synthetic */ C_ba this$0;

    public C_av(C_ba c_ba, GuiScreen guiScreen, C_ax c_ax) {
        this.this$0 = c_ba;
        this.guiScreen = guiScreen;
        this.serverListStorage = c_ax;
    }

    @Override
    public void f_() {
        this.serverTextField.updateCursorCounter();
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 96 + 12, "Connect"));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 120 + 12, "Cancel"));
        this.serverTextField = new C_bt(this.g, this.c / 2 - 100, 116, 200, 20);
        this.serverTextField.setMaxStringLength(128);
        this.serverTextField.setFocused(true);
        String string = this.b.w.lastServer;
        if (string.length() != 0) {
            this.serverTextField.setText(string.trim());
        } else {
            this.serverTextField.setText("");
        }
        if (this.serverTextField.getText() != null) {
            ((GuiButton)this.e.get((int)0)).c = this.serverTextField.getText().length() > 0 && this.serverTextField.getText().split(":").length > 0;
        }
    }

    @Override
    public void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 1) {
                this.guiScreen.confirmClicked(false, 0);
            } else if (guiButton.b == 0) {
                String string;
                this.b.w.lastServer = string = this.serverTextField.getText();
                this.b.w.a();
                this.serverListStorage.ip = string;
                this.guiScreen.confirmClicked(true, 0);
            }
        }
    }

    @Override
    protected void a(char c, int n) {
        this.serverTextField.textboxKeyTyped(c, n);
        if (c == '\u001c') {
            this.a((GuiButton)this.e.get(0));
        }
        ((GuiButton)this.e.get((int)0)).c = this.serverTextField.getText().length() > 0 && this.serverTextField.getText().split(":").length > 0;
    }

    @Override
    protected void mouseClick(int n, int n2, int n3) {
        super.mouseClick(n, n2, n3);
        this.serverTextField.mouseClicked(n, n2, n3);
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_av.a(this.g, "Direct Connect", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
        C_av.b(this.g, "IP Address / host name", this.c / 2 - 100, 100, 0xA0A0A0);
        this.serverTextField.drawTextBox();
        super.a(n, n2, f);
    }
}

