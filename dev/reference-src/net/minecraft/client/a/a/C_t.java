/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.b.C_h;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import net.minecraft.client.b.C_u;

public final class C_t
extends C_j {
    private C_u modelFoxMain;

    public C_t(C_l c_l, float f) {
        super(c_l, 0.7f);
        this.modelFoxMain = (C_u)this.d;
    }

    private void renderFox(C_h c_h, float f, float f2, float f3, float f4, float f5) {
        this.modelFoxMain.isSleeping = c_h.isLaying;
        super.renderEntity(c_h, f, f2, f3, f4, f5);
    }

    @Override
    public final void renderEntity(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        this.renderFox((C_h)c_e, f, f2, f3, f4, f5);
    }

    @Override
    public final void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderFox((C_h)c_b, f, f2, f3, f4, f5);
    }
}

