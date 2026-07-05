/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.furniture.BlockWall;

public final class BlockTorch
extends Block {
    public BlockTorch(int n, int n2) {
        super(n, n2, C_c.n);
        this.a(true);
    }

    @Override
    public final C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
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
        return 2;
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3) {
        int n4 = c_g.a(n, n2 - 1, n3);
        Block c_x = Block.c[n4];
        if (c_x == Block.table || c_x == Block.fence || c_x instanceof BlockWall || c_x == Block.stairUpsideDown) {
            return true;
        }
        return c_g.b(n - 1, n2, n3) ? true : (c_g.b(n + 1, n2, n3) ? true : (c_g.b(n, n2, n3 - 1) ? true : (c_g.b(n, n2, n3 + 1) ? true : c_g.b(n, n2 - 1, n3))));
    }

    @Override
    public final void g(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.e(n, n2, n3);
        if (n4 == 1 && c_g.b(n, n2 - 1, n3)) {
            n5 = 5;
        }
        if (n4 == 2 && c_g.b(n, n2, n3 + 1)) {
            n5 = 4;
        }
        if (n4 == 3 && c_g.b(n, n2, n3 - 1)) {
            n5 = 3;
        }
        if (n4 == 4 && c_g.b(n + 1, n2, n3)) {
            n5 = 2;
        }
        if (n4 == 5 && c_g.b(n - 1, n2, n3)) {
            n5 = 1;
        }
        c_g.setBlockMetadata(n, n2, n3, n5);
    }

    @Override
    public final void a(World c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.e(n, n2, n3) == 0) {
            this.d(c_g, n, n2, n3);
        }
        int n4 = 251 - c_g.E * 50;
        if (c_g.isBloodMoon() && c_g.E != 0 && random.nextInt(n4) == 0 && this == Block.af) {
            byte by = c_g.e(n, n2, n3);
            c_g.setBlockAndMetadataWithNotify(n, n2, n3, Block.unlitTorch.at, by);
        }
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        if (c_g.b(n - 1, n2, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 1);
        } else if (c_g.b(n + 1, n2, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 2);
        } else if (c_g.b(n, n2, n3 - 1)) {
            c_g.setBlockMetadata(n, n2, n3, 3);
        } else if (c_g.b(n, n2, n3 + 1)) {
            c_g.setBlockMetadata(n, n2, n3, 4);
        } else if (c_g.b(n, n2 - 1, n3)) {
            c_g.setBlockMetadata(n, n2, n3, 5);
        }
        this.dropTorchIfCantStay(c_g, n, n2, n3);
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, int n4) {
        if (this.dropTorchIfCantStay(c_g, n, n2, n3)) {
            byte by = c_g.e(n, n2, n3);
            boolean bl = false;
            if (!c_g.b(n - 1, n2, n3) && by == 1) {
                if (c_g.b(n + 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 2);
                } else if (c_g.b(n, n2, n3 - 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 3);
                } else if (c_g.b(n, n2, n3 + 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 4);
                } else {
                    c_g.setBlockMetadata(n, n2, n3, 0);
                }
            } else if (!c_g.b(n + 1, n2, n3) && by == 2) {
                if (c_g.b(n - 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 1);
                } else if (c_g.b(n, n2, n3 - 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 3);
                } else if (c_g.b(n, n2, n3 + 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 4);
                } else {
                    c_g.setBlockMetadata(n, n2, n3, 0);
                }
            } else if (!c_g.b(n, n2, n3 - 1) && by == 3) {
                if (c_g.b(n - 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 1);
                } else if (c_g.b(n + 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 2);
                } else if (c_g.b(n, n2, n3 + 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 4);
                } else {
                    c_g.setBlockMetadata(n, n2, n3, 0);
                }
            } else if (!c_g.b(n, n2, n3 + 1) && by == 4) {
                if (c_g.b(n - 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 1);
                } else if (c_g.b(n, n2, n3 - 1)) {
                    c_g.setBlockMetadata(n, n2, n3, 3);
                } else if (c_g.b(n + 1, n2, n3)) {
                    c_g.setBlockMetadata(n, n2, n3, 2);
                } else {
                    c_g.setBlockMetadata(n, n2, n3, 0);
                }
            }
            if (!c_g.b(n, n2 - 1, n3) && by == 5) {
                bl = true;
            }
            if (bl) {
                this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
                c_g.b(n, n2, n3, 0);
            }
        }
    }

    private boolean dropTorchIfCantStay(World c_g, int n, int n2, int n3) {
        if (!this.a(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
            return false;
        }
        return true;
    }

    @Override
    public final net.minecraft.a.d.C_c a(World c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        byte by = c_g.e(n, n2, n3);
        if (by == 1) {
            this.a(0.0f, 0.2f, 0.35f, 0.3f, 0.8f, 0.65f);
        } else if (by == 2) {
            this.a(0.7f, 0.2f, 0.35f, 1.0f, 0.8f, 0.65f);
        } else if (by == 3) {
            this.a(0.35f, 0.2f, 0.0f, 0.65f, 0.8f, 0.3f);
        } else if (by == 4) {
            this.a(0.35f, 0.2f, 0.7f, 0.65f, 0.8f, 1.0f);
        } else {
            this.a(0.4f, 0.0f, 0.4f, 0.6f, 0.6f, 0.6f);
        }
        return super.a(c_g, n, n2, n3, c_a, c_a2);
    }

    @Override
    public final void b(World c_g, int n, int n2, int n3, Random random) {
        if (this.at == Block.unlitTorch.at) {
            return;
        }
        byte by = c_g.e(n, n2, n3);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + 0.7f;
        float f3 = (float)n3 + 0.5f;
        if (by == 1) {
            c_g.a("smoke", f - 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            c_g.a(this == Block.torchHell ? "hell" : "flame", f - 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
        } else if (by == 2) {
            c_g.a("smoke", f + 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            c_g.a(this == Block.torchHell ? "hell" : "flame", f + 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
        } else if (by == 3) {
            c_g.a("smoke", f, f2 + 0.22f, f3 - 0.27f, 0.0f, 0.0f, 0.0f);
            c_g.a(this == Block.torchHell ? "hell" : "flame", f, f2 + 0.22f, f3 - 0.27f, 0.0f, 0.0f, 0.0f);
        } else if (by == 4) {
            c_g.a("smoke", f, f2 + 0.22f, f3 + 0.27f, 0.0f, 0.0f, 0.0f);
            c_g.a(this == Block.torchHell ? "hell" : "flame", f, f2 + 0.22f, f3 + 0.27f, 0.0f, 0.0f, 0.0f);
        } else {
            c_g.a("smoke", f, f2, f3, 0.0f, 0.0f, 0.0f);
            c_g.a(this == Block.torchHell ? "hell" : "flame", f, f2, f3, 0.0f, 0.0f, 0.0f);
        }
    }
}

