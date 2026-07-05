/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.render.tileentity;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.render.tileentity.TileEntityRenderer;

public abstract class TileEntitySpecialRenderer {
    protected TileEntityRenderer tileEntityRenderer;

    public abstract void renderTileEntityAt(TileEntity var1, float var2, float var3, float var4, float var5);

    protected void bindTextureByName(String string) {
        RenderEngine renderEngine = this.tileEntityRenderer.renderEngine;
        RenderEngine.a(renderEngine.a(string));
    }

    public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer) {
        this.tileEntityRenderer = tileEntityRenderer;
    }

    public void cacheSpecialRenderInfo(World c_g) {
    }

    public FontRenderer getFontRenderer() {
        return this.tileEntityRenderer.getFontRenderer();
    }
}

