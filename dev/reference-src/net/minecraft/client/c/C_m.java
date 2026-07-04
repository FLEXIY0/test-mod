package net.minecraft.client.c;

import java.util.List;
import net.minecraft.client.GameSettings;
import net.minecraft.client.d;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public final class C_m extends GuiScreen {
   private int amountScrolled;
   private int top;
   private int bottom;
   private int left;
   private int right;
   private int initialClickY;
   private String i = "Controls";
   private GameSettings j;
   private int k = -1;

   public C_m(GameSettings var1) {
      this.j = var1;
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

      for (int var1 = 0; var1 < this.j.s.length; var1++) {
         this.e.add(new GuiButton(var1, this.c / 2 - 75 + var1 % 2 * 160, 40 + 24 * (var1 >> 1), 60, 20, this.j.a(var1)));
      }

      this.e.add(new GuiButton(108, this.c / 2 + 110, this.d - 50, 60, 20, "Packs"));
      this.e.add(new GuiButton(200, this.c / 2 - 75, this.d - 25, 150, 20, "Done"));
      this.e.add(new GuiButton(107, this.c / 2 - 170, this.d - 50, 60, 20, "General"));
      this.e.add(new GuiButton(106, this.c / 2 - 30, this.d - 50, 60, 20, "Audio"));
      this.e.add(new GuiButton(105, this.c / 2 - 100, this.d - 50, 60, 20, "Graphics"));
      this.e.add(new GuiButton(100, this.c / 2 + 40, this.d - 50, 60, 20, "Controls"));
      this.top = 32;
      this.bottom = this.d - 58 + 2;
      this.left = 0;
      this.right = this.c;
      this.e.get(this.e.size() - 1).c = false;
   }

   @Override
   protected final void a(GuiButton var1) {
      for (int var2 = 0; var2 < this.j.s.length; var2++) {
         this.e.get(var2).a = this.j.a(var2);
      }

      if (var1.b == 106) {
         this.b.a(new C_ad(this.j));
      } else if (var1.b == 107) {
         this.b.a(new GuiOptions(this.j));
      } else if (var1.b == 105) {
         this.b.a(new C_bv(this.j));
      } else if (var1.b == 108) {
         this.b.a(new C_bu(this.j));
      } else if (var1.b == 200) {
         if (this.b.d != null) {
            this.b.a(new C_b());
         } else {
            this.b.a(new GuiMainMenu());
         }
      } else {
         this.k = var1.b;
         var1.a = "> " + this.j.a(var1.b) + " <";
      }
   }

   @Override
   protected final void a(char var1, int var2) {
      if (this.k >= 0) {
         this.j.a(this.k, var2);
         this.e.get(this.k).a = this.j.a(this.k);
         this.k = -1;
      } else {
         super.a(var1, var2);
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

      List var30 = this.e;
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

      byte var31 = 24;
      int var32 = (var30.size() - 1) / 2 * var31 - 1;
      int var33 = var32 - (this.bottom - 6 - (this.top + 6));
      if (var33 < 0) {
         var33 /= 2;
      }

      if (this.amountScrolled < 0) {
         this.amountScrolled = 0;
      }

      if (this.amountScrolled > var33) {
         this.amountScrolled = var33;
      }

      GL11.glDisable(2896);
      GL11.glDisable(2912);
      net.minecraft.client.a.C_d var34 = net.minecraft.client.a.C_d.a;
      GL11.glBindTexture(3553, this.b.m.a("/dirt.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var35 = 32.0F;
      if (this.b.d == null) {
         var34.b();
         var34.b(2105376);
         var34.a((float)this.left, (float)this.bottom, 0.0F, (float)this.left / var35, (float)(this.bottom + this.amountScrolled) / var35);
         var34.a((float)this.right, (float)this.bottom, 0.0F, (float)this.right / var35, (float)(this.bottom + this.amountScrolled) / var35);
         var34.a((float)this.right, (float)this.top, 0.0F, (float)this.right / var35, (float)(this.top + this.amountScrolled) / var35);
         var34.a((float)this.left, (float)this.top, 0.0F, (float)this.left / var35, (float)(this.top + this.amountScrolled) / var35);
         var34.a();
      }

      for (int var10 = 0; var10 < var30.size() - 6; var10++) {
         int var11 = this.c / 2 - 75 + var10 % 2 * 160;
         int var12 = 40 + 24 * (var10 >> 1) - this.amountScrolled;
         GuiButton var13 = this.e.get(var10);
         d var14 = this.b;
         var13.i = var12;
         if (var13.i <= this.bottom && var13.i + 20 >= this.top) {
            var13.c = true;
         } else {
            var13.c = false;
         }

         if (var13.d) {
            FontRenderer var16 = var14.n;
            GL11.glBindTexture(3553, var14.m.a("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            byte var17 = 1;
            boolean var18 = var1 >= var13.g && var12 >= var13.i && var1 < var13.g + var13.e && var12 < var13.i + var13.f;
            if (!var13.c || var13.slider) {
               var17 = 0;
            } else if (var18) {
               var17 = 2;
            }

            var13.b(var13.g, var13.i, 0, 46 + var17 * 20, var13.e / 2, var13.f);
            var13.b(var13.g + var13.e / 2, var13.i, 200 - var13.e / 2, 46 + var17 * 20, var13.e / 2, var13.f);
            var13.mouseDragged(this.b, var11, var12);
            if (var33 > 0) {
               int var19 = this.top + 6;
               int var20 = this.bottom - 6;
               int var21 = var20 - var19;
               int var22 = var21 * var21 / var32;
               if (var22 < 32) {
                  var22 = 32;
               }

               if (var22 > var21) {
                  var22 = var21;
               }

               int var23 = this.amountScrolled * (var21 - var22) / var33 + var19;
               if (var23 < var19) {
                  var23 = var19;
               }

               if (var23 > var20) {
                  var23 = var20;
               }

               int var24 = this.c - 13;
               this.b(var24, var19, 236, 0, 9, 4);
               short var25 = 248;
               int var26 = 0;

               for (int var27 = var21 - 8; var27 > 0; var27 -= var25) {
                  this.b(var24, var19 + var26 * var25 + 4, 236, 4, 9, var27 > var25 ? var25 : var27);
                  var26++;
               }

               this.b(var24, var19 + var21 - 5, 236, 252, 9, 4);
               this.b(var24, var23, 245, 0, 9, 4);
               byte var42 = 13;
               int var28 = 0;

               for (int var29 = var22 - 8; var29 > 0; var29 -= var42) {
                  this.b(var24, var23 + var28 * var42 + 4, 245, 4, 9, var29 > var42 ? var42 : var29);
                  var28++;
               }

               this.b(var24, var23 + var22 - 4, 245, 17, 9, 4);
            }

            GuiButton.drawStringAlt(var16, this.j.setKeyBindingName(var13.b), var13.g, var13.i + (var13.f - 8) / 2, 14737632);
         }
      }

      super.a(var1, var2, var3);
      byte var36 = 4;
      this.renderBackdrop(0, this.top, 255, 255);
      this.renderBackdrop(this.bottom, this.d, 255, 255);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glShadeModel(7425);
      GL11.glDisable(3553);
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.left, (float)(this.top + var36));
      GL11.glVertex2f((float)this.right, (float)(this.top + var36));
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.right, (float)this.top);
      GL11.glVertex2f((float)this.left, (float)this.top);
      GL11.glEnd();
      GL11.glBegin(7);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glVertex2f((float)this.left, (float)this.bottom);
      GL11.glVertex2f((float)this.right, (float)this.bottom);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glVertex2f((float)this.right, (float)(this.bottom - var36));
      GL11.glVertex2f((float)this.left, (float)(this.bottom - var36));
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glShadeModel(7424);
      GL11.glEnable(3008);
      GL11.glDisable(3042);
      a(this.g, this.i, this.c / 2, 12, 16777215);

      for (int var37 = this.j.s.length; var37 <= this.e.size() - 1; var37++) {
         GuiButton var38 = this.e.get(var37);
         d var39 = this.b;
         if (var38.d) {
            FontRenderer var15 = var39.n;
            GL11.glBindTexture(3553, var39.m.a("/gui/gui.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            byte var40 = 1;
            boolean var41 = var1 >= var38.g && var2 >= var38.i && var1 < var38.g + var38.e && var2 < var38.i + var38.f;
            if (!var38.c || var38.slider) {
               var40 = 0;
            } else if (var41) {
               var40 = 2;
            }

            var38.b(var38.g, var38.i, 0, 46 + var40 * 20, var38.e / 2, var38.f);
            var38.b(var38.g + var38.e / 2, var38.i, 200 - var38.e / 2, 46 + var40 * 20, var38.e / 2, var38.f);
            if (!var38.c) {
               GuiButton.a(var15, var38.a, var38.g + var38.e / 2, var38.i + (var38.f - 8) / 2, -6250336);
            } else if (var41) {
               GuiButton.a(var15, var38.a, var38.g + var38.e / 2, var38.i + (var38.f - 8) / 2, 16777120);
            } else {
               GuiButton.a(var15, var38.a, var38.g + var38.e / 2, var38.i + (var38.f - 8) / 2, 14737632);
            }
         }
      }
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
