/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public class BlockCoralFan
extends Block {
    private static String[] NAME_LIST = new String[]{"Tube", "Fire", "Bubble", "Brain"};

    public BlockCoralFan(int n, int n2, Material c_c) {
        super(n, n2, c_c);
        this.hasStates = true;
    }

    @Override
    public int a(int n, int n2) {
        return this.as + n2;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n] + " Coral";
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3)) && c_g.f(n, n2, n3) == Material.f;
    }

    protected boolean canThisPlantGrowOnThisBlockID(int n) {
        return n == Block.coral.at;
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
        return this.canThisPlantGrowOnThisBlockID(c_g.a(n, n2 - 1, n3)) && c_g.f(n, n2, n3) == Material.f;
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

