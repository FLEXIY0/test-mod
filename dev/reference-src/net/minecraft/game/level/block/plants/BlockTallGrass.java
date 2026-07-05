/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.b.Item;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockTallGrass
extends BlockFlower {
    public BlockTallGrass(int n, int n2) {
        super(n, n2);
        float f = 0.4f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.6f, 0.5f + f);
        this.hasStates = true;
    }

    @Override
    public int a(int n, Random random) {
        if (random.nextInt(8) == 0) {
            switch (random.nextInt(3)) {
                case 1: {
                    return Item.seedsMelon.ap;
                }
                case 2: {
                    return Item.seedsPumpkin.ap;
                }
            }
            return Item.O.ap;
        }
        return -1;
    }
}

