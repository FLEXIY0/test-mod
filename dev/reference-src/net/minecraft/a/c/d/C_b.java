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
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_c;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_b
extends net.minecraft.a.c.C_b {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private boolean inGround = false;
    public int arrowShake = 0;
    public C_e owner;
    private int ticksInGround;
    private int ticksInAir = 0;
    public int arrowType = 0;

    public C_b(World c_g, C_e c_e, int n) {
        super(c_g);
        this.owner = c_e;
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
        this.setArrowHeading2(this.k, this.l, this.m, 1.5f, 1.0f);
    }

    public C_b(World c_g) {
        super(c_g);
    }

    public C_b(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.a(0.5f, 0.5f);
        this.b(f, f2, f3);
        this.v = 0.0f;
    }

    @Override
    protected void entityInit() {
    }

    public final void setArrowHeading(float f, float f2, float f3, float f4, float f5) {
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
        this.ticksInGround = 0;
    }

    public final void setArrowHeading2(float f, float f2, float f3, float f4, float f5) {
        float f6 = MathHelper.c(f * f + f2 * f2 + f3 * f3);
        f /= f6;
        f2 /= f6;
        f3 /= f6;
        this.k = f *= f4;
        this.l = f2 *= f4;
        this.m = f3 *= f4;
        f4 = MathHelper.c(f * f + f3 * f3);
        this.p = this.n = (float)(Math.atan2(f, f3) * 180.0 / 3.1415927410125732);
        this.q = this.o = (float)(Math.atan2(f2, f4) * 180.0 / 3.1415927410125732);
        this.ticksInGround = 0;
    }

    @Override
    public final void b_() {
        Object object;
        Object object2;
        super.b_();
        int n = this.d.a(this.xTile, this.yTile, this.zTile);
        if (n > 0) {
            Block.c[n].setBlockBoundsBasedOnState(this.d, this.xTile, this.yTile, this.zTile);
            object2 = Block.c[n].getCollisionBoundingBoxFromPool(this.d, this.xTile, this.yTile, this.zTile);
            if (object2 != null && ((net.minecraft.a.d.C_b)object2).isVecInside(new C_a(this.h, this.i, this.j))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            if (this.d.a(this.xTile, this.yTile, this.zTile) == this.inTile) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.k();
                }
                return;
            }
            this.inGround = false;
            this.k *= this.G.nextFloat() * 0.2f;
            this.l *= this.G.nextFloat() * 0.2f;
            this.m *= this.G.nextFloat() * 0.2f;
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        } else {
            ++this.ticksInAir;
        }
        object2 = new C_a(this.h, this.i, this.j);
        C_a c_a = new C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        C_c c_c = this.d.a((C_a)object2, c_a);
        object2 = new C_a(this.h, this.i, this.j);
        c_a = new C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        if (c_c != null) {
            c_a = new C_a(c_c.f.a, c_c.f.b, c_c.f.c);
        }
        net.minecraft.a.c.C_b c_b = null;
        List<net.minecraft.a.c.C_b> list = this.d.r.a(this, this.r.a(this.k, this.l, this.m).b(1.0f, 1.0f, 1.0f));
        float f = 0.0f;
        for (int i = 0; i < list.size(); ++i) {
            float f2;
            net.minecraft.a.c.C_b c_b2 = list.get(i);
            if (!c_b2.d() || c_b2 == this.owner && this.ticksInAir < 5 || (object = c_b2.r.b(0.3f, 0.3f, 0.3f).a((C_a)object2, c_a)) == null || !((f2 = ((C_a)object2).b(((C_c)object).f)) < f) && f != 0.0f) continue;
            c_b = c_b2;
            f = f2;
        }
        if (c_b != null) {
            c_c = new C_c(c_b);
        }
        int n2 = 4;
        if (this.arrowType > 0) {
            n2 = 6;
        }
        if (c_c != null) {
            if (c_c.g != null) {
                if (!c_c.g.deflectProjectile) {
                    if (c_c.g.attackEntityFrom(this, n2, 0.4f)) {
                        this.d.a(this, "random.drr", 1.0f, 1.2f / (this.G.nextFloat() * 0.2f + 0.9f));
                        this.k();
                        if (this.arrowType == 1 || this.arrowType == 2) {
                            c_c.g.poison = 100;
                        }
                        if (this.owner instanceof EntityPlayer && c_c.g instanceof C_e) {
                            if (((C_e)c_c.g).W <= 0) {
                                this.owner.awardKillScore(c_c.g, ((C_e)c_c.g).c());
                            }
                            ((EntityPlayer)this.owner).triggerAchievement(AchievementList.fireArrow);
                        }
                    }
                } else {
                    this.k *= -0.1f;
                    this.l *= -0.1f;
                    this.m *= -0.1f;
                    this.n += 180.0f;
                    this.p += 180.0f;
                    this.ticksInAir = 0;
                    if (c_c.g instanceof EntityPlayer) {
                        object = (EntityPlayer)c_c.g;
                        if (((EntityPlayer)object).b.charmSlot[0] != null && ((EntityPlayer)object).b.charmSlot[0].c == Item.shield.ap) {
                            ((EntityPlayer)object).damageItem(1, ((EntityPlayer)object).b.charmSlot[0], this.d);
                            ((EntityPlayer)object).addStat(StatList.objectUseStats[((EntityPlayer)object).b.charmSlot[0].c], 1);
                            this.d.a(this, "random.block", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 1.2f));
                            if (((EntityPlayer)object).b.charmSlot[0].a <= 0) {
                                ((EntityPlayer)object).b.charmSlot[0] = null;
                            }
                        }
                    }
                }
            } else {
                this.xTile = c_c.b;
                this.yTile = c_c.c;
                this.zTile = c_c.d;
                this.inTile = this.d.a(this.xTile, this.yTile, this.zTile);
                this.k = c_c.f.a - this.h;
                this.l = c_c.f.b - this.i;
                this.m = c_c.f.c - this.j;
                float f3 = MathHelper.c(this.k * this.k + this.l * this.l + this.m * this.m);
                this.h -= this.k / f3 * 0.05f;
                this.i -= this.l / f3 * 0.05f;
                this.j -= this.m / f3 * 0.05f;
                this.d.a(this, "random.drr", 1.0f, 1.2f / (this.G.nextFloat() * 0.2f + 0.9f));
                this.inGround = true;
                this.arrowShake = 7;
            }
        }
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f) {
            int n3 = 0;
            switch (this.d.getWindDirection()) {
                case 0: {
                    n3 = 1;
                    this.h += (float)(((double)this.k + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 1: {
                    n3 = 1;
                    this.j += (float)(((double)this.m + (double)((float)n3 * this.d.getWindForce())) * 0.2);
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
                    n3 = 1;
                    this.h += (float)(((double)this.k + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 5: {
                    n3 = -1;
                    this.h += (float)(((double)this.k + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 6: {
                    n3 = -1;
                    this.h += (float)(((double)this.k + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 7: {
                    n3 = -1;
                    this.j += (float)(((double)this.m + (double)((float)n3 * this.d.getWindForce())) * 0.2);
                }
            }
        }
        this.h += this.k;
        this.i += this.l;
        this.j += this.m;
        float f4 = MathHelper.c(this.k * this.k + this.m * this.m);
        this.n = (float)(Math.atan2(this.k, this.m) * 180.0 / 3.1415927410125732);
        this.o = (float)(Math.atan2(this.l, f4) * 180.0 / 3.1415927410125732);
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
        float f5 = 0.99f;
        if (this.l()) {
            for (int i = 0; i < 4; ++i) {
                this.d.a("bubble", this.h - this.k * 0.25f, this.i - this.l * 0.25f, this.j - this.m * 0.25f, this.k, this.l, this.m);
            }
            f5 = 0.8f;
        } else if (this.arrowType != 0) {
            for (int i = 0; i < 4; ++i) {
                this.d.a("spell", this.h - this.k * 0.25f, this.i - this.l * 0.25f, this.j - this.m * 0.25f, this.k, this.l, this.m);
            }
        }
        this.k *= f5;
        this.l *= f5;
        this.m *= f5;
        this.l -= 0.01f;
        this.b(this.h, this.i, this.j);
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("xTile", (short)this.xTile);
        nBTTagCompound.a("yTile", (short)this.yTile);
        nBTTagCompound.a("zTile", (short)this.zTile);
        nBTTagCompound.a("inTile", (byte)this.inTile);
        nBTTagCompound.a("shake", (byte)this.arrowShake);
        nBTTagCompound.a("type", (byte)this.arrowType);
        nBTTagCompound.a("inGround", (byte)(this.inGround ? 1 : 0));
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound.c("xTile");
        this.yTile = nBTTagCompound.c("yTile");
        this.zTile = nBTTagCompound.c("zTile");
        this.inTile = nBTTagCompound.b("inTile") & 0xFF;
        this.arrowShake = nBTTagCompound.b("shake") & 0xFF;
        this.arrowType = nBTTagCompound.b("type") & 0xFF;
        this.inGround = nBTTagCompound.b("inGround") == 1;
    }

    @Override
    public final String a() {
        return "Dart";
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
        int n = Item.dart.ap;
        if (this.arrowType == 1) {
            n = Item.dartPoison.ap;
        }
        if (this.inGround && this.arrowType <= 1 && this.arrowShake <= 0 && !this.d.multiplayerWorld && !this.u) {
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

