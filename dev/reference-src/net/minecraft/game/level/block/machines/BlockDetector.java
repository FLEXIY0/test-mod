/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;

public class BlockDetector
extends Block {
    public BlockDetector(int n, int n2, Material c_c) {
        super(n, n2, c_c);
        this.a(true);
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
    public final boolean d(World c_g, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int a() {
        return 34;
    }

    @Override
    public int e() {
        return 5;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        this.changeState(c_g, n, n2, n3, 0);
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        this.changeState(c_g, n, n2, n3, 0);
    }

    @Override
    public void onEntityCollidedWithBlock(World c_g, int n, int n2, int n3) {
        this.changeState(c_g, n, n2, n3, 4);
    }

    private void changeState(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld && c_g.e(n, n2, n3) != n4) {
            c_g.setBlockMetadata(n, n2, n3, n4);
        }
    }
}

