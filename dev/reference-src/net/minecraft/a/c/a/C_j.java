/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.d.C_d;
import net.minecraft.a.c.e.EntityPlayer;

public class C_j
extends C_e {
    public C_j(World c_g) {
        super(c_g);
        this.V = "/mob/imp.png";
        this.am = 1.2f;
        this.a(0.4f, 1.4f);
    }

    public C_j(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/imp.png";
        this.am = 1.2f;
        this.a(0.4f, 1.4f);
        this.b(f, f2, f3);
    }

    @Override
    public final void f() {
        super.f();
        this.J = 0;
        if (this.isInWater()) {
            this.attackEntityFrom(null, 1, 0.0f);
        }
        float f = this.G.nextFloat() * 0.02f;
        float f2 = this.G.nextFloat() * 0.02f;
        float f3 = this.G.nextFloat() * 0.02f;
        this.d.a("fire", this.h + this.G.nextFloat() * this.w * 2.0f - this.w, this.i + this.G.nextFloat() * this.x, this.j + this.G.nextFloat() * this.w * 2.0f - this.w, f, f2, f3);
        this.d.a("smoke", this.h + this.G.nextFloat() * this.w * 2.0f - this.w, this.i + this.G.nextFloat() * this.x, this.j + this.G.nextFloat() * this.w * 2.0f - this.w, f, f2, f3);
    }

    @Override
    protected final void a(Entity c_b, float f) {
        if (this.d.multiplayerWorld) {
            return;
        }
        if (f < 10.0f) {
            f = c_b.h - this.h;
            float f2 = c_b.j - this.j;
            if (this.ac == 0) {
                C_d c_d = new C_d(this.d, this);
                c_d.i += 1.0f;
                c_d.b(this.h, this.i + this.n(), this.j);
                float f3 = c_b.i + c_b.n() - 1.1f - c_d.i;
                this.d.a(this, "random.bow", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 0.8f));
                this.d.spawnEntityInWorld(c_d);
                c_d.setSnowballHeading(f, f3, f2, 1.0f, 12.0f);
                this.ac = 30;
            }
            this.n = (float)(Math.atan2(f2, f) * 180.0 / 3.1415927410125732) - 90.0f;
            this.O = true;
        }
    }

    @Override
    protected void a(int n) {
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
    protected final String g() {
        return "mob.imp";
    }

    @Override
    protected final String h() {
        return "mob.imphurt";
    }

    @Override
    protected final String i() {
        return "mob.imphurt";
    }

    @Override
    public final String a() {
        return "Imp";
    }

    @Override
    protected final int itemDropped() {
        return Item.ash.ap;
    }

    @Override
    public int c() {
        return 120;
    }

    @Override
    public int statId() {
        return 19;
    }

    @Override
    public void attackEntityDuringBloodRain() {
    }

    @Override
    protected void dropFewItems(Entity c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2;
            ItemStack itemStack2;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
            n2 = this.G.nextInt(10);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 = this.G.nextInt(5);
            }
            if (n2 == 0) {
                this.a(Item.fireBall.ap, 1, 0.0f);
            }
        }
    }
}

