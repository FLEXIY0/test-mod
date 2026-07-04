/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class C_n
extends NBTBase {
    public int[] intArray;

    public C_n() {
    }

    public C_n(int[] nArray) {
        this.intArray = nArray;
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.intArray.length);
        ByteBuffer byteBuffer = ByteBuffer.allocate(this.intArray.length * 4);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.asIntBuffer().put(this.intArray);
        byte[] byArray = byteBuffer.array();
        dataOutput.write(byArray);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this.intArray = new int[n];
        byte[] byArray = new byte[n * 4];
        dataInput.readFully(byArray);
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.asIntBuffer().get(this.intArray);
    }

    @Override
    public final byte a() {
        return 11;
    }

    public final String toString() {
        return "[" + this.intArray.length + " ints]";
    }

    @Override
    public NBTBase copy() {
        return null;
    }
}

