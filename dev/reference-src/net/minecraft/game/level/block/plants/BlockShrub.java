/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockShrub
extends BlockFlower {
    public BlockShrub(int n, int n2) {
        super(n, n2);
        float f = 0.4f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == C_x.t.at || n == C_x.redSand.at || n == C_x.k.at;
    }

    @Override
    public boolean canBlockStay(C_g c_g, int n, int n2, int n3) {
        return this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3));
    }

    @Override
    public int a(Random random) {
        return random.nextInt(3);
    }

    @Override
    public int a(int n, Random random) {
        return Item.z.ap;
    }
}

