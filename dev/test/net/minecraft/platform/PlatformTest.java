package net.minecraft.platform;

import net.minecraft.a.c.e.EntityPlayer;

/**
 * Headless checks for the platform event bus: listeners fire, a throwing
 * listener doesn't kill the tick, and the first tick lazily boots Platform.init
 * (which registers the potion system) so features are wired without editing the
 * game loop.
 */
public class PlatformTest {
    static int pass = 0, fail = 0;
    static void ok(boolean c, String m) { if (c) pass++; else { fail++; System.out.println("FAIL: " + m); } }

    static int calls = 0;

    public static void main(String[] a) throws Exception {
        ok(Hooks.listenerCount() == 0, "no listeners before boot");

        // a normal listener + a rogue one that throws
        Hooks.onTick(new Hooks.TickListener() {
            public void onTick(EntityPlayer p) { calls++; }
        });
        Hooks.onTick(new Hooks.TickListener() {
            public void onTick(EntityPlayer p) { throw new RuntimeException("boom"); }
        });

        int before = Hooks.listenerCount();
        Hooks.fireTick(null); // null player is valid between worlds
        ok(calls == 1, "listener fired once (got " + calls + ")");
        ok(Hooks.listenerCount() > before, "first tick lazily booted Platform.init (registered more listeners)");

        Hooks.fireTick(null);
        ok(calls == 2, "listener fires each tick despite a throwing sibling");

        // ---- attack event (fired from the unlocked EntityPlayer's attack path) ----
        final int[] atk = {0, -1};
        Hooks.onAttack(new Hooks.AttackListener() {
            public void onAttack(EntityPlayer p, net.minecraft.a.c.Entity t, int dmg) {
                atk[0]++; atk[1] = dmg;
            }
        });
        Hooks.fireAttack(null, null, 7);
        ok(atk[0] == 1, "attack listener fired");
        ok(atk[1] == 7, "attack listener saw the damage value");

        // ---- block-break event (fired from the survival controller) ----
        final int[] brk = {0, -1};
        Hooks.onBlockBreak(new Hooks.BlockBreakListener() {
            public void onBlockBreak(net.minecraft.a.a.World w, int x, int y, int z, int id) {
                brk[0]++; brk[1] = id;
            }
        });
        Hooks.fireBlockBreak(null, 1, 2, 3, 49);
        ok(brk[0] == 1, "block-break listener fired");
        ok(brk[1] == 49, "block-break listener saw the block id");

        // ---- ModRegistry: recipes go through the public facade ----
        // Init Block first (the game's natural order) so StatList doesn't touch a
        // half-initialized CraftingManager singleton.
        Class.forName("net.minecraft.a.a.b.Block");
        int recipesBefore = recipeCount();
        ModRegistry.addShapelessRecipe(
                new net.minecraft.a.b.ItemStack(net.minecraft.a.b.Item.z, 2),
                net.minecraft.a.b.Item.z);
        ok(recipeCount() == recipesBefore + 1, "ModRegistry.addShapelessRecipe registered a recipe");
        ModRegistry.addShapedRecipe(
                new net.minecraft.a.b.ItemStack(net.minecraft.a.b.Item.A, 1),
                "#", '#', net.minecraft.a.b.Item.z);
        ok(recipeCount() == recipesBefore + 2, "ModRegistry.addShapedRecipe registered a recipe");

        System.out.println("PlatformTest: " + pass + " passed, " + fail + " failed");
        if (fail > 0) System.exit(1);
    }

    static int recipeCount() throws Exception {
        java.lang.reflect.Field f = net.minecraft.a.b.a.CraftingManager.class.getDeclaredField("b");
        f.setAccessible(true);
        return ((java.util.List<?>) f.get(net.minecraft.a.b.a.CraftingManager.a())).size();
    }
}
