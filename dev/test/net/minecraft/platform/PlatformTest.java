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

        System.out.println("PlatformTest: " + pass + " passed, " + fail + " failed");
        if (fail > 0) System.exit(1);
    }
}
