package net.minecraft.a.a.b;

public final class C_v extends C_ad {
   protected C_v(int var1, int var2) {
      super(var1, var2);
      this.a(0.3F, 0.0F, 0.3F, 0.7F, 0.4F, 0.7F);
   }

   @Override
   protected final boolean b(int var1) {
      return Block.e[var1];
   }

   @Override
   public final boolean e(net.minecraft.a.a.World var1, int var2, int var3, int var4) {
      if (var1.d(var2, var3, var4) <= 13) {
         var2 = var1.a(var2, var3 - 1, var4);
         if (Block.e[var2]) {
            return true;
         }
      }

      return false;
   }
}
