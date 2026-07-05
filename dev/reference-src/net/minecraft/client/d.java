package net.minecraft.client;

import com.a.a.NBTTagCompound;
import java.awt.Canvas;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.swing.JOptionPane;
import net.minecraft.a.a.LevelOptions;
import net.minecraft.a.a.b.C_aa;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_t;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.c.C_f;
import net.minecraft.client.b.C_h;
import net.minecraft.client.c.C_ag;
import net.minecraft.client.c.C_ak;
import net.minecraft.client.c.C_aq;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.c.GuiAchievement;
import net.minecraft.client.c.GuiMainMenu;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.ScaledResolution;
import net.minecraft.client.f.C_d;
import net.minecraft.client.statistics.StatFileWriter;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;
import net.minecraft.game.level.block.container.BlockContainer;
import net.minecraft.network.NetClientHandler;
import net.minecraft.network.WorldClient;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import util.MathHelper;

public final class d implements Runnable {
   private static d minecraft;
   public net.minecraft.client.dx.C_a a;
   public boolean E = false;
   public int b;
   public int c;
   public C_g G = new C_g(20.0F);
   public net.minecraft.a.a.World d;
   public net.minecraft.client.a.C_b e;
   public CharacterLoader characters;
   public net.minecraft.client.g.C_a f;
   public net.minecraft.a.c.C_e cameraMob;
   public C_d g;
   public C_l h = null;
   public String i;
   public Canvas j;
   public boolean k = true;
   public volatile boolean l = false;
   public RenderEngine m;
   public FontRenderer n;
   public GuiScreen o = null;
   public C_a p = new C_a(this);
   public net.minecraft.client.a.C_e q = new net.minecraft.client.a.C_e(this);
   private C_j H;
   private int I = 0;
   private int J = 0;
   private int K;
   private int L;
   public String r = null;
   public int s = 0;
   public GuiAchievement guiAchievement = new GuiAchievement(this);
   public net.minecraft.client.c.C_l t;
   public boolean u = false;
   public net.minecraft.a.d.C_c v;
   public GameSettings w;
   public net.minecraft.client.e.C_c x;
   public C_m y;
   public File z;
   private String N;
   private int port;
   private C_f O;
   private net.minecraft.client.a.c.C_d P;
   volatile boolean A;
   public String B;
   public boolean C;
   private int Q;
   public boolean D;
   private static File minecraftDir;
   public LevelIO levelIo;
   public net.minecraft.client.a.c.C_l texturePackList;
   public LevelOptions worldOptions = new LevelOptions();
   private float soundFade = 1.0F;
   private int joinPlayerCounter;
   public String lastChatMessage = null;
   public StatFileWriter statFileWriter;

   public d(Canvas var1, MinecraftApplet var2, int var3, int var4, boolean var5) {
      new C_h(0.0F);
      this.v = null;
      this.x = new net.minecraft.client.e.C_c();
      this.N = null;
      this.O = new C_f();
      this.P = new net.minecraft.client.a.c.C_d();
      this.A = false;
      this.B = "";
      this.C = false;
      this.Q = 0;
      this.D = false;
      this.K = var3;
      this.L = var4;
      this.E = var5;
      new C_n(this, "Timer hack thread");
      this.j = var1;
      this.b = var3;
      this.c = var4;
      this.E = var5;
      this.levelIo = new LevelIO(this, this.p);
      minecraft = this;
   }

   public final void a(String var1, int var2) {
      this.N = var1;
      this.port = var2;
   }

   public final void a(GuiScreen var1) {
      if (!(this.o instanceof net.minecraft.client.c.C_c)) {
         if (this.o != null) {
            this.o.a();
         }

         this.statFileWriter.syncStats();
         if (var1 == null && this.d == null) {
            var1 = new GuiMainMenu();
         } else if (var1 == null && this.f.W <= 0) {
            var1 = new net.minecraft.client.c.C_d();
         }

         this.o = (GuiScreen)var1;
         if (var1 != null) {
            this.e();
            ScaledResolution var2;
            int var3 = (var2 = new ScaledResolution(this.w, this.b, this.c)).a();
            int var4 = var2.b();
            ((GuiScreen)var1).a(this, var3, var4);
            this.u = false;
         } else {
            this.b();
         }
      }
   }

   public final void a() {
      this.levelIo = new LevelIO(this, null);

      try {
         if (this.d != null) {
            this.d.active = true;
         }

         this.saveLevel();
         this.saveCharacter();
         this.characters.saveCharacter(this.w.character, this.characters.currentCharacter);
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      try {
         if (this.H != null) {
            this.H.a();
         }
      } catch (Exception var7) {
      }

      try {
         this.x.b();
         Mouse.destroy();
         Keyboard.destroy();
      } finally {
         Display.destroy();
         System.exit(0);
      }
   }

   @Override
   public final void run() {
      this.A = true;

      try {
         if (this.E) {
            Display.setFullscreen(true);
            this.b = Display.getDisplayMode().getWidth();
            this.c = Display.getDisplayMode().getHeight();
         } else if (this.j != null) {
            Display.setParent(this.j);
         } else {
            Display.setDisplayMode(new DisplayMode(this.b, this.c));
         }

         Display.setTitle("Minecraft Indev+");
         Display.setResizable(true);

         try {
            PixelFormat var1 = new PixelFormat();
            var1 = var1.withDepthBits(24);
            Display.create(var1);
            System.out.println("LWJGL version: " + Sys.getVersion());
            System.out.println("GL RENDERER: " + GL11.glGetString(7937));
            System.out.println("GL VENDOR: " + GL11.glGetString(7936));
            System.out.println("GL VERSION: " + GL11.glGetString(7938));
            ContextCapabilities var2 = GLContext.getCapabilities();
            System.out.println("OpenGL 3.0: " + var2.OpenGL30);
            System.out.println("OpenGL 3.1: " + var2.OpenGL31);
            System.out.println("OpenGL 3.2: " + var2.OpenGL32);
            System.out.println("ARB_compatibility: " + var2.GL_ARB_compatibility);
            if (var2.OpenGL32) {
               IntBuffer var3 = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
               GL11.glGetInteger(37158, var3);
               int var4 = var3.get(0);
               System.out.println("PROFILE MASK: " + Integer.toBinaryString(var4));
               System.out.println("CORE PROFILE: " + ((var4 & 1) != 0));
               System.out.println("COMPATIBILITY PROFILE: " + ((var4 & 2) != 0));
            }

            System.out.println("Indev+");
            System.out.println("");
         } catch (LWJGLException var19) {
            var19.printStackTrace();

            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var18) {
            }

            Display.create();
         }

         Keyboard.create();
         Mouse.create();
         this.y = new C_m();

         try {
            Controllers.create();
         } catch (Exception var17) {
            var17.printStackTrace();
         }

         GL11.glEnable(3553);
         GL11.glShadeModel(7425);
         GL11.glClearDepth(1.0);
         GL11.glEnable(2929);
         GL11.glDepthFunc(515);
         GL11.glEnable(3008);
         GL11.glAlphaFunc(516, 0.1F);
         GL11.glCullFace(1029);
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         GL11.glMatrixMode(5888);
         this.z = getMinecraftDir();
         this.w = new GameSettings(this, this.z);
         this.texturePackList = new net.minecraft.client.a.c.C_l(this, this.z);
         this.m = new RenderEngine(this.texturePackList);
         this.n = new FontRenderer(this.w, "/default.png", this.m);
         net.minecraft.client.a.a.C_i.a.itemRenderer = new net.minecraft.client.a.C_g(this);
         this.statFileWriter = new StatFileWriter(this.characters, this.z, this.h);
         this.statFileWriter.syncStats();
         this.drawSplash();
         this.x.a(this.w);
         this.m.a(this.P);
         this.m.a(this.O);
         this.m.a(new net.minecraft.client.a.c.C_a());
         this.m.a(new net.minecraft.client.a.c.C_e());
         this.m.a(new net.minecraft.client.a.c.C_h());
         this.m.a(new net.minecraft.client.a.c.C_c(0));
         this.m.a(new net.minecraft.client.a.c.C_c(1));
         this.m.a(new net.minecraft.client.a.c.C_c(2));
         this.m.a(new net.minecraft.client.a.c.C_c(4));

         for (int var26 = 0; var26 < 16; var26++) {
            this.m.a(new net.minecraft.client.a.c.C_m(528 + var26));
         }

         this.m.a(new net.minecraft.client.a.c.C_n(this, 288));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 320));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 352));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 384));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 548));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 552));
         this.m.a(new net.minecraft.client.a.c.C_g(this, 557, -1));
         this.m.a(new net.minecraft.client.a.c.C_g(this, 583, 0));
         this.m.a(new net.minecraft.client.a.c.C_g(this, 590, 2));
         this.m.a(new net.minecraft.client.a.c.C_g(this, 713, 4));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 681));
         this.m.a(new net.minecraft.client.a.c.C_n(this, 685));
         this.characters = new CharacterLoader(this, this.w.character);
         this.e = new net.minecraft.client.a.C_b(this, this.m);
         GL11.glViewport(0, 0, this.b, this.c);
         this.g = new C_d(this.d, this.m);

         try {
            this.H = new C_j(this.z, this);
            this.H.start();
         } catch (Exception var16) {
         }

         this.t = new net.minecraft.client.c.C_l(this);
         this.statFileWriter.writeStat(StatList.startGameStat, 1);
         net.minecraft.a.b.a.C_f.addUnlockedRecipes();
         if (this.N != null) {
            this.a(new C_ak(this, this.N, this.port));
         } else if (this.d == null) {
            this.a(new GuiMainMenu());
         }

         if (this.w.h) {
            Display.setVSyncEnabled(true);
         }
      } catch (Exception var24) {
         var24.printStackTrace();
         JOptionPane.showMessageDialog((Component)null, var24.toString(), "Failed to start Minecraft", 0);
         return;
      }

      long var27 = System.currentTimeMillis();
      int var28 = 0;

      try {
         while (this.A) {
            if (this.d != null) {
               this.d.d();
            }

            if (this.j == null && Display.isCloseRequested()) {
               this.A = false;
            }

            try {
               if (this.l && this.d != null) {
                  float var29 = this.G.c;
                  this.G.a();
                  this.G.c = var29;
               } else {
                  this.G.a();
               }

               for (int var30 = 0; var30 < this.G.b; var30++) {
                  this.I++;
                  this.f();
               }

               this.x.a(this.f, this.G.c);
               GL11.glEnable(3553);
               if (!Keyboard.isKeyDown(65)) {
                  Display.update();
               }

               if (this.a != null) {
                  this.a.a(this.G.c);
               }

               this.q.a(this.G.c);
               if (!Display.isActive()) {
                  if (this.E) {
                     this.d();
                  }

                  Thread.sleep(10L);
               }

               this.guiAchievement.updateAchievementWindow();
               Thread.yield();
               if (Keyboard.isKeyDown(65)) {
                  Display.update();
               }

               int var5;
               int var31;
               if (this.j != null) {
                  var31 = this.j.getWidth();
                  var5 = this.j.getHeight();
               } else {
                  var31 = Display.getWidth();
                  var5 = Display.getHeight();
               }

               if (!this.E && (var31 != this.b || var5 != this.c)) {
                  this.b = Math.max(var31, 1);
                  this.c = Math.max(var5, 1);
                  this.a(this.b, this.c);
               }

               var28++;
               this.l = this.o != null && this.o.c() && !this.isMultiplayerWorld();
            } catch (Exception var20) {
               this.a(new C_aq(var20));
               var20.printStackTrace();
               return;
            }

            while (System.currentTimeMillis() >= var27 + 1000L) {
               this.B = var28 + " fps" + (this.w.h ? " (vsync)" : "") + ", " + net.minecraft.client.a.C_h.a + " chunk updates";
               net.minecraft.client.a.C_h.a = 0;
               var27 += 1000L;
               var28 = 0;
            }
         }
      } catch (C_p var21) {
      } catch (Throwable var22) {
         var22.printStackTrace();
      } finally {
         this.a();
      }
   }

   private void drawSplash() throws LWJGLException {
      ScaledResolution var1 = new ScaledResolution(this.w, this.b, this.c);
      GL11.glClear(16640);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0, (double)var1.a(), (double)var1.b(), 0.0, 1000.0, 3000.0);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
      GL11.glViewport(0, 0, this.b, this.c);
      GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      net.minecraft.client.a.C_d var2 = net.minecraft.client.a.C_d.a;
      GL11.glDisable(2896);
      GL11.glEnable(3553);
      GL11.glDisable(2912);
      GL11.glBindTexture(3553, this.m.a("/title/splash.png"));
      var2.b();
      var2.b(16777215);
      var2.a(0.0F, (float)this.c, 0.0F, 0.0F, 0.0F);
      var2.a((float)this.b, (float)this.c, 0.0F, 0.0F, 0.0F);
      var2.a((float)this.b, 0.0F, 0.0F, 0.0F, 0.0F);
      var2.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      var2.a();
      short var3 = 256;
      short var4 = 256;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var2.b(16777215);
      this.drawImageRect((var1.a() - var3) / 2, (var1.b() - var4) / 2, 0, 0, var3, var4);
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      GL11.glEnable(3008);
      GL11.glAlphaFunc(516, 0.1F);
      Display.swapBuffers();
   }

   public void drawImageRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      net.minecraft.client.a.C_d var9 = net.minecraft.client.a.C_d.a;
      var9.b();
      var9.a((float)(var1 + 0), (float)(var2 + var6), 0.0F, (float)(var3 + 0) * var7, (float)(var4 + var6) * var8);
      var9.a((float)(var1 + var5), (float)(var2 + var6), 0.0F, (float)(var3 + var5) * var7, (float)(var4 + var6) * var8);
      var9.a((float)(var1 + var5), (float)(var2 + 0), 0.0F, (float)(var3 + var5) * var7, (float)(var4 + 0) * var8);
      var9.a((float)(var1 + 0), (float)(var2 + 0), 0.0F, (float)(var3 + 0) * var7, (float)(var4 + 0) * var8);
      var9.a();
   }

   public static File getMinecraftDir() {
      if (minecraftDir == null) {
         String var0 = "minecraft";
         String var1 = System.getProperty("user.home", ".");
         switch (getOS()) {
            case a:
            case b:
               minecraftDir = new File(var1, '.' + var0 + '/');
               break;
            case c:
               String var2;
               if ((var2 = System.getenv("APPDATA")) != null) {
                  minecraftDir = new File(var2, "." + var0 + '/');
               } else {
                  minecraftDir = new File(var1, '.' + var0 + '/');
               }
               break;
            case d:
               minecraftDir = new File(var1, "Library/Application Support/" + var0);
               break;
            default:
               minecraftDir = new File(var1, var0 + '/');
         }

         if (!minecraftDir.exists() && !minecraftDir.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + minecraftDir);
         }
      }

      return minecraftDir;
   }

   public static C_e getOS() {
      String var0 = System.getProperty("os.name").toLowerCase();
      if (var0.contains("win")) {
         return C_e.c;
      } else if (var0.contains("mac")) {
         return C_e.d;
      } else if (var0.contains("solaris")) {
         return C_e.b;
      } else if (var0.contains("sunos")) {
         return C_e.b;
      } else if (var0.contains("linux")) {
         return C_e.a;
      } else {
         return var0.contains("unix") ? C_e.a : C_e.e;
      }
   }

   public final void b() {
      if (Display.isActive() && !this.C) {
         this.C = true;
         this.y.a();
         this.a((GuiScreen)null);
         this.Q = this.I + 10000;
      }
   }

   public final String getTileEntityList() {
      return "L: " + this.d.d((int)this.f.h, (int)this.f.i, (int)this.f.j);
   }

   private void e() {
      if (this.C) {
         if (this.f != null) {
            this.f.a.b();
         }

         this.C = false;
         this.y.resetMouseCursor();
      }
   }

   public final void c() {
      if (this.o == null) {
         this.a(new net.minecraft.client.c.C_b());
      }
   }

   private void a(int var1) {
      if (var1 != 0 || this.J <= 0) {
         if (var1 == 0) {
            this.f.swingItem();
         }

         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         if (this.v != null) {
            var2 = this.v.b;
            var3 = this.v.c;
            var4 = this.v.d;
            var5 = this.v.e;
         }

         int var6 = this.d.a(var2, var3, var4);
         if (var1 == 1) {
            if (this.f.isSneaking == 0 && Block.c[var6] != null) {
               if (this.d.multiplayerWorld && this.v != null) {
                  if (this.a.sendPlaceBlock(this.f, this.d, this.f.b.d(), var2, var3, var4, this.v.e)
                     && this.v.a == 0
                     && (var6 = this.d.a(var2, var3, var4)) > 0) {
                     this.f.swingItem();
                     return;
                  }
               } else if (Block.c[var6].a(this.d, var2, var3, var4, this.f) && this.v.a == 0 && (var6 = this.d.a(var2, var3, var4)) > 0) {
                  this.f.swingItem();
                  return;
               }
            }

            if (this.f.b.d() == null && this.f.b.charmSlot[0] != null && this.f.b.charmSlot[0].c == Item.ring.ap && this.f.gamemode != 2) {
               this.d.a(this.f, "random.bow", 0.5F, 0.4F / (this.d.q.nextFloat() * 0.4F + 0.8F));
               this.f.swingItem();
               if (!this.d.multiplayerWorld) {
                  this.d.spawnEntityInWorld(new net.minecraft.a.c.d.C_d(this.d, this.f));
               } else {
                  this.a.useSpecial(this.f, this.d, this.f.b.charmSlot[0]);
               }

               this.f.addStat(StatList.objectUseStats[this.f.b.charmSlot[0].c], 1);
               if (this.f.gamemode == 0) {
                  this.f.b.charmSlot[0].damageItem2(1, this.d);
               }
            }

            ItemStack var7 = this.f.b.d();
            if (var7 != null && (var6 == 0 || var6 > 0 && var6 != Block.doorOak.at)) {
               var3 = var7.a;
               if (this.a.sendUseItem(this.f, this.d, var7) || var7 != null && var7.a != var3) {
                  this.q.a.d();
                  if (var7.a <= 0) {
                     this.f.b.a[this.f.b.c] = null;
                  }
               }
            }

            if (this.v != null && this.v.a == 1) {
               this.a.interactWithEntity(this.f, this.v.g);
            }
         }

         if (this.v == null) {
            if (var1 == 0 && !(this.a instanceof net.minecraft.client.dx.C_c)) {
               this.J = 10;
            }
         } else if (this.v.a == 1) {
            if (var1 == 0 && !this.f.isBlocking()) {
               net.minecraft.a.c.e.C_b var18 = this.f.b;
               ItemStack var17;
               int var19 = (var17 = this.f.b.a(var18.c)) != null ? Item.b[var17.c].a() : 1;
               if (var19 > 0) {
                  if (var18.a[var18.c] != null && var18.a[var18.c].a() instanceof C_t) {
                     this.a.attackEntity(this.f, this.v.g, 0.8F);
                  } else if (var18.a[var18.c] != null && var18.a[var18.c].a() instanceof C_bm) {
                     this.a.attackEntity(this.f, this.v.g, 0.0F);
                  } else if (var18.a[var18.c] == null && var18.charmSlot[0] != null && var18.charmSlot[0].a() == Item.gloves) {
                     this.a.attackEntityUnarmed(this.f, this.v.g, 0.4F);
                  } else {
                     this.a.attackEntity(this.f, this.v.g, 0.4F);
                  }

                  this.f.addStat(StatList.damageDealtStat, var19);
               }

               return;
            }
         } else if (this.v.a == 0) {
            Block var8 = Block.c[this.d.a(var2, var3, var4)];
            if (var1 != 0) {
               ItemStack var16 = this.f.b.d();
               var2 = this.v.b;
               var3 = this.v.c;
               var4 = this.v.d;
               var5 = this.v.e;
               boolean var9 = this.a.sendPlaceBlock(this.f, this.d, var16, var2, var3, var4, var5);
               if (var16 == null) {
                  return;
               }

               var6 = var16.a;
               if (var9) {
                  this.f.swingItem();
               }

               if (var16.a == 0) {
                  this.f.b.a[this.f.b.c] = null;
                  return;
               }

               if (var16.a != var6) {
                  this.q.a.d();
               }
            } else if (var8 != Block.o && this.a instanceof net.minecraft.client.dx.C_b
               || this.a instanceof net.minecraft.client.dx.C_c
               || this.a instanceof net.minecraft.client.dx.C_d) {
               if (!this.d.containsFire(var2, var3, var4, this.v.e)) {
                  this.a.clickBlock(var2, var3, var4, this.v.e);
               }

               return;
            }
         }
      }
   }

   public final void d() {
      try {
         this.E = !this.E;
         System.out.println("Toggle fullscreen!");
         if (this.E) {
            Display.setDisplayMode(Display.getDesktopDisplayMode());
            this.b = Display.getDisplayMode().getWidth();
            this.c = Display.getDisplayMode().getHeight();
         } else {
            if (this.j != null) {
               this.b = this.j.getWidth();
               this.c = this.j.getHeight();
            } else {
               this.b = this.K;
               this.c = this.L;
            }

            Display.setDisplayMode(new DisplayMode(this.K, this.L));
         }

         this.e();
         Display.setFullscreen(this.E);
         Display.update();
         Thread.sleep(1000L);
         if (this.E) {
            this.b();
         }

         if (this.o != null) {
            this.e();
            this.a(this.b, this.c);
         }

         System.out.println("Size: " + this.b + ", " + this.c);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   private void a(int var1, int var2) {
      this.b = var1;
      this.c = var2;
      if (this.o != null) {
         ScaledResolution var3;
         var2 = (var3 = new ScaledResolution(this.w, var1, var2)).a();
         var1 = var3.b();
         this.o.a(this, var2, var1);
      }
   }

   private void f() {
      if (this.x != null && this.d != null && this.x.f) {
         byte var1 = 0;
         if (this.d.gamemode == 1) {
            var1 = 4;
         } else if (this.d.isNight) {
            var1 = 10;
         }

         this.x.playRandomMusicIfReady(var1);
         this.x.a.setVolume("BgMusic", this.w.musicVol * this.w.masterVol);
         this.x.a.setVolume("streaming", this.w.streamingVol * this.w.masterVol);
         float var2 = 12.0F;
         net.minecraft.client.g.C_a var3 = this.f;
         int var4 = this.d.countBlocks(var3.r.b(var2 + 2.0F, var2 + 2.0F, var2 + 2.0F), Block.p.at);
         var4 += this.d.countBlocks(var3.r.b(var2 + 2.0F, var2 + 2.0F, var2 + 2.0F), Block.q.at);
         double var5 = (double)MathHelper.a((double)var3.h);
         double var7 = (double)MathHelper.a((double)var3.i);
         double var9 = (double)MathHelper.a((double)var3.j);
         if (var4 >= 500 && !var3.isInWater() && !this.l && this.d.l((int)var5, (int)var7, (int)var9)) {
            this.x.playAmbience("loops.ocean");
            this.soundFade += 0.01F;
            if (this.soundFade > 0.2F) {
               this.soundFade = 0.2F;
            }
         } else {
            this.soundFade -= 0.01F;
            if (this.soundFade < 0.0F) {
               this.soundFade = 0.0F;
               this.x.a.stop("ambienceTrack");
            }
         }

         this.x.a.setVolume("ambienceTrack", this.soundFade * this.w.ambienceVol * this.w.masterVol);
      }

      if (!this.l && this.d != null) {
         this.a.c();
         this.t.tick();
      }

      for (int var11 = 0; var11 < this.t.b.size(); var11++) {
         this.t.b.get(var11).time++;
      }

      GL11.glBindTexture(3553, this.m.a("/terrain.png"));
      if (!this.l) {
         this.m.a();
      }

      if (this.o == null && this.f != null && this.f.W <= 0) {
         this.a((GuiScreen)null);
      }

      if (this.cameraMob == null || this.cameraMob.u || this.cameraMob.W <= 0) {
         this.cameraMob = this.f;
         if (this.f != null) {
            this.f.resetPlayerKeyState();
         }
      }

      if (this.o == null || this.o.f) {
         label763:
         while (true) {
            label570:
            while (!Mouse.next()) {
               if (this.J > 0) {
                  this.J--;
               }

               while (Keyboard.next()) {
                  net.minecraft.client.g.C_a var25 = this.f;
                  int var28 = Keyboard.getEventKey();
                  boolean var17 = Keyboard.getEventKeyState();
                  if ((this.o == null || this.o.f) && !this.f.isSitting && !this.f.isLaying && this.cameraMob == this.f) {
                     var25.a.a(var28, var17);
                  }

                  if (Keyboard.getEventKeyState()) {
                     if (Keyboard.getEventKey() == this.w.keyBindFullScr.b) {
                        this.d();
                        continue label570;
                     }

                     if (Keyboard.getEventKey() == this.w.keyBindScreenshot.b) {
                        this.t.addChatMessage(ScreenShotHelper.attemptScreenCapture(this.z, this.b, this.c));
                        continue label570;
                     }

                     if (this.o != null) {
                        this.o.g();
                     } else {
                        if (Keyboard.getEventKey() == this.w.keyBindPause.b) {
                           this.c();
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindIso.b) {
                           this.q.b();
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindHUD.b) {
                           this.w.showHUD = !this.w.showHUD;
                        }

                        if (Keyboard.getEventKey() == this.w.y.b && (this.d.multiplayerWorld || this.f.cheats)) {
                           this.a(new C_ag());
                        }

                        if (Keyboard.getEventKey() == this.w.m.b) {
                           this.f.addStat(StatList.jumpStat, 1);
                        }

                        if (this.a instanceof net.minecraft.client.dx.C_c) {
                           if (Keyboard.getEventKey() == this.w.r.b && !this.f.isSitting && !this.f.isLaying) {
                              this.f.j();
                           }

                           if (Keyboard.getEventKey() == this.w.q.b) {
                              this.d.a((int)this.f.h, (int)this.f.i, (int)this.f.j, this.f.n);
                              this.f.j();
                           }
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindThirdPerson.b) {
                           this.w.thirdPersonView = (this.w.thirdPersonView + 1) % 3;
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindDebug.b) {
                           this.w.d = !this.w.d;
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindCrawl.b) {
                           this.f.setSneakState(this.f.isSneaking == 2 ? 0 : 2);
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindSneak.b) {
                           this.f.toggleSneak(this.f.isSneaking == 1 ? 0 : 1);
                        }

                        if (Keyboard.getEventKey() == this.w.n.b) {
                           this.a(this.a.displayInventory());
                        }

                        if (Keyboard.getEventKey() == this.w.keyBindFlight.b
                           && (this.a instanceof net.minecraft.client.dx.C_c || this.a instanceof net.minecraft.client.dx.C_d && this.a.b)) {
                           this.f.isFlying = !this.f.isFlying;
                        }

                        if (Keyboard.getEventKey() == this.w.o.b && this.f.gamemode != 2) {
                           if (this.f.b.a[this.f.b.c] != null) {
                              this.f.swingItem();
                           }

                           this.f.dropCurrentItem();
                        }
                     }

                     int var12 = 0;

                     while (true) {
                        if (var12 >= 9) {
                           continue label570;
                        }

                        if (Keyboard.getEventKey() == var12 + 2) {
                           this.f.b.c = var12;
                           if (this.f.b.a[this.f.b.c] != null) {
                              this.f.b.a[this.f.b.c].textTime = 30;
                           }
                        }

                        var12++;
                     }
                  }
               }

               if (this.o == null) {
                  if (Mouse.isButtonDown(0) && (float)(this.I - this.Q) >= this.G.a / 4.0F && this.C) {
                     this.a(0);
                     this.Q = this.I;
                  }

                  if (Mouse.isButtonDown(1) && (float)(this.I - this.Q) >= this.G.a / 4.0F && this.C) {
                     this.a(1);
                     this.Q = this.I;
                  }
               }

               boolean var18 = this.o == null && Mouse.isButtonDown(0) && this.C;
               if (this.f.gamemode != 2 && this.J <= 0) {
                  if (var18 && this.v != null && this.v.a == 0) {
                     int var15 = this.v.b;
                     int var26 = this.v.c;
                     int var29 = this.v.d;
                     this.a.a(var15, var26, var29, this.v.e);
                     if (this.w.particleCount <= 1) {
                        this.g.a(var15, var26, var29, this.v.e);
                     }
                  } else {
                     this.a.a();
                  }
               }
               break label763;
            }

            int var14;
            if ((var14 = Mouse.getEventDWheel()) != 0) {
               net.minecraft.a.c.e.C_b var19 = this.f.b;
               if (this.w.scrollInvert) {
                  var14 *= -1;
               }

               if (var14 > 0) {
                  var14 = 1;
               }

               if (var14 < 0) {
                  var14 = -1;
               }

               var19.c -= var14;

               while (var19.c < 0) {
                  var19.c += 9;
               }

               while (var19.c >= 9) {
                  var19.c -= 9;
               }

               if (this.f.b.a[this.f.b.c] != null) {
                  this.f.b.a[this.f.b.c].textTime = 30;
               }
            }

            if (this.o == null && this.f.gamemode != 2) {
               if (!this.C && Mouse.getEventButtonState()) {
                  this.b();
               } else if (this.f.isUsingItem()) {
                  if (Mouse.getEventButton() == 1 && !Mouse.getEventButtonState()) {
                     this.a.onStoppedUsingItem(this.f);
                  }
               } else {
                  if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                     this.a(0);
                     this.Q = this.I;
                  }

                  if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                     this.a(1);
                     this.Q = this.I;
                  }

                  if (Mouse.getEventButton() == 2 && Mouse.getEventButtonState() && this.v != null) {
                     if (this.v.a == 0) {
                        int var16 = this.d.a(this.v.b, this.v.c, this.v.d);
                        int var21 = 0;
                        Block var27 = Block.c[var16];
                        boolean var30 = this.a instanceof net.minecraft.client.dx.C_c;
                        net.minecraft.a.a.b.a.TileEntity var6 = null;
                        if (var30 && Keyboard.isKeyDown(29) && var27 instanceof BlockContainer) {
                           var6 = this.d.j(this.v.b, this.v.c, this.v.d);
                        }

                        if (var16 == Block.Y.at) {
                           var16 = Block.Z.at;
                        }

                        if (var16 == Block.stairUpsideDown.at) {
                           var16 = Block.Z.at;
                        }

                        if (var16 == Block.stairDoubleWood.at) {
                           var16 = Block.stairSingleWood.at;
                        }

                        if (var16 == Block.stairUpsideDownWood.at) {
                           var16 = Block.stairSingleWood.at;
                        }

                        if (var16 == Block.reeds.at) {
                           var16 = Item.reed.ap;
                        }

                        if (var16 == Block.doorOak.at) {
                           var16 = Item.doorOak.ap;
                        }

                        if (var16 == Block.doorPalm.at) {
                           var16 = Item.doorPalm.ap;
                        }

                        if (var16 == Block.doorSpruce.at) {
                           var16 = Item.doorSpruce.ap;
                        }

                        if (var16 == Block.doorBirch.at) {
                           var16 = Item.doorBirch.ap;
                        }

                        if (var16 == Block.doorSteel.at) {
                           var16 = Item.doorSteel.ap;
                        }

                        if (var16 == Block.flowerPot.at) {
                           var16 = Item.flowerPot.ap;
                        }

                        if (var16 == Block.bed.at) {
                           var16 = Item.bed.ap;
                        }

                        if (var16 == Block.cake.at) {
                           var16 = Item.cake.ap;
                        }

                        if (var16 == Block.signStanding.at || var16 == Block.signWall.at || var16 == Block.signHanging.at) {
                           var16 = Item.sign.ap;
                        }

                        if (var16 == Block.signBirchStanding.at || var16 == Block.signBirchWall.at || var16 == Block.signBirchHanging.at) {
                           var16 = Item.signBirch.ap;
                        }

                        if (var16 == Block.signPalmStanding.at || var16 == Block.signPalmWall.at || var16 == Block.signPalmHanging.at) {
                           var16 = Item.signPalm.ap;
                        }

                        if (var16 == Block.signDarkStanding.at || var16 == Block.signDarkWall.at || var16 == Block.signDarkHanging.at) {
                           var16 = Item.signDark.ap;
                        }

                        if (var16 == Block.ao.at) {
                           var16 = Item.O.ap;
                        }

                        if (var16 == Block.melonStem.at) {
                           var16 = Item.seedsMelon.ap;
                        }

                        if (var16 == Block.pumpkinStem.at) {
                           var16 = Item.seedsPumpkin.ap;
                        }

                        if (var16 == Block.ar.at) {
                           var16 = Block.aq.at;
                        }

                        if (var16 == Block.generatorActive.at) {
                           var16 = Block.generator.at;
                        }

                        if (var16 == Block.pulleyExtension.at) {
                           var16 = Block.pulleyBase.at;
                        }

                        if (var16 == Block.pulleyBaseActive.at) {
                           var16 = Block.pulleyBase.at;
                        }

                        if (var16 == Block.pulleyStickyBaseActive.at) {
                           var16 = Block.pulleyStickyBase.at;
                        }

                        if (var16 == Block.adminiumLampLit.at) {
                           var16 = Block.adminiumLamp.at;
                        }

                        if (var27 instanceof C_aa) {
                           var21 = this.d.e(this.v.b, this.v.c, this.v.d) & 3;
                        } else if (var27.hasStates && this.d.e(this.v.b, this.v.c, this.v.d) <= var27.getMaxDamage()) {
                           var21 = this.d.e(this.v.b, this.v.c, this.v.d);
                        }

                        if (!var30 && (!(this.a instanceof net.minecraft.client.dx.C_d) || !this.a.b)) {
                           this.f.b.swapItemFromInventory(var16, var21, this);
                        } else {
                           this.f.b.swapItem(var16, var21, this, var6);
                        }
                     }

                     if (this.v.a == 1) {
                        if (this.v.g instanceof net.minecraft.a.c.C_e) {
                           byte var22 = 8;
                           if (this.v.g instanceof net.minecraft.a.c.b.C_c) {
                              var22 = 0;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_b) {
                              var22 = 1;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_e) {
                              var22 = 2;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_f) {
                              var22 = 3;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_f) {
                              var22 = 4;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_c) {
                              var22 = 5;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_b) {
                              var22 = 6;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_d) {
                              var22 = 7;
                           }

                           if (this.v.g instanceof EntitySteve) {
                              var22 = 9;
                           }

                           if (this.v.g instanceof EntityBlackSteve) {
                              var22 = 10;
                           }

                           if (this.v.g instanceof EntityBeastBoy) {
                              var22 = 11;
                           }

                           if (this.v.g instanceof EntityRana) {
                              var22 = 12;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_h) {
                              var22 = 13;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_k) {
                              var22 = 14;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_g) {
                              var22 = 15;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_m) {
                              var22 = 16;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_d) {
                              var22 = 17;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_i) {
                              var22 = 18;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_g) {
                              var22 = 19;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_j) {
                              var22 = 20;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_h) {
                              var22 = 21;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_k) {
                              var22 = 22;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.b.C_j) {
                              var22 = 23;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_l) {
                              var22 = 24;
                           }

                           if (this.v.g instanceof net.minecraft.a.c.a.C_i) {
                              var22 = 25;
                           }

                           if (!(this.a instanceof net.minecraft.client.dx.C_c) && (!(this.a instanceof net.minecraft.client.dx.C_d) || !this.a.b)) {
                              this.f.b.swapItemFromInventory(Item.spawnEgg.ap, var22, this);
                           } else {
                              this.f.b.swapItem(Item.spawnEgg.ap, var22, this, null);
                           }
                        }

                        if (this.v.g instanceof net.minecraft.a.c.C_a) {
                           if (!(this.a instanceof net.minecraft.client.dx.C_c) && (!(this.a instanceof net.minecraft.client.dx.C_d) || !this.a.b)) {
                              this.f.b.swapItemFromInventory(Item.ao.ap, 0, this);
                           } else {
                              this.f.b.swapItem(Item.ao.ap, 0, this, null);
                           }
                        }

                        if (this.v.g instanceof net.minecraft.a.c.c.C_e) {
                           if (!(this.a instanceof net.minecraft.client.dx.C_c) && (!(this.a instanceof net.minecraft.client.dx.C_d) || !this.a.b)) {
                              this.f.b.swapItemFromInventory(Item.itemFrame.ap, 0, this);
                           } else {
                              this.f.b.swapItem(Item.itemFrame.ap, 0, this, null);
                           }
                        }

                        if (this.v.g instanceof net.minecraft.a.c.c.C_g) {
                           int var23 = Item.minecart.ap;
                           switch (((net.minecraft.a.c.c.C_g)this.v.g).minecartType) {
                              case 1:
                                 var23 = Item.minecartChest.ap;
                                 break;
                              case 2:
                                 var23 = Item.minecartFurnace.ap;
                                 break;
                              case 3:
                                 var23 = Item.minecartExplosive.ap;
                           }

                           if (!(this.a instanceof net.minecraft.client.dx.C_c) && (!(this.a instanceof net.minecraft.client.dx.C_d) || !this.a.b)) {
                              this.f.b.swapItemFromInventory(var23, 0, this);
                           } else {
                              this.f.b.swapItem(var23, 0, this, null);
                           }
                        }
                     }
                  }
               }
            } else if (this.o != null) {
               this.o.f();
            } else if (this.f.gamemode == 2) {
               if (!this.C && Mouse.getEventButtonState()) {
                  this.b();
               } else {
                  if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.v != null && this.v.a == 1) {
                     net.minecraft.a.c.C_b var20 = this.v.g;
                     this.cameraMob = (net.minecraft.a.c.C_e)var20;
                  }

                  if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                     this.cameraMob = this.f;
                     this.f.resetPlayerKeyState();
                  }
               }
            }
         }
      }

      if (this.o != null) {
         this.Q = this.I + 10000;
      }

      if (this.o != null) {
         GuiScreen var13 = this.o;

         while (Mouse.next()) {
            var13.f();
         }

         while (Keyboard.next()) {
            var13.g();
         }

         if (this.o != null) {
            this.o.f_();
         }
      }

      if (this.d != null) {
         if (this.f != null) {
            this.joinPlayerCounter++;
            if (this.joinPlayerCounter == 30) {
               this.joinPlayerCounter = 0;
               this.d.joinEntityInSurroundings(this.f);
            }
         }

         this.d.E = this.f.difficulty;
         if (this.d.multiplayerWorld) {
            this.d.E = 3;
         }

         if (!this.l) {
            this.q.a();
            this.e.e();
            if (this.f != null && this.f.u) {
               this.f.ab++;
            }

            if (this.d.lightStrike > 0) {
               this.d.lightStrike--;
            }

            this.d.c();
            this.d.f();
            if (this.d != null) {
               this.d.k((int)this.f.h, (int)this.f.i, (int)this.f.j);
               this.g.a();
            }
         } else {
            this.q.playRandomAmbience();
         }
      }
   }

   public boolean isMultiplayerWorld() {
      return this.d != null && this.d.multiplayerWorld;
   }

   public final void generateLevel(LevelOptions var1, String var2) {
      this.a((GuiScreen)null);
      System.gc();
      String var3 = this.h != null ? this.h.b : "anonymous";
      var1.cheats = this.characters.currentCharacter.k("Cheats");
      net.minecraft.a.a.World var4 = var1.generate(this.p, var3);
      var4.f = var2;
      var4.fileName = var2 + ".mclevel";
      var4.parentName = var2;
      var4.gamemode = this.characters.currentCharacter.c("Gamemode");
      var4.cheats = this.characters.currentCharacter.k("Cheats");
      var4.hardcore = this.characters.currentCharacter.k("Hardcore");
      File var5 = new File(this.z, "saves/");

      for (File var6 = new File(var5, var2 + ".mclevel"); var6.exists(); var4.parentName = var2) {
         var2 = var2 + "-";
         var6 = new File(var5, var2 + ".mclevel");
         var4.f = var2;
         var4.fileName = var2 + ".mclevel";
      }

      this.setLevel(var4, var1.gamemode, var1.cheats);
   }

   public final void generateLevelSubtype(LevelOptions var1, String var2, String var3) {
      this.a((GuiScreen)null);
      System.gc();
      String var4 = this.h != null ? this.h.b : "anonymous";
      var1.cheats = this.characters.currentCharacter.k("Cheats");
      net.minecraft.a.a.World var5 = var1.generate(this.p, var4);
      var5.f = var2;
      var5.fileName = var2;
      var5.gamemode = this.characters.currentCharacter.c("Gamemode");
      var5.cheats = this.characters.currentCharacter.k("Cheats");
      var5.hardcore = this.characters.currentCharacter.k("Hardcore");
      var5.child = true;
      var5.parentName = var3;
      File var6 = new File(this.z, "saves/" + var3 + "/");
      File var7 = new File(var6, var2);
      if (var7.exists()) {
         this.loadLevel(var2, var3);
      } else {
         this.setLevel(var5, var1.gamemode, var1.cheats);
         this.saveLevel();
      }
   }

   public final void saveLevel() {
      if (!this.isMultiplayerWorld()) {
         if (this.d != null) {
            File var1 = new File(this.z, "saves/");
            if (this.d.child) {
               var1 = new File(this.z, "saves/" + this.d.parentName + "/");
            }

            var1.mkdirs();
            var1 = new File(var1, this.d.fileName);

            try {
               this.levelIo.a(this.d, new FileOutputStream(var1));
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      }
   }

   public final void saveCharacter() {
      if (!this.isMultiplayerWorld()) {
         if (this.f != null && !(this.f instanceof net.minecraft.client.g.C_d) && !(this.a instanceof net.minecraft.client.dx.C_d)) {
            try {
               NBTTagCompound var1 = new NBTTagCompound();
               this.f.c(var1);
               this.characters.currentCharacter = var1;
               this.characters.saveCharacter(this.w.character, var1);
            } catch (IOException var2) {
               var2.printStackTrace();
            }
         }
      }
   }

   public final void loadLevel(String var1) {
      try {
         File var2 = new File(this.z, "saves/" + var1);
         net.minecraft.a.a.World var3 = this.levelIo.a(new FileInputStream(var2));
         var3.fileName = var1;
         var3.active = false;
         if (var3.parentName.isEmpty()) {
            var3.parentName = var3.fileName.replace(".mclevel", "");
         }

         this.a(var3);
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   public final void loadLevel(String var1, String var2) {
      try {
         File var3 = new File(this.z, "saves/" + var2 + "/");
         File var4 = new File(var3, var1);
         if (!var3.exists() || !var4.exists()) {
            this.loadLevel(var2 + ".mclevel");
            return;
         }

         net.minecraft.a.a.World var5 = this.levelIo.a(new FileInputStream(var4));
         var5.fileName = var1;
         var5.active = false;
         if (var5.parentName.isEmpty()) {
            var5.parentName = var2;
         }

         this.a(var5);
      } catch (IOException var6) {
         var6.printStackTrace();
      }
   }

   public final void deleteLevel(String var1) {
      File var2 = new File(this.z, "saves/" + var1.replace(".mclevel", ""));
      if (var2.exists()) {
         for (File var6 : var2.listFiles()) {
            var6.delete();
         }

         var2.delete();
      }

      File var7 = new File(this.z, "saves/" + var1);
      var7.delete();
   }

   public final void a(net.minecraft.a.a.World var1) {
      this.setLevel(var1, 0, false);
   }

   public final void setLevel(net.minecraft.a.a.World var1, int var2, boolean var3) {
      this.saveLevel();
      this.saveCharacter();
      this.statFileWriter.syncStats();
      if (this.d != null) {
         this.d.k();
      }

      this.d = var1;
      this.x.a.stop("streaming");
      this.x.a.stop("ambience");
      if (var1 != null) {
         var1.a();
         this.f = (net.minecraft.client.g.C_a)var1.b(net.minecraft.client.g.C_a.class);
         this.cameraMob = this.f;
         var1.y = this.f;
         var1.mc = this;
         if (this.f == null) {
            if (!var1.multiplayerWorld) {
               this.f = new net.minecraft.client.g.C_a(this, var1, this.h);
            } else {
               this.f = (net.minecraft.client.g.C_d)this.a.createPlayer(var1);
            }

            this.f.gamemode = var2;
            this.f.cheats = var3;
            if (this.f.gamemode == 0) {
               this.f.isFlying = false;
            }

            this.f.j();
            if (var1 != null) {
               var1.y = this.f;
               var1.spawnEntityInWorld(this.f);
            }

            this.cameraMob = this.f;
         }

         this.f.gamemode = this.characters.currentCharacter.c("Gamemode");
         if (this.characters.currentCharacter != null) {
            if (this.f.cheats) {
               this.f.b(this.characters.currentCharacter);
            } else {
               this.f.readEntityWithoutInv(this.characters.currentCharacter);
            }
         }

         if (this.f != null) {
            this.f.a = new net.minecraft.client.g.C_c(this.w);
            if (!var1.multiplayerWorld) {
               this.a = net.minecraft.client.dx.C_a.get(this, this.f.gamemode);
            }

            this.a.a(var1);
            this.a.a(this.f);
         }

         if (this.e != null) {
            this.e.a(var1);
         }

         if (this.g != null) {
            this.g.a(var1);
         }

         this.O.d = 0;
         this.P.d = 0;
         int var4 = this.m.a("/water.png");
         if (var1.m == Block.p.at) {
            this.O.d = var4;
         } else {
            this.P.d = var4;
         }

         this.f.addStat(StatList.loadWorldStat, 1);
      }

      System.gc();
   }

   public void respawn() {
      if (this.isMultiplayerWorld()) {
         net.minecraft.a.a.World var10 = this.d;
         this.a((GuiScreen)null);
         int var11 = this.f.entityId;
         this.f = null;
         WorldClient var12 = (WorldClient)var10;
         this.a(var12);
         this.d.clearAllEntities();
         this.f.entityId = var11;
         if (this.o instanceof net.minecraft.client.c.C_d) {
            this.a((GuiScreen)null);
         }
      } else {
         boolean var1 = false;
         boolean var2 = false;
         String var3 = "Player";
         String var4 = "";
         net.minecraft.a.c.e.C_b var5 = null;
         net.minecraft.a.C_m var6 = null;
         int var7 = 2;
         int var8 = 0;
         int var9 = 0;
         if (this.f != null) {
            this.d.setEntityDead(this.f);
            var1 = this.f.cheats;
            var2 = this.f.keepInventory;
            var3 = this.f.name;
            var5 = this.f.b;
            var6 = this.f.inventoryChest;
            var7 = this.f.difficulty;
            var8 = this.f.P;
            var4 = this.f.skinId;
            if (this.f.isHardcoreEnabled) {
               this.f.gamemode = 2;
               this.d.gamemode = 2;
               this.d.hardcore = false;
            }

            var9 = this.f.gamemode;
         }

         this.f = (net.minecraft.client.g.C_a)this.a.createPlayer(this.d);
         this.f.cheats = var1;
         this.f.keepInventory = var2;
         this.f.name = var3;
         this.f.skinId = var4;
         this.f.difficulty = var7;
         this.f.P = var8;
         this.f.gamemode = var9;
         if (var5 != null && this.f.keepInventory) {
            this.f.b = var5;
         }

         if (var6 != null) {
            this.f.inventoryChest = var6;
         }

         this.f.j();
         this.f.a = new net.minecraft.client.g.C_c(this.w);
         this.a.a(this.f);
         this.d.y = this.f;
         this.d.spawnEntityInWorld(this.f);
         if (var9 == 2) {
            this.a = net.minecraft.client.dx.C_a.get(this, this.f.gamemode);
            this.a.a(this.d);
            this.a.a(this.f);
         }

         this.a((GuiScreen)null);
      }
   }

   public static d getMinecraft() {
      return minecraft;
   }

   public static void main(String[] var0) {
      String var1 = "Player" + System.currentTimeMillis() % 1000L;
      if (var0.length > 0) {
         var1 = var0[0];
      }

      String var2 = "-";
      if (var0.length > 1) {
         var2 = var0[1];
      }

      startMainThread(var1, var2);
   }

   public static void startMainThread(String var0, String var1) {
      minecraftDir = new File(".");
      boolean var2 = false;
      d var3 = new d(null, null, 854, 480, var2);
      Thread var4 = new Thread(var3, "Minecraft main thread");
      var4.setPriority(10);
      var3.k = false;
      var3.i = "www.minecraft.net";
      if (var0 != null && var1 != null) {
         var3.h = new C_l(var0, var1);
      } else {
         var3.h = new C_l("Player" + System.currentTimeMillis() % 1000L, "");
      }

      var4.start();
   }

   public NetClientHandler getSendQueue() {
      return this.f instanceof net.minecraft.client.g.C_d ? ((net.minecraft.client.g.C_d)this.f).sendQueue : null;
   }

   public net.minecraft.a.a.World updateBorderTexture(net.minecraft.a.a.World var1) {
      this.O.d = 0;
      this.P.d = 0;
      int var2 = this.m.a("/water.png");
      if (var1.m == Block.p.at) {
         this.O.d = var2;
      } else {
         this.P.d = var2;
      }

      return var1;
   }

   public static boolean isGuiEnabled() {
      return true;
   }

   static {
      if (System.getProperty("java.util.Arrays.useLegacyMergeSort") == null) {
         System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      }
   }
}
