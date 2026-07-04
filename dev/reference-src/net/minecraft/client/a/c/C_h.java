/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import net.minecraft.a.a.b.C_x;
import net.minecraft.client.a.c.C_b;

public final class C_h
extends C_b {
    private float[] currentFireFrame = new float[320];
    private float[] lastFireFrame = new float[320];

    public C_h() {
        super(C_x.hellfire.as);
    }

    @Override
    public final void a() {
        int n;
        int n2;
        int n3;
        for (int i = 0; i < 16; ++i) {
            for (n3 = 0; n3 < 20; ++n3) {
                int n4 = 18;
                float f = this.currentFireFrame[i + ((n3 + 1) % 20 << 4)] * 18.0f;
                for (n2 = i - 1; n2 <= i + 1; ++n2) {
                    for (n = n3; n <= n3 + 1; ++n) {
                        if (n2 >= 0 && n >= 0 && n2 < 16 && n < 20) {
                            f += this.currentFireFrame[n2 + (n << 4)];
                        }
                        ++n4;
                    }
                }
                this.lastFireFrame[i + (n3 << 4)] = f / ((float)n4 * 1.06f);
                if (n3 < 19) continue;
                this.lastFireFrame[i + (n3 << 4)] = (float)(Math.random() * Math.random() * Math.random() * 4.0 + Math.random() * (double)0.1f + (double)0.2f);
            }
        }
        float[] fArray = this.lastFireFrame;
        this.lastFireFrame = this.currentFireFrame;
        this.currentFireFrame = fArray;
        for (n3 = 0; n3 < 256; ++n3) {
            float f;
            float f2 = this.currentFireFrame[n3] * 1.8f;
            if (f > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            n2 = (int)(f2 * f2 * 100.0f);
            n = (int)(f2 * 255.0f);
            int n5 = 255;
            int n6 = 255;
            if (f2 < 0.5f) {
                n6 = 0;
            }
            this.a[n3 << 2] = (byte)n2;
            this.a[(n3 << 2) + 1] = (byte)n;
            this.a[(n3 << 2) + 2] = (byte)n5;
            this.a[(n3 << 2) + 3] = (byte)n6;
        }
    }
}

