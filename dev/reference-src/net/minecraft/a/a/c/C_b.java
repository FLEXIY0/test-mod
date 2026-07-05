/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.c;

import java.util.Random;
import net.minecraft.a.a.C_g;

public abstract class C_b {
    private final boolean doBlockNotify;

    public C_b() {
        this.doBlockNotify = false;
    }

    public C_b(boolean bl) {
        this.doBlockNotify = bl;
    }

    public abstract boolean generate(C_g var1, Random var2, int var3, int var4, int var5);

    public void setScale(double d2, double d3, double d4) {
    }

    protected void placeBlock(C_g c_g, int n, int n2, int n3, int n4) {
        this.setBlockAndMetadata(c_g, n, n2, n3, n4, 0);
    }

    protected void setBlockAndMetadata(C_g c_g, int n, int n2, int n3, int n4, int n5) {
        if (this.doBlockNotify) {
            c_g.setBlockAndMetadataWithNotify(n, n2, n3, n4, n5);
        } else {
            c_g.setBlockAndMetadata(n, n2, n3, n4, n5);
        }
    }
}

