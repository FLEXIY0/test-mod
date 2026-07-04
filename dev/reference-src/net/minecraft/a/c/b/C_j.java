/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.b.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class C_j
extends C_e {
    public C_j(C_g c_g) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.V = "/mob/flowercow.png";
    }

    public C_j(C_g c_g, int n) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.V = "/mob/flowercow.png";
    }

    public C_j(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.b(f, f2, f3);
        this.V = "/mob/flowercow.png";
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2;
            ItemStack itemStack2;
            int n3 = this.G.nextInt(3) + 1;
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
            n2 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n2;
            }
            for (n3 = 0; n3 < n2; ++n3) {
                this.a(C_x.plantYellow.at, 1);
            }
        }
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.V = "/mob/flowercow.png";
    }

    @Override
    public final String a() {
        return "Moobloom";
    }

    @Override
    public int statId() {
        return 22;
    }
}

