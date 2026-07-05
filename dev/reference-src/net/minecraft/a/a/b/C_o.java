/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.b.C_g;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.client.GameSettings;

public final class C_o
extends C_g {
    private static String[] NAME_LIST = new String[]{"Oak", "Apple Tree", "Oak", "Birch", "Palm", "Pine"};

    protected C_o(int n, int n2) {
        super(n, n2, C_c.h, true);
        this.a(true);
        this.hasStates = true;
    }

    @Override
    public final void a(net.minecraft.a.a.World c_g, int n, int n2, int n3, Random random) {
        int n4 = 4;
        int n5 = 4;
        if (!c_g.b(n, n2 - 1, n3)) {
            for (int i = n - n4; i <= n + n4; ++i) {
                for (int j = n2 - n5; j <= n2; ++j) {
                    for (int k = n3 - n4; k <= n3 + n4; ++k) {
                        if (c_g.a(i, j, k) != Block.y.at && c_g.a(i, j, k) != Block.log.at) continue;
                        return;
                    }
                }
            }
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public final int a(Random random) {
        return random.nextInt(10) == 0 ? 1 : 0;
    }

    @Override
    public int getMaxDamage() {
        return 5;
    }

    @Override
    public final int a(int n, Random random) {
        return Block.n.at;
    }

    private int altDrop(int n, Random random) {
        return Item.apple.ap;
    }

    @Override
    public final void a(net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            for (int i = 0; i < n5; ++i) {
                int n6;
                C_b c_b;
                float f2;
                float f3;
                float f4;
                int n7;
                if (c_g.q.nextFloat() <= f && (n7 = this.a(n4, c_g.q)) > 0) {
                    f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                    f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                    f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                    c_b = new C_b(c_g, (float)n + f4, (float)n2 + f3, (float)n3 + f2, new ItemStack(n7, 1, this.damageDropped(n4)));
                    new C_b(c_g, (float)n + f4, (float)n2 + f3, (float)n3 + f2, new ItemStack(n7, 1, this.damageDropped(n4))).O = 10;
                    c_g.spawnEntityInWorld(c_b);
                }
                if (!(c_g.q.nextFloat() <= 0.5f) || (n6 = this.altDrop(n4, c_g.q)) <= 0 || c_g.e(n, n2, n3) != 1) continue;
                f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                c_b = new C_b(c_g, (float)n + f4, (float)n2 + f3, (float)n3 + f2, new ItemStack(n6, 1, 0));
                new C_b(c_g, (float)n + f4, (float)n2 + f3, (float)n3 + f2, new ItemStack(n6, 1, 0)).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public void dropBlockAsItemWithChance(net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        int n5 = 1;
        for (int i = 0; i < n5; ++i) {
            int n6;
            int n7 = this.damageDropped(n4);
            if (c_g.mc.f != null && c_g.mc.f.b.d().a().isToolSilkTouch()) {
                n7 = n4;
            }
            if (!(c_g.q.nextFloat() <= 1.0f) || (n6 = this.at) <= 0) continue;
            float f = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
            float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
            C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, n7));
            new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, n7)).O = 10;
            c_g.spawnEntityInWorld(c_b);
        }
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 3: {
                this.as = 326;
                break;
            }
            case 4: {
                this.as = 358;
                break;
            }
            case 5: {
                this.as = 390;
                break;
            }
            default: {
                this.as = 352;
            }
        }
        if (GameSettings.fancyTextures) {
            return this.as;
        }
        if (n2 <= 2) {
            return this.as + 32;
        }
        return this.as + 1;
    }

    @Override
    public int a() {
        return 35;
    }

    @Override
    protected int damageDropped(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 0;
        }
        return n - 1;
    }

    @Override
    public final void b(net.minecraft.a.a.World c_g, int n, int n2, int n3, Random random) {
        float f;
        float f2;
        float f3;
        if (c_g.season.currentSeason == 2 && c_g.season.seasonProgress >= 0.3f && c_g.season.seasonProgress <= 0.7f && c_g.a(n, n2 - 1, n3) == 0 && random.nextInt(20) == 0 && c_g.e(n, n2, n3) <= 2) {
            f3 = (float)n + random.nextFloat();
            f2 = (float)n2 + this.av - 0.1f;
            f = (float)n3 + random.nextFloat();
            c_g.a("leaf", f3, f2, f, 0.0f, 0.0f, 0.0f);
        }
        if (c_g.season.currentSeason != 3 && c_g.getRaining() && c_g.type != 4 && random.nextInt(10) == 0) {
            f3 = (float)n + random.nextFloat();
            f2 = (float)n2 + this.av - 0.1f;
            f = (float)n3 + random.nextFloat();
            c_g.a("dripWater", f3, f2, f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override
    public String getBlockName(int n) {
        if (n >= 6) {
            return NAME_LIST[2] + " Leaves";
        }
        return NAME_LIST[n] + " Leaves";
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

