/*
 * Minimal status-effect engine for Indev++ (blueprint: ReIndev's Potion/Effects,
 * rebuilt against the older API). The fork's EntityPlayer isn't recompilable and
 * has no effect system, so effects are held here and applied every game tick by
 * poking the player's public fields (health via addHealth, fire counter J, motion
 * k/l/m, nightVision). Single-player: one active list, rebound when the player
 * instance changes (new world). PotionManager.tick(player) is called from d.java.
 */
package net.minecraft.potion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.a.c.e.EntityPlayer;

public final class PotionManager {
    // effect ids (also the metadata of the matching potion item)
    public static final int HEAL = 0;          // instant health
    public static final int REGEN = 1;         // health over time
    public static final int SPEED = 2;         // faster movement
    public static final int JUMP = 3;          // higher jump
    public static final int FIRE_RESIST = 4;   // never burns
    public static final int NIGHT_VISION = 5;  // see in the dark
    public static final int STRENGTH = 6;      // reserved (needs combat hook)
    public static final int COUNT = 7;

    /** ARGB tint used for the potion contents icon per effect. */
    public static final int[] COLOR = {
        0xFFF82423, // heal   - red
        0xFFEE4FF0, // regen  - magenta
        0xFF7CAFC6, // speed  - cyan
        0xFF22FF4C, // jump   - green
        0xFFE07A1C, // fire   - orange
        0xFF1F4FE0, // night  - blue
        0xFF932423, // strength - dark red
    };

    public static final String[] NAME = {
        "Healing", "Regeneration", "Swiftness", "Leaping", "Fire Resistance", "Night Vision", "Strength"
    };

    private static final List<PotionEffect> active = new ArrayList<PotionEffect>();
    private static Object boundPlayer;

    private PotionManager() {}

    public static List<PotionEffect> getActive() { return active; }

    public static boolean has(int id) {
        for (PotionEffect e : active) if (e.id == id && e.duration > 0) return true;
        return false;
    }

    public static void clear() { active.clear(); }

    /** Drink a potion of the given effect id: applies it with a sensible duration. */
    public static void drink(EntityPlayer player, int id) {
        switch (id) {
            case HEAL:         apply(player, HEAL, 0, 2);            break; // instant +8
            case REGEN:        apply(player, REGEN, 300, 1);        break; // 15s
            case SPEED:        apply(player, SPEED, 600, 1);        break; // 30s
            case JUMP:         apply(player, JUMP, 600, 1);         break; // 30s
            case FIRE_RESIST:  apply(player, FIRE_RESIST, 900, 1);  break; // 45s
            case NIGHT_VISION: apply(player, NIGHT_VISION, 1200, 1); break; // 60s
            default: break;
        }
    }

    /** Add an effect. Instant effects (HEAL) are applied immediately and not stored. */
    public static void apply(EntityPlayer player, int id, int duration, int level) {
        if (player == null) return;
        if (id == HEAL) {
            player.addHealth(4 * level);
            return;
        }
        for (PotionEffect e : active) {
            if (e.id == id) { // refresh: keep the longer duration
                if (duration > e.duration) e.duration = duration;
                return;
            }
        }
        active.add(new PotionEffect(id, duration, level));
    }

    /** Called once per game tick with the local player. */
    public static void tick(EntityPlayer player) {
        if (player == null) { active.clear(); boundPlayer = null; return; }
        if (boundPlayer != player) { active.clear(); boundPlayer = player; } // new world/player
        if (active.isEmpty()) return;

        boolean nightVision = false;
        Iterator<PotionEffect> it = active.iterator();
        while (it.hasNext()) {
            PotionEffect e = it.next();
            switch (e.id) {
                case REGEN:
                    if (e.duration % Math.max(6, 50 / e.level) == 0) player.addHealth(1);
                    break;
                case SPEED: {
                    float m = 1.0f + 0.18f * e.level;
                    player.k *= m; player.m *= m;
                    break;
                }
                case JUMP:
                    // catch the launch tick (initial jump velocity ~0.42) and add lift
                    if (player.l > 0.40f && player.l < 0.44f) player.l += 0.12f * e.level;
                    break;
                case FIRE_RESIST:
                    player.J = 0;
                    break;
                case NIGHT_VISION:
                    nightVision = true;
                    break;
                default:
                    break;
            }
            if (--e.duration <= 0) it.remove();
        }
        // drive the engine's own night-vision flag from our effect
        player.nightVision = nightVision;
        if (nightVision) player.nightVisionTimer = 200;
    }
}
