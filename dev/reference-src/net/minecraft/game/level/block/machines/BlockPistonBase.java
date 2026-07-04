/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_d;
import net.minecraft.a.a.b.a.C_j;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockContainer;
import net.minecraft.game.level.block.machines.BlockPistonMoving;
import util.MathHelper;

public class BlockPistonBase
extends C_x {
    private boolean isSticky;
    private boolean editing;

    public BlockPistonBase(int n, int n2, boolean bl, boolean bl2) {
        super(n, n2, C_c.pulley);
        this.isSticky = bl;
        this.editing = bl2;
        this.setStepSound(aG);
        this.b(2.0f);
    }

    public int getPistonExtensionTexture() {
        return this.isSticky ? 576 : 577;
    }

    @Override
    public int a(int n, int n2) {
        int n3 = BlockPistonBase.getOrientation(n2);
        return n3 > 5 ? this.as : (n == n3 ? (!BlockPistonBase.isExtended(n2) && this.au <= 0.0f && this.av <= 0.0f && this.aw <= 0.0f && this.ax >= 1.0f && this.ay >= 1.0f && this.az >= 1.0f ? this.as : (this.isSticky ? 609 : 580)) : (n == C_d.faceToSide[n3] ? (this.isSticky ? 608 : 579) : (this.isSticky ? 610 : 578)));
    }

    @Override
    public int a(int n) {
        if (n == 1) {
            return this.isSticky ? 576 : 577;
        }
        if (n == 0) {
            return this.isSticky ? 608 : 579;
        }
        return this.isSticky ? 610 : 578;
    }

    @Override
    public int a() {
        return 27;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public int a(int n, Random random) {
        if (this.at == C_x.pulleyBaseActive.at) {
            return C_x.pulleyBase.at;
        }
        if (this.at == C_x.pulleyStickyBaseActive.at) {
            return C_x.pulleyStickyBase.at;
        }
        return this.at;
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        byte by = c_g.e(n, n2, n3);
        int n4 = BlockPistonBase.getOrientation(by);
        boolean bl = this.isIndirectlyPowered(c_g, n, n2, n3, n4);
        if (!bl && !c_g.multiplayerWorld) {
            if (by != 7) {
                if (!BlockPistonBase.isExtended(by)) {
                    if (BlockPistonBase.canExtend(c_g, n, n2, n3, n4)) {
                        int n5 = C_x.pulleyBase.at;
                        n5 = this.at == n5 ? C_x.pulleyBaseActive.at : (this.at == C_x.pulleyBaseActive.at ? C_x.pulleyBase.at : C_x.pulleyStickyBaseActive.at);
                        c_g.setBlockAndMetadata(n, n2, n3, n5, n4 | 8);
                        c_g.powerBlock(n, n2, n3, 0, n4);
                        entityPlayer.addStat(StatList.pistonUse, 1);
                    }
                } else if (BlockPistonBase.isExtended(by)) {
                    int n6 = C_x.pulleyBaseActive.at;
                    n6 = this.at == n6 ? C_x.pulleyBase.at : (this.at == C_x.pulleyBase.at ? C_x.pulleyBaseActive.at : C_x.pulleyStickyBase.at);
                    c_g.setBlockAndMetadata(n, n2, n3, n6, n4);
                    c_g.powerBlock(n, n2, n3, 1, n4);
                    entityPlayer.addStat(StatList.pistonUse, 1);
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public void onBlockPlacedByPlayer(C_g c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        int n5 = BlockPistonBase.determineOrientation(c_g, n, n2, n3, entityPlayer);
        c_g.setBlockMetadataWithNotify(n, n2, n3, n5);
        this.updatePistonState(c_g, n, n2, n3);
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (this.editing) {
            this.updatePistonStateReverse(c_g, n, n2, n3);
        } else {
            this.updatePistonState(c_g, n, n2, n3);
        }
    }

    private void updatePistonState(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        int n4 = BlockPistonBase.getOrientation(by);
        boolean bl = this.isIndirectlyPowered(c_g, n, n2, n3, n4);
        if (by != 7) {
            if (bl && !BlockPistonBase.isExtended(by)) {
                if (BlockPistonBase.canExtend(c_g, n, n2, n3, n4)) {
                    c_g.setBlockMetadata(n, n2, n3, n4 | 8);
                    c_g.powerBlock(n, n2, n3, 0, n4);
                }
            } else if (!bl && BlockPistonBase.isExtended(by)) {
                c_g.setBlockMetadata(n, n2, n3, n4);
                c_g.powerBlock(n, n2, n3, 1, n4);
            }
        }
    }

    private void updatePistonStateReverse(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        int n4 = BlockPistonBase.getOrientation(by);
        boolean bl = c_g.isBlockIndirectlyGettingPowered(n, n2, n3);
        if (by != 7) {
            if (!bl && !BlockPistonBase.isExtended(by)) {
                if (BlockPistonBase.canExtend(c_g, n, n2, n3, n4)) {
                    c_g.setBlockMetadata(n, n2, n3, n4 | 8);
                    c_g.powerBlock(n, n2, n3, 0, n4);
                }
            } else if (bl && BlockPistonBase.isExtended(by)) {
                c_g.setBlockMetadata(n, n2, n3, n4);
                c_g.powerBlock(n, n2, n3, 1, n4);
            }
        }
    }

    private boolean isIndirectlyPowered(C_g c_g, int n, int n2, int n3, int n4) {
        return n4 != 0 && c_g.isBlockIndirectlyProvidingPowerTo(n, n2 - 1, n3, 0) ? true : (n4 != 1 && c_g.isBlockIndirectlyProvidingPowerTo(n, n2 + 1, n3, 1) ? true : (n4 != 2 && c_g.isBlockIndirectlyProvidingPowerTo(n, n2, n3 - 1, 2) ? true : (n4 != 3 && c_g.isBlockIndirectlyProvidingPowerTo(n, n2, n3 + 1, 3) ? true : (n4 != 5 && c_g.isBlockIndirectlyProvidingPowerTo(n + 1, n2, n3, 5) ? true : (n4 != 4 && c_g.isBlockIndirectlyProvidingPowerTo(n - 1, n2, n3, 4) ? true : (c_g.isBlockIndirectlyProvidingPowerTo(n, n2, n3, 0) ? true : (c_g.isBlockIndirectlyProvidingPowerTo(n, n2 + 2, n3, 1) ? true : (c_g.isBlockIndirectlyProvidingPowerTo(n, n2 + 1, n3 - 1, 2) ? true : (c_g.isBlockIndirectlyProvidingPowerTo(n, n2 + 1, n3 + 1, 3) ? true : (c_g.isBlockIndirectlyProvidingPowerTo(n - 1, n2 + 1, n3, 4) ? true : c_g.isBlockIndirectlyProvidingPowerTo(n + 1, n2 + 1, n3, 5)))))))))));
    }

    @Override
    public void powerBlock(C_g c_g, int n, int n2, int n3, int n4, int n5) {
        if (n4 == 0) {
            if (this.tryExtend(c_g, n, n2, n3, n5)) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, n5 | 8);
                c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "tile.piston.out", 0.5f, c_g.q.nextFloat() * 0.25f + 0.6f);
            } else {
                c_g.setBlockMetadata(n, n2, n3, n5);
            }
        } else if (n4 == 1) {
            C_a c_a = c_g.j(n + C_d.offsetsXForSide[n5], n2 + C_d.offsetsYForSide[n5], n3 + C_d.offsetsZForSide[n5]);
            if (c_a != null && c_a instanceof C_j) {
                ((C_j)c_a).clearPistonTileEntity();
            }
            c_g.setBlockAndMetadata(n, n2, n3, C_x.pulleyMoving.at, n5);
            c_g.a(n, n2, n3, BlockPistonMoving.getTileEntity(this.at, n5, n5, false, true));
            if (this.isSticky) {
                C_j c_j;
                C_a c_a2;
                int n6 = n + C_d.offsetsXForSide[n5] * 2;
                int n7 = n2 + C_d.offsetsYForSide[n5] * 2;
                int n8 = n3 + C_d.offsetsZForSide[n5] * 2;
                int n9 = c_g.a(n6, n7, n8);
                int n10 = c_g.e(n6, n7, n8);
                boolean bl = false;
                if (n9 == C_x.pulleyMoving.at && (c_a2 = c_g.j(n6, n7, n8)) != null && c_a2 instanceof C_j && (c_j = (C_j)c_a2).getPistonOrientation() == n5 && c_j.isExtending()) {
                    c_j.clearPistonTileEntity();
                    n9 = c_j.getStoredBlockID();
                    n10 = c_j.getBlockMetadata();
                    bl = true;
                }
                if (!bl && n9 > 0 && BlockPistonBase.canPushBlock(n9, c_g, n6, n7, n8, false) && (C_x.c[n9].getMobilityFlag() == 0 || n9 == C_x.pulleyBase.at || n9 == C_x.pulleyStickyBase.at || n9 == C_x.pulleyBaseActive.at || n9 == C_x.pulleyStickyBaseActive.at)) {
                    c_g.setBlockAndMetadata(n += C_d.offsetsXForSide[n5], n2 += C_d.offsetsYForSide[n5], n3 += C_d.offsetsZForSide[n5], C_x.pulleyMoving.at, n10);
                    c_g.a(n, n2, n3, BlockPistonMoving.getTileEntity(n9, n10, n5, false, false));
                    c_g.b(n6, n7, n8, 0);
                } else if (!bl) {
                    c_g.b(n + C_d.offsetsXForSide[n5], n2 + C_d.offsetsYForSide[n5], n3 + C_d.offsetsZForSide[n5], 0);
                }
            } else {
                c_g.b(n + C_d.offsetsXForSide[n5], n2 + C_d.offsetsYForSide[n5], n3 + C_d.offsetsZForSide[n5], 0);
            }
            c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "tile.piston.in", 0.5f, c_g.q.nextFloat() * 0.15f + 0.6f);
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        if (BlockPistonBase.isExtended(by)) {
            switch (BlockPistonBase.getOrientation(by)) {
                case 0: {
                    this.a(0.0f, 0.25f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
                    break;
                }
                case 2: {
                    this.a(0.0f, 0.0f, 0.25f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.75f);
                    break;
                }
                case 4: {
                    this.a(0.25f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 5: {
                    this.a(0.0f, 0.0f, 0.0f, 0.75f, 1.0f, 1.0f);
                }
            }
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public void setBlockBoundsForItemRender(int n) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void getCollidingBoundingBoxes(C_g c_g, int n, int n2, int n3, C_b c_b, ArrayList<C_b> arrayList) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public boolean c() {
        return false;
    }

    public static int getOrientation(int n) {
        return n & 7;
    }

    public static boolean isExtended(int n) {
        return (n & 8) != 0;
    }

    private static int determineOrientation(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4;
        if (MathHelper.e(entityPlayer.h - (float)n) < 2.0f && MathHelper.e(entityPlayer.j - (float)n3) < 2.0f) {
            double d2 = (double)entityPlayer.i + 1.82 - (double)entityPlayer.v;
            if (d2 - (double)n2 > 2.0) {
                return 1;
            }
            if ((double)n2 - d2 > 0.0) {
                return 0;
            }
        }
        return (n4 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3) == 0 ? 2 : (n4 == 1 ? 5 : (n4 == 2 ? 3 : (n4 == 3 ? 4 : 0)));
    }

    private static boolean canPushBlock(int n, C_g c_g, int n2, int n3, int n4, boolean bl) {
        if (n2 <= 1 || n3 <= 1 || n4 <= 1 || n2 >= c_g.a - 2 || n3 >= c_g.c - 2 || n4 >= c_g.b - 2) {
            return false;
        }
        if (n == C_x.ae.at) {
            return false;
        }
        if (n != C_x.pulleyBase.at && n != C_x.pulleyStickyBase.at && n != C_x.pulleyBaseActive.at && n != C_x.pulleyStickyBaseActive.at) {
            if (C_x.c[n].getHardness() == -1.0f) {
                return false;
            }
            if (C_x.c[n].getMobilityFlag() == 2) {
                return false;
            }
            if (!bl && C_x.c[n].getMobilityFlag() == 1) {
                return false;
            }
        } else if (BlockPistonBase.isExtended(c_g.e(n2, n3, n4))) {
            return false;
        }
        return !(C_x.c[n] instanceof BlockContainer);
    }

    private static boolean canExtend(C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = n + C_d.offsetsXForSide[n4];
        int n6 = n2 + C_d.offsetsYForSide[n4];
        int n7 = n3 + C_d.offsetsZForSide[n4];
        if (n <= 1 || n2 <= 1 || n3 <= 1 || n >= c_g.a - 2 || n2 >= c_g.c - 2 || n3 >= c_g.b - 2) {
            return false;
        }
        for (int i = 0; i < 13; ++i) {
            if (n6 <= 0 || n6 >= c_g.c) {
                return false;
            }
            int n8 = c_g.a(n5, n6, n7);
            if (n8 == 0) break;
            if (!BlockPistonBase.canPushBlock(n8, c_g, n5, n6, n7, true)) {
                return false;
            }
            if (C_x.c[n8].getMobilityFlag() == 1) break;
            if (i == 12) {
                return false;
            }
            n5 += C_d.offsetsXForSide[n4];
            n6 += C_d.offsetsYForSide[n4];
            n7 += C_d.offsetsZForSide[n4];
        }
        return true;
    }

    private boolean tryExtend(C_g c_g, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = n + C_d.offsetsXForSide[n4];
        int n8 = n2 + C_d.offsetsYForSide[n4];
        int n9 = n3 + C_d.offsetsZForSide[n4];
        if (n <= 1 || n2 <= 1 || n3 <= 1 || n >= c_g.a - 2 || n2 >= c_g.c - 2 || n3 >= c_g.b - 2) {
            return false;
        }
        for (n6 = 0; n6 < 13; ++n6) {
            if (n8 <= 0 || n8 >= c_g.c) {
                return false;
            }
            n5 = c_g.a(n7, n8, n9);
            if (n5 == 0) break;
            if (!BlockPistonBase.canPushBlock(n5, c_g, n7, n8, n9, true)) {
                return false;
            }
            if (C_x.c[n5].getMobilityFlag() != 1) {
                if (n6 == 12) {
                    return false;
                }
                n7 += C_d.offsetsXForSide[n4];
                n8 += C_d.offsetsYForSide[n4];
                n9 += C_d.offsetsZForSide[n4];
                continue;
            }
            C_x.c[n5].f(c_g, n7, n8, n9, c_g.e(n7, n8, n9));
            if (n5 == C_x.ao.at) {
                C_x.c[n5].c(c_g, n7, n8, n9, c_g.e(n7, n8, n9));
            }
            c_g.b(n7, n8, n9, 0);
            break;
        }
        while (n7 != n || n8 != n2 || n9 != n3) {
            n6 = n7 - C_d.offsetsXForSide[n4];
            n5 = n8 - C_d.offsetsYForSide[n4];
            int n10 = n9 - C_d.offsetsZForSide[n4];
            int n11 = c_g.a(n6, n5, n10);
            byte by = c_g.e(n6, n5, n10);
            if (n11 == this.at && n6 == n && n5 == n2 && n10 == n3) {
                c_g.setBlockAndMetadata(n7, n8, n9, C_x.pulleyMoving.at, n4 | (this.isSticky ? 8 : 0));
                c_g.a(n7, n8, n9, BlockPistonMoving.getTileEntity(C_x.pulleyExtension.at, n4 | (this.isSticky ? 8 : 0), n4, true, false));
            } else {
                c_g.setBlockAndMetadata(n7, n8, n9, C_x.pulleyMoving.at, by);
                c_g.a(n7, n8, n9, BlockPistonMoving.getTileEntity(n11, by, n4, true, false));
            }
            n7 = n6;
            n8 = n5;
            n9 = n10;
        }
        return true;
    }
}

