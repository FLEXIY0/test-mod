/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class C_b
extends C_e {
    public int type = this.G.nextInt(2);

    public C_b(World c_g) {
        super(c_g);
        this.V = this.type == 1 ? "/mob/spider_brown.png" : "/mob/spider.png";
        this.V = "/mob/spider.png";
        this.a(1.4f, 0.9f);
        this.am = 0.8f;
    }

    public C_b(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = this.type == 1 ? "/mob/spider_brown.png" : "/mob/spider.png";
        this.a(1.4f, 0.9f);
        this.am = 0.8f;
        this.b(f, f2, f3);
    }

    @Override
    protected final void e() {
        super.e();
        if (!(!this.d.isBloodMoon() || this.W <= 0 || !this.s || this.G.nextInt(5000) != 0 || this.m() || this.o() || this.isInRope() || this.l() || this.d.l((int)this.h, (int)this.i, (int)this.j))) {
            this.spawnCobweb(this.d);
        }
    }

    @Override
    protected final net.minecraft.a.c.Entity b() {
        return this.a(1.0f) < 0.5f && this.d.y.b(this) < 256.0f && ((EntityPlayer)this.d.y).gamemode == 0 ? this.d.y : null;
    }

    @Override
    protected final void a(net.minecraft.a.c.Entity c_b, float f) {
        if (this.a(1.0f) > 0.5f && this.G.nextInt(100) == 0) {
            this.b = null;
        } else if (f > 2.0f && f < 6.0f && this.G.nextInt(10) == 0) {
            if (this.s) {
                f = c_b.h - this.h;
                float f2 = c_b.j - this.j;
                float f3 = MathHelper.c(f * f + f2 * f2);
                this.k = f / f3 * 0.5f * 0.8f + this.k * 0.2f;
                this.m = f2 / f3 * 0.5f * 0.8f + this.m * 0.2f;
                this.l = 0.4f;
                return;
            }
        } else {
            super.a(c_b, f);
        }
    }

    @Override
    public final boolean isOnLadder() {
        return this.t;
    }

    @Override
    public final boolean isInCobweb() {
        return false;
    }

    public void spawnCobweb(World c_g) {
        if (c_g.a((int)this.h, (int)this.i, (int)this.j) == 0) {
            c_g.b((int)this.h, (int)this.i, (int)this.j, Block.cobweb.at);
        }
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Color", this.type);
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.type = nBTTagCompound.d("Color");
        this.V = this.type == 1 ? "/mob/spider_brown.png" : "/mob/spider.png";
    }

    @Override
    protected final String g() {
        return "mob.spider";
    }

    @Override
    protected final String h() {
        return "mob.spider";
    }

    @Override
    protected final String i() {
        return "mob.spiderdeath";
    }

    @Override
    public final String a() {
        return "Spider";
    }

    @Override
    protected final int itemDropped() {
        return Item.G.ap;
    }

    @Override
    public int c() {
        return 105;
    }

    @Override
    public int statId() {
        return 6;
    }
}

