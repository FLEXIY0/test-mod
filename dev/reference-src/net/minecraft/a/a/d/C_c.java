/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.d;

import net.minecraft.a.a.d.C_a;
import net.minecraft.a.a.d.C_b;
import net.minecraft.a.a.d.C_d;
import net.minecraft.a.a.d.C_e;

public class C_c {
    public static final C_c a = new C_d();
    public static final C_c b = new C_c();
    public static final C_c c = new C_c();
    public static final C_c d = new C_c();
    public static final C_c e = new C_c();
    public static final C_c f = new C_b().setNoPushMobility();
    public static final C_c g = new C_b().setNoPushMobility();
    public static final C_c h = new C_c();
    public static final C_c i = new C_a().setNoPushMobility();
    public static final C_c j = new C_c();
    public static final C_c k = new C_c();
    public static final C_c l = new C_d().setNoPushMobility();
    public static final C_c m = new C_c();
    public static final C_c n = new C_a().setNoPushMobility();
    public static final C_c o = new C_e();
    public static final C_c p = new C_c();
    public static final C_c cake = new C_c();
    public static final C_c rope = new C_c();
    public static final C_c web = new C_c().setNoPushMobility();
    public static final C_c solid = new C_c();
    public static final C_c pumpkin = new C_c().setNoPushMobility();
    public static final C_c snow = new C_c().setNoPushMobility();
    public static final C_c cactus = new C_c().setNoPushMobility();
    public static final C_c slime = new C_c();
    public static final C_c ice = new C_c().setImmovableMobility();
    public static final C_c quicksand = new C_c();
    public static final C_c magma = new C_c();
    public static final C_c ash = new C_c().setNoPushMobility();
    public static final C_c cloud = new C_c();
    public static final C_c pulley = new C_c().setImmovableMobility();
    public static final C_c vacuum = new C_c();
    public static final C_c bone = new C_c();
    public static final C_c portal = new C_c().setImmovableMobility();
    private int mobilityFlag;

    public boolean d() {
        return false;
    }

    public final boolean e() {
        return !this.d() && !this.a();
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public int getMaterialMobility() {
        return this.mobilityFlag;
    }

    protected C_c setNoPushMobility() {
        this.mobilityFlag = 1;
        return this;
    }

    protected C_c setImmovableMobility() {
        this.mobilityFlag = 2;
        return this;
    }
}

