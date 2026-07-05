/*
 * Decompiled with CFR 0.152.
 */
package util;

import util.C_d;

class C_c {
    final int hashEntry;
    Object valueEntry;
    C_c nextEntry;
    final int slotHash;
    final /* synthetic */ C_d this$0;

    C_c(C_d c_d, int n, int n2, Object object, C_c c_c) {
        this.this$0 = c_d;
        this.valueEntry = object;
        this.nextEntry = c_c;
        this.hashEntry = n2;
        this.slotHash = n;
    }

    public final int getHash() {
        return this.hashEntry;
    }

    public final Object getValue() {
        return this.valueEntry;
    }

    public final boolean equals(Object object) {
        Object object2;
        Object object3;
        Integer n;
        if (!(object instanceof C_c)) {
            return false;
        }
        C_c c_c = (C_c)object;
        Integer n2 = this.getHash();
        return (n2 == (n = Integer.valueOf(c_c.getHash())) || n2 != null && n2.equals(n)) && ((object3 = this.getValue()) == (object2 = c_c.getValue()) || object3 != null && object3.equals(object2));
    }

    public final int hashCode() {
        return C_d.getHash(this.hashEntry);
    }

    public final String toString() {
        return this.getHash() + "=" + this.getValue();
    }
}

