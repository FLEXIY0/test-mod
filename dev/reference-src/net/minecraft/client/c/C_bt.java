/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.GuiScreen;

public class C_bt
extends Gui {
    private final FontRenderer fontRenderer;
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;
    private String text;
    private String flavorText;
    private int maxStringLength;
    private int cursorCounter;
    public boolean isFocused = false;
    public boolean isEnabled = true;
    private GuiScreen parentGuiScreen;

    public C_bt(GuiScreen guiScreen, FontRenderer fontRenderer, int n, int n2, int n3, int n4, String string, String string2) {
        this.parentGuiScreen = guiScreen;
        this.fontRenderer = fontRenderer;
        this.xPos = n;
        this.yPos = n2;
        this.width = n3;
        this.height = n4;
        this.setText(string);
        this.flavorText = string2;
    }

    public C_bt(FontRenderer fontRenderer, int n, int n2, int n3, int n4) {
        this.fontRenderer = fontRenderer;
        this.xPos = n;
        this.yPos = n2;
        this.width = n3;
        this.height = n4;
        this.text = "";
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getText() {
        return this.text;
    }

    public void updateCursorCounter() {
        ++this.cursorCounter;
    }

    public void textboxKeyTyped(char c, int n) {
        if (this.isEnabled && this.isFocused) {
            if (c == '\t') {
                this.parentGuiScreen.selectNextField();
            }
            if (c == '\u0016') {
                int n2;
                String string = GuiScreen.getClipboardString();
                if (string == null) {
                    string = "";
                }
                if ((n2 = 32 - this.text.length()) > string.length()) {
                    n2 = string.length();
                }
                if (n2 > 0) {
                    this.text = this.text + string.substring(0, n2);
                }
            }
            if (n == 14 && this.text.length() > 0) {
                this.text = this.text.substring(0, this.text.length() - 1);
            }
            if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.fontRenderer.a(this.text) < this.width - 15 && (this.text.length() < this.maxStringLength || this.maxStringLength == 0)) {
                this.text = this.text + c;
            }
        }
    }

    public void mouseClicked(int n, int n2, int n3) {
        boolean bl = this.isEnabled && n >= this.xPos && n < this.xPos + this.width && n2 >= this.yPos && n2 < this.yPos + this.height;
        this.setFocused(bl);
    }

    public void setFocused(boolean bl) {
        if (bl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = bl;
    }

    public void drawTextBox() {
        int n = -8355711;
        if (this.isFocused) {
            n = -1;
        }
        C_bt.a(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, n);
        C_bt.a(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
        if (this.isEnabled) {
            boolean bl = this.isFocused && this.cursorCounter / 6 % 2 == 0;
            C_bt.b(this.fontRenderer, this.text + (bl ? "_" : ""), this.xPos + 4, this.yPos + (this.height - 8) / 2, 0xE0E0E0);
        } else {
            C_bt.b(this.fontRenderer, this.text, this.xPos + 4, this.yPos + (this.height - 8) / 2, 0x707070);
        }
        if (!this.isFocused && (this.text == "" || this.text.isEmpty())) {
            C_bt.b(this.fontRenderer, this.flavorText, this.xPos + 4, this.yPos + (this.height - 8) / 2, 0xE0E0E0);
        }
    }

    public void drawText(int n) {
        if (this.isEnabled) {
            boolean bl = this.isFocused && this.cursorCounter / 6 % 2 == 0;
            C_bt.b(this.fontRenderer, this.text + (bl ? "_" : ""), this.xPos + n, this.yPos + (this.height - 8) / 2, 0xE0E0E0);
        } else {
            C_bt.b(this.fontRenderer, this.text, this.xPos + n, this.yPos + (this.height - 8) / 2, 0x707070);
        }
        if (!this.isFocused && (this.text == "" || this.text.isEmpty())) {
            C_bt.b(this.fontRenderer, this.flavorText, this.xPos + n, this.yPos + (this.height - 8) / 2, 0xE0E0E0);
        }
    }

    public void setMaxStringLength(int n) {
        this.maxStringLength = n;
    }

    public void setFlavorText(String string) {
        this.flavorText = string;
    }
}

