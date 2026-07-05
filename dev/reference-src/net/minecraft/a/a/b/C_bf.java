/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;

public class C_bf
extends Block {
    private static String[] NAME_LIST = new String[]{"Brown", "Red", "Gloshroom"};

    protected C_bf(int n) {
        super(n, 458, Material.c);
        this.hasStates = true;
    }

    @Override
    public final int a(Random random) {
        return random.nextInt(3);
    }

    @Override
    public final int a(int n, Random random) {
        return n == 0 ? Block.mushroomBrown.at : (n == 1 ? Block.mushroomRed.at : (n == 2 ? Block.mushroomGlowing.at : 0));
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 2;
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 1: {
                return n == 0 ? 428 : 458;
            }
            case 2: {
                return n == 0 ? 428 : 460;
            }
        }
        return n == 0 ? 428 : 459;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= f) || (n6 = this.a(n4, c_g.q)) <= 0) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, 0));
                new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, 0)).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n] + " Cap";
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

