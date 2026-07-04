/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_e
extends NBTBase {
    public byte a;

    public C_e() {
    }

    public C_e(byte by) {
        this.a = by;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readByte();
    }

    @Override
    public final byte a() {
        return 1;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new C_e(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            C_e c_e = (C_e)object;
            return this.a == c_e.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a;
    }
}

