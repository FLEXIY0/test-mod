/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import java.util.Random;
import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.a.C_f;
import org.lwjgl.opengl.GL11;

public class C_y
extends C_f {
    public void renderBolt(net.minecraft.a.c.c.C_f c_f, float f, float f2, float f3, float f4, float f5) {
        int n;
        C_d c_d = C_d.a;
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)1);
        float[] fArray = new float[8];
        float[] fArray2 = new float[8];
        float f6 = 0.0f;
        float f7 = 0.0f;
        Random random = new Random(c_f.thunderStrength);
        for (n = 7; n >= 0; --n) {
            fArray[n] = f6;
            fArray2[n] = f7;
            f6 += (float)(random.nextInt(11) - 5);
            f7 += (float)(random.nextInt(11) - 5);
        }
        for (n = 0; n < 4; ++n) {
            Random random2 = new Random(c_f.thunderStrength);
            for (int i = 0; i < 3; ++i) {
                int n2 = 7;
                int n3 = 0;
                if (i > 0) {
                    n2 = 7 - i;
                }
                if (i > 0) {
                    n3 = n2 - 2;
                }
                float f8 = fArray[n2] - f6;
                float f9 = fArray2[n2] - f7;
                for (int j = n2; j >= n3; --j) {
                    float f10 = f8;
                    float f11 = f9;
                    if (i == 0) {
                        f8 += (float)(random2.nextInt(11) - 5);
                        f9 += (float)(random2.nextInt(11) - 5);
                    } else {
                        f8 += (float)(random2.nextInt(31) - 15);
                        f9 += (float)(random2.nextInt(31) - 15);
                    }
                    c_d.a(5);
                    float f12 = 0.5f;
                    c_d.a(0.9f * f12, 0.9f * f12, 1.0f * f12, 0.3f);
                    float f13 = 0.1f + (float)n * 0.2f;
                    if (i == 0) {
                        f13 *= (float)j * 0.1f + 1.0f;
                    }
                    float f14 = 0.1f + (float)n * 0.2f;
                    if (i == 0) {
                        f14 *= (float)(j - 1) * 0.1f + 1.0f;
                    }
                    for (int k = 0; k < 5; ++k) {
                        float f15 = f + 0.5f - f13;
                        float f16 = f3 + 0.5f - f13;
                        if (k == 1 || k == 2) {
                            f15 += f13 * 2.0f;
                        }
                        if (k == 2 || k == 3) {
                            f16 += f13 * 2.0f;
                        }
                        float f17 = f + 0.5f - f14;
                        float f18 = f3 + 0.5f - f14;
                        if (k == 1 || k == 2) {
                            f17 += f14 * 2.0f;
                        }
                        if (k == 2 || k == 3) {
                            f18 += f14 * 2.0f;
                        }
                        c_d.b(f17 + f8, f2 + (float)(j * 16), f18 + f9);
                        c_d.b(f15 + f10, f2 + (float)((j + 1) * 16), f16 + f11);
                    }
                    c_d.a();
                }
            }
        }
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
    }

    @Override
    public void a(C_b c_b, float f, float f2, float f3, float f4, float f5) {
        this.renderBolt((net.minecraft.a.c.c.C_f)c_b, f, f2, f3, f4, f5);
    }
}

