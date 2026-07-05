/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import net.minecraft.a.a.b.Block;
import net.minecraft.client.a.c.C_b;
import net.minecraft.client.d;

public final class C_f
extends C_b {
    private float[] e = new float[256];
    private float[] f = new float[256];
    private float[] g = new float[256];
    private float[] h = new float[256];

    public C_f() {
        super(Block.p.as);
    }

    @Override
    public final void a() {
        int n;
        int n2;
        float f;
        int n3;
        int n4;
        for (n4 = 0; n4 < 16; ++n4) {
            for (n3 = 0; n3 < 16; ++n3) {
                f = 0.0f;
                for (int i = n4 - 1; i <= n4 + 1; ++i) {
                    n2 = i & 0xF;
                    n = n3 & 0xF;
                    f += this.e[n2 + (n << 4)];
                }
                this.f[n4 + (n3 << 4)] = f / 3.3f + this.g[n4 + (n3 << 4)] * 0.8f;
            }
        }
        for (n4 = 0; n4 < 16; ++n4) {
            for (n3 = 0; n3 < 16; ++n3) {
                int n5 = n4 + (n3 << 4);
                this.g[n5] = this.g[n5] + this.h[n4 + (n3 << 4)] * 0.05f;
                if (this.g[n4 + (n3 << 4)] < 0.0f) {
                    this.g[n4 + (n3 << 4)] = 0.0f;
                }
                int n6 = n4 + (n3 << 4);
                this.h[n6] = this.h[n6] - 0.1f;
                if (!(Math.random() < 0.05)) continue;
                this.h[n4 + (n3 << 4)] = 0.5f;
            }
        }
        float[] fArray = this.f;
        this.f = this.e;
        this.e = fArray;
        for (n3 = 0; n3 < 256; ++n3) {
            float f2;
            f = this.e[n3];
            if (f2 > 1.0f) {
                f = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
            float f3 = f * f;
            n2 = (int)(32.0f + f3 * 32.0f);
            n = (int)(50.0f + f3 * 64.0f);
            n4 = 255;
            int n7 = (int)(146.0f + f3 * 50.0f);
            int n8 = 1;
            if (net.minecraft.client.d.getMinecraft().d != null && net.minecraft.client.d.getMinecraft().d.theme == 4) {
                n8 = 55;
                n2 = (int)(64.0f + f3 * 64.0f);
                n = (int)(100.0f + f3 * 128.0f);
            }
            this.a[n3 << 2] = (byte)n2;
            this.a[(n3 << 2) + 1] = (byte)n;
            this.a[(n3 << 2) + 2] = (byte)((byte)n4 / n8);
            this.a[(n3 << 2) + 3] = (byte)n7;
        }
    }
}

