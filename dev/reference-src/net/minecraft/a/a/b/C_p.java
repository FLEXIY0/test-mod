/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.furniture.BlockTorch;
import net.minecraft.game.level.block.plants.BlockFlower;
import net.minecraft.game.level.block.plants.BlockSeaweed;

public class C_p
extends Block {
    protected int a;
    protected int b;
    protected int liquidType = 1;

    protected C_p(int n, C_c c_c) {
        super(n, c_c);
        this.as = 14;
        if (c_c == C_c.g) {
            this.as = 46;
            this.liquidType = 2;
        }
        Block.g[n] = true;
        this.b = n;
        this.a = n + 1;
        this.a(0.01f, -0.09f, 0.01f, 1.01f, 0.90999997f, 1.01f);
        this.a(true);
        this.a(2.0f);
    }

    @Override
    public int a() {
        return 41;
    }

    @Override
    public int getMaxMetadata() {
        return 8;
    }

    @Override
    public final int a(int n) {
        return this.aC == C_c.g ? this.as : (n == 1 ? this.as : (n == 0 ? this.as : this.as + 64));
    }

    protected final int getFlowDecay(World c_g, int n, int n2, int n3) {
        return c_g.f(n, n2, n3) != this.aC ? -1 : (int)c_g.e(n, n2, n3);
    }

    @Override
    public final boolean c() {
        return false;
    }

    public static float getFluidHeightPercent(int n) {
        if (n >= 8) {
            n = 0;
        }
        return (float)(n + 1) / 9.0f;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        this.e(c_g, n, n2, n3, 0);
    }

    public boolean e(World c_g, int n, int n2, int n3, int n4) {
        boolean bl = false;
        while (this.e(c_g, n, --n2, n3)) {
            boolean bl2 = c_g.b(n, n2, n3, this.b);
            if (bl2) {
                bl = true;
            }
            if (bl2 && this.aC != C_c.g) continue;
        }
        ++n2;
        if (this.aC == C_c.f || !bl) {
            bl = bl | this.i(c_g, n - 1, n2, n3) | this.i(c_g, n + 1, n2, n3) | this.i(c_g, n, n2, n3 - 1) | this.i(c_g, n, n2, n3 + 1);
        }
        if (this.aC == C_c.g) {
            bl = bl | C_p.h(c_g, n - 1, n2, n3) | C_p.h(c_g, n + 1, n2, n3) | C_p.h(c_g, n, n2, n3 - 1) | C_p.h(c_g, n, n2, n3 + 1);
        }
        if (!bl) {
            c_g.d(n, n2, n3, this.a);
        } else {
            c_g.e(n, n2, n3, this.b);
        }
        return bl;
    }

    protected final boolean e(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        Block c_x = Block.c[n4];
        if (n4 != 0 && n4 != Block.ag.at) {
            return c_x instanceof BlockFlower && !(c_x instanceof BlockSeaweed) || c_x instanceof BlockTorch || c_x instanceof C_am || c_x instanceof C_bs;
        }
        if (this.aC == C_c.f) {
            for (n4 = n - 2; n4 <= n + 2; ++n4) {
                for (int i = n2 - 2; i <= n2 + 2; ++i) {
                    for (int j = n3 - 2; j <= n3 + 2; ++j) {
                        if (c_g.a(n4, i, j) != Block.A.at) continue;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean h(World c_g, int n, int n2, int n3) {
        if (Block.ag.b(c_g.a(n, n2, n3))) {
            Block.ag.h(c_g, n, n2, n3);
            return true;
        }
        return false;
    }

    private boolean i(World c_g, int n, int n2, int n3) {
        if (!this.e(c_g, n, n2, n3)) {
            return false;
        }
        if (c_g.b(n, n2, n3, this.b)) {
            c_g.e(n, n2, n3, this.b);
        }
        return false;
    }

    @Override
    public final float f(World c_g, int n, int n2, int n3) {
        return this.aC == C_c.g ? 100.0f : super.f(c_g, n, n2, n3);
    }

    @Override
    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (n4 == 0 && c_g.a(n, n2, n3) != 0) {
            return false;
        }
        if (n4 == 1 && c_g.b(n, n2, n3)) {
            return true;
        }
        return n >= 0 && n2 >= 0 && n3 >= 0 && n < c_g.a && n3 < c_g.b ? (n5 == this.b || n5 == this.a || n5 == Block.coralFan.at ? false : super.d(c_g, n, n2, n3, n4)) : false;
    }

    @Override
    public final boolean canCollideCheck(int n, boolean bl) {
        return bl && n == 0;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (n4 != 0) {
            C_c c_c = Block.c[n4].aC;
            if (this.aC == C_c.f && c_c == C_c.g || c_c == C_c.f && this.aC == C_c.g) {
                c_g.b(n, n2, n3, Block.i.at);
            }
        }
        c_g.e(n, n2, n3, this.at);
    }

    @Override
    public int e() {
        return this.aC == C_c.g ? 25 : 5;
    }

    @Override
    public int a(Random random) {
        return 0;
    }

    @Override
    public int f() {
        return this.aC == C_c.f ? 1 : 0;
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, Random random) {
        float f;
        float f2;
        float f3;
        if (C_p.j(c_g, n + 1, n2, n3) || C_p.j(c_g, n - 1, n2, n3) || C_p.j(c_g, n, n2, n3 - 1) || C_p.j(c_g, n, n2, n3 + 1)) {
            if (this.aC == C_c.g && random.nextInt(100) == 0) {
                c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "liquid.lava", random.nextFloat() * 0.55f + 0.75f, random.nextFloat() * 0.5f + 0.3f);
            }
            if (this.aC == C_c.f && random.nextInt(100) == 0) {
                c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "liquid.water", random.nextFloat() * 0.25f + 0.75f, random.nextFloat() * 0.5f + 0.3f);
            }
        }
        if (this.aC == C_c.g && c_g.f(n, n2 + 1, n3) == C_c.a && !c_g.b(n, n2 + 1, n3) && random.nextInt(100) == 0) {
            f3 = (float)n + random.nextFloat();
            f2 = (float)n2 + this.ay;
            f = (float)n3 + random.nextFloat();
            c_g.a("lava", f3, f2, f, 0.0f, 0.0f, 0.0f);
            c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "liquid.lavapop", random.nextFloat() * 0.25f + 0.75f, random.nextFloat() * 0.75f + 0.75f);
        }
        if (this.aC == C_c.f) {
            byte by;
            if (C_p.j(c_g, n + 1, n2, n3)) {
                for (int i = 0; i < 4; ++i) {
                    c_g.a("splash", (float)(n + 1) + 0.125f, n2, (float)n3 + random.nextFloat(), 0.0f, 0.0f, 0.0f);
                }
            }
            if (C_p.j(c_g, n - 1, n2, n3)) {
                for (int i = 0; i < 4; ++i) {
                    c_g.a("splash", (float)n - 0.125f, n2, (float)n3 + random.nextFloat(), 0.0f, 0.0f, 0.0f);
                }
            }
            if (C_p.j(c_g, n, n2, n3 + 1)) {
                for (int i = 0; i < 4; ++i) {
                    c_g.a("splash", (float)n + random.nextFloat(), n2, (float)(n3 + 1) + 0.125f, 0.0f, 0.0f, 0.0f);
                }
            }
            if (C_p.j(c_g, n, n2, n3 - 1)) {
                for (int i = 0; i < 4; ++i) {
                    c_g.a("splash", (float)n + random.nextFloat(), n2, (float)n3 - 0.125f, 0.0f, 0.0f, 0.0f);
                }
            }
            if (random.nextInt(10) == 0 && ((by = c_g.e(n, n2, n3)) <= 0 || by >= 8)) {
                c_g.a("suspended", (float)n + random.nextFloat(), (float)n2 + random.nextFloat(), (float)n3 + random.nextFloat(), 0.0f, 0.0f, 0.0f);
            }
        }
        if (random.nextInt(10) == 0 && c_g.a((float)n, (float)(n2 - 1), (float)n3)) {
            f3 = (float)n + random.nextFloat();
            f2 = (float)n2 - 1.05f;
            f = (float)n3 + random.nextFloat();
            if (this.getMaterial(0) == C_c.f) {
                c_g.a("dripWater", f3, f2, f, 0.0f, 0.0f, 0.0f);
            } else {
                c_g.a("dripLava", f3, f2, f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private static boolean j(World c_g, int n, int n2, int n3) {
        C_c c_c = c_g.f(n, n2, n3);
        C_c c_c2 = c_g.f(n, n2 - 1, n3);
        return !c_c.c() && !c_c.d() ? c_c2.c() || c_c2.d() : false;
    }
}

