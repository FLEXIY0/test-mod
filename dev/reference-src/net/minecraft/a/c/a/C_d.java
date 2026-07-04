/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;

public class C_d
extends C_e {
    private int P;
    private int Q;
    private int R = 30;

    public C_d(C_g c_g) {
        super(c_g);
        this.V = "/mob/creeper.png";
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte)-1);
    }

    public C_d(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/creeper.png";
        this.b(f, f2, f3);
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
    }

    @Override
    public final String a() {
        return "Creeper";
    }

    @Override
    protected final void e() {
        this.Q = this.P;
        if (this.P > 0 && this.getCreeperState() < 0) {
            --this.P;
        }
        if (this.getCreeperState() >= 0) {
            this.setCreeperState(2);
        }
        super.e();
        if (this.getCreeperState() != 1) {
            this.setCreeperState(-1);
        }
    }

    @Override
    public void b_() {
        this.Q = this.P;
        if (this.d.multiplayerWorld) {
            int n = this.getCreeperState();
            if (n > 0 && this.P == 0) {
                this.d.a(this, "random.fuse", 1.0f, 0.5f);
            }
            this.P += n;
            if (this.P < 0) {
                this.P = 0;
            }
            if (this.P >= 30) {
                this.P = 30;
            }
        }
        super.b_();
        if (this.b == null && this.P > 0) {
            this.setCreeperState(-1);
            --this.P;
            if (this.P < 0) {
                this.P = 0;
            }
        }
    }

    @Override
    protected final void a(C_b c_b, float f) {
        if (!this.d.multiplayerWorld) {
            int n = this.getCreeperState();
            if (n <= 0 && f < 3.0f || n > 0 && f < 7.0f) {
                if (this.P == 0) {
                    this.d.a(this, "random.fuse", 1.0f, 0.5f);
                }
                this.setCreeperState(1);
                ++this.P;
                if (this.P >= 30) {
                    this.d.a(this, this.h, this.i, this.j, 3.0f);
                    this.k();
                }
                this.O = true;
            } else {
                this.setCreeperState(-1);
                --this.P;
                if (this.P < 0) {
                    this.P = 0;
                }
            }
        }
    }

    public final float getFlashTime(float f) {
        return ((float)this.Q + (float)(this.P - this.Q) * f) / (float)(this.R - 2);
    }

    @Override
    protected final String h() {
        return "mob.creeper";
    }

    @Override
    protected final String i() {
        return "mob.creeperdeath";
    }

    @Override
    public int c() {
        return 200;
    }

    @Override
    public int statId() {
        return 7;
    }

    @Override
    protected final int itemDropped() {
        return Item.I.ap;
    }

    private int getCreeperState() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    private void setCreeperState(int n) {
        this.dataWatcher.updateObject(16, (byte)n);
    }
}

