/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package net.minecraft.client.md3;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.md3.MD3Shader;
import org.lwjgl.BufferUtils;

public final class MD3Surface {
    public int verts;
    private int frames;
    public MD3Shader[] shaders;
    public IntBuffer triangles;
    public FloatBuffer polygons;
    public FloatBuffer vertices;
    public FloatBuffer normals;
    private float[] h;
    private float[] i;

    public MD3Surface(int n, int n2, int n3) {
        this.verts = n2;
        this.frames = n3;
        this.triangles = BufferUtils.createIntBuffer((int)(n * 3));
        this.polygons = BufferUtils.createFloatBuffer((int)(n2 << 1));
        this.vertices = BufferUtils.createFloatBuffer((int)(n2 * (n3 + 2) * 3));
        this.normals = BufferUtils.createFloatBuffer((int)(n2 * (n3 + 2) * 3));
        this.h = new float[n2 * 3];
        this.i = new float[n2 * 3];
    }

    public final void setFrame(int n, int n2, float f) {
        this.triangles.position(0).limit(this.triangles.capacity());
        this.polygons.position(0).limit(this.polygons.capacity());
        int n3 = n;
        if (f != 0.0f) {
            this.interpolate(this.vertices, n, n2, f);
            this.interpolate(this.normals, n, n2, f);
            n3 = this.frames;
        }
        this.vertices.clear().position(n3 * this.verts * 3).limit((n3 + 1) * this.verts * 3);
        this.normals.clear().position(n3 * this.verts * 3).limit((n3 + 1) * this.verts * 3);
    }

    private void interpolate(FloatBuffer floatBuffer, int n, int n2, float f) {
        floatBuffer.clear().position(n * this.verts * 3).limit((n + 1) * this.verts * 3);
        floatBuffer.get(this.h);
        floatBuffer.clear().position(n2 * this.verts * 3).limit((n2 + 1) * this.verts * 3);
        floatBuffer.get(this.i);
        for (int i = 0; i < this.verts * 3; ++i) {
            float[] fArray = this.h;
            int n3 = i;
            float[] fArray2 = fArray;
            int n4 = n3;
            fArray2[n4] = fArray2[n4] + (this.i[i] - this.h[i]) * f;
        }
        n = this.frames;
        floatBuffer.clear().position(n * this.verts * 3);
        floatBuffer.put(this.h);
    }
}

