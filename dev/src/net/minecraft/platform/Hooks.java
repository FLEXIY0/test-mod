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

    /** Fired when the player melee-attacks an entity (damage already computed). */
    public interface AttackListener {
        void onAttack(EntityPlayer player, net.minecraft.a.c.Entity target, int damage);
    }

    /** Fired when a block is broken by the player in survival (before removal). */
    public interface BlockBreakListener {
        void onBlockBreak(net.minecraft.a.a.World world, int x, int y, int z, int blockId);
    }

    private static final List<TickListener> tickListeners = new ArrayList<TickListener>();
    private static final List<AttackListener> attackListeners = new ArrayList<AttackListener>();
    private static final List<BlockBreakListener> breakListeners = new ArrayList<BlockBreakListener>();
    private static boolean initialized = false;

    private Hooks() {}

    public static void onTick(TickListener listener) {
        if (listener != null) tickListeners.add(listener);
    }

    public static void onAttack(AttackListener listener) {
        if (listener != null) attackListeners.add(listener);
    }

    public static void onBlockBreak(BlockBreakListener listener) {
        if (listener != null) breakListeners.add(listener);
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

    /** Called from EntityPlayer.attackTargetEntityWithCurrentItem. */
    public static void fireAttack(EntityPlayer player, net.minecraft.a.c.Entity target, int damage) {
        for (int i = 0; i < attackListeners.size(); i++) {
            try {
                attackListeners.get(i).onAttack(player, target, damage);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    /** Called from the survival game-mode controller before a block is removed. */
    public static void fireBlockBreak(net.minecraft.a.a.World world, int x, int y, int z, int blockId) {
        for (int i = 0; i < breakListeners.size(); i++) {
            try {
                breakListeners.get(i).onBlockBreak(world, x, y, z, blockId);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    /** Test/tooling helpers. */
    public static int listenerCount() { return tickListeners.size(); }
    public static int attackListenerCount() { return attackListeners.size(); }
    public static int breakListenerCount() { return breakListeners.size(); }
}
