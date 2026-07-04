/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.C_b;
import com.a.a.C_d;
import com.a.a.C_e;
import com.a.a.C_h;
import com.a.a.C_i;
import com.a.a.C_n;
import com.a.a.NBTBase;
import com.a.a.NBTTagList;
import com.a.a.NBTTagLong;
import com.a.a.NBTTagString;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class NBTTagCompound
extends NBTBase {
    private Map<String, NBTBase> a = new HashMap<String, NBTBase>();

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        Iterator<NBTBase> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            NBTBase.a(iterator.next(), dataOutput);
        }
        dataOutput.writeByte(0);
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        NBTBase nBTBase;
        this.a.clear();
        while ((nBTBase = NBTBase.b(dataInput)).a() != 0) {
            this.a.put(nBTBase.c(), nBTBase);
        }
    }

    @Override
    public final byte a() {
        return 10;
    }

    public final void a(String string, NBTBase nBTBase) {
        this.a.put(string, nBTBase.l(string));
    }

    public final void a(String string, byte by) {
        this.a.put(string, new C_e(by).l(string));
    }

    public final void a(String string, short s) {
        this.a.put(string, new C_h(s).l(string));
    }

    public final void a(String string, int n) {
        this.a.put(string, new C_d(n).l(string));
    }

    public final void a(String string, long l) {
        this.a.put(string, new NBTTagLong(l).l(string));
    }

    public final void a(String string, float f) {
        this.a.put(string, new C_b(f).l(string));
    }

    public final void a(String string, String string2) {
        this.a.put(string, new NBTTagString(string2).l(string));
    }

    public final void a(String string, byte[] byArray) {
        this.a.put(string, new C_i(byArray).l(string));
    }

    public void setIntArray(String string, int[] nArray) {
        this.a.put(string, new C_n(nArray).l(string));
    }

    public final void a(String string, NBTTagCompound nBTTagCompound) {
        this.a.put(string, nBTTagCompound.l(string));
    }

    public final void a(String string, boolean bl) {
        this.a(string, (byte)(bl ? 1 : 0));
    }

    public final boolean a(String string) {
        return this.a.containsKey(string);
    }

    public final byte b(String string) {
        return !this.a.containsKey(string) ? (byte)0 : ((C_e)this.a.get((Object)string)).a;
    }

    public final short c(String string) {
        return !this.a.containsKey(string) ? (short)0 : ((C_h)this.a.get((Object)string)).a;
    }

    public final int d(String string) {
        return !this.a.containsKey(string) ? 0 : ((C_d)this.a.get((Object)string)).a;
    }

    public final long e(String string) {
        return !this.a.containsKey(string) ? 0L : ((NBTTagLong)this.a.get((Object)string)).a;
    }

    public final float f(String string) {
        return !this.a.containsKey(string) ? 0.0f : ((C_b)this.a.get((Object)string)).a;
    }

    public final String g(String string) {
        return !this.a.containsKey(string) ? "" : ((NBTTagString)this.a.get((Object)string)).a;
    }

    public final byte[] h(String string) {
        return !this.a.containsKey(string) ? new byte[]{} : ((C_i)this.a.get((Object)string)).a;
    }

    public int[] getIntArray(String string) {
        if (!this.a.containsKey(string)) {
            return new int[0];
        }
        return ((C_n)this.a.get((Object)string)).intArray;
    }

    public final NBTTagCompound i(String string) {
        return !this.a.containsKey(string) ? new NBTTagCompound() : (NBTTagCompound)this.a.get(string);
    }

    public final NBTTagList j(String string) {
        return !this.a.containsKey(string) ? new NBTTagList() : (NBTTagList)this.a.get(string);
    }

    public final boolean k(String string) {
        return this.b(string) != 0;
    }

    public final String toString() {
        return "" + this.a.size() + " entries";
    }

    public final boolean b() {
        return this.a.isEmpty();
    }

    @Override
    public NBTBase copy() {
        NBTTagCompound nBTTagCompound = (NBTTagCompound)new NBTTagCompound().l(this.c());
        for (String string : this.a.keySet()) {
            nBTTagCompound.a(string, this.a.get(string).copy());
        }
        return nBTTagCompound;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)object;
            return this.a.entrySet().equals(nBTTagCompound.a.entrySet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }

    public void merge(NBTTagCompound nBTTagCompound) {
        for (String string : nBTTagCompound.a.keySet()) {
            NBTBase nBTBase = nBTTagCompound.a.get(string);
            if (nBTBase.a() == 10) {
                if (this.a(string)) {
                    NBTTagCompound nBTTagCompound2 = this.i(string);
                    nBTTagCompound2.merge((NBTTagCompound)nBTBase);
                    continue;
                }
                this.a(string, nBTBase.copy());
                continue;
            }
            this.a(string, nBTBase.copy());
        }
    }

    public NBTBase getTag(String string) {
        return this.a.get(string);
    }
}

