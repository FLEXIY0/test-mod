/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.dx;

import net.minecraft.a.a.C_b;
import net.minecraft.a.a.C_g;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.d;
import net.minecraft.client.dx.C_a;

public final class C_e
extends C_a {
    private C_b mobSpawner;

    public C_e(d d2) {
        super(d2);
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
        entityPlayer.F = true;
        entityPlayer.isFlying = true;
    }

    @Override
    public GuiScreen displayInventory() {
        return null;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final void a(C_g c_g) {
        super.a(c_g);
        c_g.z = false;
        c_g.y.F = true;
        c_g.y.isFlying = true;
        this.mobSpawner = new C_b(c_g);
    }

    @Override
    public final float b() {
        return 5.0f;
    }

    @Override
    public final void c() {
        this.mobSpawner.a();
    }
}

