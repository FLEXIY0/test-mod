/*
 * The Nether Reactor Core block (native Indev++ port of the MCPE mod).
 *
 * Right-click with the 3x3x3 gold/cobblestone pattern built around it (and a
 * bit of head-room) to ignite the reactor; the TileEntityNetherReactor then
 * runs the whole spire/loot/collapse sequence. Extends BlockContainer so a
 * TileEntityNetherReactor is attached on placement, exactly like the furnace.
 *
 * Phase is kept in the block metadata (0 normal, 1 active, 2 spent) and picks
 * the texture (spliced atlas tiles 960/961/962).
 */
package net.minecraft.game.level.block.machines;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.Block;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.a.b.a.TileEntityNetherReactor;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.game.level.block.container.BlockContainer;

public class BlockNetherReactorCore extends BlockContainer {
    public BlockNetherReactorCore(int id, int texture) {
        super(id, net.minecraft.a.a.d.C_c.d);
        this.as = texture;
    }

    @Override
    public TileEntity getBlockEntity() {
        return new TileEntityNetherReactor();
    }

    /** Texture per phase: 0 normal, 1 active, 2 spent -> consecutive atlas tiles. */
    @Override
    public int a(int side, int meta) {
        if (meta < 0 || meta > 2) meta = 0;
        return this.as + meta;
    }

    @Override
    public boolean a(World world, int x, int y, int z, EntityPlayer player) {
        // verify the gold/cobblestone pattern (layer 0 = y-1 .. layer 2 = y+1)
        for (int layer = 0; layer <= 2; ++layer) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    if (world.a(x + j, y + layer - 1, z + k) == patternAt(layer, j + 1, k + 1)) continue;
                    return false; // not the correct pattern
                }
            }
        }
        if (getPhase(world, x, y, z) != 0) return false;   // already active/spent
        if (y > 100 || y < 2) return false;                // build lower / higher
        TileEntity te = world.j(x, y, z);
        if (te instanceof TileEntityNetherReactor) {
            ((TileEntityNetherReactor) te).lightItUp();
            return true;
        }
        return false;
    }

    @Override
    public void b(World world, int x, int y, int z) {
        TileEntity te = world.j(x, y, z);
        if (te instanceof TileEntityNetherReactor && getPhase(world, x, y, z) == 1) {
            ((TileEntityNetherReactor) te).finishReactorRun();
        }
        super.b(world, x, y, z);
    }

    public static void setPhase(World world, int x, int y, int z, int phase) {
        world.d(x, y, z, phase); // set block metadata
    }

    public static int getPhase(World world, int x, int y, int z) {
        return world.e(x, y, z); // get block metadata
    }

    // pattern block ids: gold corners / cobble frame / core centre
    private static int patternAt(int layer, int r, int c) {
        int gold = Block.W.at, cobble = Block.l.at, core = Block.netherReactorCore.at;
        boolean corner = (r != 1) && (c != 1);
        switch (layer) {
            case 0:  return corner ? gold : cobble;
            case 1:  return (r == 1 && c == 1) ? core : (corner ? cobble : 0);
            default: return corner ? 0 : cobble;
        }
    }
}
