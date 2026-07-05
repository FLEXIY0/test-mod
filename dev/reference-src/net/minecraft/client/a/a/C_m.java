/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_b;
import net.minecraft.client.a.a.C_j;
import org.lwjgl.opengl.GL11;

public final class C_m
extends C_j {
    public C_m() {
        super(new net.minecraft.client.b.C_e(), 1.0f);
        this.a(new net.minecraft.client.b.C_e());
    }

    @Override
    protected final float a(EntityLiving c_e) {
        return 180.0f;
    }

    @Override
    protected final boolean a(EntityLiving c_e, int n) {
        C_b c_b = (C_b)c_e;
        if (c_b.type == 0) {
            int n2 = n;
            C_b c_b2 = c_b;
            if (n2 != 0) {
                return false;
            }
            if (n2 != 0) {
                return false;
            }
            this.a("/mob/spider_eyes.png");
            float f = (1.0f - c_b2.a(1.0f)) * 0.5f;
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3008);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
            return true;
        }
        return false;
    }
}

