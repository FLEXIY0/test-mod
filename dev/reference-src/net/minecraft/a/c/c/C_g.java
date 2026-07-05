/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.util.List;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import util.MathHelper;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class C_g
extends net.minecraft.a.c.C_b
implements C_b {
    private ItemStack[] cargoItems = new ItemStack[36];
    public int damageTaken = 0;
    public int timeSinceHit = 0;
    public int forwardDirection = 1;
    private boolean isInReverse = false;
    public int minecartType;
    private float pushX;
    private float pushZ;
    private int fuel;
    private static final int[][][] matrix = new int[][][]{new int[][]{{0, 0, -1}, {0, 0, 1}}, new int[][]{{-1, 0, 0}, {1, 0, 0}}, new int[][]{{-1, -1, 0}, {1, 0, 0}}, new int[][]{{-1, 0, 0}, {1, -1, 0}}, new int[][]{{0, 0, -1}, {0, -1, 1}}, new int[][]{{0, -1, -1}, {0, 0, 1}}, new int[][]{{0, 0, 1}, {1, 0, 0}}, new int[][]{{0, 0, 1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {-1, 0, 0}}, new int[][]{{0, 0, -1}, {1, 0, 0}}};

    public C_g(net.minecraft.a.a.World c_g) {
        super(c_g);
        this.c = true;
        this.a(0.98f, 0.7f);
        this.v = this.x - 0.3f;
        this.A = false;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public net.minecraft.a.d.C_b getCollisionBox(net.minecraft.a.c.C_b c_b) {
        return c_b.r;
    }

    public net.minecraft.a.d.C_b getBoundingBox() {
        return this.r;
    }

    @Override
    public boolean p() {
        return true;
    }

    public C_g(net.minecraft.a.a.World c_g, float f, float f2, float f3, int n) {
        this(c_g);
        this.b(f, f2 + this.v, f3);
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.A = false;
        this.minecartType = n;
    }

    @Override
    public float getMountedYOffset() {
        return -0.75f;
    }

    @Override
    public boolean attackEntityFrom(net.minecraft.a.c.C_b c_b, int n, float f) {
        if (!this.d.multiplayerWorld && !this.u) {
            this.forwardDirection = -this.forwardDirection;
            this.timeSinceHit = 10;
            this.damageTaken += n * 10;
            if (this.damageTaken > 40 && !this.u) {
                if (this.d.z) {
                    this.a(Item.minecart.ap, 1, 0.0f);
                    switch (this.minecartType) {
                        case 1: {
                            this.a(Block.aj.at, 1);
                            break;
                        }
                        case 2: {
                            this.a(Block.aq.at, 1);
                            break;
                        }
                        case 3: {
                            this.a(Block.ab.at, 1);
                        }
                    }
                }
                this.k();
            }
        }
        return true;
    }

    @Override
    public boolean d() {
        return !this.u;
    }

    @Override
    public void k() {
        if (!this.d.multiplayerWorld) {
            for (int i = 0; i < this.a(); ++i) {
                ItemStack itemStack = this.a(i);
                if (itemStack == null) continue;
                float f = this.G.nextFloat() * 0.8f + 0.1f;
                float f2 = this.G.nextFloat() * 0.8f + 0.1f;
                float f3 = this.G.nextFloat() * 0.8f + 0.1f;
                while (itemStack.a > 0) {
                    int n = this.G.nextInt(21) + 10;
                    if (n > itemStack.a) {
                        n = itemStack.a;
                    }
                    itemStack.a -= n;
                    net.minecraft.a.c.c.C_b c_b = new net.minecraft.a.c.c.C_b(this.d, this.h + f, this.i + f2, this.j + f3, new ItemStack(itemStack.c, n, itemStack.d));
                    float f4 = 0.05f;
                    c_b.k = (float)this.G.nextGaussian() * f4;
                    c_b.l = (float)this.G.nextGaussian() * f4 + 0.2f;
                    c_b.m = (float)this.G.nextGaussian() * f4;
                    this.d.spawnEntityInWorld(c_b);
                }
            }
        }
        super.k();
    }

    @Override
    public void b_() {
        double d2;
        int n;
        int n2;
        if (this.timeSinceHit > 0) {
            --this.timeSinceHit;
        }
        if (this.damageTaken > 0) {
            --this.damageTaken;
        }
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.q = this.o;
        this.p = this.n;
        this.l = (float)((double)this.l - (double)0.04f);
        int n3 = MathHelper.a((double)this.h);
        if (this.d.a(n3, (n2 = MathHelper.a((double)this.i)) - 1, n = MathHelper.a((double)this.j)) == Block.rail.at || this.d.a(n3, n2 - 1, n) == Block.railBooster.at) {
            --n2;
        }
        double d3 = 0.4;
        double d4 = 0.0078125;
        boolean bl = false;
        if (this.d.a(n3, n2, n) == Block.rail.at || this.d.a(n3, n2, n) == Block.railBooster.at) {
            double d5;
            C_a c_a;
            double d6;
            double d7;
            double d8;
            C_a c_a2 = this.getPos(this.h, this.i, this.j);
            byte by = this.d.e(n3, n2, n);
            this.i = n2;
            if (by >= 2 && by <= 5) {
                this.i = n2 + 1;
            }
            if (by == 2) {
                this.k = (float)((double)this.k - d4);
            }
            if (by == 3) {
                this.k = (float)((double)this.k + d4);
            }
            if (by == 4) {
                this.m = (float)((double)this.m + d4);
            }
            if (by == 5) {
                this.m = (float)((double)this.m - d4);
            }
            int[][] nArray = matrix[by];
            double d9 = nArray[1][0] - nArray[0][0];
            double d10 = nArray[1][2] - nArray[0][2];
            double d11 = Math.sqrt(d9 * d9 + d10 * d10);
            double d12 = (double)this.k * d9 + (double)this.m * d10;
            if (d12 < 0.0) {
                d9 = -d9;
                d10 = -d10;
            }
            double d13 = Math.sqrt(this.k * this.k + this.m * this.m);
            this.k = (float)(d13 * d9 / d11);
            this.m = (float)(d13 * d10 / d11);
            double d14 = 0.0;
            double d15 = (double)n3 + 0.5 + (double)nArray[0][0] * 0.5;
            double d16 = (double)n + 0.5 + (double)nArray[0][2] * 0.5;
            double d17 = (double)n3 + 0.5 + (double)nArray[1][0] * 0.5;
            double d18 = (double)n + 0.5 + (double)nArray[1][2] * 0.5;
            d9 = d17 - d15;
            d10 = d18 - d16;
            if (d9 == 0.0) {
                this.h = (float)n3 + 0.5f;
                d14 = (double)this.j - (double)n;
            } else if (d10 == 0.0) {
                this.j = (float)n + 0.5f;
                d14 = (double)this.h - (double)n3;
            } else {
                d8 = (double)this.h - d15;
                d7 = (double)this.j - d16;
                d14 = d6 = (d8 * d9 + d7 * d10) * 2.0;
            }
            this.h = (float)(d15 + d9 * d14);
            this.j = (float)(d16 + d10 * d14);
            this.b(this.h, this.i + this.v + 0.1f, this.j);
            d8 = this.k;
            d7 = this.m;
            if (this.riddenByEntity != null) {
                d8 *= 0.75;
                d7 *= 0.75;
            }
            if (d8 < -d3) {
                d8 = -d3;
            }
            if (d8 > d3) {
                d8 = d3;
            }
            if (d7 < -d3) {
                d7 = -d3;
            }
            if (d7 > d3) {
                d7 = d3;
            }
            this.d((float)d8, 0.0f, (float)d7);
            if (nArray[0][1] != 0 && MathHelper.a((double)this.h) - n3 == nArray[0][0] && MathHelper.a((double)this.j) - n == nArray[0][2]) {
                this.b(this.h, this.i + (float)nArray[0][1], this.j);
            } else if (nArray[1][1] != 0 && MathHelper.a((double)this.h) - n3 == nArray[1][0] && MathHelper.a((double)this.j) - n == nArray[1][2]) {
                this.b(this.h, this.i + (float)nArray[1][1], this.j);
            }
            if (this.riddenByEntity != null) {
                if (this.d.a(n3, n2, n) == Block.railBooster.at) {
                    this.k = (float)((double)this.k * 1.296999979019165);
                    this.l = (float)((double)this.l * 0.0);
                    this.m = (float)((double)this.m * 1.296999979019165);
                } else {
                    this.k = (float)((double)this.k * (double)0.997f);
                    this.l = (float)((double)this.l * 0.0);
                    this.m = (float)((double)this.m * (double)0.997f);
                }
                if (this.k > 256.0f) {
                    this.k = 256.0f;
                }
                if (this.m > 256.0f) {
                    this.m = 256.0f;
                }
                if (this.k < -256.0f) {
                    this.k = -256.0f;
                }
                if (this.m < -256.0f) {
                    this.m = -256.0f;
                }
            } else {
                if (this.d.a(n3, n2, n) == Block.railBooster.at) {
                    this.k = (float)((double)this.k * 1.0);
                    this.l = (float)((double)this.l * 0.0);
                    this.m = (float)((double)this.m * 1.0);
                } else {
                    this.k = (float)((double)this.k * (double)0.96f);
                    this.l = (float)((double)this.l * 0.0);
                    this.m = (float)((double)this.m * (double)0.96f);
                }
                if (this.k > 256.0f) {
                    this.k = 256.0f;
                }
                if (this.m > 256.0f) {
                    this.m = 256.0f;
                }
                if (this.k < -256.0f) {
                    this.k = -256.0f;
                }
                if (this.m < -256.0f) {
                    this.m = -256.0f;
                }
                if (this.minecartType == 2) {
                    d6 = MathHelper.c(this.pushX * this.pushX + this.pushZ * this.pushZ);
                    if (d6 > 0.01) {
                        bl = true;
                        this.pushX = (float)((double)this.pushX / d6);
                        this.pushZ = (float)((double)this.pushZ / d6);
                        double d19 = 0.04;
                        this.k = (float)((double)this.k * (double)0.8f);
                        this.l = (float)((double)this.l * 0.0);
                        this.m = (float)((double)this.m * (double)0.8f);
                        this.k = (float)((double)this.k + (double)this.pushX * d19);
                        this.m = (float)((double)this.m + (double)this.pushZ * d19);
                    } else {
                        this.k = (float)((double)this.k * (double)0.9f);
                        this.l = (float)((double)this.l * 0.0);
                        this.m = (float)((double)this.m * (double)0.9f);
                    }
                }
            }
            if ((c_a = this.getPos(this.h, this.i, this.j)) != null && c_a2 != null) {
                double d20 = (double)(c_a2.b - c_a.b) * 0.05;
                d13 = Math.sqrt(this.k * this.k + this.m * this.m);
                if (d13 > 0.0) {
                    this.k = (float)((double)this.k / d13 * (d13 + d20));
                    this.m = (float)((double)this.m / d13 * (d13 + d20));
                }
                this.b(this.h, c_a.b, this.j);
            }
            int n4 = MathHelper.a((double)this.h);
            int n5 = MathHelper.a((double)this.j);
            if (n4 != n3 || n5 != n) {
                d13 = Math.sqrt(this.k * this.k + this.m * this.m);
                this.k = (float)(d13 * (double)(n4 - n3));
                this.m = (float)(d13 * (double)(n5 - n));
            }
            if (this.minecartType == 2 && (d5 = (double)MathHelper.c(this.pushX * this.pushX + this.pushZ * this.pushZ)) > 0.01 && (double)(this.k * this.k + this.m * this.m) > 0.001) {
                this.pushX = (float)((double)this.pushX / d5);
                this.pushZ = (float)((double)this.pushZ / d5);
                if ((double)(this.pushX * this.k + this.pushZ * this.m) < 0.0) {
                    this.pushX = 0.0f;
                    this.pushZ = 0.0f;
                } else {
                    this.pushX = this.k;
                    this.pushZ = this.m;
                }
            }
            if (this.t && this.minecartType == 3) {
                this.k();
                this.d.a(null, this.h, this.i, this.j, 4.0f);
            }
        } else {
            if ((double)this.k < -d3) {
                this.k = (float)(-d3);
            }
            if ((double)this.k > d3) {
                this.k = (float)d3;
            }
            if ((double)this.m < -d3) {
                this.m = (float)(-d3);
            }
            if ((double)this.m > d3) {
                this.m = (float)d3;
            }
            if (this.s) {
                this.k = (float)((double)this.k * 0.5);
                this.l = (float)((double)this.l * 0.5);
                this.m = (float)((double)this.m * 0.5);
            }
            this.d(this.k, this.l, this.m);
            if (!this.s) {
                this.k = (float)((double)this.k * (double)0.95f);
                this.l = (float)((double)this.l * (double)0.95f);
                this.m = (float)((double)this.m * (double)0.95f);
            }
            if (this.t && this.minecartType == 3) {
                this.k();
                this.d.a(null, this.h, this.i, this.j, 4.0f);
            }
        }
        this.o = 0.0f;
        double d21 = this.e - this.h;
        double d22 = this.g - this.j;
        if (d21 * d21 + d22 * d22 > 0.001) {
            this.n = (float)(Math.atan2(d22, d21) * 180.0 / Math.PI);
            if (this.isInReverse) {
                this.n += 180.0f;
            }
        }
        int n6 = MathHelper.a((double)this.r.a - 0.999);
        int n7 = MathHelper.a((double)this.r.b - 0.999);
        int n8 = MathHelper.a((double)this.r.c - 0.999);
        int n9 = MathHelper.a((double)this.r.d + 0.999);
        int n10 = MathHelper.a((double)this.r.e + 0.999);
        int n11 = MathHelper.a((double)this.r.f + 0.999);
        for (int i = n6; i <= n9; ++i) {
            for (int j = n7; j <= n10; ++j) {
                for (int k = n8; k <= n11; ++k) {
                    int n12 = this.d.a(i, j, k);
                    if (n12 <= 0) continue;
                    Block.c[n12].onEntityCollidedWithBlock(this.d, i, j, k);
                }
            }
        }
        for (d2 = (double)(this.n - this.p); d2 >= 180.0; d2 -= 360.0) {
        }
        while (d2 < -180.0) {
            d2 += 360.0;
        }
        if (d2 < -170.0 || d2 >= 170.0) {
            this.n += 180.0f;
            this.isInReverse = !this.isInReverse;
        }
        this.setRotation(this.n, this.o);
        List<net.minecraft.a.c.C_b> list = this.d.a(this, this.r.b(0.2f, 0.0f, 0.2f));
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                net.minecraft.a.c.C_b c_b = list.get(i);
                if (c_b == this.riddenByEntity || !c_b.p() || !(c_b instanceof C_g)) continue;
                c_b.c(this);
            }
        }
        if (this.riddenByEntity != null && this.riddenByEntity.u) {
            this.riddenByEntity = null;
        }
        if (bl && this.G.nextInt(4) == 0) {
            --this.fuel;
            if (this.fuel < 0) {
                this.pushZ = 0.0f;
                this.pushX = 0.0f;
            }
            this.d.a("largesmoke", this.h, this.i + 0.8f, this.j, 0.0f, 0.0f, 0.0f);
        }
    }

    public C_a getPosOffset(double d2, double d3, double d4, double d5) {
        int n;
        int n2;
        int n3 = MathHelper.a(d2);
        if (this.d.a(n3, (n2 = MathHelper.a(d3)) - 1, n = MathHelper.a(d4)) == Block.rail.at || this.d.a(n3, n2 - 1, n) == Block.railBooster.at) {
            --n2;
        }
        if (this.d.a(n3, n2, n) == Block.rail.at || this.d.a(n3, n2, n) == Block.railBooster.at) {
            byte by = this.d.e(n3, n2, n);
            d3 = n2;
            if (by >= 2 && by <= 5) {
                d3 = n2 + 1;
            }
            int[][] nArray = matrix[by];
            double d6 = nArray[1][0] - nArray[0][0];
            double d7 = nArray[1][2] - nArray[0][2];
            double d8 = Math.sqrt(d6 * d6 + d7 * d7);
            if (nArray[0][1] != 0 && MathHelper.a(d2 += (d6 /= d8) * d5) - n3 == nArray[0][0] && MathHelper.a(d4 += (d7 /= d8) * d5) - n == nArray[0][2]) {
                d3 += (double)nArray[0][1];
            } else if (nArray[1][1] != 0 && MathHelper.a(d2) - n3 == nArray[1][0] && MathHelper.a(d4) - n == nArray[1][2]) {
                d3 += (double)nArray[1][1];
            }
            return this.getPos(d2, d3, d4);
        }
        return null;
    }

    public C_a getPos(double d2, double d3, double d4) {
        int n;
        int n2;
        int n3 = MathHelper.a(d2);
        if (this.d.a(n3, (n2 = MathHelper.a(d3)) - 1, n = MathHelper.a(d4)) == Block.rail.at || this.d.a(n3, n2 - 1, n) == Block.railBooster.at) {
            --n2;
        }
        if (this.d.a(n3, n2, n) == Block.rail.at || this.d.a(n3, n2, n) == Block.railBooster.at) {
            byte by = this.d.e(n3, n2, n);
            d3 = n2;
            if (by >= 2 && by <= 5) {
                d3 = n2 + 1;
            }
            int[][] nArray = matrix[by];
            double d5 = 0.0;
            double d6 = (double)n3 + 0.5 + (double)nArray[0][0] * 0.5;
            double d7 = (double)n2 + 0.5 + (double)nArray[0][1] * 0.5;
            double d8 = (double)n + 0.5 + (double)nArray[0][2] * 0.5;
            double d9 = (double)n3 + 0.5 + (double)nArray[1][0] * 0.5;
            double d10 = (double)n2 + 0.5 + (double)nArray[1][1] * 0.5;
            double d11 = (double)n + 0.5 + (double)nArray[1][2] * 0.5;
            double d12 = d9 - d6;
            double d13 = (d10 - d7) * 2.0;
            double d14 = d11 - d8;
            if (d12 == 0.0) {
                d2 = (double)n3 + 0.5;
                d5 = d4 - (double)n;
            } else if (d14 == 0.0) {
                d4 = (double)n + 0.5;
                d5 = d2 - (double)n3;
            } else {
                double d15;
                double d16 = d2 - d6;
                double d17 = d4 - d8;
                d5 = d15 = (d16 * d12 + d17 * d14) * 2.0;
            }
            d2 = d6 + d12 * d5;
            d3 = d7 + d13 * d5;
            d4 = d8 + d14 * d5;
            if (d13 < 0.0) {
                d3 += 1.0;
            }
            if (d13 > 0.0) {
                d3 += 0.5;
            }
            return new C_a((float)d2, (float)d3, (float)d4);
        }
        return null;
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        nBTTagCompound.a("Type", this.minecartType);
        nBTTagCompound.a("PushX", this.pushX);
        nBTTagCompound.a("PushZ", this.pushZ);
        nBTTagCompound.a("Fuel", (short)this.fuel);
        for (int i = 0; i < this.cargoItems.length; ++i) {
            if (this.cargoItems[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.cargoItems[i].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        nBTTagCompound.a("Items", nBTTagList);
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.cargoItems = new ItemStack[this.a()];
        this.minecartType = nBTTagCompound.d("Type");
        this.pushX = nBTTagCompound.f("PushX");
        this.pushZ = nBTTagCompound.f("PushZ");
        this.fuel = nBTTagCompound.c("Fuel");
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.cargoItems.length) continue;
            this.cargoItems[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    public void c(net.minecraft.a.c.C_b c_b) {
        if (c_b != this.riddenByEntity) {
            super.c(c_b);
        }
    }

    @Override
    public int a() {
        return 27;
    }

    @Override
    public ItemStack a(int n) {
        return this.cargoItems[n];
    }

    @Override
    public ItemStack a(int n, int n2) {
        if (this.cargoItems[n] != null) {
            if (this.cargoItems[n].a <= n2) {
                ItemStack itemStack = this.cargoItems[n];
                this.cargoItems[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this.cargoItems[n].a(n2);
            if (this.cargoItems[n].a == 0) {
                this.cargoItems[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public void a(int n, ItemStack itemStack) {
        this.cargoItems[n] = itemStack;
        if (itemStack != null && itemStack.a > this.c()) {
            itemStack.a = this.c();
        }
    }

    @Override
    public String b() {
        return "Minecart";
    }

    @Override
    public int c() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        switch (this.minecartType) {
            case 0: {
                if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityPlayer) {
                    return true;
                }
                if (!this.d.multiplayerWorld) {
                    entityPlayer.mountEntity(this);
                }
                entityPlayer.resetPlayerKeyState();
                break;
            }
            case 1: {
                if (this.d.multiplayerWorld) break;
                entityPlayer.a(this);
                break;
            }
            case 2: {
                if (this.d.multiplayerWorld) break;
                ItemStack itemStack = entityPlayer.b.d();
                if (itemStack != null && itemStack.c == Item.i.ap) {
                    if (--itemStack.a == 0) {
                        entityPlayer.b.a(entityPlayer.b.c, null);
                    }
                    this.fuel += 1200;
                }
                this.pushX = this.h - entityPlayer.h;
                this.pushZ = this.j - entityPlayer.j;
            }
        }
        return true;
    }

    @Override
    public String a() {
        return "Minecart";
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.u ? false : entityPlayer.getDistanceSq(this.h + 0.5f, this.i + 0.5f, this.j + 0.5f) <= 64.0f;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

