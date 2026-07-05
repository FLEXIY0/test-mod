/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;

public class C_as
extends Block {
    protected C_as(int n, int n2, Material c_c) {
        super(n, n2, c_c);
    }

    @Override
    public int a(World c_g, int n, int n2, int n3, int n4) {
        return n4 == 0 ? this.as + 1 : (n4 == 1 ? this.as + 2 : this.as);
    }

    @Override
    public int a(int n) {
        return n == 0 ? this.as + 1 : (n == 1 ? this.as + 3 : this.as);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        float f;
        boolean bl;
        if (c_g.multiplayerWorld) {
            c_g.markBlockNeedsUpdate(n, n2, n3);
            return true;
        }
        boolean bl2 = bl = entityPlayer.b.d() != null && entityPlayer.b.d().a().canCompost();
        if (bl) {
            if (bl) {
                --entityPlayer.b.d().a;
                if (entityPlayer.b.d().a <= 0) {
                    entityPlayer.b.a[entityPlayer.b.c] = null;
                }
            }
            if (c_g.I.nextInt(2) == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, c_g.e(n, n2, n3) + 1);
                String string = "grow";
                for (int i = 0; i < 7; ++i) {
                    f = (float)(c_g.I.nextGaussian() * (double)0.02f);
                    float f2 = (float)(c_g.I.nextGaussian() * (double)0.02f);
                    float f3 = (float)(c_g.I.nextGaussian() * (double)0.02f);
                    c_g.a(string, (float)n + c_g.I.nextFloat(), (float)n2 + c_g.I.nextFloat(), (float)n3 + c_g.I.nextFloat(), f, f2, f3);
                }
            }
        }
        if (c_g.e(n, n2, n3) >= 4) {
            float f4 = c_g.I.nextFloat() * 0.7f + 0.15f;
            float f5 = c_g.I.nextFloat() * 0.7f + 0.15f;
            f = c_g.I.nextFloat() * 0.7f + 0.15f;
            EntityItem c_b = new EntityItem(c_g, (float)n + f4, (float)n2 + f5, (float)n3 + f, new ItemStack(Item.fertilizer.ap, 1));
            c_g.spawnEntityInWorld(c_b);
            c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
            entityPlayer.triggerAchievement(AchievementList.compost);
        }
        return true;
    }

    @Override
    public int a() {
        return 36;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }
}

