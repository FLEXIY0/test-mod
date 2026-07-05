/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_n;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.c.C_f;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.d;
import net.minecraft.network.DataWatcher;
import util.MathHelper;

public abstract class Entity {
    private static int nextEntityID = 0;
    public int entityId = nextEntityID++;
    public Entity riddenByEntity;
    public Entity ridingEntity;
    public boolean c = false;
    public World d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public net.minecraft.a.d.C_b r;
    public boolean s = false;
    public boolean t = false;
    private boolean a = true;
    public boolean u = false;
    public float v = 0.0f;
    public float w = 0.6f;
    public float x = 1.8f;
    public float y = 0.0f;
    public float z = 0.0f;
    protected boolean A = true;
    public float b = 0.0f;
    private int O = 1;
    public float B;
    public float C;
    public float D;
    public float P = 0.0f;
    public float E = 0.0f;
    public boolean F = false;
    public Random G = new Random();
    public int H = 0;
    public int I = 1;
    public int J = 0;
    public int poison = 0;
    public int K = 300;
    protected boolean R = false;
    public int L = 0;
    public int M = 300;
    private boolean S = true;
    public String N;
    public String skinId = "";
    public int isSneaking;
    public boolean isFlying;
    public boolean isGliding;
    public boolean isSitting;
    public boolean isLaying;
    public boolean deflectProjectile = false;
    public boolean canGlow = false;
    private float entityRiderPitchDelta;
    private float entityRiderYawDelta;
    public DataWatcher dataWatcher = new DataWatcher();
    public int chunkCoordX;
    public int chunkCoordY;
    public int chunkCoordZ;
    public int serverPosX;
    public int serverPosY;
    public int serverPosZ;
    protected double renderDistanceWeight = 1.0;
    public int stunTimer = 0;
    public boolean isVisible;
    protected boolean isJumping;

    public Entity(World c_g) {
        this.d = c_g;
        this.b(0.0f, 0.0f, 0.0f);
        this.dataWatcher.addObject(0, (byte)0);
        this.entityInit();
    }

    protected abstract void entityInit();

    protected void j() {
        if (this.d != null) {
            float f = (float)this.d.i + 0.5f;
            float f2 = (float)this.d.k + 0.5f;
            for (float f3 = (float)this.d.j; f3 > 0.0f; f3 += 1.0f) {
                this.b(f, f3, f2);
                if (this.d.getCollidingBoundingBoxes(this, this.r).size() == 0) break;
            }
            this.m = 0.0f;
            this.l = 0.0f;
            this.k = 0.0f;
            this.n = this.d.l;
            this.o = 0.0f;
        }
    }

    public void k() {
        this.u = true;
    }

    protected void a(float f, float f2) {
        this.w = f;
        this.x = f2;
    }

    public final void b(float f, float f2, float f3) {
        this.h = f;
        this.i = f2;
        this.j = f3;
        float f4 = this.w / 2.0f;
        float f5 = this.x;
        this.r = new net.minecraft.a.d.C_b(f - f4, f2 - this.v + this.P, f3 - f4, f + f4, f2 - this.v + this.P + f5, f3 + f4);
    }

    public void setRotation(float f, float f2) {
        this.n = f % 360.0f;
        this.o = f2 % 360.0f;
    }

    public void b_() {
        int n;
        if (this.ridingEntity != null && this.ridingEntity.u) {
            this.ridingEntity = null;
            this.isSitting = false;
        }
        ++this.H;
        this.y = this.z;
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.q = this.o;
        this.p = this.n;
        if (this.l()) {
            if (!this.R && !this.S) {
                float f;
                float f2;
                float f3;
                float f4 = MathHelper.c(this.k * this.k * 0.2f + this.l * this.l + this.m * this.m * 0.2f) * 0.2f;
                if (f3 > 1.0f) {
                    f4 = 1.0f;
                }
                this.d.a(this, "random.splash", f4, 1.0f + (this.G.nextFloat() - this.G.nextFloat()) * 0.4f);
                f4 = (int)this.r.b;
                n = 0;
                while ((float)n < 1.0f + this.w * 20.0f) {
                    f2 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                    f = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                    this.d.a("bubble", this.h + f2, f4 + 1.0f, this.j + f, this.k, this.l - this.G.nextFloat() * 0.2f, this.m);
                    ++n;
                }
                n = 0;
                while ((float)n < 1.0f + this.w * 20.0f) {
                    f2 = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                    f = (this.G.nextFloat() * 2.0f - 1.0f) * this.w;
                    this.d.a("splash", this.h + f2, f4 + 1.0f, this.j + f, this.k, this.l, this.m);
                    ++n;
                }
            }
            this.b = 0.0f;
            this.R = true;
            this.J = 0;
        } else {
            this.R = false;
        }
        int n2 = MathHelper.a((double)this.r.a - 0.999);
        n = MathHelper.a((double)this.r.b - 0.999);
        int n3 = MathHelper.a((double)this.r.c - 0.999);
        int n4 = MathHelper.a((double)this.r.d + 0.999);
        int n5 = MathHelper.a((double)this.r.e + 0.999);
        int n6 = MathHelper.a((double)this.r.f + 0.999);
        for (int i = n2; i <= n4; ++i) {
            for (int j = n; j <= n5; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    int n7 = this.d.a(i, j, k);
                    if (n7 <= 0) continue;
                    Block.c[n7].onEntityCollidedWithBlock(this.d, i, j, k);
                }
            }
        }
        if (this.d.getRaining() && this.d.l((int)this.h, (int)this.i, (int)this.j)) {
            this.J = 0;
        }
        if (this.J > 0) {
            if (this.J % 20 == 0 && !this.d.multiplayerWorld) {
                this.attackEntityFrom(null, 1, 0.0f);
            }
            --this.J;
        }
        if (this.o()) {
            this.a(10);
        }
        if (this.isInMagma()) {
            this.a(1);
        }
        if (this.isInCactus()) {
            this.attackEntityFrom(null, 1, 0.0f);
        }
        if (this.h < -8.0f) {
            float f = -(this.h + 8.0f);
            this.k += f * 0.001f;
        }
        if (this.j < -8.0f) {
            float f = -(this.j + 8.0f);
            this.m += f * 0.001f;
        }
        if (this.h > (float)this.d.a + 8.0f) {
            float f = this.h - (float)this.d.a + 8.0f;
            this.k -= f * 0.001f;
        }
        if (this.j > (float)this.d.b + 8.0f) {
            float f = this.j - (float)this.d.b + 8.0f;
            this.m -= f * 0.001f;
        }
        if (!this.d.multiplayerWorld) {
            this.setEntityFlag(0, this.J > 0);
            this.setEntityFlag(2, this.ridingEntity != null);
        }
        this.S = false;
    }

    public final boolean c(float f, float f2, float f3) {
        float f4 = f3;
        f3 = f2;
        f2 = f;
        net.minecraft.a.d.C_b c_b = this.r;
        c_b = new net.minecraft.a.d.C_b(c_b.a + f4, c_b.b + f3, c_b.c + f4, c_b.d + f2, c_b.e + f3, c_b.f + f4);
        return this.d.getCollidingBoundingBoxes(this, c_b).size() > 0 ? false : !this.d.b(c_b);
    }

    public void d(float f, float f2, float f3) {
        if (this.F) {
            this.r.c(f, f2, f3);
            this.h = (this.r.a + this.r.d) / 2.0f;
            this.i = this.r.b + this.v - this.P;
            this.j = (this.r.c + this.r.f) / 2.0f;
        } else {
            int n;
            float f4;
            float f5;
            int n2;
            int n3;
            boolean bl;
            float f6 = this.h;
            float f7 = this.j;
            float f8 = f;
            float f9 = f2;
            float f10 = f3;
            net.minecraft.a.d.C_b c_b = this.r.a();
            boolean bl2 = bl = this.s && !this.isFlying && this.isSneaking == 1;
            if (bl) {
                float f11 = 0.05f;
                while (f != 0.0f && this.d.getCollidingBoundingBoxes(this, this.r.cloneMove(f, 0.0f, 0.0f)).size() == 0) {
                    f = f < f11 && f >= -f11 ? 0.0f : (f > 0.0f ? (f -= f11) : (f += f11));
                    f8 = f;
                }
                while (f3 != 0.0f && this.d.getCollidingBoundingBoxes(this, this.r.cloneMove(0.0f, 0.0f, f3)).size() == 0) {
                    f3 = f3 < f11 && f3 >= -f11 ? 0.0f : (f3 > 0.0f ? (f3 -= f11) : (f3 += f11));
                    f10 = f3;
                }
            }
            ArrayList arrayList = (ArrayList)this.d.getCollidingBoundingBoxes(this, this.r.a(f, f2, f3));
            for (n3 = 0; n3 < arrayList.size(); ++n3) {
                f2 = ((net.minecraft.a.d.C_b)arrayList.get(n3)).b(this.r, f2);
            }
            this.r.c(0.0f, f2, 0.0f);
            if (!this.a && f9 != f2) {
                f3 = 0.0f;
                f2 = 0.0f;
                f = 0.0f;
            }
            n3 = this.s || f9 != f2 && f9 < 0.0f ? 1 : 0;
            for (n2 = 0; n2 < arrayList.size(); ++n2) {
                f = ((net.minecraft.a.d.C_b)arrayList.get(n2)).a(this.r, f);
            }
            this.r.c(f, 0.0f, 0.0f);
            if (!this.a && f8 != f) {
                f3 = 0.0f;
                f2 = 0.0f;
                f = 0.0f;
            }
            for (n2 = 0; n2 < arrayList.size(); ++n2) {
                f3 = ((net.minecraft.a.d.C_b)arrayList.get(n2)).c(this.r, f3);
            }
            this.r.c(0.0f, 0.0f, f3);
            if (!this.a && f10 != f3) {
                f3 = 0.0f;
                f2 = 0.0f;
                f = 0.0f;
            }
            if (this.E > 0.0f && n3 != 0 && this.P < 0.05f && (f8 != f || f10 != f3)) {
                f5 = f;
                f4 = f2;
                float f12 = f3;
                f = f8;
                f2 = this.E;
                f3 = f10;
                net.minecraft.a.d.C_b c_b2 = this.r.a();
                this.r = c_b.a();
                arrayList = (ArrayList)this.d.getCollidingBoundingBoxes(this, this.r.a(f8, f2, f10));
                for (n = 0; n < arrayList.size(); ++n) {
                    f2 = ((net.minecraft.a.d.C_b)arrayList.get(n)).b(this.r, f2);
                }
                this.r.c(0.0f, f2, 0.0f);
                if (!this.a && f9 != f2) {
                    f3 = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                }
                for (n = 0; n < arrayList.size(); ++n) {
                    f = ((net.minecraft.a.d.C_b)arrayList.get(n)).a(this.r, f);
                }
                this.r.c(f, 0.0f, 0.0f);
                if (!this.a && f8 != f) {
                    f3 = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                }
                for (n = 0; n < arrayList.size(); ++n) {
                    f3 = ((net.minecraft.a.d.C_b)arrayList.get(n)).c(this.r, f3);
                }
                this.r.c(0.0f, 0.0f, f3);
                if (!this.a && f10 != f3) {
                    f3 = 0.0f;
                    f2 = 0.0f;
                    f = 0.0f;
                }
                if (f5 * f5 + f12 * f12 >= f * f + f3 * f3) {
                    f = f5;
                    f2 = f4;
                    f3 = f12;
                    this.r = c_b2.a();
                } else {
                    this.P = (float)((double)this.P + 0.5);
                }
            }
            if (!this.d.multiplayerWorld || this instanceof EntityPlayer || !(this instanceof EntityLiving)) {
                this.h = (this.r.a + this.r.d) / 2.0f;
                this.i = this.r.b + this.v - this.P;
                this.j = (this.r.c + this.r.f) / 2.0f;
            }
            this.t = f8 != f || f10 != f3;
            boolean bl3 = this.s = f9 != f2 && f9 < 0.0f;
            if (!(this.isOnLadder() || this.isInRope() || this.isInCobweb() || this.isOnVine() || this.isInSlime() || this.isInCloud())) {
                if (this.s) {
                    if (this.b > 0.0f) {
                        this.b(this.b);
                        this.b = 0.0f;
                    }
                } else if (f2 < 0.0f) {
                    this.b -= f2;
                }
            }
            if (f8 != f) {
                this.k = 0.0f;
            }
            if (f9 != f2) {
                this.l = 0.0f;
            }
            if (f10 != f3) {
                this.m = 0.0f;
            }
            f5 = this.h - f6;
            f4 = this.j - f7;
            if (!this.isFlying && !this.isGliding) {
                this.z = (float)((double)this.z + (double)MathHelper.c(f5 * f5 + f4 * f4) * 0.6);
            }
            if (this.A) {
                int n4 = (int)this.h;
                int n5 = (int)(this.i - 0.2f - this.v);
                n = (int)this.j;
                int n6 = this.d.a(n4, n5, n);
                if (this.d.a(n4, n5 - 1, n) == Block.fence.at || this.d.a(n4, n5 - 1, n) == Block.wall.at) {
                    n6 = this.d.a(n4, n5 - 1, n);
                }
                if (this.z > (float)this.O && n6 > 0) {
                    ++this.O;
                    C_n c_n = Block.c[n6].getStepSound(this.d.e(n4, n5, n));
                    if (this.d.a(n4, n5 + 1, n) == Block.snowLayer.at) {
                        c_n = Block.soundSnowFootstep;
                    }
                    if (!Block.c[n6].getMaterial(this.d.e(n4, n5, n)).d()) {
                        this.d.a(this, c_n.b(), c_n.a * 0.15f, c_n.b);
                    }
                    if (this.isJumping) {
                        Block.c[n6].g(this.d, n4, n5, n);
                    }
                }
            }
            this.P *= 0.4f;
            boolean bl4 = this.l();
            if (this.d.isBoundingBoxHellfire(this.r)) {
                this.convertHellfireItem();
                if (!bl4) {
                    ++this.J;
                    if (this.J == 0) {
                        this.J = 300;
                    }
                }
            } else if (this.isBurning()) {
                this.a(1);
                if (!bl4) {
                    ++this.J;
                    if (this.J == 0) {
                        this.J = 300;
                    }
                }
            } else if (this.J <= 0) {
                this.J = -this.I;
            }
            if (bl4 && this.J > 0) {
                this.d.a(this, "random.fizz", 0.7f, 1.6f + (this.G.nextFloat() - this.G.nextFloat()) * 0.4f);
                this.J = -this.I;
            }
        }
    }

    protected void a(int n) {
        this.attackEntityFrom(null, n, 0.0f);
    }

    protected void convertHellfireItem() {
        this.attackEntityFrom(null, 1, 0.0f);
    }

    public void onStruckByLightning(C_f c_f) {
        this.a(5);
        ++this.J;
        if (this.J == 0) {
            this.J = 300;
        }
    }

    public boolean isBurning() {
        return this.d.c(this.r);
    }

    protected void b(float f) {
    }

    public boolean l() {
        return this.d.a(this.r.b(0.0f, -0.4f, 0.0f), Material.f);
    }

    public boolean isInWater() {
        return this.d.a(this.r.b(0.0f, 0.0f, 0.0f), Material.f);
    }

    public final boolean isInRope() {
        return this.d.a(this.r.b(0.0f, -0.6f, 0.0f), Material.rope);
    }

    public boolean isInCobweb() {
        return this.d.a(this.r.b(0.0f, -0.6f, 0.0f), Material.web);
    }

    public boolean isInCactus() {
        return this.d.a(this.r.b(0.1f, 0.1f, 0.1f), Material.cactus);
    }

    public boolean isInMagma() {
        return this.d.a(this.r.b(0.0f, 0.1f, 0.0f), Material.magma);
    }

    public boolean isInSlime() {
        return this.d.a(this.r.b(-0.1f, 0.1f, -0.1f), Material.slime);
    }

    public boolean isInCloud() {
        return this.d.a(this.r.b(-0.1f, 0.3f, -0.1f), Material.cloud);
    }

    public boolean isInIce() {
        return this.d.a(this.r.b(-0.1f, 0.1f, -0.1f), Material.ice);
    }

    public boolean isInQuicksand() {
        return this.d.a(this.r.b(-0.1f, 0.1f, -0.1f), Material.quicksand);
    }

    public boolean isInMagmaAirPocket() {
        return this.d.a(this.r.b(0.0f, 2.0f, 0.0f), Material.magma);
    }

    public boolean isInVacuum() {
        return this.d.a(this.r.b(0.1f, 0.1f, 0.1f), Material.vacuum);
    }

    public final boolean canSneakHere() {
        if (this.isSneaking == 2) {
            boolean bl = true;
            for (float f = -0.3f; f <= 0.3f; f += 0.3f) {
                for (float f2 = -0.3f; f2 <= 0.3f; f2 += 0.3f) {
                    if (!this.d.a(this.h + f, this.i + 1.0f, this.j + f2)) continue;
                    bl = false;
                }
            }
            return bl;
        }
        return true;
    }

    public boolean setSneakState(int n) {
        if (this.isSneaking == n) {
            return false;
        }
        if (this.d.gamemode != 2 && (this.s || this.R) && this.canSneakHere() && this.isSneaking != 1 && !this.isSitting && !this.isLaying && !this.d.multiplayerWorld) {
            this.isSneaking = n;
            switch (this.isSneaking) {
                case 1: {
                    this.v = 1.42f;
                    this.a(0.6f, 1.8f);
                    return true;
                }
                case 2: {
                    this.v = 0.56f;
                    this.a(0.6f, 0.9f);
                    this.b(this.h, this.i, this.j);
                    return true;
                }
            }
            this.v = 1.62f;
            this.a(0.6f, 1.8f);
            this.b(this.h, this.i + 1.3f, this.j);
            return true;
        }
        return false;
    }

    public boolean toggleSneak(int n) {
        if (this.isSneaking == n) {
            return false;
        }
        if (!(net.minecraft.client.d.getMinecraft().w.sneakMode || this.isSneaking == 2 || this.d.gamemode == 2 || !this.s || this.isInWater() || this.isSitting || this.isLaying || this.isFlying)) {
            this.isSneaking = n;
            switch (this.isSneaking) {
                case 1: {
                    this.v = 1.42f;
                    return true;
                }
            }
            this.v = 1.62f;
            return true;
        }
        return false;
    }

    public final boolean m() {
        if (this.d == null) {
            return false;
        }
        int n = this.d.a((int)this.h, (int)(this.i + this.n()), (int)this.j);
        return n != 0 ? Block.c[n].getMaterial(this.d.e((int)this.h, (int)(this.i + this.n()), (int)this.j)) == Material.f : false;
    }

    public boolean isOnLadder() {
        int n;
        int n2;
        int n3 = MathHelper.a((double)this.h);
        return this.d.a(n3, n2 = MathHelper.a((double)this.r.b), n = MathHelper.a((double)this.j)) == Block.ladder.at;
    }

    public boolean isOnVine() {
        int n;
        int n2;
        int n3 = MathHelper.a((double)this.h);
        return this.d.a(n3, n2 = MathHelper.a((double)this.r.b), n = MathHelper.a((double)this.j)) == Block.vine.at;
    }

    public void mountEntity(Entity c_b) {
        this.entityRiderPitchDelta = 0.0f;
        this.entityRiderYawDelta = 0.0f;
        if (c_b == null) {
            if (this.ridingEntity != null) {
                this.setLocationAndAngles(this.ridingEntity.h, this.ridingEntity.r.b + this.ridingEntity.x, this.ridingEntity.j, this.n, this.o);
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
            this.isSitting = false;
        } else if (this.ridingEntity == c_b) {
            this.ridingEntity.riddenByEntity = null;
            this.ridingEntity = null;
            this.isSitting = false;
            this.setLocationAndAngles(c_b.h, c_b.r.b + c_b.x, c_b.j, this.n, this.o);
        } else {
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            if (c_b.riddenByEntity != null) {
                c_b.riddenByEntity.ridingEntity = null;
            }
            this.ridingEntity = c_b;
            c_b.riddenByEntity = this;
            this.isSitting = true;
        }
    }

    public void updateRidden() {
        if (this.ridingEntity.u) {
            this.ridingEntity = null;
            this.isSitting = false;
            this.b(this.h, this.i + 0.5f, this.j);
        } else {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.b_();
            if (this.ridingEntity != null) {
                this.ridingEntity.updateRiderPosition();
                this.entityRiderYawDelta = (float)((double)this.entityRiderYawDelta + (double)(this.ridingEntity.n - this.ridingEntity.p));
                this.entityRiderPitchDelta = (float)((double)this.entityRiderPitchDelta + (double)(this.ridingEntity.o - this.ridingEntity.q));
                while ((double)this.entityRiderYawDelta >= 180.0) {
                    this.entityRiderYawDelta = (float)((double)this.entityRiderYawDelta - 360.0);
                }
                while ((double)this.entityRiderYawDelta < -180.0) {
                    this.entityRiderYawDelta = (float)((double)this.entityRiderYawDelta + 360.0);
                }
                while ((double)this.entityRiderPitchDelta >= 180.0) {
                    this.entityRiderPitchDelta = (float)((double)this.entityRiderPitchDelta - 360.0);
                }
                while ((double)this.entityRiderPitchDelta < -180.0) {
                    this.entityRiderPitchDelta = (float)((double)this.entityRiderPitchDelta + 360.0);
                }
                double d2 = (double)this.entityRiderYawDelta * 0.5;
                double d3 = (double)this.entityRiderPitchDelta * 0.5;
                float f = 10.0f;
                if (d2 > (double)f) {
                    d2 = f;
                }
                if (d2 < (double)(-f)) {
                    d2 = -f;
                }
                if (d3 > (double)f) {
                    d3 = f;
                }
                if (d3 < (double)(-f)) {
                    d3 = -f;
                }
                this.entityRiderYawDelta = (float)((double)this.entityRiderYawDelta - d2);
                this.entityRiderPitchDelta = (float)((double)this.entityRiderPitchDelta - d3);
                this.n = (float)((double)this.n + d2);
                this.o = (float)((double)this.o + d3);
            }
        }
    }

    public void updateRiderPosition() {
        this.riddenByEntity.b(this.h, this.i + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.j);
    }

    public float getYOffset() {
        return this.v;
    }

    public float getMountedYOffset() {
        return this.x * 0.75f;
    }

    public float n() {
        return 0.0f;
    }

    public final boolean o() {
        return this.d.a(this.r.b(0.0f, -0.4f, 0.0f), Material.g);
    }

    public final void moveRelative(float f, float f2, float f3) {
        float f4;
        float f5 = MathHelper.c(f * f + f2 * f2);
        if (f4 >= 0.01f) {
            if (f5 < 1.0f) {
                f5 = 1.0f;
            }
            f5 = f3 / f5;
            f *= f5;
            f2 *= f5;
            f3 = MathHelper.a(this.n * (float)Math.PI / 180.0f);
            f5 = MathHelper.b(this.n * (float)Math.PI / 180.0f);
            this.k += f * f5 - f2 * f3;
            this.m += f2 * f5 + f * f3;
        }
    }

    public void e(float f, float f2, float f3) {
        if (this.isFlying) {
            float f4 = MathHelper.c(f * f + f2 * f2);
            if (f4 < 0.1f) {
                return;
            }
            float f5 = MathHelper.a(this.n * (float)Math.PI / 180.0f);
            float f6 = MathHelper.b(this.n * (float)Math.PI / 180.0f);
            this.k += (f *= 0.125f) * f6 - (f2 *= 0.125f) * f5;
            this.m += f2 * f6 + f * f5;
        }
    }

    public float a(float f) {
        int n = (int)this.h;
        int n2 = (int)(this.i + this.v / 2.0f);
        int n3 = (int)this.j;
        return this.d != null ? this.d.c(n, n2, n3) : 1.0f;
    }

    public final void a(World c_g) {
        this.d = c_g;
    }

    public final void b(float f, float f2, float f3, float f4, float f5) {
        this.e = this.h = f;
        this.f = this.i = f2 + this.v;
        this.g = this.j = f3;
        this.n = f4;
        this.o = f5;
        this.b(this.h, this.i, this.j);
    }

    public float getDistanceSq(float f, float f2, float f3) {
        float f4 = this.h - f;
        float f5 = this.i - f2;
        float f6 = this.j - f3;
        return f4 * f4 + f5 * f5 + f6 * f6;
    }

    public final float b(Entity c_b) {
        float f = this.h - c_b.h;
        float f2 = this.i - c_b.i;
        float f3 = this.j - c_b.j;
        return f * f + f2 * f2 + f3 * f3;
    }

    public void a(EntityPlayer entityPlayer) {
    }

    public void c(Entity c_b) {
        float f;
        float f2 = c_b.h - this.h;
        float f3 = c_b.j - this.j;
        float f4 = f2 * f2 + f3 * f3;
        if (f >= 0.01f) {
            f4 = MathHelper.c(f4);
            f2 /= f4;
            f3 /= f4;
            f2 /= f4;
            f3 /= f4;
            this.a(-(f2 *= 0.05f), 0.0f, -(f3 *= 0.05f));
            c_b.a(f2, 0.0f, f3);
        }
    }

    public void a(float f, float f2, float f3) {
        this.k += f;
        this.l += f2;
        this.m += f3;
    }

    public boolean attackEntityFrom(Entity c_b, int n, float f) {
        return false;
    }

    public void awardKillScore(Entity c_b, int n) {
    }

    public boolean d() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public String q() {
        return null;
    }

    public final void c(NBTTagCompound nBTTagCompound) {
        String string = this.a();
        if (string != null) {
            nBTTagCompound.a("id", string);
            nBTTagCompound.a("Pos", Entity.a(this.h, this.i, this.j));
            nBTTagCompound.a("Motion", Entity.a(this.k, this.l, this.m));
            nBTTagCompound.a("Rotation", Entity.a(this.n, this.o));
            nBTTagCompound.a("FallDistance", this.b);
            nBTTagCompound.a("Fire", (short)this.J);
            nBTTagCompound.a("Poison", (short)this.poison);
            nBTTagCompound.a("Air", (short)this.M);
            this.a(nBTTagCompound);
        }
    }

    public final void d(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Pos");
        NBTTagList nBTTagList2 = nBTTagCompound.j("Motion");
        NBTTagList nBTTagList3 = nBTTagCompound.j("Rotation");
        this.h = ((com.a.a.C_b)nBTTagList.a((int)0)).a;
        this.i = ((com.a.a.C_b)nBTTagList.a((int)1)).a - this.v;
        this.j = ((com.a.a.C_b)nBTTagList.a((int)2)).a;
        this.k = ((com.a.a.C_b)nBTTagList2.a((int)0)).a;
        this.l = ((com.a.a.C_b)nBTTagList2.a((int)1)).a;
        this.m = ((com.a.a.C_b)nBTTagList2.a((int)2)).a;
        this.n = ((com.a.a.C_b)nBTTagList3.a((int)0)).a;
        this.o = ((com.a.a.C_b)nBTTagList3.a((int)1)).a;
        this.b = nBTTagCompound.f("FallDistance");
        this.J = nBTTagCompound.c("Fire");
        this.poison = nBTTagCompound.c("Poison");
        this.M = nBTTagCompound.c("Air");
        this.b(this.h, this.i, this.j, this.n, this.o);
        this.b(nBTTagCompound);
    }

    public final void readFromNBTWithoutPos(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Motion");
        NBTTagList nBTTagList2 = nBTTagCompound.j("Rotation");
        this.k = ((com.a.a.C_b)nBTTagList.a((int)0)).a;
        this.l = ((com.a.a.C_b)nBTTagList.a((int)1)).a;
        this.m = ((com.a.a.C_b)nBTTagList.a((int)2)).a;
        this.n = ((com.a.a.C_b)nBTTagList2.a((int)0)).a;
        this.o = ((com.a.a.C_b)nBTTagList2.a((int)1)).a;
        this.b = nBTTagCompound.f("FallDistance");
        this.J = nBTTagCompound.c("Fire");
        this.poison = nBTTagCompound.c("Poison");
        this.M = nBTTagCompound.c("Air");
        this.b(nBTTagCompound);
    }

    public abstract String a();

    protected abstract void b(NBTTagCompound var1);

    protected abstract void a(NBTTagCompound var1);

    protected static NBTTagList a(float ... fArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (float f : fArray) {
            nBTTagList.a(new com.a.a.C_b(f));
        }
        return nBTTagList;
    }

    public float c_() {
        return this.x / 2.0f;
    }

    public final net.minecraft.a.c.c.EntityItem a(int n, int n2) {
        return this.a(n, 1, 0.0f);
    }

    public final net.minecraft.a.c.c.EntityItem a(int n, int n2, float f) {
        net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(this.d, this.h, this.i + f, this.j, new ItemStack(n, n2));
        new net.minecraft.a.c.c.EntityItem(this.d, this.h, this.i + f, this.j, new ItemStack(n, n2)).O = 10;
        this.d.spawnEntityInWorld(c_b);
        return c_b;
    }

    public final net.minecraft.a.c.c.EntityItem entityDropItemAndMetadata(int n, int n2, int n3, float f) {
        net.minecraft.a.c.c.EntityItem c_b = new net.minecraft.a.c.c.EntityItem(this.d, this.h, this.i + f, this.j, new ItemStack(n, n2, n3));
        new net.minecraft.a.c.c.EntityItem(this.d, this.h, this.i + f, this.j, new ItemStack(n, n2, n3)).O = 10;
        this.d.spawnEntityInWorld(c_b);
        return c_b;
    }

    public boolean interact(EntityPlayer entityPlayer) {
        return false;
    }

    public boolean r() {
        return !this.u;
    }

    public net.minecraft.a.d.C_b getCollisionBox(Entity c_b) {
        return null;
    }

    protected void setEntityFlag(int n, boolean bl) {
        byte by = this.dataWatcher.getWatchableObjectByte(0);
        if (bl) {
            this.dataWatcher.updateObject(0, (byte)(by | 1 << n));
        } else {
            this.dataWatcher.updateObject(0, (byte)(by & ~(1 << n)));
        }
    }

    public void setPositionAndRotation2(float f, float f2, float f3, float f4, float f5, int n) {
        this.b(f, f2, f3);
        this.setRotation(f4, f5);
        ArrayList arrayList = (ArrayList)this.d.getCollidingBoundingBoxes(this, this.r.getInsetBoundingBox(0.03125f, 0.0f, 0.03125f));
        if (arrayList.size() > 0) {
            double d2 = 0.0;
            for (int i = 0; i < arrayList.size(); ++i) {
                net.minecraft.a.d.C_b c_b = (net.minecraft.a.d.C_b)arrayList.get(i);
                if (!((double)c_b.e > d2)) continue;
                d2 = c_b.e;
            }
            f2 = (float)((double)f2 + (d2 - (double)this.r.b));
            this.b(f, f2, f3);
        }
    }

    public void setVelocity(float f, float f2, float f3) {
        this.k = f;
        this.l = f2;
        this.m = f3;
    }

    public void handleHealthUpdate(byte by) {
    }

    public void outfitWithItem(int n, ItemStack itemStack) {
    }

    public boolean isInRangeToRenderVec3D(C_a c_a) {
        double d2 = this.h - c_a.a;
        double d3 = this.i - c_a.b;
        double d4 = this.j - c_a.c;
        double d5 = d2 * d2 + d3 * d3 + d4 * d4;
        return this.isInRangeToRenderDist(d5);
    }

    public boolean isInRangeToRenderDist(double d2) {
        double d3 = this.r.getAverageEdgeLength();
        return d2 < (d3 *= 64.0 * this.renderDistanceWeight) * d3;
    }

    public DataWatcher getDataWatcher() {
        return this.dataWatcher;
    }

    public void setLocationAndAngles(float f, float f2, float f3, float f4, float f5) {
        this.e = this.h = f;
        this.B = this.h;
        this.f = this.i = f2 + this.v;
        this.C = this.i;
        this.g = this.j = f3;
        this.D = this.j;
        this.n = f4;
        this.o = f5;
        this.b(this.h, this.i, this.j);
    }

    public boolean isInsideOfMaterial(Material c_c) {
        int n;
        int n2;
        double d2 = this.i + this.n();
        int n3 = MathHelper.a((double)this.h);
        int n4 = this.d.a(n3, n2 = MathHelper.d(MathHelper.a(d2)), n = MathHelper.a((double)this.j));
        return n4 != 0 && Block.c[n4].aC == c_c;
    }
}

