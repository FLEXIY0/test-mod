/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.util.Random;
import net.minecraft.client.a.c.C_b;
import util.MathHelper;

public class C_m
extends C_b {
    private int portalTickCounter = 0;
    private byte[][] portalTextureData = new byte[32][1024];

    public C_m(int n) {
        super(n);
        Random random = new Random(100L);
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int n2;
                    float f = 0.0f;
                    for (n2 = 0; n2 < 2; ++n2) {
                        float f2 = (float)(n2 * 16) * 0.5f;
                        float f3 = (float)(n2 * 16) * 0.5f;
                        float f4 = ((float)j - f2) / 16.0f * 2.0f;
                        float f5 = ((float)k - f3) / 16.0f * 2.0f;
                        if (f4 < -1.0f) {
                            f4 += 2.0f;
                        }
                        if (f4 >= 1.0f) {
                            f4 -= 2.0f;
                        }
                        if (f5 < -1.0f) {
                            f5 += 2.0f;
                        }
                        if (f5 >= 1.0f) {
                            f5 -= 2.0f;
                        }
                        float f6 = f4 * f4 + f5 * f5;
                        float f7 = (float)Math.atan2(f5, f4) + ((float)i / 32.0f * (float)Math.PI * 2.0f - f6 * 10.0f + (float)(n2 * 2)) * (float)(n2 * 2 - 1);
                        f7 = (MathHelper.a(f7) + 1.0f) / 2.0f;
                        f += (f7 /= f6 + 1.0f) * 0.5f;
                    }
                    n2 = (int)((f += random.nextFloat() * 0.1f) * 100.0f + 155.0f);
                    int n3 = (int)(f * f * 200.0f + 55.0f);
                    int n4 = (int)(f * f * f * f * 255.0f);
                    int n5 = (int)(f * 100.0f + 155.0f);
                    int n6 = k * 16 + j;
                    switch (this.b) {
                        case 528: {
                            n3 = (int)(f * 100.0f + 155.0f);
                            n4 = (int)(f * f * 155.0f);
                            n2 = (int)(f * f * 155.0f);
                            break;
                        }
                        case 529: {
                            n3 = (int)(f * 100.0f + 155.0f);
                            n4 = (int)(f * 80.0f + 60.0f);
                            n2 = (int)(f * f * 60.0f);
                            break;
                        }
                        case 530: {
                            n3 = (int)(f * 120.0f + 135.0f);
                            n4 = (int)(f * 100.0f + 120.0f);
                            n2 = (int)(f * f * 40.0f);
                            break;
                        }
                        case 531: {
                            n3 = (int)(f * 80.0f + 100.0f);
                            n4 = (int)(f * 120.0f + 135.0f);
                            n2 = (int)(f * f * 40.0f);
                            break;
                        }
                        case 532: {
                            n3 = (int)(f * 60.0f);
                            n4 = (int)(f * 120.0f + 135.0f);
                            n2 = (int)(f * f * 60.0f);
                            break;
                        }
                        case 533: {
                            n3 = (int)(f * 60.0f);
                            n4 = (int)(f * 120.0f + 135.0f);
                            n2 = (int)(f * 100.0f + 100.0f);
                            break;
                        }
                        case 534: {
                            n3 = (int)(f * 50.0f);
                            n4 = (int)(f * 120.0f + 135.0f);
                            n2 = (int)(f * 120.0f + 135.0f);
                            break;
                        }
                        case 535: {
                            n3 = (int)(f * 45.0f + 55.0f);
                            n4 = (int)(f * 60.0f + 120.0f);
                            n2 = (int)(f * 140.0f + 115.0f);
                            break;
                        }
                        case 536: {
                            n3 = (int)(f * 80.0f + 60.0f);
                            n4 = (int)(f * 80.0f + 60.0f);
                            n2 = (int)(f * 120.0f + 135.0f);
                            break;
                        }
                        case 537: {
                            n3 = (int)(f * 100.0f + 80.0f);
                            n4 = (int)(f * 40.0f);
                            n2 = (int)(f * 120.0f + 135.0f);
                            break;
                        }
                        case 538: {
                            n3 = (int)(f * 120.0f + 100.0f);
                            n4 = (int)(f * 60.0f);
                            n2 = (int)(f * 120.0f + 135.0f);
                            break;
                        }
                        case 539: {
                            n3 = (int)(f * 120.0f + 135.0f);
                            n4 = (int)(f * 40.0f);
                            n2 = (int)(f * 120.0f + 135.0f);
                            break;
                        }
                        case 540: {
                            n3 = (int)(f * 120.0f + 155.0f);
                            n4 = (int)(f * 60.0f);
                            n2 = (int)(f * 80.0f + 60.0f);
                            break;
                        }
                        case 541: {
                            n3 = (int)(f * 60.0f + 60.0f);
                            n4 = (int)(f * 60.0f + 60.0f);
                            n2 = (int)(f * 60.0f + 60.0f);
                            break;
                        }
                        case 542: {
                            n3 = (int)(f * 100.0f + 100.0f);
                            n4 = (int)(f * 100.0f + 100.0f);
                            n2 = (int)(f * 100.0f + 100.0f);
                            break;
                        }
                        case 543: {
                            n3 = (int)(f * 100.0f + 155.0f);
                            n4 = (int)(f * 100.0f + 155.0f);
                            n2 = (int)(f * 100.0f + 155.0f);
                        }
                    }
                    this.portalTextureData[i][n6 * 4 + 0] = (byte)n3;
                    this.portalTextureData[i][n6 * 4 + 1] = (byte)n4;
                    this.portalTextureData[i][n6 * 4 + 2] = (byte)n2;
                    this.portalTextureData[i][n6 * 4 + 3] = (byte)n5;
                }
            }
        }
    }

    @Override
    public void a() {
        ++this.portalTickCounter;
        byte[] byArray = this.portalTextureData[this.portalTickCounter & 0x1F];
        for (int i = 0; i < 256; ++i) {
            int n = byArray[i * 4 + 0] & 0xFF;
            int n2 = byArray[i * 4 + 1] & 0xFF;
            int n3 = byArray[i * 4 + 2] & 0xFF;
            int n4 = byArray[i * 4 + 3] & 0xFF;
            this.a[i * 4 + 0] = (byte)n;
            this.a[i * 4 + 1] = (byte)n2;
            this.a[i * 4 + 2] = (byte)n3;
            this.a[i * 4 + 3] = (byte)n4;
        }
    }
}

