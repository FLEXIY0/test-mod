/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.md3;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.md3.MD3Model;
import net.minecraft.client.md3.MD3Surface;
import org.lwjgl.opengl.GL11;

public final class MD3Renderer {
    private MD3Model model;
    private int displayList;
    private boolean useAnimation;

    public MD3Renderer(MD3Model mD3Model, boolean bl) {
        this.model = mD3Model;
        this.displayList = 0;
        this.useAnimation = bl;
    }

    public final int getAnimFrames() {
        return this.model.animFrames;
    }

    public final void render(int n, int n2, float f) {
        if (this.displayList == 0 || this.useAnimation) {
            if (!this.useAnimation) {
                this.displayList = GL11.glGenLists((int)1);
            }
            GL11.glEnableClientState((int)32884);
            GL11.glEnableClientState((int)32888);
            GL11.glEnableClientState((int)32885);
            if (!this.useAnimation) {
                GL11.glNewList((int)this.displayList, (int)4864);
            }
            for (int i = 0; i < this.model.surfaces.length; ++i) {
                MD3Surface mD3Surface = this.model.surfaces[i];
                if (this.useAnimation) {
                    mD3Surface.setFrame(n, n2, f);
                } else {
                    mD3Surface.setFrame(0, 0, 0.0f);
                }
                mD3Surface.triangles.position(0);
                mD3Surface.polygons.position(0);
                GL11.glVertexPointer((int)3, (int)0, (FloatBuffer)mD3Surface.vertices);
                GL11.glNormalPointer((int)0, (FloatBuffer)mD3Surface.normals);
                GL11.glTexCoordPointer((int)2, (int)0, (FloatBuffer)mD3Surface.polygons);
                GL11.glDrawElements((int)4, (IntBuffer)mD3Surface.triangles);
            }
            if (!this.useAnimation) {
                GL11.glEndList();
            }
            GL11.glDisableClientState((int)32884);
            GL11.glDisableClientState((int)32888);
            GL11.glDisableClientState((int)32885);
        }
        if (!this.useAnimation) {
            GL11.glCallList((int)this.displayList);
        }
    }

    public void renderTag(String string, MD3Renderer mD3Renderer, int n, int n2, float f, int n3, int n4, float f2) {
        mD3Renderer.render(n3, n4, f2);
    }
}

