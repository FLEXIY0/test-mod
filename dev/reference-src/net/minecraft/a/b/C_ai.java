/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_ao;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.C_e;
import net.minecraft.a.c.b.C_b;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_ai
extends Item {
    public static final String[] dyeColors = new String[]{"Red ", "Orange ", "Yellow ", "Chartreuse ", "Green ", "Spring Green ", "Cyan ", "Capri ", "Ultramarine ", "Violet ", "Purple ", "Magenta ", "Rose ", "Dark Gray ", "Light Gray ", "White "};
    public static final int[] colorCodes = new int[]{0x1E1B1B, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 0x434343, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 0xF0F0F0};

    public C_ai(int n) {
        super(n);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public int getIconFromDamage(int n) {
        return this.as + n;
    }

    @Override
    public int getSubtypes() {
        return 15;
    }

    @Override
    public String getItemName(ItemStack itemStack) {
        if (itemStack.getItemDamage() == 15) {
            return "Bone Meal";
        }
        return dyeColors[itemStack.getItemDamage()] + super.getItemName(itemStack);
    }

    @Override
    public String getItemName(int n) {
        if (n == 15) {
            return "Bone Meal";
        }
        return dyeColors[n] + super.getItemName();
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (n5 == Block.cloth.at && c_g.e(n, n2, n3) != 15 - itemStack.getItemDamage() && !c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, 15 - itemStack.getItemDamage());
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        if (n5 == Block.carpet.at && c_g.e(n, n2, n3) != 15 - itemStack.getItemDamage() && !c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, 15 - itemStack.getItemDamage());
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        if (n5 == Block.glassStained.at && c_g.e(n, n2, n3) != 15 - itemStack.getItemDamage() && !c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, 15 - itemStack.getItemDamage());
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        if (n5 == Block.B.at && !c_g.multiplayerWorld) {
            c_g.setBlockAndMetadata(n, n2, n3, Block.glassStained.at, 15 - itemStack.getItemDamage());
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        if (n5 == Block.coloredPane.at && c_g.e(n, n2, n3) != itemStack.getItemDamage() && !c_g.multiplayerWorld) {
            c_g.setBlockMetadata(n, n2, n3, itemStack.getItemDamage());
            if (entityPlayer.gamemode != 1) {
                --itemStack.a;
            }
            entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
            return true;
        }
        return false;
    }

    @Override
    public void saddleEntity(ItemStack itemStack, C_e c_e, EntityPlayer entityPlayer) {
        if (c_e instanceof C_b) {
            C_b c_b = (C_b)c_e;
            int n = C_ao.getClothColor(itemStack.getItemDamage());
            if (!c_b.getSheared() && c_b.getFleeceColor() != n) {
                c_b.setFleeceColor(n);
                --itemStack.a;
            }
        }
    }
}

