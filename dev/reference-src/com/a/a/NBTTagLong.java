/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class NBTTagLong
extends NBTBase {
    public long a;

    public NBTTagLong() {
    }

    public NBTTagLong(long l) {
        this.a = l;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.a = dataInput.readLong();
    }

    @Override
    public final byte a() {
        return 4;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new NBTTagLong(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagLong nBTTagLong = (NBTTagLong)object;
            return this.a == nBTTagLong.a;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this.a ^ this.a >>> 32);
    }
}

