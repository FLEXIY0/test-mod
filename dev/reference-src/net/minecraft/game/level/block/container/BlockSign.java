/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.container;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockSign
extends BlockContainer {
    private Class<? extends TileEntity> signEntityClass;
    private int itemDropID;
    private int type;
    private int[] colorTable = new int[]{0xAA0000, 0xFFAA00, 0xFFFF55, 0x55FF55, 2752298, 4063131, 0x55FFFF, 5615103, 0x5555FF, 0x88008B, 0xAA00AA, 0xFF55FF, 15940202, 4209214, 9342610, 0xFFFFFF};

    public BlockSign(int n, Class<? extends TileEntity> clazz, int n2, int n3, int n4) {
        super(n, Material.c);
        this.type = n3;
        this.as = n4;
        this.signEntityClass = clazz;
        float f = 0.25f;
        float f2 = 1.0f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.itemDropID = n2;
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public C_b getSelectedBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        this.setBlockBoundsBasedOnState(c_g, n, n2, n3);
        return super.getSelectedBoundingBoxFromPool(c_g, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        if (this.type == 1) {
            byte by = c_g.e(n, n2, n3);
            float f = 0.28125f;
            float f2 = 0.78125f;
            float f3 = 0.0f;
            float f4 = 1.0f;
            float f5 = 0.125f;
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            if (by == 2) {
                this.a(f3, f, 1.0f - f5, f4, f2, 1.0f);
            }
            if (by == 3) {
                this.a(f3, f, 0.0f, f4, f2, f5);
            }
            if (by == 4) {
                this.a(1.0f - f5, f, f3, 1.0f, f2, f4);
            }
            if (by == 5) {
                this.a(0.0f, f, f3, f5, f2, f4);
            }
        }
    }

    @Override
    public int a() {
        return -1;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public TileEntity getBlockEntity() {
        try {
            return this.signEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public final boolean a(World c_g, int n, int n2, int n3, EntityPlayer entityPlayer) {
        if (c_g.multiplayerWorld) {
            return false;
        }
        boolean bl = false;
        if (entityPlayer.b.d() != null) {
            ItemStack itemStack = entityPlayer.b.d();
            if (itemStack.a() == Item.dyePowder) {
                ((C_l)c_g.j((int)n, (int)n2, (int)n3)).textColor = this.colorTable[itemStack.d];
                bl = true;
            } else if (itemStack.a() == Item.i) {
                ((C_l)c_g.j((int)n, (int)n2, (int)n3)).textColor = 0;
                bl = true;
            } else {
                entityPlayer.displayGUIEditSign((C_l)c_g.j(n, n2, n3));
                return true;
            }
            if (bl && entityPlayer.gamemode == 0) {
                --itemStack.a;
                if (itemStack.a <= 0) {
                    entityPlayer.b.a(entityPlayer.b.c, null);
                }
            }
        } else {
            entityPlayer.displayGUIEditSign((C_l)c_g.j(n, n2, n3));
            return true;
        }
        return bl;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2, n3) == 0 && (c_g.a(n, n2 - 1, n3) == Block.fence.at || c_g.a(n, n2 + 1, n3) == Block.fence.at || c_g.a(n, n2 - 1, n3) == Block.wall.at || c_g.a(n, n2 + 1, n3) == Block.wall.at || c_g.a((float)n, (float)(n2 - 1), (float)n3) || c_g.a((float)n, (float)(n2 + 1), (float)n3) || c_g.a((float)(n - 1), (float)n2, (float)n3) || c_g.a((float)(n + 1), (float)n2, (float)n3) || c_g.a((float)n, (float)n2, (float)(n3 - 1)) || c_g.a((float)n, (float)n2, (float)(n3 + 1)));
    }

    @Override
    public int a(int n, Random random) {
        return this.itemDropID;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (this.type == 0) {
            if (!c_g.f(n, n2 - 1, n3).a()) {
                bl = true;
            }
        } else if (this.type == 2) {
            if (!c_g.f(n, n2 + 1, n3).a()) {
                bl = true;
            }
        } else {
            byte by = c_g.e(n, n2, n3);
            bl = true;
            if (by == 2 && c_g.f(n, n2, n3 + 1).a()) {
                bl = false;
            }
            if (by == 3 && c_g.f(n, n2, n3 - 1).a()) {
                bl = false;
            }
            if (by == 4 && c_g.f(n + 1, n2, n3).a()) {
                bl = false;
            }
            if (by == 5 && c_g.f(n - 1, n2, n3).a()) {
                bl = false;
            }
        }
        if (bl) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }
}

