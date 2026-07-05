package net.minecraft.a.a;

final class C_f {
   private int a;
   private int b;
   private int c;
   private C_i d;

   private C_f(C_i var1, byte var2) {
      this.d = var1;
   }

   public final C_f a(float var1, float var2, float var3) {
      this.a = (int)(var1 / 8.0F);
      this.b = (int)(var2 / 8.0F);
      this.c = (int)(var3 / 8.0F);
      if (this.a < 0) {
         this.a = 0;
      }

      if (this.b < 0) {
         this.b = 0;
      }

      if (this.c < 0) {
         this.c = 0;
      }

      if (this.a >= this.d.a) {
         this.a = this.d.a - 1;
      }

      if (this.b >= this.d.b) {
         this.b = this.d.b - 1;
      }

      if (this.c >= this.d.c) {
         this.c = this.d.c - 1;
      }

      return this;
   }

   public final void a(net.minecraft.a.c.C_b var1) {
      if (this.a >= 0 && this.b >= 0 && this.c >= 0) {
         this.d.d[(this.c * this.d.b + this.b) * this.d.a + this.a].add(var1);
      }
   }

   public final void b(net.minecraft.a.c.C_b var1) {
      if (this.a >= 0 && this.b >= 0 && this.c >= 0) {
         this.d.d[(this.c * this.d.b + this.b) * this.d.a + this.a].remove(var1);
      }
   }

   C_f(C_i var1) {
      this(var1, (byte)0);
   }

   static int xPosition(C_f var0) {
      return var0.a;
   }

   static int yPosition(C_f var0) {
      return var0.b;
   }

   static int zPosition(C_f var0) {
      return var0.c;
   }
}
