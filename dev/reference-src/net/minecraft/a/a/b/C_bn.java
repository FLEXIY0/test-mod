/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public class C_bn
extends Block {
    protected C_bn(int n, int n2, C_c c_c) {
        super(n, n2, c_c);
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        if (c_g.a((float)n, (float)(n2 - 1), (float)n3) || c_g.a((float)n, (float)(n2 + 1), (float)n3) || c_g.a(n, n2 - 1, n3) == Block.j.at) {
            return true;
        }
        if (c_g.a(n, n2 - 1, n3) == this.at && c_g.e(n, n2, n3) < 3) {
            return true;
        }
        return c_g.a(n, n2 + 1, n3) == this.at && c_g.e(n, n2 + 1, n3) >= 3;
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        if (c_g.a((float)n, (float)(n2 - 1), (float)n3) || c_g.a((float)n, (float)(n2 + 1), (float)n3)) {
            return true;
        }
        if (c_g.a(n, n2 - 1, n3) == this.at && c_g.e(n, n2, n3) < 3) {
            return true;
        }
        return c_g.a(n, n2 + 1, n3) == this.at && c_g.e(n, n2, n3) >= 3;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!this.canBlockStay(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        } else if (c_g.a(n, n2 - 1, n3) == this.at && c_g.e(n, n2 + 1, n3) == 2) {
            c_g.setBlockMetadata(n, n2, n3, 1);
        } else if (c_g.a(n, n2 + 1, n3) == this.at && c_g.e(n, n2 - 1, n3) == 4) {
            c_g.setBlockMetadata(n, n2, n3, 5);
        } else if (!c_g.a((float)n, (float)(n2 + 1), (float)n3) && c_g.a(n, n2 + 1, n3) != this.at && c_g.a(n, n2 - 1, n3) == this.at || c_g.a((float)n, (float)(n2 - 1), (float)n3) && c_g.a(n, n2 + 1, n3) != this.at) {
            c_g.setBlockMetadata(n, n2, n3, 2);
        } else if (!c_g.a((float)n, (float)(n2 - 1), (float)n3) && c_g.a(n, n2 - 1, n3) != this.at && c_g.a(n, n2 + 1, n3) == this.at || c_g.a((float)n, (float)(n2 + 1), (float)n3) && c_g.a(n, n2 - 1, n3) != this.at) {
            c_g.setBlockMetadata(n, n2, n3, 4);
        } else if (c_g.a((float)n, (float)(n2 + 1), (float)n3) && c_g.a(n, n2 - 1, n3) == this.at) {
            c_g.setBlockMetadata(n, n2, n3, 3);
        } else if (c_g.a((float)n, (float)(n2 - 1), (float)n3) && c_g.a(n, n2 + 1, n3) == this.at) {
            c_g.setBlockMetadata(n, n2, n3, 0);
        }
    }

    @Override
    public final void d(World c_g, int n, int n2, int n3) {
        if (c_g.a(n, n2 + 1, n3) != this.at && (c_g.a(n, n2 - 1, n3) == this.at || c_g.a((float)n, (float)(n2 - 1), (float)n3))) {
            c_g.setBlockMetadata(n, n2, n3, 2);
        } else if (c_g.a(n, n2 - 1, n3) != this.at && (c_g.a(n, n2 + 1, n3) == this.at || c_g.a((float)n, (float)(n2 + 1), (float)n3))) {
            c_g.setBlockMetadata(n, n2, n3, 4);
        } else if (c_g.a(n, n2 + 1, n3) == this.at && c_g.a(n, n2 - 1, n3) == this.at) {
            c_g.setBlockMetadata(n, n2, n3, 1);
            if (c_g.e(n, n2 - 1, n3) != 1 && !c_g.a((float)n, (float)(n2 - 2), (float)n3)) {
                c_g.setBlockMetadata(n, n2 - 1, n3, 1);
            }
            if (c_g.e(n, n2 + 1, n3) != 3 && !c_g.a((float)n, (float)(n2 + 2), (float)n3)) {
                c_g.setBlockMetadata(n, n2 + 1, n3, 1);
            }
        }
    }

    @Override
    public int a(int n, int n2) {
        if (n2 == 1 || n2 == 5) {
            return 367;
        }
        if (n2 == 2 || n2 == 4) {
            return 335;
        }
        return 399;
    }

    @Override
    public final int a(int n) {
        return 335;
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        this.setSpikeSize(c_g.e(n, n2, n3));
    }

    public void setSpikeSize(int n) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (n == 1 || n == 5) {
            this.a(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
        if (n == 2) {
            this.a(0.25f, 0.0f, 0.25f, 0.75f, 0.75f, 0.75f);
        }
        if (n == 4) {
            this.a(0.25f, 0.25f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
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
    public int a() {
        return 1;
    }
}

