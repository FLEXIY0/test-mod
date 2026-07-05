/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.c.C_b;
import net.minecraft.a.a.c.C_c;
import net.minecraft.a.a.c.C_d;
import net.minecraft.a.a.c.C_e;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.plants.BlockCrops;
import net.minecraft.game.level.block.plants.BlockMushroom;
import net.minecraft.game.level.block.plants.BlockStem;

public class C_al
extends Item {
    private Random itemRand = new Random();

    protected C_al(int n) {
        super(n);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, C_g c_g, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        int n8 = c_g.a(n, n2, n3);
        C_x c_x = C_x.c[n8];
        boolean bl = false;
        if (n8 == C_x.k.at && !c_g.a((float)n, (float)(n2 + 1), (float)n3)) {
            if (c_g.theme == 4) {
                c_g.a(n, n2, n3, C_x.mycelium.at);
            } else {
                c_g.a(n, n2, n3, C_x.j.at);
            }
            if (c_g.type == 8) {
                entityPlayer.triggerAchievement(AchievementList.moonTerraform);
            }
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            bl = true;
        }
        if (n8 == C_x.n.at) {
            n7 = c_g.e(n, n2, n3);
            if (!c_g.multiplayerWorld) {
                C_b c_b;
                c_g.d(n, n2, n3, 0);
                if (n7 == 3) {
                    c_g.growPalmTree(n, n2, n3);
                } else if (n7 == 4) {
                    c_b = new C_d();
                    C_e c_e = new C_e();
                    if (a.nextBoolean()) {
                        ((C_d)c_b).generate(c_g, a, n, n2, n3);
                    } else {
                        c_e.generate(c_g, a, n, n2, n3);
                    }
                } else if (n7 == 1) {
                    c_b = new C_c(false);
                    ((C_c)c_b).setScale(0.3, 1.0, 0.3);
                    ((C_c)c_b).metadata = 1;
                    ((C_c)c_b).leafDistanceLimit = 5;
                    ((C_c)c_b).generate(c_g, c_g.q, n, n2, n3);
                } else {
                    c_g.growTree(n, n2, n3, n7);
                }
                if (c_g.cantGrow) {
                    c_g.d(n, n2, n3, C_x.n.at);
                } else if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
            }
            entityPlayer.addStat(StatList.treeGrowth, 1);
            bl = true;
        }
        if (c_x instanceof BlockMushroom) {
            if (!c_g.multiplayerWorld) {
                c_g.d(n, n2, n3, 0);
                n7 = 0;
                switch (c_x.at) {
                    case 40: {
                        n7 = 1;
                        break;
                    }
                    case 103: {
                        n7 = 2;
                        break;
                    }
                    default: {
                        n7 = 0;
                    }
                }
                c_g.growLargeMushroom(n, n2, n3, n7);
                if (c_g.cantGrow) {
                    c_g.d(n, n2, n3, c_x.at);
                } else {
                    if (entityPlayer.gamemode != 1) {
                        --itemStack.a;
                    }
                    if (c_g.theme != 4) {
                        entityPlayer.triggerAchievement(AchievementList.fungus);
                    }
                }
            }
            entityPlayer.addStat(StatList.mushroomGrowth, 1);
            bl = true;
        }
        if (c_x == C_x.plantRed || c_x == C_x.plantBlue || c_x == C_x.plantYellow || c_x == C_x.plantPurple) {
            if (!c_g.multiplayerWorld) {
                c_g.d(n, n2, n3, 0);
                switch (c_x.at) {
                    case 37: {
                        c_g.genBigFlowerFeature2(6, false, c_g, a, n, n2, n3);
                        break;
                    }
                    case 38: {
                        c_g.genBigFlowerFeature1(6, false, c_g, a, n, n2, n3);
                        break;
                    }
                    case 26: {
                        c_g.genBigFlowerFeature4(6, false, c_g, a, n, n2, n3);
                        break;
                    }
                    default: {
                        c_g.genBigFlowerFeature3(6, false, c_g, a, n, n2, n3);
                    }
                }
                if (c_g.cantGrow) {
                    c_g.d(n, n2, n3, c_x.at);
                } else if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
            }
            entityPlayer.addStat(StatList.flowerGrowth, 1);
            bl = true;
        }
        if (n8 == C_x.ao.at) {
            if (!c_g.multiplayerWorld) {
                ((BlockCrops)C_x.ao).fertilize(c_g, n, n2, n3);
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
            }
            bl = true;
        }
        if (n8 == C_x.pumpkinStem.at) {
            if (!c_g.multiplayerWorld) {
                ((BlockStem)C_x.pumpkinStem).fertilize(c_g, n, n2, n3);
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
            }
            bl = true;
        }
        if (n8 == C_x.melonStem.at) {
            if (!c_g.multiplayerWorld) {
                ((BlockStem)C_x.melonStem).fertilize(c_g, n, n2, n3);
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
            }
            bl = true;
        }
        if (n8 == C_x.j.at) {
            if (!c_g.multiplayerWorld) {
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
                block9: for (n7 = 0; n7 < 128; ++n7) {
                    int n9 = n;
                    int n10 = n2 + 1;
                    n6 = n3;
                    for (n5 = 0; n5 < n7 / 16; ++n5) {
                        if (c_g.a(n9 += this.itemRand.nextInt(3) - 1, (n10 += (this.itemRand.nextInt(3) - 1) * this.itemRand.nextInt(3) / 2) - 1, n6 += this.itemRand.nextInt(3) - 1) != C_x.j.at || c_g.b(n9, n10, n6)) continue block9;
                    }
                    if (c_g.a(n9, n10, n6) == 0) {
                        if (this.itemRand.nextInt(3) == 0) {
                            c_g.b(n9, n10, n6, C_x.tallGrass.at);
                        } else if (this.itemRand.nextInt(3) == 0) {
                            c_g.b(n9, n10, n6, C_x.plantYellow.at);
                        } else if (this.itemRand.nextInt(3) == 0) {
                            c_g.b(n9, n10, n6, C_x.plantRed.at);
                        } else if (this.itemRand.nextInt(3) == 0) {
                            c_g.b(n9, n10, n6, C_x.plantPurple.at);
                        } else if (this.itemRand.nextInt(3) == 0) {
                            c_g.b(n9, n10, n6, C_x.plantBlue.at);
                        } else if (this.itemRand.nextInt(6) == 0) {
                            c_g.setBlockAndMetadataWithNotify(n9, n10, n6, C_x.n.at, this.itemRand.nextInt(2));
                        } else if (this.itemRand.nextInt(6) == 0 && c_g.season.currentSeason == 3) {
                            c_g.setBlockAndMetadataWithNotify(n9, n10, n6, C_x.berryBush.at, 1);
                        }
                    }
                    if (!C_x.reeds.canBlockStay(c_g, n9, n10, n6)) continue;
                    c_g.a(n9, n10, n6, C_x.reeds.at);
                }
            }
            bl = true;
        }
        if (n8 == C_x.mycelium.at) {
            if (!c_g.multiplayerWorld) {
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
                block11: for (n7 = 0; n7 < 128; ++n7) {
                    int n11 = n;
                    int n12 = n2 + 1;
                    n6 = n3;
                    for (n5 = 0; n5 < n7 / 16; ++n5) {
                        if (c_g.a(n11 += this.itemRand.nextInt(3) - 1, (n12 += (this.itemRand.nextInt(3) - 1) * this.itemRand.nextInt(3) / 2) - 1, n6 += this.itemRand.nextInt(3) - 1) != C_x.mycelium.at || c_g.b(n11, n12, n6)) continue block11;
                    }
                    if (c_g.a(n11, n12, n6) != 0) continue;
                    if (this.itemRand.nextInt(3) == 0) {
                        c_g.b(n11, n12, n6, C_x.mushroomBrown.at);
                        continue;
                    }
                    if (this.itemRand.nextInt(3) == 0) {
                        c_g.b(n11, n12, n6, C_x.mushroomRed.at);
                        continue;
                    }
                    if (this.itemRand.nextInt(3) != 0) continue;
                    c_g.b(n11, n12, n6, C_x.mushroomGlowing.at);
                }
            }
            bl = true;
        }
        if (bl) {
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            entityPlayer.triggerAchievement(AchievementList.fertilize);
        }
        return bl;
    }
}

