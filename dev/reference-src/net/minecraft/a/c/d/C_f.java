/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.d;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.a.C_j;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_c;
import net.minecraft.client.statistics.AchievementList;
import util.MathHelper;

public class C_f
extends C_b {
    private int xTileSnowball = -1;
    private int yTileSnowball = -1;
    private int zTileSnowball = -1;
    private int inTileSnowball = 0;
    public C_e thrower;
    private int ticksInAirSnowball = 0;

    public C_f(World c_g) {
        super(c_g);
        this.a(0.25f, 0.25f);
    }

    @Override
    protected void entityInit() {
    }

    public C_f(World c_g, C_e c_e) {
        super(c_g);
        this.thrower = c_e;
        this.a(0.25f, 0.25f);
        this.b(c_e.h, c_e.i + c_e.n(), c_e.j, c_e.n, c_e.o);
        this.h -= MathHelper.b(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.i -= 0.1f;
        this.j -= MathHelper.a(this.n / 180.0f * (float)Math.PI) * 0.16f;
        this.b(this.h, this.i, this.j);
        this.v = 0.0f;
        float f = 0.4f;
        this.k = -MathHelper.a(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * f;
        this.m = MathHelper.b(this.n / 180.0f * (float)Math.PI) * MathHelper.b(this.o / 180.0f * (float)Math.PI) * f;
        this.l = -MathHelper.a(this.o / 180.0f * (float)Math.PI) * f;
        this.setSnowballHeading(this.k, this.l, this.m, 1.5f, 1.0f);
    }

    public C_f(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.a(0.25f, 0.25f);
        this.b(f, f2, f3);
        this.v = 0.0f;
    }

    public void setSnowballHeading(float f, float f2, float f3, float f4, float f5) {
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
    }

    @Override
    public void b_() {
        this.B = this.h;
        this.C = this.i;
        this.D = this.j;
        super.b_();
        ++this.ticksInAirSnowball;
        C_a c_a = new C_a(this.h, this.i, this.j);
        C_a c_a2 = new C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        C_c c_c = this.d.a(c_a, c_a2);
        c_a = new C_a(this.h, this.i, this.j);
        c_a2 = new C_a(this.h + this.k, this.i + this.l, this.j + this.m);
        if (c_c != null) {
            c_a2 = c_a.a(c_c.f.a, c_c.f.b, c_c.f.c);
        }
        if (!this.d.multiplayerWorld) {
            C_b c_b = null;
            List<C_b> list = this.d.a(this, this.r.a(this.k, this.l, this.m).b(1.0f, 1.0f, 1.0f));
            double d2 = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                float f;
                float f2;
                net.minecraft.a.d.C_b c_b2;
                C_c c_c2;
                C_b c_b3 = list.get(i);
                if (!c_b3.d() || c_b3 == this.thrower && this.ticksInAirSnowball < 5 || (c_c2 = (c_b2 = c_b3.r.b(f2 = 0.3f, f2, f2)).a(c_a, c_a2)) == null || !((double)(f = c_a.b(c_c2.f)) < d2) && d2 != 0.0) continue;
                c_b = c_b3;
                d2 = f;
            }
            if (c_b != null) {
                c_c = new C_c(c_b);
            }
        }
        if (c_c != null) {
            if (c_c.g != null) {
                int n = 0;
                if (c_c.g instanceof C_j) {
                    n = 2;
                }
                if (c_c.g.attackEntityFrom(this.thrower, n, 0.4f) && c_c.g instanceof C_j && ((C_j)c_c.g).W <= 0 && this.thrower instanceof EntityPlayer) {
                    ((EntityPlayer)this.thrower).triggerAchievement(AchievementList.killImpSpecial);
                }
            } else if (this.d.a((int)this.h, (int)this.i, (int)this.j) == 0 && this.d.a(this.h, this.i - 1.0f, this.j) && !(this.d.f((int)this.h, (int)this.i, (int)this.j) instanceof net.minecraft.a.a.d.C_b)) {
                this.d.a((int)this.h, (int)this.i, (int)this.j, Block.snowLayer.at);
            }
            for (int i = 0; i < 8; ++i) {
                this.d.a("snowballpoof", this.h, this.i, this.j, 0.0f, 0.0f, 0.0f);
            }
            this.k();
        }
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f) {
            int n = 0;
            switch (this.d.getWindDirection()) {
                case 0: {
                    n = 1;
                    this.h += (float)(((double)this.k + (double)((float)n * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 1: {
                    n = 1;
                    this.j += (float)(((double)this.m + (double)((float)n * this.d.getWindForce())) * 0.2);
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
                    n = 1;
                    this.h += (float)(((double)this.k + (double)((float)n * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 5: {
                    n = -1;
                    this.h += (float)(((double)this.k + (double)((float)n * this.d.getWindForce())) * 0.2);
                    this.j += (float)(((double)this.m + (double)((float)n * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 6: {
                    n = -1;
                    this.h += (float)(((double)this.k + (double)((float)n * this.d.getWindForce())) * 0.2);
                    break;
                }
                case 7: {
                    n = -1;
                    this.j += (float)(((double)this.m + (double)((float)n * this.d.getWindForce())) * 0.2);
                }
            }
        }
        this.h += this.k;
        this.i += this.l;
        this.j += this.m;
        float f = MathHelper.c(this.k * this.k + this.m * this.m);
        this.n = (float)(Math.atan2(this.k, this.m) * 180.0 / 3.1415927410125732);
        this.o = (float)(Math.atan2(this.l, f) * 180.0 / 3.1415927410125732);
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
        float f3 = 0.99f;
        float f4 = 0.03f;
        if (this.l()) {
            for (int i = 0; i < 4; ++i) {
                float f5 = 0.25f;
                this.d.a("bubble", this.h - this.k * f5, this.i - this.l * f5, this.j - this.m * f5, this.k, this.l, this.m);
            }
            f3 = 0.8f;
        }
        this.k = (float)((double)this.k * (double)f3);
        this.l = (float)((double)this.l * (double)f3);
        this.m = (float)((double)this.m * (double)f3);
        this.l = (float)((double)this.l - (double)f4);
        this.b(this.h, this.i, this.j);
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("xTile", (short)this.xTileSnowball);
        nBTTagCompound.a("yTile", (short)this.yTileSnowball);
        nBTTagCompound.a("zTile", (short)this.zTileSnowball);
        nBTTagCompound.a("inTile", (byte)this.inTileSnowball);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        this.xTileSnowball = nBTTagCompound.c("xTile");
        this.yTileSnowball = nBTTagCompound.c("yTile");
        this.zTileSnowball = nBTTagCompound.c("zTile");
        this.inTileSnowball = nBTTagCompound.b("inTile") & 0xFF;
    }

    @Override
    public float c_() {
        return 0.0f;
    }

    @Override
    public String a() {
        return "Snowball";
    }
}

