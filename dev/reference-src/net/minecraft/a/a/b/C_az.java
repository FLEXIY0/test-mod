/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_ae;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.client.statistics.AchievementList;

public class C_az
extends C_ae {
    protected C_az(int n, int n2, Material c_c) {
        super(n, n2, c_c, false);
        this.a(true);
    }

    @Override
    public int a(Random random) {
        return 0;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        if (c_g.mc.f.b.a[c_g.mc.f.b.c] == null || c_g.mc.f.b.a[c_g.mc.f.b.c].a() != Item.E) {
            if (c_g.theme == 1) {
                c_g.mc.f.triggerAchievement(AchievementList.hellIce);
            }
            c_g.a(n, n2, n3, Block.p.at);
        }
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        if (c_g.season.currentSeason != 3 && random.nextInt(20) == 0) {
            c_g.b(n, n2, n3, Block.q.at);
        }
        for (int i = -2; i < 3; ++i) {
            for (int j = -2; j < 3; ++j) {
                for (int k = -2; k < 3; ++k) {
                    Material c_c = c_g.f(n + i, n2 + k, n3 + j);
                    if (c_g.a(n + i, n2 + k, n3 + j) != Block.af.at && c_c != Material.g && c_c != Material.l) continue;
                    c_g.b(n, n2, n3, Block.p.at);
                }
            }
        }
    }

    @Override
    public int f() {
        return 1;
    }
}

