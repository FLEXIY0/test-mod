/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package net.minecraft.client.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_b;
import net.minecraft.client.a.C_d;
import net.minecraft.client.a.C_f;
import net.minecraft.client.a.b.C_e;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.lwjgl.opengl.GL11;
import util.MathHelper;

public final class C_h {
    private World g;
    private int h = -1;
    private static C_d i = C_d.a;
    public static int a = 0;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    public boolean b = false;
    private boolean[] p = new boolean[2];
    public int q;
    public int r;
    public int s;
    public boolean c;
    private C_b t;
    private C_f u;
    public boolean d = true;
    public boolean e;
    public int f;
    public List<TileEntity> tileEntityRenderers = new ArrayList<TileEntity>();
    private List<TileEntity> tileEntities;

    public C_h(World c_g, List<TileEntity> list, int n, int n2, int n3, int n4, int n5) {
        this.u = new C_f(c_g);
        this.g = c_g;
        this.tileEntities = list;
        this.j = n;
        this.k = n2;
        this.l = n3;
        this.o = 16;
        this.n = 16;
        this.m = 16;
        this.q = n + this.m / 2;
        this.r = n2 + this.n / 2;
        this.s = n3 + this.o / 2;
        MathHelper.c(this.m * this.m + this.n * this.n + this.o * this.o);
        this.t = new C_b(n, n2, n3, n + this.m, n2 + this.n, n3 + this.o).b(2.0f, 2.0f, 2.0f);
        this.h = n5;
        this.d();
        GL11.glDisable((int)3553);
        GL11.glNewList((int)(n5 + 2), (int)4864);
        net.minecraft.client.a.a.C_e.a(this.t);
        GL11.glEndList();
        GL11.glEnable((int)3553);
    }

    public final void a() {
        if (this.c) {
            int n;
            ++a;
            int n2 = this.j;
            int n3 = this.k;
            int n4 = this.l;
            int n5 = this.j + this.m;
            int n6 = this.k + this.n;
            int n7 = this.l + this.o;
            for (n = 0; n < 2; ++n) {
                this.p[n] = true;
            }
            HashSet<TileEntity> hashSet = new HashSet<TileEntity>();
            hashSet.addAll(this.tileEntityRenderers);
            this.tileEntityRenderers.clear();
            for (n = 0; n < 2; ++n) {
                boolean bl = false;
                boolean bl2 = false;
                this.u.setRenderPass(n);
                i.b();
                GL11.glNewList((int)(this.h + n), (int)4864);
                for (int i = n3; i < n6; ++i) {
                    for (int j = n4; j < n7; ++j) {
                        int n8 = (i * this.g.b + j) * this.g.a + n2;
                        for (int k = n2; k < n5; ++k) {
                            int n9;
                            Object object;
                            int n10;
                            if ((n10 = this.g.d[n8++] & 0xFF) <= 0) continue;
                            if (n == 0 && Block.c[n10].hasTileEntity() && TileEntityRenderer.instance.hasSpecialRenderer((TileEntity)(object = this.g.j(k, i, j)))) {
                                this.tileEntityRenderers.add((TileEntity)object);
                            }
                            if ((n9 = ((Block)(object = Block.c[n10])).f()) != n) {
                                bl = true;
                            }
                            if (n9 != n && n9 != 2) continue;
                            bl2 |= this.u.b((Block)object, k, i, j);
                        }
                    }
                }
                i.a();
                GL11.glEndList();
                if (bl2) {
                    this.p[n] = false;
                }
                if (!bl) break;
            }
            HashSet<TileEntity> hashSet2 = new HashSet<TileEntity>();
            hashSet2.addAll(this.tileEntityRenderers);
            hashSet2.removeAll(hashSet);
            this.tileEntities.addAll(hashSet2);
            hashSet.removeAll(this.tileEntityRenderers);
            this.tileEntities.removeAll(hashSet);
        }
    }

    public final float a(net.minecraft.a.c.C_e c_e) {
        float f = c_e.h - (float)this.q;
        float f2 = c_e.i - (float)this.r;
        float f3 = c_e.j - (float)this.s;
        return f * f + f2 * f2 + f3 * f3;
    }

    private void d() {
        for (int i = 0; i < 2; ++i) {
            this.p[i] = true;
        }
        this.b = false;
    }

    public final void b() {
        this.d();
        this.g = null;
    }

    public final int a(int[] nArray, int n, int n2) {
        if (!this.b) {
            return n;
        }
        if (!this.p[n2]) {
            nArray[n++] = this.h + n2;
        }
        return n;
    }

    public void load() {
        this.d = true;
    }

    public void unload() {
        this.d = false;
    }

    public final float distanceSquared(EntityPlayer entityPlayer) {
        float f = entityPlayer.h - (float)this.j;
        float f2 = entityPlayer.i - (float)this.k;
        float f3 = entityPlayer.j - (float)this.l;
        return f * f + f2 * f2 + f3 * f3;
    }

    public void render(int n) {
        GL11.glCallList((int)(this.h + n));
    }

    public final void a(C_e c_e) {
        this.b = c_e.a(this.t);
    }

    public final void c() {
        GL11.glCallList((int)(this.h + 2));
    }
}

