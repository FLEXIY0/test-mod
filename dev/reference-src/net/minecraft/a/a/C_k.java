/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

public class C_k {
    public final int x;
    public final int y;
    public final int z;

    public C_k(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public boolean equals(Object object) {
        if (!(object instanceof C_k)) {
            return false;
        }
        C_k c_k = (C_k)object;
        return c_k.x == this.x && c_k.y == this.y && c_k.z == this.z;
    }

    public int hashCode() {
        return this.x * 8976890 + this.y * 981131 + this.z;
    }
}

