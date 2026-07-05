/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.b.C_a;

public class C_c
extends C_a {
    public C_c(World c_g) {
        super(c_g);
        this.V = "/mob/pig.png";
        this.a(0.9f, 0.9f);
    }

    public C_c(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/pig.png";
        this.a(0.9f, 0.9f);
        this.b(f, f2, f3);
    }

    @Override
    protected final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
    }

    @Override
    protected final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
    }

    @Override
    public final String a() {
        return "Pig";
    }

    @Override
    protected final String g() {
        return "mob.pig";
    }

    @Override
    protected final String h() {
        return "mob.pig";
    }

    @Override
    protected final String i() {
        return "mob.pigdeath";
    }

    @Override
    protected final int itemDropped() {
        if (this.J > 0) {
            return Item.an.ap;
        }
        return Item.am.ap;
    }

    @Override
    public int statId() {
        return 0;
    }
}

