/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_k;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockJukeBox
extends BlockContainer {
    public BlockJukeBox(int n, int n2) {
        super(n, Material.c);
        this.as = n2;
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            return this.as + 1;
        }
        if (n4 == 0) {
            return this.as + 2;
        }
        return this.as;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as + 1 : (n == 0 ? this.as + 2 : this.as);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.e(n, n2, n3) == 0) {
            return false;
        }
        this.playMusic(c_g, n, n2, n3);
        return true;
    }

    public void ejectRecord(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            C_k c_k = (C_k)c_g.j(n, n2, n3);
            c_k.record = n4;
            c_k.onInventoryChanged();
            c_g.setBlockMetadataWithNotify(n, n2, n3, 1);
        }
    }

    public void playMusic(World c_g, int n, int n2, int n3) {
        if (!c_g.multiplayerWorld) {
            C_k c_k = (C_k)c_g.j(n, n2, n3);
            int n4 = c_k.record;
            if (n4 != 0) {
                c_g.playRecord(null, n, n2, n3);
                c_k.record = 0;
                c_k.onInventoryChanged();
                c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
                float f = 0.7f;
                float f2 = c_g.q.nextFloat() * f + (1.0f - f) * 0.5f;
                float f3 = c_g.q.nextFloat() * f + (1.0f - f) * 0.2f + 0.6f;
                float f4 = c_g.q.nextFloat() * f + (1.0f - f) * 0.5f;
                EntityItem c_b = new EntityItem(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n4, 1, 0));
                c_b.O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        this.playMusic(c_g, n, n2, n3);
        super.b(c_g, n, n2, n3);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            super.a(c_g, n, n2, n3, n4, f);
        }
    }

    @Override
    public TileEntity getBlockEntity() {
        return new C_k();
    }
}

