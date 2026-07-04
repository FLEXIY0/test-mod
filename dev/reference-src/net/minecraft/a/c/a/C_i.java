/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class C_i
extends C_e {
    public C_i(C_g c_g) {
        super(c_g);
        this.V = "/mob/bogged.png";
    }

    public C_i(C_g c_g, float f, float f2, float f3) {
        this(c_g);
        this.b(f, f2, f3);
    }

    @Override
    public final void f() {
        super.f();
        this.poison = 0;
    }

    @Override
    public final boolean a(float f, float f2, float f3) {
        this.b(f, f2 + this.x / 2.0f, f3);
        return (this.d.a((int)f, (int)f2 - 1, (int)f3) == C_x.mycelium.at || this.d.d((int)f, (int)f2, (int)f3) <= this.G.nextInt(8)) && this.d.d(this.r) && this.d.getCollidingBoundingBoxes(this, this.r).size() == 0 && !this.d.b(this.r);
    }

    @Override
    protected final void a(C_b c_b, float f) {
        if (f < 10.0f) {
            f = c_b.h - this.h;
            float f2 = c_b.j - this.j;
            if (this.ac == 0) {
                net.minecraft.a.c.d.C_b c_b2 = new net.minecraft.a.c.d.C_b(this.d, this, 2);
                c_b2.i += 1.0f;
                float f3 = c_b.i - c_b2.i;
                this.d.a(this, "random.bow", 1.0f, 1.0f / (this.G.nextFloat() * 0.4f + 0.8f));
                this.d.spawnEntityInWorld(c_b2);
                c_b2.setArrowHeading2(f, f3, f2, 1.5f, 12.0f);
                this.ac = 30;
            }
            this.n = (float)(Math.atan2(f2, f) * 180.0 / 3.1415927410125732) - 90.0f;
            this.O = true;
        }
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
        return "Husk";
    }

    @Override
    protected final int itemDropped() {
        return Item.dart.ap;
    }

    @Override
    public int c() {
        return 120;
    }

    @Override
    public int statId() {
        return 26;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void attackEntityDuringBloodRain() {
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            ItemStack itemStack2;
            int n2;
            ItemStack itemStack3;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack3 = ((EntityPlayer)c_b).b.d()) != null && (itemStack3.a() == Item.C || itemStack3.a() == Item.battleAxeGold || itemStack3.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
            n2 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                ++n2;
            }
            for (n3 = 0; n3 < n2; ++n3) {
                this.a(Item.rottenFlesh.ap, 1);
            }
            int n4 = this.G.nextInt(40);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n4 = this.G.nextInt(10);
            }
            if (n4 == 0) {
                this.entityDropItemAndMetadata(Item.dartShooter.ap, 1, this.G.nextInt(Item.dartShooter.d()), 0.0f);
            }
        }
    }
}

