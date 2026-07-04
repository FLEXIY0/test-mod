/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.client.f.C_k;

public class C_w
extends C_k {
    public C_w(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.a *= 0.1f;
        this.b *= 0.1f;
        this.O *= 0.1f;
        this.U = this.G.nextFloat();
        this.W = f4;
        this.Y = f6;
        this.X = f5;
        this.T = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.F = false;
        this.P = (int)(Math.random() * 8.0);
    }

    @Override
    public float a(float f) {
        float f2 = super.a(f);
        float f3 = (float)this.S / (float)this.T;
        f3 = f3 * f3 * f3 * f3;
        return f2 * (1.0f - f3) + f3;
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

