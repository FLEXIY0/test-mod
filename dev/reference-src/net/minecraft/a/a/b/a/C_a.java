/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;

public class C_a {
    public C_g a;
    public int b;
    public int c;
    public int d;
    protected boolean removing;

    public void a(NBTTagCompound nBTTagCompound) {
    }

    public void b(NBTTagCompound nBTTagCompound) {
    }

    public void d() {
    }

    public void onInventoryChanged() {
        if (this.a != null) {
            this.a.updateTileEntity(this.b, this.c, this.d, this);
        }
    }

    public boolean isRemoving() {
        return this.removing;
    }

    public void markForRemoval() {
        this.removing = true;
    }

    public void unmarkForRemoval() {
        this.removing = false;
    }

    public int getBlockMetadata() {
        return this.a.e(this.b, this.c, this.d);
    }

    public float getDistanceFrom(float f, float f2, float f3) {
        float f4 = (float)this.b + 0.5f - f;
        float f5 = (float)this.c + 0.5f - f2;
        float f6 = (float)this.d + 0.5f - f3;
        return f4 * f4 + f5 * f5 + f6 * f6;
    }

    public C_x getBlockType() {
        return C_x.c[this.a.a(this.b, this.c, this.d)];
    }
}

