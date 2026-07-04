/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import net.minecraft.client.statistics.StatBase;

public class StatCrafting
extends StatBase {
    private final int itemID;

    public StatCrafting(int n, String string, int n2) {
        super(n, string);
        this.itemID = n2;
    }

    public int getItemID() {
        return this.itemID;
    }
}

