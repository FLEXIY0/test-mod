package net.minecraft.a.b.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.a.a.b.C_bo;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_ah;
import net.minecraft.a.b.C_av;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.C_bb;
import net.minecraft.a.b.C_bd;
import net.minecraft.a.b.C_bh;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.d;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockChair;
import net.minecraft.game.level.block.furniture.BlockFenceGate;
import net.minecraft.game.level.block.furniture.BlockTrapdoor;

public final class C_f {
   private static final C_f a = new C_f();
   private List<C_l> b = new ArrayList<>();
   private List<C_l> unlockedRecipes = new ArrayList<>();

   public static final C_f a() {
      return a;
   }

   private C_f() {
      new C_e().a(this);
      new C_h().a(this);
      new C_d().a(this);
      new C_n().addRecipes(this);
      new C_q().addRecipes(this);
      new C_p().addRecipes(this);
      new C_m().addRecipes(this);
      new C_o().addRecipes(this);
      new C_a().a(this);
      this.addShapelessRecipe(new ItemStack(Item.B), Block.mushroomBrown, Block.mushroomRed, Item.A);
      this.addShapelessRecipe(new ItemStack(Item.bowlGlowSoup), Item.B, Block.mushroomGlowing);
      this.addShapelessRecipe(new ItemStack(Block.ad), Block.l, Block.moss);
      this.addShapelessRecipe(new ItemStack(Block.stairMoss), Block.stairStone, Block.moss);
      this.addShapelessRecipe(new ItemStack(Block.Z, 1, 4), new ItemStack(Block.Z, 1, 3), Block.moss);
      this.addShapelessRecipe(new ItemStack(Block.stoneBricks, 1, 1), new ItemStack(Block.stoneBricks, 1, 0), Block.moss);
      this.addShapelessRecipe(new ItemStack(Block.stairStoneBricksMossy), Block.stairStoneBricks, Block.moss);
      this.addShapelessRecipe(new ItemStack(Block.Z, 1, 10), new ItemStack(Block.Z, 1, 9), Block.moss);
      this.addShapelessRecipe(new ItemStack(Item.minecartChest), Item.minecart, Block.aj);
      this.addShapelessRecipe(new ItemStack(Item.minecartFurnace), Item.minecart, Block.aq);
      this.addShapelessRecipe(new ItemStack(Item.minecartExplosive), Item.minecart, Block.ab);
      this.addShapelessRecipe(new ItemStack(Item.bookAndQuill), Item.book, Item.H);
      this.addShapelessRecipe(new ItemStack(Item.lighter, 1), Item.k, Item.al);
      this.addShapelessRecipe(new ItemStack(Item.f, 1), Item.ingotAdminium, new ItemStack(Item.i, 1, 1));
      this.addShapelessRecipe(new ItemStack(Block.plantern, 1), Block.pumpkin, Block.lantern);
      this.a(new ItemStack(Block.packedIce), "###", "###", "###", '#', Block.ice);
      this.a(new ItemStack(Block.aj), "###", "# #", "###", '#', Block.m);
      this.a(new ItemStack(Block.composter), "# #", "# #", "###", '#', Block.m);
      this.a(new ItemStack(Block.chest), "###", "#X#", "###", '#', Item.ingotAdminium, 'X', Item.pearl);
      this.a(new ItemStack(Block.generator), "###", "#X#", "###", '#', Item.k, 'X', Block.ak);
      this.a(new ItemStack(Block.transformer), "###", "X X", "###", '#', Item.k, 'X', Block.ak);
      this.a(new ItemStack(Block.regulator), "###", "X X", "###", '#', Item.l, 'X', Block.ak);
      this.a(new ItemStack(Block.detector), "#X#", "XYX", "#X#", '#', Item.k, 'X', Block.B, 'Y', Block.ak);
      this.a(new ItemStack(Block.fan), "###", "#X#", "# #", '#', Item.k, 'X', Block.ak);
      this.a(new ItemStack(Block.vacuum), "###", "#X#", "#Y#", '#', Item.l, 'X', Block.ak, 'Y', Block.aj);
      this.a(new ItemStack(Block.pump), "###", "#X#", "#Y#", '#', Item.k, 'X', Block.ak, 'Y', Item.bucketEmpty);
      this.a(new ItemStack(Block.dispenser), "###", "#X#", "#Y#", '#', Item.k, 'X', Block.ak, 'Y', Item.g);
      this.a(new ItemStack(Block.pulleyBase), " # ", "#X#", "###", '#', Item.k, 'X', Block.ak);
      this.a(new ItemStack(Block.pulleyStickyBase), " # ", "#X#", "###", '#', Item.l, 'X', Block.ak);
      this.a(new ItemStack(Block.observer), "###", "XYX", "###", '#', Item.k, 'X', Item.emerald, 'Y', Block.ak);
      this.a(new ItemStack(Block.barrel), "#X#", "# #", "#X#", '#', Item.z, 'X', Block.stairSingleWood);
      this.a(new ItemStack(Block.aq), "###", "# #", "###", '#', Block.l);
      this.a(new ItemStack(Block.jukeBox), "###", "#X#", "###", '#', Block.m, 'X', Item.j);
      this.a(new ItemStack(Block.noteBlock), "###", "#X#", "###", '#', Block.m, 'X', Block.ak);
      this.a(new ItemStack(Block.netherReactorCore), "I I", "IDI", "I I", 'I', Item.k, 'D', Item.j); // 6 iron + 1 diamond
      this.a(new ItemStack(Block.cauldron), "I I", "I I", "III", 'I', Item.k); // cauldron: 7 iron
      this.a(new ItemStack(Item.potionBottle, 3), "G G", " G ", 'G', Block.B); // 3 glass -> 3 bottles

      this.a(new ItemStack(Block.an), "##", "##", '#', Block.m);
      this.a(new ItemStack(Block.snowBlock), "##", "##", '#', Item.snowball);
      this.a(new ItemStack(Block.t), "##", "##", '#', Item.sandball);
      this.a(new ItemStack(Block.melon), "##", "##", '#', Item.melonSlice);
      this.a(new ItemStack(Block.sandStone, 4, 0), "##", "##", '#', Block.t);
      this.a(new ItemStack(Block.sandStone, 4, 1), "##", "##", '#', new ItemStack(Block.sandStone, 1, 0));
      this.a(new ItemStack(Block.sandStone, 4, 2), "##", "##", '#', Block.redSand);
      this.a(new ItemStack(Block.sandStone, 4, 3), "##", "##", '#', new ItemStack(Block.sandStone, 1, 2));
      this.a(new ItemStack(Block.stoneBricks, 4, 0), "##", "##", '#', Block.i);
      this.a(new ItemStack(Block.brimStoneBrick, 4, 0), "##", "##", '#', Block.brimStone);
      this.a(new ItemStack(Block.moonRockBrick, 4, 0), "##", "##", '#', Block.moonRock);
      this.a(new ItemStack(Block.cobweb, 2), "##", "##", '#', Item.G);
      this.a(new ItemStack(Block.ab, 1), "X#X", "#X#", "X#X", 'X', Item.I, '#', Block.t);
      this.a(new ItemStack(Block.ab, 1), "X#X", "#X#", "X#X", 'X', Item.I, '#', Block.redSand);
      this.a(new ItemStack(Block.m, 4, 0), "#", '#', new ItemStack(Block.y, 1, 0));
      this.a(new ItemStack(Block.m, 4, 1), "#", '#', new ItemStack(Block.y, 1, 1));
      this.a(new ItemStack(Block.m, 4, 2), "#", '#', new ItemStack(Block.y, 1, 2));
      this.a(new ItemStack(Block.m, 4, 3), "#", '#', new ItemStack(Block.y, 1, 3));
      this.a(new ItemStack(Block.m, 4, 0), "#", '#', new ItemStack(Block.log, 1, 0));
      this.a(new ItemStack(Block.m, 4, 1), "#", '#', new ItemStack(Block.log, 1, 1));
      this.a(new ItemStack(Block.m, 4, 2), "#", '#', new ItemStack(Block.log, 1, 2));
      this.a(new ItemStack(Block.m, 4, 3), "#", '#', new ItemStack(Block.log, 1, 3));
      this.a(new ItemStack(Block.m, 4, 0), "#", '#', new ItemStack(Block.mushroomStem, 1));
      this.a(new ItemStack(Block.m, 4, 0), "#", '#', new ItemStack(Block.flowerStem, 1));
      this.a(new ItemStack(Block.pillar, 2), "#", "#", '#', Block.moonRockBrick);
      this.a(new ItemStack(Block.concrete, 1), "#", "#", '#', new ItemStack(Block.Z, 1, 0));
      this.a(new ItemStack(Item.z, 4), "#", "#", '#', Block.m);
      this.a(new ItemStack(Block.af, 4), "X", "#", 'X', Item.i, '#', Item.z);
      this.a(new ItemStack(Block.af, 2), "X", "#", 'X', new ItemStack(Item.i, 1, 1), '#', Item.z);
      this.a(new ItemStack(Item.A, 4), "# #", " # ", '#', Block.m);
      this.a(new ItemStack(Item.Q, 1), "###", '#', Item.P);
      this.a(new ItemStack(Item.ao, 1), "###", "#X#", "###", '#', Item.z, 'X', Block.cloth);
      this.a(new ItemStack(Item.itemFrame, 1), "###", "#X#", "###", '#', Item.z, 'X', Item.leather);
      this.a(new ItemStack(Item.doorOak, 2), "##X", "##X", "##X", '#', new ItemStack(Block.m, 1, 0));
      this.a(new ItemStack(Item.doorBirch, 2), "##X", "##X", "##X", '#', new ItemStack(Block.m, 1, 1));
      this.a(new ItemStack(Item.doorPalm, 2), "##X", "##X", "##X", '#', new ItemStack(Block.m, 1, 2));
      this.a(new ItemStack(Item.doorSpruce, 2), "##X", "##X", "##X", '#', new ItemStack(Block.m, 1, 3));
      this.a(new ItemStack(Item.doorSteel, 2), "##X", "##X", "##X", '#', Item.k);
      this.a(new ItemStack(Block.ladder, 2), "#X#", "###", "#X#", '#', Item.z);
      this.a(new ItemStack(Block.rail, 16), "YXY", "Y#Y", "YXY", '#', Item.z, 'Y', Item.k);
      this.a(new ItemStack(Block.railBooster, 8), "YXY", "Y#Y", "YZY", '#', Item.z, 'Y', Item.l, 'Z', Block.ak);
      this.a(new ItemStack(Item.minecart, 1), "#X#", "###", '#', Item.k);
      this.a(new ItemStack(Block.ak, 8), " X ", "X X", " X ", 'X', Item.k);
      this.a(new ItemStack(Item.paper, 3), "###", '#', Item.reed);
      this.a(new ItemStack(Item.paper, 3), "###", '#', Item.bark);
      this.a(new ItemStack(Item.book, 3), "#", "#", "#", '#', Item.paper);
      this.a(new ItemStack(Block.ac, 1, 0), "###", "XXX", "###", '#', Block.m);
      this.a(new ItemStack(Block.clay, 1), "##", "##", '#', Item.clay);
      this.a(new ItemStack(Block.aa, 1), "##", "##", '#', Item.bricks);
      this.a(new ItemStack(Item.gapple), "###", "#X#", "###", '#', Block.W, 'X', Item.apple);
      this.a(new ItemStack(Item.cake, 1), "###", "XXX", "###", 'X', Item.apple, '#', Item.P);
      this.a(new ItemStack(Block.chair, 1), "#  ", "###", "X X", '#', new ItemStack(Block.m, 1, 0), 'X', Item.z);
      this.a(new ItemStack(Block.chairWhite, 1), "#  ", "###", "X X", '#', new ItemStack(Block.m, 1, 1), 'X', Item.z);
      this.a(new ItemStack(Block.chairRed, 1), "#  ", "###", "X X", '#', new ItemStack(Block.m, 1, 2), 'X', Item.z);
      this.a(new ItemStack(Block.chairBlack, 1), "#  ", "###", "X X", '#', new ItemStack(Block.m, 1, 3), 'X', Item.z);
      this.a(new ItemStack(Block.table, 1, 0), "###", "X X", "X X", '#', new ItemStack(Block.m, 1, 0), 'X', Item.z);
      this.a(new ItemStack(Block.table, 1, 1), "###", "X X", "X X", '#', new ItemStack(Block.m, 1, 1), 'X', Item.z);
      this.a(new ItemStack(Block.table, 1, 2), "###", "X X", "X X", '#', new ItemStack(Block.m, 1, 2), 'X', Item.z);
      this.a(new ItemStack(Block.table, 1, 3), "###", "X X", "X X", '#', new ItemStack(Block.m, 1, 3), 'X', Item.z);
      this.a(new ItemStack(Item.sign, 3), "###", "###", " X ", 'X', Item.z, '#', new ItemStack(Block.m, 1, 0));
      this.a(new ItemStack(Item.signBirch, 3), "###", "###", " X ", 'X', Item.z, '#', new ItemStack(Block.m, 1, 1));
      this.a(new ItemStack(Item.signPalm, 3), "###", "###", " X ", 'X', Item.z, '#', new ItemStack(Block.m, 1, 2));
      this.a(new ItemStack(Item.signDark, 3), "###", "###", " X ", 'X', Item.z, '#', new ItemStack(Block.m, 1, 3));
      this.a(new ItemStack(Item.bed, 1), "###", "XXX", 'X', Block.m, '#', Block.cloth);
      this.a(new ItemStack(Block.glassPane, 16), "#X#", "XXX", "#X#", '#', Block.B, 'X', Item.z);
      this.a(new ItemStack(Block.ironBars, 16), "###", "###", '#', Item.k);
      this.a(new ItemStack(Block.trapdoorWood, 2), "###", "###", '#', new ItemStack(Block.m, 1, 0));
      this.a(new ItemStack(Block.trapdoorBirch, 2), "###", "###", '#', new ItemStack(Block.m, 1, 1));
      this.a(new ItemStack(Block.trapdoorJungle, 2), "###", "###", '#', new ItemStack(Block.m, 1, 2));
      this.a(new ItemStack(Block.trapdoorSpruce, 2), "###", "###", '#', new ItemStack(Block.m, 1, 3));
      this.a(new ItemStack(Block.trapdoorSteel, 2), "##", "##", '#', Item.k);
      this.a(new ItemStack(Block.rope, 3), "#", "#", "#", '#', Item.G);
      this.a(new ItemStack(Block.rod, 2), "#", "#", "X", '#', Item.l, 'X', Block.X);
      this.a(new ItemStack(Item.quiver, 1), "#X ", "# X", "#  ", '#', Item.leather, 'X', Item.G);
      this.a(new ItemStack(Item.quiverAdminium, 1), "#X ", "# X", "#  ", '#', Item.ingotAdminium, 'X', Item.G);
      this.a(new ItemStack(Block.lantern, 4), "#A#", "XYX", "###", 'A', Item.ingotAdminium, '#', Item.k, 'X', Block.B, 'Y', Block.af);
      this.a(new ItemStack(Block.adminiumLamp, 2), "###", "YXY", "###", '#', Block.B, 'X', Block.af, 'Y', Block.ak);
      this.a(new ItemStack(Item.flowerPot, 2), "# #", " # ", '#', Item.bricks);
      this.a(new ItemStack(Item.bucketEmpty, 1), "# #", " # ", '#', Item.k);
      this.a(new ItemStack(Item.fishingRod, 1), "  #", " #X", "# X", '#', Item.z, 'X', Item.G);
      this.a(new ItemStack(Item.clock, 1), " X ", "XYX", " X ", 'X', Item.ingotAdminium, 'Y', Item.pearl);
      this.a(new ItemStack(Item.seedsMelon, 1), "X", 'X', Item.melonSlice);
      this.a(new ItemStack(Item.seedsPumpkin, 2), "X", 'X', Block.pumpkin);
      this.a(new ItemStack(Item.pumpkinPie, 1), " X ", "XYX", " X ", 'X', Item.P, 'Y', Block.pumpkin);
      this.a(new ItemStack(Item.glowDust, 1), "X", 'X', Block.mushroomGlowing);
      this.a(new ItemStack(Item.ring, 1), " Y ", "X X", " X ", 'X', Item.ingotAdminium, 'Y', Item.fireBall);
      this.a(new ItemStack(Item.aquaCharm, 1), "X X", "YXY", " Z ", 'X', Item.ingotAdminium, 'Y', Item.fishFin, 'Z', Item.jellyfishTentacle);
      this.a(new ItemStack(Item.coin, 1), " # ", "#X#", " # ", 'X', Item.antlionExtract, '#', Item.l);
      this.a(new ItemStack(Item.bootsHermes, 1), "YXY", "X#X", 'X', Item.slimeBall, '#', Item.U, 'Y', Item.harpyFeather);
      this.a(new ItemStack(Item.spectacles, 1), "YXY", "X X", 'X', Item.ingotAdminium, 'Y', Item.glowDust);
      this.a(new ItemStack(Item.shield, 1), "XXX", "XYX", " X ", 'X', Item.ingotAdminium, 'Y', Item.emerald);
      this.a(new ItemStack(Item.pearl, 1), "XXX", "XYX", "XXX", 'X', Item.glowDust, 'Y', Item.tear);
      this.a(new ItemStack(Item.gloves, 1), "Y Y", "X X", 'X', Item.ingotAdminium, 'Y', Item.slimeBall);
      this.a(new ItemStack(Item.mirror, 1), " # ", "#X#", " # ", 'X', Item.glowDust, '#', Item.ingotAdminium);
      this.a(new ItemStack(Item.bracelet, 1), "#X#", " # ", 'X', Item.tear, '#', Item.ingotAdminium);
      this.a(new ItemStack(Item.vial, 1), " Y ", "#X#", " # ", '#', Block.B, 'X', Item.eye, 'Y', Item.ingotAdminium);

      for (int var1 = 0; var1 < 16; var1++) {
         this.a(new ItemStack(Block.coloredPane, 16, var1), "###", "###", '#', new ItemStack(Block.glassStained, 1, C_bo.getGlassColor(var1)));
      }

      Collections.sort(this.b, new C_i(this));
      System.out.println(this.b.size() + " recipes");
   }

   final void a(ItemStack var1, Object... var2) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if (var2[var4] instanceof String[]) {
         String[] var11 = (String[])var2[var4++];

         for (int var8 = 0; var8 < var11.length; var8++) {
            String var9 = var11[var8];
            var6++;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while (var2[var4] instanceof String) {
            String var7 = (String)var2[var4++];
            var6++;
            var5 = var7.length();
            var3 = var3 + var7;
         }
      }

      HashMap var12;
      for (var12 = new HashMap(); var4 < var2.length; var4 += 2) {
         Character var13 = (Character)var2[var4];
         ItemStack var15 = null;
         if (var2[var4 + 1] instanceof Item) {
            var15 = new ItemStack((Item)var2[var4 + 1]);
         } else if (var2[var4 + 1] instanceof Block) {
            var15 = new ItemStack((Block)var2[var4 + 1], 1, -1);
         } else if (var2[var4 + 1] instanceof ItemStack) {
            var15 = (ItemStack)var2[var4 + 1];
         }

         var12.put(var13, var15);
      }

      ItemStack[] var14 = new ItemStack[var5 * var6];

      for (int var16 = 0; var16 < var5 * var6; var16++) {
         char var10 = var3.charAt(var16);
         if (var12.containsKey(var10)) {
            var14[var16] = ((ItemStack)var12.get(var10)).copy();
         } else {
            var14[var16] = null;
         }
      }

      this.b.add(new C_r(var5, var6, var14, var1));
   }

   final void addShapelessRecipe(ItemStack var1, Object... var2) {
      ArrayList var3 = new ArrayList();

      for (Object var7 : var2) {
         if (var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).copy());
         } else if (var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if (!(var7 instanceof Block)) {
               throw new RuntimeException("Invalid shapeless recipe!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.b.add(new C_s(var1, var3));
   }

   public ItemStack findMatchingRecipe(net.minecraft.client.c.a.C_a var1) {
      int var2 = 0;
      ItemStack var3 = null;
      ItemStack var4 = null;

      for (int var5 = 0; var5 < var1.a(); var5++) {
         ItemStack var6 = var1.a(var5);
         if (var6 != null) {
            if (var2 == 0) {
               var3 = var6;
            }

            if (var2 == 1) {
               var4 = var6;
            }

            var2++;
         }
      }

      if (var2 == 2 && var3.c == var4.c && var3.a == 1 && var4.a == 1 && Item.b[var3.c].isDamagable()) {
         Item var13 = Item.b[var3.c];
         int var7 = var13.d() - var3.getItemDamage();
         int var8 = var13.d() - var4.getItemDamage();
         int var9 = var7 + var8 + var13.d() * 5 / 100;
         int var10 = var13.d() - var9;
         if (var10 < 0) {
            var10 = 0;
         }

         return new ItemStack(var3.c, 1, var10);
      } else {
         for (int var11 = 0; var11 < this.b.size(); var11++) {
            C_l var12 = this.b.get(var11);
            if (var12.matches(var1)) {
               return var12.getCraftingResult(var1);
            }
         }

         return null;
      }
   }

   public List<C_l> getRecipeList() {
      return this.b;
   }

   public List<C_l> getUnlockedRecipeList() {
      return this.unlockedRecipes;
   }

   public static void addUnlockedRecipes() {
      for (int var0 = 0; var0 < 1024; var0++) {
         if (d.getMinecraft().statFileWriter.getStatCount(StatList.objectCraftStats[var0]) >= 1) {
            ItemStack var1 = new ItemStack(var0);

            for (int var2 = 0; var2 < a().getRecipeList().size(); var2++) {
               C_l var3 = a().getRecipeList().get(var2);
               Item var4 = var3.getRecipeOutput().a();
               boolean var5 = (
                     var4 instanceof net.minecraft.a.b.C_g
                        || var4 instanceof net.minecraft.a.b.C_n
                        || var4 instanceof net.minecraft.a.b.C_c
                        || var4 instanceof net.minecraft.a.b.C_j
                        || var4 instanceof C_bm
                        || var4 instanceof C_ba
                        || var4 instanceof net.minecraft.a.b.C_m
                        || var4 instanceof C_bh
                        || var4 instanceof C_ah
                        || var4 instanceof C_av
                        || var4 instanceof net.minecraft.a.b.C_b
                        || var4 instanceof C_bb
                        || var4 instanceof net.minecraft.a.b.C_r
                        || var4 instanceof C_bd
                        || var4 instanceof net.minecraft.a.b.C_f
                  )
                  && var4.getClass().equals(var1.a().getClass());
               boolean var6 = false;
               boolean var7 = var4 == Item.i && var1.a() instanceof C_bd;
               boolean var8 = false;
               if (var4.ap < 256 && var1.c < 256) {
                  Block var9 = Block.c[var1.c];
                  Block var10 = Block.c[var4.ap];
                  var6 = var9 != null
                     && var10 != null
                     && (
                        var9 instanceof C_bq
                           || var9 instanceof BlockFenceGate
                           || var9 instanceof BlockChair
                           || var9 instanceof net.minecraft.a.a.b.C_bb
                           || var9 instanceof C_bs
                           || var9 instanceof BlockTrapdoor
                     )
                     && var10.getClass().equals(var9.getClass());
                  var8 = var9 != null
                     && var10 != null
                     && (var10 == Block.hayBlock || var10 == Block.slimeBlock || var10 == Block.bone)
                     && var9 instanceof net.minecraft.a.a.b.C_bb;
               }

               if ((var4 == var1.a() || var5 || var6 || var7 || var8) && !a().getUnlockedRecipeList().contains(var3)) {
                  a().getUnlockedRecipeList().add(var3);
               }
            }
         }
      }
   }

   public static void clearRecipes() {
      a().getUnlockedRecipeList().clear();
   }
}
