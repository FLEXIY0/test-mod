/*
 * Readable facade over the (still obfuscated) World methods. Class names were
 * remapped to Beta names (World, Block, TileEntity), but method names stay
 * obfuscated — so this gives ports and new features legible calls like
 * WorldApi.getBlockId(world, x, y, z) instead of world.a(x, y, z). Pure
 * delegation, zero risk (nothing in the core classes is recompiled).
 */
package net.minecraft.platform;

import net.minecraft.a.a.World;
import net.minecraft.a.a.b.a.TileEntity;

public final class WorldApi {
    private WorldApi() {}

    public static int getBlockId(World w, int x, int y, int z) {
        return w.a(x, y, z);
    }

    /** Set a block id (with the standard neighbour notify). */
    public static boolean setBlock(World w, int x, int y, int z, int id) {
        return w.a(x, y, z, id);
    }

    public static int getBlockMetadata(World w, int x, int y, int z) {
        return w.e(x, y, z);
    }

    public static boolean setBlockMetadata(World w, int x, int y, int z, int meta) {
        return w.d(x, y, z, meta);
    }

    public static boolean setBlockAndMetadata(World w, int x, int y, int z, int id, int meta) {
        return w.setBlockAndMetadataWithNotify(x, y, z, id, meta);
    }

    public static TileEntity getTileEntity(World w, int x, int y, int z) {
        return w.j(x, y, z);
    }

    public static void spawnEntity(World w, net.minecraft.a.c.Entity entity) {
        w.spawnEntityInWorld(entity);
    }

    public static void markForUpdate(World w, int x, int y, int z) {
        w.markBlockNeedsUpdate(x, y, z);
    }
}
