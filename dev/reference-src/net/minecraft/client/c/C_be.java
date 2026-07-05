/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.c;

import java.util.ArrayList;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.C_d;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.statistics.StatList;
import org.lwjgl.opengl.GL11;

public final class C_be
extends GuiScreen {
    private int paintingAmount = 50;
    private int selectedPainting = 1;
    private int xPos;
    private int yPos;
    private int zPos;
    private byte face;

    public C_be(int n, int n2, int n3, byte by) {
        this.xPos = n;
        this.yPos = n2;
        this.zPos = n3;
        this.face = by;
    }

    @Override
    public final void b() {
        this.e.clear();
        this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 100, 50, 20, "<- Prev"));
        this.e.add(new GuiButton(1, this.c / 2 + 50, this.d / 4 + 100, 50, 20, "Next ->"));
        this.e.add(new GuiButton(2, this.c / 2 - 100, this.d / 4 + 120 + 12, 65, 20, "Select"));
        this.e.add(new GuiButton(3, this.c / 2 + 36, this.d / 4 + 120 + 12, 65, 20, "Cancel"));
        this.e.add(new GuiButton(4, this.c / 2 - 34, this.d / 4 + 120 + 12, 68, 20, "Random"));
    }

    @Override
    protected final void a(GuiButton guiButton) {
        net.minecraft.client.g.C_a c_a;
        C_a c_a2;
        if (guiButton.b == 0) {
            --this.selectedPainting;
            if (this.selectedPainting < 1) {
                this.selectedPainting = this.paintingAmount;
            }
        }
        if (guiButton.b == 1) {
            ++this.selectedPainting;
            if (this.selectedPainting > this.paintingAmount) {
                this.selectedPainting = 1;
            }
        }
        if (guiButton.b == 2) {
            c_a2 = new C_a(this.b.d, this.xPos, this.yPos, this.zPos, this.face, this.selectedPainting);
            if (!this.b.d.multiplayerWorld && c_a2.c()) {
                this.b.d.spawnEntityInWorld(c_a2);
                c_a = this.b.f;
                if (c_a.gamemode != 1) {
                    --c_a.b.d().a;
                    if (c_a.b.d().a <= 0) {
                        c_a.b.a(c_a.b.c, null);
                    }
                }
                c_a.addStat(StatList.objectUseStats[Item.ao.ap], 1);
            }
            this.b.a((GuiScreen)null);
            this.b.b();
        }
        if (guiButton.b == 3) {
            this.b.a((GuiScreen)null);
            this.b.b();
        }
        if (guiButton.b == 4) {
            c_a2 = new C_a(this.b.d, this.xPos, this.yPos, this.zPos, this.face, 0);
            if (!this.b.d.multiplayerWorld && c_a2.c()) {
                this.b.d.spawnEntityInWorld(c_a2);
                c_a = this.b.f;
                if (c_a.gamemode != 1) {
                    --c_a.b.d().a;
                    if (c_a.b.d().a <= 0) {
                        c_a.b.a(c_a.b.c, null);
                    }
                }
                c_a.addStat(StatList.objectUseStats[Item.ao.ap], 1);
            }
            this.b.a((GuiScreen)null);
            this.b.b();
        }
    }

    @Override
    public final void a(int n, int n2, float f) {
        this.h();
        C_be.a(this.g, "Choose Painting", this.c / 2, 20, 0xFFFFFF);
        C_be.a(this.g, this.getPaintingName(this.selectedPainting), this.c / 2, this.d / 4 + 105, 0xFFFFFF);
        this.renderPainting(this.selectedPainting);
        super.a(n, n2, f);
    }

    public String getPaintingName(int n) {
        ArrayList<C_d> arrayList = new ArrayList<C_d>();
        C_d[] c_dArray = C_d.values();
        for (int i = 0; i < c_dArray.length; ++i) {
            C_d c_d = c_dArray[i];
            arrayList.add(c_d);
        }
        return "''" + ((C_d)((Object)arrayList.get((int)(n - 1)))).b + "''";
    }

    private void renderPainting(int n) {
        ArrayList<C_d> arrayList = new ArrayList<C_d>();
        C_d[] c_dArray = C_d.values();
        for (int i = 0; i < c_dArray.length; ++i) {
            C_d c_d = c_dArray[i];
            arrayList.add(c_d);
        }
        GL11.glBindTexture((int)3553, (int)this.b.m.a("/art/kz.png"));
        ScaledResolution scaledResolution = new ScaledResolution(this.b.w, this.b.b, this.b.c);
        int n2 = scaledResolution.scaleFactor - 1;
        int n3 = 8;
        if (n2 >= 5) {
            n2 = scaledResolution.scaleFactor / 3;
            n3 = 4;
        } else if (n2 == 4 || n2 == 3) {
            if (((C_d)((Object)arrayList.get((int)(n - 1)))).d == 64 && ((C_d)((Object)arrayList.get((int)(n - 1)))).c == 64) {
                n2 = scaledResolution.scaleFactor / 2;
                n3 = 4;
            }
        } else if (n2 == 2) {
            n2 = scaledResolution.scaleFactor;
            n3 = 6;
            if (((C_d)((Object)arrayList.get((int)(n - 1)))).d == 64 && ((C_d)((Object)arrayList.get((int)(n - 1)))).c == 64) {
                n2 = scaledResolution.scaleFactor - 1;
                n3 = 4;
            }
        } else if (n2 <= 1) {
            n2 = scaledResolution.scaleFactor;
            n3 = 3;
        }
        int n4 = (((C_d)((Object)arrayList.get((int)(n - 1)))).d / 2 + 2) * n2 - 36;
        int n5 = (((C_d)((Object)arrayList.get((int)(n - 1)))).c / 2 + 2) * n2 - n3;
        this.drawPaintingTexture(this.c / 2 - n5, this.d / 4 - n4, ((C_d)((Object)arrayList.get((int)(n - 1)))).e, ((C_d)((Object)arrayList.get((int)(n - 1)))).f, ((C_d)((Object)arrayList.get((int)(n - 1)))).c * n2, ((C_d)((Object)arrayList.get((int)(n - 1)))).d * n2, ((C_d)((Object)arrayList.get((int)(n - 1)))).c, ((C_d)((Object)arrayList.get((int)(n - 1)))).d);
    }
}

