/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.dx;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_f;
import net.minecraft.client.d;
import net.minecraft.client.dx.C_b;
import net.minecraft.client.dx.C_c;
import net.minecraft.client.dx.C_e;
import net.minecraft.client.statistics.AchievementList;
import net.minecraft.client.statistics.StatBase;
import net.minecraft.client.statistics.StatList;

public class C_a {
    protected final d a;
    public boolean b = false;

    public C_a(d d2) {
        this.a = d2;
    }

    public void a(World c_g) {
    }

    public void clickBlock(int n, int n2, int n3, int n4) {
        this.sendBlockRemoved(n, n2, n3, n4);
    }

    public GuiScreen displayInventory() {
        return new C_f(this.a.f);
    }

    public boolean sendBlockRemoved(int n, int n2, int n3, int n4) {
        Object object;
        this.a.g.a(n, n2, n3);
        World c_g = this.a.d;
        Block c_x = Block.c[c_g.a(n, n2, n3)];
        byte by = c_g.e(n, n2, n3);
        if (c_x != null) {
            StatBase statBase;
            if (this.a.f.gamemode != 1) {
                c_x.dropBlockAsMultipleItems(c_g, n, n2, n3, by);
            }
            this.a.f.addStat(StatList.mineBlockStatArray[c_x.at], 1);
            this.a.f.addStat(StatList.blocksBrokenStat, 1);
            if (c_x.at == Block.i.at && (Integer)(object = Integer.valueOf(d.getMinecraft().statFileWriter.getStatCount(statBase = StatList.mineBlockStatArray[c_x.at]))) >= 3456) {
                this.a.f.triggerAchievement(AchievementList.cobblestone);
            }
        }
        boolean bl = c_g.b(n, n2, n3, 0);
        if (c_x != null && bl) {
            object = this.a.x;
            String string = c_x.getStepSound(by).a();
            float f = (float)n + 0.5f;
            float f2 = (float)n2 + 0.5f;
            float f3 = (float)n3 + 0.5f;
            float f4 = (c_x.getStepSound((int)by).a + 1.0f) / 2.0f;
            ((net.minecraft.client.e.C_c)object).playBlockSound(string, f, f2, f3, f4, c_x.getStepSound((int)by).b * 0.8f);
            if (this.a.f.gamemode != 2) {
                c_x.c(c_g, n, n2, n3, by);
            }
        }
        return bl;
    }

    public void a(int n, int n2, int n3, int n4) {
    }

    public void a() {
    }

    public void a(float f) {
    }

    public float b() {
        return 5.0f;
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public void a(EntityPlayer entityPlayer) {
    }

    public ItemStack clickSlot(int n, int n2, int n3, boolean bl, EntityPlayer entityPlayer) {
        return entityPlayer.craftingInventory.clickSlot(n2, n3, bl, entityPlayer);
    }

    public ItemStack updateWindow(int n, int n2, int n3, boolean bl, EntityPlayer entityPlayer) {
        return entityPlayer.craftingInventory.updateWindow(n2, n3, bl, entityPlayer);
    }

    public void closeInventory(int n, EntityPlayer entityPlayer) {
        entityPlayer.craftingInventory.onCraftGuiClosed(entityPlayer);
        entityPlayer.craftingInventory = entityPlayer.inventorySlots;
    }

    public void copyStack(ItemStack itemStack, int n) {
    }

    public void dupeStack(ItemStack itemStack) {
    }

    public static C_a get(d d2, int n) {
        switch (n) {
            case 0: {
                return new C_b(d2);
            }
            case 1: {
                return new C_c(d2);
            }
            case 2: {
                return new C_e(d2);
            }
        }
        return null;
    }

    public boolean sendPlaceBlock(EntityPlayer entityPlayer, World c_g, ItemStack itemStack, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (!c_g.multiplayerWorld) {
            return itemStack == null ? false : itemStack.useItem(entityPlayer, c_g, n, n2, n3, n4);
        }
        return n5 > 0 && Block.c[n5].a(c_g, n, n2, n3, entityPlayer) ? true : (itemStack == null ? false : itemStack.useItem(entityPlayer, c_g, n, n2, n3, n4));
    }

    public EntityPlayer createPlayer(World c_g) {
        return new net.minecraft.client.g.C_a(this.a, c_g, this.a.h);
    }

    public void interactWithEntity(EntityPlayer entityPlayer, net.minecraft.a.c.C_b c_b) {
        entityPlayer.useCurrentItemOnEntity(c_b);
    }

    public void attackEntity(EntityPlayer entityPlayer, net.minecraft.a.c.C_b c_b, float f) {
        entityPlayer.attackTargetEntityWithCurrentItem(c_b, f);
    }

    public void attackEntityUnarmed(EntityPlayer entityPlayer, net.minecraft.a.c.C_b c_b, float f) {
        entityPlayer.attackTargetEntityWithCharm(c_b, f);
    }

    public boolean sendUseItem(EntityPlayer entityPlayer, World c_g, ItemStack itemStack) {
        if (this.a.v != null && this.a.v.g != null && this.a.v.g instanceof net.minecraft.a.c.c.C_e) {
            return false;
        }
        int n = itemStack.a;
        ItemStack itemStack2 = itemStack.useItemRightClick(c_g, entityPlayer);
        if (itemStack2 != itemStack || itemStack2 != null && itemStack2.a != n) {
            entityPlayer.b.a[entityPlayer.b.c] = itemStack2;
            if (itemStack2.a <= 0) {
                entityPlayer.b.a[entityPlayer.b.c] = null;
            }
            return true;
        }
        return false;
    }

    public void onStoppedUsingItem(EntityPlayer entityPlayer) {
        entityPlayer.stopUsingItem();
    }

    public void useSpecial(EntityPlayer entityPlayer, World c_g, ItemStack itemStack) {
    }
}

