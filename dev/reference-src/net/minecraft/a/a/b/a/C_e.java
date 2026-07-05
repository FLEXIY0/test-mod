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

public final class C_e
extends TileEntity
implements C_b {
    public ItemStack[] barrelContents = new ItemStack[9];

    @Override
    public final int a() {
        return 9;
    }

    @Override
    public final ItemStack a(int n) {
        return this.barrelContents[n];
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.barrelContents[n] != null) {
            if (this.barrelContents[n].a <= n2) {
                ItemStack itemStack = this.barrelContents[n];
                this.barrelContents[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.barrelContents[n].a(n2);
            if (this.barrelContents[n].a == 0) {
                this.barrelContents[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.barrelContents[n] = itemStack;
        if (itemStack != null && itemStack.a > 64) {
            itemStack.a = 64;
        }
        this.onInventoryChanged();
    }

    @Override
    public final String b() {
        return "Barrel";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.barrelContents = new ItemStack[9];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.barrelContents.length) continue;
            this.barrelContents[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", "Barrel");
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.barrelContents.length; ++i) {
            if (this.barrelContents[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.barrelContents[i].a(nBTTagCompound2);
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
        this.a.playSoundAtBlock(this.b, this.c, this.d, "random.barrelOpen", 0.5f, this.a.I.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public void closeInventory() {
        this.a.playSoundAtBlock(this.b, this.c, this.d, "random.barrelClose", 0.5f, this.a.I.nextFloat() * 0.1f + 0.9f);
    }
}

