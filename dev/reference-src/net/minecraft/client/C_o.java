/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import net.minecraft.client.C_e;

final class C_o {
    static final int[] a = new int[C_e.values().length];

    C_o() {
    }

    static {
        try {
            C_o.a[C_e.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            C_o.a[C_e.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            C_o.a[C_e.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            C_o.a[C_e.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

