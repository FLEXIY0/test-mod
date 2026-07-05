/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b.a;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;

public class C_j {
    private static final C_j smeltingBase = new C_j();
    private Map<Integer, ItemStack> smeltingList = new HashMap<Integer, ItemStack>();

    public static final C_j smelting() {
        return smeltingBase;
    }

    private C_j() {
        this.addSmelting(Block.w.at, new ItemStack(Item.k));
        this.addSmelting(Block.v.at, new ItemStack(Item.l));
        this.addSmelting(Block.al.at, new ItemStack(Item.j));
        this.addSmelting(Block.oreEmerald.at, new ItemStack(Item.emerald));
        this.addSmelting(Block.oreAdminium.at, new ItemStack(Item.ingotAdminium));
        this.addSmelting(Block.x.at, new ItemStack(Item.i, 1, 0));
        this.addSmelting(Item.rawIron.ap, new ItemStack(Item.k));
        this.addSmelting(Item.rawGold.ap, new ItemStack(Item.l));
        this.addSmelting(Item.rawAdminium.ap, new ItemStack(Item.ingotAdminium));
        this.addSmelting(Block.t.at, new ItemStack(Block.B));
        this.addSmelting(Block.redSand.at, new ItemStack(Block.B));
        this.addSmelting(Item.am.ap, new ItemStack(Item.an));
        this.addSmelting(Item.fishRaw.ap, new ItemStack(Item.fishCooked));
        this.addSmelting(Block.l.at, new ItemStack(Block.i));
        this.addSmelting(Block.y.at, new ItemStack(Item.i, 1, 1));
        this.addSmelting(Block.log.at, new ItemStack(Item.i, 1, 1));
        this.addSmelting(Item.clay.ap, new ItemStack(Item.bricks));
        this.addSmelting(Item.antlionTusk.ap, new ItemStack(Item.antlionExtract));
        this.addSmelting(Block.coral.at, new ItemStack(Block.A));
    }

    public void addSmelting(int n, ItemStack itemStack) {
        this.smeltingList.put(n, itemStack);
    }

    public ItemStack getSmeltingResult(int n) {
        return this.smeltingList.get(n);
    }

    public Map<Integer, ItemStack> getSmeltingList() {
        return this.smeltingList;
    }
}

