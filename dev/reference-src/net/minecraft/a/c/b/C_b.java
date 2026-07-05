package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import util.MathHelper;

public class C_b extends C_a {
   public boolean grazing = false;
   public int grazingTime = 0;
   public static final float[][] fleeceColorTable = new float[][]{
      {1.0F, 1.0F, 1.0F},
      {0.6F, 0.6F, 0.6F},
      {0.3F, 0.3F, 0.3F},
      {1.0F, 0.25F, 0.625F},
      {1.0F, 0.25F, 1.0F},
      {0.75F, 0.375F, 1.0F},
      {0.625F, 0.25F, 1.0F},
      {0.5F, 0.5F, 1.0F},
      {0.4F, 0.7F, 1.0F},
      {0.25F, 1.0F, 1.0F},
      {0.25F, 1.0F, 0.625F},
      {0.25F, 1.0F, 0.25F},
      {0.625F, 1.0F, 0.25F},
      {1.0F, 1.0F, 0.25F},
      {1.0F, 0.625F, 0.25F},
      {1.0F, 0.25F, 0.25F},
      {0.1F, 0.1F, 0.1F},
      {0.3F, 0.2F, 0.1F}
   };

   public C_b(net.minecraft.a.a.World var1) {
      super(var1);
      this.V = "/mob/sheep.png";
      this.a(0.9F, 1.3F);
      this.setFleeceColor(this.G.nextInt(3));
   }

   public C_b(net.minecraft.a.a.World var1, float var2, float var3, float var4) {
      super(var1);
      this.V = "/mob/sheep.png";
      this.a(0.9F, 1.3F);
      this.setFleeceColor(this.G.nextInt(3));
      this.b(var2, var3, var4);
   }

   @Override
   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, new Byte((byte)0));
   }

   @Override
   public final boolean attackEntityFrom(net.minecraft.a.c.Entity var1, int var2, float var3) {
      if (!this.getSheared() && var1 instanceof EntityPlayer && !this.d.multiplayerWorld) {
         this.setSheared(true);
         int var4 = 1 + this.G.nextInt(3);
         if (var1 != null && var1 instanceof EntityPlayer) {
            ItemStack var5 = ((EntityPlayer)var1).b.d();
            if (var5 != null && (var5.a() == Item.C || var5.a() == Item.battleAxeGold || var5.a() == Item.spearGold)) {
               var4++;
            }
         }

         for (int var8 = 0; var8 < var4; var8++) {
            net.minecraft.a.c.c.EntityItem var6;
            net.minecraft.a.c.c.EntityItem var7 = var6 = this.entityDropItemAndMetadata(Block.cloth.at, 1, this.getFleeceColor(), 1.0F);
            var7.l = var7.l + this.G.nextFloat() * 0.05F;
            var6.k = var6.k + (this.G.nextFloat() - this.G.nextFloat()) * 0.1F;
            var6.m = var6.m + (this.G.nextFloat() - this.G.nextFloat()) * 0.1F;
         }

         return false;
      } else {
         return super.attackEntityFrom(var1, var2, var3);
      }
   }

   @Override
   protected final void e() {
      if (!this.d.multiplayerWorld) {
         super.e();
      }

      float var1 = MathHelper.a(this.n * (float) Math.PI / 180.0F);
      float var2 = MathHelper.b(this.n * (float) Math.PI / 180.0F);
      var1 = -0.7F * var1;
      var2 = 0.7F * var2;
      int var3 = (int)(this.h + var1);
      int var4 = (int)(this.i - 1.0F);
      int var5 = (int)(this.j + var2);
      Block var6 = Block.c[this.d.a(var3, var4, var5)];
      if (this.getSheared()) {
         if (this.grazing) {
            this.aj = this.ak = 0.0F;
            if (this.d.a(var3, var4, var5) == Block.j.at && (this.d.a(var3, var4, var5) != Block.j.at || this.d.e(var3, var4, var5) != 1)) {
               if (++this.grazingTime == 60) {
                  if (var6 != null) {
                     this.d.a(this, var6.getStepSound(0).a(), (var6.getStepSound(0).a + 1.0F) / 2.0F, var6.getStepSound(0).b * 0.8F);
                  }

                  this.d.mc.g.a(var3, var4, var5);
                  if (!this.d.multiplayerWorld) {
                     this.d.a(var3, var4, var5, Block.k.at);
                  }

                  if (this.G.nextInt(5) == 0) {
                     this.setSheared(false);
                  }
               }

               this.o = (float)(40 + this.grazingTime / 2 % 2 * 10);
            } else {
               this.grazing = false;
               this.o = 0.0F;
            }
         } else if (this.d.a(var3, var4, var5) == Block.j.at && this.d.e(var3, var4, var5) == 0 && this.G.nextInt(100) == 0) {
            this.grazing = true;
            this.grazingTime = 0;
         }
      } else {
         this.grazing = false;
         this.o = 0.0F;
      }
   }

   @Override
   public void d(net.minecraft.a.c.Entity var1) {
      if (this.d.multiplayerWorld) {
         super.d(var1);
      }

      if (this.c() > 0 && var1 != null) {
         var1.awardKillScore(this, this.c());
      }

      if (this.statId() >= 0 && var1 != null && var1 instanceof EntityPlayer) {
         ((EntityPlayer)var1).addStat(StatList.objectKillStats[this.statId()], 1);
         int var2 = 0;

         for (int var3 = 0; var3 < StatList.entities.length; var3++) {
            if (net.minecraft.client.d.getMinecraft().statFileWriter.getStatCount(StatList.objectKillStats[var3]) >= 1) {
               var2++;
            }
         }

         if (var2 >= StatList.entities.length - 1) {
            ((EntityPlayer)var1).triggerAchievement(AchievementList.slayer);
         }
      }
   }

   @Override
   protected final void a(NBTTagCompound var1) {
      super.a(var1);
      var1.a("Sheared", this.getSheared());
      var1.a("Grazing", this.grazing);
      var1.a("Color", this.getFleeceColor());
   }

   @Override
   protected final void b(NBTTagCompound var1) {
      super.b(var1);
      this.setSheared(var1.k("Sheared"));
      this.grazing = var1.k("Grazing");
      this.setFleeceColor(var1.d("Color"));
   }

   @Override
   public final String a() {
      return "Sheep";
   }

   @Override
   protected final String g() {
      return "mob.sheep";
   }

   @Override
   protected final String h() {
      return "mob.sheep";
   }

   @Override
   protected final String i() {
      return "mob.sheep";
   }

   public boolean getSheared() {
      return (this.dataWatcher.getWatchableObjectByte(16) & 16) != 0;
   }

   public void setSheared(boolean var1) {
      byte var2 = this.dataWatcher.getWatchableObjectByte(16);
      if (var1) {
         this.dataWatcher.updateObject(16, (byte)(var2 | 16));
      } else {
         this.dataWatcher.updateObject(16, (byte)(var2 & -17));
      }
   }

   public int getFleeceColor() {
      return this.dataWatcher.getWatchableObjectByte(16) & 15;
   }

   public void setFleeceColor(int var1) {
      byte var2 = this.dataWatcher.getWatchableObjectByte(16);
      this.dataWatcher.updateObject(16, (byte)(var2 & 240 | var1 & 15));
   }

   @Override
   public int statId() {
      return 1;
   }
}
