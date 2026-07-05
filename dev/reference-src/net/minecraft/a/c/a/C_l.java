/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class C_l
extends C_e {
    public C_l(World c_g) {
        super(c_g);
        this.V = "/mob/termite.png";
        this.a(0.9f, 0.9f);
        this.am = 1.3f;
        this.a = 3;
        this.W = 8;
        this.A = false;
    }

    public C_l(World c_g, float f, float f2, float f3) {
        super(c_g, f, f2, f3);
        this.V = "/mob/termite.png";
        this.a(0.9f, 0.9f);
        this.am = 1.3f;
        this.a = 3;
        this.W = 8;
        this.A = false;
    }

    @Override
    public void f() {
        super.f();
        this.poison = 0;
    }

    @Override
    protected void a(Entity c_b, float f) {
        if (this.ac <= 0 && (double)f < 2.0 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, this.a, 0.4f);
            c_b.poison = 150;
        }
    }

    @Override
    public final boolean a(float f, float f2, float f3) {
        this.b(f, f2 + this.x / 2.0f, f3);
        return this.d.a((int)f, (int)f2 - 1, (int)f3) == Block.mycelium.at && this.d.d(this.r) && this.d.getCollidingBoundingBoxes(this, this.r).size() == 0 && !this.d.b(this.r);
    }

    @Override
    public final String a() {
        return "Slug";
    }

    @Override
    public int c() {
        return 105;
    }

    @Override
    public int statId() {
        return 25;
    }

    @Override
    public String g() {
        return "mob.spider";
    }

    @Override
    protected String h() {
        return "mob.spider";
    }

    @Override
    protected String i() {
        return "mob.spiderdeath";
    }

    @Override
    public void b_() {
        this.T = this.n;
        super.b_();
    }

    @Override
    public float a(int n, int n2, int n3) {
        return this.d.a(n, n2 - 1, n3) == Block.mycelium.at ? 10.0f : super.a(n, n2, n3);
    }

    @Override
    protected final int itemDropped() {
        return -1;
    }

    @Override
    protected void dropFewItems(Entity c_b) {
        ItemStack itemStack;
        int n = this.G.nextInt(5);
        if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
            n = 0;
        }
        if (n == 0) {
            this.a(Item.eye.ap, 1, 0.0f);
        }
    }
}

