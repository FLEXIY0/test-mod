/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import com.a.a.NBTTagCompound;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_n;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_e
extends C_b {
    public int S = 20;
    public float T = 0.0f;
    public float U = 0.0f;
    private float a;
    protected String V = "/char.png";
    public int W;
    public int X;
    private int P;
    public int Y;
    public int Z;
    public float aa = 0.0f;
    public int ab = 0;
    public int ac = 0;
    public float ad;
    public float ae;
    public float af;
    public float ag;
    public float ah;
    protected int ai = 0;
    protected float aj;
    protected float ak;
    protected float Q;
    protected float am;
    private float counter;
    public float prevSwingProgress;
    public float swingProgress;
    public boolean isMultiplayerEntity = false;
    protected int damageTaken = 0;
    protected int newPosRotationIncrements;
    protected float newPosX;
    protected float newPosY;
    protected float newPosZ;
    protected float newRotationYaw;
    protected float newRotationPitch;

    public C_e(World c_g) {
        super(c_g);
        this.isJumping = false;
        this.am = 0.7f;
        this.W = 10;
        this.c = true;
        this.b(this.h, this.i, this.j);
        this.n = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.E = 0.5f;
    }

    public C_e(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.isJumping = false;
        this.am = 0.7f;
        this.W = 10;
        this.c = true;
        this.b(this.h, this.i, this.j);
        this.n = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.E = 0.5f;
        this.b(f, f2, f3);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public final String q() {
        return this.V;
    }

    @Override
    public boolean d() {
        return !this.u && !this.isLaying && !this.isSitting;
    }

    @Override
    public final boolean p() {
        return !this.u && !this.isLaying && !this.isSitting;
    }

    @Override
    public float n() {
        return this.x * 0.85f;
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected boolean canDespawn() {
        return true;
    }

    @Override
    public void b_() {
        boolean bl;
        float f;
        float f2;
        int n;
        this.prevSwingProgress = this.swingProgress;
        super.b_();
        if (this.G.nextInt(1000) < this.P++) {
            this.P = -80;
            String string = this.g();
            if (string != null) {
                this.d.a(this, string, this.getSoundVolume(), (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
            }
        }
        if ((this.m() || this.d.type == 8) && this.r() && !this.canBreatheUnderwater()) {
            if (this.counter % 8.0f == 0.0f) {
                this.d.a("bubble", this.h, this.i - 0.1f, this.j, 0.0f, -this.l, 0.0f);
            }
            if (this.isInMagmaAirPocket()) {
                this.counter -= 5.0f;
                if (this.counter < 0.0f) {
                    this.counter = 0.0f;
                }
                this.M += 5;
                if (this.M > this.K) {
                    this.M = this.K;
                }
            } else {
                this.counter += 1.0f;
                if (this.M > this.K) {
                    this.M = this.K;
                }
                --this.M;
                if (this.M == -20) {
                    this.M = 0;
                    for (n = 0; n < 8; ++n) {
                        float f3 = this.G.nextFloat() - this.G.nextFloat();
                        f2 = this.G.nextFloat() - this.G.nextFloat();
                        f = this.G.nextFloat() - this.G.nextFloat();
                        this.d.a("bubble", this.h + f3, this.i + f2, this.j + f, this.k, this.l, this.m);
                    }
                    this.attackEntityFrom(null, 2, 0.0f);
                }
                this.J = 0;
            }
        } else {
            this.counter -= 7.5f;
            if (this.counter < 0.0f) {
                this.counter = 0.0f;
            }
            this.M += 7;
            if (this.M > this.K) {
                this.M = this.K;
            }
        }
        if (this.poison > 0) {
            if (this.poison % 20 == 0 && this.W > 1 && !this.d.multiplayerWorld) {
                this.attackEntityFrom(null, 1, 0.0f);
            }
            this.d.a("spell", this.h + (this.G.nextFloat() - 0.5f) * this.w, this.i + this.G.nextFloat() * this.x - this.v, this.j + (this.G.nextFloat() - 0.5f) * this.w, 0.0f, 0.0f, 0.0f);
            --this.poison;
        }
        if (this.l() && this.d.theme == 4) {
            this.poison = 100;
        }
        for (n = -5; n < 6; ++n) {
            block10: for (int i = -5; i < 6; ++i) {
                int n2 = this.d.a((int)this.h, (int)this.i, (int)this.j + i);
                int n3 = this.d.a((int)this.h + n, (int)this.i, (int)this.j);
                if (n2 == Block.fan.at) {
                    switch (this.d.e((int)this.h, (int)this.i, (int)this.j + i)) {
                        case 6: {
                            if (i <= 0) break;
                            this.m = (float)((double)this.m - 0.002);
                            break;
                        }
                        case 7: {
                            if (i >= 0) break;
                            this.m = (float)((double)this.m + 0.002);
                        }
                    }
                }
                if (n3 != Block.fan.at) continue;
                switch (this.d.e((int)this.h + n, (int)this.i, (int)this.j)) {
                    case 8: {
                        if (n <= 0) continue block10;
                        this.k = (float)((double)this.k - 0.002);
                        continue block10;
                    }
                    case 9: {
                        if (n >= 0) continue block10;
                        this.k = (float)((double)this.k + 0.002);
                    }
                }
            }
        }
        this.ad = this.ae;
        if (this.ac > 0) {
            --this.ac;
        }
        if (this.Y > 0) {
            --this.Y;
        }
        if (this.L > 0) {
            --this.L;
        }
        if (this.stunTimer > 0) {
            --this.stunTimer;
        }
        if (this.W <= 0) {
            ++this.ab;
            if (this.ab > 20) {
                this.k();
                if (!(this instanceof EntityPlayer)) {
                    for (n = 0; n < 20; ++n) {
                        float f4 = this.G.nextFloat() * 0.02f;
                        float f5 = this.G.nextFloat() * 0.02f;
                        float f6 = this.G.nextFloat() * 0.02f;
                        this.d.a("puff", this.h + this.G.nextFloat() * this.w * 2.0f - this.w, this.i + this.G.nextFloat() * this.x, this.j + this.G.nextFloat() * this.w * 2.0f - this.w, f4, f5, f6);
                    }
                }
            }
        }
        this.attackEntityDuringBloodRain();
        this.attackEntityDuringPoisonRain();
        this.U = this.T;
        this.p = this.n;
        this.q = this.o;
        this.f();
        float f7 = this.h - this.e;
        float f8 = this.j - this.g;
        f2 = MathHelper.c(f7 * f7 + f8 * f8);
        f = this.T;
        float f9 = 0.0f;
        float f10 = 0.0f;
        if (f2 > 0.05f) {
            f10 = 1.0f;
            f9 = f2 * 3.0f;
            f = (float)Math.atan2(f8, f7) * 180.0f / (float)Math.PI - 90.0f;
        }
        if (!this.s) {
            f10 = 0.0f;
        }
        this.a += (f10 - this.a) * 0.3f;
        for (f7 = f - this.T; f7 < -180.0f; f7 += 360.0f) {
        }
        while (f7 >= 180.0f) {
            f7 -= 360.0f;
        }
        this.T += f7 * 0.1f;
        for (f7 = this.n - this.T; f7 < -180.0f; f7 += 360.0f) {
        }
        while (f7 >= 180.0f) {
            f7 -= 360.0f;
        }
        boolean bl2 = bl = f7 < -90.0f || f7 >= 90.0f;
        if (f7 < -75.0f) {
            f7 = -75.0f;
        }
        if (f7 >= 75.0f) {
            f7 = 75.0f;
        }
        this.T = this.n - f7;
        this.T += f7 * 0.1f;
        if (bl) {
            f9 = -f9;
        }
        while (this.n - this.p < -180.0f) {
            this.p -= 360.0f;
        }
        while (this.n - this.p >= 180.0f) {
            this.p += 360.0f;
        }
        while (this.T - this.U < -180.0f) {
            this.U -= 360.0f;
        }
        while (this.T - this.U >= 180.0f) {
            this.U += 360.0f;
        }
        while (this.o - this.q < -180.0f) {
            this.q -= 360.0f;
        }
        while (this.o - this.q >= 180.0f) {
            this.q += 360.0f;
        }
    }

    public boolean canEntityBeSeen(C_b c_b) {
        return this.d.a(new C_a(this.h, this.i + this.n(), this.j), new C_a(c_b.h, c_b.i + c_b.n(), c_b.j)) == null;
    }

    public void attackEntityDuringBloodRain() {
        if (this.d.getRaining() && this.d.theme == 1 && this.d.l((int)this.h, (int)this.i, (int)this.j)) {
            this.attackEntityFrom(null, 1, 0.0f);
        }
    }

    public void attackEntityDuringPoisonRain() {
        if (this.d.getRaining() && this.d.theme == 4 && this.d.l((int)this.h, (int)this.i, (int)this.j)) {
            this.poison = 100;
        }
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    @Override
    public final void a(float f, float f2) {
        super.a(f, f2);
    }

    public void b(int n) {
        if (this.W > 0) {
            this.W += n;
            if (this.W > 20) {
                this.W = 20;
            }
            this.L = this.S / 2;
        }
    }

    public final void addHealth(int n) {
        if (this.W >= 20) {
            this.W += n;
            if (this.W > 40) {
                this.W = 40;
            }
            this.L = this.S / 2;
        }
    }

    public float getSwingProgress(float f) {
        float f2 = this.swingProgress - this.prevSwingProgress;
        if (f2 < 0.0f) {
            f2 += 1.0f;
        }
        return this.prevSwingProgress + f2 * f;
    }

    @Override
    public boolean attackEntityFrom(C_b c_b, int n, float f) {
        if (this.d.multiplayerWorld) {
            return false;
        }
        this.ai = 0;
        if (this.W <= 0) {
            return false;
        }
        this.ag = 1.5f;
        boolean bl = true;
        if ((float)this.L > (float)this.S / 2.0f) {
            if (n <= this.damageTaken) {
                return false;
            }
            this.W -= n - this.damageTaken;
            this.damageTaken = n;
            bl = false;
        } else {
            this.damageTaken = n;
            this.X = this.W;
            this.L = this.S;
            this.W -= n;
            this.Z = 10;
            this.Y = 10;
        }
        this.aa = 0.0f;
        if (c_b != null) {
            float f2 = c_b.h - this.h;
            float f3 = c_b.j - this.j;
            this.aa = (float)(Math.atan2(f3, f2) * 180.0 / 3.1415927410125732) - this.n;
            float f4 = MathHelper.c(f2 * f2 + f3 * f3);
            this.k /= 2.0f;
            this.l /= 2.0f;
            this.m /= 2.0f;
            this.k -= f2 / f4 * f;
            this.l += 0.4f;
            this.m -= f3 / f4 * f;
            if (this.l > 0.4f) {
                this.l = 0.4f;
            }
        } else {
            this.aa = (int)(Math.random() * 2.0) * 180;
        }
        if (this.isSitting) {
            this.isSitting = false;
        }
        if (this.isLaying) {
            this.isLaying = false;
        }
        if (bl && this.W <= 0) {
            this.d.a(this, this.i(), this.getSoundVolume(), (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
            this.d(c_b);
        } else if (bl) {
            this.d.a(this, this.h(), this.getSoundVolume(), (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
        }
        return true;
    }

    protected String g() {
        return null;
    }

    protected String h() {
        return "random.hurt";
    }

    protected String i() {
        return "random.hurt";
    }

    public void d(C_b c_b) {
        if (!this.d.multiplayerWorld) {
            this.dropFewItems(c_b);
        }
        if (this.c() > 0 && c_b != null) {
            c_b.awardKillScore(this, this.c());
        }
        if (this.statId() >= 0 && c_b != null && c_b instanceof EntityPlayer) {
            ((EntityPlayer)c_b).addStat(StatList.objectKillStats[this.statId()], 1);
            int n = 0;
            for (int i = 0; i < StatList.entities.length; ++i) {
                if (net.minecraft.client.d.getMinecraft().statFileWriter.getStatCount(StatList.objectKillStats[i]) < 1) continue;
                ++n;
            }
            if (n >= StatList.entities.length - 1) {
                ((EntityPlayer)c_b).triggerAchievement(AchievementList.slayer);
            }
        }
    }

    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n2;
            }
            for (int i = 0; i < n2; ++i) {
                this.a(n, 1);
            }
        }
    }

    protected int itemDropped() {
        return 0;
    }

    public int c() {
        return 0;
    }

    public int statId() {
        return -1;
    }

    @Override
    protected void b(float f) {
        int n = (int)Math.ceil(f - 3.0f);
        if (n > 0 && this.d.type != 8) {
            if (this.d.a((int)this.h, (int)(this.i - 0.2f - this.v), (int)this.j) == Block.stalactite.at) {
                this.attackEntityFrom(null, 100, 0.0f);
            } else {
                this.attackEntityFrom(null, n, 0.0f);
                n = this.d.a((int)this.h, (int)(this.i - 0.2f - this.v), (int)this.j);
                if (n > 0 && !this.d.multiplayerWorld) {
                    C_n c_n = Block.c[n].getStepSound(this.d.e((int)this.h, (int)(this.i - 0.2f - this.v), (int)this.j));
                    this.d.playSoundAtBlock(this.h, this.i, this.j, c_n.b(), c_n.a * 0.5f, c_n.b * 0.75f);
                    if (this.d.mc.w.particleCount == 0) {
                        this.d.mc.g.a((int)this.h, (int)(this.i - 0.2f - this.v), (int)this.j);
                    }
                }
            }
        }
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("Health", (short)this.W);
        nBTTagCompound.a("HurtTime", (short)this.Y);
        nBTTagCompound.a("DeathTime", (short)this.ab);
        nBTTagCompound.a("AttackTime", (short)this.ac);
        nBTTagCompound.a("StunTime", (short)this.stunTimer);
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        this.W = nBTTagCompound.c("Health");
        if (!nBTTagCompound.a("Health")) {
            this.W = 10;
        }
        this.Y = nBTTagCompound.c("HurtTime");
        this.ab = nBTTagCompound.c("DeathTime");
        this.ac = nBTTagCompound.c("AttackTime");
        this.stunTimer = nBTTagCompound.c("StunTime");
    }

    @Override
    public String a() {
        return "Mob";
    }

    @Override
    public final boolean r() {
        return !this.u && this.W > 0;
    }

    @Override
    public void setPositionAndRotation2(float f, float f2, float f3, float f4, float f5, int n) {
        this.v = 0.0f;
        this.newPosX = f;
        this.newPosY = f2;
        this.newPosZ = f3;
        this.newRotationYaw = f4;
        this.newRotationPitch = f5;
        this.newPosRotationIncrements = n;
    }

    public void f() {
        float f;
        C_b c_b;
        int n;
        float f2;
        if (this.newPosRotationIncrements > 0) {
            double d2;
            float f3 = this.h + (this.newPosX - this.h) / (float)this.newPosRotationIncrements;
            f2 = this.i + (this.newPosY - this.i) / (float)this.newPosRotationIncrements;
            float f4 = this.j + (this.newPosZ - this.j) / (float)this.newPosRotationIncrements;
            for (d2 = (double)(this.newRotationYaw - this.n); d2 < -180.0; d2 += 360.0) {
            }
            while (d2 >= 180.0) {
                d2 -= 360.0;
            }
            this.n = (float)((double)this.n + d2 / (double)this.newPosRotationIncrements);
            this.o = (float)((double)this.o + ((double)this.newRotationPitch - (double)this.o) / (double)this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.b(f3, f2, f4);
            this.setRotation(this.n, this.o);
            ArrayList arrayList = (ArrayList)this.d.getCollidingBoundingBoxes(this, this.r.getInsetBoundingBox(0.03125f, 0.0f, 0.03125f));
            if (arrayList.size() > 0) {
                double d3 = 0.0;
                for (n = 0; n < arrayList.size(); ++n) {
                    net.minecraft.a.d.C_b c_b2 = (net.minecraft.a.d.C_b)arrayList.get(n);
                    if (!((double)c_b2.e > d3)) continue;
                    d3 = c_b2.e;
                }
                f2 = (float)((double)f2 + (d3 - (double)this.r.b));
                this.b(f3, f2, f4);
            }
        }
        ++this.ai;
        if (!this.d.multiplayerWorld && this.ai > 600 && this.G.nextInt(800) == 0 && (c_b = this.d.i()) != null) {
            f2 = c_b.h - this.h;
            float f5 = c_b.i - this.i;
            float f6 = c_b.j - this.j;
            if (f2 * f2 + f5 * f5 + f6 * f6 < 1024.0f) {
                this.ai = 0;
            } else if (this.canDespawn()) {
                this.k();
            }
        }
        if (this.W <= 0 || this.d.AIDisabled && !(this instanceof EntityPlayer)) {
            this.isJumping = false;
            this.aj = 0.0f;
            this.ak = 0.0f;
            this.Q = 0.0f;
        } else if (this instanceof EntityPlayer || !this.d.AIDisabled) {
            this.e();
        }
        boolean bl = this.l();
        boolean bl2 = this.o();
        n = this.isInRope();
        if (this.isJumping) {
            if (bl || bl2 || n != 0) {
                this.l += 0.04f;
            } else if (this.s) {
                this.l = this.isInCloud() ? 0.82f : 0.42f;
            }
        }
        this.aj *= 0.98f;
        this.ak *= 0.98f;
        this.Q *= 0.9f;
        this.moveEntityWithHeading(this.aj, this.ak);
        float f7 = this.ak;
        f2 = this.aj;
        if (!this.d.multiplayerWorld && (this.d.a(this.h, this.i + this.n(), this.j) || this.d.isQuicksand(this.h, this.i + this.n(), this.j) || this.i <= -100.0f)) {
            this.attackEntityFrom(null, 1, 0.0f);
        }
        this.af = this.ag;
        float f8 = this.h - this.e;
        f2 = this.j - this.g;
        f2 = MathHelper.c(f8 * f8 + f2 * f2) * 4.0f;
        if (f > 1.0f) {
            f2 = 1.0f;
        }
        this.ag += (f2 - this.ag) * 0.4f;
        this.ah += this.ag;
        List<C_b> list = this.d.a(this, this.r.b(0.2f, 0.0f, 0.2f));
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                C_b c_b3 = list.get(i);
                if (!c_b3.p()) continue;
                c_b3.c(this);
            }
        }
    }

    protected void moveEntityWithHeading(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        if (this.l() && !this.isFlying) {
            float f5 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            if (this.m() && this.isSneaking == 2) {
                this.k *= 0.91f;
                this.l *= 0.91f;
                this.m *= 0.91f;
            } else {
                this.k *= 0.8f;
                this.l *= 0.8f;
                this.m *= 0.8f;
            }
            this.l = (float)((double)this.l - 0.02);
            if (this.t && this.c(this.k, this.l + 0.6f - this.i + f5, this.m)) {
                this.l = 0.3f;
            }
        } else if (this.o() && !this.isFlying) {
            float f6 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.5f;
            this.l *= 0.5f;
            this.m *= 0.5f;
            this.l = (float)((double)this.l - 0.02);
            if (this.t && this.c(this.k, this.l + 0.6f - this.i + f6, this.m)) {
                this.l = 0.3f;
            }
        } else if (!(this.isSneaking <= 0 || this.isInWater() || this.isInCobweb() || this.isInQuicksand() || this.isInCloud() || this.isFlying)) {
            this.moveRelative(f3, f4, this.s ? 0.1f : 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.4f;
            this.l *= 0.98f;
            this.m *= 0.4f;
            this.l = (float)((double)this.l - 0.08);
            if (this.s) {
                this.k *= 0.3f;
                this.m *= 0.3f;
            }
        } else if ((this.isOnLadder() || this.isOnVine()) && !this.isFlying) {
            this.moveRelative(f3, f4, this.s ? 0.1f : 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.4f;
            this.l *= 0.4f;
            this.m *= 0.4f;
            this.l = (float)((double)this.l - 0.08);
            if (this.t) {
                this.l = 0.15f;
            }
            this.b = 0.0f;
        } else if (this.isInRope() && !this.isFlying) {
            float f7 = this.i;
            this.moveRelative(f3, f4, this.s ? 0.1f : 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.4f;
            this.l *= 0.4f;
            this.m *= 0.4f;
            this.l = (float)((double)this.l - 0.08);
            this.b = 0.0f;
            if (this.isJumping) {
                this.l = 0.15f;
            }
        } else if (this.isInCobweb() && !this.isFlying) {
            float f8 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.2f;
            this.l *= 0.2f;
            this.m *= 0.2f;
            this.l = (float)((double)this.l - 0.02);
            this.b = 0.0f;
        } else if (this.isInIce() && !this.isFlying) {
            float f9 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.93f;
            this.l *= 0.98f;
            this.m *= 0.93f;
            this.l = (float)((double)this.l - 0.08);
        } else if (this.isInQuicksand() && !this.isFlying) {
            float f10 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.2f;
            this.l *= 0.2f;
            this.m *= 0.2f;
            this.l = (float)((double)this.l - 0.02);
        } else if (this.isInSlime() && !this.isFlying) {
            float f11 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.93f;
            this.l *= 0.98f;
            this.m *= 0.93f;
            this.l += 0.5f;
            this.b = 0.0f;
        } else if (this.isInCloud() && !this.isFlying) {
            float f12 = this.i;
            this.moveRelative(f3, f4, 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.8f;
            this.l *= 0.5f;
            this.m *= 0.8f;
            this.l = (float)((double)this.l - 0.04);
            this.b = 0.0f;
        } else if (this.isFlying) {
            float f13 = this.i;
            this.e(f3, f4, 0.0f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.8f;
            this.l *= 0.8f;
            this.m *= 0.8f;
            this.l = 0.0f;
        } else {
            this.moveRelative(f3, f4, this.s ? 0.1f : 0.02f);
            this.d(this.k, this.l, this.m);
            this.k *= 0.91f;
            this.l *= 0.98f;
            this.m *= 0.91f;
            this.l = this.d.type == 8 ? (float)((double)this.l - 0.03) : (float)((double)this.l - 0.08);
            if (this.s) {
                this.k *= 0.6f;
                this.m *= 0.6f;
            }
        }
    }

    protected void e() {
        if (this.G.nextFloat() < 0.07f) {
            this.aj = (this.G.nextFloat() - 0.5f) * this.am;
            this.ak = this.G.nextFloat() * this.am;
        }
        boolean bl = this.isJumping = this.G.nextFloat() < 0.01f;
        if (this.G.nextFloat() < 0.04f) {
            this.Q = (this.G.nextFloat() - 0.5f) * 60.0f;
        }
        this.n += this.Q;
        this.o = 0.0f;
        boolean bl2 = this.l();
        boolean bl3 = this.o();
        if (bl2 || bl3) {
            this.isJumping = this.G.nextFloat() < 0.8f;
        }
    }

    public boolean a(float f, float f2, float f3) {
        this.b(f, f2 + this.x / 2.0f, f3);
        return this.d.d(this.r) && this.d.getCollidingBoundingBoxes(this, this.r).size() == 0 && !this.d.b(this.r);
    }

    public int getItemIcon(ItemStack itemStack) {
        return itemStack.getIconIndex();
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 2) {
            this.ag = 1.5f;
            this.L = this.S;
            this.Z = 10;
            this.Y = 10;
            this.aa = 0.0f;
            this.d.a(this, this.h(), 1.0f, (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
            this.attackEntityFrom(null, 0, 0.0f);
        } else if (by == 3) {
            this.d.a(this, this.i(), 1.0f, (this.G.nextFloat() - this.G.nextFloat()) * 0.2f + 1.0f);
            this.W = 0;
            this.d((C_b)null);
        } else {
            super.handleHealthUpdate(by);
        }
    }
}

