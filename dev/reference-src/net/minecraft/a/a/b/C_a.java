/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.C_b;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_q;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_a
extends C_q {
    private Random a = new Random();

    protected C_a(int n) {
        super(54, net.minecraft.a.a.d.Material.c);
        this.as = 26;
    }

    public final int a(World c_g, int n, int n2, int n3, int n4) {
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
        if (n5 == this.at || n6 == this.at) {
            if (n4 == 2 || n4 == 3) {
                return this.as;
            }
            int n9 = 0;
            if (n5 == this.at) {
                n9 = -1;
            }
            int n10 = c_g.a(n - 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
            int n11 = c_g.a(n + 1, n2, n5 == this.at ? n3 - 1 : n3 + 1);
            if (n4 == 4) {
                n9 = -1 - n9;
            }
            n = 5;
            if ((Block.e[n7] || Block.e[n10]) && !Block.e[n8] && !Block.e[n11]) {
                n = 5;
            }
            if ((Block.e[n8] || Block.e[n11]) && !Block.e[n7] && !Block.e[n10]) {
                n = 4;
            }
            return (n4 == n ? this.as + 16 : this.as + 32) + n9;
        }
        if (n7 == this.at || n8 == this.at) {
            if (n4 == 4 || n4 == 5) {
                return this.as;
            }
            int n12 = 0;
            if (n7 == this.at) {
                n12 = -1;
            }
            int n13 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 - 1);
            int n14 = c_g.a(n7 == this.at ? n - 1 : n + 1, n2, n3 + 1);
            if (n4 == 3) {
                n12 = -1 - n12;
            }
            n = 3;
            if ((Block.e[n5] || Block.e[n13]) && !Block.e[n6] && !Block.e[n14]) {
                n = 3;
            }
            if ((Block.e[n6] || Block.e[n14]) && !Block.e[n5] && !Block.e[n13]) {
                n = 2;
            }
            return (n4 == n ? this.as + 16 : this.as + 32) + n12;
        }
        int n15 = 3;
        if (Block.e[n5] && !Block.e[n6]) {
            n15 = 3;
        }
        if (Block.e[n6] && !Block.e[n5]) {
            n15 = 2;
        }
        if (Block.e[n7] && !Block.e[n8]) {
            n15 = 5;
        }
        if (Block.e[n8] && !Block.e[n7]) {
            n15 = 4;
        }
        if (n4 == n15) {
            return this.as + 1;
        }
        return this.as;
    }

    public final int a(int n) {
        if (n == 1) {
            return this.as - 1;
        }
        if (n == 0) {
            return this.as - 1;
        }
        if (n == 3) {
            return this.as + 1;
        }
        return this.as;
    }

    public final boolean a(World c_g, int n, int n2, int n3) {
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
        if (n4 > 1) {
            return false;
        }
        if (this.e(c_g, n - 1, n2, n3)) {
            return false;
        }
        if (this.e(c_g, n + 1, n2, n3)) {
            return false;
        }
        if (this.e(c_g, n, n2, n3 - 1)) {
            return false;
        }
        return !this.e(c_g, n, n2, n3 + 1);
    }

    private boolean e(World c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2, n3) != this.at) {
            return false;
        }
        if (c_g.a(n - 1, n2, n3) == this.at) {
            return true;
        }
        if (c_g.a(n + 1, n2, n3) == this.at) {
            return true;
        }
        if (c_g.a(n, n2, n3 - 1) == this.at) {
            return true;
        }
        return c_g.a(n, n2, n3 + 1) == this.at;
    }

    public final void b(World c_g, int n, int n2, int n3) {
        C_c c_c = (C_c)c_g.j(n, n2, n3);
        for (int i = 0; i < c_c.a(); ++i) {
            ItemStack itemStack = c_c.a(i);
            if (itemStack == null) continue;
            float f = this.a.nextFloat() * 0.8f + 0.1f;
            float f2 = this.a.nextFloat() * 0.8f + 0.1f;
            float f3 = this.a.nextFloat() * 0.8f + 0.1f;
            while (itemStack.a > 0) {
                int n4 = this.a.nextInt(21) + 10;
                if (n4 > itemStack.a) {
                    n4 = itemStack.a;
                }
                itemStack.a -= n4;
                net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.d));
                new net.minecraft.a.c.c.EntityItem(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(itemStack.c, n4, itemStack.d)).k = (float)this.a.nextGaussian() * 0.05f;
                c_b.l = (float)this.a.nextGaussian() * 0.05f + 0.2f;
                c_b.m = (float)this.a.nextGaussian() * 0.05f;
                c_g.a(c_b);
            }
        }
        super.b(c_g, n, n2, n3);
    }

    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        C_b c_b = (C_c)c_g.j(n, n2, n3);
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
            c_b = new net.minecraft.a.C_a("Large chest", (C_c)c_g.j(n - 1, n2, n3), c_b);
        }
        if (c_g.a(n + 1, n2, n3) == this.at) {
            c_b = new net.minecraft.a.C_a("Large chest", c_b, (C_c)c_g.j(n + 1, n2, n3));
        }
        if (c_g.a(n, n2, n3 - 1) == this.at) {
            c_b = new net.minecraft.a.C_a("Large chest", (C_c)c_g.j(n, n2, n3 - 1), c_b);
        }
        if (c_g.a(n, n2, n3 + 1) == this.at) {
            c_b = new net.minecraft.a.C_a("Large chest", c_b, (C_c)c_g.j(n, n2, n3 + 1));
        }
        entityPlayer.a(c_b);
        return true;
    }

    protected final net.minecraft.a.a.b.a.TileEntity a_() {
        return new C_c();
    }
}

