/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class C_k
extends C_e {
    public C_k(C_g c_g) {
        super(c_g);
        this.V = "/mob/mummy.png";
        this.am = 0.5f;
        this.a = 5;
    }

    public C_k(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.V = "/mob/mummy.png";
        this.am = 0.5f;
        this.a = 5;
        this.b(f, f2, f3);
    }

    @Override
    public final void f() {
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
        return "Mummy";
    }

    @Override
    protected final int itemDropped() {
        return Item.rottenFlesh.ap;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void attackEntityDuringBloodRain() {
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
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            int n2;
            ItemStack itemStack;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n3;
            }
            n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(Item.chainmail.ap, 1);
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
        }
    }

    @Override
    public int c() {
        return 80;
    }

    @Override
    public int statId() {
        return 13;
    }
}

