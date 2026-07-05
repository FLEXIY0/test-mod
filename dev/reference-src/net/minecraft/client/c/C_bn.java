/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package net.minecraft.client.c;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.c.Gui;
import net.minecraft.client.statistics.StatCrafting;
import org.lwjgl.input.Mouse;

abstract class C_bn
extends C_bm {
    protected int selectedItemStat;
    protected List fullStatsList;
    protected Comparator statsComparator;
    public int selectedBlockStat;
    public int selectedStat;
    final C_bs statsGui;

    protected C_bn(C_bs c_bs) {
        super(C_bs.getMinecraft(c_bs), c_bs.c, c_bs.d, 32, c_bs.d - 64, 20);
        this.statsGui = c_bs;
        this.selectedItemStat = -1;
        this.selectedBlockStat = -1;
        this.selectedStat = 0;
        this.setSlotActive(false);
        this.setMaxHeight(true, 20);
    }

    @Override
    protected void elementClicked(int n, boolean bl) {
    }

    @Override
    protected boolean isSelected(int n) {
        return false;
    }

    @Override
    protected void drawBackground() {
        this.statsGui.h();
    }

    @Override
    protected void onInteraction(int n, int n2, C_d c_d) {
        if (!Mouse.isButtonDown((int)0)) {
            this.selectedItemStat = -1;
        }
        if (this.selectedItemStat == 0) {
            C_bs.drawSprite(this.statsGui, n + 55 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 55 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedItemStat == 1) {
            C_bs.drawSprite(this.statsGui, n + 95 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 95 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedItemStat == 2) {
            C_bs.drawSprite(this.statsGui, n + 135 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 135 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedItemStat == 3) {
            C_bs.drawSprite(this.statsGui, n + 175 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 175 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedItemStat == 4) {
            C_bs.drawSprite(this.statsGui, n + 215 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 215 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedBlockStat != -1) {
            int n3 = 19;
            int n4 = 18;
            if (this.selectedBlockStat == 1) {
                n3 = 59;
            } else if (this.selectedBlockStat == 2) {
                n3 = 99;
            } else if (this.selectedBlockStat == 3) {
                n3 = 139;
            } else if (this.selectedBlockStat == 4) {
                n3 = 179;
            }
            if (this.selectedStat == 1) {
                n4 = 36;
            }
            C_bs.drawSprite(this.statsGui, n + n3, n2 + 1, n4, 0);
        }
    }

    @Override
    protected void onClick(int n, int n2) {
        this.selectedItemStat = -1;
        if (n >= 25 && n < 55) {
            this.selectedItemStat = 0;
        } else if (n >= 60 && n < 95) {
            this.selectedItemStat = 1;
        } else if (n >= 110 && n < 135) {
            this.selectedItemStat = 2;
        } else if (n >= 160 && n < 175) {
            this.selectedItemStat = 3;
        } else if (n >= 190 && n < 215) {
            this.selectedItemStat = 4;
        }
        if (this.selectedItemStat >= 0) {
            this.selectSlot(this.selectedItemStat);
            C_bs.getMinecraft((C_bs)this.statsGui).x.a("random.click", 1.0f, 1.0f);
        }
    }

    @Override
    protected final int getSize() {
        return this.fullStatsList.size();
    }

    protected final StatCrafting getStat(int n) {
        return (StatCrafting)this.fullStatsList.get(n);
    }

    protected abstract String getStatName(int var1);

    protected void displayStatString(StatCrafting statCrafting, int n, int n2, boolean bl) {
        if (statCrafting != null) {
            String string = statCrafting.getTypeName(C_bs.getStatsFileWriter(this.statsGui).getStatCount(statCrafting));
            Gui.b(C_bs.getFontRenderer(this.statsGui), string, n - C_bs.getFontRenderer(this.statsGui).a(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        } else {
            String string = "-";
            Gui.b(C_bs.getFontRenderer(this.statsGui), string, n - C_bs.getFontRenderer(this.statsGui).a(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        }
    }

    @Override
    protected void scrollFunc(int n, int n2) {
        if (n2 >= this.top && n2 <= this.bottom) {
            int n3 = this.getScrollValue(n, n2);
            int n4 = this.statsGui.c / 2 - 92 - 16;
            if (n3 >= 0) {
                if (n < n4 || n > n4 + 20) {
                    return;
                }
                StatCrafting statCrafting = this.getStat(n3);
                this.drawSlot(statCrafting, n, n2);
            } else {
                String string = "";
                if (n >= n4 + 55 - 18 && n <= n4 + 55) {
                    string = this.getStatName(0);
                } else if (n >= n4 + 95 - 18 && n <= n4 + 95) {
                    string = this.getStatName(1);
                } else if (n >= n4 + 135 - 18 && n <= n4 + 135) {
                    string = this.getStatName(2);
                } else if (n >= n4 + 175 - 18 && n <= n4 + 175) {
                    string = this.getStatName(3);
                } else {
                    if (n < n4 + 215 - 18 || n > n4 + 215) {
                        return;
                    }
                    string = this.getStatName(4);
                }
                string = ("" + string).trim();
                if (string.length() > 0) {
                    int n5 = n + 12;
                    int n6 = n2 - 12;
                    int n7 = C_bs.getFontRenderer(this.statsGui).a(string);
                    C_bs.drawGradientRect(this.statsGui, n5 - 3, n6 - 3, n5 + n7 + 3, n6 + 8 + 3, 0x60050500, -1607454624);
                    C_bs.getFontRenderer(this.statsGui).a(string, n5, n6, -1);
                }
            }
        }
    }

    protected void drawSlot(StatCrafting statCrafting, int n, int n2) {
        if (statCrafting != null) {
            Item item = Item.b[statCrafting.getItemID()];
            String string = ("" + item.getItemName()).trim();
            if (statCrafting.getItemID() < 256) {
                Block c_x = Block.c[statCrafting.getItemID()];
                string = ("" + c_x.getBlockName()).trim();
            }
            if (string.length() > 0) {
                int n3 = n + 12;
                int n4 = n2 - 12;
                int n5 = C_bs.getFontRenderer(this.statsGui).a(string);
                C_bs.drawGradientRect(this.statsGui, n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, 0x60050500, -1607454624);
                C_bs.getFontRenderer(this.statsGui).a(string, n3, n4, -1);
            }
        }
    }

    protected void selectSlot(int n) {
        if (n != this.selectedBlockStat) {
            this.selectedBlockStat = n;
            this.selectedStat = -1;
        } else if (this.selectedStat == -1) {
            this.selectedStat = 1;
        } else {
            this.selectedBlockStat = -1;
            this.selectedStat = 0;
        }
        Collections.sort(this.fullStatsList, this.statsComparator);
    }
}

