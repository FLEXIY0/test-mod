/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public final class C_i
extends NBTBase {
    public byte[] a;

    public C_i() {
    }

    public C_i(byte[] byArray) {
        this.a = byArray;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.a.length);
        dataOutput.write(this.a);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this.a = new byte[n];
        dataInput.readFully(this.a);
    }

    @Override
    public final byte a() {
        return 7;
    }

    public final String toString() {
        return "[" + this.a.length + " bytes]";
    }

    @Override
    public NBTBase copy() {
        byte[] byArray = new byte[this.a.length];
        System.arraycopy(this.a, 0, byArray, 0, this.a.length);
        return new C_i(byArray).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object) ? Arrays.equals(this.a, ((C_i)object).a) : false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.a);
    }
}

