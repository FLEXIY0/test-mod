/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_a
extends C_b {
    public int a = 0;

    public C_a(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.c = true;
        this.a(0.98f, 0.98f);
        this.v = this.x / 2.0f;
        this.b(f, f2, f3);
        float f4 = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.k = -MathHelper.a(f4 * (float)Math.PI / 180.0f) * 0.02f;
        this.l = 0.2f;
        this.m = -MathHelper.b(f4 * (float)Math.PI / 180.0f) * 0.02f;
        this.A = false;
        this.a = 80;
        this.e = f;
        this.f = f2;
        this.g = f3;
    }

    public C_a(C_g c_g, float f, float f2, float f3, int n) {
        super(c_g);
        this.c = true;
        this.a(0.98f, 0.98f);
        this.v = this.x / 2.0f;
        this.b(f, f2, f3);
        float f4 = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.k = -MathHelper.a(f4 * (float)Math.PI / 180.0f) * 0.02f;
        this.l = 0.2f;
        this.m = -MathHelper.b(f4 * (float)Math.PI / 180.0f) * 0.02f;
        this.A = false;
        this.a = n;
        this.e = f;
        this.f = f2;
        this.g = f3;
    }

    public C_a(C_g c_g) {
        super(c_g);
        this.c = true;
        this.a(0.98f, 0.98f);
        this.v = this.x / 2.0f;
        this.b(this.h, this.i, this.j);
        float f = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.k = -MathHelper.a(f * (float)Math.PI / 180.0f) * 0.02f;
        this.l = 0.2f;
        this.m = -MathHelper.b(f * (float)Math.PI / 180.0f) * 0.02f;
        this.A = false;
        this.a = 80;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public final boolean d() {
        return !this.u;
    }

    @Override
    public final void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.l -= 0.04f;
        this.d(this.k, this.l, this.m);
        this.k *= 0.98f;
        this.l *= 0.98f;
        this.m *= 0.98f;
        if (this.s) {
            this.k *= 0.7f;
            this.m *= 0.7f;
            this.l *= -0.5f;
        }
        if (this.a-- <= 0) {
            this.k();
            if (!this.d.multiplayerWorld) {
                this.d.a(null, this.h, this.i, this.j, 4.0f);
            }
            net.minecraft.client.d.getMinecraft().f.triggerAchievement(AchievementList.useTNT);
        } else {
            this.d.a("smoke", this.h, this.i + 0.5f, this.j, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override
    public boolean attackEntityFrom(C_b c_b, int n, float f) {
        if (c_b instanceof EntityPlayer && !this.d.multiplayerWorld) {
            this.k();
            ((EntityPlayer)c_b).addStat(StatList.tntDefused, 1);
            if (((EntityPlayer)c_b).gamemode != 1) {
                this.a(C_x.ab.at, 1);
            }
        }
        return true;
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("Fuse", (byte)this.a);
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        this.a = nBTTagCompound.b("Fuse");
    }

    @Override
    public final String a() {
        return "PrimedTnt";
    }

    @Override
    public final float c_() {
        return 0.0f;
    }
}

