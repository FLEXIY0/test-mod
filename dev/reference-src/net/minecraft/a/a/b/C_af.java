/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public final class C_af
extends C_x {
    protected C_af(int n) {
        super(n, C_c.b);
        this.as = 320;
        this.a(true);
        this.hasStates = true;
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return new C_b(n, n2, n3, n + 1, n2 + 1, n3 + 1);
    }

    @Override
    public final int a(int n, int n2) {
        if (n2 == 1) {
            return n == 1 ? 396 : (n == 396 ? 2 : 397);
        }
        return n == 1 ? 288 : (n == 0 ? 2 : 320);
    }

    @Override
    public void setBlockBoundsForItemRender(int n) {
        if (n == 1) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public final boolean isOpaqueCube(int n) {
        return n != 1;
    }

    @Override
    public int getMaxDamage() {
        return 1;
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        if (c_g.e(n, n2, n3) == 1) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public int a(C_g c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (n4 == 1) {
            if (by == 1) {
                return 396;
            }
            return 288;
        }
        if (n4 == 0) {
            return 2;
        }
        C_c c_c = c_g.f(n, n2 + 1, n3);
        int n5 = c_g.a(n, n2 + 1, n3);
        return c_c == C_c.snow ? 294 : (c_c == C_c.ash ? 491 : (n5 == C_x.t.at || n5 == C_x.sandLayer.at || c_c == C_c.quicksand ? 645 : (by == 1 ? 397 : 320)));
    }

    @Override
    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (!c_g.multiplayerWorld) {
            if (c_g.d(n, n2 + 1, n3) < 4 && c_g.f(n, n2 + 1, n3).b()) {
                if (random.nextInt(4) == 0) {
                    c_g.b(n, n2, n3, C_x.k.at);
                }
            } else if (c_g.d(n, n2 + 1, n3) >= 9 && c_g.a(n = n + random.nextInt(3) - 1, n2 = n2 + random.nextInt(5) - 3, n3 = n3 + random.nextInt(3) - 1) == C_x.k.at && c_g.d(n, n2 + 1, n3) >= 4 && !c_g.f(n, n2 + 1, n3).b()) {
                c_g.b(n, n2, n3, C_x.j.at);
            }
        }
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        super.b(c_g, n, n2, n3, n4);
        if (c_g.f(n, n2 + 1, n3).a() && c_g.e(n, n2, n3) == 1) {
            c_g.b(n, n2, n3, C_x.k.at);
        }
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, Random random) {
        super.b(c_g, n, n2, n3, random);
        if (random.nextInt(250) == 0 && c_g.season.currentSeason == 1 && c_g.season.seasonProgress >= 0.3f && c_g.season.seasonProgress <= 0.7f && c_g.isNight && !c_g.getRaining()) {
            c_g.a("firefly", (float)n + random.nextFloat(), (float)n2 + 1.1f, (float)n3 + random.nextFloat(), 0.0f, 0.0f, 0.0f);
        }
    }

    @Override
    public final int a(int n, Random random) {
        return C_x.k.a(0, random);
    }

    @Override
    public String getBlockName(int n) {
        return n == 1 ? "Grass Path" : "Grass";
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }
}

