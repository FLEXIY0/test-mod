package net.minecraft.a.a;

import com.a.a.NBTTagCompound;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockContainer;
import util.MathHelper;

public class World {
   private static float[] F = new float[16];
   public int a;
   public int b;
   public int c;
   public byte[] d;
   public byte[] e;
   public String f;
   public String g;
   public long h;
   public long seed;
   public int i;
   public int j;
   public int k;
   public float l;
   public int m = Block.p.at;
   public int defaultBlock = Block.j.at;
   public List<C_d> n = new ArrayList<>();
   private List<C_e> G = new LinkedList<>();
   public Map<Object, TileEntity> o = new HashMap<>();
   public List<TileEntity> H = new ArrayList<>();
   int[] p;
   public Random q = new Random();
   public Random I = new Random();
   private int J = this.q.nextInt();
   public C_i r;
   public int s;
   public int t;
   public int u;
   public int v = 10079487;
   public int w = 16777215;
   public int x = 16777215;
   private int K = 0;
   public EntityLiving y;
   public boolean z = true;
   public int A = 15;
   public int B = 15;
   public net.minecraft.a.a.a.C_c C = new net.minecraft.a.a.a.C_c(this);
   public C_n season = new C_n();
   public int D = 650;
   private static short N;
   private short[] O = new short[1048576];
   private int[] P = new int[1048576];
   private int[] Q = new int[1048576];
   public int E = 2;
   public int gamemode = 0;
   private float[] colorsSunriseSunset = new float[4];
   public int daysPassed;
   public int theme = 0;
   public int type = 0;
   private boolean tileEntityFlag;
   public boolean multiplayerWorld = false;
   public boolean cantGrow;
   protected boolean bloodMoon;
   public boolean isNight = false;
   public boolean physicsDisabled = false;
   public boolean AIDisabled = false;
   public boolean cheats = false;
   public boolean hardcore = false;
   public ArrayList<net.minecraft.a.d.C_b> collidingBoxes = new ArrayList<>();
   public d mc;
   public int bloodMoonChance;
   protected float prevRainingStrength;
   protected float rainingStrength;
   protected float prevThunderingStrength;
   protected float thunderingStrength;
   protected boolean raining;
   protected int rainTime;
   protected boolean thundering;
   protected int thunderTime;
   protected int weatherUpdates;
   public int lightStrike;
   protected float windForce;
   protected byte windDirection;
   protected int windTime;
   protected float fogDistance = 512.0F;
   protected int fogTime;
   protected int fogDensity;
   public String fileName;
   protected int soundCounter;
   public boolean freezeWeatherUpdates = false;
   public List<EntityPlayer> playerEntities = new ArrayList<>();
   public List<Entity> loadedEntityList = new ArrayList<>();
   public C_j chunkMap = new C_j();
   private List<Entity> unloadedEntityList = new ArrayList<>();
   public boolean revival = true;
   private static int lightingUpdatesScheduled = 0;
   private List<C_c> lightingToUpdate = new ArrayList<>();
   public byte[] light;
   private int minHeight;
   private int lightingUpdatesCounter;
   public boolean child = false;
   public boolean active = false;
   public String parentName = "";
   public static HashMap<Integer, Integer> seasonColor = new C_p();

   public void a() {
      if (this.d == null) {
         throw new RuntimeException("The level is corrupt!");
      } else {
         this.n = new ArrayList<>();
         this.q = new Random();
         this.J = this.q.nextInt();
         this.soundCounter = this.I.nextInt(12000);
         this.G = new ArrayList<>();
         if (this.r == null) {
            this.r = new C_i(this.a, this.c, this.b);
         }

         this.updateWeatherStatus();
      }
   }

   public void setPartialData(int var1, int var2, int var3, byte[] var4, byte[] var5, byte[] var6, int[] var7) {
      if (var5 != null && var5.length == 0) {
         var5 = null;
      }

      if (var6 != null && var6.length == 0) {
         var6 = null;
      }

      if (var7 != null && var7.length == 0) {
         var7 = null;
      }

      this.a = var1;
      this.b = var3;
      this.c = var2;
      this.d = var4;
      this.light = new byte[var4.length];

      for (int var11 = 0; var11 < this.a; var11++) {
         for (int var8 = 0; var8 < this.b; var8++) {
            for (int var9 = 0; var9 < this.c; var9++) {
               int var10 = 0;
               if (this.type != 8) {
                  if (var9 <= 1 && var9 < this.t - 1 && var4[((var9 + 1) * this.b + var8) * this.a + var11] == 0 && this.type == 5) {
                     var10 = Block.s.at;
                  } else if (var9 < this.t - 1) {
                     var10 = Block.o.at;
                  } else if (var9 < this.t) {
                     if (this.t > this.s && this.m == Block.p.at) {
                        if (this.theme == 4) {
                           var10 = Block.mycelium.at;
                        } else {
                           var10 = this.defaultBlock;
                        }
                     } else if (this.type == 4) {
                        var10 = Block.redSand.at;
                     } else if (this.theme == 4) {
                        var10 = Block.mycelium.at;
                     } else {
                        var10 = Block.k.at;
                     }
                  } else if (var9 < this.s) {
                     var10 = this.m;
                  }
               }

               var4[(var9 * this.b + var8) * this.a + var11] = (byte)var10;
               if (var9 == 1 && var11 != 0 && var8 != 0 && var11 != this.a - 1 && var8 != this.b - 1) {
                  var9 = this.c - 2;
               }
            }
         }
      }

      this.p = new int[var1 * var3];
      Arrays.fill(this.p, this.c);
      if (var5 == null) {
         this.e = new byte[var4.length];
      } else {
         this.e = var5;
      }

      if (var6 == null) {
         this.light = new byte[var4.length];
      } else {
         this.light = var6;
      }

      if (var7 == null) {
         this.p = new int[var1 * var3];
         Arrays.fill(this.p, this.c);
         this.initLighting();
      } else {
         this.p = var7;
      }

      if (var6 != null) {
         this.lightingToUpdate.clear();
      }

      for (int var12 = 0; var12 < this.n.size(); var12++) {
         this.n.get(var12).a();
      }

      this.G.clear();
      this.b();
      this.a();
      System.gc();
   }

   public void generate(int var1, int var2, int var3, byte[] var4, byte[] var5, byte[] var6, int[] var7) {
      if (var5 != null && var5.length == 0) {
         var5 = null;
      }

      if (var6 != null && var6.length == 0) {
         var6 = null;
      }

      if (var7 != null && var7.length == 0) {
         var7 = null;
      }

      this.a = var1;
      this.b = var3;
      this.c = var2;
      this.d = var4;
      this.light = new byte[var4.length];

      for (int var11 = 0; var11 < this.a; var11++) {
         for (int var8 = 0; var8 < this.b; var8++) {
            for (int var9 = 0; var9 < this.c; var9++) {
               int var10 = 0;
               if (this.type != 8) {
                  if (var9 <= 1 && var9 < this.t - 1 && var4[((var9 + 1) * this.b + var8) * this.a + var11] == 0) {
                     var10 = Block.s.at;
                  } else if (var9 < this.t - 1) {
                     var10 = Block.o.at;
                  } else if (var9 < this.t) {
                     if (this.t > this.s && this.m == Block.p.at) {
                        if (this.theme == 4) {
                           var10 = Block.mycelium.at;
                        } else {
                           var10 = this.defaultBlock;
                        }
                     } else if (this.type == 4) {
                        var10 = Block.redSand.at;
                     } else {
                        var10 = Block.k.at;
                     }
                  } else if (var9 < this.s) {
                     var10 = this.m;
                  }
               }

               var4[(var9 * this.b + var8) * this.a + var11] = (byte)var10;
               if (var9 == 1 && var11 != 0 && var8 != 0 && var11 != this.a - 1 && var8 != this.b - 1) {
                  var9 = this.c - 2;
               }
            }
         }
      }

      this.p = new int[var1 * var3];
      Arrays.fill(this.p, this.c);
      if (var5 == null) {
         this.e = new byte[var4.length];
      } else {
         this.e = var5;
      }

      if (var6 == null) {
         this.light = new byte[var4.length];
      } else {
         this.light = var6;
      }

      if (var7 == null) {
         this.p = new int[var1 * var3];
         Arrays.fill(this.p, this.c);
         this.initLighting();
      } else {
         this.p = var7;
      }

      if (var6 != null) {
         this.lightingToUpdate.clear();
      }

      for (int var12 = 0; var12 < this.n.size(); var12++) {
         this.n.get(var12).a();
      }

      this.G.clear();
      this.b();
      this.a();
      System.gc();
   }

   public int calculateSkylightSubtracted(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (MathHelper.b(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.5F);
      if (var3 < 0.0F) {
         var3 = 0.0F;
      }

      if (var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0 - (double)(this.getRainStatus(var1) * 5.0F) / 16.0));
      var3 = (float)((double)var3 * (1.0 - (double)(this.getThunderStatus(var1) * 5.0F) / 16.0));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public void b() {
      Random var1 = new Random();
      int var2 = 0;

      label79:
      while (true) {
         var2++;
         int var3 = var1.nextInt(this.a / 2) + this.a / 4;
         int var4 = var1.nextInt(this.b / 2) + this.b / 4;
         int var5 = this.a(var3, var4) + 1;
         if (this.type == 5) {
            var5 = this.getLastUncoveredBlock(var3, var4) + 1;
         }

         if (var2 == 1000000) {
            this.i = var3;
            this.j = var5 + 3;
            this.k = var4;
            this.l = 180.0F;
            return;
         }

         if (var5 >= 4 && var5 > this.s) {
            for (int var6 = var3 - 3; var6 <= var3 + 3; var6++) {
               for (int var7 = var5 - 1; var7 <= var5 + 2; var7++) {
                  for (int var8 = var4 - 3 - 2; var8 <= var4 + 3; var8++) {
                     if (this.f(var6, var7, var8).a()) {
                        continue label79;
                     }
                  }
               }
            }

            int var9 = var5 - 2;

            for (int var10 = var3 - 3; var10 <= var3 + 3; var10++) {
               for (int var11 = var4 - 3 - 2; var11 <= var4 + 3; var11++) {
                  if (!Block.e[this.a(var10, var9, var11)]) {
                     continue label79;
                  }
               }
            }

            this.i = var3;
            this.j = var5;
            this.k = var4;
            this.l = 180.0F;
            return;
         }
      }
   }

   public void a(C_d var1) {
      for (int var2 = 0; var2 < this.r.e.size(); var2++) {
         var1.a(this.r.e.get(var2));
      }

      this.n.add(var1);
   }

   public void b(C_d var1) {
      this.n.remove(var1);
   }

   public List<net.minecraft.a.d.C_b> getCollidingBoundingBoxes(Entity var1, net.minecraft.a.d.C_b var2) {
      this.collidingBoxes.clear();
      int var3 = MathHelper.a((double)var2.a);
      int var4 = MathHelper.a((double)var2.d + 1.0);
      int var5 = MathHelper.a((double)var2.b);
      int var6 = MathHelper.a((double)var2.e + 1.0);
      int var7 = MathHelper.a((double)var2.c);
      int var8 = MathHelper.a((double)var2.f + 1.0);
      if (var2.a < 0.0F) {
         var3--;
      }

      if (var2.b < 0.0F) {
         var5--;
      }

      if (var2.c < 0.0F) {
         var7--;
      }

      for (int var9 = var3; var9 < var4; var9++) {
         for (int var10 = var7; var10 < var8; var10++) {
            for (int var11 = var5 - 1; var11 < var6; var11++) {
               Block var12 = Block.c[this.a(var9, var11, var10)];
               if (var12 != null) {
                  var12.getCollidingBoundingBoxes(this, var9, var11, var10, var2, this.collidingBoxes);
                  net.minecraft.a.d.C_b var13;
                  if ((var13 = var12.getCollisionBoundingBoxFromPool(this, var9, var11, var10)) != null && var2.a(var13)) {
                     this.collidingBoxes.add(var13);
                  }
               }
            }
         }
      }

      return this.collidingBoxes;
   }

   public int countBlocks(net.minecraft.a.d.C_b var1, int var2) {
      int var3 = 0;
      int var4 = (int)var1.a;
      int var5 = (int)var1.d + 1;
      int var6 = (int)var1.b;
      int var7 = (int)var1.e + 1;
      int var8 = (int)var1.c;
      int var9 = (int)var1.f + 1;
      if (var1.a < 0.0F) {
         var4--;
      }

      if (var1.b < 0.0F) {
         var6--;
      }

      if (var1.c < 0.0F) {
         var8--;
      }

      for (int var10 = var4; var10 < var5; var10++) {
         for (int var11 = var6; var11 < var7; var11++) {
            for (int var12 = var8; var12 < var9; var12++) {
               if (var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 < this.a && var11 < this.c && var12 < this.b && this.a(var10, var11, var12) == var2) {
                  var3++;
               }
            }
         }
      }

      return var3;
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = this.a(var1, var2, var3);
      int var8 = this.a(var4, var5, var6);
      this.a(var1, var2, var3, var8);
      this.a(var4, var5, var6, var7);
      this.c(var1, var2, var3, var8);
      this.c(var4, var5, var6, var7);
   }

   public boolean a(int var1, int var2, int var3, int var4) {
      return this.setBlockAndMetadata(var1, var2, var3, var4, 0);
   }

   public boolean setBlockAndMetadata(int var1, int var2, int var3, int var4, int var5) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var1 < this.a - 1 && var2 < this.c - 1 && var3 < this.b - 1) {
         if (var4 == this.d[(var2 * this.b + var3) * this.a + var1]) {
            return false;
         } else {
            int var6 = this.getHeightValue(var1, var3);
            if (var4 == 0 && (var1 == 0 || var3 == 0 || var1 == this.a - 1 || var3 == this.b - 1) && var2 >= this.t && var2 < this.s) {
               var4 = Block.p.at;
            }

            byte var7 = this.d[(var2 * this.b + var3) * this.a + var1];
            this.d[(var2 * this.b + var3) * this.a + var1] = (byte)var4;
            if (var7 != 0 && !this.multiplayerWorld) {
               Block.c[var7 & 255].b(this, var1, var2, var3);
               Block.c[var7 & 255].breakBlock(this, var1, var2, var3, var7, this.e(var1, var2, var3));
            }

            this.setBlockMetadata(var1, var2, var3, var5);
            if (Block.f[var4] != 0) {
               if (var2 >= var6) {
                  this.relightBlock(var1, var2 + 1, var3);
               }
            } else if (var2 == var6 - 1) {
               this.relightBlock(var1, var2, var3);
            }

            this.scheduleLightingUpdate(C_l.Sky, var1, var2, var3, var1, var2, var3);
            this.scheduleLightingUpdate(C_l.Block, var1, var2, var3, var1, var2, var3);
            this.updateSkylight_do(var1, var3);
            if (var4 != 0 && !this.multiplayerWorld && var4 != Block.Z.at && var4 != Block.stairUpsideDown.at) {
               Block.c[var4].d(this, var1, var2, var3);
            }

            for (int var8 = 0; var8 < this.n.size(); var8++) {
               this.n.get(var8).a(var1, var2, var3);
            }

            this.markBlocksDirtyVertical(var1, var2, var3, var4);
            return true;
         }
      } else {
         return false;
      }
   }

   public final void d() {
      this.updatingLighting();
   }

   public final void scheduleLightingUpdate(C_l var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      lightingUpdatesScheduled++;

      try {
         if (lightingUpdatesScheduled != 50) {
            int var8 = this.lightingToUpdate.size();
            int var9 = 5;
            if (var9 > var8) {
               var9 = var8;
            }

            for (int var10 = 0; var10 < var9; var10++) {
               C_c var11 = this.lightingToUpdate.get(this.lightingToUpdate.size() - var10 - 1);
               if (var11.skyBlock == var1 && var11.getLightUpdated(var2, var3, var4, var5, var6, var7)) {
                  return;
               }
            }

            this.lightingToUpdate.add(new C_c(var1, var2, var3, var4, var5, var6, var7));
            var9 = 1000000;
            if (this.lightingToUpdate.size() > 1000000) {
               System.out.println("More than " + var9 + " updates, aborting lighting updates");
               this.lightingToUpdate.clear();
            }
         }
      } finally {
         lightingUpdatesScheduled--;
      }
   }

   public void initLighting() {
      Arrays.fill(this.p, 0);
      int var1 = this.c - 1;
      this.lightingToUpdate.clear();

      for (int var2 = 0; var2 <= this.a; var2++) {
         for (int var3 = 0; var3 <= this.b; var3++) {
            this.setHeightValue(var2, var3, this.c - 1);
            this.relightBlock(var2, this.c - 1, var3);
            var1 = Math.min(this.minHeight, this.getHeightValue(var2, var3));
         }
      }

      this.minHeight = var1;

      for (int var4 = 0; var4 <= this.a; var4++) {
         for (int var5 = 0; var5 <= this.b; var5++) {
            this.updateSkylight_do(var4, var5);
         }
      }
   }

   public int getHeightValue(int var1, int var2) {
      try {
         return this.p[var1 + var2 * this.a];
      } catch (Exception var4) {
         return 0;
      }
   }

   public void setHeightValue(int var1, int var2, int var3) {
      try {
         this.p[var1 + var2 * this.a] = var3;
      } catch (Exception var5) {
      }
   }

   private void updateSkylight_do(int var1, int var2) {
      if (var1 >= 0 && var1 < this.a && var2 >= 0 && var2 < this.b) {
         int var3 = this.getHeightValue(var1, var2);
         this.checkSkylightNeighborHeight(var1 - 1, var2, var3);
         this.checkSkylightNeighborHeight(var1 + 1, var2, var3);
         this.checkSkylightNeighborHeight(var1, var2 - 1, var3);
         this.checkSkylightNeighborHeight(var1, var2 + 1, var3);
      }
   }

   private void checkSkylightNeighborHeight(int var1, int var2, int var3) {
      if (var1 >= 0 && var1 < this.a && var2 >= 0 && var2 < this.b && var3 >= 0 && var3 < this.c) {
         int var4 = this.getHeightValue(var1, var2);
         if (var4 > var3) {
            this.scheduleLightingUpdate(C_l.Sky, var1, var3, var2, var1, var4, var2);
         } else if (var4 < var3) {
            this.scheduleLightingUpdate(C_l.Sky, var1, var4, var2, var1, var3, var2);
         }
      }
   }

   private void relightBlock(int var1, int var2, int var3) {
      int var4 = this.getHeightValue(var1, var3);
      int var5 = var4;
      if (var2 > var4) {
         var5 = var2;
      }

      while (var5 > 0 && Block.f[this.a(var1, var5 - 1, var3)] == 0) {
         var5--;
      }

      if (var5 != var4) {
         int var6 = var5;
         int var7 = var4;
         if (var5 > var4) {
            var7 = var5;
            var6 = var4;
         }

         for (int var8 = 0; var8 < this.n.size(); var8++) {
            this.n.get(var8).a(var1, var6, var3, var1, var7, var3);
         }

         this.setHeightValue(var1, var3, var5);
         if (var5 < this.minHeight) {
            this.minHeight = var5;
         } else {
            int var13 = this.c - 1;

            for (int var9 = 0; var9 < 16; var9++) {
               for (int var10 = 0; var10 < 16; var10++) {
                  if (this.getHeightValue(var9, var10) < var13) {
                     var13 = this.getHeightValue(var9, var10);
                  }
               }
            }

            this.minHeight = var13;
         }

         if (var5 < var4) {
            for (int var15 = var5; var15 < var4; var15++) {
               this.setSavedLightValue(C_l.Sky, var1, var15, var3, 15);
            }
         } else {
            this.scheduleLightingUpdate(C_l.Sky, var1, var4, var3, var1, var5, var3);

            for (int var14 = var4; var14 < var5; var14++) {
               this.setSavedLightValue(C_l.Sky, var1, var14, var3, 0);
            }
         }

         int var16 = 15;

         int var11;
         for (var11 = var5; var5 > 0 && var16 > 0; this.setSavedLightValue(C_l.Sky, var1, var5, var3, var16)) {
            int var12 = Block.f[this.a(var1, --var5, var3)];
            if (var12 == 0) {
               var12 = 1;
            }

            var16 -= var12;
            if (var16 < 0) {
               var16 = 0;
            }
         }

         while (var5 > 0 && Block.f[this.a(var1, var5 - 1, var3)] == 0) {
            var5--;
         }

         if (var5 != var11) {
            if (var5 > var11) {
               int var17 = var5;
               var5 = var11;
               var11 = var17;
            }

            if (var5 > var6) {
               var5 = var6;
            }

            if (var11 < var7) {
               var11 = var7;
            }

            this.scheduleLightingUpdate(C_l.Sky, var1 - 1, var5, var3 - 1, var1 + 1, var11, var3 + 1);
         }
      }
   }

   public final boolean updatingLighting() {
      if (this.lightingUpdatesCounter >= 50) {
         return false;
      } else {
         this.lightingUpdatesCounter++;
         int var1 = 500;

         while (!this.lightingToUpdate.isEmpty()) {
            if (--var1 <= 0) {
               this.lightingUpdatesCounter--;
               return true;
            }

            this.lightingToUpdate.remove(this.lightingToUpdate.size() - 1).updateLight(this);
         }

         this.lightingUpdatesCounter--;
         return false;
      }
   }

   public final void neighborLightPropagationChanged(C_l var1, int var2, int var3, int var4, int var5) {
      if (var2 >= 0 && var2 < this.a && var3 >= 0 && var3 < this.c && var4 >= 0 && var4 < this.b) {
         if (var1 == C_l.Sky) {
            if (this.l(var2, var3, var4)) {
               var5 = 15;
            }
         } else if (var1 == C_l.Block) {
            int var6 = this.a(var2, var3, var4);
            if (Block.h[var6] > var5) {
               var5 = Block.h[var6];
            }
         }

         if (this.getSavedLightValue(var1, var2, var3, var4) != var5) {
            this.scheduleLightingUpdate(var1, var2, var3, var4, var2, var3, var4);
         }
      }
   }

   public final int getSavedLightValue(C_l var1, int var2, int var3, int var4) {
      if (var2 < 0) {
         var2 = 0;
      } else if (var2 >= this.a) {
         var2 = this.a - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      } else if (var3 >= this.c) {
         var3 = this.c - 1;
      }

      if (var4 < 0) {
         var4 = 0;
      } else if (var4 >= this.b) {
         var4 = this.b - 1;
      }

      byte var5 = this.light[(var3 * this.b + var4) * this.a + var2];
      if (var1 == C_l.Sky) {
         var5 = (byte)(var5 >>> 4);
      }

      return var5 & 15;
   }

   public final void setSavedLightValue(C_l var1, int var2, int var3, int var4, int var5) {
      int var6 = (var3 * this.b + var4) * this.a + var2;
      byte var7 = this.light[var6];
      if (var1 == C_l.Sky) {
         var7 = (byte)(var7 & 15);
         var7 = (byte)(var7 | (byte)(var5 << 4));
      } else {
         var7 = (byte)(var7 & -16);
         var7 = (byte)(var7 | (byte)(var5 & 15));
      }

      this.light[var6] = var7;

      for (int var8 = 0; var8 < this.n.size(); var8++) {
         this.n.get(var8).a(var2, var3, var4);
      }
   }

   public boolean setBlockWithClipping(int var1, int var2, int var3, int var4) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var1 < this.a - 1 && var2 < this.c - 1 && var3 < this.b - 1) {
         if (var4 == this.d[(var2 * this.b + var3) * this.a + var1]) {
            return false;
         } else {
            if (var4 == 0 && (var1 == 0 || var3 == 0 || var1 == this.a - 1 || var3 == this.b - 1) && var2 >= this.t && var2 < this.s) {
               var4 = Block.p.at;
            }

            this.d[(var2 * this.b + var3) * this.a + var1] = (byte)var4;
            this.setBlockMetadata(var1, var2, var3, 0);
            this.markBlocksDirtyVertical(var1, var2, var3, var4);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean b(int var1, int var2, int var3, int var4) {
      if (this.a(var1, var2, var3, var4)) {
         this.c(var1, var2, var3, var4);
         return true;
      } else {
         return false;
      }
   }

   public void markBlocksDirtyVertical(int var1, int var2, int var3, int var4) {
      if (var3 > var4) {
         int var5 = var4;
         var4 = var3;
         var3 = var5;
      }

      this.markBlocksDirty(var1, var3, var2, var1, var4, var2);
   }

   public void markBlocksDirty(int var1, int var2, int var3, int var4, int var5, int var6) {
      for (int var7 = 0; var7 < this.n.size(); var7++) {
         this.n.get(var7).a(var1, var2, var3, var4, var5, var6);
      }
   }

   public boolean setBlockAndMetadataWithNotify(int var1, int var2, int var3, int var4, int var5) {
      if (this.setBlockAndMetadata(var1, var2, var3, var4, var5)) {
         this.notifyBlockChange(var1, var2, var3, var4);
         return true;
      } else {
         return false;
      }
   }

   public void setBlockMetadataWithNotify(int var1, int var2, int var3, int var4) {
      this.setBlockMetadata(var1, var2, var3, var4);
      int var5 = this.a(var1, var2, var3);
      if (Block.hasMetadata[var5 & 0xFF]) {
         this.notifyBlockChange(var1, var2, var3, var5);
      } else {
         this.c(var1, var2, var3, var5);
      }
   }

   public void markBlockNeedsUpdate(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < this.n.size(); var4++) {
         this.n.get(var4).a(var1, var2, var3);
      }
   }

   protected void notifyBlockChange(int var1, int var2, int var3, int var4) {
      this.markBlockNeedsUpdate(var1, var2, var3);
      this.c(var1, var2, var3, var4);
   }

   public void c(int var1, int var2, int var3, int var4) {
      this.h(var1 - 1, var2, var3, var4);
      this.h(var1 + 1, var2, var3, var4);
      this.h(var1, var2 - 1, var3, var4);
      this.h(var1, var2 + 1, var3, var4);
      this.h(var1, var2, var3 - 1, var4);
      this.h(var1, var2, var3 + 1, var4);
   }

   public boolean d(int var1, int var2, int var3, int var4) {
      if (var1 >= 0 && var2 >= 0 && var3 >= 0 && var1 < this.a && var2 < this.c && var3 < this.b) {
         if (var4 == this.d[(var2 * this.b + var3) * this.a + var1]) {
            return false;
         } else {
            this.d[(var2 * this.b + var3) * this.a + var1] = (byte)var4;
            return true;
         }
      } else {
         return false;
      }
   }

   private void h(int var1, int var2, int var3, int var4) {
      Block var5;
      if (var1 >= 0
         && var2 >= 0
         && var3 >= 0
         && var1 < this.a
         && var2 < this.c
         && var3 < this.b
         && (var5 = Block.c[this.d[(var2 * this.b + var3) * this.a + var1] & 255]) != null) {
         var5.b(this, var1, var2, var3, var4);
      }
   }

   public int a(int var1, int var2, int var3) {
      if (var1 < 0) {
         var1 = 0;
      } else if (var1 >= this.a) {
         var1 = this.a - 1;
      }

      if (var2 < 0) {
         var2 = 0;
      } else if (var2 >= this.c) {
         var2 = this.c - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      } else if (var3 >= this.b) {
         var3 = this.b - 1;
      }

      return this.d[(var2 * this.b + var3) * this.a + var1] & 0xFF;
   }

   public boolean b(int var1, int var2, int var3) {
      Block var4;
      return (var4 = Block.c[this.a(var1, var2, var3)]) == null ? false : var4.isOpaqueCube(this.e(var1, var2, var3));
   }

   public void c() {
      this.r.a();
      this.tileEntityFlag = true;

      for (int var1 = 0; var1 < this.H.size(); var1++) {
         TileEntity var2 = this.H.get(var1);
         if (!var2.isRemoving()) {
            var2.d();
         }

         if (var2.isRemoving()) {
            this.H.remove(var2);
            this.i(var2.b, var2.c, var2.d);
            var1--;
         }
      }

      this.tileEntityFlag = false;
   }

   public float a(float var1) {
      var1 = this.c(var1);
      if ((var1 = 1.0F - (MathHelper.b(var1 * (float) Math.PI * 2.0F) * 2.0F + 0.75F)) < 0.0F) {
         var1 = 0.0F;
      }

      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      if (this.type == 8) {
         return 1.0F;
      } else {
         if (var1 == 1.0F) {
            this.isNight = true;
         } else {
            this.isNight = false;
         }

         return var1 * var1 * 0.5F;
      }
   }

   public net.minecraft.a.d.C_a b(float var1) {
      if ((var1 = MathHelper.b(this.c(var1) * (float) Math.PI * 2.0F) * 2.0F + 0.5F) < 0.0F) {
         var1 = 0.0F;
      }

      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      float var2 = (float)(this.v >> 16 & 0xFF) / 255.0F;
      float var3 = (float)(this.v >> 8 & 0xFF) / 255.0F;
      float var4 = (float)(this.v & 0xFF) / 255.0F;
      float var5 = this.getRainStatus(var2);
      float var6 = this.getThunderStatus(var2);
      int var9 = this.season.currentSeason;
      int var10 = this.season.lastSeason;
      int var11 = this.season.nextSeason;
      float var12 = this.season.seasonProgress;
      int var13 = var12 <= 0.5F ? var10 : var11;
      float var14 = -(Math.abs(var12 * 2.0F - 1.0F) - 1.0F) * 0.5F + 0.5F;
      float var15 = 1.0F - var14;
      int var16 = seasonColor.get(var9);
      int var17 = seasonColor.get(var13);
      float var18 = (float)(var16 >> 16 & 0xFF) / 255.0F;
      float var19 = (float)(var16 >> 8 & 0xFF) / 255.0F;
      float var20 = (float)(var16 >> 0 & 0xFF) / 255.0F;
      float var21 = (float)(var17 >> 16 & 0xFF) / 255.0F;
      float var22 = (float)(var17 >> 8 & 0xFF) / 255.0F;
      float var23 = (float)(var17 >> 0 & 0xFF) / 255.0F;
      if (this.theme == 0 && !this.multiplayerWorld) {
         var2 = var18 * var14 + var21 * var15;
         var3 = var19 * var14 + var22 * var15;
         var4 = var20 * var14 + var23 * var15;
      }

      if (var5 > 0.0F) {
         float var7 = (var2 * 0.3F + var3 * 0.59F + var4 * 0.11F) * 0.6F;
         float var8 = 1.0F - var5 * 0.75F;
         if (this.type == 4 && this.theme != 1) {
            var8 = 1.0F - var5;
            var2 = var2 * var8 + var5 * 0.7F;
            var3 = var3 * var8 + var5 * 0.5F;
            var4 = var4 * var8 + var5 * 0.2F;
         } else {
            var2 = var2 * var8 + var7 * (1.0F - var8);
            var3 = var3 * var8 + var7 * (1.0F - var8);
            var4 = var4 * var8 + var7 * (1.0F - var8);
         }
      }

      if (var6 > 0.0F) {
         float var30 = (var2 * 0.3F + var3 * 0.59F + var4 * 0.11F) * 0.2F;
         float var24 = 1.0F - var6 * 0.75F;
         var2 = var2 * var24 + var30 * (1.0F - var24);
         var3 = var3 * var24 + var30 * (1.0F - var24);
         var4 = var4 * var24 + var30 * (1.0F - var24);
      }

      if (this.lightStrike > 0) {
         float var31 = (float)this.lightStrike - var2;
         if (var31 > 1.0F) {
            var31 = 1.0F;
         }

         var31 *= 0.45F;
         var2 = var2 * (1.0F - var31) + 0.8F * var31;
         var3 = var3 * (1.0F - var31) + 0.8F * var31;
         var4 = var4 * (1.0F - var31) + 1.0F * var31;
      }

      if (this.type == 8) {
         var2 = 0.0F;
         var3 = 0.0F;
         var4 = 0.0F;
      }

      var2 *= var1;
      var3 *= var1;
      var4 *= var1;
      return new net.minecraft.a.d.C_a(var2, var3, var4);
   }

   public float[] calcSunriseSunsetColors(float var1, float var2) {
      float var3 = 0.4F;
      float var4 = MathHelper.b(var1 * (float) Math.PI * 2.0F) - 0.0F;
      float var5 = -0.0F;
      if (this.type == 8) {
         return null;
      } else if (var4 >= var5 - var3 && var4 <= var5 + var3) {
         float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
         float var7 = 1.0F - (1.0F - MathHelper.a(var6 * (float) Math.PI)) * 0.99F;
         var7 *= var7;
         this.colorsSunriseSunset[0] = var6 * 0.3F + 0.7F;
         this.colorsSunriseSunset[1] = var6 * var6 * 0.7F + 0.2F;
         this.colorsSunriseSunset[2] = var6 * var6 * 0.0F + 0.2F;
         this.colorsSunriseSunset[3] = var7;
         return this.colorsSunriseSunset;
      } else {
         return null;
      }
   }

   public float c(float var1) {
      float var2 = (float)(this.D % 24000) + var1;
      float var3 = 0.5F;
      float var4 = 0.5F;
      int var5 = this.season.currentSeason;
      int var6 = this.season.seasonProgress <= 0.5F ? this.season.lastSeason : this.season.nextSeason;
      switch (var5) {
         case 1:
            var3 = 0.7F;
            break;
         case 3:
            var3 = 0.3F;
            break;
         default:
            var3 = 0.5F;
      }

      switch (var6) {
         case 1:
            var4 = 0.7F;
            break;
         case 3:
            var4 = 0.3F;
            break;
         default:
            var4 = 0.5F;
      }

      float var7 = Math.abs(this.season.seasonProgress - 0.5F);
      float var8 = var3 + (var4 - var3) * var7;
      float var9 = 1.0F - var8;
      int var10 = (int)(24000.0F * var8);
      int var11 = (int)(24000.0F * var9);
      boolean var12 = var2 < (float)var10;
      float var13;
      if (var12) {
         var13 = var2 / (float)var10;
      } else {
         var13 = (var2 - (float)var10) / (float)var11;
      }

      float var14;
      if (var12) {
         var14 = var13 / 2.0F;
      } else {
         var14 = 0.5F + var13 / 2.0F;
      }

      var14 -= 0.25F;
      if (var14 < 0.0F) {
         var14++;
      }

      if (var14 > 1.0F) {
         var14--;
      }

      float var19 = 1.0F - (float)((Math.cos((double)var14 * Math.PI) + 1.0) / 2.0);
      var14 += (var19 - var14) / 3.0F;
      if (this.A > 15) {
         return 0.0F;
      } else {
         return this.A < 0 ? 1.0F : var14;
      }
   }

   public float getSunsetAngle(float var1) {
      float var2 = this.c(var1);
      return var2 * (float) Math.PI * 2.0F;
   }

   public net.minecraft.a.d.C_a d(float var1) {
      if ((var1 = MathHelper.b(this.c(var1) * (float) Math.PI * 2.0F) * 2.0F + 0.5F) < 0.0F) {
         var1 = 0.0F;
      }

      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      float var2 = (float)(this.w >> 16 & 0xFF) / 255.0F;
      float var3 = (float)(this.w >> 8 & 0xFF) / 255.0F;
      float var4 = (float)(this.w & 0xFF) / 255.0F;
      var2 *= var1 * 0.94F + 0.06F;
      var3 *= var1 * 0.94F + 0.06F;
      var4 *= var1 * 0.91F + 0.09F;
      return new net.minecraft.a.d.C_a(var2, var3, var4);
   }

   public net.minecraft.a.d.C_a e(float var1) {
      if ((var1 = MathHelper.b(this.c(var1) * (float) Math.PI * 2.0F) * 2.0F + 0.5F) < 0.0F) {
         var1 = 0.0F;
      }

      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      float var2 = (float)(this.x >> 16 & 0xFF) / 255.0F;
      float var3 = (float)(this.x >> 8 & 0xFF) / 255.0F;
      float var4 = (float)(this.x & 0xFF) / 255.0F;
      float var5 = this.getRainStatus(var1);
      float var6 = this.getThunderStatus(var1);
      if (var5 > 0.0F) {
         float var7 = (var2 * 0.3F + var3 * 0.59F + var4 * 0.11F) * 0.6F;
         float var8 = 1.0F - var5 * 0.95F;
         if (this.type == 4 && this.theme != 1) {
            var2 = var2 * var8 + var5 * 0.5F;
            var3 = var3 * var8 + var5 * 0.3F;
            var4 = var4 * var8 + var5 * 0.0F;
         } else {
            var2 = var2 * var8 + var7 * (1.0F - var8);
            var3 = var3 * var8 + var7 * (1.0F - var8);
            var4 = var4 * var8 + var7 * (1.0F - var8);
         }
      }

      if (var6 > 0.0F) {
         float var14 = (var2 * 0.3F + var3 * 0.59F + var4 * 0.11F) * 0.2F;
         float var9 = 1.0F - var6 * 0.95F;
         var2 = var2 * var9 + var14 * (1.0F - var9);
         var3 = var3 * var9 + var14 * (1.0F - var9);
         var4 = var4 * var9 + var14 * (1.0F - var9);
      }

      var2 *= var1 * 0.9F + 0.1F;
      var3 *= var1 * 0.9F + 0.1F;
      var4 *= var1 * 0.85F + 0.15F;
      return new net.minecraft.a.d.C_a(var2, var3, var4);
   }

   public int e() {
      float var1;
      if ((var1 = MathHelper.b(this.c(1.0F) * (float) Math.PI * 2.0F) * 1.5F + 0.5F) < 0.0F) {
         var1 = 0.0F;
      }

      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      int var2;
      if ((var2 = (int)(var1 * ((float)(15 * this.A) / 15.0F - 4.0F) + 4.0F)) > 15) {
         var2 = 15;
      }

      if (var2 < 4) {
         var2 = 4;
      }

      if (this.raining && var2 > 12) {
         var2 = 12;
      }

      if (this.thundering && var2 > 8) {
         var2 = 8;
      }

      return var2;
   }

   public void f() {
      this.D++;
      if (this.bloodMoonChance == 9 && this.E > 0 && this.theme != 2 && this.type != 5 && this.type != 8 && this.daysPassed >= 5) {
         Item.clock.a(299);
      } else if (this.bloodMoon) {
         Item.clock.a(299);
      } else {
         Item.clock.a(298);
      }

      if (this.D == 24000) {
         this.D = 0;
         this.daysPassed++;
         if (this.bloodMoon) {
            this.mc.f.addStat(StatList.bloodMoons, 1);
            this.bloodMoon = false;
            this.bloodMoonChance = 0;
         } else {
            this.bloodMoonChance = this.I.nextInt(10);
         }

         this.mc.f.addStat(StatList.daysPassed, 1);
         if (this.daysPassed >= 100 && this.mc.f.gamemode != 2) {
            this.mc.f.triggerAchievement(AchievementList.yearChallenge);
         }
      }

      if (this.mc != null
         && this.a(this.mc.G.c) > 0.0F
         && this.bloodMoonChance == 9
         && this.E > 0
         && !this.bloodMoon
         && this.theme != 2
         && this.type != 5
         && this.type != 8
         && this.daysPassed >= 5) {
         this.bloodMoon = true;
         this.mc.f.triggerAchievement(AchievementList.bloodMoon);
         this.mc.t.addChatMessage("§cThe blood moon is rising...");
      }

      this.season.tick();
      if (this.type != 5 && this.type != 8 && this.theme != 2 && !this.freezeWeatherUpdates) {
         this.updateWeather();
      }

      int var1 = this.e();
      if (this.B != var1) {
         this.a(var1);
      }

      var1 = 1;
      int var2 = 1;

      while (1 << var1 < this.a) {
         var1++;
      }

      while (1 << var2 < this.b) {
         var2++;
      }

      int var3 = this.b - 1;
      int var4 = this.a - 1;
      int var5 = this.c - 1;
      int var6;
      if ((var6 = this.G.size()) > 200) {
         var6 = 200;
      }

      for (int var7 = 0; var7 < var6; var7++) {
         C_e var9;
         if ((var9 = this.G.remove(0)).e > 0) {
            var9.e--;
            this.G.add(var9);
         } else {
            int var10 = var9.c;
            int var11 = var9.b;
            int var8 = var9.a;
            byte var12;
            if (var8 >= 0
               && var11 >= 0
               && var10 >= 0
               && var8 < this.a
               && var11 < this.c
               && var10 < this.b
               && (var12 = this.d[(var9.b * this.b + var9.c) * this.a + var9.a]) == var9.d
               && var12 > 0
               && !this.physicsDisabled) {
               Block.c[var12].a(this, var9.a, var9.b, var9.c, this.q);
            }
         }
      }

      this.K = this.K + this.a * this.b * this.c;
      var6 = this.K / 200;
      this.K -= var6 * 200;
      if (this.I.nextInt(250) == 0 && this.raining && this.thundering && !this.multiplayerWorld && this.season.currentSeason == 1) {
         this.J = this.J * 3 + 1013904223;
         int var23 = this.J >> 2;
         int var18 = var23 >> var1 & var3;
         var23 = var23 >> var1 + var2 & var4;
         int var21 = this.a(var18, var23);
         byte var26 = 10;

         for (int var30 = var18 - var26; var30 <= var18 + var26; var30++) {
            for (int var13 = var23 - var26; var13 <= var23 + var26; var13++) {
               int var14 = this.a(var30, var13);
               if (var14 > var21 && this.a(var30, var14 - 1, var13) == Block.rod.at) {
                  var18 = var30;
                  var23 = var13;
                  var21 = var14;
                  break;
               }
            }
         }

         if (this.canBlockBeRainedOn(var18, var21, var23)) {
            this.spawnEntityInWorld(new net.minecraft.a.c.c.C_f(this, (float)var18, (float)var21, (float)var23));
            this.weatherUpdates = 2;
         }
      }

      if (this.raining && (this.season.currentSeason != 2 || this.type == 4)) {
         this.J = this.J * 3 + 1013904223;
         int var27 = this.J >> 2;
         int var19 = var27 & var3;
         int var31 = var27 >> 8 & var4;
         int var22 = this.a(var19, var31);
         if (var22 >= 1 && var22 < this.c) {
            int var33 = this.a(var19, var22 - 1, var31);
            int var25 = this.a(var19, var22, var31);
            Block var35 = Block.tallGrass;
            if (this.season.currentSeason == 3) {
               var35 = Block.snowLayer;
               if (this.theme == 1) {
                  var35 = Block.ash;
               }
            }

            if (this.type == 4) {
               var35 = Block.sandLayer;
            }

            if (var35.at == Block.tallGrass.at) {
               if (this.I.nextInt(150) == 0
                  && var25 == 0
                  && var35.canBlockStay(this, var19, var22, var31)
                  && var33 != 0
                  && var33 != Block.ice.at
                  && Block.c[var33].getMaterial(0).c()
                  && this.season.currentSeason == 0) {
                  this.b(var19, var22, var31, var35.at);
               }
            } else if (var25 == 0 && var35.canBlockStay(this, var19, var22, var31) && var33 != 0 && var33 != Block.ice.at && Block.c[var33].getMaterial(0).c()) {
               this.b(var19, var22, var31, var35.at);
            }

            if (var33 == var35.at && var35.at != Block.tallGrass.at && this.e(var19, var22 - 1, var31) < 7 && this.thundering) {
               this.setBlockMetadataWithNotify(var19, var22 - 1, var31, this.e(var19, var22 - 1, var31) + 1);
            }

            if (this.season.currentSeason == 3
               && (var33 == Block.q.at || var33 == Block.p.at)
               && this.e(var19, var22 - 1, var31) == 0
               && this.theme != 1
               && this.type != 4) {
               this.b(var19, var22 - 1, var31, Block.ice.at);
            }
         }
      }

      for (int var17 = 0; var17 < var6; var17++) {
         this.J = this.J * 3 + 1013904223;
         int var28;
         int var32 = (var28 = this.J >> 2) & var4;
         int var20 = var28 >> var1 & var3;
         var28 = var28 >> var1 + var2 & var5;
         byte var34 = this.d[(var28 * this.b + var20) * this.a + var32];
         if (Block.d[var34 & 255] && !this.physicsDisabled) {
            Block.c[var34 & 255].a(this, var32, var28, var20, this.q);
         }
      }

      if (this.type == 5) {
         if (this.soundCounter > 0) {
            this.soundCounter--;
         }

         if (this.soundCounter == 0 && !this.mc.l) {
            this.mc.x.playAllocatedAmbience("loops.cave chimes", 0.1F, 1.0F, false);
            this.soundCounter = this.I.nextInt(12000) + 6000;
         }
      }
   }

   public boolean canBlockBeRainedOn(int var1, int var2, int var3) {
      if (!this.thundering) {
         return false;
      } else if (!this.l(var1, var2, var3)) {
         return false;
      } else {
         return this.a(var1, var3) > var2 ? false : this.season.currentSeason != 3;
      }
   }

   public int a(Class<?> var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < this.r.e.size(); var3++) {
         Entity var4 = this.r.e.get(var3);
         if (var1.isAssignableFrom(var4.getClass())) {
            var2++;
         }
      }

      return var2;
   }

   public int g() {
      return this.t;
   }

   public int h() {
      return this.s;
   }

   public boolean b(net.minecraft.a.d.C_b var1) {
      int var2 = (int)var1.a;
      int var3 = (int)var1.d + 1;
      int var4 = (int)var1.b;
      int var5 = (int)var1.e + 1;
      int var6 = (int)var1.c;
      int var7 = (int)var1.f + 1;
      if (var1.a < 0.0F) {
         var2--;
      }

      if (var1.b < 0.0F) {
         var4--;
      }

      if (var1.c < 0.0F) {
         var6--;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      if (var4 < 0) {
         var4 = 0;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      if (var3 > this.a) {
         var3 = this.a;
      }

      if (var5 > this.c) {
         var5 = this.c;
      }

      if (var7 > this.b) {
         var7 = this.b;
      }

      for (int var8 = var2; var8 < var3; var8++) {
         for (int var11 = var4; var11 < var5; var11++) {
            for (int var9 = var6; var9 < var7; var9++) {
               Block var10;
               if ((var10 = Block.c[this.a(var8, var11, var9)]) != null && var10.getMaterial(this.e(var8, var11, var9)).d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean c(net.minecraft.a.d.C_b var1) {
      int var2 = (int)var1.a;
      int var3 = (int)var1.d + 1;
      int var4 = (int)var1.b;
      int var5 = (int)var1.e + 1;
      int var6 = (int)var1.c;

      for (int var7 = (int)var1.f + 1; var2 < var3; var2++) {
         for (int var8 = var4; var8 < var5; var8++) {
            for (int var9 = var6; var9 < var7; var9++) {
               if (this.a(var2, var8, var9) == Block.ag.at) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean isBoundingBoxHellfire(net.minecraft.a.d.C_b var1) {
      int var2 = (int)var1.a;
      int var3 = (int)var1.d + 1;
      int var4 = (int)var1.b;
      int var5 = (int)var1.e + 1;
      int var6 = (int)var1.c;

      for (int var7 = (int)var1.f + 1; var2 < var3; var2++) {
         for (int var8 = var4; var8 < var5; var8++) {
            for (int var9 = var6; var9 < var7; var9++) {
               int var10 = this.a(var2, var8, var9);
               if (var10 == Block.hellfire.at) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean isBoundingBoxLava(net.minecraft.a.d.C_b var1) {
      int var2 = (int)var1.a;
      int var3 = (int)var1.d + 1;
      int var4 = (int)var1.b;
      int var5 = (int)var1.e + 1;
      int var6 = (int)var1.c;

      for (int var7 = (int)var1.f + 1; var2 < var3; var2++) {
         for (int var8 = var4; var8 < var5; var8++) {
            for (int var9 = var6; var9 < var7; var9++) {
               int var10;
               if ((var10 = this.a(var2, var8, var9)) == Block.ag.at || var10 == Block.r.at || var10 == Block.s.at) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean a(net.minecraft.a.d.C_b var1, Material var2) {
      int var3 = (int)var1.a;
      int var4 = (int)var1.d + 1;
      int var5 = (int)var1.b;
      int var6 = (int)var1.e + 1;
      int var7 = (int)var1.c;

      for (int var8 = (int)var1.f + 1; var3 < var4; var3++) {
         for (int var9 = var5; var9 < var6; var9++) {
            for (int var10 = var7; var10 < var8; var10++) {
               Block var11;
               if ((var11 = Block.c[this.a(var3, var9, var10)]) != null && var11.getMaterial(this.e(var3, var9, var10)) == var2) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void e(int var1, int var2, int var3, int var4) {
      C_e var5 = new C_e(var1, var2, var3, var4);
      if (var4 > 0) {
         var3 = Block.c[var4].e();
         var5.e = var3;
      }

      this.G.add(var5);
   }

   public void immediateUpdate(int var1, int var2, int var3, int var4) {
      C_e var5 = new C_e(var1, var2, var3, var4);
      if (var4 > 0) {
         var3 = Block.c[var4].e();
         var5.e = var3;
      }

      this.G.add(0, var5);
   }

   public boolean d(net.minecraft.a.d.C_b var1) {
      return this.r.a((Entity)null, var1).size() == 0;
   }

   public boolean e(net.minecraft.a.d.C_b var1) {
      List var2 = this.r.a((Entity)null, var1);

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (((Entity)var2.get(var3)).c) {
            return false;
         }
      }

      return true;
   }

   public List<Entity> a(Entity var1, net.minecraft.a.d.C_b var2) {
      return this.r.a(var1, var2);
   }

   public boolean a(float var1, float var2, float var3, float var4) {
      return this.a(var1 - 0.1F, var2 - 0.1F, var3 - 0.1F)
         ? true
         : (
            this.a(var1 - 0.1F, var2 - 0.1F, var3 + 0.1F)
               ? true
               : (
                  this.a(var1 - 0.1F, var2 + 0.1F, var3 - 0.1F)
                     ? true
                     : (
                        this.a(var1 - 0.1F, var2 + 0.1F, var3 + 0.1F)
                           ? true
                           : (
                              this.a(var1 + 0.1F, var2 - 0.1F, var3 - 0.1F)
                                 ? true
                                 : (
                                    this.a(var1 + 0.1F, var2 - 0.1F, var3 + 0.1F)
                                       ? true
                                       : (this.a(var1 + 0.1F, var2 + 0.1F, var3 - 0.1F) ? true : this.a(var1 + 0.1F, var2 + 0.1F, var3 + 0.1F))
                                 )
                           )
                     )
               )
         );
   }

   public boolean a(float var1, float var2, float var3) {
      int var4;
      return (var4 = this.a((int)var1, (int)var2, (int)var3)) > 0 && Block.c[var4].isOpaqueCube(this.e((int)var1, (int)var2, (int)var3));
   }

   public boolean isSolidTile(int var1, int var2, int var3) {
      Block var4;
      return (var4 = Block.c[this.a(var1, var2, var3)]) == null ? false : var4.d();
   }

   public boolean isQuicksand(float var1, float var2, float var3) {
      int var4;
      return (var4 = this.a((int)var1, (int)var2, (int)var3)) > 0 && Block.c[var4].at == Block.quickSand.at;
   }

   public int a(int var1, int var2) {
      int var3 = this.c;

      while ((this.a(var1, var3 - 1, var2) == 0 || Block.c[this.a(var1, var3 - 1, var2)].getMaterial(this.a(var1, var3 - 1, var2)) == Material.a) && var3 > 0) {
         var3--;
      }

      return var3;
   }

   public int getLastUncoveredBlock(int var1, int var2) {
      int var3 = this.c / 4;

      while (
         (this.a(var1, var3 + 1, var2) == 0 || Block.c[this.a(var1, var3 + 1, var2)].getMaterial(this.a(var1, var3 + 1, var2)) == Material.a) && var3 < this.c
      ) {
         var3++;
      }

      return var3;
   }

   public void a(int var1, int var2, int var3, float var4) {
      this.i = var1;
      this.j = var2;
      this.k = var3;
      this.l = var4;
   }

   public float c(int var1, int var2, int var3) {
      return F[this.d(var1, var2, var3)];
   }

   public byte d(int var1, int var2, int var3) {
      return (byte)Math.max(this.getSavedLightValue(C_l.Sky, var1, var2, var3) - (15 - this.B), this.getSavedLightValue(C_l.Block, var1, var2, var3));
   }

   public byte e(int var1, int var2, int var3) {
      if (var1 < 0) {
         var1 = 0;
      } else if (var1 >= this.a) {
         var1 = this.a - 1;
      }

      if (var2 < 0) {
         var2 = 0;
      } else if (var2 >= this.c) {
         var2 = this.c - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      } else if (var3 >= this.b) {
         var3 = this.b - 1;
      }

      return (byte)(this.e[(var2 * this.b + var3) * this.a + var1] >>> 4 & 15);
   }

   public boolean setBlockMetadata(int var1, int var2, int var3, int var4) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var1 < this.a - 1 && var2 < this.c - 1 && var3 < this.b - 1) {
         if (var4 == this.d[(var2 * this.b + var3) * this.a + var1]) {
            return false;
         } else {
            if (var1 < 0) {
               var1 = 0;
            } else if (var1 >= this.a) {
               var1 = this.a - 1;
            }

            if (var2 < 0) {
               var2 = 0;
            } else if (var2 >= this.c) {
               var2 = this.c - 1;
            }

            if (var3 < 0) {
               var3 = 0;
            } else if (var3 >= this.b) {
               var3 = this.b - 1;
            }

            this.e[(var2 * this.b + var3) * this.a + var1] = (byte)((this.e[(var2 * this.b + var3) * this.a + var1] & 15) + (var4 << 4));

            for (int var5 = 0; var5 < this.n.size(); var5++) {
               this.n.get(var5).a(var1, var2, var3);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public Material f(int var1, int var2, int var3) {
      int var4;
      return (var4 = this.a(var1, var2, var3)) == 0 ? Material.a : Block.c[var4].getMaterial(this.e(var1, var2, var3));
   }

   public boolean g(int var1, int var2, int var3) {
      int var4;
      return (var4 = this.a(var1, var2, var3)) > 0 && Block.c[var4].getMaterial(this.e(var1, var2, var3)) == Material.f;
   }

   public boolean isLava(int var1, int var2, int var3) {
      int var4;
      return (var4 = this.a(var1, var2, var3)) > 0 && Block.c[var4].getMaterial(this.e(var1, var2, var3)) == Material.g;
   }

   public net.minecraft.a.d.C_c a(net.minecraft.a.d.C_a var1, net.minecraft.a.d.C_a var2) {
      return this.rayTraceBlocks_do(var1, var2, false, false);
   }

   public net.minecraft.a.d.C_c rayTraceBlocks_do(net.minecraft.a.d.C_a var1, net.minecraft.a.d.C_a var2, boolean var3, boolean var4) {
      if (Double.isNaN((double)var1.a) || Double.isNaN((double)var1.b) || Double.isNaN((double)var1.c)) {
         return null;
      } else if (!Double.isNaN((double)var2.a) && !Double.isNaN((double)var2.b) && !Double.isNaN((double)var2.c)) {
         int var5 = MathHelper.a((double)var2.a);
         int var6 = MathHelper.a((double)var2.b);
         int var7 = MathHelper.a((double)var2.c);
         int var8 = MathHelper.a((double)var1.a);
         int var9 = MathHelper.a((double)var1.b);
         int var10 = MathHelper.a((double)var1.c);
         int var11 = this.a(var8, var9, var10);
         byte var12 = this.e(var8, var9, var10);
         Block var13 = Block.c[var11];
         if ((!var4 || var13 == null || var13.getCollisionBoundingBoxFromPool(this, var8, var9, var10) != null)
            && var11 > 0
            && var13.canCollideCheck(var12, var3)) {
            net.minecraft.a.d.C_c var14 = var13.a(this, var8, var9, var10, var1, var2);
            if (var14 != null) {
               return var14;
            }
         }

         var11 = 200;

         while (var11-- >= 0) {
            if (Double.isNaN((double)var1.a) || Double.isNaN((double)var1.b) || Double.isNaN((double)var1.c)) {
               return null;
            }

            if (var8 == var5 && var9 == var6 && var10 == var7) {
               return null;
            }

            boolean var39 = true;
            boolean var15 = true;
            boolean var16 = true;
            float var17 = 999.0F;
            float var18 = 999.0F;
            float var19 = 999.0F;
            if (var5 > var8) {
               var17 = (float)var8 + 1.0F;
            } else if (var5 < var8) {
               var17 = (float)var8 + 0.0F;
            } else {
               var39 = false;
            }

            if (var6 > var9) {
               var18 = (float)var9 + 1.0F;
            } else if (var6 < var9) {
               var18 = (float)var9 + 0.0F;
            } else {
               var15 = false;
            }

            if (var7 > var10) {
               var19 = (float)var10 + 1.0F;
            } else if (var7 < var10) {
               var19 = (float)var10 + 0.0F;
            } else {
               var16 = false;
            }

            double var20 = 999.0;
            double var22 = 999.0;
            double var24 = 999.0;
            double var26 = (double)(var2.a - var1.a);
            double var28 = (double)(var2.b - var1.b);
            double var30 = (double)(var2.c - var1.c);
            if (var39) {
               var20 = (double)(var17 - var1.a) / var26;
            }

            if (var15) {
               var22 = (double)(var18 - var1.b) / var28;
            }

            if (var16) {
               var24 = (double)(var19 - var1.c) / var30;
            }

            byte var32;
            if (var20 < var22 && var20 < var24) {
               if (var5 > var8) {
                  var32 = 4;
               } else {
                  var32 = 5;
               }

               var1.a = var17;
               var1.b = (float)((double)var1.b + var28 * var20);
               var1.c = (float)((double)var1.c + var30 * var20);
            } else if (var22 < var24) {
               if (var6 > var9) {
                  var32 = 0;
               } else {
                  var32 = 1;
               }

               var1.a = (float)((double)var1.a + var26 * var22);
               var1.b = var18;
               var1.c = (float)((double)var1.c + var30 * var22);
            } else {
               if (var7 > var10) {
                  var32 = 2;
               } else {
                  var32 = 3;
               }

               var1.a = (float)((double)var1.a + var26 * var24);
               var1.b = (float)((double)var1.b + var28 * var24);
               var1.c = var19;
            }

            net.minecraft.a.d.C_a var33 = new net.minecraft.a.d.C_a(var1.a, var1.b, var1.c);
            var8 = (int)(var33.a = (float)MathHelper.a((double)var1.a));
            if (var32 == 5) {
               var8--;
               var33.a++;
            }

            var9 = (int)(var33.b = (float)MathHelper.a((double)var1.b));
            if (var32 == 1) {
               var9--;
               var33.b++;
            }

            var10 = (int)(var33.c = (float)MathHelper.a((double)var1.c));
            if (var32 == 3) {
               var10--;
               var33.c++;
            }

            int var34 = this.a(var8, var9, var10);
            byte var35 = this.e(var8, var9, var10);
            Block var36 = Block.c[var34];
            if ((!var4 || var36 == null || var36.getCollisionBoundingBoxFromPool(this, var8, var9, var10) != null)
               && var34 > 0
               && var36.canCollideCheck(var35, var3)) {
               net.minecraft.a.d.C_c var37 = var36.a(this, var8, var9, var10, var1, var2);
               if (var37 != null) {
                  return var37;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public boolean genBigFlowerFeature1(int var1, boolean var2, World var3, Random var4, int var5, int var6, int var7) {
      int var8 = var4.nextInt(4) + var1;
      boolean var9 = true;
      int var10 = Block.flowerPetal.at;
      if (var6 >= 1 && var6 + var8 + 1 <= var3.c) {
         for (int var11 = var6; var11 <= var6 + 1 + var8; var11++) {
            byte var12 = 1;
            if (var11 == var6) {
               var12 = 0;
            }

            if (var11 >= var6 + 1 + var8 - 2) {
               var12 = 2;
            }

            for (int var15 = var5 - var12; var15 <= var5 + var12 && var9; var15++) {
               for (int var13 = var7 - var12; var13 <= var7 + var12 && var9; var13++) {
                  if (var11 >= 0 && var15 >= 0 && var13 >= 0 && var15 < this.a && var13 < this.b && var11 < this.c) {
                     int var14 = var3.a(var15, var11, var13);
                     if (var14 != 0
                        && var14 != Block.plantPurple.at
                        && var14 != Block.plantBlue.at
                        && var14 != Block.plantYellow.at
                        && var14 != Block.plantRed.at) {
                        var9 = false;
                     }
                  } else {
                     var9 = false;
                  }
               }
            }
         }

         if (!var9) {
            this.cantGrow = true;
            return false;
         } else {
            int var21 = var3.a(var5, var6 - 1, var7);
            if ((var21 == Block.j.at || var21 == Block.k.at) && var6 < var3.c - var8 - 1) {
               var3.a(var5, var6 - 1, var7, Block.k.at);
               byte var22 = 3;
               byte var27 = 0;

               for (int var23 = var6 - var22 + var8; var23 <= var6 + var8; var23++) {
                  int var25 = var23 - (var6 + var8);
                  int var16 = var27 + 1 - var25 / 2;

                  for (int var17 = var5 - var16; var17 <= var5 + var16; var17++) {
                     int var18 = var17 - var5;

                     for (int var19 = var7 - var16; var19 <= var7 + var16; var19++) {
                        int var20 = var19 - var7;
                        if ((Math.abs(var18) != var16 || Math.abs(var20) != var16 || var4.nextInt(2) != 0 && var25 != 0)
                           && !Block.e[var3.a(var17, var23, var19)]) {
                        }
                     }
                  }
               }

               for (int var24 = 0; var24 < var8; var24++) {
                  int var26 = var3.a(var5, var6 + var24, var7);
                  if (var26 == 0 || var26 == Block.plantRed.at || var26 == Block.plantYellow.at || var26 == Block.plantPurple.at || var26 == Block.plantBlue.at
                     )
                   {
                     var3.setBlockAndMetadata(var5, var6 + var24, var7, Block.flowerStem.at, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + (var8 - 1), var7, var10, 1);
                     var3.setBlockAndMetadata(var5 + 1, var6 + (var8 - 1), var7, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 - 1, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 + 1, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7, var10, 1);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7, var10, 1);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 1, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 1, var10, 1);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7, var10, 1);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 2, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 2, var10, 1);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 1, var10, 1);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 1, var10, 1);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 1, var10, 1);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 1, var10, 1);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 - 2, var10, 1);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 + 2, var10, 1);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 - 2, var10, 1);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 + 2, var10, 1);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7, var10, 1);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 - 2, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 + 2, var10, 1);
                     var3.setBlockAndMetadata(var5 - 3, var6 + var8 + 2, var7, var10, 1);
                     var3.setBlockAndMetadata(var5 + 3, var6 + var8 + 2, var7, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 - 3, var10, 1);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 + 3, var10, 1);
                  }
               }

               this.cantGrow = false;
               return true;
            } else {
               this.cantGrow = true;
               return false;
            }
         }
      } else {
         this.cantGrow = true;
         return false;
      }
   }

   public boolean genBigFlowerFeature2(int var1, boolean var2, World var3, Random var4, int var5, int var6, int var7) {
      int var8 = var4.nextInt(4) + var1;
      boolean var9 = true;
      int var10 = Block.flowerPetal.at;
      if (var6 >= 1 && var6 + var8 + 1 <= var3.c) {
         for (int var11 = var6; var11 <= var6 + 1 + var8; var11++) {
            byte var12 = 1;
            if (var11 == var6) {
               var12 = 0;
            }

            if (var11 >= var6 + 1 + var8 - 2) {
               var12 = 2;
            }

            for (int var15 = var5 - var12; var15 <= var5 + var12 && var9; var15++) {
               for (int var13 = var7 - var12; var13 <= var7 + var12 && var9; var13++) {
                  if (var11 >= 0 && var15 >= 0 && var13 >= 0 && var15 < this.a && var13 < this.b && var11 < this.c) {
                     int var14 = var3.a(var15, var11, var13);
                     if (var14 != 0
                        && var14 != Block.plantPurple.at
                        && var14 != Block.plantBlue.at
                        && var14 != Block.plantYellow.at
                        && var14 != Block.plantRed.at) {
                        var9 = false;
                     }
                  } else {
                     var9 = false;
                  }
               }
            }
         }

         if (!var9) {
            this.cantGrow = true;
            return false;
         } else {
            int var21 = var3.a(var5, var6 - 1, var7);
            if ((var21 == Block.j.at || var21 == Block.k.at) && var6 < var3.c - var8 - 1) {
               var3.a(var5, var6 - 1, var7, Block.k.at);
               byte var22 = 3;
               byte var27 = 0;

               for (int var23 = var6 - var22 + var8; var23 <= var6 + var8; var23++) {
                  int var25 = var23 - (var6 + var8);
                  int var16 = var27 + 1 - var25 / 2;

                  for (int var17 = var5 - var16; var17 <= var5 + var16; var17++) {
                     int var18 = var17 - var5;

                     for (int var19 = var7 - var16; var19 <= var7 + var16; var19++) {
                        int var20 = var19 - var7;
                        if ((Math.abs(var18) != var16 || Math.abs(var20) != var16 || var4.nextInt(2) != 0 && var25 != 0)
                           && !Block.e[var3.a(var17, var23, var19)]) {
                        }
                     }
                  }
               }

               int var24;
               for (var24 = 0; var24 < var8; var24++) {
                  int var26 = var3.a(var5, var6 + var24, var7);
                  if (var26 == 0 || var26 == Block.plantRed.at || var26 == Block.plantYellow.at || var26 == Block.plantPurple.at || var26 == Block.plantBlue.at
                     )
                   {
                     var3.setBlockAndMetadata(var5, var6 + var24, var7, Block.flowerStem.at, 0);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7, var10, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7, var10, 0);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7, var10, 0);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 1, var10, 0);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 1, var10, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 1, var10, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 1, var10, 0);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 1, var10, 0);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 1, var10, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 2, var10, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 2, var10, 0);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 2, var10, 0);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 2, var10, 0);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 - 1, var10, 0);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 + 1, var10, 0);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 - 1, var10, 0);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 + 1, var10, 0);
                  }
               }

               if (var4.nextInt(2) == 0) {
                  var3.setBlockAndMetadata(var5 - 1, var6 + var24 / 6 + 1, var7, Block.flowerStem.at, 0);
                  var3.setBlockAndMetadata(var5 + 1, var6 + var24 / 6 + 2, var7, Block.flowerStem.at, 0);
               } else {
                  var3.setBlockAndMetadata(var5, var6 + var24 / 6 + 1, var7 - 1, Block.flowerStem.at, 0);
                  var3.setBlockAndMetadata(var5, var6 + var24 / 6 + 2, var7 + 1, Block.flowerStem.at, 0);
               }

               this.cantGrow = false;
               return true;
            } else {
               this.cantGrow = true;
               return false;
            }
         }
      } else {
         this.cantGrow = true;
         return false;
      }
   }

   public boolean genBigFlowerFeature3(int var1, boolean var2, World var3, Random var4, int var5, int var6, int var7) {
      int var8 = var4.nextInt(4) + var1;
      boolean var9 = true;
      int var10 = Block.flowerPetal.at;
      if (var6 >= 1 && var6 + var8 + 1 <= var3.c) {
         for (int var11 = var6; var11 <= var6 + 1 + var8; var11++) {
            byte var12 = 1;
            if (var11 == var6) {
               var12 = 0;
            }

            if (var11 >= var6 + 1 + var8 - 2) {
               var12 = 2;
            }

            for (int var15 = var5 - var12; var15 <= var5 + var12 && var9; var15++) {
               for (int var13 = var7 - var12; var13 <= var7 + var12 && var9; var13++) {
                  if (var11 >= 0 && var15 >= 0 && var13 >= 0 && var15 < this.a && var13 < this.b && var11 < this.c) {
                     int var14 = var3.a(var15, var11, var13);
                     if (var14 != 0
                        && var14 != Block.plantPurple.at
                        && var14 != Block.plantBlue.at
                        && var14 != Block.plantYellow.at
                        && var14 != Block.plantRed.at) {
                        var9 = false;
                     }
                  } else {
                     var9 = false;
                  }
               }
            }
         }

         if (!var9) {
            this.cantGrow = true;
            return false;
         } else {
            int var21 = var3.a(var5, var6 - 1, var7);
            if ((var21 == Block.j.at || var21 == Block.k.at) && var6 < var3.c - var8 - 1) {
               var3.a(var5, var6 - 1, var7, Block.k.at);
               byte var22 = 3;
               byte var27 = 0;

               for (int var23 = var6 - var22 + var8; var23 <= var6 + var8; var23++) {
                  int var25 = var23 - (var6 + var8);
                  int var16 = var27 + 1 - var25 / 2;

                  for (int var17 = var5 - var16; var17 <= var5 + var16; var17++) {
                     int var18 = var17 - var5;

                     for (int var19 = var7 - var16; var19 <= var7 + var16; var19++) {
                        int var20 = var19 - var7;
                        if ((Math.abs(var18) != var16 || Math.abs(var20) != var16 || var4.nextInt(2) != 0 && var25 != 0)
                           && !Block.e[var3.a(var17, var23, var19)]) {
                        }
                     }
                  }
               }

               for (int var24 = 0; var24 < var8; var24++) {
                  int var26 = var3.a(var5, var6 + var24, var7);
                  if (var26 == 0 || var26 == Block.plantRed.at || var26 == Block.plantYellow.at || var26 == Block.plantPurple.at || var26 == Block.plantBlue.at
                     )
                   {
                     var3.setBlockAndMetadata(var5, var6 + var24, var7, Block.flowerStem.at, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + (var8 - 1), var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + (var8 - 1), var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 2, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 - 2, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 + 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 - 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 - 2, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 + 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 + 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 2, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 2, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 - 2, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 + 2, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 2, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 2, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 2, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 2, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 3, var7, var10, 3);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 3, var7, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 3, var7 - 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 3, var7 + 1, var10, 3);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 3, var7, var10, 3);
                  }
               }

               this.cantGrow = false;
               return true;
            } else {
               this.cantGrow = true;
               return false;
            }
         }
      } else {
         this.cantGrow = true;
         return false;
      }
   }

   public boolean genBigFlowerFeature4(int var1, boolean var2, World var3, Random var4, int var5, int var6, int var7) {
      int var8 = var4.nextInt(4) + var1;
      boolean var9 = true;
      int var10 = Block.flowerPetal.at;
      if (var6 >= 1 && var6 + var8 + 1 <= var3.c) {
         for (int var11 = var6; var11 <= var6 + 1 + var8; var11++) {
            byte var12 = 1;
            if (var11 == var6) {
               var12 = 0;
            }

            if (var11 >= var6 + 1 + var8 - 2) {
               var12 = 2;
            }

            for (int var15 = var5 - var12; var15 <= var5 + var12 && var9; var15++) {
               for (int var13 = var7 - var12; var13 <= var7 + var12 && var9; var13++) {
                  if (var11 >= 0 && var15 >= 0 && var13 >= 0 && var15 < this.a && var13 < this.b && var11 < this.c) {
                     int var14 = var3.a(var15, var11, var13);
                     if (var14 != 0
                        && var14 != Block.plantPurple.at
                        && var14 != Block.plantBlue.at
                        && var14 != Block.plantYellow.at
                        && var14 != Block.plantRed.at) {
                        var9 = false;
                     }
                  } else {
                     var9 = false;
                  }
               }
            }
         }

         if (!var9) {
            this.cantGrow = true;
            return false;
         } else {
            int var21 = var3.a(var5, var6 - 1, var7);
            if ((var21 == Block.j.at || var21 == Block.k.at) && var6 < var3.c - var8 - 1) {
               var3.a(var5, var6 - 1, var7, Block.k.at);
               byte var22 = 3;
               byte var27 = 0;

               for (int var23 = var6 - var22 + var8; var23 <= var6 + var8; var23++) {
                  int var25 = var23 - (var6 + var8);
                  int var16 = var27 + 1 - var25 / 2;

                  for (int var17 = var5 - var16; var17 <= var5 + var16; var17++) {
                     int var18 = var17 - var5;

                     for (int var19 = var7 - var16; var19 <= var7 + var16; var19++) {
                        int var20 = var19 - var7;
                        if ((Math.abs(var18) != var16 || Math.abs(var20) != var16 || var4.nextInt(2) != 0 && var25 != 0)
                           && !Block.e[var3.a(var17, var23, var19)]) {
                        }
                     }
                  }
               }

               int var24;
               for (var24 = 0; var24 < var8; var24++) {
                  int var26 = var3.a(var5, var6 + var24, var7);
                  if (var26 == 0 || var26 == Block.plantRed.at || var26 == Block.plantYellow.at || var26 == Block.plantPurple.at || var26 == Block.plantBlue.at
                     )
                   {
                     var3.setBlockAndMetadata(var5, var6 + var24, var7, Block.flowerStem.at, 0);
                     var3.setBlockAndMetadata(var5 - 1, var6 + (var8 - 1), var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + (var8 - 1), var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + (var8 - 1), var7, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + (var8 - 1), var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + (var8 - 1), var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + (var8 - 1), var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + (var8 - 1), var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 1, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 1, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 1, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 1, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 1, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 - 2, var6 + var8 + 2, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 + 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 2, var6 + var8 + 2, var7 - 1, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 2, var7 - 2, var10, 2);
                     var3.setBlockAndMetadata(var5 + 1, var6 + var8 + 2, var7 + 2, var10, 2);
                     var3.setBlockAndMetadata(var5 - 1, var6 + var8 + 2, var7 + 2, var10, 2);
                  }
               }

               var3.setBlockAndMetadata(var5 + 1, var6 + var24 / 2, var7, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5 - 1, var6 + var24 / 2, var7, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5, var6 + var24 / 2, var7 + 1, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5, var6 + var24 / 2, var7 - 1, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5 + 2, var6 + var24 / 2 + 1, var7, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5 - 2, var6 + var24 / 2 + 1, var7, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5, var6 + var24 / 2 + 1, var7 + 2, Block.flowerStem.at, 0);
               var3.setBlockAndMetadata(var5, var6 + var24 / 2 + 1, var7 - 2, Block.flowerStem.at, 0);
               this.cantGrow = false;
               return true;
            } else {
               this.cantGrow = true;
               return false;
            }
         }
      } else {
         this.cantGrow = true;
         return false;
      }
   }

   private void generateVines(World var1, int var2, int var3, int var4, int var5) {
      var1.setBlockAndMetadata(var2, var3, var4, Block.vine.at, var5);

      for (int var6 = 4; var1.a(var2, --var3, var4) == 0 && var6 > 0; var6--) {
         var1.setBlockAndMetadata(var2, var3, var4, Block.vine.at, var5);
      }
   }

   public boolean growSwampTrees(World var1, Random var2, int var3, int var4, int var5) {
      int var6 = var2.nextInt(4) + 5;

      while (var1.f(var3, var4 - 1, var5) == Material.f) {
         var4--;
      }

      boolean var7 = true;
      if (var4 >= 1 && var4 + var6 + 1 <= var1.c) {
         for (int var8 = var4; var8 <= var4 + 1 + var6; var8++) {
            byte var12 = 1;
            if (var8 == var4) {
               var12 = 0;
            }

            if (var8 >= var4 + 1 + var6 - 2) {
               var12 = 3;
            }

            for (int var9 = var3 - var12; var9 <= var3 + var12 && var7; var9++) {
               for (int var10 = var5 - var12; var10 <= var5 + var12 && var7; var10++) {
                  if (var8 >= 0 && var8 < var1.c && var9 > 0 && var9 < var1.a && var10 > 0 && var10 < var1.b) {
                     int var11 = var1.a(var9, var8, var10);
                     if (var11 != 0 && var11 != Block.z.at) {
                        if (var11 != Block.q.at && var11 != Block.p.at) {
                           var7 = false;
                        } else if (var8 > var4) {
                           var7 = false;
                        }
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if (!var7) {
            return false;
         } else {
            int var16 = var1.a(var3, var4 - 1, var5);
            if ((var16 == Block.j.at || var16 == Block.k.at) && var4 < var1.c - var6 - 1) {
               var1.a(var3, var4 - 1, var5, Block.k.at);

               for (int var13 = var4 - 3 + var6; var13 <= var4 + var6; var13++) {
                  int var17 = var13 - (var4 + var6);
                  int var20 = 2 - var17 / 2;

                  for (int var22 = var3 - var20; var22 <= var3 + var20; var22++) {
                     int var24 = var22 - var3;

                     for (int var14 = var5 - var20; var14 <= var5 + var20; var14++) {
                        int var15 = var14 - var5;
                        if ((Math.abs(var24) != var20 || Math.abs(var15) != var20 || var2.nextInt(2) != 0 && var17 != 0)
                           && !Block.e[var1.a(var22, var13, var14)]
                           && this.a(var22, var13, var14) != Block.portal.at) {
                           var1.a(var22, var13, var14, Block.z.at);
                        }
                     }
                  }
               }

               for (int var26 = 0; var26 < var6; var26++) {
                  int var18 = var1.a(var3, var4 + var26, var5);
                  if (var18 == 0 || var18 == Block.z.at || var18 == Block.p.at || var18 == Block.q.at) {
                     var1.a(var3, var4 + var26, var5, Block.y.at);
                  }
               }

               for (int var27 = var4 - 3 + var6; var27 <= var4 + var6; var27++) {
                  int var19 = var27 - (var4 + var6);
                  int var21 = 2 - var19 / 2;

                  for (int var23 = var3 - var21; var23 <= var3 + var21; var23++) {
                     for (int var25 = var5 - var21; var25 <= var5 + var21; var25++) {
                        if (var1.a(var23, var27, var25) == Block.z.at) {
                           if (var2.nextInt(4) == 0 && var1.a(var23 - 1, var27, var25) == 0) {
                              this.generateVines(var1, var23 - 1, var27, var25, 4);
                           }

                           if (var2.nextInt(4) == 0 && var1.a(var23 + 1, var27, var25) == 0) {
                              this.generateVines(var1, var23 + 1, var27, var25, 5);
                           }

                           if (var2.nextInt(4) == 0 && var1.a(var23, var27, var25 - 1) == 0) {
                              this.generateVines(var1, var23, var27, var25 - 1, 2);
                           }

                           if (var2.nextInt(4) == 0 && var1.a(var23, var27, var25 + 1) == 0) {
                              this.generateVines(var1, var23, var27, var25 + 1, 3);
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean growTrees(int var1, int var2, int var3, int var4) {
      int var5 = this.q.nextInt(3) + 4;
      if (var4 == 2) {
         var5 = this.q.nextInt(3) + 6;
      }

      boolean var6 = true;
      if (var2 > 0 && var2 + var5 + 1 <= this.c) {
         for (int var7 = var2; var7 <= var2 + 1 + var5; var7++) {
            byte var10 = 1;
            if (var7 == var2) {
               var10 = 0;
            }

            if (var7 >= var2 + 1 + var5 - 2) {
               var10 = 2;
            }

            for (int var8 = var1 - var10; var8 <= var1 + var10 && var6; var8++) {
               for (int var9 = var3 - var10; var9 <= var3 + var10 && var6; var9++) {
                  if (var8 >= 0 && var7 >= 0 && var9 >= 0 && var8 < this.a && var7 < this.c && var9 < this.b) {
                     if ((this.d[(var7 * this.b + var9) * this.a + var8] & 255) != 0) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            }
         }

         if (!var6) {
            return false;
         } else {
            int var14;
            if (((var14 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var14 == Block.k.at) && var2 < this.c - var5 - 1) {
               this.b(var1, var2 - 1, var3, Block.k.at);

               for (int var18 = var2 - 3 + var5; var18 <= var2 + var5; var18++) {
                  int var16 = var18 - (var2 + var5);
                  int var17 = 1 - var16 / 2;

                  for (int var11 = var1 - var17; var11 <= var1 + var17; var11++) {
                     int var12 = var11 - var1;

                     for (int var15 = var3 - var17; var15 <= var3 + var17; var15++) {
                        int var13 = var15 - var3;
                        if ((Math.abs(var12) != var17 || Math.abs(var13) != var17 || this.q.nextInt(2) != 0 && var16 != 0)
                           && !Block.e[this.a(var11, var18, var15)]
                           && this.a(var11, var18, var15) != Block.portal.at
                           && var4 != 3) {
                           switch (var4) {
                              case 1:
                                 this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, this.q.nextInt(2) + 1);
                                 break;
                              case 2:
                                 this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, 3);
                                 break;
                              default:
                                 this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, var4);
                           }
                        }
                     }
                  }
               }

               for (int var19 = 0; var19 < var5; var19++) {
                  if (!Block.e[this.a(var1, var2 + var19, var3)]) {
                     if (var4 == 2) {
                        this.setBlockAndMetadataWithNotify(var1, var2 + var19, var3, Block.y.at, 1);
                     } else {
                        this.b(var1, var2 + var19, var3, Block.y.at);
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean growCaveTrees(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(2) + 3;
      boolean var5 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var6 = var2; var6 <= var2 + 1 + var4; var6++) {
            byte var9 = 1;
            if (var6 >= var2 + 1 + var4 - 2) {
               var9 = 2;
            }

            for (int var7 = var1 - var9; var7 <= var1 + var9 && var5; var7++) {
               for (int var8 = var3 - var9; var8 <= var3 + var9 && var5; var8++) {
                  if (var7 >= 0 && var6 >= 0 && var8 >= 0 && var7 < this.a && var6 < this.c && var8 < this.b) {
                     if ((this.d[(var6 * this.b + var8) * this.a + var7] & 255) != 0) {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if (!var5) {
            return false;
         } else {
            int var14;
            if (((var14 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var14 == Block.k.at || var14 == Block.moss.at)
               && var2 < this.c - var4 - 1) {
               this.b(var1, var2 - 1, var3, Block.k.at);
               byte var10 = 2;
               if (var4 == 4) {
                  var10 = 3;
               }

               for (int var17 = var2 - var10 + var4; var17 <= var2 + var4; var17++) {
                  int var16 = var17 - (var2 + var4);

                  for (int var11 = var1 - 1; var11 <= var1 + 1; var11++) {
                     int var12 = var11 - var1;

                     for (int var15 = var3 - 1; var15 <= var3 + 1; var15++) {
                        int var13 = var15 - var3;
                        if (var16 == -1 || var16 == -2 && var4 == 4 || Math.abs(var12) != 1 || Math.abs(var13) != 1) {
                           this.setBlockAndMetadataWithNotify(var11, var17, var15, Block.z.at, 5);
                        }
                     }
                  }
               }

               for (int var18 = 0; var18 < var4; var18++) {
                  if (!Block.e[this.a(var1, var2 + var18, var3)]) {
                     this.setBlockAndMetadataWithNotify(var1, var2 + var18, var3, Block.y.at, 3);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean growPalmTrees(int var1, int var2, int var3) {
      int var4 = this.I.nextInt(3) + 6;
      int var5 = this.I.nextInt(3) - 1;
      int var6 = this.I.nextInt(2);
      int var7 = var4 - 6;
      boolean var8 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var9 = var2; var9 <= var2 + 1 + var4; var9++) {
            byte var12 = 1;
            if (var9 == var2) {
               var12 = 0;
            }

            if (var9 >= var2 + 1 + var4 - 1) {
               var12 = 3;
            }

            for (int var10 = var1 - var12; var10 <= var1 + var12 && var8; var10++) {
               for (int var11 = var3 - var12; var11 <= var3 + var12 && var8; var11++) {
                  if (var10 >= 0 && var9 >= 0 && var11 >= 0 && var10 < this.a && var9 < this.c && var11 < this.b) {
                     if ((this.d[(var9 * this.b + var11) * this.a + var10] & 255) != 0) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if (!var8) {
            return false;
         } else {
            int var18;
            if (((var18 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var18 == Block.k.at) && var2 < this.c - var4 - 1) {
               this.b(var1, var2 - 1, var3, Block.k.at);
               if (var5 != 0) {
                  this.b(var1, var2 - 1, var3 + 1 * var5, Block.k.at);
                  this.b(var1 + 1 * var5, var2 - 1, var3, Block.k.at);
                  this.b(var1, var2 - 1, var3 - 1 * var5, Block.k.at);
                  this.b(var1 - 1 * var5, var2 - 1, var3, Block.k.at);
               }

               int var19 = var1 + 2 * var5;
               int var13 = var2 + var4;
               int var14 = var3;
               if (var6 == 1) {
                  var19 = var1;
                  var14 = var3 + 2 * var5;
               }

               this.setBlockAndMetadataWithNotify(var19, var13, var14, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19, var13 + 1, var14, Block.z.at, 4);

               for (int var15 = 1; var15 <= 3; var15++) {
                  int var16 = var13;
                  if (var15 == 3) {
                     var16 = var13 - 1;
                  }

                  this.setBlockAndMetadataWithNotify(var19 + var15, var16, var14 - var15, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19 + var15, var16, var14 + var15, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19 - var15, var16, var14 - var15, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19 - var15, var16, var14 + var15, Block.z.at, 4);
               }

               this.setBlockAndMetadataWithNotify(var19 + 1, var13 - 1, var14, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19 - 1, var13 - 1, var14, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19, var13 - 1, var14 + 1, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19, var13 - 1, var14 - 1, Block.z.at, 4);

               for (int var20 = 1; var20 <= 4; var20++) {
                  int var22 = var13;
                  if (var20 == 4) {
                     var22 = var13 - 1;
                  }

                  this.setBlockAndMetadataWithNotify(var19 + var20, var22, var14, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19 - var20, var22, var14, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19, var22, var14 + var20, Block.z.at, 4);
                  this.setBlockAndMetadataWithNotify(var19, var22, var14 - var20, Block.z.at, 4);
               }

               this.setBlockAndMetadataWithNotify(var1, var2 + var7, var3, Block.y.at, 2);

               for (int var21 = 0; var21 < var4; var21++) {
                  int var23 = var21 / 2;
                  if (var23 > 2) {
                     var23 = 2;
                  }

                  byte var17 = 0;
                  if (var4 == 8 && var5 != 0) {
                     var17 = 1;
                  }

                  if (var6 == 1) {
                     this.setBlockAndMetadataWithNotify(var1, var2 + var21 + var17, var3 + var23 * var5, Block.y.at, 2);
                  } else {
                     this.setBlockAndMetadataWithNotify(var1 + var23 * var5, var2 + var21 + var17, var3, Block.y.at, 2);
                  }

                  if (var5 != 0) {
                     this.setBlockAndMetadataWithNotify(var1, var2, var3 + 1 * var5, Block.y.at, 2);
                     this.setBlockAndMetadataWithNotify(var1 + 1 * var5, var2, var3, Block.y.at, 2);
                     this.setBlockAndMetadataWithNotify(var1, var2, var3 - 1 * var5, Block.y.at, 2);
                     this.setBlockAndMetadataWithNotify(var1 - 1 * var5, var2, var3, Block.y.at, 2);
                     this.setBlockAndMetadataWithNotify(var1, var2, var3, Block.y.at, 2);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public boolean growCorals(int var1, int var2, int var3) {
      int var4 = this.I.nextInt(3) + 4;
      int var5 = this.I.nextInt(4);
      int var6 = this.I.nextInt(4) - 1;
      int var7 = var4 - 6;
      boolean var8 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var9 = var2; var9 <= var2 + 1 + var4; var9++) {
            byte var12 = 1;
            if (var9 == var2) {
               var12 = 0;
            }

            if (var9 >= var2 + 1 + var4 - 1) {
               var12 = 3;
            }

            for (int var10 = var1 - var12; var10 <= var1 + var12 && var8; var10++) {
               for (int var11 = var3 - var12; var11 <= var3 + var12 && var8; var11++) {
                  if (var10 >= 0 && var9 >= 0 && var11 >= 0 && var10 < this.a && var9 < this.c && var11 < this.b) {
                     if ((this.d[(var9 * this.b + var11) * this.a + var10] & 255) != Block.q.at) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if (!var8) {
            return false;
         } else if ((this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.coral.at && var2 < this.c - var4 - 1) {
            this.setBlockAndMetadataWithNotify(var1, var2 + var7, var3, Block.coral.at, var5);

            for (int var14 = 0; var14 < var4; var14++) {
               int var13 = var14 / 2;
               if (var6 == 0) {
                  this.setBlockAndMetadataWithNotify(var1, var2 + var7 + 1, var3 + 1, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 + 1, var2 + var7 + 1, var3, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1, var2 + var14, var3 + var13 + 1, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 + var13 + 1, var2 + var14, var3, Block.coral.at, var5);
               } else if (var6 == 2) {
                  this.setBlockAndMetadataWithNotify(var1, var2 + var7 + 1, var3 - 1, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 - 1, var2 + var7 + 1, var3, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1, var2 + var14, var3 - var13 - 1, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 - var13 - 1, var2 + var14, var3, Block.coral.at, var5);
               } else {
                  this.setBlockAndMetadataWithNotify(var1, var2 + var14, var3 + var13 - var6, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 + var13 - var6, var2 + var14, var3, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1, var2 + var14, var3 - var13 - var6, Block.coral.at, var5);
                  this.setBlockAndMetadataWithNotify(var1 - var13 - var6, var2 + var14, var3, Block.coral.at, var5);
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean growSpikes(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(20) + 4;
      int var5 = this.q.nextInt(16) + 2;
      int var6 = this.q.nextInt(18) + 3;
      int var7 = this.q.nextInt(17) + 3;
      int var8 = this.q.nextInt(17) + 2;
      int var9 = this.q.nextInt(19) + 1;
      int var10 = this.q.nextInt(15) + 4;
      int var11 = this.q.nextInt(16) + 3;
      int var12 = this.q.nextInt(17) + 4;
      int var13 = this.q.nextInt(13) + 4;
      int var14 = this.q.nextInt(12) + 3;
      int var15 = this.q.nextInt(14) + 1;
      int var16 = this.q.nextInt(12) + 4;
      boolean var17 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var18 = var2; var18 <= var2 + 1 + var4; var18++) {
            byte var21 = 1;
            if (var18 == var2) {
               var21 = 0;
            }

            if (var18 >= var2 + 1 + var4 - 2) {
               var21 = 2;
            }

            for (int var19 = var1 - var21; var19 <= var1 + var21 && var17; var19++) {
               for (int var20 = var3 - var21; var20 <= var3 + var21 && var17; var20++) {
                  if (var19 >= 0 && var18 >= 0 && var20 >= 0 && var19 < this.a && var18 < this.c && var20 < this.b) {
                     if ((this.d[(var18 * this.b + var20) * this.a + var19] & 255) != 0) {
                        var17 = false;
                     }
                  } else {
                     var17 = false;
                  }
               }
            }
         }

         if (!var17) {
            return false;
         } else {
            int var23;
            if (((var23 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.s.at || var23 == Block.r.at) && var2 < this.c - var4 - 1) {
               for (int var24 = -1; var24 < 2; var24++) {
                  for (int var22 = -1; var22 < 2; var22++) {
                     this.b(var1 + var24, var2 - 1, var3 + var22, Block.ae.at);
                  }
               }

               for (int var25 = 0; var25 < var4; var25++) {
                  if (!Block.e[this.a(var1, var2 + var25, var3)]) {
                     this.b(var1, var2 + var25, var3, Block.ae.at);
                  }
               }

               for (int var26 = 0; var26 < var5; var26++) {
                  if (!Block.e[this.a(var1 + 1, var2 + var26, var3)]) {
                     this.b(var1 + 1, var2 + var26, var3, Block.ae.at);
                  }
               }

               for (int var27 = 0; var27 < var6; var27++) {
                  if (!Block.e[this.a(var1, var2 + var27, var3 + 1)]) {
                     this.b(var1, var2 + var27, var3 + 1, Block.ae.at);
                  }
               }

               for (int var28 = 0; var28 < var7; var28++) {
                  if (!Block.e[this.a(var1, var2 + var28, var3 - 1)]) {
                     this.b(var1, var2 + var28, var3 - 1, Block.ae.at);
                  }
               }

               for (int var29 = 0; var29 < var8; var29++) {
                  if (!Block.e[this.a(var1 - 1, var2 + var29, var3)]) {
                     this.b(var1 - 1, var2 + var29, var3, Block.ae.at);
                  }
               }

               for (int var30 = 0; var30 < var9; var30++) {
                  if (!Block.e[this.a(var1 - 1, var2 + var30, var3 - 1)]) {
                     this.b(var1 - 1, var2 + var30, var3 - 1, Block.ae.at);
                  }
               }

               for (int var31 = 0; var31 < var10; var31++) {
                  if (!Block.e[this.a(var1 + 1, var2 + var31, var3 + 1)]) {
                     this.b(var1 + 1, var2 + var31, var3 + 1, Block.ae.at);
                  }
               }

               for (int var32 = 0; var32 < var11; var32++) {
                  if (!Block.e[this.a(var1 - 1, var2 + var32, var3 + 1)]) {
                     this.b(var1 - 1, var2 + var32, var3 + 1, Block.ae.at);
                  }
               }

               for (int var33 = 0; var33 < var12; var33++) {
                  if (!Block.e[this.a(var1 + 1, var2 + var33, var3 - 1)]) {
                     this.b(var1 + 1, var2 + var33, var3 - 1, Block.ae.at);
                  }
               }

               for (int var34 = 0; var34 < var13; var34++) {
                  if (!Block.e[this.a(var1 + 2, var2 + var34, var3)]) {
                     this.b(var1 + 2, var2 - 1 + var34, var3, Block.ae.at);
                  }
               }

               for (int var35 = 0; var35 < var14; var35++) {
                  if (!Block.e[this.a(var1 - 2, var2 + var35, var3)]) {
                     this.b(var1 - 2, var2 - 1 + var35, var3, Block.ae.at);
                  }
               }

               for (int var36 = 0; var36 < var15; var36++) {
                  if (!Block.e[this.a(var1, var2 + var36, var3 + 2)]) {
                     this.b(var1, var2 - 1 + var36, var3 + 2, Block.ae.at);
                  }
               }

               for (int var37 = 0; var37 < var16; var37++) {
                  if (!Block.e[this.a(var1, var2 + var37, var3 - 2)]) {
                     this.b(var1, var2 - 1 + var37, var3 - 2, Block.ae.at);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public void growPalmTree(int var1, int var2, int var3) {
      int var4 = this.I.nextInt(3) + 6;
      int var5 = this.I.nextInt(3) - 1;
      int var6 = this.I.nextInt(2);
      int var7 = var4 - 6;
      boolean var8 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var9 = var2; var9 <= var2 + 1 + var4; var9++) {
            byte var12 = 1;
            if (var9 == var2) {
               var12 = 0;
            }

            if (var9 >= var2 + 1 + var4 - 1) {
               var12 = 3;
            }

            for (int var10 = var1 - var12; var10 <= var1 + var12 && var8; var10++) {
               for (int var11 = var3 - var12; var11 <= var3 + var12 && var8; var11++) {
                  if (var10 >= 0 && var9 >= 0 && var11 >= 0 && var10 < this.a && var9 < this.c && var11 < this.b) {
                     if ((this.d[(var9 * this.b + var11) * this.a + var10] & 255) != 0) {
                        var8 = false;
                        this.cantGrow = true;
                     }
                  } else {
                     var8 = false;
                     this.cantGrow = true;
                  }
               }
            }
         }

         if (!var8) {
            this.cantGrow = true;
            return;
         }

         int var18;
         if (((var18 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var18 == Block.k.at) && var2 < this.c - var4 - 1) {
            this.b(var1, var2 - 1, var3, Block.k.at);
            int var19 = var1 + 2 * var5;
            int var13 = var2 + var4;
            int var14 = var3;
            if (var6 == 1) {
               var19 = var1;
               var14 = var3 + 2 * var5;
            }

            this.setBlockAndMetadataWithNotify(var19, var13, var14, Block.z.at, 4);
            this.setBlockAndMetadataWithNotify(var19, var13 + 1, var14, Block.z.at, 4);

            for (int var15 = 1; var15 <= 3; var15++) {
               int var16 = var13;
               if (var15 == 3) {
                  var16 = var13 - 1;
               }

               this.setBlockAndMetadataWithNotify(var19 + var15, var16, var14 - var15, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19 + var15, var16, var14 + var15, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19 - var15, var16, var14 - var15, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19 - var15, var16, var14 + var15, Block.z.at, 4);
            }

            this.setBlockAndMetadataWithNotify(var19 + 1, var13 - 1, var14, Block.z.at, 4);
            this.setBlockAndMetadataWithNotify(var19 - 1, var13 - 1, var14, Block.z.at, 4);
            this.setBlockAndMetadataWithNotify(var19, var13 - 1, var14 + 1, Block.z.at, 4);
            this.setBlockAndMetadataWithNotify(var19, var13 - 1, var14 - 1, Block.z.at, 4);

            for (int var20 = 1; var20 <= 4; var20++) {
               int var22 = var13;
               if (var20 == 4) {
                  var22 = var13 - 1;
               }

               this.setBlockAndMetadataWithNotify(var19 + var20, var22, var14, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19 - var20, var22, var14, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19, var22, var14 + var20, Block.z.at, 4);
               this.setBlockAndMetadataWithNotify(var19, var22, var14 - var20, Block.z.at, 4);
            }

            this.setBlockAndMetadataWithNotify(var1, var2 + var7, var3, Block.y.at, 2);

            for (int var21 = 0; var21 < var4; var21++) {
               int var23 = var21 / 2;
               if (var23 > 2) {
                  var23 = 2;
               }

               byte var17 = 0;
               if (var4 == 8 && var5 != 0) {
                  var17 = 1;
               }

               if (var6 == 1) {
                  this.setBlockAndMetadataWithNotify(var1, var2 + var21 + var17, var3 + var23 * var5, Block.y.at, 2);
               } else {
                  this.setBlockAndMetadataWithNotify(var1 + var23 * var5, var2 + var21 + var17, var3, Block.y.at, 2);
               }

               if (var5 != 0) {
                  this.setBlockAndMetadataWithNotify(var1, var2, var3 + 1 * var5, Block.y.at, 2);
                  this.setBlockAndMetadataWithNotify(var1 + 1 * var5, var2, var3, Block.y.at, 2);
                  this.setBlockAndMetadataWithNotify(var1, var2, var3 - 1 * var5, Block.y.at, 2);
                  this.setBlockAndMetadataWithNotify(var1 - 1 * var5, var2, var3, Block.y.at, 2);
                  this.setBlockAndMetadataWithNotify(var1, var2, var3, Block.y.at, 2);
               }
            }

            this.cantGrow = false;
         } else {
            this.cantGrow = true;
         }
      } else {
         this.cantGrow = true;
      }
   }

   public void growTree(int var1, int var2, int var3, int var4) {
      int var5 = this.q.nextInt(3) + 4;
      if (var4 == 2) {
         var5 = this.q.nextInt(3) + 6;
      }

      boolean var6 = true;
      if (var2 > 0 && var2 + var5 + 1 <= this.c) {
         for (int var7 = var2; var7 <= var2 + 1 + var5; var7++) {
            byte var10 = 1;
            if (var7 == var2) {
               var10 = 0;
            }

            if (var7 >= var2 + 1 + var5 - 2) {
               var10 = 2;
            }

            for (int var8 = var1 - var10; var8 <= var1 + var10 && var6; var8++) {
               for (int var9 = var3 - var10; var9 <= var3 + var10 && var6; var9++) {
                  if (var8 >= 0 && var7 >= 0 && var9 >= 0 && var8 < this.a && var7 < this.c && var9 < this.b) {
                     if ((this.d[(var7 * this.b + var9) * this.a + var8] & 255) != 0) {
                        var6 = false;
                        this.cantGrow = true;
                     }
                  } else {
                     var6 = false;
                     this.cantGrow = true;
                  }
               }
            }
         }

         if (!var6) {
            this.cantGrow = true;
            return;
         }

         int var14;
         if (((var14 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var14 == Block.k.at) && var2 < this.c - var5 - 1) {
            this.b(var1, var2 - 1, var3, Block.k.at);

            for (int var18 = var2 - 3 + var5; var18 <= var2 + var5; var18++) {
               int var16 = var18 - (var2 + var5);
               int var17 = 1 - var16 / 2;

               for (int var11 = var1 - var17; var11 <= var1 + var17; var11++) {
                  int var12 = var11 - var1;

                  for (int var15 = var3 - var17; var15 <= var3 + var17; var15++) {
                     int var13 = var15 - var3;
                     if ((Math.abs(var12) != var17 || Math.abs(var13) != var17 || this.q.nextInt(2) != 0 && var16 != 0)
                        && !Block.e[this.a(var11, var18, var15)]
                        && this.a(var11, var18, var15) != Block.portal.at) {
                        if (var4 == 1) {
                           this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, this.q.nextInt(2) + 1);
                        } else if (var4 == 2) {
                           this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, 3);
                        } else {
                           this.setBlockAndMetadataWithNotify(var11, var18, var15, Block.z.at, var4);
                        }
                     }
                  }
               }
            }

            for (int var19 = 0; var19 < var5; var19++) {
               if (!Block.e[this.a(var1, var2 + var19, var3)]) {
                  if (var4 == 2) {
                     this.setBlockAndMetadataWithNotify(var1, var2 + var19, var3, Block.y.at, 1);
                  } else {
                     this.b(var1, var2 + var19, var3, Block.y.at);
                  }
               }
            }

            this.cantGrow = false;
         } else {
            this.cantGrow = true;
         }
      } else {
         this.cantGrow = true;
      }
   }

   public void growCaveTree(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(2) + 3;
      boolean var5 = true;
      if (var2 > 0 && var2 + var4 + 1 <= this.c) {
         for (int var6 = var2; var6 <= var2 + 1 + var4; var6++) {
            byte var9 = 1;

            for (int var7 = var1 - var9; var7 <= var1 + var9 && var5; var7++) {
               for (int var8 = var3 - var9; var8 <= var3 + var9 && var5; var8++) {
                  if (var7 >= 0 && var6 >= 0 && var8 >= 0 && var7 < this.a && var6 < this.c && var8 < this.b) {
                     if ((this.d[(var6 * this.b + var8) * this.a + var7] & 255) != 0) {
                        var5 = false;
                        this.cantGrow = true;
                     }
                  } else {
                     var5 = false;
                     this.cantGrow = true;
                  }
               }
            }
         }

         if (!var5) {
            this.cantGrow = true;
            return;
         }

         int var14;
         if (((var14 = this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.j.at || var14 == Block.k.at) && var2 < this.c - var4 - 1) {
            this.b(var1, var2 - 1, var3, Block.k.at);
            byte var10 = 2;
            if (var4 == 4) {
               var10 = 3;
            }

            for (int var17 = var2 - var10 + var4; var17 <= var2 + var4; var17++) {
               int var16 = var17 - (var2 + var4);

               for (int var11 = var1 - 1; var11 <= var1 + 1; var11++) {
                  int var12 = var11 - var1;

                  for (int var15 = var3 - 1; var15 <= var3 + 1; var15++) {
                     int var13 = var15 - var3;
                     if (var16 == -1 || var16 == -2 && var4 == 4 || Math.abs(var12) != 1 || Math.abs(var13) != 1) {
                        this.setBlockAndMetadataWithNotify(var11, var17, var15, Block.z.at, 5);
                     }
                  }
               }
            }

            for (int var18 = 0; var18 < var4; var18++) {
               if (!Block.e[this.a(var1, var2 + var18, var3)]) {
                  this.setBlockAndMetadataWithNotify(var1, var2 + var18, var3, Block.y.at, 3);
               }
            }

            this.cantGrow = false;
         } else {
            this.cantGrow = true;
         }
      } else {
         this.cantGrow = true;
      }
   }

   public void growLargeMushroom(int var1, int var2, int var3, int var4) {
      int var5 = this.I.nextInt(3) + 4;
      boolean var6 = true;
      if (var2 >= 1 && var2 + var5 + 1 < this.c) {
         for (int var7 = var2; var7 <= var2 + 1 + var5; var7++) {
            byte var11 = 3;
            if (var7 <= var2 + 3) {
               var11 = 0;
            }

            for (int var8 = var1 - var11; var8 <= var1 + var11 && var6; var8++) {
               for (int var9 = var3 - var11; var9 <= var3 + var11 && var6; var9++) {
                  if (var7 >= 0 && var8 >= 0 && var9 >= 0 && var8 < this.a && var9 < this.b && var7 < this.c) {
                     int var10 = this.a(var8, var7, var9);
                     if (var10 != 0 && var10 != Block.z.at && var10 != Block.B.at && var10 != Block.portal.at) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            }
         }

         if (!var6) {
            this.cantGrow = true;
         } else {
            int var14 = this.a(var1, var2 - 1, var3);
            if (var14 != Block.mycelium.at) {
               this.cantGrow = true;
            } else {
               int var20 = var2 + var5;
               if (var4 == 1) {
                  var20 = var2 + var5 - 3;
               }

               if (var4 == 2) {
                  var20 = var2 + var5 - 1;
               }

               for (int var15 = var20; var15 <= var2 + var5; var15++) {
                  int var17 = 1;
                  if (var15 < var2 + var5) {
                     var17++;
                  }

                  if (var4 == 0 || var4 == 2) {
                     var17 = 3;
                  }

                  for (int var19 = var1 - var17; var19 <= var1 + var17; var19++) {
                     for (int var12 = var3 - var17; var12 <= var3 + var17; var12++) {
                        int var13 = 5;
                        if (var19 == var1 - var17) {
                           var13--;
                        }

                        if (var19 == var1 + var17) {
                           var13++;
                        }

                        if (var12 == var3 - var17) {
                           var13 -= 3;
                        }

                        if (var12 == var3 + var17) {
                           var13 += 3;
                        }

                        if (var4 != 0 && var4 != 2 && var15 >= var2 + var5
                           || var19 != var1 - var17 && var19 != var1 + var17
                           || var12 != var3 - var17 && var12 != var3 + var17) {
                           if (var4 == 2 && var15 == var2 + var5 && (var1 == var19 + 3 || var1 == var19 - 3 || var3 == var12 + 3 || var3 == var12 - 3)) {
                              var13 = 0;
                           }

                           if (var13 == 5 && var15 < var2 + var5) {
                              var13 = 0;
                           }

                           if ((var13 != 0 || var2 >= var2 + var5 - 1) && !Block.e[this.a(var19, var15, var12)]) {
                              this.setBlockAndMetadata(var19, var15, var12, Block.mushroomCap.at, var4);
                           }
                        }
                     }
                  }
               }

               for (int var16 = 0; var16 < var5; var16++) {
                  int var18 = this.a(var1, var2 + var16, var3);
                  if (!Block.e[var18]) {
                     this.a(var1, var2 + var16, var3, Block.mushroomStem.at);
                  }
               }

               this.a(var1, var2 - 1, var3, Block.k.at);
               this.cantGrow = false;
            }
         }
      } else {
         this.cantGrow = true;
      }
   }

   public boolean growLargeMushrooms(int var1, int var2, int var3, int var4) {
      int var5 = this.I.nextInt(3) + 4;
      boolean var6 = true;
      if (var2 >= 1 && var2 + var5 + 1 < this.c) {
         for (int var7 = var2; var7 <= var2 + 1 + var5; var7++) {
            byte var11 = 3;
            if (var7 <= var2 + 3) {
               var11 = 0;
            }

            for (int var8 = var1 - var11; var8 <= var1 + var11 && var6; var8++) {
               for (int var9 = var3 - var11; var9 <= var3 + var11 && var6; var9++) {
                  if (var7 >= 0 && var8 >= 0 && var9 >= 0 && var8 < this.a && var9 < this.b && var7 < this.c) {
                     int var10 = this.a(var8, var7, var9);
                     if (var10 != 0 && var10 != Block.z.at && var10 != Block.B.at && var10 != Block.portal.at) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            }
         }

         if (!var6) {
            return false;
         } else {
            int var14 = this.a(var1, var2 - 1, var3);
            if (var14 != Block.mycelium.at) {
               return false;
            } else {
               int var20 = var2 + var5;
               if (var4 == 1) {
                  var20 = var2 + var5 - 3;
               }

               if (var4 == 2) {
                  var20 = var2 + var5 - 1;
               }

               for (int var15 = var20; var15 <= var2 + var5; var15++) {
                  int var17 = 1;
                  if (var15 < var2 + var5) {
                     var17++;
                  }

                  if (var4 == 0 || var4 == 2) {
                     var17 = 3;
                  }

                  for (int var19 = var1 - var17; var19 <= var1 + var17; var19++) {
                     for (int var12 = var3 - var17; var12 <= var3 + var17; var12++) {
                        int var13 = 5;
                        if (var19 == var1 - var17) {
                           var13--;
                        }

                        if (var19 == var1 + var17) {
                           var13++;
                        }

                        if (var12 == var3 - var17) {
                           var13 -= 3;
                        }

                        if (var12 == var3 + var17) {
                           var13 += 3;
                        }

                        if (var4 != 0 && var4 != 2 && var15 >= var2 + var5
                           || var19 != var1 - var17 && var19 != var1 + var17
                           || var12 != var3 - var17 && var12 != var3 + var17) {
                           if (var4 == 2 && var15 == var2 + var5 && (var1 == var19 + 3 || var1 == var19 - 3 || var3 == var12 + 3 || var3 == var12 - 3)) {
                              var13 = 0;
                           }

                           if (var13 == 5 && var15 < var2 + var5) {
                              var13 = 0;
                           }

                           if ((var13 != 0 || var2 >= var2 + var5 - 1) && !Block.e[this.a(var19, var15, var12)]) {
                              this.setBlockAndMetadata(var19, var15, var12, Block.mushroomCap.at, var4);
                           }
                        }
                     }
                  }
               }

               for (int var16 = 0; var16 < var5; var16++) {
                  int var18 = this.a(var1, var2 + var16, var3);
                  if (!Block.e[var18]) {
                     this.a(var1, var2 + var16, var3, Block.mushroomStem.at);
                  }
               }

               this.a(var1, var2 - 1, var3, Block.k.at);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public boolean growCactus(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(3) + 1;
      boolean var5 = true;

      for (int var6 = var2; var6 <= var2 + 1 + var4; var6++) {
         byte var9 = 1;
         if (var6 == var2) {
            var9 = 0;
         }

         if (var6 >= var2 + 1 + var4 - 2) {
            var9 = 2;
         }

         for (int var7 = var1 - var9; var7 <= var1 + var9 && var5; var7++) {
            for (int var8 = var3 - var9; var8 <= var3 + var9 && var5; var8++) {
               if (var7 >= 0 && var6 >= 0 && var8 >= 0 && var7 < this.a && var6 < this.c && var8 < this.b) {
                  if ((this.d[(var6 * this.b + var8) * this.a + var7] & 255) != 0) {
                     var5 = false;
                  }
               } else {
                  var5 = false;
               }
            }
         }
      }

      if (!var5) {
         return false;
      } else if ((this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.t.at && var2 < this.c - var4 - 1) {
         for (int var10 = 0; var10 < var4; var10++) {
            if (Block.cactus.canBlockStay(this, var1, var2 + var10, var3)) {
               this.a(var1, var2 + var10, var3, Block.cactus.at);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean growSeaweed(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(12) + 1;
      if (var2 < var4) {
         return false;
      } else if (this.a(var1, var2, var3) == Block.k.at && this.f(var1, var2 + 1, var3) == Material.f && var2 < this.c - var4 - 1) {
         for (int var5 = 0; var5 < var4; var5++) {
            if (Block.seaweed.canBlockStay(this, var1, var2 + var5 + 1, var3)) {
               this.a(var1, var2 + var5 + 1, var3, Block.seaweed.at);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean growCoralFans(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(12) + 1;
      if (var2 < var4) {
         return false;
      } else if (this.a(var1, var2, var3) == Block.coral.at && this.f(var1, var2 + 1, var3) == Material.f && var2 < this.c - var4 - 1) {
         for (int var5 = 0; var5 < var4; var5++) {
            if (Block.coralFan.canBlockStay(this, var1, var2 + var5 + 1, var3)) {
               this.setBlockAndMetadata(var1, var2 + var5 + 1, var3, Block.coralFan.at, this.e(var1, var2, var3));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean growStalactites(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(5) + 1;
      boolean var5 = true;

      for (int var6 = var2; var6 <= var2 + 1 + var4; var6++) {
         byte var9 = 1;
         if (var6 == var2) {
            var9 = 0;
         }

         if (var6 >= var2 + 1 + var4 - 2) {
            var9 = 2;
         }

         for (int var7 = var1 - var9; var7 <= var1 + var9 && var5; var7++) {
            for (int var8 = var3 - var9; var8 <= var3 + var9 && var5; var8++) {
               if (var7 >= 0 && var6 >= 0 && var8 >= 0 && var7 < this.a && var6 < this.c && var8 < this.b) {
                  if ((this.d[(var6 * this.b + var8) * this.a + var7] & 255) != 0) {
                     var5 = false;
                  }
               } else {
                  var5 = false;
               }
            }
         }
      }

      if (!var5) {
         return false;
      } else if ((this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.i.at && var2 < this.c - var4 - 1) {
         for (int var10 = 0; var10 < var4; var10++) {
            if (Block.stalactite.canBlockStay(this, var1, var2 + var10, var3)) {
               this.a(var1, var2 + var10, var3, Block.stalactite.at);
               if (this.a((float)var1, (float)(var2 - 1), (float)var3) && var4 > 1) {
                  this.setBlockMetadata(var1, var2, var3, 0);
               } else {
                  this.setBlockMetadata(var1, var2, var3, 2);
               }
            }
         }

         for (int var11 = 0; var11 < var4; var11++) {
            if (this.a(var1, var2 + var11 - 1, var3) == Block.stalactite.at && this.a(var1, var2 + var11 + 1, var3) == Block.stalactite.at && var4 > 2) {
               this.setBlockMetadata(var1, var2 + var11, var3, 1);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean growStalagmites(int var1, int var2, int var3) {
      int var4 = this.q.nextInt(7) + 1;
      if (var2 < var4) {
         return false;
      } else {
         boolean var5 = true;

         for (int var6 = var2; var6 <= var2 - 1 - var4; var6--) {
            byte var9 = 2;
            if (var6 == var2) {
               var9 = 0;
            }

            for (int var7 = var1 - var9; var7 <= var1 + var9 && var5; var7++) {
               for (int var8 = var3 - var9; var8 <= var3 + var9 && var5; var8++) {
                  if (var7 >= 0 && var6 >= 0 && var8 >= 0 && var7 < this.a && var6 < this.c && var8 < this.b) {
                     if ((this.d[(var6 * this.b + var8) * this.a + var7] & 255) != 0) {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if (!var5) {
            return false;
         } else if ((this.d[((var2 - 1) * this.b + var3) * this.a + var1] & 255) == Block.i.at && var2 < this.c - var4 - 1) {
            if (this.a(var1, var2 + 1, var3) == Block.i.at) {
               for (int var10 = 0; var10 < var4; var10++) {
                  if (this.a(var1, var2 - var10, var3) == 0 && this.a(var1, var2 - var10 - 1, var3) == 0) {
                     this.a(var1, var2 - var10, var3, Block.stalactite.at);
                     this.setBlockMetadata(var1, var2, var3, 4);
                  }
               }
            }

            for (int var11 = 0; var11 < var4; var11++) {
               if (this.a(var1, var2 - var11 + 1, var3) == Block.stalactite.at && this.a(var1, var2 - var11 - 1, var3) == Block.stalactite.at && var4 > 2) {
                  this.setBlockMetadata(var1, var2 - var11, var3, 5);
               }

               if (this.a((float)var1, (float)(var2 - var11 + 1), (float)var3) && this.a(var1, var2 - var11 - 1, var3) == Block.stalactite.at) {
                  this.setBlockMetadata(var1, var2 - var11, var3, 3);
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public Entity i() {
      return this.y;
   }

   public boolean spawnEntityInWorld(Entity var1) {
      this.chunkMap.addEntity(var1);
      this.r.a(var1);
      var1.a(this);
      if (var1 instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)var1;
         this.playerEntities.add(var2);
      }

      this.obtainEntitySkin(var1);
      return true;
   }

   public void obtainEntitySkin(Entity var1) {
      for (int var2 = 0; var2 < this.n.size(); var2++) {
         this.n.get(var2).a(var1);
      }
   }

   public void b(Entity var1) {
      this.r.b(var1);

      for (int var2 = 0; var2 < this.n.size(); var2++) {
         this.n.get(var2).b(var1);
      }
   }

   public void a(Entity var1, float var2, float var3, float var4, float var5) {
      this.a(var2, var3, var4, "random.explode", 4.0F, (1.0F + (this.q.nextFloat() - this.q.nextFloat()) * 0.2F) * 0.7F);
      TreeSet var6 = new TreeSet();

      for (int var8 = 0; var8 < 16; var8++) {
         for (int var9 = 0; var9 < 16; var9++) {
            for (int var10 = 0; var10 < 16; var10++) {
               if (var8 == 0 || var8 == 15 || var9 == 0 || var9 == 15 || var10 == 0 || var10 == 15) {
                  float var11 = (float)var8 / 15.0F * 2.0F - 1.0F;
                  float var17 = (float)var9 / 15.0F * 2.0F - 1.0F;
                  float var18 = (float)var10 / 15.0F * 2.0F - 1.0F;
                  float var19 = (float)Math.sqrt((double)(var11 * var11 + var17 * var17 + var18 * var18));
                  var11 /= var19;
                  var17 /= var19;
                  var18 /= var19;
                  float var20 = var5 * (0.7F + this.q.nextFloat() * 0.6F);
                  float var21 = var2;
                  float var22 = var3;

                  for (float var12 = var4; var20 > 0.0F; var20 -= 0.22500001F) {
                     int var13 = (int)var21;
                     int var14 = (int)var22;
                     int var15 = (int)var12;
                     int var16;
                     if ((var16 = this.a(var13, var14, var15)) > 0) {
                        var20 -= (Block.c[var16].g() + 0.3F) * 0.3F;
                     }

                     if (var20 > 0.0F) {
                        int var23 = var13 + (var14 << 10) + (var15 << 10 << 10);
                        var6.add(var23);
                     }

                     var21 += var11 * 0.3F;
                     var22 += var17 * 0.3F;
                     var12 += var18 * 0.3F;
                  }
               }
            }
         }
      }

      var5 *= 2.0F;
      int var40 = (int)(var2 - var5 - 1.0F);
      int var42 = (int)(var2 + var5 + 1.0F);
      int var43 = (int)(var3 - var5 - 1.0F);
      int var54 = (int)(var3 + var5 + 1.0F);
      int var56 = (int)(var4 - var5 - 1.0F);
      int var57 = (int)(var4 + var5 + 1.0F);
      List var58 = this.r.a(var1, (float)var40, (float)var43, (float)var56, (float)var42, (float)var54, (float)var57);
      net.minecraft.a.d.C_a var59 = new net.minecraft.a.d.C_a(var2, var3, var4);

      for (int var25 = 0; var25 < var58.size(); var25++) {
         Entity var26;
         Entity var27;
         float var60 = (var26 = var27 = (Entity)var58.get(var25)).h - var2;
         float var62 = var26.i - var3;
         float var28 = var26.j - var4;
         float var48;
         if ((var48 = MathHelper.c(var60 * var60 + var62 * var62 + var28 * var28) / var5) <= 1.0F) {
            var28 = var27.h - var2;
            float var29 = var27.i - var3;
            float var30 = var27.j - var4;
            float var31 = MathHelper.c(var28 * var28 + var29 * var29 + var30 * var30);
            var28 /= var31;
            var29 /= var31;
            var30 /= var31;
            float var32 = this.a(var59, var27.r);
            float var24 = (1.0F - var48) * var32;
            float var33 = 1.0F - var48;
            if (!var27.deflectProjectile) {
               if (var1 != null) {
                  var27.attackEntityFrom(var1, (int)(var33 * 25.0F + 1.0F), 0.4F);
               } else {
                  var27.attackEntityFrom(var1, (int)((var24 * var24 + var24) / 2.0F * 8.0F * var5 + 1.0F), 0.4F);
               }
            } else {
               ItemStack var34 = ((EntityPlayer)var27).b.charmSlot[0];
               if (var34 != null && var34.c == Item.shield.ap) {
                  if (var1 != null) {
                     var34.damageItem2((int)(var33 * 25.0F + 1.0F), this);
                  } else {
                     var34.damageItem2((int)((var24 * var24 + var24) / 2.0F * 8.0F * var5 + 1.0F), this);
                  }
               }
            }

            var27.k += var28 * var24;
            var27.l += var29 * var24;
            var27.m += var30 * var24;
         }
      }

      var5 = var5;
      ArrayList var67 = new ArrayList();
      var67.addAll(var6);

      for (int var68 = var67.size() - 1; var68 >= 0; var68--) {
         int var69;
         var40 = (var69 = (Integer)var67.get(var68)) & 1023;
         int var49 = var69 >> 10 & 1023;
         int var50 = var69 >> 20 & 1023;
         if (var40 > 0 && var49 > 0 && var50 > 0 && var40 < this.a - 1 && var49 < this.c - 1 && var50 < this.b - 1) {
            int var51 = this.a(var40, var49, var50);

            for (int var52 = 0; var52 <= 0; var52++) {
               float var66 = (float)var40 + this.q.nextFloat();
               float var61 = (float)var49 + this.q.nextFloat();
               float var72 = (float)var50 + this.q.nextFloat();
               float var74 = var66 - var2;
               float var37 = var61 - var3;
               float var63 = var72 - var4;
               float var45 = MathHelper.c(var74 * var74 + var37 * var37 + var63 * var63);
               var74 /= var45;
               var37 /= var45;
               var63 /= var45;
               float var46;
               var45 = (var46 = 0.5F / (var45 / var5 + 0.1F)) * (this.q.nextFloat() * this.q.nextFloat() + 0.3F);
               var74 *= var45;
               var37 *= var45;
               var63 *= var45;
               this.a("explode", (var66 + var2) / 2.0F, (var61 + var3) / 2.0F, (var72 + var4) / 2.0F, var74, var37, var63);
               this.a("smoke", var66, var61, var72, var74, var37, var63);
            }

            if (var51 > 0) {
               Block.c[var51].a(this, var40, var49, var50, this.e(var40, var49, var50), 0.3F);
               this.b(var40, var49, var50, 0);
               Block.c[var51].c(this, var40, var49, var50);
            }
         }
      }
   }

   private float a(net.minecraft.a.d.C_a var1, net.minecraft.a.d.C_b var2) {
      float var3 = 1.0F / ((var2.d - var2.a) * 2.0F + 1.0F);
      float var4 = 1.0F / ((var2.e - var2.b) * 2.0F + 1.0F);
      float var5 = 1.0F / ((var2.f - var2.c) * 2.0F + 1.0F);
      int var6 = 0;
      int var7 = 0;

      for (float var8 = 0.0F; var8 <= 1.0F; var8 += var3) {
         for (float var9 = 0.0F; var9 <= 1.0F; var9 += var4) {
            for (float var10 = 0.0F; var10 <= 1.0F; var10 += var5) {
               float var11 = var2.a + (var2.d - var2.a) * var8;
               float var12 = var2.b + (var2.e - var2.b) * var9;
               float var13 = var2.c + (var2.f - var2.c) * var10;
               if (this.a(new net.minecraft.a.d.C_a(var11, var12, var13), var1) == null) {
                  var6++;
               }

               var7++;
            }
         }
      }

      return (float)var6 / (float)var7;
   }

   public Entity b(Class<?> var1) {
      for (int var2 = 0; var2 < this.r.e.size(); var2++) {
         Entity var3 = this.r.e.get(var2);
         if (var1.isAssignableFrom(var3.getClass())) {
            return var3;
         }
      }

      return null;
   }

   public int a(int var1, int var2, int var3, int var4, int var5) {
      if (var1 >= 0 && var2 >= 0 && var3 >= 0 && var1 < this.a && var2 < this.c && var3 < this.b) {
         int var6 = var1;
         int var7 = var3;
         int var8 = ((var2 << 10) + var3 << 10) + var1;
         byte var9 = 0;
         int var10 = var9 + 1;
         this.P[0] = var1 + (var3 << 10);
         int var11 = -9999;
         if (var4 == Block.q.at || var4 == Block.p.at) {
            var11 = Block.ah.at;
         }

         if (var4 == Block.s.at || var4 == Block.r.at) {
            var11 = Block.ai.at;
         }

         int var12;
         boolean var13;
         do {
            var13 = false;
            int var14 = -1;
            var12 = 0;
            if (++N == 30000) {
               Arrays.fill(this.O, (short)0);
               N = 1;
            }

            while (var10 > 0) {
               int var15 = this.P[--var10];
               if (this.O[var15] != N) {
                  var1 = var15 % 1024;

                  int var16;
                  for (var16 = (var16 = (var3 = var15 / 1024) - var7) * var16;
                     var1 > 0
                        && this.O[var15 - 1] != N
                        && (this.d[(var2 * this.b + var3) * this.a + var1 - 1] == var4 || this.d[(var2 * this.b + var3) * this.a + var1 - 1] == var5);
                     var15--
                  ) {
                     var1--;
                  }

                  if (var1 > 0 && this.d[(var2 * this.b + var3) * this.a + var1 - 1] == var11) {
                     var13 = true;
                  }

                  boolean var17 = false;
                  boolean var18 = false;

                  for (boolean var19 = false;
                     var1 < this.a
                        && this.O[var15] != N
                        && (this.d[(var2 * this.b + var3) * this.a + var1] == var4 || this.d[(var2 * this.b + var3) * this.a + var1] == var5);
                     var1++
                  ) {
                     if (var3 > 0) {
                        byte var20;
                        if ((var20 = this.d[(var2 * this.b + var3 - 1) * this.a + var1]) == var11) {
                           var13 = true;
                        }

                        boolean var21;
                        if ((var21 = this.O[var15 - 1024] != N && (var20 == var4 || var20 == var5)) && !var17) {
                           this.P[var10++] = var15 - 1024;
                        }

                        var17 = var21;
                     }

                     if (var3 < this.b - 1) {
                        byte var27;
                        if ((var27 = this.d[(var2 * this.b + var3 + 1) * this.a + var1]) == var11) {
                           var13 = true;
                        }

                        boolean var29;
                        if ((var29 = this.O[var15 + 1024] != N && (var27 == var4 || var27 == var5)) && !var18) {
                           this.P[var10++] = var15 + 1024;
                        }

                        var18 = var29;
                     }

                     if (var2 < this.c - 1) {
                        byte var28;
                        boolean var30;
                        if ((var30 = (var28 = this.d[((var2 + 1) * this.b + var3) * this.a + var1]) == var4 || var28 == var5) && !var19) {
                           this.Q[var12++] = var15;
                        }

                        var19 = var30;
                     }

                     int var22;
                     if ((var22 = (var22 = var1 - var6) * var22 + var16) > var14) {
                        var14 = var22;
                        var8 = ((var2 << 10) + var3 << 10) + var1;
                     }

                     this.O[var15++] = N;
                  }

                  if (var1 < this.a && this.d[(var2 * this.b + var3) * this.a + var1] == var11) {
                     var13 = true;
                  }
               }
            }

            var2++;
            int[] var26 = this.Q;
            this.Q = this.P;
            this.P = var26;
            var10 = var12;
         } while (var12 > 0);

         return var13 ? -9999 : var8;
      } else {
         return -1;
      }
   }

   public boolean floodFill(int var1, int var2, int var3, int var4, int var5) {
      if (var1 >= 0 && var2 >= 0 && var3 >= 0 && var1 < this.a && var2 < this.c && var3 < this.b) {
         if (++N == 30000) {
            Arrays.fill(this.O, (short)0);
            N = 1;
         }

         byte var6 = 0;
         int var7 = var6 + 1;
         this.P[0] = var1 + (var3 << 10);

         while (var7 > 0) {
            int var8 = this.P[--var7];
            if (this.O[var8] != N) {
               var1 = var8 % 1024;
               var3 = var8 / 1024;
               if (var1 == 0 || var1 == this.a - 1 || var2 == 0 || var2 == this.c - 1 || var3 == 0 || var3 == this.b - 1) {
                  return false;
               }

               while (
                  var1 > 0
                     && this.O[var8 - 1] != N
                     && (this.d[(var2 * this.b + var3) * this.a + var1 - 1] == var4 || this.d[(var2 * this.b + var3) * this.a + var1 - 1] == var5)
               ) {
                  var1--;
                  var8--;
               }

               if (var1 > 0 && this.d[(var2 * this.b + var3) * this.a + var1 - 1] == 0) {
                  return false;
               }

               boolean var9 = false;

               for (boolean var10 = false;
                  var1 < this.a
                     && this.O[var8] != N
                     && (this.d[(var2 * this.b + var3) * this.a + var1] == var4 || this.d[(var2 * this.b + var3) * this.a + var1] == var5);
                  var1++
               ) {
                  if (var1 == 0 || var1 == this.a - 1) {
                     return false;
                  }

                  if (var3 > 0) {
                     byte var11;
                     if ((var11 = this.d[(var2 * this.b + var3 - 1) * this.a + var1]) == 0) {
                        return false;
                     }

                     boolean var12;
                     if ((var12 = this.O[var8 - 1024] != N && (var11 == var4 || var11 == var5)) && !var9) {
                        this.P[var7++] = var8 - 1024;
                     }

                     var9 = var12;
                  }

                  if (var3 < this.c - 1) {
                     byte var15;
                     if ((var15 = this.d[(var2 * this.b + var3 + 1) * this.a + var1]) == 0) {
                        return false;
                     }

                     boolean var16;
                     if ((var16 = this.O[var8 + 1024] != N && (var15 == var4 || var15 == var5)) && !var10) {
                        this.P[var7++] = var8 + 1024;
                     }

                     var10 = var16;
                  }

                  this.O[var8] = N;
                  var8++;
               }

               if (var1 < this.a && this.d[(var2 * this.b + var3) * this.a + var1] == 0) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected void updateWeather() {
      if (this.weatherUpdates > 0) {
         this.weatherUpdates--;
      }

      if (this.season.currentSeason == 1 || this.season.currentSeason == 3) {
         int var1 = this.getThunderTime();
         if (var1 <= 0) {
            if (this.getThundering()) {
               if (this.season.currentSeason == 3) {
                  this.setThunderTime(this.I.nextInt(24000) + 7200);
               } else {
                  this.setThunderTime(this.I.nextInt(12000) + 3600);
               }
            } else {
               this.setThunderTime(this.I.nextInt(168000) + 12000);
            }
         } else {
            this.setThunderTime(--var1);
            if (var1 <= 0 && this.raining) {
               this.setThundering(!this.getThundering());
            }
         }
      }

      int var6 = this.getRainTime();
      if (var6 <= 0) {
         if (this.getRaining()) {
            if (this.season.currentSeason == 3) {
               this.setRainTime(this.I.nextInt(24000) + 24000);
            } else {
               this.setRainTime(this.I.nextInt(12000) + 12000);
            }
         } else {
            this.setRainTime(this.I.nextInt(168000) + 12000);
         }
      } else {
         this.setRainTime(--var6);
         if (var6 <= 0) {
            this.setRaining(!this.getRaining());
            if (!this.getRaining() && this.getThundering()) {
               this.setThundering(false);
            }
         }
      }

      if (this.season.currentSeason == 2) {
         int var2 = this.getWindTime();
         if (var2 <= 0) {
            this.windForce = this.I.nextFloat();
            this.windDirection = (byte)this.I.nextInt(8);
            this.setWindTime(this.I.nextInt(600) + 12000);
         } else {
            this.setWindTime(--var2);
         }
      } else {
         this.windForce = 0.0F;
      }

      double var9 = (double)(512 >> (this.fogDensity << 1));
      if (var9 == 32.0) {
         var9 = 64.0;
      }

      if ((double)this.fogDistance > var9) {
         this.fogDistance = (float)((double)this.fogDistance - 0.1);
         if (this.fogDensity == 1 && this.fogDistance < 128.0F) {
            this.fogDistance = 128.0F;
         }

         if (this.fogDensity == 2 && this.fogDistance < 64.0F) {
            this.fogDistance = 64.0F;
         }
      } else if ((double)this.fogDistance < var9) {
         this.fogDistance = (float)((double)this.fogDistance + 0.1);
         if (this.fogDensity == 1 && this.fogDistance > 128.0F) {
            this.fogDistance = 128.0F;
         }

         if (this.fogDensity == 2 && this.fogDistance > 64.0F) {
            this.fogDistance = 64.0F;
         }
      }

      if (this.fogDistance > 512.0F) {
         this.fogDistance = 512.0F;
      }

      if (this.fogDistance < 16.0F) {
         this.fogDistance = 16.0F;
      }

      if (this.season.currentSeason == 3) {
         int var4 = this.getFogTime();
         if (var4 <= 0) {
            this.fogDensity = this.I.nextInt(4);
            this.setFogTime(this.I.nextInt(12000) + 12000);
         } else {
            this.setFogTime(--var4);
         }
      } else {
         this.fogDensity = 0;
      }

      this.prevRainingStrength = this.rainingStrength;
      if (this.getRaining()) {
         this.rainingStrength = (float)((double)this.rainingStrength + 0.01);
      } else {
         this.rainingStrength = (float)((double)this.rainingStrength - 0.01);
      }

      if (this.rainingStrength < 0.0F) {
         this.rainingStrength = 0.0F;
      }

      if (this.rainingStrength > 1.0F) {
         this.rainingStrength = 1.0F;
      }

      this.prevThunderingStrength = this.thunderingStrength;
      if (this.getThundering()) {
         this.thunderingStrength = (float)((double)this.thunderingStrength + 0.01);
      } else {
         this.thunderingStrength = (float)((double)this.thunderingStrength - 0.01);
      }

      if (this.thunderingStrength < 0.0F) {
         this.thunderingStrength = 0.0F;
      }

      if (this.thunderingStrength > 1.0F) {
         this.thunderingStrength = 1.0F;
      }
   }

   public float getThunderStatus(float var1) {
      return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * var1) * this.getRainStatus(var1);
   }

   public float getRainStatus(float var1) {
      return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * var1;
   }

   public void setWeather(float var1) {
      this.prevRainingStrength = var1;
      this.rainingStrength = var1;
   }

   public boolean getThundering() {
      return this.thundering;
   }

   public void setThundering(boolean var1) {
      this.thundering = var1;
   }

   public int getThunderTime() {
      return this.thunderTime;
   }

   public void setThunderTime(int var1) {
      this.thunderTime = var1;
   }

   public boolean getRaining() {
      return this.raining;
   }

   public void setRaining(boolean var1) {
      this.raining = var1;
   }

   public int getRainTime() {
      return this.rainTime;
   }

   public void setRainTime(int var1) {
      this.rainTime = var1;
   }

   public int getWindTime() {
      return this.windTime;
   }

   public void setWindTime(int var1) {
      this.windTime = var1;
   }

   public float getWindForce() {
      return this.windForce;
   }

   public int getWindDirection() {
      return this.windDirection;
   }

   public void setWindDirection(byte var1, float var2) {
      this.windDirection = var1;
      this.windForce = var2;
   }

   public int getFogTime() {
      return this.fogTime;
   }

   public void setFogTime(int var1) {
      this.fogTime = var1;
   }

   public float getFogDistance() {
      return this.fogDistance;
   }

   public int getFogDensity() {
      return this.fogDensity;
   }

   public void setFogDensity(int var1) {
      this.fogDensity = var1;
   }

   public boolean isBloodMoon() {
      return this.bloodMoon;
   }

   public void setBloodMoon(boolean var1) {
      this.bloodMoon = var1;
   }

   private void updateWeatherStatus() {
      if (this.getRaining()) {
         this.rainingStrength = 1.0F;
         if (this.getThundering()) {
            this.thunderingStrength = 1.0F;
         }
      }
   }

   public boolean isBlockProvidingPowerTo(int var1, int var2, int var3, int var4) {
      int var5 = this.a(var1, var2, var3);
      return var5 == 0 ? false : Block.c[var5].isProvidingStrongPower(this, var1, var2, var3, var4);
   }

   public boolean isBlockGettingPowered(int var1, int var2, int var3) {
      return this.isBlockProvidingPowerTo(var1, var2 - 1, var3, 0)
         ? true
         : (
            this.isBlockProvidingPowerTo(var1, var2 + 1, var3, 1)
               ? true
               : (
                  this.isBlockProvidingPowerTo(var1, var2, var3 - 1, 2)
                     ? true
                     : (
                        this.isBlockProvidingPowerTo(var1, var2, var3 + 1, 3)
                           ? true
                           : (this.isBlockProvidingPowerTo(var1 - 1, var2, var3, 4) ? true : this.isBlockProvidingPowerTo(var1 + 1, var2, var3, 5))
                     )
               )
         );
   }

   public boolean isBlockIndirectlyProvidingPowerTo(int var1, int var2, int var3, int var4) {
      int var5 = this.a(var1, var2, var3);
      Block var6 = Block.c[var5];
      boolean var7 = false;
      boolean var8 = false;
      if (this.b(var1, var2, var3)) {
         var7 |= this.isBlockGettingPowered(var1, var2, var3);
         if (!var6.canProvidePower()) {
            var8 = true;
         }
      }

      if (!var8) {
         var7 |= var5 == 0 ? false : Block.c[var5].isProvidingWeakPower(this, var1, var2, var3, var4);
      }

      return var7;
   }

   public boolean isBlockIndirectlyGettingPowered(int var1, int var2, int var3) {
      return this.isBlockIndirectlyProvidingPowerTo(var1, var2 - 1, var3, 0)
         ? true
         : (
            this.isBlockIndirectlyProvidingPowerTo(var1, var2 + 1, var3, 1)
               ? true
               : (
                  this.isBlockIndirectlyProvidingPowerTo(var1, var2, var3 - 1, 2)
                     ? true
                     : (
                        this.isBlockIndirectlyProvidingPowerTo(var1, var2, var3 + 1, 3)
                           ? true
                           : (
                              this.isBlockIndirectlyProvidingPowerTo(var1 - 1, var2, var3, 4)
                                 ? true
                                 : this.isBlockIndirectlyProvidingPowerTo(var1 + 1, var2, var3, 5)
                           )
                     )
               )
         );
   }

   public void a(Entity var1, String var2, float var3, float var4) {
      for (int var5 = 0; var5 < this.n.size(); var5++) {
         float var6 = 16.0F;
         if (var3 > 1.0F) {
            var6 = 16.0F * var3;
         }

         float var7 = var1.h - this.y.h;
         float var8 = var1.i - this.y.i;
         float var9 = var1.j - this.y.j;
         if (var7 * var7 + var8 * var8 + var9 * var9 < var6 * var6) {
            this.n.get(var5).playMobSound(var2, var1.h, var1.i - var1.v, var1.j, var3, var4);
         }
      }
   }

   public void a(float var1, float var2, float var3, String var4, float var5, float var6) {
      try {
         for (int var7 = 0; var7 < this.n.size(); var7++) {
            float var8 = 16.0F;
            if (var5 > 1.0F) {
               var8 = 16.0F * var5;
            }

            float var9 = var1 - this.y.h;
            float var10 = var2 - this.y.i;
            float var11 = var3 - this.y.j;
            if (var9 * var9 + var10 * var10 + var11 * var11 < var8 * var8) {
               this.n.get(var7).a(var4, var1, var2, var3, var5, var6);
            }
         }
      } catch (Exception var12) {
         var12.printStackTrace();
      }
   }

   public void playSoundAtBlock(float var1, float var2, float var3, String var4, float var5, float var6) {
      try {
         for (int var7 = 0; var7 < this.n.size(); var7++) {
            float var8 = 16.0F;
            if (var5 > 1.0F) {
               var8 = 16.0F * var5;
            }

            float var9 = var1 - this.y.h;
            float var10 = var2 - this.y.i;
            float var11 = var3 - this.y.j;
            if (var9 * var9 + var10 * var10 + var11 * var11 < var8 * var8) {
               this.n.get(var7).playBlockSound(var4, var1, var2, var3, var5, var6);
            }
         }
      } catch (Exception var12) {
         var12.printStackTrace();
      }
   }

   public void playRecord(String var1, int var2, int var3, int var4) {
      for (int var5 = 0; var5 < this.n.size(); var5++) {
         this.n.get(var5).playRecord(var1, var2, var3, var4);
      }
   }

   public boolean containsFire(int var1, int var2, int var3, int var4) {
      boolean var5 = false;
      if (this.multiplayerWorld) {
         return false;
      } else {
         if (var4 == 0) {
            var2--;
         }

         if (var4 == 1) {
            var2++;
         }

         if (var4 == 2) {
            var3--;
         }

         if (var4 == 3) {
            var3++;
         }

         if (var4 == 4) {
            var1--;
         }

         if (var4 == 5) {
            var1++;
         }

         if (this.a(var1, var2, var3) == Block.ag.at || this.a(var1, var2, var3) == Block.hellfire.at) {
            var5 = true;
            this.a((float)var1 + 0.5F, (float)var2 + 0.5F, (float)var3 + 0.5F, "random.fizz", 0.5F, 2.6F + (this.q.nextFloat() - this.q.nextFloat()) * 0.8F);
            this.b(var1, var2, var3, 0);
            this.mc.f.addStat(StatList.firesDoused, 1);
         }

         return var5;
      }
   }

   public void a(int var1, int var2, int var3, TileEntity var4) {
      if (var4 != null && !var4.isRemoving()) {
         this.H.add(var4);
         var4.a = this;
         var4.b = var1;
         var4.c = var2;
         var4.d = var3;
         if (this.a(var1, var2, var3) != 0 && Block.c[this.a(var1, var2, var3)] instanceof BlockContainer) {
            var4.unmarkForRemoval();
            this.o.put(var1 + (var2 << 10) + (var3 << 10 << 10), var4);
         } else {
            System.out.println("Attempted to place a tile entity where there was no entity tile!");
         }
      }
   }

   public void i(int var1, int var2, int var3) {
      TileEntity var4 = this.j(var1, var2, var3);
      if (var4 != null && this.tileEntityFlag) {
         var4.markForRemoval();
      } else {
         if (var4 != null) {
            this.H.remove(var4);
         }

         TileEntity var5 = this.o.remove(var1 + (var2 << 10) + (var3 << 10 << 10));
         if (var5 != null) {
            var5.markForRemoval();
         }
      }
   }

   public TileEntity j(int var1, int var2, int var3) {
      int var4 = var1 + (var2 << 10) + (var3 << 10 << 10);
      TileEntity var5;
      if ((var5 = this.o.get(var4)) == null) {
         int var6 = this.a(var1, var2, var3);
         if (var6 <= 0 || !Block.c[var6].hasTileEntity()) {
            return null;
         }

         if (var5 == null) {
            var5 = ((BlockContainer)Block.c[var6]).getBlockEntity();
            this.a(var1, var2, var3, var5);
         }

         var5 = this.o.get(var4);
      }

      if (var5 != null && var5.isRemoving()) {
         this.o.remove(var4);
         return null;
      } else {
         return var5;
      }
   }

   public void a(String var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (this.mc.w.particleCount == 0) {
         for (int var8 = 0; var8 < this.n.size(); var8++) {
            this.n.get(var8).a(var1, var2, var3, var4, var5, var6, var7);
         }
      }
   }

   public void k(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < 1000; var4++) {
         int var5 = var1 + this.q.nextInt(16) - this.q.nextInt(16);
         int var6 = var2 + this.q.nextInt(16) - this.q.nextInt(16);
         int var7 = var3 + this.q.nextInt(16) - this.q.nextInt(16);
         int var8;
         if ((var8 = this.a(var5, var6, var7)) > 0) {
            Block.c[var8].b(this, var5, var6, var7, this.I);
         }
      }
   }

   public String j() {
      return "" + this.G.size() + ", S: " + this.lightingToUpdate.size();
   }

   public final int getLightingQueue() {
      return this.lightingToUpdate.size();
   }

   public void k() {
      for (int var1 = 0; var1 < this.n.size(); var1++) {
         C_d var2 = this.n.get(var1);

         for (int var3 = 0; var3 < this.r.e.size(); var3++) {
            var2.b(this.r.e.get(var1));
         }
      }
   }

   protected void a(int var1) {
      this.B = var1;

      for (int var2 = 0; var2 < this.n.size(); var2++) {
         this.n.get(var2).h();
      }
   }

   public boolean l(int var1, int var2, int var3) {
      return var2 >= this.getHeightValue(var1, var3);
   }

   public void updateTileEntity(int var1, int var2, int var3, TileEntity var4) {
      for (int var5 = 0; var5 < this.n.size(); var5++) {
         this.n.get(var5).updateTileEntity(var1, var2, var3, var4);
      }
   }

   public void setEntityDead(Entity var1) {
      var1.k();
   }

   public void joinEntityInSurroundings(Entity var1) {
   }

   public void powerBlock(int var1, int var2, int var3, int var4, int var5) {
      int var6 = this.a(var1, var2, var3);
      if (var6 > 0) {
         Block.c[var6].powerBlock(this, var1, var2, var3, var4, var5);
      }
   }

   public void playNoteAt(int var1, int var2, int var3, int var4, int var5) {
      int var6 = this.a(var1, var2, var3);
      if (var6 > 0) {
         Block.c[var6].playBlock(this, var1, var2, var3, var4, var5);
      }
   }

   public void clearAllEntities() {
      for (int var1 = 0; var1 < this.unloadedEntityList.size(); var1++) {
         Entity var2 = this.unloadedEntityList.get(var1);
         this.chunkMap.removeEntity(var2);
      }

      for (int var3 = 0; var3 < this.unloadedEntityList.size(); var3++) {
         this.b(this.unloadedEntityList.get(var3));
      }

      for (int var4 = 0; var4 < this.loadedEntityList.size(); var4++) {
         Entity var5 = this.loadedEntityList.get(var4);
         if (!(var5 instanceof net.minecraft.client.g.C_d)) {
            this.chunkMap.removeEntity(var5);
            this.loadedEntityList.remove(var4--);
            this.b(var5);
         }
      }
   }

   public void updateEntityList() {
      this.loadedEntityList.removeAll(this.unloadedEntityList);

      for (int var1 = 0; var1 < this.unloadedEntityList.size(); var1++) {
         Entity var2 = this.unloadedEntityList.get(var1);
         this.chunkMap.removeEntity(var2);
      }

      for (int var3 = 0; var3 < this.unloadedEntityList.size(); var3++) {
         this.b(this.unloadedEntityList.get(var3));
      }

      this.unloadedEntityList.clear();

      for (int var4 = 0; var4 < this.loadedEntityList.size(); var4++) {
         Entity var5 = this.loadedEntityList.get(var4);
         if (var5.u) {
            this.chunkMap.removeEntity(var5);
            this.loadedEntityList.remove(var4--);
            this.b(var5);
         }
      }
   }

   public void sendQuittingDisconnectingPacket() {
   }

   public ItemStack storeTEInStack(ItemStack var1, TileEntity var2) {
      NBTTagCompound var3 = new NBTTagCompound();
      var2.b(var3);
      var1.setTagInfo("BlockEntityTag", var3);
      return var1;
   }

   static {
      for (int var0 = 0; var0 <= 15; var0++) {
         float var1 = 1.0F - (float)var0 / 15.0F;
         F[var0] = (1.0F - var1) / (var1 * 3.0F + 1.0F) * 0.95F + 0.05F;
      }

      N = 0;
   }

   // ---- Beta/ReIndev-style facade: readable aliases over the obfuscated API
   // ---- so ported code compiles as-is (class recompiled from decompiled src).
   public int getBlockId(int x, int y, int z) {
      return this.a(x, y, z);
   }

   public boolean setBlock(int x, int y, int z, int id) {
      return this.a(x, y, z, id);
   }

   public boolean setBlockWithNotify(int x, int y, int z, int id) {
      return this.b(x, y, z, id);
   }

   public int getBlockMetadata(int x, int y, int z) {
      return this.e(x, y, z);
   }

   // setBlockMetadata(x,y,z,meta) already exists natively in this jar.

   public TileEntity getBlockTileEntity(int x, int y, int z) {
      return this.j(x, y, z);
   }

   public void setBlockTileEntity(int x, int y, int z, TileEntity te) {
      this.a(x, y, z, te);
   }

   public void removeBlockTileEntity(int x, int y, int z) {
      this.i(x, y, z);
   }
}
