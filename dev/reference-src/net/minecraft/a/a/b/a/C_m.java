/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_m
extends TileEntity
implements C_b {
    public ItemStack[] vacuumContents = new ItemStack[9];

    @Override
    public final int a() {
        return 9;
    }

    @Override
    public final ItemStack a(int n) {
        return this.vacuumContents[n];
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.vacuumContents[n] != null) {
            if (this.vacuumContents[n].a <= n2) {
                ItemStack itemStack = this.vacuumContents[n];
                this.vacuumContents[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.vacuumContents[n].a(n2);
            if (this.vacuumContents[n].a == 0) {
                this.vacuumContents[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.vacuumContents[n] = itemStack;
        if (itemStack != null && itemStack.a > 64) {
            itemStack.a = 64;
        }
        this.onInventoryChanged();
    }

    public final boolean storePartialItemStack(ItemStack itemStack) {
        int n;
        int n2;
        int n3 = itemStack.a;
        int n4 = n2 = itemStack.c;
        int n5 = itemStack.d;
        int n6 = 0;
        if (n3 <= 0) {
            return false;
        }
        while (true) {
            if (n6 >= this.vacuumContents.length) {
                n = -1;
                break;
            }
            if (!(this.vacuumContents[n6] == null || this.vacuumContents[n6].c != n4 || this.vacuumContents[n6].a >= this.vacuumContents[n6].a().c() || this.vacuumContents[n6].a >= 64 || this.vacuumContents[n6].getHasSubtypes() && this.vacuumContents[n6].getItemDamage() != itemStack.getItemDamage() || !ItemStack.areItemStackTagsEqual(this.vacuumContents[n6], itemStack) || this.vacuumContents[n6].hasTagCompound())) {
                n = n6;
                break;
            }
            ++n6;
        }
        int n7 = n;
        if (n < 0) {
            n7 = this.storeItemStack();
        }
        if (n7 < 0) {
            n = n3;
        } else {
            if (this.vacuumContents[n7] == null) {
                this.vacuumContents[n7] = new ItemStack(n2, 0, n5);
                if (itemStack.hasTagCompound()) {
                    this.vacuumContents[n7].setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                }
            }
            n2 = n3;
            if (n3 > this.vacuumContents[n7].a().c() - this.vacuumContents[n7].a) {
                n2 = this.vacuumContents[n7].a().c() - this.vacuumContents[n7].a;
            }
            if (n2 > 64 - this.vacuumContents[n7].a) {
                n2 = 64 - this.vacuumContents[n7].a;
            }
            if (n2 == 0) {
                n = n3;
            } else {
                this.vacuumContents[n7].a += n2;
                this.vacuumContents[n7].b = 5;
                n = n3 -= n2;
            }
        }
        itemStack.a = n;
        if (itemStack.a == 0) {
            return true;
        }
        int n8 = this.storeItemStack();
        if (n8 >= 0) {
            this.vacuumContents[n8] = itemStack;
            this.vacuumContents[n8].b = 5;
            return true;
        }
        return false;
    }

    private int storeItemStack() {
        for (int i = 0; i < this.vacuumContents.length; ++i) {
            if (this.vacuumContents[i] != null) continue;
            return i;
        }
        return -1;
    }

    @Override
    public final String b() {
        return "Collector";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.vacuumContents = new ItemStack[9];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.vacuumContents.length) continue;
            this.vacuumContents[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", "Vacuum");
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.vacuumContents.length; ++i) {
            if (this.vacuumContents[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.vacuumContents[i].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        nBTTagCompound.a("Items", nBTTagList);
    }

    @Override
    public final int c() {
        return 64;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.a.j(this.b, this.c, this.d) != this ? false : entityPlayer.getDistanceSq((float)this.b + 0.5f, (float)this.c + 0.5f, (float)this.d + 0.5f) <= 64.0f;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

