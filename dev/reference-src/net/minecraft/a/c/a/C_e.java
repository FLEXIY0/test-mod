/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.C_c;
import net.minecraft.a.c.e.EntityPlayer;

public class C_e
extends C_c {
    protected int a = 2;
    public ItemStack[] armorInventory = new ItemStack[4];

    public C_e(World c_g) {
        super(c_g);
        this.W = 20;
        this.V = "/char2.png";
    }

    public C_e(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.W = 20;
        this.V = "/char2.png";
        this.b(f, f2, f3);
    }

    @Override
    public void f() {
        if (this.a(1.0f) > 0.5f) {
            this.ai += 2;
        }
        super.f();
    }

    @Override
    public void b_() {
        super.b_();
        if (!this.d.multiplayerWorld && this.d.E == 0) {
            this.k();
        }
    }

    @Override
    protected C_b b() {
        return this.d.y.b(this) < 256.0f && ((EntityPlayer)this.d.y).gamemode == 0 && this.canEntityBeSeen(this.d.y) ? this.d.y : null;
    }

    @Override
    public boolean attackEntityFrom(C_b c_b, int n, float f) {
        if (c_b != null) {
            n -= this.getArmorValue() / 4;
        }
        if (super.attackEntityFrom(c_b, n, f)) {
            if (c_b != this) {
                this.b = c_b;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void a(C_b c_b, float f) {
        if (this.ac <= 0 && (double)f < 2.0 && c_b.r.e > this.r.b && c_b.r.b < this.r.e) {
            this.ac = 20;
            c_b.attackEntityFrom(this, this.a, 0.4f);
        }
    }

    public int getArmorValue() {
        int n = 0;
        if (this.d.multiplayerWorld) {
            return 0;
        }
        for (ItemStack itemStack : this.armorInventory) {
            if (itemStack == null || !(itemStack.a() instanceof C_j)) continue;
            int n2 = ((C_j)itemStack.a()).at;
            n += n2;
        }
        return n;
    }

    @Override
    protected float a(int n, int n2, int n3) {
        return 0.5f - this.d.c(n, n2, n3);
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
    protected int itemDropped() {
        return Item.lighter.ap;
    }

    @Override
    public String a() {
        return "Human";
    }

    @Override
    public boolean a(float f, float f2, float f3) {
        return this.d.d((int)f, (int)f2, (int)f3) <= this.G.nextInt(8) && super.a(f, f2, f3);
    }
}

