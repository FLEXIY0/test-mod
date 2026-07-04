package net.minecraft.client.c;

import java.util.List;
import net.minecraft.client.GameSettings;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public final class C_ad extends GuiScreen {
   private String screenTitle = "Audio";
   private GameSettings options;
   private int amountScrolled;
   private int top;
   private int bottom;
   private int left;
   private int right;
   private int initialClickY;

   public C_ad(GameSettings var1) {
      this.options = var1;
      this.amountScrolled = 0;
      this.top = 32;
      this.bottom = this.d - 55 + 4;
      this.left = 0;
      this.right = this.c;
      this.initialClickY = -2;
   }

   @Override
   public final void b() {
      this.e.clear();
      this.e.add(new C_bl(102, this.c / 2 - 100, this.d / 4, "Master", 7, 200, 20));
      this.e.add(new C_bl(102, this.c / 2 - 155, this.d / 4 + 24, "Music", 2));
      this.e.add(new C_bl(103, this.c / 2 + 5, this.d / 4 + 24, "Sound", 3));
      this.e.add(new C_bl(101, this.c / 2 - 155, this.d / 4 + 48, "Ambience", 8));
      this.e.add(new C_bl(104, this.c / 2 + 5, this.d / 4 + 48, "Mobs", 9));
      this.e.add(new C_bl(101, this.c / 2 - 155, this.d / 4 + 72, "Streaming", 10));
      this.e.add(new C_bl(104, this.c / 2 + 5, this.d / 4 + 72, "Blocks", 11));
      this.e.add(new GuiButton(105, this.c / 2 - 100, this.d - 50, 60, 20, "Graphics"));
      this.e.add(new GuiButton(100, this.c / 2 + 40, this.d - 50, 60, 20, "Controls"));
      this.e.add(new GuiButton(108, this.c / 2 + 110, this.d - 50, 60, 20, "Packs"));
      this.e.add(new GuiButton(200, this.c / 2 - 75, this.d - 25, 150, 20, "Done"));
      this.e.add(new GuiButton(107, this.c / 2 - 170, this.d - 50, 60, 20, "General"));
      this.e.add(new GuiButton(106, this.c / 2 - 30, this.d - 50, 60, 20, "Audio"));
      this.top = 32;
      this.bottom = this.d - 58 + 2;
      this.left = 0;
      this.right = this.c;
      this.e.get(this.e.size() - 1).c = false;
   }

   @Override
   protected final void a(GuiButton var1) {
      if (var1.c) {
         if (var1.b == 100) {
            this.b.a(new C_m(this.options));
         }

         if (var1.b == 107) {
            this.b.a(new GuiOptions(this.options));
         }

         if (var1.b == 105) {
            this.b.a(new C_bv(this.options));
         }

         if (var1.b == 108) {
            this.b.a(new C_bu(this.options));
         }

         if (var1.b == 200) {
            if (this.b.d != null) {
               this.b.a(new C_b());
            } else {
               this.b.a(new GuiMainMenu());
            }
         }
      }
   }

   @Override
   public void f() {
      super.f();
      if ((float)Mouse.getEventDWheel() < 0.0F) {
         this.amountScrolled = (int)((float)this.amountScrolled - (float)this.initialClickY * 10.0F);
      } else if ((float)Mouse.getEventDWheel() > 0.0F) {
         this.amountScrolled = (int)((float)this.amountScrolled + (float)this.initialClickY * 10.0F);
      }
   }

   @Override
   public final void a(int var1, int var2, float var3) {
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

      List var11 = this.e;
      if (Mouse.isButtonDown(0)) {
         if (this.initialClickY == -1) {
            if (var2 >= this.top && var2 <= this.bottom) {
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

      byte var12 = 24;
      int var13 = (var11.size() - 1) / 2 * var12 - 1;
      int var14 = var13 - (this.bottom - 6 - (this.top + 6));
      if (var14 < 0) {
         var14 /= 2;
      }

      if (this.amountScrolled < 0) {
         this.amountScrolled = 0;
      }

      if (this.amountScrolled > var14) {
         this.amountScrolled = var14;
      }

      GL11.glDisable(2896);
      GL11.glDisable(2912);
      net.minecraft.client.a.C_d var15 = net.minecraft.client.a.C_d.a;
      GL11.glBindTexture(3553, this.b.m.a("/dirt.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var16 = 32.0F;
      if (this.b.d == null) {
         var15.b();
         var15.b(2105376);
         var15.a((float)this.left, (float)this.bottom, 0.0F, (float)this.left / var16, (float)(this.bottom + this.amountScrolled) / var16);
         var15.a((float)this.right, (float)this.bottom, 0.0F, (float)this.right / var16, (float)(this.bottom + this.amountScrolled) / var16);
         var15.a((float)this.right, (float)this.top, 0.0F, (float)this.right / var16, (float)(this.top + this.amountScrolled) / var16);
         var15.a((float)this.left, (float)this.top, 0.0F, (float)this.left / var16, (float)(this.top + this.amountScrolled) / var16);
         var15.a();
      }

      this.renderBackdrop(0, this.top, 255, 255);
      this.renderBackdrop(this.bottom, this.d, 255, 255);
      super.a(var1, var2, var3);
      byte var10 = 4;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.left, (float)(this.top + var10));
      GL11.glVertex2f((float)this.right, (float)(this.top + var10));
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.right, (float)this.top);
      GL11.glVertex2f((float)this.left, (float)this.top);
      GL11.glEnd();
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.left, (float)this.bottom);
      GL11.glVertex2f((float)this.right, (float)this.bottom);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.right, (float)(this.bottom - var10));
      GL11.glVertex2f((float)this.left, (float)(this.bottom - var10));
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glEnable(3008);
      GL11.glDisable(3042);
      a(this.g, this.screenTitle, this.c / 2, 12, 16777215);
   }

   public void renderBackdrop(int var1, int var2, int var3, int var4) {
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
