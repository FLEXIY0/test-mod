/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c.a;

import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_ah;
import net.minecraft.a.b.C_av;
import net.minecraft.a.b.C_b;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.C_bb;
import net.minecraft.a.b.C_bd;
import net.minecraft.a.b.C_bh;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_c;
import net.minecraft.a.b.C_f;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.C_m;
import net.minecraft.a.b.C_n;
import net.minecraft.a.b.C_r;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_l;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.a.C_a;
import net.minecraft.client.c.a.C_g;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockChair;
import net.minecraft.game.level.block.furniture.BlockFenceGate;
import net.minecraft.game.level.block.furniture.BlockTrapdoor;

public final class C_d
extends C_g {
    private final net.minecraft.a.C_b e;
    private EntityPlayer thePlayer;

    public C_d(EntityPlayer entityPlayer, net.minecraft.a.C_b c_b, net.minecraft.a.C_b c_b2, int n, int n2, int n3) {
        super(c_b2, n, n2, n3);
        this.e = c_b;
        this.thePlayer = entityPlayer;
    }

    @Override
    public final boolean a(ItemStack itemStack) {
        return false;
    }

    @Override
    public final void onPickupFromSlot(ItemStack itemStack) {
        for (int i = 0; i < this.e.a(); ++i) {
            if (this.e.a(i) == null) continue;
            this.e.a(i, 1);
        }
        this.onCrafting(itemStack);
    }

    protected void onCrafting(ItemStack itemStack) {
        this.thePlayer.addStat(StatList.objectCraftStats[itemStack.c], 1);
        this.thePlayer.addStat(StatList.itemsCraftedStat, 1);
        for (int i = 0; i < net.minecraft.a.b.a.CraftingManager.a().getRecipeList().size(); ++i) {
            C_l c_l = net.minecraft.a.b.a.CraftingManager.a().getRecipeList().get(i);
            Item item = c_l.getCraftingResult((C_a)this.e).a();
            boolean bl = (item instanceof net.minecraft.a.b.C_g || item instanceof C_n || item instanceof C_c || item instanceof C_j || item instanceof C_bm || item instanceof C_ba || item instanceof C_m || item instanceof C_bh || item instanceof C_ah || item instanceof C_av || item instanceof C_b || item instanceof C_bb || item instanceof C_bd || item instanceof C_r || item instanceof C_f) && item.getClass().equals(itemStack.a().getClass());
            boolean bl2 = false;
            boolean bl3 = item == Item.i && itemStack.a() instanceof C_bd;
            boolean bl4 = false;
            if (item.ap < 256 && itemStack.c < 256) {
                Block c_x = Block.c[itemStack.c];
                Block c_x2 = Block.c[item.ap];
                bl2 = c_x != null && c_x2 != null && (c_x instanceof C_bq || c_x instanceof BlockFenceGate || c_x instanceof BlockChair || c_x instanceof net.minecraft.a.a.b.C_bb || c_x instanceof C_bs || c_x instanceof BlockTrapdoor) && c_x2.getClass().equals(c_x.getClass());
                boolean bl5 = bl4 = c_x != null && c_x2 != null && (c_x2 == Block.hayBlock || c_x2 == Block.slimeBlock || c_x2 == Block.bone) && c_x instanceof net.minecraft.a.a.b.C_bb;
            }
            if (item != itemStack.a() && !bl && !bl2 && !bl3 && !bl4 || net.minecraft.a.b.a.CraftingManager.a().getUnlockedRecipeList().contains(c_l) || this.thePlayer.d.multiplayerWorld) continue;
            net.minecraft.a.b.a.CraftingManager.a().getUnlockedRecipeList().add(c_l);
            net.minecraft.client.d.getMinecraft().guiAchievement.queueRecipeInformation(itemStack);
        }
        if (net.minecraft.a.b.a.CraftingManager.a().getUnlockedRecipeList().size() == net.minecraft.a.b.a.CraftingManager.a().getRecipeList().size()) {
            this.thePlayer.triggerAchievement(AchievementList.recipes);
        }
        if (itemStack.c == Block.an.at) {
            this.thePlayer.triggerAchievement(AchievementList.buildWorkBench);
        } else if (itemStack.c == Block.aq.at) {
            this.thePlayer.triggerAchievement(AchievementList.buildFurnace);
        } else if (itemStack.c == Block.barrel.at) {
            this.thePlayer.triggerAchievement(AchievementList.buildChest);
        } else if (itemStack.a().isToolSilkTouch()) {
            this.thePlayer.triggerAchievement(AchievementList.silkTouch);
        } else if (itemStack.a() instanceof net.minecraft.a.b.C_a) {
            this.thePlayer.triggerAchievement(AchievementList.buildPickaxe);
        } else if (itemStack.c == Item.Q.ap) {
            this.thePlayer.triggerAchievement(AchievementList.makeBread);
        } else if (itemStack.a() instanceof C_c) {
            this.thePlayer.triggerAchievement(AchievementList.buildSword);
        } else if (itemStack.a() instanceof C_n) {
            this.thePlayer.triggerAchievement(AchievementList.buildHoe);
        } else if (itemStack.c == Item.fishingRod.ap) {
            this.thePlayer.triggerAchievement(AchievementList.buildFishingRod);
        } else if (itemStack.c == Block.lantern.at) {
            this.thePlayer.triggerAchievement(AchievementList.buildLantern);
        } else if (itemStack.c == Block.chest.at) {
            this.thePlayer.triggerAchievement(AchievementList.endChest);
        }
    }
}

