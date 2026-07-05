/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import net.minecraft.a.b.ItemStack;

public final class C_c {
    private int a;
    private int b;
    private int[] c;
    private ItemStack d;

    public C_c(int n, int n2, int[] nArray, ItemStack itemStack) {
        this.a = n;
        this.b = n2;
        this.c = nArray;
        this.d = itemStack;
    }

    public final boolean a(int[] nArray) {
        for (int i = 0; i <= 3 - this.a; ++i) {
            for (int j = 0; j <= 3 - this.b; ++j) {
                if (this.a(nArray, i, j, true)) {
                    return true;
                }
                if (!this.a(nArray, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean a(int[] nArray, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int n3 = i - n;
                int n4 = j - n2;
                int n5 = -1;
                if (n3 >= 0 && n4 >= 0 && n3 < this.a && n4 < this.b) {
                    n5 = bl ? this.c[this.a - n3 - 1 + n4 * this.a] : this.c[n3 + n4 * this.a];
                }
                if (nArray[i + j * 3] == n5) continue;
                return false;
            }
        }
        return true;
    }

    public final ItemStack a() {
        return new ItemStack(this.d.c, this.d.a);
    }

    public final int b() {
        return this.a * this.b;
    }
}

