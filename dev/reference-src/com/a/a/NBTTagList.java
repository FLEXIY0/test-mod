/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class NBTTagList
extends NBTBase {
    public List<NBTBase> a = new ArrayList<NBTBase>();
    private byte b;

    @Override
    final void a(DataOutput dataOutput) throws IOException {
        this.b = this.a.size() > 0 ? this.a.get(0).a() : (byte)1;
        dataOutput.writeByte(this.b);
        dataOutput.writeInt(this.a.size());
        for (int i = 0; i < this.a.size(); ++i) {
            this.a.get(i).a(dataOutput);
        }
    }

    @Override
    final void a(DataInput dataInput) throws IOException {
        this.b = dataInput.readByte();
        int n = dataInput.readInt();
        this.a = new ArrayList<NBTBase>();
        for (int i = 0; i < n; ++i) {
            NBTBase nBTBase = NBTBase.a(this.b);
            nBTBase.a(dataInput);
            this.a.add(nBTBase);
        }
    }

    @Override
    public final byte a() {
        return 9;
    }

    public final String toString() {
        String string;
        StringBuilder stringBuilder = new StringBuilder().append("").append(this.a.size()).append(" entries of type ");
        switch (this.b) {
            case 0: {
                string = "TAG_End";
                break;
            }
            case 1: {
                string = "TAG_Byte";
                break;
            }
            case 2: {
                string = "TAG_Short";
                break;
            }
            case 3: {
                string = "TAG_Int";
                break;
            }
            case 4: {
                string = "TAG_Long";
                break;
            }
            case 5: {
                string = "TAG_Float";
                break;
            }
            case 6: {
                string = "TAG_Double";
                break;
            }
            case 7: {
                string = "TAG_Byte_Array";
                break;
            }
            case 8: {
                string = "TAG_String";
                break;
            }
            case 9: {
                string = "TAG_List";
                break;
            }
            case 10: {
                string = "TAG_Compound";
                break;
            }
            default: {
                string = "UNKNOWN";
            }
        }
        return stringBuilder.append(string).toString();
    }

    public final void a(NBTBase nBTBase) {
        this.b = nBTBase.a();
        this.a.add(nBTBase);
    }

    public final NBTBase a(int n) {
        return this.a.get(n);
    }

    public final int b() {
        return this.a.size();
    }

    @Override
    public NBTBase copy() {
        NBTTagList nBTTagList = (NBTTagList)new NBTTagList().l(this.c());
        nBTTagList.b = this.b;
        for (NBTBase nBTBase : this.a) {
            NBTBase nBTBase2 = nBTBase.copy();
            nBTTagList.a.add(nBTBase2);
        }
        return nBTTagList;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagList nBTTagList = (NBTTagList)object;
            if (this.b == nBTTagList.b) {
                return this.a.equals(nBTTagList.a);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.a.hashCode();
    }

    public void appendTag(NBTBase nBTBase) {
        this.b = nBTBase.a();
        this.a.add(nBTBase);
    }

    public NBTBase removeTag(int n) {
        return this.a.remove(n);
    }
}

