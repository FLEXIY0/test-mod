/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.C_l;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.GameSettings;

public class C_bs
extends Block {
    public C_bs(int n, int n2, Material c_c) {
        super(n, n2, c_c);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.a(true);
        this.hasStates = true;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        if (this.at == Block.snowLayer.at) {
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    for (int k = -1; k < 2; ++k) {
                        Material c_c = c_g.f(n + i, n2 + k, n3 + j);
                        if (c_g.a(n + i, n2 + k, n3 + j) != Block.af.at && c_c != Material.g && c_c != Material.l && c_g.a(n + i, n2 + k, n3 + j) != Block.lantern.at) continue;
                        return false;
                    }
                }
            }
        }
        return c_g.a(n, n2 - 1, n3) == Block.z.at ? true : (c_g.a(n, n2 - 1, n3) == Block.B.at ? true : (c_g.a(n, n2 - 1, n3) == Block.detector.at ? true : (c_g.a(n, n2 - 1, n3) == Block.stairUpsideDown.at ? true : (c_g.a(n, n2 - 1, n3) == this.at && c_g.e(n, n2 - 1, n3) < 7 ? true : (!c_g.b(n, n2 - 1, n3) ? false : super.a(c_g, n, n2, n3))))));
    }

    @Override
    public void setBlockBoundsForItemRender(int n) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    @Override
    protected int damageDropped(int n) {
        return 0;
    }

    @Override
    public int getMaxMetadata() {
        return 7;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2 - 1, n3).a()) {
            this.f(c_g, n, n2, n3, 0);
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2 - 1, n3) != this.at && (c_g.b(n, n2 - 1, n3) || c_g.a(n, n2 - 1, n3) == Block.z.at || c_g.a(n, n2 - 1, n3) == Block.B.at || c_g.a(n, n2 - 1, n3) == this.at);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        if (this.at == Block.snowLayer.at) {
            if (c_g.season.currentSeason != 3 && random.nextInt(20) == 0) {
                if (c_g.e(n, n2, n3) >= 1) {
                    c_g.setBlockMetadata(n, n2, n3, c_g.e(n, n2, n3) - 1);
                } else {
                    c_g.b(n, n2, n3, 0);
                }
            }
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    for (int k = -1; k < 2; ++k) {
                        Material c_c = c_g.f(n + i, n2 + k, n3 + j);
                        if (c_g.a(n + i, n2 + k, n3 + j) != Block.af.at && c_c != Material.g && c_c != Material.l && c_g.a(n + i, n2 + k, n3 + j) != Block.lantern.at) continue;
                        if (c_g.e(n, n2, n3) >= 1) {
                            c_g.setBlockMetadata(n, n2, n3, c_g.e(n, n2, n3) - 1);
                            continue;
                        }
                        c_g.b(n, n2, n3, 0);
                    }
                }
            }
        }
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2 - 1, n3);
        if (by >= 7) {
            super.d(c_g, n, n2, n3);
        }
        if (this.at == c_g.a(n, n2 - 1, n3) && by < 7) {
            c_g.setBlockMetadata(n, n2 - 1, n3, by + 1);
            c_g.a(n, n2, n3, 0);
        }
    }

    @Override
    public net.minecraft.a.d.C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        int n4 = c_g.e(n, n2, n3) & 7;
        return n4 >= 3 && n4 < 7 ? new net.minecraft.a.d.C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + 0.5f, (float)n3 + this.az) : (n4 >= 7 ? new net.minecraft.a.d.C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + 1.0f, (float)n3 + this.az) : null);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        int n4 = c_g.e(n, n2, n3) & 7;
        float f = (float)(2 * (1 + n4)) / 16.0f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, f, 1.0f);
    }

    @Override
    public int a() {
        return 17;
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
    public int a(int n, Random random) {
        if (this.at == Block.snowLayer.at) {
            return Item.snowball.ap;
        }
        if (this.at == Block.sandLayer.at) {
            return Item.sandball.ap;
        }
        if (this.at == Block.ash.at) {
            return Item.ash.ap;
        }
        return 0;
    }

    @Override
    public int a(Random random) {
        return 1;
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            EntityPlayer entityPlayer = (EntityPlayer)c_g.y;
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= f) || (n6 = this.a(n4, c_g.q)) <= 0 || entityPlayer == null || entityPlayer.b.a[entityPlayer.b.c] == null || !(entityPlayer.b.a[entityPlayer.b.c].a() instanceof C_l)) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4)));
                new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public void dropBlockAsMultipleItems(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            int n5 = 0;
            byte by = c_g.e(n, n2, n3);
            if (by >= 2) {
                n5 = 1 + (by - 3) / 2;
            }
            EntityPlayer entityPlayer = (EntityPlayer)c_g.y;
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= 1.0f) || (n6 = this.a(n4, c_g.q)) <= 0 || entityPlayer == null || entityPlayer.b.a[entityPlayer.b.c] == null || !(entityPlayer.b.a[entityPlayer.b.c].a() instanceof C_l)) continue;
                float f = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4)));
                new EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public int a(int n, int n2) {
        if (this.at == Block.leafPile.at && !GameSettings.fancyTextures) {
            return this.as + 32;
        }
        return this.as;
    }

    @Override
    public boolean canBeDuped() {
        return true;
    }

    @Override
    public boolean canCompost() {
        return this.aC == Material.h;
    }
}

