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

public class C_k
extends C_e {
    public C_k(C_g c_g) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.V = this.getType() == 0 ? "/mob/redcow.png" : "/mob/browncow.png";
    }

    public C_k(C_g c_g, int n) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.setType(n);
        this.V = this.getType() == 0 ? "/mob/redcow.png" : "/mob/browncow.png";
    }

    public C_k(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.a(0.9f, 1.3f);
        this.b(f, f2, f3);
        this.setType(this.G.nextInt(2));
        this.V = this.getType() == 0 ? "/mob/redcow.png" : "/mob/browncow.png";
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte(0));
    }

    @Override
    public final void f() {
        super.f();
        this.poison = 0;
    }

    @Override
    protected void e() {
        if (this.isMultiplayerEntity) {
            this.V = this.getType() == 0 ? "/mob/redcow.png" : "/mob/browncow.png";
        }
        super.e();
    }

    public int getType() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void setType(int n) {
        this.dataWatcher.updateObject(16, (byte)n);
    }

    @Override
    protected final float a(int n, int n2, int n3) {
        return this.d.a(n, n2 - 1, n3) == C_x.mycelium.at ? 10.0f : this.d.c(n, n2, n3) - 0.5f;
    }

    @Override
    public final boolean a(float f, float f2, float f3) {
        this.b(f, f2 + this.x / 2.0f, f3);
        return this.d.d((int)f, (int)f2, (int)f3) > 8 && this.d.a((int)f, (int)f2 - 1, (int)f3) == C_x.mycelium.at && this.d.d(this.r) && this.d.getCollidingBoundingBoxes(this, this.r).size() == 0 && !this.d.b(this.r);
    }

    @Override
    protected void dropFewItems(C_b c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            int n2;
            int n3;
            ItemStack itemStack2;
            int n4 = this.G.nextInt(3) + 1;
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                ++n4;
            }
            for (n3 = 0; n3 < n4; ++n3) {
                this.a(n, 1);
            }
            n3 = this.G.nextInt(3);
            int n5 = n2 = this.getType() == 0 ? C_x.mushroomRed.at : C_x.mushroomBrown.at;
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                ++n3;
            }
            for (n4 = 0; n4 < n3; ++n4) {
                this.a(n2, 1);
            }
        }
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        nBTTagCompound.a("Color", this.getType());
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        this.setType(nBTTagCompound.d("Color"));
        this.V = this.getType() == 0 ? "/mob/redcow.png" : "/mob/browncow.png";
    }

    @Override
    public final String a() {
        return "Mooshroom";
    }

    @Override
    public int statId() {
        return 21;
    }
}

