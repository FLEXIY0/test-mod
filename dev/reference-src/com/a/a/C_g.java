/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_g
extends NBTBase {
    private double a;

    public C_g() {
    }

    public C_g(double d2) {
        this.a = d2;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readDouble();
    }

    @Override
    public final byte a() {
        return 6;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new C_g(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            C_g c_g = (C_g)object;
            return this.a == c_g.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long l = Double.doubleToLongBits(this.a);
        return super.hashCode() ^ (int)(l ^ l >>> 32);
    }
}

