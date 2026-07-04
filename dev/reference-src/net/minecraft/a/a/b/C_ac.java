/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_a;
import net.minecraft.a.d.C_b;

public final class C_ac
extends C_x {
    protected C_ac(int n, int n2) {
        super(50, 80, C_c.n);
        this.a(true);
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

    public final int a() {
        return 2;
    }

    public final boolean a(C_g c_g, int n, int n2, int n3) {
        if (c_g.b(n - 1, n2, n3)) {
            return true;
        }
        if (c_g.b(n + 1, n2, n3)) {
            return true;
        }
        if (c_g.b(n, n2, n3 - 1)) {
            return true;
        }
        if (c_g.b(n, n2, n3 + 1)) {
            return true;
        }
        return c_g.b(n, n2 - 1, n3);
    }

    public final void g(C_g c_g, int n, int n2, int n3, int n4) {
        int n5 = c_g.e(n, n2, n3);
        if (n4 == 1 && c_g.b(n, n2 - 1, n3)) {
            n5 = 5;
        }
        if (n4 == 2 && c_g.b(n, n2, n3 + 1)) {
            n5 = 4;
        }
        if (n4 == 3 && c_g.b(n, n2, n3 - 1)) {
            n5 = 3;
        }
        if (n4 == 4 && c_g.b(n + 1, n2, n3)) {
            n5 = 2;
        }
        if (n4 == 5 && c_g.b(n - 1, n2, n3)) {
            n5 = 1;
        }
        c_g.f(n, n2, n3, n5);
    }

    public final void a(C_g c_g, int n, int n2, int n3, Random random) {
        super.a(c_g, n, n2, n3, random);
        if (c_g.e(n, n2, n3) == 0) {
            this.d(c_g, n, n2, n3);
        }
    }

    public final void d(C_g c_g, int n, int n2, int n3) {
        if (c_g.b(n - 1, n2, n3)) {
            c_g.f(n, n2, n3, 1);
        } else if (c_g.b(n + 1, n2, n3)) {
            c_g.f(n, n2, n3, 2);
        } else if (c_g.b(n, n2, n3 - 1)) {
            c_g.f(n, n2, n3, 3);
        } else if (c_g.b(n, n2, n3 + 1)) {
            c_g.f(n, n2, n3, 4);
        } else if (c_g.b(n, n2 - 1, n3)) {
            c_g.f(n, n2, n3, 5);
        }
        this.e(c_g, n, n2, n3);
    }

    public final void b(C_g c_g, int n, int n2, int n3, int n4) {
        if (this.e(c_g, n, n2, n3)) {
            n4 = c_g.e(n, n2, n3);
            boolean bl = false;
            if (!c_g.b(n - 1, n2, n3) && n4 == 1) {
                bl = true;
            }
            if (!c_g.b(n + 1, n2, n3) && n4 == 2) {
                bl = true;
            }
            if (!c_g.b(n, n2, n3 - 1) && n4 == 3) {
                bl = true;
            }
            if (!c_g.b(n, n2, n3 + 1) && n4 == 4) {
                bl = true;
            }
            if (!c_g.b(n, n2 - 1, n3) && n4 == 5) {
                bl = true;
            }
            if (bl) {
                this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
                c_g.b(n, n2, n3, 0);
            }
        }
    }

    private boolean e(C_g c_g, int n, int n2, int n3) {
        if (!this.a(c_g, n, n2, n3)) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
            return false;
        }
        return true;
    }

    public final net.minecraft.a.d.C_c a(C_g c_g, int n, int n2, int n3, C_a c_a, C_a c_a2) {
        byte by = c_g.e(n, n2, n3);
        if (by == 1) {
            this.a(0.0f, 0.2f, 0.35f, 0.3f, 0.8f, 0.65f);
        } else if (by == 2) {
            this.a(0.7f, 0.2f, 0.35f, 1.0f, 0.8f, 0.65f);
        } else if (by == 3) {
            this.a(0.35f, 0.2f, 0.0f, 0.65f, 0.8f, 0.3f);
        } else if (by == 4) {
            this.a(0.35f, 0.2f, 0.7f, 0.65f, 0.8f, 1.0f);
        } else {
            this.a(0.4f, 0.0f, 0.4f, 0.6f, 0.6f, 0.6f);
        }
        return super.a(c_g, n, n2, n3, c_a, c_a2);
    }

    public final void b(C_g c_g, int n, int n2, int n3, Random random) {
        byte by = c_g.e(n, n2, n3);
        float f = (float)n + 0.5f;
        float f2 = (float)n2 + 0.7f;
        float f3 = (float)n3 + 0.5f;
        if (by == 1) {
            c_g.a("smoke", f - 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f - 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 2) {
            c_g.a("smoke", f + 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f + 0.27f, f2 + 0.22f, f3, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 3) {
            c_g.a("smoke", f, f2 + 0.22f, f3 - 0.27f, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f, f2 + 0.22f, f3 - 0.27f, 0.0f, 0.0f, 0.0f);
            return;
        }
        if (by == 4) {
            c_g.a("smoke", f, f2 + 0.22f, f3 + 0.27f, 0.0f, 0.0f, 0.0f);
            c_g.a("flame", f, f2 + 0.22f, f3 + 0.27f, 0.0f, 0.0f, 0.0f);
            return;
        }
        c_g.a("smoke", f, f2, f3, 0.0f, 0.0f, 0.0f);
        c_g.a("flame", f, f2, f3, 0.0f, 0.0f, 0.0f);
    }
}

