/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import java.util.Random;
import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.C_ae;
import net.minecraft.a.a.d.C_c;

public class C_bo
extends C_ae {
    private static String[] NAME_LIST = new String[]{"Red", "Orange", "Yellow", "Chartreuse", "Green", "Spring Green", "Cyan", "Capri", "Ultramarine", "Violet", "Purple", "Magenta", "Rose", "Dark Gray", "Light Gray", "White"};

    protected C_bo(int n, int n2, C_c c_c, boolean bl) {
        super(n, n2, c_c, bl);
        this.hasStates = true;
    }

    @Override
    public final int a(Random random) {
        return 0;
    }

    @Override
    public int f() {
        return 1;
    }

    @Override
    public int a(int n, int n2) {
        return this.as - n2;
    }

    @Override
    public int a(C_g c_g, int n, int n2, int n3, int n4) {
        return this.a(n4, c_g.e(n, n2, n3));
    }

    @Override
    protected int damageDropped(int n) {
        return n;
    }

    @Override
    public int getMaxDamage() {
        return 15;
    }

    public static int getGlassColor(int n) {
        return ~n & 0xF;
    }

    @Override
    public String getBlockName(int n) {
        return NAME_LIST[C_bo.getGlassColor(n)] + " Glass";
    }
}

