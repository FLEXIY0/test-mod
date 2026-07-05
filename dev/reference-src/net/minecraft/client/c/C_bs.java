/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.a.b.ItemStack;
import net.minecraft.client.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.C_bo;
import net.minecraft.client.c.C_bp;
import net.minecraft.client.c.C_bq;
import net.minecraft.client.c.C_br;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.d;
import net.minecraft.client.statistics.StatFileWriter;
import org.lwjgl.opengl.GL11;

public class C_bs
extends GuiScreen {
    private static C_e renderItem = new C_e();
    protected GuiScreen parentGui;
    protected String statsTitle = "Statistics";
    private C_bp slotGeneral;
    private C_bq slotItem;
    private C_bo slotBlock;
    private C_br slotMob;
    private StatFileWriter statFileWriter;
    private C_bm selectedSlot = null;

    public C_bs(GuiScreen guiScreen, StatFileWriter statFileWriter) {
        this.parentGui = guiScreen;
        this.statFileWriter = statFileWriter;
    }

    @Override
    public void b() {
        this.slotGeneral = new C_bp(this);
        this.slotGeneral.registerScrollButtons(this.e, 1, 1);
        this.slotItem = new C_bq(this);
        this.slotItem.registerScrollButtons(this.e, 1, 1);
        this.slotBlock = new C_bo(this);
        this.slotBlock.registerScrollButtons(this.e, 1, 1);
        this.slotMob = new C_br(this);
        this.slotMob.registerScrollButtons(this.e, 1, 1);
        this.selectedSlot = this.slotGeneral;
        this.addHeaderButtons();
    }

    public void addHeaderButtons() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 70, this.d - 28, 150, 20, "Done"));
        this.e.add(new GuiButton(1, this.c / 2 - 170, this.d - 52, 80, 20, "General"));
        GuiButton guiButton = new GuiButton(2, this.c / 2 - 80, this.d - 52, 80, 20, "Blocks");
        this.e.add(guiButton);
        GuiButton guiButton2 = new GuiButton(3, this.c / 2 + 10, this.d - 52, 80, 20, "Items");
        this.e.add(guiButton2);
        GuiButton guiButton3 = new GuiButton(4, this.c / 2 + 100, this.d - 52, 80, 20, "Mobs");
        this.e.add(guiButton3);
        if (this.slotBlock.getSize() == 0) {
            guiButton.c = false;
        }
        if (this.slotItem.getSize() == 0) {
            guiButton2.c = false;
        }
        if (this.slotMob.getSize() == 0) {
            guiButton3.c = false;
        }
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0) {
                this.b.a(this.parentGui);
            } else if (guiButton.b == 1) {
                this.selectedSlot = this.slotGeneral;
            } else if (guiButton.b == 3) {
                this.selectedSlot = this.slotItem;
            } else if (guiButton.b == 2) {
                this.selectedSlot = this.slotBlock;
            } else if (guiButton.b == 4) {
                this.selectedSlot = this.slotMob;
            } else {
                this.selectedSlot.actionPerformed(guiButton);
            }
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.selectedSlot.drawScreen(n, n2, f);
        C_bs.a(this.g, this.statsTitle, this.c / 2, 12, 0xFFFFFF);
        super.a(n, n2, f);
    }

    private void drawItemSprite(int n, int n2, int n3) {
        this.drawButtonBackground(n + 1, n2 + 1);
        GL11.glEnable((int)32826);
        GL11.glPushMatrix();
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        C_c.b();
        GL11.glPopMatrix();
        renderItem.a(this.b.m, new ItemStack(n3, 1, 0), n + 2, n2 + 2);
        C_c.a();
        GL11.glDisable((int)32826);
    }

    private void drawButtonBackground(int n, int n2) {
        this.drawSprite(n, n2, 0, 0);
    }

    private void drawSprite(int n, int n2, int n3, int n4) {
        int n5 = this.b.m.a("/gui/slot.png");
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(n5);
        C_d c_d = C_d.a;
        c_d.b();
        c_d.a(n + 0, n2 + 18, this.h, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        c_d.a(n + 18, n2 + 18, this.h, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f);
        c_d.a(n + 18, n2 + 0, this.h, (float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        c_d.a(n + 0, n2 + 0, this.h, (float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f);
        c_d.a();
    }

    static d getMinecraft(C_bs c_bs) {
        return c_bs.b;
    }

    static FontRenderer getFontRenderer(C_bs c_bs) {
        return c_bs.g;
    }

    public static StatFileWriter getStatsFileWriter(C_bs c_bs) {
        return c_bs.statFileWriter;
    }

    static void drawSprite(C_bs c_bs, int n, int n2, int n3, int n4) {
        c_bs.drawSprite(n, n2, n3, n4);
    }

    static void drawGradientRect(C_bs c_bs, int n, int n2, int n3, int n4, int n5, int n6) {
        C_bs.drawGradientRect(n, n2, n3, n4, n5, n6, 1.5f);
    }

    static void drawItemSprite(C_bs c_bs, int n, int n2, int n3) {
        c_bs.drawItemSprite(n, n2, n3);
    }
}

