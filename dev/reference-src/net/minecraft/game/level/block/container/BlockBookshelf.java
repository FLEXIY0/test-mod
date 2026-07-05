/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import com.a.a.NBTTagCompound;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_f;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;

public final class BlockBookshelf
extends BlockContainer {
    private Random random = new Random();

    public BlockBookshelf(int n, int n2) {
        super(n, C_c.c);
        this.as = n2;
        this.hasStates = true;
    }

    @Override
    public final int a(int n) {
        return n <= 1 ? 4 : this.as;
    }

    @Override
    public final int a(int n, int n2) {
        if (n2 >= 8) {
            return n <= 1 ? 4 : 67;
        }
        return n <= 1 ? 4 : this.as + n2;
    }

    @Override
    public int a(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (by >= 8) {
            return n4 <= 1 ? 4 : 67;
        }
        return n4 <= 1 ? 4 : this.as + by;
    }

    @Override
    public String getBlockName(int n) {
        return "Bookshelf";
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3) {
        C_f c_f = (C_f)c_g.j(n, n2, n3);
        for (int i = 0; i < c_f.a(); ++i) {
            ItemStack itemStack = c_f.a(i);
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
    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        C_f c_f = (C_f)c_g.j(n, n2, n3);
        if (c_g.multiplayerWorld) {
            return true;
        }
        entityPlayer.displayGUIBookshelf(c_f);
        return true;
    }

    @Override
    public final TileEntity getBlockEntity() {
        return new C_f();
    }
}

