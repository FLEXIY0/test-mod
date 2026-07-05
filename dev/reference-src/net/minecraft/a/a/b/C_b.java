/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_p;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;

public final class C_b
extends C_p {
    protected C_b(int n, C_c c_c) {
        super(n, c_c);
        this.b = n - 1;
        this.a = n;
        this.a(true);
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        if (this.aC == C_c.f && c_g.getRaining() && c_g.season.currentSeason != 3 && c_g.theme != 1 && c_g.e(n, n2, n3) > 0 && c_g.l(n, n2 + 1, n3)) {
            c_g.setBlockMetadata(n, n2, n3, c_g.e(n, n2, n3) - 1);
        }
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (this.e(c_g, n, n2 - 1, n3)) {
            bl = true;
        }
        if (!bl && this.e(c_g, n - 1, n2, n3)) {
            bl = true;
        }
        if (!bl && this.e(c_g, n + 1, n2, n3)) {
            bl = true;
        }
        if (!bl && this.e(c_g, n, n2, n3 - 1)) {
            bl = true;
        }
        if (!bl && this.e(c_g, n, n2, n3 + 1)) {
            bl = true;
        }
        if (n4 != 0) {
            C_c c_c = Block.c[n4].aC;
            if (this.aC == C_c.f && c_c == C_c.g || c_c == C_c.f && this.aC == C_c.g) {
                c_g.b(n, n2, n3, Block.ae.at);
                return;
            }
        }
        if (Block.ag.b(n4)) {
            bl = true;
        }
        if (bl) {
            c_g.d(n, n2, n3, this.b);
            c_g.e(n, n2, n3, this.b);
        }
    }
}

