/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_d
extends NBTBase {
    public int a;

    public C_d() {
    }

    public C_d(int n) {
        this.a = n;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readInt();
    }

    @Override
    public final byte a() {
        return 3;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new C_d(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            C_d c_d = (C_d)object;
            return this.a == c_d.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a;
    }
}

