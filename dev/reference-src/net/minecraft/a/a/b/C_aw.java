/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.a.C_n;
import net.minecraft.a.c.e.EntityPlayer;

public class C_aw
extends C_x {
    protected C_aw(int n, int n2) {
        super(n, C_c.pumpkin);
        this.as = n2;
        this.a(true);
    }

    @Override
    public int a(int n, int n2) {
        int n3;
        if (n2 < 0) {
            n2 = 0;
        }
        return (n3 = n2 & 0xC) == 0 && (n == 1 || n == 0) ? this.as + 1 : (n3 == 4 && (n == 5 || n == 4) ? this.as + 1 : (n3 == 8 && (n == 2 || n == 3) ? this.as + 1 : this.as));
    }

    @Override
    public int a() {
        return 24;
    }

    @Override
    public int a(Random random) {
        if (this.at == 85) {
            return 4;
        }
        return 1;
    }

    @Override
    public int a(int n, Random random) {
        if (this.at == 85) {
            return Item.melonSlice.ap;
        }
        return this.at;
    }

    @Override
    public int a(int n) {
        return n == 1 ? this.as : (n == 0 ? this.as : (n == 3 ? this.as + 1 + 32 : this.as + 32));
    }

    @Override
    public void d(C_g c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        if (this.at == C_x.pumpkin.at && c_g.a(n, n2 - 1, n3) == C_x.snowBlock.at && c_g.a(n, n2 - 2, n3) == C_x.snowBlock.at) {
            c_g.a(n, n2, n3, 0);
            c_g.a(n, n2 - 1, n3, 0);
            c_g.a(n, n2 - 2, n3, 0);
            c_g.spawnEntityInWorld(new C_n(c_g, n, n2, n3));
        }
    }

    @Override
    public void g(C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = ((EntityPlayer)c_g.y).b.d().d & 3;
        byte by = 0;
        switch (n4) {
            case 0: 
            case 1: {
                by = (byte)n5;
                break;
            }
            case 2: 
            case 3: {
                by = (byte)(n5 + 8);
                break;
            }
            case 4: 
            case 5: {
                by = (byte)(n5 + 4);
            }
        }
        c_g.setBlockMetadataWithNotify(n, n2, n3, by);
    }

    @Override
    public boolean canExist(C_g c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        return (n4 == 0 || C_x.c[n4].getMaterial(0).a()) && c_g.b(n, n2 - 1, n3);
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

