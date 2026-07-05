/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.b;

import java.nio.FloatBuffer;
import net.minecraft.client.a.b.C_b;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_a
extends C_b {
    private static C_a e = new C_a();
    private FloatBuffer f = BufferUtils.createFloatBuffer((int)16);
    private FloatBuffer g = BufferUtils.createFloatBuffer((int)16);
    private FloatBuffer h = BufferUtils.createFloatBuffer((int)16);

    public static C_b a() {
        C_a c_a = e;
        C_a.e.f.clear();
        c_a.g.clear();
        c_a.h.clear();
        GL11.glGetFloat((int)2983, (FloatBuffer)c_a.f);
        GL11.glGetFloat((int)2982, (FloatBuffer)c_a.g);
        c_a.f.flip().limit(16);
        c_a.f.get(c_a.b);
        c_a.g.flip().limit(16);
        c_a.g.get(c_a.c);
        c_a.d[0] = c_a.c[0] * c_a.b[0] + c_a.c[1] * c_a.b[4] + c_a.c[2] * c_a.b[8] + c_a.c[3] * c_a.b[12];
        c_a.d[1] = c_a.c[0] * c_a.b[1] + c_a.c[1] * c_a.b[5] + c_a.c[2] * c_a.b[9] + c_a.c[3] * c_a.b[13];
        c_a.d[2] = c_a.c[0] * c_a.b[2] + c_a.c[1] * c_a.b[6] + c_a.c[2] * c_a.b[10] + c_a.c[3] * c_a.b[14];
        c_a.d[3] = c_a.c[0] * c_a.b[3] + c_a.c[1] * c_a.b[7] + c_a.c[2] * c_a.b[11] + c_a.c[3] * c_a.b[15];
        c_a.d[4] = c_a.c[4] * c_a.b[0] + c_a.c[5] * c_a.b[4] + c_a.c[6] * c_a.b[8] + c_a.c[7] * c_a.b[12];
        c_a.d[5] = c_a.c[4] * c_a.b[1] + c_a.c[5] * c_a.b[5] + c_a.c[6] * c_a.b[9] + c_a.c[7] * c_a.b[13];
        c_a.d[6] = c_a.c[4] * c_a.b[2] + c_a.c[5] * c_a.b[6] + c_a.c[6] * c_a.b[10] + c_a.c[7] * c_a.b[14];
        c_a.d[7] = c_a.c[4] * c_a.b[3] + c_a.c[5] * c_a.b[7] + c_a.c[6] * c_a.b[11] + c_a.c[7] * c_a.b[15];
        c_a.d[8] = c_a.c[8] * c_a.b[0] + c_a.c[9] * c_a.b[4] + c_a.c[10] * c_a.b[8] + c_a.c[11] * c_a.b[12];
        c_a.d[9] = c_a.c[8] * c_a.b[1] + c_a.c[9] * c_a.b[5] + c_a.c[10] * c_a.b[9] + c_a.c[11] * c_a.b[13];
        c_a.d[10] = c_a.c[8] * c_a.b[2] + c_a.c[9] * c_a.b[6] + c_a.c[10] * c_a.b[10] + c_a.c[11] * c_a.b[14];
        c_a.d[11] = c_a.c[8] * c_a.b[3] + c_a.c[9] * c_a.b[7] + c_a.c[10] * c_a.b[11] + c_a.c[11] * c_a.b[15];
        c_a.d[12] = c_a.c[12] * c_a.b[0] + c_a.c[13] * c_a.b[4] + c_a.c[14] * c_a.b[8] + c_a.c[15] * c_a.b[12];
        c_a.d[13] = c_a.c[12] * c_a.b[1] + c_a.c[13] * c_a.b[5] + c_a.c[14] * c_a.b[9] + c_a.c[15] * c_a.b[13];
        c_a.d[14] = c_a.c[12] * c_a.b[2] + c_a.c[13] * c_a.b[6] + c_a.c[14] * c_a.b[10] + c_a.c[15] * c_a.b[14];
        c_a.d[15] = c_a.c[12] * c_a.b[3] + c_a.c[13] * c_a.b[7] + c_a.c[14] * c_a.b[11] + c_a.c[15] * c_a.b[15];
        c_a.a[0][0] = c_a.d[3] - c_a.d[0];
        c_a.a[0][1] = c_a.d[7] - c_a.d[4];
        c_a.a[0][2] = c_a.d[11] - c_a.d[8];
        c_a.a[0][3] = c_a.d[15] - c_a.d[12];
        C_a.a(c_a.a, 0);
        c_a.a[1][0] = c_a.d[3] + c_a.d[0];
        c_a.a[1][1] = c_a.d[7] + c_a.d[4];
        c_a.a[1][2] = c_a.d[11] + c_a.d[8];
        c_a.a[1][3] = c_a.d[15] + c_a.d[12];
        C_a.a(c_a.a, 1);
        c_a.a[2][0] = c_a.d[3] + c_a.d[1];
        c_a.a[2][1] = c_a.d[7] + c_a.d[5];
        c_a.a[2][2] = c_a.d[11] + c_a.d[9];
        c_a.a[2][3] = c_a.d[15] + c_a.d[13];
        C_a.a(c_a.a, 2);
        c_a.a[3][0] = c_a.d[3] - c_a.d[1];
        c_a.a[3][1] = c_a.d[7] - c_a.d[5];
        c_a.a[3][2] = c_a.d[11] - c_a.d[9];
        c_a.a[3][3] = c_a.d[15] - c_a.d[13];
        C_a.a(c_a.a, 3);
        c_a.a[4][0] = c_a.d[3] - c_a.d[2];
        c_a.a[4][1] = c_a.d[7] - c_a.d[6];
        c_a.a[4][2] = c_a.d[11] - c_a.d[10];
        c_a.a[4][3] = c_a.d[15] - c_a.d[14];
        C_a.a(c_a.a, 4);
        c_a.a[5][0] = c_a.d[3] + c_a.d[2];
        c_a.a[5][1] = c_a.d[7] + c_a.d[6];
        c_a.a[5][2] = c_a.d[11] + c_a.d[10];
        c_a.a[5][3] = c_a.d[15] + c_a.d[14];
        C_a.a(c_a.a, 5);
        return e;
    }

    private static void a(float[][] fArray, int n) {
        float f = MathHelper.c(fArray[n][0] * fArray[n][0] + fArray[n][1] * fArray[n][1] + fArray[n][2] * fArray[n][2]);
        float[] fArray2 = fArray[n];
        fArray2[0] = fArray2[0] / f;
        float[] fArray3 = fArray[n];
        fArray3[1] = fArray3[1] / f;
        float[] fArray4 = fArray[n];
        fArray4[2] = fArray4[2] / f;
        float[] fArray5 = fArray[n];
        fArray5[3] = fArray5[3] / f;
    }
}

