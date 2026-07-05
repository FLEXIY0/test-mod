package net.minecraft.a.a.b.a;

import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.a.a.b.C_x;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemPotion;
import net.minecraft.game.level.block.machines.BlockCauldron;
import net.minecraft.potion.PotionManager;

/**
 * Headless checks for the ReIndev cauldron/potion port: cauldron block +
 * per-face textures, potion/bottle item registration + per-effect icons, the
 * water brewing recipe table, and the tile-entity mapping. Effect application
 * itself pokes live player fields, so it's exercised in-game, not here.
 */
public class CauldronTest {
    static int pass = 0, fail = 0;
    static void ok(boolean c, String m) { if (c) pass++; else { fail++; System.out.println("FAIL: " + m); } }

    public static void main(String[] a) throws Exception {
        Class.forName("net.minecraft.a.a.b.C_x"); // register blocks + auto item-blocks
        Class.forName("net.minecraft.a.b.Item");  // register items

        // 1. cauldron block + per-face textures (side / top-empty / top-water / bottom)
        C_x cauldron = C_x.c[201];
        ok(cauldron instanceof BlockCauldron, "block 201 is BlockCauldron");
        ok(cauldron.a(2, 0) == 967, "cauldron side = 967 (got " + cauldron.a(2, 0) + ")");
        ok(cauldron.a(1, 0) == 968, "cauldron top empty = 968");
        ok(cauldron.a(1, 1) == 969, "cauldron top water = 969");
        ok(cauldron.a(0, 0) == 970, "cauldron bottom = 970");
        ok(Item.b[201] != null, "cauldron has an auto item (placeable)");

        // 2. potion + bottle items
        ok(Item.potion instanceof ItemPotion, "Item.potion is ItemPotion");
        ok(Item.b[190 + 256] == Item.potion, "potion registered at id 190");
        ok(Item.b[191 + 256] == Item.potionBottle, "bottle registered at id 191");
        ok(Item.potion.getIconFromDamage(0) == 960, "potion icon base 960");
        ok(Item.potion.getIconFromDamage(3) == 963, "potion icon for effect 3 = 963");
        ok(Item.potion.getIconFromDamage(6) == 966, "potion icon for effect 6 = 966");
        ok(Item.potion.getIconFromDamage(99) == 960, "potion icon clamps bad meta");

        // 3. water brewing recipe table (ingredient -> effect)
        ok(TileEntityCauldron.ingredientToEffect(Item.gapple.ap) == PotionManager.HEAL, "golden apple -> heal");
        ok(TileEntityCauldron.ingredientToEffect(Item.apple.ap) == PotionManager.REGEN, "apple -> regen");
        ok(TileEntityCauldron.ingredientToEffect(Item.H.ap) == PotionManager.SPEED, "feather -> speed");
        ok(TileEntityCauldron.ingredientToEffect(Item.slimeBall.ap) == PotionManager.JUMP, "slimeball -> jump");
        ok(TileEntityCauldron.ingredientToEffect(Item.i.ap) == PotionManager.FIRE_RESIST, "coal -> fire resist");
        ok(TileEntityCauldron.ingredientToEffect(C_x.glowStone.at) == PotionManager.NIGHT_VISION, "glowstone -> night vision");
        ok(TileEntityCauldron.ingredientToEffect(Item.k.ap) == -1, "iron ingot brews nothing");

        // 4. tile entity registered for save/load
        Field nm = Class.forName("net.minecraft.a.a.C_o").getDeclaredField("nameToClassMap");
        nm.setAccessible(true);
        Map<?, ?> map = (Map<?, ?>) nm.get(null);
        ok(map.get("Cauldron") == TileEntityCauldron.class, "tile entity 'Cauldron' mapped");

        // 5. effect metadata tables are complete
        ok(PotionManager.COLOR.length == PotionManager.COUNT, "a colour per effect");
        ok(PotionManager.NAME.length == PotionManager.COUNT, "a name per effect");

        System.out.println("CauldronTest: " + pass + " passed, " + fail + " failed");
        if (fail > 0) System.exit(1);
    }
}
