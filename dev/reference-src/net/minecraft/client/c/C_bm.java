/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.util.List;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.d;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class C_bm {
    private final d mc;
    protected final int width;
    protected final int height;
    protected final int top;
    protected final int bottom;
    private final int right;
    private final int left;
    protected int slotHeight;
    private int scrollUpButtonID;
    private int scrollDownButtonID;
    protected int screenWidth;
    protected int screenHeight;
    private float initialClickY = -2.0f;
    private float scrollMultiplier;
    private float amountScrolled;
    private int selectedElement = -1;
    private long lastClicked = 0L;
    protected boolean active = true;
    private int maxHeight;
    private boolean doInteraction = false;

    public C_bm(d d2, int n, int n2, int n3, int n4, int n5) {
        this.mc = d2;
        this.width = n;
        this.height = n2;
        this.top = n3;
        this.bottom = n4;
        this.slotHeight = n5;
        this.left = 0;
        this.right = n;
    }

    public void setSlotActive(boolean bl) {
        this.active = bl;
    }

    protected void setMaxHeight(boolean bl, int n) {
        this.doInteraction = bl;
        this.maxHeight = n;
        if (!bl) {
            this.maxHeight = 0;
        }
    }

    public int getScrollValue(int n, int n2) {
        int n3 = this.width / 2 - 110;
        int n4 = this.width / 2 + 110;
        int n5 = n2 - this.top - this.maxHeight + (int)this.amountScrolled - 4;
        int n6 = n5 / this.slotHeight;
        return n >= n3 && n <= n4 && n6 >= 0 && n5 >= 0 && n6 < this.getSize() ? n6 : -1;
    }

    protected abstract int getSize();

    protected abstract void elementClicked(int var1, boolean var2);

    protected abstract boolean isSelected(int var1);

    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + this.maxHeight;
    }

    protected abstract void drawBackground();

    protected abstract void drawSlot(int var1, int var2, int var3, int var4, C_d var5);

    protected void onInteraction(int n, int n2, C_d c_d) {
    }

    protected void onClick(int n, int n2) {
    }

    protected void scrollFunc(int n, int n2) {
    }

    public void registerScrollButtons(List<?> list, int n, int n2) {
        this.scrollUpButtonID = n;
        this.scrollDownButtonID = n2;
    }

    private void bindAmountScrolled() {
        int n = this.getContentHeight() - (this.bottom - this.top - 4);
        if (n < 0) {
            n /= 2;
        }
        if (this.amountScrolled < 0.0f) {
            this.amountScrolled = 0.0f;
        }
        if (this.amountScrolled > (float)n) {
            this.amountScrolled = n;
        }
    }

    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == this.scrollUpButtonID) {
                this.amountScrolled -= (float)(this.slotHeight * 2 / 3);
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            } else if (guiButton.b == this.scrollDownButtonID) {
                this.amountScrolled += (float)(this.slotHeight * 2 / 3);
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            }
        }
    }

    public void drawScreen(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        this.screenWidth = n;
        this.screenHeight = n2;
        this.drawBackground();
        int n11 = this.getSize();
        int n12 = this.width / 2 + 124;
        int n13 = n12 + 6;
        if (Mouse.isButtonDown((int)0)) {
            if (this.initialClickY == -1.0f) {
                n10 = 1;
                if (n2 >= this.top && n2 <= this.bottom) {
                    n9 = this.width / 2 - 110;
                    n8 = this.width / 2 + 110;
                    n7 = n2 - this.top - this.maxHeight + (int)this.amountScrolled - 4;
                    n6 = n7 / this.slotHeight;
                    if (n >= n9 && n <= n8 && n6 >= 0 && n7 >= 0 && n6 < n11) {
                        n5 = n6 == this.selectedElement && System.currentTimeMillis() - this.lastClicked < 250L ? 1 : 0;
                        this.elementClicked(n6, n5 != 0);
                        this.selectedElement = n6;
                        this.lastClicked = System.currentTimeMillis();
                    } else if (n >= n9 && n <= n8 && n7 < 0) {
                        this.onClick(n - n9, n2 - this.top + (int)this.amountScrolled - 4);
                        n10 = 0;
                    }
                    if (n >= n12 && n <= n13) {
                        this.scrollMultiplier = -1.0f;
                        n4 = this.getContentHeight() - (this.bottom - this.top - 4);
                        if (n4 < 1) {
                            n4 = 1;
                        }
                        if ((n3 = (int)((float)((this.bottom - this.top) * (this.bottom - this.top)) / (float)this.getContentHeight())) < 32) {
                            n3 = 32;
                        }
                        if (n3 > this.bottom - this.top - 8) {
                            n3 = this.bottom - this.top - 8;
                        }
                        this.scrollMultiplier /= (float)(this.bottom - this.top - n3) / (float)n4;
                    } else {
                        this.scrollMultiplier = 1.0f;
                    }
                    this.initialClickY = n10 != 0 ? (float)n2 : -2.0f;
                } else {
                    this.initialClickY = -2.0f;
                }
            } else if (this.initialClickY >= 0.0f) {
                this.amountScrolled -= ((float)n2 - this.initialClickY) * this.scrollMultiplier;
                this.initialClickY = n2;
            }
        } else {
            while (Mouse.next()) {
                n10 = Mouse.getEventDWheel();
                if (n10 == 0) continue;
                if (n10 > 0) {
                    n10 = -1;
                } else if (n10 < 0) {
                    n10 = 1;
                }
                this.amountScrolled += (float)(n10 * this.slotHeight / 2);
            }
            this.initialClickY = -1.0f;
        }
        this.bindAmountScrolled();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2912);
        C_d c_d = C_d.a;
        if (this.mc.d == null) {
            GL11.glBindTexture((int)3553, (int)this.mc.m.a("/dirt.png"));
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            float f2 = 32.0f;
            c_d.b();
            c_d.b(0x202020);
            c_d.a(this.left, this.bottom, 0.0f, (float)this.left / f2, (float)(this.bottom + (int)this.amountScrolled) / f2);
            c_d.a(this.right, this.bottom, 0.0f, (float)this.right / f2, (float)(this.bottom + (int)this.amountScrolled) / f2);
            c_d.a(this.right, this.top, 0.0f, (float)this.right / f2, (float)(this.top + (int)this.amountScrolled) / f2);
            c_d.a(this.left, this.top, 0.0f, (float)this.left / f2, (float)(this.top + (int)this.amountScrolled) / f2);
            c_d.a();
        }
        n8 = this.width / 2 - 92 - 16;
        n7 = this.top + 4 - (int)this.amountScrolled;
        if (this.doInteraction) {
            this.onInteraction(n8, n7, c_d);
        }
        GL11.glDisable((int)3553);
        n4 = this.getContentHeight() - (this.bottom - this.top - 4);
        if (n4 > 0) {
            n3 = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
            if (n3 < 32) {
                n3 = 32;
            }
            if (n3 > this.bottom - this.top - 8) {
                n3 = this.bottom - this.top - 8;
            }
            if ((n9 = (int)this.amountScrolled * (this.bottom - this.top - n3) / n4 + this.top) < this.top) {
                n9 = this.top;
            }
            c_d.b();
            c_d.setColorRGBA_I(0, 255);
            c_d.a(n12, this.bottom, 0.0f, 0.0f, 1.0f);
            c_d.a(n13, this.bottom, 0.0f, 1.0f, 1.0f);
            c_d.a(n13, this.top, 0.0f, 1.0f, 0.0f);
            c_d.a(n12, this.top, 0.0f, 0.0f, 0.0f);
            c_d.a();
            c_d.b();
            c_d.setColorRGBA_I(0x808080, 255);
            c_d.a(n12, n9 + n3, 0.0f, 0.0f, 1.0f);
            c_d.a(n13, n9 + n3, 0.0f, 1.0f, 1.0f);
            c_d.a(n13, n9, 0.0f, 1.0f, 0.0f);
            c_d.a(n12, n9, 0.0f, 0.0f, 0.0f);
            c_d.a();
            c_d.b();
            c_d.setColorRGBA_I(0xC0C0C0, 255);
            c_d.a(n12, n9 + n3 - 1, 0.0f, 0.0f, 1.0f);
            c_d.a(n13 - 1, n9 + n3 - 1, 0.0f, 1.0f, 1.0f);
            c_d.a(n13 - 1, n9, 0.0f, 1.0f, 0.0f);
            c_d.a(n12, n9, 0.0f, 0.0f, 0.0f);
            c_d.a();
        }
        GL11.glEnable((int)3553);
        for (n6 = 0; n6 < n11; ++n6) {
            n4 = n7 + n6 * this.slotHeight + this.maxHeight;
            n3 = this.slotHeight - 4;
            if (n4 > this.bottom || n4 + n3 < this.top) continue;
            if (this.active && this.isSelected(n6)) {
                n9 = this.width / 2 - 110;
                n5 = this.width / 2 + 110;
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glDisable((int)3553);
                c_d.b();
                c_d.b(0x808080);
                c_d.a(n9, n4 + n3 + 2, 0.0f, 0.0f, 1.0f);
                c_d.a(n5, n4 + n3 + 2, 0.0f, 1.0f, 1.0f);
                c_d.a(n5, n4 - 2, 0.0f, 1.0f, 0.0f);
                c_d.a(n9, n4 - 2, 0.0f, 0.0f, 0.0f);
                c_d.b(0);
                c_d.a(n9 + 1, n4 + n3 + 1, 0.0f, 0.0f, 1.0f);
                c_d.a(n5 - 1, n4 + n3 + 1, 0.0f, 1.0f, 1.0f);
                c_d.a(n5 - 1, n4 - 1, 0.0f, 1.0f, 0.0f);
                c_d.a(n9 + 1, n4 - 1, 0.0f, 0.0f, 0.0f);
                c_d.a();
                GL11.glEnable((int)3553);
            }
            if (n8 <= 0 || n8 >= this.height) continue;
            this.drawSlot(n6, n8, n4, n3, c_d);
        }
        GL11.glDisable((int)2929);
        n5 = 4;
        this.overlayBackground(0, this.top, 255, 255);
        this.overlayBackground(this.bottom, this.height, 255, 255);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3008);
        GL11.glShadeModel((int)7425);
        c_d.b();
        c_d.setColorRGBA_I(0, 0);
        c_d.a(this.left, this.top + n5, 0.0f, 0.0f, 1.0f);
        c_d.a(this.right, this.top + n5, 0.0f, 1.0f, 1.0f);
        c_d.setColorRGBA_I(0, 255);
        c_d.a(this.right, this.top, 0.0f, 1.0f, 0.0f);
        c_d.a(this.left, this.top, 0.0f, 0.0f, 0.0f);
        c_d.a();
        c_d.b();
        c_d.setColorRGBA_I(0, 255);
        c_d.a(this.left, this.bottom, 0.0f, 0.0f, 1.0f);
        c_d.a(this.right, this.bottom, 0.0f, 1.0f, 1.0f);
        c_d.setColorRGBA_I(0, 0);
        c_d.a(this.right, this.bottom - n5, 0.0f, 1.0f, 0.0f);
        c_d.a(this.left, this.bottom - n5, 0.0f, 0.0f, 0.0f);
        c_d.a();
        this.scrollFunc(n, n2);
        GL11.glEnable((int)3553);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)3008);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
    }

    private void overlayBackground(int n, int n2, int n3, int n4) {
        C_d c_d = C_d.a;
        GL11.glBindTexture((int)3553, (int)this.mc.m.a("/dirt.png"));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f = 32.0f;
        c_d.b();
        c_d.setColorRGBA_I(0x404040, n4);
        c_d.a(0.0f, n2, 0.0f, 0.0f, (float)n2 / f);
        c_d.a(this.width, n2, 0.0f, (float)this.width / f, (float)n2 / f);
        c_d.setColorRGBA_I(0x404040, n3);
        c_d.a(this.width, n, 0.0f, (float)this.width / f, (float)n / f);
        c_d.a(0.0f, n, 0.0f, 0.0f, (float)n / f);
        c_d.a();
    }
}

