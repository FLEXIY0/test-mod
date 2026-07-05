/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.render.tileentity;

import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.C_i;
import net.minecraft.client.c.FontRenderer;
import net.minecraft.client.render.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityNoteRenderer
extends TileEntitySpecialRenderer {
    private int[] colorArray = new int[]{0x77D700, 9814016, 11707648, 13403648, 14836992, 15941888, 16522752, 0xFE000F, 16187443, 15204442, 13566083, 11403433, 8782028, 5964007, 2949369, 133886, 14326, 26848, 39612, 50829, 59736, 64545, 2096128, 5892096, 9748736};
    private String[] noteArray = new String[]{"F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#"};

    public void renderTileEntityNoteAt(C_i c_i, float f, float f2, float f3, float f4) {
        byte by = c_i.note;
        String string = "" + by;
        FontRenderer fontRenderer = this.getFontRenderer();
        float f5 = 0.6666667f;
        float f6 = 0.016666668f * f5;
        GL11.glPushMatrix();
        GL11.glDepthMask((boolean)false);
        GL11.glNormal3f((float)0.0f, (float)0.0f, (float)(-1.0f * f6));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(f + 0.5f), (float)(f2 + 0.58f), (float)(f3 + 1.0f));
        GL11.glTranslatef((float)0.01f, (float)0.0f, (float)0.01f);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glScalef((float)f6, (float)(-f6), (float)f6);
        fontRenderer.b(string, -fontRenderer.a(string) / 2 + 8, 0, this.colorArray[c_i.note]);
        if (by >= 12) {
            by = (byte)(by - 12);
        }
        fontRenderer.b("|", -fontRenderer.a("|") / 2, 0, 0xFFFFFF);
        fontRenderer.b(this.noteArray[by], -fontRenderer.a(this.noteArray[by]) / 2 - 8, 0, this.colorArray[c_i.note]);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(f + 1.0f), (float)(f2 + 0.58f), (float)(f3 + 0.5f));
        GL11.glTranslatef((float)0.01f, (float)0.0f, (float)-0.01f);
        GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glScalef((float)f6, (float)(-f6), (float)f6);
        fontRenderer.b(string, -fontRenderer.a(string) / 2 + 8, 0, this.colorArray[c_i.note]);
        if (by >= 12) {
            by = (byte)(by - 12);
        }
        fontRenderer.b("|", -fontRenderer.a("|") / 2, 0, 0xFFFFFF);
        fontRenderer.b(this.noteArray[by], -fontRenderer.a(this.noteArray[by]) / 2 - 8, 0, this.colorArray[c_i.note]);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)f, (float)(f2 + 0.58f), (float)(f3 + 0.5f));
        GL11.glTranslatef((float)-0.01f, (float)0.0f, (float)0.01f);
        GL11.glRotatef((float)270.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glScalef((float)f6, (float)(-f6), (float)f6);
        fontRenderer.b(string, -fontRenderer.a(string) / 2 + 8, 0, this.colorArray[c_i.note]);
        if (by >= 12) {
            by = (byte)(by - 12);
        }
        fontRenderer.b("|", -fontRenderer.a("|") / 2, 0, 0xFFFFFF);
        fontRenderer.b(this.noteArray[by], -fontRenderer.a(this.noteArray[by]) / 2 - 8, 0, this.colorArray[c_i.note]);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(f + 0.5f), (float)(f2 + 0.58f), (float)f3);
        GL11.glTranslatef((float)-0.01f, (float)0.0f, (float)-0.01f);
        GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glScalef((float)f6, (float)(-f6), (float)f6);
        fontRenderer.b(string, -fontRenderer.a(string) / 2 + 8, 0, this.colorArray[c_i.note]);
        if (by >= 12) {
            by = (byte)(by - 12);
        }
        fontRenderer.b("|", -fontRenderer.a("|") / 2, 0, 0xFFFFFF);
        fontRenderer.b(this.noteArray[by], -fontRenderer.a(this.noteArray[by]) / 2 - 8, 0, this.colorArray[c_i.note]);
        GL11.glPopMatrix();
        GL11.glDepthMask((boolean)true);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity c_a, float f, float f2, float f3, float f4) {
        this.renderTileEntityNoteAt((C_i)c_a, f, f2, f3, f4);
    }
}

