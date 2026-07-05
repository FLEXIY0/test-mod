/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_aa;
import net.minecraft.a.a.b.C_ab;
import net.minecraft.a.a.b.C_af;
import net.minecraft.a.a.b.C_ag;
import net.minecraft.a.a.b.C_ah;
import net.minecraft.a.a.b.C_ai;
import net.minecraft.a.a.b.C_aj;
import net.minecraft.a.a.b.C_ak;
import net.minecraft.a.a.b.C_al;
import net.minecraft.a.a.b.C_am;
import net.minecraft.a.a.b.C_an;
import net.minecraft.a.a.b.C_ao;
import net.minecraft.a.a.b.C_ap;
import net.minecraft.a.a.b.C_aq;
import net.minecraft.a.a.b.C_ar;
import net.minecraft.a.a.b.C_as;
import net.minecraft.a.a.b.C_at;
import net.minecraft.a.a.b.C_au;
import net.minecraft.a.a.b.C_av;
import net.minecraft.a.a.b.C_aw;
import net.minecraft.a.a.b.C_ax;
import net.minecraft.a.a.b.C_ay;
import net.minecraft.a.a.b.C_az;
import net.minecraft.a.a.b.C_b;
import net.minecraft.a.a.b.C_ba;
import net.minecraft.a.a.b.C_bb;
import net.minecraft.a.a.b.C_bc;
import net.minecraft.a.a.b.C_bd;
import net.minecraft.a.a.b.C_be;
import net.minecraft.a.a.b.C_bf;
import net.minecraft.a.a.b.C_bg;
import net.minecraft.a.a.b.C_bh;
import net.minecraft.a.a.b.C_bi;
import net.minecraft.a.a.b.C_bj;
import net.minecraft.a.a.b.C_bk;
import net.minecraft.a.a.b.C_bl;
import net.minecraft.a.a.b.C_bm;
import net.minecraft.a.a.b.C_bn;
import net.minecraft.a.a.b.C_bo;
import net.minecraft.a.a.b.C_bp;
import net.minecraft.a.a.b.C_bq;
import net.minecraft.a.a.b.C_br;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.C_bt;
import net.minecraft.a.a.b.C_bv;
import net.minecraft.a.a.b.C_c;
import net.minecraft.a.a.b.C_e;
import net.minecraft.a.a.b.C_h;
import net.minecraft.a.a.b.C_i;
import net.minecraft.a.a.b.C_j;
import net.minecraft.a.a.b.C_l;
import net.minecraft.a.a.b.C_m;
import net.minecraft.a.a.b.C_n;
import net.minecraft.a.a.b.C_o;
import net.minecraft.a.a.b.C_r;
import net.minecraft.a.a.b.C_u;
import net.minecraft.a.a.b.C_w;
import net.minecraft.a.b.C_ad;
import net.minecraft.a.b.C_ae;
import net.minecraft.a.b.C_d;
import net.minecraft.a.b.C_y;
import net.minecraft.a.b.C_z;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.container.BlockBarrel;
import net.minecraft.game.level.block.container.BlockBookshelf;
import net.minecraft.game.level.block.container.BlockChest;
import net.minecraft.game.level.block.container.BlockEndChest;
import net.minecraft.game.level.block.container.BlockFurnace;
import net.minecraft.game.level.block.container.BlockJukeBox;
import net.minecraft.game.level.block.container.BlockSign;
import net.minecraft.game.level.block.container.BlockWorkbench;
import net.minecraft.game.level.block.furniture.BlockBed;
import net.minecraft.game.level.block.furniture.BlockCake;
import net.minecraft.game.level.block.furniture.BlockChair;
import net.minecraft.game.level.block.furniture.BlockDoor;
import net.minecraft.game.level.block.furniture.BlockFence;
import net.minecraft.game.level.block.furniture.BlockFenceGate;
import net.minecraft.game.level.block.furniture.BlockFlowerPot;
import net.minecraft.game.level.block.furniture.BlockLadder;
import net.minecraft.game.level.block.furniture.BlockLantern;
import net.minecraft.game.level.block.furniture.BlockPane;
import net.minecraft.game.level.block.furniture.BlockRod;
import net.minecraft.game.level.block.furniture.BlockRope;
import net.minecraft.game.level.block.furniture.BlockTable;
import net.minecraft.game.level.block.furniture.BlockTorch;
import net.minecraft.game.level.block.furniture.BlockTrapdoor;
import net.minecraft.game.level.block.furniture.BlockWall;
import net.minecraft.game.level.block.machines.BlockDetector;
import net.minecraft.game.level.block.machines.BlockDispenser;
import net.minecraft.game.level.block.machines.BlockFan;
import net.minecraft.game.level.block.machines.BlockGears;
import net.minecraft.game.level.block.machines.BlockGenerator;
import net.minecraft.game.level.block.machines.BlockLamp;
import net.minecraft.game.level.block.machines.BlockNote;
import net.minecraft.game.level.block.machines.BlockObserver;
import net.minecraft.game.level.block.machines.BlockPistonBase;
import net.minecraft.game.level.block.machines.BlockPistonExtension;
import net.minecraft.game.level.block.machines.BlockPistonMoving;
import net.minecraft.game.level.block.machines.BlockPump;
import net.minecraft.game.level.block.machines.BlockTransformer;
import net.minecraft.game.level.block.machines.BlockVacuum;
import net.minecraft.game.level.block.plants.BlockBush;
import net.minecraft.game.level.block.plants.BlockCactus;
import net.minecraft.game.level.block.plants.BlockCoralFan;
import net.minecraft.game.level.block.plants.BlockCrops;
import net.minecraft.game.level.block.plants.BlockFlower;
import net.minecraft.game.level.block.plants.BlockLilyPad;
import net.minecraft.game.level.block.plants.BlockMushroom;
import net.minecraft.game.level.block.plants.BlockPlantern;
import net.minecraft.game.level.block.plants.BlockReeds;
import net.minecraft.game.level.block.plants.BlockSapling;
import net.minecraft.game.level.block.plants.BlockSeaweed;
import net.minecraft.game.level.block.plants.BlockShrub;
import net.minecraft.game.level.block.plants.BlockStem;
import net.minecraft.game.level.block.plants.BlockTallGrass;
import net.minecraft.game.level.block.plants.BlockVine;

public class Block {
    protected static C_n a = new C_n("stone", 1.0f, 1.0f);
    protected static C_n b = new C_n("wood", 1.0f, 1.0f);
    protected static C_n aD = new C_n("gravel", 1.0f, 1.0f);
    protected static C_n aE = new C_n("grass", 1.0f, 1.0f);
    protected static C_n aF = new C_n("stone", 1.0f, 1.0f);
    protected static C_n aG = new C_n("stone", 1.0f, 1.5f);
    protected static C_n aH = new C_j("stone", 1.0f, 1.0f);
    protected static C_n aI = new C_n("cloth", 1.0f, 1.0f);
    protected static C_n aJ = new C_i("sand", 1.0f, 1.0f);
    public static C_n soundSnowFootstep = new C_n("snow", 1.0f, 1.0f);
    protected static C_n soundSlimeFootstep = new C_bv("slime", 1.0f, 1.0f);
    protected static C_n soundBoneFootstep = new C_n("wood", 1.0f, 1.5f);
    public static final Block[] c = new Block[256];
    public static final boolean[] d = new boolean[256];
    public static final boolean[] e = new boolean[256];
    public static final int[] f = new int[256];
    public static final boolean[] hasMetadata = new boolean[256];
    public static final boolean[] g = new boolean[256];
    public static final int[] h = new int[256];
    public static final Block i = new C_r(1, 1).b(1.5f).a(10.0f).setName("Stone").setStepSound(aF);
    public static final C_af j = (C_af)new C_af(2).b(0.6f).setName("Grass").setStepSound(aE);
    public static final Block k = new C_l(3, 2).b(0.5f).setName("Dirt").setStepSound(aD);
    public static final Block l = new C_aq(4, 32).b(2.0f).a(10.0f).setName("Cobblestone").setStepSound(aF);
    public static final Block m = new C_bj(5, 4, net.minecraft.a.a.d.C_c.c).b(2.0f).a(5.0f).setName("Planks").setStepSound(b);
    public static final Block n = new BlockSapling(6, 15).b(0.0f).setName("Sapling").setStepSound(aE);
    public static final Block o = new Block(7, 33, net.minecraft.a.a.d.C_c.d).b(-1.0f).a(6000000.0f).setName("Bedrock").setStepSound(aF);
    public static final Block p = new C_m(8, net.minecraft.a.a.d.C_c.f).b(100.0f).c(3).setName("Water");
    public static final Block q = new C_b(9, net.minecraft.a.a.d.C_c.f).b(100.0f).c(3).setName("Still Water");
    public static final Block r = new C_m(10, net.minecraft.a.a.d.C_c.g).b(0.0f).c(1.0f).c(255).setName("Lava");
    public static final Block s = new C_b(11, net.minecraft.a.a.d.C_c.g).b(100.0f).c(1.0f).c(255).setName("Still Lava");
    public static final Block t = new C_w(12, 34, net.minecraft.a.a.d.C_c.m).b(0.5f).setName("Sand").setStepSound(aJ);
    public static final Block u = new C_e(13, 35).b(0.6f).setName("Gravel").setStepSound(aD);
    public static final Block v = new C_c(14, 64).b(3.0f).a(5.0f).setName("Gold Ore").setStepSound(aF);
    public static final Block w = new C_c(15, 65).b(3.0f).a(5.0f).setName("Iron Ore").setStepSound(aF);
    public static final Block x = new C_c(16, 66).b(3.0f).a(5.0f).setName("Coal Ore").setStepSound(aF);
    public static final Block y = new C_aa(17).b(2.0f).setName("Log").setStepSound(b);
    public static final Block z = new C_o(18, 352).b(0.2f).setGravity(0.3f).c(1).setName("Leaves").setStepSound(aE).setParticleType(true);
    public static final Block A = new C_ag(19).b(0.6f).setName("Sponge").setStepSound(aE);
    public static final Block B = new C_u(20, 97, net.minecraft.a.a.d.C_c.o, false).b(0.3f).setName("Glass").setStepSound(aH).setParticleType(true);
    public static final Block cloth = new C_ao().b(0.8f).setName("Cloth").setStepSound(aI);
    public static final BlockFlower plantYellow = (BlockFlower)new BlockFlower(37, 13).b(0.0f).setName("Dandelion").setStepSound(aE);
    public static final BlockFlower plantRed = (BlockFlower)new BlockFlower(38, 12).b(0.0f).setName("Rose").setStepSound(aE);
    public static final BlockFlower mushroomBrown = (BlockFlower)new BlockMushroom(39, 45).b(0.0f).setName("Brown Mushroom").setStepSound(aE);
    public static final BlockFlower mushroomRed = (BlockFlower)new BlockMushroom(40, 44).b(0.0f).setName("Red Mushroom").setStepSound(aE);
    public static final Block W = new C_bb(41, 71).b(3.0f).a(10.0f).setName("Gold Block").setStepSound(aG);
    public static final Block X = new C_bb(42, 70).b(5.0f).a(10.0f).setName("Iron Block").setStepSound(aG);
    public static final Block Y = new C_aj(43, true, false, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Double Slab").setStepSound(aF);
    public static final Block Z = new C_aj(44, false, false, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Slab").setStepSound(aF);
    public static final Block stairUpsideDown = new C_aj(147, false, true, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Double Slab").setStepSound(aF);
    public static final Block aa = new Block(45, 7, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Bricks").setStepSound(aF);
    public static final Block ab = new C_h(46, 8).b(0.0f).setName("TNT").setStepSound(aE);
    public static final Block ac = new BlockBookshelf(47, 160).b(1.5f).setName("Empty Bookshelf").setStepSound(b);
    public static final Block ad = new Block(48, 68, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Mossy Cobblestone").setStepSound(aF);
    public static final Block ae = new Block(49, 69, net.minecraft.a.a.d.C_c.d).b(10.0f).a(2000.0f).setName("\u00a7dObsidian").setStepSound(aF);
    public static final Block af = new BlockTorch(50, 79).b(0.0f).c(0.875f).setName("Torch").setStepSound(b).disableNeighborNotifyOnMetadataChange().setDecorationStatus(true);
    public static final Block ah = new C_ai(52, Block.p.at).b(0.0f).setName("Water Source").setStepSound(b);
    public static final Block ai = new C_ai(53, Block.r.at).b(0.0f).setName("Lava Source").setStepSound(b);
    public static final Block aj = new BlockChest(54).b(2.5f).setName("Chest").setStepSound(b);
    public static final Block ak = new BlockGears(55, 110).b(0.5f).setName("Cog").setStepSound(aG).setDecorationStatus(true);
    public static final Block al = new C_c(56, 98).b(3.0f).a(5.0f).setName("\u00a7bDiamond Ore").setStepSound(aF);
    public static final Block am = new C_bb(57, 72).b(5.0f).a(10.0f).setName("\u00a7bDiamond Block").setStepSound(aG);
    public static final Block an = new BlockWorkbench(58).b(2.5f).setName("Workbench").setStepSound(b);
    public static final Block ao = new BlockCrops(59, 168).b(0.0f).setName("Crops").setStepSound(aE);
    public static final Block ap = new C_ab(60).b(0.6f).setName("Farmland").setStepSound(aD);
    public static final Block aq = new BlockFurnace(61, false).b(3.5f).setName("Furnace").setStepSound(aF);
    public static final Block ar = new BlockFurnace(62, true).b(3.5f).c(0.875f).setName("Lit Furnace").setStepSound(aF);
    public static final Block blockCoal = new C_bb(21, 3).b(3.0f).a(10.0f).setName("Coal Block").setStepSound(aF);
    public static final Block oreEmerald = new C_c(22, 99).b(3.0f).a(5.0f).setName("\u00a7aEmerald Ore").setStepSound(aF);
    public static final Block blockEmerald = new C_bb(23, 224).b(5.0f).a(10.0f).setName("\u00a7aEmerald Block").setStepSound(aG);
    public static final Block doorOak = new BlockDoor(24, 257, 322, net.minecraft.a.a.d.C_c.c).b(3.0f).setStepSound(b).setName("Oak Door").disableNeighborNotifyOnMetadataChange();
    public static final Block ladder = new BlockLadder(25, 227).b(0.5f).setStepSound(b).setName("Ladder").setDecorationStatus(true);
    public static final BlockFlower plantPurple = (BlockFlower)new BlockFlower(26, 265).b(0.0f).setName("Petunia").setStepSound(aE);
    public static final BlockFlower plantBlue = (BlockFlower)new BlockFlower(27, 495).b(0.0f).setName("Lilac").setStepSound(aE);
    public static final Block barrel = new BlockBarrel(28).b(2.5f).setName("Barrel").setStepSound(b);
    public static final Block reeds = new BlockReeds(29, 552).b(0.0f).setName("Reeds").setStepSound(aE);
    public static final Block clay = new C_an(30, 197).b(0.5f).setName("Clay").setStepSound(aD);
    public static final Block cake = new BlockCake(31, 204).b(0.5f).setStepSound(aI).setName("Apple Pie").setParticleType(true).disableNeighborNotifyOnMetadataChange();
    public static final Block chair = new BlockChair(32, 4, net.minecraft.a.a.d.C_c.c).b(1.5f).a(3.0f).setStepSound(b).setName("Oak Chair").setDecorationStatus(true);
    public static final Block table = new BlockTable(33, 4, net.minecraft.a.a.d.C_c.c).b(1.5f).a(3.0f).setStepSound(b).setName("Table").setDecorationStatus(true);
    public static final Block bed = new BlockBed(63).b(0.5f).setStepSound(b).setName("Bed").setParticleType(true);
    public static final Block fence = new BlockFence(64, 4).b(2.0f).a(5.0f).setStepSound(b).setName("Fence").setDecorationStatus(true);
    public static final Block stairWood = new C_bq(67, m, 4).setName("Oak Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairStone = new C_bq(68, l, 32).setName("Cobblestone Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairBrick = new C_bq(69, aa, 7).setName("Brick Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairMoss = new C_bq(70, ad, 68).setName("Moss Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block fenceGateOak = new BlockFenceGate(71, 4).b(2.0f).a(5.0f).setName("Oak Fence Gate").setStepSound(b).setDecorationStatus(true).disableNeighborNotifyOnMetadataChange();
    public static final Block glassPane = new BlockPane(72, 230, 4, net.minecraft.a.a.d.C_c.o).b(0.3f).setStepSound(aH).setName("Window").setDecorationStatus(true);
    public static final Block trapdoorWood = new BlockTrapdoor(73, 231, net.minecraft.a.a.d.C_c.c).b(2.0f).setStepSound(b).setName("Oak Trapdoor").setDecorationStatus(true);
    public static final Block carpet = new C_am().b(0.5f).setStepSound(aI).setName("Carpet").setDecorationStatus(true);
    public static final Block ash = new C_bs(75, 232, net.minecraft.a.a.d.C_c.ash).b(0.1f).setStepSound(aI).setName("Ash").setDecorationStatus(true);
    public static final Block rope = new BlockRope(77, 233, net.minecraft.a.a.d.C_c.rope).setStepSound(aI).setName("Rope").setDecorationStatus(true);
    public static final Block unlitTorch = new BlockTorch(79, 229).b(0.0f).setName("Unlit Torch").setStepSound(b).disableNeighborNotifyOnMetadataChange().setDecorationStatus(true);
    public static final Block cobweb = new C_ar(80, 11, net.minecraft.a.a.d.C_c.web).b(1.5f).setStepSound(aI).setName("Cobweb").setDecorationStatus(true);
    public static final Block lantern = new BlockLantern(81, 234).b(1.0f).c(1.0f).setStepSound(aG).setName("\u00a7dLantern").setDecorationStatus(true);
    public static final Block flowerPot = new BlockFlowerPot(82, 235).b(0.5f).setStepSound(a).setName("Flower Pot").setDecorationStatus(true);
    public static final Block jukeBox = new BlockJukeBox(83, 262).b(2.0f).a(10.0f).setStepSound(b).setName("\u00a7bJukebox");
    public static final Block pumpkin = new C_aw(84, 238).b(1.0f).setStepSound(b).setName("Pumpkin");
    public static final Block melon = new C_aw(85, 236).b(1.0f).setStepSound(b).setName("Melon");
    public static final Block pumpkinStem = new BlockStem(86, 270, pumpkin).b(0.0f).setName("Pumpkin Stem").setStepSound(aE);
    public static final Block melonStem = new BlockStem(87, 268, melon).b(0.0f).setName("Melon Stem").setStepSound(aE);
    public static final BlockFlower berryBush = (BlockFlower)new BlockBush(88, 267).b(0.0f).setName("Berry Bush").setStepSound(aE);
    public static final Block snowLayer = new C_bs(89, 292, net.minecraft.a.a.d.C_c.snow).b(0.1f).setStepSound(soundSnowFootstep).setName("Snow").setDecorationStatus(true);
    public static final Block snowBlock = new C_bm(90, 292, net.minecraft.a.a.d.C_c.snow).b(0.5f).setStepSound(soundSnowFootstep).setName("Snow Block");
    public static final Block ice = new C_az(91, 293, net.minecraft.a.a.d.C_c.ice).b(0.3f).c(1).setStepSound(aH).setName("Ice");
    public static final Block sandStone = new C_bl(92, 300).b(1.0f).setStepSound(aF).setName("Sandstone");
    public static final Block quickSand = new C_w(93, 303, net.minecraft.a.a.d.C_c.quicksand).b(0.7f).setStepSound(aJ).setName("Quick Sand");
    public static final Block cactus = new BlockCactus(94, 295).b(0.4f).setStepSound(aI).setName("Cactus");
    public static final Block stairSandstone = new C_bq(95, sandStone, 300).setName("Sandstone Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block deadBush = new BlockShrub(96, 298).b(0.0f).setName("Dead Bush").setStepSound(aE);
    public static final Block sandLayer = new C_bs(97, 34, net.minecraft.a.a.d.C_c.m).b(0.1f).setStepSound(aJ).setName("Sand Layer").setDecorationStatus(true);
    public static final Block stairWoodWhite = new C_bq(98, m, 328).setName("Birch Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairWoodCherry = new C_bq(99, m, 360).setName("Palm Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairWoodBlack = new C_bq(100, m, 392).setName("Pine Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block moss = new C_be(101, 330, net.minecraft.a.a.d.C_c.b).b(0.3f).setName("Moss").setStepSound(aE);
    public static final Block vine = new BlockVine(102, 685).b(0.3f).setStepSound(aE).setName("Vine").setDecorationStatus(true);
    public static final BlockFlower mushroomGlowing = (BlockFlower)new BlockMushroom(103, 332).b(0.0f).c(0.7f).setName("\u00a7bGloshroom").setStepSound(aE);
    public static final Block blockAdminium = new C_bb(104, 398).b(3.0f).a(10.0f).setName("\u00a7dAdminium Block").setStepSound(aG);
    public static final Block oreAdminium = new C_c(105, 334).b(3.0f).a(5.0f).setName("\u00a7dAdminium Ore").setStepSound(aF);
    public static final Block stalactite = new C_bn(106, 399, net.minecraft.a.a.d.C_c.d).b(1.5f).setName("Stalactite").setStepSound(aF).setDecorationStatus(true);
    public static final Block slimeBlock = new C_bt(107, 333, net.minecraft.a.a.d.C_c.slime).b(0.5f).setName("\u00a7aSlime Block").setStepSound(soundSlimeFootstep);
    public static final Block coral = new C_at(108, 362, net.minecraft.a.a.d.C_c.c).b(0.5f).setName("Coral").setStepSound(aE);
    public static final Block magma = new C_ba(109, 226, net.minecraft.a.a.d.C_c.magma).b(2.0f).setName("Magma").c(0.5f).setStepSound(aF);
    public static final Block seaweed = new BlockSeaweed(110, 462).c(3).setName("Seaweed").setStepSound(aE).setDecorationStatus(true);
    public static final Block wall = new BlockWall(111, l).setName("Wall").setDecorationStatus(true);
    public static final Block fenceGateBirch = new BlockFenceGate(112, 328).b(2.0f).a(5.0f).setName("Birch Fence Gate").setStepSound(b).setDecorationStatus(true).disableNeighborNotifyOnMetadataChange();
    public static final Block fenceGatePalm = new BlockFenceGate(113, 360).b(2.0f).a(5.0f).setName("Palm Fence Gate").setStepSound(b).setDecorationStatus(true).disableNeighborNotifyOnMetadataChange();
    public static final Block fenceGateSpruce = new BlockFenceGate(114, 392).b(2.0f).a(5.0f).setName("Pine Fence Gate").setStepSound(b).setDecorationStatus(true).disableNeighborNotifyOnMetadataChange();
    public static final Block doorBirch = new BlockDoor(115, 448, 395, net.minecraft.a.a.d.C_c.c).b(3.0f).setStepSound(b).setName("Birch Door").disableNeighborNotifyOnMetadataChange();
    public static final Block doorPalm = new BlockDoor(116, 449, 396, net.minecraft.a.a.d.C_c.c).b(3.0f).setStepSound(b).setName("Palm Door").disableNeighborNotifyOnMetadataChange();
    public static final Block doorSpruce = new BlockDoor(117, 450, 397, net.minecraft.a.a.d.C_c.c).b(3.0f).setStepSound(b).setName("Pine Door").disableNeighborNotifyOnMetadataChange();
    public static final Block stoneBricks = new C_al(118, 394, net.minecraft.a.a.d.C_c.d).b(2.5f).a(10.0f).setName("Stone Bricks").setStepSound(aF);
    public static final Block stairStoneBricks = new C_bq(119, stoneBricks, 394).setName("Stone Brick Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairStoneBricksMossy = new C_bq(120, stoneBricks, 395).setName("Mossy Brick Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block moonRock = new Block(121, 258, net.minecraft.a.a.d.C_c.d).b(1.5f).a(10.0f).setName("Moon Rock").setStepSound(aF);
    public static final C_bh mycelium = (C_bh)new C_bh(122).b(0.6f).setName("Mycelium").setStepSound(aE);
    public static final Block mushroomStem = new C_bg(123).b(1.0f).setName("Mushroom Stem").setStepSound(b);
    public static final Block mushroomCap = new C_bf(124).b(1.0f).setName("Mushroom Cap").setStepSound(b);
    public static final Block log = new C_br(125).b(2.0f).setName("Oak Log").setStepSound(b);
    public static final Block cloudBlock = new C_ap(126, 431, net.minecraft.a.a.d.C_c.cloud).b(0.5f).setName("Cloud Block").setStepSound(aI);
    public static final Block redSand = new C_w(127, 423, net.minecraft.a.a.d.C_c.m).b(0.5f).setName("Red Sand").setStepSound(aJ);
    public static final Block brimStone = new Block(128, 424, net.minecraft.a.a.d.C_c.d).b(1.5f).setName("Basalt").setStepSound(aF);
    public static final Block brimStoneBrick = new Block(129, 454, net.minecraft.a.a.d.C_c.d).b(3.0f).a(10.0f).setName("Basalt Bricks").setStepSound(aF);
    public static final Block stairBlackBricks = new C_bq(130, brimStoneBrick, 454).setName("Basalt Brick Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block stairRedSandstone = new C_bq(131, sandStone, 451).setName("Red Sandstone Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block chairWhite = new BlockChair(132, 328, net.minecraft.a.a.d.C_c.c).b(1.5f).a(3.0f).setStepSound(b).setName("Birch Chair").setDecorationStatus(true);
    public static final Block chairRed = new BlockChair(133, 360, net.minecraft.a.a.d.C_c.c).b(1.5f).a(3.0f).setStepSound(b).setName("Palm Chair").setDecorationStatus(true);
    public static final Block chairBlack = new BlockChair(134, 392, net.minecraft.a.a.d.C_c.c).b(1.5f).a(3.0f).setStepSound(b).setName("Pine Chair").setDecorationStatus(true);
    public static final Block rail = new C_bc(144, 461).setName("Rails").b(0.7f).setStepSound(aG).setDecorationStatus(true);
    public static final Block railBooster = new C_bc(145, 493).setName("Booster Track").b(0.7f).setStepSound(aG).setDecorationStatus(true);
    public static final Block glassStained = new C_bo(146, 527, net.minecraft.a.a.d.C_c.o, false).b(0.3f).setName("Glass").setStepSound(aH);
    public static final Block chest = new BlockEndChest(148).b(2.5f).a(5.0f).setName("\u00a7dAdminium Chest").setStepSound(aF);
    public static final Block moonRockBrick = new C_bd(149, 545, net.minecraft.a.a.d.C_c.d).b(3.0f).a(10.0f).setName("Moon Bricks").setStepSound(aF);
    public static final Block stairMoonBricks = new C_bq(150, moonRockBrick, 545).setName("Moon Brick Stairs").disableNeighborNotifyOnMetadataChange();
    public static final Block hayBlock = new C_ax(151, 546, net.minecraft.a.a.d.C_c.b).b(0.5f).setName("Hay Bale").setStepSound(aE);
    public static final Block lilyPad = new BlockLilyPad(152, 548).b(0.0f).setName("Lily Pad").setStepSound(aE).setDecorationStatus(true);
    public static final Block generator = new BlockGenerator(153, false).b(4.0f).a(10.0f).setName("Generator").setStepSound(aG);
    public static final Block generatorActive = new BlockGenerator(154, true).b(4.0f).a(10.0f).c(0.875f).setName("Active Generator").setStepSound(aG);
    public static final Block pulleyBase = new BlockPistonBase(155, 38, false, false).setName("Iron Piston");
    public static final Block pulleyStickyBase = new BlockPistonBase(156, 576, true, false).setName("Golden Piston");
    public static final BlockPistonExtension pulleyExtension = new BlockPistonExtension(157, 577);
    public static final BlockPistonMoving pulleyMoving = new BlockPistonMoving(158);
    public static final Block fan = new BlockFan(159, 581).setName("Fan").b(2.0f).a(4.0f).setStepSound(aG);
    public static final Block vacuum = new BlockVacuum(160, 585).setName("Collector").b(2.0f).a(4.0f).setStepSound(aG);
    public static final Block pump = new BlockPump(161, 590, net.minecraft.a.a.d.C_c.e).setName("Pump").b(2.0f).a(4.0f).setStepSound(aG);
    public static final Block pillar = new C_bi(162).b(1.5f).setName("Moon Pillar").setStepSound(aF);
    public static final Block concrete = new Block(163, 6, net.minecraft.a.a.d.C_c.d).b(2.0f).a(10.0f).setName("Concrete").setStepSound(aF);
    public static final Block pulleyBaseActive = new BlockPistonBase(164, 38, false, true).setName("Reversed Piston");
    public static final Block pulleyStickyBaseActive = new BlockPistonBase(165, 576, true, true).setName("Reversed Golden Piston");
    public static final Block transformer = new BlockTransformer(166, 615, net.minecraft.a.a.d.C_c.e).setName("Transformer").b(2.0f).a(4.0f).setStepSound(aG);
    public static final Block doorSteel = new BlockDoor(167, 672, 430, net.minecraft.a.a.d.C_c.e).b(5.0f).setStepSound(aG).setName("Iron Door").disableNeighborNotifyOnMetadataChange();
    public static final Block rod = new BlockRod(168, 71, net.minecraft.a.a.d.C_c.e).setName("Lightning Rod").b(1.5f).a(2.0f).setStepSound(aG).setDecorationStatus(true);
    public static final Block trapdoorSteel = new BlockTrapdoor(169, 621, net.minecraft.a.a.d.C_c.e).b(5.0f).setStepSound(aG).setName("Iron Trapdoor").setDecorationStatus(true);
    public static final Block regulator = new BlockTransformer(170, 647, net.minecraft.a.a.d.C_c.e).setName("Regulator").b(2.0f).a(4.0f).setStepSound(aG);
    public static final Block adminiumLamp = new BlockLamp(171, 622, net.minecraft.a.a.d.C_c.o).setName("Lamp").b(0.5f).setStepSound(aH);
    public static final Block adminiumLampLit = new BlockLamp(172, 623, net.minecraft.a.a.d.C_c.o).setName("Lit Lamp").b(0.5f).c(1.0f).setStepSound(aH);
    public static final Block noteBlock = new BlockNote(173).setName("Note Block").b(0.8f).setStepSound(b).disableNeighborNotifyOnMetadataChange();
    public static final Block ironBars = new BlockPane(174, 641, 581, net.minecraft.a.a.d.C_c.e).b(1.5f).setStepSound(aG).setName("Iron Bars").setDecorationStatus(true);
    public static final Block detector = new BlockDetector(175, 642, net.minecraft.a.a.d.C_c.e).b(2.0f).setStepSound(aG).setName("Detector");
    public static final Block leafPile = new C_bs(176, 352, net.minecraft.a.a.d.C_c.h).b(0.1f).setGravity(0.3f).setStepSound(aE).setName("Leaf Pile").setDecorationStatus(true).setParticleType(true);
    public static final Block bone = new C_ak(177).b(0.8f).setName("Bone Block").setStepSound(soundBoneFootstep);
    public static final Block flowerStem = new C_av(178).b(1.0f).setName("Flower Stem").setStepSound(b);
    public static final Block flowerPetal = new C_au(179).b(1.0f).setName("Flower Petal").setStepSound(b);
    public static final Block tallGrass = new BlockTallGrass(180, 681).b(0.0f).setName("Tall Grass").setStepSound(aE);
    public static final Block stairDoubleWood = new C_aj(181, true, false, net.minecraft.a.a.d.C_c.c).b(1.0f).a(5.0f).setName("Double Slab").setStepSound(b);
    public static final Block stairSingleWood = new C_aj(182, false, false, net.minecraft.a.a.d.C_c.c).b(1.0f).a(5.0f).setName("Slab").setStepSound(b);
    public static final Block stairUpsideDownWood = new C_aj(183, false, true, net.minecraft.a.a.d.C_c.c).b(1.0f).a(5.0f).setName("Double Slab").setStepSound(b);
    public static final Block coralFan = new BlockCoralFan(184, 653, net.minecraft.a.a.d.C_c.f).b(0.0f).setName("Coral Fan").setStepSound(aE).c(0.75f).setDecorationStatus(true);
    public static final Block coloredPane = new C_bp(185, 527, net.minecraft.a.a.d.C_c.o, false).b(0.3f).setName("Glass").setStepSound(aH).setDecorationStatus(true);
    public static final Block portal = new C_bk(186, 528).b(-1.0f).a(6000000.0f).setName("Portal").setStepSound(aH).c(0.75f);
    public static final Block packedIce = new Block(187, 704, net.minecraft.a.a.d.C_c.ice).b(0.3f).setStepSound(aH).setName("Packed Ice");
    public static final Block composter = new C_as(188, 705, net.minecraft.a.a.d.C_c.c).b(1.0f).setStepSound(b).setName("Composter");
    public static final Block dispenser = new BlockDispenser(189).b(3.5f).setStepSound(aG).setName("Dispenser");
    public static final Block trapdoorBirch = new BlockTrapdoor(190, 709, net.minecraft.a.a.d.C_c.c).b(2.0f).setStepSound(b).setName("Birch Trapdoor").setDecorationStatus(true);
    public static final Block trapdoorJungle = new BlockTrapdoor(191, 710, net.minecraft.a.a.d.C_c.c).b(2.0f).setStepSound(b).setName("Palm Trapdoor").setDecorationStatus(true);
    public static final Block trapdoorSpruce = new BlockTrapdoor(192, 711, net.minecraft.a.a.d.C_c.c).b(2.0f).setStepSound(b).setName("Pine Trapdoor").setDecorationStatus(true);
    public static final Block torchHell = new BlockTorch(193, 624).b(0.0f).c(0.675f).setName("\u00a7bHellfire Torch").setStepSound(b).disableNeighborNotifyOnMetadataChange().setDecorationStatus(true);
    public static final Block observer = new BlockObserver(194, net.minecraft.a.a.d.C_c.e).b(3.0f).setName("Observer").setStepSound(aG);
    public static final Block plantern = new BlockPlantern(195, 238, net.minecraft.a.a.d.C_c.pumpkin).b(1.0f).setStepSound(b).c(1.0f).setName("\u00a7bJack O' Lantern");
    public static final C_ah ag = (C_ah)new C_ah(51, 47).b(0.0f).c(1.0f).setName("Fire").setStepSound(b).setDecorationStatus(true);
    public static final C_ay hellfire = (C_ay)new C_ay(78, 463).b(0.0f).c(1.0f).setName("Hellfire").setStepSound(b).setDecorationStatus(true);
    public static final Block signStanding = new BlockSign(34, net.minecraft.a.a.b.a.C_l.class, Item.sign.ap, 0, 4).b(1.0f).setStepSound(b).setName("Oak Sign");
    public static final Block signWall = new BlockSign(35, net.minecraft.a.a.b.a.C_l.class, Item.sign.ap, 1, 4).b(1.0f).setStepSound(b).setName("Oak Sign");
    public static final Block signHanging = new BlockSign(76, net.minecraft.a.a.b.a.C_l.class, Item.sign.ap, 2, 4).b(1.0f).setStepSound(b).setName("Oak Sign");
    public static final Block signBirchStanding = new BlockSign(135, net.minecraft.a.a.b.a.C_l.class, Item.signBirch.ap, 0, 328).b(1.0f).setStepSound(b).setName("Birch Sign");
    public static final Block signBirchWall = new BlockSign(136, net.minecraft.a.a.b.a.C_l.class, Item.signBirch.ap, 1, 328).b(1.0f).setStepSound(b).setName("Birch Sign");
    public static final Block signBirchHanging = new BlockSign(137, net.minecraft.a.a.b.a.C_l.class, Item.signBirch.ap, 2, 328).b(1.0f).setStepSound(b).setName("Birch Sign");
    public static final Block signPalmStanding = new BlockSign(138, net.minecraft.a.a.b.a.C_l.class, Item.signPalm.ap, 0, 360).b(1.0f).setStepSound(b).setName("Palm Sign");
    public static final Block signPalmWall = new BlockSign(139, net.minecraft.a.a.b.a.C_l.class, Item.signPalm.ap, 1, 360).b(1.0f).setStepSound(b).setName("Palm Sign");
    public static final Block signPalmHanging = new BlockSign(140, net.minecraft.a.a.b.a.C_l.class, Item.signPalm.ap, 2, 360).b(1.0f).setStepSound(b).setName("Palm Sign");
    public static final Block signDarkStanding = new BlockSign(141, net.minecraft.a.a.b.a.C_l.class, Item.signDark.ap, 0, 392).b(1.0f).setStepSound(b).setName("Pine Sign");
    public static final Block signDarkWall = new BlockSign(142, net.minecraft.a.a.b.a.C_l.class, Item.signDark.ap, 1, 392).b(1.0f).setStepSound(b).setName("Pine Sign");
    public static final Block signDarkHanging = new BlockSign(143, net.minecraft.a.a.b.a.C_l.class, Item.signDark.ap, 2, 392).b(1.0f).setStepSound(b).setName("Pine Sign");
    public int as;
    public final int at;
    public float aL;
    public float aM;
    public float au;
    public float av;
    public float aw;
    public float ax;
    public float ay;
    public float az;
    public C_n aA = a;
    public float aB = 1.0f;
    public net.minecraft.a.a.d.C_c aC;
    protected String name = "";
    public boolean isDecoration = false;
    public boolean simpleParticles = false;
    public boolean hasStates = false;
    protected boolean isBlockContainer;
    private boolean enableStats = true;

    protected Block(int n, net.minecraft.a.a.d.C_c c_c) {
        if (c[n] != null) {
            throw new IllegalArgumentException("Slot " + n + " is already occupied by " + c[n] + " when adding " + this);
        }
        this.aC = c_c;
        Block.c[n] = this;
        this.at = n;
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        Block.e[n] = this.isOpaqueCube(0);
        Block.f[n] = this.isOpaqueCube(0) ? 255 : 0;
        Block.g[n] = false;
    }

    protected Block(int n, int n2, net.minecraft.a.a.d.C_c c_c) {
        this(n, c_c);
        this.as = n2;
    }

    protected final Block c(int n) {
        Block.f[this.at] = n;
        return this;
    }

    protected final Block setGravity(float f) {
        this.aB = f;
        return this;
    }

    protected final Block setDecorationStatus(boolean bl) {
        this.isDecoration = bl;
        return this;
    }

    protected final Block setParticleType(boolean bl) {
        this.simpleParticles = bl;
        return this;
    }

    private Block c(float f) {
        Block.h[this.at] = (int)(15.0f * f);
        return this;
    }

    protected Block disableNeighborNotifyOnMetadataChange() {
        Block.hasMetadata[this.at] = true;
        return this;
    }

    protected final Block a(float f) {
        this.aM = f * 3.0f;
        return this;
    }

    public boolean c() {
        return true;
    }

    public int a() {
        return 0;
    }

    protected final Block b(float f) {
        this.aL = f;
        if (this.aM < f * 5.0f) {
            this.aM = f * 5.0f;
        }
        return this;
    }

    protected final Block setName(String string) {
        this.name = string;
        return this;
    }

    protected final Block setStepSound(C_n c_n) {
        this.aA = c_n;
        return this;
    }

    public C_n getStepSound(int n) {
        return this.aA;
    }

    protected final void a(boolean bl) {
        Block.d[this.at] = bl;
    }

    public int getMobilityFlag() {
        return this.aC.getMaterialMobility();
    }

    public float getHardness() {
        return this.aL;
    }

    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.au = f;
        this.av = f2;
        this.aw = f3;
        this.ax = f4;
        this.ay = f5;
        this.az = f6;
    }

    public float f(World c_g, int n, int n2, int n3) {
        float f = c_g.c(n, n2, n3);
        if (c_g.mc.f.nightVision && (f += 0.7f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        return !c_g.b(n, n2, n3);
    }

    public int a(World c_g, int n, int n2, int n3, int n4) {
        return this.a(n4, c_g.e(n, n2, n3));
    }

    public int a(int n, int n2) {
        return this.a(n);
    }

    public int a(int n) {
        return this.as;
    }

    public net.minecraft.a.d.C_b getSelectedBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return new net.minecraft.a.d.C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + this.ay, (float)n3 + this.az);
    }

    public net.minecraft.a.d.C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return new net.minecraft.a.d.C_b((float)n + this.au, (float)n2 + this.av, (float)n3 + this.aw, (float)n + this.ax, (float)n2 + this.ay, (float)n3 + this.az);
    }

    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
    }

    public boolean isOpaqueCube(int n) {
        return true;
    }

    public boolean canCollideCheck(int n, boolean bl) {
        return this.d();
    }

    public boolean d() {
        return true;
    }

    public void a(World c_g, int n, int n2, int n3, Random random) {
    }

    public void b(World c_g, int n, int n2, int n3, Random random) {
    }

    public void c(World c_g, int n, int n2, int n3, int n4) {
    }

    public void b(World c_g, int n, int n2, int n3, int n4) {
    }

    public int e() {
        return 5;
    }

    public boolean isProvidingStrongPower(World c_g, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean isProvidingWeakPower(World c_g, int n, int n2, int n3, int n4) {
        return false;
    }

    public boolean canProvidePower() {
        return false;
    }

    public String getBlockName(int n) {
        return this.name;
    }

    public String getBlockName() {
        return this.name;
    }

    public int getMaxDamage() {
        return 0;
    }

    public int getMaxMetadata() {
        return this.getMaxDamage();
    }

    public void d(World c_g, int n, int n2, int n3) {
    }

    public void b(World c_g, int n, int n2, int n3) {
    }

    public boolean directSmelt(World c_g, float f, float f2, float f3) {
        return false;
    }

    public int a(Random random) {
        return 1;
    }

    public int a(int n, Random random) {
        return this.at;
    }

    public net.minecraft.a.a.d.C_c getMaterial(int n) {
        return this.aC;
    }

    protected int damageDropped(int n) {
        return 0;
    }

    public final float blockStrength(EntityPlayer entityPlayer, int n) {
        boolean bl;
        if (this.aL < 0.0f) {
            return 0.0f;
        }
        if (!entityPlayer.canHarvestBlock(this, (byte)n)) {
            return 1.0f / this.aL / 100.0f;
        }
        net.minecraft.a.c.e.C_b c_b = entityPlayer.b;
        float f = 1.0f;
        if (c_b.a[c_b.c] != null) {
            f = 1.0f * c_b.a[c_b.c].a().getStrVsBlock(this, n);
        }
        float f2 = f;
        boolean bl2 = bl = entityPlayer.b.charmSlot[0] != null && entityPlayer.b.charmSlot[0].c == Item.aquaCharm.ap;
        if (entityPlayer.m() && !bl) {
            f2 = f / 5.0f;
        }
        if (!entityPlayer.s) {
            f2 /= 5.0f;
        }
        return f2 / this.aL / 30.0f;
    }

    public final float a(EntityPlayer entityPlayer) {
        return this.blockStrength(entityPlayer, 0);
    }

    public void f(World c_g, int n, int n2, int n3, int n4) {
        this.a(c_g, n, n2, n3, n4, 1.0f);
    }

    public void dropBlockAsMultipleItems(World c_g, int n, int n2, int n3, int n4) {
    }

    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        if (!c_g.multiplayerWorld) {
            int n5 = this.a(c_g.q);
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= f) || (n6 = this.a(n4, c_g.q)) <= 0) continue;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                net.minecraft.a.c.c.C_b c_b = new net.minecraft.a.c.c.C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4)));
                new net.minecraft.a.c.c.C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    public void dropBlockAsItemWithChance(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.multiplayerWorld) {
            int n5 = 1;
            for (int i = 0; i < n5; ++i) {
                int n6;
                if (!(c_g.q.nextFloat() <= 1.0f) || (n6 = this.at) <= 0) continue;
                float f = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f2 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f3 = c_g.q.nextFloat() * 0.7f + 0.15f;
                net.minecraft.a.c.c.C_b c_b = new net.minecraft.a.c.c.C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4)));
                new net.minecraft.a.c.c.C_b(c_g, (float)n + f, (float)n2 + f2, (float)n3 + f3, new ItemStack(n6, 1, this.damageDropped(n4))).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
        }
    }

    public final float g() {
        return this.aM / 5.0f;
    }

    public net.minecraft.a.d.C_c a(World c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        c_a = c_a.a(-n, -n2, -n3);
        c_a2 = c_a2.a(-n, -n2, -n3);
        C_a c_a3 = c_a.a(c_a2, this.au);
        C_a c_a4 = c_a.a(c_a2, this.ax);
        C_a c_a5 = c_a.b(c_a2, this.av);
        C_a c_a6 = c_a.b(c_a2, this.ay);
        C_a c_a7 = c_a.c(c_a2, this.aw);
        c_a2 = c_a.c(c_a2, this.az);
        if (!this.a(c_a3)) {
            c_a3 = null;
        }
        if (!this.a(c_a4)) {
            c_a4 = null;
        }
        if (!this.b(c_a5)) {
            c_a5 = null;
        }
        if (!this.b(c_a6)) {
            c_a6 = null;
        }
        if (!this.c(c_a7)) {
            c_a7 = null;
        }
        if (!this.c(c_a2)) {
            c_a2 = null;
        }
        C_a c_a8 = null;
        if (c_a3 != null) {
            c_a8 = c_a3;
        }
        if (c_a4 != null && (c_a8 == null || c_a.b(c_a4) < c_a.b(c_a8))) {
            c_a8 = c_a4;
        }
        if (c_a5 != null && (c_a8 == null || c_a.b(c_a5) < c_a.b(c_a8))) {
            c_a8 = c_a5;
        }
        if (c_a6 != null && (c_a8 == null || c_a.b(c_a6) < c_a.b(c_a8))) {
            c_a8 = c_a6;
        }
        if (c_a7 != null && (c_a8 == null || c_a.b(c_a7) < c_a.b(c_a8))) {
            c_a8 = c_a7;
        }
        if (c_a2 != null && (c_a8 == null || c_a.b(c_a2) < c_a.b(c_a8))) {
            c_a8 = c_a2;
        }
        if (c_a8 == null) {
            return null;
        }
        int n4 = -1;
        if (c_a8 == c_a3) {
            n4 = 4;
        }
        if (c_a8 == c_a4) {
            n4 = 5;
        }
        if (c_a8 == c_a5) {
            n4 = 0;
        }
        if (c_a8 == c_a6) {
            n4 = 1;
        }
        if (c_a8 == c_a7) {
            n4 = 2;
        }
        if (c_a8 == c_a2) {
            n4 = 3;
        }
        return new net.minecraft.a.d.C_c(n, n2, n3, n4, c_a8.a(n, n2, n3));
    }

    private boolean a(C_a c_a) {
        return c_a == null ? false : c_a.b >= this.av && c_a.b <= this.ay && c_a.c >= this.aw && c_a.c <= this.az;
    }

    private boolean b(C_a c_a) {
        return c_a == null ? false : c_a.a >= this.au && c_a.a <= this.ax && c_a.c >= this.aw && c_a.c <= this.az;
    }

    private boolean c(C_a c_a) {
        return c_a == null ? false : c_a.a >= this.au && c_a.a <= this.ax && c_a.b >= this.av && c_a.b <= this.ay;
    }

    public void c(World c_g, int n, int n2, int n3) {
    }

    public int f() {
        return 0;
    }

    public boolean a(World c_g, int n, int n2, int n3) {
        return true;
    }

    public boolean canExist(World c_g, int n, int n2, int n3) {
        return true;
    }

    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        return false;
    }

    public void onBlockClicked(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    public void g(World c_g, int n, int n2, int n3) {
    }

    public void onEntityCollidedWithBlock(World c_g, int n, int n2, int n3) {
    }

    public void g(World c_g, int n, int n2, int n3, int n4) {
    }

    public void onBlockPlacedByPlayer(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        entityPlayer.addStat(StatList.objectUseStats[this.at], 1);
        entityPlayer.addStat(StatList.blocksPlacedStat, 1);
    }

    public void breakBlock(World c_g, int n, int n2, int n3, int n4, int n5) {
    }

    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return true;
    }

    public void getCollidingBoundingBoxes(World c_g, int n, int n2, int n3, net.minecraft.a.d.C_b c_b, ArrayList<net.minecraft.a.d.C_b> arrayList) {
        net.minecraft.a.d.C_b c_b2 = this.getCollisionBoundingBoxFromPool(c_g, n, n2, n3);
        if (c_b2 != null && c_b.a(c_b2)) {
            arrayList.add(c_b2);
        }
    }

    public void setBlockBoundsForItemRender(int n) {
    }

    public boolean getIsBlockSolid(World c_g, int n, int n2, int n3, int n4) {
        return !c_g.b(n, n2, n3);
    }

    public void powerBlock(World c_g, int n, int n2, int n3, int n4, int n5) {
    }

    public void playBlock(World c_g, int n, int n2, int n3, int n4, int n5) {
    }

    public boolean hasTileEntity() {
        return this.isBlockContainer;
    }

    public boolean getEnableStats() {
        return this.enableStats;
    }

    protected Block disableStats() {
        this.enableStats = false;
        return this;
    }

    public boolean canBeDuped() {
        return this.at == Block.brimStone.at;
    }

    public boolean tryToCreatePortal(World c_g, int n, int n2, int n3) {
        return false;
    }

    public boolean canCompost() {
        return false;
    }

    static {
        Item.b[Block.cloth.at] = new net.minecraft.a.b.C_ab(Block.cloth.at - 256);
        Item.b[Block.Z.at] = new net.minecraft.a.b.C_bi(Block.Z.at - 256);
        Item.b[Block.stairSingleWood.at] = new net.minecraft.a.b.C_bj(Block.stairSingleWood.at - 256);
        Item.b[Block.n.at] = new net.minecraft.a.b.C_bg(Block.n.at - 256);
        Item.b[Block.z.at] = new net.minecraft.a.b.C_as(Block.z.at - 256);
        Item.b[Block.y.at] = new net.minecraft.a.b.C_au(Block.y.at - 256);
        Item.b[Block.log.at] = new net.minecraft.a.b.C_bo(Block.log.at - 256);
        Item.b[Block.m.at] = new net.minecraft.a.b.C_az(Block.m.at - 256);
        Item.b[Block.mushroomCap.at] = new net.minecraft.a.b.C_aw(Block.mushroomCap.at - 256);
        Item.b[Block.flowerPetal.at] = new net.minecraft.a.b.C_an(Block.flowerPetal.at - 256);
        Item.b[Block.carpet.at] = new C_z(Block.carpet.at - 256);
        Item.b[Block.berryBush.at] = new C_y(Block.berryBush.at - 256);
        Item.b[Block.coral.at] = new C_ad(Block.coral.at - 256);
        Item.b[Block.coralFan.at] = new C_ae(Block.coralFan.at - 256);
        Item.b[Block.fence.at] = new net.minecraft.a.b.C_ak(Block.fence.at - 256);
        Item.b[Block.wall.at] = new net.minecraft.a.b.C_bq(Block.wall.at - 256);
        Item.b[Block.table.at] = new net.minecraft.a.b.C_bp(Block.table.at - 256);
        Item.b[Block.stoneBricks.at] = new net.minecraft.a.b.C_w(Block.stoneBricks.at - 256);
        Item.b[Block.j.at] = new net.minecraft.a.b.C_ar(Block.j.at - 256);
        Item.b[Block.sandStone.at] = new net.minecraft.a.b.C_bf(Block.sandStone.at - 256);
        Item.b[Block.glassStained.at] = new net.minecraft.a.b.C_aq(Block.glassStained.at - 256);
        Item.b[Block.coloredPane.at] = new net.minecraft.a.b.C_aq(Block.coloredPane.at - 256);
        Item.b[Block.lilyPad.at] = new net.minecraft.a.b.C_at(Block.lilyPad.at - 256);
        Item.b[Block.pulleyBase.at] = new net.minecraft.a.b.C_ay(Block.pulleyBase.at - 256);
        Item.b[Block.pulleyStickyBase.at] = new net.minecraft.a.b.C_ay(Block.pulleyStickyBase.at - 256);
        for (int i = 0; i < 256; ++i) {
            if (c[i] == null || Item.b[i] != null) continue;
            Item.b[i] = new C_d(i - 256);
        }
        StatList.initBreakableStats();
    }
}

