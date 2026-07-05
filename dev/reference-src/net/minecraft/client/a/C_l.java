/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.a;

import java.util.Comparator;
import net.minecraft.a.c.Entity;
import net.minecraft.client.a.C_h;

public final class C_l
implements Comparator<C_h> {
    private double entityPosX;
    private double entityPosY;
    private double entityPosZ;

    public C_l(Entity c_b) {
        this.entityPosX = -c_b.h;
        this.entityPosY = -c_b.i;
        this.entityPosZ = -c_b.j;
    }

    @Override
    public int compare(C_h c_h, C_h c_h2) {
        double d2 = (double)c_h.q + this.entityPosX;
        double d3 = (double)c_h.r + this.entityPosY;
        double d4 = (double)c_h.s + this.entityPosZ;
        double d5 = (double)c_h2.q + this.entityPosX;
        double d6 = (double)c_h2.r + this.entityPosY;
        double d7 = (double)c_h2.s + this.entityPosZ;
        return (int)((d2 * d2 + d3 * d3 + d4 * d4 - (d5 * d5 + d6 * d6 + d7 * d7)) * 1024.0);
    }
}

