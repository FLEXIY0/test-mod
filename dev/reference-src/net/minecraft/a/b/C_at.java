/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.d.Material;
import net.minecraft.a.b.C_d;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.a.d.C_a;
import util.MathHelper;

public final class C_at
extends C_d {
    public C_at(int n) {
        super(n);
        this.aq = 64;
        this.ar = 64;
    }

    @Override
    public final ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        int n;
        int n2;
        int n3;
        float f = entityPlayer.q + (entityPlayer.o - entityPlayer.q);
        float f2 = entityPlayer.p + (entityPlayer.n - entityPlayer.p);
        float f3 = entityPlayer.e + (entityPlayer.h - entityPlayer.e);
        float f4 = entityPlayer.f + (entityPlayer.i - entityPlayer.f);
        float f5 = entityPlayer.g + (entityPlayer.j - entityPlayer.g);
        C_a c_a = new C_a(f3, f4, f5);
        float f6 = MathHelper.b(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        f2 = MathHelper.a(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f7 = -MathHelper.b(-f * ((float)Math.PI / 180));
        C_a c_a2 = c_a.a((f2 *= f7) * 5.0f, (f = MathHelper.a(-f * ((float)Math.PI / 180))) * 5.0f, (f6 *= f7) * 5.0f);
        net.minecraft.a.d.C_c c_c = c_g.rayTraceBlocks_do(c_a, c_a2, true, false);
        if (c_c == null || c_g.multiplayerWorld) {
            return itemStack;
        }
        if (c_c.a == 0 && c_g.f(n3 = c_c.b, n2 = c_c.c, n = c_c.d) == Material.f && c_g.e(n3, n2, n) == 0 && c_c.e == 1) {
            c_g.b(n3, n2 + 1, n, Block.lilyPad.at);
            c_g.a((float)n3, (float)(n2 + 1), (float)n, "step.grass", 1.0f, 0.8f);
            entityPlayer.swingItem();
            if (c_g.gamemode == 0) {
                --itemStack.a;
            }
        }
        return itemStack;
    }
}

