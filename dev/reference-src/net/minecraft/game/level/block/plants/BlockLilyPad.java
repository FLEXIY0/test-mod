/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockLilyPad
extends BlockFlower {
    public BlockLilyPad(int n, int n2) {
        super(n, n2);
        float f = 0.5f;
        float f2 = 0.015625f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    public int a() {
        return 26;
    }

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == C_x.q.at;
    }

    @Override
    public boolean canBlockStay(C_g c_g, int n, int n2, int n3) {
        return n2 >= 0 && n2 < 256 ? c_g.f(n, n2 - 1, n3) == C_c.f && c_g.e(n, n2 - 1, n3) == 0 : false;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        return new C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + this.ay, (float)n3 + this.az);
    }
}

