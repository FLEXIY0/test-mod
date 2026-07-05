/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import net.minecraft.a.C_b;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.machines.BlockGenerator;

public final class C_h
extends TileEntity
implements C_b {
    private ItemStack[] fuel = new ItemStack[1];
    public int activeTime = 0;
    public int currentItemBurnTime = 0;
    public int offTimer = 0;
    public int onTimer = 0;
    public boolean active = false;

    @Override
    public final int a() {
        return this.fuel.length;
    }

    @Override
    public final ItemStack a(int n) {
        return this.fuel[n];
    }

    @Override
    public final ItemStack a(int n, int n2) {
        if (this.fuel[n] != null) {
            if (this.fuel[n].a <= n2) {
                ItemStack itemStack = this.fuel[n];
                this.fuel[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this.fuel[n].a(n2);
            if (this.fuel[n].a == 0) {
                this.fuel[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public final void a(int n, ItemStack itemStack) {
        this.fuel[n] = itemStack;
        if (itemStack != null && itemStack.a > 64) {
            itemStack.a = 64;
        }
    }

    @Override
    public final String b() {
        return "Generator";
    }

    @Override
    public final void a(NBTTagCompound nBTTagCompound) {
        super.a(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound.j("Items");
        this.fuel = new ItemStack[this.fuel.length];
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList.a(i);
            byte by = nBTTagCompound2.b("Slot");
            if (by < 0 || by >= this.fuel.length) continue;
            this.fuel[by] = new ItemStack(nBTTagCompound2);
        }
        this.activeTime = nBTTagCompound.c("BurnTime");
        this.active = nBTTagCompound.k("State");
        this.offTimer = nBTTagCompound.c("OffTimer");
        this.onTimer = nBTTagCompound.c("OnTimer");
        this.currentItemBurnTime = C_h.getItemBurnTime(this.fuel[0]);
    }

    @Override
    public final void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("BurnTime", (short)this.activeTime);
        nBTTagCompound.a("OnTimer", (short)this.onTimer);
        nBTTagCompound.a("OffTimer", (short)this.offTimer);
        nBTTagCompound.a("id", "Generator");
        nBTTagCompound.a("State", this.active);
        NBTTagList nBTTagList = new NBTTagList();
        if (this.fuel[0] != null) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2.a("Slot", (byte)0);
            this.fuel[0].a(nBTTagCompound2);
            nBTTagList.a(nBTTagCompound2);
        }
        nBTTagCompound.a("Items", nBTTagList);
    }

    @Override
    public final int c() {
        return 64;
    }

    public final int getBurnTimeRemainingScaled(int n) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }
        return this.activeTime * 12 / this.currentItemBurnTime;
    }

    public final boolean isBurning() {
        return this.activeTime > 0;
    }

    @Override
    public final void d() {
        int n;
        boolean bl = this.offTimer > 0;
        boolean bl2 = false;
        if (this.offTimer > 0) {
            --this.offTimer;
        }
        if (this.onTimer > 0) {
            --this.onTimer;
        }
        if (this.shouldChangeState(this.b, this.c, this.d, Block.regulator.at)) {
            n = 20;
            if (this.checkForBlocks(this.b, this.c, this.d, 5, Block.regulator.at)) {
                n = 50;
            } else if (this.checkForBlocks(this.b, this.c, this.d, 6, Block.regulator.at)) {
                n = 75;
            } else if (this.checkForBlocks(this.b, this.c, this.d, 7, Block.regulator.at)) {
                n = 100;
            }
            if (this.onTimer <= 0) {
                this.onTimer = n;
            }
            if (this.onTimer == 1) {
                this.active = true;
            }
        }
        if (this.shouldChangeState(this.b, this.c, this.d, Block.detector.at) || this.shouldChangeState(this.b, this.c, this.d, Block.observer.at)) {
            this.active = true;
        }
        if (this.active) {
            if (this.activeTime > 0) {
                --this.activeTime;
            }
            if (this.shouldChangeState(this.b, this.c, this.d, Block.transformer.at)) {
                n = 20;
                if (this.checkForBlocks(this.b, this.c, this.d, 5, Block.transformer.at)) {
                    n = 50;
                } else if (this.checkForBlocks(this.b, this.c, this.d, 6, Block.transformer.at)) {
                    n = 75;
                } else if (this.checkForBlocks(this.b, this.c, this.d, 7, Block.transformer.at)) {
                    n = 100;
                }
                if (this.offTimer > n) {
                    this.offTimer = n;
                }
                if (this.offTimer == 0) {
                    this.active = false;
                }
            } else {
                this.offTimer = this.activeTime;
            }
            if (!this.a.multiplayerWorld && this.activeTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.activeTime = C_h.getItemBurnTime(this.fuel[0]);
                if (this.activeTime > 0) {
                    bl2 = true;
                    if (this.fuel[0] != null) {
                        if (this.fuel[0].a() == Item.bucketLava) {
                            this.fuel[0] = new ItemStack(Item.bucketEmpty, 1);
                        } else {
                            --this.fuel[0].a;
                            if (this.fuel[0].a == 0) {
                                this.fuel[0] = null;
                            }
                        }
                        ++this.offTimer;
                    }
                }
            }
        } else {
            this.offTimer = 0;
        }
        if (bl != this.offTimer > 0 && !this.a.multiplayerWorld) {
            bl2 = true;
            BlockGenerator.updateBlockState(this.offTimer > 0, this.a, this.b, this.c, this.d);
        }
        if (bl2) {
            this.onInventoryChanged();
        }
    }

    private boolean checkForBlocks(int n, int n2, int n3, int n4, int n5) {
        boolean bl = false;
        for (int i = -1; i < 2; ++i) {
            block1: for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    if (this.a.a(n + i, n2 + k, n3 + j) != n5 || this.a.e(n + i, n2 + k, n3 + j) != n4) continue;
                    bl = true;
                    continue block1;
                }
            }
        }
        return bl;
    }

    private boolean shouldChangeState(int n, int n2, int n3, int n4) {
        boolean bl = false;
        for (int i = -1; i < 2; ++i) {
            block1: for (int j = -1; j < 2; ++j) {
                for (int k = -1; k < 2; ++k) {
                    if (this.a.a(n + i, n2 + k, n3 + j) != n4 || this.a.e(n + i, n2 + k, n3 + j) < 4) continue;
                    bl = true;
                    continue block1;
                }
            }
        }
        return bl;
    }

    private boolean canSmelt() {
        if (this.fuel[0] == null) {
            return false;
        }
        return C_h.isFuel(this.fuel[0]);
    }

    private static int getItemBurnTime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        int n = itemStack.a().ap;
        return n == Item.i.ap && itemStack.getItemDamage() == 0 ? 1600 : (n == Item.i.ap && itemStack.getItemDamage() == 1 ? 800 : (n == Block.blockCoal.at ? 14400 : (n == Item.bucketLava.ap ? 20000 : 0)));
    }

    public static boolean isFuel(ItemStack itemStack) {
        return C_h.getItemBurnTime(itemStack) > 0;
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

