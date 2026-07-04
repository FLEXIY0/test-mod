/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.StatBase;

public class StatMob
extends StatBase {
    private final int entityID;

    public StatMob(int n, String string, int n2) {
        super(n, string);
        this.entityID = n2;
    }

    public int getEntity() {
        return this.entityID;
    }
}

