/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.a.c.a.C_b;
import net.minecraft.a.c.a.C_c;
import net.minecraft.a.c.a.C_d;
import net.minecraft.a.c.a.C_f;
import net.minecraft.a.c.a.C_g;
import net.minecraft.a.c.a.C_h;
import net.minecraft.a.c.a.C_i;
import net.minecraft.a.c.a.C_j;
import net.minecraft.a.c.a.C_k;
import net.minecraft.a.c.a.C_l;
import net.minecraft.a.c.a.C_m;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.entity.md3.EntityBeastBoy;
import net.minecraft.game.entity.md3.EntityBlackSteve;
import net.minecraft.game.entity.md3.EntityRana;
import net.minecraft.game.entity.md3.EntitySteve;

public class C_aj
extends Item {
    public static final String[] spawnedEntities = new String[]{"Pig", "Sheep", "Cow", "Duck", "Zombie", "Skeleton", "Spider", "Creeper", "Human", "Steve", "Black Steve", "Beast Boy", "Rana", "Fox", "Mummy", "Antlion", "Slime", "Bat", "Jellyfish", "Fish", "Fire Imp", "Harpy", "Mooshroom", "Moobloom", "Slug", "Husk"};

    protected C_aj(int n) {
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
        return 25;
    }

    @Override
    public String getItemName(ItemStack itemStack) {
        return spawnedEntities[itemStack.getItemDamage()] + " Spawn Egg";
    }

    @Override
    public String getItemName(int n) {
        return spawnedEntities[n] + " Spawn Egg";
    }

    @Override
    public final boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, net.minecraft.a.a.World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        if (n4 == 0) {
            --n2;
        }
        if (n4 == 1) {
            ++n2;
        }
        if (n4 == 2) {
            --n3;
        }
        if (n4 == 3) {
            ++n3;
        }
        if (n4 == 4) {
            --n;
        }
        if (n4 == 5) {
            ++n;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            if (c_g.a(n, n2, n3) == 0 || c_g.f(n, n2, n3) == net.minecraft.a.a.d.Material.f) {
                EntityLiving c_e = null;
                float f = 1.0f;
                switch (itemStack.d) {
                    case 0: {
                        c_e = new net.minecraft.a.c.b.C_c(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 1: {
                        c_e = new net.minecraft.a.c.b.C_b(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 2: {
                        c_e = new net.minecraft.a.c.b.C_e(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 3: {
                        c_e = new net.minecraft.a.c.b.C_f(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 4: {
                        c_e = new C_f(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 5: {
                        c_e = new C_c(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 6: {
                        c_e = new C_b(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 7: {
                        c_e = new C_d(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 8: {
                        c_e = new EntityLiving(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 9: {
                        c_e = new EntitySteve(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 10: {
                        c_e = new EntityBlackSteve(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 11: {
                        c_e = new EntityBeastBoy(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 12: {
                        c_e = new EntityRana(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 13: {
                        c_e = new net.minecraft.a.c.b.C_h(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 14: {
                        c_e = new C_k(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 15: {
                        c_e = new C_g(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 16: {
                        c_e = new C_m(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 17: {
                        c_e = new net.minecraft.a.c.b.C_d(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 18: {
                        c_e = new net.minecraft.a.c.b.C_i(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 19: {
                        c_e = new net.minecraft.a.c.b.C_g(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 20: {
                        c_e = new C_j(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 21: {
                        c_e = new C_h(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 22: {
                        c_e = new net.minecraft.a.c.b.C_k(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 23: {
                        c_e = new net.minecraft.a.c.b.C_j(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 24: {
                        c_e = new C_l(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                        break;
                    }
                    case 25: {
                        c_e = new C_i(c_g, (float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f);
                    }
                }
                if (c_e != null && !c_g.multiplayerWorld) {
                    f = c_e.x / 2.0f;
                    if (n5 == Block.fence.at || n5 == Block.fenceGateOak.at) {
                        f = c_e.x / 2.0f + 0.5f;
                    }
                    c_e.b((float)n + 0.5f, (float)n2 + f, (float)n3 + 0.5f, 0.0f, 0.0f);
                    c_g.spawnEntityInWorld(c_e);
                    if (entityPlayer.gamemode != 1) {
                        --itemStack.a;
                    }
                    entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
                }
            }
            return true;
        }
        return false;
    }
}

