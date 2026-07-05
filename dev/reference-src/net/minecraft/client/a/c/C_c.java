/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.a.a.b.C_x;
import net.minecraft.client.a.c.C_b;
import util.MathHelper;

public class C_c
extends C_b {
    private int e = 0;
    private int[] f = new int[1024];
    private int[] g = new int[1024];
    private int h;

    public C_c(int n) {
        super(C_x.ak.as + n);
        this.h = (n << 1) - 1;
        this.e = 2;
        try {
            ImageIO.read(C_c.class.getResource("/misc/gear.png")).getRGB(0, 0, 32, 32, this.f, 0, 32);
            ImageIO.read(C_c.class.getResource("/misc/gearmiddle.png")).getRGB(0, 0, 16, 16, this.g, 0, 16);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public final void a() {
        if (this.h < 2) {
            this.e = this.e + this.h & 0x3F;
        }
        float f = MathHelper.a((float)this.e / 64.0f * (float)Math.PI * 2.0f);
        float f2 = MathHelper.b((float)this.e / 64.0f * (float)Math.PI * 2.0f);
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                float f3 = ((float)i / 15.0f - 0.5f) * 31.0f;
                float f4 = ((float)j / 15.0f - 0.5f) * 31.0f;
                float f5 = f2 * f3 - f * f4;
                f3 = f2 * f4 + f * f3;
                int n = (int)(f5 + 16.0f);
                int n2 = (int)(f3 + 16.0f);
                int n3 = 0;
                if (n >= 0 && n2 >= 0 && n < 32 && n2 < 32) {
                    n3 = this.f[n + (n2 << 5)];
                    n2 = this.g[i + (j << 4)];
                    if (n2 >>> 24 > 128) {
                        n3 = n2;
                    }
                }
                n2 = n3 >> 16 & 0xFF;
                n = n3 >> 8 & 0xFF;
                int n4 = n3 & 0xFF;
                n3 = n3 >>> 24 > 128 ? 255 : 0;
                int n5 = i + (j << 4);
                this.a[n5 << 2] = (byte)n2;
                this.a[(n5 << 2) + 1] = (byte)n;
                this.a[(n5 << 2) + 2] = (byte)n4;
                this.a[(n5 << 2) + 3] = (byte)n3;
            }
        }
    }
}

