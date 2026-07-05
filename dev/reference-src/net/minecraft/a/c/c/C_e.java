/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.c.c;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_a;
import net.minecraft.a.c.C_d;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.d.C_g;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_e
extends C_a {
    private float itemDropChance = 1.0f;

    public C_e(net.minecraft.a.a.World c_g) {
        super(c_g);
    }

    @Override
    public float c_() {
        return this.a == 5 ? -1.0f : 0.0f;
    }

    public C_e(net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        this(c_g);
        this.P = n;
        this.Q = n2;
        this.R = n3;
        this.b = C_d.a;
        this.b(n4);
    }

    @Override
    protected void entityInit() {
        this.getDataWatcher().addObjectByDataType(2, 5);
        this.getDataWatcher().addObject(3, (byte)0);
    }

    public ItemStack getDisplayedItem() {
        return this.getDataWatcher().getWatchableObjectItemStack(2);
    }

    public void setDisplayedItem(ItemStack itemStack) {
        if (itemStack != null) {
            itemStack = itemStack.copy();
            itemStack.a = 1;
        }
        this.getDataWatcher().updateObject(2, itemStack);
        this.getDataWatcher().setWatchableState(2);
    }

    @Override
    protected void b(int n) {
        this.a = n;
        this.p = this.n = (float)(n * 90);
        float f = this.b.c;
        float f2 = this.b.d;
        float f3 = this.b.c;
        if (n != 0 && n != 2) {
            f = 0.5f;
        } else {
            f3 = 0.5f;
        }
        f /= 42.0f;
        f2 /= 42.0f;
        f3 /= 42.0f;
        float f4 = (float)this.P + 0.5f;
        float f5 = (float)this.Q + 0.5f;
        float f6 = (float)this.R + 0.5f;
        if (n == 0) {
            f6 -= 0.5625f;
        }
        if (n == 1) {
            f4 -= 0.5625f;
        }
        if (n == 2) {
            f6 += 0.5625f;
        }
        if (n == 3) {
            f4 += 0.5625f;
        }
        if (n == 4) {
            f2 -= 0.3f;
            f5 += 0.5f;
            f += 0.365f;
        }
        if (n == 5) {
            f2 = (float)((double)f2 - 0.3);
            f5 = (float)((double)f5 - 0.5);
            f = (float)((double)f + 0.365);
        }
        if (n == 0) {
            f4 -= C_e.c(this.b.c);
        }
        if (n == 1) {
            f6 += C_e.c(this.b.c);
        }
        if (n == 2) {
            f4 += C_e.c(this.b.c);
        }
        if (n == 3) {
            f6 -= C_e.c(this.b.c);
        }
        f5 = n == 4 ? (f5 -= C_e.c(this.b.d)) : (f5 += C_e.c(this.b.d));
        this.b(f4, f5, f6);
        float f7 = -0.00625f;
        this.r = new net.minecraft.a.d.C_b(f4 - f - f7, f5 - f2 - f7, f6 - f3 - f7, f4 + f + f7, f5 + f2 + f7, f6 + f3 + f7);
    }

    @Override
    public final boolean c() {
        int n;
        int n2 = this.b.c / 16;
        int n3 = this.b.d / 16;
        int n4 = this.P;
        int n5 = this.R;
        if (this.a == 5) {
            return true;
        }
        if (this.a == 0 || this.a == 2) {
            n4 = (int)(this.h - (float)this.b.c / 32.0f);
        }
        if (this.a == 1 || this.a == 3) {
            n5 = (int)(this.j - (float)this.b.c / 32.0f);
        }
        int n6 = (int)(this.i - (float)this.b.d / 32.0f);
        for (int i = 0; i < n2; ++i) {
            for (n = 0; n < n3; ++n) {
                Material c_c = this.a != 0 && this.a != 2 ? this.d.f(this.P, n6 + n, n5 + i) : this.d.f(n4 + i, n6 + n, this.R);
                if (c_c.a()) continue;
                return false;
            }
        }
        List<net.minecraft.a.c.Entity> list = this.d.r.a(this, this.r);
        for (n = 0; n < list.size(); ++n) {
            if (!(list.get(n) instanceof C_a)) continue;
            return false;
        }
        return true;
    }

    @Override
    public final boolean attackEntityFrom(net.minecraft.a.c.Entity c_b, int n, float f) {
        boolean bl;
        if (this.d.multiplayerWorld) {
            return true;
        }
        if (c_b instanceof net.minecraft.a.c.d.C_a || c_b instanceof net.minecraft.a.c.d.C_b || c_b instanceof C_g) {
            return false;
        }
        boolean bl2 = bl = !(c_b instanceof EntityPlayer) || c_b instanceof EntityPlayer && ((EntityPlayer)c_b).gamemode != 1;
        if (this.d.multiplayerWorld) {
            bl = false;
        }
        if (this.getDisplayedItem() == null) {
            this.k();
            if (bl) {
                this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, new ItemStack(Item.itemFrame)));
            }
        } else {
            if (bl) {
                this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, this.getDisplayedItem()));
            }
            this.setDisplayedItem(null);
        }
        return true;
    }

    @Override
    public final void b_() {
        if (!this.c()) {
            if (this.O++ >= 1) {
                this.k();
                this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, new ItemStack(Item.itemFrame)));
            }
        } else {
            this.O = 0;
        }
    }

    @Override
    public void d(float f, float f2, float f3) {
        if (!this.d.multiplayerWorld && (double)(f * f + f2 * f2 + f3 * f3) > 0.0) {
            this.k();
            this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, new ItemStack(Item.itemFrame)));
            if (this.getDisplayedItem() != null) {
                this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, this.getDisplayedItem()));
            }
        }
    }

    @Override
    public void a(float f, float f2, float f3) {
        if (!this.d.multiplayerWorld && (double)(f * f + f2 * f2 + f3 * f3) > 0.0) {
            this.k();
            this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, new ItemStack(Item.itemFrame)));
            if (this.getDisplayedItem() != null) {
                this.d.spawnEntityInWorld(new EntityItem(this.d, this.h, this.i, this.j, this.getDisplayedItem()));
            }
        }
    }

    public int getRotation() {
        return this.getDataWatcher().getWatchableObjectByte(3);
    }

    public void setItemRotation(int n) {
        this.getDataWatcher().updateObject(3, (byte)(n % 8));
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        if (this.getDisplayedItem() != null) {
            nBTTagCompound.a("Item", this.getDisplayedItem().a(new NBTTagCompound()));
            nBTTagCompound.a("ItemRotation", (byte)this.getRotation());
            nBTTagCompound.a("ItemDropChance", this.itemDropChance);
        }
        super.a(nBTTagCompound);
    }

    @Override
    public final String a() {
        return "Frame";
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        NBTTagCompound nBTTagCompound2 = nBTTagCompound.i("Item");
        if (nBTTagCompound2 != null) {
            this.setDisplayedItem(ItemStack.loadItemStackFromNBT(nBTTagCompound2));
            this.setItemRotation(nBTTagCompound.b("ItemRotation"));
            if (nBTTagCompound.a("ItemDropChance")) {
                this.itemDropChance = nBTTagCompound.f("ItemDropChance");
            }
        }
        super.b(nBTTagCompound);
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        if (this.d.multiplayerWorld) {
            return true;
        }
        if (this.getDisplayedItem() == null) {
            ItemStack itemStack = entityPlayer.b.d();
            if (itemStack != null) {
                this.setDisplayedItem(itemStack);
                if (entityPlayer.gamemode != 1 && --itemStack.a <= 0) {
                    entityPlayer.b.a(entityPlayer.b.c, null);
                }
                entityPlayer.addStat(StatList.frameUse, 1);
            }
        } else {
            this.setItemRotation(this.getRotation() + 1);
        }
        this.d.mc.f.swingItem();
        return true;
    }
}

