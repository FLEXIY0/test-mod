/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_ThingWithPosition;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

final class J_PositionTrackingPushbackReader
implements J_ThingWithPosition {
    private final PushbackReader field_27338_a;
    private int field_27337_b = 0;
    private int field_27340_c = 1;
    private boolean field_27339_d = false;

    public J_PositionTrackingPushbackReader(Reader reader) {
        this.field_27338_a = new PushbackReader(reader);
    }

    public void func_27334_a(char c) throws IOException {
        --this.field_27337_b;
        if (this.field_27337_b < 0) {
            this.field_27337_b = 0;
        }
        this.field_27338_a.unread(c);
    }

    public void func_27335_a(char[] cArray) {
        this.field_27337_b -= cArray.length;
        if (this.field_27337_b < 0) {
            this.field_27337_b = 0;
        }
    }

    public int func_27333_c() throws IOException {
        int n = this.field_27338_a.read();
        this.func_27332_a(n);
        return n;
    }

    public int func_27336_b(char[] cArray) throws IOException {
        int n = this.field_27338_a.read(cArray);
        char[] cArray2 = cArray;
        int n2 = cArray.length;
        for (int i = 0; i < n2; ++i) {
            char c = cArray2[i];
            this.func_27332_a(c);
        }
        return n;
    }

    private void func_27332_a(int n) {
        if (13 == n) {
            this.field_27337_b = 0;
            ++this.field_27340_c;
            this.field_27339_d = true;
        } else {
            if (10 == n && !this.field_27339_d) {
                this.field_27337_b = 0;
                ++this.field_27340_c;
            } else {
                ++this.field_27337_b;
            }
            this.field_27339_d = false;
        }
    }

    @Override
    public int func_27331_a() {
        return this.field_27337_b;
    }

    @Override
    public int func_27330_b() {
        return this.field_27340_c;
    }
}

