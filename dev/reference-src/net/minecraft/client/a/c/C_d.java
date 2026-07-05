/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import net.minecraft.a.a.b.C_x;
import net.minecraft.client.a.c.C_b;
import util.MathHelper;

public final class C_d
extends C_b {
    private float[] e = new float[256];
    private float[] f = new float[256];
    private float[] g = new float[256];
    private float[] h = new float[256];

    public C_d() {
        super(C_x.r.as);
    }

    @Override
    public final void a() {
        int n;
        int n2;
        int n3;
        float f;
        int n4;
        for (int i = 0; i < 16; ++i) {
            for (n4 = 0; n4 < 16; ++n4) {
                f = 0.0f;
                int n5 = (int)(MathHelper.a((float)n4 * (float)Math.PI * 2.0f / 16.0f) * 1.2f);
                n3 = (int)(MathHelper.a((float)i * (float)Math.PI * 2.0f / 16.0f) * 1.2f);
                for (n2 = i - 1; n2 <= i + 1; ++n2) {
                    for (n = n4 - 1; n <= n4 + 1; ++n) {
                        int n6 = n2 + n5 & 0xF;
                        int n7 = n + n3 & 0xF;
                        f += this.e[n6 + (n7 << 4)];
                    }
                }
                this.f[i + (n4 << 4)] = f / 10.0f + (this.g[(i & 0xF) + ((n4 & 0xF) << 4)] + this.g[(i + 1 & 0xF) + ((n4 & 0xF) << 4)] + this.g[(i + 1 & 0xF) + ((n4 + 1 & 0xF) << 4)] + this.g[(i & 0xF) + ((n4 + 1 & 0xF) << 4)]) / 4.0f * 0.8f;
                int n8 = i + (n4 << 4);
                this.g[n8] = this.g[n8] + this.h[i + (n4 << 4)] * 0.01f;
                if (this.g[i + (n4 << 4)] < 0.0f) {
                    this.g[i + (n4 << 4)] = 0.0f;
                }
                int n9 = i + (n4 << 4);
                this.h[n9] = this.h[n9] - 0.06f;
                if (!(Math.random() < 0.005)) continue;
                this.h[i + (n4 << 4)] = 1.5f;
            }
        }
        float[] fArray = this.f;
        this.f = this.e;
        this.e = fArray;
        for (n4 = 0; n4 < 256; ++n4) {
            float f2;
            f = this.e[n4] * 2.0f;
            if (f2 > 1.0f) {
                f = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
            n3 = (int)(f * 100.0f + 155.0f);
            n2 = (int)(f * f * 255.0f);
            n = (int)(f * f * f * f * 128.0f);
            this.a[n4 << 2] = (byte)n3;
            this.a[(n4 << 2) + 1] = (byte)n2;
            this.a[(n4 << 2) + 2] = (byte)n;
            this.a[(n4 << 2) + 3] = -1;
        }
    }
}

