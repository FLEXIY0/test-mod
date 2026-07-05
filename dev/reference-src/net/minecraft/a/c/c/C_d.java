/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_c;
import net.minecraft.client.g.C_a;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_d
extends net.minecraft.a.c.Entity {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private boolean inGround = false;
    public int shake = 0;
    public EntityPlayer angler;
    private int ticksInGround;
    private int ticksInAir = 0;
    private int ticksCatchable = 0;
    public net.minecraft.a.c.Entity bobber = null;
    private int airTime;
    private float netPosX;
    private float altPosY;
    private float altPosZ;
    private float altRotPitch;
    private float altRotYaw;
    private float velocityX;
    private float velocityY;
    private float velocityZ;
    private Item[] lootList = new Item[]{Item.leather, Item.G, Item.bone, Item.rottenFlesh, Item.z, Item.fishFin};
    private boolean bait = false;

    public C_d(World c_g) {
        super(c_g);
        this.a(0.25f, 0.25f);
    }

    public C_d(World c_g, float f, float f2, float f3) {
        this(c_g);
        this.b(f, f2, f3);
    }

    public C_d(World c_g, EntityPlayer entityPlayer) {
        super(c_g);
        this.angler = entityPlayer;
        this.angler.fishEntity = this;
        this.a(0.25f, 0.25f);
        this.b(entityPlayer.h, entityPlayer.i + 1.62f - entityPlayer.v, entityPlayer.j, entityPlayer.n, entityPlayer.o);
        this.h -= MathHelper.b(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.i -= 0.1f;
        this.j -= MathHelper.a(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.b(this.h, this.i, this.j);
        this.v = 0.0f;
        float f = 0.4f;
        this.k = -MathHelper.a(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * f;
        this.m = MathHelper.b(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * f;
        this.l = -MathHelper.a(this.o / 180.0f * (float)Math.PI) * f;
        this.setMotionAndAngles(this.k, this.l, this.m, 1.5f, 1.0f);
    }

    public C_d(World c_g, EntityPlayer entityPlayer, boolean bl) {
        this(c_g, entityPlayer);
        this.bait = bl;
    }

    @Override
    protected void entityInit() {
    }

    public void setMotionAndAngles(float f, float f2, float f3, float f4, float f5) {
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
        float f7 = MathHelper.c(f * f + f3 * f3);
        this.p = this.n = (float)(Math.atan2(f, f3) * 180.0 / 3.1415927410125732);
        this.q = this.o = (float)(Math.atan2(f2, f7) * 180.0 / 3.1415927410125732);
        this.ticksInGround = 0;
    }

    public void setPositionAndRotation(float f, float f2, float f3, float f4, float f5, int n) {
        this.netPosX = f;
        this.altPosY = f2;
        this.altPosZ = f3;
        this.altRotPitch = f4;
        this.altRotYaw = f5;
        this.airTime = n;
        this.k = this.velocityX;
        this.l = this.velocityY;
        this.m = this.velocityZ;
    }

    @Override
    public void setVelocity(float f, float f2, float f3) {
        this.velocityX = this.k = f;
        this.velocityY = this.l = f2;
        this.velocityZ = this.m = f3;
    }

    @Override
    public void b_() {
        super.b_();
        if (this.airTime > 0) {
            float f;
            float f2 = this.h + (this.netPosX - this.h) / (float)this.airTime;
            float f3 = this.i + (this.altPosY - this.i) / (float)this.airTime;
            float f4 = this.j + (this.altPosZ - this.j) / (float)this.airTime;
            for (f = this.altRotPitch - this.n; f < -180.0f; f += 360.0f) {
            }
            while (f >= 180.0f) {
                f -= 360.0f;
            }
            this.n = (float)((double)this.n + (double)f / (double)this.airTime);
            this.o = (float)((double)this.o + ((double)this.altRotYaw - (double)this.o) / (double)this.airTime);
            --this.airTime;
            this.b(f2, f3, f4);
            this.setRotation(this.n, this.o);
        } else {
            float f;
            if (!this.d.multiplayerWorld) {
                ItemStack itemStack = this.angler.b.a[this.angler.b.c];
                if (this.angler.u || !this.angler.r() || itemStack == null || itemStack.a() != Item.fishingRod || this.b(this.angler) > 1024.0f) {
                    this.k();
                    this.angler.fishEntity = null;
                    return;
                }
                if (this.bobber != null) {
                    if (!this.bobber.u) {
                        this.h = this.bobber.h;
                        this.i = this.bobber.r.b + this.bobber.x * 0.8f;
                        this.j = this.bobber.j;
                        return;
                    }
                    this.bobber = null;
                }
            }
            if (this.shake > 0) {
                --this.shake;
            }
            if (this.inGround) {
                int n = this.d.a(this.xTile, this.yTile, this.zTile);
                if (n == this.inTile) {
                    ++this.ticksInGround;
                    if (this.ticksInGround == 1200) {
                        this.k();
                    }
                    return;
                }
                this.k = (float)((double)this.k * (double)(this.G.nextFloat() * 0.2f));
                this.l = (float)((double)this.l * (double)(this.G.nextFloat() * 0.2f));
                this.m = (float)((double)this.m * (double)(this.G.nextFloat() * 0.2f));
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            } else {
                ++this.ticksInAir;
            }
            net.minecraft.a.d.C_a c_a = new net.minecraft.a.d.C_a(this.h, this.i, this.j);
            net.minecraft.a.d.C_a c_a2 = new net.minecraft.a.d.C_a(this.h + this.k, this.i + this.l, this.j + this.m);
            C_c c_c = this.d.a(c_a, c_a2);
            c_a = new net.minecraft.a.d.C_a(this.h, this.i, this.j);
            c_a2 = new net.minecraft.a.d.C_a(this.h + this.k, this.i + this.l, this.j + this.m);
            if (c_c != null) {
                c_a2 = new net.minecraft.a.d.C_a(c_c.f.a, c_c.f.b, c_c.f.c);
            }
            net.minecraft.a.c.Entity c_b = null;
            List<net.minecraft.a.c.Entity> list = this.d.a(this, this.r.a(this.k, this.l, this.m).b(1.0f, 1.0f, 1.0f));
            float f5 = 0.0f;
            for (int i = 0; i < list.size(); ++i) {
                float f6;
                net.minecraft.a.d.C_b c_b2;
                C_c c_c2;
                net.minecraft.a.c.Entity c_b3 = list.get(i);
                if (!c_b3.d() || c_b3 == this.angler && this.ticksInAir < 5 || (c_c2 = (c_b2 = c_b3.r.b(f6 = 0.3f, f6, f6)).a(c_a, c_a2)) == null || !((f = c_a.b(c_c2.f)) < f5) && f5 != 0.0f) continue;
                c_b = c_b3;
                f5 = f;
            }
            if (c_b != null) {
                c_c = new C_c(c_b);
            }
            if (c_c != null) {
                if (c_c.g != null) {
                    if (c_c.g.attackEntityFrom(this.angler, 0, 0.0f)) {
                        this.bobber = c_c.g;
                    }
                } else {
                    this.inGround = true;
                }
            }
            if (!this.inGround) {
                int n;
                this.d(this.k, this.l, this.m);
                float f7 = MathHelper.c(this.k * this.k + this.m * this.m);
                this.n = (float)(Math.atan2(this.k, this.m) * 180.0 / 3.1415927410125732);
                this.o = (float)(Math.atan2(this.l, f7) * 180.0 / 3.1415927410125732);
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
                float f8 = 0.92f;
                if (this.s || this.t) {
                    f8 = 0.5f;
                }
                int n2 = 5;
                float f9 = 0.0f;
                for (n = 0; n < n2; ++n) {
                    if (!this.m()) continue;
                    f9 += 1.0f / (float)n2;
                }
                if (f9 > 0.0f) {
                    if (this.ticksCatchable > 0) {
                        --this.ticksCatchable;
                    } else {
                        n = 300;
                        if (this.d.getRaining() && this.d.l((int)this.h, (int)this.i + 1, (int)this.j) || this.bait) {
                            n = 100;
                        }
                        if (this.G.nextInt(n) == 0) {
                            float f10;
                            float f11;
                            this.ticksCatchable = this.G.nextInt(30) + 10;
                            this.l = (float)((double)this.l - (double)0.2f);
                            this.d.a(this, "random.splash", 0.25f, 1.0f + (this.G.nextFloat() - this.G.nextFloat()) * 0.4f);
                            float f12 = MathHelper.a((double)this.r.b);
                            int n3 = 0;
                            while ((float)n3 < 1.0f + this.w * 20.0f) {
                                f11 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                                f10 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                                this.d.a("bubble", this.h + f11, f12 + 1.0f, this.j + f10, this.k, this.l - this.G.nextFloat() * 0.2f, this.m);
                                ++n3;
                            }
                            n3 = 0;
                            while ((float)n3 < 1.0f + this.w * 20.0f) {
                                f11 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                                f10 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                                this.d.a("splash", this.h + f11, f12 + 1.0f, this.j + f10, this.k, this.l, this.m);
                                ++n3;
                            }
                        }
                    }
                }
                if (this.ticksCatchable > 0) {
                    this.l = (float)((double)this.l - (double)(this.G.nextFloat() * this.G.nextFloat() * this.G.nextFloat()) * 0.2);
                }
                f = f9 * 2.0f - 1.0f;
                float f13 = 0.04f;
                f13 = 0.04f;
                this.l += f13 * f;
                if (f9 > 0.0f) {
                    f8 *= 0.9f;
                    this.l *= 0.8f;
                }
                this.k *= f8;
                this.l *= f8;
                this.m *= f8;
                this.b(this.h, this.i, this.j);
            }
        }
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("xTile", (short)this.xTile);
        nBTTagCompound.a("yTile", (short)this.yTile);
        nBTTagCompound.a("zTile", (short)this.zTile);
        nBTTagCompound.a("inTile", (byte)this.inTile);
        nBTTagCompound.a("shake", (byte)this.shake);
        nBTTagCompound.a("inGround", (byte)(this.inGround ? 1 : 0));
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        this.xTile = nBTTagCompound.c("xTile");
        this.yTile = nBTTagCompound.c("yTile");
        this.zTile = nBTTagCompound.c("zTile");
        this.inTile = nBTTagCompound.b("inTile") & 0xFF;
        this.shake = nBTTagCompound.b("shake") & 0xFF;
        this.inGround = nBTTagCompound.b("inGround") == 1;
    }

    @Override
    public float c_() {
        return 0.0f;
    }

    public int catchFish() {
        int n = 0;
        if (this.bobber != null) {
            float f = this.angler.h - this.h;
            float f2 = this.angler.i - this.i;
            float f3 = this.angler.j - this.j;
            float f4 = MathHelper.c(f * f + f2 * f2 + f3 * f3);
            float f5 = 0.1f;
            this.bobber.k += f * f5;
            this.bobber.l = (float)((double)this.bobber.l + ((double)(f2 * f5) + (double)MathHelper.c(f4) * (double)0.08f));
            this.bobber.m += f3 * f5;
            n = 3;
            this.angler.triggerAchievement(AchievementList.wrangleMob);
        } else if (this.ticksCatchable > 0) {
            int n2 = this.G.nextInt(10);
            int n3 = Item.fishRaw.ap;
            if (n2 == 0) {
                n3 = this.lootList[this.G.nextInt((int)this.lootList.length)].ap;
            }
            if (n3 == Item.fishFin.ap) {
                this.angler.triggerAchievement(AchievementList.killFish);
            }
            EntityItem c_b = new EntityItem(this.d, this.h, this.i, this.j, new ItemStack(n3));
            float f = this.angler.h - this.h;
            float f6 = this.angler.i - this.i - this.angler.v;
            float f7 = this.angler.j - this.j;
            float f8 = MathHelper.c(f * f + f6 * f6 + f7 * f7);
            float f9 = 0.1f;
            c_b.k = f * f9;
            c_b.l = f6 * f9 + MathHelper.c(f8) * 0.08f;
            c_b.m = f7 * f9;
            this.d.spawnEntityInWorld(c_b);
            ((C_a)this.angler).addStat(StatList.fishCaughtStat, 1);
            n = 1;
        }
        if (this.inGround) {
            n = 2;
        }
        this.k();
        this.angler.fishEntity = null;
        return n;
    }

    @Override
    public String a() {
        return "Bobber";
    }
}

