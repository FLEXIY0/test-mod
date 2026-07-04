/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.f;

import net.minecraft.a.a.C_g;
import net.minecraft.a.d.C_b;
import net.minecraft.client.f.C_k;
import util.MathHelper;

public class C_s
extends C_k {
    private int courseChangeCooldown = 0;
    private float waypointX;
    private float waypointY;
    private float waypointZ;

    public C_s(C_g c_g, float f, float f2, float f3, float f4, float f5, float f6) {
        super(c_g, f, f2, f3, f4, f5, f6);
        this.W = 1.0f;
        this.X = 1.0f;
        this.Y = 1.0f;
        this.P = 34;
        this.a(0.02f, 0.02f);
        this.U *= this.G.nextFloat() * 0.6f + 0.2f;
        this.k = (float)((double)this.k * (double)0.02f);
        this.l = (float)((double)this.l * (double)0.02f);
        this.m = (float)((double)this.m * (double)0.02f);
        this.T = (int)(64.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public float a(float f) {
        return 1.0f;
    }

    @Override
    public void b_() {
        this.e = this.h;
        this.f = this.i;
        this.g = this.j;
        this.d(this.k, this.l, this.m);
        this.k = (float)((double)this.k * 0.99);
        this.l = (float)((double)this.l * 0.99);
        this.m = (float)((double)this.m * 0.99);
        float f = this.waypointX - this.h;
        float f2 = this.waypointY - this.i;
        float f3 = this.waypointZ - this.j;
        this.n = (float)(Math.atan2(f3, f) * 180.0 / 3.1415927410125732) - 90.0f;
        float f4 = MathHelper.c(f * f + f2 * f2 + f3 * f3);
        if (f4 < 1.0f || f4 > 20.0f) {
            this.waypointX = this.h + (this.G.nextFloat() * 2.0f - 1.0f) * 2.0f;
            this.waypointY = this.i + (this.G.nextFloat() * 2.0f - 1.0f) * 2.0f;
            this.waypointZ = this.j + (this.G.nextFloat() * 2.0f - 1.0f) * 2.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.G.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, f4)) {
                this.k = (float)((double)this.k + (double)(f / f4) * 0.01);
                this.l = (float)((double)this.l + (double)(f2 / f4) * 0.01);
                this.m = (float)((double)this.m + (double)(f3 / f4) * 0.01);
            } else {
                this.waypointX = this.h;
                this.waypointY = this.i;
                this.waypointZ = this.j;
            }
        }
        if (this.T-- <= 0) {
            this.k();
        }
    }

    private boolean isCourseTraversable(float f, float f2, float f3, float f4) {
        float f5 = (this.waypointX - this.h) / f4;
        float f6 = (this.waypointY - this.i) / f4;
        float f7 = (this.waypointZ - this.j) / f4;
        C_b c_b = this.r.a();
        int n = 1;
        while ((float)n < f4) {
            c_b.c(f5, f6, f7);
            if (this.d.getCollidingBoundingBoxes(this, c_b).size() > 0) {
                return false;
            }
            ++n;
        }
        return true;
    }
}

