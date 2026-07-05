/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a.a;

import java.io.IOException;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityLiving;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.a.C_f;
import net.minecraft.client.md3.MD3Loader;
import net.minecraft.client.md3.MD3Renderer;
import org.lwjgl.opengl.GL11;

public class C_z
extends C_f {
    public MD3Renderer[] model = new MD3Renderer[1];
    private int entityTypeToRender;

    public C_z(int n) {
        this.entityTypeToRender = n;
        this.b = 0.5f;
        this.c = 0.5f;
        try {
            this.model[0] = this.entityTypeToRender == 3 ? new MD3Renderer(new MD3Loader().newLoad("/rana.md3"), true) : new MD3Renderer(new MD3Loader().newLoad("/steve.md3"), true);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    @Override
    public void a(Entity c_b, float f, float f2, float f3, float f4, float f5) {
        EntityLiving c_e = (EntityLiving)c_b;
        GL11.glPushMatrix();
        try {
            GL11.glTranslatef((float)f, (float)f2, (float)f3);
            switch (this.entityTypeToRender) {
                case 0: {
                    this.a("/steve.png");
                    break;
                }
                case 1: {
                    this.a("/black_steve.png");
                    break;
                }
                case 2: {
                    this.a("/beast_boy.png");
                    break;
                }
                case 3: {
                    this.a("/cube-nes.png");
                }
            }
            float f6 = 0.0175f;
            GL11.glRotatef((float)(-(c_e.p + (c_e.n - c_e.p) * f5) - 180.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)f6, (float)(-f6), (float)f6);
            GL11.glEnable((int)2977);
            int n = c_e.H % (this.model[0].getAnimFrames() - 1);
            int n2 = (n + 1) % (this.model[0].getAnimFrames() - 1);
            this.model[0].render(n, n2, f5);
            GL11.glDisable((int)2977);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glPopMatrix();
        if (GameSettings.f) {
            this.a(c_b, f, f2, f3, f4);
        }
    }
}

