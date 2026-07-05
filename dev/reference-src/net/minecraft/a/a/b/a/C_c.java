/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public final class C_c
extends TileEntity
implements C_b {
    public ItemStack[] e = new ItemStack[36];
    public boolean adjacentChestChecked = false;
    public C_c adjacentChestZNeg;
    public C_c adjacentChestXPos;
    public C_c adjacentChestXNeg;
    public C_c adjacentChestZPos;
    public float lidAngle;
    public float prevLidAngle;
    private int numUsingPlayers;

    @Override
    public final int a() {
        return 27;
    }

    @Override
    public final ItemStack a(int n) {
        return this.e[n];
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.e[n] != null) {
            if (this.e[n].a <= n2) {
                ItemStack itemStack = this.e[n];
                this.e[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.e[n].a(n2);
            if (this.e[n].a == 0) {
                this.e[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.e[n] = itemStack;
        if (itemStack != null && itemStack.a > 64) {
            itemStack.a = 64;
        }
        this.onInventoryChanged();
    }

    @Override
    public final String b() {
        return "Chest";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.e = new ItemStack[27];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            int n = nBTTagCompound2.b("Slot") & 0xFF;
            if (n < 0 || n >= this.e.length) continue;
            this.e[n] = new ItemStack(nBTTagCompound2);
        }
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", "Chest");
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.e.length; ++i) {
            if (this.e[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)i);
            this.e[i].a(nBTTagCompound2);
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

    public void checkForAdjacentChests() {
        if (!this.adjacentChestChecked) {
            this.adjacentChestChecked = true;
            this.adjacentChestZNeg = null;
            this.adjacentChestXPos = null;
            this.adjacentChestXNeg = null;
            this.adjacentChestZPos = null;
            if (this.a.a(this.b - 1, this.c, this.d) == Block.aj.at) {
                this.adjacentChestXNeg = (C_c)this.a.j(this.b - 1, this.c, this.d);
            }
            if (this.a.a(this.b + 1, this.c, this.d) == Block.aj.at) {
                this.adjacentChestXPos = (C_c)this.a.j(this.b + 1, this.c, this.d);
            }
            if (this.a.a(this.b, this.c, this.d - 1) == Block.aj.at) {
                this.adjacentChestZNeg = (C_c)this.a.j(this.b, this.c, this.d - 1);
            }
            if (this.a.a(this.b, this.c, this.d + 1) == Block.aj.at) {
                this.adjacentChestZPos = (C_c)this.a.j(this.b, this.c, this.d + 1);
            }
            if (this.adjacentChestZNeg != null) {
                this.adjacentChestZNeg.adjacentChestChecked = false;
            }
            if (this.adjacentChestZPos != null) {
                this.adjacentChestZPos.adjacentChestChecked = false;
            }
            if (this.adjacentChestXPos != null) {
                this.adjacentChestXPos.adjacentChestChecked = false;
            }
            if (this.adjacentChestXNeg != null) {
                this.adjacentChestXNeg.adjacentChestChecked = false;
            }
        }
    }

    @Override
    public void d() {
        double d2;
        super.d();
        this.checkForAdjacentChests();
        this.prevLidAngle = this.lidAngle;
        if (this.numUsingPlayers > 0 && this.lidAngle == 0.0f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
            double d3 = (double)this.b + 0.5;
            d2 = (double)this.d + 0.5;
            if (this.adjacentChestZPos != null) {
                d2 += 0.5;
            }
            if (this.adjacentChestXPos != null) {
                d3 += 0.5;
            }
            this.a.playSoundAtBlock((float)d3, (float)this.c + 0.5f, (float)d2, "random.chest_open", 0.5f, this.a.I.nextFloat() * 0.1f + 0.9f);
        }
        if (this.numUsingPlayers == 0 && this.lidAngle > 0.0f || this.numUsingPlayers > 0 && this.lidAngle < 1.0f) {
            float f;
            float f2 = this.lidAngle;
            this.lidAngle = this.numUsingPlayers > 0 ? 1.0f : 0.0f;
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            if (this.lidAngle < (f = 0.5f) && f2 >= f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
                d2 = (double)this.b + 0.5;
                double d4 = (double)this.d + 0.5;
                if (this.adjacentChestZPos != null) {
                    d4 += 0.5;
                }
                if (this.adjacentChestXPos != null) {
                    d2 += 0.5;
                }
                this.a.playSoundAtBlock((float)d2, (float)this.c + 0.5f, (float)d4, "random.chest_close", 0.5f, this.a.I.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }

    @Override
    public void openInventory() {
        ++this.numUsingPlayers;
    }

    @Override
    public void closeInventory() {
        --this.numUsingPlayers;
    }

    @Override
    public void markForRemoval() {
        this.adjacentChestChecked = false;
        this.checkForAdjacentChests();
        super.markForRemoval();
    }
}

