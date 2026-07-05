/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import net.minecraft.client.a.c.C_b;
import net.minecraft.client.d;

public class C_g
extends C_b {
    private static final int TEXTURE_WIDTH = 16;
    private static final int TEXTURE_HEIGHT = 16;
    private int frames = 3;
    private int counter = 0;
    private int tickDelay = 0;
    private int tickCounter = 0;
    private int[] textureIntArray1 = new int[1024];
    private int[] textureIntArray2 = new int[1024];
    private int[] textureIntArray3 = new int[1024];

    public C_g(d d2, int n, int n2) {
        super(n);
        this.tickDelay = n2;
        if (this.tickDelay < 0) {
            this.frames = 2;
        }
        try {
            int n3 = n % 32 * 16;
            int n4 = n / 32 * 16;
            BufferedImage bufferedImage = ImageIO.read(d2.texturePackList.selectedTexturePack.getResourceAsStream("/terrain.png"));
            switch (this.frames) {
                case 3: {
                    bufferedImage.getRGB(n3 - 16, n4, 16, 16, this.textureIntArray1, 0, 16);
                    bufferedImage.getRGB(n3, n4, 16, 16, this.textureIntArray2, 0, 16);
                    bufferedImage.getRGB(n3 + 16, n4, 16, 16, this.textureIntArray3, 0, 16);
                    break;
                }
                default: {
                    bufferedImage.getRGB(n3, n4, 16, 16, this.textureIntArray1, 0, 16);
                    bufferedImage.getRGB(n3 + 16, n4, 16, 16, this.textureIntArray2, 0, 16);
                    break;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public final void a() {
        if (this.frames == 2) {
            ++this.counter;
            if (this.counter > 3) {
                this.counter = 0;
            }
        } else {
            ++this.tickCounter;
            if (this.tickCounter >= this.tickDelay) {
                this.tickCounter = 0;
                ++this.counter;
                if (this.frames == 3 && this.counter > 2) {
                    this.counter = 0;
                } else if (this.frames != 3 && this.counter > 1) {
                    this.counter = 0;
                }
            }
        }
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n = this.textureIntArray1[i + j * 16];
                int n2 = this.textureIntArray2[i + j * 16];
                int n3 = this.textureIntArray3[i + j * 16];
                int n4 = n >> 24 & 0xFF;
                int n5 = n >> 16 & 0xFF;
                int n6 = n >> 8 & 0xFF;
                int n7 = n >> 0 & 0xFF;
                int n8 = n2 >> 24 & 0xFF;
                int n9 = n2 >> 16 & 0xFF;
                int n10 = n2 >> 8 & 0xFF;
                int n11 = n2 >> 0 & 0xFF;
                int n12 = n3 >> 24 & 0xFF;
                int n13 = n3 >> 16 & 0xFF;
                int n14 = n3 >> 8 & 0xFF;
                int n15 = n3 >> 0 & 0xFF;
                if (this.frames == 3) {
                    switch (this.counter) {
                        case 0: {
                            this.a[(i + j * 16) * 4 + 0] = (byte)n5;
                            this.a[(i + j * 16) * 4 + 1] = (byte)n6;
                            this.a[(i + j * 16) * 4 + 2] = (byte)n7;
                            this.a[(i + j * 16) * 4 + 3] = (byte)n4;
                            break;
                        }
                        case 1: {
                            this.a[(i + j * 16) * 4 + 0] = (byte)n9;
                            this.a[(i + j * 16) * 4 + 1] = (byte)n10;
                            this.a[(i + j * 16) * 4 + 2] = (byte)n11;
                            this.a[(i + j * 16) * 4 + 3] = (byte)n8;
                            break;
                        }
                        case 2: {
                            this.a[(i + j * 16) * 4 + 0] = (byte)n13;
                            this.a[(i + j * 16) * 4 + 1] = (byte)n14;
                            this.a[(i + j * 16) * 4 + 2] = (byte)n15;
                            this.a[(i + j * 16) * 4 + 3] = (byte)n12;
                            break;
                        }
                    }
                    continue;
                }
                if (this.counter < 2) {
                    this.a[(i + j * 16) * 4 + 0] = (byte)n5;
                    this.a[(i + j * 16) * 4 + 1] = (byte)n6;
                    this.a[(i + j * 16) * 4 + 2] = (byte)n7;
                    this.a[(i + j * 16) * 4 + 3] = (byte)n4;
                    continue;
                }
                this.a[(i + j * 16) * 4 + 0] = (byte)n9;
                this.a[(i + j * 16) * 4 + 1] = (byte)n10;
                this.a[(i + j * 16) * 4 + 2] = (byte)n11;
                this.a[(i + j * 16) * 4 + 3] = (byte)n8;
            }
        }
    }
}

