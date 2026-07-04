/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.d;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.d.C_b;

public class C_e {
    private final int maxNumCleans;
    private final int numEntriesToRemove;
    private final List<C_b> listAABB = new ArrayList<C_b>();
    private int nextPoolIndex = 0;
    private int maxPoolIndex = 0;
    private int numCleans = 0;

    public C_e(int n, int n2) {
        this.maxNumCleans = n;
        this.numEntriesToRemove = n2;
    }

    public C_b addOrModifyAABBInPool(float f, float f2, float f3, float f4, float f5, float f6) {
        C_b c_b;
        if (this.nextPoolIndex >= this.listAABB.size()) {
            c_b = new C_b(f, f2, f3, f4, f5, f6);
            this.listAABB.add(c_b);
        } else {
            c_b = this.listAABB.get(this.nextPoolIndex);
            c_b.setBounds(f, f2, f3, f4, f5, f6);
        }
        ++this.nextPoolIndex;
        return c_b;
    }

    public void cleanPool() {
        if (this.nextPoolIndex > this.maxPoolIndex) {
            this.maxPoolIndex = this.nextPoolIndex;
        }
        if (this.numCleans++ == this.maxNumCleans) {
            int n = Math.max(this.maxPoolIndex, this.listAABB.size() - this.numEntriesToRemove);
            while (this.listAABB.size() > n) {
                this.listAABB.remove(n);
            }
            this.maxPoolIndex = 0;
            this.numCleans = 0;
        }
        this.nextPoolIndex = 0;
    }

    public void clearPool() {
        this.nextPoolIndex = 0;
        this.listAABB.clear();
    }

    public int getlistAABBsize() {
        return this.listAABB.size();
    }

    public int getnextPoolIndex() {
        return this.nextPoolIndex;
    }
}

