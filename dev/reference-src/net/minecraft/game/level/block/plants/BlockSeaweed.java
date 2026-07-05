/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockSeaweed
extends BlockFlower {
    public BlockSeaweed(int n, int n2) {
        super(n, n2);
        this.as = 462;
        this.aC = Material.f;
        this.a(true);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected final boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == Block.k.at || n == this.at;
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, Block.q.at);
        }
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        if (c_g.f(n, n2 + 1, n3) == Material.f && c_g.f(n, n2 + 2, n3) == Material.f) {
            int n4 = 1;
            while (c_g.a(n, n2 - n4, n3) == this.at) {
                ++n4;
            }
            if (n4 < 6 && random.nextInt(25) == 0) {
                c_g.b(n, n2 + 1, n3, this.at);
                c_g.setBlockMetadataWithNotify(n, n2, n3, 15);
            }
        }
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2 - 1, n3) == this.at) {
            c_g.setBlockMetadata(n, n2 - 1, n3, 15);
        }
    }

    @Override
    public int a(int n, int n2) {
        if (n2 == 15) {
            return 494;
        }
        return 462;
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2 + 1, n3);
        if (n4 != this.at && n4 != Block.q.at && n4 != Block.p.at) {
            return false;
        }
        return this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3));
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return this.canBlockStay(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int a() {
        return 6;
    }
}

