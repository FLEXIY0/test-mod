/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.dx;

import net.minecraft.a.a.C_b;
import net.minecraft.a.a.World;
import net.minecraft.a.b.C_bm;
import net.minecraft.a.b.C_t;
import net.minecraft.a.b.Item;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.c.GuiScreen;
import net.minecraft.client.c.a.C_m;
import net.minecraft.client.d;
import net.minecraft.client.dx.C_a;

public final class C_c
extends C_a {
    private C_b c;

    public C_c(d d2) {
        super(d2);
    }

    @Override
    public void clickBlock(int n, int n2, int n3, int n4) {
        Item item;
        if (this.a.f.b.d() != null && (item = this.a.f.b.d().a()) != null && (item instanceof net.minecraft.a.b.C_c || item instanceof C_t || item instanceof C_bm)) {
            return;
        }
        this.sendBlockRemoved(n, n2, n3, n4);
    }

    @Override
    public final void a(EntityPlayer entityPlayer) {
    }

    @Override
    public GuiScreen displayInventory() {
        return new C_m(this.a.f);
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final void a(World c_g) {
        super.a(c_g);
        c_g.z = false;
        this.c = new C_b(c_g);
    }

    @Override
    public final float b() {
        return 5.0f;
    }

    @Override
    public final void c() {
        this.c.a();
    }
}

