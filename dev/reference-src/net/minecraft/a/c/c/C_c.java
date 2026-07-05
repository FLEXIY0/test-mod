/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.c.C_b;

public class C_c
extends C_b {
    public static final long serialVersionUID = 0L;
    public int id;
    private Random random = new Random();

    public C_c(C_g c_g, float f, float f2, float f3, int n) {
        super(c_g);
        this.a(0.98f, 0.98f);
        this.v = this.x / 2.0f;
        this.b(f, f2, f3);
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.A = false;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.id = n;
    }

    public C_c(C_g c_g) {
        super(c_g);
        this.a(0.98f, 0.98f);
        this.v = this.x / 2.0f;
        this.b(this.h, this.i, this.j);
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.A = false;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public final boolean d() {
        return !this.u;
    }

    @Override
    public String a() {
        return "Sand";
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("ID", (short)this.id);
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound.c("ID");
    }

    @Override
    public void b_() {
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
        float f = 0.7f;
        f = this.random.nextFloat() * f + (1.0f - f) * 0.5f;
        int n = this.d.a((int)this.h, (int)this.i, (int)this.j);
        int n2 = this.d.a((int)this.h, (int)this.i - 1, (int)this.j);
        net.minecraft.a.a.d.C_c c_c = this.d.f((int)this.h, (int)this.i, (int)this.j);
        if (this.s || n2 == C_x.quickSand.at) {
            if (!this.d.multiplayerWorld) {
                if (!this.d.a(this.h, this.i, this.j) && n != 0 && c_c != net.minecraft.a.a.d.C_c.f && c_c != net.minecraft.a.a.d.C_c.g && c_c != net.minecraft.a.a.d.C_c.pulley || n2 == C_x.stalactite.at) {
                    this.a(this.id, 1);
                } else {
                    this.d.b((int)this.h, (int)this.i, (int)this.j, this.id);
                }
            }
            this.k();
        }
    }
}

