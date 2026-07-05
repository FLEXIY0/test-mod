/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.d.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import util.MathHelper;

public class C_h
extends C_e {
    private int courseChangeCooldown = 0;
    private float waypointX;
    private float waypointY;
    private float waypointZ;
    private boolean canShoot = true;

    public C_h(World c_g) {
        super(c_g);
        this.V = "/mob/harpy.png";
        this.a(0.8f, 2.4f);
        this.W = 12;
        this.am = 1.2f;
        this.A = false;
    }

    public C_h(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/harpy.png";
        this.a(0.8f, 2.4f);
        this.W = 12;
        this.am = 1.2f;
        this.b(f, f2, f3);
        this.A = false;
    }

    @Override
    protected void e() {
        float f;
        float f2;
        float f3;
        float f4;
        if (this.d.multiplayerWorld) {
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
            Entity c_b = this.b;
            f4 = this.b.h - this.h;
            f3 = c_b.i - this.i;
            f2 = c_b.j - this.j;
            f = MathHelper.c(f4 * f4 + f3 * f3 + f2 * f2);
            if (this.d.a(new C_a(this.h, this.i + this.n(), this.j), new C_a(this.b.h, this.b.i + this.b.n(), this.b.j)) == null) {
                this.attackEntityDirectly(this.b, f);
                if (this.canShoot) {
                    this.a(this.b, f);
                }
            }
        }
        float f5 = this.waypointX - this.h;
        f4 = this.waypointY - this.i;
        f3 = this.waypointZ - this.j;
        this.n = (float)(Math.atan2(f3, f5) * 180.0 / 3.1415927410125732) - 90.0f;
        f2 = MathHelper.c(f5 * f5 + f4 * f4 + f3 * f3);
        if (this.b != null) {
            f = this.b.h - this.h;
            float f6 = this.b.i - this.i;
            float f7 = this.b.j - this.j;
            float f8 = MathHelper.c(f * f + f6 * f6 + f7 * f7);
            if (f8 > 20.0f) {
                this.waypointX = this.b.h;
                this.waypointY = this.b.i;
                this.waypointZ = this.b.j;
                this.am = 5.0f;
                this.canShoot = false;
            } else {
                this.setWayPoint(f2);
            }
        } else {
            this.setWayPoint(f2);
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.G.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, f2)) {
                this.k = (float)((double)this.k + (double)(f5 / f2) * 0.1 * (double)this.am);
                this.l = (float)((double)this.l + (double)(f4 / f2) * 0.1 * (double)this.am);
                this.m = (float)((double)this.m + (double)(f3 / f2) * 0.1 * (double)this.am);
            } else {
                this.waypointX = this.h;
                this.waypointY = this.i;
                this.waypointZ = this.j;
            }
        }
    }

    private void setWayPoint(float f) {
        if (f < 1.0f || f > 60.0f) {
            this.waypointX = this.h + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointY = this.i + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointZ = this.j + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.am = 1.2f;
            this.canShoot = true;
        }
    }

    @Override
    protected final void a(Entity c_b, float f) {
        if (this.d.multiplayerWorld) {
            return;
        }
        if (f < 20.0f) {
            f = c_b.h - this.h;
            float f2 = c_b.j - this.j;
            if (this.ac == 0) {
                C_c c_c = new C_c(this.d, this);
                c_c.i += 1.0f;
                c_c.b(this.h, this.i + this.n(), this.j);
                float f3 = c_b.i + c_b.n() - 1.1f - c_c.i;
                this.d.a(this, "random.breath", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 0.8f));
                this.d.spawnEntityInWorld(c_c);
                c_c.setSnowballHeading(f, f3, f2, 1.0f, 12.0f);
                this.ac = 30;
            }
            this.n = (float)(Math.atan2(f2, f) * 180.0 / 3.1415927410125732) - 90.0f;
            this.O = true;
        }
    }

    protected void attackEntityDirectly(Entity c_b, float f) {
        if ((double)f < 2.5 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, this.a, 0.4f);
        }
    }

    @Override
    protected Entity b() {
        return this.d.y.b(this) < 512.0f && ((EntityPlayer)this.d.y).gamemode == 0 ? this.d.y : null;
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
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
    }

    @Override
    protected float getSoundVolume() {
        return 0.5f;
    }

    @Override
    protected String g() {
        return "mob.harpy";
    }

    @Override
    protected String h() {
        return "mob.harpyhurt";
    }

    @Override
    protected String i() {
        return "mob.harpyhurt";
    }

    @Override
    public String a() {
        return "Harpy";
    }

    @Override
    protected int itemDropped() {
        return Item.harpyFeather.ap;
    }

    @Override
    public int c() {
        return 105;
    }

    @Override
    public int statId() {
        return 20;
    }

    @Override
    protected void dropFewItems(Entity c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2 = this.G.nextInt(5);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 = 0;
            }
            if (n2 == 0) {
                this.a(n, 1);
            }
        }
    }
}

