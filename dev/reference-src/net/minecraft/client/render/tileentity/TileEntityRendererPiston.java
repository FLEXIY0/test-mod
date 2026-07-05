/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.render.tileentity;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_j;
import net.minecraft.client.C_c;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.C_f;
import net.minecraft.client.render.tileentity.TileEntitySpecialRenderer;
import net.minecraft.game.level.block.machines.BlockPistonBase;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston
extends TileEntitySpecialRenderer {
    private C_f blockRenderer;

    public void renderPiston(C_j c_j, float f, float f2, float f3, float f4) {
        C_x c_x = C_x.c[c_j.getStoredBlockID()];
        if (c_x != null && c_j.getProgress(f4) < 1.0f) {
            C_d c_d = C_d.a;
            this.bindTextureByName("/terrain.png");
            C_c.a();
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)2884);
            GL11.glShadeModel((int)7424);
            c_d.b();
            c_d.setTranslation(f - (float)c_j.b + c_j.getOffsetX(f4), f2 - (float)c_j.c + c_j.getOffsetY(f4), f3 - (float)c_j.d + c_j.getOffsetZ(f4));
            c_d.a(1.0f, 1.0f, 1.0f);
            if (c_x == C_x.pulleyExtension && c_j.getProgress(f4) < 0.5f) {
                this.blockRenderer.renderPistonExtensionAllFaces(c_x, c_j.b, c_j.c, c_j.d, false);
            } else if (c_j.shouldRenderHead() && !c_j.isExtending()) {
                C_x.pulleyExtension.setHeadTexture(((BlockPistonBase)c_x).getPistonExtensionTexture());
                this.blockRenderer.renderPistonExtensionAllFaces(C_x.pulleyExtension, c_j.b, c_j.c, c_j.d, c_j.getProgress(f4) < 0.5f);
                C_x.pulleyExtension.clearHeadTexture();
                c_d.setTranslation(f - (float)c_j.b, f2 - (float)c_j.c, f3 - (float)c_j.d);
                this.blockRenderer.renderPistonBaseAllFaces(c_x, c_j.b, c_j.c, c_j.d);
            } else {
                this.blockRenderer.a(c_x, c_j.b, c_j.c, c_j.d);
            }
            c_d.setTranslation(0.0f, 0.0f, 0.0f);
            c_d.a();
            GL11.glEnable((int)2884);
            C_c.b();
        }
    }

    @Override
    public void cacheSpecialRenderInfo(C_g c_g) {
        this.blockRenderer = new C_f(c_g);
    }

    @Override
    public void renderTileEntityAt(C_a c_a, float f, float f2, float f3, float f4) {
        this.renderPiston((C_j)c_a, f, f2, f3, f4);
    }
}

