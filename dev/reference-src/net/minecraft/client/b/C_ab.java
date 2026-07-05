/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.b;

import net.minecraft.client.b.C_c;
import net.minecraft.client.b.C_l;
import util.MathHelper;

public class C_ab
extends C_l {
    private C_c[] silverfishBodyParts = new C_c[7];
    private C_c[] silverfishWings;
    private float[] ass = new float[7];
    private static final int[][] silverfishBoxLength = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
    private static final int[][] silverfishTexturePositions = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

    public C_ab() {
        float f = -3.5f;
        for (int i = 0; i < this.silverfishBodyParts.length; ++i) {
            this.silverfishBodyParts[i] = new C_c(silverfishTexturePositions[i][0], silverfishTexturePositions[i][1]);
            this.silverfishBodyParts[i].a((float)silverfishBoxLength[i][0] * -0.5f, 0.0f, (float)silverfishBoxLength[i][2] * -0.5f, silverfishBoxLength[i][0], silverfishBoxLength[i][1], silverfishBoxLength[i][2], 0.0f);
            this.silverfishBodyParts[i].a(0.0f, 24 - silverfishBoxLength[i][1], f);
            this.ass[i] = f;
            if (i >= this.silverfishBodyParts.length - 1) continue;
            f += (float)(silverfishBoxLength[i][2] + silverfishBoxLength[i + 1][2]) * 0.5f;
        }
        this.silverfishWings = new C_c[3];
        this.silverfishWings[0] = new C_c(20, 0);
        this.silverfishWings[0].a(-5.0f, 0.0f, (float)silverfishBoxLength[2][2] * -0.5f, 10, 8, silverfishBoxLength[2][2], 0.0f);
        this.silverfishWings[0].a(0.0f, 16.0f, this.ass[2]);
        this.silverfishWings[1] = new C_c(20, 11);
        this.silverfishWings[1].a(-3.0f, 0.0f, (float)silverfishBoxLength[4][2] * -0.5f, 6, 4, silverfishBoxLength[4][2], 0.0f);
        this.silverfishWings[1].a(0.0f, 20.0f, this.ass[4]);
        this.silverfishWings[2] = new C_c(20, 18);
        this.silverfishWings[2].a(-3.0f, 0.0f, (float)silverfishBoxLength[4][2] * -0.5f, 6, 5, silverfishBoxLength[1][2], 0.0f);
        this.silverfishWings[2].a(0.0f, 19.0f, this.ass[1]);
    }

    public int cunkf() {
        return 38;
    }

    @Override
    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        this.b(f, f2, f3, f4, f5, f6);
        for (n = 0; n < this.silverfishBodyParts.length; ++n) {
            this.silverfishBodyParts[n].a(f6);
        }
        for (n = 0; n < this.silverfishWings.length; ++n) {
            this.silverfishWings[n].a(f6);
        }
    }

    @Override
    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < this.silverfishBodyParts.length; ++i) {
            this.silverfishBodyParts[i].b = MathHelper.b(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.05f * (float)(1 + Math.abs(i - 2));
            this.silverfishBodyParts[i].j = MathHelper.a(f3 * 0.9f + (float)i * 0.15f * (float)Math.PI) * (float)Math.PI * 0.2f * (float)Math.abs(i - 2);
        }
        this.silverfishWings[0].b = this.silverfishBodyParts[2].b;
        this.silverfishWings[1].b = this.silverfishBodyParts[4].b;
        this.silverfishWings[1].j = this.silverfishBodyParts[4].j;
        this.silverfishWings[2].b = this.silverfishBodyParts[1].b;
        this.silverfishWings[2].j = this.silverfishBodyParts[1].j;
    }
}

