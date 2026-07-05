/*
 * One active potion effect on the player (Indev++ port of ReIndev's cauldron
 * potions). Just data: which effect, how many ticks left, and potency level.
 * The behaviour lives in PotionManager, which is ticked from the game loop.
 */
package net.minecraft.potion;

public class PotionEffect {
    public final int id;
    public int duration; // ticks remaining
    public final int level; // 1 = normal, 2 = enhanced ...

    public PotionEffect(int id, int duration, int level) {
        this.id = id;
        this.duration = duration;
        this.level = level < 1 ? 1 : level;
    }
}
