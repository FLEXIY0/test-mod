/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_h
extends NBTBase {
    public short a;

    public C_h() {
    }

    public C_h(short s) {
        this.a = s;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readShort();
    }

    @Override
    public final byte a() {
        return 2;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new C_h(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            C_h c_h = (C_h)object;
            return this.a == c_h.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a;
    }
}

