/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.util.HashMap;

final class C_w
extends HashMap<String, Integer> {
    private static final long serialVersionUID = 1L;

    C_w() {
        this.put("day", 0);
        this.put("night", 11000);
        this.put("noon", 4000);
        this.put("midnight", 16000);
        this.put("sunrise", 22000);
        this.put("sunset", 9000);
    }
}

