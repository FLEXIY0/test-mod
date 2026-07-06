/*
 * Clean registration facade for the Indev++ platform: one readable place to
 * register tile entities, entities and recipes without touching the engine's
 * obfuscated registries directly. Blocks and items still self-register through
 * their constructors (Block.c[] / Item.b[]) — see dev/MODDING.md.
 */
package net.minecraft.platform;

import net.minecraft.a.a.TileEntityRegistry;
import net.minecraft.a.a.b.a.TileEntity;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.b.a.CraftingManager;
import net.minecraft.a.c.Entity;
import net.minecraft.a.c.EntityList;

public final class ModRegistry {
    private ModRegistry() {}

    /** Register a tile entity so it saves/loads with the world ("id" in NBT). */
    public static void registerTileEntity(Class<? extends TileEntity> clazz, String name) {
        TileEntityRegistry.addMapping(clazz, name);
    }

    /** Register an entity so it saves/loads with the world. */
    public static void registerEntity(Class<? extends Entity> clazz, String name, int id) {
        EntityList.addMapping(clazz, name, id);
    }

    /** Shaped recipe, Beta style: addShapedRecipe(result, "##", "##", '#', Item.k). */
    public static void addShapedRecipe(ItemStack result, Object... pattern) {
        CraftingManager.a().addShapedRecipe(result, pattern);
    }

    /** Shapeless recipe: any arrangement of the ingredients. */
    public static void addShapelessRecipe(ItemStack result, Object... ingredients) {
        CraftingManager.a().addShapelessRecipePublic(result, ingredients);
    }
}
