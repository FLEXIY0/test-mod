/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_c;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import util.MathHelper;

public class C_i
extends C_c {
    public float tentacle1Motion = 0.0f;
    public float tentacle1PrevMotion = 0.0f;
    public float tentacle2Motion = 0.0f;
    public float tentacle2PrevMotion = 0.0f;
    public float tentacle3Motion = 0.0f;
    public float tentacle3PrevMotion = 0.0f;
    public float tentacle4Motion = 0.0f;
    public float tentacle4PrevMotion = 0.0f;
    private float randomMotionSpeed = 0.0f;
    private float tentacleAngle = 0.0f;
    private float lastTentacleAngle = 0.0f;
    private float randomMotionVecX = 0.0f;
    private float randomMotionVecY = 0.0f;
    private float randomMotionVecZ = 0.0f;

    public C_i(World c_g) {
        super(c_g);
        this.V = "/mob/jellyfish.png";
        this.W = 10;
        this.a(0.95f, 0.75f);
        this.tentacleAngle = 1.0f / (this.G.nextFloat() + 1.0f) * 0.2f;
        this.canGlow = true;
        this.A = false;
    }

    public C_i(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/jellyfish.png";
        this.W = 10;
        this.a(0.95f, 0.75f);
        this.tentacleAngle = 1.0f / (this.G.nextFloat() + 1.0f) * 0.2f;
        this.b(f, f2, f3);
        this.canGlow = true;
        this.A = false;
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
    public final String a() {
        return "Jellyfish";
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
    protected final int itemDropped() {
        return Item.jellyfishTentacle.ap;
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2 = 10;
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 = 5;
            }
            if (this.G.nextInt(n2) == 0) {
                this.a(n, 1);
            }
        }
    }

    @Override
    public int c() {
        return 10;
    }

    @Override
    public int statId() {
        return 17;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.d.e(this.r);
    }

    @Override
    public boolean isInWater() {
        return this.d.a(this.r.b(0.0f, -0.6f, 0.0f), net.minecraft.a.a.d.C_c.f);
    }

    @Override
    public void f() {
        super.f();
        this.tentacle1PrevMotion = this.tentacle1Motion;
        this.tentacle2PrevMotion = this.tentacle2Motion;
        this.tentacle3PrevMotion = this.tentacle3Motion;
        this.tentacle4PrevMotion = this.tentacle4Motion;
        this.tentacle3Motion += this.tentacleAngle;
        if (this.tentacle3Motion > (float)Math.PI * 2) {
            this.tentacle3Motion -= (float)Math.PI * 2;
            if (this.G.nextInt(10) == 0) {
                this.tentacleAngle = 1.0f / (this.G.nextFloat() + 1.0f) * 0.2f;
            }
        }
        if (this.isInWater()) {
            float f;
            if (this.tentacle3Motion < (float)Math.PI) {
                f = this.tentacle3Motion / (float)Math.PI;
                this.tentacle4Motion = MathHelper.a(f * f * (float)Math.PI) * (float)Math.PI * 0.25f;
                if ((double)f > 0.75) {
                    this.randomMotionSpeed = 1.0f;
                    this.lastTentacleAngle = 1.0f;
                } else {
                    this.lastTentacleAngle *= 0.8f;
                }
            } else {
                this.tentacle4Motion = 0.0f;
                this.randomMotionSpeed *= 0.9f;
                this.lastTentacleAngle *= 0.99f;
            }
            this.k = this.randomMotionVecX * this.randomMotionSpeed;
            this.l = this.randomMotionVecY * this.randomMotionSpeed;
            this.m = this.randomMotionVecZ * this.randomMotionSpeed;
            f = MathHelper.c(this.k * this.k + this.m * this.m);
            this.T += (-((float)Math.atan2(this.k, this.m)) * 180.0f / (float)Math.PI - this.T) * 0.1f;
            this.n = this.T;
            this.tentacle2Motion += (float)Math.PI * this.lastTentacleAngle * 1.5f;
            this.tentacle1Motion += (-((float)Math.atan2(f, this.l)) * 180.0f / (float)Math.PI - this.tentacle1Motion) * 0.1f;
        } else {
            this.tentacle4Motion = MathHelper.e(MathHelper.a(this.tentacle3Motion)) * (float)Math.PI * 0.25f;
            this.k = 0.0f;
            this.l -= 0.08f;
            this.l *= 0.98f;
            this.m = 0.0f;
            this.tentacle1Motion = (float)((double)this.tentacle1Motion + (double)(-90.0f - this.tentacle1Motion) * 0.02);
        }
        if (!this.m()) {
            this.attackEntityFrom(null, 2, 0.0f);
        }
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        this.d(this.k, this.l, this.m);
    }

    @Override
    protected void e() {
        float f;
        if (this.G.nextInt(50) == 0 || !this.R || this.randomMotionVecX == 0.0f && this.randomMotionVecY == 0.0f && this.randomMotionVecZ == 0.0f) {
            f = this.G.nextFloat() * (float)Math.PI * 2.0f;
            this.randomMotionVecX = MathHelper.b(f) * 0.2f;
            this.randomMotionVecY = -0.1f + this.G.nextFloat() * 0.2f;
            this.randomMotionVecZ = MathHelper.a(f) * 0.2f;
        }
        if (this.b == null) {
            this.b = this.b();
        } else if (!this.b.r()) {
            this.b = null;
        } else {
            C_b c_b = this.b;
            float f2 = this.b.h - this.h;
            float f3 = c_b.i - this.i;
            f = c_b.j - this.j;
            float f4 = MathHelper.c(f2 * f2 + f3 * f3 + f * f);
            if (this.d.a(new C_a(this.h, this.i + this.n(), this.j), new C_a(this.b.h, this.b.i + this.b.n(), this.b.j)) == null) {
                this.a(this.b, f4);
            }
        }
    }

    @Override
    protected C_b b() {
        return this.d.y.b(this) < 256.0f ? this.d.y : null;
    }

    @Override
    protected void a(C_b c_b, float f) {
        if ((double)f < 1.5 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, 2, 0.4f);
        }
    }
}

