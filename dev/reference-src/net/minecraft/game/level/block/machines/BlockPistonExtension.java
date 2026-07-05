/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.level.block.machines;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.C_d;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;
import net.minecraft.game.level.block.machines.BlockPistonBase;

public class BlockPistonExtension
extends Block {
    private int headTexture = -1;

    public BlockPistonExtension(int n, int n2) {
        super(n, n2, C_c.pulley);
        this.setStepSound(aG);
        this.b(2.0f);
    }

    public void setHeadTexture(int n) {
        this.headTexture = n;
    }

    public void clearHeadTexture() {
        this.headTexture = -1;
    }

    @Override
    public void b(World c_g, int n, int n2, int n3) {
        super.b(c_g, n, n2, n3);
        byte by = c_g.e(n, n2, n3);
        int n4 = C_d.faceToSide[BlockPistonExtension.getDirectionMeta(by)];
        int n5 = c_g.a(n += C_d.offsetsXForSide[n4], n2 += C_d.offsetsYForSide[n4], n3 += C_d.offsetsZForSide[n4]);
        if ((n5 == Block.pulleyBase.at || n5 == Block.pulleyStickyBase.at || n5 == Block.pulleyBaseActive.at || n5 == Block.pulleyStickyBaseActive.at) && BlockPistonBase.isExtended(by = c_g.e(n, n2, n3))) {
            if (c_g.gamemode == 0) {
                Block.c[n5].f(c_g, n, n2, n3, by);
            }
            c_g.b(n, n2, n3, 0);
        }
    }

    @Override
    public int a(int n, int n2) {
        int n3 = BlockPistonExtension.getDirectionMeta(n2);
        return n == n3 ? (this.headTexture >= 0 ? this.headTexture : ((n2 & 8) != 0 ? this.as - 1 : this.as)) : (n == C_d.faceToSide[n3] ? ((n2 & 8) != 0 ? 576 : 577) : ((n2 & 8) != 0 ? 610 : 578));
    }

    @Override
    public int a() {
        return 28;
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
    public boolean a(World c_g, int n, int n2, int n3) {
        return false;
    }

    @Override
    public int a(Random random) {
        return 0;
    }

    @Override
    public void getCollidingBoundingBoxes(World c_g, int n, int n2, int n3, C_b c_b, ArrayList<C_b> arrayList) {
        byte by = c_g.e(n, n2, n3);
        switch (BlockPistonExtension.getDirectionMeta(by)) {
            case 0: {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.375f, 0.25f, 0.375f, 0.625f, 1.0f, 0.625f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                break;
            }
            case 1: {
                this.a(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.375f, 0.0f, 0.375f, 0.625f, 0.75f, 0.625f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                break;
            }
            case 2: {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.25f, 0.375f, 0.25f, 0.75f, 0.625f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                break;
            }
            case 3: {
                this.a(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.25f, 0.375f, 0.0f, 0.75f, 0.625f, 0.75f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                break;
            }
            case 4: {
                this.a(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.375f, 0.25f, 0.25f, 0.625f, 0.75f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                break;
            }
            case 5: {
                this.a(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
                this.a(0.0f, 0.375f, 0.25f, 0.75f, 0.625f, 0.75f);
                super.getCollidingBoundingBoxes(c_g, n, n2, n3, c_b, arrayList);
            }
        }
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void setBlockBoundsBasedOnState(World c_g, int n, int n2, int n3) {
        byte by = c_g.e(n, n2, n3);
        switch (BlockPistonExtension.getDirectionMeta(by)) {
            case 0: {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
                break;
            }
            case 1: {
                this.a(0.0f, 0.75f, 0.0f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 2: {
                this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.25f);
                break;
            }
            case 3: {
                this.a(0.0f, 0.0f, 0.75f, 1.0f, 1.0f, 1.0f);
                break;
            }
            case 4: {
                this.a(0.0f, 0.0f, 0.0f, 0.25f, 1.0f, 1.0f);
                break;
            }
            case 5: {
                this.a(0.75f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        int n5 = BlockPistonExtension.getDirectionMeta(c_g.e(n, n2, n3));
        int n6 = c_g.a(n - C_d.offsetsXForSide[n5], n2 - C_d.offsetsYForSide[n5], n3 - C_d.offsetsZForSide[n5]);
        if (n6 != Block.pulleyBase.at && n6 != Block.pulleyStickyBase.at && n6 != Block.pulleyBaseActive.at && n6 != Block.pulleyStickyBaseActive.at) {
            c_g.b(n, n2, n3, 0);
        } else {
            Block.c[n6].b(c_g, n - C_d.offsetsXForSide[n5], n2 - C_d.offsetsYForSide[n5], n3 - C_d.offsetsZForSide[n5], n4);
        }
    }

    public static int getDirectionMeta(int n) {
        return n & 7;
    }
}

