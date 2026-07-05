package net.minecraft.client.a;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.GameSettings;
import net.minecraft.client.d;
import net.minecraft.client.c.ScaledResolution;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import util.MathHelper;

public final class C_e {
   private d b;
   private boolean c = false;
   private float d = 0.0F;
   private int e;
   public C_g a;
   private net.minecraft.a.c.C_b f = null;
   private DecimalFormat i = new DecimalFormat("0000");
   private ByteBuffer j;
   private FloatBuffer k = BufferUtils.createFloatBuffer(16);
   private FloatBuffer o = BufferUtils.createFloatBuffer(16);
   private float p;
   private float q;
   private float r;
   private float s;
   private float t;
   private int rainSoundCounter = 0;
   private int windSoundCounter = 0;
   private Random l = new Random();
   private float soundVolume = 0.3F;
   private float fovModifierHand;
   private float fovModifierHandPrev;

   public C_e(d var1) {
      this.b = var1;
      this.a = new C_g(var1);
   }

   public final void a() {
      this.updateFovModifierHand();
      this.s = this.t;
      float var1 = this.b.d.c((int)this.b.f.h, (int)this.b.f.i, (int)this.b.f.j);
      float var2 = (float)(3 - this.b.w.e) / 3.0F;
      var1 = var1 * (1.0F - var2) + var2;
      this.t = this.t + (var1 - this.t) * 0.1F;
      this.a.a();
      this.e++;
      this.addRainParticles();
      if (this.b.d.theme != 1 && this.b.d.type != 5 && this.b.d.type != 8) {
         this.playWindSound();
         this.playRandomAmbience();
      }
   }

   private net.minecraft.a.d.C_a b(float var1) {
      net.minecraft.client.g.C_a var2 = this.b.f;
      float var3 = this.b.f.e + (var2.h - var2.e) * var1;
      float var4 = var2.f + (var2.i - var2.f) * var1;
      var1 = var2.g + (var2.j - var2.g) * var1;
      return new net.minecraft.a.d.C_a(var3, var4, var1);
   }

   private void c(float var1) {
      net.minecraft.client.g.C_a var2 = this.b.f;
      float var3 = (float)this.b.f.Y - var1;
      if (var2.W <= 0) {
         var1 += (float)var2.ab;
         GL11.glRotatef(40.0F - 8000.0F / (var1 + 200.0F), 0.0F, 0.0F, 1.0F);
      }

      if (var3 >= 0.0F) {
         float var6;
         var3 = MathHelper.a((var6 = var3 / (float)var2.Z) * var6 * var6 * var6 * (float) Math.PI);
         var1 = var2.aa;
         GL11.glRotatef(-var2.aa, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(var1, 0.0F, 1.0F, 0.0F);
      }
   }

   private void d(float var1) {
      net.minecraft.client.g.C_a var2 = this.b.f;
      float var3 = this.b.f.z - var2.y;
      var3 = var2.z + var3 * var1;
      float var4 = var2.Q + (var2.R - var2.Q) * var1;
      var1 = var2.ad + (var2.ae - var2.ad) * var1;
      GL11.glTranslatef(MathHelper.a(var3 * (float) Math.PI) * var4 * 0.5F, -Math.abs(MathHelper.b(var3 * (float) Math.PI) * var4), 0.0F);
      GL11.glRotatef(MathHelper.a(var3 * (float) Math.PI) * var4 * 3.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(Math.abs(MathHelper.b(var3 * (float) Math.PI + 0.2F) * var4) * 5.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(var1, 1.0F, 0.0F, 0.0F);
   }

   public final void a(float var1) {
      if (this.c && !Display.isActive()) {
         this.b.c();
      }

      this.c = Display.isActive();
      if (this.b.C) {
         this.b.y.b();
         byte var6 = 1;
         if (this.b.w.c) {
            var6 = -1;
         }

         float var7 = this.b.w.sensitivity * 0.3F + 0.2F;
         float var8 = var7 * var7 * var7 * 8.0F;
         float var4 = (float)this.b.y.a * var8;
         float var5 = (float)this.b.y.b * var8;
         float var10 = var5 * (float)var6;
         net.minecraft.client.g.C_a var12 = this.b.f;
         float var13 = this.b.f.o;
         float var14 = var12.n;
         var12.n = (float)((double)var12.n + (double)var4 * 0.15);
         var12.o = (float)((double)var12.o + (double)var10 * 0.15);
         if (var12.o < -90.0F) {
            var12.o = -90.0F;
         }

         if (var12.o > 90.0F) {
            var12.o = 90.0F;
         }

         var12.q = var12.q + (var12.o - var13);
         var12.p = var12.p + (var12.n - var14);
      }

      ScaledResolution var15;
      int var16 = (var15 = new ScaledResolution(this.b.w, this.b.b, this.b.c)).a();
      int var17 = var15.b();
      int var2 = Mouse.getX() * var16 / this.b.b;
      int var3 = var17 - Mouse.getY() * var17 / this.b.c - 1;
      if (this.b.d != null) {
         this.e(var1);
         this.b.t.a(var1);
      } else {
         GL11.glViewport(0, 0, this.b.b, this.b.c);
         GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
         GL11.glClear(16640);
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         this.c();
      }

      if (this.b.o != null) {
         GL11.glClear(256);
         this.b.o.a(var2, var3, var1);
      }
   }

   private void addRainParticles() {
      float var1 = this.b.d.getRainStatus(1.0F);
      if (!GameSettings.f) {
         var1 /= 2.0F;
      }

      if (var1 != 0.0F) {
         this.l.setSeed((long)this.e * 312987231L);
         net.minecraft.a.c.C_e var2 = this.b.cameraMob;
         net.minecraft.a.a.C_g var3 = this.b.d;
         int var4 = MathHelper.a((double)var2.h);
         int var5 = MathHelper.a((double)var2.i);
         int var6 = MathHelper.a((double)var2.j);
         byte var7 = 10;
         double var8 = 0.0;
         double var10 = 0.0;
         double var12 = 0.0;
         int var14 = 0;

         for (int var15 = 0; var15 < (int)(100.0F * var1 * var1); var15++) {
            int var16 = var4 + this.l.nextInt(var7) - this.l.nextInt(var7);
            int var17 = var6 + this.l.nextInt(var7) - this.l.nextInt(var7);
            int var18 = var3.a(var16, var17);
            int var19 = var3.a(var16, var18 - 1, var17);
            if (var18 <= var5 + var7 && var18 >= var5 - var7 && var3.season.currentSeason != 3 && var3.type != 4) {
               float var20 = this.l.nextFloat();
               float var21 = this.l.nextFloat();
               if (var19 > 0) {
                  if (C_x.c[var19].getMaterial(0) == net.minecraft.a.a.d.C_c.g) {
                     this.b.g.a(new net.minecraft.client.f.C_j(var3, (float)var16 + var20, (float)var18 + 0.1F - C_x.c[var19].av, (float)var17 + var21));
                  } else {
                     if (this.l.nextInt(++var14) == 0) {
                        var8 = (double)((float)var16 + var20);
                        var10 = (double)((float)var18 + 0.1F) - (double)C_x.c[var19].av;
                        var12 = (double)((float)var17 + var21);
                     }

                     this.b.g.a(new net.minecraft.client.f.C_i(var3, (float)var16 + var20, (float)var18 + 0.1F - C_x.c[var19].av, (float)var17 + var21));
                  }
               }
            }
         }

         if (var14 > 0 && this.l.nextInt(3) < this.rainSoundCounter++) {
            this.rainSoundCounter = 0;
            if (var10 > (double)var2.i + 1.0 && var3.a(MathHelper.a((double)var2.h), MathHelper.a((double)var2.j)) > MathHelper.a((double)var2.i)) {
               this.b.d.a((float)var8, (float)var10, (float)var12, "loops.waterfall", 0.01F * this.b.w.ambienceVol * this.b.w.masterVol, 0.5F);
            } else {
               this.b.d.a((float)var8, (float)var10, (float)var12, "loops.waterfall", 0.05F * this.b.w.ambienceVol * this.b.w.masterVol, 1.0F);
            }
         }
      }
   }

   private void playWindSound() {
      this.l.setSeed((long)this.e * 312987231L);
      net.minecraft.a.c.C_e var1 = this.b.cameraMob;
      net.minecraft.a.a.C_g var2 = this.b.d;
      if (this.l.nextInt(250) < this.windSoundCounter++ && var2.season.currentSeason == 2 && var2.getWindForce() >= 0.2F && var2.type != 5 && var2.type != 8) {
         this.windSoundCounter = 0;
         double var3 = (double)MathHelper.a((double)var1.h);
         double var5 = (double)MathHelper.a((double)var1.i);
         double var7 = (double)MathHelper.a((double)var1.j);
         String var9 = "loops.treewind";
         float var10 = 0.1F;
         if (var2.getRaining()) {
            var9 = "loops.wind_hit";
            var10 = 0.3F;
         }

         if (var2.l((int)var3, (int)var5, (int)var7)) {
            this.b.x.playAmbience(var9, var10, 1.0F);
         }
      }
   }

   public void playRandomAmbience() {
      this.l.setSeed((long)this.e * 312987231L);
      net.minecraft.a.a.C_g var1 = this.b.d;
      if (var1.season.seasonProgress >= 0.3F && var1.season.seasonProgress <= 0.7F && var1.season.currentSeason < 2) {
         String var2 = null;
         this.b.x.a.setVolume("ambience", this.soundVolume * this.b.w.ambienceVol * this.b.w.masterVol);
         if (var1.season.currentSeason == 1 && var1.type != 8 && var1.type != 5 && var1.theme != 1) {
            if (var1.a(this.b.G.c) > 0.0F && !var1.getRaining()) {
               var2 = "loops.crickets chirping";
               this.soundVolume += 0.01F;
               if (this.soundVolume > 2.0F) {
                  this.soundVolume = 2.0F;
               }
            } else {
               var2 = null;
               this.soundVolume -= 0.01F;
               if (this.soundVolume < 0.0F) {
                  this.soundVolume = 0.0F;
                  this.b.x.a.stop("ambience");
               }
            }
         } else if (var1.season.currentSeason == 0 && var1.type != 8 && var1.type != 5 && var1.theme != 1) {
            if (var1.D < 12000 && !var1.getRaining()) {
               var2 = "loops.birds screaming loop";
               this.soundVolume += 0.01F;
               if (this.soundVolume > 0.1F) {
                  this.soundVolume = 0.1F;
               }
            } else {
               var2 = null;
               this.soundVolume -= 0.01F;
               if (this.soundVolume < 0.0F) {
                  this.soundVolume = 0.0F;
                  this.b.x.a.stop("ambience");
               }
            }
         }

         if (!this.b.x.a.playing("ambience") && var2 != null) {
            this.b.x.playAllocatedAmbience(var2, this.soundVolume, 1.0F, true);
         }

         this.b
            .x
            .a
            .setVolume(
               "ambience",
               this.soundVolume
                  * (float)(
                     (double)this.b
                           .d
                           .getSavedLightValue(
                              net.minecraft.a.a.C_l.Sky, MathHelper.a((double)this.b.f.h), MathHelper.a((double)this.b.f.i), MathHelper.a((double)this.b.f.j)
                           )
                        / 15.0
                  )
                  * this.b.w.ambienceVol
                  * this.b.w.masterVol
            );
      }
   }

   protected void renderRainSnow(float var1) {
      float var2 = this.b.d.getRainStatus(var1);
      if (var2 > 0.0F) {
         net.minecraft.a.c.C_e var3 = this.b.cameraMob;
         net.minecraft.a.a.C_g var4 = this.b.d;
         int var5 = MathHelper.a((double)var3.h);
         int var6 = MathHelper.a((double)var3.i);
         int var7 = MathHelper.a((double)var3.j);
         C_d var8 = C_d.a;
         GL11.glDisable(2884);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.01F);
         if (var4.theme == 1 && var4.type != 4) {
            GL11.glBindTexture(3553, this.b.m.a("/environment/ashfall.png"));
         } else if (var4.type == 4) {
            GL11.glBindTexture(3553, this.b.m.a("/environment/sandstorm.png"));
         } else {
            GL11.glBindTexture(3553, this.b.m.a("/environment/snow.png"));
         }

         float var9 = var3.C + (var3.i - var3.C) * var1;
         int var10 = MathHelper.a((double)var9);
         byte var11 = 5;
         if (GameSettings.f) {
            var11 = 10;
         }

         for (int var12 = var5 - var11; var12 <= var5 + var11; var12++) {
            for (int var13 = var7 - var11; var13 <= var7 + var11; var13++) {
               if (var4.season.currentSeason == 3 || var4.type == 4) {
                  int var14 = var4.a(var12, var13);
                  if (var14 < 0) {
                     var14 = 0;
                  }

                  int var15 = var14;
                  if (var14 < var10) {
                     var15 = var10;
                  }

                  int var16 = var6 - var11;
                  int var18 = var6 + var11;
                  if (var16 < var14) {
                     var16 = var14;
                  }

                  if (var18 < var14) {
                     var18 = var14;
                  }

                  float var17 = 1.0F;
                  if (var16 != var18) {
                     this.l.setSeed((long)(var12 * var12 * 3121 + var12 * 45238971 + var13 * var13 * 418711 + var13 * 13761));
                     float var19 = 0.01F;
                     float var20 = 0.001F;
                     if (var4.type == 4 || var4.getThundering()) {
                        var19 = 0.1F;
                        var20 = 0.01F;
                     }

                     float var21 = (float)this.e + var1;
                     float var22 = ((float)(this.e & 511) + var1) / 512.0F;
                     float var23 = this.l.nextFloat() + var21 * var19 * (float)this.l.nextGaussian();
                     float var24 = this.l.nextFloat() + var21 * (float)this.l.nextGaussian() * var20;
                     float var25 = (float)var12 + 0.5F - var3.h;
                     float var26 = (float)var13 + 0.5F - var3.j;
                     float var27 = MathHelper.c(var25 * var25 + var26 * var26) / (float)var11;
                     var8.b();
                     float var28 = var4.c(var12, var15, var13);
                     GL11.glColor4f(var28, var28, var28, ((1.0F - var27 * var27) * 0.3F + 0.5F) * var2);
                     var8.a((float)(var12 + 0), (float)var16, (float)var13 + 0.5F, 0.0F * var17 + var23, (float)var16 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)(var12 + 1), (float)var16, (float)var13 + 0.5F, 1.0F * var17 + var23, (float)var16 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)(var12 + 1), (float)var18, (float)var13 + 0.5F, 1.0F * var17 + var23, (float)var18 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)(var12 + 0), (float)var18, (float)var13 + 0.5F, 0.0F * var17 + var23, (float)var18 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)var12 + 0.5F, (float)var16, (float)(var13 + 0), 0.0F * var17 + var23, (float)var16 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)var12 + 0.5F, (float)var16, (float)(var13 + 1), 1.0F * var17 + var23, (float)var16 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)var12 + 0.5F, (float)var18, (float)(var13 + 1), 1.0F * var17 + var23, (float)var18 * var17 / 4.0F + var22 * var17 + var24);
                     var8.a((float)var12 + 0.5F, (float)var18, (float)(var13 + 0), 0.0F * var17 + var23, (float)var18 * var17 / 4.0F + var22 * var17 + var24);
                     var8.addTranslation(0.0F, 0.0F, 0.0F);
                     var8.a();
                  }
               }
            }
         }

         if (var4.theme == 1) {
            GL11.glBindTexture(3553, this.b.m.a("/environment/blood.png"));
         } else if (var4.theme == 4) {
            GL11.glBindTexture(3553, this.b.m.a("/environment/poison.png"));
         } else {
            GL11.glBindTexture(3553, this.b.m.a("/environment/rain.png"));
         }

         if (GameSettings.f) {
            var11 = 10;
         }

         for (int var29 = var5 - var11; var29 <= var5 + var11; var29++) {
            for (int var30 = var7 - var11; var30 <= var7 + var11; var30++) {
               if (var4.season.currentSeason != 3 && var4.type != 4) {
                  int var31 = var4.a(var29, var30);
                  int var32 = var6 - var11;
                  int var33 = var6 + var11;
                  if (var32 < var31) {
                     var32 = var31;
                  }

                  if (var33 < var31) {
                     var33 = var31;
                  }

                  float var35 = 1.0F;
                  if (var32 != var33) {
                     this.l.setSeed((long)(var29 * var29 * 3121 + var29 * 45238971 + var30 * var30 * 418711 + var30 * 13761));
                     float var34 = ((float)(this.e + var29 * var29 * 3121 + var29 * 45238971 + var30 * var30 * 418711 + var30 * 13761 & 31) + var1)
                        / 32.0F
                        * (3.0F + this.l.nextFloat());
                     float var36 = (float)var29 + 0.5F - var3.h;
                     float var37 = (float)var30 + 0.5F - var3.j;
                     float var38 = MathHelper.c(var36 * var36 + var37 * var37) / (float)var11;
                     var8.b();
                     float var39 = var4.c(var29, 128, var30) * 0.85F + 0.15F;
                     GL11.glColor4f(var39, var39, var39, ((1.0F - var38 * var38) * 0.5F + 0.5F) * var2);
                     var8.a((float)(var29 + 0), (float)var32, (float)var30 + 0.5F, 0.0F * var35, (float)var32 * var35 / 4.0F + var34 * var35);
                     var8.a((float)(var29 + 1), (float)var32, (float)var30 + 0.5F, 1.0F * var35, (float)var32 * var35 / 4.0F + var34 * var35);
                     var8.a((float)(var29 + 1), (float)var33, (float)var30 + 0.5F, 1.0F * var35, (float)var33 * var35 / 4.0F + var34 * var35);
                     var8.a((float)(var29 + 0), (float)var33, (float)var30 + 0.5F, 0.0F * var35, (float)var33 * var35 / 4.0F + var34 * var35);
                     var8.a((float)var29 + 0.5F, (float)var32, (float)(var30 + 0), 0.0F * var35, (float)var32 * var35 / 4.0F + var34 * var35);
                     var8.a((float)var29 + 0.5F, (float)var32, (float)(var30 + 1), 1.0F * var35, (float)var32 * var35 / 4.0F + var34 * var35);
                     var8.a((float)var29 + 0.5F, (float)var33, (float)(var30 + 1), 1.0F * var35, (float)var33 * var35 / 4.0F + var34 * var35);
                     var8.a((float)var29 + 0.5F, (float)var33, (float)(var30 + 0), 0.0F * var35, (float)var33 * var35 / 4.0F + var34 * var35);
                     var8.addTranslation(0.0F, 0.0F, 0.0F);
                     var8.a();
                  }
               }
            }
         }

         GL11.glEnable(2884);
         GL11.glDisable(3042);
         GL11.glAlphaFunc(516, 0.1F);
      }
   }

   public final void b() {
      this.b.p.a("Grabbing large screenshot");
      File var1 = new File(this.b.z, "screenshots");
      var1.mkdir();
      int var2 = 0;

      File var3;
      while ((var3 = new File(var1, "mc_map_" + this.i.format((long)var2) + ".png")).exists()) {
         var2++;
      }

      var3 = var3.getAbsoluteFile();
      this.b.p.b("Rendering");
      this.b.p.a(0);

      try {
         int var4 = (this.b.d.a << 4) + (this.b.d.b << 4);
         var2 = (this.b.d.c << 4) + var4 / 2;
         BufferedImage var5;
         Graphics var6 = (var5 = new BufferedImage(var4, var2, 1)).getGraphics();
         int var7 = this.b.b;
         int var8 = this.b.c;
         int var9 = (var4 / var7 + 1) * (var2 / var8 + 1);
         int var10 = 0;

         for (int var11 = 0; var11 < var4; var11 += var7) {
            for (int var12 = 0; var12 < var2; var12 += var8) {
               var10++;
               this.b.p.a(var10 * 100 / var9);
               int var13 = var11 - var4 / 2;
               int var14 = var12 - var2 / 2;
               if (this.j == null) {
                  this.j = BufferUtils.createByteBuffer(this.b.b * this.b.c << 2);
               }

               net.minecraft.client.g.C_a var17 = this.b.f;
               net.minecraft.a.a.C_g var18 = this.b.d;
               C_b var19 = this.b.e;
               GL11.glViewport(0, 0, this.b.b, this.b.c);
               this.f(0.0F);
               GL11.glClear(16640);
               GL11.glEnable(2884);
               this.d = (float)(512 >> (this.b.w.e << 1));
               GL11.glMatrixMode(5889);
               GL11.glLoadIdentity();
               GL11.glOrtho(0.0, (double)this.b.b, 0.0, (double)this.b.c, 10.0, 10000.0);
               GL11.glMatrixMode(5888);
               GL11.glLoadIdentity();
               GL11.glTranslatef((float)(-var13), (float)(-var14), -5000.0F);
               GL11.glScalef(16.0F, -16.0F, -16.0F);
               ((Buffer)this.k).clear();
               this.k.put(1.0F).put(-0.5F).put(0.0F).put(0.0F);
               this.k.put(0.0F).put(1.0F).put(-1.0F).put(0.0F);
               this.k.put(1.0F).put(0.5F).put(0.0F).put(0.0F);
               this.k.put(0.0F).put(0.0F).put(0.0F).put(1.0F);
               ((Buffer)this.k).flip();
               GL11.glMultMatrix(this.k);
               GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef((float)(-var18.a) / 2.0F, (float)(-var18.c) / 2.0F, (float)(-var18.b) / 2.0F);
               net.minecraft.client.a.b.C_d var20 = new net.minecraft.client.a.b.C_d();
               this.b.e.a(var20);
               this.b.e.a((EntityPlayer)var17);
               this.d();
               GL11.glEnable(2912);
               GL11.glFogi(2917, 9729);
               float var21 = (float)var18.c * 8.0F;
               GL11.glFogf(2915, 5000.0F - var21);
               GL11.glFogf(2916, 5000.0F + var21 * 8.0F);
               net.minecraft.client.C_c.b();
               var19.a(this.b(0.0F), var20, 0.0F);
               net.minecraft.client.C_c.a();
               GL11.glBindTexture(3553, this.b.m.a("/terrain.png"));
               var19.a(var17, 0);
               var19.f();
               if (var18.u < var18.c) {
                  var19.a(0.0F);
               }

               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               GL11.glColorMask(false, false, false, false);
               int var16 = var19.a(var17, 1);
               GL11.glColorMask(true, true, true, true);
               if (var16 > 0) {
                  var19.d();
               }

               if (var18.g() >= 0) {
                  var19.g();
               }

               GL11.glDepthMask(true);
               GL11.glDisable(3042);
               GL11.glDisable(2912);
               ((Buffer)this.j).clear();
               GL11.glPixelStorei(3333, 1);
               GL11.glReadPixels(0, 0, this.b.b, this.b.c, 6407, 5121, this.j);
               BufferedImage var22 = a(this.j, var7, var8);
               var6.drawImage(var22, var11, var12, (ImageObserver)null);
            }
         }

         var6.dispose();
         this.b.p.b("Saving as " + var3.toString());
         this.b.p.a(100);
         FileOutputStream var26 = new FileOutputStream(var3);
         ImageIO.write(var5, "png", var26);
         var26.close();
      } catch (Throwable var23) {
         var23.printStackTrace();
      }
   }

   private static BufferedImage a(ByteBuffer var0, int var1, int var2) {
      ((Buffer)var0).position(0).limit(var1 * var2 << 2);
      BufferedImage var3;
      int[] var4 = ((DataBufferInt)(var3 = new BufferedImage(var1, var2, 1)).getRaster().getDataBuffer()).getData();

      for (int var5 = 0; var5 < var1 * var2; var5++) {
         int var6 = var0.get(var5 * 3) & 255;
         int var7 = var0.get(var5 * 3 + 1) & 255;
         int var8 = var0.get(var5 * 3 + 2) & 255;
         var4[var5] = var6 << 16 | var7 << 8 | var8;
      }

      return var3;
   }

   private void e(float var1) {
      C_e var2 = this;
      net.minecraft.a.c.C_e var3 = this.b.cameraMob;
      float var4 = this.b.cameraMob.q + (var3.o - var3.q) * var1;
      float var5 = var3.p + (var3.n - var3.p) * var1;
      net.minecraft.a.d.C_a var6 = this.b(var1);
      float var7 = MathHelper.b(-var5 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var8 = MathHelper.a(-var5 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var9 = -MathHelper.b(-var4 * (float) (Math.PI / 180.0));
      float var10 = MathHelper.a(-var4 * (float) (Math.PI / 180.0));
      float var11 = var8 * var9;
      float var12 = var7 * var9;
      float var13 = this.b.a.b();
      float var14 = var13 - 1.0F;
      if (var3 instanceof net.minecraft.client.g.C_a) {
         if (((net.minecraft.client.g.C_a)var3).b.a[((net.minecraft.client.g.C_a)var3).b.c] != null
            && ((net.minecraft.client.g.C_a)var3).b.a[((net.minecraft.client.g.C_a)var3).b.c].a() instanceof C_bm) {
            var14++;
         }

         if (((net.minecraft.client.g.C_a)var3).b.charmSlot[0] != null && ((net.minecraft.client.g.C_a)var3).b.charmSlot[0].a() == Item.bracelet) {
            var13 += 2.0F;
         }
      }

      net.minecraft.a.d.C_a var15 = var6.a(var11 * var13, var10 * var13, var12 * var13);
      this.b.v = this.b.d.a(var6, var15);
      float var16 = var13;
      var6 = this.b(var1);
      if (this.b.v != null) {
         var16 = this.b.v.f.b(var6);
      }

      if (var16 > var14) {
         var16 = var14;
      }

      var15 = var6.a(var11 * var16, var10 * var16, var12 * var16);
      this.f = null;
      List var17 = this.b.d.r.a(var3, var3.r.a(var11 * var16, var10 * var16, var12 * var16));
      float var18 = 0.0F;

      for (int var19 = 0; var19 < var17.size(); var19++) {
         net.minecraft.a.c.C_b var20 = (net.minecraft.a.c.C_b)var17.get(var19);
         net.minecraft.a.d.C_c var21;
         if ((var20.d() || var20 instanceof net.minecraft.a.c.C_a)
            && (var21 = var20.r.b(0.1F, 0.1F, 0.1F).a(var6, var15)) != null
            && ((var4 = var6.b(var21.f)) < var18 || var18 == 0.0F)) {
            var2.f = var20;
            var18 = var4;
         }
      }

      if (var2.f != null) {
         var2.b.v = new net.minecraft.a.d.C_c(var2.f);
      }

      net.minecraft.client.g.C_a var52 = this.b.f;
      net.minecraft.a.a.C_g var53 = this.b.d;
      C_b var54 = this.b.e;
      net.minecraft.client.f.C_d var22 = this.b.g;
      GL11.glViewport(0, 0, this.b.b, this.b.c);
      this.f(var1);
      GL11.glClear(16640);
      GL11.glEnable(2884);
      GL11.glEnable(2929);
      float var23 = var1;
      this.d = this.b.d.getFogDistance();
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      net.minecraft.a.c.C_e var24 = this.b.cameraMob;
      var8 = this.getFOV(var1, true);
      GLU.gluPerspective(var8, (float)this.b.b / (float)this.b.c, 0.05F, this.d);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      this.c(var1);
      if (this.b.w.viewBobbing) {
         this.d(var1);
      }

      float var25 = this.b.f.prevTimeInPortal + (this.b.f.timeInPortal - this.b.f.prevTimeInPortal) * var1;
      if (var25 > 0.0F) {
         float var26 = 5.0F / (var25 * var25 + 5.0F) - var25 * 0.04F;
         var26 *= var26;
         float var27 = 20.0F;
         GL11.glRotatef(((float)this.e + var1) * var27, 0.0F, 1.0F, 1.0F);
         GL11.glScalef(1.0F / var26, 1.0F, 1.0F);
         GL11.glRotatef(-((float)this.e + var1) * var27, 0.0F, 1.0F, 1.0F);
      }

      C_e var58 = this;
      float var59 = var24.h - var24.e;
      var24 = this.b.cameraMob;
      var8 = this.b.cameraMob.e + var59 * var1;
      var9 = var24.f + (var24.i - var24.f) * var1;
      var10 = var24.g + (var24.j - var24.g) * var1;
      if (this.b.w.thirdPersonView == 0) {
         if (!this.b.w.showArm) {
            float var28 = -0.2F;
            float var29 = var24.isSneaking == 2 ? 0.1F : -0.0F;
            net.minecraft.a.d.C_a var30 = new net.minecraft.a.d.C_a(var8, var9 + var24.n() - var28, var10);
            net.minecraft.a.d.C_a var31 = var30.a(0.0F, var28, var29);
            net.minecraft.a.d.C_c var32 = this.b.d.a(var30, var31);
            float var33 = var28;
            if (var32 != null) {
               double var34 = (double)var32.f.b(var30) - 0.05;
               net.minecraft.a.d.C_a var36 = var31.a(var30).a();
               var33 = (float)((double)var36.b * var34);
            }

            if (var24.isSneaking == 2) {
               var33 = 0.0F;
            }

            GL11.glTranslatef(0.0F, var33, var29);
         } else {
            GL11.glTranslatef(0.0F, 0.0F, -0.1F);
         }
      } else {
         var11 = 4.0F;
         float var60 = var24.n;
         float var62 = var24.o;
         if (this.b.w.thirdPersonView == 2) {
            var62 += 180.0F;
         }

         float var64 = -MathHelper.a(var60 / 180.0F * (float) Math.PI) * MathHelper.b(var62 / 180.0F * (float) Math.PI) * 4.0F;
         var12 = MathHelper.b(var60 / 180.0F * (float) Math.PI) * MathHelper.b(var62 / 180.0F * (float) Math.PI) * 4.0F;
         var13 = -MathHelper.a(var62 / 180.0F * (float) Math.PI) * 4.0F;

         for (int var67 = 0; var67 < 8; var67++) {
            var16 = (float)(((var67 & 1) << 1) - 1);
            var23 = (float)(((var67 >> 1 & 1) << 1) - 1);
            var18 = (float)(((var67 >> 2 & 1) << 1) - 1);
            var16 *= 0.1F;
            var23 *= 0.1F;
            var18 *= 0.1F;
            float var70;
            net.minecraft.a.d.C_c var72;
            if ((
                     var72 = var58.b
                        .d
                        .a(
                           new net.minecraft.a.d.C_a(var8 + var16, var9 + var23, var10 + var18),
                           new net.minecraft.a.d.C_a(var8 - var64 + var16 + var18, var9 - var13 + var23, var10 - var12 + var18)
                        )
                  )
                  != null
               && (var70 = var72.f.b(new net.minecraft.a.d.C_a(var8, var9, var10))) < var11) {
               var11 = var70;
            }
         }

         if (this.b.w.thirdPersonView == 2) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         GL11.glRotatef(var24.o - var62, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var24.n - var60, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, 0.0F, -var11);
         GL11.glRotatef(var60 - var24.n, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(var62 - var24.o, 1.0F, 0.0F, 0.0F);
      }

      float var61 = 1.0F;
      if (this.b.w.thirdPersonView == 1) {
         var61 = -2.0F;
      } else if (this.b.w.thirdPersonView == 2) {
         var61 = 2.0F;
      }

      if (var24 instanceof net.minecraft.a.c.b.C_a || var24 instanceof net.minecraft.a.c.a.C_b || var24 instanceof net.minecraft.a.c.a.C_g) {
         GL11.glTranslatef(0.0F, -1.2F, var61);
      }

      if (var24 instanceof net.minecraft.a.c.a.C_e && !(var24 instanceof net.minecraft.a.c.a.C_b) && !(var24 instanceof net.minecraft.a.c.a.C_g)) {
         GL11.glTranslatef(0.0F, -1.78F, var61);
      }

      GL11.glRotatef(var24.q + (var24.o - var24.q) * var23, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(var24.p + (var24.n - var24.p) * var23 + 180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(-var8, -var9, -var10);
      net.minecraft.client.a.b.C_a.a();
      this.d();
      GL11.glEnable(2912);
      var54.a(var1);
      this.d();
      net.minecraft.client.a.b.C_c var63 = new net.minecraft.client.a.b.C_c();
      this.b.e.a(var63);
      this.b.e.a((EntityPlayer)var52);
      this.d();
      GL11.glEnable(2912);
      GL11.glBindTexture(3553, this.b.m.a("/terrain.png"));
      net.minecraft.client.C_c.a();
      var54.a(var52, 0);
      if (var53.a(var52.h, var52.i, var52.j, 0.1F)) {
         int var65 = (int)var52.h;
         int var68 = (int)var52.i;
         int var71 = (int)var52.j;
         C_f var73 = new C_f(var53);

         for (int var74 = var65 - 1; var74 <= var65 + 1; var74++) {
            for (int var35 = var68 - 1; var35 <= var68 + 1; var35++) {
               for (int var75 = var71 - 1; var75 <= var71 + 1; var75++) {
                  int var37;
                  if ((var37 = var53.a(var74, var35, var75)) > 0) {
                     var73.a(C_x.c[var37], var74, var35, var75);
                  }
               }
            }
         }
      }

      net.minecraft.client.C_c.b();
      var54.a(this.b(var1), var63, var1);
      var22.renderLitParticles(var52, var1);
      net.minecraft.client.C_c.a();
      this.d();
      var22.a(var52, var1);
      var54.f();
      if (this.b.f.gamemode != 2 && this.b.v != null && var52.m() && this.b.w.showHUD) {
         GL11.glDisable(3008);
         var54.a(this.b.v, 0, var52.b.d());
         var54.a(this.b.v, 0);
         GL11.glEnable(3008);
      }

      GL11.glBlendFunc(770, 771);
      this.d();
      var54.g();
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glColorMask(false, false, false, false);
      int var66 = var54.a(var52, 1);
      GL11.glColorMask(true, true, true, true);
      if (var66 > 0) {
         var54.d();
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
      if (this.b.f.gamemode != 2 && this.b.v != null && !var52.m() && this.b.w.showHUD) {
         GL11.glDisable(3008);
         var54.a(this.b.v, 0, var52.b.d());
         var54.a(this.b.v, 0);
         GL11.glEnable(3008);
      }

      this.renderRainSnow(var1);
      GL11.glDisable(2912);
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      float var69 = this.getFOV(var1, false);
      GLU.gluPerspective(var69, (float)this.b.b / (float)this.b.c, 0.05F, this.d);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glPushMatrix();
      this.c(var1);
      if (this.b.w.viewBobbing) {
         this.d(var1);
      }

      if (this.b.w.thirdPersonView == 0 && this.b.f.gamemode != 2) {
         this.a.a(var1);
      }

      GL11.glPopMatrix();
      if (this.b.w.thirdPersonView == 0) {
         this.a.b(var1);
         this.c(var1);
      }

      if (this.b.w.viewBobbing) {
         this.d(var1);
      }

      GL11.glColorMask(true, true, true, false);
   }

   private void updateFovModifierHand() {
      float var1 = this.b.f.getFOVMultiplier();
      this.fovModifierHandPrev = this.fovModifierHand;
      this.fovModifierHand = this.fovModifierHand + (var1 - this.fovModifierHand) * 0.5F;
   }

   private float getFOV(float var1, boolean var2) {
      net.minecraft.client.g.C_a var3 = this.b.f;
      float var4 = 70.0F;
      if (var2) {
         var4 = this.b.w.fov;
      }

      var4 *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * var1;
      if (var3.m()) {
         var4 = var4 * 60.0F / 70.0F;
      }

      if (var3.W <= 0) {
         float var5 = (float)var3.ab + var1;
         var4 /= (1.0F - 500.0F / (var5 + 500.0F)) * 2.0F + 1.0F;
      }

      if (Keyboard.isKeyDown(this.b.w.keyBindZoom.b) && this.b.o == null) {
         var4 = 25.0F;
      }

      return var4;
   }

   public final void c() {
      ScaledResolution var1;
      int var2 = (var1 = new ScaledResolution(this.b.w, this.b.b, this.b.c)).a();
      int var3 = var1.b();
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0, (double)var2, (double)var3, 0.0, 1000.0, 3000.0);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   private void f(float var1) {
      net.minecraft.a.a.C_g var2 = this.b.d;
      net.minecraft.client.g.C_a var3 = this.b.f;
      float var4 = 0.25F;
      var4 = 1.0F - (float)Math.pow((double)var4, 0.25);
      net.minecraft.a.d.C_a var5;
      float var6 = (var5 = var2.b(var1)).a;
      float var7 = var5.b;
      float var8 = var5.c;
      net.minecraft.a.d.C_a var9 = var2.d(var1);
      this.p = var9.a;
      this.q = var9.b;
      this.r = var9.c;
      this.p = this.p + (var6 - this.p) * var4;
      this.q = this.q + (var7 - this.q) * var4;
      this.r = this.r + (var8 - this.r) * var4;
      float var10 = var2.getRainStatus(var1);
      if (var10 > 0.0F) {
         float var11 = 1.0F - var10 * 0.5F;
         float var12 = 1.0F - var10 * 0.4F;
         float var13 = 1.0F - var10;
         if (var2.type == 4 && var2.theme != 1) {
            this.p = this.p * var13 + var10 * 0.6F;
            this.q = this.q * var13 + var10 * 0.4F;
            this.r = this.r * var13 + var10 * 0.2F;
         } else {
            this.p *= var11;
            this.q *= var11;
            this.r *= var12;
         }
      }

      float var18 = var2.getThunderStatus(var1);
      if (var18 > 0.0F) {
         float var19 = 1.0F - var18 * 0.5F;
         this.p *= var19;
         this.q *= var19;
         this.r *= var19;
      }

      if (this.b.d.getFogDensity() < 2 && GameSettings.f) {
         net.minecraft.a.d.C_a var15 = MathHelper.a(var2.getSunsetAngle(var1)) > 0.0F
            ? new net.minecraft.a.d.C_a(0.0F, 0.0F, 1.0F)
            : new net.minecraft.a.d.C_a(0.0F, 0.0F, -1.0F);
         float var14 = (float)var3.getLook(var1).getIntermediateVector(var15);
         if (var14 < 0.0F) {
            var14 = 0.0F;
         }

         if (var14 > 0.0F) {
            float[] var16 = var2.calcSunriseSunsetColors(var2.c(var1), var1);
            if (var16 != null) {
               var14 *= var16[3];
               this.p = this.p * (1.0F - var14) + var16[0] * var14;
               this.q = this.q * (1.0F - var14) + var16[1] * var14;
               this.r = this.r * (1.0F - var14) + var16[2] * var14;
            }
         }
      }

      C_x var20;
      if ((var20 = C_x.c[var2.a((int)var3.h, (int)(var3.i + 0.12F), (int)var3.j)]) != null
         && var20.getMaterial(var2.e((int)var3.h, (int)(var3.i + 0.12F), (int)var3.j)) != net.minecraft.a.a.d.C_c.a) {
         net.minecraft.a.a.d.C_c var22;
         if ((var22 = var20.getMaterial(var2.e((int)var3.h, (int)(var3.i + 0.12F), (int)var3.j))) == net.minecraft.a.a.d.C_c.f) {
            if (var2.theme == 4) {
               this.p = 0.02F;
               this.q = 0.2F;
               this.r = 0.02F;
            } else {
               this.p = 0.02F;
               this.q = 0.02F;
               this.r = 0.2F;
            }
         } else if (var22 == net.minecraft.a.a.d.C_c.g) {
            this.p = 0.6F;
            this.q = 0.1F;
            this.r = 0.0F;
         }
      }

      float var23 = this.s + (this.t - this.s) * var1;
      this.p *= var23;
      this.q *= var23;
      this.r *= var23;
      GL11.glClearColor(this.p, this.q, this.r, 0.0F);
   }

   private void d() {
      net.minecraft.a.a.C_g var1 = this.b.d;
      net.minecraft.client.g.C_a var2 = this.b.f;
      float var3 = this.r;
      float var4 = this.q;
      float var5 = this.p;
      ((Buffer)this.o).clear();
      this.o.put(var5).put(var4).put(var3).put(1.0F);
      ((Buffer)this.o).flip();
      GL11.glFog(2918, this.o);
      GL11.glNormal3f(0.0F, -1.0F, 0.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      C_x var6;
      if ((var6 = C_x.c[var1.a((int)var2.h, (int)(var2.i + 0.12F), (int)var2.j)]) != null
         && var6.getMaterial(var1.e((int)var2.h, (int)(var2.i + 0.12F), (int)var2.j)).d()
         && !var2.canBreatheUnderwater()) {
         net.minecraft.a.a.d.C_c var7 = var6.getMaterial(var1.e((int)var2.h, (int)(var2.i + 0.12F), (int)var2.j));
         GL11.glFogi(2917, 2048);
         if (var7 == net.minecraft.a.a.d.C_c.f) {
            GL11.glFogf(2914, 0.1F);
         } else if (var7 == net.minecraft.a.a.d.C_c.g) {
            GL11.glFogf(2914, 2.0F);
         }
      } else {
         GL11.glFogi(2917, 9729);
         GL11.glFogf(2915, var1.getFogDistance() / 4.0F);
         GL11.glFogf(2916, var1.getFogDistance());
      }

      GL11.glEnable(2903);
      GL11.glColorMaterial(1028, 4608);
   }
}
