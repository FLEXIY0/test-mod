/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.c.C_b;
import util.MathHelper;

public class C_c
extends C_b {
    static final byte[] otherCoordPairs = new byte[]{2, 0, 0, 1, 2, 1};
    Random rand = new Random();
    World worldObj;
    int[] basePos = new int[]{0, 0, 0};
    int heightLimit = 0;
    int height;
    double heightAttenuation = 0.618;
    double branchDensity = 1.0;
    double branchSlope = 0.381;
    double scaleWidth = 1.0;
    double leafDensity = 1.0;
    int trunkSize = 1;
    int heightLimitLimit = 12;
    public int leafDistanceLimit = 4;
    public int metadata = 0;
    int[][] leafNodes;

    public C_c(boolean bl) {
        super(bl);
    }

    void generateLeafNodeList() {
        int n;
        this.height = (int)((double)this.heightLimit * this.heightAttenuation);
        if (this.height >= this.heightLimit) {
            this.height = this.heightLimit - 1;
        }
        if ((n = (int)(1.382 + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0, 2.0))) < 1) {
            n = 1;
        }
        int[][] nArray = new int[n * this.heightLimit][4];
        int n2 = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
        int n3 = 1;
        int n4 = this.basePos[1] + this.height;
        int n5 = n2 - this.basePos[1];
        nArray[0][0] = this.basePos[0];
        nArray[0][1] = n2--;
        nArray[0][2] = this.basePos[2];
        nArray[0][3] = n4;
        while (n5 >= 0) {
            float f = this.layerSize(n5);
            if (f < 0.0f) {
                --n2;
                --n5;
                continue;
            }
            double d2 = 0.5;
            for (int i = 0; i < n; ++i) {
                int[] nArray2;
                int n6;
                double d3;
                double d4 = this.scaleWidth * (double)f * ((double)this.rand.nextFloat() + 0.328);
                int n7 = MathHelper.a(d4 * Math.sin(d3 = (double)this.rand.nextFloat() * 2.0 * 3.14159) + (double)this.basePos[0] + d2);
                int[] nArray3 = new int[]{n7, n2, n6 = MathHelper.a(d4 * Math.cos(d3) + (double)this.basePos[2] + d2)};
                if (this.checkBlockLine(nArray3, nArray2 = new int[]{n7, n2 + this.leafDistanceLimit, n6}) != -1) continue;
                int[] nArray4 = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]};
                double d5 = Math.sqrt(Math.pow(Math.abs(this.basePos[0] - nArray3[0]), 2.0) + Math.pow(Math.abs(this.basePos[2] - nArray3[2]), 2.0));
                double d6 = d5 * this.branchSlope;
                nArray4[1] = (double)nArray3[1] - d6 > (double)n4 ? n4 : (int)((double)nArray3[1] - d6);
                if (this.checkBlockLine(nArray4, nArray3) != -1) continue;
                nArray[n3][0] = n7;
                nArray[n3][1] = n2;
                nArray[n3][2] = n6;
                nArray[n3][3] = nArray4[1];
                ++n3;
            }
            --n2;
            --n5;
        }
        this.leafNodes = new int[n3][4];
        System.arraycopy(nArray, 0, this.leafNodes, 0, n3);
    }

    void genTreeLayer(int n, int n2, int n3, float f, byte by, int n4) {
        int n5 = (int)((double)f + 0.618);
        byte by2 = otherCoordPairs[by];
        byte by3 = otherCoordPairs[by + 3];
        int[] nArray = new int[]{n, n2, n3};
        int[] nArray2 = new int[]{0, 0, 0};
        int n6 = -n5;
        nArray2[by] = nArray[by];
        for (int i = -n5; i <= n5; ++i) {
            nArray2[by2] = nArray[by2] + i;
            n6 = -n5;
            while (n6 <= n5) {
                double d2 = Math.sqrt(Math.pow((double)Math.abs(i) + 0.5, 2.0) + Math.pow((double)Math.abs(n6) + 0.5, 2.0));
                if (d2 > (double)f) {
                    ++n6;
                    continue;
                }
                nArray2[by3] = nArray[by3] + n6;
                int n7 = this.worldObj.a(nArray2[0], nArray2[1], nArray2[2]);
                if (n7 != 0 && n7 != 18) {
                    ++n6;
                    continue;
                }
                if (this.metadata == 1) {
                    this.setBlockAndMetadata(this.worldObj, nArray2[0], nArray2[1], nArray2[2], n4, this.rand.nextInt(2) == 0 ? 1 : 2);
                } else {
                    this.setBlockAndMetadata(this.worldObj, nArray2[0], nArray2[1], nArray2[2], n4, this.metadata);
                }
                ++n6;
            }
        }
    }

    float layerSize(int n) {
        if ((double)n < (double)this.heightLimit * 0.3) {
            return -1.618f;
        }
        float f = (float)this.heightLimit / 2.0f;
        float f2 = (float)this.heightLimit / 2.0f - (float)n;
        float f3 = f2 == 0.0f ? f : (Math.abs(f2) >= f ? 0.0f : (float)Math.sqrt(Math.pow(Math.abs(f), 2.0) - Math.pow(Math.abs(f2), 2.0)));
        return f3 *= 0.5f;
    }

    float leafSize(int n) {
        return n >= 0 && n < this.leafDistanceLimit ? (n != 0 && n != this.leafDistanceLimit - 1 ? 3.0f : 2.0f) : -1.0f;
    }

    void generateLeafNode(int n, int n2, int n3) {
        int n4 = n2 + this.leafDistanceLimit;
        for (int i = n2; i < n4; ++i) {
            float f = this.leafSize(i - n2);
            this.genTreeLayer(n, i, n3, f, (byte)1, 18);
        }
    }

    void placeBlockLine(int[] nArray, int[] nArray2, int n) {
        int[] nArray3 = new int[]{0, 0, 0};
        int n2 = 0;
        for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            nArray3[n3] = nArray2[n3] - nArray[n3];
            if (Math.abs(nArray3[n3]) <= Math.abs(nArray3[n2])) continue;
            n2 = n3;
        }
        if (nArray3[n2] != 0) {
            byte by = otherCoordPairs[n2];
            byte by2 = otherCoordPairs[n2 + 3];
            int n4 = nArray3[n2] > 0 ? 1 : -1;
            double d2 = (double)nArray3[by] / (double)nArray3[n2];
            double d3 = (double)nArray3[by2] / (double)nArray3[n2];
            int[] nArray4 = new int[]{0, 0, 0};
            int n5 = nArray3[n2] + n4;
            for (int i = 0; i != n5; i += n4) {
                nArray4[n2] = MathHelper.a((double)(nArray[n2] + i) + 0.5);
                nArray4[by] = MathHelper.a((double)nArray[by] + (double)i * d2 + 0.5);
                nArray4[by2] = MathHelper.a((double)nArray[by2] + (double)i * d3 + 0.5);
                this.setBlockAndMetadata(this.worldObj, nArray4[0], nArray4[1], nArray4[2], n, 0);
            }
        }
    }

    void generateLeaves() {
        int n = this.leafNodes.length;
        for (int i = 0; i < n; ++i) {
            int n2 = this.leafNodes[i][0];
            int n3 = this.leafNodes[i][1];
            int n4 = this.leafNodes[i][2];
            this.generateLeafNode(n2, n3, n4);
        }
    }

    boolean leafNodeNeedsBase(int n) {
        return (double)n >= (double)this.heightLimit * 0.2;
    }

    void generateTrunk() {
        int n = this.basePos[0];
        int n2 = this.basePos[1];
        int n3 = this.basePos[1] + this.height;
        int n4 = this.basePos[2];
        int[] nArray = new int[]{n, n2, n4};
        int[] nArray2 = new int[]{n, n3, n4};
        this.placeBlockLine(nArray, nArray2, 17);
        if (this.trunkSize == 2) {
            nArray[0] = nArray[0] + 1;
            nArray2[0] = nArray2[0] + 1;
            this.placeBlockLine(nArray, nArray2, 17);
            nArray[2] = nArray[2] + 1;
            nArray2[2] = nArray2[2] + 1;
            this.placeBlockLine(nArray, nArray2, 17);
            nArray[0] = nArray[0] + -1;
            nArray2[0] = nArray2[0] + -1;
            this.placeBlockLine(nArray, nArray2, 17);
        }
    }

    void generateLeafNodeBases() {
        int n = this.leafNodes.length;
        int[] nArray = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]};
        for (int i = 0; i < n; ++i) {
            int[] nArray2 = this.leafNodes[i];
            int[] nArray3 = new int[]{nArray2[0], nArray2[1], nArray2[2]};
            nArray[1] = nArray2[3];
            int n2 = nArray[1] - this.basePos[1];
            if (!this.leafNodeNeedsBase(n2)) continue;
            this.placeBlockLine(nArray, nArray3, 17);
        }
    }

    int checkBlockLine(int[] nArray, int[] nArray2) {
        int n;
        int[] nArray3 = new int[]{0, 0, 0};
        int n2 = 0;
        for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
            nArray3[n3] = nArray2[n3] - nArray[n3];
            if (Math.abs(nArray3[n3]) <= Math.abs(nArray3[n2])) continue;
            n2 = n3;
        }
        if (nArray3[n2] == 0) {
            return -1;
        }
        byte by = otherCoordPairs[n2];
        byte by2 = otherCoordPairs[n2 + 3];
        int n4 = nArray3[n2] > 0 ? 1 : -1;
        double d2 = (double)nArray3[by] / (double)nArray3[n2];
        double d3 = (double)nArray3[by2] / (double)nArray3[n2];
        int[] nArray4 = new int[]{0, 0, 0};
        int n5 = nArray3[n2] + n4;
        for (n = 0; n != n5; n += n4) {
            nArray4[n2] = nArray[n2] + n;
            nArray4[by] = MathHelper.a((double)nArray[by] + (double)n * d2);
            nArray4[by2] = MathHelper.a((double)nArray[by2] + (double)n * d3);
            int n6 = this.worldObj.a(nArray4[0], nArray4[1], nArray4[2]);
            if (n6 != 0) break;
        }
        return n == n5 ? -1 : Math.abs(n);
    }

    boolean validTreeLocation() {
        int[] nArray = new int[]{this.basePos[0], this.basePos[1], this.basePos[2]};
        int[] nArray2 = new int[]{this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2]};
        int n = this.worldObj.a(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);
        if (n != 2 && n != 3) {
            return false;
        }
        if (nArray[0] <= 0 || nArray[1] <= 0 || nArray[2] <= 0 || nArray[0] >= this.worldObj.a || nArray[1] >= this.worldObj.c || nArray[2] >= this.worldObj.b) {
            return false;
        }
        int n2 = this.checkBlockLine(nArray, nArray2);
        if (n2 == -1) {
            return true;
        }
        if (n2 < 6) {
            return false;
        }
        this.heightLimit = n2;
        return true;
    }

    @Override
    public void setScale(double d2, double d3, double d4) {
        this.heightLimitLimit = (int)(d2 * 12.0);
        if (d2 > 0.5) {
            this.leafDistanceLimit = 5;
        }
        this.scaleWidth = d3;
        this.leafDensity = d4;
    }

    @Override
    public boolean generate(World c_g, Random random, int n, int n2, int n3) {
        this.worldObj = c_g;
        long l = random.nextLong();
        this.rand.setSeed(l);
        this.basePos[0] = n;
        this.basePos[1] = n2;
        this.basePos[2] = n3;
        if (this.heightLimit == 0) {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }
        if (!this.validTreeLocation()) {
            c_g.cantGrow = true;
            return false;
        }
        this.generateLeafNodeList();
        this.generateLeaves();
        this.generateTrunk();
        this.generateLeafNodeBases();
        c_g.cantGrow = false;
        return true;
    }
}

