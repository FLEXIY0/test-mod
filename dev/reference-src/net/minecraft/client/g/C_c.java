/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.g;

import net.minecraft.client.GameSettings;
import net.minecraft.client.g.C_b;

public final class C_c
extends C_b {
    private boolean[] d = new boolean[10];
    private GameSettings e;

    public C_c(GameSettings gameSettings) {
        this.e = gameSettings;
    }

    @Override
    public final void a(int n, boolean bl) {
        int n2 = -1;
        if (n == this.e.i.b) {
            n2 = 0;
        }
        if (n == this.e.k.b) {
            n2 = 1;
        }
        if (n == this.e.j.b) {
            n2 = 2;
        }
        if (n == this.e.l.b) {
            n2 = 3;
        }
        if (n == this.e.m.b) {
            n2 = 4;
        }
        if (n2 >= 0) {
            this.d[n2] = bl;
        }
    }

    @Override
    public final void b() {
        for (int i = 0; i < 10; ++i) {
            this.d[i] = false;
        }
    }

    @Override
    public final void a() {
        this.a = 0.0f;
        this.b = 0.0f;
        if (this.d[0]) {
            this.b += 1.0f;
        }
        if (this.d[1]) {
            this.b -= 1.0f;
        }
        if (this.d[2]) {
            this.a += 1.0f;
        }
        if (this.d[3]) {
            this.a -= 1.0f;
        }
        this.c = this.d[4];
    }
}

