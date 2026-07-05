/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.C_c;
import net.minecraft.a.d.C_b;

public class C_am
extends Block {
    private static String[] NAME_LIST = new String[]{"Red", "Orange", "Yellow", "Chartreuse", "Green", "Spring Green", "Cyan", "Capri", "Ultramarine", "Violet", "Purple", "Magenta", "Rose", "Dark Gray", "Light Gray", "White"};

    public C_am() {
        super(74, 143, C_c.k);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.06f, 1.0f);
        this.hasStates = true;
    }

    @Override
    public boolean a(World c_g, int n, int n2, int n3) {
        return c_g.a(n, n2 - 1, n3) == Block.B.at ? true : (c_g.a(n, n2 - 1, n3) == Block.detector.at ? true : (c_g.a(n, n2 - 1, n3) == Block.stairUpsideDown.at ? true : (c_g.f(n, n2, n3) == C_c.f ? false : (!c_g.b(n, n2 - 1, n3) ? false : (c_g.a(n, n2 - 1, n3) == this.at ? false : super.a(c_g, n, n2, n3))))));
    }

    @Override
    public void b(World c_g, int n, int n2, int n3, int n4) {
        if (!c_g.f(n, n2 - 1, n3).a()) {
            this.f(c_g, n, n2, n3, c_g.e(n, n2, n3));
            c_g.b(n, n2, n3, 0);
        }
        super.b(c_g, n, n2, n3, n4);
    }

    @Override
    public boolean canBlockStay(World c_g, int n, int n2, int n3) {
        return !c_g.f(n, n2 - 1, n3).a();
    }

    @Override
    public C_b getCollisionBoundingBoxFromPool(World c_g, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int a() {
        return 17;
    }

    @Override
    public boolean isOpaqueCube(int n) {
        return false;
    }

    @Override
    public final boolean c() {
        return false;
    }

    @Override
    public int a(int n, int n2) {
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
        return NAME_LIST[C_am.getClothColor(n)] + " Carpet";
    }
}

