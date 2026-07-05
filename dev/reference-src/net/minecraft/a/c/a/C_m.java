package net.minecraft.a.c.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.e.EntityPlayer;
import util.MathHelper;

public class C_m extends C_e {
   public float offsetY;
   public float offsetX;
   private int slimeJumpDelay = 0;

   public C_m(net.minecraft.a.a.World var1) {
      super(var1);
      this.V = "/mob/slime.png";
      int var2 = 1 << this.G.nextInt(3);
      this.v = 0.0F;
      this.slimeJumpDelay = this.G.nextInt(20) + 10;
      this.setSlimeSize(var2);
   }

   public C_m(net.minecraft.a.a.World var1, float var2, float var3, float var4) {
      super(var1);
      this.V = "/mob/slime.png";
      int var5 = 1 << this.G.nextInt(3);
      this.v = 0.0F;
      this.slimeJumpDelay = this.G.nextInt(20) + 10;
      this.setSlimeSize(var5);
      this.b(var2, var3, var4);
   }

   public void setSlimeSize(int var1) {
      this.dataWatcher.updateObject(16, new Byte((byte)var1));
      this.a(0.6F * (float)var1, 0.6F * (float)var1);
      this.W = var1 * var1;
      this.b(this.h, this.i, this.j);
   }

   @Override
   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, new Byte((byte)1));
   }

   public int getSlimeSize() {
      return this.dataWatcher.getWatchableObjectByte(16);
   }

   @Override
   public void a(NBTTagCompound var1) {
      super.a(var1);
      var1.a("Size", this.getSlimeSize());
   }

   @Override
   public void b(NBTTagCompound var1) {
      super.b(var1);
      this.setSlimeSize(var1.d("Size"));
   }

   @Override
   protected void b(float var1) {
   }

   @Override
   public final void b_() {
      this.offsetX = this.offsetY;
      boolean var1 = this.s;
      super.b_();
      if (this.s && !var1) {
         int var2 = this.getSlimeSize();

         for (int var3 = 0; var3 < var2 * 8; var3++) {
            float var4 = this.G.nextFloat() * (float) Math.PI * 2.0F;
            float var5 = this.G.nextFloat() * 0.5F + 0.5F;
            float var6 = MathHelper.a(var4) * (float)var2 * 0.5F * var5;
            float var7 = MathHelper.b(var4) * (float)var2 * 0.5F * var5;
            this.d.a("slimeballpoof", this.h + var6, this.r.b, this.j + var7, 0.0F, 0.0F, 0.0F);
         }

         if (var2 > 2) {
            this.d.a(this, "mob.slime", this.getSoundVolume(), ((this.G.nextFloat() - this.G.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.offsetY = -0.5F;
      }

      this.offsetY *= 0.6F;
   }

   @Override
   protected void e() {
      net.minecraft.a.c.C_b var1 = this.b;
      if (var1 != null) {
         this.faceEntity(var1, 10.0F, 20.0F);
      } else {
         this.b = this.b();
         if (this.G.nextFloat() < 0.04F) {
            this.Q = (this.G.nextFloat() - 0.5F) * 60.0F;
         }

         this.n = this.n + this.Q;
         this.o = 0.0F;
      }

      if (this.s && this.slimeJumpDelay-- <= 0) {
         this.slimeJumpDelay = this.G.nextInt(20) + 10;
         if (var1 != null) {
            this.slimeJumpDelay /= 3;
         }

         this.isJumping = true;
         if (this.getSlimeSize() > 1) {
            this.d.a(this, "mob.slime", this.getSoundVolume(), ((this.G.nextFloat() - this.G.nextFloat()) * 0.2F + 1.0F) * 0.8F);
         }

         this.offsetY = 1.0F;
         this.aj = 1.0F - this.G.nextFloat() * 2.0F;
         this.ak = (float)(1 * this.getSlimeSize());
      } else {
         this.isJumping = false;
         if (this.s) {
            this.aj = this.ak = 0.0F;
         }
      }
   }

   public void faceEntity(net.minecraft.a.c.C_b var1, float var2, float var3) {
      float var4 = var1.h - this.h;
      float var5 = var1.j - this.j;
      float var6;
      if (var1 instanceof net.minecraft.a.c.C_e) {
         net.minecraft.a.c.C_e var7 = (net.minecraft.a.c.C_e)var1;
         var6 = this.i + this.n() - (var7.i + var7.n());
      } else {
         var6 = (var1.r.b + var1.r.e) / 2.0F - (this.i + this.n());
      }

      float var10 = MathHelper.c(var4 * var4 + var5 * var5);
      float var8 = (float)(Math.atan2((double)var5, (double)var4) * 180.0 / (float) Math.PI) - 90.0F;
      float var9 = (float)(-(Math.atan2((double)var6, (double)var10) * 180.0 / (float) Math.PI));
      this.o = -this.updateRotation(this.o, var9, var3);
      this.n = this.updateRotation(this.n, var8, var2);
   }

   private float updateRotation(float var1, float var2, float var3) {
      float var4 = var2 - var1;

      while (var4 < -180.0F) {
         var4 += 360.0F;
      }

      while (var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      if (var4 > var3) {
         var4 = var3;
      }

      if (var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   @Override
   public void k() {
      int var1 = this.getSlimeSize();
      if (!this.d.multiplayerWorld && var1 > 1 && this.W <= 0) {
         for (int var2 = 0; var2 < 4; var2++) {
            float var3 = ((float)(var2 % 2) - 0.5F) * (float)var1 / 4.0F;
            float var4 = ((float)(var2 / 2) - 0.5F) * (float)var1 / 4.0F;
            C_m var5 = new C_m(this.d);
            var5.setSlimeSize(var1 / 2);
            var5.b(this.h + var3, this.i + 0.5F + this.n(), this.j + var4, this.G.nextFloat() * 360.0F, 0.0F);
            this.d.spawnEntityInWorld(var5);
         }
      }

      super.k();
   }

   @Override
   public void a(EntityPlayer var1) {
      int var2 = this.getSlimeSize();
      if (var2 > 1 && (double)this.b(var1) < 1.0 * (double)var2 && var1.attackEntityFrom(this, var2, 0.4F)) {
         this.d.a(this, "mob.slimeattack", 1.0F, (this.G.nextFloat() - this.G.nextFloat()) * 0.2F + 1.0F);
      }
   }

   @Override
   protected String h() {
      return "mob.slime";
   }

   @Override
   protected String i() {
      return "mob.slime";
   }

   @Override
   public String a() {
      return "Slime";
   }

   @Override
   protected int itemDropped() {
      return this.getSlimeSize() == 1 ? Item.slimeBall.ap : 0;
   }

   @Override
   protected float getSoundVolume() {
      return 0.6F;
   }

   @Override
   public int c() {
      return 10;
   }

   @Override
   public int statId() {
      return 15;
   }
}
