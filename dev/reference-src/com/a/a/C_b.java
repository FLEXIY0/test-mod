/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_b
extends NBTBase {
    public float a;

    public C_b() {
    }

    public C_b(float f) {
        this.a = f;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readFloat();
    }

    @Override
    public final byte a() {
        return 5;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new C_b(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            C_b c_b = (C_b)object;
            return this.a == c_b.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.a);
    }
}

