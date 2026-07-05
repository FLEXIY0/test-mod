/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import net.minecraft.a.b.ItemStack;
import net.minecraft.client.C_c;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.d;
import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.AchievementList;
import org.lwjgl.opengl.GL11;

public class GuiAchievement
extends Gui {
    private d theGame;
    private int achievementWindowWidth;
    private int achievementWindowHeight;
    private String achievementGetLocalText;
    private String achievementStatName;
    private Achievement theAchievement;
    private long achievementTime;
    private C_e itemRender = new C_e();
    private boolean haveAchiement;
    private boolean isRecipe = false;
    private ItemStack theItem;

    public GuiAchievement(d d2) {
        this.theGame = d2;
    }

    public void queueTakenAchievement(Achievement achievement) {
        this.theGame.x.a("random.in", 1.0f, 1.0f);
        if (this.theGame.isMultiplayerWorld() || this.theGame.f.gamemode == 2) {
            return;
        }
        this.achievementGetLocalText = achievement.getSpecial() ? "Challenge complete!" : "Achievement get!";
        this.achievementStatName = achievement.getName();
        this.achievementTime = System.currentTimeMillis();
        this.theAchievement = achievement;
        this.haveAchiement = false;
        this.isRecipe = false;
    }

    public void queueAchievementInformation(Achievement achievement) {
        if (this.theGame.isMultiplayerWorld() || this.theGame.f.gamemode == 2) {
            return;
        }
        this.achievementGetLocalText = achievement.getName();
        this.achievementStatName = achievement.getDescription();
        this.achievementTime = System.currentTimeMillis() - 2500L;
        this.theAchievement = achievement;
        this.haveAchiement = true;
        this.isRecipe = false;
    }

    public void queueRecipeInformation(ItemStack itemStack) {
        this.theGame.x.a("random.in", 1.0f, 1.0f);
        if (this.theGame.isMultiplayerWorld() || this.theGame.f.gamemode == 2) {
            return;
        }
        this.achievementGetLocalText = "New recipe unlocked!";
        this.achievementStatName = itemStack.getItemName();
        this.achievementTime = System.currentTimeMillis();
        this.theItem = itemStack;
        this.haveAchiement = false;
        this.isRecipe = true;
    }

    private void updateAchievementWindowScale() {
        if (this.theGame.isMultiplayerWorld()) {
            return;
        }
        GL11.glPushMatrix();
        GL11.glViewport((int)0, (int)0, (int)this.theGame.b, (int)this.theGame.c);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        this.achievementWindowWidth = this.theGame.b;
        this.achievementWindowHeight = this.theGame.c;
        ScaledResolution scaledResolution = new ScaledResolution(this.theGame.w, this.theGame.b, this.theGame.c);
        this.achievementWindowWidth = scaledResolution.a();
        this.achievementWindowHeight = scaledResolution.b();
        GL11.glClear((int)256);
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        GL11.glOrtho((double)0.0, (double)this.achievementWindowWidth, (double)this.achievementWindowHeight, (double)0.0, (double)1000.0, (double)3000.0);
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-2000.0f);
        GL11.glPopMatrix();
    }

    public void updateAchievementWindow() {
        if (this.theGame.isMultiplayerWorld()) {
            return;
        }
        if (this.theAchievement != null && this.achievementTime != 0L || this.isRecipe && this.achievementTime != 0L) {
            double d2 = (double)(System.currentTimeMillis() - this.achievementTime) / 5000.0;
            if (d2 < 0.0 || d2 > 1.0) {
                this.theGame.x.a("random.out", 1.0f, 1.0f);
                this.achievementTime = 0L;
            } else {
                this.updateAchievementWindowScale();
                double d3 = d2 * 2.0;
                if (d3 > 1.0) {
                    d3 = 2.0 - d3;
                }
                d3 *= 4.0;
                if ((d3 = 1.0 - d3) < 0.0) {
                    d3 = 0.0;
                }
                d3 *= d3;
                d3 *= d3;
                int n = this.achievementWindowWidth - 160 + (int)(d3 * 160.0);
                int n2 = 0;
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                int n3 = this.theGame.m.a("/achievement/bg.png");
                GL11.glEnable((int)3553);
                GL11.glBindTexture((int)3553, (int)n3);
                GL11.glDisable((int)2896);
                this.b(n, n2, 96, 0, 160, 32);
                if (!this.isRecipe) {
                    if (this.theAchievement.getSpecial()) {
                        this.b(n + 3, n2 + 3, 26, 0, 26, 26);
                    } else {
                        this.b(n + 3, n2 + 3, 0, 0, 26, 26);
                    }
                } else {
                    this.b(n + 3, n2 + 3, 52, 0, 26, 26);
                }
                if (this.haveAchiement || this.theAchievement == AchievementList.openInventory) {
                    this.theGame.n.drawSplitString(this.theAchievement.getDescription(), n + 32, n2 + 7, 120, -1);
                } else {
                    this.theGame.n.b(this.achievementGetLocalText, n + 32, n2 + 7, -256);
                    this.theGame.n.b(this.achievementStatName, n + 32, n2 + 18, -1);
                }
                GL11.glPushMatrix();
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                C_c.b();
                GL11.glPopMatrix();
                GL11.glDisable((int)2896);
                GL11.glEnable((int)32826);
                GL11.glEnable((int)2903);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
                if (this.isRecipe) {
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                    this.itemRender.a(this.theGame.m, this.theItem, n + 8, n2 + 8);
                } else if (this.theAchievement == AchievementList.trophy) {
                    this.itemRender.renderItemIntoGUI(this.theGame.m, this.theAchievement.theItemStack.c, this.theAchievement.theItemStack.d, 385, n + 8, n2 + 8);
                } else {
                    this.itemRender.a(this.theGame.m, this.theAchievement.theItemStack, n + 8, n2 + 8);
                }
                GL11.glDisable((int)2896);
                GL11.glDisable((int)2929);
                GL11.glDisable((int)2903);
                GL11.glDisable((int)32826);
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            }
        }
    }
}

