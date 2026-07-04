/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public class BlockObserver
extends C_x {
    public BlockObserver(int n, C_c c_c) {
        super(n, c_c);
        this.as = 716;
        this.a(true);
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 != C_x.generatorActive.at && n4 != C_x.generator.at && c_g.e(n, n2, n3) != 4 && !c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, 4);
            c_g.e(n, n2, n3, n4);
        }
    }

    @Override
    public void a(C_g c_g, int n, int n2, int n3, Random random) {
        if (!c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, 0);
        }
    }

    @Override
    public int e() {
        return 1;
    }

    @Override
    public int a(int n, int n2) {
        if (n == 1 || n == 0) {
            return 718;
        }
        return 716;
    }

    @Override
    public final int a(C_g c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1 || n4 == 0) {
            return 718;
        }
        byte by = c_g.e(n, n2, n3);
        return by == 4 ? 717 : 716;
    }
}

