/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import java.util.Random;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public class C_g
extends TileEntity
implements C_b {
    private ItemStack[] dispenserContents = new ItemStack[9];
    private Random dispenserRandom = new Random();

    @Override
    public int a() {
        return 9;
    }

    @Override
    public ItemStack a(int n) {
        return this.dispenserContents[n];
    }

    @Override
    public ItemStack a(int n, int n2) {
        if (this.dispenserContents[n] != null) {
            if (this.dispenserContents[n].a <= n2) {
                ItemStack itemStack = this.dispenserContents[n];
                this.dispenserContents[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.dispenserContents[n].a(n2);
            if (this.dispenserContents[n].a == 0) {
                this.dispenserContents[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.dispenserContents[n] != null) {
            ItemStack itemStack = this.dispenserContents[n];
            this.dispenserContents[n] = null;
            return itemStack;
        }
        return null;
    }

    public ItemStack getRandomStackFromInventory() {
        int n = -1;
        int n2 = 1;
        for (int i = 0; i < this.dispenserContents.length; ++i) {
            if (this.dispenserContents[i] == null || this.dispenserRandom.nextInt(n2++) != 0) continue;
            n = i;
        }
        if (n >= 0) {
            return this.a(n, 1);
        }
        return null;
    }

    @Override
    public void a(int n, ItemStack itemStack) {
        this.dispenserContents[n] = itemStack;
        if (itemStack != null && itemStack.a > this.c()) {
            itemStack.a = this.c();
        }
        this.onInventoryChanged();
    }

    @Override
    public String b() {
        return "Dispenser";
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.dispenserContents = new ItemStack[this.a()];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.dispenserContents.length) continue;
            this.dispenserContents[n] = ItemStack.loadItemStackFromNBT(nBTTagCompound2);
        }
    }

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", "Dispenser");
        super.b(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.dispenserContents.length; ++i) {
            if (this.dispenserContents[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.dispenserContents[i].a(nBTTagCompound2);
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.a("Items", nBTTagList);
    }

    @Override
    public int c() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.a.j(this.b, this.c, this.d) != this ? false : entityPlayer.getDistanceSq((float)this.b + 0.5f, (float)this.c + 0.5f, (float)this.d + 0.5f) <= 64.0f;
    }

    public void openChest() {
    }

    public void closeChest() {
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }
}

