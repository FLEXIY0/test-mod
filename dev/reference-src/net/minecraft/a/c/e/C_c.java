/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.e;

import net.minecraft.a.a.World;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.furniture.BlockBed;
import util.MathHelper;

public class C_c
extends EntityPlayer {
    private int newPositionZ;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float newPositionX;
    private float newPositionY;

    public C_c(World c_g, String string) {
        super(c_g);
        this.name = string;
        this.v = 0.0f;
        this.E = 0.0f;
        if (string != null && string.length() > 0) {
            this.N = "http://minecraft.net/skin/" + string + ".png";
        }
        this.F = true;
        this.renderDistanceWeight = 10.0;
    }

    protected void resetHeight() {
        this.v = 0.0f;
    }

    public boolean attackEntityFrom(C_b c_b, int n) {
        return true;
    }

    @Override
    public void setPositionAndRotation2(float f, float f2, float f3, float f4, float f5, int n) {
        this.positionX = f;
        this.positionY = f2;
        this.positionZ = f3;
        this.newPositionX = f4;
        this.newPositionY = f5;
        this.newPositionZ = n;
    }

    @Override
    public void b_() {
        super.b_();
        this.af = this.ag;
        float f = this.h - this.e;
        float f2 = this.j - this.g;
        float f3 = MathHelper.c(f * f + f2 * f2) * 4.0f;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.ag += (f3 - this.ag) * 0.4f;
        this.ah += this.ag;
    }

    @Override
    public float c_() {
        return 0.0f;
    }

    @Override
    public void f() {
        super.e();
        if (this.newPositionZ > 0) {
            float f = this.h + (this.positionX - this.h) / (float)this.newPositionZ;
            float f2 = this.i + (this.positionY - this.i) / (float)this.newPositionZ;
            float f3 = this.j + (this.positionZ - this.j) / (float)this.newPositionZ;
            float f4 = this.newPositionX - this.n;
            while ((double)f4 < -180.0) {
                f4 = (float)((double)f4 + 360.0);
            }
            while ((double)f4 >= 180.0) {
                f4 = (float)((double)f4 - 360.0);
            }
            this.n += f4 / (float)this.newPositionZ;
            this.o += (this.newPositionY - this.o) / (float)this.newPositionZ;
            --this.newPositionZ;
            this.b(f, f2, f3);
            this.setRotation(this.n, this.o);
        }
    }

    @Override
    public void outfitWithItem(int n, ItemStack itemStack) {
        if (n == 0) {
            this.b.a[this.b.c] = itemStack;
        } else if (n > 0 && n < 5) {
            this.b.b[n - 1] = itemStack;
        } else if (n == 5 || n == 6) {
            this.b.charmSlot[0] = itemStack;
        }
    }

    @Override
    public float getBedOrientationInDegrees() {
        byte by = this.d.e((int)this.h, (int)this.i, (int)this.j);
        int n = BlockBed.getDirectionFromMetadata(by);
        switch (n) {
            case 0: {
                return 90.0f;
            }
            case 1: {
                return 0.0f;
            }
            case 2: {
                return 270.0f;
            }
            case 3: {
                return 180.0f;
            }
        }
        return 0.0f;
    }
}

