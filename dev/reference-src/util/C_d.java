/*
 * Decompiled with CFR 0.152.
 */
package util;

import util.C_c;

public class C_d {
    private transient C_c[] slots = new C_c[16];
    private transient int count;
    private int threshold = 12;
    final float growFactor = 0.75f;
    volatile transient int versionStamp;

    private static int computeHash(int n) {
        n ^= n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    private static int getSlotIndex(int n, int n2) {
        return n & n2 - 1;
    }

    public Object lookup(int n) {
        int n2 = C_d.computeHash(n);
        C_c c_c = this.slots[C_d.getSlotIndex(n2, this.slots.length)];
        while (c_c != null) {
            if (c_c.hashEntry == n) {
                return c_c.valueEntry;
            }
            c_c = c_c.nextEntry;
        }
        return null;
    }

    public void addKey(int n, Object object) {
        int n2 = C_d.computeHash(n);
        int n3 = C_d.getSlotIndex(n2, this.slots.length);
        C_c c_c = this.slots[n3];
        while (c_c != null) {
            if (c_c.hashEntry == n) {
                c_c.valueEntry = object;
            }
            c_c = c_c.nextEntry;
        }
        ++this.versionStamp;
        this.insert(n2, n, object, n3);
    }

    private void grow(int n) {
        C_c[] c_cArray = this.slots;
        int n2 = c_cArray.length;
        if (n2 == 0x40000000) {
            this.threshold = Integer.MAX_VALUE;
        } else {
            C_c[] c_cArray2 = new C_c[n];
            this.copyTo(c_cArray2);
            this.slots = c_cArray2;
            float f = n;
            this.getClass();
            this.threshold = (int)(f * 0.75f);
        }
    }

    private void copyTo(C_c[] c_cArray) {
        C_c[] c_cArray2 = this.slots;
        int n = c_cArray.length;
        for (int i = 0; i < c_cArray2.length; ++i) {
            C_c c_c;
            C_c c_c2 = c_cArray2[i];
            if (c_c2 == null) continue;
            c_cArray2[i] = null;
            do {
                c_c = c_c2.nextEntry;
                int n2 = C_d.getSlotIndex(c_c2.slotHash, n);
                c_c2.nextEntry = c_cArray[n2];
                c_cArray[n2] = c_c2;
                c_c2 = c_c;
            } while (c_c != null);
        }
    }

    public Object removeObject(int n) {
        C_c c_c = this.removeEntry(n);
        return c_c == null ? null : c_c.valueEntry;
    }

    final C_c removeEntry(int n) {
        C_c c_c;
        int n2 = C_d.computeHash(n);
        int n3 = C_d.getSlotIndex(n2, this.slots.length);
        C_c c_c2 = c_c = this.slots[n3];
        while (c_c2 != null) {
            C_c c_c3 = c_c2.nextEntry;
            if (c_c2.hashEntry == n) {
                ++this.versionStamp;
                --this.count;
                if (c_c == c_c2) {
                    this.slots[n3] = c_c3;
                } else {
                    c_c.nextEntry = c_c3;
                }
                return c_c2;
            }
            c_c = c_c2;
            c_c2 = c_c3;
        }
        return c_c2;
    }

    public void clearMap() {
        ++this.versionStamp;
        C_c[] c_cArray = this.slots;
        for (int i = 0; i < c_cArray.length; ++i) {
            c_cArray[i] = null;
        }
        this.count = 0;
    }

    private void insert(int n, int n2, Object object, int n3) {
        C_c c_c = this.slots[n3];
        this.slots[n3] = new C_c(this, n, n2, object, c_c);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }
    }

    static int getHash(int n) {
        return C_d.computeHash(n);
    }
}

