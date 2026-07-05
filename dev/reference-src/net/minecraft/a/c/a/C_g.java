package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class C_g extends C_e {
   private int existence;
   private int stayBuried = 0;

   public C_g(net.minecraft.a.a.World var1) {
      super(var1);
      this.V = "/mob/antlion.png";
      this.a(0.7F, 0.5F);
      this.am = 0.8F;
   }

   public C_g(net.minecraft.a.a.World var1, float var2, float var3, float var4) {
      super(var1);
      this.V = "/mob/antlion.png";
      this.a(0.7F, 0.5F);
      this.am = 0.8F;
      this.b(var2, var3, var4);
   }

   @Override
   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(14, new Byte((byte)0));
   }

   @Override
   protected void e() {
      super.e();
      if (!this.d.multiplayerWorld) {
         Block var1 = Block.c[this.d.a((int)this.h, (int)this.i - 1, (int)this.j)];
         if (this.G.nextInt(250) == 0 && !this.isLaying && this.s && var1 != null && (var1.at == Block.t.at || var1.at == Block.redSand.at)) {
            this.isLaying = true;
            this.d.a(this, var1.getStepSound(0).a(), (var1.getStepSound(0).a + 1.0F) / 2.0F, var1.getStepSound(0).b * 0.8F);
            this.d.mc.g.a((int)this.h, (int)this.i - 1, (int)this.j);
         }

         if (this.isLaying) {
            this.existence++;
            this.stayBuried++;
            this.am = 0.0F;
            this.isJumping = false;
            if (this.existence > this.G.nextInt(2500) + 300) {
               this.existence = 0;
               if (this.b != null) {
                  this.teleportEntity();
               } else {
                  if (var1 != null) {
                     this.d.a(this, var1.getStepSound(0).a(), (var1.getStepSound(0).a + 1.0F) / 2.0F, var1.getStepSound(0).b * 0.8F);
                  }

                  this.d.mc.g.a((int)this.h, (int)this.i - 1, (int)this.j);
                  this.isLaying = false;
               }
            }

            if (!this.d.a(this.h, this.i - 1.0F, this.j) && this.stayBuried > 10) {
               this.isLaying = false;
            }

            if (this.W > 0 && this.W < this.X && this.Y == 9) {
               this.teleportEntity();
            }
         } else if (this.b != null) {
            this.am = 1.1F;
         } else {
            this.am = 0.8F;
         }
      } else {
         this.isLaying = this.isBuried();
      }
   }

   public boolean isBuried() {
      return (this.dataWatcher.getWatchableObjectByte(14) & 14) != 0;
   }

   @Override
   protected final void a(net.minecraft.a.c.C_b var1, float var2) {
      if (!this.d.multiplayerWorld) {
         if (var2 > 2.0F && var2 < 6.0F && this.G.nextInt(10) == 0) {
            if (this.s && !this.isLaying) {
               var2 = var1.h - this.h;
               float var10 = var1.j - this.j;
               float var11 = MathHelper.c(var2 * var2 + var10 * var10);
               this.k = var2 / var11 * 0.5F * 0.8F + this.k * 0.2F;
               this.m = var10 / var11 * 0.5F * 0.8F + this.m * 0.2F;
               this.l = 0.4F;
               return;
            }
         } else if (this.isLaying) {
            if (var2 < 10.0F) {
               this.b = var1;
               float var3 = var1.h - this.h;
               float var4 = var1.j - this.j;
               if (this.ac == 0) {
                  net.minecraft.a.c.d.C_e var5 = new net.minecraft.a.c.d.C_e(this.d, this);
                  float var6 = var1.i + var1.n() - 1.1F - var5.i;
                  float var7 = MathHelper.c(var3 * var3 + var4 * var4) * 0.2F;
                  this.d.a(this, "random.bow", 1.0F, 1.0F / (this.G.nextFloat() * 0.4F + 0.8F));
                  this.d.spawnEntityInWorld(var5);
                  var5.setSnowballHeading(var3, var6 + var7, var4, 1.6F, 12.0F);
                  this.ac = 25;
               }

               this.n = (float)(Math.atan2((double)var4, (double)var3) * 180.0 / (float) Math.PI) - 90.0F;
               this.O = true;
            } else {
               Block var9 = Block.c[this.d.a((int)this.h, (int)this.i - 1, (int)this.j)];
               if (var9 != null) {
                  this.d.a(this, var9.getStepSound(0).a(), (var9.getStepSound(0).a + 1.0F) / 2.0F, var9.getStepSound(0).b * 0.8F);
               }

               this.d.mc.g.a((int)this.h, (int)this.i - 1, (int)this.j);
               this.isLaying = false;
            }
         } else {
            super.a(var1, var2);
         }
      }
   }

   @Override
   protected net.minecraft.a.c.C_b b() {
      return this.d.y.b(this) < 100.0F && ((EntityPlayer)this.d.y).gamemode == 0 && this.canEntityBeSeen(this.d.y) ? this.d.y : null;
   }

   @Override
   public final boolean l() {
      return this.d.a(this.r.b(0.0F, 0.0F, 0.0F), net.minecraft.a.a.d.C_c.f);
   }

   @Override
   public final boolean attackEntityFrom(net.minecraft.a.c.C_b var1, int var2, float var3) {
      this.ai = 0;
      if (this.W <= 0) {
         return false;
      } else {
         this.ag = 1.5F;
         if ((float)this.L > (float)this.S / 2.0F) {
            if (this.X - var2 >= this.W) {
               return false;
            }

            this.W = this.X - var2;
         } else {
            this.X = this.W;
            this.L = this.S;
            this.W -= var2;
            this.Y = this.Z = 10;
         }

         this.aa = 0.0F;
         if (var1 != null && !this.isLaying) {
            float var4 = var1.h - this.h;
            float var5 = var1.j - this.j;
            this.aa = (float)(Math.atan2((double)var5, (double)var4) * 180.0 / (float) Math.PI) - this.n;
            float var6 = MathHelper.c(var4 * var4 + var5 * var5);
            this.k /= 2.0F;
            this.l /= 2.0F;
            this.m /= 2.0F;
            this.k -= var4 / var6 * var3;
            this.l += 0.4F;
            this.m -= var5 / var6 * var3;
            if (this.l > 0.4F) {
               this.l = 0.4F;
            }
         } else {
            this.aa = (float)((int)(Math.random() * 2.0) * 180);
         }

         if (var1 != null && var1 != this) {
            this.b = var1;
         }

         if (this.isSitting) {
            this.isSitting = false;
         }

         if (this.W <= 0) {
            this.d.a(this, this.i(), this.getSoundVolume(), (this.G.nextFloat() - this.G.nextFloat()) * 0.2F + 1.0F);
            this.d(var1);
         } else {
            this.d.a(this, this.h(), this.getSoundVolume(), (this.G.nextFloat() - this.G.nextFloat()) * 0.2F + 1.0F);
         }

         return true;
      }
   }

   private void teleportEntity() {
      Block var1 = Block.c[this.d.a((int)this.h, (int)this.i - 1, (int)this.j)];
      if (this.isLaying) {
         int var2 = (int)this.h + (this.G.nextInt(20) - 10);
         int var3 = (int)this.j + (this.G.nextInt(20) - 10);
         int var4 = this.d.a(var2, var3);
         if ((this.d.a(var2, var4 - 1, var3) == Block.t.at || this.d.a(var2, var4 - 1, var3) == Block.redSand.at) && var1 != null) {
            this.d.a(this, var1.getStepSound(0).a(), (var1.getStepSound(0).a + 1.0F) / 2.0F, var1.getStepSound(0).b * 0.8F);
            this.d.mc.g.a((int)this.h, (int)this.i - 1, (int)this.j);
            this.b((float)var2 + 0.5F, (float)(var4 + 1), (float)var3 + 0.5F);
         } else {
            this.isLaying = false;
         }

         this.stayBuried = 0;
      }
   }

   @Override
   public final boolean d() {
      return !this.u && !this.isSitting;
   }

   @Override
   protected final void a(NBTTagCompound var1) {
      super.a(var1);
      var1.a("BuryTime", this.existence);
      var1.a("Buried", this.isLaying);
   }

   @Override
   protected final void b(NBTTagCompound var1) {
      super.b(var1);
      this.existence = var1.d("BuryTime");
      this.isLaying = var1.k("Buried");
   }

   @Override
   protected final String g() {
      return "mob.spider";
   }

   @Override
   protected final String h() {
      return "mob.spider";
   }

   @Override
   protected final String i() {
      return "mob.spiderdeath";
   }

   @Override
   public final String a() {
      return "Antlion";
   }

   @Override
   protected final int itemDropped() {
      return Block.t.at;
   }

   @Override
   public int c() {
      return 120;
   }

   @Override
   public int statId() {
      return 14;
   }

   @Override
   protected void dropFewItems(net.minecraft.a.c.C_b var1) {
      int var2;
      if ((var2 = this.itemDropped()) > 0) {
         int var3 = this.G.nextInt(3);
         if (var1 != null && var1 instanceof EntityPlayer) {
            ItemStack var4 = ((EntityPlayer)var1).b.d();
            if (var4 != null && (var4.a() == Item.C || var4.a() == Item.battleAxeGold || var4.a() == Item.spearGold)) {
               var3++;
            }
         }

         for (int var6 = 0; var6 < var3; var6++) {
            this.a(var2, 1);
         }

         int var7 = this.G.nextInt(10);
         if (var1 != null && var1 instanceof EntityPlayer) {
            ItemStack var5 = ((EntityPlayer)var1).b.d();
            if (var5 != null && (var5.a() == Item.C || var5.a() == Item.battleAxeGold || var5.a() == Item.spearGold)) {
               var7 = this.G.nextInt(5);
            }
         }

         if (var7 == 0) {
            this.a(Item.antlionTusk.ap, 1, 0.0F);
         }
      }
   }
}
