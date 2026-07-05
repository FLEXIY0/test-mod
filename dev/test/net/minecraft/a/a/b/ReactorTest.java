package net.minecraft.a.a.b;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import net.minecraft.a.b.Item;
import net.minecraft.game.level.block.machines.BlockNetherReactorCore;

/**
 * Headless checks for the native Nether Reactor port: block registration,
 * per-phase textures, the gold/cobblestone activation pattern, and the tile
 * entity name mapping. Runs against the built jar (in-package for C_x's
 * protected name field; reflection for the block's private pattern).
 */
public class ReactorTest {
    static int pass = 0, fail = 0;
    static void ok(boolean c, String m) { if (c) pass++; else { fail++; System.out.println("FAIL: " + m); } }

    static String name(C_x b) throws Exception {
        Field f = C_x.class.getDeclaredField("name"); f.setAccessible(true);
        return (String) f.get(b);
    }

    public static void main(String[] a) throws Exception {
        // force C_x static init (registers all blocks + auto item-blocks)
        Class.forName("net.minecraft.a.a.b.C_x");

        // 1. the five new blocks exist at their ids with the spliced textures
        int[] ids = {196, 197, 198, 199, 200};
        int[] tex = {963, 964, 965, 966, 960};
        String[] want = {"Netherrack", "Soul Sand", "Glowstone", "Glowing Obsidian", "Nether Reactor Core"};
        for (int i = 0; i < ids.length; i++) {
            C_x b = C_x.c[ids[i]];
            ok(b != null, "block id " + ids[i] + " registered");
            if (b == null) continue;
            ok(b.as == tex[i], "block " + ids[i] + " texture " + tex[i] + " (got " + b.as + ")");
            ok(name(b).contains(want[i]), "block " + ids[i] + " named ~" + want[i] + " (got '" + name(b) + "')");
            ok(Item.b[ids[i]] != null, "block " + ids[i] + " has an auto item (placeable)");
        }

        // 2. reactor core is the right class and gives per-phase textures
        C_x core = C_x.c[200];
        ok(core instanceof BlockNetherReactorCore, "core is BlockNetherReactorCore");
        ok(core.a(0, 0) == 960, "core phase0 texture 960 (got " + core.a(0, 0) + ")");
        ok(core.a(0, 1) == 961, "core phase1 texture 961 (got " + core.a(0, 1) + ")");
        ok(core.a(0, 2) == 962, "core phase2 texture 962 (got " + core.a(0, 2) + ")");
        ok(core.a(0, 5) == 960, "core clamps bad meta to phase0");

        // 3. the activation pattern (gold corners / cobble frame / core centre)
        Method pat = BlockNetherReactorCore.class.getDeclaredMethod("patternAt", int.class, int.class, int.class);
        pat.setAccessible(true);
        int gold = C_x.W.at, cobble = C_x.l.at, coreId = C_x.netherReactorCore.at;
        // layer 0 (bottom): corners gold, rest cobble
        ok((Integer) pat.invoke(null, 0, 0, 0) == gold, "L0 corner = gold");
        ok((Integer) pat.invoke(null, 0, 1, 1) == cobble, "L0 centre = cobble");
        ok((Integer) pat.invoke(null, 0, 0, 1) == cobble, "L0 edge = cobble");
        // layer 1 (middle): corners cobble, edges air, centre core
        ok((Integer) pat.invoke(null, 1, 1, 1) == coreId, "L1 centre = core");
        ok((Integer) pat.invoke(null, 1, 0, 0) == cobble, "L1 corner = cobble");
        ok((Integer) pat.invoke(null, 1, 0, 1) == 0, "L1 edge = air");
        // layer 2 (top): corners air, rest cobble
        ok((Integer) pat.invoke(null, 2, 0, 0) == 0, "L2 corner = air");
        ok((Integer) pat.invoke(null, 2, 1, 1) == cobble, "L2 centre = cobble");
        ok((Integer) pat.invoke(null, 2, 0, 1) == cobble, "L2 edge = cobble");

        // 4. tile entity is registered for save/load
        Class<?> reg = Class.forName("net.minecraft.a.a.C_o");
        Field nm = reg.getDeclaredField("nameToClassMap"); nm.setAccessible(true);
        Map<?, ?> map = (Map<?, ?>) nm.get(null);
        ok(map.get("NetherReactor") == Class.forName("net.minecraft.a.a.b.a.TileEntityNetherReactor"),
                "tile entity 'NetherReactor' mapped");

        // 5. pigman mob: subclasses the zombie (so the render manager's superclass
        //    fallback reuses the zombie renderer) and is registered in EntityList
        Class<?> pig = Class.forName("net.minecraft.a.c.a.EntityPigZombie");
        ok(pig.getSuperclass() == Class.forName("net.minecraft.a.c.a.C_f"),
                "EntityPigZombie extends zombie (render fallback)");
        Class<?> elist = Class.forName("net.minecraft.a.c.C_f");
        Field s2c = elist.getDeclaredField("stringToClassMapping"); s2c.setAccessible(true);
        Map<?, ?> emap = (Map<?, ?>) s2c.get(null);
        ok(emap.get("PigZombie") == pig, "EntityPigZombie registered in EntityList as 'PigZombie'");

        System.out.println("ReactorTest: " + pass + " passed, " + fail + " failed");
        if (fail > 0) System.exit(1);
    }
}
