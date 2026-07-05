/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.d;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_c;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_a
extends C_b {
    private int b = -1;
    private int O = -1;
    private int P = -1;
    private int Q = 0;
    private boolean R = false;
    public int a = 0;
    public C_e S;
    private int T;
    private int U = 0;
    public int arrowType = 0;

    public C_a(World c_g, C_e c_e, int n, float f) {
        super(c_g);
        this.S = c_e;
        this.a(0.5f, 0.5f);
        this.b(c_e.h, c_e.i, c_e.j, c_e.n, c_e.o);
        this.h -= MathHelper.b(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.i -= 0.1f;
        this.j -= MathHelper.a(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.b(this.h, this.i, this.j);
        this.v = 0.0f;
        this.k = -MathHelper.a(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI);
        this.m = MathHelper.b(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI);
        this.l = -MathHelper.a(this.o / 180.0f * (float)Math.PI);
        this.arrowType = n;
        this.a(this.k, this.l, this.m, f * 1.5f, 1.0f);
    }

    public C_a(World c_g) {
        super(c_g);
    }

    public C_a(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.a(0.5f, 0.5f);
        this.b(f, f2, f3);
        this.v = 0.0f;
    }

    @Override
    protected void entityInit() {
    }

    public final void a(float f, float f2, float f3, float f4, float f5) {
        float f6 = MathHelper.c(f * f + f2 * f2 + f3 * f3);
        f /= f6;
        f2 /= f6;
        f3 /= f6;
        f = (float)((double)f + this.G.nextGaussian() * (double)0.0075f * (double)f5);
        f2 = (float)((double)f2 + this.G.nextGaussian() * (double)0.0075f * (double)f5);
        f3 = (float)((double)f3 + this.G.nextGaussian() * (double)0.0075f * (double)f5);
        this.k = f *= f4;
        this.l = f2 *= f4;
        this.m = f3 *= f4;
        f4 = MathHelper.c(f * f + f3 * f3);
        this.p = this.n = (float)(Math.atan2(f, f3) * 180.0 / 3.1415927410125732);
        this.q = this.o = (float)(Math.atan2(f2, f4) * 180.0 / 3.1415927410125732);
        this.T = 0;
    }

    @Override
    public final void b_() {
        int n;
        float f;
        Object object;
        super.b_();
        int n2 = this.d.a(this.b, this.O, this.P);
        if (n2 > 0) {
            Block.c[n2].setBlockBoundsBasedOnState(this.d, this.b, this.O, this.P);
            object = Block.c[n2].getCollisionBoundingBoxFromPool(this.d, this.b, this.O, this.P);
            if (object != null && ((net.minecraft.a.d.C_b)object).isVecInside(new net.minecraft.a.d.C_a(this.h, this.i, this.j))) {
                this.R = true;
            }
        }
        if (this.a > 0) {
            --this.a;
        }
        if (this.R) {
            if (this.d.a(this.b, this.O, this.P) == this.Q) {
                ++this.T;
                if (this.T == 1200) {
                    this.k();
                }
                return;
            }
            this.R = false;
            this.k *= this.G.nextFloat() * 0.2f;
            this.l *= this.G.nextFloat() * 0.2f;
            this.m *= this.G.nextFloat() * 0.2f;
            this.T = 0;
            this.U = 0;
        } else {
            ++this.U;
        }
        object = new net.minecraft.a.d.C_a(this.h, this.i, this.j);
        net.minecraft.a.d.C_a c_a = new net.minecraft.a.d.C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        C_c c_c = this.d.a((net.minecraft.a.d.C_a)object, c_a);
        object = new net.minecraft.a.d.C_a(this.h, this.i, this.j);
        c_a = new net.minecraft.a.d.C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        if (c_c != null) {
            c_a = new net.minecraft.a.d.C_a(c_c.f.a, c_c.f.b, c_c.f.c);
        }
        C_b c_b = null;
        List<C_b> list = this.d.r.a(this, this.r.a(this.k, this.l, this.m).b(1.0f, 1.0f, 1.0f));
        float f2 = 0.0f;
        for (int i = 0; i < list.size(); ++i) {
            C_c c_c2;
            C_b c_b2 = list.get(i);
            if (!c_b2.d() || c_b2 == this.S && this.U < 5 || (c_c2 = c_b2.r.b(0.3f, 0.3f, 0.3f).a((net.minecraft.a.d.C_a)object, c_a)) == null || !((f = ((net.minecraft.a.d.C_a)object).b(c_c2.f)) < f2) && f2 != 0.0f) continue;
            c_b = c_b2;
            f2 = f;
        }
        if (c_b != null) {
            c_c = new C_c(c_b);
        }
        int n3 = 3;
        float f3 = 0.4f;
        if (this.arrowType == 1) {
            n3 = 8;
            f3 = 0.8f;
        }
        if (c_c != null) {
            if (c_c.g != null && c_c.g != this.S) {
                f = MathHelper.sqrt_double(this.k * this.k + this.l * this.l + this.m * this.m);
                n = (int)Math.ceil((double)f * (double)n3);
                if (!c_c.g.deflectProjectile) {
                    if (c_c.g.attackEntityFrom(this, n, f3)) {
                        this.d.a(this, "random.drr", 1.0f, 1.2f / (this.G.nextFloat() * 0.2f + 0.9f));
                        this.k();
                        if (this.S instanceof EntityPlayer && c_c.g instanceof C_e && ((C_e)c_c.g).W <= 0) {
                            this.S.awardKillScore(c_c.g, ((C_e)c_c.g).c());
                        }
                    }
                } else {
                    this.k *= -0.1f;
                    this.l *= -0.1f;
                    this.m *= -0.1f;
                    this.n += 180.0f;
                    this.p += 180.0f;
                    this.U = 0;
                    if (c_c.g instanceof EntityPlayer) {
                        EntityPlayer entityPlayer = (EntityPlayer)c_c.g;
                        if (entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].c == Item.shield.ap) {
                            entityPlayer.damageItem(1, entityPlayer.b.charmSlot[0], this.d);
                            entityPlayer.addStat(StatList.objectUseStats[entityPlayer.b.charmSlot[0].c], 1);
                            this.d.a(this, "random.block", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 1.2f));
                            if (entityPlayer.b.charmSlot[0].a <= 0) {
                                entityPlayer.b.charmSlot[0] = null;
                            }
                        }
                    }
                }
            } else {
                this.b = c_c.b;
                this.O = c_c.c;
                this.P = c_c.d;
                this.Q = this.d.a(this.b, this.O, this.P);
                this.k = c_c.f.a - this.h;
                this.l = c_c.f.b - this.i;
                this.m = c_c.f.c - this.j;
                float f4 = MathHelper.c(this.k * this.k + this.l * this.l + this.m * this.m);
                this.h -= this.k / f4 * 0.05f;
                this.i -= this.l / f4 * 0.05f;
                this.j -= this.m / f4 * 0.05f;
                this.d.a(this, "random.drr", 1.0f, 1.2f / (this.G.nextFloat() * 0.2f + 0.9f));
                this.R = true;
                this.a = 7;
            }
        }
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f) {
            int n4 = 0;
            switch (this.d.getWindDirection()) {
                case 0: {
                    n4 = 1;
                    this.h += (float)(((double)this.k + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 1: {
                    n4 = 1;
                    this.j += (float)(((double)this.m + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 2: {
                    this.h += (float)(((double)this.k - (double)this.d.getWindForce()) * 0.2);
                    this.j += (float)(((double)this.m + (double)this.d.getWindForce()) * 0.2);
                    break;
                }
                case 3: {
                    this.h += (float)(((double)this.k + (double)this.d.getWindForce()) * 0.2);
                    this.j += (float)(((double)this.m - (double)this.d.getWindForce()) * 0.2);
                    break;
                }
                case 4: {
                    n4 = 1;
                    this.h += (float)(((double)this.k + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 5: {
                    n4 = -1;
                    this.h += (float)(((double)this.k + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 6: {
                    n4 = -1;
                    this.h += (float)(((double)this.k + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 7: {
                    n4 = -1;
                    this.j += (float)(((double)this.m + (double)((float)n4 * this.d.getWindForce())) * 0.2);
                }
            }
        }
        this.d.a("crit", this.h + this.k, this.i + this.l, this.j + this.m, -this.k, -this.l + 0.2f, -this.m);
        this.h += this.k;
        this.i += this.l;
        this.j += this.m;
        float f5 = MathHelper.c(this.k * this.k + this.m * this.m);
        this.n = (float)(Math.atan2(this.k, this.m) * 180.0 / 3.1415927410125732);
        this.o = (float)(Math.atan2(this.l, f5) * 180.0 / 3.1415927410125732);
        while (this.o - this.q < -180.0f) {
            this.q -= 360.0f;
        }
        while (this.o - this.q >= 180.0f) {
            this.q += 360.0f;
        }
        while (this.n - this.p < -180.0f) {
            this.p -= 360.0f;
        }
        while (this.n - this.p >= 180.0f) {
            this.p += 360.0f;
        }
        this.o = this.q + (this.o - this.q) * 0.2f;
        this.n = this.p + (this.n - this.p) * 0.2f;
        float f6 = 0.99f;
        if (this.l()) {
            for (n = 0; n < 4; ++n) {
                this.d.a("bubble", this.h - this.k * 0.25f, this.i - this.l * 0.25f, this.j - this.m * 0.25f, this.k, this.l, this.m);
            }
            f6 = 0.8f;
        }
        this.k *= f6;
        this.l *= f6;
        this.m *= f6;
        this.l -= 0.03f;
        this.b(this.h, this.i, this.j);
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("xTile", (short)this.b);
        nBTTagCompound.a("yTile", (short)this.O);
        nBTTagCompound.a("zTile", (short)this.P);
        nBTTagCompound.a("inTile", (byte)this.Q);
        nBTTagCompound.a("shake", (byte)this.a);
        nBTTagCompound.a("type", (byte)this.arrowType);
        nBTTagCompound.a("inGround", (byte)(this.R ? 1 : 0));
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        this.b = nBTTagCompound.c("xTile");
        this.O = nBTTagCompound.c("yTile");
        this.P = nBTTagCompound.c("zTile");
        this.Q = nBTTagCompound.b("inTile") & 0xFF;
        this.a = nBTTagCompound.b("shake") & 0xFF;
        this.arrowType = nBTTagCompound.b("type") & 0xFF;
        this.R = nBTTagCompound.b("inGround") == 1;
    }

    @Override
    public final String a() {
        return "Arrow";
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
        int n = Item.h.ap;
        if (this.arrowType == 1) {
            n = Item.arrowAdminium.ap;
        }
        if (this.R && this.arrowType <= 1 && this.a <= 0 && !this.d.multiplayerWorld && !this.u) {
            if (entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].a() == Item.quiver && entityPlayer.b.storeArrowInQuiver(new ItemStack(n, 1))) {
                this.d.a(this, "random.pop", 0.2f, ((this.G.nextFloat() - this.G.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityPlayer.a(this);
                this.k();
            } else if (entityPlayer.b.a(new ItemStack(n, 1))) {
                this.d.a(this, "random.pop", 0.2f, ((this.G.nextFloat() - this.G.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                entityPlayer.a(this);
                this.k();
            }
        }
    }

    @Override
    public final float c_() {
        return 0.0f;
    }
}

