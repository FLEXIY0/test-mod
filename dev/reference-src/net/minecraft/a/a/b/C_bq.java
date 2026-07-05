/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import util.MathHelper;

public class C_bq
extends Block {
    private Block modelBlock;

    protected C_bq(int n, Block c_x, int n2) {
        super(n, c_x.as, c_x.getMaterial(0));
        this.modelBlock = c_x;
        this.b(c_x.aL);
        this.a(c_x.aM / 3.0f);
        this.setStepSound(c_x.aA);
        this.hasStates = true;
        this.as = n2;
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public int getMaxMetadata() {
        return 7;
    }

    @Override
    public void getCollidingBoundingBoxes(World c_g, int n, int n2, int n3, C_b c_b, ArrayList<C_b> arrayList) {
        byte by = c_g.e(n, n2, n3);
        if (by == 0) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
        } else if (by == 1) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
        } else if (by == 2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
        } else if (by == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
        }
    }

    private boolean setBoundState(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        return C_bq.isBlockStairsID(n5) && c_g.e(n, n2, n3) == n4;
    }

    public void renderNormal(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        if ((by & 4) != 0) {
            this.a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
    }

    public boolean renderCornerInner(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        int n4 = by & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((by & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 0.5f;
        boolean bl = true;
        if (n4 == 0) {
            f3 = 0.5f;
            f6 = 1.0f;
            int n5 = c_g.a(n + 1, n2, n3);
            byte by2 = c_g.e(n + 1, n2, n3);
            if (C_bq.isBlockStairsID(n5) && (by & 4) == (by2 & 4)) {
                int n6 = by2 & 3;
                if (n6 == 3 && !this.setBoundState(c_g, n, n2, n3 + 1, by)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n6 == 2 && !this.setBoundState(c_g, n, n2, n3 - 1, by)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n4 == 1) {
            f4 = 0.5f;
            f6 = 1.0f;
            int n7 = c_g.a(n - 1, n2, n3);
            byte by3 = c_g.e(n - 1, n2, n3);
            if (C_bq.isBlockStairsID(n7) && (by & 4) == (by3 & 4)) {
                int n8 = by3 & 3;
                if (n8 == 3 && !this.setBoundState(c_g, n, n2, n3 + 1, by)) {
                    f6 = 0.5f;
                    bl = false;
                } else if (n8 == 2 && !this.setBoundState(c_g, n, n2, n3 - 1, by)) {
                    f5 = 0.5f;
                    bl = false;
                }
            }
        } else if (n4 == 2) {
            f5 = 0.5f;
            f6 = 1.0f;
            int n9 = c_g.a(n, n2, n3 + 1);
            byte by4 = c_g.e(n, n2, n3 + 1);
            if (C_bq.isBlockStairsID(n9) && (by & 4) == (by4 & 4)) {
                int n10 = by4 & 3;
                if (n10 == 1 && !this.setBoundState(c_g, n + 1, n2, n3, by)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n10 == 0 && !this.setBoundState(c_g, n - 1, n2, n3, by)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        } else if (n4 == 3) {
            int n11 = c_g.a(n, n2, n3 - 1);
            byte by5 = c_g.e(n, n2, n3 - 1);
            if (C_bq.isBlockStairsID(n11) && (by & 4) == (by5 & 4)) {
                int n12 = by5 & 3;
                if (n12 == 1 && !this.setBoundState(c_g, n + 1, n2, n3, by)) {
                    f4 = 0.5f;
                    bl = false;
                } else if (n12 == 0 && !this.setBoundState(c_g, n - 1, n2, n3, by)) {
                    f3 = 0.5f;
                    bl = false;
                }
            }
        }
        this.a(f3, f, f5, f4, f2, f6);
        return bl;
    }

    public boolean renderCornerOuter(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        int n4 = by & 3;
        float f = 0.5f;
        float f2 = 1.0f;
        if ((by & 4) != 0) {
            f = 0.0f;
            f2 = 0.5f;
        }
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.5f;
        float f6 = 1.0f;
        boolean bl = false;
        if (n4 == 0) {
            int n5 = c_g.a(n - 1, n2, n3);
            byte by2 = c_g.e(n - 1, n2, n3);
            if (C_bq.isBlockStairsID(n5) && (by & 4) == (by2 & 4)) {
                int n6 = by2 & 3;
                if (n6 == 3 && !this.setBoundState(c_g, n, n2, n3 - 1, by)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n6 == 2 && !this.setBoundState(c_g, n, n2, n3 + 1, by)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n4 == 1) {
            int n7 = c_g.a(n + 1, n2, n3);
            byte by3 = c_g.e(n + 1, n2, n3);
            if (C_bq.isBlockStairsID(n7) && (by & 4) == (by3 & 4)) {
                f3 = 0.5f;
                f4 = 1.0f;
                int n8 = by3 & 3;
                if (n8 == 3 && !this.setBoundState(c_g, n, n2, n3 - 1, by)) {
                    f5 = 0.0f;
                    f6 = 0.5f;
                    bl = true;
                } else if (n8 == 2 && !this.setBoundState(c_g, n, n2, n3 + 1, by)) {
                    f5 = 0.5f;
                    f6 = 1.0f;
                    bl = true;
                }
            }
        } else if (n4 == 2) {
            int n9 = c_g.a(n, n2, n3 - 1);
            byte by4 = c_g.e(n, n2, n3 - 1);
            if (C_bq.isBlockStairsID(n9) && (by & 4) == (by4 & 4)) {
                f5 = 0.0f;
                f6 = 0.5f;
                int n10 = by4 & 3;
                if (n10 == 1 && !this.setBoundState(c_g, n - 1, n2, n3, by)) {
                    bl = true;
                } else if (n10 == 0 && !this.setBoundState(c_g, n + 1, n2, n3, by)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        } else if (n4 == 3) {
            int n11 = c_g.a(n, n2, n3 + 1);
            byte by5 = c_g.e(n, n2, n3 + 1);
            if (C_bq.isBlockStairsID(n11) && (by & 4) == (by5 & 4)) {
                int n12 = by5 & 3;
                if (n12 == 1 && !this.setBoundState(c_g, n - 1, n2, n3, by)) {
                    bl = true;
                } else if (n12 == 0 && !this.setBoundState(c_g, n + 1, n2, n3, by)) {
                    f3 = 0.5f;
                    f4 = 1.0f;
                    bl = true;
                }
            }
        }
        if (bl) {
            this.a(f3, f, f5, f4, f2, f6);
        }
        return bl;
    }

    public static boolean isBlockStairsID(int n) {
        return n > 0 && Block.c[n] instanceof C_bq;
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
        return 12;
    }

    @Override
    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        return super.d(c_g, n, n2, n3, n4);
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, Random random) {
        this.modelBlock.b(c_g, n, n2, n3, random);
    }

    @Override
    public void c(World c_g, int n, int n2, int n3, int n4) {
        this.modelBlock.c(c_g, n, n2, n3, n4);
    }

    @Override
    public float f(World c_g, int n, int n2, int n3) {
        return this.modelBlock.f(c_g, n, n2, n3);
    }

    @Override
    public int f() {
        return this.modelBlock.f();
    }

    @Override
    public int a(int n, Random random) {
        return this.at;
    }

    @Override
    public int a(Random random) {
        return this.modelBlock.a(random);
    }

    @Override
    public int a(int n) {
        if (this.at == Block.stairSandstone.at) {
            return this.modelBlock.a(n);
        }
        if (this.at == Block.stairRedSandstone.at) {
            return n == 1 ? 452 : (n == 0 ? 453 : 451);
        }
        if (this.at == Block.stairMoonBricks.at) {
            if (n == 2 || n == 4) {
                return 612;
            }
            return this.as;
        }
        return this.as;
    }

    @Override
    public int e() {
        return this.modelBlock.e();
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return this.modelBlock.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public boolean d() {
        return this.modelBlock.d();
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return this.modelBlock.a(c_g, n, n2, n3);
    }

    @Override
    public void d(World c_g, int n, int n2, int n3) {
        this.b(c_g, n, n2, n3, 0);
        this.modelBlock.d(c_g, n, n2, n3);
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        this.modelBlock.b(c_g, n, n2, n3);
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, Random random) {
        this.modelBlock.a(c_g, n, n2, n3, random);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return this.modelBlock.a(c_g, n, n2, n3, entityPlayer);
    }

    @Override
    public void c(World c_g, int n, int n2, int n3) {
        this.modelBlock.c(c_g, n, n2, n3);
    }

    @Override
    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        int n5 = MathHelper.a((double)(entityPlayer.n * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            if (c_g.a(n, n2 + 1, n3) != 0 && n4 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 6);
            } else {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 2);
            }
        }
        if (n5 == 1) {
            if (c_g.a(n, n2 + 1, n3) != 0 && n4 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 5);
            } else {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 1);
            }
        }
        if (n5 == 2) {
            if (c_g.a(n, n2 + 1, n3) != 0 && n4 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 7);
            } else {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 3);
            }
        }
        if (n5 == 3) {
            if (c_g.a(n, n2 + 1, n3) != 0 && n4 == 0) {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 4);
            } else {
                c_g.setBlockMetadataWithNotify(n, n2, n3, 0);
            }
        }
    }
}

