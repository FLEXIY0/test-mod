/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import net.minecraft.client.a.C_d;
import net.minecraft.client.c.C_bm;
import net.minecraft.client.c.C_bs;
import net.minecraft.client.c.Gui;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;

class C_bp
extends C_bm {
    final C_bs statsGui;

    public C_bp(C_bs c_bs) {
        super(C_bs.getMinecraft(c_bs), c_bs.c, c_bs.d, 32, c_bs.d - 64, 10);
        this.statsGui = c_bs;
        this.setSlotActive(false);
    }

    @Override
    protected int getSize() {
        return StatList.generalStats.size();
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
        return this.getSize() * 10;
    }

    @Override
    protected void drawBackground() {
        this.statsGui.h();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, C_d c_d) {
        StatBase statBase = StatList.generalStats.get(n);
        Gui.b(C_bs.getFontRenderer(this.statsGui), statBase.getName(), n2 + 2, n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
        String string = statBase.getTypeName(C_bs.getStatsFileWriter(this.statsGui).getStatCount(statBase));
        Gui.b(C_bs.getFontRenderer(this.statsGui), string, n2 + 2 + 213 - C_bs.getFontRenderer(this.statsGui).a(string), n3 + 1, n % 2 == 0 ? 0xFFFFFF : 0x909090);
    }
}

