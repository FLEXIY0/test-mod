/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.C_f;
import net.minecraft.a.b.a.C_j;
import net.minecraft.a.b.a.C_l;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatBasic;
import net.minecraft.client.statistics.StatCrafting;
import net.minecraft.client.statistics.StatMob;

public class StatList {
    protected static Map<Integer, StatBase> oneShotStats = new HashMap<Integer, StatBase>();
    public static List<StatBase> allStats = new ArrayList<StatBase>();
    public static List<StatBasic> generalStats = new ArrayList<StatBasic>();
    public static List<StatCrafting> itemStats = new ArrayList<StatCrafting>();
    public static List<StatCrafting> objectMineStats = new ArrayList<StatCrafting>();
    public static List<StatMob> objectMobStats = new ArrayList<StatMob>();
    public static StatBase startGameStat = new StatBasic(1000, "Games started").initIndependentStat().registerStat();
    public static StatBase createWorldStat = new StatBasic(1001, "Worlds created").initIndependentStat().registerStat();
    public static StatBase loadWorldStat = new StatBasic(1002, "Worlds loaded").initIndependentStat().registerStat();
    public static StatBase minutesPlayedStat = new StatBasic(1100, "Minutes played", StatBase.timeStatType).initIndependentStat().registerStat();
    public static StatBase daysPassed = new StatBasic(2007, "Days survived").initIndependentStat().registerStat();
    public static StatBase bloodMoons = new StatBasic(2008, "Blood moons survived").initIndependentStat().registerStat();
    public static StatBase distanceWalkedStat = new StatBasic(2000, "Distance walked", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceSneakedStat = new StatBasic(2005, "Distance sneaked", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceCrawledStat = new StatBasic(2009, "Distance crawled", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceSwumStat = new StatBasic(2001, "Distance swum", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceFallenStat = new StatBasic(2002, "Distance fallen", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceClimbedStat = new StatBasic(2003, "Distance climbed", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceFlownStat = new StatBasic(2004, "Distance flown", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceByMinecartStat = new StatBasic(2006, "Distance traveled in cart", StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase jumpStat = new StatBasic(2010, "Times jumped").initIndependentStat().registerStat();
    public static StatBase dropStat = new StatBasic(2011, "Items dropped").initIndependentStat().registerStat();
    public static StatBase collectStat = new StatBasic(2014, "Items collected").initIndependentStat().registerStat();
    public static StatBase damageDealtStat = new StatBasic(2020, "Damage dealt").registerStat();
    public static StatBase damageTakenStat = new StatBasic(2021, "Damage taken").registerStat();
    public static StatBase deathsStat = new StatBasic(2022, "Total deaths").registerStat();
    public static StatBase mobKillsStat = new StatBasic(2023, "Total mob kills").registerStat();
    public static StatBase blocksBrokenStat = new StatBasic(2026, "Total blocks mined").registerStat();
    public static StatBase blocksPlacedStat = new StatBasic(2027, "Total blocks placed").registerStat();
    public static StatBase itemsBrokenStat = new StatBasic(2012, "Total items broken").registerStat();
    public static StatBase itemsCraftedStat = new StatBasic(2013, "Total items crafted").registerStat();
    public static StatBase fishCaughtStat = new StatBasic(2025, "Total fish caught").registerStat();
    public static StatBase lightningStrike = new StatBasic(2076, "Struck by lightning").registerStat();
    public static StatBase firesDoused = new StatBasic(2077, "Fires extinguished").registerStat();
    public static StatBase torchesRelight = new StatBasic(2081, "Torches relit").registerStat();
    public static StatBase tntIgnited = new StatBasic(2091, "TNT ignited").registerStat();
    public static StatBase tntDefused = new StatBasic(2080, "TNT defused").registerStat();
    public static StatBase slabSplits = new StatBasic(2089, "Slabs split").registerStat();
    public static StatBase treesChopped = new StatBasic(2086, "Logs stripped").registerStat();
    public static StatBase pathsMade = new StatBasic(2087, "Paths made").registerStat();
    public static StatBase farmlandMade = new StatBasic(2088, "Farmland tilled").registerStat();
    public static StatBase benchUse = new StatBasic(2028, "Workbench uses").registerStat();
    public static StatBase chestUse = new StatBasic(2029, "Chest uses").registerStat();
    public static StatBase furnaceUse = new StatBasic(2030, "Furnace uses").registerStat();
    public static StatBase barrelUse = new StatBasic(2031, "Barrel uses").registerStat();
    public static StatBase endChestUse = new StatBasic(2032, "Adminium chest uses").registerStat();
    public static StatBase generatorUse = new StatBasic(2033, "Generator uses").registerStat();
    public static StatBase vacuumUse = new StatBasic(2073, "Vacuum uses").registerStat();
    public static StatBase shelfUse = new StatBasic(2034, "Bookshelf uses").registerStat();
    public static StatBase bedUse = new StatBasic(2035, "Times slept in bed").registerStat();
    public static StatBase chairUse = new StatBasic(2079, "Times sat in chair").registerStat();
    public static StatBase potUse = new StatBasic(2036, "Flowers potted").registerStat();
    public static StatBase frameUse = new StatBasic(2085, "Frames filled").registerStat();
    public static StatBase signUse = new StatBasic(2037, "Signs edited").registerStat();
    public static StatBase doorUse = new StatBasic(2038, "Doors opened").registerStat();
    public static StatBase pieUse = new StatBasic(2039, "Pie slices eaten").registerStat();
    public static StatBase jukeboxUse = new StatBasic(2074, "Records played").registerStat();
    public static StatBase pistonUse = new StatBasic(2075, "Pulleys triggered").registerStat();
    public static StatBase noteUse = new StatBasic(2082, "Note block uses").registerStat();
    public static StatBase berryGathered = new StatBasic(2078, "Berries harvested").registerStat();
    public static StatBase treeGrowth = new StatBasic(2083, "Trees grown").registerStat();
    public static StatBase mushroomGrowth = new StatBasic(2084, "Mushrooms grown").registerStat();
    public static StatBase flowerGrowth = new StatBasic(2090, "Flowers grown").registerStat();
    public static StatBase[] mineBlockStatArray = StatList.initMinableStats("Total blocks mined", 0x1000000);
    public static StatBase[] objectCraftStats;
    public static StatBase[] objectUseStats;
    public static StatBase[] objectBreakStats;
    public static StatBase[] objectObtainStats;
    public static StatBase[] objectDisposeStats;
    public static StatBase[] objectKillStats;
    public static StatBase[] objectDeathStats;
    public static final String[] entities;
    private static boolean blockStatsInitialized;
    private static boolean itemStatsInitialized;

    public static void initBreakableStats() {
        objectUseStats = StatList.initUsableStats(objectUseStats, "Times placed", 0x1020000, 0, 256);
        objectBreakStats = StatList.initBreakStats(objectBreakStats, "Times broken", 0x1030000, 0, 256);
        objectObtainStats = StatList.initPickupStats(objectObtainStats, "Times obtained", 17908288, 0, 256);
        objectDisposeStats = StatList.initPickupStats(objectDisposeStats, "Times disposed of", 17973824, 0, 256);
        blockStatsInitialized = true;
        StatList.initCraftableStats();
    }

    public static void initStats() {
        objectUseStats = StatList.initUsableStats(objectUseStats, "Times used", 0x1020000, 256, 1024);
        objectBreakStats = StatList.initBreakStats(objectBreakStats, "Times broken", 0x1030000, 256, 1024);
        objectObtainStats = StatList.initPickupStats(objectObtainStats, "Times obtained", 17908288, 256, 1024);
        objectDisposeStats = StatList.initPickupStats(objectDisposeStats, "Times disposed of", 17973824, 256, 1024);
        itemStatsInitialized = true;
        StatList.initCraftableStats();
    }

    public static void initCraftableStats() {
        if (blockStatsInitialized && itemStatsInitialized) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (C_l object : C_f.a().getRecipeList()) {
                if (object.getRecipeOutput() == null) continue;
                hashSet.add(object.getRecipeOutput().c);
            }
            for (ItemStack itemStack : C_j.smelting().getSmeltingList().values()) {
                hashSet.add(itemStack.c);
            }
            objectCraftStats = new StatBase[1024];
            for (Integer n : hashSet) {
                if (Item.b[n] == null) continue;
                String string = Item.b[n].getItemName();
                StatList.objectCraftStats[n.intValue()] = new StatCrafting(0x1010000 + n, string, n).registerStat();
            }
            StatList.replaceAllSimilarBlocks(objectCraftStats);
        }
    }

    private static StatBase[] initMinableStats(String string, int n) {
        StatBase[] statBaseArray = new StatBase[256];
        for (int i = 0; i < 256; ++i) {
            if (C_x.c[i] == null || !C_x.c[i].getEnableStats()) continue;
            String string2 = C_x.c[i].getBlockName();
            statBaseArray[i] = new StatCrafting(n + i, string2, i).registerStat();
            objectMineStats.add((StatCrafting)statBaseArray[i]);
        }
        StatList.replaceAllSimilarBlocks(statBaseArray);
        return statBaseArray;
    }

    private static StatBase[] initUsableStats(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (Item.b[i] == null) continue;
            String string2 = Item.b[i].getItemName();
            statBaseArray[i] = new StatCrafting(n + i, string2, i).registerStat();
            if (i < 256) continue;
            itemStats.add((StatCrafting)statBaseArray[i]);
        }
        StatList.replaceAllSimilarBlocks(statBaseArray);
        return statBaseArray;
    }

    private static StatBase[] initBreakStats(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (Item.b[i] == null || !Item.b[i].isDamagable()) continue;
            String string2 = Item.b[i].getItemName();
            statBaseArray[i] = new StatCrafting(n + i, string2, i).registerStat();
        }
        StatList.replaceAllSimilarBlocks(statBaseArray);
        return statBaseArray;
    }

    private static StatBase[] initPickupStats(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (Item.b[i] == null) continue;
            String string2 = Item.b[i].getItemName();
            statBaseArray[i] = new StatCrafting(n + i, string2, i).registerStat();
        }
        StatList.replaceAllSimilarBlocks(statBaseArray);
        return statBaseArray;
    }

    public static StatBase[] initKillStats(StatBase[] statBaseArray, String string, int n, int n2, int n3) {
        if (statBaseArray == null) {
            statBaseArray = new StatBase[32];
        }
        for (int i = n2; i < n3; ++i) {
            if (entities[i] == null) continue;
            String string2 = entities[i];
            statBaseArray[i] = new StatMob(n + i, string2, i).registerStat();
        }
        return statBaseArray;
    }

    private static StatBase[] initMobStats(String string, int n) {
        StatBase[] statBaseArray = new StatBase[32];
        for (int i = 0; i < entities.length; ++i) {
            String string2 = entities[i];
            statBaseArray[i] = new StatMob(n + i, string2, i).registerStat();
            objectMobStats.add((StatMob)statBaseArray[i]);
        }
        return statBaseArray;
    }

    private static void replaceAllSimilarBlocks(StatBase[] statBaseArray) {
        StatList.replaceSimilarBlocks(statBaseArray, C_x.q.at, C_x.p.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.s.at, C_x.r.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.ar.at, C_x.aq.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.Y.at, C_x.Z.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.stairUpsideDown.at, C_x.Z.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.generatorActive.at, C_x.generator.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.pulleyBaseActive.at, C_x.pulleyBase.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.pulleyStickyBaseActive.at, C_x.pulleyStickyBase.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.pulleyExtension.at, C_x.pulleyBase.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.pulleyMoving.at, C_x.pulleyBase.at);
        StatList.replaceSimilarBlocks(statBaseArray, C_x.adminiumLampLit.at, C_x.adminiumLamp.at);
    }

    private static void replaceSimilarBlocks(StatBase[] statBaseArray, int n, int n2) {
        if (statBaseArray[n] != null && statBaseArray[n2] == null) {
            statBaseArray[n2] = statBaseArray[n];
        } else {
            allStats.remove(statBaseArray[n]);
            objectMineStats.remove(statBaseArray[n]);
            generalStats.remove(statBaseArray[n]);
            statBaseArray[n] = statBaseArray[n2];
        }
    }

    public static StatBase getOneShotStat(int n) {
        return oneShotStats.get(n);
    }

    static {
        entities = new String[]{"Pig", "Sheep", "Cow", "Duck", "Zombie", "Skeleton", "Spider", "Creeper", "Steve", "Black Steve", "Beast Boy", "Rana", "Fox", "Mummy", "Antlion", "Slime", "Bat", "Jellyfish", "Fish", "Fire Imp", "Harpy", "Mooshroom", "Moobloom", "Giant", "Snowman", "Slug", "Husk"};
        AchievementList.init();
        StatList.initMobStats("Mob Killed", 2040);
        objectKillStats = StatList.initKillStats(objectKillStats, "Kills", 2140, 0, entities.length);
        objectDeathStats = StatList.initKillStats(objectDeathStats, "Deaths", 2240, 0, entities.length);
        blockStatsInitialized = false;
        itemStatsInitialized = false;
    }
}

