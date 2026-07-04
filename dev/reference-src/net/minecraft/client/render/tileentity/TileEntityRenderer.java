/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.render.tileentity;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.C_c;
import net.minecraft.a.a.b.a.C_i;
import net.minecraft.a.a.b.a.C_j;
import net.minecraft.a.a.b.a.C_l;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.render.tileentity.TileEntityChestRenderer;
import net.minecraft.client.render.tileentity.TileEntityNoteRenderer;
import net.minecraft.client.render.tileentity.TileEntityRendererPiston;
import net.minecraft.client.render.tileentity.TileEntitySignRenderer;
import net.minecraft.client.render.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderer {
    private Map<Class<?>, TileEntitySpecialRenderer> specialRendererMap = new HashMap();
    public static TileEntityRenderer instance = new TileEntityRenderer();
    private FontRenderer fontRenderer;
    public RenderEngine renderEngine;
    public C_g worldObj;
    public EntityPlayer entityPlayer;
    public float playerYaw;
    public float playerPitch;
    public float playerX;
    public float playerY;
    public float playerZ;

    private TileEntityRenderer() {
        this.specialRendererMap.put(C_l.class, new TileEntitySignRenderer());
        this.specialRendererMap.put(C_j.class, new TileEntityRendererPiston());
        this.specialRendererMap.put(C_i.class, new TileEntityNoteRenderer());
        this.specialRendererMap.put(C_c.class, new TileEntityChestRenderer());
        for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this.specialRendererMap.values()) {
            tileEntitySpecialRenderer.setTileEntityRenderer(this);
        }
    }

    public TileEntitySpecialRenderer getSpecialRendererForClass(Class<?> clazz) {
        TileEntitySpecialRenderer tileEntitySpecialRenderer = this.specialRendererMap.get(clazz);
        if (tileEntitySpecialRenderer == null && clazz != C_a.class) {
            tileEntitySpecialRenderer = this.getSpecialRendererForClass(clazz.getSuperclass());
            this.specialRendererMap.put(clazz, tileEntitySpecialRenderer);
        }
        return tileEntitySpecialRenderer;
    }

    public boolean hasSpecialRenderer(C_a c_a) {
        return this.getSpecialRendererForEntity(c_a) != null;
    }

    public TileEntitySpecialRenderer getSpecialRendererForEntity(C_a c_a) {
        return c_a == null ? null : this.getSpecialRendererForClass(c_a.getClass());
    }

    public void cacheActiveRenderInfo(C_g c_g, RenderEngine renderEngine, FontRenderer fontRenderer, EntityPlayer entityPlayer, float f) {
        if (this.worldObj != c_g) {
            this.cacheSpecialRenderInfo(c_g);
        }
        this.renderEngine = renderEngine;
        this.entityPlayer = entityPlayer;
        this.fontRenderer = fontRenderer;
        this.playerYaw = entityPlayer.p + (entityPlayer.n - entityPlayer.p) * f;
        this.playerPitch = entityPlayer.q + (entityPlayer.o - entityPlayer.q) * f;
        this.playerX = entityPlayer.B + (entityPlayer.h - entityPlayer.B) * f;
        this.playerY = entityPlayer.C + (entityPlayer.i - entityPlayer.C) * f;
        this.playerZ = entityPlayer.D + (entityPlayer.j - entityPlayer.D) * f;
    }

    private void cacheSpecialRenderInfo(C_g c_g) {
        this.worldObj = c_g;
        for (TileEntitySpecialRenderer tileEntitySpecialRenderer : this.specialRendererMap.values()) {
            if (tileEntitySpecialRenderer == null) continue;
            tileEntitySpecialRenderer.cacheSpecialRenderInfo(c_g);
        }
    }

    public void renderTileEntity(C_a c_a, float f) {
        if (c_a.getDistanceFrom(this.playerX, this.playerY, this.playerZ) < 4096.0f) {
            float f2 = this.worldObj.c(c_a.b, c_a.c, c_a.d);
            if (this.worldObj.mc.f.nightVision && (f2 += 0.7f) > 1.0f) {
                f2 = 1.0f;
            }
            GL11.glColor3f((float)f2, (float)f2, (float)f2);
            this.renderTileEntityAt(c_a, c_a.b, c_a.c, c_a.d, f);
        }
    }

    public void renderTileEntityAt(C_a c_a, float f, float f2, float f3, float f4) {
        TileEntitySpecialRenderer tileEntitySpecialRenderer = this.getSpecialRendererForEntity(c_a);
        if (tileEntitySpecialRenderer != null) {
            tileEntitySpecialRenderer.renderTileEntityAt(c_a, f, f2, f3, f4);
        }
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
}

