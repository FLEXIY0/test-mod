/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a;

import java.util.Comparator;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.a.C_h;

public final class C_a
implements Comparator<C_h> {
    private EntityPlayer a;

    public C_a(EntityPlayer entityPlayer) {
        this.a = entityPlayer;
    }

    @Override
    public final int compare(C_h c_h, C_h c_h2) {
        C_h c_h3 = c_h;
        boolean bl = c_h3.b;
        boolean bl2 = c_h2.b;
        return bl && !bl2 ? 1 : ((!bl2 || bl) && c_h3.a(this.a) < c_h2.a(this.a) ? 1 : -1);
    }
}

