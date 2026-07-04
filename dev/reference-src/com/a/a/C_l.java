/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class C_l
extends NBTBase {
    @Override
    final void a(DataInput dataInput) throws IOException {
    }

    @Override
    final void a(DataOutput dataOutput) throws IOException {
    }

    @Override
    public final byte a() {
        return 0;
    }

    public final String toString() {
        return "END";
    }

    @Override
    public NBTBase copy() {
        return new C_l();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
}

