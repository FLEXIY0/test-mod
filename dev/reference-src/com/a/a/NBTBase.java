/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.C_b;
import com.a.a.C_d;
import com.a.a.C_e;
import com.a.a.C_g;
import com.a.a.C_h;
import com.a.a.C_i;
import com.a.a.C_l;
import com.a.a.C_n;
import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import com.a.a.NBTTagLong;
import com.a.a.NBTTagString;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase {
    private String a = null;

    abstract void a(DataOutput var1) throws IOException;

    abstract void a(DataInput var1) throws IOException;

    public abstract byte a();

    public final String c() {
        return this.a == null ? "" : this.a;
    }

    public final NBTBase l(String string) {
        this.a = string;
        return this;
    }

    public static NBTBase b(DataInput dataInput) throws IOException {
        byte by = dataInput.readByte();
        if (by == 0) {
            return new C_l();
        }
        NBTBase nBTBase = NBTBase.a(by);
        byte[] byArray = new byte[dataInput.readShort()];
        dataInput.readFully(byArray);
        nBTBase.a = new String(byArray, "UTF-8");
        nBTBase.a(dataInput);
        return nBTBase;
    }

    public static void a(NBTBase nBTBase, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(nBTBase.a());
        if (nBTBase.a() != 0) {
            byte[] byArray = nBTBase.c().getBytes("UTF-8");
            dataOutput.writeShort(byArray.length);
            dataOutput.write(byArray);
            nBTBase.a(dataOutput);
        }
    }

    public static NBTBase a(byte by) {
        switch (by) {
            case 0: {
                return new C_l();
            }
            case 1: {
                return new C_e();
            }
            case 2: {
                return new C_h();
            }
            case 3: {
                return new C_d();
            }
            case 4: {
                return new NBTTagLong();
            }
            case 5: {
                return new C_b();
            }
            case 6: {
                return new C_g();
            }
            case 7: {
                return new C_i();
            }
            case 8: {
                return new NBTTagString();
            }
            case 9: {
                return new NBTTagList();
            }
            case 10: {
                return new NBTTagCompound();
            }
            case 11: {
                return new C_n();
            }
        }
        return null;
    }

    public abstract NBTBase copy();

    public boolean equals(Object object) {
        if (object != null && object instanceof NBTBase) {
            NBTBase nBTBase = (NBTBase)object;
            return this.a() != nBTBase.a() ? false : (this.a == null && nBTBase.a != null || this.a != null && nBTBase.a == null ? false : this.a == null || this.a.equals(nBTBase.a));
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.a();
    }
}

