/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.furniture.BlockFenceGate;

public class BlockFence
extends Block {
    private static String[] NAME_LIST = new String[]{"Oak", "Birch", "Palm", "Pine"};

    public BlockFence(int n, int n2) {
        super(n, n2, Material.c);
        this.hasStates = true;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        boolean bl = this.canConnectFenceTo(c_g, n, n2, n3 - 1);
        boolean bl2 = this.canConnectFenceTo(c_g, n, n2, n3 + 1);
        boolean bl3 = this.canConnectFenceTo(c_g, n - 1, n2, n3);
        boolean bl4 = this.canConnectFenceTo(c_g, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        return C_b.getAABBPool().addOrModifyAABBInPool((float)n + f, n2, (float)n3 + f3, (float)n + f2, (float)n2 + 1.5f, (float)n3 + f4);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        boolean bl = this.canConnectFenceTo(c_g, n, n2, n3 - 1);
        boolean bl2 = this.canConnectFenceTo(c_g, n, n2, n3 + 1);
        boolean bl3 = this.canConnectFenceTo(c_g, n - 1, n2, n3);
        boolean bl4 = this.canConnectFenceTo(c_g, n + 1, n2, n3);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        this.a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    public boolean canConnectFenceTo(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        Block c_x = Block.c[n4];
        if (n4 != this.at && !(c_x instanceof BlockFenceGate)) {
            Block c_x2 = Block.c[n4];
            return c_x2 != null && c_x2.c();
        }
        return true;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int a() {
        return 11;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 3;
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 1: {
                return 328;
            }
            case 2: {
                return 360;
            }
            case 3: {
                return 392;
            }
        }
        return 4;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n] + " Fence";
    }
}

