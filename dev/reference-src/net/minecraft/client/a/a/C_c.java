/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_d;
import net.minecraft.client.a.a.C_j;
import net.minecraft.client.b.C_k;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_c
extends C_j {
    public C_c() {
        super(new C_k(), 0.5f);
    }

    @Override
    protected final void a(C_e c_e, float f) {
        float f2 = ((C_d)c_e).getFlashTime(f);
        f = 1.0f + MathHelper.a(f2 * 100.0f) * f2 * 0.01f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f2 *= f2;
        f2 *= f2;
        float f3 = (1.0f + f2 * 0.4f) * f;
        f2 = (1.0f + f2 * 0.1f) / f;
        GL11.glScalef((float)f3, (float)f2, (float)f3);
    }

    @Override
    protected final int a(C_e c_e, float f, float f2) {
        float f3 = ((C_d)c_e).getFlashTime(f2);
        if ((int)(f3 * 10.0f) % 2 == 0) {
            return 0;
        }
        int n = (int)(f3 * 0.2f * 255.0f);
        if (n < 0) {
            n = 0;
        }
        if (n > 255) {
            n = 255;
        }
        return n << 24 | 0xFF0000 | 0xFF00 | 0xFF;
    }
}

