/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.client.a.C_d;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import org.lwjgl.opengl.GL11;

public class GuiCredits
extends GuiScreen {
    private GuiScreen parent;
    private String title = "Credits";
    private float oElapsedTicks = 0.1f;
    private float elapsedTicks = 0.1f;
    private float oScrollingBackgroundValue = 0.0f;
    private float scrollingBackgroundValue = 0.0f;

    public GuiCredits(GuiScreen guiScreen) {
        this.parent = guiScreen;
    }

    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c - 85, this.d - 25, 80, 20, "Go back"));
    }

    @Override
    public final void f_() {
        super.f_();
        this.oElapsedTicks = this.elapsedTicks;
        this.oScrollingBackgroundValue = this.scrollingBackgroundValue;
        int n = -750;
        if (this.b.w.guiScale == 0) {
            n = -900;
        } else if (this.b.w.guiScale == 1) {
            n = -1950;
        } else if (this.b.w.guiScale == 2) {
            n = -1250;
        } else if (this.b.w.guiScale == 3) {
            n = -1050;
        }
        if (this.elapsedTicks <= (float)n) {
            this.oElapsedTicks = 0.0f;
            this.elapsedTicks = 0.0f;
        }
        this.elapsedTicks -= 1.0f;
        this.scrollingBackgroundValue += 0.01f;
    }

    @Override
    protected final void a(GuiButton guiButton) {
        if (guiButton.c && guiButton.b == 0) {
            this.b.a(this.parent);
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        float f2 = this.oElapsedTicks + (this.elapsedTicks - this.oElapsedTicks) * f;
        float f3 = this.oScrollingBackgroundValue + (this.scrollingBackgroundValue - this.oScrollingBackgroundValue) * f;
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        int n3 = scaledResolution.a();
        int n4 = scaledResolution.b();
        GL11.glClear((int)16640);
        C_d c_d = C_d.a;
        int n5 = this.b.m.a("/dirt.png");
        GL11.glBindTexture((int)3553, (int)n5);
        float f4 = 32.0f;
        c_d.b();
        c_d.b(0x404040);
        c_d.a(0.0f, n4, 0.0f, 0.0f, (float)n4 / f4 + f3);
        c_d.a(n3, n4, 0.0f, (float)n3 / f4, (float)n4 / f4 + f3);
        c_d.a(n3, 0.0f, 0.0f, (float)n3 / f4, 0.0f + f3);
        c_d.a(0.0f, 0.0f, 0.0f, 0.0f, 0.0f + f3);
        c_d.a();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)f2, (float)0.0f);
        GuiCredits.a(this.g, this.title, this.c / 2, this.d + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7aIndev++ Development Team", this.c / 2, this.d + 30 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eYoniko: \u00a7fLead developer", this.c / 2, this.d + 45 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eGeneric PnP Monitor: \u00a7fProgrammer", this.c / 2, this.d + 60 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eNostalgiaModder: \u00a7fTexture artist", this.c / 2, this.d + 75 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7aFormer Members", this.c / 2, this.d + 100 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eStrultz: \u00a7fProgrammer", this.c / 2, this.d + 115 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eLassebq: \u00a7fProgrammer", this.c / 2, this.d + 130 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eRyPieEye: \u00a7fTexture artist", this.c / 2, this.d + 145 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eWarriorAlexOne: \u00a7fTexture artist", this.c / 2, this.d + 160 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eNitpick: \u00a7fTexture artist", this.c / 2, this.d + 175 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eContributors", this.c / 2, this.d + 200 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eMrLordSith: \u00a7fNetworking codebase", this.c / 2, this.d + 215 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7e314rft: \u00a7fOriginal chair model", this.c / 2, this.d + 230 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7ena_th_an: \u00a7fAdditional programming", this.c / 2, this.d + 245 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7ejonkadelic: \u00a7fSeasonal texture transitions", this.c / 2, this.d + 260 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eSoybean_56: \u00a7fMusic composer", this.c / 2, this.d + 275 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7enasko222: \u00a7fPalm tree code", this.c / 2, this.d + 290 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eBlueStaggo: \u00a7fLighting engine optimizations", this.c / 2, this.d + 305 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eSteve2024: \u00a7fAdditional texture work", this.c / 2, this.d + 320 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7dSpecial Thanks", this.c / 2, this.d + 355 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7ePaul Lamb: \u00a7fIndev sound library", this.c / 2, this.d + 370 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eMoresteck: \u00a7fBetacraft hosting and authentication", this.c / 2, this.d + 385 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7ePsychadeliCon: \u00a7fPortal system inspiration", this.c / 2, this.d + 400 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eJesette: \u00a7fMummy texture", this.c / 2, this.d + 415 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eCrackers0106: \u00a7fProgrammer Art+ assets", this.c / 2, this.d + 430 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eDock: \u00a7fOriginal MD3 models", this.c / 2, this.d + 445 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eNotch: \u00a7fFor creating Minecraft Indev", this.c / 2, this.d + 460 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eMatthaw: \u00a7fTesting lead and #1 player", this.c / 2, this.d + 475 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eTesters: \u00a7fAnyone who helped test the mod \u00a74<3", this.c / 2, this.d + 490 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eYou: \u00a7fFor playing this mod and your continued support", this.c / 2, this.d + 505 + 0, 0xFFFFFF);
        GuiCredits.a(this.g, "\u00a7eNotice: \u00a7fThis project is not associated with Mojang or Microsoft.", this.c / 2, this.d + 550 + 0, 0xFFFFFF);
        GL11.glPopMatrix();
        super.a(n, n2, f);
    }
}

