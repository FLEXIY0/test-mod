/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.a.b.a.C_l;
import net.minecraft.client.a.a.C_e;
import net.minecraft.client.c.C_ab;
import net.minecraft.client.c.ChatAllowedCharacters;
import net.minecraft.client.c.Gui;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.statistics.Achievement;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatFileWriter;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class C_ac
extends GuiScreen {
    private static C_e renderItem = new C_e();
    protected StatFileWriter statFileWriter;
    protected String screenTitle = "Achievements";
    private C_ab achievementSlotContainer;
    private int sortMode;
    private String name = "";
    private int counter;
    private int filter;
    private String[] recipes = new String[]{"All", "Locked", "Unlocked"};
    private List<C_l> finalList = CraftingManager.a().getRecipeList();

    public C_ac(StatFileWriter statFileWriter) {
        this.statFileWriter = statFileWriter;
    }

    public C_ac(StatFileWriter statFileWriter, int n) {
        this.statFileWriter = statFileWriter;
        this.sortMode = n;
        this.screenTitle = "Recipes";
    }

    @Override
    public void b() {
        this.achievementSlotContainer = new C_ab(this, this);
        this.achievementSlotContainer.registerScrollButtons(this.e, 4, 5);
        this.initButtons();
        Keyboard.enableRepeatEvents((boolean)true);
    }

    @Override
    public final void a() {
        super.a();
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void initButtons() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 72, this.d - 28, 150, 20, "Done"));
        this.e.add(new GuiButton(1, this.c / 2 - 154, this.d - 52, 100, 20, "Achievements"));
        this.e.add(new GuiButton(2, this.c / 2 - 46, this.d - 52, 100, 20, "Challenges"));
        this.e.add(new GuiButton(3, this.c / 2 + 62, this.d - 52, 100, 20, "Recipes"));
        this.e.add(new GuiButton(4, this.c / 2 - 241, 75, 118, 20, "Show: " + this.recipes[this.filter]));
        if (this.sortMode == 0) {
            ((GuiButton)this.e.get((int)1)).c = false;
            ((GuiButton)this.e.get((int)4)).d = false;
            ((GuiButton)this.e.get((int)4)).c = false;
        } else if (this.sortMode == 1) {
            ((GuiButton)this.e.get((int)2)).c = false;
            ((GuiButton)this.e.get((int)4)).d = false;
            ((GuiButton)this.e.get((int)4)).c = false;
        } else if (this.sortMode == 2) {
            ((GuiButton)this.e.get((int)3)).c = false;
            ((GuiButton)this.e.get((int)4)).d = true;
            ((GuiButton)this.e.get((int)4)).c = true;
        }
    }

    @Override
    public final void f_() {
        ++this.counter;
    }

    @Override
    protected void a(GuiButton guiButton) {
        if (guiButton.c) {
            if (guiButton.b == 0) {
                this.b.a((GuiScreen)null);
            } else if (guiButton.b == 1) {
                this.sortMode = 0;
                this.screenTitle = "Achievements";
                ((GuiButton)this.e.get((int)1)).c = false;
                ((GuiButton)this.e.get((int)2)).c = true;
                ((GuiButton)this.e.get((int)3)).c = true;
                ((GuiButton)this.e.get((int)4)).d = false;
                ((GuiButton)this.e.get((int)4)).c = false;
                this.achievementSlotContainer.setSlotHeight(36);
                this.achievementSlotContainer.setMaxHeight(true, -12);
            } else if (guiButton.b == 2) {
                this.sortMode = 1;
                this.screenTitle = "Challenges";
                ((GuiButton)this.e.get((int)2)).c = false;
                ((GuiButton)this.e.get((int)1)).c = true;
                ((GuiButton)this.e.get((int)3)).c = true;
                ((GuiButton)this.e.get((int)4)).d = false;
                ((GuiButton)this.e.get((int)4)).c = false;
                this.achievementSlotContainer.setSlotHeight(36);
                this.achievementSlotContainer.setMaxHeight(true, -12);
            } else if (guiButton.b == 3) {
                this.sortMode = 2;
                this.screenTitle = "Recipes";
                ((GuiButton)this.e.get((int)3)).c = false;
                ((GuiButton)this.e.get((int)1)).c = true;
                ((GuiButton)this.e.get((int)2)).c = true;
                ((GuiButton)this.e.get((int)4)).d = true;
                ((GuiButton)this.e.get((int)4)).c = true;
                this.achievementSlotContainer.setSlotHeight(72);
                this.achievementSlotContainer.setMaxHeight(true, 2);
            } else if (guiButton.b == 4) {
                ++this.filter;
                if (this.filter > 2) {
                    this.filter = 0;
                }
                ((GuiButton)this.e.get((int)4)).a = "Show: " + this.recipes[this.filter];
                this.switchList();
            } else {
                this.achievementSlotContainer.actionPerformed(guiButton);
            }
        }
    }

    public List<C_l> switchList() {
        switch (this.filter) {
            case 1: {
                this.finalList = new ArrayList<C_l>();
                for (C_l c_l : CraftingManager.a().getRecipeList()) {
                    if (CraftingManager.a().getUnlockedRecipeList().contains(c_l)) continue;
                    this.finalList.add(c_l);
                }
                break;
            }
            case 2: {
                this.finalList = CraftingManager.a().getUnlockedRecipeList();
                break;
            }
            default: {
                this.finalList = CraftingManager.a().getRecipeList();
            }
        }
        return this.finalList;
    }

    @Override
    public void buttonAction(boolean bl, int n) {
    }

    @Override
    protected final void a(char c, int n) {
        if (n == 14 && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        if (n == 1) {
            this.b.a((GuiScreen)null);
        }
        if (n == 28) {
            // empty if block
        }
        if (c == '\u0016') {
            int n2;
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            if ((n2 = 32 - this.name.length()) > string.length()) {
                n2 = string.length();
            }
            if (n2 > 0) {
                this.name = this.name + string.substring(0, n2);
            }
        }
        if (ChatAllowedCharacters.ALLOWED_CHARACTERS.indexOf(c) >= 0 && this.name.length() < 16 && this.g.a(this.name) < 192) {
            this.name = this.name + c;
        }
    }

    @Override
    public void a(int n, int n2, float f) {
        this.achievementSlotContainer.drawScreen(n, n2, f);
        if (this.sortMode == 2) {
            Gui.a(this.g, CraftingManager.a().getUnlockedRecipeList().size() + "/" + CraftingManager.a().getRecipeList().size(), this.c / 2, 18, 0xFFFFFF);
            int n3 = this.c / 2 - 240;
            int n4 = 35;
            C_ac.a(n3 - 1, n4 + 15 - 1, n3 + 116 + 1, n4 + 35 + 1, -6250336);
            C_ac.a(n3, n4 + 15, n3 + 116, n4 + 35, -16777216);
            C_ac.b(this.g, this.name + (this.counter / 6 % 2 == 0 ? "_" : ""), n3 + 4, n4 + 15 + 6, 0xE0E0E0);
            C_ac.b(this.g, "Search Recipes:", this.c / 2 - 223, n4 + 3, 0xE0E0E0);
        } else {
            List<Achievement> list = AchievementList.achievementList;
            if (this.sortMode == 1) {
                list = AchievementList.challengeList;
            }
            int n5 = 0;
            for (int i = 0; i < list.size(); ++i) {
                if (!this.b.statFileWriter.hasAchievementUnlocked(list.get(i))) continue;
                ++n5;
            }
            Gui.a(this.g, n5 + "/" + list.size(), this.c / 2, 18, 0xFFFFFF);
        }
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)50.0f);
        Gui.a(this.g, this.screenTitle, this.c / 2, 8, 0xFFFFFF);
        super.a(n, n2, f);
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-50.0f);
    }

    static /* synthetic */ int access$000(C_ac c_ac) {
        return c_ac.sortMode;
    }

    static /* synthetic */ List access$100(C_ac c_ac) {
        return c_ac.finalList;
    }

    static /* synthetic */ String access$200(C_ac c_ac) {
        return c_ac.name;
    }

    static /* synthetic */ List access$102(C_ac c_ac, List list) {
        c_ac.finalList = list;
        return c_ac.finalList;
    }

    static /* synthetic */ C_e access$300() {
        return renderItem;
    }
}

