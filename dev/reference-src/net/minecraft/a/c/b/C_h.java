package net.minecraft.a.c.b;

import com.a.a.NBTTagCompound;
import java.util.List;
import net.minecraft.a.b.Item;

public class C_h extends C_a {
   private int existence;
   private float rotation;
   private byte type;

   public C_h(net.minecraft.a.a.World var1) {
      super(var1);
      if (var1.getRaining() && var1.season.currentSeason == 3) {
         this.type = 1;
      } else if (var1.type == 4) {
         this.type = 2;
      } else {
         this.type = 0;
      }

      if (this.type == 1) {
         this.V = "/mob/snow_fox.png";
      } else if (this.type == 2) {
         this.V = "/mob/desert_fox.png";
      } else {
         this.V = "/mob/fox.png";
      }

      this.a(0.7F, 0.4F);
   }

   public C_h(net.minecraft.a.a.World var1, float var2, float var3, float var4) {
      super(var1);
      if (var1.getRaining() && var1.season.currentSeason == 3) {
         this.type = 1;
      } else if (var1.type == 4) {
         this.type = 2;
      } else {
         this.type = 0;
      }

      if (this.type == 1) {
         this.V = "/mob/snow_fox.png";
      } else if (this.type == 2) {
         this.V = "/mob/desert_fox.png";
      } else {
         this.V = "/mob/fox.png";
      }

      this.a(0.7F, 0.4F);
      this.b(var2, var3, var4);
   }

   @Override
   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(13, new Byte((byte)0));
   }

   @Override
   protected void e() {
      super.e();
      if (!this.d.multiplayerWorld) {
         if (this.b == null) {
            List var1 = this.d.a(this, this.r.b(16.0F, 4.0F, 16.0F));
            if (!var1.isEmpty()) {
               net.minecraft.a.c.C_b var2 = (net.minecraft.a.c.C_b)var1.get(this.d.q.nextInt(var1.size()));
               if (var2 instanceof C_f) {
                  this.b = var2;
               } else if (this.G.nextInt(1000) == 0 && !this.isLaying && !this.l()) {
                  this.isLaying = true;
                  this.rotation = (float)this.G.nextInt(360);
               }
            }
         } else if (!this.b.r()) {
            this.b = null;
         }

         if (this.isLaying) {
            this.existence++;
            this.ak = this.aj = this.am = 0.0F;
            this.k = this.m = 0.0F;
            this.isJumping = false;
            this.n = this.rotation;
            if (this.type == 1) {
               this.V = "/mob/snow_fox_sleeping.png";
            } else if (this.type == 2) {
               this.V = "/mob/desert_fox_sleeping.png";
            } else {
               this.V = "/mob/fox_sleeping.png";
            }

            if (this.existence > this.G.nextInt(2500) + 300) {
               this.existence = 0;
               this.isLaying = false;
            }
         } else {
            if (this.type == 1) {
               this.V = "/mob/snow_fox.png";
            } else if (this.type == 2) {
               this.V = "/mob/desert_fox.png";
            } else {
               this.V = "/mob/fox.png";
            }

            if (this.b != null) {
               this.am = 1.7F;
            } else {
               this.am = 0.7F;
            }
         }
      } else {
         this.isLaying = this.isSleeping();
         if (this.isLaying) {
            switch (this.type) {
               case 1:
                  this.V = "/mob/snow_fox_sleeping.png";
                  break;
               case 2:
                  this.V = "/mob/desert_fox_sleeping.png";
                  break;
               default:
                  this.V = "/mob/fox_sleeping.png";
            }

            this.k = this.m = 0.0F;
            this.isJumping = false;
         } else {
            switch (this.type) {
               case 1:
                  this.V = "/mob/snow_fox.png";
                  break;
               case 2:
                  this.V = "/mob/desert_fox.png";
                  break;
               default:
                  this.V = "/mob/fox.png";
            }
         }
      }
   }

   public boolean isSleeping() {
      return (this.dataWatcher.getWatchableObjectByte(13) & 13) != 0;
   }

   @Override
   protected void a(net.minecraft.a.c.C_b var1, float var2) {
      if ((double)var2 < 2.5 && var1.r.e > this.r.b && var1.r.b < this.r.e) {
         this.ac = 20;
         var1.attackEntityFrom(this, 4, 0.4F);
      }
   }

   @Override
   public final boolean l() {
      return this.d.a(this.r.b(0.0F, 0.0F, 0.0F), net.minecraft.a.a.d.C_c.f);
   }

   @Override
   public boolean attackEntityFrom(net.minecraft.a.c.C_b var1, int var2, float var3) {
      if (super.attackEntityFrom(var1, var2, var3)) {
         if (var1 != this) {
            this.b = var1;
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   public void a(NBTTagCompound var1) {
      super.a(var1);
      var1.a("Sleeping", this.existence);
      var1.a("SleepRot", this.rotation);
      var1.a("Laying", this.isLaying);
      var1.a("Sleeve", this.type);
   }

   @Override
   public void b(NBTTagCompound var1) {
      super.b(var1);
      this.existence = var1.d("Sleeping");
      this.rotation = var1.f("SleepRot");
      this.isLaying = var1.k("Laying");
      this.type = var1.b("Sleeve");
   }

   @Override
   public final String a() {
      return "Fox";
   }

   @Override
   protected String g() {
      return this.isLaying && this.G.nextInt(4) != 0 ? null : "mob.fox";
   }

   @Override
   protected String h() {
      return "mob.foxhurt";
   }

   @Override
   protected String i() {
      return "mob.foxdeath";
   }

   @Override
   protected int itemDropped() {
      return Item.leather.ap;
   }

   @Override
   public int statId() {
      return 12;
   }
}
