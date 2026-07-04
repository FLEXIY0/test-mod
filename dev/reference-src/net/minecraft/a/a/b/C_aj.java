/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;

public final class C_aj
extends C_x {
    public boolean a;
    public static final String[] NAME_LIST = new String[]{"Stone", "Brick", "Cobblestone", "Mossy Cobble", "Sandstone", "Stone Brick", "Mossy Brick", "Smooth Sandstone", "Basalt Brick", "Red Sandstone", "Smooth Red Sandstone", "Moon Brick"};
    public static final String[] NAME_LIST2 = new String[]{"Oak", "Birch", "Palm", "Pine"};

    public C_aj(int n, boolean bl, boolean bl2, C_c c_c) {
        super(n, 6, c_c);
        this.a = bl;
        if (!bl && !bl2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        } else if (bl2) {
            this.a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        this.hasStates = true;
    }

    @Override
    public int a(int n, int n2) {
        if (this.aC == C_c.c) {
            switch (n2) {
                default: {
                    return 4;
                }
                case 1: {
                    return 328;
                }
                case 2: {
                    return 360;
                }
                case 3: 
            }
            return 392;
        }
        switch (n2) {
            default: {
                return n <= 1 ? 6 : 5;
            }
            case 1: {
                return C_x.aa.as;
            }
            case 2: {
                return C_x.l.as;
            }
            case 3: {
                return C_x.ad.as;
            }
            case 4: {
                return n == 1 ? 301 : (n == 0 ? 302 : 300);
            }
            case 5: {
                return 394;
            }
            case 6: {
                return 395;
            }
            case 7: {
                return n == 1 ? 301 : (n == 0 ? 301 : 492);
            }
            case 8: {
                return 454;
            }
            case 9: {
                return n == 1 ? 452 : (n == 0 ? 453 : 451);
            }
            case 10: {
                return n == 1 ? 452 : (n == 0 ? 452 : 0);
            }
            case 11: 
        }
        return n == 2 || n == 4 ? 612 : 545;
    }

    @Override
    public int a(int n) {
        return this.a(n, 0);
    }

    @Override
    public final boolean isOpaqueCube(int n) {
        return this.a;
    }

    @Override
    public final C_c getMaterial(int n) {
        return this.aC;
    }

    @Override
    public int getMaxDamage() {
        if (this.aC == C_c.c) {
            return 3;
        }
        return 11;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int a(Random random) {
        return this.a ? 2 : 1;
    }

    public static int getSlabType(int n) {
        return n;
    }

    @Override
    public String getBlockName(int n) {
        if (this.aC == C_c.c) {
            if (n > this.getMaxDamage()) {
                return NAME_LIST2[C_aj.getSlabType(0)] + " Slab";
            }
            return NAME_LIST2[C_aj.getSlabType(n)] + " Slab";
        }
        if (n > this.getMaxDamage()) {
            return NAME_LIST[C_aj.getSlabType(0)] + " Slab";
        }
        return NAME_LIST[C_aj.getSlabType(n)] + " Slab";
    }

    @Override
    public void g(C_g c_g, int n, int n2, int n3, int n4) {
        byte by = c_g.e(n, n2, n3);
        byte by2 = c_g.e(n, n2 - 1, n3);
        byte by3 = c_g.e(n, n2 + 1, n3);
        if (this.aC == C_c.c) {
            if (n4 == 0) {
                if (c_g.a(n, n2 + 1, n3) != C_x.stairUpsideDownWood.at) {
                    c_g.setBlockAndMetadataWithNotify(n, n2, n3, C_aj.stairUpsideDownWood.at, by);
                } else if (by == by3) {
                    c_g.b(n, n2, n3, 0);
                    c_g.setBlockAndMetadataWithNotify(n, n2 + 1, n3, C_x.stairDoubleWood.at, by);
                }
            }
            if (n4 == 1 && by == by2 && c_g.a(n, n2 - 1, n3) == C_aj.stairSingleWood.at) {
                c_g.b(n, n2, n3, 0);
                c_g.setBlockAndMetadataWithNotify(n, n2 - 1, n3, C_x.stairDoubleWood.at, by);
            }
        } else {
            if (n4 == 0) {
                if (c_g.a(n, n2 + 1, n3) != C_x.stairUpsideDown.at) {
                    c_g.setBlockAndMetadataWithNotify(n, n2, n3, C_aj.stairUpsideDown.at, by);
                } else if (by == by3) {
                    c_g.b(n, n2, n3, 0);
                    c_g.setBlockAndMetadataWithNotify(n, n2 + 1, n3, C_x.Y.at, by);
                }
            }
            if (n4 == 1 && by == by2 && c_g.a(n, n2 - 1, n3) == C_aj.Z.at) {
                c_g.b(n, n2, n3, 0);
                c_g.setBlockAndMetadataWithNotify(n, n2 - 1, n3, C_x.Y.at, by);
            }
        }
    }

    @Override
    public final int a(int n, Random random) {
        if (this.aC == C_c.c) {
            return C_x.stairSingleWood.at;
        }
        return C_x.Z.at;
    }

    @Override
    public final boolean c() {
        return this.a;
    }

    @Override
    public final boolean d(C_g c_g, int n, int n2, int n3, int n4) {
        return n4 == 1 || n4 == 0 ? true : (!super.d(c_g, n, n2, n3, n4) ? false : (n4 == 0 ? true : c_g.a(n, n2, n3) != this.at));
    }
}

