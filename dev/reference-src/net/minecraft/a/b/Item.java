/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.C_a;
import net.minecraft.a.b.C_aa;
import net.minecraft.a.b.C_ac;
import net.minecraft.a.b.C_af;
import net.minecraft.a.b.C_ag;
import net.minecraft.a.b.C_ah;
import net.minecraft.a.b.C_ai;
import net.minecraft.a.b.C_aj;
import net.minecraft.a.b.C_al;
import net.minecraft.a.b.C_am;
import net.minecraft.a.b.C_ao;
import net.minecraft.a.b.C_ap;
import net.minecraft.a.b.C_av;
import net.minecraft.a.b.C_ax;
import net.minecraft.a.b.C_b;
import net.minecraft.a.b.C_ba;
import net.minecraft.a.b.C_bb;
import net.minecraft.a.b.C_bc;
import net.minecraft.a.b.C_bd;
import net.minecraft.a.b.C_be;
import net.minecraft.a.b.C_bh;
import net.minecraft.a.b.C_bk;
import net.minecraft.a.b.C_bl;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_bn;
import net.minecraft.a.b.C_br;
import net.minecraft.a.b.C_c;
import net.minecraft.a.b.C_e;
import net.minecraft.a.b.C_f;
import net.minecraft.a.b.C_h;
import net.minecraft.a.b.C_j;
import net.minecraft.a.b.C_l;
import net.minecraft.a.b.C_m;
import net.minecraft.a.b.C_n;
import net.minecraft.a.b.C_o;
import net.minecraft.a.b.C_p;
import net.minecraft.a.b.C_q;
import net.minecraft.a.b.C_r;
import net.minecraft.a.b.C_s;
import net.minecraft.a.b.C_t;
import net.minecraft.a.b.C_u;
import net.minecraft.a.b.C_v;
import net.minecraft.a.b.C_x;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class Item {
    protected static Random a = new Random();
    public static Item[] b = new Item[1024];
    public net.minecraft.a.a.b.C_x[] blocksEffectiveAgainst;
    public static final Item c = new C_l(0, 2).a(162).setItemName("Iron Shovel");
    public static final Item d = new C_a(1, 2).a(194).setItemName("Iron Pickaxe");
    public static final Item e = new C_h(2, 2).a(226).setItemName("Iron Axe");
    public static final Item lighter = new C_m(3, 0).a(5).setItemName("Lighter");
    public static final Item apple = new C_p(4, 4).a(10).setItemName("Apple").setStackSize(2);
    public static final Item g = new C_e(5).a(37).setItemName("Bow");
    public static final Item h = new C_r(6).a(69).setItemName("Arrow").setItemDescription("4 DMG", 0);
    public static final Item i = new C_ac(7).setItemName("Coal");
    public static final Item j = new C_bd(8).a(103).setItemName("\u00a7bDiamond");
    public static final Item k = new C_bd(9).a(39).setItemName("Iron Ingot");
    public static final Item l = new C_bd(10).a(71).setItemName("Gold Ingot");
    public static final Item m = new C_c(11, 2).a(130).setItemName("Iron Sword");
    public static final Item n = new C_c(12, 0).a(128).setItemName("Wooden Sword").setItemDescription("Chance to Crit", 2);
    public static final Item o = new C_l(13, 0).setLooting(true).a(160).setItemName("Wooden Shovel").setItemDescription("Extra Drops", 3);
    public static final Item p = new C_a(14, 0).setLooting(true).a(192).setItemName("Wooden Pickaxe").setItemDescription("Extra Drops", 3);
    public static final Item q = new C_h(15, 0).setLooting(true).a(224).setItemName("Wooden Axe").setItemDescription("Extra Drops", 3);
    public static final Item r = new C_c(16, 1).a(129).setItemName("Stone Sword");
    public static final Item s = new C_l(17, 1).a(161).setItemName("Stone Shovel");
    public static final Item t = new C_a(18, 1).a(193).setItemName("Stone Pickaxe");
    public static final Item u = new C_h(19, 1).a(225).setItemName("Stone Axe");
    public static final Item v = new C_c(20, 4).a(131).setItemName("\u00a7bDiamond Sword");
    public static final Item w = new C_l(21, 4).a(163).setItemName("\u00a7bDiamond Shovel");
    public static final Item x = new C_a(22, 4).a(195).setItemName("\u00a7bDiamond Pickaxe");
    public static final Item y = new C_h(23, 4).a(227).setItemName("\u00a7bDiamond Axe");
    public static final Item z = new Item(24).a(101).setItemName("Stick");
    public static final Item A = new Item(25).a(135).setItemName("Bowl");
    public static final Item B = new C_b(26, 10).a(136).setItemName("Mushroom Stew");
    public static final Item C = new C_c(27, 0).a(132).setSilkTouch(true).setItemName("Golden Sword").setItemDescription("Looting", 2);
    public static final Item D = new C_l(28, 0).a(164).setSilkTouch(true).setItemName("Golden Shovel").setItemDescription("Silk Touch", 3);
    public static final Item E = new C_a(29, 0).a(196).setSilkTouch(true).setItemName("Golden Pickaxe").setItemDescription("Silk Touch", 3);
    public static final Item F = new C_h(30, 0).a(228).setSilkTouch(true).setItemName("Golden Axe").setItemDescription("Silk Touch", 3);
    public static final Item G = new Item(31).a(8).setItemName("Silk");
    public static final Item H = new Item(32).a(40).setItemName("Feather");
    public static final Item I = new Item(33).a(72).setItemName("Sulphur");
    public static final Item J = new C_n(34, 0).a(256).setItemName("Wooden Hoe").setItemDescription("Extra Drops", 1);
    public static final Item K = new C_n(35, 1).a(257).setItemName("Stone Hoe");
    public static final Item L = new C_n(36, 2).a(258).setItemName("Iron Hoe");
    public static final Item M = new C_n(37, 4).a(259).setItemName("\u00a7bDiamond Hoe");
    public static final Item N = new C_n(38, 0).a(260).setItemName("Golden Hoe").setItemDescription("Fortune", 1);
    public static final Item O = new C_f(39, net.minecraft.a.a.b.C_x.ao.at).a(9).setItemName("Wheat Seeds").setDecor(true);
    public static final Item P = new C_bd(40).a(41).setItemName("Wheat");
    public static final Item Q = new C_p(41, 5).a(73).setItemName("Bread").setStackSize(2);
    public static final Item R = new C_j(42, 0, 0, 0).a(0).setItemName("Cloth Helmet");
    public static final Item S = new C_j(43, 0, 0, 1).a(32).setItemName("Cloth Chestplate");
    public static final Item T = new C_j(44, 0, 0, 2).a(64).setItemName("Cloth Leggings");
    public static final Item U = new C_j(45, 0, 0, 3).a(96).setItemName("Cloth Boots");
    public static final Item V = new C_j(46, 1, 1, 0).a(1).setItemName("Chainmail Helmet");
    public static final Item W = new C_j(47, 1, 1, 1).a(33).setItemName("Chainmail Chestplate");
    public static final Item X = new C_j(48, 1, 1, 2).a(65).setItemName("Chainmail Leggings");
    public static final Item Y = new C_j(49, 1, 1, 3).a(97).setItemName("Chainmail Boots");
    public static final Item Z = new C_j(50, 3, 2, 0).a(2).setItemName("Iron Helmet");
    public static final Item aa = new C_j(51, 3, 2, 1).a(34).setItemName("Iron Chestplate");
    public static final Item ab = new C_j(52, 3, 2, 2).a(66).setItemName("Iron Leggings");
    public static final Item ac = new C_j(53, 3, 2, 3).a(98).setItemName("Iron Boots");
    public static final Item ad = new C_j(54, 5, 3, 0).a(3).setItemName("\u00a7bDiamond Helmet");
    public static final Item ae = new C_j(55, 5, 3, 1).a(35).setItemName("\u00a7bDiamond Chestplate");
    public static final Item af = new C_j(56, 5, 3, 2).a(67).setItemName("\u00a7bDiamond Leggings");
    public static final Item ag = new C_j(57, 5, 3, 3).a(99).setItemName("\u00a7bDiamond Boots");
    public static final Item ah = new C_j(58, 1, 4, 0).a(4).setItemName("Golden Helmet").setItemDescription("Respiration", 2);
    public static final Item ai = new C_j(59, 1, 4, 1).a(36).setItemName("Golden Chestplate");
    public static final Item aj = new C_j(60, 1, 4, 2).a(68).setItemName("Golden Leggings");
    public static final Item ak = new C_j(61, 1, 4, 3).a(100).setItemName("Golden Boots");
    public static final Item al = new Item(62).a(6).setItemName("Flint");
    public static final Item am = new C_p(63, 3).a(167).setItemName("Raw Porkchop");
    public static final Item an = new C_p(64, 8).a(168).setItemName("Cooked Porkchop");
    public static final Item ao = new C_o(65).a(42).setItemName("Painting").setDecor(true);
    public static final Item doorOak = new C_ah(66, net.minecraft.a.a.b.C_x.doorOak).a(74).setItemName("Oak Door").setDecor(true);
    public static final Item emerald = new C_bd(67).a(104).setItemName("\u00a7aEmerald");
    public static final Item swordEmerald = new C_c(68, 3).a(133).setDamageVsEntity(8).setItemName("\u00a7aEmerald Sword");
    public static final Item shovelEmerald = new C_l(69, 3).a(165).setItemName("\u00a7aEmerald Shovel");
    public static final Item pickaxeEmerald = new C_a(70, 3).a(197).setItemName("\u00a7aEmerald Pickaxe");
    public static final Item axeEmerald = new C_h(71, 3).a(229).setItemName("\u00a7aEmerald Axe");
    public static final Item hoeEmerald = new C_n(72, 3).a(261).setItemName("\u00a7aEmerald Hoe");
    public static final Item helmetEmerald = new C_j(73, 4, 5, 0).a(13).setItemName("\u00a7aEmerald Helmet");
    public static final Item plateEmerald = new C_j(74, 4, 5, 1).a(45).setItemName("\u00a7aEmerald Chestplate");
    public static final Item legsEmerald = new C_j(75, 4, 5, 2).a(77).setItemName("\u00a7aEmerald Leggings");
    public static final Item bootsEmerald = new C_j(76, 4, 5, 3).a(109).setItemName("\u00a7aEmerald Boots");
    public static final Item reed = new C_bc(77, net.minecraft.a.a.b.C_x.reeds).a(106).setItemName("Reeds").setDecor(true);
    public static final Item paper = new Item(78).a(169).setItemName("Paper");
    public static final Item book = new Item(79).a(170).setItemName("Book");
    public static final Item bone = new Item(80).a(137).setItemName("Bone");
    public static final Item clay = new C_bk(81).a(201).setItemName("Clay Ball");
    public static final Item bricks = new Item(82).a(166).setItemName("Brick");
    public static final Item dyePowder = new C_ai(83).a(320).setItemName("Dye");
    public static final Item leather = new Item(84).a(138).setItemName("Leather");
    public static final Item rottenFlesh = new C_be(85, 5).a(105).setItemName("Rotten Flesh").setStackSize(8).setItemDescription("Poisonous", 1);
    public static final Item helmetStudded = new C_j(86, 2, 6, 0).a(14).setItemName("Studded Helmet");
    public static final Item plateStudded = new C_j(87, 2, 6, 1).a(46).setItemName("Studded Chestplate");
    public static final Item legsStudded = new C_j(88, 2, 6, 2).a(78).setItemName("Studded Leggings");
    public static final Item bootsStudded = new C_j(89, 2, 6, 3).a(110).setItemName("Studded Boots");
    public static final Item gapple = new C_ap(90, 20).a(11).setItemName("\u00a7bGolden Apple").setItemDescription("+10 Absorption", 1);
    public static final Item cake = new C_bc(91, net.minecraft.a.a.b.C_x.cake).a(43).setItemName("Apple Pie").setDecor(true);
    public static final Item sign = new C_bh(92, 0).a(75).setItemName("Oak Sign").setDecor(true);
    public static final Item signBirch = new C_bh(162, 1).a(448).setItemName("Birch Sign").setDecor(true);
    public static final Item signPalm = new C_bh(163, 2).a(449).setItemName("Palm Sign").setDecor(true);
    public static final Item signDark = new C_bh(164, 3).a(450).setItemName("Pine Sign").setDecor(true);
    public static final Item bed = new C_u(93).a(107).setItemName("Bed").setDecor(true);
    public static final Item ingotAdminium = new C_bd(94).a(134).setItemName("\u00a7dAdminium Ingot");
    public static final Item f = new C_m(95, 1).a(102).setItemName("\u00a7dHellfire Lighter");
    public static final Item arrowAdminium = new C_r(96).a(262).setItemName("\u00a7dCrossbow Bolt").setItemDescription("8 DMG", 0);
    public static final Item quiver = new C_ba(97).a(70).setItemName("Quiver");
    public static final Item battleAxeWood = new C_t(98, 0).setLooting(true).a(288).setItemName("Wooden Battleaxe").setItemDescription("Chance to Crit", 3);
    public static final Item battleAxeStone = new C_t(99, 1).a(289).setItemName("Stone Battleaxe");
    public static final Item battleAxeIron = new C_t(100, 2).a(290).setItemName("Iron Battleaxe");
    public static final Item battleAxeDiamond = new C_t(101, 4).a(291).setItemName("\u00a7bDiamond Battleaxe");
    public static final Item battleAxeGold = new C_t(102, 0).a(292).setSilkTouch(true).setItemName("Golden Battleaxe").setItemDescription("Looting", 3);
    public static final Item battleAxeEmerald = new C_t(103, 3).a(293).setItemName("\u00a7aEmerald Battleaxe");
    public static final Item flowerPot = new C_bc(104, net.minecraft.a.a.b.C_x.flowerPot).a(139).setItemName("Flower Pot").setDecor(true);
    public static final Item itemFrame = new C_ao(105).a(171).setItemName("Item Frame").setDecor(true);
    public static final Item bucketEmpty = new C_x(106, 0).a(232).setItemName("Empty Bucket");
    public static final Item bucketWater = new C_x(107, net.minecraft.a.a.b.C_x.p.at).a(264).setItemName("Water Bucket");
    public static final Item bucketLava = new C_x(108, net.minecraft.a.a.b.C_x.r.at).a(296).setItemName("Lava Bucket");
    public static final Item fishingRod = new C_am(109).a(198).setItemName("Fishing Rod");
    public static final Item fishRaw = new C_p(110, 2).a(199).setItemName("Raw Fish").setStackSize(2);
    public static final Item fishCooked = new C_p(111, 5).a(200).setItemName("Cooked Fish").setStackSize(2);
    public static final Item spawnEgg = new C_aj(120).a(352).setItemName("Spawn Egg");
    public static final Item debugStick = new C_bn(121).a(266).setItemName("\u00a7dDebug Stick");
    public static final Item clock = new Item(122).a(298).setItemName("\u00a7dMoon Watch").setStackSize(1).setToolItem(true);
    public static final Item melonSlice = new C_p(123, 2).a(141).setItemName("Melon Slice").setStackSize(4);
    public static final Item seedsMelon = new C_f(124, net.minecraft.a.a.b.C_x.melonStem.at).a(173).setItemName("Melon Seeds").setDecor(true);
    public static final Item seedsPumpkin = new C_f(125, net.minecraft.a.a.b.C_x.pumpkinStem.at).a(174).setItemName("Pumpkin Seeds").setDecor(true);
    public static final Item berry = new C_p(126, 1).a(142).setItemName("Wild Berries").setStackSize(8);
    public static final Item pumpkinPie = new C_p(127, 10).a(205).setItemName("Pumpkin Pastry");
    public static final Item ash = new Item(128).a(237).setItemName("Ashes");
    public static final Item fertilizer = new C_al(129).a(206).setItemName("Fertilizer");
    public static final Item snowball = new C_bl(130, 0).a(233).setItemName("Snowball");
    public static final Item fireBall = new C_bl(133, 1).a(297).setItemName("\u00a7bFireball").setItemDescription("Dropped by Imps", 0);
    public static final Item slimeBall = new C_bd(134).a(265).setItemName("\u00a7aSlimeball");
    public static final Item antlionTusk = new C_bk(135).a(269).setItemName("\u00a7bAntlion Pincer");
    public static final Item antlionExtract = new Item(136).a(270).setItemName("\u00a7dAntlion Extract");
    public static final Item glowDust = new Item(137).a(301).setItemName("\u00a7dGlodust");
    public static final Item bowlGlowSoup = new C_b(138, 10).a(302).setItemName("Gloshroom Stew").setItemDescription("Nightivision 60s", 1);
    public static final Item doorBirch = new C_ah(139, net.minecraft.a.a.b.C_x.doorBirch).a(239).setItemName("Birch Door").setDecor(true);
    public static final Item doorPalm = new C_ah(140, net.minecraft.a.a.b.C_x.doorPalm).a(271).setItemName("Palm Door").setDecor(true);
    public static final Item doorSpruce = new C_ah(141, net.minecraft.a.a.b.C_x.doorSpruce).a(303).setItemName("Pine Door").setDecor(true);
    public static final Item jellyfishTentacle = new Item(142).a(267).setItemName("\u00a7bJellyfish Tentacle");
    public static final Item fishFin = new Item(143).a(202).setItemName("\u00a7bFish Fin");
    public static final Item spearWood = new C_bm(144, 0).a(416).setItemName("Wooden Spear").setItemDescription("Chance to Crit", 2);
    public static final Item spearStone = new C_bm(145, 1).a(417).setItemName("Stone Spear");
    public static final Item spearSteel = new C_bm(146, 2).a(418).setItemName("Iron Spear");
    public static final Item spearGold = new C_bm(147, 0).a(420).setItemName("Golden Spear").setItemDescription("Looting", 3);
    public static final Item spearDiamond = new C_bm(148, 4).a(419).setItemName("\u00a7bDiamond Spear");
    public static final Item spearEmerald = new C_bm(149, 3).a(421).setItemName("\u00a7aEmerald Spear");
    public static final Item harpyFeather = new Item(150).a(203).setItemName("\u00a7bHarpy Feather");
    public static final Item ring = new C_aa(151).a(231).setItemName("\u00a7eHellfire Ring").setItemDescription("Fire Resistance", 1).setItemDescription("Fire Aspect", 2);
    public static final Item aquaCharm = new C_aa(152).a(263).setItemName("\u00a7eTide Amulet").setItemDescription("Water Breathing", 1).setItemDescription("Aqua Affinity", 2);
    public static final Item coin = new C_aa(153).a(295).setItemName("\u00a7eLucky Coin").setItemDescription("Fortune", 1);
    public static final Item shield = new C_aa(154).a(294).setItemName("\u00a7eAdminium Shield").setItemDescription("Blast Immunity", 1).setItemDescription("Arrow Deflect", 2);
    public static final Item bootsHermes = new C_aa(155).a(422).setItemName("\u00a7eSkyrunner Boots").setItemDescription("+25% Speed", 1).setItemDescription("2x Jump Height", 2).setItemDescription("Feather Falling", 3);
    public static final Item spectacles = new C_aa(156).a(423).setItemName("\u00a7eSpectacles").setItemDescription("Nightvision", 1);
    public static final Item rawIron = new C_bk(157).a(424).setItemName("Raw Iron");
    public static final Item rawGold = new C_bk(158).a(425).setItemName("Raw Gold");
    public static final Item rawAdminium = new C_bk(159).a(426).setItemName("\u00a7dRaw Adminium");
    public static final Item tear = new Item(160).a(431).setItemName("\u00a7dBlood Tear").setItemDescription("Dropped by Rana", 0);
    public static final Item pearl = new C_ax(161).a(463).setItemName("\u00a7dBlood Pearl");
    public static final Item minecart = new C_av(165, 0).a(427).setItemName("Minecart");
    public static final Item minecartChest = new C_av(166, 1).a(428).setItemName("Chest Minecart");
    public static final Item minecartFurnace = new C_av(167, 2).a(429).setItemName("Furnace Minecart");
    public static final Item minecartExplosive = new C_av(168, 3).a(430).setItemName("TNT Minecart");
    public static final Item bookAndQuill = new C_v(169).a(234).setItemName("Book and Quill");
    public static final Item writtenBook = new C_br(170).a(235).setItemName("Written Book");
    public static final Item gloves = new C_aa(171).a(451).setItemName("\u00a7eClimbing Gloves").setItemDescription("Wall Climbing", 1).setItemDescription("+3 Unarmed DMG", 2);
    public static final Item mirror = new C_aa(172).a(452).setItemName("\u00a7eMagic Mirror").setItemDescription("Free Respawn", 1);
    public static final Item bracelet = new C_aa(173).a(453).setItemName("\u00a7eBuilder's Bracelet").setItemDescription("+2 Block Reach", 1).setItemDescription("Haste", 2);
    public static final Item doorSteel = new C_ah(174, net.minecraft.a.a.b.C_x.doorSteel).a(384).setItemName("Iron Door").setDecor(true);
    public static final Item quiverAdminium = new C_ba(175).a(386).setItemName("\u00a7dAdminium Quiver").setItemDescription("Infinity", 1);
    public static final Item sandball = new C_bl(176, 2).a(238).setItemName("Sandball");
    public static final Item vial = new C_aa(177).a(387).setItemName("\u00a7ePoison Vial").setItemDescription("Poison Immunity", 1).setItemDescription("Poison Touch", 2);
    public static final Item eye = new Item(178).a(388).setItemName("\u00a7bPoison Gland");
    public static final Item dartShooter = new C_ag(179).a(391).setItemName("\u00a7aDart Shooter");
    public static final Item dart = new Item(180).a(389).setItemName("Dart").setItemDescription("4 DMG", 0);
    public static final Item dartPoison = new Item(181).a(390).setItemName("\u00a7bPoison Dart").setItemDescription("6 DMG", 0).setItemDescription("Poison", 1);
    public static final Item chainmail = new Item(182).a(392).setItemName("Chainmail");
    public static final Item bark = new C_s(183).a(396).setItemName("Bark");
    public static final Item crossbow = new C_af(184).a(454).setItemName("Crossbow");
    public static final Item crossbowLoaded = new C_af(185).a(457).setItemName("Loaded Crossbow");
    public static final Item bucketFish = new C_x(186, net.minecraft.a.a.b.C_x.p.at).a(397).setStackSize(1).setItemName("Fish Bucket");
    public static final Item recordGold = new C_bb(112, "Classic Blues").a(12).setItemName("\u00a7bGolden Record").setItemDescription("Soybean_56", 0);
    public static final Item recordGreen = new C_bb(113, "Spaced Out").a(44).setItemName("\u00a7bGreen Record").setItemDescription("Soybean_56", 0);
    public static final Item recordRed = new C_bb(114, "Eternal Suspense").a(76).setItemName("\u00a7bRed Record").setItemDescription("Soybean_56", 0);
    public static final Item recordBlue = new C_bb(115, "Cobble Man").a(108).setItemName("\u00a7bTeal Record").setItemDescription("Soybean_56", 0);
    public static final Item recordWhite = new C_bb(116, "Queue the Madness").a(204).setItemName("\u00a7bWhite Record").setItemDescription("Soybean_56", 0);
    public static final Item recordPurple = new C_bb(117, "Dreamscape").a(172).setItemName("\u00a7bPurple Record").setItemDescription("Soybean_56", 0);
    public static final Item recordOrange = new C_bb(118, "Indevia").a(268).setItemName("\u00a7bOrange Record").setItemDescription("Soybean_56", 0);
    public static final Item recordAqua = new C_bb(119, "Washed Away").a(140).setItemName("\u00a7bBlue Record").setItemDescription("Soybean_56", 0);
    public static final Item recordBlack = new C_bb(131, "Disc VIII").a(236).setItemName("\u00a7bBlack Record").setItemDescription("RyPieEye", 0);
    public static final Item recordSpecial = new C_bb(132, "Magnetic Circuit").a(300).setItemName("\u00a7bLost Record").setItemDescription("Notch", 0);
    public final int ap;
    protected int aq = 64;
    protected int ar = 32;
    protected int as;
    protected String name = "";
    protected String[] desc = new String[]{"", "", "", ""};
    protected boolean hasSubtypes = false;
    private boolean silkTouch = false;
    protected boolean isDecorationItem = false;
    protected boolean isToolItem = false;
    private boolean looting;

    protected Item(int n) {
        this.ap = n + 256;
        if (b[n + 256] != null) {
            System.out.println("CONFLICT @ " + n + " for item " + b[n + 256] + " when adding " + this);
        }
        Item.b[n + 256] = this;
    }

    public String getItemDescription(ItemStack itemStack, int n) {
        return this.desc[n];
    }

    public int getItemDescriptionLength(ItemStack itemStack) {
        return this.desc.length;
    }

    public String getItemName(ItemStack itemStack) {
        return this.name;
    }

    public String getItemName(int n) {
        return this.name;
    }

    public String getItemName() {
        return this.name;
    }

    public final Item a(int n) {
        this.as = n;
        return this;
    }

    private final Item setDecor(boolean bl) {
        this.isDecorationItem = bl;
        return this;
    }

    private final Item setToolItem(boolean bl) {
        this.isToolItem = bl;
        return this;
    }

    public final boolean getDecor() {
        return this.isDecorationItem;
    }

    public final boolean getTool() {
        return this.isToolItem;
    }

    public Item getItem() {
        return b[this.ap];
    }

    public int getIconFromDamage(int n) {
        return this.as;
    }

    public boolean isToolSilkTouch() {
        return this.silkTouch;
    }

    public boolean isBlockAffectiveAgainst(net.minecraft.a.a.b.C_x c_x) {
        if (this.blocksEffectiveAgainst != null) {
            for (net.minecraft.a.a.b.C_x c_x2 : this.blocksEffectiveAgainst) {
                if (!c_x2.equals(c_x)) continue;
                return true;
            }
        }
        return false;
    }

    public final int getIconIndex(ItemStack itemStack) {
        return this.getIconFromDamage(itemStack.getItemDamage());
    }

    public int getPlacedBlockMetadata(int n) {
        return 0;
    }

    public boolean a(ItemStack itemStack, C_g c_g, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        return false;
    }

    public float getStrVsBlock(net.minecraft.a.a.b.C_x c_x, int n) {
        return 1.0f;
    }

    public ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        return itemStack;
    }

    public final int c() {
        return this.aq;
    }

    public final int d() {
        return this.ar;
    }

    public boolean isDamagable() {
        return false;
    }

    public void hitEntity(EntityPlayer entityPlayer, ItemStack itemStack, C_g c_g) {
    }

    public void onBlockDestroyed(EntityPlayer entityPlayer, ItemStack itemStack, C_g c_g) {
    }

    public boolean throwInFire(C_g c_g, float f, float f2, float f3) {
        return false;
    }

    public int a() {
        return 1;
    }

    public Item setDamageVsEntity(int n) {
        return this;
    }

    public boolean canHarvestBlock(net.minecraft.a.a.b.C_x c_x, int n) {
        return false;
    }

    protected Item setHasSubtypes(boolean bl) {
        this.hasSubtypes = bl;
        return this;
    }

    protected Item setStackSize(int n) {
        this.aq = n;
        return this;
    }

    protected Item setSilkTouch(boolean bl) {
        this.silkTouch = bl;
        return this;
    }

    protected Item setLooting(boolean bl) {
        this.looting = bl;
        return this;
    }

    protected Item setItemName(String string) {
        this.name = string;
        return this;
    }

    protected Item setItemDescription(String string, int n) {
        this.desc[n] = string;
        return this;
    }

    protected Item setMaxDamage(int n) {
        this.ar = n;
        return this;
    }

    public boolean isDamageable() {
        return this.ar > 0 && !this.hasSubtypes;
    }

    public boolean getHasSubtypes() {
        return this.hasSubtypes;
    }

    public int getSubtypes() {
        return 0;
    }

    public int getSpriteNumber() {
        return 1;
    }

    public void b(ItemStack itemStack) {
    }

    public void saddleEntity(ItemStack itemStack, net.minecraft.a.c.C_e c_e, EntityPlayer entityPlayer) {
    }

    public boolean isLooting() {
        return this.looting;
    }

    public void onPlayerStoppedUsing(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer, int n) {
    }

    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 0;
    }

    public C_q getItemUseAction(ItemStack itemStack) {
        return C_q.none;
    }

    public ItemStack onFoodEaten(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        return itemStack;
    }

    public boolean canCompost() {
        return false;
    }

    static {
        StatList.initStats();
    }
}

