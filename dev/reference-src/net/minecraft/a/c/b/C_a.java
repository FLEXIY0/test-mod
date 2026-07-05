/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_c;

public abstract class C_a
extends C_c {
    public C_a(World c_g) {
        super(c_g);
    }

    @Override
    protected float a(int n, int n2, int n3) {
        return this.d.a(n, n2 - 1, n3) == Block.j.at ? 10.0f : this.d.c(n, n2, n3) - 0.5f;
    }

    @Override
    protected void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
    }

    @Override
    protected void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
    }

    @Override
    public boolean a(float f, float f2, float f3) {
        return this.d.d((int)f, (int)f2, (int)f3) > 8 && this.d.a((int)f, (int)f2 - 1, (int)f3) == Block.j.at && super.a(f, f2, f3);
    }

    @Override
    public int c() {
        return 10;
    }

    @Override
    public boolean attackEntityFrom(C_b c_b, int n, float f) {
        this.panic = 100;
        return super.attackEntityFrom(c_b, n, f);
    }
}

