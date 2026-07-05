/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a;

public class C_q
implements Comparable<C_q> {
    public int x;
    public int y;
    public int z;

    public C_q() {
    }

    public C_q(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public C_q(C_q c_q) {
        this.x = c_q.x;
        this.y = c_q.y;
        this.z = c_q.z;
    }

    public boolean equals(Object object) {
        if (!(object instanceof C_q)) {
            return false;
        }
        C_q c_q = (C_q)object;
        return this.x == c_q.x && this.y == c_q.y && this.z == c_q.z;
    }

    public int hashCode() {
        return this.x + this.z << 8 + this.y << 16;
    }

    @Override
    public int compareTo(C_q c_q) {
        return this.y == c_q.y ? (this.z == c_q.z ? this.x - c_q.x : this.z - c_q.z) : this.y - c_q.y;
    }

    public double getSqDistanceTo(int n, int n2, int n3) {
        int n4 = this.x - n;
        int n5 = this.y - n2;
        int n6 = this.z - n3;
        return Math.sqrt(n4 * n4 + n5 * n5 + n6 * n6);
    }
}

