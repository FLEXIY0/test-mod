/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.d;

import net.minecraft.a.a.d.C_a;
import net.minecraft.a.a.d.C_b;
import net.minecraft.a.a.d.C_d;
import net.minecraft.a.a.d.C_e;

public class Material {
    public static final Material a = new C_d();
    public static final Material b = new Material();
    public static final Material c = new Material();
    public static final Material d = new Material();
    public static final Material e = new Material();
    public static final Material f = new C_b().setNoPushMobility();
    public static final Material g = new C_b().setNoPushMobility();
    public static final Material h = new Material();
    public static final Material i = new C_a().setNoPushMobility();
    public static final Material j = new Material();
    public static final Material k = new Material();
    public static final Material l = new C_d().setNoPushMobility();
    public static final Material m = new Material();
    public static final Material n = new C_a().setNoPushMobility();
    public static final Material o = new C_e();
    public static final Material p = new Material();
    public static final Material cake = new Material();
    public static final Material rope = new Material();
    public static final Material web = new Material().setNoPushMobility();
    public static final Material solid = new Material();
    public static final Material pumpkin = new Material().setNoPushMobility();
    public static final Material snow = new Material().setNoPushMobility();
    public static final Material cactus = new Material().setNoPushMobility();
    public static final Material slime = new Material();
    public static final Material ice = new Material().setImmovableMobility();
    public static final Material quicksand = new Material();
    public static final Material magma = new Material();
    public static final Material ash = new Material().setNoPushMobility();
    public static final Material cloud = new Material();
    public static final Material pulley = new Material().setImmovableMobility();
    public static final Material vacuum = new Material();
    public static final Material bone = new Material();
    public static final Material portal = new Material().setImmovableMobility();
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

    protected Material setNoPushMobility() {
        this.mobilityFlag = 1;
        return this;
    }

    protected Material setImmovableMobility() {
        this.mobilityFlag = 2;
        return this;
    }
}

