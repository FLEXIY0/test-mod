/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.b.C_a;
import net.minecraft.a.c.e.EntityPlayer;

public class C_e
extends C_a {
    int type = 0;

    public C_e(C_g c_g) {
        super(c_g);
        this.V = this.type == 1 ? "/mob/cow_bw.png" : "/mob/cow.png";
        this.a(0.9f, 1.3f);
    }

    public C_e(C_g c_g, int n) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.type = n;
        this.V = this.type == 1 ? "/mob/cow_bw.png" : "/mob/cow.png";
    }

    public C_e(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.type = this.G.nextInt(4);
        this.V = this.type == 1 ? "/mob/cow_bw.png" : "/mob/cow.png";
        this.a(0.9f, 1.3f);
        this.b(f, f2, f3);
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Color", this.type);
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.type = nBTTagCompound.d("Color");
        this.V = this.type == 1 ? "/mob/cow_bw.png" : "/mob/cow.png";
    }

    @Override
    public String a() {
        return "Cow";
    }

    @Override
    protected String g() {
        return "mob.cow";
    }

    @Override
    protected String h() {
        return "mob.cowhurt";
    }

    @Override
    protected String i() {
        return "mob.cowhurt";
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    @Override
    protected int itemDropped() {
        return Item.leather.ap;
    }

    @Override
    public int statId() {
        return 2;
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2 = this.G.nextInt(3) + 1;
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n2;
            }
            for (int i = 0; i < n2; ++i) {
                this.a(n, 1);
            }
        }
    }
}

