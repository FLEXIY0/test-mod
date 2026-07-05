/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;

public class C_av
extends Block {
    protected C_av(int n) {
        super(n, C_c.c);
        this.as = 673;
        this.hasStates = true;
    }

    @Override
    public final int a(Random random) {
        return 0;
    }

    @Override
    public int a() {
        return 24;
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
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
    public int a(int n, int n2) {
        int n3 = n2 & 0xC;
        return n3 == 0 && (n == 1 || n == 0) ? 674 : (n3 == 4 && (n == 5 || n == 4) ? 674 : (n3 == 8 && (n == 2 || n == 3) ? 674 : 673));
    }

    @Override
    public boolean canCompost() {
        return true;
    }
}

