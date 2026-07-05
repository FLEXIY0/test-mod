/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_q;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_b;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_s
extends C_q {
    private final boolean a;

    protected C_s(int n, boolean bl) {
        super(n, Material.d);
        this.a = bl;
        this.as = 45;
    }

    public final void d(World c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        C_s.e(c_g, n, n2, n3);
    }

    private static void e(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3 - 1);
        int n5 = c_g.a(n, n2, n3 + 1);
        int n6 = c_g.a(n - 1, n2, n3);
        int n7 = c_g.a(n + 1, n2, n3);
        int n8 = 3;
        if (Block.e[n4] && !Block.e[n5]) {
            n8 = 3;
        }
        if (Block.e[n5] && !Block.e[n4]) {
            n8 = 2;
        }
        if (Block.e[n6] && !Block.e[n7]) {
            n8 = 5;
        }
        if (Block.e[n7] && !Block.e[n6]) {
            n8 = 4;
        }
        c_g.f(n, n2, n3, n8);
    }

    public final int a(World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return Block.i.as;
        }
        if (n4 == 0) {
            return Block.i.as;
        }
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            C_s.e(c_g, n, n2, n3);
            by = c_g.e(n, n2, n3);
        }
        if (n4 != by) {
            return this.as;
        }
        if (this.a) {
            return this.as + 16;
        }
        return this.as - 1;
    }

    public final void b(World c_g, int n, int n2, int n3, Random random) {
        if (!this.a) {
            return;
        }
        byte by = c_g.e(n, n2, n3);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + random.nextFloat() * 6.0f / 16.0f;
        float f3 = (float)n3 + 0.5f;
        float f4 = random.nextFloat() * 0.6f - 0.3f;
        if (by == 4) {
            c_g.a("smoke", f - 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f - 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 5) {
            c_g.a("smoke", f + 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f + 0.52f, f2, f3 + f4, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 2) {
            c_g.a("smoke", f + f4, f2, f3 - 0.52f, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f + f4, f2, f3 - 0.52f, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 3) {
            c_g.a("smoke", f + f4, f2, f3 + 0.52f, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f + f4, f2, f3 + 0.52f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final int a(int n) {
        if (n == 1) {
            return Block.i.at;
        }
        if (n == 0) {
            return Block.i.at;
        }
        if (n == 3) {
            return this.as - 1;
        }
        return this.as;
    }

    public final boolean a(World object, int n, int n2, int n3, EntityPlayer entityPlayer) {
        object = (C_b)((World)object).j(n, n2, n3);
        entityPlayer.a((C_b)object);
        return true;
    }

    protected final TileEntity a_() {
        return new C_b();
    }
}

