/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.b.C_p;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public class BlockBed
extends Block {
    public static final int[][] headBlockToFootBlockMap = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public BlockBed(int n) {
        super(n, 198, Material.c);
        this.setBounds();
    }

    @Override
    public int a(int n, int n2) {
        if (n == 0) {
            return Block.m.as;
        }
        int n3 = BlockBed.getDirectionFromMetadata(n2);
        int n4 = C_p.bedDirection[n3][n];
        return BlockBed.isBlockFootOfBed(n2) ? (n4 == 2 ? this.as + 5 : (n4 != 5 && n4 != 4 ? this.as + 1 : this.as + 4)) : (n4 == 3 ? this.as + 2 : (n4 != 5 && n4 != 4 ? this.as : this.as + 3));
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        if (c_g.y.isLaying) {
            c_g.y.isLaying = false;
        }
    }

    @Override
    public int a() {
        return 13;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean getEnableStats() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        this.setBounds();
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        c_g.a(n, n2, n3, entityPlayer.n);
        byte by = c_g.e(n, n2, n3);
        int n4 = BlockBed.getDirectionFromMetadata(by);
        boolean bl = false;
        if (!(c_g.multiplayerWorld || entityPlayer.isInWater() || entityPlayer.isSneaking != 0 || c_g.a((float)n, (float)(n2 + 1), (float)n3) || entityPlayer.isSitting || entityPlayer.isFlying)) {
            bl = !BlockBed.isBlockFootOfBed(by) ? !c_g.a((float)(n + headBlockToFootBlockMap[n4][0]), (float)(n2 + 1), (float)(n3 + headBlockToFootBlockMap[n4][1])) : !c_g.a((float)n, (float)(n2 + 1), (float)n3);
            if (bl) {
                if (!c_g.isBloodMoon()) {
                    entityPlayer.m = 0.0f;
                    entityPlayer.l = 0.0f;
                    entityPlayer.k = 0.0f;
                    entityPlayer.resetPlayerKeyState();
                    switch (by) {
                        case 0: {
                            entityPlayer.b((float)n + 0.5f, (float)n2 + 1.7f, (float)n3 + 1.5f);
                            break;
                        }
                        case 1: {
                            entityPlayer.b((float)n - 0.5f, (float)n2 + 1.7f, (float)n3 + 0.5f);
                            break;
                        }
                        case 2: {
                            entityPlayer.b((float)n + 0.5f, (float)n2 + 1.7f, (float)n3 - 0.5f);
                            break;
                        }
                        case 3: {
                            entityPlayer.b((float)n + 1.5f, (float)n2 + 1.7f, (float)n3 + 0.5f);
                            break;
                        }
                        default: {
                            entityPlayer.b((float)n + 0.5f, (float)n2 + 1.7f, (float)n3 + 0.5f);
                        }
                    }
                    boolean bl2 = entityPlayer.isLaying = !entityPlayer.isLaying;
                    if (entityPlayer.isLaying) {
                        entityPlayer.addStat(StatList.bedUse, 1);
                        entityPlayer.triggerAchievement(AchievementList.restInBed);
                    }
                } else {
                    entityPlayer.chatMessage("\u00a7cYou may not rest during a blood moon!");
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        int n5 = BlockBed.getDirectionFromMetadata(by);
        if (BlockBed.isBlockFootOfBed(by)) {
            if (c_g.a(n - headBlockToFootBlockMap[n5][0], n2, n3 - headBlockToFootBlockMap[n5][1]) != this.at) {
                c_g.b(n, n2, n3, 0);
            }
            if (!c_g.f(n, n2 - 1, n3).a()) {
                c_g.b(n, n2, n3, 0);
                if (!c_g.multiplayerWorld) {
                    this.f(c_g, n, n2, n3, by);
                }
            }
        } else if (c_g.a(n + headBlockToFootBlockMap[n5][0], n2, n3 + headBlockToFootBlockMap[n5][1]) != this.at) {
            c_g.b(n, n2, n3, 0);
            if (!c_g.multiplayerWorld) {
                this.f(c_g, n, n2, n3, by);
            }
        } else if (!c_g.f(n, n2 - 1, n3).a()) {
            c_g.b(n, n2, n3, 0);
            if (!c_g.multiplayerWorld) {
                this.f(c_g, n, n2, n3, by);
            }
        }
    }

    @Override
    public int a(int n, Random random) {
        return BlockBed.isBlockFootOfBed(n) ? 0 : Item.bed.ap;
    }

    private void setBounds() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }

    public static int getDirectionFromMetadata(int n) {
        return n & 3;
    }

    public static boolean isBlockFootOfBed(int n) {
        return (n & 8) != 0;
    }

    public static boolean isBedOccupied(int n) {
        return (n & 4) != 0;
    }

    public static void setBedOccupied(World c_g, int n, int n2, int n3, boolean bl) {
        int n4 = c_g.e(n, n2, n3);
        n4 = bl ? (n4 |= 4) : (n4 &= 0xFFFFFFFB);
        c_g.setBlockMetadataWithNotify(n, n2, n3, n4);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!BlockBed.isBlockFootOfBed(n4)) {
            super.a(c_g, n, n2, n3, n4, f);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }
}

