/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.dx;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.C_h;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.client.d;
import net.minecraft.client.dx.C_a;
import net.minecraft.client.e.C_c;
import net.minecraft.client.statistics.StatList;
import net.minecraft.game.level.block.furniture.BlockDoor;

public final class C_b
extends C_a {
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private int i = 0;
    private net.minecraft.a.a.C_b j;
    // Tree-feller (TimberZ-style): break the whole tree while sneaking with an axe.
    private boolean felling = false;
    private int felledCount = 0;

    public C_b(d d2) {
        super(d2);
    }

    @Override
    public final boolean sendBlockRemoved(int n, int n2, int n3, int n4) {
        ItemStack itemStack;
        int n5 = this.a.d.a(n, n2, n3);
        byte by = this.a.d.e(n, n2, n3);
        boolean bl = super.sendBlockRemoved(n, n2, n3, n4);
        ItemStack itemStack2 = this.a.f.b.d();
        if (bl && this.a.f.canHarvestBlock(Block.c[n5], by)) {
            if (itemStack2 != null) {
                if (itemStack2.a().isToolSilkTouch()) {
                    if (itemStack2.a().isBlockAffectiveAgainst(Block.c[n5]) && !(Block.c[n5] instanceof BlockDoor)) {
                        Block.c[n5].dropBlockAsItemWithChance(this.a.d, n, n2, n3, by);
                    } else {
                        Block.c[n5].f(this.a.d, n, n2, n3, by);
                    }
                } else if (!itemStack2.a().isToolSilkTouch()) {
                    Block.c[n5].f(this.a.d, n, n2, n3, by);
                    if (itemStack2.a().isBlockAffectiveAgainst(Block.c[n5]) && Block.c[n5].canBeDuped() && itemStack2.a().isLooting() && this.a.d.I.nextInt(3) == 0) {
                        Block.c[n5].f(this.a.d, n, n2, n3, by);
                    }
                }
            } else {
                Block.c[n5].f(this.a.d, n, n2, n3, by);
            }
        }
        if (itemStack2 != null && Block.c[n5].aL > 0.0f) {
            Item.b[itemStack2.c].onBlockDestroyed(this.a.f, itemStack2, this.a.d);
            if (itemStack2.a == 0) {
                this.a.f.h_();
            }
        }
        if ((itemStack = this.a.f.b.charmSlot[0]) != null && itemStack.a() == Item.bracelet && this.a.d.q.nextInt(4) == 0) {
            itemStack.damageItem2(1, this.a.d);
            this.a.f.addStat(StatList.objectUseStats[itemStack.c], 1);
        }
        ItemStack heldNow = this.a.f.b.d();
        if (bl && !this.felling
                && (n5 == Block.y.at || n5 == Block.log.at)
                && this.a.f.isSneaking != 0
                && heldNow != null && heldNow.a() instanceof C_h) {
            this.felling = true;
            this.felledCount = 0;
            this.fellTree(n, n2, n3, n4);
            this.felling = false;
        }
        return bl;
    }

    @Override
    public final void clickBlock(int n, int n2, int n3, int n4) {
        int n5 = this.a.d.a(n, n2, n3);
        if (n5 > 0 && Block.c[n5].blockStrength(this.a.f, this.a.d.e(n, n2, n3)) >= 1.0f) {
            this.sendBlockRemoved(n, n2, n3, n4);
        }
        if (n5 > 0 && this.f == 0.0f) {
            Block.c[n5].onBlockClicked(this.a.d, n, n2, n3, this.a.f);
        }
    }

    @Override
    public final void a() {
        this.f = 0.0f;
        this.i = 0;
    }

    @Override
    public final void a(int n, int n2, int n3, int n4) {
        if (this.i > 0) {
            --this.i;
        } else {
            super.a(n, n2, n3, n4);
            if (n == this.c && n2 == this.d && n3 == this.e) {
                n4 = this.a.d.a(n, n2, n3);
                if (n4 != 0) {
                    Block c_x = Block.c[n4];
                    float f = 1.0f;
                    if (this.a.f.b.charmSlot[0] != null && this.a.f.b.charmSlot[0].a() == Item.bracelet && !this.a.f.isInWater()) {
                        f = 4.0f;
                    }
                    this.f += c_x.blockStrength(this.a.f, this.a.d.e(n, n2, n3)) * f;
                    if (this.h % 4.0f == 0.0f && c_x != null) {
                        C_c c_c = this.a.x;
                        String string = c_x.getStepSound(this.a.d.e(n, n2, n3)).b();
                        float f2 = (float)n + 0.5f;
                        float f3 = (float)n2 + 0.5f;
                        float f4 = (float)n3 + 0.5f;
                        float f5 = (c_x.getStepSound((int)this.a.d.e((int)n, (int)n2, (int)n3)).a + 1.0f) / 8.0f;
                        c_c.playBlockSound(string, f2, f3, f4, f5, c_x.getStepSound((int)this.a.d.e((int)n, (int)n2, (int)n3)).b * 0.5f);
                    }
                    this.h += 1.0f;
                    if (this.f >= 1.0f) {
                        this.sendBlockRemoved(n, n2, n3, n4);
                        this.f = 0.0f;
                        this.g = 0.0f;
                        this.h = 0.0f;
                        this.i = 5;
                    }
                }
            } else {
                this.f = 0.0f;
                this.g = 0.0f;
                this.h = 0.0f;
                this.c = n;
                this.d = n2;
                this.e = n3;
            }
        }
    }

    @Override
    public final void a(float f) {
        this.a.e.a = this.f <= 0.0f ? 0.0f : (f = this.g + (this.f - this.g) * f);
    }

    @Override
    public final float b() {
        return 4.0f;
    }

    @Override
    public final void a(World c_g) {
        super.a(c_g);
        c_g.z = true;
        this.j = new net.minecraft.a.a.C_b(c_g);
    }

    @Override
    public final void c() {
        this.g = this.f;
        this.j.a();
    }

    /**
     * Recursively break every log connected (26-neighbourhood) to the one
     * just felled. Each block goes through sendBlockRemoved, so drops and
     * axe durability are calculated per block. Stops if the axe is gone or
     * a safety cap is reached.
     */
    private void fellTree(int x, int y, int z, int side) {
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                for (int dz = -1; dz <= 1; ++dz) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    if (this.felledCount >= 512) return;
                    int nx = x + dx, ny = y + dy, nz = z + dz;
                    int id = this.a.d.a(nx, ny, nz);
                    if (id != Block.y.at && id != Block.log.at) continue;
                    ItemStack held = this.a.f.b.d();
                    if (held == null || !(held.a() instanceof C_h)) return;
                    ++this.felledCount;
                    this.sendBlockRemoved(nx, ny, nz, side);
                    this.fellTree(nx, ny, nz, side);
                }
            }
        }
    }
}
