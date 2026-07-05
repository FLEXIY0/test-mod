/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_b;
import net.minecraft.client.statistics.StatList;

public class BlockDoor
extends C_x {
    int opening = 0;
    int dropID;

    public BlockDoor(int n, int n2, int n3, C_c c_c) {
        super(n, c_c);
        this.as = n2;
        this.dropID = n3;
        float f = 0.5f;
        float f2 = 1.0f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
    }

    @Override
    public int a(int n, int n2) {
        if (n != 0 && n != 1) {
            int n3 = this.getState(n2);
            if ((n3 == 0 || n3 == 2) ^ n <= 3) {
                return this.as;
            }
            int n4 = n3 / 2 + (n & 1 ^ n3);
            int n5 = this.as - (n2 & 8) * 4;
            if (((n4 += (n2 & 4) / 4) & 1) != 0) {
                n5 = -n5;
            }
            return n5;
        }
        return this.as;
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
        return 7;
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    @Override
    public boolean getEnableStats() {
        return false;
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(C_g c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(C_g c_g, int n, int n2, int n3) {
        this.setDoorRotation(this.getState(c_g.e(n, n2, n3)));
    }

    public void setDoorRotation(int n) {
        float f = 0.1875f;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        if (n == 0) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f);
        }
        if (n == 1) {
            this.a(1.0f - f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 2) {
            this.a(0.0f, 0.0f, 1.0f - f, 1.0f, 1.0f, 1.0f);
        }
        if (n == 3) {
            this.a(0.0f, 0.0f, 0.0f, f, 1.0f, 1.0f);
        }
    }

    @Override
    public boolean a(C_g c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (this.at == C_x.doorSteel.at) {
            return false;
        }
        byte by = c_g.e(n, n2, n3);
        if ((by & 8) != 0) {
            if (c_g.a(n, n2 - 1, n3) == this.at) {
                this.a(c_g, n, n2 - 1, n3, entityPlayer);
            }
            entityPlayer.addStat(StatList.doorUse, 1);
            return true;
        }
        if (c_g.a(n, n2 + 1, n3) == this.at) {
            c_g.setBlockMetadataWithNotify(n, n2 + 1, n3, (by ^ 4) + 8);
        }
        c_g.setBlockMetadataWithNotify(n, n2, n3, by ^ 4);
        entityPlayer.addStat(StatList.doorUse, 1);
        if (by < 4) {
            c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_open", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
        } else {
            c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_close", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
        }
        return true;
    }

    @Override
    public void b(C_g c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        if ((by & 8) != 0) {
            if (c_g.a(n, n2 - 1, n3) != this.at) {
                c_g.b(n, n2, n3, 0);
            }
            if (n4 > 0 && C_x.c[n4].canProvidePower()) {
                this.b(c_g, n, n2 - 1, n3, n4);
            }
        } else {
            boolean bl = false;
            if (c_g.a(n, n2 + 1, n3) != this.at) {
                c_g.b(n, n2, n3, 0);
                bl = true;
            }
            if (!c_g.b(n, n2 - 1, n3)) {
                c_g.b(n, n2, n3, 0);
                bl = true;
                if (c_g.a(n, n2 + 1, n3) == this.at) {
                    c_g.b(n, n2 + 1, n3, 0);
                }
            }
            if (bl) {
                if (!c_g.multiplayerWorld && c_g.gamemode == 0) {
                    this.f(c_g, n, n2, n3, by);
                }
            } else if (n4 > 0 && C_x.c[n4].canProvidePower()) {
                boolean bl2 = c_g.isBlockIndirectlyGettingPowered(n, n2, n3) || c_g.isBlockIndirectlyGettingPowered(n, n2 + 1, n3);
                this.onPoweredBlockChange(c_g, n, n2, n3, bl2);
            }
        }
    }

    public void onPoweredBlockChange(C_g c_g, int n, int n2, int n3, boolean bl) {
        byte by = c_g.e(n, n2, n3);
        if ((by & 8) != 0) {
            if (c_g.a(n, n2 - 1, n3) == this.at) {
                this.onPoweredBlockChange(c_g, n, n2 - 1, n3, bl);
            }
        } else {
            boolean bl2;
            boolean bl3 = bl2 = (c_g.e(n, n2, n3) & 4) > 0;
            if (bl2 != bl) {
                if (c_g.a(n, n2 + 1, n3) == this.at) {
                    c_g.setBlockMetadataWithNotify(n, n2 + 1, n3, (by ^ 4) + 8);
                }
                c_g.setBlockMetadataWithNotify(n, n2, n3, by ^ 4);
                if (by < 4) {
                    c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_open", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
                } else {
                    c_g.playSoundAtBlock((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.door_close", 1.0f, c_g.q.nextFloat() * 0.1f + 0.9f);
                }
            }
        }
    }

    @Override
    public int a(int n, Random random) {
        return (n & 8) != 0 ? 0 : this.dropID;
    }

    @Override
    public net.minecraft.a.d.C_c a(C_g c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.a(c_g, n, n2, n3, c_a, c_a2);
    }

    public int getState(int n) {
        return (n & 4) == 0 ? n - 1 & 3 : n & 3;
    }

    @Override
    public final boolean a(C_g c_g, int n, int n2, int n3) {
        return n2 >= c_g.c - 1 ? false : c_g.b(n, n2 - 1, n3) && c_g.a(n, n2 + 1, n3) == 0 && c_g.a(n, n2, n3) == 0 && super.a(c_g, n, n2, n3);
    }

    public static boolean isOpen(int n) {
        return (n & 4) != 0;
    }
}

