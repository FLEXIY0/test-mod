/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.util.HashMap;
import net.minecraft.client.C_l;

final class C_x
extends HashMap<String, net.minecraft.a.a.b.C_x> {
    private static final long serialVersionUID = 1L;

    C_x() {
        for (net.minecraft.a.a.b.C_x c_x : C_l.a) {
            for (int i = 0; i < c_x.getMaxDamage() + 1; ++i) {
                String string = c_x.getBlockName(i).toLowerCase().replace(" ", "_");
                if (string.startsWith("&")) {
                    string = string.substring(2);
                }
                this.put(string, c_x);
            }
        }
    }
}

