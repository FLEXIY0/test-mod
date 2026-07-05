/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_q;

public class C_y
extends C_q {
    public C_y() {
        this.chestLid = new C_c(0, 0).setTextureSize(128, 64);
        this.chestLid.a(0.0f, -5.0f, -14.0f, 32, 4, 16, 0.0f);
        this.chestLid.j = 0.0f;
        this.chestLid.k = 5.0f;
        this.chestLid.l = 14.0f;
        this.chestKnob = new C_c(0, 0).setTextureSize(128, 64);
        this.chestKnob.a(-1.0f, -2.0f, -15.0f, 2, 4, 1, 0.0f);
        this.chestKnob.j = 16.0f;
        this.chestKnob.k = 5.0f;
        this.chestKnob.l = 14.99f;
        this.chestBelow = new C_c(0, 21).setTextureSize(128, 64);
        this.chestBelow.a(0.0f, 0.0f, 0.0f, 32, 12, 16, 0.0f);
        this.chestBelow.k = 4.0f;
    }
}

