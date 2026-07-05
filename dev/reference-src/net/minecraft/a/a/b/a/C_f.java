/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_f
extends C_a
implements C_b {
    private ItemStack[] chestContents = new ItemStack[9];

    @Override
    public final int a() {
        return 9;
    }

    @Override
    public final ItemStack a(int n) {
        return this.chestContents[n];
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.chestContents[n] != null) {
            if (this.chestContents[n].a <= n2) {
                ItemStack itemStack = this.chestContents[n];
                this.chestContents[n] = null;
                this.onInventoryChanged();
                this.checkForSlots();
                return itemStack;
            }
            ItemStack itemStack = this.chestContents[n].a(n2);
            if (this.chestContents[n].a == 0) {
                this.chestContents[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    private void checkForSlots() {
        int n = 0;
        for (int i = 0; i < this.a(); ++i) {
            if (this.a(i) == null) continue;
            ++n;
        }
        this.a.setBlockMetadataWithNotify(this.b, this.c, this.d, n);
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.chestContents[n] = itemStack;
        if (itemStack != null && itemStack.a > 64) {
            itemStack.a = 64;
        }
        this.checkForSlots();
        this.onInventoryChanged();
    }

    @Override
    public final String b() {
        return "Bookshelf";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.chestContents = new ItemStack[27];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.chestContents.length) continue;
            this.chestContents[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", "Bookshelf");
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.chestContents.length; ++i) {
            if (this.chestContents[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.chestContents[i].a(nBTTagCompound2);
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

