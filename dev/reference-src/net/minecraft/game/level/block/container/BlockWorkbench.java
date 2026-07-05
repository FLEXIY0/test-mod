/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.c.e.EntityPlayer;

public final class BlockWorkbench
extends Block {
    public BlockWorkbench(int n) {
        super(58, Material.c);
        this.as = 107;
    }

    @Override
    public final int a(int n) {
        return n == 1 ? this.as - 32 : (n == 0 ? Block.m.a(0) : (n != 2 && n != 4 ? this.as : this.as + 1));
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return true;
        }
        entityPlayer.displayWorkbenchGUI(n, n2, n3);
        return true;
    }
}

