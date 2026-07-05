/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_j;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockFurnace;

public final class C_b
extends C_a
implements net.minecraft.a.C_b {
    private ItemStack[] e = new ItemStack[3];
    public int f = 0;
    public int g = 0;
    public int h = 0;

    @Override
    public final int a() {
        return this.e.length;
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
                return itemStack;
            }
            ItemStack itemStack = this.e[n].a(n2);
            if (this.e[n].a == 0) {
                this.e[n] = null;
            }
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
    }

    @Override
    public final String b() {
        return "Chest";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.e = new ItemStack[this.e.length];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            byte by = nBTTagCompound2.b("Slot");
            if (by < 0 || by >= this.e.length) continue;
            this.e[by] = new ItemStack(nBTTagCompound2);
        }
        this.f = nBTTagCompound.c("BurnTime");
        this.h = nBTTagCompound.c("CookTime");
        this.g = C_b.a(this.e[1]);
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("BurnTime", (short)this.f);
        nBTTagCompound.a("CookTime", (short)this.h);
        nBTTagCompound.a("id", "Furnace");
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

    public final int b(int n) {
        return this.h * 24 / 200;
    }

    public final int c(int n) {
        if (this.g == 0) {
            this.g = 200;
        }
        return this.f * 12 / this.g;
    }

    public final boolean e() {
        return this.f > 0;
    }

    @Override
    public final void d() {
        boolean bl = this.f > 0;
        boolean bl2 = false;
        if (this.f > 0) {
            --this.f;
        }
        if (!this.a.multiplayerWorld) {
            if (this.f == 0 && this.f()) {
                this.g = this.f = C_b.a(this.e[1]);
                if (this.f > 0) {
                    bl2 = true;
                    if (this.e[1] != null) {
                        if (this.e[1].a() == Item.bucketLava) {
                            this.e[1] = new ItemStack(Item.bucketEmpty, 1);
                        } else {
                            --this.e[1].a;
                            if (this.e[1].a == 0) {
                                this.e[1] = null;
                            }
                        }
                    }
                }
            }
            if (this.e() && this.f()) {
                ++this.h;
                if (this.h == 200) {
                    this.h = 0;
                    this.smeltItem();
                    bl2 = true;
                }
            } else {
                this.h = 0;
            }
            if (bl != this.f > 0) {
                bl2 = true;
                BlockFurnace.updateFurnaceBlockState(this.f > 0, this.a, this.b, this.c, this.d);
            }
        }
        if (bl2) {
            this.onInventoryChanged();
        }
    }

    private boolean f() {
        if (this.e[0] == null) {
            return false;
        }
        ItemStack itemStack = C_j.smelting().getSmeltingResult(this.e[0].a().ap);
        return itemStack == null ? false : (this.e[2] == null ? true : (!this.e[2].isItemEqual(itemStack) ? false : (this.e[2].a < this.c() && this.e[2].a < this.e[2].getMaxStackSize() ? true : this.e[2].a < itemStack.getMaxStackSize())));
    }

    public void smeltItem() {
        if (this.f()) {
            ItemStack itemStack = C_j.smelting().getSmeltingResult(this.e[0].a().ap);
            if (this.e[2] == null) {
                this.e[2] = itemStack.copy();
            } else if (this.e[2].c == itemStack.c) {
                ++this.e[2].a;
            }
            --this.e[0].a;
            if (this.e[0].a <= 0) {
                this.e[0] = null;
            }
        }
    }

    private static int a(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        int n = itemStack.a().ap;
        return n < 256 && C_x.c[n].getMaterial(itemStack.getItemDamage()) == C_c.c ? 300 : (n < 256 && C_x.c[n].getMaterial(itemStack.getItemDamage()) == C_c.k ? 200 : (n < 256 && C_x.c[n].getMaterial(itemStack.getItemDamage()) == C_c.i ? 100 : (n < 256 && C_x.c[n].getMaterial(itemStack.getItemDamage()) == C_c.h ? 150 : (n == Item.z.ap ? 100 : (n == Item.i.ap && itemStack.getItemDamage() == 0 ? 1600 : (n == Item.i.ap && itemStack.getItemDamage() == 1 ? 800 : (n == C_x.seaweed.at ? 400 : (n == C_x.blockCoal.at ? 14400 : (n == Item.bucketLava.ap ? 20000 : 0)))))))));
    }

    public static boolean isFuel(ItemStack itemStack) {
        return C_b.a(itemStack) > 0;
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

