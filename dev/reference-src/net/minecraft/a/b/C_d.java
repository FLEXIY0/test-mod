/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.C_aj;
import net.minecraft.a.a.b.C_bc;
import net.minecraft.a.a.b.C_bn;
import net.minecraft.a.a.b.C_bs;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.client.d;
import net.minecraft.client.statistics.AchievementList;

public class C_d
extends Item {
    public int as;

    public C_d(int n) {
        super(n);
        this.as = n + 256;
        this.a(Block.c[n + 256].a(2));
    }

    @Override
    public boolean canCompost() {
        return Block.c[this.as].canCompost();
    }

    @Override
    public String getItemName(ItemStack itemStack) {
        return Block.c[this.as].getBlockName(itemStack.getItemDamage());
    }

    @Override
    public String getItemName(int n) {
        return Block.c[this.as].getBlockName(n);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World c_g, int n, int n2, int n3, int n4) {
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
        if (itemStack.a == 0) {
            return false;
        }
        if (n > 0 && n2 > 0 && n3 > 0 && n < c_g.a - 1 && n2 < c_g.c - 1 && n3 < c_g.b - 1) {
            C_b c_b;
            int n5 = c_g.a(n, n2, n3);
            int n6 = c_g.a(n, n2 - 1, n3);
            Block c_x = Block.c[n5];
            Block c_x2 = Block.c[n6];
            int n7 = n2;
            int n8 = 0;
            for (int i = n2; i > 0; --i) {
                if (c_g.a(n, i + 1, n3) != Block.rope.at || c_g.a(n, i, n3) != 0) continue;
                n8 = i;
            }
            if (n5 == Block.rope.at && this.as == Block.rope.at) {
                if (entityPlayer.gamemode != 1 && c_g.a(n, n8, n3) == 0 && n8 != 0) {
                    --itemStack.a;
                }
                c_g.a(n, n8, n3, Block.rope.at);
            }
            if (c_x2 instanceof C_bs && n4 == 1 && itemStack.c != Block.snowLayer.at && itemStack.c != Block.ash.at && itemStack.c != Block.sandLayer.at && itemStack.c != Block.leafPile.at) {
                n7 = n2 - 1;
            }
            if ((this.as > 0 && c_x == null || c_x == Block.p || c_x == Block.q || c_x == Block.r || c_x == Block.s || c_x == Block.ag || c_x == Block.hellfire || c_x instanceof C_bs) && c_g.e(c_b = (c_x = Block.c[this.as]).getCollisionBoundingBoxFromPool(c_g, n, n2, n3)) && c_x.a(c_g, n, n2, n3) && c_g.setBlockAndMetadataWithNotify(n, n7, n3, this.as, this.getPlacedBlockMetadata(itemStack.getItemDamage()))) {
                C_d.setTileEntityNBT(c_g, entityPlayer, n, n7, n3, itemStack);
                c_x.g(c_g, n, n7, n3, n4);
                c_x.onBlockPlacedByPlayer(c_g, entityPlayer, n, n7, n3, n4);
                if (c_x instanceof C_aj || c_x instanceof C_bn || c_x instanceof C_bc) {
                    c_x.d(c_g, n, n7, n3);
                }
                float f = (float)n + 0.5f;
                float f2 = (float)n2 + 0.5f;
                float f3 = (float)n3 + 0.5f;
                String string = c_x.getStepSound(this.getPlacedBlockMetadata(itemStack.getItemDamage())).b();
                float f4 = (c_x.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).a + 1.0f) / 2.0f;
                c_g.playSoundAtBlock(f, f2, f3, string, f4, c_x.getStepSound((int)this.getPlacedBlockMetadata((int)itemStack.getItemDamage())).b * 0.8f);
                if (entityPlayer.gamemode != 1) {
                    --itemStack.a;
                }
                if (itemStack.c == Block.j.at && c_g.type == 8) {
                    entityPlayer.triggerAchievement(AchievementList.moonTerraform);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final boolean throwInFire(World c_g, float f, float f2, float f3) {
        boolean bl = Block.c[this.as].directSmelt(c_g, f, f2, f3);
        if (bl) {
            net.minecraft.client.d.getMinecraft().f.triggerAchievement(AchievementList.hellfireLighter);
        }
        return bl;
    }

    public static boolean setTileEntityNBT(World c_g, EntityPlayer entityPlayer, int n, int n2, int n3, ItemStack itemStack) {
        TileEntity c_a;
        NBTTagCompound nBTTagCompound = itemStack.getSubCompound("BlockEntityTag");
        if (nBTTagCompound != null && (c_a = c_g.j(n, n2, n3)) != null) {
            if (c_g.multiplayerWorld) {
                return false;
            }
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            c_a.b(nBTTagCompound2);
            NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagCompound2.copy();
            nBTTagCompound2.merge(nBTTagCompound);
            nBTTagCompound2.a("x", n);
            nBTTagCompound2.a("y", n2);
            nBTTagCompound2.a("z", n3);
            if (!nBTTagCompound2.equals(nBTTagCompound3)) {
                c_a.a(nBTTagCompound2);
                return true;
            }
        }
        return false;
    }
}

