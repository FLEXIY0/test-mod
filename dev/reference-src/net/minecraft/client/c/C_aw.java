/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.C_a;
import net.minecraft.client.c.C_ba;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;

public class C_aw
extends GuiScreen {
    private GuiScreen parentScreen;
    private String message1;
    private String message2;
    protected String buttonText1;
    protected String buttonText2;
    private int worldNumber;
    final /* synthetic */ C_ba this$0;

    public C_aw(C_ba c_ba, GuiScreen guiScreen, String string, String string2, int n) {
        this.this$0 = c_ba;
        this.parentScreen = guiScreen;
        this.message1 = string;
        this.message2 = string2;
        this.worldNumber = n;
        this.buttonText1 = "Yes";
        this.buttonText2 = "No";
    }

    public C_aw(C_ba c_ba, GuiScreen guiScreen, String string, String string2, String string3, String string4, int n) {
        this.this$0 = c_ba;
        this.parentScreen = guiScreen;
        this.message1 = string;
        this.message2 = string2;
        this.buttonText1 = string3;
        this.buttonText2 = string4;
        this.worldNumber = n;
    }

    @Override
    public void b() {
        this.e.add(new C_a(0, this.c / 2 - 155, this.d / 6 + 96, this.buttonText1));
        this.e.add(new C_a(1, this.c / 2 - 155 + 160, this.d / 6 + 96, this.buttonText2));
    }

    @Override
    protected void a(GuiButton guiButton) {
        this.parentScreen.confirmClicked(guiButton.b == 0, this.worldNumber);
    }

    @Override
    public void a(int n, int n2, float f) {
        this.h();
        C_aw.a(this.g, this.message1, this.c / 2, 70, 0xFFFFFF);
        C_aw.a(this.g, this.message2, this.c / 2, 90, 0xFFFFFF);
        super.a(n, n2, f);
    }
}

