/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c;

import net.minecraft.a.a.World;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.b.C_a;
import util.MathHelper;

public class C_c
extends EntityLiving {
    protected net.minecraft.a.a.a.C_b a;
    protected Entity b;
    protected boolean O = false;
    protected int panic;

    public C_c(World c_g) {
        super(c_g);
    }

    @Override
    protected void e() {
        float f;
        float f2;
        float f3;
        if (this.d.multiplayerWorld || this.stunTimer > 0) {
            return;
        }
        if (this.panic > 0 && this.s) {
            if (this instanceof C_a) {
                this.am = 1.2f;
            }
            --this.panic;
        } else if (this.panic <= 0 && this.s && this instanceof C_a) {
            this.am = 0.7f;
        }
        this.O = false;
        if (this.b == null) {
            this.b = this.b();
            if (this.b != null) {
                this.a = this.d.C.a(this, this.b, 16.0f);
            }
        } else if (!this.b.r()) {
            this.b = null;
        } else {
            Entity c_b = this.b;
            f3 = this.b.h - this.h;
            f2 = c_b.i - this.i;
            f = c_b.j - this.j;
            float f4 = MathHelper.c(f3 * f3 + f2 * f2 + f * f);
            if (this.d.a(new net.minecraft.a.d.C_a(this.h, this.i + this.n(), this.j), new net.minecraft.a.d.C_a(this.b.h, this.b.i + this.b.n(), this.b.j)) == null) {
                this.a(this.b, f4);
            }
        }
        if (this.O) {
            this.aj = 0.0f;
            this.ak = 0.0f;
            this.isJumping = false;
        } else {
            int n;
            if (this.b != null && (this.a == null || this.G.nextInt(20) == 0)) {
                this.a = this.d.C.a(this, this.b, 16.0f);
            } else if (this.a == null || this.G.nextInt(100) == 0) {
                int n2 = -1;
                n = -1;
                int n3 = -1;
                float f5 = -99999.0f;
                for (int i = 0; i < 200; ++i) {
                    float f6;
                    int n4 = (int)(this.h + (float)this.G.nextInt(21) - 10.0f);
                    int n5 = (int)(this.i + (float)this.G.nextInt(9) - 4.0f);
                    int n6 = (int)(this.j + (float)this.G.nextInt(21) - 10.0f);
                    float f7 = this.a(n4, n5, n6);
                    if (!(f6 > f5)) continue;
                    f5 = f7;
                    n2 = n4;
                    n = n5;
                    n3 = n6;
                }
                if (n2 > 0) {
                    this.a = this.d.C.a((Entity)this, n2, n, n3, 16.0f);
                }
            }
            boolean bl = this.l();
            n = this.o() ? 1 : 0;
            if (this.a != null && this.G.nextInt(100) != 0) {
                net.minecraft.a.d.C_a c_a = this.a.a(this);
                float f8 = this.w * 2.0f;
                while (c_a != null) {
                    f2 = this.j;
                    f3 = this.i;
                    f = this.h;
                    float f9 = f2 - c_a.c;
                    if ((f -= c_a.a) * f + (f3 -= c_a.b) * f3 + f9 * f9 >= f8 * f8 || c_a.b > this.i) break;
                    this.a.a();
                    if (this.a.b()) {
                        c_a = null;
                        this.a = null;
                        continue;
                    }
                    c_a = this.a.a(this);
                }
                this.isJumping = false;
                if (c_a != null) {
                    float f10 = c_a.a - this.h;
                    f = c_a.c - this.j;
                    f3 = c_a.b - this.i;
                    this.n = (float)(Math.atan2(f, f10) * 180.0 / 3.1415927410125732) - 90.0f;
                    this.ak = this.am;
                    if (f3 > 0.0f) {
                        this.isJumping = true;
                    }
                }
                if (this.G.nextFloat() < 0.8f && (bl || n != 0)) {
                    this.isJumping = true;
                }
            } else {
                super.e();
                this.a = null;
            }
        }
    }

    protected void a(Entity c_b, float f) {
    }

    protected float a(int n, int n2, int n3) {
        return 0.0f;
    }

    protected Entity b() {
        return null;
    }

    @Override
    public boolean a(float f, float f2, float f3) {
        return super.a(f, f2, f3) && this.a((int)f, (int)f2, (int)f3) >= 0.0f;
    }
}

