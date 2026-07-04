/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.b;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.d.C_a;
import net.minecraft.client.a.C_d;
import net.minecraft.client.b.C_i;
import net.minecraft.client.b.C_j;
import org.lwjgl.opengl.GL11;

public final class C_c {
    private C_j[] f;
    private C_i[] g;
    public float textureWidth = 64.0f;
    public float textureHeight = 32.0f;
    private int h;
    private int i;
    public float j;
    public float k;
    public float l;
    public float a;
    public float b;
    public float c;
    private boolean m = false;
    private int n = 0;
    public boolean d = false;
    public boolean e = true;
    private boolean o = false;
    public List<C_c> childModels;

    public C_c(int n, int n2) {
        this.h = n;
        this.i = n2;
    }

    public final void a(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.f = new C_j[8];
        this.g = new C_i[6];
        float f5 = f + (float)n;
        float f6 = f2 + (float)n2;
        float f7 = f3 + (float)n3;
        f -= f4;
        f2 -= f4;
        f3 -= f4;
        f5 += f4;
        f6 += f4;
        f7 += f4;
        if (this.d) {
            f4 = f5;
            f5 = f;
            f = f4;
        }
        C_j c_j = new C_j(f, f2, f3, 0.0f, 0.0f);
        C_j c_j2 = new C_j(f5, f2, f3, 0.0f, 8.0f);
        C_j c_j3 = new C_j(f5, f6, f3, 8.0f, 8.0f);
        C_j c_j4 = new C_j(f, f6, f3, 8.0f, 0.0f);
        C_j c_j5 = new C_j(f, f2, f7, 0.0f, 0.0f);
        C_j c_j6 = new C_j(f5, f2, f7, 0.0f, 8.0f);
        C_j c_j7 = new C_j(f5, f6, f7, 8.0f, 8.0f);
        C_j c_j8 = new C_j(f, f6, f7, 8.0f, 0.0f);
        this.f[0] = c_j;
        this.f[1] = c_j2;
        this.f[2] = c_j3;
        this.f[3] = c_j4;
        this.f[4] = c_j5;
        this.f[5] = c_j6;
        this.f[6] = c_j7;
        this.f[7] = c_j8;
        this.g[0] = new C_i(new C_j[]{c_j6, c_j2, c_j3, c_j7}, this.h + n3 + n, this.i + n3, this.h + n3 + n + n3, this.i + n3 + n2, this.textureWidth, this.textureHeight);
        this.g[1] = new C_i(new C_j[]{c_j, c_j5, c_j8, c_j4}, this.h, this.i + n3, this.h + n3, this.i + n3 + n2, this.textureWidth, this.textureHeight);
        this.g[2] = new C_i(new C_j[]{c_j6, c_j5, c_j, c_j2}, this.h + n3, this.i, this.h + n3 + n, this.i + n3, this.textureWidth, this.textureHeight);
        this.g[3] = new C_i(new C_j[]{c_j3, c_j4, c_j8, c_j7}, this.h + n3 + n, this.i, this.h + n3 + n + n, this.i + n3, this.textureWidth, this.textureHeight);
        this.g[4] = new C_i(new C_j[]{c_j2, c_j, c_j4, c_j3}, this.h + n3, this.i + n3, this.h + n3 + n, this.i + n3 + n2, this.textureWidth, this.textureHeight);
        this.g[5] = new C_i(new C_j[]{c_j5, c_j6, c_j7, c_j8}, this.h + n3 + n + n3, this.i + n3, this.h + n3 + n + n3 + n, this.i + n3 + n2, this.textureWidth, this.textureHeight);
        if (this.d) {
            for (int i = 0; i < this.g.length; ++i) {
                C_i c_i = this.g[i];
                C_j[] c_jArray = new C_j[c_i.a.length];
                for (n = 0; n < c_i.a.length; ++n) {
                    c_jArray[n] = c_i.a[c_i.a.length - n - 1];
                }
                c_i.a = c_jArray;
            }
        }
    }

    public void addChild(C_c c_c) {
        if (this.childModels == null) {
            this.childModels = new ArrayList<C_c>();
        }
        this.childModels.add(c_c);
    }

    public final void a(float f, float f2, float f3) {
        this.j = f;
        this.k = f2;
        this.l = f3;
    }

    public final void a(float f) {
        if (this.e) {
            if (!this.m) {
                float f2 = f;
                C_c c_c = this;
                this.n = GL11.glGenLists((int)1);
                GL11.glNewList((int)this.n, (int)4864);
                C_d c_d = C_d.a;
                for (int i = 0; i < c_c.g.length; ++i) {
                    c_d.b();
                    C_i c_i = c_c.g[i];
                    float f3 = f2;
                    C_d c_d2 = c_d;
                    C_i c_i2 = c_i;
                    C_a c_a = c_i.a[1].a.a(c_i2.a[0].a).a();
                    C_a c_a2 = c_i2.a[1].a.a(c_i2.a[2].a).a();
                    c_a = new C_a(c_a.b * c_a2.c - c_a.c * c_a2.b, c_a.c * c_a2.a - c_a.a * c_a2.c, c_a.a * c_a2.b - c_a.b * c_a2.a).a();
                    C_d.c(-c_a.a, -c_a.b, -c_a.c);
                    for (int j = 0; j < 4; ++j) {
                        C_j c_j = c_i2.a[j];
                        c_d2.a(c_j.a.a * f3, c_j.a.b * f3, c_j.a.c * f3, c_j.b, c_j.c);
                    }
                    c_d.a();
                }
                GL11.glEndList();
                c_c.m = true;
            }
            if (this.a == 0.0f && this.b == 0.0f && this.c == 0.0f) {
                if (this.j == 0.0f && this.k == 0.0f && this.l == 0.0f) {
                    GL11.glCallList((int)this.n);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).a(f);
                        }
                    }
                } else {
                    GL11.glTranslatef((float)(this.j * f), (float)(this.k * f), (float)(this.l * f));
                    GL11.glCallList((int)this.n);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).a(f);
                        }
                    }
                    GL11.glTranslatef((float)(-this.j * f), (float)(-this.k * f), (float)(-this.l * f));
                }
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef((float)(this.j * f), (float)(this.k * f), (float)(this.l * f));
                if (this.c != 0.0f) {
                    GL11.glRotatef((float)(this.c * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.b != 0.0f) {
                    GL11.glRotatef((float)(this.b * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.a != 0.0f) {
                    GL11.glRotatef((float)(this.a * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
                GL11.glCallList((int)this.n);
                if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        this.childModels.get(i).a(f);
                    }
                }
                GL11.glPopMatrix();
            }
        }
    }

    public final void renderFist(float f) {
        if (this.e) {
            if (!this.m) {
                float f2 = f;
                C_c c_c = this;
                this.n = GL11.glGenLists((int)1);
                GL11.glNewList((int)this.n, (int)4864);
                C_d c_d = C_d.a;
                for (int i = 0; i < c_c.g.length; ++i) {
                    c_d.b();
                    C_i c_i = c_c.g[i];
                    float f3 = f2;
                    C_d c_d2 = c_d;
                    C_i c_i2 = c_i;
                    C_a c_a = c_i.a[1].a.a(c_i2.a[0].a).a();
                    C_a c_a2 = c_i2.a[1].a.a(c_i2.a[2].a).a();
                    c_a = new C_a(c_a.b * c_a2.c - c_a.c * c_a2.b, c_a.c * c_a2.a - c_a.a * c_a2.c, c_a.a * c_a2.b - c_a.b * c_a2.a).a();
                    C_d.c(-c_a.a, -c_a.b, -c_a.c);
                    for (int j = 0; j < 4; ++j) {
                        C_j c_j = c_i2.a[j];
                        c_d2.a(c_j.a.a * f3, c_j.a.b * f3, c_j.a.c * f3, c_j.b, c_j.c);
                    }
                    c_d.a();
                }
                GL11.glEndList();
                c_c.m = true;
            }
            if (this.j == 0.0f && this.k == 0.0f && this.l == 0.0f) {
                GL11.glCallList((int)this.n);
            } else {
                GL11.glTranslatef((float)(this.j * f), (float)(this.k * f), (float)(this.l * f));
                GL11.glCallList((int)this.n);
                GL11.glTranslatef((float)(-this.j * f), (float)(-this.k * f), (float)(-this.l * f));
            }
        }
    }

    public void renderWithRotation(float f) {
        if (!this.o && this.e) {
            if (!this.m) {
                this.a(f);
            }
            if (this.a == 0.0f && this.b == 0.0f && this.c == 0.0f) {
                if (this.j != 0.0f || this.k != 0.0f || this.l != 0.0f) {
                    GL11.glTranslatef((float)(this.j * f), (float)(this.k * f), (float)(this.l * f));
                }
            } else {
                GL11.glTranslatef((float)(this.j * f), (float)(this.k * f), (float)(this.l * f));
                if (this.c != 0.0f) {
                    GL11.glRotatef((float)(this.c * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
                }
                if (this.b != 0.0f) {
                    GL11.glRotatef((float)(this.b * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
                }
                if (this.a != 0.0f) {
                    GL11.glRotatef((float)(this.a * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
                }
            }
        }
    }

    public C_c setTextureSize(int n, int n2) {
        this.textureWidth = n;
        this.textureHeight = n2;
        return this;
    }
}

