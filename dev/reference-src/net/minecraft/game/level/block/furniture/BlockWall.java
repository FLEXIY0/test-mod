/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public class BlockWall
extends Block {
    private static String[] NAME_LIST = new String[]{"Cobblestone", "Mossy Cobble", "Brick", "Sandstone", "Stone Brick", "Mossy Brick", "Basalt Brick", "Red Sandstone", "Moon Rock", "Basalt"};

    public BlockWall(int n, Block c_x) {
        super(n, c_x.as, c_x.aC);
        this.b(c_x.aL);
        this.a(c_x.aM / 3.0f);
        this.setStepSound(c_x.aA);
        this.hasStates = true;
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
        return 23;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        boolean bl = this.canConnectWallTo(c_g, n, n2, n3 - 1);
        boolean bl2 = this.canConnectWallTo(c_g, n, n2, n3 + 1);
        boolean bl3 = this.canConnectWallTo(c_g, n - 1, n2, n3);
        boolean bl4 = this.canConnectWallTo(c_g, n + 1, n2, n3);
        boolean bl5 = this.canConnectWallTo(c_g, n, n2 + 1, n3);
        float f = 0.25f;
        float f2 = 0.75f;
        float f3 = 0.25f;
        float f4 = 0.75f;
        float f5 = 1.0f;
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
        if (bl && bl2 && !bl3 && !bl4) {
            f5 = bl5 ? 1.0f : 0.8125f;
            f = 0.3125f;
            f2 = 0.6875f;
        } else if (!bl && !bl2 && bl3 && bl4) {
            f5 = bl5 ? 1.0f : 0.8125f;
            f3 = 0.3125f;
            f4 = 0.6875f;
        }
        this.a(f, 0.0f, f3, f2, f5, f4);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        this.ay = 1.5f;
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    public boolean canConnectWallTo(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2, n3);
        if (n4 != this.at && n4 != Block.fenceGateOak.at && n4 != Block.fenceGateBirch.at && n4 != Block.fenceGatePalm.at && n4 != Block.fenceGateSpruce.at && n4 != Block.glassPane.at && n4 != Block.ironBars.at && n4 != Block.coloredPane.at && !c_g.a((float)n, (float)n2, (float)n3)) {
            Block c_x = Block.c[n4];
            return c_x != null && c_x.isOpaqueCube(c_g.e(n, n2, n3)) && c_x.c() ? c_x.aC != Material.pumpkin : false;
        }
        return true;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 9;
    }

    @Override
    public int a(int n, int n2) {
        switch (n2) {
            case 1: {
                return 68;
            }
            case 2: {
                return 7;
            }
            case 3: {
                if (n == 0) {
                    return 302;
                }
                if (n == 1) {
                    return 301;
                }
                return 300;
            }
            case 4: {
                return 394;
            }
            case 5: {
                return 395;
            }
            case 6: {
                return 454;
            }
            case 7: {
                if (n == 0) {
                    return 453;
                }
                if (n == 1) {
                    return 452;
                }
                return 451;
            }
            case 8: {
                return 258;
            }
            case 9: {
                return 424;
            }
        }
        return 32;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[n] + " Wall";
    }
}

