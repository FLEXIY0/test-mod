/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.client.f.C_k;

public final class C_r
extends C_k {
    public C_r(World c_g, float f, float f2, float f3) {
        this(c_g, f, f2, f3, 1.0f);
    }

    public C_r(World c_g, float f, float f2, float f3, float f4) {
        super(c_g, f, f2, f3, 0.0f, 0.0f, 0.0f);
        this.a *= 0.1f;
        this.b *= 0.1f;
        this.O *= 0.1f;
        this.Y = 1.0f;
        this.X = 1.0f;
        this.W = 1.0f;
        this.U = (float)(2.0 * (Math.random() * 0.8 + 0.5));
        int n = this.G.nextInt(4);
        switch (n) {
            case 1: {
                this.P = 65;
                break;
            }
            case 2: {
                this.P = 80;
                break;
            }
            case 3: {
                this.P = 81;
                break;
            }
            default: {
                this.P = 64;
            }
        }
        this.T = 15;
        this.T = (int)((float)this.T * f4);
        this.F = false;
    }

    @Override
    public final void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        if (this.s) {
            ++this.S;
        }
        if (this.S >= this.T) {
            this.k();
            if (this.G.nextInt(50) == 0 && this.d.a((int)this.h, (int)this.i, (int)this.j) == 0 && this.d.a((float)((int)this.h), (float)((int)this.i - 1), (float)((int)this.j))) {
                this.d.b((int)this.h, (int)this.i, (int)this.j, Block.leafPile.at);
            }
        }
        this.b = (float)((double)this.b - 0.004);
        if (this.d.season.currentSeason == 2 && this.d.getWindForce() > 0.0f) {
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

