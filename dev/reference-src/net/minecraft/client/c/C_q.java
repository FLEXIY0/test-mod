/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.c;

import java.io.File;
import java.io.FilenameFilter;
import net.minecraft.client.c.C_f;

final class C_q
implements FilenameFilter {
    C_q(C_f c_f) {
    }

    public final boolean accept(File file, String string) {
        return string.toLowerCase().endsWith(".mclevel");
    }
}

