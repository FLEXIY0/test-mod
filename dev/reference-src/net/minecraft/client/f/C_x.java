/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.a.C_d;
import net.minecraft.client.f.C_k;

public final class C_x
extends C_k {
    private float smokeParticleScale;

    public C_x(C_g c_g, float f, float f2, float f3) {
        this(c_g, f, f2, f3, 1.0f);
    }

    public C_x(C_g c_g, float f, float f2, float f3, float f4) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.a *= 0.1f;
        this.b *= 0.1f;
        this.O *= 0.1f;
        this.X = this.Y = (float)(Math.random() * (double)0.3f + (double)0.7f);
        this.W = this.Y;
        this.U *= 1.25f;
        this.U *= f4;
        this.smokeParticleScale = this.U;
        this.T = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.T = (int)((float)this.T * f4);
        this.F = false;
    }

    @Override
    public final void a(C_d c_d, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8 = ((float)this.S + f) / (float)this.T * 32.0f;
        if (f7 < 0.0f) {
            f8 = 0.0f;
        }
        if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        this.U = this.smokeParticleScale * f8;
        super.a(c_d, f, f2, f3, f4, f5, f6);
    }

    @Override
    public final void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.S++ >= this.T) {
            this.k();
        }
        this.P = 7 - (this.S << 3) / this.T;
        this.b = (float)((double)this.b + 0.004);
        if (this.d.l((int)this.h, (int)this.i, (int)this.j) && this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f) {
            switch (this.d.getWindDirection()) {
                case 0: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 1: {
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 2: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.1);
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 3: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.1);
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 4: {
                    this.a = (float)(((double)this.a + (double)this.d.getWindForce()) * 0.1);
                    this.O = (float)(((double)this.O + (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 5: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.1);
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 6: {
                    this.a = (float)(((double)this.a - (double)this.d.getWindForce()) * 0.1);
                    break;
                }
                case 7: {
                    this.O = (float)(((double)this.O - (double)this.d.getWindForce()) * 0.1);
                }
            }
        }
        this.d(this.a, this.b, this.O);
        if (this.i == this.f) {
            this.a = (float)((double)this.a * 1.1);
            this.O = (float)((double)this.O * 1.1);
        }
        this.a *= 0.96f;
        this.b *= 0.96f;
        this.O *= 0.96f;
        if (this.s) {
            this.a *= 0.7f;
            this.O *= 0.7f;
        }
    }
}

