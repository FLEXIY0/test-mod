/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;

public class C_q
extends C_l {
    public C_c chestLid = new C_c(0, 0).setTextureSize(64, 64);
    public C_c chestBelow;
    public C_c chestKnob;

    public C_q() {
        this.chestLid.a(0.0f, -5.0f, -14.0f, 16, 4, 16, 0.0f);
        this.chestLid.j = 0.0f;
        this.chestLid.k = 5.0f;
        this.chestLid.l = 14.0f;
        this.chestKnob = new C_c(0, 0).setTextureSize(64, 64);
        this.chestKnob.a(-1.0f, -2.0f, -15.0f, 2, 4, 1, 0.0f);
        this.chestKnob.j = 8.0f;
        this.chestKnob.k = 5.0f;
        this.chestKnob.l = 14.99f;
        this.chestBelow = new C_c(0, 19).setTextureSize(64, 64);
        this.chestBelow.a(0.0f, 0.0f, 0.0f, 16, 12, 16, 0.0f);
        this.chestBelow.k = 4.0f;
    }

    public void renderAll() {
        this.chestKnob.a = this.chestLid.a;
        this.chestLid.a(0.0625f);
        this.chestKnob.a(0.0625f);
        this.chestBelow.a(0.0625f);
    }
}

