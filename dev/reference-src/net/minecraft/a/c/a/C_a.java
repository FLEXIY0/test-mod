/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class C_a
extends C_e {
    public C_a(C_g c_g) {
        super(c_g);
        this.V = "/mob/zombie.png";
        this.am = 0.5f;
        this.a = 50;
        this.W *= 10;
        this.v *= 6.0f;
        this.a(this.w * 6.0f, this.x * 6.0f);
    }

    public C_a(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/zombie.png";
        this.am = 0.5f;
        this.a = 50;
        this.W *= 10;
        this.v *= 6.0f;
        this.a(this.w * 6.0f, this.x * 6.0f);
        this.b(f, f2, f3);
    }

    @Override
    protected final float a(int n, int n2, int n3) {
        return this.d.c(n, n2, n3) - 0.5f;
    }

    @Override
    protected final void a(C_b c_b, float f) {
        if ((double)f < 3.5 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, this.a, 0.8f);
        }
    }

    @Override
    public void f() {
        if (this.d.isBloodMoon()) {
            this.ai = 0;
        }
        super.f();
    }

    @Override
    protected final String g() {
        return "mob.zombie";
    }

    @Override
    protected final String h() {
        return "mob.zombiehurt";
    }

    @Override
    protected final String i() {
        return "mob.zombiedeath";
    }

    @Override
    public final String a() {
        return "Giant";
    }

    @Override
    protected final int itemDropped() {
        return Item.ingotAdminium.ap;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void attackEntityDuringBloodRain() {
    }

    @Override
    protected final void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2 = 4 + this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n2 += 2;
            }
            for (int i = 2; i < n2; ++i) {
                this.a(n, 1);
            }
        }
    }

    @Override
    public int c() {
        return 1000;
    }

    @Override
    public int statId() {
        return 23;
    }
}

