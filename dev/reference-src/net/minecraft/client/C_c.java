/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client;

import java.nio.FloatBuffer;
import net.minecraft.a.d.C_a;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public final class C_c {
    private static FloatBuffer a = BufferUtils.createFloatBuffer((int)16);

    public static void a() {
        GL11.glDisable((int)2896);
        GL11.glDisable((int)16384);
        GL11.glDisable((int)16385);
        GL11.glDisable((int)2903);
    }

    public static void b() {
        GL11.glEnable((int)2896);
        GL11.glEnable((int)16384);
        GL11.glEnable((int)16385);
        GL11.glEnable((int)2903);
        GL11.glColorMaterial((int)1032, (int)5634);
        C_a c_a = new C_a(0.3f, 1.0f, -0.7f);
        GL11.glLight((int)16384, (int)4611, (FloatBuffer)C_c.a(c_a.a, c_a.b, c_a.c, 0.0f));
        GL11.glLight((int)16384, (int)4609, (FloatBuffer)C_c.a(0.5f, 0.5f, 0.5f, 1.0f));
        GL11.glLight((int)16384, (int)4608, (FloatBuffer)C_c.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight((int)16384, (int)4610, (FloatBuffer)C_c.a(0.0f, 0.0f, 0.0f, 1.0f));
        c_a = new C_a(-0.7f, 1.0f, 0.2f);
        GL11.glLight((int)16385, (int)4611, (FloatBuffer)C_c.a(c_a.a, c_a.b, c_a.c, 0.0f));
        GL11.glLight((int)16385, (int)4609, (FloatBuffer)C_c.a(0.5f, 0.5f, 0.5f, 1.0f));
        GL11.glLight((int)16385, (int)4608, (FloatBuffer)C_c.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight((int)16385, (int)4610, (FloatBuffer)C_c.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glShadeModel((int)7425);
        GL11.glLightModel((int)2899, (FloatBuffer)C_c.a(0.5f, 0.5f, 0.5f, 1.0f));
    }

    private static FloatBuffer a(float f, float f2, float f3, float f4) {
        a.clear();
        a.put(f).put(f2).put(f3).put(f4);
        a.flip();
        return a;
    }
}

