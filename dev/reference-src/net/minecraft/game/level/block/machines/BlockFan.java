/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class BlockFan
extends Block {
    public BlockFan(int n, int n2) {
        super(n, n2, Material.e);
    }

    @Override
    public void g(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            int n5 = MathHelper.a((double)(c_g.y.n * 4.0f / 360.0f) + 0.5) & 3;
            if (n5 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
            }
            if (n5 == 1) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 5);
            }
            if (n5 == 2) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
            }
            if (n5 == 3) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 4);
            }
        }
    }

    @Override
    public final int a(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.g(c_g, n, n2, n3, n4);
            by = c_g.e(n, n2, n3);
        }
        if (by >= 6) {
            switch (n4) {
                case 2: {
                    if (by == 6) {
                        return this.as + 2;
                    }
                    return this.as;
                }
                case 3: {
                    if (by == 7) {
                        return this.as + 2;
                    }
                    return this.as;
                }
                case 4: {
                    if (by == 8) {
                        return this.as + 2;
                    }
                    return this.as;
                }
                case 5: {
                    if (by == 9) {
                        return this.as + 2;
                    }
                    return this.as;
                }
            }
        }
        return n4 != by ? this.as : (c_g.e(n, n2, n3) >= 6 ? this.as + 2 : this.as + 1);
    }

    @Override
    public final int a(int n) {
        return n == 3 ? this.as + 1 : this.as;
    }

    @Override
    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            this.updateStateWhenPowered(c_g, n, n2, n3, n4);
        }
    }

    private void updateStateWhenPowered(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if (c_g.isBlockIndirectlyGettingPowered(n, n2, n3) && by < 6) {
            c_g.setBlockMetadata(n, n2, n3, by + 4);
        } else if (!c_g.isBlockIndirectlyGettingPowered(n, n2, n3) && by >= 6) {
            c_g.setBlockMetadata(n, n2, n3, by - 4);
        }
    }
}

