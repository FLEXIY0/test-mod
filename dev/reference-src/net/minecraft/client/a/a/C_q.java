/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_e;
import net.minecraft.a.c.b.C_f;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_q
extends C_j {
    public C_q(C_l c_l, float f) {
        super(c_l, f);
    }

    public void renderChicken(C_f c_f, float f, float f2, float f3, float f4, float f5) {
        super.a(c_f, f, f2, f3, f4, f5);
    }

    protected float getWingRotation(C_f c_f, float f) {
        float f2 = c_f.newPos + (c_f.lastGroundPos - c_f.newPos) * f;
        float f3 = c_f.startPos + (c_f.destPos - c_f.startPos) * f;
        return (MathHelper.a(f2) + 1.0f) * f3;
    }

    @Override
    protected float getDefaultAngle(C_e c_e, float f) {
        return this.getWingRotation((C_f)c_e, f);
    }

    public void doRender(C_e c_e, float f, float f2, float f3, float f4, float f5) {
        this.renderChicken((C_f)c_e, f, f2, f3, f4, f5);
    }
}

