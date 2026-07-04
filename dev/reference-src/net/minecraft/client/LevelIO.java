/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.a.a.C_g;
import net.minecraft.a.c.C_b;
import net.minecraft.client.d;
import net.minecraft.client.g.C_a;

public final class LevelIO
extends net.minecraft.a.a.C_a {
    private d a;

    public LevelIO(d d2, util.C_b c_b) {
        super(c_b);
        this.a = d2;
    }

    @Override
    protected final C_b a(C_g c_g, String string) {
        return string.equals("LocalPlayer") ? new C_a(this.a, c_g, this.a.h) : super.a(c_g, string);
    }
}

