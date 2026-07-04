/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;
import net.minecraft.a.b.a.C_l;
import net.minecraft.a.b.a.C_r;
import net.minecraft.client.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.C_ac;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.Gui;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.IAchieveDisplay;
import net.minecraft.client.statistics.StatFileWriter;
import net.minecraft.client.statistics.StatList;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

class C_ab
extends C_bm {
    private C_ac theAchievements;
    final /* synthetic */ C_ac this$0;

    public C_ab(C_ac c_ac, C_ac c_ac2) {
        this.this$0 = c_ac;
        super(c_ac2.b, c_ac2.c, c_ac2.d, 32, c_ac2.d - 64, 36);
        this.theAchievements = c_ac2;
        if (C_ac.access$000(c_ac) == 2) {
            this.setSlotHeight(72);
            this.setMaxHeight(true, 2);
        } else {
            this.setSlotHeight(36);
            this.setMaxHeight(true, -12);
        }
    }

    @Override
    protected int getSize() {
        return C_ac.access$000(this.this$0) == 2 ? MathHelper.ceil_float((float)C_ac.access$100(this.this$0).size() / 2.0f) : (C_ac.access$000(this.this$0) == 1 ? AchievementList.challengeDisplayList.size() : AchievementList.achieveDisplayList.size());
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
    }

    @Override
    protected boolean isSelected(int n) {
        return false;
    }

    @Override
    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + (C_ac.access$000(this.this$0) == 2 ? 4 : 0);
    }

    protected void setSlotHeight(int n) {
        this.slotHeight = n;
    }

    @Override
    protected void drawBackground() {
        this.this$0.h();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        if (C_ac.access$000(this.this$0) == 2) {
            List<C_l> list = this.this$0.switchList();
            ArrayList<C_l> arrayList = new ArrayList<C_l>();
            for (C_l c_l : list) {
                if (!C_f.a().getUnlockedRecipeList().contains(c_l) || !c_l.getRecipeOutput().getItemName().toLowerCase().contains(C_ac.access$200(this.this$0).toLowerCase())) continue;
                arrayList.add(c_l);
            }
            if (!C_ac.access$200(this.this$0).isEmpty() && arrayList.size() > 0) {
                C_ac.access$102(this.this$0, arrayList);
            } else {
                C_ac.access$102(this.this$0, list);
            }
            try {
                C_l c_l;
                C_l c_l2 = (C_l)C_ac.access$100(this.this$0).get(n * 2);
                c_l = null;
                if (n * 2 + 1 < C_ac.access$100(this.this$0).size()) {
                    c_l = (C_l)C_ac.access$100(this.this$0).get(n * 2 + 1);
                }
                int n5 = 106;
                int n6 = n2 + 110 - n5 / 2;
                int n7 = n2 + 110 + 2;
                if (c_l != null) {
                    n6 = n2 + 110 - n5 - 2;
                }
                if (c_l != null) {
                    this.drawRecipe(c_l, n7, n3);
                }
                this.drawRecipe(c_l2, n6, n3);
            }
            catch (Exception exception) {
                return;
            }
            return;
        }
        IAchieveDisplay iAchieveDisplay = C_ac.access$000(this.this$0) == 1 ? AchievementList.challengeDisplayList.get(n) : AchievementList.achieveDisplayList.get(n);
        switch (iAchieveDisplay.getType()) {
            case 0: {
                int n8 = 0xFFFFFF;
                if (this.this$0.statFileWriter.hasAchievementUnlocked(iAchieveDisplay.getAchievement())) {
                    n8 = 0xFFFF55;
                }
                int n9 = 0;
                boolean bl = false;
                if (this.this$0.statFileWriter.hasAchievementUnlocked(iAchieveDisplay.getAchievement())) {
                    n9 = 28;
                }
                if (!this.this$0.statFileWriter.hasAchievementUnlocked(iAchieveDisplay.getAchievement().parentAchievement) && iAchieveDisplay.getAchievement().parentAchievement != null) {
                    GL11.glColor4f((float)0.3f, (float)0.3f, (float)0.3f, (float)1.0f);
                    n8 = 0x4C4C4C;
                    bl = true;
                } else {
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                }
                RenderEngine.a(this.theAchievements.b.m.a("/achievement/bg.png"));
                this.theAchievements.b(n2, n3, 0, 58, 216, 32);
                if (iAchieveDisplay.getAchievement().getSpecial()) {
                    this.theAchievements.b(n2 + 3, n3 + 3, 26, n9, 26, 26);
                } else {
                    this.theAchievements.b(n2 + 3, n3 + 3, 0, n9, 26, 26);
                }
                GL11.glEnable((int)32826);
                GL11.glPushMatrix();
                GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                C_c.b();
                GL11.glPopMatrix();
                GL11.glEnable((int)2903);
                GL11.glEnable((int)2884);
                if (iAchieveDisplay.getAchievement() == AchievementList.trophy) {
                    C_ac.access$300().renderItemIntoGUI(this.theAchievements.b.m, iAchieveDisplay.getAchievement().theItemStack.c, iAchieveDisplay.getAchievement().theItemStack.d, 385, n2 + 3 + 2 + 3, n3 + 3 + 2 + 3);
                } else {
                    C_ac.access$300().a(this.theAchievements.b.m, iAchieveDisplay.getAchievement().theItemStack, n2 + 3 + 2 + 3, n3 + 3 + 2 + 3);
                }
                GL11.glDisable((int)2903);
                C_c.a();
                GL11.glDisable((int)32826);
                this.this$0.g.b(iAchieveDisplay.getName(), n2 + 32, n3 + 7, n8);
                this.this$0.g.drawSplitString(iAchieveDisplay.getAchievement().getDescription(), n2 + 32, n3 + 18, 184, bl ? 2829132 : 0x9090FF);
                GL11.glColor4f((float)0.3f, (float)0.3f, (float)0.3f, (float)1.0f);
                if (bl) {
                    int n10 = this.theAchievements.b.m.a("/gui/gui.png");
                    RenderEngine.a(n10);
                    this.theAchievements.b(n2 + 216 - 10 - 9, n3 + 9, 40, 146, 10, 14);
                }
                String string = "";
                string = this.screenWidth >= n2 && this.screenHeight >= n3 && this.screenWidth <= n2 + 215 && this.screenHeight <= n3 + 30 && bl ? "Requires: " + iAchieveDisplay.getAchievement().parentAchievement.getName() : "";
                string = ("" + string).trim();
                if (string.length() > 0) {
                    int n11 = this.screenWidth + 12;
                    int n12 = this.screenHeight - 12;
                    int n13 = this.theAchievements.g.a(string);
                    Gui.drawGradientRect(n11 - 3, n12 - 3, n11 + n13 + 3, n12 + 8 + 3, 0x60050500, -1607454624, 1.5f);
                    this.theAchievements.g.a(string, n11, n12, -1);
                }
                return;
            }
            case 1: {
                String string = iAchieveDisplay.getName();
                int n14 = this.theAchievements.g.a(string);
                int n15 = 3;
                int n16 = 3;
                int n17 = 3;
                int n18 = n2 + n15;
                int n19 = n2 + 108 - n16 - n14 / 2;
                int n20 = n2 + 108 + n16 + n14 / 2;
                int n21 = n2 + 216 - n15;
                int n22 = n3 + 20;
                int n23 = n3 + 21;
                int n24 = n3 + 20 + n17;
                int n25 = n3 + 21 + n17;
                Gui.a(n18 + 0, n22 + 0, n19 + 0, n23 + 0, -1);
                Gui.a(n18 + 1, n22 + 1, n19 + 1, n23 + 1, -12632257);
                Gui.a(n18 + 0, n24 + 0, n19 + 0, n25 + 0, -1);
                Gui.a(n18 + 1, n24 + 1, n19 + 1, n25 + 1, -12632257);
                Gui.a(n20 + 0, n22 + 0, n21 + 0, n23 + 0, -1);
                Gui.a(n20 + 1, n22 + 1, n21 + 1, n23 + 1, -12632257);
                Gui.a(n20 + 0, n24 + 0, n21 + 0, n25 + 0, -1);
                Gui.a(n20 + 1, n24 + 1, n21 + 1, n25 + 1, -12632257);
                this.theAchievements.g.a(string, n2 + 108 - n14 / 2, n3 + 18, iAchieveDisplay.getColor());
                return;
            }
        }
    }

    private void drawRecipe(C_l c_l, int n, int n2) {
        int n3;
        int n4;
        int n5 = 106;
        int n6 = this.theAchievements.b.m.a("/gui/recipe.png");
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderEngine.a(n6);
        this.theAchievements.b(n, n2, 0, 0, 130, 68);
        GL11.glEnable((int)32826);
        GL11.glPushMatrix();
        GL11.glRotatef((float)180.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        C_c.b();
        GL11.glPopMatrix();
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        ItemStack[] itemStackArray = c_l.getRecipeItems();
        int n7 = 3;
        int n8 = 3;
        if (c_l instanceof C_r) {
            n7 = ((C_r)c_l).getRecipeWidth();
            n8 = ((C_r)c_l).getRecipeHeight();
        }
        String string = "";
        StatFileWriter statFileWriter = d.getMinecraft().statFileWriter;
        List<C_l> list = C_f.a().getUnlockedRecipeList();
        for (int i = 0; i < n7; ++i) {
            for (n4 = 0; n4 < n8; ++n4) {
                ItemStack itemStack;
                n3 = n4 * n7 + i;
                if (n3 >= itemStackArray.length || (itemStack = itemStackArray[n3]) == null) continue;
                if (!list.contains(c_l) && !this.theAchievements.b.d.multiplayerWorld && statFileWriter.getStatCount(StatList.objectCraftStats[itemStack.c]) <= 0 && statFileWriter.getStatCount(StatList.objectObtainStats[itemStack.c]) <= 0) {
                    GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
                } else {
                    GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
                }
                C_ac.access$300().a(this.theAchievements.b.m, itemStack, n + 8 + i * 18, n2 + 8 + n4 * 18);
            }
        }
        if (!list.contains(c_l) && !this.theAchievements.b.d.multiplayerWorld) {
            GL11.glColor3f((float)0.0f, (float)0.0f, (float)0.0f);
        } else {
            GL11.glColor3f((float)1.0f, (float)1.0f, (float)1.0f);
        }
        if (c_l.getRecipeOutput().a() == Item.clock) {
            C_ac.access$300().renderItemIntoGUI(this.theAchievements.b.m, c_l.getRecipeOutput().getItemID(), c_l.getRecipeOutput().getItemDamage(), 298, n + n5 - 16 - 8, n2 + 26);
        } else {
            C_ac.access$300().a(this.theAchievements.b.m, c_l.getRecipeOutput(), n + n5 - 16 - 8, n2 + 26);
        }
        string = this.screenWidth >= n + n5 - 16 - 8 && this.screenHeight >= n2 + 26 && this.screenWidth <= n + n5 - 16 - 8 + 16 && this.screenHeight <= n2 + 26 + 16 ? (!list.contains(c_l) && !this.theAchievements.b.d.multiplayerWorld ? "???" : c_l.getRecipeOutput().getItemName()) : "";
        C_c.a();
        GL11.glDisable((int)32826);
        GL11.glDisable((int)2929);
        String string2 = "" + c_l.getRecipeOutput().a;
        if (c_l.getRecipeOutput().a > 1) {
            this.theAchievements.g.a(string2, n + n5 - 16 - 8 + 17 - this.theAchievements.g.a(string2), n2 + 26 + 9, 0xFFFFFF);
        }
        if ((string = ("" + string).trim()).length() > 0) {
            n4 = this.screenWidth + 12;
            n3 = this.screenHeight - 12;
            int n9 = this.theAchievements.g.a(string);
            Gui.drawGradientRect(n4 - 3, n3 - 3, n4 + n9 + 3, n3 + 8 + 3, 0x60050500, -1607454624, 1.5f);
            this.theAchievements.g.a(string, n4, n3, 0xFFFFFF);
        }
        for (n4 = 0; n4 < n7; ++n4) {
            for (n3 = 0; n3 < n8; ++n3) {
                ItemStack itemStack;
                int n10 = n3 * n7 + n4;
                if (n10 >= itemStackArray.length || (itemStack = itemStackArray[n10]) == null) continue;
                string = this.screenWidth >= n + 8 + n4 * 18 && this.screenHeight >= n2 + 8 + n3 * 18 && this.screenWidth <= n + 8 + n4 * 18 + 16 && this.screenHeight <= n2 + 8 + n3 * 18 + 16 ? (!list.contains(c_l) && !this.theAchievements.b.d.multiplayerWorld && statFileWriter.getStatCount(StatList.objectCraftStats[itemStack.c]) <= 0 && statFileWriter.getStatCount(StatList.objectObtainStats[itemStack.c]) <= 0 ? "???" : itemStack.getItemName()) : "";
                string = ("" + string).trim();
                if (string.length() <= 0) continue;
                int n11 = this.screenWidth + 12;
                int n12 = this.screenHeight - 12;
                int n13 = this.theAchievements.g.a(string);
                Gui.drawGradientRect(n11 - 3, n12 - 3, n11 + n13 + 3, n12 + 8 + 3, 0x60050500, -1607454624, 1.5f);
                this.theAchievements.g.a(string, n11, n12, 0xFFFFFF);
            }
        }
    }
}

