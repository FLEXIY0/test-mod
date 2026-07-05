/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.plants;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.plants.BlockFlower;

public class BlockBush
extends BlockFlower {
    public BlockBush(int n, int n2) {
        super(n, n2);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.hasStates = true;
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        byte by;
        super.a(c_g, n, n2, n3, random);
        if (c_g.d(n, n2 + 1, n3) >= 9 && random.nextInt(50) == 0 && (by = c_g.e(n, n2, n3)) < 1) {
            c_g.setBlockMetadata(n, n2, n3, by + 1);
            return;
        }
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        if (c_g.e(n, n2, n3) != 1) {
            return true;
        }
        float f = c_g.q.nextFloat() * 0.7f + 0.15f;
        float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
        float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
        C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.berry));
        new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(Item.berry)).O = 10;
        c_g.spawnEntityInWorld(c_b);
        c_g.setBlockMetadata(n, n2, n3, 0);
        entityPlayer.addStat(StatList.berryGathered, 1);
        return true;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        super.a(c_g, n, n2, n3, n4, f);
        if (!c_g.multiplayerWorld && n4 == 1) {
            float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(Item.berry));
            new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(Item.berry)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
    }

    @Override
    public int a(int n, int n2) {
        if (n2 == 0 || n2 > 1) {
            return this.as;
        }
        return this.as + 32;
    }

    @Override
    protected int damageDropped(int n) {
        return 0;
    }

    @Override
    public int getMaxDamage() {
        return 1;
    }

    @Override
    public String getBlockName(int n) {
        if (n == 0) {
            return "Bush";
        }
        return "Berry Bush";
    }
}

