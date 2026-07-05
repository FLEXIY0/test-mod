/*
 * Cauldron block (Indev++ port of ReIndev's BlockCauldron). A full cube with
 * cauldron textures whose top changes with the fluid metadata (0 empty / 1
 * water). Right-click delegates to TileEntityCauldron (fill / brew / bottle).
 * Extends BlockContainer so the tile entity is attached on placement.
 *
 * Texture indices (spliced atlas): as = side; TOP_EMPTY/TOP_WATER top; BOTTOM.
 */
package net.minecraft.game.level.block.machines;

import net.minecraft.a.a.C_g;
import net.minecraft.a.a.b.a.C_a;
import net.minecraft.a.a.b.a.TileEntityCauldron;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockCauldron extends BlockContainer {
    private final int topEmpty, topWater, bottom;

    public BlockCauldron(int id, int side, int topEmpty, int topWater, int bottom) {
        super(id, net.minecraft.a.a.d.C_c.d);
        this.as = side;
        this.topEmpty = topEmpty;
        this.topWater = topWater;
        this.bottom = bottom;
    }

    @Override
    public C_a getBlockEntity() {
        return new TileEntityCauldron();
    }

    @Override
    public int a(int side, int meta) {
        if (side == 1) return meta == 1 ? this.topWater : this.topEmpty; // top
        if (side == 0) return this.bottom;                               // bottom
        return this.as;                                                  // sides
    }

    @Override
    public boolean a(C_g world, int x, int y, int z, EntityPlayer player) {
        C_a te = world.j(x, y, z);
        if (!(te instanceof TileEntityCauldron)) return false;
        ItemStack held = player.b.d();
        return ((TileEntityCauldron) te).itemUsed(player, held);
    }
}
