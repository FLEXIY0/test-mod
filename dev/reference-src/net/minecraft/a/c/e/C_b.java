package net.minecraft.a.c.e;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.d;
import net.minecraft.network.packet.Packet202CreativeInventory;

public final class C_b implements net.minecraft.a.C_b {
   public ItemStack[] a = new ItemStack[36];
   public ItemStack[] b = new ItemStack[4];
   public ItemStack[] quiverInventory = new ItemStack[3];
   public ItemStack[] charmSlot = new ItemStack[1];
   public int c = 0;
   public EntityPlayer d;
   private ItemStack itemStack;
   public boolean inventoryChanged = false;

   public C_b(EntityPlayer var1) {
      this.d = var1;
   }

   public final ItemStack d() {
      return this.a[this.c];
   }

   private int d(int var1) {
      for (int var2 = 0; var2 < this.a.length; var2++) {
         if (this.a[var2] != null && this.a[var2].c == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int getQuiverSlotContainItem(int var1) {
      for (int var2 = 0; var2 < this.quiverInventory.length; var2++) {
         if (this.quiverInventory[var2] != null && this.quiverInventory[var2].c == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int getInventorySlotContainItemAndMetadata(int var1, int var2) {
      for (int var3 = 0; var3 < this.a.length; var3++) {
         if (this.a[var3] != null && this.a[var3].c == var1 && this.a[var3].d == var2) {
            return var3;
         }
      }

      return -1;
   }

   private int f() {
      for (int var1 = 0; var1 < this.a.length; var1++) {
         if (this.a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   private int storeArrowStack() {
      for (int var1 = 0; var1 < this.quiverInventory.length; var1++) {
         if (this.quiverInventory[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public final void swapItem(int var1, int var2, d var3, C_a var4) {
      int var5 = this.d(var1);
      if (var1 > 0 && var1 < 256) {
         C_x var6 = C_x.c[var1];
         if (var6.hasStates) {
            var5 = this.getInventorySlotContainItemAndMetadata(var1, var2);
         }
      }

      if (var1 == Item.spawnEgg.ap || var1 == Item.ao.ap) {
         var5 = this.getInventorySlotContainItemAndMetadata(var1, var2);
      }

      if (var5 >= 0 && var5 < 9) {
         this.c = var5;
         if (this.a[this.c] != null) {
            this.a[this.c].textTime = 30;
         }

         var3.q.a.d();
      } else {
         if (this.a[this.c] == null) {
            ItemStack var7 = new ItemStack(var1, 1, var2);
            if (var4 != null) {
               var3.d.storeTEInStack(var7, var4);
            }

            this.a[this.c] = var7;
         } else {
            this.a[this.c].c = var1;
            if (this.a[this.c].getHasSubtypes()) {
               this.a[this.c].d = var2;
            } else {
               this.a[this.c].d = 0;
            }

            this.a[this.c].a = 1;
         }

         if (this.a[this.c] != null) {
            this.a[this.c].textTime = 30;
         }

         var3.q.a.d();
      }

      if (var3.isMultiplayerWorld() && var3.getSendQueue() != null) {
         var3.getSendQueue().addToSendQueue(new Packet202CreativeInventory(this.c, this.a[this.c]));
      }
   }

   public final void swapItemFromInventory(int var1, int var2, d var3) {
      if (!var3.isMultiplayerWorld()) {
         int var4 = this.d(var1);
         if (var1 > 0 && var1 < 256) {
            C_x var5 = C_x.c[var1];
            if (var5.hasStates) {
               var4 = this.getInventorySlotContainItemAndMetadata(var1, var2);
            }
         }

         if (var4 >= 0 && var4 < 9) {
            this.c = var4;
            if (this.a[this.c] != null) {
               this.a[this.c].textTime = 30;
            }

            var3.q.a.d();
         } else if (var4 >= 9) {
            this.replaceItem(var1, var2);
            if (this.a[this.c] != null) {
               this.a[this.c].textTime = 30;
            }

            var3.q.a.d();
         }
      }
   }

   public void replaceItem(int var1, int var2) {
      int var3 = this.d(var1);
      if (var1 > 0 && var1 < 256) {
         C_x var4 = C_x.c[var1];
         if (var4.hasStates) {
            var3 = this.getInventorySlotContainItemAndMetadata(var1, var2);
         }
      }

      int var5 = this.a[var3].a;
      if (var3 >= 0 && this.a[this.c] != null) {
         this.a[var3].c = this.a[this.c].c;
         this.a[var3].a = this.a[this.c].a;
         if (!this.a[var3].getHasSubtypes() && this.a[var3].getMaxDamage() <= 0) {
            this.a[var3].d = 0;
         } else {
            this.a[var3].d = this.a[this.c].d;
         }
      } else if (var3 >= 0 && this.a[this.c] == null) {
         this.a[var3] = null;
      }

      if (this.a[this.c] != null) {
         this.a[this.c].c = var1;
         this.a[this.c].a = var5;
         if (!this.a[this.c].getHasSubtypes() && this.a[var3].getMaxDamage() <= 0) {
            this.a[this.c].d = 0;
         } else {
            this.a[this.c].d = var2;
         }

         this.a[this.c].textTime = 30;
      } else {
         this.a[this.c] = new ItemStack(var1, var5, var2);
      }
   }

   public final boolean c(int var1) {
      if ((var1 = this.d(var1)) < 0) {
         return false;
      } else {
         if (--this.a[var1].a <= 0) {
            this.a[var1] = null;
         }

         return true;
      }
   }

   public final boolean consumeQuiverItem(int var1) {
      if ((var1 = this.getQuiverSlotContainItem(var1)) < 0) {
         return false;
      } else {
         if (--this.quiverInventory[var1].a <= 0) {
            this.quiverInventory[var1] = null;
         }

         return true;
      }
   }

   public final boolean a(ItemStack var1) {
      int var2 = var1.a;
      int var3 = var1.c;
      int var4 = var3;
      int var5 = var1.d;
      C_b var6 = this;
      int var7 = 0;

      int var8;
      while (true) {
         if (var7 >= var6.a.length) {
            var8 = -1;
            break;
         }

         if (var6.a[var7] != null
            && var6.a[var7].c == var4
            && var6.a[var7].a < var6.a[var7].a().c()
            && var6.a[var7].a < 64
            && (!var6.a[var7].getHasSubtypes() || var6.a[var7].getItemDamage() == var1.getItemDamage())
            && ItemStack.areItemStackTagsEqual(this.a[var7], var1)
            && !this.a[var7].hasTagCompound()) {
            var8 = var7;
            break;
         }

         var7++;
      }

      int var9 = var8;
      if (var8 < 0) {
         var9 = this.f();
      }

      if (var9 < 0) {
         var8 = var2;
      } else {
         if (this.a[var9] == null) {
            this.a[var9] = new ItemStack(var3, 0, var5);
            if (var1.hasTagCompound()) {
               this.a[var9].setTagCompound((NBTTagCompound)var1.getTagCompound().copy());
            }
         }

         var3 = var2;
         if (var2 > this.a[var9].a().c() - this.a[var9].a) {
            var3 = this.a[var9].a().c() - this.a[var9].a;
         }

         if (var3 > 64 - this.a[var9].a) {
            var3 = 64 - this.a[var9].a;
         }

         if (var3 == 0) {
            var8 = var2;
         } else {
            var2 -= var3;
            this.a[var9].a += var3;
            this.a[var9].b = 5;
            if (this.a[var9] == this.a[this.c] && this.a[this.c].a == 1) {
               this.a[var9].textTime = 30;
            }

            var8 = var2;
         }
      }

      var1.a = var8;
      if (var1.a == 0) {
         return true;
      } else {
         int var10;
         if ((var10 = this.f()) >= 0) {
            this.a[var10] = var1;
            this.a[var10].b = 5;
            if (this.a[var10] == this.a[this.c] && this.a[this.c].a == 1) {
               this.a[var10].textTime = 30;
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public final boolean storeArrowInQuiver(ItemStack var1) {
      int var2 = var1.a;
      int var3 = var1.c;
      int var4 = var3;
      int var5 = var1.d;
      C_b var6 = this;
      int var7 = 0;

      int var8;
      while (true) {
         if (var7 >= var6.quiverInventory.length) {
            var8 = -1;
            break;
         }

         if (var6.quiverInventory[var7] != null
            && var6.quiverInventory[var7].c == var4
            && var6.quiverInventory[var7].a < var6.quiverInventory[var7].a().c()
            && var6.quiverInventory[var7].a < 64
            && (!var6.quiverInventory[var7].getHasSubtypes() || var6.quiverInventory[var7].getItemDamage() == var1.getItemDamage())
            && ItemStack.areItemStackTagsEqual(this.a[var7], var1)) {
            var8 = var7;
            break;
         }

         var7++;
      }

      int var9 = var8;
      if (var8 < 0) {
         var9 = this.storeArrowStack();
      }

      if (var9 < 0) {
         var8 = var2;
      } else {
         if (this.quiverInventory[var9] == null) {
            this.quiverInventory[var9] = new ItemStack(var3, 0, var5);
            if (var1.hasTagCompound()) {
               this.a[var2].setTagCompound((NBTTagCompound)var1.getTagCompound().copy());
            }
         }

         var3 = var2;
         if (var2 > this.quiverInventory[var9].a().c() - this.quiverInventory[var9].a) {
            var3 = this.quiverInventory[var9].a().c() - this.quiverInventory[var9].a;
         }

         if (var3 > 64 - this.quiverInventory[var9].a) {
            var3 = 64 - this.quiverInventory[var9].a;
         }

         if (var3 == 0) {
            var8 = var2;
         } else {
            var2 -= var3;
            this.quiverInventory[var9].a += var3;
            this.quiverInventory[var9].b = 5;
            var8 = var2;
         }
      }

      var1.a = var8;
      if (var1.a == 0) {
         return true;
      } else {
         int var10;
         if ((var10 = this.storeArrowStack()) >= 0) {
            this.quiverInventory[var10] = var1;
            this.quiverInventory[var10].b = 5;
            return true;
         } else {
            return false;
         }
      }
   }

   @Override
   public final ItemStack a(int var1, int var2) {
      ItemStack[] var3 = this.a;
      if (var1 >= this.a.length) {
         var3 = this.b;
         var1 -= this.a.length;
         if (var1 >= this.b.length) {
            var3 = this.quiverInventory;
            var1 -= this.b.length;
            if (var1 >= this.quiverInventory.length) {
               var3 = this.charmSlot;
               var1 -= this.quiverInventory.length;
            }
         }
      }

      if (var3[var1] != null) {
         if (var3[var1].a <= var2) {
            ItemStack var5 = var3[var1];
            var3[var1] = null;
            return var5;
         } else {
            ItemStack var4 = var3[var1].a(var2);
            if (var3[var1].a == 0) {
               var3[var1] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   @Override
   public final void a(int var1, ItemStack var2) {
      ItemStack[] var3 = this.a;
      if (var1 >= this.a.length) {
         var3 = this.b;
         var1 -= this.a.length;
         if (var1 >= this.b.length) {
            var3 = this.quiverInventory;
            var1 -= this.b.length;
            if (var1 >= this.quiverInventory.length) {
               var3 = this.charmSlot;
               var1 -= this.quiverInventory.length;
            }
         }
      }

      var3[var1] = var2;
   }

   @Override
   public final int a() {
      return this.a.length + 8;
   }

   @Override
   public final ItemStack a(int var1) {
      ItemStack[] var2 = this.a;
      if (var1 >= this.a.length) {
         var2 = this.b;
         var1 -= this.a.length;
         if (var1 >= this.b.length) {
            var2 = this.quiverInventory;
            var1 -= this.b.length;
            if (var1 >= this.quiverInventory.length) {
               var2 = this.charmSlot;
               var1 -= this.quiverInventory.length;
            }
         }
      }

      return var2[var1];
   }

   @Override
   public final String b() {
      return "Inventory";
   }

   @Override
   public final int c() {
      return 64;
   }

   public void dropAllItems() {
      for (int var1 = 0; var1 < this.a.length; var1++) {
         if (this.a[var1] != null) {
            this.d.a(this.a[var1], true);
            this.a[var1] = null;
         }
      }

      for (int var2 = 0; var2 < this.b.length; var2++) {
         if (this.b[var2] != null) {
            this.d.a(this.b[var2], true);
            this.b[var2] = null;
         }
      }

      for (int var3 = 0; var3 < this.quiverInventory.length; var3++) {
         if (this.quiverInventory[var3] != null) {
            this.d.a(this.quiverInventory[var3], true);
            this.quiverInventory[var3] = null;
         }
      }

      if (this.charmSlot[0] != null) {
         this.d.a(this.charmSlot[0], true);
         this.charmSlot[0] = null;
      }
   }

   public final int e() {
      int var1 = 0;

      for (ItemStack var5 : this.b) {
         if (var5 != null && var5.a() instanceof C_j) {
            int var6 = ((C_j)var5.a()).at;
            var1 += var6;
         }
      }

      return var1;
   }

   public void setItemStack(ItemStack var1) {
      this.itemStack = var1;
   }

   public void decrItemStack(int var1) {
      this.itemStack.a -= var1;
      if (this.itemStack.a <= 0) {
         this.itemStack = null;
      }
   }

   public ItemStack getItemStack() {
      return this.itemStack;
   }

   @Override
   public void onInventoryChanged() {
      this.inventoryChanged = true;
   }

   @Override
   public boolean canInteractWith(EntityPlayer var1) {
      return this.d.u ? false : (double)var1.b(this.d) <= 64.0;
   }

   public int getDamageVsEntity(net.minecraft.a.c.C_b var1) {
      ItemStack var2 = this.a(this.c);
      return var2 != null ? var2.getDamageVsEntity(var1) : 1;
   }

   public int getCharmDamageVsEntity(net.minecraft.a.c.C_b var1) {
      ItemStack var2 = this.a(43);
      return var2 != null ? var2.getDamageVsEntity(var1) : 1;
   }

   public boolean containsItem(Item var1) {
      for (int var2 = 0; var2 < this.a.length; var2++) {
         if (this.a[var2] != null && this.a[var2].a() == var1) {
            return true;
         }
      }

      for (int var3 = 0; var3 < this.quiverInventory.length; var3++) {
         if (this.quiverInventory[var3] != null && this.quiverInventory[var3].a() == var1) {
            return true;
         }
      }

      return this.charmSlot[0] != null && this.charmSlot[0].a() == Item.quiverAdminium;
   }

   @Override
   public void openInventory() {
   }

   @Override
   public void closeInventory() {
   }

   public boolean hasItem(int var1) {
      int var2 = this.d(var1);
      int var3 = this.getQuiverSlotContainItem(var1);
      return var2 >= 0 || var3 >= 0;
   }
}
