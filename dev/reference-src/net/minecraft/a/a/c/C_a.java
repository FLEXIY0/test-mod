package net.minecraft.a.a.c;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.C_l;
import net.minecraft.a.a.LevelOptions;
import net.minecraft.a.a.b.Block;
import net.minecraft.client.d;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.plants.BlockBush;
import net.minecraft.game.level.block.plants.BlockFlower;
import util.MathHelper;

public final class C_a {
   private util.C_b e;
   private int f;
   private int g;
   private int h;
   private Random i = new Random();
   private byte[] j;
   private int k;
   private int l;
   public boolean a = false;
   public boolean b = false;
   public boolean c = false;
   public boolean desertGen = false;
   public boolean cavesGen = false;
   public boolean mountainGen = false;
   public boolean marshGen = false;
   public boolean moonGen = false;
   public boolean oceanGen = false;
   public boolean cheats = false;
   public long seed = new Random().nextLong();
   public int theme;
   private int m;
   private int n;
   private int[] p = new int[1048576];
   public LevelOptions worldGen;

   public C_a(util.C_b var1) {
      this.e = var1;
   }

   public final World a(String var1, int var2, int var3, int var4) {
      int var5 = 1;
      if (this.b) {
         var5 = var4 / 2 / 48 + 1;
      }

      this.n = 17 + var5 * 4;
      if (this.cavesGen) {
         this.n = 13 + var5 * 4;
      }

      if (this.oceanGen || this.theme == 1 && !this.cavesGen) {
         this.n = 14 + var5 * 4;
      }

      this.e.a("Generating level");
      World var6 = new World();
      var6.s = this.k;
      var6.t = this.l;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.j = new byte[var2 * var3 * var4];
      this.i.setSeed(this.seed);

      for (int var7 = 0; var7 < var5; var7++) {
         this.k = var4 / 2 - var7 * 48;
         if (this.oceanGen) {
            this.k = var4 - 2 - var7 * 48;
         }

         this.l = this.k - 2;
         int[] var17;
         if (this.c || this.cavesGen) {
            var17 = new int[var2 * var3];

            for (int var12 = 0; var12 < var17.length; var12++) {
               var17[var12] = 0;
            }

            this.b();
            this.b();
         } else if (this.mountainGen) {
            var17 = new int[var2 * var3];
            net.minecraft.a.a.c.a.C_d var21 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            float var22 = 0.4F;

            for (int var23 = 0; var23 < this.f; var23++) {
               for (int var24 = 0; var24 < this.g; var24++) {
                  double var25 = var21.a((double)((float)var23 * var22), (double)((float)var24 * var22)) / 1.0 - 2.0;
                  double var27 = var25 / 2.0;
                  if (var27 < 0.0) {
                     var27 *= 0.4;
                  }

                  var17[var23 + var24 * this.f] = (int)var27;
               }
            }

            this.b();
            this.b();
         } else if (this.moonGen) {
            var17 = new int[var2 * var3];
            net.minecraft.a.a.c.a.C_d var99 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            float var115 = 1.3F;

            for (int var131 = 0; var131 < this.f; var131++) {
               for (int var145 = 0; var145 < this.g; var145++) {
                  double var157 = var99.a((double)((float)var131 * var115), (double)((float)var145 * var115)) / 1.0 - 4.0;
                  double var173 = var157 / 12.0;
                  if (var173 < 0.0) {
                     var173 *= 0.8;
                  }

                  var17[var131 + var145 * this.f] = (int)var173;
               }
            }

            this.b();
            this.b();
         } else if (this.marshGen) {
            var17 = new int[var2 * var3];
            net.minecraft.a.a.c.a.C_d var100 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            float var116 = 0.9F;

            for (int var132 = 0; var132 < this.f; var132++) {
               for (int var146 = 0; var146 < this.g; var146++) {
                  double var158 = var100.a((double)((float)var132 * var116), (double)((float)var146 * var116)) / 1.0 - 4.0;
                  double var174 = var158 / 10.0;
                  if (var174 < 0.0) {
                     var174 *= 0.8;
                  }

                  var17[var132 + var146 * this.f] = (int)var174;
               }
            }

            this.b();
            this.b();
         } else if (this.oceanGen) {
            var17 = new int[var2 * var3];
            net.minecraft.a.a.c.a.C_d var101 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            float var117 = 1.3F;

            for (int var133 = 0; var133 < this.f; var133++) {
               for (int var147 = 0; var147 < this.g; var147++) {
                  double var159 = var101.a((double)((float)var133 * var117), (double)((float)var147 * var117)) / 1.0 - 4.0;
                  double var175 = var159 / 12.0;
                  if (var175 < 0.0) {
                     var175 *= 0.8;
                  }

                  var17[var133 + var147 * this.f] = (int)var175 - (this.h / 2 + this.h / 3);
               }
            }

            this.b();
            this.b();
         } else {
            this.e.b("Raising..");
            this.b();
            C_a var8 = this;
            net.minecraft.a.a.c.a.C_d var102 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            net.minecraft.a.a.c.a.C_d var118 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            net.minecraft.a.a.c.a.C_c var134 = new net.minecraft.a.a.c.a.C_c(this.i, 6);
            net.minecraft.a.a.c.a.C_c var18 = new net.minecraft.a.a.c.a.C_c(this.i, 2);
            int[] var148 = new int[this.f * this.g];

            for (int var19 = 0; var19 < var8.f; var19++) {
               double var160 = Math.abs(((double)var19 / ((double)var8.f - 1.0) - 0.5) * 2.0);
               var8.a((float)var19 * 100.0F / (float)(var8.f - 1));

               for (int var10 = 0; var10 < var8.g; var10++) {
                  double var176 = Math.abs(((double)var10 / ((double)var8.g - 1.0) - 0.5) * 2.0);
                  double var29 = var102.a((double)((float)var19 * 1.3F), (double)((float)var10 * 1.3F)) / 6.0 + -4.0;
                  double var31 = var118.a((double)((float)var19 * 1.3F), (double)((float)var10 * 1.3F)) / 5.0 + 10.0 + -4.0;
                  if (this.desertGen) {
                     var29 = var102.a((double)((float)var19 * 1.3F), (double)((float)var10 * 1.3F)) / 9.0 + -4.0;
                     var31 = var102.a((double)((float)var19 * 1.3F), (double)((float)var10 * 1.3F)) / 5.0 + -4.0;
                  }

                  if (var134.a((double)var19, (double)var10) / 8.0 > 0.0) {
                     var31 = var29;
                  }

                  double var33 = Math.max(var29, var31) / 2.0;
                  if (var8.a) {
                     double var35 = Math.sqrt(var160 * var160 + var176 * var176) * 1.2F;
                     double var37 = var18.a((double)((float)var19 * 0.05F), (double)((float)var10 * 0.05F)) / 4.0 + 1.0;
                     if ((var35 = Math.max(Math.min(var35, var37), Math.max(var160, var176))) > 1.0) {
                        var35 = 1.0;
                     }

                     if (var35 < 0.0) {
                        var35 = 0.0;
                     }

                     var35 *= var35;
                     if ((var33 = var33 * (1.0 - var35) - var35 * 10.0 + 5.0) < 0.0) {
                        var33 -= var33 * var33 * 0.2F;
                     }
                  } else if (var33 < 0.0) {
                     var33 *= 0.8;
                  }

                  var148[var19 + var10 * var8.f] = (int)var33;
               }
            }

            var17 = var148;
            this.e.b("Eroding..");
            this.b();
            int[] var20 = var148;
            var8 = this;
            var118 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
            net.minecraft.a.a.c.a.C_d var161 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));

            for (int var14 = 0; var14 < var8.f; var14++) {
               var8.a((float)var14 * 100.0F / (float)(var8.f - 1));

               for (int var15 = 0; var15 < var8.g; var15++) {
                  double var26 = var118.a((double)(var14 << 1), (double)(var15 << 1)) / 8.0;
                  int var84 = var161.a((double)(var14 << 1), (double)(var15 << 1)) > 0.0 ? 1 : 0;
                  if (var26 > 2.0) {
                     int var28 = ((var20[var14 + var15 * var8.f] - var84) / 2 << 1) + var84;
                     var20[var14 + var15 * var8.f] = var28;
                  }
               }
            }
         }

         this.e.b("Soiling..");
         this.b();
         int[] var92 = var17;
         C_a var60 = this;
         int var103 = this.f;
         int var13 = this.g;
         int var70 = this.h;
         net.minecraft.a.a.c.a.C_c var120 = new net.minecraft.a.a.c.a.C_c(this.i, 8);
         net.minecraft.a.a.c.a.C_c var135 = new net.minecraft.a.a.c.a.C_c(this.i, 8);
         net.minecraft.a.a.c.a.C_c var149 = new net.minecraft.a.a.c.a.C_c(this.i, 6);
         net.minecraft.a.a.c.a.C_c var162 = new net.minecraft.a.a.c.a.C_c(this.i, 6);
         net.minecraft.a.a.c.a.C_c var168 = new net.minecraft.a.a.c.a.C_c(this.i, 6);

         for (int var9 = 0; var9 < var103; var9++) {
            double var177 = Math.abs(((double)var9 / ((double)var103 - 1.0) - 0.5) * 2.0);
            var60.a((float)var9 * 100.0F / (float)(var103 - 1));

            for (int var184 = 0; var184 < var13; var184++) {
               double var30 = Math.abs(((double)var184 / ((double)var13 - 1.0) - 0.5) * 2.0);
               double var32;
               var32 = (var32 = Math.max(var177, var30)) * var32 * var32;
               int var34 = (int)(var120.a((double)var9, (double)var184) / 24.0) - 4;
               if (this.mountainGen) {
                  var34 = (int)(var120.a((double)var9, (double)var184) / 21.0) - 2;
               }

               int var201 = var92[var9 + var184 * var103] + var60.k;
               int var11 = var201 + var34;
               var92[var9 + var184 * var103] = Math.max(var201, var11);
               if (var92[var9 + var184 * var103] > var70 - 2) {
                  var92[var9 + var184 * var103] = var70 - 2;
               }

               if (var92[var9 + var184 * var103] <= 0) {
                  var92[var9 + var184 * var103] = 1;
               }

               boolean var39 = var120.a((double)var9, (double)var184) > 64.0;
               double var36;
               int var38;
               if ((
                     var38 = (int)(
                        (double)(
                                 (int)(Math.sqrt(Math.abs(var36 = var135.a((double)var9 * 2.3, (double)var184 * 2.3) / 24.0)) * Math.signum(var36) * 20.0)
                                    + var60.k
                              )
                              * (1.0 - var32)
                           + var32 * (double)var60.h
                     )
                  )
                  > var60.k) {
                  var38 = var60.h;
               }

               double var40 = var120.a((double)var9, (double)var184);

               for (int var42 = 0; var42 < var70; var42++) {
                  int var43 = (var42 * var60.g + var184) * var60.f + var9;
                  int var44 = 0;
                  if (var42 <= var201) {
                     float var45 = 0.25F;
                     if (this.h == 128) {
                        var45 = 0.15F;
                     }

                     if (this.h == 256) {
                        var45 = 0.1F;
                     }

                     if (this.h == 512) {
                        var45 = 0.05F;
                     }

                     if (this.h == 1024) {
                        var45 = 0.025F;
                     }

                     int var46 = this.k + (int)((float)this.h * var45);
                     int var47 = (int)(var40 / 8.0);
                     int var48 = var46 - var47;
                     if (this.desertGen) {
                        if (var39) {
                           var44 = Block.quickSand.at;
                        } else {
                           var44 = Block.t.at;
                        }
                     } else if (this.moonGen) {
                        var44 = Block.moonRock.at;
                     } else if (!this.mountainGen || var42 < var48) {
                        var44 = Block.k.at;
                     } else if (this.theme == 1) {
                        var44 = Block.brimStone.at;
                     } else {
                        var44 = Block.packedIce.at;
                     }
                  }

                  if (var42 == var11 && this.desertGen) {
                     var44 = Block.sandStone.at;
                  }

                  if (var42 < var11) {
                     if (this.moonGen) {
                        var44 = Block.moonRock.at;
                     } else {
                        var44 = Block.i.at;
                     }
                  }

                  if (var60.b && var42 < var38) {
                     var44 = 0;
                  }

                  if (var60.j[var43] == 0) {
                     var60.j[var43] = (byte)var44;
                  }
               }
            }
         }

         this.e.b("Growing..");
         this.b();
         var92 = var17;
         var60 = this;
         var103 = this.f;
         var13 = this.g;
         net.minecraft.a.a.c.a.C_c var77 = new net.minecraft.a.a.c.a.C_c(this.i, 8);
         var120 = new net.minecraft.a.a.c.a.C_c(this.i, 8);
         var135 = new net.minecraft.a.a.c.a.C_c(this.i, 6);
         int var16 = this.k - 1;
         if (this.theme == 2) {
            var16 += 2;
         }

         for (int var63 = 0; var63 < var103; var63++) {
            var60.a((float)var63 * 100.0F / (float)(var103 - 1));

            for (int var85 = 0; var85 < var13; var85++) {
               boolean var178 = var77.a((double)var63, (double)var85) > 8.0;
               if (var60.a) {
                  var178 = var77.a((double)var63, (double)var85) > -8.0;
               }

               if (var60.theme == 2 && !this.marshGen) {
                  var178 = var77.a((double)var63, (double)var85) > -32.0;
               }

               if (var60.theme == 1 || var60.theme == 3) {
                  var178 = var77.a((double)var63, (double)var85) > -8.0;
               }

               if (this.mountainGen && var60.theme != 2) {
                  var178 = var77.a((double)var63, (double)var85) > 64.0;
               }

               if (var60.oceanGen) {
                  var178 = var77.a((double)var63, (double)var85) > 16.0;
               }

               boolean var182 = var120.a((double)var63, (double)var85) > 12.0;
               boolean var185 = var149.a((double)var63, (double)var85) > 16.0;
               boolean var187 = var135.a((double)var63, (double)var85) > 16.0;
               boolean var189 = var168.a((double)var63, (double)var85) > 20.0;
               int var65;
               int var192 = ((var65 = var92[var63 + var85 * var103]) * var60.g + var85) * var60.f + var63;
               int var194 = var60.j[((var65 + 1) * var60.g + var85) * var60.f + var63] & 255;
               int var197 = var60.j[((var65 - 1) * var60.g + var85) * var60.f + var63] & 255;
               if (!this.moonGen) {
                  if (!this.desertGen) {
                     if ((var194 == Block.p.at || var194 == Block.q.at || var194 == 0) && var65 <= var60.k - 1 && var182) {
                        if (this.b && var197 == 0) {
                           var60.j[var192] = (byte)Block.cloudBlock.at;
                        } else {
                           var60.j[var192] = (byte)Block.u.at;
                        }
                     }
                  } else if (var194 == 0 && var65 <= var60.k - 1 && var182) {
                     if (this.theme == 1) {
                        var60.j[var192] = (byte)Block.k.at;
                     } else if (this.theme == 4) {
                        var60.j[var192] = (byte)Block.mycelium.at;
                     } else {
                        var60.j[var192] = (byte)Block.j.at;
                     }
                  }

                  if (var194 == 0) {
                     int var202 = -1;
                     if (var65 <= var16 && var178) {
                        if (this.b && var197 == 0) {
                           var202 = Block.cloudBlock.at;
                        } else {
                           var202 = Block.t.at;
                        }
                     }

                     if (this.theme == 1 && var185 && !this.cavesGen) {
                        var202 = Block.j.at;
                     }

                     if (((var194 = var60.j[((var65 + 1) * var60.g + var85) * var60.f + var63] & 255) == Block.p.at || var194 == Block.q.at || var194 == 0)
                        && var65 < var60.k - 1
                        && var185) {
                        if (this.b && var197 == 0) {
                           var202 = Block.cloudBlock.at;
                        } else {
                           var202 = Block.clay.at;
                        }
                     }

                     if (this.oceanGen) {
                        boolean var204 = var162.a((double)var63, (double)var85) > 8.0;
                        if (var65 <= var16 && var204) {
                           var202 = Block.coral.at;
                        }
                     }

                     if (this.theme == 1 && var187) {
                        if (this.b && var197 == 0) {
                           var202 = Block.cloudBlock.at;
                        } else {
                           var202 = Block.magma.at;
                        }
                     }

                     if (this.theme == 1 && var189) {
                        var202 = Block.ae.at;
                     }

                     if (var60.j[var192] != 0 && var202 > 0) {
                        var60.j[var192] = (byte)var202;
                     }
                  }
               }
            }
         }
      }

      this.e.b("Carving..");
      this.b();
      C_a var62 = this;
      int var69 = this.f;
      int var71 = this.g;
      int var72 = this.h;
      int var73 = var69 * var71 * var72 / 256 / 64 << 1;
      if (this.cavesGen) {
         var73 = var69 * var71 * var72 / 256 / 16;
      }

      if (this.oceanGen) {
         var73 = 0;
      }

      for (int var64 = 0; var64 < var73; var64++) {
         var62.a((float)var64 * 100.0F / (float)(var73 - 1));
         float var74 = var62.i.nextFloat() * (float)var69;
         float var78 = var62.i.nextFloat() * (float)var72;
         float var86 = var62.i.nextFloat() * (float)var71;
         int var66 = (int)((var62.i.nextFloat() + var62.i.nextFloat()) * 200.0F);
         float var94 = var62.i.nextFloat() * (float) Math.PI * 2.0F;
         float var105 = 0.0F;
         float var122 = var62.i.nextFloat() * (float) Math.PI * 2.0F;
         float var137 = 0.0F;
         float var150 = var62.i.nextFloat() * var62.i.nextFloat();

         for (int var67 = 0; var67 < var66; var67++) {
            var74 += MathHelper.a(var94) * MathHelper.b(var122);
            var86 += MathHelper.b(var94) * MathHelper.b(var122);
            var78 += MathHelper.a(var122);
            var94 += var105 * 0.2F;
            float var106;
            var105 = (var106 = var105 * 0.9F) + (var62.i.nextFloat() - var62.i.nextFloat());
            var122 = (var122 + var137 * 0.5F) * 0.5F;
            float var138;
            var137 = (var138 = var137 * 0.75F) + (var62.i.nextFloat() - var62.i.nextFloat());
            if (var62.i.nextFloat() >= 0.25F) {
               float var163 = var74 + (var62.i.nextFloat() * 4.0F - 2.0F) * 0.2F;
               float var169 = var78 + (var62.i.nextFloat() * 4.0F - 2.0F) * 0.2F;
               float var179 = var86 + (var62.i.nextFloat() * 4.0F - 2.0F) * 0.2F;
               if (this.cavesGen) {
                  var163 = var74;
                  var169 = var78;
                  var179 = var86;
               }

               float var183 = ((float)var62.h - var169) / (float)var62.h;
               float var186 = 1.2F + (var183 * 3.5F + 1.0F) * var150;
               float var188 = MathHelper.a((float)var67 * (float) Math.PI / (float)var66) * var186;
               if (this.cavesGen) {
                  var188 = MathHelper.a((float)var67 * (float) Math.PI / (float)var66) * 2.5F + 1.0F;
               }

               for (int var50 = (int)(var163 - var188); var50 <= (int)(var163 + var188); var50++) {
                  for (int var190 = (int)(var169 - var188); var190 <= (int)(var169 + var188); var190++) {
                     for (int var193 = (int)(var179 - var188); var193 <= (int)(var179 + var188); var193++) {
                        float var196 = (float)var50 - var163;
                        float var198 = (float)var190 - var169;
                        float var203 = (float)var193 - var179;
                        if (var196 * var196 + var198 * var198 * 2.0F + var203 * var203 < var188 * var188
                           && var50 > 0
                           && var190 > 0
                           && var193 > 0
                           && var50 < var62.f - 1
                           && var190 < var62.h - 1
                           && var193 < var62.g - 1) {
                           int var56 = (var190 * var62.g + var193) * var62.f + var50;
                           if (var62.j[var56] == Block.i.at) {
                              var62.j[var56] = 0;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.cavesGen) {
         this.a(Block.x.at, 1000, 10, var4);
         this.a(Block.w.at, 800, 8, var4);
         this.a(Block.v.at, 500, 6, var4);
         this.a(Block.al.at, 500, 2, var4);
         this.a(Block.oreEmerald.at, 4000, 1, var4);
         this.a(Block.oreAdminium.at, 1000, 1, var4);
      } else {
         this.a(Block.x.at, 1000, 10, var4);
         this.a(Block.w.at, 800, 8, var4 / 2);
         this.a(Block.v.at, 500, 6, var4 / 3);
         this.a(Block.oreEmerald.at, 4000, 1, var4 / 4);
         this.a(Block.al.at, 500, 2, var4 / 5);
         this.a(Block.oreAdminium.at, 1000, 1, var4 / 5);
      }

      this.populateLargeOreVeins(Block.u.at, 90, 1, 4);
      if (this.theme == 1) {
         this.populateLargeOreVeins(Block.brimStone.at, 90, 1, 4);
      } else {
         this.populateLargeOreVeins(Block.k.at, 90, 1, 4);
      }

      this.e.b("Melting..");
      this.b();
      this.c();
      var6.u = var4 + 2;
      if (this.b) {
         this.l = -128;
         this.k = this.l + 1;
         var6.u = -16;
      } else if (this.oceanGen) {
         this.l = this.k / 4 - 4;
         if (this.h > 64) {
            this.l = this.k / 4 - 20;
         }

         var6.u += 32;
      } else if (!this.a) {
         this.l = this.k + 1;
         this.k = this.l - 16;
      } else {
         this.l = this.k - 9;
      }

      this.e.b("Watering..");
      this.b();
      if (!this.moonGen) {
         this.a();
         if (!this.b && !this.cavesGen) {
            var5 = Block.q.at;
            if (this.theme == 1 && !this.oceanGen) {
               var5 = Block.s.at;
            }

            for (int var57 = 0; var57 < var2; var57++) {
               this.a(var57, this.k - 1, 0, 0, var5);
               this.a(var57, this.k - 1, var3 - 1, 0, var5);
            }

            for (int var58 = 0; var58 < var3; var58++) {
               this.a(var2 - 1, this.k - 1, var58, 0, var5);
               this.a(0, this.k - 1, var58, 0, var5);
            }
         }
      }

      if (this.theme == 0) {
         var6.v = 10079487;
         var6.w = 16777215;
         var6.x = 16777215;
      }

      if (this.theme == 1) {
         var6.x = 2164736;
         var6.w = 1049600;
         var6.v = 1049600;
         var6.B = var6.A = 7;
         if (!this.oceanGen) {
            var6.m = Block.r.at;
         }

         if (this.b) {
            var6.u = var4 + 2;
            this.k = -16;
         }
      }

      if (this.theme == 2) {
         var6.v = 13033215;
         var6.w = 13033215;
         var6.x = 15658751;
         var6.B = var6.A = 15;
         var6.A = 16;
         var6.u = var4 + 64;
      }

      if (this.theme == 3) {
         var6.v = 7699847;
         var6.w = 5069403;
         var6.x = 5069403;
         var6.B = var6.A = 12;
      }

      if (this.theme == 4) {
         var6.x = 1518354;
         var6.w = 1649945;
         var6.v = 1653785;
         var6.B = var6.A = 12;
         var6.defaultBlock = Block.mycelium.at;
      } else if (this.moonGen) {
         var6.v = 0;
         var6.w = 0;
         var6.x = 0;
         var6.B = var6.A = 0;
         var6.u = var4 + 64;
         var6.defaultBlock = Block.moonRock.at;
      } else if (this.desertGen) {
         var6.defaultBlock = Block.t.at;
      }

      var6.s = this.k;
      var6.t = this.l;
      if (this.cavesGen) {
         var6.type = 5;
      } else if (this.oceanGen) {
         var6.type = 7;
      } else if (this.moonGen) {
         var6.type = 8;
      } else if (this.desertGen) {
         var6.type = 4;
      }

      var6.cheats = this.cheats;
      this.e.b("Assembling..");
      this.b();
      this.a(0.0F);
      var6.generate(var2, var4, var3, this.j, (byte[])null, null, null);
      if (this.marshGen) {
         if (this.theme == 1) {
            var5 = Block.s.at;
         } else {
            var5 = Block.q.at;
         }

         for (int var75 = 0; var75 < this.f; var75++) {
            for (int var79 = 0; var79 < this.h; var79++) {
               for (int var87 = 0; var87 < this.g; var87++) {
                  if (var6.a(var75, var79, var87) == 0 && var79 <= this.h / 2 && var6.l(var75, var79, var87)) {
                     var6.a(var75, var79, var87, var5);
                     var6.d();
                  }
               }
            }
         }
      }

      this.e.b("Building..");
      this.b();
      this.a(0.0F);
      var6.b();
      if (this.worldGen.house == 1) {
         a(var6);
      } else if (this.worldGen.house == 2) {
         this.generateDebugHouse(var6);
      } else if (this.worldGen.house >= 3) {
         this.generateGateway(var6, this.worldGen.house - 3);
      }

      this.e.b("Planting..");
      this.b();
      if (this.theme != 1 && !this.cavesGen) {
         this.b(var6);
      }

      this.b();
      if (this.desertGen) {
         this.growPalmTrees(var6);
      } else if (!this.cavesGen) {
         this.c(var6);
      }

      if (this.theme == 3 && !this.cavesGen) {
         for (int var53 = 0; var53 < 50; var53++) {
            if (this.desertGen) {
               this.growPalmTrees(var6);
            } else {
               this.c(var6);
            }
         }
      }

      if (this.desertGen) {
         this.growCacti(var6);
      }

      if (this.oceanGen) {
         this.growSeaweed(var6);
      }

      if (this.theme == 4) {
         this.growMushrooms(var6);
      }

      if (this.theme == 2) {
         this.growFlowers(var6);
      }

      if (this.theme == 1) {
         this.growSpikes(var6);
      }

      short var76 = 100;
      if (this.theme == 2) {
         var76 = 1000;
      }

      if (!this.cavesGen && !this.oceanGen) {
         if (this.theme == 1) {
            this.b();
            this.populateFlowersAndMushrooms(var6, (BlockFlower)Block.deadBush, var76);
         } else {
            this.b();
            this.populateFlowersAndMushrooms(var6, Block.plantYellow, var76);
            this.b();
            this.populateFlowersAndMushrooms(var6, Block.plantRed, var76);
            this.b();
            this.populateFlowersAndMushrooms(var6, Block.plantPurple, var76);
            this.b();
            this.populateFlowersAndMushrooms(var6, Block.plantBlue, var76);
         }

         this.b();
         this.populateFlowersAndMushrooms(var6, Block.mushroomBrown, 50);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.mushroomRed, 50);
         this.b();
         if (this.theme == 4) {
            this.populateFlowersAndMushrooms(var6, Block.mushroomGlowing, 50);
         }

         if (this.worldGen.seasons == 3) {
            this.populateFlowersAndMushrooms(var6, Block.berryBush, 50);
         }

         if (this.marshGen) {
            this.populateFlowersAndMushrooms(var6, (BlockFlower)Block.lilyPad, 200);
         }
      }

      if (this.desertGen) {
         this.populateDeadBush(var6);
      }

      if (this.worldGen.seasons == 2 || this.worldGen.seasons == 1) {
         int var80;
         if (this.worldGen.seasons == 2) {
            var80 = Block.pumpkin.at;
         } else {
            var80 = Block.melon.at;
         }

         for (int var88 = 0; var88 < var6.a; var88++) {
            for (int var95 = 0; var95 < var6.b; var95++) {
               int var107 = var88 + this.i.nextInt(16) + 8;
               int var123 = var95 + this.i.nextInt(16) + 8;
               if (this.i.nextInt(5000) == 0) {
                  this.populatePumpkins(var6, this.i, var107, var6.a(var88, var95), var123, var80);
               }
            }
         }
      }

      if (this.marshGen) {
         for (int var81 = 0; var81 < var6.a; var81++) {
            for (int var89 = 0; var89 < var6.b; var89++) {
               int var96 = var81 + this.i.nextInt(16) + 8;
               int var108 = var89 + this.i.nextInt(16) + 8;
               if (this.i.nextInt(100) == 0) {
                  this.populateGrass(var6, this.i, var96, var6.a(var81, var89), var108, Block.tallGrass.at);
               }
            }
         }
      }

      for (int var90 = 0; var90 < var6.a; var90++) {
         for (int var97 = 0; var97 < var6.b; var97++) {
            int var109 = var90 + this.i.nextInt(16) + 8;
            int var82 = var97 + this.i.nextInt(16) + 8;
            if (this.i.nextInt(500) == 0) {
               this.populateReeds(var6, this.i, var109, var6.a(var90, var97), var82);
            }
         }
      }

      this.e.b("Finalizing..");
      this.b();
      this.a(0.0F);
      net.minecraft.a.a.c.a.C_c var91 = new net.minecraft.a.a.c.a.C_c(this.i, 8);
      int var98 = Block.ae.at;

      for (int var110 = 0; var110 < this.f; var110++) {
         this.a((float)var110 * 100.0F / (float)(this.f - 1));

         for (int var124 = 0; var124 < this.h; var124++) {
            for (int var139 = 0; var139 < this.g; var139++) {
               if (var6.a(var110, var124 + 1, var139) != Block.q.at
                  && var6.a(var110, var124 + 1, var139) != Block.p.at
                  && var6.a(var110, var124, var139) == Block.clay.at) {
                  var6.a(var110, var124, var139, Block.t.at);
               }

               if ((var6.a(var110, var124 + 1, var139) == Block.p.at || var6.a(var110, var124 + 1, var139) == Block.q.at)
                  && (var6.a(var110, var124, var139) == Block.s.at || var6.a(var110, var124, var139) == Block.r.at)) {
                  var6.b(var110, var124, var139, var98);
               }

               if ((var6.a(var110, var124 + 1, var139) == Block.r.at || var6.a(var110, var124 + 1, var139) == Block.s.at)
                  && (var6.a(var110, var124, var139) == Block.q.at || var6.a(var110, var124, var139) == Block.p.at)) {
                  var6.b(var110, var124, var139, var98);
               }

               if (this.desertGen
                  && (
                     var6.a(var110, var124 - 1, var139) == Block.t.at
                        || var6.a(var110, var124 - 1, var139) == Block.quickSand.at
                        || var6.a(var110, var124 - 1, var139) == Block.j.at
                  )
                  && (var6.a(var110, var124, var139) == Block.q.at || var6.a(var110, var124, var139) == Block.p.at)) {
                  var6.b(var110, var124 - 1, var139, Block.k.at);
               }

               if (this.cavesGen) {
                  if (var124 == this.h / 2 + 1) {
                     var6.b(var110, var124 - 1, var139, Block.o.at);
                  }

                  boolean var151 = var91.a((double)var110, (double)var139) > 64.0;
                  if (var6.a(var110, var124 + 1, var139) == 0 && var6.a(var110, var124, var139) == Block.i.at && var151) {
                     var6.b(var110, var124, var139, Block.moss.at);
                  }
               }

               if (this.oceanGen && var6.a(var110, var124, var139) == Block.coral.at) {
                  var6.setBlockMetadata(var110, var124, var139, this.i.nextInt(4));
               }

               if (this.worldGen.seasons == 3 && this.worldGen.seasonLock && !this.desertGen && !this.moonGen && !this.cavesGen) {
                  int var152 = Block.snowLayer.at;
                  if (this.theme == 1) {
                     var152 = Block.ash.at;
                  }

                  int var164 = var6.a(var110, var139);
                  if (var6.a((float)var110, (float)(var164 - 1), (float)var139) || var6.a(var110, var164 - 1, var139) == Block.z.at) {
                     var6.a(var110, var164, var139, var152);
                  } else if (var6.a(var110, var164 - 1, var139) == Block.q.at || var6.a(var110, var164 - 1, var139) == Block.p.at) {
                     var6.a(var110, var164 - 1, var139, Block.ice.at);
                  } else if (var6.a(var110, var164 - 1, var139) == Block.lilyPad.at) {
                     var6.a(var110, var164 - 2, var139, Block.ice.at);
                     var6.a(var110, var164 - 1, var139, 0);
                  }
               }

               if (this.theme == 1) {
                  if (var6.a(var110, var124, var139) == Block.t.at) {
                     var6.a(var110, var124, var139, Block.redSand.at);
                  }

                  if (var6.a(var110, var124, var139) == Block.sandStone.at) {
                     var6.setBlockMetadata(var110, var124, var139, 2);
                  }
               }
            }
         }
      }

      if (this.cavesGen) {
         this.growCaveTrees(var6);
         this.populateFlowersAndMushrooms(var6, Block.mushroomRed, 50);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.mushroomBrown, 50);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.mushroomGlowing, 50);
         this.b();

         for (int var54 = 0; var54 < 50; var54++) {
            this.growStalactites(var6);
         }

         for (int var111 = 0; var111 < var6.a; var111++) {
            for (int var125 = 0; var125 < var6.b; var125++) {
               int var140 = var111 + this.i.nextInt(16) + 8;
               int var83 = var125 + this.i.nextInt(16) + 8;
               this.populateVines(var6, this.i, var140, var6.getLastUncoveredBlock(var111, var125), var83);
            }
         }
      }

      if (this.oceanGen) {
         int var112 = (this.f + this.g + this.h) / 64;

         for (int var126 = 0; var126 < var112; var126++) {
            int var141 = this.i.nextInt(20) + 10;
            int var153 = this.i.nextInt(this.f - 2 * var141) + var141;
            int var165 = this.i.nextInt(this.h - 2 * var141) + var141;
            int var170 = this.i.nextInt(this.g - 2 * var141) + var141;
            if (var6.f(var153, var165, var170) == net.minecraft.a.a.d.Material.f) {
               this.generateSpheres(var153, var165, var170, var141, Block.B.at, var6);
            }

            if (var126 == 5) {
               var6.a(var153, var165, var170, 180.0F);
               if (this.worldGen.house == 1) {
                  a(var6);
               } else if (this.worldGen.house == 2) {
                  this.generateDebugHouse(var6);
               } else if (this.worldGen.house >= 3) {
                  this.generateGateway(var6, this.worldGen.house - 3);
               }
            }
         }

         for (int var127 = 0; var127 < var6.a; var127++) {
            for (int var142 = 0; var142 < var6.b; var142++) {
               for (int var154 = 0; var154 < var6.c; var154++) {
                  if (var6.a(var127, var154, var142) == Block.k.at && var6.a(var127, var154 + 1, var142) == 0) {
                     if (this.theme == 4) {
                        var6.a(var127, var154, var142, Block.mycelium.at);
                     } else {
                        var6.a(var127, var154, var142, Block.j.at);
                     }
                  }

                  if (var6.a(var127, var154, var142) == Block.packedIce.at && var6.a(var127, var154 + 1, var142) == 0) {
                     var6.a(var127, var154, var142, Block.snowBlock.at);
                  }
               }
            }
         }

         for (int var128 = 0; var128 < 10; var128++) {
            this.growCacti(var6);
            this.populateDeadBush(var6);
         }

         if (this.theme == 4) {
            this.growMushrooms(var6);
         } else if (this.theme == 2) {
            this.growFlowers(var6);
         } else {
            this.c(var6);
         }

         if (this.theme == 3) {
            for (int var55 = 0; var55 < 50; var55++) {
               this.c(var6);
            }
         }

         this.growCorals(var6);
         this.growCoralFans(var6);
         if (this.worldGen.seasons == 2 || this.worldGen.seasons == 1) {
            int var129;
            if (this.worldGen.seasons == 2) {
               var129 = Block.pumpkin.at;
            } else {
               var129 = Block.melon.at;
            }

            for (int var143 = 0; var143 < var6.a; var143++) {
               for (int var155 = 0; var155 < var6.b; var155++) {
                  for (int var166 = 0; var166 < var6.c; var166++) {
                     int var171 = var143 + this.i.nextInt(16) + 8;
                     int var180 = var155 + this.i.nextInt(16) + 8;
                     if (this.i.nextInt(5000) == 0) {
                        this.populatePumpkins(var6, this.i, var171, var166, var180, var129);
                     }
                  }
               }
            }
         }
      }

      this.e.b("Lighting..");
      this.b();
      var6.initLighting();

      for (C_l var156 : C_l.values()) {
         var6.scheduleLightingUpdate(var156, 0, 0, 0, var6.a, var6.c, var6.b);
         int var167 = 10000;

         for (int var172 = var6.getLightingQueue(); var6.updatingLighting() && var167 > 0; var167--) {
            int var181 = var6.getLightingQueue();
            if (var181 > var172) {
               var172 = var181;
            }

            this.e.b("Lighting.. (" + (var156 == C_l.Sky ? "Sky " : "Block ") + var181 + " / " + var172 + ")");
            this.a((float)(var172 - var181) * 100.0F / (float)var172);
         }
      }

      if (this.oceanGen) {
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.plantYellow, var76);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.plantRed, var76);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.plantPurple, var76);
         this.b();
         this.populateFlowersAndMushrooms(var6, Block.plantBlue, var76);
         if (this.worldGen.seasons == 3) {
            this.populateFlowersAndMushrooms(var6, Block.berryBush, 50);
         }
      }

      this.initWorld(var6, var1);
      this.e.b("Spawning..");
      this.b();
      net.minecraft.a.a.C_b var114 = new net.minecraft.a.a.C_b(var6);

      for (int var49 = 0; var49 < 1000; var49++) {
         this.a((float)var49 * 100.0F / 999.0F);
         var114.a();
      }

      if (this.m != this.n) {
         throw new IllegalStateException("Wrong number of phases! Wanted " + this.n + ", got " + this.m);
      } else {
         return var6;
      }
   }

   private void initWorld(World var1, String var2) {
      var1.h = System.currentTimeMillis();
      var1.g = var2;
      var1.f = this.worldGen.name;
      var1.seed = this.seed;
      var1.theme = this.theme;
      var1.type = this.worldGen.type;
      var1.fileName = this.worldGen.file;
      if (this.worldGen.type == 5) {
         var1.B = var1.A = 15;
         var1.A = 16;
      }

      if (this.worldGen.seasonLock) {
         var1.season.seasonsDisabled = true;
         var1.season.currentSeason = this.worldGen.seasons;
         var1.season.seasonProgress = 0.5F;
      } else {
         var1.season.seasonTime = 600000 * this.worldGen.seasons;
      }

      var1.season.nextSeason = this.worldGen.seasons + 1;
      var1.season.lastSeason = this.worldGen.seasons - 1;
      if (var1.season.lastSeason < 0) {
         var1.season.lastSeason = 3;
      }

      if (var1.season.nextSeason > 3) {
         var1.season.nextSeason = 0;
      }

      d.getMinecraft().statFileWriter.writeStat(StatList.createWorldStat, 1);
   }

   private static void a(World var0) {
      int var1 = var0.i;
      int var2 = var0.j;
      int var3 = var0.k;

      for (int var4 = var1 - 3; var4 <= var1 + 3; var4++) {
         for (int var5 = var2 - 2; var5 <= var2 + 2; var5++) {
            for (int var6 = var3 - 3; var6 <= var3 + 3; var6++) {
               int var7 = var5 < var2 - 1 ? Block.ae.at : 0;
               if (var4 == var1 - 3 || var6 == var3 - 3 || var4 == var1 + 3 || var6 == var3 + 3 || var5 == var2 - 2 || var5 == var2 + 2) {
                  var7 = Block.i.at;
                  if (var5 >= var2 - 1) {
                     var7 = Block.m.at;
                  }
               }

               if (var6 == var3 - 3 && var4 == var1 && var5 >= var2 - 1 && var5 <= var2) {
                  var7 = 0;
               }

               var0.a(var4, var5, var6, var7);
            }
         }
      }

      var0.b(var1 - 3 + 1, var2, var3, Block.af.at);
      var0.b(var1 + 3 - 1, var2, var3, Block.af.at);
   }

   public final void generateDebugHouse(World var1) {
      int var2 = var1.i;
      int var3 = var1.j;
      int var4 = var1.k;

      for (int var5 = var2 - 3; var5 <= var2 + 3; var5++) {
         for (int var6 = var3 - 2; var6 <= var3 + 2; var6++) {
            for (int var7 = var4 - 3; var7 <= var4 + 3; var7++) {
               int var8 = var6 < var3 - 1 ? Block.ae.at : 0;
               if (var5 == var2 - 3 || var7 == var4 - 3 || var5 == var2 + 3 || var7 == var4 + 3 || var6 == var3 - 2 || var6 == var3 + 2) {
                  var8 = Block.ad.at;
               }

               if (var7 == var4 - 3 && var5 == var2 && var6 >= var3 - 1 && var6 <= var3) {
                  var8 = 0;
               }

               var1.a(var5, var6, var7, var8);
            }
         }
      }

      var1.b(var2 - 3 + 1, var3, var4, Block.af.at);
      var1.b(var2 + 3 - 1, var3, var4, Block.af.at);
   }

   private void generateGateway(World var1, int var2) {
      int var3 = var1.i;
      int var4 = var1.j - 1;
      int var5 = var1.k;

      for (int var6 = -1; var6 <= 2; var6++) {
         for (int var7 = -1; var7 <= 3; var7++) {
            boolean var8 = var6 == -1 || var6 == 2 || var7 == -1 || var7 == 3;
            var1.a(var3 + var6, var4 + var7, var5, var8 ? Block.ae.at : 0);
            var1.a(var3 + var6, var4 + var7 + 1, var5 - 1, 0);
            var1.a(var3 + var6, var4 + var7 + 1, var5 + 1, 0);
            if (var1.a(var3 + var6, var4 - 1, var5 + 1) == 0) {
               var1.a(var3 + var6, var4 - 1, var5 + 1, Block.ae.at);
            }

            if (var1.a(var3 + var6, var4 - 1, var5 - 1) == 0) {
               var1.a(var3 + var6, var4 - 1, var5 - 1, Block.ae.at);
            }
         }
      }

      for (int var9 = 0; var9 < 2; var9++) {
         for (int var10 = 0; var10 < 3; var10++) {
            var1.setBlockAndMetadata(var3 + var9, var4 + var10, var5, Block.portal.at, var2);
         }
      }
   }

   private void b(World var1) {
      for (int var2 = 0; var2 < this.f; var2++) {
         this.a((float)var2 * 100.0F / (float)(this.f - 1));

         for (int var3 = 0; var3 < this.h; var3++) {
            for (int var4 = 0; var4 < this.g; var4++) {
               boolean var5 = var1.d(var2, var3 + 1, var4) > 4;
               if (this.b) {
                  var5 = true;
               }

               if (var1.a(var2, var3, var4) == Block.k.at && !var1.f(var2, var3 + 1, var4).b() && var5) {
                  if (this.theme == 4) {
                     var1.a(var2, var3, var4, Block.mycelium.at);
                  } else {
                     var1.a(var2, var3, var4, Block.j.at);
                  }
               }

               if (var1.a(var2, var3, var4) == Block.packedIce.at && !var1.f(var2, var3 + 1, var4).b()) {
                  var1.a(var2, var3, var4, Block.snowBlock.at);
               }
            }
         }
      }
   }

   private void c(World var1) {
      int var2 = this.f * this.g * this.h / 80000;
      C_c var3 = new C_c(false);
      C_d var4 = new C_d();
      C_e var5 = new C_e();

      for (int var6 = 0; var6 < var2; var6++) {
         if (var6 % 100 == 0) {
            this.a((float)var6 * 100.0F / (float)(var2 - 1));
         }

         int var7 = this.i.nextInt(this.f);
         int var8 = this.i.nextInt(this.h);
         int var9 = this.i.nextInt(this.g);

         for (int var10 = 0; var10 < 25; var10++) {
            int var11 = var7;
            int var12 = var8;
            int var13 = var9;

            for (int var14 = 0; var14 < 20; var14++) {
               var11 += this.i.nextInt(12) - this.i.nextInt(12);
               var12 += this.i.nextInt(3) - this.i.nextInt(6);
               var13 += this.i.nextInt(12) - this.i.nextInt(12);
               int var15 = this.i.nextInt(10);
               int var16;
               if (var15 == 1) {
                  var16 = var15;
               } else if (var15 == 2 && this.theme == 3) {
                  var16 = var15;
               } else if (var15 >= 1 && this.theme == 1) {
                  var16 = 3;
               } else {
                  var16 = 0;
               }

               if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 < this.f && var12 < this.h && var13 < this.g) {
                  if (this.marshGen && this.theme != 4) {
                     var1.growSwampTrees(var1, this.i, var11, var12, var13);
                  } else if (this.theme == 3) {
                     if (var16 == 2) {
                        var1.growTrees(var11, var12, var13, var16);
                     } else if (this.i.nextInt(3) == 0) {
                        var3.setScale(1.0, 1.0, 1.0);
                        var3.generate(var1, this.i, var11, var12, var13);
                     }
                  } else if (this.mountainGen && var12 > this.h / 2) {
                     if (this.i.nextBoolean()) {
                        var4.generate(var1, this.i, var11, var12, var13);
                     } else {
                        var5.generate(var1, this.i, var11, var12, var13);
                     }
                  } else if (var16 == 1) {
                     var3.setScale(0.3, 1.0, 0.3);
                     var3.metadata = 1;
                     var3.leafDistanceLimit = 5;
                     var3.generate(var1, this.i, var11, var12, var13);
                  } else {
                     var1.growTrees(var11, var12, var13, var16);
                  }
               }
            }
         }
      }
   }

   private void growCaveTrees(World var1) {
      int var2 = this.f * this.g * this.h / 256;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growCaveTrees(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growPalmTrees(World var1) {
      int var2 = this.f * this.g * this.h / 80000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growPalmTrees(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growMushrooms(World var1) {
      int var2 = this.f * this.g * this.h / 80000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               int var12 = this.i.nextInt(3);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growLargeMushrooms(var8, var9, var10, var12);
               }
            }
         }
      }
   }

   private void growFlowers(World var1) {
      int var2 = this.f * this.g * this.h / 80000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               int var12 = this.i.nextInt(4);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  switch (var12) {
                     case 1:
                        var1.genBigFlowerFeature1(6, false, var1, this.i, var8, var9, var10);
                     case 2:
                        var1.genBigFlowerFeature2(6, false, var1, this.i, var8, var9, var10);
                     case 3:
                        var1.genBigFlowerFeature3(6, false, var1, this.i, var8, var9, var10);
                     default:
                        var1.genBigFlowerFeature4(6, false, var1, this.i, var8, var9, var10);
                  }
               }
            }
         }
      }
   }

   private void growCorals(World var1) {
      int var2 = this.f * this.g * this.h / 80000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growCorals(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growSpikes(World var1) {
      int var2 = this.f * this.g * this.h / 80000;
      int var3 = 100;
      if (this.a || this.marshGen) {
         if (this.f < 256 && this.g < 256) {
            var3 = 100;
         } else {
            var3 = 350 * (this.f / 256 * this.g / 256);
         }
      }

      for (int var4 = 0; var4 < var2; var4++) {
         if (var4 % 100 == 0) {
            this.a((float)var4 * 100.0F / (float)(var2 - 1));
         }

         int var5 = this.i.nextInt(this.f);
         int var6 = this.i.nextInt(this.h);
         int var7 = this.i.nextInt(this.g);

         for (int var8 = 0; var8 < 25; var8++) {
            int var9 = var5;
            int var10 = var6;
            int var11 = var7;

            for (int var12 = 0; var12 < 20; var12++) {
               var9 += this.i.nextInt(var3) - this.i.nextInt(var3);
               var10 += this.i.nextInt(3) - this.i.nextInt(6);
               var11 += this.i.nextInt(var3) - this.i.nextInt(var3);
               if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 < this.f && var10 < this.h && var11 < this.g) {
                  var1.growSpikes(var9, var10, var11);
               }
            }
         }
      }
   }

   private void growCacti(World var1) {
      int var2 = this.f * this.g * this.h / 80000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(100) - this.i.nextInt(100);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(100) - this.i.nextInt(100);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growCactus(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growSeaweed(World var1) {
      int var2 = this.f * this.g * this.h / 8000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growSeaweed(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growCoralFans(World var1) {
      int var2 = this.f * this.g * this.h / 8000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);

         for (int var7 = 0; var7 < 25; var7++) {
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for (int var11 = 0; var11 < 20; var11++) {
               var8 += this.i.nextInt(12) - this.i.nextInt(12);
               var9 += this.i.nextInt(3) - this.i.nextInt(6);
               var10 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var8 >= 0 && var9 >= 0 && var10 >= 0 && var8 < this.f && var9 < this.h && var10 < this.g) {
                  var1.growCoralFans(var8, var9, var10);
               }
            }
         }
      }
   }

   private void growStalactites(World var1) {
      int var2 = this.f * this.g * this.h / 80000;
      int var3 = this.i.nextInt(2);

      for (int var4 = 0; var4 < var2; var4++) {
         if (var4 % 100 == 0) {
            this.a((float)var4 * 100.0F / (float)(var2 - 1));
         }

         int var5 = this.i.nextInt(this.f);
         int var6 = this.i.nextInt(this.h);
         int var7 = this.i.nextInt(this.g);

         for (int var8 = 0; var8 < 25; var8++) {
            int var9 = var5;
            int var10 = var6;
            int var11 = var7;

            for (int var12 = 0; var12 < 20; var12++) {
               var9 += this.i.nextInt(12) - this.i.nextInt(12);
               var10 += this.i.nextInt(3) - this.i.nextInt(6);
               var11 += this.i.nextInt(12) - this.i.nextInt(12);
               if (var3 == 0) {
                  var9 += this.i.nextInt(250) - this.i.nextInt(250);
                  var10 += this.i.nextInt(3) - this.i.nextInt(6);
                  var11 += this.i.nextInt(250) - this.i.nextInt(250);
               }

               if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 < this.f && var10 < this.h && var11 < this.g) {
                  if (var3 == 1) {
                     var1.growStalactites(var9, var10, var11);
                  } else {
                     var1.growStalagmites(var9, var10, var11);
                  }
               }
            }
         }
      }
   }

   private void populateFlowersAndMushrooms(World var1, BlockFlower var2, int var3) {
      var3 = (int)((long)this.f * (long)this.g * (long)this.h * (long)var3 / 1600000L);

      for (int var4 = 0; var4 < var3; var4++) {
         if (var4 % 100 == 0) {
            this.a((float)var4 * 100.0F / (float)(var3 - 1));
         }

         int var5 = this.i.nextInt(this.f);
         int var6 = this.i.nextInt(this.h);
         int var7 = this.i.nextInt(this.g);

         for (int var8 = 0; var8 < 10; var8++) {
            int var9 = var5;
            int var10 = var6;
            int var11 = var7;

            for (int var12 = 0; var12 < 10; var12++) {
               var9 += this.i.nextInt(4) - this.i.nextInt(4);
               var10 += this.i.nextInt(2) - this.i.nextInt(2);
               var11 += this.i.nextInt(4) - this.i.nextInt(4);
               if (var9 >= 0
                  && var11 >= 0
                  && var10 > 0
                  && var9 < this.f
                  && var11 < this.g
                  && var10 < this.h
                  && var1.a(var9, var10, var11) == 0
                  && var2.canBlockStay(var1, var9, var10, var11)) {
                  if (var2 instanceof BlockBush) {
                     var1.setBlockAndMetadataWithNotify(var9, var10, var11, var2.at, 1);
                  } else {
                     var1.b(var9, var10, var11, var2.at);
                  }
               }
            }
         }
      }
   }

   private void populateDeadBush(World var1) {
      for (int var2 = 0; var2 < 500; var2++) {
         int var3 = this.i.nextInt(this.f);
         int var4 = this.i.nextInt(this.h);
         int var5 = this.i.nextInt(this.g);

         for (int var6 = 0; var6 < 10; var6++) {
            var3 += this.i.nextInt(100) - this.i.nextInt(100);
            var4 += this.i.nextInt(2) - this.i.nextInt(2);
            var5 += this.i.nextInt(100) - this.i.nextInt(100);
            if (var3 >= 0
               && var5 >= 0
               && var4 > 0
               && var3 < this.f
               && var5 < this.g
               && var4 < this.h
               && var1.a(var3, var4, var5) == 0
               && Block.deadBush.canBlockStay(var1, var3, var4, var5)) {
               var1.b(var3, var4, var5, Block.deadBush.at);
            }
         }
      }
   }

   public boolean populateReeds(World var1, Random var2, int var3, int var4, int var5) {
      for (int var6 = 0; var6 < 20; var6++) {
         int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
         int var8 = var4;
         int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);
         if (var1.f(var7, var4, var9) == net.minecraft.a.a.d.Material.a
            && (
               var1.f(var7 - 1, var4 - 1, var9) == net.minecraft.a.a.d.Material.f
                  || var1.f(var7 + 1, var4 - 1, var9) == net.minecraft.a.a.d.Material.f
                  || var1.f(var7, var4 - 1, var9 - 1) == net.minecraft.a.a.d.Material.f
                  || var1.f(var7, var4 - 1, var9 + 1) == net.minecraft.a.a.d.Material.f
            )) {
            int var10 = 2 + var2.nextInt(var2.nextInt(3) + 1);

            for (int var11 = 0; var11 < var10; var11++) {
               if (Block.reeds.canBlockStay(var1, var7, var8 + var11, var9)) {
                  var1.a(var7, var8 + var11, var9, Block.reeds.at);
               }
            }
         }
      }

      return true;
   }

   public boolean populateVines(World var1, Random var2, int var3, int var4, int var5) {
      for (int var6 = 0; var6 < 20; var6++) {
         int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
         int var8 = var4;
         int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);
         if (var1.f(var7, var4, var9) == net.minecraft.a.a.d.Material.a
            && (
               var1.a(var7 + 1, var4, var9) == Block.moss.at
                  || var1.a(var7 - 1, var4, var9) == Block.moss.at
                  || var1.a(var7, var4, var9 + 1) == Block.moss.at
                  || var1.a(var7, var4, var9 - 1) == Block.moss.at
            )) {
            int var10 = 2 + var2.nextInt(var2.nextInt(14) + 1);
            byte var11 = 0;
            if (var1.b(var7, var4, var9 + 1)) {
               var11 = 2;
            } else if (var1.b(var7, var4, var9 - 1)) {
               var11 = 3;
            } else if (var1.b(var7 + 1, var4, var9)) {
               var11 = 4;
            } else if (var1.b(var7 - 1, var4, var9)) {
               var11 = 5;
            }

            for (int var12 = 0; var12 < var10; var12++) {
               if (var1.a(var7, var8 - var12, var9) == 0) {
                  var1.a(var7, var8 - var12, var9, Block.vine.at);
                  Block.vine.g(var1, var7, var8 - var12, var9, var11);
               }
            }
         }
      }

      return true;
   }

   public boolean populatePumpkins(World var1, Random var2, int var3, int var4, int var5, int var6) {
      for (int var7 = 0; var7 < 64; var7++) {
         int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
         int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
         int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
         if (var1.f(var8, var9, var10) == net.minecraft.a.a.d.Material.a
            && var1.a(var8, var9 - 1, var10) == Block.j.at
            && Block.pumpkin.canExist(var1, var8, var9, var10)) {
            var1.a(var8, var9, var10, var6);
            var1.a(var8, var9 - 1, var10, Block.k.at);
         }
      }

      return true;
   }

   public boolean populateGrass(World var1, Random var2, int var3, int var4, int var5, int var6) {
      int var7;
      do {
         var7 = var1.a(var3, var4, var5);
         var4--;
      } while ((var7 == 0 || var7 == Block.z.at) && var4 > 0);

      for (int var8 = 0; var8 < var1.c; var8++) {
         int var9 = var3 + var2.nextInt(8) - var2.nextInt(8);
         int var10 = var4 + var2.nextInt(4) - var2.nextInt(4);
         int var11 = var5 + var2.nextInt(8) - var2.nextInt(8);
         if (!var1.isSolidTile(var9, var10, var11) && Block.c[var6].canBlockStay(var1, var9, var10, var11)) {
            var1.a(var9, var10, var11, var6);
         }
      }

      return true;
   }

   private int a(int var1, int var2, int var3, int var4) {
      int var5 = 0;
      byte var6 = (byte)var1;
      int var7 = this.f;
      int var8 = this.g;
      int var9 = this.h;
      var2 = var7 * var8 * var9 / 256 / 64 * var2 / 100;

      for (int var10 = 0; var10 < var2; var10++) {
         this.a((float)var10 * 100.0F / (float)(var2 - 1));
         float var11 = this.i.nextFloat() * (float)var7;
         float var12 = this.i.nextFloat() * (float)var9;
         float var13 = this.i.nextFloat() * (float)var8;
         if (var12 <= (float)var4) {
            int var14 = (int)((this.i.nextFloat() + this.i.nextFloat()) * 75.0F * (float)var3 / 100.0F);
            float var15 = this.i.nextFloat() * (float) Math.PI * 2.0F;
            float var16 = 0.0F;
            float var17 = this.i.nextFloat() * (float) Math.PI * 2.0F;
            float var18 = 0.0F;

            for (int var19 = 0; var19 < var14; var19++) {
               var11 += MathHelper.a(var15) * MathHelper.b(var17);
               var13 += MathHelper.b(var15) * MathHelper.b(var17);
               var12 += MathHelper.a(var17);
               var15 += var16 * 0.2F;
               float var29;
               var16 = (var29 = var16 * 0.9F) + (this.i.nextFloat() - this.i.nextFloat());
               var17 = (var17 + var18 * 0.5F) * 0.5F;
               float var30;
               var18 = (var30 = var18 * 0.9F) + (this.i.nextFloat() - this.i.nextFloat());
               float var20 = MathHelper.a((float)var19 * (float) Math.PI / (float)var14) * (float)var3 / 100.0F + 1.0F;

               for (int var21 = (int)(var11 - var20); var21 <= (int)(var11 + var20); var21++) {
                  for (int var22 = (int)(var12 - var20); var22 <= (int)(var12 + var20); var22++) {
                     for (int var23 = (int)(var13 - var20); var23 <= (int)(var13 + var20); var23++) {
                        float var24 = (float)var21 - var11;
                        float var25 = (float)var22 - var12;
                        float var26 = (float)var23 - var13;
                        if (var24 * var24 + var25 * var25 * 2.0F + var26 * var26 < var20 * var20
                           && var21 > 0
                           && var22 > 0
                           && var23 > 0
                           && var21 < this.f - 1
                           && var22 < this.h - 1
                           && var23 < this.g - 1) {
                           int var27 = (var22 * this.g + var23) * this.f + var21;
                           if (this.j[var27] == Block.i.at) {
                              this.j[var27] = var6;
                              var5++;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   private void populateLargeOreVeins(int var1, int var2, int var3, int var4) {
      byte var5 = (byte)var1;
      var4 = this.f;
      int var6 = this.g;
      int var7 = this.h;
      int var8 = var4 * var6 * var7 / 256 / 64 * var2 / 100;

      for (int var9 = 0; var9 < var8; var9++) {
         float var10 = this.i.nextFloat() * (float)var4;
         float var11 = this.i.nextFloat() * (float)var7;
         float var12 = this.i.nextFloat() * (float)var6;
         int var13 = (int)((this.i.nextFloat() + this.i.nextFloat()) * 75.0F * (float)var2 / 100.0F);
         float var14 = this.i.nextFloat() * (float) Math.PI * 2.0F;
         float var15 = 0.0F;
         float var16 = this.i.nextFloat() * (float) Math.PI * 2.0F;
         float var17 = 0.0F;

         for (int var18 = 0; var18 < var13; var18++) {
            var10 += MathHelper.a(var14) * MathHelper.b(var16);
            var12 += MathHelper.b(var14) * MathHelper.b(var16);
            var11 += MathHelper.a(var16);
            var14 += var15 * 0.2F;
            float var28;
            var15 = (var28 = var15 * 0.9F) + (this.i.nextFloat() - this.i.nextFloat());
            var16 = (var16 + var17 * 0.5F) * 0.5F;
            float var29;
            var17 = (var29 = var17 * 0.9F) + (this.i.nextFloat() - this.i.nextFloat());
            float var19 = MathHelper.a((float)var18 * (float) Math.PI / (float)var13) * (float)var2 / 100.0F + 1.0F;

            for (int var20 = (int)(var10 - var19); var20 <= (int)(var10 + var19); var20++) {
               for (int var21 = (int)(var11 - var19); var21 <= (int)(var11 + var19); var21++) {
                  for (int var22 = (int)(var12 - var19); var22 <= (int)(var12 + var19); var22++) {
                     float var23 = (float)var20 - var10;
                     float var24 = (float)var21 - var11;
                     float var25 = (float)var22 - var12;
                     if (var23 * var23 + var24 * var24 * 2.0F + var25 * var25 < var19 * var19
                        && var20 > 0
                        && var21 > 0
                        && var22 > 0
                        && var20 < this.f - 1
                        && var21 < this.h - 1
                        && var22 < this.g - 1) {
                        int var26 = (var21 * this.g + var22) * this.f + var20;
                        if (this.j[var26] == Block.i.at) {
                           this.j[var26] = var5;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean withinSphere(int var1, int var2, int var3, int var4) {
      return var1 * var1 + var2 * var2 + var3 * var3 <= var4 * var4;
   }

   private boolean generateSpheres(int var1, int var2, int var3, int var4, int var5, World var6) {
      byte var7 = (byte)var5;
      byte var8 = (byte)this.i.nextInt(5);
      byte var9 = (byte)Block.k.at;
      if (var8 == 1) {
         var9 = (byte)Block.t.at;
      }

      if (var8 == 1 && this.theme == 1) {
         var9 = (byte)Block.redSand.at;
      }

      if (var8 == 2) {
         var9 = (byte)Block.packedIce.at;
      }

      for (int var10 = 0; var10 <= var4; var10++) {
         for (int var11 = 0; var11 <= var4; var11++) {
            for (int var12 = 0; var12 <= var4; var12++) {
               if (this.withinSphere(var10, var12, var11, var4)) {
                  var6.setBlockWithClipping(var1 + var10, var2 + var12, var3 + var11, var7);
                  var6.setBlockWithClipping(var1 - var10, var2 + var12, var3 + var11, var7);
                  var6.setBlockWithClipping(var1 + var10, var2 + var12, var3 - var11, var7);
                  var6.setBlockWithClipping(var1 - var10, var2 + var12, var3 - var11, var7);
                  var6.setBlockWithClipping(var1 + var10, var2 - var12, var3 + var11, var7);
                  var6.setBlockWithClipping(var1 - var10, var2 - var12, var3 + var11, var7);
                  var6.setBlockWithClipping(var1 + var10, var2 - var12, var3 - var11, var7);
                  var6.setBlockWithClipping(var1 - var10, var2 - var12, var3 - var11, var7);
                  var6.setBlockWithClipping(var1 + var10 - 1, var2 + var12 - 1, var3 + var11 - 1, 0);
                  var6.setBlockWithClipping(var1 - var10 + 1, var2 + var12 - 1, var3 + var11 - 1, 0);
                  var6.setBlockWithClipping(var1 + var10 - 1, var2 + var12 - 1, var3 - var11 + 1, 0);
                  var6.setBlockWithClipping(var1 - var10 + 1, var2 + var12 - 1, var3 - var11 + 1, 0);
                  var6.setBlockWithClipping(var1 + var10 - 1, var2 - var12 + 1, var3 + var11 - 1, 0);
                  var6.setBlockWithClipping(var1 - var10 + 1, var2 - var12 + 1, var3 + var11 - 1, 0);
                  var6.setBlockWithClipping(var1 + var10 - 1, var2 - var12 + 1, var3 - var11 + 1, 0);
                  var6.setBlockWithClipping(var1 - var10 + 1, var2 - var12 + 1, var3 - var11 + 1, 0);
               }
            }
         }
      }

      int var39 = var4 * 2;
      int var40 = var4 * 2;
      int var41 = var4 * 2;
      int[] var13 = new int[var39 * var40];
      net.minecraft.a.a.c.a.C_d var14 = new net.minecraft.a.a.c.a.C_d(new net.minecraft.a.a.c.a.C_c(this.i, 8), new net.minecraft.a.a.c.a.C_c(this.i, 8));
      float var15 = 1.3F;

      for (int var16 = 0; var16 < var39; var16++) {
         for (int var17 = 0; var17 < var40; var17++) {
            double var18 = var14.a((double)((float)(var1 + var16 - var4) * var15), (double)((float)(var3 + var17 - var4) * var15)) / 1.0 - 4.0;
            double var20 = var18 / 12.0;
            if (var20 < 0.0) {
               var20 *= 0.8;
            }

            var13[var16 + var17 * var39] = (int)var20;
         }
      }

      net.minecraft.a.a.c.a.C_c var42 = new net.minecraft.a.a.c.a.C_c(this.i, 8);

      for (int var43 = 0; var43 < var39; var43++) {
         double var44 = Math.abs(((double)var43 / (double)(var39 - 1) - 0.5) * 2.0);

         for (int var45 = 0; var45 < var40; var45++) {
            double var21 = Math.abs(((double)var45 / (double)(var40 - 1) - 0.5) * 2.0);
            double var23 = Math.max(var44, var21);
            var23 = var23 * var23 * var23;
            int var25 = (int)(var42.a((double)var43, (double)var45) / 12.0) - 4;
            int var26 = var13[var43 + var45 * var39] + var2;
            int var27 = var26 + var25;

            for (int var28 = 0; var28 < var41; var28++) {
               int var29 = var2 + var28 - var4;
               int var30 = var1 + var43 - var4;
               int var31 = var3 + var45 - var4;
               double var32 = (double)(var30 - var1);
               double var34 = (double)(var29 - var2);
               double var36 = (double)(var31 - var3);
               if (!(var32 * var32 + var34 * var34 + var36 * var36 > (double)((var4 - 1) * (var4 - 1)))) {
                  int var38 = 0;
                  if (var29 <= var26) {
                     var38 = var9;
                  }

                  if (var29 < var27) {
                     var38 = Block.i.at;
                  }

                  if (var38 != 0) {
                     var6.setBlockWithClipping(var30, var29, var31, var38);
                  }
               }
            }
         }
      }

      this.a(Block.x.at, 1000, 10, (var41 << 2) / 5);
      this.a(Block.w.at, 800, 8, var41 * 3 / 5);
      this.a(Block.v.at, 500, 6, (var41 << 1) / 5);
      this.a(Block.al.at, 500, 2, var41 / 5);
      this.a(Block.oreEmerald.at, 4000, 1, var41 / 5);
      return true;
   }

   private void a() {
      int var1 = Block.q.at;
      if (this.theme == 1) {
         var1 = Block.s.at;
      }

      int var2 = this.f * this.g * this.h / 1000;

      for (int var3 = 0; var3 < var2; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var2 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = this.i.nextInt(this.h);
         int var6 = this.i.nextInt(this.g);
         if (this.j[(var5 * this.g + var6) * this.f + var4] == 0) {
            long var7;
            if ((var7 = this.a(var4, var5, var6, 0, 255)) > 0L && var7 < 640L) {
               this.a(var4, var5, var6, 255, var1);
            } else {
               this.a(var4, var5, var6, 255, 0);
            }
         }
      }

      this.a(100.0F);
   }

   private void b() {
      this.m++;
      this.a(0.0F);
   }

   private void a(float var1) {
      if (var1 < 0.0F) {
         throw new IllegalStateException("Failed to set next phase!");
      } else {
         int var2 = (int)(((float)(this.m - 1) + var1 / 100.0F) * 100.0F / (float)this.n);
         this.e.a(var2);
      }
   }

   private void c() {
      int var1 = this.f * this.g * this.h / (this.b ? 2000 : 1000);
      int var2 = this.l;

      for (int var3 = 0; var3 < var1; var3++) {
         if (var3 % 100 == 0) {
            this.a((float)var3 * 100.0F / (float)(var1 - 1));
         }

         int var4 = this.i.nextInt(this.f);
         int var5 = Math.min(Math.min(this.i.nextInt(var2), this.i.nextInt(var2)), Math.min(this.i.nextInt(var2), this.i.nextInt(var2)));
         if (this.b) {
            var5 = this.i.nextInt(this.h);
         }

         int var6 = this.i.nextInt(this.g);
         if (this.j[(var5 * this.g + var6) * this.f + var4] == 0) {
            long var7;
            if ((var7 = this.a(var4, var5, var6, 0, 255)) > 0L && var7 < 640L) {
               this.a(var4, var5, var6, 255, Block.s.at);
            } else {
               this.a(var4, var5, var6, 255, 0);
            }
         }
      }

      this.a(100.0F);
   }

   private long a(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = (byte)var5;
      byte var7 = (byte)var4;
      ArrayList var8 = new ArrayList();
      byte var9 = 0;
      int var10 = 1;
      int var11 = 1;

      while (1 << var10 < this.f) {
         var10++;
      }

      while (1 << var11 < this.g) {
         var11++;
      }

      int var12 = this.g - 1;
      int var13 = this.f - 1;
      int var14 = var9 + 1;
      this.p[0] = ((var2 << var11) + var3 << var10) + var1;
      long var15 = 0L;
      var1 = this.f * this.g;

      while (var14 > 0) {
         var2 = this.p[--var14];
         if (var14 == 0 && var8.size() > 0) {
            this.p = (int[])var8.remove(var8.size() - 1);
            var14 = this.p.length;
         }

         var3 = var2 >> var10 & var12;
         int var17 = var2 >> var10 + var11;

         int var18;
         int var19;
         for (var19 = var18 = var2 & var13; var18 > 0 && this.j[var2 - 1] == var7; var2--) {
            var18--;
         }

         while (var19 < this.f && this.j[var2 + var19 - var18] == var7) {
            var19++;
         }

         int var20 = var2 >> var10 & var12;
         int var21 = var2 >> var10 + var11;
         if (var5 == 255 && (var18 == 0 || var19 == this.f - 1 || var17 == 0 || var17 == this.h - 1 || var3 == 0 || var3 == this.g - 1)) {
            return -1L;
         }

         if (var20 != var3 || var21 != var17) {
            System.out.println("Diagonal flood!?");
         }

         boolean var22 = false;
         boolean var23 = false;
         boolean var24 = false;

         for (var15 += (long)(var19 - var18); var18 < var19; var18++) {
            this.j[var2] = var6;
            if (var3 > 0) {
               boolean var25;
               if ((var25 = this.j[var2 - this.f] == var7) && !var22) {
                  if (var14 == this.p.length) {
                     var8.add(this.p);
                     this.p = new int[1048576];
                     var14 = 0;
                  }

                  this.p[var14++] = var2 - this.f;
               }

               var22 = var25;
            }

            if (var3 < this.g - 1) {
               boolean var30;
               if ((var30 = this.j[var2 + this.f] == var7) && !var23) {
                  if (var14 == this.p.length) {
                     var8.add(this.p);
                     this.p = new int[1048576];
                     var14 = 0;
                  }

                  this.p[var14++] = var2 + this.f;
               }

               var23 = var30;
            }

            if (var17 > 0) {
               byte var26 = this.j[var2 - var1];
               if ((var6 == Block.r.at || var6 == Block.s.at) && (var26 == Block.p.at || var26 == Block.q.at)) {
                  this.j[var2 - var1] = (byte)Block.ae.at;
               }

               boolean var31;
               if ((var31 = var26 == var7) && !var24) {
                  if (var14 == this.p.length) {
                     var8.add(this.p);
                     this.p = new int[1048576];
                     var14 = 0;
                  }

                  this.p[var14++] = var2 - var1;
               }

               var24 = var31;
            }

            var2++;
         }
      }

      return var15;
   }
}
