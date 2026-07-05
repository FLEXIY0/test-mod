/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.a.a.World;
import net.minecraft.a.a.C_k;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.c.C_b;
import net.minecraft.a.d.C_a;
import util.MathHelper;

public class C_m {
    public boolean isFlaming = false;
    private World worldObj;
    public float explosionX;
    public float explosionY;
    public float explosionZ;
    public C_b exploder;
    public float explosionSize;
    public Set<C_k> destroyedBlockPositions = new HashSet<C_k>();

    public C_m(World c_g, C_b c_b, float f, float f2, float f3, float f4) {
        this.worldObj = c_g;
        this.exploder = c_b;
        this.explosionSize = f4;
        this.explosionX = f;
        this.explosionY = f2;
        this.explosionZ = f3;
    }

    public void doExplosionA() {
        float f;
        float f2;
        float f3;
        int n;
        int n2;
        int n3;
        int n4;
        float f4;
        float f5;
        float f6;
        int n5;
        int n6;
        int n7;
        float f7 = this.explosionX;
        float f8 = this.explosionY;
        float f9 = this.explosionZ;
        float f10 = this.explosionSize;
        this.worldObj.a(f7, f8, f9, "random.explode", 4.0f, (1.0f + (this.worldObj.q.nextFloat() - this.worldObj.q.nextFloat()) * 0.2f) * 0.7f);
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        float f11 = f10;
        for (n7 = 0; n7 < 16; ++n7) {
            for (n6 = 0; n6 < 16; ++n6) {
                for (n5 = 0; n5 < 16; ++n5) {
                    if (n7 != 0 && n7 != 15 && n6 != 0 && n6 != 15 && n5 != 0 && n5 != 15) continue;
                    f6 = (float)n7 / 15.0f * 2.0f - 1.0f;
                    float f12 = (float)n6 / 15.0f * 2.0f - 1.0f;
                    float f13 = (float)n5 / 15.0f * 2.0f - 1.0f;
                    float f14 = (float)Math.sqrt(f6 * f6 + f12 * f12 + f13 * f13);
                    f6 /= f14;
                    f12 /= f14;
                    f13 /= f14;
                    float f15 = f7;
                    f5 = f8;
                    f4 = f9;
                    for (float f16 = f10 * (0.7f + this.worldObj.q.nextFloat() * 0.6f); f16 > 0.0f; f16 -= 0.22500001f) {
                        n4 = (int)f15;
                        n3 = (int)f5;
                        n2 = (int)f4;
                        n = this.worldObj.a(n4, n3, n2);
                        if (n > 0) {
                            f16 -= (Block.c[n].g() + 0.3f) * 0.3f;
                        }
                        if (f16 > 0.0f) {
                            int n8 = n4 + (n3 << 10) + (n2 << 10 << 10);
                            treeSet.add(n8);
                        }
                        f15 += f6 * 0.3f;
                        f5 += f12 * 0.3f;
                        f4 += f13 * 0.3f;
                    }
                }
            }
        }
        n7 = (int)(f7 - (f10 *= 2.0f) - 1.0f);
        n6 = (int)(f7 + f10 + 1.0f);
        n5 = (int)(f8 - f10 - 1.0f);
        int n9 = (int)(f8 + f10 + 1.0f);
        int n10 = (int)(f9 - f10 - 1.0f);
        int n11 = (int)(f9 + f10 + 1.0f);
        List<C_b> list = this.worldObj.a(this.exploder, new net.minecraft.a.d.C_b(n7, n5, n10, n6, n9, n11));
        C_a c_a = new C_a(f7, f8, f9);
        for (int i = 0; i < list.size(); ++i) {
            float f17;
            C_b c_b;
            C_b c_b2 = c_b = list.get(i);
            f5 = c_b.h - f7;
            f3 = c_b2.i - f8;
            f2 = c_b2.j - f9;
            f4 = MathHelper.c(f5 * f5 + f3 * f3 + f2 * f2) / f10;
            if (!(f17 <= 1.0f)) continue;
            f2 = c_b.h - f7;
            f = c_b.i - f8;
            float f18 = c_b.j - f9;
            float f19 = MathHelper.c(f2 * f2 + f * f + f18 * f18);
            f2 /= f19;
            f /= f19;
            f18 /= f19;
            float f20 = this.getBlockDensity(c_a, c_b.r);
            float f21 = (1.0f - f4) * f20;
            c_b.attackEntityFrom(this.exploder, (int)((f21 * f21 + f21) / 2.0f * 8.0f * f10 + 1.0f), 0.4f);
            c_b.k += f2 * f21;
            c_b.l += f * f21;
            c_b.m += f18 * f21;
        }
        f10 = f11;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(treeSet);
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            int n12 = (Integer)arrayList.get(i);
            n7 = n12 & 0x3FF;
            n4 = n12 >> 10 & 0x3FF;
            n3 = n12 >> 20 & 0x3FF;
            if (n7 < 0 || n4 < 0 || n3 < 0 || n7 >= this.worldObj.a || n4 >= this.worldObj.c || n3 >= this.worldObj.b) continue;
            n2 = this.worldObj.a(n7, n4, n3);
            for (n = 0; n <= 0; ++n) {
                float f22 = (float)n7 + this.worldObj.q.nextFloat();
                f5 = (float)n4 + this.worldObj.q.nextFloat();
                f2 = (float)n3 + this.worldObj.q.nextFloat();
                f = f22 - f7;
                f11 = f5 - f8;
                f3 = f2 - f9;
                f6 = MathHelper.c(f * f + f11 * f11 + f3 * f3);
                f /= f6;
                f11 /= f6;
                f3 /= f6;
                f6 = 0.5f / (f6 / f10 + 0.1f);
                this.worldObj.a("explode", (f22 + f7) / 2.0f, (f5 + f8) / 2.0f, (f2 + f9) / 2.0f, f *= (f6 *= this.worldObj.q.nextFloat() * this.worldObj.q.nextFloat() + 0.3f), f11 *= f6, f3 *= f6);
                this.worldObj.a("smoke", f22, f5, f2, f, f11, f3);
            }
            if (n2 <= 0) continue;
            Block.c[n2].a(this.worldObj, n7, n4, n3, this.worldObj.e(n7, n4, n3), 0.3f);
            this.worldObj.b(n7, n4, n3, 0);
            Block.c[n2].c(this.worldObj, n7, n4, n3);
        }
    }

    public void doExplosionB(boolean bl) {
        this.worldObj.a(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0f, (1.0f + (this.worldObj.q.nextFloat() - this.worldObj.q.nextFloat()) * 0.2f) * 0.7f);
        ArrayList<C_k> arrayList = new ArrayList<C_k>();
        arrayList.addAll(this.destroyedBlockPositions);
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            C_k c_k = (C_k)arrayList.get(i);
            int n = c_k.x;
            int n2 = c_k.y;
            int n3 = c_k.z;
            int n4 = this.worldObj.a(n, n2, n3);
            if (bl) {
                float f = (float)n + this.worldObj.q.nextFloat();
                float f2 = (float)n2 + this.worldObj.q.nextFloat();
                float f3 = (float)n3 + this.worldObj.q.nextFloat();
                float f4 = f - this.explosionX;
                float f5 = f2 - this.explosionY;
                float f6 = f3 - this.explosionZ;
                float f7 = MathHelper.c(f4 * f4 + f5 * f5 + f6 * f6);
                f4 /= f7;
                f5 /= f7;
                f6 /= f7;
                float f8 = 0.5f / (f7 / this.explosionSize + 0.1f);
                this.worldObj.a("explode", (f + this.explosionX * 1.0f) / 2.0f, (f2 + this.explosionY * 1.0f) / 2.0f, (f3 + this.explosionZ * 1.0f) / 2.0f, f4 *= (f8 *= this.worldObj.q.nextFloat() * this.worldObj.q.nextFloat() + 0.3f), f5 *= f8, f6 *= f8);
                this.worldObj.a("smoke", f, f2, f3, f4, f5, f6);
            }
            if (n4 <= 0) continue;
            Block.c[n4].a(this.worldObj, n, n2, n3, this.worldObj.e(n, n2, n3), 0.3f);
            this.worldObj.b(n, n2, n3, 0);
            Block.c[n4].c(this.worldObj, n, n2, n3);
        }
    }

    private float getBlockDensity(C_a c_a, net.minecraft.a.d.C_b c_b) {
        float f = 1.0f / ((c_b.d - c_b.a) * 2.0f + 1.0f);
        float f2 = 1.0f / ((c_b.e - c_b.b) * 2.0f + 1.0f);
        float f3 = 1.0f / ((c_b.f - c_b.c) * 2.0f + 1.0f);
        int n = 0;
        int n2 = 0;
        for (float f4 = 0.0f; f4 <= 1.0f; f4 += f) {
            for (float f5 = 0.0f; f5 <= 1.0f; f5 += f2) {
                for (float f6 = 0.0f; f6 <= 1.0f; f6 += f3) {
                    float f7 = c_b.a + (c_b.d - c_b.a) * f4;
                    float f8 = c_b.b + (c_b.e - c_b.b) * f5;
                    float f9 = c_b.c + (c_b.f - c_b.c) * f6;
                    if (this.worldObj.a(new C_a(f7, f8, f9), c_a) == null) {
                        ++n;
                    }
                    ++n2;
                }
            }
        }
        return (float)n / (float)n2;
    }
}

