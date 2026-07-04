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

public class C_au
extends GuiScreen {
    private GuiScreen parentGui;
    private C_bt serverAddress;
    private C_bt serverName;
    private C_ax srvListItem;
    final /* synthetic */ C_ba this$0;

    public C_au(C_ba c_ba, GuiScreen guiScreen, C_ax c_ax) {
        this.this$0 = c_ba;
        this.parentGui = guiScreen;
        this.srvListItem = c_ax;
    }

    @Override
    public void f_() {
        this.serverName.updateCursorCounter();
        this.serverAddress.updateCursorCounter();
    }

    @Override
    public void b() {
        Keyboard.enableRepeatEvents((boolean)true);
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 96 + 12, "Add Server"));
        this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 120 + 12, "Cancel"));
        this.serverName = new C_bt(this.g, this.c / 2 - 100, 76, 200, 20);
        this.serverName.setFocused(true);
        this.serverName.setText(this.srvListItem.name);
        this.serverAddress = new C_bt(this.g, this.c / 2 - 100, 116, 200, 20);
        this.serverAddress.setMaxStringLength(128);
        this.serverAddress.setText(this.srvListItem.ip);
        ((GuiButton)this.e.get((int)0)).c = this.serverAddress.getText().length() > 0 && this.serverAddress.getText().split(":").length > 0 && this.serverName.getText().length() > 0;
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
                this.parentGui.confirmClicked(false, 0);
            } else if (guiButton.b == 0) {
                this.srvListItem.name = this.serverName.getText();
                this.srvListItem.ip = this.serverAddress.getText();
                this.parentGui.confirmClicked(true, 0);
            }
        }
    }

    @Override
    protected void a(char c, int n) {
        String string;
        String[] stringArray;
        this.serverName.textboxKeyTyped(c, n);
        this.serverAddress.textboxKeyTyped(c, n);
        if (c == '\t') {
            if (this.serverName.isFocused) {
                this.serverName.setFocused(false);
                this.serverAddress.setFocused(true);
            } else {
                this.serverName.setFocused(true);
                this.serverAddress.setFocused(false);
            }
        }
        if (c == '\r') {
            this.a((GuiButton)this.e.get(0));
        }
        boolean bl = ((GuiButton)this.e.get((int)0)).c = this.serverAddress.getText().length() > 0 && this.serverAddress.getText().split(":").length > 0 && this.serverName.getText().length() > 0;
        if (((GuiButton)this.e.get((int)0)).c && (stringArray = (string = this.serverAddress.getText().trim()).split(":")).length > 2) {
            ((GuiButton)this.e.get((int)0)).c = false;
        }
    }

    @Override
    protected void mouseClick(int n, int n2, int n3) {
        super.mouseClick(n, n2, n3);
        this.serverAddress.mouseClicked(n, n2, n3);
        this.serverName.mouseClicked(n, n2, n3);
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_au.a(this.g, "Add Server", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
        C_au.b(this.g, "Name", this.c / 2 - 100, 63, 0xA0A0A0);
        C_au.b(this.g, "IP Address / host name", this.c / 2 - 100, 104, 0xA0A0A0);
        this.serverName.drawTextBox();
        this.serverAddress.drawTextBox();
        super.a(n, n2, f);
    }
}

