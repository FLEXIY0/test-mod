/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.a.a.World;
import net.minecraft.a.a.C_k;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public final class BlockGears
extends Block {
    private boolean providePower = true;
    private Set<C_k> blocksNeedingUpdate = new HashSet<C_k>();

    public BlockGears(int n, int n2) {
        super(n, n2, Material.n);
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int getMobilityFlag() {
        return 2;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        boolean bl = this.canConnectTo(c_g, n, n2, n3 - 1);
        boolean bl2 = this.canConnectTo(c_g, n, n2, n3 + 1);
        boolean bl3 = this.canConnectTo(c_g, n - 1, n2, n3);
        boolean bl4 = this.canConnectTo(c_g, n + 1, n2, n3);
        boolean bl5 = this.canConnectTo(c_g, n, n2 - 1, n3);
        boolean bl6 = this.canConnectTo(c_g, n, n2 + 1, n3);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        float f7 = 0.125f;
        if (!(!bl5 || bl || bl2 || bl3 || bl4 || bl6)) {
            f3 = 0.0f;
            f4 = f7;
        }
        if (!(!bl6 || bl || bl2 || bl3 || bl4 || bl5)) {
            f3 = 1.0f - f7;
            f4 = 1.0f;
        }
        if (!(!bl || bl2 || bl3 || bl4 || bl6 || bl5)) {
            f5 = 0.0f;
            f6 = f7;
        }
        if (!(!bl2 || bl || bl3 || bl4 || bl6 || bl5)) {
            f5 = 1.0f - f7;
            f6 = 1.0f;
        }
        if (!(!bl3 || bl4 || bl || bl2 || bl6 || bl5)) {
            f = 0.0f;
            f2 = f7;
        }
        if (!(!bl4 || bl3 || bl || bl2 || bl6 || bl5)) {
            f = 1.0f - f7;
            f2 = 1.0f;
        }
        this.a(f, f3, f5, f2, f4, f6);
    }

    public boolean canConnectTo(World c_g, int n, int n2, int n3) {
        return c_g.a((float)n, (float)n2, (float)n3);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.b(n - 1, n2, n3) ? true : (c_g.b(n, n2 - 1, n3) ? true : (c_g.b(n, n2 + 1, n3) ? true : (c_g.b(n + 1, n2, n3) ? true : (c_g.b(n, n2, n3 - 1) ? true : c_g.b(n, n2, n3 + 1)))));
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        super.b(c_g, n, n2, n3, n4);
        if (!c_g.multiplayerWorld) {
            boolean bl = this.a(c_g, n, n2, n3);
            if (bl) {
                this.updateAndPropagateCurrentStrength(c_g, n, n2, n3);
            } else {
                this.dropGear(c_g, n, n2, n3);
            }
            super.b(c_g, n, n2, n3, n4);
        }
    }

    private boolean dropGear(World c_g, int n, int n2, int n3) {
        if (!this.a(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
            return false;
        }
        return true;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public final int a() {
        return 5;
    }

    @Override
    public final int a(Random random) {
        return 1;
    }

    @Override
    public int a(int n) {
        return this.as + 2;
    }

    private void updateAndPropagateCurrentStrength(World c_g, int n, int n2, int n3) {
        this.calculateCurrentChanges(c_g, n, n2, n3, n, n2, n3);
        ArrayList<C_k> arrayList = new ArrayList<C_k>(this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();
        for (int i = 0; i < arrayList.size(); ++i) {
            C_k c_k = arrayList.get(i);
            c_g.c(c_k.x, c_k.y, c_k.z, this.at);
        }
    }

    private void calculateCurrentChanges(World c_g, int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9;
        int n10;
        int n11 = c_g.e(n, n2, n3);
        int n12 = 0;
        this.providePower = false;
        boolean bl = c_g.isBlockIndirectlyGettingPowered(n, n2, n3);
        this.providePower = true;
        if (bl) {
            n12 = 8;
        } else {
            for (n10 = 0; n10 < 18; ++n10) {
                n9 = n;
                n8 = n2;
                n7 = n3;
                if (n10 == 0) {
                    n9 = n - 1;
                }
                if (n10 == 1) {
                    ++n9;
                }
                if (n10 == 2) {
                    n7 = n3 - 1;
                }
                if (n10 == 3) {
                    ++n7;
                }
                if (n10 == 4) {
                    n7 = n3 - 1;
                    n9 = n - 1;
                }
                if (n10 == 5) {
                    ++n9;
                    n7 = n3 - 1;
                }
                if (n10 == 6) {
                    n9 = n - 1;
                    ++n7;
                }
                if (n10 == 7) {
                    ++n7;
                    ++n9;
                }
                if (n10 == 8) {
                    n8 = n2 - 1;
                }
                if (n10 == 9) {
                    ++n8;
                }
                if (n10 == 10) {
                    ++n8;
                    n9 = n - 1;
                }
                if (n10 == 11) {
                    ++n8;
                    ++n9;
                }
                if (n10 == 12) {
                    ++n8;
                    n7 = n3 - 1;
                }
                if (n10 == 13) {
                    ++n8;
                    ++n7;
                }
                if (n10 == 14) {
                    n8 = n2 - 1;
                    n9 = n - 1;
                }
                if (n10 == 15) {
                    n8 = n2 - 1;
                    ++n9;
                }
                if (n10 == 16) {
                    n8 = n2 - 1;
                    n7 = n3 - 1;
                }
                if (n10 == 17) {
                    n8 = n2 - 1;
                    ++n7;
                }
                if (n9 != n4 || n8 != n5 || n7 != n6) {
                    n12 = this.getMaxCurrentStrength(c_g, n9, n8, n7, n12);
                }
                if (c_g.b(n9, n8, n7) && !c_g.b(n, n2 + 1, n3)) {
                    if (n9 == n4 && n8 == n5 && n7 == n6) continue;
                    n12 = this.getMaxCurrentStrength(c_g, n9, n8, n7, n12);
                    continue;
                }
                if (c_g.b(n9, n2, n7) || n9 == n4 && n8 == n5 && n7 == n6) continue;
                n12 = this.getMaxCurrentStrength(c_g, n9, n8, n7, n12);
            }
            n12 = n12 > 0 ? --n12 : 0;
        }
        if (n11 != n12) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, n12);
            c_g.markBlocksDirty(n, n2, n3, n, n2, n3);
            for (n10 = 0; n10 < 18; ++n10) {
                n9 = n;
                n7 = n3;
                n8 = n2;
                if (n10 == 0) {
                    n9 = n - 1;
                }
                if (n10 == 1) {
                    ++n9;
                }
                if (n10 == 2) {
                    n7 = n3 - 1;
                }
                if (n10 == 3) {
                    ++n7;
                }
                if (n10 == 4) {
                    n7 = n3 - 1;
                    n9 = n - 1;
                }
                if (n10 == 5) {
                    n7 = n3 - 1;
                    ++n9;
                }
                if (n10 == 6) {
                    n9 = n - 1;
                    ++n7;
                }
                if (n10 == 7) {
                    ++n7;
                    ++n9;
                }
                if (n10 == 8) {
                    n8 = n2 - 1;
                }
                if (n10 == 9) {
                    ++n8;
                }
                if (n10 == 10) {
                    ++n8;
                    n9 = n - 1;
                }
                if (n10 == 11) {
                    ++n8;
                    ++n9;
                }
                if (n10 == 12) {
                    ++n8;
                    n7 = n3 - 1;
                }
                if (n10 == 13) {
                    ++n8;
                    ++n7;
                }
                if (n10 == 14) {
                    n8 = n2 - 1;
                    n9 = n - 1;
                }
                if (n10 == 15) {
                    n8 = n2 - 1;
                    ++n9;
                }
                if (n10 == 16) {
                    n8 = n2 - 1;
                    n7 = n3 - 1;
                }
                if (n10 == 17) {
                    n8 = n2 - 1;
                    ++n7;
                }
                int n13 = this.getMaxCurrentStrength(c_g, n9, n8, n7, -1);
                n12 = c_g.e(n, n2, n3);
                if (n12 > 0) {
                    --n12;
                }
                if (n13 >= 0 && n13 != n12) {
                    this.calculateCurrentChanges(c_g, n9, n8, n7, n, n2, n3);
                }
                n13 = this.getMaxCurrentStrength(c_g, n9, n8, n7, -1);
                n12 = c_g.e(n, n2, n3);
                if (n12 > 0) {
                    --n12;
                }
                if (n13 < 0 || n13 == n12) continue;
                this.calculateCurrentChanges(c_g, n9, n8, n7, n, n2, n3);
            }
            if (n11 < n12 || n12 == 0) {
                this.blocksNeedingUpdate.add(new C_k(n, n2, n3));
                this.blocksNeedingUpdate.add(new C_k(n - 1, n2, n3));
                this.blocksNeedingUpdate.add(new C_k(n + 1, n2, n3));
                this.blocksNeedingUpdate.add(new C_k(n, n2 - 1, n3));
                this.blocksNeedingUpdate.add(new C_k(n, n2 + 1, n3));
                this.blocksNeedingUpdate.add(new C_k(n, n2, n3 - 1));
                this.blocksNeedingUpdate.add(new C_k(n, n2, n3 + 1));
                this.blocksNeedingUpdate.add(new C_k(n - 1, n2, n3 - 1));
                this.blocksNeedingUpdate.add(new C_k(n + 1, n2, n3 + 1));
                this.blocksNeedingUpdate.add(new C_k(n + 1, n2, n3 - 1));
                this.blocksNeedingUpdate.add(new C_k(n - 1, n2, n3 + 1));
            }
        }
    }

    private void notifyWireNeighborsOfNeighborChange(World c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2, n3) == this.at) {
            c_g.c(n, n2, n3, this.at);
            c_g.c(n - 1, n2, n3, this.at);
            c_g.c(n + 1, n2, n3, this.at);
            c_g.c(n, n2, n3 - 1, this.at);
            c_g.c(n, n2, n3 + 1, this.at);
            c_g.c(n, n2 - 1, n3, this.at);
            c_g.c(n, n2 + 1, n3, this.at);
        }
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
        super.d(c_g, n, n2, n3);
        if (!c_g.multiplayerWorld) {
            this.updateAndPropagateCurrentStrength(c_g, n, n2, n3);
            c_g.c(n, n2 + 1, n3, this.at);
            c_g.c(n, n2 - 1, n3, this.at);
            this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2, n3);
            this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2, n3);
            this.notifyWireNeighborsOfNeighborChange(c_g, n, n2, n3 - 1);
            this.notifyWireNeighborsOfNeighborChange(c_g, n, n2, n3 + 1);
            if (c_g.b(n - 1, n2, n3)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2 + 1, n3);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2 - 1, n3);
            }
            if (c_g.b(n + 1, n2, n3)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2 + 1, n3);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2 - 1, n3);
            }
            if (c_g.b(n, n2, n3 - 1)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 + 1, n3 - 1);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 - 1, n3 - 1);
            }
            if (c_g.b(n, n2, n3 + 1)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 + 1, n3 + 1);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 - 1, n3 + 1);
            }
        }
    }

    @Override
    public void breakBlock(World c_g, int n, int n2, int n3, int n4, int n5) {
        super.breakBlock(c_g, n, n2, n3, n4, n5);
        if (!c_g.multiplayerWorld) {
            c_g.c(n, n2 + 1, n3, this.at);
            c_g.c(n, n2 - 1, n3, this.at);
            c_g.c(n + 1, n2, n3, this.at);
            c_g.c(n - 1, n2, n3, this.at);
            c_g.c(n, n2, n3 + 1, this.at);
            c_g.c(n, n2, n3 - 1, this.at);
            this.updateAndPropagateCurrentStrength(c_g, n, n2, n3);
            this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2, n3);
            this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2, n3);
            this.notifyWireNeighborsOfNeighborChange(c_g, n, n2, n3 - 1);
            this.notifyWireNeighborsOfNeighborChange(c_g, n, n2, n3 + 1);
            if (c_g.b(n - 1, n2, n3)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2 + 1, n3);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n - 1, n2 - 1, n3);
            }
            if (c_g.b(n + 1, n2, n3)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2 + 1, n3);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n + 1, n2 - 1, n3);
            }
            if (c_g.b(n, n2, n3 - 1)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 + 1, n3 - 1);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 - 1, n3 - 1);
            }
            if (c_g.b(n, n2, n3 + 1)) {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 + 1, n3 + 1);
            } else {
                this.notifyWireNeighborsOfNeighborChange(c_g, n, n2 - 1, n3 + 1);
            }
        }
    }

    private int getMaxCurrentStrength(World c_g, int n, int n2, int n3, int n4) {
        if (c_g.a(n, n2, n3) != this.at) {
            return n4;
        }
        int n5 = c_g.e(n, n2, n3);
        return n5 > n4 ? n5 : n4;
    }

    @Override
    public boolean isProvidingStrongPower(World c_g, int n, int n2, int n3, int n4) {
        return !this.providePower ? false : this.isProvidingWeakPower(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean isProvidingWeakPower(World c_g, int n, int n2, int n3, int n4) {
        boolean bl;
        if (!this.providePower) {
            return false;
        }
        if (c_g.e(n, n2, n3) == 0) {
            return false;
        }
        if (c_g.e(n, n2, n3) <= 8) {
            return true;
        }
        if (n4 == 1) {
            return true;
        }
        boolean bl2 = BlockGears.isPowerProviderOrWire(c_g, n - 1, n2, n3, 1) || !c_g.b(n - 1, n2, n3) && BlockGears.isPowerProviderOrWire(c_g, n - 1, n2 - 1, n3, -1);
        boolean bl3 = BlockGears.isPowerProviderOrWire(c_g, n + 1, n2, n3, 3) || !c_g.b(n + 1, n2, n3) && BlockGears.isPowerProviderOrWire(c_g, n + 1, n2 - 1, n3, -1);
        boolean bl4 = BlockGears.isPowerProviderOrWire(c_g, n, n2, n3 - 1, 2) || !c_g.b(n, n2, n3 - 1) && BlockGears.isPowerProviderOrWire(c_g, n, n2 - 1, n3 - 1, -1);
        boolean bl5 = bl = BlockGears.isPowerProviderOrWire(c_g, n, n2, n3 + 1, 0) || !c_g.b(n, n2, n3 + 1) && BlockGears.isPowerProviderOrWire(c_g, n, n2 - 1, n3 + 1, -1);
        if (!c_g.b(n, n2 + 1, n3)) {
            if (c_g.b(n - 1, n2, n3) && BlockGears.isPowerProviderOrWire(c_g, n - 1, n2 + 1, n3, -1)) {
                bl2 = true;
            }
            if (c_g.b(n + 1, n2, n3) && BlockGears.isPowerProviderOrWire(c_g, n + 1, n2 + 1, n3, -1)) {
                bl3 = true;
            }
            if (c_g.b(n, n2, n3 - 1) && BlockGears.isPowerProviderOrWire(c_g, n, n2 + 1, n3 - 1, -1)) {
                bl4 = true;
            }
            if (c_g.b(n, n2, n3 + 1) && BlockGears.isPowerProviderOrWire(c_g, n, n2 + 1, n3 + 1, -1)) {
                bl = true;
            }
        }
        return !bl4 && !bl3 && !bl2 && !bl && n4 >= 2 && n4 <= 5 ? true : (n4 == 2 && bl4 && !bl2 && !bl3 ? true : (n4 == 3 && bl && !bl2 && !bl3 ? true : (n4 == 4 && bl2 && !bl4 && !bl ? true : n4 == 5 && bl3 && !bl4 && !bl)));
    }

    @Override
    public boolean canProvidePower() {
        return this.providePower;
    }

    public static boolean isPowerProviderOrWire(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (n5 == Block.ak.at) {
            byte by = c_g.e(n, n2, n3);
            return n4 == by;
        }
        return false;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, Random random) {
        byte by = c_g.e(n, n2, n3);
        if (by > 0) {
            float f = (float)n + this.au + (random.nextFloat() - this.ax) * 0.2f;
            float f2 = (float)n2 + 0.0625f;
            float f3 = (float)n3 + this.aw + (random.nextFloat() - this.az) * 0.2f;
            float f4 = (float)by / 15.0f;
            float f5 = f4 * 0.6f + 0.4f;
            if (by == 0) {
                f5 = 0.0f;
            }
            float f6 = f4 * f4 * 0.7f - 0.5f;
            float f7 = f4 * f4 * 0.6f - 0.7f;
            if (f6 < 0.0f) {
                f6 = 0.0f;
            }
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            c_g.a("smoke", f, f2, f3, f5, f6, f7);
        }
    }
}

