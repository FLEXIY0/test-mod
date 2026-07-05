/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.b.C_a;

public class C_f
extends C_a {
    public boolean isOnGround = false;
    public float lastGroundPos = 0.0f;
    public float destPos = 0.0f;
    public float startPos;
    public float newPos;
    public float fallDMG = 1.0f;

    public C_f(World c_g) {
        super(c_g);
        this.V = "/mob/duck.png";
        this.a(0.6f, 0.8f);
        this.W = 4;
    }

    public C_f(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/duck.png";
        this.a(0.6f, 0.8f);
        this.W = 4;
        this.b(f, f2, f3);
    }

    @Override
    public void f() {
        super.f();
        this.newPos = this.lastGroundPos;
        this.startPos = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.s ? -1 : 4) * 0.3);
        if (this.destPos < 0.0f) {
            this.destPos = 0.0f;
        }
        if (this.destPos > 1.0f) {
            this.destPos = 1.0f;
        }
        if (!this.s && this.fallDMG < 1.0f) {
            this.fallDMG = 1.0f;
        }
        this.fallDMG = (float)((double)this.fallDMG * 0.9);
        if (!this.s && (double)this.l < 0.0) {
            this.l = (float)((double)this.l * 0.6);
        }
        this.lastGroundPos += this.fallDMG * 2.0f;
    }

    @Override
    protected void b(float f) {
    }

    @Override
    public final boolean l() {
        return this.d.a(this.r.b(0.0f, 0.0f, 0.0f), C_c.f);
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
        return "Duck";
    }

    @Override
    protected String g() {
        return "mob.duck";
    }

    @Override
    protected String h() {
        return "mob.duckhurt";
    }

    @Override
    protected String i() {
        return "mob.duckhurt";
    }

    @Override
    protected int itemDropped() {
        return Item.H.ap;
    }

    @Override
    public int statId() {
        return 3;
    }
}

