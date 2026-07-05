/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class BlockFlowerPot
extends Block {
    public BlockFlowerPot(int n, int n2) {
        super(n, n2, C_c.n);
        this.setBlockBoundsForItemRender();
    }

    public void setBlockBoundsForItemRender() {
        float f = 0.375f;
        float f2 = f / 2.0f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f, 0.5f + f2);
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public int a() {
        return 30;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean getEnableStats() {
        return false;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.b.d();
        if (itemStack == null) {
            if (c_g.e(n, n2, n3) != 0) {
                ItemStack itemStack2 = BlockFlowerPot.getPlantForMeta(c_g.e(n, n2, n3));
                if (itemStack2 != null) {
                    this.dropBlockAsItem_do(c_g, n, n2, n3, itemStack2);
                }
                c_g.setBlockMetadata(n, n2, n3, 0);
                return true;
            }
            return false;
        }
        if (c_g.e(n, n2, n3) != 0) {
            ItemStack itemStack3 = BlockFlowerPot.getPlantForMeta(c_g.e(n, n2, n3));
            if (itemStack3 != null) {
                this.dropBlockAsItem_do(c_g, n, n2, n3, itemStack3);
            }
            c_g.setBlockMetadata(n, n2, n3, 0);
            return true;
        }
        int n4 = BlockFlowerPot.getMetaForPlant(itemStack);
        if (n4 > 0) {
            c_g.setBlockMetadataWithNotify(n, n2, n3, n4);
            if (entityPlayer.gamemode != 1 && --itemStack.a <= 0) {
                entityPlayer.b.a(entityPlayer.b.c, null);
            }
            entityPlayer.addStat(StatList.potUse, 1);
            return true;
        }
        return false;
    }

    public int idPicked(World c_g, int n, int n2, int n3) {
        ItemStack itemStack = BlockFlowerPot.getPlantForMeta(c_g.e(n, n2, n3));
        return itemStack == null ? Item.flowerPot.ap : itemStack.c;
    }

    @Override
    public int a(Random random) {
        return 1;
    }

    @Override
    public int a(int n, Random random) {
        return Item.flowerPot.ap;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2, n3) == 0 && (c_g.a((float)n, (float)(n2 - 1), (float)n3) || c_g.a(n, n2 - 1, n3) == Block.table.at);
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.b(n, n2 - 1, n3) && c_g.a(n, n2 - 1, n3) != Block.table.at) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public void a(World c_g, int n, int n2, int n3, int n4, float f) {
        ItemStack itemStack;
        super.a(c_g, n, n2, n3, n4, f);
        if (!c_g.multiplayerWorld && n4 > 0 && (itemStack = BlockFlowerPot.getPlantForMeta(n4)) != null) {
            this.dropBlockAsItem_do(c_g, n, n2, n3, itemStack);
        }
    }

    protected void dropBlockAsItem_do(World c_g, int n, int n2, int n3, ItemStack itemStack) {
        if (c_g.multiplayerWorld) {
            return;
        }
        float f = 0.7f;
        float f2 = c_g.q.nextFloat() * f + (1.0f - f) * 0.5f;
        float f3 = c_g.q.nextFloat() * f + (1.0f - f) * 0.5f;
        float f4 = c_g.q.nextFloat() * f + (1.0f - f) * 0.5f;
        C_b c_b = new C_b(c_g, (float)n + f2, (float)n2 + f3, (float)n3 + f4, itemStack);
        c_b.O = 10;
        c_g.spawnEntityInWorld(c_b);
    }

    public int idDropped(int n, Random random, int n2) {
        return Item.flowerPot.ap;
    }

    public static ItemStack getPlantForMeta(int n) {
        switch (n) {
            case 1: {
                return new ItemStack(Block.plantRed);
            }
            case 2: {
                return new ItemStack(Block.plantYellow);
            }
            case 3: {
                return new ItemStack(Block.n, 1, 0);
            }
            case 4: {
                return new ItemStack(Block.n, 1, 1);
            }
            case 5: {
                return new ItemStack(Block.plantBlue);
            }
            case 6: {
                return new ItemStack(Block.plantPurple);
            }
            case 7: {
                return new ItemStack(Block.mushroomRed);
            }
            case 8: {
                return new ItemStack(Block.mushroomBrown);
            }
            case 9: {
                return new ItemStack(Block.berryBush, 1, 0);
            }
            case 10: {
                return new ItemStack(Block.berryBush, 1, 1);
            }
            case 11: {
                return new ItemStack(Block.n, 1, 2);
            }
            case 12: {
                return new ItemStack(Block.n, 1, 3);
            }
            case 13: {
                return new ItemStack(Block.n, 1, 4);
            }
            case 14: {
                return new ItemStack(Block.cactus);
            }
            case 15: {
                return new ItemStack(Block.mushroomGlowing);
            }
        }
        return null;
    }

    public static int getMetaForPlant(ItemStack itemStack) {
        int n = itemStack.a().ap;
        if (n == Block.plantRed.at) {
            return 1;
        }
        if (n == Block.plantYellow.at) {
            return 2;
        }
        if (n == Block.plantBlue.at) {
            return 5;
        }
        if (n == Block.plantPurple.at) {
            return 6;
        }
        if (n == Block.mushroomBrown.at) {
            return 8;
        }
        if (n == Block.mushroomRed.at) {
            return 7;
        }
        if (n == Block.cactus.at) {
            return 14;
        }
        if (n == Block.mushroomGlowing.at) {
            return 15;
        }
        if (n == Block.n.at) {
            switch (itemStack.getItemDamage()) {
                case 0: {
                    return 3;
                }
                case 1: {
                    return 4;
                }
                case 2: {
                    return 11;
                }
                case 3: {
                    return 12;
                }
                case 4: {
                    return 13;
                }
            }
        }
        if (n == Block.berryBush.at) {
            switch (itemStack.getItemDamage()) {
                case 0: {
                    return 9;
                }
                case 1: {
                    return 10;
                }
            }
        }
        return 0;
    }
}

