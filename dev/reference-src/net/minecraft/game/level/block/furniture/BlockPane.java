/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.furniture;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.Item;
import net.minecraft.a.d.C_b;

public class BlockPane
extends Block {
    private int secondaryTex;

    public BlockPane(int n, int n2, int n3, Material c_c) {
        super(n, n2, c_c);
        this.secondaryTex = n3;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public int a() {
        return 18;
    }

    @Override
    public boolean d(World c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.a(n, n2, n3);
        return n5 == this.at ? false : super.d(c_g, n, n2, n3, n4);
    }

    @Override
    public void getCollidingBoundingBoxes(World c_g, int n, int n2, int n3, C_b c_b, ArrayList<C_b> arrayList) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        boolean bl = this.doesPaneMatch(c_g.a(n, n2, n3 - 1));
        boolean bl2 = this.doesPaneMatch(c_g.a(n, n2, n3 + 1));
        boolean bl3 = this.doesPaneMatch(c_g.a(n - 1, n2, n3));
        boolean bl4 = this.doesPaneMatch(c_g.a(n + 1, n2, n3));
        if (bl3 && bl4) {
            f = 0.0f;
            f2 = 1.0f;
        } else if (bl3) {
            f = 0.0f;
        } else if (bl4) {
            f2 = 1.0f;
        }
        if (bl && bl2) {
            f3 = 0.0f;
            f4 = 1.0f;
        } else if (bl) {
            f3 = 0.0f;
        } else if (bl2) {
            f4 = 1.0f;
        }
        this.a(f, 0.0f, f3, f2, 1.0f, f4);
        super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
    }

    public void setBlockBoundsForItemRender() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        boolean bl = this.doesPaneMatch(c_g.a(n, n2, n3 - 1));
        boolean bl2 = this.doesPaneMatch(c_g.a(n, n2, n3 + 1));
        boolean bl3 = this.doesPaneMatch(c_g.a(n - 1, n2, n3));
        boolean bl4 = this.doesPaneMatch(c_g.a(n + 1, n2, n3));
        if (bl3 && bl4) {
            f = 0.0f;
            f2 = 1.0f;
        } else if (bl3) {
            f = 0.0f;
        } else if (bl4) {
            f2 = 1.0f;
        }
        if (bl && !bl2) {
            f3 = 0.0f;
        } else if (!bl && bl2) {
            f4 = 1.0f;
        } else if (bl && bl2) {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        this.a(f, 0.0f, f3, f2, 1.0f, f4);
    }

    public int getAlternateTexture(int n) {
        return this.secondaryTex;
    }

    @Override
    public final int a(int n, Random random) {
        if (this.at == Block.ironBars.at) {
            return this.at;
        }
        return Item.z.ap;
    }

    @Override
    public int a(Random random) {
        if (this.at == Block.ironBars.at) {
            return 1;
        }
        return 2;
    }

    public final boolean doesPaneMatch(int n) {
        return Block.e[n] || n == this.at || n == Block.B.at || n == Block.z.at || n == Block.Y.at || n == Block.Z.at || n == Block.stairUpsideDown.at || n == Block.wall.at;
    }
}

