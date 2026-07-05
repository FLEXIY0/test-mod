/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.ARBOcclusionQuery
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 */
package net.minecraft.client.a;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.d.C_g;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.C_c;
import net.minecraft.client.GameSettings;
import net.minecraft.client.a.C_a;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.C_h;
import net.minecraft.client.a.C_l;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.a.a.C_i;
import net.minecraft.client.a.b.C_e;
import net.minecraft.client.d;
import net.minecraft.client.f.C_aa;
import net.minecraft.client.f.C_ab;
import net.minecraft.client.f.C_j;
import net.minecraft.client.f.C_o;
import net.minecraft.client.f.C_p;
import net.minecraft.client.f.C_q;
import net.minecraft.client.f.C_r;
import net.minecraft.client.f.C_s;
import net.minecraft.client.f.C_t;
import net.minecraft.client.f.C_u;
import net.minecraft.client.f.C_v;
import net.minecraft.client.f.C_w;
import net.minecraft.client.f.C_x;
import net.minecraft.client.f.C_y;
import net.minecraft.client.f.C_z;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import util.MathHelper;

public final class C_b
implements net.minecraft.a.a.C_d {
    public List<net.minecraft.a.a.b.a.TileEntity> tileEntities = new ArrayList<net.minecraft.a.a.b.a.TileEntity>();
    private net.minecraft.a.a.World b;
    private RenderEngine c;
    private int d;
    private IntBuffer e = BufferUtils.createIntBuffer((int)65536);
    private List<C_h> f = new ArrayList<C_h>();
    private C_h[] g;
    private C_h[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private d m;
    private C_f n;
    private IntBuffer o;
    private boolean p = false;
    private int q = 0;
    private int r;
    private int s;
    private int t;
    private int u;
    private int[] v = new int[50000];
    private IntBuffer w = BufferUtils.createIntBuffer((int)64);
    private int x;
    private int y;
    private int z;
    private int A;
    private float B = -9999.0f;
    private float C = -9999.0f;
    private float D = -9999.0f;
    public float a;
    private double cloudWindVX = 0.0;
    private double cloudWindVZ = 0.0;
    private double cloudWindOffX = 0.0;
    private double cloudWindOffZ = 0.0;

    public C_b(d d2, RenderEngine renderEngine) {
        this.m = d2;
        this.c = renderEngine;
        this.d = GL11.glGenLists((int)2);
        this.l = GL11.glGenLists((int)786432);
        this.p = GLContext.getCapabilities().GL_ARB_occlusion_query;
        if (this.p) {
            this.w.clear();
            GL11.glGetInteger((int)34916, (IntBuffer)this.w);
            if (this.w.get(0) == 0) {
                this.p = false;
            } else {
                this.o = BufferUtils.createIntBuffer((int)262144);
                this.o.clear();
                this.o.position(0);
                this.o.limit(262144);
                ARBOcclusionQuery.glGenQueriesARB((IntBuffer)this.o);
            }
        }
        this.r = GL11.glGenLists((int)1);
        GL11.glNewList((int)this.r, (int)4864);
        Random random = new Random(10842L);
        for (int i = 0; i < 500; ++i) {
            GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(random.nextFloat() * 360.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            C_d c_d = C_d.a;
            float f = 0.25f + random.nextFloat() * 0.25f;
            c_d.b();
            c_d.a(-f, -100.0f, f, 1.0f, 1.0f);
            c_d.a(f, -100.0f, f, 0.0f, 1.0f);
            c_d.a(f, -100.0f, -f, 0.0f, 0.0f);
            c_d.a(-f, -100.0f, -f, 1.0f, 0.0f);
            c_d.a();
        }
        GL11.glEndList();
    }

    public final void a(net.minecraft.a.a.World c_g) {
        if (this.b != null) {
            this.b.b(this);
        }
        this.B = -9999.0f;
        this.C = -9999.0f;
        this.D = -9999.0f;
        C_i.a.a(c_g);
        this.b = c_g;
        this.n = new C_f(c_g);
        if (c_g != null) {
            c_g.a(this);
            this.a();
        }
    }

    @Override
    public final void a() {
        int n;
        int n2;
        if (this.h != null) {
            for (n2 = 0; n2 < this.h.length; ++n2) {
                this.h[n2].b();
            }
        }
        this.i = this.b.a / 16;
        this.j = this.b.c / 16;
        this.k = this.b.b / 16;
        this.h = new C_h[this.i * this.j * this.k];
        this.g = new C_h[this.i * this.j * this.k];
        n2 = 0;
        int n3 = 0;
        for (n = 0; n < this.f.size(); ++n) {
            this.f.get((int)n).c = false;
        }
        this.f.clear();
        this.tileEntities.clear();
        for (n = 0; n < this.i; ++n) {
            for (int i = 0; i < this.j; ++i) {
                for (int j = 0; j < this.k; ++j) {
                    if (this.h[(j * this.j + i) * this.i + n] != null) {
                        this.tileEntities.removeAll(this.h[(j * this.j + i) * this.i + n].tileEntityRenderers);
                    }
                    this.h[(j * this.j + i) * this.i + n] = new C_h(this.b, this.tileEntities, n << 4, i << 4, j << 4, 16, this.l + n2);
                    if (this.p) {
                        this.h[(j * this.j + i) * this.i + n].f = this.o.get(n3);
                    }
                    ++n3;
                    this.g[(j * this.j + i) * this.i + n] = this.h[(j * this.j + i) * this.i + n];
                    n2 += 3;
                }
            }
        }
        GL11.glNewList((int)this.d, (int)4864);
        this.i();
        GL11.glEndList();
        GL11.glNewList((int)(this.d + 1), (int)4864);
        this.j();
        GL11.glEndList();
        this.b(0, 0, 0, this.b.a, this.b.c, this.b.b);
    }

    public final void a(net.minecraft.a.d.C_a c_a, C_e c_e, float f) {
        int n;
        net.minecraft.a.a.C_i c_i = this.b.r;
        TileEntityRenderer.instance.cacheActiveRenderInfo(this.b, this.c, this.m.n, this.m.f, f);
        C_i.a.cacheActiveRenderInfo(this.b, this.c, this.m.n, this.m.f, f);
        this.s = 0;
        this.t = 0;
        this.u = 0;
        for (n = 0; n < c_i.a; ++n) {
            for (int i = 0; i < c_i.b; ++i) {
                for (int j = 0; j < c_i.c; ++j) {
                    boolean bl;
                    List<net.minecraft.a.c.C_b> list = c_i.d[(j * c_i.b + i) * c_i.a + n];
                    if (list.size() == 0) continue;
                    int n2 = (n << 3) + 4;
                    int n3 = (i << 3) + 4;
                    int n4 = (j << 3) + 4;
                    this.s += list.size();
                    float f2 = n2;
                    float f3 = n3;
                    float f4 = n4;
                    float f5 = f3;
                    float f6 = f2;
                    if (f6 >= 0.0f && f5 >= 0.0f && f4 >= 0.0f && f6 < (float)this.b.a && f5 < (float)this.b.c && f4 < (float)this.b.b) {
                        int n5 = (int)(f6 / 16.0f);
                        int n6 = (int)(f5 / 16.0f);
                        int n7 = (int)(f4 / 16.0f);
                        bl = this.h[(n7 * this.j + n6) * this.i + n5].b && this.h[(n7 * this.j + n6) * this.i + n5].d;
                    } else {
                        bl = true;
                    }
                    if (!bl) {
                        this.u += list.size();
                        continue;
                    }
                    for (n2 = 0; n2 < list.size(); ++n2) {
                        net.minecraft.a.c.C_b c_b;
                        net.minecraft.a.c.C_b c_b2 = c_b = list.get(n2);
                        f5 = c_b.h - c_a.a;
                        f4 = c_b2.i - c_a.b;
                        f6 = c_b2.j - c_a.c;
                        float f7 = f5 = f5 * f5 + f4 * f4 + f6 * f6;
                        net.minecraft.a.d.C_b c_b3 = c_b2.r;
                        f5 = c_b3.d - c_b3.a;
                        f4 = c_b3.e - c_b3.b;
                        f6 = c_b3.f - c_b3.c;
                        f6 = (f5 + f4 + f6) / 3.0f * 64.0f;
                        if (c_b instanceof net.minecraft.a.c.c.C_f || c_b instanceof net.minecraft.a.c.c.C_d || c_b instanceof net.minecraft.a.c.d.C_f || c_b instanceof net.minecraft.a.c.d.C_a || c_b instanceof net.minecraft.a.c.d.C_b || c_b instanceof net.minecraft.a.c.d.C_d || c_b instanceof C_g || c_b instanceof net.minecraft.a.c.d.C_e) {
                            ++this.t;
                            C_i.a.a(c_b, f);
                            continue;
                        }
                        if (f7 < f6 * f6 && c_e.a(c_b.r) && (c_b != this.m.f || !this.m.w.showArm || this.m.w.thirdPersonView != 0)) {
                            ++this.t;
                            C_i.a.a(c_b, f);
                            c_b.isVisible = true;
                            continue;
                        }
                        c_b.isVisible = false;
                    }
                }
            }
        }
        for (n = 0; n < this.tileEntities.size(); ++n) {
            TileEntityRenderer.instance.renderTileEntity(this.tileEntities.get(n), f);
        }
    }

    public final String b() {
        return "C: " + this.A + "/" + this.x + ", F: " + this.y + ", O: " + this.z;
    }

    public final String c() {
        return "E: " + this.t + "/" + this.s + ", H: " + this.u + ", I: " + (this.s - this.u - this.t) + ", LT: " + this.b.H.size();
    }

    public final int a(EntityPlayer entityPlayer, int n) {
        int n2;
        float f;
        float f2;
        float f3;
        if (n == 0) {
            this.x = 0;
            this.y = 0;
            this.z = 0;
            this.A = 0;
        }
        if ((f3 = entityPlayer.h - this.B) * f3 + (f2 = entityPlayer.i - this.C) * f2 + (f = entityPlayer.j - this.D) * f > 16.0f) {
            this.B = entityPlayer.h;
            this.C = entityPlayer.i;
            this.D = entityPlayer.j;
            Arrays.sort(this.g, new C_l(entityPlayer));
        }
        if (this.p && n == 0) {
            float f4;
            int n3;
            int n4;
            int n5 = 8;
            this.a(0, 8);
            for (n4 = 0; n4 < 8; ++n4) {
                this.g[n4].d = true;
            }
            n2 = 0 + this.b(0, 8, n);
            for (n3 = 0; n3 < this.g.length; ++n3) {
                if (!this.g[n3].d) continue;
                f4 = 256 / (1 << this.m.w.e);
                if (this.m.w.e != 0 && !(this.g[n3].distanceSquared(entityPlayer) < f4 * f4)) {
                    this.g[n3].unload();
                    continue;
                }
                this.g[n3].load();
            }
            do {
                n3 = n5;
                if ((n5 <<= 1) > this.g.length) {
                    n5 = this.g.length;
                }
                GL11.glDisable((int)3553);
                GL11.glDisable((int)2896);
                GL11.glDisable((int)3008);
                GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
                GL11.glDepthMask((boolean)false);
                this.a(n3, n5);
                for (n4 = n3; n4 < n5; ++n4) {
                    int n6;
                    if (!this.g[n4].b) {
                        this.g[n4].d = true;
                    }
                    if (!this.g[n4].b || !this.g[n4].e || this.q % (n6 = (int)(1.0f + (f4 = MathHelper.c(this.g[n4].a(entityPlayer))) / 64.0f)) != n4 % n6) continue;
                    ARBOcclusionQuery.glBeginQueryARB((int)35092, (int)this.g[n4].f);
                    this.g[n4].c();
                    ARBOcclusionQuery.glEndQueryARB((int)35092);
                    this.g[n4].e = true;
                }
                GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                GL11.glDepthMask((boolean)true);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)3008);
                n2 += this.b(n3, n5, n);
            } while (n5 < this.g.length);
        } else {
            n2 = 0 + this.b(0, this.g.length, n);
        }
        return n2;
    }

    private void a(int n, int n2) {
        while (n < n2) {
            if (this.g[n].e) {
                this.w.clear();
                ARBOcclusionQuery.glGetQueryObjectuARB((int)this.g[n].f, (int)34919, (IntBuffer)this.w);
                if (this.w.get(0) != 0) {
                    this.g[n].e = false;
                    this.w.clear();
                    ARBOcclusionQuery.glGetQueryObjectuARB((int)this.g[n].f, (int)34918, (IntBuffer)this.w);
                    this.g[n].d = this.w.get(0) != 0;
                }
            }
            ++n;
        }
    }

    private int b(int n, int n2, int n3) {
        int n4 = 0;
        while (n < n2) {
            if (n3 == 0) {
                ++this.x;
                if (!this.g[n].b) {
                    ++this.y;
                }
                if (this.g[n].b && !this.g[n].d) {
                    ++this.z;
                }
                if (this.g[n].b && this.g[n].d) {
                    ++this.A;
                }
            }
            if (this.g[n].b && this.g[n].d) {
                n4 = this.g[n].a(this.v, n4, n3);
            }
            ++n;
        }
        this.e.clear();
        this.e.put(this.v, 0, n4);
        this.e.flip();
        if (this.e.remaining() > 0) {
            GL11.glCallLists((IntBuffer)this.e);
        }
        return this.e.remaining();
    }

    public final void d() {
        GL11.glBindTexture((int)3553, (int)this.c.a("/terrain.png"));
        GL11.glCallLists((IntBuffer)this.e);
    }

    public final void e() {
        ++this.q;
    }

    public final void a(float f) {
        float f2;
        int n;
        float f3;
        int n2;
        GL11.glDisable((int)3553);
        net.minecraft.a.d.C_a c_a = this.b.b(f);
        float f4 = c_a.a;
        float f5 = c_a.b;
        float f6 = c_a.c;
        GL11.glDepthMask((boolean)false);
        C_d c_d = C_d.a;
        C_d.a.b();
        c_d.a(f4, f5, f6);
        f6 = this.b.c + 10;
        for (n2 = -2048; n2 < this.b.a + 2048; n2 += 512) {
            for (int i = -2048; i < this.b.b + 2048; i += 512) {
                c_d.b(n2, f6, i);
                c_d.b(n2 + 512, f6, i);
                c_d.b(n2 + 512, f6, i + 512);
                c_d.b(n2, f6, i + 512);
            }
        }
        c_d.a();
        if (GameSettings.f) {
            GL11.glDisable((int)3008);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            C_c.a();
            float[] fArray = this.b.calcSunriseSunsetColors(this.b.c(f), f);
            if (fArray != null) {
                GL11.glDisable((int)3553);
                GL11.glShadeModel((int)7425);
                GL11.glPushMatrix();
                f4 = this.m.f.B + (this.m.f.h - this.m.f.B) * f;
                f5 = this.m.f.C + (this.m.f.i - this.m.f.C) * f;
                f3 = this.m.f.D + (this.m.f.j - this.m.f.D) * f;
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GL11.glTranslatef((float)f4, (float)f5, (float)f3);
                GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                float f7 = this.b.c(f);
                GL11.glRotatef((float)(f7 > 0.5f ? 180.0f : 0.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                float f8 = fArray[0];
                float f9 = fArray[1];
                float f10 = fArray[2];
                c_d.a(6);
                c_d.a(f8, f9, f10, fArray[3]);
                c_d.b(0.0f, 100.0f, 0.0f);
                n = 16;
                c_d.a(fArray[0], fArray[1], fArray[2], 0.0f);
                for (int i = 0; i <= n; ++i) {
                    f2 = (float)i * (float)Math.PI * 2.0f / (float)n;
                    float f11 = MathHelper.a(f2);
                    float f12 = MathHelper.b(f2);
                    c_d.b(f11 * 120.0f, f12 * 120.0f, -f12 * 40.0f * fArray[3]);
                }
                c_d.a();
                GL11.glPopMatrix();
                GL11.glShadeModel((int)7424);
            }
            GL11.glEnable((int)3553);
            GL11.glBlendFunc((int)770, (int)1);
        }
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2912);
        GL11.glDisable((int)3008);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)1);
        GL11.glPushMatrix();
        f4 = this.m.f.B + (this.m.f.h - this.m.f.B) * f;
        f5 = this.m.f.C + (this.m.f.i - this.m.f.C) * f;
        float f13 = this.m.f.D + (this.m.f.j - this.m.f.D) * f;
        f3 = 1.0f - this.b.getRainStatus(f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f3);
        GL11.glTranslatef((float)f4, (float)f5, (float)f13);
        GL11.glRotatef((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glRotatef((float)(this.b.c(f) * 360.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glBindTexture((int)3553, (int)this.c.a("/terrain/sun.png"));
        c_d.b();
        c_d.a(-30.0f, 100.0f, -30.0f, 0.0f, 0.0f);
        c_d.a(30.0f, 100.0f, -30.0f, 1.0f, 0.0f);
        c_d.a(30.0f, 100.0f, 30.0f, 1.0f, 1.0f);
        c_d.a(-30.0f, 100.0f, 30.0f, 0.0f, 1.0f);
        c_d.a();
        if (this.b.type == 8) {
            GL11.glBindTexture((int)3553, (int)this.c.a("/terrain/earth.png"));
        } else if (this.b.isBloodMoon()) {
            GL11.glBindTexture((int)3553, (int)this.c.a("/terrain/blood_moon.png"));
        } else {
            GL11.glBindTexture((int)3553, (int)this.c.a("/terrain/moon.png"));
        }
        c_d.b();
        c_d.a(-20.0f, -100.0f, 20.0f, 1.0f, 1.0f);
        c_d.a(20.0f, -100.0f, 20.0f, 0.0f, 1.0f);
        c_d.a(20.0f, -100.0f, -20.0f, 0.0f, 0.0f);
        c_d.a(-20.0f, -100.0f, -20.0f, 1.0f, 0.0f);
        c_d.a();
        if (this.m.w.stars) {
            GL11.glDisable((int)3553);
            float f14 = this.b.a(f);
            GL11.glColor4f((float)f14, (float)f14, (float)f14, (float)f3);
            GL11.glCallList((int)this.r);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)3553);
        }
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)2912);
        GL11.glPopMatrix();
        GL11.glDepthMask((boolean)true);
        if (this.b.type != 8) {
            if (this.b.mc.w.cloudStyle == 0) {
                this.renderCloudsFancy(f);
            } else if (this.b.mc.w.cloudStyle == 1) {
                GL11.glBindTexture((int)3553, (int)this.c.a("/environment/clouds.png"));
                GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                net.minecraft.a.d.C_a c_a2 = this.b.e(f);
                f5 = c_a2.a;
                f13 = c_a2.b;
                f4 = c_a2.c;
                float f15 = this.b.u;
                f2 = ((float)this.q + f) * 4.8828125E-4f * 0.03f;
                c_d.b();
                c_d.a(f5, f13, f4);
                for (n = -2048; n < this.b.a + 2048; n += 512) {
                    for (n2 = -2048; n2 < this.b.b + 2048; n2 += 512) {
                        c_d.a(n, f15, n2 + 512, (float)n * 4.8828125E-4f + f2, (float)(n2 + 512) * 4.8828125E-4f);
                        c_d.a(n + 512, f15, n2 + 512, (float)(n + 512) * 4.8828125E-4f + f2, (float)(n2 + 512) * 4.8828125E-4f);
                        c_d.a(n + 512, f15, n2, (float)(n + 512) * 4.8828125E-4f + f2, (float)n2 * 4.8828125E-4f);
                        c_d.a(n, f15, n2, (float)n * 4.8828125E-4f + f2, (float)n2 * 4.8828125E-4f);
                        c_d.a(n, f15, n2, (float)n * 4.8828125E-4f + f2, (float)n2 * 4.8828125E-4f);
                        c_d.a(n + 512, f15, n2, (float)(n + 512) * 4.8828125E-4f + f2, (float)n2 * 4.8828125E-4f);
                        c_d.a(n + 512, f15, n2 + 512, (float)(n + 512) * 4.8828125E-4f + f2, (float)(n2 + 512) * 4.8828125E-4f);
                        c_d.a(n, f15, n2 + 512, (float)n * 4.8828125E-4f + f2, (float)(n2 + 512) * 4.8828125E-4f);
                    }
                }
                c_d.a();
            }
        }
    }

    public void renderCloudsFancy(float f) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        C_d c_d = C_d.a;
        float f2 = 12.0f;
        float f3 = 4.0f;
        double d2 = (double)(((float)this.q + f) * 0.03f) / (double)f2;
        double d3 = (double)f2 + (double)0.33f;
        float f4 = 0.03f;
        if (this.b.season.currentSeason == 2 && !this.m.l) {
            double d4 = (double)(this.b.getWindForce() * f4) / (double)f2;
            double d5 = 0.0;
            double d6 = 0.0;
            switch (this.b.getWindDirection()) {
                case 0: {
                    d5 = -d4;
                    break;
                }
                case 1: {
                    d6 = -d4;
                    break;
                }
                case 2: {
                    d5 = d4;
                    d6 = -d4;
                    break;
                }
                case 3: {
                    d5 = -d4;
                    d6 = d4;
                    break;
                }
                case 4: {
                    d5 = -d4;
                    d6 = -d4;
                    break;
                }
                case 5: {
                    d5 = d4;
                    d6 = d4;
                    break;
                }
                case 6: {
                    d5 = d4;
                    break;
                }
                case 7: {
                    d6 = d4;
                }
            }
            double d7 = 0.02;
            this.cloudWindVX += (d5 - this.cloudWindVX) * d7;
            this.cloudWindVZ += (d6 - this.cloudWindVZ) * d7;
            double d8 = 0.1;
            this.cloudWindOffX += this.cloudWindVX * d8;
            this.cloudWindOffZ += this.cloudWindVZ * d8;
            d2 += this.cloudWindOffX;
            d3 += this.cloudWindOffZ;
        }
        float f5 = this.b.u;
        int n = MathHelper.a(d2 / 2048.0);
        int n2 = MathHelper.a(d3 / 2048.0);
        d2 -= (double)(n * 2048);
        d3 -= (double)(n2 * 2048);
        GL11.glBindTexture((int)3553, (int)this.c.a("/clouds.png"));
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        net.minecraft.a.d.C_a c_a = this.b.e(f);
        float f6 = c_a.a;
        float f7 = c_a.b;
        float f8 = c_a.c;
        float f9 = (float)(d2 * 0.0);
        float f10 = (float)(d3 * 0.0);
        float f11 = 0.00390625f;
        f9 = (float)MathHelper.a(d2) * f11;
        f10 = (float)MathHelper.a(d3) * f11;
        float f12 = (float)(d2 - (double)MathHelper.a(d2));
        float f13 = (float)(d3 - (double)MathHelper.a(d3));
        int n3 = 8;
        int n4 = 6;
        float f14 = 9.765625E-4f;
        GL11.glScalef((float)f2, (float)1.0f, (float)f2);
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                GL11.glColorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
            } else {
                GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            }
            for (int j = -n4 + 1; j <= n4; ++j) {
                for (int k = -n4 + 1; k <= n4; ++k) {
                    int n5;
                    c_d.b();
                    float f15 = j * n3;
                    float f16 = k * n3;
                    float f17 = f15 - f12;
                    float f18 = f16 - f13;
                    c_d.a(f6 * 0.7f, f7 * 0.7f, f8 * 0.7f, 0.8f);
                    C_d.c(0.0f, -1.0f, 0.0f);
                    c_d.a(f17 + 0.0f, f5 + 0.0f, f18 + (float)n3, (f15 + 0.0f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                    c_d.a(f17 + (float)n3, f5 + 0.0f, f18 + (float)n3, (f15 + (float)n3) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                    c_d.a(f17 + (float)n3, f5 + 0.0f, f18 + 0.0f, (f15 + (float)n3) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    c_d.a(f17 + 0.0f, f5 + 0.0f, f18 + 0.0f, (f15 + 0.0f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    c_d.a(f6, f7, f8, 0.8f);
                    C_d.c(0.0f, 1.0f, 0.0f);
                    c_d.a(f17 + 0.0f, f5 + f3 - f14, f18 + (float)n3, (f15 + 0.0f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                    c_d.a(f17 + (float)n3, f5 + f3 - f14, f18 + (float)n3, (f15 + (float)n3) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                    c_d.a(f17 + (float)n3, f5 + f3 - f14, f18 + 0.0f, (f15 + (float)n3) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    c_d.a(f17 + 0.0f, f5 + f3 - f14, f18 + 0.0f, (f15 + 0.0f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    c_d.a(f6 * 0.9f, f7 * 0.9f, f8 * 0.9f, 0.8f);
                    C_d.c(-1.0f, 0.0f, 0.0f);
                    for (n5 = 0; n5 < n3; ++n5) {
                        c_d.a(f17 + (float)n5 + 0.0f, f5 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 0.0f, f5 + f3, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 0.0f, f5 + f3, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 0.0f, f5 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    }
                    C_d.c(1.0f, 0.0f, 0.0f);
                    for (n5 = 0; n5 < n3; ++n5) {
                        c_d.a(f17 + (float)n5 + 1.0f - f14, f5 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 1.0f - f14, f5 + f3, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + (float)n3) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 1.0f - f14, f5 + f3, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                        c_d.a(f17 + (float)n5 + 1.0f - f14, f5 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f11 + f9, (f16 + 0.0f) * f11 + f10);
                    }
                    c_d.a(f6 * 0.8f, f7 * 0.8f, f8 * 0.8f, 0.8f);
                    C_d.c(0.0f, 0.0f, -1.0f);
                    for (n5 = 0; n5 < n3; ++n5) {
                        c_d.a(f17 + 0.0f, f5 + f3, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + (float)n3, f5 + f3, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + (float)n3, f5 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + 0.0f, f5 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                    }
                    C_d.c(0.0f, 0.0f, 1.0f);
                    for (n5 = 0; n5 < n3; ++n5) {
                        c_d.a(f17 + 0.0f, f5 + f3, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + (float)n3, f5 + f3, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + (float)n3, f5 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                        c_d.a(f17 + 0.0f, f5 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f11 + f9, (f16 + (float)n5 + 0.5f) * f11 + f10);
                    }
                    c_d.a();
                }
            }
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
    }

    public final void f() {
        float f = this.b.c(0, this.b.g(), 0);
        GL11.glBindTexture((int)3553, (int)this.c.a("/dirt.png"));
        if (this.b.type == 4 && this.b.m == net.minecraft.a.a.b.Block.r.at) {
            GL11.glBindTexture((int)3553, (int)this.c.a("/redsand.png"));
        }
        if (this.b.g() > this.b.h() && this.b.m == net.minecraft.a.a.b.Block.p.at) {
            if (this.b.type == 4) {
                GL11.glBindTexture((int)3553, (int)this.c.a("/sand.png"));
            } else if (this.b.theme == 4) {
                GL11.glBindTexture((int)3553, (int)this.c.a("/mycelium.png"));
            } else {
                GL11.glBindTexture((int)3553, (int)this.c.a("/grass.png"));
            }
        }
        GL11.glColor4f((float)f, (float)f, (float)f, (float)1.0f);
        GL11.glEnable((int)3553);
        if (this.b.type != 8 && this.b.type != 2) {
            GL11.glCallList((int)this.d);
        }
    }

    private void i() {
        C_d c_d = C_d.a;
        float f = this.b.g();
        int n = 128;
        if (128 > this.b.a) {
            n = this.b.a;
        }
        if (n > this.b.b) {
            n = this.b.b;
        }
        int n2 = 2048 / n;
        c_d.b();
        for (int i = -n * n2; i < this.b.a + n * n2; i += n) {
            for (int j = -n * n2; j < this.b.b + n * n2; j += n) {
                if (!(f < 0.0f) && i >= 0 && j >= 0 && i < this.b.a && j < this.b.b) continue;
                c_d.a(i, f, j + n, 0.0f, n);
                c_d.a(i + n, f, j + n, n, n);
                c_d.a(i + n, f, j, n, 0.0f);
                c_d.a(i, f, j, 0.0f, 0.0f);
            }
        }
        c_d.a();
    }

    public final void g() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBindTexture((int)3553, (int)this.c.a("/water.png"));
        float f = this.b.c(0, this.b.h(), 0);
        if (net.minecraft.a.a.b.Block.h[this.b.m] > 0) {
            f = 1.0f;
        }
        GL11.glColor4f((float)f, (float)f, (float)f, (float)1.0f);
        if (this.b.type != 8 && this.b.type != 2) {
            GL11.glCallList((int)(this.d + 1));
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)3042);
    }

    private void j() {
        float f = this.b.h();
        GL11.glBlendFunc((int)770, (int)771);
        C_d c_d = C_d.a;
        int n = 128;
        if (128 > this.b.a) {
            n = this.b.a;
        }
        if (n > this.b.b) {
            n = this.b.b;
        }
        int n2 = 2048 / n;
        c_d.b();
        float f2 = net.minecraft.a.a.b.Block.p.au;
        float f3 = net.minecraft.a.a.b.Block.p.aw;
        for (int i = -n * n2; i < this.b.a + n * n2; i += n) {
            for (int j = -n * n2; j < this.b.b + n * n2; j += n) {
                float f4 = f - 0.111f;
                if (!(f < 0.0f) && i >= 0 && j >= 0 && i < this.b.a && j < this.b.b) continue;
                c_d.a((float)i + f2, f4, (float)(j + n) + f3, 0.0f, n);
                c_d.a((float)(i + n) + f2, f4, (float)(j + n) + f3, n, n);
                c_d.a((float)(i + n) + f2, f4, (float)j + f3, n, 0.0f);
                c_d.a((float)i + f2, f4, (float)j + f3, 0.0f, 0.0f);
                c_d.a((float)i + f2, f4, (float)j + f3, 0.0f, 0.0f);
                c_d.a((float)(i + n) + f2, f4, (float)j + f3, n, 0.0f);
                c_d.a((float)(i + n) + f2, f4, (float)(j + n) + f3, n, n);
                c_d.a((float)i + f2, f4, (float)(j + n) + f3, 0.0f, n);
            }
        }
        c_d.a();
        GL11.glDisable((int)3042);
    }

    public final void a(EntityPlayer entityPlayer) {
        Collections.sort(this.f, new C_a(entityPlayer));
        int n = this.f.size() - 1;
        int n2 = this.f.size();
        for (int i = 0; i < n2; ++i) {
            C_h c_h;
            C_h c_h2 = this.f.get(n - i);
            if (c_h.a(entityPlayer) > 2500.0f && i > 4) {
                return;
            }
            this.f.remove(c_h2);
            c_h2.a();
            c_h2.c = false;
        }
    }

    public final void a(net.minecraft.a.d.C_c c_c, int n, ItemStack itemStack) {
        C_d c_d = C_d.a;
        GL11.glEnable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glBlendFunc((int)770, (int)1);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)((MathHelper.a((float)System.currentTimeMillis() / 100.0f) * 0.2f + 0.4f) * 0.5f));
        if (this.a > 0.0f) {
            GL11.glBlendFunc((int)774, (int)768);
            int n2 = this.c.a("/terrain.png");
            GL11.glBindTexture((int)3553, (int)n2);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
            GL11.glPushMatrix();
            n2 = this.b.a(c_c.b, c_c.c, c_c.d);
            net.minecraft.a.a.b.Block c_x = n2 > 0 ? net.minecraft.a.a.b.Block.c[n2] : null;
            GL11.glDisable((int)3008);
            c_d.b();
            c_d.c();
            if (c_x == null) {
                c_x = net.minecraft.a.a.b.Block.i;
            }
            this.n.a(c_x, c_c.b, c_c.c, c_c.d, 481 + (int)(this.a * 10.0f));
            c_d.a();
            GL11.glEnable((int)3008);
            GL11.glDepthMask((boolean)true);
            GL11.glPopMatrix();
        }
        GL11.glDisable((int)3042);
        GL11.glDisable((int)3008);
    }

    public final void a(net.minecraft.a.d.C_c c_c, int n) {
        C_d c_d;
        net.minecraft.a.d.C_b c_b;
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.4f);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDepthMask((boolean)false);
        n = this.b.a(c_c.b, c_c.c, c_c.d);
        if (n > 0) {
            c_b = net.minecraft.a.a.b.Block.c[n].getSelectedBoundingBoxFromPool(this.b, c_c.b, c_c.c, c_c.d).b(0.002f, 0.002f, 0.002f);
            net.minecraft.a.a.b.Block.c[n].setBlockBoundsBasedOnState(this.b, c_c.b, c_c.c, c_c.d);
            c_d = C_d.a;
            c_d.a(3);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.a();
            c_d.a(3);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.a();
            c_d.a(1);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.f);
            c_d.b(c_b.d, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.f);
            c_d.a();
        }
        if (c_c != null && c_c.g instanceof net.minecraft.a.c.C_a) {
            c_b = c_c.g.r.b(0.015f, 0.015f, 0.015f);
            c_d = C_d.a;
            c_d.a(3);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.a();
            c_d.a(3);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.a();
            c_d.a(1);
            c_d.b(c_b.a, c_b.b, c_b.c);
            c_d.b(c_b.a, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.c);
            c_d.b(c_b.d, c_b.e, c_b.c);
            c_d.b(c_b.d, c_b.b, c_b.f);
            c_d.b(c_b.d, c_b.e, c_b.f);
            c_d.b(c_b.a, c_b.b, c_b.f);
            c_d.b(c_b.a, c_b.e, c_b.f);
            c_d.a();
        }
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
    }

    private void b(int n, int n2, int n3, int n4, int n5, int n6) {
        n /= 16;
        n2 /= 16;
        n3 /= 16;
        n4 /= 16;
        n5 /= 16;
        n6 /= 16;
        if (n < 0) {
            n = 0;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        if (n3 < 0) {
            n3 = 0;
        }
        if (n4 > this.i - 1) {
            n4 = this.i - 1;
        }
        if (n5 > this.j - 1) {
            n5 = this.j - 1;
        }
        if (n6 > this.k - 1) {
            n6 = this.k - 1;
        }
        while (n <= n4) {
            for (int i = n2; i <= n5; ++i) {
                for (int j = n3; j <= n6; ++j) {
                    C_h c_h = this.h[(j * this.j + i) * this.i + n];
                    if (c_h.c) continue;
                    c_h.c = true;
                    this.f.add(this.h[(j * this.j + i) * this.i + n]);
                }
            }
            ++n;
        }
    }

    @Override
    public final void a(int n, int n2, int n3) {
        this.b(n - 1, n2 - 1, n3 - 1, n + 1, n2 + 1, n3 + 1);
    }

    @Override
    public final void a(int n, int n2, int n3, int n4, int n5, int n6) {
        this.b(n - 1, n2 - 1, n3 - 1, n4 + 1, n5 + 1, n6 + 1);
    }

    public final void a(C_e c_e) {
        for (int i = 0; i < this.h.length; ++i) {
            this.h[i].a(c_e);
        }
    }

    @Override
    public final void a(String string, float f, float f2, float f3, float f4, float f5) {
        this.m.x.a(string, f, f2, f3, f4, f5);
    }

    @Override
    public void playMobSound(String string, float f, float f2, float f3, float f4, float f5) {
        this.m.x.playMobSound(string, f, f2, f3, f4, f5);
    }

    @Override
    public void playBlockSound(String string, float f, float f2, float f3, float f4, float f5) {
        this.m.x.playBlockSound(string, f, f2, f3, f4, f5);
    }

    @Override
    public final void a(String string, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = this.m.f.h - f;
        float f8 = this.m.f.i - f2;
        float f9 = this.m.f.j - f3;
        if (f7 * f7 + f8 * f8 + f9 * f9 <= 256.0f) {
            if (string == "bubble") {
                this.m.g.a(new net.minecraft.client.f.C_a(this.b, f, f2, f3, f4, f5, f6, 0));
            } else if (string == "bigbubble") {
                this.m.g.a(new net.minecraft.client.f.C_a(this.b, f, f2, f3, f4, f5, f6, 1));
            } else if (string == "smoke") {
                this.m.g.a(new C_j(this.b, f, f2, f3));
            } else if (string == "puff") {
                this.m.g.a(new C_x(this.b, f, f2, f3));
            } else if (string == "crit") {
                this.m.g.a(new C_o(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "swipe") {
                this.m.g.a(new C_ab(this.b, f, f2, f3, f4));
            } else if (string == "explode") {
                this.m.g.a(new net.minecraft.client.f.C_h(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "flame") {
                this.m.g.a(new net.minecraft.client.f.C_c(this.b, f, f2, f3));
            } else if (string == "hell") {
                net.minecraft.client.f.C_c c_c = new net.minecraft.client.f.C_c(this.b, f, f2, f3);
                c_c.P = 131;
                this.m.g.a(c_c);
            } else if (string == "fire") {
                this.m.g.a(new net.minecraft.client.f.C_c(this.b, f, f2, f3, 10));
            } else if (string == "lava") {
                this.m.g.a(new net.minecraft.client.f.C_g(this.b, f, f2, f3));
            } else if (string == "splash") {
                this.m.g.a(new net.minecraft.client.f.C_f(this.b, f, f2, f3));
            } else if (string == "leaf") {
                this.m.g.a(new C_r(this.b, f, f2, f3));
            } else if (string == "firefly") {
                this.m.g.a(new C_s(this.b, f, f2, f3, f9, f9, f9));
            } else if (string == "snowballpoof") {
                this.m.g.a(new C_y(this.b, f, f2, f3, Item.snowball));
            } else if (string == "sandballpoof") {
                this.m.g.a(new C_y(this.b, f, f2, f3, 238));
            } else if (string == "slimeballpoof") {
                this.m.g.a(new C_y(this.b, f, f2, f3, Item.slimeBall));
            } else if (string == "townaura") {
                this.m.g.a(new net.minecraft.client.f.C_l(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "dripWater") {
                this.m.g.a(new C_p(this.b, f, f2, f3, net.minecraft.a.a.d.C_c.f));
            } else if (string == "dripLava") {
                this.m.g.a(new C_p(this.b, f, f2, f3, net.minecraft.a.a.d.C_c.g));
            } else if (string == "suspended") {
                this.m.g.a(new C_aa(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "note") {
                this.m.g.a(new C_v(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "spell") {
                this.m.g.a(new C_z(this.b, f, f2, f3, 0.0f, 0.0f, 0.0f));
            } else if (string == "portal") {
                this.m.g.a(new C_w(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "grow") {
                this.m.g.a(new C_t(this.b, f, f2, f3, f4, f5, f6));
            } else if (string == "dust") {
                this.m.g.a(new C_q(this.b, f, f2, f3, f4, f5, f6));
            } else {
                if (string == "largesmoke") {
                    this.m.g.a(new C_j(this.b, f, f2, f3, 2.5f));
                }
                if (string.startsWith("iconcrack_")) {
                    int n = Integer.parseInt(string.substring(string.indexOf("_") + 1));
                    this.m.g.a(new C_u(this.b, f, f2, f3, f4, f5, f6, Item.b[n]));
                }
            }
        }
    }

    @Override
    public final void a(String string, float f, float f2, float f3, float f4) {
    }

    @Override
    public final void a(net.minecraft.a.c.C_b c_b) {
        if (c_b.N != null) {
            this.c.a(c_b.N, new net.minecraft.client.a.C_c());
        }
    }

    @Override
    public final void b(net.minecraft.a.c.C_b c_b) {
        if (c_b.N != null) {
            this.c.b(c_b.N);
        }
    }

    @Override
    public final void h() {
        GL11.glNewList((int)this.d, (int)4864);
        this.i();
        GL11.glEndList();
        GL11.glNewList((int)(this.d + 1), (int)4864);
        this.j();
        GL11.glEndList();
        for (C_h c_h : this.h) {
            if (c_h.c) continue;
            c_h.c = true;
            this.f.add(c_h);
        }
    }

    @Override
    public void updateTileEntity(int n, int n2, int n3, net.minecraft.a.a.b.a.TileEntity c_a) {
    }

    @Override
    public void playRecord(String string, int n, int n2, int n3) {
        if (string != null) {
            if (string.equals("Disc VIII")) {
                this.m.t.setRecordPlayingMessage("RyPieEye - " + string);
            } else if (string.equals("Magnetic Circuit")) {
                this.m.t.setRecordPlayingMessage("Notch - " + string);
            } else {
                this.m.t.setRecordPlayingMessage("Soybean_56 - " + string);
            }
        }
        this.m.x.playStreaming(string, n, n2, n3, 1.0f, 1.0f);
        this.m.x.a.setVolume("streaming", this.m.w.streamingVol);
    }
}

