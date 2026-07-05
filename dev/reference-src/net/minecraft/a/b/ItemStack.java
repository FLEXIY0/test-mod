/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import com.a.a.NBTBase;
import com.a.a.NBTTagCompound;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;

public final class ItemStack {
    public int a;
    public int b;
    public int c;
    public int d;
    public int textTime;
    public NBTTagCompound stackTagCompound;
    private static Random rand = new Random();

    public ItemStack(Block c_x) {
        this(c_x, 1);
    }

    public ItemStack(Block c_x, int n) {
        this(c_x.at, n);
    }

    public ItemStack(Block c_x, int n, int n2) {
        this(c_x.at, n, n2);
    }

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int n) {
        this(item.ap, n);
    }

    public ItemStack(Item item, int n, int n2) {
        this(item.ap, n, n2);
    }

    public ItemStack(int n) {
        this(n, 1);
    }

    public ItemStack(int n, int n2) {
        this.a = 0;
        this.c = n;
        this.a = n2;
    }

    public ItemStack(int n, int n2, int n3) {
        this.a = 0;
        this.c = n;
        this.a = n2;
        this.d = n3;
    }

    private ItemStack() {
        this.a = 0;
    }

    public ItemStack(NBTTagCompound nBTTagCompound) {
        this.a = 0;
        this.c = nBTTagCompound.c("id");
        this.a = nBTTagCompound.b("Count");
        this.d = nBTTagCompound.c("Damage");
        if (nBTTagCompound.a("tag")) {
            this.stackTagCompound = nBTTagCompound.i("tag");
        }
    }

    public ItemStack(int n, int n2, int n3, NBTTagCompound nBTTagCompound) {
        this.c = n;
        this.a = n2;
        this.d = n3;
        this.setTagCompound(nBTTagCompound);
    }

    public final ItemStack a(int n) {
        ItemStack itemStack = new ItemStack(this.c, n, this.d);
        if (this.stackTagCompound != null) {
            itemStack.stackTagCompound = (NBTTagCompound)this.stackTagCompound.copy();
        }
        this.a -= n;
        return itemStack;
    }

    public final Item a() {
        return Item.b[this.c];
    }

    public final int getItemDamage() {
        return this.d;
    }

    public final int getItemID() {
        return this.c;
    }

    public boolean isItemDamaged() {
        return this.isItemStackDamageable() && this.d > 0;
    }

    public boolean getHasSubtypes() {
        return Item.b[this.c].getHasSubtypes();
    }

    public int getIconIndex() {
        return this.a().getIconIndex(this);
    }

    public int getMaxStackSize() {
        return this.a().c();
    }

    public NBTTagCompound a(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.a("id", (short)this.c);
        nBTTagCompound.a("Count", (byte)this.a);
        nBTTagCompound.a("Damage", (short)this.d);
        if (this.stackTagCompound != null) {
            nBTTagCompound.a("tag", (NBTBase)this.stackTagCompound);
        }
        return nBTTagCompound;
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.c = nBTTagCompound.c("id");
        this.a = nBTTagCompound.b("Count");
        this.d = nBTTagCompound.c("Damage");
        if (nBTTagCompound.a("tag")) {
            this.stackTagCompound = nBTTagCompound.i("tag");
        }
    }

    public final int getMaxDamage() {
        return Item.b[this.c].d();
    }

    public boolean isItemStackDamageable() {
        if (Item.b[this.c].d() <= 0) {
            return false;
        }
        return !this.hasTagCompound() || !this.getTagCompound().k("Unbreakable");
    }

    public final void damageItem(int n, World c_g) {
        if (!this.isItemStackDamageable() || c_g.gamemode == 1) {
            return;
        }
        this.d += n;
        if (this.d > this.getMaxDamage()) {
            for (int i = 0; i < 16; ++i) {
                C_a c_a = new C_a((rand.nextFloat() - 0.5f) * 0.1f, (float)(Math.random() * (double)0.1f + (double)0.1f), 0.0f);
                c_a.rotateAroundX(-c_g.y.o * (float)Math.PI / 180.0f);
                c_a.rotateAroundY(-c_g.y.n * (float)Math.PI / 180.0f);
                C_a c_a2 = new C_a((rand.nextFloat() - 1.5f) * 0.3f, -rand.nextFloat() * 0.6f - 0.3f, 0.6f);
                c_a2.rotateAroundX(-c_g.y.o * (float)Math.PI / 180.0f);
                c_a2.rotateAroundY(-c_g.y.n * (float)Math.PI / 180.0f);
                c_a2 = c_a2.a(c_g.y.h, c_g.y.i + c_g.y.n(), c_g.y.j);
                c_g.a("iconcrack_" + this.a().ap, c_a2.a, c_a2.b, c_a2.c, c_a.a, c_a.b + 0.05f, c_a.c);
            }
            c_g.a(c_g.y, "random.break", 1.0f, 1.0f);
            c_g.mc.f.addStat(StatList.objectBreakStats[this.c], 1);
            c_g.mc.f.addStat(StatList.itemsBrokenStat, 1);
            if (this.c == Item.M.ap) {
                c_g.mc.f.triggerAchievement(AchievementList.ripoff);
            }
            --this.a;
            if (this.a < 0) {
                this.a = 0;
                if (!(this.a() instanceof C_j)) {
                    c_g.mc.f.b.a[c_g.mc.f.b.c] = null;
                }
            }
            this.d = 0;
        }
    }

    public final void damageItem2(int n, World c_g) {
        if (!this.isItemStackDamageable() || c_g.gamemode == 1) {
            return;
        }
        this.d += n;
        if (this.d > this.getMaxDamage()) {
            for (int i = 0; i < 16; ++i) {
                C_a c_a = new C_a((rand.nextFloat() - 0.5f) * 0.1f, (float)(Math.random() * (double)0.1f + (double)0.1f), 0.0f);
                c_a.rotateAroundX(-c_g.y.o * (float)Math.PI / 180.0f);
                c_a.rotateAroundY(-c_g.y.n * (float)Math.PI / 180.0f);
                C_a c_a2 = new C_a((rand.nextFloat() - 1.5f) * 0.3f, -rand.nextFloat() * 0.6f - 0.3f, 0.6f);
                c_a2.rotateAroundX(-c_g.y.o * (float)Math.PI / 180.0f);
                c_a2.rotateAroundY(-c_g.y.n * (float)Math.PI / 180.0f);
                c_a2 = c_a2.a(c_g.y.h, c_g.y.i + c_g.y.n(), c_g.y.j);
                c_g.a("iconcrack_" + this.a().ap, c_a2.a, c_a2.b, c_a2.c, c_a.a, c_a.b + 0.05f, c_a.c);
            }
            c_g.a(c_g.y, "random.break", 1.0f, 1.0f);
            c_g.mc.f.addStat(StatList.objectBreakStats[this.c], 1);
            c_g.mc.f.addStat(StatList.itemsBrokenStat, 1);
            if (this.c == Item.M.ap) {
                c_g.mc.f.triggerAchievement(AchievementList.ripoff);
            }
            --this.a;
            if (this.a < 0) {
                this.a = 0;
            }
            if (this == c_g.mc.f.b.charmSlot[0]) {
                c_g.mc.f.b.charmSlot[0] = null;
            }
            this.d = 0;
        }
    }

    private boolean isItemStackEqual(ItemStack itemStack) {
        return this.a != itemStack.a ? false : (this.c != itemStack.c ? false : (this.d != itemStack.d ? false : (this.stackTagCompound == null && itemStack.stackTagCompound != null ? false : this.stackTagCompound == null || this.stackTagCompound.equals(itemStack.stackTagCompound))));
    }

    public boolean isItemEqual(ItemStack itemStack) {
        return this.c == itemStack.c && this.d == itemStack.d;
    }

    public boolean isStackEqual(ItemStack itemStack) {
        return this.c == itemStack.c && this.a == itemStack.a && this.d == itemStack.d;
    }

    public static boolean areItemStacksEqual(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null && itemStack2 == null ? true : (itemStack != null && itemStack2 != null ? itemStack.isItemStackEqual(itemStack2) : false);
    }

    public static boolean areItemStackTagsEqual(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null && itemStack2 == null ? true : (itemStack != null && itemStack2 != null ? (itemStack.stackTagCompound == null && itemStack2.stackTagCompound != null ? false : itemStack.stackTagCompound == null || itemStack.stackTagCompound.equals(itemStack2.stackTagCompound)) : false);
    }

    public ItemStack copy() {
        ItemStack itemStack = new ItemStack(this.c, this.a, this.d);
        if (this.stackTagCompound != null) {
            itemStack.stackTagCompound = (NBTTagCompound)this.stackTagCompound.copy();
        }
        return itemStack;
    }

    public static ItemStack copyItemStack(ItemStack itemStack) {
        return itemStack == null ? null : itemStack.copy();
    }

    public boolean isStackable() {
        return this.getMaxStackSize() > 1 && (!this.isItemStackDamageable() || !this.isItemDamaged());
    }

    public String getItemName() {
        return Item.b[this.c].getItemName(this);
    }

    public String getItemDescription(int n) {
        if (this.c == Item.ao.ap) {
            return Item.b[this.c].getItemDescription(this, this.d);
        }
        return Item.b[this.c].getItemDescription(this, n);
    }

    public int getItemDescriptionLength() {
        return Item.b[this.c].getItemDescriptionLength(this);
    }

    public static ItemStack loadItemStackFromNBT(NBTTagCompound nBTTagCompound) {
        ItemStack itemStack = new ItemStack();
        itemStack.readFromNBT(nBTTagCompound);
        return itemStack.a() != null ? itemStack : null;
    }

    public boolean hasTagCompound() {
        return this.stackTagCompound != null;
    }

    public NBTTagCompound getTagCompound() {
        return this.stackTagCompound;
    }

    public void setTagCompound(NBTTagCompound nBTTagCompound) {
        this.stackTagCompound = nBTTagCompound;
    }

    public void setTagInfo(String string, NBTBase nBTBase) {
        if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
        }
        this.stackTagCompound.a(string, nBTBase);
    }

    public NBTTagCompound getSubCompound(String string) {
        return this.stackTagCompound != null && this.stackTagCompound.a(string) ? this.stackTagCompound.i(string) : null;
    }

    public String toString() {
        return this.a + "x" + Item.b[this.c].getItemName() + "@" + this.d + (this.hasTagCompound() ? "+NBT" : "");
    }

    public ItemStack useItemRightClick(World c_g, EntityPlayer entityPlayer) {
        return this.a().a(this, c_g, entityPlayer);
    }

    public void hitEntity(EntityLiving c_e, EntityPlayer entityPlayer) {
        if (entityPlayer.d.z) {
            Item.b[this.c].hitEntity(entityPlayer, this, entityPlayer.d);
        }
    }

    public void useItemOnEntity(EntityLiving c_e, EntityPlayer entityPlayer) {
        this.a().saddleEntity(this, c_e, entityPlayer);
    }

    public int getDamageVsEntity(Entity c_b) {
        return Item.b[this.c].a();
    }

    public boolean useItem(EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        return this.a().onItemUse(this, entityPlayer, c_g, n, n2, n3, n4);
    }

    public void updateAnimations(World c_g, EntityPlayer entityPlayer, int n, boolean bl) {
        if (this.b > 0) {
            --this.b;
        }
        if (this.textTime > 0) {
            --this.textTime;
        }
    }

    public void onPlayerStoppedUsing(World c_g, EntityPlayer entityPlayer, int n) {
        this.a().onPlayerStoppedUsing(this, c_g, entityPlayer, n);
    }

    public ItemStack onFoodEaten(World c_g, EntityPlayer entityPlayer) {
        return this.a().onFoodEaten(this, c_g, entityPlayer);
    }

    public int getMaxItemUseDuration() {
        return this.a().getMaxItemUseDuration(this);
    }

    public C_q getItemUseAction() {
        return this.a().getItemUseAction(this);
    }
}

