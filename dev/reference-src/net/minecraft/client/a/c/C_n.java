/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a.c;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import net.minecraft.client.a.c.C_b;
import net.minecraft.client.d;

public class C_n
extends C_b {
    private static final int NUM_SEASONS = 4;
    private static final int TEXTURE_WIDTH = 16;
    private static final int TEXTURE_HEIGHT = 16;
    private final d minecraft;
    private final int[][] seasonalIcons = new int[4][256];

    public C_n(d d2, int n) {
        super(n);
        this.minecraft = d2;
        try {
            int n2 = n % 32 * 16;
            int n3 = n / 32 * 16;
            BufferedImage bufferedImage = ImageIO.read(d2.texturePackList.selectedTexturePack.getResourceAsStream("/terrain.png"));
            for (int i = 0; i < 4; ++i) {
                bufferedImage.getRGB(n2 + i * 16, n3, 16, 16, this.seasonalIcons[i], 0, 16);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void a() {
        if (this.minecraft.d == null) {
            return;
        }
        int n = this.minecraft.d.season.currentSeason;
        int n2 = this.minecraft.d.season.lastSeason;
        int n3 = this.minecraft.d.season.nextSeason;
        float f = this.minecraft.d.season.seasonProgress;
        int n4 = f <= 0.5f ? n2 : n3;
        float f2 = -(Math.abs(f * 2.0f - 1.0f) - 1.0f) * 0.5f + 0.5f;
        float f3 = 1.0f - f2;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n5 = this.seasonalIcons[n][i + j * 16];
                int n6 = this.seasonalIcons[n4][i + j * 16];
                int n7 = n5 >> 24 & 0xFF;
                int n8 = n5 >> 16 & 0xFF;
                int n9 = n5 >> 8 & 0xFF;
                int n10 = n5 >> 0 & 0xFF;
                int n11 = n6 >> 24 & 0xFF;
                int n12 = n6 >> 16 & 0xFF;
                int n13 = n6 >> 8 & 0xFF;
                int n14 = n6 >> 0 & 0xFF;
                int n15 = (int)((float)n7 * f2) + (int)((float)n11 * f3);
                int n16 = (int)((float)n8 * f2) + (int)((float)n12 * f3);
                int n17 = (int)((float)n9 * f2) + (int)((float)n13 * f3);
                int n18 = (int)((float)n10 * f2) + (int)((float)n14 * f3);
                this.a[(i + j * 16) * 4 + 0] = (byte)n16;
                this.a[(i + j * 16) * 4 + 1] = (byte)n17;
                this.a[(i + j * 16) * 4 + 2] = (byte)n18;
                this.a[(i + j * 16) * 4 + 3] = (byte)n15;
            }
        }
    }
}

