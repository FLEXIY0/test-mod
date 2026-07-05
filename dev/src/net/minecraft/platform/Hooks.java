/*
 * Indev++ platform: a tiny event bus so features plug into the engine instead
 * of being surgically spliced into obfuscated classes. The engine fires generic
 * events (currently a per-tick event); features register listeners in
 * Platform.init(). This is the first primitive of the "engine -> platform" arc.
 */
package net.minecraft.platform;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.a.c.e.EntityPlayer;

public final class Hooks {
    /** Fired once per game tick with the local player (may be null between worlds). */
    public interface TickListener {
        void onTick(EntityPlayer player);
    }

    private static final List<TickListener> tickListeners = new ArrayList<TickListener>();
    private static boolean initialized = false;

    private Hooks() {}

    public static void onTick(TickListener listener) {
        if (listener != null) tickListeners.add(listener);
    }

    /** Called from the game loop (d.java). Lazily boots the platform on first use. */
    public static void fireTick(EntityPlayer player) {
        if (!initialized) {
            initialized = true;
            Platform.init();
        }
        for (int i = 0; i < tickListeners.size(); i++) {
            try {
                tickListeners.get(i).onTick(player);
            } catch (Throwable t) {
                t.printStackTrace(); // one bad listener must not kill the tick loop
            }
        }
    }

    /** Test/tooling helper. */
    public static int listenerCount() { return tickListeners.size(); }
}
