/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.a;

import net.minecraft.a.a.a.C_a;

public final class C_b {
    private final C_a[] a;
    private final int pathLength;
    private int b;

    public C_b(C_a[] c_aArray) {
        this.a = c_aArray;
        this.pathLength = c_aArray.length;
    }

    public final void a() {
        ++this.b;
    }

    public final boolean b() {
        return this.b >= this.a.length;
    }

    public final net.minecraft.a.d.C_a a(net.minecraft.a.c.Entity c_b) {
        float f = (float)this.a[this.b].a + (float)((int)(c_b.w + 1.0f)) * 0.5f;
        float f2 = this.a[this.b].b;
        float f3 = (float)this.a[this.b].c + (float)((int)(c_b.w + 1.0f)) * 0.5f;
        return new net.minecraft.a.d.C_a(f, f2, f3);
    }

    public int getPathLength() {
        return this.pathLength;
    }

    public int getCurrentPathIndex() {
        return this.b;
    }

    public C_a getPathPointFromIndex(int n) {
        return this.a[n];
    }
}

