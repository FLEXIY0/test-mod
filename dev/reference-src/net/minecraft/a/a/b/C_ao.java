/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;

public class C_ao
extends Block {
    private static String[] NAME_LIST = new String[]{"Red", "Orange", "Yellow", "Chartreuse", "Green", "Spring Green", "Cyan", "Capri", "Ultramarine", "Violet", "Purple", "Magenta", "Rose", "Dark Gray", "Light Gray", "White"};

    public C_ao() {
        super(36, 143, C_c.k);
        this.hasStates = true;
    }

    @Override
    public int a(int n, int n2) {
        if (n2 < 0) {
            return 143;
        }
        return this.as - n2;
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 15;
    }

    public static int getClothColor(int n) {
        return ~n & 0xF;
    }

    @Override
    public String getBlockName(int n) {
        if (n < 0) {
            return "White Cloth";
        }
        return NAME_LIST[C_ao.getClothColor(n)] + " Cloth";
    }
}

