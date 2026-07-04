/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import net.minecraft.client.a.C_d;
import net.minecraft.client.c.C_bn;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.c.Gui;
import net.minecraft.client.statistics.SorterStatsMob;
import net.minecraft.client.statistics.StatList;
import net.minecraft.client.statistics.StatMob;
import org.lwjgl.input.Mouse;

public class C_br
extends C_bn {
    public final C_bs theStats;

    protected C_br(C_bs c_bs) {
        super(c_bs);
        this.theStats = c_bs;
        this.fullStatsList = new ArrayList();
        for (StatMob statMob : StatList.objectMobStats) {
            boolean bl = false;
            int n = statMob.getEntity();
            if (StatList.objectKillStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectKillStats[n]) > 0) {
                bl = true;
            } else if (StatList.objectDeathStats[n] != null && C_bs.getStatsFileWriter(c_bs).getStatCount(StatList.objectDeathStats[n]) > 0) {
                bl = true;
            }
            if (!bl) continue;
            this.fullStatsList.add(statMob);
        }
        this.statsComparator = new SorterStatsMob(this, c_bs);
    }

    protected final StatMob getStatMob(int n) {
        return (StatMob)this.fullStatsList.get(n);
    }

    @Override
    protected void scrollFunc(int n, int n2) {
        if (n2 >= this.top && n2 <= this.bottom) {
            int n3 = this.getScrollValue(n, n2);
            int n4 = this.statsGui.c / 2 - 92 - 16;
            if (n3 >= 0) {
                if (n < n4 + 40 || n > n4 + 40 + 20) {
                    return;
                }
            } else {
                String string = "";
                if (n >= n4 + 115 - 18 && n <= n4 + 115) {
                    string = this.getStatName(0);
                } else if (n >= n4 + 165 - 18 && n <= n4 + 165) {
                    string = this.getStatName(1);
                } else {
                    if (n < n4 + 215 - 18 || n > n4 + 215) {
                        return;
                    }
                    string = this.getStatName(2);
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

    @Override
    protected void onInteraction(int n, int n2, C_d c_d) {
        if (!Mouse.isButtonDown((int)0)) {
            this.selectedItemStat = -1;
        }
        if (this.selectedItemStat == 0) {
            C_bs.drawSprite(this.statsGui, n + 115 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 115 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedItemStat == 1) {
            C_bs.drawSprite(this.statsGui, n + 165 - 18, n2 + 1, 0, 0);
        } else {
            C_bs.drawSprite(this.statsGui, n + 165 - 18, n2 + 1, 0, 18);
        }
        if (this.selectedBlockStat != -1) {
            int n3 = 79;
            int n4 = 18;
            if (this.selectedBlockStat == 1) {
                n3 = 129;
            } else if (this.selectedBlockStat == 2) {
                n3 = 179;
            }
            if (this.selectedStat == 1) {
                n4 = 36;
            }
            C_bs.drawSprite(this.statsGui, n + n3, n2 + 1, n4, 0);
        }
        if (this.selectedStat == 0) {
            C_bs.drawSprite(this.theStats, n + 115 - 18 + 1, n2 + 1, 94, 18);
        } else {
            C_bs.drawSprite(this.theStats, n + 115 - 18 + 1, n2 + 1, 94, 18);
        }
        if (this.selectedStat == 1) {
            C_bs.drawSprite(this.theStats, n + 165 - 18 + 1, n2 + 1, 110, 18);
        } else {
            C_bs.drawSprite(this.theStats, n + 165 - 18 + 1, n2 + 1, 110, 18);
        }
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        StatMob statMob = this.getStatMob(n);
        int n5 = statMob.getEntity();
        C_bs.a(C_bs.getFontRenderer(this.statsGui), StatList.objectMobStats.get(n5).getName(), n2 + 40, n3, -1);
        this.displayStatString((StatMob)StatList.objectKillStats[n5], n2 + 115, n3, n % 2 == 0);
        this.displayStatString((StatMob)StatList.objectDeathStats[n5], n2 + 165, n3, n % 2 == 0);
    }

    protected void displayStatString(StatMob statMob, int n, int n2, boolean bl) {
        if (statMob != null) {
            String string = statMob.getTypeName(C_bs.getStatsFileWriter(this.statsGui).getStatCount(statMob));
            Gui.b(C_bs.getFontRenderer(this.statsGui), string, n - C_bs.getFontRenderer(this.statsGui).a(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        } else {
            String string = "-";
            Gui.b(C_bs.getFontRenderer(this.statsGui), string, n - C_bs.getFontRenderer(this.statsGui).a(string), n2 + 5, bl ? 0xFFFFFF : 0x909090);
        }
    }

    @Override
    protected String getStatName(int n) {
        return n == 0 ? "Total kills" : (n == 1 ? "Times killed by" : "");
    }

    @Override
    protected void onClick(int n, int n2) {
        this.selectedItemStat = -1;
        if (n >= 79 && n < 115) {
            this.selectedItemStat = 0;
        } else if (n >= 129 && n < 165) {
            this.selectedItemStat = 1;
        }
        if (this.selectedItemStat >= 0) {
            this.selectSlot(this.selectedItemStat);
            C_bs.getMinecraft((C_bs)this.statsGui).x.a("random.click", 1.0f, 1.0f);
        }
    }
}

