/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import com.a.a.NBTTagCompound;
import java.util.Random;
import net.minecraft.a.C_a;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public final class BlockChest
extends BlockContainer {
    private Random random = new Random();

    public BlockChest(int n) {
        super(n, net.minecraft.a.a.d.C_c.c);
        this.as = 42;
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        this.unifyAdjacentChests(c_g, n, n2, n3);
        int n4 = c_g.a(n, n2, n3 - 1);
        int n5 = c_g.a(n, n2, n3 + 1);
        int n6 = c_g.a(n - 1, n2, n3);
        int n7 = c_g.a(n + 1, n2, n3);
        if (n4 == this.at) {
            this.unifyAdjacentChests(c_g, n, n2, n3 - 1);
        }
        if (n5 == this.at) {
            this.unifyAdjacentChests(c_g, n, n2, n3 + 1);
        }
        if (n6 == this.at) {
            this.unifyAdjacentChests(c_g, n - 1, n2, n3);
        }
        if (n7 == this.at) {
            this.unifyAdjacentChests(c_g, n + 1, n2, n3);
        }
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.onBlockPlacedByPlayer(c_g, entityPlayer, n, n2, n3, n4);
        int n5 = c_g.a(n, n2, n3 - 1);
        int n6 = c_g.a(n, n2, n3 + 1);
        int n7 = c_g.a(n - 1, n2, n3);
        int n8 = c_g.a(n + 1, n2, n3);
        int n9 = 0;
        int n10 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3;
        if (n10 == 0) {
            n9 = 2;
        }
        if (n10 == 1) {
            n9 = 5;
        }
        if (n10 == 2) {
            n9 = 3;
        }
        if (n10 == 3) {
            n9 = 4;
        }
        if (n5 != this.at && n6 != this.at && n7 != this.at && n8 != this.at) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, n9);
        } else {
            if (!(n5 != this.at && n6 != this.at || n9 != 4 && n9 != 5)) {
                if (n5 == this.at) {
                    c_g.setBlockMetadataWithNotify(n, n2, n3 - 1, n9);
                } else {
                    c_g.setBlockMetadataWithNotify(n, n2, n3 + 1, n9);
                }
                c_g.setBlockMetadataWithNotify(n, n2, n3, n9);
            }
            if (!(n7 != this.at && n8 != this.at || n9 != 2 && n9 != 3)) {
                if (n7 == this.at) {
                    c_g.setBlockMetadataWithNotify(n - 1, n2, n3, n9);
                } else {
                    c_g.setBlockMetadataWithNotify(n + 1, n2, n3, n9);
                }
                c_g.setBlockMetadataWithNotify(n, n2, n3, n9);
            }
        }
    }

    @Override
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this.as - 1;
        }
        if (n4 == 0) {
            return this.as - 1;
        }
        int n5 = c_g.a(n, n2, n3 - 1);
        int n6 = c_g.a(n, n2, n3 + 1);
        int n7 = c_g.a(n - 1, n2, n3);
        int n8 = c_g.a(n + 1, n2, n3);
        if (n5 != this.at && n6 != this.at) {
            if (n7 != this.at && n8 != this.at) {
                int n9 = 3;
                if (C_x.e[n5] && !C_x.e[n6]) {
                    n9 = 3;
                }
                if (C_x.e[n6] && !C_x.e[n5]) {
                    n9 = 2;
                }
                if (C_x.e[n7] && !C_x.e[n8]) {
                    n9 = 5;
                }
                if (C_x.e[n8] && !C_x.e[n7]) {
                    n9 = 4;
                }
                return n4 == n9 ? this.as + 1 : this.as;
            }
            if (n4 != 4 && n4 != 5) {
                int n10 = 0;
                if (n7 == this.at) {
                    n10 = -1;
                }
                int n11 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 - 1);
                int n12 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 + 1);
                if (n4 == 3) {
                    n10 = -1 - n10;
                }
                int n13 = 3;
                if ((C_x.e[n5] || C_x.e[n11]) && !C_x.e[n6] && !C_x.e[n12]) {
                    n13 = 3;
                }
                if ((C_x.e[n6] || C_x.e[n12]) && !C_x.e[n5] && !C_x.e[n11]) {
                    n13 = 2;
                }
                return (n4 == n13 ? this.as + 32 : this.as + 64) + n10;
            }
            return this.as;
        }
        if (n4 != 2 && n4 != 3) {
            int n14 = 0;
            if (n5 == this.at) {
                n14 = -1;
            }
            int n15 = c_g.a(n - 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
            int n16 = c_g.a(n + 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
            if (n4 == 4) {
                n14 = -1 - n14;
            }
            int n17 = 5;
            if ((C_x.e[n7] || C_x.e[n15]) && !C_x.e[n8] && !C_x.e[n16]) {
                n17 = 5;
            }
            if ((C_x.e[n8] || C_x.e[n16]) && !C_x.e[n7] && !C_x.e[n15]) {
                n17 = 4;
            }
            return (n4 == n17 ? this.as + 32 : this.as + 64) + n14;
        }
        return this.as;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as - 1 : (n == 0 ? this.as - 1 : (n == 3 ? this.as + 1 : this.as));
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3) {
        int n4 = 0;
        if (c_g.a(n - 1, n2, n3) == this.at) {
            ++n4;
        }
        if (c_g.a(n + 1, n2, n3) == this.at) {
            ++n4;
        }
        if (c_g.a(n, n2, n3 - 1) == this.at) {
            ++n4;
        }
        if (c_g.a(n, n2, n3 + 1) == this.at) {
            ++n4;
        }
        return n4 > 1 ? false : (this.isThereANeighborChest(c_g, n - 1, n2, n3) ? false : (this.isThereANeighborChest(c_g, n + 1, n2, n3) ? false : (this.isThereANeighborChest(c_g, n, n2, n3 - 1) ? false : !this.isThereANeighborChest(c_g, n, n2, n3 + 1))));
    }

    private boolean isThereANeighborChest(C_g c_g, int n, int n2, int n3) {
        return c_g.a(n, n2, n3) != this.at ? false : (c_g.a(n - 1, n2, n3) == this.at ? true : (c_g.a(n + 1, n2, n3) == this.at ? true : (c_g.a(n, n2, n3 - 1) == this.at ? true : c_g.a(n, n2, n3 + 1) == this.at)));
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3) {
        C_c c_c = (C_c)c_g.j(n, n2, n3);
        for (int i = 0; i < c_c.a(); ++i) {
            ItemStack itemStack = c_c.a(i);
            if (itemStack == null) continue;
            float f = this.random.nextFloat() * 0.8f + 0.1f;
            float f2 = this.random.nextFloat() * 0.8f + 0.1f;
            float f3 = this.random.nextFloat() * 0.8f + 0.1f;
            while (itemStack.a > 0) {
                int n4 = this.random.nextInt(21) + 10;
                if (n4 > itemStack.a) {
                    n4 = itemStack.a;
                }
                itemStack.a -= n4;
                NBTTagCompound nBTTagCompound = null;
                if (itemStack.getTagCompound() != null) {
                    nBTTagCompound = itemStack.getTagCompound();
                }
                ItemStack itemStack2 = new ItemStack(itemStack.c, n4, itemStack.d);
                if (nBTTagCompound != null) {
                    itemStack2 = new ItemStack(itemStack.c, n4, itemStack.d, nBTTagCompound);
                }
                C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, itemStack2);
                new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, itemStack2).k = (float)this.random.nextGaussian() * 0.05f;
                c_b.l = (float)this.random.nextGaussian() * 0.05f + 0.2f;
                c_b.m = (float)this.random.nextGaussian() * 0.05f;
                c_g.spawnEntityInWorld(c_b);
            }
        }
        super.b(c_g, n, n2, n3);
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        net.minecraft.a.C_b c_b = (C_c)c_g.j(n, n2, n3);
        if (c_g.b(n, n2 + 1, n3)) {
            return true;
        }
        if (c_g.a(n - 1, n2, n3) == this.at && c_g.b(n - 1, n2 + 1, n3)) {
            return true;
        }
        if (c_g.a(n + 1, n2, n3) == this.at && c_g.b(n + 1, n2 + 1, n3)) {
            return true;
        }
        if (c_g.a(n, n2, n3 - 1) == this.at && c_g.b(n, n2 + 1, n3 - 1)) {
            return true;
        }
        if (c_g.a(n, n2, n3 + 1) == this.at && c_g.b(n, n2 + 1, n3 + 1)) {
            return true;
        }
        if (c_g.a(n - 1, n2, n3) == this.at) {
            c_b = new C_a("Large chest", (C_c)c_g.j(n - 1, n2, n3), c_b);
        }
        if (c_g.a(n + 1, n2, n3) == this.at) {
            c_b = new C_a("Large chest", c_b, (C_c)c_g.j(n + 1, n2, n3));
        }
        if (c_g.a(n, n2, n3 - 1) == this.at) {
            c_b = new C_a("Large chest", (C_c)c_g.j(n, n2, n3 - 1), c_b);
        }
        if (c_g.a(n, n2, n3 + 1) == this.at) {
            c_b = new C_a("Large chest", c_b, (C_c)c_g.j(n, n2, n3 + 1));
        }
        if (c_g.multiplayerWorld) {
            return true;
        }
        entityPlayer.a(c_b);
        return true;
    }

    @Override
    public int a() {
        return 200;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final net.minecraft.a.a.b.a.C_a getBlockEntity() {
        return new C_c();
    }

    public void unifyAdjacentChests(C_g c_g, int n, int n2, int n3) {
        if (!c_g.multiplayerWorld) {
            int n4;
            int n5 = c_g.a(n, n2, n3 - 1);
            int n6 = c_g.a(n, n2, n3 + 1);
            int n7 = c_g.a(n - 1, n2, n3);
            int n8 = c_g.a(n + 1, n2, n3);
            if (n5 != this.at && n6 != this.at) {
                if (n7 != this.at && n8 != this.at) {
                    n4 = 3;
                    if (C_x.e[n5] && !C_x.e[n6]) {
                        n4 = 3;
                    }
                    if (C_x.e[n6] && !C_x.e[n5]) {
                        n4 = 2;
                    }
                    if (C_x.e[n7] && !C_x.e[n8]) {
                        n4 = 5;
                    }
                    if (C_x.e[n8] && !C_x.e[n7]) {
                        n4 = 4;
                    }
                } else {
                    int n9 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 - 1);
                    int n10 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 + 1);
                    n4 = 3;
                    byte by = n7 == this.at ? c_g.e(n - 1, n2, n3) : c_g.e(n + 1, n2, n3);
                    if (by == 2) {
                        n4 = 2;
                    }
                    if ((C_x.e[n5] || C_x.e[n9]) && !C_x.e[n6] && !C_x.e[n10]) {
                        n4 = 3;
                    }
                    if ((C_x.e[n6] || C_x.e[n10]) && !C_x.e[n5] && !C_x.e[n9]) {
                        n4 = 2;
                    }
                }
            } else {
                int n11 = c_g.a(n - 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
                int n12 = c_g.a(n + 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
                n4 = 5;
                byte by = n5 == this.at ? c_g.e(n, n2, n3 - 1) : c_g.e(n, n2, n3 + 1);
                if (by == 4) {
                    n4 = 4;
                }
                if ((C_x.e[n7] || C_x.e[n11]) && !C_x.e[n8] && !C_x.e[n12]) {
                    n4 = 5;
                }
                if ((C_x.e[n8] || C_x.e[n12]) && !C_x.e[n7] && !C_x.e[n11]) {
                    n4 = 4;
                }
            }
            c_g.setBlockMetadataWithNotify(n, n2, n3, n4);
        }
    }
}

