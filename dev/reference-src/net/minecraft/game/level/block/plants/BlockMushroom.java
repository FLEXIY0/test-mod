/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.game.level.block.plants.BlockFlower;

public final class BlockMushroom
extends BlockFlower {
    public BlockMushroom(int n, int n2) {
        super(n, n2);
        this.a(0.3f, 0.0f, 0.3f, 0.7f, 0.4f, 0.7f);
    }

    @Override
    protected final boolean canThisPlantGrowOnThisBlockID(int n) {
        return Block.e[n];
    }

    @Override
    public final boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return (c_g.d(n, n2, n3) <= 13 || c_g.a(n, n2 - 1, n3) == Block.mycelium.at) && Block.e[n = c_g.a(n, n2 - 1, n3)];
    }
}

