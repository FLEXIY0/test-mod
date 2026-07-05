/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.d.C_b;

public class C_ad
extends Block {
    protected C_ad(int n, int n2) {
        super(n, Material.i);
        this.as = n2;
        this.a(true);
        this.a(0.3f, 0.0f, 0.3f, 0.7f, 0.6f, 0.7f);
    }

    public final boolean a(World c_g, int n, int n2, int n3) {
        return this.b(c_g.a(n, n2 - 1, n3));
    }

    protected boolean b(int n) {
        return n == Block.j.at || n == Block.k.at || n == Block.ap.at;
    }

    public final void b(World c_g, int n, int n2, int n3, int n4) {
        super.b(c_g, n, n2, n3, n4);
        this.h(c_g, n, n2, n3);
    }

    public void a(World c_g, int n, int n2, int n3, Random random) {
        this.h(c_g, n, n2, n3);
    }

    private void h(World c_g, int n, int n2, int n3) {
        if (!this.e(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
    }

    public boolean e(World c_g, int n, int n2, int n3) {
        return (c_g.d(n, n2, n3) >= 8 || c_g.d(n, n2, n3) >= 4 && c_g.l(n, n2, n3)) && this.b(c_g.a(n, n2 - 1, n3));
    }

    public final C_b a(int n, int n2, int n3) {
        return null;
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public int a() {
        return 1;
    }
}

