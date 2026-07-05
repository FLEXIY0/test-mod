package net.minecraft.client.c;

import java.io.File;
import java.util.List;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.c.C_g;
import net.minecraft.client.a.c.C_i;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class C_bu extends GuiScreen {
   protected GameSettings options;
   private int amountScrolled = 0;
   private int top = 32;
   private int bottom = this.d - 55 + 4;
   private int left = 0;
   private int right = this.c;
   private int initialClickY = -2;
   private int refreshTime = -1;
   private String texturePackPath = "";

   public C_bu(GameSettings var1) {
      this.options = var1;
   }

   @Override
   public void b() {
      this.e.clear();
      this.e.add(new GuiButton(200, this.c / 2 - 75, this.d - 25, 150, 20, "Done"));
      this.e.add(new GuiButton(107, this.c / 2 - 170, this.d - 50, 60, 20, "General"));
      this.e.add(new GuiButton(106, this.c / 2 - 30, this.d - 50, 60, 20, "Audio"));
      this.e.add(new GuiButton(105, this.c / 2 - 100, this.d - 50, 60, 20, "Graphics"));
      this.e.add(new GuiButton(100, this.c / 2 + 40, this.d - 50, 60, 20, "Controls"));
      this.e.add(new GuiButton(108, this.c / 2 + 110, this.d - 50, 60, 20, "Folder"));
      this.b.texturePackList.updateAvaliableTexturePacks();
      this.texturePackPath = new File("texturepacks").getAbsolutePath();
      this.top = 32;
      this.bottom = this.d - 58 + 2;
      this.left = 0;
      this.right = this.c;
   }

   @Override
   public void a() {
      super.a();
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 288));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 320));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 352));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 384));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 548));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 552));
      this.b.m.a(new C_g(this.b, 557, -1));
      this.b.m.a(new C_g(this.b, 583, 0));
      this.b.m.a(new C_g(this.b, 590, 2));
      this.b.m.a(new C_g(this.b, 713, 4));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 681));
      this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 685));
   }

   @Override
   protected void a(GuiButton var1) {
      if (var1.c) {
         if (var1.b == 108) {
            Sys.openURL("file://" + this.texturePackPath);
         }

         if (var1.b == 100) {
            this.b.a(new C_m(this.options));
         }

         if (var1.b == 105) {
            this.b.a(new C_bv(this.options));
         }

         if (var1.b == 106) {
            this.b.a(new C_ad(this.options));
         }

         if (var1.b == 107) {
            this.b.a(new GuiOptions(this.options));
         }

         if (var1.b == 200) {
            if (this.b.d != null) {
               this.b.a(new C_b());
            } else {
               this.b.a(new GuiMainMenu());
            }
         }

         if (var1.b == 6) {
            this.b.m.b();
            if (this.b.d != null) {
               this.b.a(new C_b());
            } else {
               this.b.a(new GuiMainMenu());
            }

            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 288));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 320));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 352));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 384));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 548));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 552));
            this.b.m.a(new C_g(this.b, 557, -1));
            this.b.m.a(new C_g(this.b, 583, 0));
            this.b.m.a(new C_g(this.b, 590, 2));
            this.b.m.a(new C_g(this.b, 713, 4));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 681));
            this.b.m.a(new net.minecraft.client.a.c.C_n(this.b, 685));
         }
      }
   }

   @Override
   public void a(int var1, int var2, float var3) {
      if (this.b.d == null) {
         ScaledResolution var4;
         int var5 = (var4 = new ScaledResolution(this.b.w, this.b.b, this.b.c)).a();
         int var6 = var4.b();
         GL11.glClear(16640);
         net.minecraft.client.a.C_d var7 = net.minecraft.client.a.C_d.a;
         int var8 = this.b.m.a("/dirt.png");
         GL11.glBindTexture(3553, var8);
         float var9 = 32.0F;
         var7.b();
         var7.b(4210752);
         var7.a(0.0F, (float)var6, 0.0F, 0.0F, (float)var6 / var9);
         var7.a((float)var5, (float)var6, 0.0F, (float)var5 / var9, (float)var6 / var9);
         var7.a((float)var5, 0.0F, 0.0F, (float)var5 / var9, 0.0F);
         var7.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
         var7.a();
      } else {
         this.h();
      }

      if (this.refreshTime <= 0) {
         this.b.texturePackList.updateAvaliableTexturePacks();
         this.refreshTime += 20;
      }

      List var16 = this.b.texturePackList.availableTexturePacks();
      if (Mouse.isButtonDown(0)) {
         if (this.initialClickY == -1) {
            if (var2 >= this.top && var2 <= this.bottom) {
               int var17 = this.c / 2 - 110;
               int var19 = this.c / 2 + 110;
               int var21 = (var2 - this.top + this.amountScrolled - 2) / 36;
               if (var1 >= var17 && var1 <= var19 && var21 >= 0 && var21 < var16.size() && this.b.texturePackList.setTexturePack((C_i)var16.get(var21))) {
                  this.b.m.b();
               }

               this.initialClickY = var2;
            } else {
               this.initialClickY = -2;
            }
         } else if (this.initialClickY >= 0) {
            this.amountScrolled = this.amountScrolled - (var2 - this.initialClickY);
            this.initialClickY = var2;
         }
      } else {
         if (this.initialClickY >= 0 && this.initialClickY != var2) {
         }

         this.initialClickY = -1;
      }

      int var18 = var16.size() * 36 - (this.bottom - this.top - 4);
      if (var18 < 0) {
         var18 /= 2;
      }

      if (this.amountScrolled < 0) {
         this.amountScrolled = 0;
      }

      if (this.amountScrolled > var18) {
         this.amountScrolled = var18;
      }

      GL11.glDisable(2896);
      GL11.glDisable(2912);
      net.minecraft.client.a.C_d var20 = net.minecraft.client.a.C_d.a;
      GL11.glBindTexture(3553, this.b.m.a("/dirt.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var22 = 32.0F;
      if (this.b.d == null) {
         var20.b();
         var20.b(2105376);
         var20.a((float)this.left, (float)this.bottom, 0.0F, (float)this.left / var22, (float)(this.bottom + this.amountScrolled) / var22);
         var20.a((float)this.right, (float)this.bottom, 0.0F, (float)this.right / var22, (float)(this.bottom + this.amountScrolled) / var22);
         var20.a((float)this.right, (float)this.top, 0.0F, (float)this.right / var22, (float)(this.top + this.amountScrolled) / var22);
         var20.a((float)this.left, (float)this.top, 0.0F, (float)this.left / var22, (float)(this.top + this.amountScrolled) / var22);
         var20.a();
      }

      for (int var23 = 0; var23 < var16.size(); var23++) {
         C_i var25 = (C_i)var16.get(var23);
         int var10 = this.c / 2 - 92 - 16;
         int var11 = 36 + var23 * 36 - this.amountScrolled;
         byte var12 = 32;
         byte var13 = 32;
         if (var25 == this.b.texturePackList.selectedTexturePack) {
            int var14 = this.c / 2 - 110;
            int var15 = this.c / 2 + 110;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3553);
            var20.b();
            var20.b(8421504);
            var20.a((float)var14, (float)(var11 + var12 + 2), 0.0F, 0.0F, 1.0F);
            var20.a((float)var15, (float)(var11 + var12 + 2), 0.0F, 1.0F, 1.0F);
            var20.a((float)var15, (float)(var11 - 2), 0.0F, 1.0F, 0.0F);
            var20.a((float)var14, (float)(var11 - 2), 0.0F, 0.0F, 0.0F);
            var20.b(0);
            var20.a((float)(var14 + 1), (float)(var11 + var12 + 1), 0.0F, 0.0F, 1.0F);
            var20.a((float)(var15 - 1), (float)(var11 + var12 + 1), 0.0F, 1.0F, 1.0F);
            var20.a((float)(var15 - 1), (float)(var11 - 1), 0.0F, 1.0F, 0.0F);
            var20.a((float)(var14 + 1), (float)(var11 - 1), 0.0F, 0.0F, 0.0F);
            var20.a();
            GL11.glEnable(3553);
         }

         var25.bindThumbnailTexture(this.b);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         var20.b();
         var20.b(16777215);
         var20.a((float)var10, (float)(var11 + var12), 0.0F, 0.0F, 1.0F);
         var20.a((float)(var10 + var13), (float)(var11 + var12), 0.0F, 1.0F, 1.0F);
         var20.a((float)(var10 + var13), (float)var11, 0.0F, 1.0F, 0.0F);
         var20.a((float)var10, (float)var11, 0.0F, 0.0F, 0.0F);
         var20.a();
         b(this.g, var25.texturePackFileName, var10 + var13 + 2, var11 + 1, 16777215);
         b(this.g, var25.firstDescriptionLine, var10 + var13 + 2, var11 + 12, 8421504);
         b(this.g, var25.secondDescriptionLine, var10 + var13 + 2, var11 + 12 + 10, 8421504);
      }

      byte var24 = 4;
      this.renderBackground(0, this.top, 255, 255);
      this.renderBackground(this.bottom, this.d, 255, 255);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.left, (float)(this.top + var24));
      GL11.glVertex2f((float)this.right, (float)(this.top + var24));
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.right, (float)this.top);
      GL11.glVertex2f((float)this.left, (float)this.top);
      GL11.glEnd();
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.left, (float)this.bottom);
      GL11.glVertex2f((float)this.right, (float)this.bottom);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.right, (float)(this.bottom - var24));
      GL11.glVertex2f((float)this.left, (float)(this.bottom - var24));
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glEnable(3008);
      GL11.glDisable(3042);
      a(this.g, "Texture Packs", this.c / 2, 12, 16777215);
      super.a(var1, var2, var3);
   }

   @Override
   public void f_() {
      super.f_();
      this.refreshTime--;
   }

   public void renderBackground(int var1, int var2, int var3, int var4) {
      net.minecraft.client.a.C_d var5 = net.minecraft.client.a.C_d.a;
      GL11.glBindTexture(3553, this.b.m.a("/dirt.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var6 = 32.0F;
      var5.b();
      var5.b(4210752);
      GL11.glColor4f(0.25F, 0.25F, 0.25F, (float)var4 / 255.0F);
      var5.a(0.0F, (float)var2, 0.0F, 0.0F, (float)var2 / var6);
      var5.a((float)this.c, (float)var2, 0.0F, (float)this.c / var6, (float)var2 / var6);
      GL11.glColor4f(0.25F, 0.25F, 0.25F, (float)var3 / 255.0F);
      var5.a((float)this.c, (float)var1, 0.0F, (float)this.c / var6, (float)var1 / var6);
      var5.a(0.0F, (float)var1, 0.0F, 0.0F, (float)var1 / var6);
      var5.a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
