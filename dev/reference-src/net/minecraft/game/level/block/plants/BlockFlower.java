/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public class BlockFlower
extends Block {
    public BlockFlower(int n, int n2) {
        super(n, C_c.i);
        this.as = n2;
        this.a(true);
        this.a(0.3f, 0.0f, 0.3f, 0.7f, 0.6f, 0.7f);
        this.isDecoration = true;
        this.aB = 0.6f;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == Block.j.at || n == Block.k.at || n == Block.ap.at;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        super.b(c_g, n, n2, n3, n4);
        this.checkFlowerChange(c_g, n, n2, n3);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        this.checkFlowerChange(c_g, n, n2, n3);
    }

    private void checkFlowerChange(World c_g, int n, int n2, int n3) {
        if (!this.canBlockStay(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return (c_g.d(n, n2, n3) >= 8 || c_g.d(n, n2, n3) >= 4 && c_g.l(n, n2, n3)) && this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3));
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
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
    public int a() {
        return 1;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

