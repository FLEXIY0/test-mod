/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_e;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;

public final class BlockBarrel
extends BlockContainer {
    private Random random = new Random();

    public BlockBarrel(int n) {
        super(n, C_c.c);
        this.as = 193;
    }

    @Override
    public int a() {
        return 33;
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
            case 2: {
                by = (byte)(n5 + 6);
                break;
            }
            case 3: {
                by = (byte)(n5 + 8);
                break;
            }
            case 4: {
                by = (byte)(n5 + 2);
                break;
            }
            case 5: {
                by = (byte)(n5 + 4);
            }
        }
        c_g.setBlockMetadataWithNotify(n, n2, n3, by);
    }

    @Override
    public int a(int n, int n2) {
        int n3 = n2;
        return n3 == 0 && n == 1 ? this.as + 1 : (n3 == 0 && n == 0 ? this.as + 2 : (n3 == 2 && n == 4 ? this.as + 1 : (n3 == 2 && n == 5 ? this.as + 2 : (n3 == 6 && n == 2 ? this.as + 1 : (n3 == 6 && n == 3 ? this.as + 2 : (n3 == 4 && n == 5 ? this.as + 1 : (n3 == 4 && n == 4 ? this.as + 2 : (n3 == 8 && n == 3 ? this.as + 1 : (n3 == 8 && n == 2 ? this.as + 2 : this.as)))))))));
    }

    @Override
    public final void b(C_g c_g, int n, int n2, int n3) {
        C_e c_e = (C_e)c_g.j(n, n2, n3);
        boolean bl = true;
        if (c_g.gamemode == 0) {
            for (int i = 0; i < c_e.a(); ++i) {
                if (c_e.a(i) == null) continue;
                bl = false;
                break;
            }
            float f = this.random.nextFloat() * 0.8f + 0.1f;
            float f2 = this.random.nextFloat() * 0.8f + 0.1f;
            float f3 = this.random.nextFloat() * 0.8f + 0.1f;
            ItemStack itemStack = new ItemStack(this.at, 1, 0);
            if (!bl) {
                c_g.storeTEInStack(itemStack, c_e);
            }
            C_b c_b = new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, itemStack);
            new C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, itemStack).k = (float)this.random.nextGaussian() * 0.05f;
            c_b.l = (float)this.random.nextGaussian() * 0.05f + 0.2f;
            c_b.m = (float)this.random.nextGaussian() * 0.05f;
            c_g.spawnEntityInWorld(c_b);
        }
        super.b(c_g, n, n2, n3);
    }

    @Override
    public void a(C_g c_g, int n, int n2, int n3, int n4, float f) {
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        C_e c_e = (C_e)c_g.j(n, n2, n3);
        if (c_g.multiplayerWorld) {
            return true;
        }
        entityPlayer.displayGUIBarrel(c_e, false);
        return true;
    }

    @Override
    public final C_a getBlockEntity() {
        return new C_e();
    }
}

