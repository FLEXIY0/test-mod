/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.c.EntityItem;
import net.minecraft.a.c.e.EntityPlayer;

public class C_j
extends Item {
    private static final int[][] damageReduceAmountArray = new int[][]{{1, 3, 2, 1}, {2, 5, 4, 1}, {2, 4, 3, 1}, {2, 6, 5, 2}, {3, 6, 5, 3}, {4, 8, 6, 3}};
    private static final int[] aw = new int[]{11, 16, 15, 13};
    public final int as;
    public final int at;
    public final int au;

    public C_j(int n, int n2, int n3, int n4) {
        super(n);
        this.as = n4;
        this.au = n3;
        this.at = damageReduceAmountArray[n2][n4];
        this.ar = n2 < 2 ? aw[n4] * 3 << n2 + 1 : aw[n4] * 4 << n2 - 1;
        this.aq = 1;
        this.isToolItem = true;
        this.desc[0] = this.at + " defense";
        this.desc[1] = this.ar + " durability";
    }

    @Override
    public final ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        ItemStack itemStack2 = itemStack.copy();
        entityPlayer.b.a[entityPlayer.b.c] = entityPlayer.b.b[3 - this.as];
        entityPlayer.b.b[3 - this.as] = itemStack2;
        c_g.a(entityPlayer, "random.bundle", 1.0f, a.nextFloat() * 0.4f + 0.8f);
        return itemStack;
    }

    @Override
    public boolean throwInFire(World c_g, float f, float f2, float f3) {
        if (this.au == 6) {
            int n = 0;
            if (this.ap == Item.bootsStudded.ap) {
                n = Item.Y.ap;
            }
            if (this.ap == Item.legsStudded.ap) {
                n = Item.X.ap;
            }
            if (this.ap == Item.plateStudded.ap) {
                n = Item.W.ap;
            }
            if (this.ap == Item.helmetStudded.ap) {
                n = Item.V.ap;
            }
            for (int i = 0; i <= 0; ++i) {
                if (!(c_g.q.nextFloat() <= 1.0f)) continue;
                float f4 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f5 = c_g.q.nextFloat() * 0.7f + 0.15f;
                float f6 = c_g.q.nextFloat() * 0.7f + 0.15f;
                EntityItem c_b = new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n));
                new EntityItem(c_g, f + f4, f2 + f5, f3 + f6, new ItemStack(n)).O = 10;
                c_g.spawnEntityInWorld(c_b);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isDamagable() {
        return true;
    }
}

