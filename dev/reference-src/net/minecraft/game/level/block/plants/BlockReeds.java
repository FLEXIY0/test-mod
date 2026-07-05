/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.d.C_b;

public class BlockReeds
extends Block {
    public BlockReeds(int n, int n2) {
        super(n, C_c.i);
        this.as = n2;
        float f = 0.375f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 1.0f, 0.5f + f);
        this.a(true);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        if (c_g.f(n, n2 + 1, n3) == C_c.a) {
            int n4 = 1;
            while (c_g.a(n, n2 - n4, n3) == this.at) {
                ++n4;
            }
            if (n4 < 3) {
                byte by = c_g.e(n, n2, n3);
                if (by == 15) {
                    c_g.b(n, n2 + 1, n3, this.at);
                    c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
                } else {
                    c_g.setBlockMetadataWithNotify(n, n2, n3, by + 1);
                }
            }
        }
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2 - 1, n3);
        return n4 == this.at ? true : (n4 != Block.j.at && n4 != Block.k.at ? false : (c_g.f(n - 1, n2 - 1, n3) == C_c.f ? true : (c_g.f(n + 1, n2 - 1, n3) == C_c.f ? true : (c_g.f(n, n2 - 1, n3 - 1) == C_c.f ? true : c_g.f(n, n2 - 1, n3 + 1) == C_c.f))));
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        this.checkBlockCoordValid(c_g, n, n2, n3);
    }

    protected final void checkBlockCoordValid(World c_g, int n, int n2, int n3) {
        if (!this.canBlockStay(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return this.a(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int a(int n, Random random) {
        return Item.reed.ap;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int a() {
        return 9;
    }
}

