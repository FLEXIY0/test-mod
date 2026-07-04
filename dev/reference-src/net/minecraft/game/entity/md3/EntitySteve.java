/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.entity.md3;

import net.minecraft.a.a.C_g;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.C_b;
import net.minecraft.a.c.a.C_e;

public class EntitySteve
extends C_e {
    public EntitySteve(C_g c_g) {
        super(c_g);
    }

    public EntitySteve(C_g c_g, float f, float f2, float f3) {
        super(c_g);
        this.W = 20;
        this.b(f, f2, f3);
    }

    @Override
    protected C_b b() {
        return null;
    }

    @Override
    protected int itemDropped() {
        return Item.G.ap;
    }

    @Override
    public String a() {
        return "Steve";
    }

    @Override
    public int statId() {
        return 8;
    }

    @Override
    public int c() {
        return 105;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
}

