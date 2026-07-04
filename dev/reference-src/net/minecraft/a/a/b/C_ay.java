/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public final class C_ay
extends C_x {
    protected C_ay(int n, int n2) {
        super(n, n2, C_c.l);
        this.a(true);
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public final int a() {
        return 3;
    }

    @Override
    public final int a(Random random) {
        return 0;
    }

    @Override
    public final int e() {
        return 20;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3) {
        return c_g.b(n, n2 - 1, n3);
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (!c_g.b(n, n2 - 1, n3)) {
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2 - 1, n3) != C_x.ae.at || !C_x.portal.tryToCreatePortal(c_g, n, n2, n3)) {
            if (!c_g.b(n, n2 - 1, n3)) {
                c_g.b(n, n2, n3, 0);
            } else {
                c_g.e(n, n2, n3, this.at);
            }
        }
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (!c_g.multiplayerWorld) {
            byte by = c_g.e(n, n2, n3);
            if (by < 15) {
                c_g.setBlockMetadata(n, n2, n3, by + 1);
                c_g.e(n, n2, n3, this.at);
            }
            if (!c_g.b(n, n2 - 1, n3) || by > 3) {
                c_g.b(n, n2, n3, C_x.ash.at);
            }
        }
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, Random random) {
        block12: {
            block11: {
                float f;
                float f2;
                float f3;
                int n4;
                if (random.nextInt(24) == 0) {
                    c_g.a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                }
                if (c_g.b(n, n2 - 1, n3) || C_x.ag.e(c_g, n, n2 - 1, n3)) break block11;
                if (C_x.ag.e(c_g, n - 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n + 1, n2, n3)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)(n + 1) - random.nextFloat() * 0.1f;
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat();
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n, n2, n3 - 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)n3 + random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (C_x.ag.e(c_g, n, n2, n3 + 1)) {
                    for (n4 = 0; n4 < 2; ++n4) {
                        f3 = (float)n + random.nextFloat();
                        f2 = (float)n2 + random.nextFloat();
                        f = (float)(n3 + 1) - random.nextFloat() * 0.1f;
                        c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                    }
                }
                if (!C_x.ag.e(c_g, n, n2 + 1, n3)) break block12;
                for (n4 = 0; n4 < 2; ++n4) {
                    f3 = (float)n + random.nextFloat();
                    f2 = (float)(n2 + 1) - random.nextFloat() * 0.1f;
                    f = (float)n3 + random.nextFloat();
                    c_g.a("largesmoke", f3, f2, f, 0.0f, 0.0f, 0.0f);
                }
                break block12;
            }
            for (int i = 0; i < 3; ++i) {
                float f = (float)n + random.nextFloat();
                float f4 = (float)n2 + random.nextFloat() * 0.5f + 0.5f;
                float f5 = (float)n3 + random.nextFloat();
                c_g.a("largesmoke", f, f4, f5, 0.0f, 0.0f, 0.0f);
            }
        }
    }
}

