/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_ae;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.AchievementList;

public class C_bk
extends C_ae {
    public static final float[][] colorTable = new float[][]{{1.0f, 0.25f, 0.25f}, {1.0f, 0.625f, 0.25f}, {1.0f, 1.0f, 0.25f}, {0.625f, 1.0f, 0.25f}, {0.25f, 1.0f, 0.25f}, {0.25f, 1.0f, 0.625f}, {0.25f, 1.0f, 1.0f}, {0.4f, 0.7f, 1.0f}, {0.5f, 0.5f, 1.0f}, {0.625f, 0.25f, 1.0f}, {0.75f, 0.375f, 1.0f}, {1.0f, 0.25f, 1.0f}, {1.0f, 0.25f, 0.625f}, {0.3f, 0.3f, 0.3f}, {0.6f, 0.6f, 0.6f}, {1.0f, 1.0f, 1.0f}};

    public C_bk(int n, int n2) {
        super(n, n2, Material.portal, false);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public final boolean canCollideCheck(int n, boolean bl) {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        if (c_g.a(n - 1, n2, n3) != this.at && c_g.a(n + 1, n2, n3) != this.at) {
            float f = 0.125f;
            float f2 = 0.5f;
            this.a(0.5f - f, 0.0f, 0.5f - f2, 0.5f + f, 1.0f, 0.5f + f2);
        } else {
            float f = 0.5f;
            float f3 = 0.125f;
            this.a(0.5f - f, 0.0f, 0.5f - f3, 0.5f + f, 1.0f, 0.5f + f3);
        }
    }

    @Override
    public int a(int n, int n2) {
        return this.as + n2;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean tryToCreatePortal(World c_g, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6 = 0;
        int n7 = 0;
        if (c_g.a(n - 1, n2, n3) == Block.ae.at || c_g.a(n + 1, n2, n3) == Block.ae.at) {
            n6 = 1;
        }
        if (c_g.a(n, n2, n3 - 1) == Block.ae.at || c_g.a(n, n2, n3 + 1) == Block.ae.at) {
            n7 = 1;
        }
        if (n6 == n7) {
            return false;
        }
        if (c_g.a(n - n6, n2, n3 - n7) == 0) {
            n -= n6;
            n3 -= n7;
        }
        for (n5 = -1; n5 <= 2; ++n5) {
            for (n4 = -1; n4 <= 3; ++n4) {
                boolean bl;
                boolean bl2 = bl = n5 == -1 || n5 == 2 || n4 == -1 || n4 == 3;
                if ((n5 == -1 || n5 == 2) && (n4 == -1 || n4 == 3)) continue;
                int n8 = c_g.a(n + n6 * n5, n2 + n4, n3 + n7 * n5);
                if (!(bl ? n8 != Block.ae.at : n8 != 0 && n8 != Block.hellfire.at)) continue;
                return false;
            }
        }
        for (n5 = 0; n5 < 2; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                c_g.setBlockAndMetadata(n + n6 * n5, n2 + n4, n3 + n7 * n5, Block.portal.at, 11);
            }
        }
        c_g.mc.f.triggerAchievement(AchievementList.buildPortal);
        return true;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        int n5 = 0;
        int n6 = 1;
        if (c_g.a(n - 1, n2, n3) == this.at || c_g.a(n + 1, n2, n3) == this.at) {
            n5 = 1;
            n6 = 0;
        }
        int n7 = n2;
        while (c_g.a(n, n7 - 1, n3) == this.at) {
            --n7;
        }
        if (c_g.a(n, n7 - 1, n3) != Block.ae.at) {
            c_g.b(n, n2, n3, 0);
        } else {
            int n8;
            for (n8 = 1; n8 < 4 && c_g.a(n, n7 + n8, n3) == this.at; ++n8) {
            }
            if (n8 == 3 && c_g.a(n, n7 + n8, n3) == Block.ae.at) {
                boolean bl;
                boolean bl2 = c_g.a(n - 1, n2, n3) == this.at || c_g.a(n + 1, n2, n3) == this.at;
                boolean bl3 = bl = c_g.a(n, n2, n3 - 1) == this.at || c_g.a(n, n2, n3 + 1) == this.at;
                if (bl2 && bl) {
                    c_g.b(n, n2, n3, 0);
                } else if (!(c_g.a(n + n5, n2, n3 + n6) == Block.ae.at && c_g.a(n - n5, n2, n3 - n6) == this.at || c_g.a(n - n5, n2, n3 - n6) == Block.ae.at && c_g.a(n + n5, n2, n3 + n6) == this.at)) {
                    c_g.b(n, n2, n3, 0);
                }
            } else {
                c_g.b(n, n2, n3, 0);
            }
        }
    }

    @Override
    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        boolean bl;
        if (c_g.a(n, n2, n3) == this.at) {
            return false;
        }
        boolean bl2 = c_g.a(n - 1, n2, n3) == this.at && c_g.a(n - 2, n2, n3) != this.at;
        boolean bl3 = c_g.a(n + 1, n2, n3) == this.at && c_g.a(n + 2, n2, n3) != this.at;
        boolean bl4 = c_g.a(n, n2, n3 - 1) == this.at && c_g.a(n, n2, n3 - 2) != this.at;
        boolean bl5 = c_g.a(n, n2, n3 + 1) == this.at && c_g.a(n, n2, n3 + 2) != this.at;
        boolean bl6 = bl2 || bl3;
        boolean bl7 = bl = bl4 || bl5;
        return bl6 && n4 == 4 ? true : (bl6 && n4 == 5 ? true : (bl && n4 == 2 ? true : bl && n4 == 3));
    }

    @Override
    public int a(Random random) {
        return 0;
    }

    @Override
    public int f() {
        return 1;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, Random random) {
        if (random.nextInt(100) == 0) {
            // empty if block
        }
        for (int i = 0; i < 4; ++i) {
            float f = (float)n + random.nextFloat();
            float f2 = (float)n2 + random.nextFloat();
            float f3 = (float)n3 + random.nextFloat();
            byte by = c_g.e(n, n2, n3);
            c_g.a("portal", f, f2, f3, colorTable[by][0], colorTable[by][1], colorTable[by][2]);
        }
    }
}

