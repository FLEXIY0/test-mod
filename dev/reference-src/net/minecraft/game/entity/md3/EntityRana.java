/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.game.entity.md3;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.a.C_e;
import net.minecraft.a.c.e.EntityPlayer;

public class EntityRana
extends C_e {
    public EntityRana(World c_g) {
        super(c_g);
    }

    public EntityRana(World c_g, float f, float f2, float f3) {
        super(c_g);
        this.W = 20;
        this.b(f, f2, f3);
    }

    @Override
    protected Entity b() {
        return null;
    }

    @Override
    public final boolean attackEntityFrom(Entity c_b, int n, float f) {
        return super.attackEntityFrom(c_b, n -= this.getArmorValue() / 4, f);
    }

    @Override
    protected int itemDropped() {
        return Block.plantRed.at;
    }

    @Override
    protected void dropFewItems(Entity c_b) {
        int n = this.itemDropped();
        if (n > 0) {
            ItemStack itemStack;
            ItemStack itemStack2;
            int n2;
            ItemStack itemStack3;
            int n3 = this.G.nextInt(3);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack3 = ((EntityPlayer)c_b).b.d()) != null && (itemStack3.a() == Item.C || itemStack3.a() == Item.battleAxeGold || itemStack3.a() == Item.spearGold)) {
                ++n3;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                this.a(n, 1);
            }
            n2 = this.G.nextInt(10);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack2 = ((EntityPlayer)c_b).b.d()) != null && (itemStack2.a() == Item.C || itemStack2.a() == Item.battleAxeGold || itemStack2.a() == Item.spearGold)) {
                n2 = this.G.nextInt(3);
            }
            if (n2 == 0) {
                this.a(Item.apple.ap, 1, 0.0f);
            }
            int n4 = this.G.nextInt(25);
            if (c_b != null && c_b instanceof EntityPlayer && (itemStack = ((EntityPlayer)c_b).b.d()) != null && (itemStack.a() == Item.C || itemStack.a() == Item.battleAxeGold || itemStack.a() == Item.spearGold)) {
                n4 = this.G.nextInt(10);
            }
            if (n4 == 0) {
                this.a(Item.tear.ap, 1, 0.0f);
            }
        }
    }

    @Override
    public String a() {
        return "Rana";
    }

    @Override
    public int statId() {
        return 11;
    }

    @Override
    public int c() {
        return 120;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
}

