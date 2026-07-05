/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class C_c {
    private int[] a;
    private int b;
    private int c;

    public BufferedImage a(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        }
        this.b = 64;
        this.c = 32;
        BufferedImage bufferedImage2 = new BufferedImage(this.b, this.c, 2);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();
        this.a = ((DataBufferInt)bufferedImage2.getRaster().getDataBuffer()).getData();
        this.b(0, 0, 32, 16);
        this.a(32, 0, 64, 32);
        this.b(0, 16, 64, 32);
        return bufferedImage2;
    }

    private void a(int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = 32;
        int n6 = 64;
        int n7 = 0;
        int n8 = 32;
        C_c c_c = this;
        n2 = n8;
        block0: while (true) {
            if (n2 >= n6) {
                bl = false;
                break;
            }
            for (int i = n7; i < n5; ++i) {
                if (c_c.a[n2 + i * c_c.b] >>> 24 >= 128) continue;
                bl = true;
                break block0;
            }
            ++n2;
        }
        if (!bl) {
            for (n = 32; n < 64; ++n) {
                for (n2 = 0; n2 < 32; ++n2) {
                    int n9 = n + n2 * this.b;
                    this.a[n9] = this.a[n9] & 0xFFFFFF;
                }
            }
        }
    }

    private void b(int n, int n2, int n3, int n4) {
        for (n = 0; n < n3; ++n) {
            for (int i = n2; i < n4; ++i) {
                int n5 = n + i * this.b;
                this.a[n5] = this.a[n5] | 0xFF000000;
            }
        }
    }
}

