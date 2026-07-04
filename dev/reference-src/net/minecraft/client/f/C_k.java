/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.c.C_b;
import net.minecraft.client.a.C_d;
import util.MathHelper;

public class C_k
extends C_b {
    protected float a;
    protected float b;
    protected float O;
    public int P;
    protected float Q;
    protected float R;
    protected int S = 0;
    protected int T = 0;
    protected float U;
    protected float V;
    public float W;
    public float X;
    public float Y;
    public static float interpX;
    public static float interpY;
    public static float interpZ;

    public C_k(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g);
        this.a(0.2f, 0.2f);
        this.v = this.x / 2.0f;
        this.b(f, f2, f3);
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.a = f4 + (float)(Math.random() * 2.0 - 1.0) * 0.4f;
        this.b = f5 + (float)(Math.random() * 2.0 - 1.0) * 0.4f;
        this.O = f6 + (float)(Math.random() * 2.0 - 1.0) * 0.4f;
        float f7 = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        f = MathHelper.c(this.a * this.a + this.b * this.b + this.O * this.O);
        this.a = this.a / f * f7 * 0.4f;
        this.b = this.b / f * f7 * 0.4f + 0.1f;
        this.O = this.O / f * f7 * 0.4f;
        this.Q = this.G.nextFloat() * 3.0f;
        this.R = this.G.nextFloat() * 3.0f;
        this.U = (this.G.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.T = (int)(4.0f / (this.G.nextFloat() * 0.9f + 0.1f));
        this.S = 0;
        this.A = false;
    }

    @Override
    protected void entityInit() {
    }

    public final C_k c(float f) {
        this.a *= 0.2f;
        this.b = (this.b - 0.1f) * 0.2f + 0.1f;
        this.O *= 0.2f;
        return this;
    }

    public final C_k d(float f) {
        this.a(0.120000005f, 0.120000005f);
        this.U *= 0.6f;
        return this;
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.b = (float)((double)this.b - 0.04 * (double)this.V);
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f && this.s) {
            switch (this.d.getWindDirection()) {
                case 0: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 1: {
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 2: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.01);
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 3: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.01);
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 4: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.01);
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 5: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.01);
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 6: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.01);
                    break;
                }
                case 7: {
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.01);
                }
            }
        }
        this.d(this.a, this.b, this.O);
        this.a *= 0.98f;
        this.b *= 0.98f;
        this.O *= 0.98f;
        if (this.s) {
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
    }

    public void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = (float)(this.P % 16) / 16.0f;
        float f8 = f7 + 0.0624375f;
        float f9 = (float)(this.P / 16) / 16.0f;
        float f10 = f9 + 0.0624375f;
        float f11 = 0.1f * this.U;
        float f12 = this.e + (this.h - this.e) * f;
        float f13 = this.f + (this.i - this.f) * f;
        float f14 = this.g + (this.j - this.g) * f;
        f = this.a(f);
        if (this.d.mc.f.nightVision && (f += 0.7f) > 1.0f) {
            f = 1.0f;
        }
        c_d.a(this.W * f, this.X * f, this.Y * f);
        c_d.a(f12 - f2 * f11 - f5 * f11, f13 - f3 * f11, f14 - f4 * f11 - f6 * f11, f7, f10);
        c_d.a(f12 - f2 * f11 + f5 * f11, f13 + f3 * f11, f14 - f4 * f11 + f6 * f11, f7, f9);
        c_d.a(f12 + f2 * f11 + f5 * f11, f13 + f3 * f11, f14 + f4 * f11 + f6 * f11, f8, f9);
        c_d.a(f12 + f2 * f11 - f5 * f11, f13 - f3 * f11, f14 + f4 * f11 - f6 * f11, f8, f10);
    }

    public int c() {
        return 0;
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public final String a() {
        return null;
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
    }
}

