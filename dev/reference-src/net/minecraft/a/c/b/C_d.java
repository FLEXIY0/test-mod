/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.d.C_a;
import util.MathHelper;

public class C_d
extends C_e {
    private int courseChangeCooldown = 0;
    private float waypointX;
    private float waypointY;
    private float waypointZ;
    private float rotation;

    public C_d(C_g c_g) {
        super(c_g);
        this.V = "/mob/bat.png";
        this.a(0.5f, 0.9f);
        this.setIsBatHanging(true);
        this.W = 6;
        this.rotation = this.G.nextInt(360);
        this.A = false;
    }

    public C_d(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/bat.png";
        this.a(0.5f, 0.9f);
        this.W = 6;
        this.b(f, f2, f3);
        this.A = false;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(12, new Byte(0));
    }

    @Override
    protected void e() {
        float f;
        float f2;
        float f3;
        if (this.d.multiplayerWorld) {
            this.setIsBatHanging(this.isSleeping());
            return;
        }
        if (this.b == null) {
            this.b = this.b();
            if (this.b != null) {
                this.a = this.d.C.a(this, this.b, 16.0f);
            }
        } else if (!this.b.r()) {
            this.b = null;
        } else {
            C_b c_b = this.b;
            f3 = this.b.h - this.h;
            f2 = c_b.i - this.i;
            f = c_b.j - this.j;
            float f4 = MathHelper.c(f3 * f3 + f2 * f2 + f * f);
            if (this.d.a(new C_a(this.h, this.i + this.n(), this.j), new C_a(this.b.h, this.b.i + this.b.n(), this.b.j)) == null) {
                this.a(this.b, f4);
            }
        }
        if (this.isLaying) {
            this.am = 0.0f;
            this.isJumping = false;
        } else {
            this.am = this.b != null ? 1.2f : 0.7f;
        }
        float f5 = this.waypointX - this.h;
        f3 = this.waypointY - this.i;
        f2 = this.waypointZ - this.j;
        this.n = !this.isLaying ? (float)(Math.atan2(f2, f5) * 180.0 / 3.1415927410125732) - 90.0f : this.rotation;
        f = MathHelper.c(f5 * f5 + f3 * f3 + f2 * f2);
        if (this.b != null) {
            this.waypointX = this.b.h;
            this.waypointY = this.b.i;
            this.waypointZ = this.b.j;
            this.isLaying = false;
        } else if (f < 1.0f || f > 20.0f) {
            this.waypointX = this.h + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointY = this.i + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointZ = this.j + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.G.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, f) && !this.isLaying) {
                this.k = (float)((double)this.k + (double)(f5 / f) * 0.1);
                this.l = (float)((double)this.l + (double)(f3 / f) * 0.1);
                this.m = (float)((double)this.m + (double)(f2 / f) * 0.1);
            } else {
                this.waypointX = this.h;
                this.waypointY = this.i;
                this.waypointZ = this.j;
            }
        }
    }

    public boolean isSleeping() {
        return (this.dataWatcher.getWatchableObjectByte(12) & 0xC) != 0;
    }

    @Override
    protected void a(C_b c_b, float f) {
        if ((double)f < 1.5 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, this.a, 0.4f);
        }
    }

    @Override
    protected void b(float f) {
    }

    @Override
    protected void moveEntityWithHeading(float f, float f2) {
        if (this.u || this.W <= 0) {
            super.moveEntityWithHeading(f, f2);
        } else {
            float f3;
            float f4;
            if (this.l()) {
                this.e(f, f2, 0.02f);
                this.d(this.k, this.l, this.m);
                this.k = (float)((double)this.k * (double)0.8f);
                this.l = (float)((double)this.l * (double)0.8f);
                this.m = (float)((double)this.m * (double)0.8f);
            } else if (this.o()) {
                this.e(f, f2, 0.02f);
                this.d(this.k, this.l, this.m);
                this.k = (float)((double)this.k * 0.5);
                this.l = (float)((double)this.l * 0.5);
                this.m = (float)((double)this.m * 0.5);
            } else {
                f4 = 0.91f;
                if (this.s) {
                    f4 = 0.54600006f;
                }
                f3 = 0.16277136f / (f4 * f4 * f4);
                this.e(f, f2, this.s ? 0.1f * f3 : 0.02f);
                f4 = 0.91f;
                if (this.s) {
                    f4 = 0.54600006f;
                }
                this.d(this.k, this.l, this.m);
                this.k = (float)((double)this.k * (double)f4);
                this.l = (float)((double)this.l * (double)f4);
                this.m = (float)((double)this.m * (double)f4);
            }
            f4 = this.h - this.e;
            f3 = this.j - this.g;
            float f5 = MathHelper.c(f4 * f4 + f3 * f3) * 4.0f;
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
        }
    }

    private boolean isCourseTraversable(float f, float f2, float f3, float f4) {
        float f5 = (this.waypointX - this.h) / f4;
        float f6 = (this.waypointY - this.i) / f4;
        float f7 = (this.waypointZ - this.j) / f4;
        net.minecraft.a.d.C_b c_b = this.r.a();
        int n = 1;
        while ((float)n < f4) {
            c_b.c(f5, f6, f7);
            if (this.d.getCollidingBoundingBoxes(this, c_b).size() > 0) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Sleeping", this.isLaying);
        nBTTagCompound.a("SleepRot", this.rotation);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.isLaying = nBTTagCompound.k("Sleeping");
        this.rotation = nBTTagCompound.f("SleepRot");
    }

    @Override
    protected float getSoundVolume() {
        return 0.1f;
    }

    @Override
    protected String g() {
        return this.getIsBatHanging() && this.G.nextInt(4) != 0 ? null : "mob.bat";
    }

    @Override
    protected String h() {
        return "mob.bathurt";
    }

    @Override
    protected String i() {
        return "mob.batdeath";
    }

    @Override
    public String a() {
        return "Bat";
    }

    public boolean getIsBatHanging() {
        return this.isLaying;
    }

    public void setIsBatHanging(boolean bl) {
        this.isLaying = bl;
    }

    @Override
    protected int itemDropped() {
        return 0;
    }

    @Override
    public int c() {
        return 10;
    }

    @Override
    public int statId() {
        return 16;
    }
}

