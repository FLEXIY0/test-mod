/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_aj;
import net.minecraft.a.a.b.C_ar;
import net.minecraft.a.a.b.C_bn;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_bt;
import net.minecraft.a.a.b.C_p;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.game.level.block.container.BlockChest;
import net.minecraft.game.level.block.furniture.BlockBed;
import net.minecraft.game.level.block.furniture.BlockDoor;
import net.minecraft.game.level.block.furniture.BlockFence;
import net.minecraft.game.level.block.furniture.BlockFenceGate;
import net.minecraft.game.level.block.furniture.BlockFlowerPot;
import net.minecraft.game.level.block.furniture.BlockLantern;
import net.minecraft.game.level.block.furniture.BlockPane;
import net.minecraft.game.level.block.furniture.BlockRod;
import net.minecraft.game.level.block.furniture.BlockTable;
import net.minecraft.game.level.block.furniture.BlockTorch;
import net.minecraft.game.level.block.furniture.BlockWall;
import net.minecraft.game.level.block.machines.BlockDetector;
import net.minecraft.game.level.block.machines.BlockPistonBase;
import net.minecraft.game.level.block.machines.BlockPistonExtension;
import net.minecraft.game.level.block.plants.BlockFlower;
import net.minecraft.game.level.block.plants.BlockStem;
import org.lwjgl.opengl.GL11;

public final class C_f {
    private C_g a;
    private int b = -1;
    private boolean flipTexture = false;
    private boolean c = false;
    private int activeRenderPass = 0;
    private int uvRotateEast = 0;
    private int uvRotateWest = 0;
    private int uvRotateSouth = 0;
    private int uvRotateNorth = 0;
    private int uvRotateTop = 0;
    private int uvRotateBottom = 0;

    public C_f(C_g c_g) {
        this.a = c_g;
    }

    public C_f() {
    }

    public void setRenderPass(int n) {
        this.activeRenderPass = n;
    }

    public final void a(C_x c_x, int n, int n2, int n3, int n4) {
        this.b = n4;
        if (c_x instanceof C_bt || c_x instanceof BlockDetector || c_x instanceof BlockChest) {
            this.activeRenderPass = 2;
            this.renderBlockSlime(c_x, n, n2, n3);
        } else {
            this.b(c_x, n, n2, n3);
        }
        this.b = -1;
    }

    public final void a(C_x c_x, int n, int n2, int n3) {
        this.flipTexture = true;
        this.b(c_x, n, n2, n3);
        this.flipTexture = false;
    }

    public final boolean b(C_x c_x, int n, int n2, int n3) {
        c_x.setBlockBoundsBasedOnState(this.a, n, n2, n3);
        int n4 = c_x.a();
        if (n4 == 0) {
            float f;
            int n5 = n;
            int n6 = n2;
            n4 = n3;
            n3 = n6;
            n2 = n5;
            C_d c_d = C_d.a;
            boolean bl = false;
            if (this.flipTexture || this.c || c_x.d(this.a, n2, n3 - 1, n4, 0)) {
                f = c_x.f(this.a, n2, n3 - 1, n4);
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(0.5f * f, 0.5f * f, 0.5f * f);
                this.renderBottomFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 0));
                bl = true;
            }
            if (this.flipTexture || this.c || c_x.d(this.a, n2, n3 + 1, n4, 1)) {
                f = c_x.f(this.a, n2, n3 + 1, n4);
                if (c_x instanceof C_aj && !((C_aj)c_x).a) {
                    f = c_x.f(this.a, n2, n3, n4);
                }
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(f * 1.0f, f * 1.0f, f * 1.0f);
                this.renderTopFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 1));
                bl = true;
            }
            if (this.flipTexture || this.c || c_x.d(this.a, n2, n3, n4 - 1, 2)) {
                f = c_x.f(this.a, n2, n3, n4 - 1);
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
                this.renderEastFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 2));
                bl = true;
            }
            if (this.flipTexture || this.c || c_x.d(this.a, n2, n3, n4 + 1, 3)) {
                f = c_x.f(this.a, n2, n3, n4 + 1);
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
                this.renderWestFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 3));
                bl = true;
            }
            if (this.flipTexture || this.c || c_x.d(this.a, n2 - 1, n3, n4, 4)) {
                f = c_x.f(this.a, n2 - 1, n3, n4);
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
                this.renderNorthFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 4));
                bl = true;
            }
            if (this.flipTexture || this.c || c_x.d(this.a, n2 + 1, n3, n4, 5)) {
                f = c_x.f(this.a, n2 + 1, n3, n4);
                if (C_x.h[c_x.at] > 0) {
                    f = 1.0f;
                }
                c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
                this.renderSouthFace(c_x, n2, n3, n4, c_x.a(this.a, n2, n3, n4, 5));
                bl = true;
            }
            return bl;
        }
        if (n4 == 9) {
            int n7 = n;
            int n8 = n2;
            n4 = n3;
            n3 = n8;
            n2 = n7;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            c_d.a(f, f, f);
            this.renderBlockReeds(c_x, this.a.e(n2, n3, n4), n2, (float)n3 - 0.0625f, n4);
            return true;
        }
        if (n4 == 4) {
            float f;
            int n9 = n;
            int n10 = n2;
            n4 = n3;
            n3 = n10;
            n2 = n9;
            C_d c_d = C_d.a;
            boolean bl = false;
            float f2 = c_x.av;
            float f3 = c_x.ay;
            c_x.ay = f3 - this.a(n2, n3, n4);
            if (this.flipTexture || c_x.d(this.a, n2, n3 - 1, n4, 0)) {
                f = c_x.f(this.a, n2, n3 - 1, n4);
                c_d.a(0.5f * f, 0.5f * f, 0.5f * f);
                this.renderBottomFace(c_x, n2, n3, n4, c_x.a(0));
                bl = true;
            }
            if (this.flipTexture || c_x.d(this.a, n2, n3 + 1, n4, 1)) {
                f = c_x.f(this.a, n2, n3 + 1, n4);
                c_d.a(f * 1.0f, f * 1.0f, f * 1.0f);
                this.renderTopFace(c_x, n2, n3, n4, c_x.a(1));
                bl = true;
            }
            c_x.av = f3 - this.a(n2, n3, n4 - 1);
            if (this.flipTexture || c_x.ay > c_x.av || c_x.d(this.a, n2, n3, n4 - 1, 2)) {
                f = c_x.f(this.a, n2, n3, n4 - 1);
                c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
                this.renderEastFace(c_x, n2, n3, n4, c_x.a(2));
                bl = true;
            }
            c_x.av = f3 - this.a(n2, n3, n4 + 1);
            if (this.flipTexture || c_x.ay > c_x.av || c_x.d(this.a, n2, n3, n4 + 1, 3)) {
                f = c_x.f(this.a, n2, n3, n4 + 1);
                c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
                this.renderWestFace(c_x, n2, n3, n4, c_x.a(3));
                bl = true;
            }
            c_x.av = f3 - this.a(n2 - 1, n3, n4);
            if (this.flipTexture || c_x.ay > c_x.av || c_x.d(this.a, n2 - 1, n3, n4, 4)) {
                f = c_x.f(this.a, n2 - 1, n3, n4);
                c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
                this.renderNorthFace(c_x, n2, n3, n4, c_x.a(4));
                bl = true;
            }
            c_x.av = f3 - this.a(n2 + 1, n3, n4);
            if (this.flipTexture || c_x.ay > c_x.av || c_x.d(this.a, n2 + 1, n3, n4, 5)) {
                f = c_x.f(this.a, n2 + 1, n3, n4);
                c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
                this.renderSouthFace(c_x, n2, n3, n4, c_x.a(5));
                bl = true;
            }
            c_x.av = f2;
            c_x.ay = f3;
            return bl;
        }
        if (n4 == 1) {
            int n11 = n;
            int n12 = n2;
            n4 = n3;
            n3 = n12;
            n2 = n11;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            c_d.a(f, f, f);
            this.a(c_x, (int)this.a.e(n2, n3, n4), (float)n2, (float)n3, (float)n4);
            return true;
        }
        if (n4 == 6) {
            int n13 = n;
            int n14 = n2;
            n4 = n3;
            n3 = n14;
            n2 = n13;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            c_d.a(f, f, f);
            this.b(c_x, this.a.e(n2, n3, n4), n2, (float)n3 - 0.0625f, n4);
            return true;
        }
        if (n4 == 2) {
            int n15 = n;
            int n16 = n2;
            n4 = n3;
            n3 = n16;
            n2 = n15;
            byte by = this.a.e(n2, n3, n4);
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            if (by == 1) {
                this.a(c_x, (float)n2 - 0.099999994f, (float)n3 + 0.2f, n4, -0.4f, 0.0f);
            } else if (by == 2) {
                this.a(c_x, (float)n2 + 0.099999994f, (float)n3 + 0.2f, n4, 0.4f, 0.0f);
            } else if (by == 3) {
                this.a(c_x, n2, (float)n3 + 0.2f, (float)n4 - 0.099999994f, 0.0f, -0.4f);
            } else if (by == 4) {
                this.a(c_x, n2, (float)n3 + 0.2f, (float)n4 + 0.099999994f, 0.0f, 0.4f);
            } else {
                this.a(c_x, n2, n3, n4, 0.0f, 0.0f);
            }
            return true;
        }
        if (n4 == 19) {
            int n17 = n;
            int n18 = n2;
            n4 = n3;
            n3 = n18;
            n2 = n17;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockRope(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 20) {
            int n19 = n;
            int n20 = n2;
            n4 = n3;
            n3 = n20;
            n2 = n19;
            byte by = this.a.e(n2, n3, n4);
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockLantern(c_x, n2, n3, n4, (double)n3 + (by == 1 ? 0.375 : 0.0));
            return true;
        }
        if (n4 == 30) {
            int n21 = n;
            int n22 = n2;
            n4 = n3;
            n3 = n22;
            n2 = n21;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockFlowerpot((BlockFlowerPot)c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 31) {
            int n23 = n;
            int n24 = n2;
            n4 = n3;
            n3 = n24;
            n2 = n23;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockCactus(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 32) {
            int n25 = n;
            int n26 = n2;
            n4 = n3;
            n3 = n26;
            n2 = n25;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockStrippedLog(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 35) {
            int n27 = n;
            int n28 = n2;
            n4 = n3;
            n3 = n28;
            n2 = n27;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockLeaves(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 40) {
            int n29 = n;
            int n30 = n2;
            n4 = n3;
            n3 = n30;
            n2 = n29;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockStem(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 41) {
            int n31 = n;
            int n32 = n2;
            n4 = n3;
            n3 = n32;
            n2 = n31;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockFluids(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 200) {
            return this.renderBlockChest(c_x, n, n2, n3);
        }
        if (n4 == 3) {
            int n33 = n;
            int n34 = n2;
            n4 = n3;
            n3 = n34;
            n2 = n33;
            C_d c_d = C_d.a;
            int n35 = c_x.a(0);
            if (this.b >= 0) {
                n35 = this.b;
            }
            float f = c_x.f(this.a, n2, n3, n4);
            c_d.a(f, f, f);
            n = (n35 & 0x1F) << 4;
            int n36 = n35 >> 1 & 0x1F0;
            float f4 = (float)n / 512.0f;
            float f5 = ((float)n + 15.99f) / 512.0f;
            float f6 = (float)n36 / 512.0f;
            float f7 = ((float)n36 + 15.99f) / 512.0f;
            if (this.a.b(n2, n3 - 1, n4) || C_x.ag.e(this.a, n2, n3 - 1, n4)) {
                float f8 = (float)n2 + 0.5f + 0.2f;
                float f9 = (float)n2 + 0.5f - 0.2f;
                float f10 = (float)n4 + 0.5f + 0.2f;
                float f11 = (float)n4 + 0.5f - 0.2f;
                float f12 = (float)n2 + 0.5f - 0.3f;
                float f13 = (float)n2 + 0.5f + 0.3f;
                float f14 = (float)n4 + 0.5f - 0.3f;
                float f15 = (float)n4 + 0.5f + 0.3f;
                c_d.a(f12, (float)n3 + 1.4f, n4 + 1, f5, f6);
                c_d.a(f8, n3, n4 + 1, f5, f7);
                c_d.a(f8, n3, n4, f4, f7);
                c_d.a(f12, (float)n3 + 1.4f, n4, f4, f6);
                c_d.a(f13, (float)n3 + 1.4f, n4, f5, f6);
                c_d.a(f9, n3, n4, f5, f7);
                c_d.a(f9, n3, n4 + 1, f4, f7);
                c_d.a(f13, (float)n3 + 1.4f, n4 + 1, f4, f6);
                f4 = (float)n / 512.0f;
                f5 = ((float)n + 15.99f) / 512.0f;
                f6 = (float)n36 / 512.0f;
                f7 = ((float)n36 + 15.99f) / 512.0f;
                c_d.a(n2 + 1, (float)n3 + 1.4f, f15, f5, f6);
                c_d.a(n2 + 1, n3, f11, f5, f7);
                c_d.a(n2, n3, f11, f4, f7);
                c_d.a(n2, (float)n3 + 1.4f, f15, f4, f6);
                c_d.a(n2, (float)n3 + 1.4f, f14, f5, f6);
                c_d.a(n2, n3, f10, f5, f7);
                c_d.a(n2 + 1, n3, f10, f4, f7);
                c_d.a(n2 + 1, (float)n3 + 1.4f, f14, f4, f6);
                f8 = (float)n2 + 0.5f - 0.5f;
                f9 = (float)n2 + 0.5f + 0.5f;
                f10 = (float)n4 + 0.5f - 0.5f;
                f11 = (float)n4 + 0.5f + 0.5f;
                f12 = (float)n2 + 0.5f - 0.4f;
                f13 = (float)n2 + 0.5f + 0.4f;
                f14 = (float)n4 + 0.5f - 0.4f;
                f15 = (float)n4 + 0.5f + 0.4f;
                c_d.a(f12, (float)n3 + 1.4f, n4, f4, f6);
                c_d.a(f8, n3, n4, f4, f7);
                c_d.a(f8, n3, n4 + 1, f5, f7);
                c_d.a(f12, (float)n3 + 1.4f, n4 + 1, f5, f6);
                c_d.a(f13, (float)n3 + 1.4f, n4 + 1, f4, f6);
                c_d.a(f9, n3, n4 + 1, f4, f7);
                c_d.a(f9, n3, n4, f5, f7);
                c_d.a(f13, (float)n3 + 1.4f, n4, f5, f6);
                f4 = (float)n / 512.0f;
                f5 = ((float)n + 15.99f) / 512.0f;
                f6 = (float)n36 / 512.0f;
                f7 = ((float)n36 + 15.99f) / 512.0f;
                c_d.a(n2, (float)n3 + 1.4f, f15, f4, f6);
                c_d.a(n2, n3, f11, f4, f7);
                c_d.a(n2 + 1, n3, f11, f5, f7);
                c_d.a(n2 + 1, (float)n3 + 1.4f, f15, f5, f6);
                c_d.a(n2 + 1, (float)n3 + 1.4f, f14, f4, f6);
                c_d.a(n2 + 1, n3, f10, f4, f7);
                c_d.a(n2, n3, f10, f5, f7);
                c_d.a(n2, (float)n3 + 1.4f, f14, f5, f6);
            } else {
                float f16;
                if ((n2 + n3 + n4 & 1) == 1) {
                    f4 = (float)n / 512.0f;
                    f5 = ((float)n + 15.99f) / 512.0f;
                    f6 = (float)n36 / 512.0f;
                    f7 = ((float)n36 + 15.99f) / 512.0f;
                }
                if ((n2 / 2 + n3 / 2 + n4 / 2 & 1) == 1) {
                    f16 = f5;
                    f5 = f4;
                    f4 = f16;
                }
                if (C_x.ag.e(this.a, n2 - 1, n3, n4)) {
                    c_d.a((float)n2 + 0.2f, (float)n3 + 1.4f + 0.0625f, n4 + 1, f5, f6);
                    c_d.a(n2, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a(n2, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a((float)n2 + 0.2f, (float)n3 + 1.4f + 0.0625f, n4, f4, f6);
                    c_d.a((float)n2 + 0.2f, (float)n3 + 1.4f + 0.0625f, n4, f4, f6);
                    c_d.a(n2, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a(n2, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a((float)n2 + 0.2f, (float)n3 + 1.4f + 0.0625f, n4 + 1, f5, f6);
                }
                if (C_x.ag.e(this.a, n2 + 1, n3, n4)) {
                    c_d.a((float)(n2 + 1) - 0.2f, (float)n3 + 1.4f + 0.0625f, n4, f4, f6);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a((float)(n2 + 1) - 0.2f, (float)n3 + 1.4f + 0.0625f, n4 + 1, f5, f6);
                    c_d.a((float)(n2 + 1) - 0.2f, (float)n3 + 1.4f + 0.0625f, n4 + 1, f5, f6);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a((float)(n2 + 1) - 0.2f, (float)n3 + 1.4f + 0.0625f, n4, f4, f6);
                }
                if (C_x.ag.e(this.a, n2, n3, n4 - 1)) {
                    c_d.a(n2, (float)n3 + 1.4f + 0.0625f, (float)n4 + 0.2f, f5, f6);
                    c_d.a(n2, (float)n3 + 0.0625f, n4, f5, f7);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a(n2 + 1, (float)n3 + 1.4f + 0.0625f, (float)n4 + 0.2f, f4, f6);
                    c_d.a(n2 + 1, (float)n3 + 1.4f + 0.0625f, (float)n4 + 0.2f, f4, f6);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4, f4, f7);
                    c_d.a(n2, (float)n3 + 0.0625f, n4, f5, f7);
                    c_d.a(n2, (float)n3 + 1.4f + 0.0625f, (float)n4 + 0.2f, f5, f6);
                }
                if (C_x.ag.e(this.a, n2, n3, n4 + 1)) {
                    c_d.a(n2 + 1, (float)n3 + 1.4f + 0.0625f, (float)(n4 + 1) - 0.2f, f4, f6);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4 + 1, f4, f7);
                    c_d.a(n2, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a(n2, (float)n3 + 1.4f + 0.0625f, (float)(n4 + 1) - 0.2f, f5, f6);
                    c_d.a(n2, (float)n3 + 1.4f + 0.0625f, (float)(n4 + 1) - 0.2f, f5, f6);
                    c_d.a(n2, (float)n3 + 0.0625f, n4 + 1, f5, f7);
                    c_d.a(n2 + 1, (float)n3 + 0.0625f, n4 + 1, f4, f7);
                    c_d.a(n2 + 1, (float)n3 + 1.4f + 0.0625f, (float)(n4 + 1) - 0.2f, f4, f6);
                }
                if (C_x.ag.e(this.a, n2, n3 + 1, n4)) {
                    f16 = (float)n2 + 0.5f + 0.5f;
                    float f17 = (float)n2 + 0.5f - 0.5f;
                    float f18 = (float)n4 + 0.5f + 0.5f;
                    float f19 = (float)n4 + 0.5f - 0.5f;
                    f4 = (float)n / 512.0f;
                    f5 = ((float)n + 15.99f) / 512.0f;
                    f6 = (float)n36 / 512.0f;
                    f7 = ((float)n36 + 15.99f) / 512.0f;
                    if ((n2 + ++n3 + n4 & 1) == 0) {
                        c_d.a(f17, (float)n3 - 0.2f, n4, f5, f6);
                        c_d.a(f16, n3, n4, f5, f7);
                        c_d.a(f16, n3, n4 + 1, f4, f7);
                        c_d.a(f17, (float)n3 - 0.2f, n4 + 1, f4, f6);
                        f4 = (float)n / 512.0f;
                        f5 = ((float)n + 15.99f) / 512.0f;
                        f6 = (float)n36 / 512.0f;
                        f7 = ((float)n36 + 15.99f) / 512.0f;
                        c_d.a(f16, (float)n3 - 0.2f, n4 + 1, f5, f6);
                        c_d.a(f17, n3, n4 + 1, f5, f7);
                        c_d.a(f17, n3, n4, f4, f7);
                        c_d.a(f16, (float)n3 - 0.2f, n4, f4, f6);
                    } else {
                        c_d.a(n2, (float)n3 - 0.2f, f18, f5, f6);
                        c_d.a(n2, n3, f19, f5, f7);
                        c_d.a(n2 + 1, n3, f19, f4, f7);
                        c_d.a(n2 + 1, (float)n3 - 0.2f, f18, f4, f6);
                        f4 = (float)n / 512.0f;
                        f5 = ((float)n + 15.99f) / 512.0f;
                        f6 = (float)n36 / 512.0f;
                        f7 = ((float)n36 + 15.99f) / 512.0f;
                        c_d.a(n2 + 1, (float)n3 - 0.2f, f19, f5, f6);
                        c_d.a(n2 + 1, n3, f18, f5, f7);
                        c_d.a(n2, n3, f18, f4, f7);
                        c_d.a(n2, (float)n3 - 0.2f, f19, f4, f6);
                    }
                }
            }
            return true;
        }
        if (n4 == 5) {
            int n37 = n;
            int n38 = n2;
            n4 = n3;
            n3 = n38;
            n2 = n37;
            C_d c_d = C_d.a;
            int n39 = 110;
            if (this.b >= 0) {
                n39 = this.b;
            }
            if (this.a.e(n2, n3, n4) == 0 && (this.a.a((float)(n2 + 1), (float)n3, (float)n4) || this.a.a((float)(n2 - 1), (float)n3, (float)n4))) {
                n39 += 2;
            }
            float f = c_x.f(this.a, n2, n3, n4);
            c_d.a(f, f, f);
            n = ((n39 & 0x1F) << 4) + 16;
            int n40 = (n39 & 0x1F) << 4;
            int n41 = n39 >> 1 & 0x1F0;
            if ((n2 + n3 + n4 & 1) == 1) {
                n = (n39 & 0x1F) << 4;
                n40 = ((n39 & 0x1F) << 4) + 16;
            }
            if (this.a.e(n2, n3, n4) == 0) {
                n = (n39 & 0x1F) << 4;
                n40 = ((n39 & 0x1F) << 4) + 32;
            }
            float f20 = (float)n / 512.0f;
            float f21 = ((float)n + 15.99f) / 512.0f;
            float f22 = (float)n41 / 512.0f;
            float f23 = ((float)n41 + 15.99f) / 512.0f;
            float f24 = (float)n40 / 512.0f;
            float f25 = ((float)n40 + 15.99f) / 512.0f;
            float f26 = (float)n41 / 512.0f;
            float f27 = ((float)n41 + 15.99f) / 512.0f;
            if (this.a.b(n2 - 1, n3, n4)) {
                c_d.a((float)n2 + 0.05f, (float)(n3 + 1) + 0.125f, (float)(n4 + 1) + 0.125f, f20, f22);
                c_d.a((float)n2 + 0.05f, (float)n3 - 0.125f, (float)(n4 + 1) + 0.125f, f20, f23);
                c_d.a((float)n2 + 0.05f, (float)n3 - 0.125f, (float)n4 - 0.125f, f21, f23);
                c_d.a((float)n2 + 0.05f, (float)(n3 + 1) + 0.125f, (float)n4 - 0.125f, f21, f22);
            }
            if (this.a.b(n2 + 1, n3, n4)) {
                c_d.a((float)(n2 + 1) - 0.05f, (float)n3 - 0.125f, (float)(n4 + 1) + 0.125f, f21, f23);
                c_d.a((float)(n2 + 1) - 0.05f, (float)(n3 + 1) + 0.125f, (float)(n4 + 1) + 0.125f, f21, f22);
                c_d.a((float)(n2 + 1) - 0.05f, (float)(n3 + 1) + 0.125f, (float)n4 - 0.125f, f20, f22);
                c_d.a((float)(n2 + 1) - 0.05f, (float)n3 - 0.125f, (float)n4 - 0.125f, f20, f23);
            }
            if (this.a.b(n2, n3, n4 - 1)) {
                c_d.a((float)(n2 + 1) + 0.125f, (float)n3 - 0.125f, (float)n4 + 0.05f, f25, f27);
                c_d.a((float)(n2 + 1) + 0.125f, (float)(n3 + 1) + 0.125f, (float)n4 + 0.05f, f25, f26);
                c_d.a((float)n2 - 0.125f, (float)(n3 + 1) + 0.125f, (float)n4 + 0.05f, f24, f26);
                c_d.a((float)n2 - 0.125f, (float)n3 - 0.125f, (float)n4 + 0.05f, f24, f27);
            }
            if (this.a.b(n2, n3, n4 + 1)) {
                c_d.a((float)(n2 + 1) + 0.125f, (float)(n3 + 1) + 0.125f, (float)(n4 + 1) - 0.05f, f24, f26);
                c_d.a((float)(n2 + 1) + 0.125f, (float)n3 - 0.125f, (float)(n4 + 1) - 0.05f, f24, f27);
                c_d.a((float)n2 - 0.125f, (float)n3 - 0.125f, (float)(n4 + 1) - 0.05f, f25, f27);
                c_d.a((float)n2 - 0.125f, (float)(n3 + 1) + 0.125f, (float)(n4 + 1) - 0.05f, f25, f26);
            }
            float f28 = 0.125f;
            float f29 = 0.05f;
            if (this.a.b(n2, n3 + 1, n4)) {
                c_d.a((float)(n2 + 0) - f28, (float)(n3 + 1) - f29, (float)(n4 + 0) - f28, f24, f26);
                c_d.a((float)(n2 + 1) + f28, (float)(n3 + 1) - f29, (float)(n4 + 0) - f28, f25, f26);
                c_d.a((float)(n2 + 1) + f28, (float)(n3 + 1) - f29, (float)(n4 + 1) + f28, f25, f27);
                c_d.a((float)(n2 + 0) - f28, (float)(n3 + 1) - f29, (float)(n4 + 1) + f28, f24, f27);
            }
            if (this.a.b(n2, n3 - 1, n4)) {
                c_d.a((float)(n2 + 0) - f28, (float)n3 + f29, (float)(n4 + 1) + f28, f24, f27);
                c_d.a((float)(n2 + 1) + f28, (float)n3 + f29, (float)(n4 + 1) + f28, f25, f27);
                c_d.a((float)(n2 + 1) + f28, (float)n3 + f29, (float)(n4 + 0) - f28, f25, f26);
                c_d.a((float)(n2 + 0) - f28, (float)n3 + f29, (float)(n4 + 0) - f28, f24, f26);
            }
            return true;
        }
        if (n4 == 7) {
            return this.renderBlockDoor(c_x, n, n2, n3);
        }
        if (n4 == 8) {
            return this.renderBlockLadder(c_x, n, n2, n3);
        }
        if (n4 == 10) {
            this.renderBlockCake(c_x, n, n2, n3);
            return true;
        }
        if (n4 == 11) {
            return this.renderBlockFence(c_x, n, n2, n3);
        }
        if (n4 == 12) {
            return this.renderBlockStairs(c_x, n, n2, n3);
        }
        if (n4 == 13) {
            return this.renderBlockBed(c_x, n, n2, n3);
        }
        if (n4 == 14) {
            return this.renderBlockChair(c_x, n, n2, n3);
        }
        if (n4 == 15) {
            return this.renderBlockTable((BlockTable)c_x, n, n2, n3);
        }
        if (n4 == 16) {
            return this.renderBlockFenceGate(c_x, n, n2, n3);
        }
        if (n4 == 17) {
            return this.renderStandardBlock(c_x, n, n2, n3);
        }
        if (n4 == 18) {
            return this.renderPaneBlock((BlockPane)c_x, n, n2, n3);
        }
        if (n4 == 21) {
            return this.renderBlockVine(c_x, n, n2, n3);
        }
        if (n4 == 22) {
            return this.renderBlockSlime(c_x, n, n2, n3);
        }
        if (n4 == 23) {
            return this.renderBlockWall((BlockWall)c_x, n, n2, n3);
        }
        if (n4 == 24) {
            return this.renderBlockLog(c_x, n, n2, n3);
        }
        if (n4 == 25) {
            return this.renderRails(c_x, n, n2, n3);
        }
        if (n4 == 26) {
            return this.renderBlockLilyPad(c_x, n, n2, n3);
        }
        if (n4 == 27) {
            return this.renderPistonBase(c_x, n, n2, n3, false);
        }
        if (n4 == 28) {
            return this.renderPistonExtension(c_x, n, n2, n3, true);
        }
        if (n4 == 29) {
            int n42 = n;
            int n43 = n2;
            n4 = n3;
            n3 = n43;
            n2 = n42;
            C_d c_d = C_d.a;
            float f = c_x.f(this.a, n2, n3, n4);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f, f, f);
            this.renderBlockRod(c_x, n2, n3, n4);
            return true;
        }
        if (n4 == 33) {
            return this.renderBlockBarrel(c_x, n, n2, n3);
        }
        if (n4 == 34) {
            return this.renderBlockDetector(c_x, n, n2, n3);
        }
        if (n4 == 36) {
            return this.renderBlockCauldron(c_x, n, n2, n3);
        }
        return false;
    }

    private boolean renderBlockChest(C_x c_x, int n, int n2, int n3) {
        return true;
    }

    private boolean renderBlockCauldron(C_x c_x, int n, int n2, int n3) {
        this.renderStandardBlock(c_x, n, n2, n3);
        C_d c_d = C_d.a;
        float f = c_x.f(this.a, n, n2 + 1, n3);
        if (C_x.h[c_x.at] > 0) {
            f = 1.0f;
        }
        c_d.a(f, f, f);
        int n4 = c_x.as;
        float f2 = 0.125f;
        c_d.a(f * 0.8f, f * 0.8f, f * 0.8f);
        this.renderSouthFace(c_x, (float)n - 1.0f + f2, n2, n3, n4);
        c_d.a(f * 0.8f, f * 0.8f, f * 0.8f);
        this.renderNorthFace(c_x, (float)n + 1.0f - f2, n2, n3, n4);
        c_d.a(f * 0.6f, f * 0.6f, f * 0.6f);
        this.renderWestFace(c_x, n, n2, (float)n3 - 1.0f + f2, n4);
        c_d.a(f * 0.6f, f * 0.6f, f * 0.6f);
        this.renderEastFace(c_x, n, n2, (float)n3 + 1.0f - f2, n4);
        int n5 = c_x.as + 1;
        c_d.a(f * 1.0f, f * 1.0f, f * 1.0f);
        this.renderTopFace(c_x, n, (float)n2 - 1.0f + 0.25f, n3, n5);
        this.renderBottomFace(c_x, n, (float)n2 + 1.0f - 0.75f, n3, n5);
        int n6 = this.a.e(n, n2, n3);
        if (n6 > 0) {
            int n7 = c_x.as + 3;
            if (n6 > 3) {
                n6 = 3;
            }
            c_d.a(f, f, f);
            this.renderTopFace(c_x, n, (float)n2 - 1.0f + (6.0f + (float)n6 * 3.0f) / 16.0f, n3, n7);
        }
        return true;
    }

    private void renderBlockCake(C_x c_x, int n, int n2, int n3) {
        int n4 = n;
        int n5 = n2;
        int n6 = n3;
        n3 = n5;
        n2 = n4;
        float f = c_x.f(this.a, n2, n3 - 1, n6);
        float f2 = c_x.f(this.a, n2, n3, n6);
        if (C_x.h[c_x.at] > 0) {
            f2 = 1.0f;
        }
        C_d c_d = C_d.a;
        c_d.a(0.5f * f, 0.5f * f, 0.5f * f);
        this.renderBottomFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 0));
        c_d.a(f2 * 1.0f, f2 * 1.0f, f2 * 1.0f);
        this.renderTopFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 1));
        c_d.a(0.8f * f2, 0.8f * f2, 0.8f * f2);
        this.renderEastFaceNew(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 2));
        c_d.a(0.8f * f2, 0.8f * f2, 0.8f * f2);
        this.renderWestFaceNew(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 3));
        c_d.a(0.6f * f2, 0.6f * f2, 0.6f * f2);
        this.renderNorthFaceNew(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 4));
        c_d.a(0.6f * f2, 0.6f * f2, 0.6f * f2);
        this.renderSouthFaceNew(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 5));
    }

    private void a(C_x c_x, float f, float f2, float f3, float f4, float f5) {
        C_d c_d = C_d.a;
        int n = c_x.a(0);
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        n = n >> 1 & 0x1F0;
        float f6 = (float)n2 / 512.0f;
        float f7 = ((float)n2 + 15.99f) / 512.0f;
        float f8 = (float)n / 512.0f;
        float f9 = ((float)n + 15.99f) / 512.0f;
        float f10 = f6 + 0.013671875f;
        float f11 = f8 + 0.01171875f;
        float f12 = f6 + 0.017578125f;
        float f13 = f8 + 0.015625f;
        float f14 = (f += 0.5f) - 0.5f;
        float f15 = f + 0.5f;
        float f16 = (f3 += 0.5f) - 0.5f;
        float f17 = f3 + 0.5f;
        c_d.a(f + f4 * 0.375f - 0.0625f, f2 + 0.625f, f3 + f5 * 0.375f - 0.0625f, f10, f11);
        c_d.a(f + f4 * 0.375f - 0.0625f, f2 + 0.625f, f3 + f5 * 0.375f + 0.0625f, f10, f13);
        c_d.a(f + f4 * 0.375f + 0.0625f, f2 + 0.625f, f3 + f5 * 0.375f + 0.0625f, f12, f13);
        c_d.a(f + f4 * 0.375f + 0.0625f, f2 + 0.625f, f3 + f5 * 0.375f - 0.0625f, f12, f11);
        c_d.a(f - 0.0625f, f2 + 1.0f, f16, f6, f8);
        c_d.a(f - 0.0625f + f4, f2, f16 + f5, f6, f9);
        c_d.a(f - 0.0625f + f4, f2, f17 + f5, f7, f9);
        c_d.a(f - 0.0625f, f2 + 1.0f, f17, f7, f8);
        c_d.a(f + 0.0625f, f2 + 1.0f, f17, f6, f8);
        c_d.a(f + f4 + 0.0625f, f2, f17 + f5, f6, f9);
        c_d.a(f + f4 + 0.0625f, f2, f16 + f5, f7, f9);
        c_d.a(f + 0.0625f, f2 + 1.0f, f16, f7, f8);
        c_d.a(f14, f2 + 1.0f, f3 + 0.0625f, f6, f8);
        c_d.a(f14 + f4, f2, f3 + 0.0625f + f5, f6, f9);
        c_d.a(f15 + f4, f2, f3 + 0.0625f + f5, f7, f9);
        c_d.a(f15, f2 + 1.0f, f3 + 0.0625f, f7, f8);
        c_d.a(f15, f2 + 1.0f, f3 - 0.0625f, f6, f8);
        c_d.a(f15 + f4, f2, f3 - 0.0625f + f5, f6, f9);
        c_d.a(f14 + f4, f2, f3 - 0.0625f + f5, f7, f9);
        c_d.a(f14, f2 + 1.0f, f3 - 0.0625f, f7, f8);
    }

    private boolean renderBlockSlime(C_x c_x, int n, int n2, int n3) {
        if (this.activeRenderPass == 0) {
            c_x.a(0.125f, 0.125f, 0.125f, 0.875f, 0.875f, 0.875f);
            boolean bl = this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            return bl;
        }
        c_x.a(-0.011f, -0.011f, -0.011f, 1.011f, 1.011f, 1.011f);
        boolean bl = this.renderStandardBlock(c_x, n, n2, n3);
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return bl;
    }

    private boolean renderBlockDetector(C_x c_x, int n, int n2, int n3) {
        if (this.a.e(n, n2, n3) == 4) {
            this.setOverrideBlockTexture(644);
        } else {
            this.setOverrideBlockTexture(643);
        }
        c_x.a(0.2f, 0.2f, 0.2f, 0.8f, 0.8f, 0.8f);
        this.renderStandardBlockNew(c_x, n, n2, n3);
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setOverrideBlockTexture(-1);
        this.renderStandardBlock(c_x, n, n2, n3);
        return true;
    }

    private void renderBlockLantern(C_x c_x, int n, int n2, int n3, double d2) {
        if (this.b >= 0) {
            c_x.as = this.b;
        }
        C_d c_d = C_d.a;
        c_x.a(0.3125f, 0.0f, 0.375f, 0.6875f, 0.4375f, 0.75f);
        c_d.addTranslation(0.0f, 0.0f, -0.0625f);
        this.renderTopFace(c_x, n, d2, n3, 266);
        this.renderBottomFace(c_x, n, d2, n3, 266);
        c_d.addTranslation(0.0f, 0.0f, 0.0625f);
        c_x.a(0.3125f, 0.0f, 0.3125f, 0.6875f, 0.4375f, 0.6875f);
        c_d.a(1.0f, 1.0f, 1.0f);
        this.renderEastFace(c_x, n, d2, n3, 266);
        this.renderWestFace(c_x, n, d2, n3, 266);
        this.renderNorthFace(c_x, n, d2, n3, 266);
        this.renderSouthFace(c_x, n, d2, n3, 266);
        c_x.a(0.375f, 0.625f, 0.375f, 0.625f, 0.6875f, 0.625f);
        c_x.as = 266;
        this.renderStandardBlock(c_x, n, n2, n3, n, d2 - 0.1875, n3);
        c_x.a(0.0625f, 0.0f, 0.0625f, 0.1875f, 0.125f, 0.1875f);
        this.renderStandardBlock(c_x, n, n2, n3, (float)n + 0.375f, d2 + 0.5, (float)n3 + 0.375f);
        float f = c_x.f(this.a, n, n2, n3);
        c_d.a(1.0f * f, 1.0f * f, 1.0f * f);
        this.renderTopFace(c_x, (float)n + 0.375f, d2 + 0.5, (float)n3 + 0.375f, 266);
        c_x.setBlockBoundsBasedOnState(this.a, n, n2, n3);
    }

    private boolean renderBlockFlowerpot(BlockFlowerPot blockFlowerPot, int n, int n2, int n3) {
        this.renderStandardBlock(blockFlowerPot, n, n2, n3);
        C_d c_d = C_d.a;
        float f = blockFlowerPot.f(this.a, n, n2, n3);
        int n4 = 0xFFFFFF;
        int n5 = blockFlowerPot.a(0);
        float f2 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n4 & 0xFF) / 255.0f;
        c_d.a(f * f2, f * f3, f * f4);
        float f5 = 0.1865f;
        this.renderSouthFace(blockFlowerPot, (float)n - 0.5f + f5, n2, n3, n5);
        this.renderNorthFace(blockFlowerPot, (float)n + 0.5f - f5, n2, n3, n5);
        this.renderWestFace(blockFlowerPot, n, n2, (float)n3 - 0.5f + f5, n5);
        this.renderEastFace(blockFlowerPot, n, n2, (float)n3 + 0.5f - f5, n5);
        this.renderTopFace(blockFlowerPot, n, (float)n2 - 0.5f + f5 + 0.1875f, n3, C_x.k.as);
        byte by = this.a.e(n, n2, n3);
        if (by != 0) {
            BlockFlower blockFlower = null;
            switch (by) {
                case 1: {
                    blockFlower = C_x.plantRed;
                    break;
                }
                case 2: {
                    blockFlower = C_x.plantYellow;
                    break;
                }
                case 5: {
                    blockFlower = C_x.plantBlue;
                    break;
                }
                case 6: {
                    blockFlower = C_x.plantPurple;
                    break;
                }
                case 7: {
                    blockFlower = C_x.mushroomRed;
                    break;
                }
                case 8: {
                    blockFlower = C_x.mushroomBrown;
                    break;
                }
                case 15: {
                    blockFlower = C_x.mushroomGlowing;
                    break;
                }
            }
            c_d.addTranslation(0.0f, 0.25f, 0.0f);
            if (blockFlower != null) {
                this.b(blockFlower, n, n2, n3);
            } else if (by == 3) {
                this.drawCrossedSquares(C_x.n, 0, n, n2, n3, 0.75f);
            } else if (by == 4) {
                this.drawCrossedSquares(C_x.n, 1, n, n2, n3, 0.75f);
            } else if (by == 9) {
                this.drawCrossedSquares(C_x.berryBush, 0, n, n2, n3, 0.75f);
            } else if (by == 10) {
                this.drawCrossedSquares(C_x.berryBush, 1, n, n2, n3, 0.75f);
            } else if (by == 11) {
                this.drawCrossedSquares(C_x.n, 2, n, n2, n3, 0.75f);
            } else if (by == 12) {
                this.drawCrossedSquares(C_x.n, 3, n, n2, n3, 0.75f);
            } else if (by == 13) {
                this.drawCrossedSquares(C_x.n, 4, n, n2, n3, 0.75f);
            } else if (by == 14) {
                float f6 = 0.125f;
                C_x.cactus.a(0.5f - f6, 0.0f, 0.5f - f6, 0.5f + f6, 0.25f, 0.5f + f6);
                this.renderStandardBlock(C_x.cactus, n, n2, n3);
                C_x.cactus.a(0.5f - f6, 0.25f, 0.5f - f6, 0.5f + f6, 0.5f, 0.5f + f6);
                this.renderStandardBlock(C_x.cactus, n, n2, n3);
                C_x.cactus.a(0.5f - f6, 0.5f, 0.5f - f6, 0.5f + f6, 0.75f, 0.5f + f6);
                this.renderStandardBlock(C_x.cactus, n, n2, n3);
                C_x.cactus.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
            c_d.addTranslation(-0.0f, -0.25f, -0.0f);
        }
        return true;
    }

    public void drawCrossedSquares(C_x c_x, int n, float f, float f2, float f3, float f4) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = 480;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        float f5 = (float)n3 / 512.0f;
        float f6 = ((float)n3 + 15.99f) / 512.0f;
        float f7 = (float)n4 / 512.0f;
        float f8 = ((float)n4 + 15.99f) / 512.0f;
        float f9 = 0.45f * f4;
        float f10 = f + 0.5f - f9;
        float f11 = f + 0.5f + f9;
        float f12 = f3 + 0.5f - f9;
        float f13 = f3 + 0.5f + f9;
        c_d.a(f10, f2 + f4, f12, f5, f7);
        c_d.a(f10, f2 + 0.0f, f12, f5, f8);
        c_d.a(f11, f2 + 0.0f, f13, f6, f8);
        c_d.a(f11, f2 + f4, f13, f6, f7);
        c_d.a(f11, f2 + f4, f13, f5, f7);
        c_d.a(f11, f2 + 0.0f, f13, f5, f8);
        c_d.a(f10, f2 + 0.0f, f12, f6, f8);
        c_d.a(f10, f2 + f4, f12, f6, f7);
        c_d.a(f10, f2 + f4, f13, f5, f7);
        c_d.a(f10, f2 + 0.0f, f13, f5, f8);
        c_d.a(f11, f2 + 0.0f, f12, f6, f8);
        c_d.a(f11, f2 + f4, f12, f6, f7);
        c_d.a(f11, f2 + f4, f12, f5, f7);
        c_d.a(f11, f2 + 0.0f, f12, f5, f8);
        c_d.a(f10, f2 + 0.0f, f13, f6, f8);
        c_d.a(f10, f2 + f4, f13, f6, f7);
    }

    private boolean renderBlockFluids(C_x c_x, int n, int n2, int n3) {
        float f;
        int n4 = n3;
        int n5 = n2;
        int n6 = n;
        C_x c_x2 = c_x;
        C_d c_d = C_d.a;
        boolean bl = false;
        C_c c_c = c_x2.getMaterial(0);
        c_x2.av = 0.0f;
        c_x2.ay = 1.0f - this.getFluidHeight(n6, n5, n4, c_c);
        if (this.flipTexture || this.c || c_x.d(this.a, n6, n5 - 1, n4, 0)) {
            f = c_x.f(this.a, n6, n5 - 1, n4);
            c_d.a(0.5f * f, 0.5f * f, 0.5f * f);
            this.renderBottomFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 0));
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n6, n5 + 1, n4, 1)) {
            f = c_x.f(this.a, n6, n5 + 1, n4);
            c_d.a(f * 1.0f, f * 1.0f, f * 1.0f);
            this.renderTopFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 1));
            bl = true;
        }
        c_x2.av = 1.0f - this.getFluidHeight(n6, n5, n4 - 1, c_c);
        if (this.flipTexture || c_x2.ay > c_x2.av && this.a.a(n6, n5, n4 - 1) != C_x.coralFan.at || this.c || c_x.d(this.a, n6, n5, n4 - 1, 2)) {
            f = c_x.f(this.a, n6, n5, n4 - 1);
            c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
            this.renderEastFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 2));
            bl = true;
        }
        c_x2.av = 1.0f - this.getFluidHeight(n6, n5, n4 + 1, c_c);
        if (this.flipTexture || c_x2.ay > c_x2.av && this.a.a(n6, n5, n4 + 1) != C_x.coralFan.at || this.c || c_x.d(this.a, n6, n5, n4 + 1, 3)) {
            f = c_x.f(this.a, n6, n5, n4 + 1);
            c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
            this.renderWestFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 3));
            bl = true;
        }
        c_x2.av = 1.0f - this.getFluidHeight(n6 - 1, n5, n4, c_c);
        if (this.flipTexture || c_x2.ay > c_x2.av && this.a.a(n6 - 1, n5, n4) != C_x.coralFan.at || this.c || c_x.d(this.a, n6 - 1, n5, n4, 4)) {
            f = c_x.f(this.a, n6 - 1, n5, n4);
            c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
            this.renderNorthFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 4));
            bl = true;
        }
        c_x2.av = 1.0f - this.getFluidHeight(n6 + 1, n5, n4, c_c);
        if (this.flipTexture || c_x2.ay > c_x2.av && this.a.a(n6 + 1, n5, n4) != C_x.coralFan.at || this.c || c_x.d(this.a, n6 + 1, n5, n4, 5)) {
            f = c_x.f(this.a, n6 + 1, n5, n4);
            c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
            this.renderSouthFace(c_x2, n6, n5, n4, c_x2.a(this.a, n6, n5, n4, 5));
            bl = true;
        }
        c_x2.av = 0.0f;
        c_x2.ay = 1.0f;
        return bl;
    }

    private float getFluidHeight(int n, int n2, int n3, C_c c_c) {
        if (this.a.b(n, n2, n3)) {
            return 0.0f;
        }
        if (this.a.f(n, n2, n3).a()) {
            return 1.0f;
        }
        if (this.a.f(n, n2, n3) != c_c) {
            return 1.0f;
        }
        byte by = this.a.e(n, n2, n3);
        if (this.a.f(n, n2 + 1, n3) == c_c && (by == 0 || by >= 8)) {
            return 0.0f;
        }
        return C_p.getFluidHeightPercent(by);
    }

    public static void setLightValue(C_d c_d, C_g c_g, C_x c_x, float f, float f2, float f3, float f4) {
        float f5 = c_g == null ? f4 : c_x.f(c_g, (int)f, (int)f2, (int)f3) * f4;
        if (C_x.h[c_x.at] > 0) {
            f5 = f4;
        }
        c_d.a(f5, f5, f5);
    }

    private void renderBlockRope(C_x c_x, int n, int n2, int n3) {
        float f = c_x.f(this.a, n, n2, n3);
        float f2 = c_x.f(this.a, n, n2 + 1, n3);
        float f3 = c_x.f(this.a, n, n2 - 1, n3);
        if (C_x.h[c_x.at] > 0) {
            f = 1.0f;
        }
        C_d c_d = C_d.a;
        c_d.a(0.5f * f3, 0.5f * f3, 0.5f * f3);
        this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
        c_d.a(f2 * 1.0f, f2 * 1.0f, f2 * 1.0f);
        this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
    }

    private void renderBlockRod(C_x c_x, int n, int n2, int n3) {
        float f = c_x.f(this.a, n, n2, n3);
        float f2 = c_x.f(this.a, n, n2 + 1, n3);
        float f3 = c_x.f(this.a, n, n2 - 1, n3);
        if (C_x.h[c_x.at] > 0) {
            f = 1.0f;
        }
        C_d c_d = C_d.a;
        c_d.a(0.5f * f3, 0.5f * f3, 0.5f * f3);
        this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
        c_d.a(f2 * 1.0f, f2 * 1.0f, f2 * 1.0f);
        this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
        if (this.b == -1) {
            this.b = 38;
        }
        c_x.a(0.325f, 0.0f, 0.325f, 0.675f, 0.1f, 0.675f);
        c_d.a(0.5f * f3, 0.5f * f3, 0.5f * f3);
        this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
        c_d.a(f2 * 1.0f, f2 * 1.0f, f2 * 1.0f);
        this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
        c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
        this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
        c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
        this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
        c_x.a(0.41666666f, 0.0f, 0.41666666f, 0.5833333f, 1.0f, 0.5833333f);
        this.b = -1;
    }

    private void a(C_x c_x, int n, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = c_x instanceof C_ar || c_x instanceof C_bn ? this.b : 480;
        }
        int n3 = (n2 & 0x1F) << 4;
        n2 = n2 >> 1 & 0x1F0;
        float f4 = (float)n3 / 512.0f;
        float f5 = ((float)n3 + 15.99f) / 512.0f;
        float f6 = (float)n2 / 512.0f;
        float f7 = ((float)n2 + 15.99f) / 512.0f;
        float f8 = f + 0.5f - 0.45f;
        f = f + 0.5f + 0.45f;
        float f9 = f3 + 0.5f - 0.45f;
        f3 = f3 + 0.5f + 0.45f;
        float f10 = f2 + 1.0f;
        float f11 = f2;
        if (c_x instanceof C_bn && (n == 3 || n == 4)) {
            f11 = f2 + 1.0f;
            f10 = f2;
        }
        c_d.a(f8, f10, f9, f4, f6);
        c_d.a(f8, f11, f9, f4, f7);
        c_d.a(f, f11, f3, f5, f7);
        c_d.a(f, f10, f3, f5, f6);
        c_d.a(f, f10, f3, f4, f6);
        c_d.a(f, f11, f3, f4, f7);
        c_d.a(f8, f11, f9, f5, f7);
        c_d.a(f8, f10, f9, f5, f6);
        c_d.a(f8, f10, f3, f4, f6);
        c_d.a(f8, f11, f3, f4, f7);
        c_d.a(f, f11, f9, f5, f7);
        c_d.a(f, f10, f9, f5, f6);
        c_d.a(f, f10, f9, f4, f6);
        c_d.a(f, f11, f9, f4, f7);
        c_d.a(f8, f11, f3, f5, f7);
        c_d.a(f8, f10, f3, f5, f6);
    }

    private void renderBlockLeaves(C_x c_x, int n, int n2, int n3) {
        float f;
        int n4 = n;
        int n5 = n2;
        int n6 = n3;
        n3 = n5;
        n2 = n4;
        C_d c_d = C_d.a;
        if (this.flipTexture || this.c || c_x.d(this.a, n2, n3 - 1, n6, 0)) {
            f = c_x.f(this.a, n2, n3 - 1, n6);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(0.5f * f, 0.5f * f, 0.5f * f);
            this.renderBottomFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 0));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderBottomFace(c_x, n2, n3, n6, 260);
            }
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n2, n3 + 1, n6, 1)) {
            f = c_x.f(this.a, n2, n3 + 1, n6);
            if (c_x instanceof C_aj && !((C_aj)c_x).a) {
                f = c_x.f(this.a, n2, n3, n6);
            }
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(f * 1.0f, f * 1.0f, f * 1.0f);
            this.renderTopFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 1));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderTopFace(c_x, n2, n3, n6, 260);
            }
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n2, n3, n6 - 1, 2)) {
            f = c_x.f(this.a, n2, n3, n6 - 1);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
            this.renderEastFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 2));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderEastFace(c_x, n2, n3, n6, 260);
            }
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n2, n3, n6 + 1, 3)) {
            f = c_x.f(this.a, n2, n3, n6 + 1);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(0.8f * f, 0.8f * f, 0.8f * f);
            this.renderWestFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 3));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderWestFace(c_x, n2, n3, n6, 260);
            }
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n2 - 1, n3, n6, 4)) {
            f = c_x.f(this.a, n2 - 1, n3, n6);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
            this.renderNorthFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 4));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderNorthFace(c_x, n2, n3, n6, 260);
            }
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n2 + 1, n3, n6, 5)) {
            f = c_x.f(this.a, n2 + 1, n3, n6);
            if (C_x.h[c_x.at] > 0) {
                f = 1.0f;
            }
            c_d.a(0.6f * f, 0.6f * f, 0.6f * f);
            this.renderSouthFace(c_x, n2, n3, n6, c_x.a(this.a, n2, n3, n6, 5));
            if (this.a.e(n2, n3, n6) == 1) {
                this.renderSouthFace(c_x, n2, n3, n6, 260);
            }
        }
    }

    private void b(C_x c_x, int n, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = this.b;
        }
        n = (n2 & 0x1F) << 4;
        n2 = n2 >> 1 & 0x1F0;
        float f4 = (float)n / 512.0f;
        float f5 = ((float)n + 15.99f) / 512.0f;
        float f6 = (float)n2 / 512.0f;
        float f7 = ((float)n2 + 15.99f) / 512.0f;
        float f8 = f + 0.5f - 0.25f;
        float f9 = f + 0.5f + 0.25f;
        float f10 = f3 + 0.5f - 0.5f;
        float f11 = f3 + 0.5f + 0.5f;
        c_d.a(f8, f2 + 1.0f, f10, f4, f6);
        c_d.a(f8, f2, f10, f4, f7);
        c_d.a(f8, f2, f11, f5, f7);
        c_d.a(f8, f2 + 1.0f, f11, f5, f6);
        c_d.a(f8, f2 + 1.0f, f11, f4, f6);
        c_d.a(f8, f2, f11, f4, f7);
        c_d.a(f8, f2, f10, f5, f7);
        c_d.a(f8, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f11, f4, f6);
        c_d.a(f9, f2, f11, f4, f7);
        c_d.a(f9, f2, f10, f5, f7);
        c_d.a(f9, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f10, f4, f6);
        c_d.a(f9, f2, f10, f4, f7);
        c_d.a(f9, f2, f11, f5, f7);
        c_d.a(f9, f2 + 1.0f, f11, f5, f6);
        f8 = f + 0.5f - 0.5f;
        f9 = f + 0.5f + 0.5f;
        f10 = f3 + 0.5f - 0.25f;
        f11 = f3 + 0.5f + 0.25f;
        c_d.a(f8, f2 + 1.0f, f10, f4, f6);
        c_d.a(f8, f2, f10, f4, f7);
        c_d.a(f9, f2, f10, f5, f7);
        c_d.a(f9, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f10, f4, f6);
        c_d.a(f9, f2, f10, f4, f7);
        c_d.a(f8, f2, f10, f5, f7);
        c_d.a(f8, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f11, f4, f6);
        c_d.a(f9, f2, f11, f4, f7);
        c_d.a(f8, f2, f11, f5, f7);
        c_d.a(f8, f2 + 1.0f, f11, f5, f6);
        c_d.a(f8, f2 + 1.0f, f11, f4, f6);
        c_d.a(f8, f2, f11, f4, f7);
        c_d.a(f9, f2, f11, f5, f7);
        c_d.a(f9, f2 + 1.0f, f11, f5, f6);
    }

    public boolean renderBlockStem(C_x c_x, int n, int n2, int n3) {
        BlockStem blockStem = (BlockStem)c_x;
        blockStem.setBlockBoundsBasedOnState(this.a, n, n2, n3);
        int n4 = blockStem.getState(this.a, n, n2, n3);
        float f = (float)this.a.e(n, n2, n3) / 10.0f + 0.3f;
        if (n4 < 0) {
            this.renderBlockStemSmall(blockStem, this.a.e(n, n2, n3), f, n, (float)n2 - 0.0625f, n3);
        } else {
            this.renderBlockStemSmall(blockStem, this.a.e(n, n2, n3), 0.5f, n, (float)n2 - 0.0625f, n3);
            this.renderBlockStemBig(blockStem, this.a.e(n, n2, n3), n4, f, n, (float)n2 - 0.0625f, n3);
        }
        return true;
    }

    public void renderBlockStemSmall(C_x c_x, int n, float f, float f2, float f3, float f4) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = this.b;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        float f5 = (float)n3 / 512.0f;
        float f6 = ((float)n3 + 15.99f) / 512.0f;
        float f7 = (float)n4 / 512.0f;
        float f8 = ((float)n4 + 15.99f * f) / 512.0f;
        float f9 = f2 + 0.5f - 0.45f;
        float f10 = f2 + 0.5f + 0.45f;
        float f11 = f4 + 0.5f - 0.45f;
        float f12 = f4 + 0.5f + 0.45f;
        c_d.a(f9, f3 + f, f11, f5, f7);
        c_d.a(f9, f3 + 0.0f, f11, f5, f8);
        c_d.a(f10, f3 + 0.0f, f12, f6, f8);
        c_d.a(f10, f3 + f, f12, f6, f7);
        c_d.a(f10, f3 + f, f12, f5, f7);
        c_d.a(f10, f3 + 0.0f, f12, f5, f8);
        c_d.a(f9, f3 + 0.0f, f11, f6, f8);
        c_d.a(f9, f3 + f, f11, f6, f7);
        c_d.a(f9, f3 + f, f12, f5, f7);
        c_d.a(f9, f3 + 0.0f, f12, f5, f8);
        c_d.a(f10, f3 + 0.0f, f11, f6, f8);
        c_d.a(f10, f3 + f, f11, f6, f7);
        c_d.a(f10, f3 + f, f11, f5, f7);
        c_d.a(f10, f3 + 0.0f, f11, f5, f8);
        c_d.a(f9, f3 + 0.0f, f12, f6, f8);
        c_d.a(f9, f3 + f, f12, f6, f7);
    }

    public void renderBlockStemBig(C_x c_x, int n, int n2, float f, float f2, float f3, float f4) {
        C_d c_d = C_d.a;
        int n3 = c_x.a(0, n) + 1;
        if (this.b >= 0) {
            n3 = this.b;
        }
        int n4 = (n3 & 0x1F) << 4;
        int n5 = n3 >> 1 & 0x1F0;
        float f5 = (float)n4 / 512.0f;
        float f6 = ((float)n4 + 15.99f) / 512.0f;
        float f7 = (float)n5 / 512.0f;
        float f8 = ((float)n5 + 15.99f * f) / 512.0f;
        float f9 = f2 + 0.5f - 0.5f;
        float f10 = f2 + 0.5f + 0.5f;
        float f11 = f4 + 0.5f - 0.5f;
        float f12 = f4 + 0.5f + 0.5f;
        float f13 = f2 + 0.5f;
        float f14 = f4 + 0.5f;
        if ((n2 + 1) / 2 % 2 == 1) {
            float f15 = f6;
            f6 = f5;
            f5 = f15;
        }
        if (n2 < 2) {
            c_d.a(f9, f3 + f, f14, f5, f7);
            c_d.a(f9, f3 + 0.0f, f14, f5, f8);
            c_d.a(f10, f3 + 0.0f, f14, f6, f8);
            c_d.a(f10, f3 + f, f14, f6, f7);
            c_d.a(f10, f3 + f, f14, f6, f7);
            c_d.a(f10, f3 + 0.0f, f14, f6, f8);
            c_d.a(f9, f3 + 0.0f, f14, f5, f8);
            c_d.a(f9, f3 + f, f14, f5, f7);
        } else {
            c_d.a(f13, f3 + f, f12, f5, f7);
            c_d.a(f13, f3 + 0.0f, f12, f5, f8);
            c_d.a(f13, f3 + 0.0f, f11, f6, f8);
            c_d.a(f13, f3 + f, f11, f6, f7);
            c_d.a(f13, f3 + f, f11, f6, f7);
            c_d.a(f13, f3 + 0.0f, f11, f6, f8);
            c_d.a(f13, f3 + 0.0f, f12, f5, f8);
            c_d.a(f13, f3 + f, f12, f5, f7);
        }
    }

    private void renderBlockReeds(C_x c_x, int n, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = this.b;
        }
        n = (n2 & 0x1F) << 4;
        n2 = n2 >> 1 & 0x1F0;
        float f4 = (float)n / 512.0f;
        float f5 = ((float)n + 15.99f) / 512.0f;
        float f6 = (float)n2 / 512.0f;
        float f7 = ((float)n2 + 15.99f) / 512.0f;
        float f8 = f + 0.5f - 0.25f;
        float f9 = f + 0.5f + 0.25f;
        float f10 = f3 + 0.5f - 0.5f;
        float f11 = f3 + 0.5f + 0.5f;
        c_d.a(f8, f2 + 1.0f, f10, f4, f6);
        c_d.a(f8, f2, f10, f4, f7);
        c_d.a(f8, f2, f11, f5, f7);
        c_d.a(f8, f2 + 1.0f, f11, f5, f6);
        c_d.a(f8, f2 + 1.0f, f11, f4, f6);
        c_d.a(f8, f2, f11, f4, f7);
        c_d.a(f8, f2, f10, f5, f7);
        c_d.a(f8, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f11, f4, f6);
        c_d.a(f9, f2, f11, f4, f7);
        c_d.a(f9, f2, f10, f5, f7);
        c_d.a(f9, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f10, f4, f6);
        c_d.a(f9, f2, f10, f4, f7);
        c_d.a(f9, f2, f11, f5, f7);
        c_d.a(f9, f2 + 1.0f, f11, f5, f6);
        f8 = f + 0.5f - 0.5f;
        f9 = f + 0.5f + 0.5f;
        f10 = f3 + 0.5f - 0.25f;
        f11 = f3 + 0.5f + 0.25f;
        c_d.a(f8, f2 + 1.0f, f10, f4, f6);
        c_d.a(f8, f2, f10, f4, f7);
        c_d.a(f9, f2, f10, f5, f7);
        c_d.a(f9, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f10, f4, f6);
        c_d.a(f9, f2, f10, f4, f7);
        c_d.a(f8, f2, f10, f5, f7);
        c_d.a(f8, f2 + 1.0f, f10, f5, f6);
        c_d.a(f9, f2 + 1.0f, f11, f4, f6);
        c_d.a(f9, f2, f11, f4, f7);
        c_d.a(f8, f2, f11, f5, f7);
        c_d.a(f8, f2 + 1.0f, f11, f5, f6);
        c_d.a(f8, f2 + 1.0f, f11, f4, f6);
        c_d.a(f8, f2, f11, f4, f7);
        c_d.a(f9, f2, f11, f5, f7);
        c_d.a(f9, f2 + 1.0f, f11, f5, f6);
    }

    public boolean renderBlockCactus(C_x c_x, int n, int n2, int n3) {
        int n4 = 0xFFFFFF;
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
        float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
        float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
        f = f4;
        f2 = f5;
        f3 = f6;
        return this.renderShrunkenBlock(c_x, n, n2, n3, f, f2, f3);
    }

    public boolean renderShrunkenBlock(C_x c_x, int n, int n2, int n3, float f, float f2, float f3) {
        float f4;
        C_d c_d = C_d.a;
        boolean bl = false;
        float f5 = 0.5f;
        float f6 = 1.0f;
        float f7 = 0.8f;
        float f8 = 0.6f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f8 * f;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f8 * f2;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = f8 * f3;
        float f21 = 0.0625f;
        float f22 = c_x.f(this.a, n, n2 - 1, n3);
        float f23 = c_x.f(this.a, n, n2, n3);
        if (C_x.h[c_x.at] > 0) {
            f23 = 1.0f;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2 - 1, n3, 0)) {
            f4 = c_x.f(this.a, n, n2 - 1, n3);
            c_d.a(f9 * f4, f13 * f4, f17 * f4);
            c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
            this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2 + 1, n3, 1)) {
            f4 = c_x.f(this.a, n, n2 + 1, n3);
            if ((double)c_x.ay != 1.0 && !c_x.getMaterial(0).d()) {
                f4 = f22;
            }
            c_d.a(f10 * f23, f14 * f23, f18 * f23);
            c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
            this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2, n3 - 1, 2)) {
            f4 = c_x.f(this.a, n, n2, n3 - 1);
            if ((double)c_x.aw > 0.0) {
                f4 = f22;
            }
            c_d.a(f11 * f23, f15 * f23, f19 * f23);
            c_d.addTranslation(0.0f, 0.0f, f21);
            this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
            c_d.addTranslation(0.0f, 0.0f, -f21);
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2, n3 + 1, 3)) {
            f4 = c_x.f(this.a, n, n2, n3 + 1);
            if ((double)c_x.az < 1.0) {
                f4 = f22;
            }
            c_d.a(f11 * f23, f15 * f23, f19 * f23);
            c_d.addTranslation(0.0f, 0.0f, -f21);
            this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
            c_d.addTranslation(0.0f, 0.0f, f21);
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n - 1, n2, n3, 4)) {
            f4 = c_x.f(this.a, n - 1, n2, n3);
            if ((double)c_x.au > 0.0) {
                f4 = f22;
            }
            c_d.a(f12 * f23, f16 * f23, f20 * f23);
            c_d.addTranslation(f21, 0.0f, 0.0f);
            this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
            c_d.addTranslation(-f21, 0.0f, 0.0f);
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n + 1, n2, n3, 5)) {
            f4 = c_x.f(this.a, n + 1, n2, n3);
            if ((double)c_x.ax < 1.0) {
                f4 = f22;
            }
            c_d.a(f12 * f23, f16 * f23, f20 * f23);
            c_d.addTranslation(-f21, 0.0f, 0.0f);
            this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
            c_d.addTranslation(f21, 0.0f, 0.0f);
            bl = true;
        }
        return bl;
    }

    public boolean renderBlockStrippedLog(C_x c_x, int n, int n2, int n3) {
        int n4 = 0xFFFFFF;
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        float f4 = (f * 30.0f + f2 * 59.0f + f3 * 11.0f) / 100.0f;
        float f5 = (f * 30.0f + f2 * 70.0f) / 100.0f;
        float f6 = (f * 30.0f + f3 * 70.0f) / 100.0f;
        f = f4;
        f2 = f5;
        f3 = f6;
        byte by = this.a.e(n, n2, n3);
        int n5 = by & 0xC;
        if (n5 == 4) {
            this.uvRotateEast = 1;
            this.uvRotateWest = 1;
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
        } else if (n5 == 8) {
            this.uvRotateSouth = 1;
            this.uvRotateNorth = 1;
        }
        boolean bl = this.renderShrunkenBlockWithRotation(c_x, n, n2, n3, f, f2, f3);
        this.uvRotateSouth = 0;
        this.uvRotateEast = 0;
        this.uvRotateWest = 0;
        this.uvRotateNorth = 0;
        this.uvRotateTop = 0;
        this.uvRotateBottom = 0;
        return bl;
    }

    public boolean renderShrunkenBlockWithRotation(C_x c_x, int n, int n2, int n3, float f, float f2, float f3) {
        float f4;
        C_d c_d = C_d.a;
        boolean bl = false;
        float f5 = 0.5f;
        float f6 = 1.0f;
        float f7 = 0.8f;
        float f8 = 0.6f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f8 * f;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f8 * f2;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = f8 * f3;
        float f21 = 0.0625f;
        float f22 = c_x.f(this.a, n, n2 - 1, n3);
        float f23 = c_x.f(this.a, n, n2, n3);
        byte by = this.a.e(n, n2, n3);
        if (C_x.h[c_x.at] > 0) {
            f23 = 1.0f;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2 - 1, n3, 0)) {
            f4 = c_x.f(this.a, n, n2 - 1, n3);
            c_d.a(f9 * f4, f13 * f4, f17 * f4);
            if (by <= 3) {
                c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
                this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(0.0f, f21, 0.0f);
                this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
                c_d.addTranslation(0.0f, -f21, 0.0f);
            }
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2 + 1, n3, 1)) {
            f4 = c_x.f(this.a, n, n2 + 1, n3);
            if ((double)c_x.ay != 1.0 && !c_x.getMaterial(0).d()) {
                f4 = f22;
            }
            c_d.a(f10 * f23, f14 * f23, f18 * f23);
            if (by <= 3) {
                c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
                this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(0.0f, -f21, 0.0f);
                this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
                c_d.addTranslation(0.0f, f21, 0.0f);
            }
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2, n3 - 1, 2)) {
            f4 = c_x.f(this.a, n, n2, n3 - 1);
            if ((double)c_x.aw > 0.0) {
                f4 = f22;
            }
            c_d.a(f11 * f23, f15 * f23, f19 * f23);
            if (by > 7 && by <= 11) {
                c_x.a(0.0625f, 0.0625f, 0.0f, 0.9375f, 0.9375f, 1.0f);
                this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(0.0f, 0.0f, f21);
                this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
                c_d.addTranslation(0.0f, 0.0f, -f21);
            }
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n, n2, n3 + 1, 3)) {
            f4 = c_x.f(this.a, n, n2, n3 + 1);
            if ((double)c_x.az < 1.0) {
                f4 = f22;
            }
            c_d.a(f11 * f23, f15 * f23, f19 * f23);
            if (by > 7 && by <= 11) {
                c_x.a(0.0625f, 0.0625f, 0.0f, 0.9375f, 0.9375f, 1.0f);
                this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(0.0f, 0.0f, -f21);
                this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
                c_d.addTranslation(0.0f, 0.0f, f21);
            }
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n - 1, n2, n3, 4)) {
            f4 = c_x.f(this.a, n - 1, n2, n3);
            if ((double)c_x.au > 0.0) {
                f4 = f22;
            }
            c_d.a(f12 * f23, f16 * f23, f20 * f23);
            if (by > 3 && by <= 7) {
                c_x.a(0.0f, 0.0625f, 0.0625f, 1.0f, 0.9375f, 0.9375f);
                this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(f21, 0.0f, 0.0f);
                this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
                c_d.addTranslation(-f21, 0.0f, 0.0f);
            }
            bl = true;
        }
        if (this.flipTexture || this.c || c_x.d(this.a, n + 1, n2, n3, 5)) {
            f4 = c_x.f(this.a, n + 1, n2, n3);
            if ((double)c_x.ax < 1.0) {
                f4 = f22;
            }
            c_d.a(f12 * f23, f16 * f23, f20 * f23);
            if (by > 3 && by <= 7) {
                c_x.a(0.0f, 0.0625f, 0.0625f, 1.0f, 0.9375f, 0.9375f);
                this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            } else {
                c_d.addTranslation(-f21, 0.0f, 0.0f);
                this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
                c_d.addTranslation(f21, 0.0f, 0.0f);
            }
            bl = true;
        }
        return bl;
    }

    public boolean renderBlockLog(C_x c_x, int n, int n2, int n3) {
        byte by = this.a.e(n, n2, n3);
        int n4 = by & 0xC;
        if (n4 == 4) {
            this.uvRotateEast = 1;
            this.uvRotateWest = 1;
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
        } else if (n4 == 8) {
            this.uvRotateSouth = 1;
            this.uvRotateNorth = 1;
        }
        boolean bl = this.renderStandardBlock(c_x, n, n2, n3);
        this.uvRotateSouth = 0;
        this.uvRotateEast = 0;
        this.uvRotateWest = 0;
        this.uvRotateNorth = 0;
        this.uvRotateTop = 0;
        this.uvRotateBottom = 0;
        return bl;
    }

    public boolean renderBlockBarrel(C_x c_x, int n, int n2, int n3) {
        byte by = this.a.e(n, n2, n3);
        if (by == 4) {
            this.uvRotateEast = 1;
            this.uvRotateWest = 1;
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
        } else if (by == 8) {
            this.uvRotateSouth = 1;
            this.uvRotateNorth = 1;
        } else if (by == 6) {
            this.uvRotateSouth = 2;
            this.uvRotateNorth = 2;
            this.uvRotateTop = -1;
            this.uvRotateBottom = -1;
        } else if (by == 2) {
            this.uvRotateEast = 2;
            this.uvRotateWest = 2;
            this.uvRotateTop = 2;
            this.uvRotateBottom = 2;
        }
        boolean bl = this.renderStandardBlock(c_x, n, n2, n3);
        this.uvRotateSouth = 0;
        this.uvRotateEast = 0;
        this.uvRotateWest = 0;
        this.uvRotateNorth = 0;
        this.uvRotateTop = 0;
        this.uvRotateBottom = 0;
        return bl;
    }

    private boolean renderBlockBed(C_x c_x, int n, int n2, int n3) {
        float f;
        C_d c_d = C_d.a;
        byte by = this.a.e(n, n2, n3);
        int n4 = BlockBed.getDirectionFromMetadata(by);
        boolean bl = BlockBed.isBlockFootOfBed(by);
        float f2 = 0.5f;
        float f3 = 1.0f;
        float f4 = 0.8f;
        float f5 = 0.6f;
        float f6 = c_x.f(this.a, n, n2, n3);
        c_d.a(f2 * f6, f2 * f6, f2 * f6);
        int n5 = c_x.a(this.a, n, n2, n3, 0);
        int n6 = (n5 & 0x1F) << 4;
        int n7 = n5 >> 1 & 0x1F0;
        float f7 = (float)n6 / 512.0f;
        float f8 = ((float)(n6 + 16) - 0.01f) / 512.0f;
        float f9 = (float)n7 / 512.0f;
        float f10 = ((float)(n7 + 16) - 0.01f) / 512.0f;
        float f11 = (float)n + c_x.au;
        float f12 = (float)n + c_x.ax;
        float f13 = (float)n2 + c_x.av + 0.1875f;
        float f14 = (float)n3 + c_x.aw;
        float f15 = (float)n3 + c_x.az;
        c_d.a(f11, f13, f15, f7, f10);
        c_d.a(f11, f13, f14, f7, f9);
        c_d.a(f12, f13, f14, f8, f9);
        c_d.a(f12, f13, f15, f8, f10);
        float f16 = c_x.f(this.a, n, n2, n3);
        c_d.a(f3 * f16, f3 * f16, f3 * f16);
        n6 = c_x.a(this.a, n, n2, n3, 1);
        n7 = (n6 & 0x1F) << 4;
        int n8 = n6 >> 1 & 0x1F0;
        float f17 = (float)n7 / 512.0f;
        float f18 = ((float)(n7 + 16) - 0.01f) / 512.0f;
        float f19 = (float)n8 / 512.0f;
        float f20 = ((float)(n8 + 16) - 0.01f) / 512.0f;
        float f21 = f17;
        float f22 = f18;
        float f23 = f19;
        float f24 = f19;
        float f25 = f17;
        float f26 = f18;
        float f27 = f20;
        float f28 = f20;
        if (n4 == 0) {
            f22 = f17;
            f23 = f20;
            f25 = f18;
            f28 = f19;
        } else if (n4 == 2) {
            f21 = f18;
            f24 = f20;
            f26 = f17;
            f27 = f19;
        } else if (n4 == 3) {
            f21 = f18;
            f24 = f20;
            f26 = f17;
            f27 = f19;
            f22 = f17;
            f23 = f20;
            f25 = f18;
            f28 = f19;
        }
        float f29 = (float)n + c_x.au;
        float f30 = (float)n + c_x.ax;
        float f31 = (float)n2 + c_x.ay;
        float f32 = (float)n3 + c_x.aw;
        float f33 = (float)n3 + c_x.az;
        c_d.a(f30, f31, f33, f25, f27);
        c_d.a(f30, f31, f32, f21, f23);
        c_d.a(f29, f31, f32, f22, f24);
        c_d.a(f29, f31, f33, f26, f28);
        n5 = net.minecraft.client.b.C_p.bedFace[n4];
        if (bl) {
            n5 = net.minecraft.client.b.C_p.bedFace[net.minecraft.client.b.C_p.bedAlternateFace[n4]];
        }
        int n9 = 4;
        switch (n4) {
            case 0: {
                n9 = 5;
                break;
            }
            case 1: {
                n9 = 3;
            }
            default: {
                break;
            }
            case 3: {
                n9 = 2;
            }
        }
        if (n5 != 2 && (this.c || c_x.d(this.a, n, n2, n3 - 1, 2))) {
            f = c_x.f(this.a, n, n2, n3 - 1);
            if ((double)c_x.aw > 0.0) {
                f = f6;
            }
            c_d.a(f4 * f, f4 * f, f4 * f);
            this.flipTexture = n9 == 2;
            this.renderEastFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 2));
        }
        if (n5 != 3 && (this.c || c_x.d(this.a, n, n2, n3 + 1, 3))) {
            f = c_x.f(this.a, n, n2, n3 + 1);
            if ((double)c_x.az < 1.0) {
                f = f6;
            }
            c_d.a(f4 * f, f4 * f, f4 * f);
            this.flipTexture = n9 == 3;
            this.renderWestFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 3));
        }
        if (n5 != 4 && (this.c || c_x.d(this.a, n - 1, n2, n3, 4))) {
            f = c_x.f(this.a, n - 1, n2, n3);
            if ((double)c_x.au > 0.0) {
                f = f6;
            }
            c_d.a(f5 * f, f5 * f, f5 * f);
            this.flipTexture = n9 == 4;
            this.renderNorthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 4));
        }
        if (n5 != 5 && (this.c || c_x.d(this.a, n + 1, n2, n3, 5))) {
            f = c_x.f(this.a, n + 1, n2, n3);
            if ((double)c_x.ax < 1.0) {
                f = f6;
            }
            c_d.a(f5 * f, f5 * f, f5 * f);
            this.flipTexture = n9 == 5;
            this.renderSouthFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 5));
        }
        this.flipTexture = false;
        return true;
    }

    public boolean renderBlockChair(C_x c_x, float f, float f2, float f3) {
        float f4;
        C_d c_d = C_d.a;
        int n = c_x.as;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        byte by = 1;
        if (this.a != null) {
            f4 = c_x.f(this.a, (int)f, (int)f2, (int)f3);
            by = this.a.e((int)f, (int)f2, (int)f3);
        } else {
            f4 = 1.0f;
        }
        c_d.a(f4, f4, f4);
        float f5 = (float)n2 / 512.0f;
        float f6 = (float)n3 / 512.0f;
        c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.015625f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.015625f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.015625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.015625f);
        c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.015625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.015625f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.015625f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.015625f);
        c_d.a(f4, f4, f4);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.00390625f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.02734375f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.02734375f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.00390625f);
        c_d.a(f4 * 0.5f, f4 * 0.5f, f4 * 0.5f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f5 + 0.00390625f, f6 + 0.02734375f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f5 + 0.00390625f, f6 + 0.00390625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f5 + 0.02734375f, f6 + 0.00390625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f5 + 0.02734375f, f6 + 0.02734375f);
        for (int i = 0; i < 4; ++i) {
            int n4 = i;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            if (i >= 2) {
                n4 -= 2;
                n5 = 1;
            }
            if (n4 == 0) {
                n6 = 1;
            }
            if (n5 == 0) {
                n7 = 1;
            }
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n5 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n5 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n5 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n5 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n7 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n7 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n7 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n7 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n6 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n6 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n6 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n6 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n4 * 10) / 512.0f, f6 + 0.01953125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n4 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n4 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n4 * 10) / 512.0f, f6 + 0.01953125f);
        }
        if (by >= 1 && by <= 4) {
            float f7 = 0.125f;
            float f8 = 0.875f;
            float f9 = 0.125f;
            float f10 = 0.25f;
            float f11 = 0.00390625f;
            float f12 = 0.02734375f;
            float f13 = 0.00390625f;
            float f14 = 0.02734375f;
            float f15 = 0.00390625f;
            float f16 = 0.0078125f;
            float f17 = 0.0234375f;
            float f18 = 0.02734375f;
            if (by == 2) {
                f9 = 0.75f;
                f10 = 0.875f;
                f15 = 0.0234375f;
                f16 = 0.02734375f;
                f17 = 0.00390625f;
                f18 = 0.0078125f;
            }
            if (by > 2) {
                f7 = 0.125f;
                f8 = 0.25f;
                f9 = 0.125f;
                f10 = 0.875f;
                f11 = 0.0234375f;
                f12 = 0.02734375f;
                f13 = 0.00390625f;
                f14 = 0.0078125f;
                f15 = 0.00390625f;
                f16 = 0.02734375f;
                f17 = 0.00390625f;
                f18 = 0.02734375f;
                if (by == 4) {
                    f7 = 0.75f;
                    f8 = 0.875f;
                    f11 = 0.00390625f;
                    f12 = 0.0078125f;
                    f13 = 0.0234375f;
                    f14 = 0.02734375f;
                }
            }
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f5 + f15, f6);
            c_d.a(f + f7, f2 + 0.5f, f3 + f9, f5 + f15, f6 + 0.015625f);
            c_d.a(f + f7, f2 + 0.5f, f3 + f10, f5 + f16, f6 + 0.015625f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f10, f5 + f16, f6);
            c_d.a(f + f8, f2 + 1.0f, f3 + f10, f5 + f17, f6);
            c_d.a(f + f8, f2 + 0.5f, f3 + f10, f5 + f17, f6 + 0.015625f);
            c_d.a(f + f8, f2 + 0.5f, f3 + f9, f5 + f18, f6 + 0.015625f);
            c_d.a(f + f8, f2 + 1.0f, f3 + f9, f5 + f18, f6);
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f + f8, f2 + 1.0f, f3 + f9, f5 + f11, f6);
            c_d.a(f + f8, f2 + 0.5f, f3 + f9, f5 + f11, f6 + 0.015625f);
            c_d.a(f + f7, f2 + 0.5f, f3 + f9, f5 + f12, f6 + 0.015625f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f5 + f12, f6);
            c_d.a(f + f7, f2 + 1.0f, f3 + f10, f5 + f13, f6);
            c_d.a(f + f7, f2 + 0.5f, f3 + f10, f5 + f13, f6 + 0.015625f);
            c_d.a(f + f8, f2 + 0.5f, f3 + f10, f5 + f14, f6 + 0.015625f);
            c_d.a(f + f8, f2 + 1.0f, f3 + f10, f5 + f14, f6);
            c_d.a(f4, f4, f4);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f5 + f13, f6 + f15);
            c_d.a(f + f7, f2 + 1.0f, f3 + f10, f5 + f13, f6 + f16);
            c_d.a(f + f8, f2 + 1.0f, f3 + f10, f5 + f14, f6 + f16);
            c_d.a(f + f8, f2 + 1.0f, f3 + f9, f5 + f14, f6 + f15);
        }
        return true;
    }

    public boolean renderBlockTable(BlockTable blockTable, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        int n = blockTable.a(0, this.a.e((int)f, (int)f2, (int)f3));
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        float f4 = this.a != null ? blockTable.f(this.a, (int)f, (int)f2, (int)f3) : 1.0f;
        c_d.a(f4, f4, f4);
        float f5 = (float)n2 / 512.0f;
        float f6 = (float)n3 / 512.0f;
        if (blockTable.d(this.a, (int)f + 1, (int)f2, (int)f3, 5)) {
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f5 + 0.0f, f6 + 0.0f);
            c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f5 + 0.0f, f6 + 0.0078125f);
            c_d.a(f + 1.0f, f2 + 0.75f, f3, f5 + 0.03125f, f6 + 0.0078125f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3, f5 + 0.03125f, f6 + 0.0f);
        }
        if (blockTable.d(this.a, (int)f - 1, (int)f2, (int)f3, 4)) {
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f, f2 + 1.0f, f3, f5 + 0.0f, f6 + 0.0f);
            c_d.a(f, f2 + 0.75f, f3, f5 + 0.0f, f6 + 0.0078125f);
            c_d.a(f, f2 + 0.75f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.0078125f);
            c_d.a(f, f2 + 1.0f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.0f);
        }
        if (blockTable.d(this.a, (int)f, (int)f2, (int)f3 - 1, 2)) {
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3, f5 + 0.0f, f6 + 0.0f);
            c_d.a(f + 1.0f, f2 + 0.75f, f3, f5 + 0.0f, f6 + 0.0078125f);
            c_d.a(f, f2 + 0.75f, f3, f5 + 0.03125f, f6 + 0.0078125f);
            c_d.a(f, f2 + 1.0f, f3, f5 + 0.03125f, f6 + 0.0f);
        }
        if (blockTable.d(this.a, (int)f, (int)f2, (int)f3 + 1, 3)) {
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f, f2 + 1.0f, f3 + 1.0f, f5 + 0.0f, f6 + 0.0f);
            c_d.a(f, f2 + 0.75f, f3 + 1.0f, f5 + 0.0f, f6 + 0.0078125f);
            c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.0078125f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.0f);
        }
        if (blockTable.d(this.a, (int)f, (int)f2 + 1, (int)f3, 1)) {
            c_d.a(f4, f4, f4);
            c_d.a(f, f2 + 1.0f, f3, f5 + 0.0f, f6 + 0.0f);
            c_d.a(f, f2 + 1.0f, f3 + 1.0f, f5 + 0.0f, f6 + 0.03125f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.03125f);
            c_d.a(f + 1.0f, f2 + 1.0f, f3, f5 + 0.03125f, f6 + 0.0f);
        }
        c_d.a(f4 * 0.5f, f4 * 0.5f, f4 * 0.5f);
        c_d.a(f, f2 + 0.75f, f3 + 1.0f, f5 + 0.0f, f6 + 0.03125f);
        c_d.a(f, f2 + 0.75f, f3, f5 + 0.0f, f6 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3, f5 + 0.03125f, f6 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f5 + 0.03125f, f6 + 0.03125f);
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        if (this.a != null) {
            bl &= this.a.a((int)f - 1, (int)f2, (int)f3) != C_x.table.at;
            bl &= this.a.a((int)f, (int)f2, (int)f3 - 1) != C_x.table.at;
            bl2 &= this.a.a((int)f + 1, (int)f2, (int)f3) != C_x.table.at;
            bl2 &= this.a.a((int)f, (int)f2, (int)f3 - 1) != C_x.table.at;
            bl3 &= this.a.a((int)f - 1, (int)f2, (int)f3) != C_x.table.at;
            bl3 &= this.a.a((int)f, (int)f2, (int)f3 + 1) != C_x.table.at;
            bl4 &= this.a.a((int)f + 1, (int)f2, (int)f3) != C_x.table.at;
            bl4 &= this.a.a((int)f, (int)f2, (int)f3 + 1) != C_x.table.at;
        }
        boolean[] blArray = new boolean[]{bl, bl2, bl3, bl4};
        for (int i = 0; i < 4; ++i) {
            if (!blArray[i]) continue;
            int n4 = i;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            if (i >= 2) {
                n4 -= 2;
                n5 = 1;
            }
            if (n4 == 0) {
                n6 = 1;
            }
            if (n5 == 0) {
                n7 = 1;
            }
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n5 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n5 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n5 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n5 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f4 * 0.6f, f4 * 0.6f, f4 * 0.6f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n7 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n7 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n7 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n7 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n6 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(2 + n6 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n6 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n5, f5 + (float)(4 + n6 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f4 * 0.8f, f4 * 0.8f, f4 * 0.8f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n4 * 10) / 512.0f, f6 + 0.0078125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(2 + n4 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n4 * 10) / 512.0f, f6 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n5, f5 + (float)(4 + n4 * 10) / 512.0f, f6 + 0.0078125f);
        }
        return true;
    }

    public boolean renderBlockDoor(C_x c_x, int n, int n2, int n3) {
        C_d c_d = C_d.a;
        BlockDoor blockDoor = (BlockDoor)c_x;
        boolean bl = false;
        float f = 0.5f;
        float f2 = 1.0f;
        float f3 = 0.8f;
        float f4 = 0.6f;
        float f5 = c_x.f(this.a, n, n2, n3);
        float f6 = c_x.f(this.a, n, n2 - 1, n3);
        if ((double)blockDoor.av > 0.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f * f6, f * f6, f * f6);
        this.renderBottomFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 0));
        bl = true;
        f6 = c_x.f(this.a, n, n2 + 1, n3);
        if ((double)blockDoor.ay < 1.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f2 * f6, f2 * f6, f2 * f6);
        this.renderTopFace(c_x, n, n2, n3, c_x.a(this.a, n, n2, n3, 1));
        bl = true;
        f6 = c_x.f(this.a, n, n2, n3 - 1);
        if ((double)blockDoor.aw > 0.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f3 * f6, f3 * f6, f3 * f6);
        int n4 = c_x.a(this.a, n, n2, n3, 2);
        if (n4 < 0) {
            this.flipTexture = true;
            n4 = -n4;
        }
        this.renderEastFace(c_x, n, n2, n3, n4);
        bl = true;
        this.flipTexture = false;
        f6 = c_x.f(this.a, n, n2, n3 + 1);
        if ((double)blockDoor.az < 1.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f3 * f6, f3 * f6, f3 * f6);
        n4 = c_x.a(this.a, n, n2, n3, 3);
        if (n4 < 0) {
            this.flipTexture = true;
            n4 = -n4;
        }
        this.renderWestFace(c_x, n, n2, n3, n4);
        bl = true;
        this.flipTexture = false;
        f6 = c_x.f(this.a, n - 1, n2, n3);
        if ((double)blockDoor.au > 0.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f4 * f6, f4 * f6, f4 * f6);
        n4 = c_x.a(this.a, n, n2, n3, 4);
        if (n4 < 0) {
            this.flipTexture = true;
            n4 = -n4;
        }
        this.renderNorthFace(c_x, n, n2, n3, n4);
        bl = true;
        this.flipTexture = false;
        f6 = c_x.f(this.a, n + 1, n2, n3);
        if ((double)blockDoor.ax < 1.0) {
            f6 = f5;
        }
        if (C_x.h[c_x.at] > 0) {
            f6 = 1.0f;
        }
        c_d.a(f4 * f6, f4 * f6, f4 * f6);
        n4 = c_x.a(this.a, n, n2, n3, 5);
        if (n4 < 0) {
            this.flipTexture = true;
            n4 = -n4;
        }
        this.renderSouthFace(c_x, n, n2, n3, n4);
        bl = true;
        this.flipTexture = false;
        return bl;
    }

    public boolean renderBlockLadder(C_x c_x, int n, int n2, int n3) {
        C_d c_d = C_d.a;
        int n4 = c_x.a(0);
        if (this.b >= 0) {
            n4 = this.b;
        }
        float f = c_x.f(this.a, n, n2, n3);
        c_d.a(f, f, f);
        int n5 = (n4 & 0x1F) << 4;
        int n6 = n4 >> 1 & 0x1F0;
        double d2 = (float)n5 / 512.0f;
        double d3 = ((float)n5 + 15.99f) / 512.0f;
        double d4 = (float)n6 / 512.0f;
        double d5 = ((float)n6 + 15.99f) / 512.0f;
        byte by = this.a.e(n, n2, n3);
        float f2 = 0.0f;
        float f3 = 0.05f;
        if (by == 5) {
            c_d.a((float)n + f3, (float)(n2 + 1) + f2, (float)(n3 + 1) + f2, (float)d2, (float)d4);
            c_d.a((float)n + f3, (float)(n2 + 0) - f2, (float)(n3 + 1) + f2, (float)d2, (float)d5);
            c_d.a((float)n + f3, (float)(n2 + 0) - f2, (float)(n3 + 0) - f2, (float)d3, (float)d5);
            c_d.a((float)n + f3, (float)(n2 + 1) + f2, (float)(n3 + 0) - f2, (float)d3, (float)d4);
        }
        if (by == 4) {
            c_d.a((float)(n + 1) - f3, (float)(n2 + 0) - f2, (float)(n3 + 1) + f2, (float)d3, (float)d5);
            c_d.a((float)(n + 1) - f3, (float)(n2 + 1) + f2, (float)(n3 + 1) + f2, (float)d3, (float)d4);
            c_d.a((float)(n + 1) - f3, (float)(n2 + 1) + f2, (float)(n3 + 0) - f2, (float)d2, (float)d4);
            c_d.a((float)(n + 1) - f3, (float)(n2 + 0) - f2, (float)(n3 + 0) - f2, (float)d2, (float)d5);
        }
        if (by == 3) {
            c_d.a((float)(n + 1) + f2, (float)(n2 + 0) - f2, (float)n3 + f3, (float)d3, (float)d5);
            c_d.a((float)(n + 1) + f2, (float)(n2 + 1) + f2, (float)n3 + f3, (float)d3, (float)d4);
            c_d.a((float)(n + 0) - f2, (float)(n2 + 1) + f2, (float)n3 + f3, (float)d2, (float)d4);
            c_d.a((float)(n + 0) - f2, (float)(n2 + 0) - f2, (float)n3 + f3, (float)d2, (float)d5);
        }
        if (by == 2) {
            c_d.a((float)(n + 1) + f2, (float)(n2 + 1) + f2, (float)(n3 + 1) - f3, (float)d2, (float)d4);
            c_d.a((float)(n + 1) + f2, (float)(n2 + 0) - f2, (float)(n3 + 1) - f3, (float)d2, (float)d5);
            c_d.a((float)(n + 0) - f2, (float)(n2 + 0) - f2, (float)(n3 + 1) - f3, (float)d3, (float)d5);
            c_d.a((float)(n + 0) - f2, (float)(n2 + 1) + f2, (float)(n3 + 1) - f3, (float)d3, (float)d4);
        }
        return true;
    }

    public boolean renderBlockVine(C_x c_x, int n, int n2, int n3) {
        C_d c_d = C_d.a;
        int n4 = c_x.a(0);
        if (this.b >= 0) {
            n4 = this.b;
        }
        float f = c_x.f(this.a, n, n2, n3);
        int n5 = 0xFFFFFF;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        c_d.a(f * f2, f * f3, f * f4);
        n5 = (n4 & 0x1F) << 4;
        int n6 = n4 >> 1 & 0x1F0;
        float f5 = (float)n5 / 512.0f;
        float f6 = ((float)n5 + 15.99f) / 512.0f;
        float f7 = (float)n6 / 512.0f;
        float f8 = ((float)n6 + 15.99f) / 512.0f;
        float f9 = 0.05f;
        byte by = this.a.e(n, n2, n3);
        if (by == 5) {
            c_d.a((float)n + f9, n2 + 1, n3 + 1, f5, f7);
            c_d.a((float)n + f9, n2 + 0, n3 + 1, f5, f8);
            c_d.a((float)n + f9, n2 + 0, n3 + 0, f6, f8);
            c_d.a((float)n + f9, n2 + 1, n3 + 0, f6, f7);
            c_d.a((float)n + f9, n2 + 1, n3 + 0, f6, f7);
            c_d.a((float)n + f9, n2 + 0, n3 + 0, f6, f8);
            c_d.a((float)n + f9, n2 + 0, n3 + 1, f5, f8);
            c_d.a((float)n + f9, n2 + 1, n3 + 1, f5, f7);
        }
        if (by == 4) {
            c_d.a((float)(n + 1) - f9, n2 + 0, n3 + 1, f6, f8);
            c_d.a((float)(n + 1) - f9, n2 + 1, n3 + 1, f6, f7);
            c_d.a((float)(n + 1) - f9, n2 + 1, n3 + 0, f5, f7);
            c_d.a((float)(n + 1) - f9, n2 + 0, n3 + 0, f5, f8);
            c_d.a((float)(n + 1) - f9, n2 + 0, n3 + 0, f5, f8);
            c_d.a((float)(n + 1) - f9, n2 + 1, n3 + 0, f5, f7);
            c_d.a((float)(n + 1) - f9, n2 + 1, n3 + 1, f6, f7);
            c_d.a((float)(n + 1) - f9, n2 + 0, n3 + 1, f6, f8);
        }
        if (by == 3) {
            c_d.a(n + 1, n2 + 0, (float)n3 + f9, f6, f8);
            c_d.a(n + 1, n2 + 1, (float)n3 + f9, f6, f7);
            c_d.a(n + 0, n2 + 1, (float)n3 + f9, f5, f7);
            c_d.a(n + 0, n2 + 0, (float)n3 + f9, f5, f8);
            c_d.a(n + 0, n2 + 0, (float)n3 + f9, f5, f8);
            c_d.a(n + 0, n2 + 1, (float)n3 + f9, f5, f7);
            c_d.a(n + 1, n2 + 1, (float)n3 + f9, f6, f7);
            c_d.a(n + 1, n2 + 0, (float)n3 + f9, f6, f8);
        }
        if (by == 2) {
            c_d.a(n + 1, n2 + 1, (float)(n3 + 1) - f9, f5, f7);
            c_d.a(n + 1, n2 + 0, (float)(n3 + 1) - f9, f5, f8);
            c_d.a(n + 0, n2 + 0, (float)(n3 + 1) - f9, f6, f8);
            c_d.a(n + 0, n2 + 1, (float)(n3 + 1) - f9, f6, f7);
            c_d.a(n + 0, n2 + 1, (float)(n3 + 1) - f9, f6, f7);
            c_d.a(n + 0, n2 + 0, (float)(n3 + 1) - f9, f6, f8);
            c_d.a(n + 1, n2 + 0, (float)(n3 + 1) - f9, f5, f8);
            c_d.a(n + 1, n2 + 1, (float)(n3 + 1) - f9, f5, f7);
        }
        if (this.a.b(n, n2 + 1, n3)) {
            c_d.a(n + 1, (float)(n2 + 1) - f9, n3 + 0, f5, f7);
            c_d.a(n + 1, (float)(n2 + 1) - f9, n3 + 1, f5, f8);
            c_d.a(n + 0, (float)(n2 + 1) - f9, n3 + 1, f6, f8);
            c_d.a(n + 0, (float)(n2 + 1) - f9, n3 + 0, f6, f7);
        }
        return true;
    }

    public boolean renderBlockLilyPad(C_x c_x, int n, int n2, int n3) {
        C_d c_d = C_d.a;
        int n4 = c_x.as;
        if (this.b >= 0) {
            n4 = this.b;
        }
        int n5 = (n4 & 0x1F) << 4;
        int n6 = n4 >> 1 & 0x1F0;
        float f = 0.015625f;
        float f2 = (float)n5 / 512.0f;
        float f3 = ((float)n5 + 15.99f) / 512.0f;
        float f4 = (float)n6 / 512.0f;
        float f5 = ((float)n6 + 15.99f) / 512.0f;
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        l = l * l * 42317861L + l * 11L;
        int n7 = (int)(l >> 16 & 3L);
        float f6 = (float)n + 0.5f;
        float f7 = (float)n3 + 0.5f;
        float f8 = (float)(n7 & 1) * 0.5f * (float)(1 - n7 / 2 % 2 * 2);
        float f9 = (float)(n7 + 1 & 1) * 0.5f * (float)(1 - (n7 + 1) / 2 % 2 * 2);
        float f10 = c_x.f(this.a, n, n2, n3);
        int n8 = 0xFFFFFF;
        float f11 = (float)(n8 >> 16 & 0xFF) / 255.0f;
        float f12 = (float)(n8 >> 8 & 0xFF) / 255.0f;
        float f13 = (float)(n8 & 0xFF) / 255.0f;
        c_d.a(f10 * f11, f10 * f12, f10 * f13);
        c_d.a(f6 + f8 - f9, (float)n2 + f, f7 + f8 + f9, f2, f4);
        c_d.a(f6 + f8 + f9, (float)n2 + f, f7 - f8 + f9, f3, f4);
        c_d.a(f6 - f8 + f9, (float)n2 + f, f7 - f8 - f9, f3, f5);
        c_d.a(f6 - f8 - f9, (float)n2 + f, f7 + f8 - f9, f2, f5);
        c_d.a(f6 - f8 - f9, (float)n2 + f, f7 + f8 - f9, f2, f5);
        c_d.a(f6 - f8 + f9, (float)n2 + f, f7 - f8 - f9, f3, f5);
        c_d.a(f6 + f8 + f9, (float)n2 + f, f7 - f8 + f9, f3, f4);
        c_d.a(f6 + f8 - f9, (float)n2 + f, f7 + f8 + f9, f2, f4);
        return true;
    }

    public boolean renderRails(C_x c_x, int n, int n2, int n3) {
        C_d c_d = C_d.a;
        byte by = this.a.e(n, n2, n3);
        int n4 = c_x.a(0, by);
        if (this.b >= 0) {
            n4 = this.b;
        }
        float f = c_x.f(this.a, n, n2, n3);
        c_d.a(f, f, f);
        int n5 = (n4 & 0x1F) << 4;
        int n6 = n4 >> 1 & 0x1F0;
        float f2 = (float)n5 / 512.0f;
        float f3 = ((float)n5 + 15.99f) / 512.0f;
        float f4 = (float)n6 / 512.0f;
        float f5 = ((float)n6 + 15.99f) / 512.0f;
        float f6 = 0.0625f;
        float f7 = n + 1;
        float f8 = n + 1;
        float f9 = n + 0;
        float f10 = n + 0;
        float f11 = n3 + 0;
        float f12 = n3 + 1;
        float f13 = n3 + 1;
        float f14 = n3 + 0;
        float f15 = (float)n2 + f6;
        float f16 = (float)n2 + f6;
        float f17 = (float)n2 + f6;
        float f18 = (float)n2 + f6;
        if (by != 1 && by != 2 && by != 3 && by != 7) {
            if (by == 8) {
                f7 = f8 = (float)(n + 0);
                f9 = f10 = (float)(n + 1);
                f11 = f14 = (float)(n3 + 1);
                f12 = f13 = (float)(n3 + 0);
            } else if (by == 9) {
                f7 = f10 = (float)(n + 0);
                f8 = f9 = (float)(n + 1);
                f11 = f12 = (float)(n3 + 0);
                f13 = f14 = (float)(n3 + 1);
            }
        } else {
            f7 = f10 = (float)(n + 1);
            f8 = f9 = (float)(n + 0);
            f11 = f12 = (float)(n3 + 1);
            f13 = f14 = (float)(n3 + 0);
        }
        if (by != 2 && by != 4) {
            if (by == 3 || by == 5) {
                f16 += 1.0f;
                f17 += 1.0f;
            }
        } else {
            f15 += 1.0f;
            f18 += 1.0f;
        }
        c_d.a(f7, f15, f11, f3, f4);
        c_d.a(f8, f16, f12, f3, f5);
        c_d.a(f9, f17, f13, f2, f5);
        c_d.a(f10, f18, f14, f2, f4);
        c_d.a(f10, f18, f14, f2, f4);
        c_d.a(f9, f17, f13, f2, f5);
        c_d.a(f8, f16, f12, f3, f5);
        c_d.a(f7, f15, f11, f3, f4);
        return true;
    }

    public boolean renderBlockFence(C_x c_x, int n, int n2, int n3) {
        float f;
        boolean bl = false;
        float f2 = 0.375f;
        float f3 = 0.625f;
        c_x.a(f2, 0.0f, f2, f3, 1.0f, f3);
        this.renderStandardBlock(c_x, n, n2, n3);
        int n4 = this.a.a(n - 1, n2, n3);
        int n5 = this.a.a(n + 1, n2, n3);
        int n6 = this.a.a(n, n2, n3 - 1);
        int n7 = this.a.a(n, n2, n3 + 1);
        bl = true;
        boolean bl2 = false;
        boolean bl3 = false;
        if (n4 == c_x.at || n5 == c_x.at || n4 == C_x.fenceGateOak.at || n5 == C_x.fenceGateOak.at || n4 == C_x.fenceGateBirch.at || n5 == C_x.fenceGateBirch.at || n4 == C_x.fenceGatePalm.at || n5 == C_x.fenceGatePalm.at || n4 == C_x.fenceGateSpruce.at || n5 == C_x.fenceGateSpruce.at || this.a.a((float)(n - 1), (float)n2, (float)n3) || this.a.a((float)(n + 1), (float)n2, (float)n3)) {
            bl2 = true;
        }
        if (n6 == c_x.at || n7 == c_x.at || n6 == C_x.fenceGateOak.at || n7 == C_x.fenceGateOak.at || n6 == C_x.fenceGateBirch.at || n7 == C_x.fenceGateBirch.at || n6 == C_x.fenceGatePalm.at || n7 == C_x.fenceGatePalm.at || n6 == C_x.fenceGateSpruce.at || n7 == C_x.fenceGateSpruce.at || this.a.a((float)n, (float)n2, (float)(n3 - 1)) || this.a.a((float)n, (float)n2, (float)(n3 + 1))) {
            bl3 = true;
        }
        boolean bl4 = this.a.a((float)(n - 1), (float)n2, (float)n3) | n4 == c_x.at | n4 == C_x.fenceGateOak.at | n4 == C_x.fenceGateBirch.at | n4 == C_x.fenceGatePalm.at | n4 == C_x.fenceGateSpruce.at;
        boolean bl5 = this.a.a((float)(n + 1), (float)n2, (float)n3) | n5 == c_x.at | n5 == C_x.fenceGateOak.at | n5 == C_x.fenceGateBirch.at | n5 == C_x.fenceGatePalm.at | n5 == C_x.fenceGateSpruce.at;
        boolean bl6 = this.a.a((float)n, (float)n2, (float)(n3 - 1)) | n6 == c_x.at | n6 == C_x.fenceGateOak.at | n6 == C_x.fenceGateBirch.at | n6 == C_x.fenceGatePalm.at | n6 == C_x.fenceGateSpruce.at;
        boolean bl7 = this.a.a((float)n, (float)n2, (float)(n3 + 1)) | n7 == c_x.at | n7 == C_x.fenceGateOak.at | n7 == C_x.fenceGateBirch.at | n7 == C_x.fenceGatePalm.at | n7 == C_x.fenceGateSpruce.at;
        if (!bl2 && !bl3) {
            bl2 = true;
        }
        f2 = 0.4375f;
        f3 = 0.5625f;
        float f4 = 0.75f;
        float f5 = 0.9375f;
        float f6 = bl4 ? 0.0f : f2;
        float f7 = bl5 ? 1.0f : f3;
        float f8 = bl6 ? 0.0f : f2;
        float f9 = f = bl7 ? 1.0f : f3;
        if (bl2) {
            c_x.a(f6, f4, f2, f7, f5, f3);
            this.renderStandardBlock(c_x, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            c_x.a(f2, f4, f8, f3, f5, f);
            this.renderStandardBlock(c_x, n, n2, n3);
            bl = true;
        }
        f4 = 0.375f;
        f5 = 0.5625f;
        if (bl2) {
            c_x.a(f6, f4, f2, f7, f5, f3);
            this.renderStandardBlock(c_x, n, n2, n3);
            bl = true;
        }
        if (bl3) {
            c_x.a(f2, f4, f8, f3, f5, f);
            this.renderStandardBlock(c_x, n, n2, n3);
            bl = true;
        }
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return bl;
    }

    public boolean renderBlockFenceGate(C_x c_x, int n, int n2, int n3) {
        float f;
        float f2;
        float f3;
        float f4;
        boolean bl = true;
        byte by = this.a.e(n, n2, n3);
        boolean bl2 = BlockFenceGate.isOpen(by);
        int n4 = BlockFenceGate.getOpenState(by);
        if (n4 != 3 && n4 != 1) {
            f4 = 0.0f;
            f3 = 0.125f;
            f2 = 0.4375f;
            f = 0.5625f;
            c_x.a(f4, 0.3125f, f2, f3, 1.0f, f);
            this.renderStandardBlock(c_x, n, n2, n3);
            f4 = 0.875f;
            f3 = 1.0f;
            c_x.a(f4, 0.3125f, f2, f3, 1.0f, f);
            this.renderStandardBlock(c_x, n, n2, n3);
        } else {
            f4 = 0.4375f;
            f3 = 0.5625f;
            f2 = 0.0f;
            f = 0.125f;
            c_x.a(f4, 0.3125f, f2, f3, 1.0f, f);
            this.renderStandardBlock(c_x, n, n2, n3);
            f2 = 0.875f;
            f = 1.0f;
            c_x.a(f4, 0.3125f, f2, f3, 1.0f, f);
            this.renderStandardBlock(c_x, n, n2, n3);
        }
        if (!bl2) {
            if (n4 != 3 && n4 != 1) {
                f4 = 0.375f;
                f3 = 0.5f;
                f2 = 0.4375f;
                f = 0.5625f;
                c_x.a(f4, 0.375f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f4 = 0.5f;
                f3 = 0.625f;
                c_x.a(f4, 0.375f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f4 = 0.625f;
                f3 = 0.875f;
                c_x.a(f4, 0.375f, f2, f3, 0.5625f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                c_x.a(f4, 0.75f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f4 = 0.125f;
                f3 = 0.375f;
                c_x.a(f4, 0.375f, f2, f3, 0.5625f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                c_x.a(f4, 0.75f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
            } else {
                f4 = 0.4375f;
                f3 = 0.5625f;
                f2 = 0.375f;
                f = 0.5f;
                c_x.a(f4, 0.375f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f2 = 0.5f;
                f = 0.625f;
                c_x.a(f4, 0.375f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f2 = 0.625f;
                f = 0.875f;
                c_x.a(f4, 0.375f, f2, f3, 0.5625f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                c_x.a(f4, 0.75f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                f2 = 0.125f;
                f = 0.375f;
                c_x.a(f4, 0.375f, f2, f3, 0.5625f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
                c_x.a(f4, 0.75f, f2, f3, 0.9375f, f);
                this.renderStandardBlock(c_x, n, n2, n3);
            }
        } else if (n4 == 3) {
            c_x.a(0.8125f, 0.375f, 0.0f, 0.9375f, 0.9375f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.8125f, 0.375f, 0.875f, 0.9375f, 0.9375f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.5625f, 0.375f, 0.0f, 0.8125f, 0.5625f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.5625f, 0.375f, 0.875f, 0.8125f, 0.5625f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.5625f, 0.75f, 0.0f, 0.8125f, 0.9375f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.5625f, 0.75f, 0.875f, 0.8125f, 0.9375f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
        } else if (n4 == 1) {
            c_x.a(0.0625f, 0.375f, 0.0f, 0.1875f, 0.9375f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0625f, 0.375f, 0.875f, 0.1875f, 0.9375f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.1875f, 0.375f, 0.0f, 0.4375f, 0.5625f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.1875f, 0.375f, 0.875f, 0.4375f, 0.5625f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.1875f, 0.75f, 0.0f, 0.4375f, 0.9375f, 0.125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.1875f, 0.75f, 0.875f, 0.4375f, 0.9375f, 1.0f);
            this.renderStandardBlock(c_x, n, n2, n3);
        } else if (n4 == 0) {
            c_x.a(0.0f, 0.375f, 0.8125f, 0.125f, 0.9375f, 0.9375f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.375f, 0.8125f, 1.0f, 0.9375f, 0.9375f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0f, 0.375f, 0.5625f, 0.125f, 0.5625f, 0.8125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.375f, 0.5625f, 1.0f, 0.5625f, 0.8125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0f, 0.75f, 0.5625f, 0.125f, 0.9375f, 0.8125f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.75f, 0.5625f, 1.0f, 0.9375f, 0.8125f);
            this.renderStandardBlock(c_x, n, n2, n3);
        } else if (n4 == 2) {
            c_x.a(0.0f, 0.375f, 0.0625f, 0.125f, 0.9375f, 0.1875f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.375f, 0.0625f, 1.0f, 0.9375f, 0.1875f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0f, 0.375f, 0.1875f, 0.125f, 0.5625f, 0.4375f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.375f, 0.1875f, 1.0f, 0.5625f, 0.4375f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.0f, 0.75f, 0.1875f, 0.125f, 0.9375f, 0.4375f);
            this.renderStandardBlock(c_x, n, n2, n3);
            c_x.a(0.875f, 0.75f, 0.1875f, 1.0f, 0.9375f, 0.4375f);
            this.renderStandardBlock(c_x, n, n2, n3);
        }
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return bl;
    }

    public boolean renderBlockWall(BlockWall blockWall, int n, int n2, int n3) {
        boolean bl = blockWall.canConnectWallTo(this.a, n - 1, n2, n3);
        boolean bl2 = blockWall.canConnectWallTo(this.a, n + 1, n2, n3);
        boolean bl3 = blockWall.canConnectWallTo(this.a, n, n2, n3 - 1);
        boolean bl4 = blockWall.canConnectWallTo(this.a, n, n2, n3 + 1);
        boolean bl5 = blockWall.canConnectWallTo(this.a, n, n2 + 1, n3);
        boolean bl6 = blockWall.canConnectWallTo(this.a, n - 1, n2 + 1, n3);
        boolean bl7 = blockWall.canConnectWallTo(this.a, n + 1, n2 + 1, n3);
        boolean bl8 = blockWall.canConnectWallTo(this.a, n, n2 + 1, n3 - 1);
        boolean bl9 = blockWall.canConnectWallTo(this.a, n, n2 + 1, n3 + 1);
        boolean bl10 = bl3 && bl4 && !bl && !bl2;
        boolean bl11 = !bl3 && !bl4 && bl && bl2;
        boolean bl12 = bl8 && bl9 && !bl6 && !bl7;
        boolean bl13 = !bl8 && !bl9 && bl6 && bl7;
        byte by = this.a.e(n, n2, n3);
        boolean bl14 = by == 2 || by == 4 || by == 5 || by == 6;
        C_x c_x = C_x.c[this.a.a(n, n2 + 1, n3)];
        if (c_x instanceof BlockTorch || c_x instanceof BlockFence || c_x instanceof BlockLantern || c_x instanceof BlockRod || bl5 && !bl12 && !bl13) {
            blockWall.a(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
            if (bl14) {
                this.renderStandardBlockNew(blockWall, n, n2, n3);
            } else {
                this.renderStandardBlock(blockWall, n, n2, n3);
            }
        }
        float f = 0.8125f;
        if (bl5) {
            f = 1.0f;
        }
        if (bl10 || bl11) {
            if (bl10) {
                blockWall.a(0.3125f, 0.0f, 0.0f, 0.6875f, f, 1.0f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            } else {
                blockWall.a(0.0f, 0.0f, 0.3125f, 1.0f, f, 0.6875f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            }
        } else {
            blockWall.a(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
            this.renderStandardBlock(blockWall, n, n2, n3);
            if (bl) {
                blockWall.a(0.0f, 0.0f, 0.3125f, 0.25f, f, 0.6875f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            }
            if (bl2) {
                blockWall.a(0.75f, 0.0f, 0.3125f, 1.0f, f, 0.6875f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            }
            if (bl3) {
                blockWall.a(0.3125f, 0.0f, 0.0f, 0.6875f, f, 0.25f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            }
            if (bl4) {
                blockWall.a(0.3125f, 0.0f, 0.75f, 0.6875f, f, 1.0f);
                if (bl14) {
                    this.renderStandardBlockNew(blockWall, n, n2, n3);
                } else {
                    this.renderStandardBlock(blockWall, n, n2, n3);
                }
            }
        }
        blockWall.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return true;
    }

    public boolean renderPaneBlock(C_x c_x, int n, int n2, int n3) {
        BlockPane blockPane = (BlockPane)c_x;
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        boolean bl = blockPane.doesPaneMatch(this.a.a(n, n2, n3 - 1));
        boolean bl2 = blockPane.doesPaneMatch(this.a.a(n, n2, n3 + 1));
        boolean bl3 = blockPane.doesPaneMatch(this.a.a(n - 1, n2, n3));
        boolean bl4 = blockPane.doesPaneMatch(this.a.a(n + 1, n2, n3));
        if (bl3 && bl4 && bl && bl2) {
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
            blockPane.a(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            boolean bl5 = this.renderStandardBlock(blockPane, n, n2, n3);
            this.uvRotateTop = 0;
            this.uvRotateBottom = 0;
            blockPane.a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            bl5 = this.renderStandardBlock(blockPane, n, n2, n3);
            return bl5;
        }
        if (bl && !bl2) {
            blockPane.a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.4375f);
            this.renderStandardBlock(blockPane, n, n2, n3);
        } else if (!bl && bl2) {
            blockPane.a(0.4375f, 0.0f, 0.5625f, 0.5625f, 1.0f, 1.0f);
            this.renderStandardBlock(blockPane, n, n2, n3);
        } else if (bl && bl2) {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        if (bl3 && bl4) {
            f = 0.0f;
            f2 = 1.0f;
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
        } else if (bl3) {
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
            blockPane.a(0.0f, 0.0f, 0.4375f, 0.4375f, 1.0f, 0.5625f);
            this.renderStandardBlock(blockPane, n, n2, n3);
            this.uvRotateTop = 0;
            this.uvRotateBottom = 0;
        } else if (bl4) {
            this.uvRotateTop = 1;
            this.uvRotateBottom = 1;
            blockPane.a(0.5625f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            this.renderStandardBlock(blockPane, n, n2, n3);
            this.uvRotateTop = 0;
            this.uvRotateBottom = 0;
        }
        blockPane.a(f, 0.0f, f3, f2, 1.0f, f4);
        boolean bl6 = this.renderStandardBlock(blockPane, n, n2, n3);
        this.uvRotateTop = 0;
        this.uvRotateBottom = 0;
        blockPane.setBlockBoundsBasedOnState(this.a, n, n2, n3);
        return bl6;
    }

    public boolean renderBlockStairs(C_x c_x, int n, int n2, int n3) {
        boolean bl = true;
        ((C_bq)c_x).renderNormal(this.a, n, n2, n3);
        this.renderStandardBlockNew(c_x, n, n2, n3, n, n2, n3);
        ((C_bq)c_x).renderCornerInner(this.a, n, n2, n3);
        this.renderStandardBlockNew(c_x, n, n2, n3, n, n2, n3);
        ((C_bq)c_x).renderCornerOuter(this.a, n, n2, n3);
        this.renderStandardBlockNew(c_x, n, n2, n3, n, n2, n3);
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return bl;
    }

    public boolean renderStandardBlock(C_x c_x, int n, int n2, int n3) {
        return this.renderStandardBlock(c_x, n, n2, n3, n, n2, n3);
    }

    public boolean renderStandardBlock(C_x c_x, int n, int n2, int n3, double d2, double d3, double d4) {
        int n4 = 0xFFFFFF;
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        return this.renderStandardBlockWithColorMultiplier(c_x, n, n2, n3, d2, d3, d4, f, f2, f3);
    }

    public boolean renderStandardBlockWithColorMultiplier(C_x c_x, int n, int n2, int n3, double d2, double d3, double d4, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        boolean bl = false;
        float f4 = 0.5f;
        float f5 = 1.0f;
        float f6 = 0.8f;
        float f7 = 0.6f;
        float f8 = f4 * f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = c_x.f(this.a, n, n2, n3);
        float f21 = c_x.f(this.a, n, n2 - 1, n3);
        c_d.a(f8 * f21, f12 * f21, f16 * f21);
        this.renderBottomFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 0));
        bl = true;
        f21 = c_x.f(this.a, n, n2 + 1, n3);
        if ((double)c_x.ay != 1.0 && !c_x.getMaterial(0).d()) {
            f21 = f20;
        }
        c_d.a(f9 * f21, f13 * f21, f17 * f21);
        this.renderTopFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 1));
        bl = true;
        f21 = c_x.f(this.a, n, n2, n3 - 1);
        if ((double)c_x.aw > 0.0) {
            f21 = f20;
        }
        c_d.a(f10 * f21, f14 * f21, f18 * f21);
        this.renderEastFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 2));
        bl = true;
        f21 = c_x.f(this.a, n, n2, n3 + 1);
        if ((double)c_x.az < 1.0) {
            f21 = f20;
        }
        c_d.a(f10 * f21, f14 * f21, f18 * f21);
        this.renderWestFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 3));
        bl = true;
        f21 = c_x.f(this.a, n - 1, n2, n3);
        if ((double)c_x.au > 0.0) {
            f21 = f20;
        }
        c_d.a(f11 * f21, f15 * f21, f19 * f21);
        this.renderNorthFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 4));
        bl = true;
        f21 = c_x.f(this.a, n + 1, n2, n3);
        if ((double)c_x.ax < 1.0) {
            f21 = f20;
        }
        c_d.a(f11 * f21, f15 * f21, f19 * f21);
        this.renderSouthFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 5));
        bl = true;
        return bl;
    }

    public boolean renderStandardBlockNew(C_x c_x, int n, int n2, int n3) {
        return this.renderStandardBlockNew(c_x, n, n2, n3, n, n2, n3);
    }

    public boolean renderStandardBlockNew(C_x c_x, int n, int n2, int n3, double d2, double d3, double d4) {
        int n4 = 0xFFFFFF;
        float f = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n4 & 0xFF) / 255.0f;
        return this.renderStandardBlockNew(c_x, n, n2, n3, d2, d3, d4, f, f2, f3);
    }

    public boolean renderStandardBlockNew(C_x c_x, int n, int n2, int n3, double d2, double d3, double d4, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        boolean bl = false;
        float f4 = 0.5f;
        float f5 = 1.0f;
        float f6 = 0.8f;
        float f7 = 0.6f;
        float f8 = f4 * f;
        float f9 = f5 * f;
        float f10 = f6 * f;
        float f11 = f7 * f;
        float f12 = f4 * f2;
        float f13 = f5 * f2;
        float f14 = f6 * f2;
        float f15 = f7 * f2;
        float f16 = f4 * f3;
        float f17 = f5 * f3;
        float f18 = f6 * f3;
        float f19 = f7 * f3;
        float f20 = c_x.f(this.a, n, n2, n3);
        float f21 = c_x.f(this.a, n, n2 - 1, n3);
        c_d.a(f8 * f21, f12 * f21, f16 * f21);
        this.renderBottomFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 0));
        bl = true;
        f21 = c_x.f(this.a, n, n2 + 1, n3);
        if ((double)c_x.ay != 1.0 && !c_x.getMaterial(0).d()) {
            f21 = f20;
        }
        c_d.a(f9 * f21, f13 * f21, f17 * f21);
        this.renderTopFace(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 1));
        bl = true;
        f21 = c_x.f(this.a, n, n2, n3 - 1);
        if ((double)c_x.aw > 0.0) {
            f21 = f20;
        }
        c_d.a(f10 * f21, f14 * f21, f18 * f21);
        this.renderEastFaceNew(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 2));
        bl = true;
        f21 = c_x.f(this.a, n, n2, n3 + 1);
        if ((double)c_x.az < 1.0) {
            f21 = f20;
        }
        c_d.a(f10 * f21, f14 * f21, f18 * f21);
        this.renderWestFaceNew(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 3));
        bl = true;
        f21 = c_x.f(this.a, n - 1, n2, n3);
        if ((double)c_x.au > 0.0) {
            f21 = f20;
        }
        c_d.a(f11 * f21, f15 * f21, f19 * f21);
        this.renderNorthFaceNew(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 4));
        bl = true;
        f21 = c_x.f(this.a, n + 1, n2, n3);
        if ((double)c_x.ax < 1.0) {
            f21 = f20;
        }
        c_d.a(f11 * f21, f15 * f21, f19 * f21);
        this.renderSouthFaceNew(c_x, d2, d3, d4, c_x.a(this.a, n, n2, n3, 5));
        bl = true;
        return bl;
    }

    private float a(int n, int n2, int n3) {
        if (this.a.f(n, n2, n3) != C_c.f) {
            return 1.0f;
        }
        return (float)this.a.e(n, n2, n3) / 9.0f;
    }

    public void renderBottomFace(C_x c_x, double d2, double d3, double d4, int n) {
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d5 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d6 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d7 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
        double d8 = ((double)n3 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d5 = ((float)n2 + 0.0f) / 512.0f;
            d6 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d7 = ((float)n3 + 0.0f) / 512.0f;
            d8 = ((float)n3 + 15.99f) / 512.0f;
        }
        double d9 = d6;
        double d10 = d5;
        double d11 = d7;
        double d12 = d8;
        if (this.uvRotateBottom == 2) {
            d5 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d6 = ((double)n2 + (double)c_x.az * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d11 = d7;
            d12 = d8;
            d9 = d5;
            d10 = d6;
            d7 = d8;
            d8 = d11;
        } else if (this.uvRotateBottom == 1) {
            d5 = ((double)(n2 + 16) - (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d9 = d6;
            d10 = d5;
            d5 = d6;
            d6 = d10;
            d11 = d8;
            d12 = d7;
        } else if (this.uvRotateBottom == 3) {
            d5 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d6 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d7 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d9 = d6;
            d10 = d5;
            d11 = d7;
            d12 = d8;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.av;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d15, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d5, (float)d7);
        c_d.a((float)d14, (float)d15, (float)d16, (float)d9, (float)d11);
        c_d.a((float)d14, (float)d15, (float)d17, (float)d6, (float)d8);
    }

    public void renderTopFace(C_x c_x, double d2, double d3, double d4, int n) {
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d5 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d6 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d7 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
        double d8 = ((double)n3 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d5 = ((float)n2 + 0.0f) / 512.0f;
            d6 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d7 = ((float)n3 + 0.0f) / 512.0f;
            d8 = ((float)n3 + 15.99f) / 512.0f;
        }
        double d9 = d6;
        double d10 = d5;
        double d11 = d7;
        double d12 = d8;
        if (this.uvRotateTop == 1) {
            d5 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d6 = ((double)n2 + (double)c_x.az * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d11 = d7;
            d12 = d8;
            d9 = d5;
            d10 = d6;
            d7 = d8;
            d8 = d11;
        } else if (this.uvRotateTop == 2) {
            d5 = ((double)(n2 + 16) - (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d9 = d6;
            d10 = d5;
            d5 = d6;
            d6 = d10;
            d11 = d8;
            d12 = d7;
        } else if (this.uvRotateTop == 3) {
            d5 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d6 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d7 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d9 = d6;
            d10 = d5;
            d11 = d7;
            d12 = d8;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.ay;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d14, (float)d15, (float)d17, (float)d6, (float)d8);
        c_d.a((float)d14, (float)d15, (float)d16, (float)d9, (float)d11);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d5, (float)d7);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d10, (float)d12);
    }

    public void renderEastFace(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d8 = ((double)n3 + (double)c_x.av * 16.0) / 512.0;
        double d9 = ((double)n3 + (double)c_x.ay * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateEast == 2) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateEast == 1) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateEast == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.av;
        double d16 = d3 + (double)c_x.ay;
        double d17 = d4 + (double)c_x.aw;
        c_d.a((float)d13, (float)d16, (float)d17, (float)d5, (float)d11);
        c_d.a((float)d14, (float)d16, (float)d17, (float)d6, (float)d8);
        c_d.a((float)d14, (float)d15, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d7, (float)d9);
    }

    public void renderWestFace(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d8 = ((double)n3 + (double)c_x.av * 16.0) / 512.0;
        double d9 = ((double)n3 + (double)c_x.ay * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateWest == 1) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d11 = d8 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateWest == 2) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateWest == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.av;
        double d16 = d3 + (double)c_x.ay;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d16, (float)d17, (float)d6, (float)d8);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d14, (float)d15, (float)d17, (float)d7, (float)d9);
        c_d.a((float)d14, (float)d16, (float)d17, (float)d5, (float)d11);
    }

    public void renderNorthFace(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        double d8 = ((double)n3 + (double)c_x.av * 16.0) / 512.0;
        double d9 = ((double)n3 + (double)c_x.ay * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateNorth == 1) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateNorth == 2) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.az * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateNorth == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d3 + (double)c_x.av;
        double d15 = d3 + (double)c_x.ay;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d15, (float)d17, (float)d5, (float)d11);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d6, (float)d8);
        c_d.a((float)d13, (float)d14, (float)d16, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d14, (float)d17, (float)d7, (float)d9);
    }

    public void renderSouthFace(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        double d8 = ((double)n3 + (double)c_x.av * 16.0) / 512.0;
        double d9 = ((double)n3 + (double)c_x.ay * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateSouth == 2) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.az * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateSouth == 1) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateSouth == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.ax;
        double d14 = d3 + (double)c_x.av;
        double d15 = d3 + (double)c_x.ay;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d14, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d14, (float)d16, (float)d7, (float)d9);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d5, (float)d11);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d6, (float)d8);
    }

    public void renderEastFaceNew(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d8 = ((double)(n3 + 16) - (double)c_x.ay * 16.0) / 512.0;
        double d9 = ((double)(n3 + 16) - (double)c_x.av * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateEast == 2) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateEast == 1) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateEast == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.av;
        double d16 = d3 + (double)c_x.ay;
        double d17 = d4 + (double)c_x.aw;
        c_d.a((float)d13, (float)d16, (float)d17, (float)d5, (float)d11);
        c_d.a((float)d14, (float)d16, (float)d17, (float)d6, (float)d8);
        c_d.a((float)d14, (float)d15, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d7, (float)d9);
    }

    public void renderWestFaceNew(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.au * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.ax * 16.0 - 0.01) / 512.0;
        double d8 = ((double)(n3 + 16) - (double)c_x.ay * 16.0) / 512.0;
        double d9 = ((double)(n3 + 16) - (double)c_x.av * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.au < 0.0 || (double)c_x.ax > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateWest == 1) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d11 = d8 = ((double)(n3 + 16) - (double)c_x.ax * 16.0) / 512.0;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateWest == 2) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.ax * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateWest == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.au * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.ax * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d2 + (double)c_x.ax;
        double d15 = d3 + (double)c_x.av;
        double d16 = d3 + (double)c_x.ay;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d16, (float)d17, (float)d6, (float)d8);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d14, (float)d15, (float)d17, (float)d7, (float)d9);
        c_d.a((float)d14, (float)d16, (float)d17, (float)d5, (float)d11);
    }

    public void renderNorthFaceNew(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        double d8 = ((double)(n3 + 16) - (double)c_x.ay * 16.0) / 512.0;
        double d9 = ((double)(n3 + 16) - (double)c_x.av * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateNorth == 1) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateNorth == 2) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.az * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateNorth == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.au;
        double d14 = d3 + (double)c_x.av;
        double d15 = d3 + (double)c_x.ay;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d15, (float)d17, (float)d5, (float)d11);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d6, (float)d8);
        c_d.a((float)d13, (float)d14, (float)d16, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d14, (float)d17, (float)d7, (float)d9);
    }

    public void renderSouthFaceNew(C_x c_x, double d2, double d3, double d4, int n) {
        double d5;
        C_d c_d = C_d.a;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        double d6 = ((double)n2 + (double)c_x.aw * 16.0) / 512.0;
        double d7 = ((double)n2 + (double)c_x.az * 16.0 - 0.01) / 512.0;
        double d8 = ((double)(n3 + 16) - (double)c_x.ay * 16.0) / 512.0;
        double d9 = ((double)(n3 + 16) - (double)c_x.av * 16.0 - 0.01) / 512.0;
        if (this.flipTexture) {
            d5 = d6;
            d6 = d7;
            d7 = d5;
        }
        if ((double)c_x.aw < 0.0 || (double)c_x.az > 1.0) {
            d6 = ((float)n2 + 0.0f) / 512.0f;
            d7 = ((float)n2 + 15.99f) / 512.0f;
        }
        if ((double)c_x.av < 0.0 || (double)c_x.ay > 1.0) {
            d8 = ((float)n3 + 0.0f) / 512.0f;
            d9 = ((float)n3 + 15.99f) / 512.0f;
        }
        d5 = d7;
        double d10 = d6;
        double d11 = d8;
        double d12 = d9;
        if (this.uvRotateSouth == 2) {
            d6 = ((double)n2 + (double)c_x.av * 16.0) / 512.0;
            d8 = ((double)(n3 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)n2 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)(n3 + 16) - (double)c_x.az * 16.0) / 512.0;
            d11 = d8;
            d12 = d9;
            d5 = d6;
            d10 = d7;
            d8 = d9;
            d9 = d11;
        } else if (this.uvRotateSouth == 1) {
            d6 = ((double)(n2 + 16) - (double)c_x.ay * 16.0) / 512.0;
            d8 = ((double)n3 + (double)c_x.az * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.av * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.aw * 16.0) / 512.0;
            d5 = d7;
            d10 = d6;
            d6 = d7;
            d7 = d10;
            d11 = d9;
            d12 = d8;
        } else if (this.uvRotateSouth == 3) {
            d6 = ((double)(n2 + 16) - (double)c_x.aw * 16.0) / 512.0;
            d7 = ((double)(n2 + 16) - (double)c_x.az * 16.0 - 0.01) / 512.0;
            d8 = ((double)n3 + (double)c_x.ay * 16.0) / 512.0;
            d9 = ((double)n3 + (double)c_x.av * 16.0 - 0.01) / 512.0;
            d5 = d7;
            d10 = d6;
            d11 = d8;
            d12 = d9;
        }
        double d13 = d2 + (double)c_x.ax;
        double d14 = d3 + (double)c_x.av;
        double d15 = d3 + (double)c_x.ay;
        double d16 = d4 + (double)c_x.aw;
        double d17 = d4 + (double)c_x.az;
        c_d.a((float)d13, (float)d14, (float)d17, (float)d10, (float)d12);
        c_d.a((float)d13, (float)d14, (float)d16, (float)d7, (float)d9);
        c_d.a((float)d13, (float)d15, (float)d16, (float)d5, (float)d11);
        c_d.a((float)d13, (float)d15, (float)d17, (float)d6, (float)d8);
    }

    public final void renderBlockOnInventory(C_x c_x, int n) {
        C_d c_d = C_d.a;
        int n2 = c_x.a();
        if (n2 == 0 || n2 == 17 || n2 == 22 || n2 == 24 || n2 == 33 || n2 == 200 || n2 == 36) {
            c_x.setBlockBoundsForItemRender(n);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0, n));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1, n));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2, n));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3, n));
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4, n));
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5, n));
            c_d.a();
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        } else if (n2 == 34) {
            for (int i = 0; i < 2; ++i) {
                int n3 = c_x.as;
                if (i == 0) {
                    c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                }
                if (i == 1) {
                    c_x.a(0.2f, 0.2f, 0.2f, 0.8f, 0.8f, 0.8f);
                    ++n3;
                }
                c_x.setBlockBoundsForItemRender(n);
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, n3);
                c_d.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            }
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (n2 == 27) {
            c_x.setBlockBoundsForItemRender(n);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3));
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4));
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5));
            c_d.a();
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        } else if (n2 == 31 || n2 == 32) {
            c_x.setBlockBoundsForItemRender(n);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            float f = 0.0625f;
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0, n));
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            c_x.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1, n));
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.addTranslation(0.0f, 0.0f, f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2, n));
            c_d.addTranslation(0.0f, 0.0f, -f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.addTranslation(0.0f, 0.0f, -f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3, n));
            c_d.addTranslation(0.0f, 0.0f, f);
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            c_d.addTranslation(f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4, n));
            c_d.addTranslation(-f, 0.0f, 0.0f);
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            c_d.addTranslation(-f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5, n));
            c_d.addTranslation(f, 0.0f, 0.0f);
            c_d.a();
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        } else if (n2 == 35) {
            c_x.setBlockBoundsForItemRender(n);
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0, n));
            if (n == 1) {
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1, n));
            if (n == 1) {
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2, n));
            if (n == 1) {
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3, n));
            if (n == 1) {
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4, n));
            if (n == 1) {
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5, n));
            if (n == 1) {
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, 260);
            }
            c_d.a();
            GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
        } else if (n2 == 23) {
            for (int i = 0; i < 2; ++i) {
                if (i == 0) {
                    c_x.a(0.0f, 0.0f, 0.3125f, 1.0f, 0.8125f, 0.6875f);
                }
                if (i == 1) {
                    c_x.a(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
                }
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3, n));
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4, n));
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5, n));
                c_d.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            }
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (n2 == 1) {
            c_d.b();
            this.a(c_x, -1, -0.5f, -0.5f, -0.5f);
            c_d.a();
        } else if (n2 == 6) {
            c_d.b();
            this.b(c_x, -1, -0.5f, -0.5f, -0.5f);
            c_d.a();
        } else if (n2 == 14) {
            this.renderBlockChairForInventory(c_x, -0.5f, -0.6f, -0.5f);
        } else if (n2 == 15) {
            this.renderBlockTableForInventory(c_x, -0.5f, -0.6f, -0.5f, n);
        } else if (n2 == 29) {
            GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3));
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4));
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5));
            c_d.a();
            c_x.a(0.325f, 0.0f, 0.325f, 0.675f, 0.1f, 0.675f);
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, 38);
            c_d.a();
            c_x.a(0.41666666f, 0.0f, 0.41666666f, 0.5833333f, 1.0f, 0.5833333f);
        } else if (n2 == 12) {
            for (int i = 0; i < 2; ++i) {
                if (i == 0) {
                    c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                }
                if (i == 1) {
                    c_x.a(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
                }
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3));
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4));
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5));
                c_d.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            }
        } else if (n2 == 11) {
            for (int i = 0; i < 4; ++i) {
                float f = 0.125f;
                if (i == 0) {
                    c_x.a(0.5f - f, 0.0f, 0.0f, 0.5f + f, 1.0f, f * 2.0f);
                }
                if (i == 1) {
                    c_x.a(0.5f - f, 0.0f, 1.0f - f * 2.0f, 0.5f + f, 1.0f, 1.0f);
                }
                f = 0.0625f;
                if (i == 2) {
                    c_x.a(0.5f - f, 1.0f - f * 3.0f, -f * 2.0f, 0.5f + f, 1.0f - f, 1.0f + f * 2.0f);
                }
                if (i == 3) {
                    c_x.a(0.5f - f, 0.5f - f * 3.0f, -f * 2.0f, 0.5f + f, 0.5f - f, 1.0f + f * 2.0f);
                }
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2, n));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3, n));
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4, n));
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5, n));
                c_d.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            }
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (n2 == 16) {
            for (int i = 0; i < 3; ++i) {
                float f = 0.0625f;
                if (i == 0) {
                    c_x.a(0.5f - f, 0.3f, 0.0f, 0.5f + f, 1.0f, f * 2.0f);
                }
                if (i == 1) {
                    c_x.a(0.5f - f, 0.3f, 1.0f - f * 2.0f, 0.5f + f, 1.0f, 1.0f);
                }
                if (i == 2) {
                    c_x.a(0.5f - f, 0.5f, 0.125f, 0.5f + f, 0.987f - f, 0.875f);
                }
                GL11.glTranslatef((float)-0.5f, (float)-0.5f, (float)-0.5f);
                c_d.b();
                C_d.c(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 1.0f, 0.0f);
                this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, -1.0f);
                this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
                c_d.a();
                c_d.b();
                C_d.c(0.0f, 0.0f, 1.0f);
                this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3));
                c_d.a();
                c_d.b();
                C_d.c(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4));
                c_d.a();
                c_d.b();
                C_d.c(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5));
                c_d.a();
                GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
            }
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (n2 == 2) {
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            this.a(c_x, -0.5f, -0.5f, -0.5f, 0.0f, 0.0f);
            c_d.a();
        }
    }

    public void renderBlocksForLogo(C_x c_x, float f) {
        int n = c_x.a();
        C_d c_d = C_d.a;
        if (n == 0) {
            GL11.glTranslatef((float)-0.4f, (float)-0.4f, (float)-0.4f);
            float f2 = 0.5f;
            float f3 = 1.0f;
            float f4 = 0.8f;
            float f5 = 0.6f;
            c_d.b();
            c_d.a(f3, f3, f3, f);
            this.renderBottomFace(c_x, 0.0, 0.0, 0.0, c_x.a(0));
            c_d.a(f2, f2, f2, f);
            this.renderTopFace(c_x, 0.0, 0.0, 0.0, c_x.a(1));
            c_d.a(f4, f4, f4, f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
            this.renderWestFace(c_x, 0.0, 0.0, 0.0, c_x.a(3));
            c_d.a(f5, f5, f5, f);
            this.renderNorthFace(c_x, 0.0, 0.0, 0.0, c_x.a(4));
            this.renderSouthFace(c_x, 0.0, 0.0, 0.0, c_x.a(5));
            c_d.a();
            GL11.glTranslatef((float)0.4f, (float)0.4f, (float)0.4f);
        }
    }

    public void renderShadow(C_x c_x, float f) {
        int n = c_x.a();
        C_d c_d = C_d.a;
        if (n == 0) {
            GL11.glTranslatef((float)-0.4f, (float)-0.4f, (float)-0.4f);
            float f2 = 1.0f;
            c_d.b();
            c_d.a(f2, f2, f2, f);
            this.renderEastFace(c_x, 0.0, 0.0, 0.0, c_x.a(2));
            c_d.a();
            GL11.glTranslatef((float)0.4f, (float)0.4f, (float)0.4f);
        }
    }

    public boolean renderBlockChairForInventory(C_x c_x, float f, float f2, float f3) {
        C_d c_d = C_d.a;
        int n = c_x.as;
        if (this.b >= 0) {
            n = this.b;
        }
        int n2 = (n & 0x1F) << 4;
        int n3 = n >> 1 & 0x1F0;
        byte by = 1;
        if (this.a != null) {
            by = this.a.e((int)f, (int)f2, (int)f3);
        }
        c_d.a(1.0f, 1.0f, 1.0f);
        float f4 = (float)n2 / 512.0f;
        float f5 = (float)n3 / 512.0f;
        c_d.b();
        C_d.c(-1.0f, 0.0f, 0.0f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.015625f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.015625f);
        c_d.a();
        c_d.b();
        C_d.c(1.0f, 0.0f, 0.0f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.015625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.015625f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 0.0f, -1.0f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.015625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.01953125f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.015625f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 0.0f, 1.0f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.015625f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.01953125f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.015625f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 1.0f, 0.0f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.00390625f);
        c_d.a(f + 0.125f, f2 + 0.5f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.02734375f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.02734375f);
        c_d.a(f + 0.875f, f2 + 0.5f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.00390625f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, -1.0f, 0.0f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.875f, f4 + 0.00390625f, f5 + 0.02734375f);
        c_d.a(f + 0.125f, f2 + 0.375f, f3 + 0.125f, f4 + 0.00390625f, f5 + 0.00390625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.125f, f4 + 0.02734375f, f5 + 0.00390625f);
        c_d.a(f + 0.875f, f2 + 0.375f, f3 + 0.875f, f4 + 0.02734375f, f5 + 0.02734375f);
        c_d.a();
        for (int i = 0; i < 4; ++i) {
            int n4 = i;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            if (i >= 2) {
                n4 -= 2;
                n5 = 1;
            }
            if (n4 == 0) {
                n6 = 1;
            }
            if (n5 == 0) {
                n7 = 1;
            }
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(2 + n7 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(2 + n7 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(4 + n7 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(4 + n7 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(2 + n6 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(2 + n6 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(4 + n6 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(4 + n6 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(2 + n4 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(2 + n4 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(4 + n4 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2 + 0.375f, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(4 + n4 * 10) / 512.0f, f5 + 0.01953125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(2 + n4 * 10) / 512.0f, f5 + (float)(4 + n5 * 10) / 512.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(2 + n4 * 10) / 512.0f, f5 + (float)(2 + n5 * 10) / 512.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.125f + 0.625f * (float)n5, f4 + (float)(4 + n4 * 10) / 512.0f, f5 + (float)(2 + n5 * 10) / 512.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n4, f2, f3 + 0.25f + 0.625f * (float)n5, f4 + (float)(4 + n4 * 10) / 512.0f, f5 + (float)(4 + n5 * 10) / 512.0f);
            c_d.a();
        }
        if (by >= 1 && by <= 4) {
            float f6 = 0.125f;
            float f7 = 0.875f;
            float f8 = 0.125f;
            float f9 = 0.25f;
            float f10 = 0.00390625f;
            float f11 = 0.02734375f;
            float f12 = 0.00390625f;
            float f13 = 0.02734375f;
            float f14 = 0.00390625f;
            float f15 = 0.0078125f;
            float f16 = 0.0234375f;
            float f17 = 0.02734375f;
            if (by == 2) {
                f8 = 0.75f;
                f9 = 0.875f;
                f14 = 0.0234375f;
                f15 = 0.02734375f;
                f16 = 0.00390625f;
                f17 = 0.0078125f;
            }
            if (by > 2) {
                f6 = 0.125f;
                f7 = 0.25f;
                f8 = 0.125f;
                f9 = 0.875f;
                f10 = 0.0234375f;
                f11 = 0.02734375f;
                f12 = 0.00390625f;
                f13 = 0.0078125f;
                f14 = 0.00390625f;
                f15 = 0.02734375f;
                f16 = 0.00390625f;
                f17 = 0.02734375f;
                if (by == 4) {
                    f6 = 0.75f;
                    f7 = 0.875f;
                    f10 = 0.00390625f;
                    f11 = 0.0078125f;
                    f12 = 0.0234375f;
                    f13 = 0.02734375f;
                }
            }
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            c_d.a(f + f6, f2 + 1.0f, f3 + f8, f4 + f14, f5);
            c_d.a(f + f6, f2 + 0.5f, f3 + f8, f4 + f14, f5 + 0.015625f);
            c_d.a(f + f6, f2 + 0.5f, f3 + f9, f4 + f15, f5 + 0.015625f);
            c_d.a(f + f6, f2 + 1.0f, f3 + f9, f4 + f15, f5);
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f4 + f16, f5);
            c_d.a(f + f7, f2 + 0.5f, f3 + f9, f4 + f16, f5 + 0.015625f);
            c_d.a(f + f7, f2 + 0.5f, f3 + f8, f4 + f17, f5 + 0.015625f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f8, f4 + f17, f5);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f8, f4 + f10, f5);
            c_d.a(f + f7, f2 + 0.5f, f3 + f8, f4 + f10, f5 + 0.015625f);
            c_d.a(f + f6, f2 + 0.5f, f3 + f8, f4 + f11, f5 + 0.015625f);
            c_d.a(f + f6, f2 + 1.0f, f3 + f8, f4 + f11, f5);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.a(f + f6, f2 + 1.0f, f3 + f9, f4 + f12, f5);
            c_d.a(f + f6, f2 + 0.5f, f3 + f9, f4 + f12, f5 + 0.015625f);
            c_d.a(f + f7, f2 + 0.5f, f3 + f9, f4 + f13, f5 + 0.015625f);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f4 + f13, f5);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 1.0f, 0.0f);
            c_d.a(f + f6, f2 + 1.0f, f3 + f8, f4 + f12, f5 + f14);
            c_d.a(f + f6, f2 + 1.0f, f3 + f9, f4 + f12, f5 + f15);
            c_d.a(f + f7, f2 + 1.0f, f3 + f9, f4 + f13, f5 + f15);
            c_d.a(f + f7, f2 + 1.0f, f3 + f8, f4 + f13, f5 + f14);
            c_d.a();
        }
        return true;
    }

    public boolean renderBlockTableForInventory(C_x c_x, float f, float f2, float f3, int n) {
        C_d c_d = C_d.a;
        int n2 = c_x.a(0, n);
        if (this.b >= 0) {
            n2 = this.b;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        c_d.a(1.0f, 1.0f, 1.0f);
        float f4 = (float)n3 / 512.0f;
        float f5 = (float)n4 / 512.0f;
        c_d.b();
        C_d.c(-1.0f, 0.0f, 0.0f);
        c_d.a(f, f2 + 1.0f, f3, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f, f2 + 0.75f, f3, f4 + 0.0f, f5 + 0.0078125f);
        c_d.a(f, f2 + 0.75f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.0078125f);
        c_d.a(f, f2 + 1.0f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.0f);
        c_d.a();
        c_d.b();
        C_d.c(1.0f, 0.0f, 0.0f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f4 + 0.0f, f5 + 0.0078125f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3, f4 + 0.03125f, f5 + 0.0078125f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3, f4 + 0.03125f, f5 + 0.0f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 0.0f, -1.0f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3, f4 + 0.0f, f5 + 0.0078125f);
        c_d.a(f, f2 + 0.75f, f3, f4 + 0.03125f, f5 + 0.0078125f);
        c_d.a(f, f2 + 1.0f, f3, f4 + 0.03125f, f5 + 0.0f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 0.0f, 1.0f);
        c_d.a(f, f2 + 1.0f, f3 + 1.0f, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f, f2 + 0.75f, f3 + 1.0f, f4 + 0.0f, f5 + 0.0078125f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.0078125f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.0f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, 1.0f, 0.0f);
        c_d.a(f, f2 + 1.0f, f3, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f, f2 + 1.0f, f3 + 1.0f, f4 + 0.0f, f5 + 0.03125f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.03125f);
        c_d.a(f + 1.0f, f2 + 1.0f, f3, f4 + 0.03125f, f5 + 0.0f);
        c_d.a();
        c_d.b();
        C_d.c(0.0f, -1.0f, 0.0f);
        c_d.a(f, f2 + 0.75f, f3 + 1.0f, f4 + 0.0f, f5 + 0.03125f);
        c_d.a(f, f2 + 0.75f, f3, f4 + 0.0f, f5 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3, f4 + 0.03125f, f5 + 0.0f);
        c_d.a(f + 1.0f, f2 + 0.75f, f3 + 1.0f, f4 + 0.03125f, f5 + 0.03125f);
        c_d.a();
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        if (this.a != null) {
            bl &= this.a.a((int)f - 1, (int)f2, (int)f3) != C_x.table.at;
            bl &= this.a.a((int)f, (int)f2, (int)f3 - 1) != C_x.table.at;
            bl2 &= this.a.a((int)f + 1, (int)f2, (int)f3) != C_x.table.at;
            bl2 &= this.a.a((int)f, (int)f2, (int)f3 - 1) != C_x.table.at;
            bl3 &= this.a.a((int)f - 1, (int)f2, (int)f3) != C_x.table.at;
            bl3 &= this.a.a((int)f, (int)f2, (int)f3 + 1) != C_x.table.at;
            bl4 &= this.a.a((int)f + 1, (int)f2, (int)f3) != C_x.table.at;
            bl4 &= this.a.a((int)f, (int)f2, (int)f3 + 1) != C_x.table.at;
        }
        boolean[] blArray = new boolean[]{bl, bl2, bl3, bl4};
        for (int i = 0; i < 4; ++i) {
            if (!blArray[i]) continue;
            int n5 = i;
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            if (i >= 2) {
                n5 -= 2;
                n6 = 1;
            }
            if (n5 == 0) {
                n7 = 1;
            }
            if (n6 == 0) {
                n8 = 1;
            }
            c_d.b();
            C_d.c(-1.0f, 0.0f, 0.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(2 + n6 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(2 + n6 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(4 + n6 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(4 + n6 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a();
            c_d.b();
            C_d.c(1.0f, 0.0f, 0.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(2 + n8 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(2 + n8 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(4 + n8 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(4 + n8 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, -1.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(2 + n7 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(2 + n7 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(4 + n7 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(4 + n7 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, 0.0f, 1.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + 0.03125f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2 + 0.75f, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + 0.0078125f);
            c_d.a();
            c_d.b();
            C_d.c(0.0f, -1.0f, 0.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + (float)(4 + n6 * 10) / 512.0f);
            c_d.a(f + 0.125f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(2 + n5 * 10) / 512.0f, f5 + (float)(2 + n6 * 10) / 512.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.125f + 0.625f * (float)n6, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + (float)(2 + n6 * 10) / 512.0f);
            c_d.a(f + 0.25f + 0.625f * (float)n5, f2, f3 + 0.25f + 0.625f * (float)n6, f4 + (float)(4 + n5 * 10) / 512.0f, f5 + (float)(4 + n6 * 10) / 512.0f);
            c_d.a();
        }
        return true;
    }

    public void renderPistonBaseAllFaces(C_x c_x, int n, int n2, int n3) {
        this.c = true;
        this.renderPistonBase(c_x, n, n2, n3, true);
        this.c = false;
    }

    private boolean renderPistonBase(C_x c_x, int n, int n2, int n3, boolean bl) {
        byte by = this.a.e(n, n2, n3);
        boolean bl2 = bl || (by & 8) != 0;
        int n4 = BlockPistonBase.getOrientation(by);
        if (bl2) {
            switch (n4) {
                case 0: {
                    this.uvRotateEast = 3;
                    this.uvRotateWest = 3;
                    this.uvRotateSouth = 3;
                    this.uvRotateNorth = 3;
                    c_x.a(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                    break;
                }
                case 2: {
                    this.uvRotateSouth = 1;
                    this.uvRotateNorth = 2;
                    c_x.a(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.uvRotateSouth = 2;
                    this.uvRotateNorth = 1;
                    this.uvRotateTop = 3;
                    this.uvRotateBottom = 3;
                    c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                    break;
                }
                case 4: {
                    this.uvRotateEast = 1;
                    this.uvRotateWest = 2;
                    this.uvRotateTop = 2;
                    this.uvRotateBottom = 1;
                    c_x.a(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 5: {
                    this.uvRotateEast = 2;
                    this.uvRotateWest = 1;
                    this.uvRotateTop = 1;
                    this.uvRotateBottom = 2;
                    c_x.a(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                }
            }
            this.renderStandardBlockNew(c_x, n, n2, n3);
            this.uvRotateEast = 0;
            this.uvRotateWest = 0;
            this.uvRotateSouth = 0;
            this.uvRotateNorth = 0;
            this.uvRotateTop = 0;
            this.uvRotateBottom = 0;
            c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            switch (n4) {
                case 0: {
                    this.uvRotateEast = 3;
                    this.uvRotateWest = 3;
                    this.uvRotateSouth = 3;
                    this.uvRotateNorth = 3;
                }
                default: {
                    break;
                }
                case 2: {
                    this.uvRotateSouth = 1;
                    this.uvRotateNorth = 2;
                    break;
                }
                case 3: {
                    this.uvRotateSouth = 2;
                    this.uvRotateNorth = 1;
                    this.uvRotateTop = 3;
                    this.uvRotateBottom = 3;
                    break;
                }
                case 4: {
                    this.uvRotateEast = 1;
                    this.uvRotateWest = 2;
                    this.uvRotateTop = 2;
                    this.uvRotateBottom = 1;
                    break;
                }
                case 5: {
                    this.uvRotateEast = 2;
                    this.uvRotateWest = 1;
                    this.uvRotateTop = 1;
                    this.uvRotateBottom = 2;
                }
            }
            this.renderStandardBlockNew(c_x, n, n2, n3);
            this.uvRotateEast = 0;
            this.uvRotateWest = 0;
            this.uvRotateSouth = 0;
            this.uvRotateNorth = 0;
            this.uvRotateTop = 0;
            this.uvRotateBottom = 0;
        }
        return true;
    }

    private void renderPistonRodUD(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        int n2 = n;
        if (this.b >= 0) {
            n2 = this.b;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        C_d c_d = C_d.a;
        float f9 = (float)(n3 + 0) / 512.0f;
        float f10 = (float)(n4 + 0) / 512.0f;
        float f11 = ((float)n3 + f8 - 0.01f) / 512.0f;
        float f12 = ((float)n4 + 4.0f - 0.01f) / 512.0f;
        c_d.a(f7, f7, f7);
        c_d.a(f, f4, f5, f11, f10);
        c_d.a(f, f3, f5, f9, f10);
        c_d.a(f2, f3, f6, f9, f12);
        c_d.a(f2, f4, f6, f11, f12);
    }

    private void renderPistonRodSN(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        int n2 = n;
        if (this.b >= 0) {
            n2 = this.b;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        C_d c_d = C_d.a;
        float f9 = (float)(n3 + 0) / 512.0f;
        float f10 = (float)(n4 + 0) / 512.0f;
        float f11 = ((float)n3 + f8 - 0.01f) / 512.0f;
        float f12 = ((float)n4 + 4.0f - 0.01f) / 512.0f;
        c_d.a(f7, f7, f7);
        c_d.a(f, f3, f6, f11, f10);
        c_d.a(f, f3, f5, f9, f10);
        c_d.a(f2, f4, f5, f9, f12);
        c_d.a(f2, f4, f6, f11, f12);
    }

    private void renderPistonRodEW(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        int n2 = n;
        if (this.b >= 0) {
            n2 = this.b;
        }
        int n3 = (n2 & 0x1F) << 4;
        int n4 = n2 >> 1 & 0x1F0;
        C_d c_d = C_d.a;
        float f9 = (float)(n3 + 0) / 512.0f;
        float f10 = (float)(n4 + 0) / 512.0f;
        float f11 = ((float)n3 + f8 - 0.01f) / 512.0f;
        float f12 = ((float)n4 + 4.0f - 0.01f) / 512.0f;
        c_d.a(f7, f7, f7);
        c_d.a(f2, f3, f5, f11, f10);
        c_d.a(f, f3, f5, f9, f10);
        c_d.a(f, f4, f6, f9, f12);
        c_d.a(f2, f4, f6, f11, f12);
    }

    public void renderPistonExtensionAllFaces(C_x c_x, int n, int n2, int n3, boolean bl) {
        this.c = true;
        this.renderPistonExtension(c_x, n, n2, n3, bl);
        this.c = false;
    }

    private boolean renderPistonExtension(C_x c_x, int n, int n2, int n3, boolean bl) {
        byte by = this.a.e(n, n2, n3);
        int n4 = BlockPistonExtension.getDirectionMeta(by);
        float f = c_x.f(this.a, n, n2, n3);
        int n5 = c_x.a(n4, by);
        float f2 = bl ? 1.0f : 0.5f;
        float f3 = bl ? 16.0f : 8.0f;
        switch (n4) {
            case 0: {
                this.uvRotateEast = 3;
                this.uvRotateWest = 3;
                this.uvRotateSouth = 3;
                this.uvRotateNorth = 3;
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodUD((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f2, (float)n3 + 0.625f, (float)n3 + 0.625f, f * 0.8f, f3, n5);
                this.renderPistonRodUD((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f2, (float)n3 + 0.375f, (float)n3 + 0.375f, f * 0.8f, f3, n5);
                this.renderPistonRodUD((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.25f, (float)n2 + 0.25f + f2, (float)n3 + 0.375f, (float)n3 + 0.625f, f * 0.6f, f3, n5);
                this.renderPistonRodUD((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.25f, (float)n2 + 0.25f + f2, (float)n3 + 0.625f, (float)n3 + 0.375f, f * 0.6f, f3, n5);
                break;
            }
            case 1: {
                c_x.a(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodUD((float)n + 0.375f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f2, (float)n2 - 0.25f + 1.0f, (float)n3 + 0.625f, (float)n3 + 0.625f, f * 0.8f, f3, n5);
                this.renderPistonRodUD((float)n + 0.625f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f2, (float)n2 - 0.25f + 1.0f, (float)n3 + 0.375f, (float)n3 + 0.375f, f * 0.8f, f3, n5);
                this.renderPistonRodUD((float)n + 0.375f, (float)n + 0.375f, (float)n2 - 0.25f + 1.0f - f2, (float)n2 - 0.25f + 1.0f, (float)n3 + 0.375f, (float)n3 + 0.625f, f * 0.6f, f3, n5);
                this.renderPistonRodUD((float)n + 0.625f, (float)n + 0.625f, (float)n2 - 0.25f + 1.0f - f2, (float)n2 - 0.25f + 1.0f, (float)n3 + 0.625f, (float)n3 + 0.375f, f * 0.6f, f3, n5);
                break;
            }
            case 2: {
                this.uvRotateSouth = 1;
                this.uvRotateNorth = 2;
                c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodSN((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f2, f * 0.6f, f3, n5);
                this.renderPistonRodSN((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f2, f * 0.6f, f3, n5);
                this.renderPistonRodSN((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.25f, (float)n3 + 0.25f + f2, f * 0.5f, f3, n5);
                this.renderPistonRodSN((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.25f, (float)n3 + 0.25f + f2, f, f3, n5);
                break;
            }
            case 3: {
                this.uvRotateSouth = 2;
                this.uvRotateNorth = 1;
                this.uvRotateTop = 3;
                this.uvRotateBottom = 3;
                c_x.a(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodSN((float)n + 0.375f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f2, (float)n3 - 0.25f + 1.0f, f * 0.6f, f3, n5);
                this.renderPistonRodSN((float)n + 0.625f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f2, (float)n3 - 0.25f + 1.0f, f * 0.6f, f3, n5);
                this.renderPistonRodSN((float)n + 0.375f, (float)n + 0.625f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 - 0.25f + 1.0f - f2, (float)n3 - 0.25f + 1.0f, f * 0.5f, f3, n5);
                this.renderPistonRodSN((float)n + 0.625f, (float)n + 0.375f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 - 0.25f + 1.0f - f2, (float)n3 - 0.25f + 1.0f, f, f3, n5);
                break;
            }
            case 4: {
                this.uvRotateEast = 1;
                this.uvRotateWest = 2;
                this.uvRotateTop = 2;
                this.uvRotateBottom = 1;
                c_x.a(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodEW((float)n + 0.25f, (float)n + 0.25f + f2, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f * 0.5f, f3, n5);
                this.renderPistonRodEW((float)n + 0.25f, (float)n + 0.25f + f2, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f, f3, n5);
                this.renderPistonRodEW((float)n + 0.25f, (float)n + 0.25f + f2, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f * 0.6f, f3, n5);
                this.renderPistonRodEW((float)n + 0.25f, (float)n + 0.25f + f2, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f * 0.6f, f3, n5);
                break;
            }
            case 5: {
                this.uvRotateEast = 2;
                this.uvRotateWest = 1;
                this.uvRotateTop = 1;
                this.uvRotateBottom = 2;
                c_x.a(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                this.renderStandardBlockNew(c_x, n, n2, n3);
                this.renderPistonRodEW((float)n - 0.25f + 1.0f - f2, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.375f, f * 0.5f, f3, n5);
                this.renderPistonRodEW((float)n - 0.25f + 1.0f - f2, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.625f, f, f3, n5);
                this.renderPistonRodEW((float)n - 0.25f + 1.0f - f2, (float)n - 0.25f + 1.0f, (float)n2 + 0.375f, (float)n2 + 0.625f, (float)n3 + 0.375f, (float)n3 + 0.375f, f * 0.6f, f3, n5);
                this.renderPistonRodEW((float)n - 0.25f + 1.0f - f2, (float)n - 0.25f + 1.0f, (float)n2 + 0.625f, (float)n2 + 0.375f, (float)n3 + 0.625f, (float)n3 + 0.625f, f * 0.6f, f3, n5);
            }
        }
        this.uvRotateEast = 0;
        this.uvRotateWest = 0;
        this.uvRotateSouth = 0;
        this.uvRotateNorth = 0;
        this.uvRotateTop = 0;
        this.uvRotateBottom = 0;
        c_x.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return true;
    }

    public void setOverrideBlockTexture(int n) {
        this.b = n;
    }

    public void clearOverrideBlockTexture() {
        this.b = -1;
    }

    public static boolean renderItemIn3d(int n) {
        return n == 0 ? true : (n == 200 ? true : (n == 36 ? true : (n == -1 ? true : (n == 15 ? true : (n == 28 ? true : (n == 22 ? true : (n == 34 ? true : (n == 23 ? true : (n == 24 ? true : (n == 29 ? true : (n == 31 ? true : (n == 32 ? true : (n == 33 ? true : (n == 35 ? true : (n == 10 ? true : (n == 7 ? true : (n == 11 ? true : (n == 14 ? true : (n == 12 ? true : (n == 17 ? true : (n == 16 ? true : n == 27)))))))))))))))))))));
    }
}

