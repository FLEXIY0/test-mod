/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.RenderEngine;
import net.minecraft.client.f.C_b;
import net.minecraft.client.f.C_k;
import net.minecraft.client.f.C_m;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_d {
    private World a;
    private List<C_k>[] b = new List[4];
    private RenderEngine c;
    private Random d = new Random();

    public C_d(World c_g, RenderEngine renderEngine) {
        if (c_g != null) {
            this.a = c_g;
        }
        this.c = renderEngine;
        for (int i = 0; i < 4; ++i) {
            this.b[i] = new ArrayList<C_k>();
        }
    }

    public final void a(C_k c_k) {
        int n = c_k.c();
        this.b[n].add(c_k);
    }

    public final void a() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < this.b[i].size(); ++j) {
                C_k c_k = this.b[i].get(j);
                c_k.b_();
                if (!c_k.u) continue;
                this.b[i].remove(j--);
            }
        }
    }

    public final void a(net.minecraft.a.c.C_b c_b, float f) {
        float f2 = MathHelper.b(c_b.n * (float)Math.PI / 180.0f);
        float f3 = MathHelper.a(c_b.n * (float)Math.PI / 180.0f);
        float f4 = -f3 * MathHelper.a(c_b.o * (float)Math.PI / 180.0f);
        float f5 = f2 * MathHelper.a(c_b.o * (float)Math.PI / 180.0f);
        float f6 = MathHelper.b(c_b.o * (float)Math.PI / 180.0f);
        C_k.interpX = c_b.B + (c_b.h - c_b.B) * f;
        C_k.interpY = c_b.C + (c_b.i - c_b.C) * f;
        C_k.interpZ = c_b.D + (c_b.j - c_b.D) * f;
        for (int i = 0; i < 3; ++i) {
            if (this.b[i].size() == 0) continue;
            int n = 0;
            if (i == 0) {
                n = this.c.a("/particles.png");
            }
            if (i == 1) {
                n = this.c.a("/terrain.png");
            }
            if (i == 2) {
                n = this.c.a("/gui/items.png");
            }
            GL11.glBindTexture((int)3553, (int)n);
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
            net.minecraft.client.a.C_d.a.b();
            for (int j = 0; j < this.b[i].size(); ++j) {
                this.b[i].get(j).a(c_d, f, f2, f6, f3, f4, f5);
            }
            c_d.a();
            GL11.glDisable((int)3042);
        }
    }

    public void renderLitParticles(net.minecraft.a.c.C_b c_b, float f) {
        float f2 = MathHelper.b(c_b.n * (float)Math.PI / 180.0f);
        float f3 = MathHelper.a(c_b.n * (float)Math.PI / 180.0f);
        float f4 = -f3 * MathHelper.a(c_b.o * (float)Math.PI / 180.0f);
        float f5 = f2 * MathHelper.a(c_b.o * (float)Math.PI / 180.0f);
        float f6 = MathHelper.b(c_b.o * (float)Math.PI / 180.0f);
        int n = 3;
        if (this.b[n].size() != 0) {
            net.minecraft.client.a.C_d c_d = net.minecraft.client.a.C_d.a;
            for (int i = 0; i < this.b[n].size(); ++i) {
                C_k c_k = this.b[n].get(i);
                c_k.a(c_d, f, f2, f6, f3, f4, f5);
            }
        }
    }

    public final void a(World c_g) {
        this.a = c_g;
        for (int i = 0; i < 4; ++i) {
            this.b[i].clear();
        }
    }

    public final void a(int n, int n2, int n3) {
        int n4;
        if (this.a.mc.w.particleCount <= 1 && (n4 = this.a.a(n, n2, n3)) != 0) {
            Block c_x = Block.c[n4];
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    for (int k = 0; k < 4; ++k) {
                        float f = (float)n + ((float)i + 0.5f) / 4.0f;
                        float f2 = (float)n2 + ((float)j + 0.5f) / 4.0f;
                        float f3 = (float)n3 + ((float)k + 0.5f) / 4.0f;
                        if (C_f.renderItemIn3d(Block.c[c_x.at].a()) && !c_x.simpleParticles && this.a.mc.w.fancyParticles) {
                            this.a(new C_b(this.a, f, f2, f3, f - (float)n - 0.5f, f2 - (float)n2 - 0.5f, f3 - (float)n3 - 0.5f, c_x, this.a.e(n, n2, n3)));
                            continue;
                        }
                        this.a(new C_m(this.a, f, f2, f3, f - (float)n - 0.5f, f2 - (float)n2 - 0.5f, f3 - (float)n3 - 0.5f, c_x, this.a.e(n, n2, n3)));
                    }
                }
            }
        }
    }

    public final void a(int n, int n2, int n3, int n4) {
        int n5 = this.a.a(n, n2, n3);
        if (n5 != 0) {
            Block c_x = Block.c[n5];
            float f = (float)n + this.d.nextFloat() * (c_x.ax - c_x.au - 0.2f) + 0.1f + c_x.au;
            float f2 = (float)n2 + this.d.nextFloat() * (c_x.ay - c_x.av - 0.2f) + 0.1f + c_x.av;
            float f3 = (float)n3 + this.d.nextFloat() * (c_x.az - c_x.aw - 0.2f) + 0.1f + c_x.aw;
            if (n4 == 0) {
                f2 = (float)n2 + c_x.av - 0.1f;
            }
            if (n4 == 1) {
                f2 = (float)n2 + c_x.ay + 0.1f;
            }
            if (n4 == 2) {
                f3 = (float)n3 + c_x.aw - 0.1f;
            }
            if (n4 == 3) {
                f3 = (float)n3 + c_x.az + 0.1f;
            }
            if (n4 == 4) {
                f = (float)n + c_x.au - 0.1f;
            }
            if (n4 == 5) {
                f = (float)n + c_x.ax + 0.1f;
            }
            if (C_f.renderItemIn3d(Block.c[c_x.at].a()) && !c_x.simpleParticles && this.a.mc.w.fancyParticles) {
                this.a(new C_b(this.a, f, f2, f3, 0.0f, 0.0f, 0.0f, c_x, this.a.e(n, n2, n3)).c(0.2f).d(0.6f));
            } else {
                this.a(new C_m(this.a, f, f2, f3, 0.0f, 0.0f, 0.0f, c_x, this.a.e(n, n2, n3)).c(0.2f).d(0.6f));
            }
        }
    }

    public final String b() {
        return "" + (this.b[0].size() + this.b[1].size() + this.b[2].size() + this.b[3].size());
    }
}

