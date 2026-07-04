/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class NBTTagString
extends NBTBase {
    public String a;

    public NBTTagString() {
    }

    public NBTTagString(String string) {
        this.a = string;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        byte[] byArray = this.a.getBytes("UTF-8");
        dataOutput.writeShort(byArray.length);
        dataOutput.write(byArray);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        byte[] byArray = new byte[dataInput.readShort()];
        dataInput.readFully(byArray);
        this.a = new String(byArray, "UTF-8");
    }

    @Override
    public final byte a() {
        return 8;
    }

    public final String toString() {
        return "" + this.a;
    }

    @Override
    public NBTBase copy() {
        return new NBTTagString(this.a).l(this.c());
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        NBTTagString nBTTagString = (NBTTagString)object;
        return this.a == null && nBTTagString.a == null || this.a != null && this.a.equals(nBTTagString.a);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }
}

