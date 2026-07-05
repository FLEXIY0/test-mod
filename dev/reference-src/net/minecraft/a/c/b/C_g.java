/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class C_g
extends C_c {
    private int courseChangeCooldown = 0;
    private int type;
    private float waypointX;
    private float waypointY;
    private float waypointZ;
    public boolean tamed = false;

    public C_g(net.minecraft.a.a.World c_g) {
        super(c_g);
        this.V = this.type == 1 ? "/mob/salmon.png" : "/mob/cod.png";
        this.W = 5;
        this.a(0.55f, 0.55f);
        this.A = false;
    }

    public C_g(net.minecraft.a.a.World c_g, int n) {
        super(c_g);
        this.type = n;
        this.V = this.type == 1 ? "/mob/salmon.png" : "/mob/cod.png";
        this.W = 5;
        this.a(0.55f, 0.55f);
        this.A = false;
    }

    public C_g(net.minecraft.a.a.World c_g, float f, float f2, float f3) {
        super(c_g);
        this.type = this.G.nextInt(2);
        this.V = this.type == 1 ? "/mob/salmon.png" : "/mob/cod.png";
        this.W = 5;
        this.a(0.55f, 0.55f);
        this.b(f, f2, f3);
        this.A = false;
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Color", this.type);
        nBTTagCompound.a("Pet", this.tamed);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.type = nBTTagCompound.d("Color");
        this.tamed = nBTTagCompound.k("Pet");
        this.V = this.type == 1 ? "/mob/salmon.png" : "/mob/cod.png";
    }

    @Override
    public final String a() {
        return "Fish";
    }

    @Override
    protected String g() {
        return null;
    }

    @Override
    protected String h() {
        return null;
    }

    @Override
    protected String i() {
        return null;
    }

    @Override
    protected int itemDropped() {
        return Item.fishRaw.ap;
    }

    @Override
    public int c() {
        return 10;
    }

    @Override
    public int statId() {
        return 18;
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            int n2 = this.G.nextInt(2);
            int n3 = 10;
            if (c_b != null && c_b instanceof EntityPlayer) {
                for (int i = 0; i < n2; ++i) {
                    this.a(n, 1);
                }
                ItemStack itemStack = ((EntityPlayer)c_b).b.d();
                if (itemStack != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                    n3 = 5;
                }
                if (this.G.nextInt(n3) == 0) {
                    this.a(Item.fishFin.ap, 1);
                }
            }
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.d.e(this.r);
    }

    @Override
    protected void e() {
        if (this.d.multiplayerWorld) {
            return;
        }
        float f = this.waypointX - this.h;
        float f2 = this.waypointY - this.i;
        float f3 = this.waypointZ - this.j;
        this.n = (float)(Math.atan2(f3, f) * 180.0 / 3.1415927410125732) - 90.0f;
        float f4 = MathHelper.c(f * f + f2 * f2 + f3 * f3);
        if (f4 < 1.0f || f4 > 20.0f) {
            this.waypointX = this.h + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointY = this.i + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
            this.waypointZ = this.j + (this.G.nextFloat() * 2.0f - 1.0f) * 6.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.G.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, f4) && this.l()) {
                this.k = (float)((double)this.k + (double)(f / f4) * 0.1);
                this.l = (float)((double)this.l + (double)(f2 / f4) * 0.1);
                this.m = (float)((double)this.m + (double)(f3 / f4) * 0.1);
            } else {
                this.waypointX = this.h;
                this.waypointY = this.i;
                this.waypointZ = this.j;
            }
        }
        if (!this.m() && this.d.f((int)this.h, (int)this.i - 1, (int)this.j) != net.minecraft.a.a.d.C_c.f) {
            this.attackEntityFrom(null, 2, 0.0f);
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
    public boolean l() {
        return this.d.a(this.r.b(0.0f, 0.0f, 0.0f), net.minecraft.a.a.d.C_c.f);
    }

    private void moveSwimming(float f, float f2) {
        float f3 = 0.91f;
        if (this.s) {
            f3 = 0.54600006f;
        }
        float f4 = 0.16277136f / (f3 * f3 * f3);
        this.e(f, f2, this.s ? 0.1f * f4 : 0.02f);
        f3 = 0.91f;
        if (this.s) {
            f3 = 0.54600006f;
        }
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * (double)f3);
        this.l = (float)((double)this.l * (double)f3);
        this.m = (float)((double)this.m * (double)f3);
    }

    @Override
    protected void moveEntityWithHeading(float f, float f2) {
        if (this.u || this.W <= 0) {
            super.moveEntityWithHeading(f, f2);
        } else {
            if (this.l()) {
                this.moveSwimming(f, f2);
            } else if (this.o()) {
                this.e(f, f2, 0.02f);
                this.d(this.k, this.l, this.m);
                this.k = (float)((double)this.k * 0.5);
                this.l = (float)((double)this.l * 0.5);
                this.m = (float)((double)this.m * 0.5);
            } else {
                this.moveSwimming(f, f2);
                this.l = (float)((double)this.l - 0.08);
            }
            float f3 = this.h - this.e;
            float f4 = this.j - this.g;
            float f5 = MathHelper.c(f3 * f3 + f4 * f4) * 4.0f;
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
        }
    }

    @Override
    protected boolean canDespawn() {
        return !this.tamed;
    }
}

