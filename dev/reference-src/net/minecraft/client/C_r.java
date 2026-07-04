package net.minecraft.client;

import net.minecraft.client.a.C_d;
import net.minecraft.client.c.GuiButton;
import net.minecraft.client.c.GuiOptions;
import net.minecraft.client.c.GuiScreen;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_r extends GuiScreen {
   private float a = 0.0F;
   private String[] i = new String[]{
      "Pre-beta!",
      "As seen on TV!",
      "Awesome!",
      "100% pure!",
      "May contain nuts!",
      "Better than Prey!",
      "More polygons!",
      "Sexy!",
      "Limited edition!",
      "Flashing letters!",
      "Made by Notch!",
      "Coming soon!",
      "Best in class!",
      "When it's finished!",
      "Absolutely dragon free!",
      "Excitement!",
      "More than 5000 sold!",
      "One of a kind!",
      "700+ hits on YouTube!",
      "Indev!",
      "Spiders everywhere!",
      "Check it out!",
      "Holy cow, man!",
      "It's a game!",
      "Made in Sweden!",
      "Uses LWJGL!",
      "Reticulating splines!",
      "Minecraft!",
      "Yaaay!",
      "Alpha version!",
      "Singleplayer!",
      "Keyboard compatible!",
      "Undocumented!",
      "Ingots!",
      "Exploding creepers!",
      "That's not a moon!",
      "l33t!",
      "Create!",
      "Survive!",
      "Dungeon!",
      "Exclusive!",
      "The bee's knees!",
      "Down with O.P.P.!",
      "Closed source!",
      "Classy!",
      "Wow!",
      "Not on steam!",
      "9.95 euro!",
      "Half price!",
      "Oh man!",
      "Check it out!",
      "Awesome community!",
      "Pixels!",
      "Teetsuuuuoooo!",
      "Kaaneeeedaaaa!",
      "Now with difficulty!",
      "Enhanced!",
      "90% bug free!",
      "Pretty!",
      "12 herbs and spices!",
      "Fat free!",
      "Absolutely no memes!",
      "Free dental!",
      "Ask your doctor!",
      "Minors welcome!",
      "Cloud computing!",
      "Legal in Finland!",
      "Hard to label!",
      "Technically good!",
      "Bringing home the bacon!",
      "Indie!",
      "GOTY!",
      "Ceci n'est pas une title screen!",
      "Euclidian!",
      "Now in 3D!",
      "Inspirational!",
      "Herregud!",
      "Complex cellular automata!",
      "Yes, sir!",
      "Played by cowboys!",
      "OpenGL 1.1!",
      "Thousands of colors!",
      "Try it!",
      "Age of Wonders is better!",
      "Try the mushroom stew!",
      "Sensational!",
      "Hot tamale, hot hot tamale!",
      "Play him off, keyboard cat!",
      "Guaranteed!",
      "Macroscopic!",
      "Bring it on!",
      "Random splash!",
      "Call your mother!",
      "Monster infighting!",
      "Loved by millions!",
      "Ultimate edition!",
      "Freaky!",
      "You've got a brand new key!",
      "Water proof!",
      "Uninflammable!",
      "Whoa, dude!",
      "All inclusive!",
      "Tell your friends!",
      "NP is not in P!",
      "Notch <3 Ez!",
      "Music by C418!"
   };
   private String j = this.i[(int)(Math.random() * (double)this.i.length)];

   @Override
   public final void f_() {
      this.a += 0.01F;
   }

   @Override
   protected final void a(char var1, int var2) {
   }

   @Override
   public final void b() {
      this.e.clear();
      this.e.add(new GuiButton(1, this.c / 2 - 100, this.d / 4 + 48, "Generate new level..."));
      this.e.add(new GuiButton(2, this.c / 2 - 100, this.d / 4 + 72, "Load level.."));
      this.e.add(new GuiButton(3, this.c / 2 - 100, this.d / 4 + 96, "Play tutorial level"));
      this.e.add(new GuiButton(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Options..."));
      this.e.get(2).c = false;
      if (this.b.h == null) {
         this.e.get(1).c = false;
      }
   }

   @Override
   protected final void a(GuiButton var1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: Constructor net/minecraft/client/c/GuiOptions.<init>(Lnet/minecraft/client/c/GuiScreen;Lnet/minecraft/client/GameSettings;)V not found
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ExprUtil.getSyntheticParametersMask(ExprUtil.java:49)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:957)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.NewExprent.toJava(NewExprent.java:460)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:1018)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.appendParamList(InvocationExprent.java:1153)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.toJava(InvocationExprent.java:902)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.IfStatement.toJava(IfStatement.java:241)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield net/minecraft/client/c/GuiButton.b I
      // 04: ifne 1d
      // 07: aload 0
      // 08: getfield net/minecraft/client/C_r.b Lnet/minecraft/client/d;
      // 0b: new net/minecraft/client/c/GuiOptions
      // 0e: dup
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield net/minecraft/client/C_r.b Lnet/minecraft/client/d;
      // 14: getfield net/minecraft/client/d.w Lnet/minecraft/client/GameSettings;
      // 17: invokespecial net/minecraft/client/c/GuiOptions.<init> (Lnet/minecraft/client/c/GuiScreen;Lnet/minecraft/client/GameSettings;)V
      // 1a: invokevirtual net/minecraft/client/d.a (Lnet/minecraft/client/c/GuiScreen;)V
      // 1d: aload 1
      // 1e: getfield net/minecraft/client/c/GuiButton.b I
      // 21: bipush 1
      // 22: if_icmpne 34
      // 25: aload 0
      // 26: getfield net/minecraft/client/C_r.b Lnet/minecraft/client/d;
      // 29: new net/minecraft/client/c/C_n
      // 2c: dup
      // 2d: aload 0
      // 2e: invokespecial net/minecraft/client/c/C_n.<init> (Lnet/minecraft/client/c/GuiScreen;)V
      // 31: invokevirtual net/minecraft/client/d.a (Lnet/minecraft/client/c/GuiScreen;)V
      // 34: aload 0
      // 35: getfield net/minecraft/client/C_r.b Lnet/minecraft/client/d;
      // 38: getfield net/minecraft/client/d.h Lnet/minecraft/client/C_l;
      // 3b: ifnull 55
      // 3e: aload 1
      // 3f: getfield net/minecraft/client/c/GuiButton.b I
      // 42: bipush 2
      // 43: if_icmpne 55
      // 46: aload 0
      // 47: getfield net/minecraft/client/C_r.b Lnet/minecraft/client/d;
      // 4a: new net/minecraft/client/c/C_e
      // 4d: dup
      // 4e: aload 0
      // 4f: invokespecial net/minecraft/client/c/C_e.<init> (Lnet/minecraft/client/c/GuiScreen;)V
      // 52: invokevirtual net/minecraft/client/d.a (Lnet/minecraft/client/c/GuiScreen;)V
      // 55: return
   }

   @Override
   public final void a(int var1, int var2, float var3) {
      this.h();
      C_d var4 = C_d.a;
      GL11.glBindTexture(3553, this.b.m.a("/gui/logo.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var4.b(16777215);
      this.b((this.c - 256) / 2, 30, 0, 0, 256, 49);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(this.c / 2 + 90), 70.0F, 0.0F);
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      float var15;
      GL11.glScalef(
         var15 = (1.8F - MathHelper.e(MathHelper.a((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float) Math.PI * 2.0F) * 0.1F))
            * 100.0F
            / (float)(this.g.a(this.j) + 32),
         var15,
         var15
      );
      a(this.g, this.j, 0, -8, 16776960);
      GL11.glPopMatrix();
      String var16 = "Copyright Mojang Specifications. Do not distribute.";
      b(this.g, var16, this.c - this.g.a(var16) - 2, this.d - 10, 16777215);
      long var7 = Runtime.getRuntime().maxMemory();
      long var9 = Runtime.getRuntime().totalMemory();
      long var11 = Runtime.getRuntime().freeMemory();
      long var13 = var7 - var11;
      String var17 = "Free memory: " + var13 * 100L / var7 + "% of " + var7 / 1024L / 1024L + "MB";
      b(this.g, var17, this.c - this.g.a(var17) - 2, 2, 8421504);
      String var18 = "Allocated memory: " + var9 * 100L / var7 + "% (" + var9 / 1024L / 1024L + "MB)";
      b(this.g, var18, this.c - this.g.a(var18) - 2, 12, 8421504);
      super.a(var1, var2, var3);
   }
}
